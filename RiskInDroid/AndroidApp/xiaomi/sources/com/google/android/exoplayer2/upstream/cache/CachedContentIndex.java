package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class CachedContentIndex {
    private final SparseArray<String> idToKey;
    private final HashMap<String, CachedContent> keyToContent;
    private final SparseBooleanArray newIds;
    private Storage previousStorage;
    private final SparseBooleanArray removedIds;
    private Storage storage;

    interface Storage {
        void delete() throws IOException;

        boolean exists() throws IOException;

        void initialize(long j);

        void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException;

        void onRemove(CachedContent cachedContent, boolean z);

        void onUpdate(CachedContent cachedContent);

        void storeFully(HashMap<String, CachedContent> hashMap) throws IOException;

        void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException;
    }

    public static boolean isIndexFile(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    public static void delete(DatabaseProvider databaseProvider, long j) throws DatabaseIOException {
        DatabaseStorage.delete(databaseProvider, j);
    }

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, null, null, false, false);
    }

    public CachedContentIndex(DatabaseProvider databaseProvider, File file, byte[] bArr, boolean z, boolean z2) {
        Assertions.checkState((databaseProvider == null && file == null) ? false : true);
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.removedIds = new SparseBooleanArray();
        this.newIds = new SparseBooleanArray();
        LegacyStorage legacyStorage = null;
        DatabaseStorage databaseStorage = databaseProvider != null ? new DatabaseStorage(databaseProvider) : null;
        legacyStorage = file != null ? new LegacyStorage(new File(file, "cached_content_index.exi"), bArr, z) : legacyStorage;
        if (databaseStorage == null || (legacyStorage != null && z2)) {
            this.storage = legacyStorage;
            this.previousStorage = databaseStorage;
            return;
        }
        this.storage = databaseStorage;
        this.previousStorage = legacyStorage;
    }

    public void initialize(long j) throws IOException {
        Storage storage2;
        this.storage.initialize(j);
        Storage storage3 = this.previousStorage;
        if (storage3 != null) {
            storage3.initialize(j);
        }
        if (this.storage.exists() || (storage2 = this.previousStorage) == null || !storage2.exists()) {
            this.storage.load(this.keyToContent, this.idToKey);
        } else {
            this.previousStorage.load(this.keyToContent, this.idToKey);
            this.storage.storeFully(this.keyToContent);
        }
        Storage storage4 = this.previousStorage;
        if (storage4 != null) {
            storage4.delete();
            this.previousStorage = null;
        }
    }

    public void store() throws IOException {
        this.storage.storeIncremental(this.keyToContent);
        int size = this.removedIds.size();
        for (int i = 0; i < size; i++) {
            this.idToKey.remove(this.removedIds.keyAt(i));
        }
        this.removedIds.clear();
        this.newIds.clear();
    }

    public CachedContent getOrAdd(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        return cachedContent == null ? addNew(str) : cachedContent;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public Collection<CachedContent> getAll() {
        return this.keyToContent.values();
    }

    public int assignIdForKey(String str) {
        return getOrAdd(str).id;
    }

    public String getKeyForId(int i) {
        return this.idToKey.get(i);
    }

    public void maybeRemove(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent != null && cachedContent.isEmpty() && !cachedContent.isLocked()) {
            this.keyToContent.remove(str);
            int i = cachedContent.id;
            boolean z = this.newIds.get(i);
            this.storage.onRemove(cachedContent, z);
            if (z) {
                this.idToKey.remove(i);
                this.newIds.delete(i);
                return;
            }
            this.idToKey.put(i, null);
            this.removedIds.put(i, true);
        }
    }

    public void removeEmpty() {
        String[] strArr = new String[this.keyToContent.size()];
        this.keyToContent.keySet().toArray(strArr);
        for (String maybeRemove : strArr) {
            maybeRemove(maybeRemove);
        }
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent orAdd = getOrAdd(str);
        if (orAdd.applyMetadataMutations(contentMetadataMutations)) {
            this.storage.onUpdate(orAdd);
        }
    }

    public ContentMetadata getContentMetadata(String str) {
        CachedContent cachedContent = get(str);
        return cachedContent != null ? cachedContent.getMetadata() : DefaultContentMetadata.EMPTY;
    }

    private CachedContent addNew(String str) {
        int newId = getNewId(this.idToKey);
        CachedContent cachedContent = new CachedContent(newId, str);
        this.keyToContent.put(str, cachedContent);
        this.idToKey.put(newId, str);
        this.newIds.put(newId, true);
        this.storage.onUpdate(cachedContent);
        return cachedContent;
    }

    @SuppressLint({"GetInstance"})
    public static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    static int getNewId(SparseArray<String> sparseArray) {
        int i;
        int size = sparseArray.size();
        if (size == 0) {
            i = 0;
        } else {
            i = sparseArray.keyAt(size - 1) + 1;
        }
        if (i < 0) {
            int i2 = 0;
            while (i < size && i == sparseArray.keyAt(i)) {
                i2 = i + 1;
            }
        }
        return i;
    }

    public static DefaultContentMetadata readContentMetadata(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < readInt) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                int i2 = min;
                int i3 = 0;
                while (i3 != readInt2) {
                    int i4 = i3 + i2;
                    bArr = Arrays.copyOf(bArr, i4);
                    dataInputStream.readFully(bArr, i3, i2);
                    i2 = Math.min(readInt2 - i4, 10485760);
                    i3 = i4;
                }
                hashMap.put(readUTF, bArr);
                i++;
            } else {
                throw new IOException("Invalid value size: ".concat(String.valueOf(readInt2)));
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    public static void writeContentMetadata(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> entrySet = defaultContentMetadata.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry next : entrySet) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    static class LegacyStorage implements Storage {
        private final AtomicFile atomicFile;
        private ReusableBufferedOutputStream bufferedOutputStream;
        private boolean changed;
        private final Cipher cipher;
        private final boolean encrypt;
        private final SecureRandom random;
        private final SecretKeySpec secretKeySpec;

        public void initialize(long j) {
        }

        public LegacyStorage(File file, byte[] bArr, boolean z) {
            SecretKeySpec secretKeySpec2;
            Cipher cipher2;
            SecureRandom secureRandom = null;
            if (bArr != null) {
                Assertions.checkArgument(bArr.length == 16);
                try {
                    cipher2 = CachedContentIndex.getCipher();
                    secretKeySpec2 = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                Assertions.checkArgument(!z);
                cipher2 = null;
                secretKeySpec2 = null;
            }
            this.encrypt = z;
            this.cipher = cipher2;
            this.secretKeySpec = secretKeySpec2;
            this.random = z ? new SecureRandom() : secureRandom;
            this.atomicFile = new AtomicFile(file);
        }

        public boolean exists() {
            return this.atomicFile.exists();
        }

        public void delete() {
            this.atomicFile.delete();
        }

        public void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            Assertions.checkState(!this.changed);
            if (!readFile(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.atomicFile.delete();
            }
        }

        public void storeFully(HashMap<String, CachedContent> hashMap) throws IOException {
            writeFile(hashMap);
            this.changed = false;
        }

        public void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException {
            if (this.changed) {
                storeFully(hashMap);
            }
        }

        public void onUpdate(CachedContent cachedContent) {
            this.changed = true;
        }

        public void onRemove(CachedContent cachedContent, boolean z) {
            this.changed = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00b4  */
        private boolean readFile(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            DataInputStream dataInputStream;
            if (!this.atomicFile.exists()) {
                return true;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.atomicFile.openRead());
                dataInputStream = new DataInputStream(bufferedInputStream);
                try {
                    int readInt = dataInputStream.readInt();
                    if (readInt >= 0) {
                        if (readInt <= 2) {
                            if ((dataInputStream.readInt() & 1) != 0) {
                                if (this.cipher == null) {
                                    Util.closeQuietly(dataInputStream);
                                    return false;
                                }
                                byte[] bArr = new byte[16];
                                dataInputStream.readFully(bArr);
                                try {
                                    this.cipher.init(2, this.secretKeySpec, new IvParameterSpec(bArr));
                                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.cipher));
                                } catch (InvalidKeyException e) {
                                    e = e;
                                    throw new IllegalStateException(e);
                                } catch (InvalidAlgorithmParameterException e2) {
                                    e = e2;
                                    throw new IllegalStateException(e);
                                }
                            } else if (this.encrypt) {
                                this.changed = true;
                            }
                            int readInt2 = dataInputStream.readInt();
                            int i = 0;
                            for (int i2 = 0; i2 < readInt2; i2++) {
                                CachedContent readCachedContent = readCachedContent(readInt, dataInputStream);
                                hashMap.put(readCachedContent.key, readCachedContent);
                                sparseArray.put(readCachedContent.id, readCachedContent.key);
                                i += hashCachedContent(readCachedContent, readInt);
                            }
                            int readInt3 = dataInputStream.readInt();
                            boolean z = dataInputStream.read() == -1;
                            if (readInt3 != i || !z) {
                                Util.closeQuietly(dataInputStream);
                                return false;
                            }
                            Util.closeQuietly(dataInputStream);
                            return true;
                        }
                    }
                    Util.closeQuietly(dataInputStream);
                    return false;
                } catch (IOException unused) {
                    if (dataInputStream != null) {
                        Util.closeQuietly(dataInputStream);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (dataInputStream != null) {
                        Util.closeQuietly(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                }
                throw th;
            }
        }

        private void writeFile(HashMap<String, CachedContent> hashMap) throws IOException {
            DataOutputStream dataOutputStream;
            try {
                OutputStream startWrite = this.atomicFile.startWrite();
                if (this.bufferedOutputStream == null) {
                    this.bufferedOutputStream = new ReusableBufferedOutputStream(startWrite);
                } else {
                    this.bufferedOutputStream.reset(startWrite);
                }
                dataOutputStream = new DataOutputStream(this.bufferedOutputStream);
                try {
                    dataOutputStream.writeInt(2);
                    int i = 0;
                    dataOutputStream.writeInt(this.encrypt ? 1 : 0);
                    if (this.encrypt) {
                        byte[] bArr = new byte[16];
                        this.random.nextBytes(bArr);
                        dataOutputStream.write(bArr);
                        this.cipher.init(1, this.secretKeySpec, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                    }
                    dataOutputStream.writeInt(hashMap.size());
                    for (CachedContent next : hashMap.values()) {
                        writeCachedContent(next, dataOutputStream);
                        i += hashCachedContent(next, 2);
                    }
                    dataOutputStream.writeInt(i);
                    this.atomicFile.endWrite(dataOutputStream);
                    Util.closeQuietly((Closeable) null);
                } catch (InvalidKeyException e) {
                    e = e;
                    throw new IllegalStateException(e);
                } catch (InvalidAlgorithmParameterException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    th = th;
                    Util.closeQuietly(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                Util.closeQuietly(dataOutputStream);
                throw th;
            }
        }

        private int hashCachedContent(CachedContent cachedContent, int i) {
            int hashCode = (cachedContent.id * 31) + cachedContent.key.hashCode();
            if (i >= 2) {
                return (hashCode * 31) + cachedContent.getMetadata().hashCode();
            }
            long contentLength = ContentMetadata.CC.getContentLength(cachedContent.getMetadata());
            return (hashCode * 31) + ((int) (contentLength ^ (contentLength >>> 32)));
        }

        private CachedContent readCachedContent(int i, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadata;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i < 2) {
                long readLong = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.setContentLength(contentMetadataMutations, readLong);
                defaultContentMetadata = DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations);
            } else {
                defaultContentMetadata = CachedContentIndex.readContentMetadata(dataInputStream);
            }
            return new CachedContent(readInt, readUTF, defaultContentMetadata);
        }

        private void writeCachedContent(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.id);
            dataOutputStream.writeUTF(cachedContent.key);
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), dataOutputStream);
        }
    }

    static final class DatabaseStorage implements Storage {
        private static final String[] COLUMNS = {"id", "key", "metadata"};
        private final DatabaseProvider databaseProvider;
        private String hexUid;
        private final SparseArray<CachedContent> pendingUpdates = new SparseArray<>();
        private String tableName;

        public static void delete(DatabaseProvider databaseProvider2, long j) throws DatabaseIOException {
            delete(databaseProvider2, Long.toHexString(j));
        }

        public DatabaseStorage(DatabaseProvider databaseProvider2) {
            this.databaseProvider = databaseProvider2;
        }

        public final void initialize(long j) {
            this.hexUid = Long.toHexString(j);
            this.tableName = getTableName(this.hexUid);
        }

        public final boolean exists() throws DatabaseIOException {
            if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, this.hexUid) != -1) {
                return true;
            }
            return false;
        }

        public final void delete() throws DatabaseIOException {
            delete(this.databaseProvider, this.hexUid);
        }

        public final void load(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException {
            Cursor cursor;
            Throwable th;
            SQLiteDatabase writableDatabase;
            Assertions.checkState(this.pendingUpdates.size() == 0);
            try {
                if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, this.hexUid) != 1) {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    initializeTable(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                cursor = getCursor();
                while (cursor.moveToNext()) {
                    CachedContent cachedContent = new CachedContent(cursor.getInt(0), cursor.getString(1), CachedContentIndex.readContentMetadata(new DataInputStream(new ByteArrayInputStream(cursor.getBlob(2)))));
                    hashMap.put(cachedContent.key, cachedContent);
                    sparseArray.put(cachedContent.id, cachedContent.key);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            } catch (SQLiteException e) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e);
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
            throw th;
        }

        public final void storeFully(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                initializeTable(writableDatabase);
                for (CachedContent addOrUpdateRow : hashMap.values()) {
                    addOrUpdateRow(writableDatabase, addOrUpdateRow);
                }
                writableDatabase.setTransactionSuccessful();
                this.pendingUpdates.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        public final void storeIncremental(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            if (this.pendingUpdates.size() != 0) {
                try {
                    writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i = 0; i < this.pendingUpdates.size(); i++) {
                        CachedContent valueAt = this.pendingUpdates.valueAt(i);
                        if (valueAt == null) {
                            deleteRow(writableDatabase, this.pendingUpdates.keyAt(i));
                        } else {
                            addOrUpdateRow(writableDatabase, valueAt);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.pendingUpdates.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e) {
                    throw new DatabaseIOException(e);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        }

        public final void onUpdate(CachedContent cachedContent) {
            this.pendingUpdates.put(cachedContent.id, cachedContent);
        }

        public final void onRemove(CachedContent cachedContent, boolean z) {
            if (z) {
                this.pendingUpdates.delete(cachedContent.id);
            } else {
                this.pendingUpdates.put(cachedContent.id, null);
            }
        }

        private Cursor getCursor() {
            return this.databaseProvider.getReadableDatabase().query(this.tableName, COLUMNS, null, null, null, null, null);
        }

        private void initializeTable(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.setVersion(sQLiteDatabase, 1, this.hexUid, 1);
            dropTable(sQLiteDatabase, this.tableName);
            sQLiteDatabase.execSQL("CREATE TABLE " + this.tableName + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        private void deleteRow(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete(this.tableName, "id = ?", new String[]{Integer.toString(i)});
        }

        private void addOrUpdateRow(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.writeContentMetadata(cachedContent.getMetadata(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.id));
            contentValues.put("key", cachedContent.key);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow(this.tableName, null, contentValues);
        }

        private static void delete(DatabaseProvider databaseProvider2, String str) throws DatabaseIOException {
            SQLiteDatabase writableDatabase;
            try {
                String tableName2 = getTableName(str);
                writableDatabase = databaseProvider2.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.removeVersion(writableDatabase, 1, str);
                dropTable(writableDatabase, tableName2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        private static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(str)));
        }

        private static String getTableName(String str) {
            return "ExoPlayerCacheIndex".concat(String.valueOf(str));
        }
    }
}
