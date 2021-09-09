package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public final class SimpleCache implements Cache {
    private static final HashSet<File> lockedCacheDirs = new HashSet<>();
    private final File cacheDir;
    private final CachedContentIndex contentIndex;
    public final CacheEvictor evictor;
    private final CacheFileMetadataIndex fileIndex;
    private Cache.CacheException initializationException;
    private final HashMap<String, ArrayList<Cache.Listener>> listeners;
    private final Random random;
    private boolean released;
    private long totalSpace;
    private final boolean touchCacheSpans;
    private long uid;

    public static synchronized boolean isCacheFolderLocked(File file) {
        boolean contains;
        synchronized (SimpleCache.class) {
            contains = lockedCacheDirs.contains(file.getAbsoluteFile());
        }
        return contains;
    }

    public static void delete(File file, DatabaseProvider databaseProvider) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long loadUid = loadUid(listFiles);
                if (loadUid != -1) {
                    try {
                        CacheFileMetadataIndex.delete(databaseProvider, loadUid);
                    } catch (DatabaseIOException unused) {
                        Log.w("SimpleCache", "Failed to delete file metadata: ".concat(String.valueOf(loadUid)));
                    }
                    try {
                        CachedContentIndex.delete(databaseProvider, loadUid);
                    } catch (DatabaseIOException unused2) {
                        Log.w("SimpleCache", "Failed to delete file metadata: ".concat(String.valueOf(loadUid)));
                    }
                }
            }
            Util.recursiveDelete(file);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.exoplayer2.upstream.cache.SimpleCache.<init>(java.io.File, com.google.android.exoplayer2.upstream.cache.CacheEvictor, byte[], boolean):void
     arg types: [java.io.File, com.google.android.exoplayer2.upstream.cache.CacheEvictor, ?[OBJECT, ARRAY], int]
     candidates:
      com.google.android.exoplayer2.upstream.cache.SimpleCache.<init>(java.io.File, com.google.android.exoplayer2.upstream.cache.CacheEvictor, com.google.android.exoplayer2.upstream.cache.CachedContentIndex, com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex):void
      com.google.android.exoplayer2.upstream.cache.SimpleCache.<init>(java.io.File, com.google.android.exoplayer2.upstream.cache.CacheEvictor, byte[], boolean):void */
    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, (byte[]) null, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr, boolean z) {
        this(file, cacheEvictor, null, bArr, z, true);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider, byte[] bArr, boolean z, boolean z2) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z, z2), (databaseProvider == null || z2) ? null : new CacheFileMetadataIndex(databaseProvider));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (lockFolder(file)) {
            this.cacheDir = file;
            this.evictor = cacheEvictor;
            this.contentIndex = cachedContentIndex;
            this.fileIndex = cacheFileMetadataIndex;
            this.listeners = new HashMap<>();
            this.random = new Random();
            this.touchCacheSpans = cacheEvictor.requiresCacheSpanTouches();
            this.uid = -1;
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("ExoPlayer:SimpleCacheInit") {
                /* class com.google.android.exoplayer2.upstream.cache.SimpleCache.AnonymousClass1 */

                public void run() {
                    synchronized (SimpleCache.this) {
                        conditionVariable.open();
                        SimpleCache.this.initialize();
                        SimpleCache.this.evictor.onCacheInitialized();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: ".concat(String.valueOf(file)));
    }

    public final synchronized void checkInitialization() throws Cache.CacheException {
        if (this.initializationException != null) {
            throw this.initializationException;
        }
    }

    public final synchronized long getUid() {
        return this.uid;
    }

    public final synchronized void release() {
        if (!this.released) {
            this.listeners.clear();
            removeStaleSpans();
            try {
                this.contentIndex.store();
                unlockFolder(this.cacheDir);
                this.released = true;
            } catch (IOException e) {
                try {
                    Log.e("SimpleCache", "Storing index file failed", e);
                } finally {
                    unlockFolder(this.cacheDir);
                    this.released = true;
                }
            }
        }
    }

    public final synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        Assertions.checkState(!this.released);
        ArrayList arrayList = this.listeners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.listeners.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return;
     */
    public final synchronized void removeListener(String str, Cache.Listener listener) {
        if (!this.released) {
            ArrayList arrayList = this.listeners.get(str);
            if (arrayList != null) {
                arrayList.remove(listener);
                if (arrayList.isEmpty()) {
                    this.listeners.remove(str);
                }
            }
        }
    }

    public final synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent != null) {
            if (!cachedContent.isEmpty()) {
                return new TreeSet((Collection) cachedContent.getSpans());
            }
        }
        return new TreeSet();
    }

    public final synchronized Set<String> getKeys() {
        Assertions.checkState(!this.released);
        return new HashSet(this.contentIndex.getKeys());
    }

    public final synchronized long getCacheSpace() {
        Assertions.checkState(!this.released);
        return this.totalSpace;
    }

    public final synchronized CacheSpan startReadWrite(String str, long j) throws InterruptedException, Cache.CacheException {
        CacheSpan startReadWriteNonBlocking;
        Assertions.checkState(!this.released);
        checkInitialization();
        while (true) {
            startReadWriteNonBlocking = startReadWriteNonBlocking(str, j);
            if (startReadWriteNonBlocking == null) {
                wait();
            }
        }
        return startReadWriteNonBlocking;
    }

    public final synchronized CacheSpan startReadWriteNonBlocking(String str, long j) throws Cache.CacheException {
        Assertions.checkState(!this.released);
        checkInitialization();
        SimpleCacheSpan span = getSpan(str, j);
        if (span.isCached) {
            return touchSpan(str, span);
        }
        CachedContent orAdd = this.contentIndex.getOrAdd(str);
        if (orAdd.isLocked()) {
            return null;
        }
        orAdd.setLocked(true);
        return span;
    }

    public final synchronized File startFile(String str, long j, long j2) throws Cache.CacheException {
        CachedContent cachedContent;
        File file;
        Assertions.checkState(!this.released);
        checkInitialization();
        cachedContent = this.contentIndex.get(str);
        Assertions.checkNotNull(cachedContent);
        Assertions.checkState(cachedContent.isLocked());
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
            removeStaleSpans();
        }
        this.evictor.onStartFile(this, str, j, j2);
        file = new File(this.cacheDir, Integer.toString(this.random.nextInt(10)));
        if (!file.exists()) {
            file.mkdir();
        }
        return SimpleCacheSpan.getCacheFile(file, cachedContent.id, j, System.currentTimeMillis());
    }

    public final synchronized void commitFile(File file, long j) throws Cache.CacheException {
        boolean z = true;
        Assertions.checkState(!this.released);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.checkNotNull(SimpleCacheSpan.createCacheEntry(file, j, this.contentIndex));
            CachedContent cachedContent = (CachedContent) Assertions.checkNotNull(this.contentIndex.get(simpleCacheSpan.key));
            Assertions.checkState(cachedContent.isLocked());
            long contentLength = ContentMetadata.CC.getContentLength(cachedContent.getMetadata());
            if (contentLength != -1) {
                if (simpleCacheSpan.position + simpleCacheSpan.length > contentLength) {
                    z = false;
                }
                Assertions.checkState(z);
            }
            if (this.fileIndex != null) {
                try {
                    this.fileIndex.set(file.getName(), simpleCacheSpan.length, simpleCacheSpan.lastTouchTimestamp);
                } catch (IOException e) {
                    throw new Cache.CacheException(e);
                } catch (IOException e2) {
                    throw new Cache.CacheException(e2);
                }
            }
            addSpan(simpleCacheSpan);
            this.contentIndex.store();
            notifyAll();
        }
    }

    public final synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.released);
        CachedContent cachedContent = (CachedContent) Assertions.checkNotNull(this.contentIndex.get(cacheSpan.key));
        Assertions.checkState(cachedContent.isLocked());
        cachedContent.setLocked(false);
        this.contentIndex.maybeRemove(cachedContent.key);
        notifyAll();
    }

    public final synchronized void removeSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.released);
        removeSpanInternal(cacheSpan);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        return false;
     */
    public final synchronized boolean isCached(String str, long j, long j2) {
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent != null && cachedContent.getCachedBytesLength(j, j2) >= j2) {
            return true;
        }
    }

    public final synchronized long getCachedLength(String str, long j, long j2) {
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent != null) {
            return cachedContent.getCachedBytesLength(j, j2);
        }
        return -j2;
    }

    public final synchronized void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        Assertions.checkState(!this.released);
        checkInitialization();
        this.contentIndex.applyContentMetadataMutations(str, contentMetadataMutations);
        try {
            this.contentIndex.store();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    public final synchronized ContentMetadata getContentMetadata(String str) {
        Assertions.checkState(!this.released);
        return this.contentIndex.getContentMetadata(str);
    }

    public final void initialize() {
        if (this.cacheDir.exists() || this.cacheDir.mkdirs()) {
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles == null) {
                String str = "Failed to list cache directory files: " + this.cacheDir;
                Log.e("SimpleCache", str);
                this.initializationException = new Cache.CacheException(str);
                return;
            }
            this.uid = loadUid(listFiles);
            if (this.uid == -1) {
                try {
                    this.uid = createUid(this.cacheDir);
                } catch (IOException e) {
                    String str2 = "Failed to create cache UID: " + this.cacheDir;
                    Log.e("SimpleCache", str2, e);
                    this.initializationException = new Cache.CacheException(str2, e);
                    return;
                }
            }
            try {
                this.contentIndex.initialize(this.uid);
                if (this.fileIndex != null) {
                    this.fileIndex.initialize(this.uid);
                    Map<String, CacheFileMetadata> all = this.fileIndex.getAll();
                    loadDirectory(this.cacheDir, true, listFiles, all);
                    this.fileIndex.removeAll(all.keySet());
                } else {
                    loadDirectory(this.cacheDir, true, listFiles, null);
                }
                this.contentIndex.removeEmpty();
                try {
                    this.contentIndex.store();
                } catch (IOException e2) {
                    Log.e("SimpleCache", "Storing index file failed", e2);
                }
            } catch (IOException e3) {
                String str3 = "Failed to initialize cache indices: " + this.cacheDir;
                Log.e("SimpleCache", str3, e3);
                this.initializationException = new Cache.CacheException(str3, e3);
            }
        } else {
            String str4 = "Failed to create cache directory: " + this.cacheDir;
            Log.e("SimpleCache", str4);
            this.initializationException = new Cache.CacheException(str4);
        }
    }

    private void loadDirectory(File file, boolean z, File[] fileArr, Map<String, CacheFileMetadata> map) {
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z && name.indexOf(46) == -1) {
                    loadDirectory(file2, false, file2.listFiles(), map);
                } else if (!z || (!CachedContentIndex.isIndexFile(name) && !name.endsWith(".uid"))) {
                    long j = -1;
                    long j2 = -9223372036854775807L;
                    CacheFileMetadata remove = map != null ? map.remove(name) : null;
                    if (remove != null) {
                        j = remove.length;
                        j2 = remove.lastTouchTimestamp;
                    }
                    SimpleCacheSpan createCacheEntry = SimpleCacheSpan.createCacheEntry(file2, j, j2, this.contentIndex);
                    if (createCacheEntry != null) {
                        addSpan(createCacheEntry);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z) {
            file.delete();
        }
    }

    private SimpleCacheSpan touchSpan(String str, SimpleCacheSpan simpleCacheSpan) {
        if (!this.touchCacheSpans) {
            return simpleCacheSpan;
        }
        String name = ((File) Assertions.checkNotNull(simpleCacheSpan.file)).getName();
        long j = simpleCacheSpan.length;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.set(name, j, currentTimeMillis);
            } catch (IOException unused) {
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        } else {
            z = true;
        }
        SimpleCacheSpan lastTouchTimestamp = this.contentIndex.get(str).setLastTouchTimestamp(simpleCacheSpan, currentTimeMillis, z);
        notifySpanTouched(simpleCacheSpan, lastTouchTimestamp);
        return lastTouchTimestamp;
    }

    private SimpleCacheSpan getSpan(String str, long j) {
        SimpleCacheSpan span;
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent == null) {
            return SimpleCacheSpan.createOpenHole(str, j);
        }
        while (true) {
            span = cachedContent.getSpan(j);
            if (!span.isCached || span.file.length() == span.length) {
                return span;
            }
            removeStaleSpans();
        }
        return span;
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.contentIndex.getOrAdd(simpleCacheSpan.key).addSpan(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        notifySpanAdded(simpleCacheSpan);
    }

    private void removeSpanInternal(CacheSpan cacheSpan) {
        CachedContent cachedContent = this.contentIndex.get(cacheSpan.key);
        if (cachedContent != null && cachedContent.removeSpan(cacheSpan)) {
            this.totalSpace -= cacheSpan.length;
            if (this.fileIndex != null) {
                String name = cacheSpan.file.getName();
                try {
                    this.fileIndex.remove(name);
                } catch (IOException unused) {
                    Log.w("SimpleCache", "Failed to remove file index entry for: ".concat(String.valueOf(name)));
                }
            }
            this.contentIndex.maybeRemove(cachedContent.key);
            notifySpanRemoved(cacheSpan);
        }
    }

    private void removeStaleSpans() {
        ArrayList arrayList = new ArrayList();
        for (CachedContent spans : this.contentIndex.getAll()) {
            Iterator<SimpleCacheSpan> it = spans.getSpans().iterator();
            while (it.hasNext()) {
                CacheSpan next = it.next();
                if (next.file.length() != next.length) {
                    arrayList.add(next);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            removeSpanInternal((CacheSpan) arrayList.get(i));
        }
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    private static long loadUid(File[] fileArr) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return parseUid(name);
                } catch (NumberFormatException unused) {
                    Log.e("SimpleCache", "Malformed UID file: ".concat(String.valueOf(file)));
                    file.delete();
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static long createUid(File file) throws IOException {
        long j;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            j = 0;
        } else {
            j = Math.abs(nextLong);
        }
        String l = Long.toString(j, 16);
        File file2 = new File(file, l + ".uid");
        if (file2.createNewFile()) {
            return j;
        }
        throw new IOException("Failed to create UID file: ".concat(String.valueOf(file2)));
    }

    private static long parseUid(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private static synchronized boolean lockFolder(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = lockedCacheDirs.add(file.getAbsoluteFile());
        }
        return add;
    }

    private static synchronized void unlockFolder(File file) {
        synchronized (SimpleCache.class) {
            lockedCacheDirs.remove(file.getAbsoluteFile());
        }
    }
}
