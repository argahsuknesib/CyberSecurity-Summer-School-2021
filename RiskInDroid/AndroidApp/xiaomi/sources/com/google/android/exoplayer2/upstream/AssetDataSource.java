package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends BaseDataSource {
    private final AssetManager assetManager;
    private long bytesRemaining;
    private InputStream inputStream;
    private boolean opened;
    private Uri uri;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.assetManager = context.getAssets();
    }

    public final long open(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            this.uri = dataSpec.uri;
            String str = (String) Assertions.checkNotNull(this.uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            transferInitializing(dataSpec);
            this.inputStream = this.assetManager.open(str, 1);
            if (this.inputStream.skip(dataSpec.position) >= dataSpec.position) {
                if (dataSpec.length != -1) {
                    this.bytesRemaining = dataSpec.length;
                } else {
                    this.bytesRemaining = (long) this.inputStream.available();
                    if (this.bytesRemaining == 2147483647L) {
                        this.bytesRemaining = -1;
                    }
                }
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.inputStream)).read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.bytesRemaining;
            if (j2 != -1) {
                this.bytesRemaining = j2 - ((long) read);
            }
            bytesTransferred(read);
            return read;
        } else if (this.bytesRemaining == -1) {
            return -1;
        } else {
            throw new AssetDataSourceException(new EOFException());
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws AssetDataSourceException {
        this.uri = null;
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        } catch (Throwable th) {
            this.inputStream = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th;
        }
    }
}
