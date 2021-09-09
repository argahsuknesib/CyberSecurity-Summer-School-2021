package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiskBasedCache implements Cache {
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    public DiskBasedCache(File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    public synchronized void clear() {
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0;
        VolleyLog.d("Cache cleared.", new Object[0]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059 A[SYNTHETIC, Splitter:B:29:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064 A[SYNTHETIC, Splitter:B:38:0x0064] */
    public synchronized Cache.Entry get(String str) {
        CountingInputStream countingInputStream;
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader == null) {
            return null;
        }
        File fileForKey = getFileForKey(str);
        try {
            countingInputStream = new CountingInputStream(new FileInputStream(fileForKey));
            try {
                CacheHeader.readHeader(countingInputStream);
                Cache.Entry cacheEntry = cacheHeader.toCacheEntry(streamToBytes(countingInputStream, (int) (fileForKey.length() - ((long) countingInputStream.bytesRead))));
                try {
                    countingInputStream.close();
                    return cacheEntry;
                } catch (IOException unused) {
                    return null;
                }
            } catch (IOException e) {
                e = e;
                try {
                    VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e.toString());
                    remove(str);
                    if (countingInputStream != null) {
                        try {
                            countingInputStream.close();
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (countingInputStream != null) {
                        try {
                            countingInputStream.close();
                        } catch (IOException unused3) {
                            return null;
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            countingInputStream = null;
            VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e.toString());
            remove(str);
            if (countingInputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            countingInputStream = null;
            if (countingInputStream != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|(2:35|36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x005e */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0055 A[SYNTHETIC, Splitter:B:32:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0061 A[SYNTHETIC, Splitter:B:40:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0064 A[SYNTHETIC] */
    public synchronized void initialize() {
        FileInputStream fileInputStream;
        if (this.mRootDirectory.exists()) {
            File[] listFiles = this.mRootDirectory.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            CacheHeader readHeader = CacheHeader.readHeader(fileInputStream);
                            readHeader.size = file.length();
                            putEntry(readHeader.key, readHeader);
                        } catch (IOException unused) {
                            fileInputStream2 = fileInputStream;
                            if (file != null) {
                            }
                            if (fileInputStream2 == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    } catch (IOException unused3) {
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                            }
                        }
                        if (fileInputStream2 == null) {
                            fileInputStream2.close();
                        }
                    }
                }
                return;
            }
            return;
        } else if (!this.mRootDirectory.mkdirs()) {
            VolleyLog.e("Unable to create cache dir %s", this.mRootDirectory.getAbsolutePath());
        }
    }

    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0;
            if (z) {
                entry.ttl = 0;
            }
            put(str, entry);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(1:16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r0.delete() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        com.android.volley.VolleyLog.d("Could not clean up file %s", r0.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
    public synchronized void put(String str, Cache.Entry entry) {
        pruneIfNeeded(entry.data.length);
        File fileForKey = getFileForKey(str);
        FileOutputStream fileOutputStream = new FileOutputStream(fileForKey);
        CacheHeader cacheHeader = new CacheHeader(str, entry);
        if (cacheHeader.writeHeader(fileOutputStream)) {
            fileOutputStream.write(entry.data);
            fileOutputStream.close();
            putEntry(str, cacheHeader);
            return;
        }
        fileOutputStream.close();
        VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
        throw new IOException();
    }

    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    private void pruneIfNeeded(int i) {
        long j;
        long j2 = (long) i;
        if (this.mTotalSize + j2 >= ((long) this.mMaxCacheSizeInBytes)) {
            if (VolleyLog.DEBUG) {
                VolleyLog.v("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.mTotalSize;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                CacheHeader cacheHeader = (CacheHeader) it.next().getValue();
                if (getFileForKey(cacheHeader.key).delete()) {
                    j = j2;
                    this.mTotalSize -= cacheHeader.size;
                } else {
                    j = j2;
                    VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", cacheHeader.key, getFilenameForKey(cacheHeader.key));
                }
                it.remove();
                i2++;
                if (((float) (this.mTotalSize + j)) < ((float) this.mMaxCacheSizeInBytes) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (VolleyLog.DEBUG) {
                VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.mTotalSize - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (!this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size;
        } else {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    private static byte[] streamToBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static class CacheHeader {
        public String etag;
        public String key;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = (long) entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public static CacheHeader readHeader(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) == 538183203) {
                cacheHeader.key = DiskBasedCache.readString(inputStream);
                cacheHeader.etag = DiskBasedCache.readString(inputStream);
                if (cacheHeader.etag.equals("")) {
                    cacheHeader.etag = null;
                }
                cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
                cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
                cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
                cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
                return cacheHeader;
            }
            throw new IOException();
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, 538183203);
                DiskBasedCache.writeString(outputStream, this.key);
                DiskBasedCache.writeString(outputStream, this.etag == null ? "" : this.etag);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.d("%s", e.toString());
                return false;
            }
        }
    }

    static class CountingInputStream extends FilterInputStream {
        public int bytesRead;

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }

    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long readLong(InputStream inputStream) throws IOException {
        return ((((long) read(inputStream)) & 255) << 0) | 0 | ((((long) read(inputStream)) & 255) << 8) | ((((long) read(inputStream)) & 255) << 16) | ((((long) read(inputStream)) & 255) << 24) | ((((long) read(inputStream)) & 255) << 32) | ((((long) read(inputStream)) & 255) << 40) | ((((long) read(inputStream)) & 255) << 48) | ((255 & ((long) read(inputStream))) << 56);
    }

    static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String readString(InputStream inputStream) throws IOException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), "UTF-8");
    }

    static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            writeInt(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                writeString(outputStream, (String) next.getKey());
                writeString(outputStream, (String) next.getValue());
            }
            return;
        }
        writeInt(outputStream, 0);
    }

    static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        int readInt = readInt(inputStream);
        Map<String, String> emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap<>(readInt);
        for (int i = 0; i < readInt; i++) {
            emptyMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return emptyMap;
    }
}
