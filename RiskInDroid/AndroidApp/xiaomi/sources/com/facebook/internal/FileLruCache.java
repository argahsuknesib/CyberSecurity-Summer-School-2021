package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
    static final String TAG = "FileLruCache";
    public static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    public AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Limits limits;
    private final Object lock;
    private final String tag;

    interface StreamCloseCallback {
        void onClose();
    }

    public FileLruCache(String str, Limits limits2) {
        this.tag = str;
        this.limits = limits2;
        this.directory = new File(FacebookSdk.getCacheDir(), str);
        this.lock = new Object();
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            BufferFile.deleteAll(this.directory);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:21:0x0003, LOOP_START, SYNTHETIC] */
    public final long sizeInBytesForTest() {
        synchronized (this.lock) {
            while (true) {
                if (!this.isTrimPending) {
                    if (this.isTrimInProgress) {
                    }
                }
                this.lock.wait();
            }
            while (true) {
            }
        }
        File[] listFiles = this.directory.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File length : listFiles) {
                j += length.length();
            }
        }
        return j;
    }

    public final InputStream get(String str) throws IOException {
        return get(str, null);
    }

    public final InputStream get(String str, String str2) throws IOException {
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject readHeader = StreamHeader.readHeader(bufferedInputStream);
                if (readHeader == null) {
                    return null;
                }
                String optString = readHeader.optString("key");
                if (optString != null) {
                    if (optString.equals(str)) {
                        String optString2 = readHeader.optString("tag", null);
                        if ((str2 != null || optString2 == null) && (str2 == null || str2.equals(optString2))) {
                            long time = new Date().getTime();
                            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                            String str3 = TAG;
                            Logger.log(loggingBehavior, str3, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                            file.setLastModified(time);
                            return bufferedInputStream;
                        }
                        bufferedInputStream.close();
                        return null;
                    }
                }
                bufferedInputStream.close();
                return null;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final OutputStream openPutStream(String str) throws IOException {
        return openPutStream(str, null);
    }

    public final OutputStream openPutStream(String str, String str2) throws IOException {
        final File newFile = BufferFile.newFile(this.directory);
        newFile.delete();
        if (newFile.createNewFile()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                final long currentTimeMillis = System.currentTimeMillis();
                final String str3 = str;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() {
                    /* class com.facebook.internal.FileLruCache.AnonymousClass1 */

                    public void onClose() {
                        if (currentTimeMillis < FileLruCache.this.lastClearCacheTime.get()) {
                            newFile.delete();
                        } else {
                            FileLruCache.this.renameToTargetAndTrim(str3, newFile);
                        }
                    }
                }), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    StreamHeader.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: ".concat(String.valueOf(e)));
                    throw new IOException(e.getMessage());
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: ".concat(String.valueOf(e2)));
                throw new IOException(e2.getMessage());
            }
        } else {
            throw new IOException("Could not create file at " + newFile.getAbsolutePath());
        }
    }

    public final void clearCache() {
        final File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.internal.FileLruCache.AnonymousClass2 */

                public void run() {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            });
        }
    }

    public final String getLocation() {
        return this.directory.getPath();
    }

    public final void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    public final InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        return new CopyingInputStream(inputStream, openPutStream(str));
    }

    public final String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new Runnable() {
                    /* class com.facebook.internal.FileLruCache.AnonymousClass3 */

                    public void run() {
                        FileLruCache.this.trim();
                    }
                });
            }
        }
    }

    public final void trim() {
        long j;
        synchronized (this.lock) {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
        }
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
            long j2 = 0;
            if (listFiles != null) {
                long j3 = 0;
                j = 0;
                for (File file : listFiles) {
                    ModifiedFile modifiedFile = new ModifiedFile(file);
                    priorityQueue.add(modifiedFile);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                    j3 += file.length();
                    j++;
                }
                j2 = j3;
            } else {
                j = 0;
            }
            while (true) {
                if (j2 > ((long) this.limits.getByteCount()) || j > ((long) this.limits.getFileCount())) {
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file2.getName());
                    j2 -= file2.length();
                    j--;
                    file2.delete();
                } else {
                    synchronized (this.lock) {
                        this.isTrimInProgress = false;
                        this.lock.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.isTrimInProgress = false;
                this.lock.notifyAll();
                throw th;
            }
        }
    }

    static class BufferFile {
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() {
            /* class com.facebook.internal.FileLruCache.BufferFile.AnonymousClass1 */

            public final boolean accept(File file, String str) {
                return !str.startsWith("buffer");
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() {
            /* class com.facebook.internal.FileLruCache.BufferFile.AnonymousClass2 */

            public final boolean accept(File file, String str) {
                return str.startsWith("buffer");
            }
        };

        private BufferFile() {
        }

        static void deleteAll(File file) {
            File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File file) {
            return new File(file, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }
    }

    static final class StreamHeader {
        private StreamHeader() {
        }

        static void writeHeader(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }

        static JSONObject readHeader(InputStream inputStream) throws IOException {
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int read2 = inputStream.read(bArr, i, i2 - i);
                if (read2 <= 0) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String str = FileLruCache.TAG;
                    Logger.log(loggingBehavior, str, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + i2);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                String str2 = FileLruCache.TAG;
                Logger.log(loggingBehavior2, str2, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                return null;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    static class CloseCallbackOutputStream extends OutputStream {
        final StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        public void flush() throws IOException {
            this.innerStream.flush();
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.innerStream.write(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.innerStream.write(bArr);
        }

        public void write(int i) throws IOException {
            this.innerStream.write(i);
        }
    }

    static final class CopyingInputStream extends InputStream {
        final InputStream input;
        final OutputStream output;

        public final boolean markSupported() {
            return false;
        }

        CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            this.input = inputStream;
            this.output = outputStream;
        }

        public final int available() throws IOException {
            return this.input.available();
        }

        public final void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        public final void mark(int i) {
            throw new UnsupportedOperationException();
        }

        public final int read(byte[] bArr) throws IOException {
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        public final int read() throws IOException {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.input.read(bArr, i, i2);
            if (read > 0) {
                this.output.write(bArr, i, read);
            }
            return read;
        }

        public final synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.min(long, long):long}
         arg types: [long, int]
         candidates:
          ClspMth{java.lang.Math.min(double, double):double}
          ClspMth{java.lang.Math.min(float, float):float}
          ClspMth{java.lang.Math.min(int, int):int}
          ClspMth{java.lang.Math.min(long, long):long} */
        public final long skip(long j) throws IOException {
            int read;
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j && (read = read(bArr, 0, (int) Math.min(j - j2, 1024L))) >= 0) {
                j2 += (long) read;
            }
            return j2;
        }
    }

    public static final class Limits {
        private int byteCount = ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
        private int fileCount = 1024;

        /* access modifiers changed from: package-private */
        public final int getByteCount() {
            return this.byteCount;
        }

        /* access modifiers changed from: package-private */
        public final int getFileCount() {
            return this.fileCount;
        }

        /* access modifiers changed from: package-private */
        public final void setByteCount(int i) {
            if (i >= 0) {
                this.byteCount = i;
                return;
            }
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void setFileCount(int i) {
            if (i >= 0) {
                this.fileCount = i;
                return;
            }
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
    }

    static final class ModifiedFile implements Comparable<ModifiedFile> {
        private final File file;
        private final long modified;

        ModifiedFile(File file2) {
            this.file = file2;
            this.modified = file2.lastModified();
        }

        /* access modifiers changed from: package-private */
        public final File getFile() {
            return this.file;
        }

        /* access modifiers changed from: package-private */
        public final long getModified() {
            return this.modified;
        }

        public final int compareTo(ModifiedFile modifiedFile) {
            if (getModified() < modifiedFile.getModified()) {
                return -1;
            }
            if (getModified() > modifiedFile.getModified()) {
                return 1;
            }
            return getFile().compareTo(modifiedFile.getFile());
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        public final int hashCode() {
            return ((this.file.hashCode() + 1073) * 37) + ((int) (this.modified % 2147483647L));
        }
    }
}
