package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {
    private final int bufferSize;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private final Cache cache;
    private DataSpec dataSpec;
    private long dataSpecBytesWritten;
    private long dataSpecFragmentSize;
    private File file;
    private final long fragmentSize;
    private OutputStream outputStream;
    private long outputStreamBytesWritten;

    public static class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(Cache cache2, long j) {
        this(cache2, j, 20480);
    }

    public CacheDataSink(Cache cache2, long j, int i) {
        Assertions.checkState(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < 2097152) {
            Log.w("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.cache = (Cache) Assertions.checkNotNull(cache2);
        this.fragmentSize = j == -1 ? Long.MAX_VALUE : j;
        this.bufferSize = i;
    }

    public final void open(DataSpec dataSpec2) throws CacheDataSinkException {
        if (dataSpec2.length != -1 || !dataSpec2.isFlagSet(2)) {
            this.dataSpec = dataSpec2;
            this.dataSpecFragmentSize = dataSpec2.isFlagSet(4) ? this.fragmentSize : Long.MAX_VALUE;
            this.dataSpecBytesWritten = 0;
            try {
                openNextOutputStream();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        } else {
            this.dataSpec = null;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        if (this.dataSpec != null) {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    if (this.outputStreamBytesWritten == this.dataSpecFragmentSize) {
                        closeCurrentOutputStream();
                        openNextOutputStream();
                    }
                    int min = (int) Math.min((long) (i2 - i3), this.dataSpecFragmentSize - this.outputStreamBytesWritten);
                    this.outputStream.write(bArr, i + i3, min);
                    i3 += min;
                    long j = (long) min;
                    this.outputStreamBytesWritten += j;
                    this.dataSpecBytesWritten += j;
                } catch (IOException e) {
                    throw new CacheDataSinkException(e);
                }
            }
        }
    }

    public final void close() throws CacheDataSinkException {
        if (this.dataSpec != null) {
            try {
                closeCurrentOutputStream();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    private void openNextOutputStream() throws IOException {
        long j = -1;
        if (this.dataSpec.length != -1) {
            j = Math.min(this.dataSpec.length - this.dataSpecBytesWritten, this.dataSpecFragmentSize);
        }
        this.file = this.cache.startFile(this.dataSpec.key, this.dataSpec.position + this.dataSpecBytesWritten, j);
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        int i = this.bufferSize;
        if (i > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
            if (reusableBufferedOutputStream == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(fileOutputStream, i);
            } else {
                reusableBufferedOutputStream.reset(fileOutputStream);
            }
            this.outputStream = this.bufferedOutputStream;
        } else {
            this.outputStream = fileOutputStream;
        }
        this.outputStreamBytesWritten = 0;
    }

    private void closeCurrentOutputStream() throws IOException {
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 != null) {
            try {
                outputStream2.flush();
                Util.closeQuietly(this.outputStream);
                this.outputStream = null;
                File file2 = this.file;
                this.file = null;
                this.cache.commitFile(file2, this.outputStreamBytesWritten);
            } catch (Throwable th) {
                Util.closeQuietly(this.outputStream);
                this.outputStream = null;
                File file3 = this.file;
                this.file = null;
                file3.delete();
                throw th;
            }
        }
    }
}
