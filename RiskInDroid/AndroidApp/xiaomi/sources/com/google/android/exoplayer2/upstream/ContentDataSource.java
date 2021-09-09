package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends BaseDataSource {
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private FileInputStream inputStream;
    private boolean opened;
    private final ContentResolver resolver;
    private Uri uri;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.resolver = context.getContentResolver();
    }

    public final long open(DataSpec dataSpec) throws ContentDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            AssetFileDescriptor openAssetFileDescriptor = this.resolver.openAssetFileDescriptor(uri2, "r");
            this.assetFileDescriptor = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.inputStream = fileInputStream;
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
                if (skip == dataSpec.position) {
                    long j = -1;
                    if (dataSpec.length != -1) {
                        this.bytesRemaining = dataSpec.length;
                    } else {
                        long length = openAssetFileDescriptor.getLength();
                        if (length == -1) {
                            FileChannel channel = fileInputStream.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j = size - channel.position();
                            }
                            this.bytesRemaining = j;
                        } else {
                            this.bytesRemaining = length - skip;
                        }
                    }
                    this.opened = true;
                    transferStarted(dataSpec);
                    return this.bytesRemaining;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: ".concat(String.valueOf(uri2)));
        } catch (IOException e) {
            throw new ContentDataSourceException(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
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
                throw new ContentDataSourceException(e);
            }
        }
        int read = ((FileInputStream) Util.castNonNull(this.inputStream)).read(bArr, i, i2);
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
            throw new ContentDataSourceException(new EOFException());
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws ContentDataSourceException {
        this.uri = null;
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
            this.inputStream = null;
            try {
                if (this.assetFileDescriptor != null) {
                    this.assetFileDescriptor.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            } catch (IOException e) {
                throw new ContentDataSourceException(e);
            } catch (Throwable th) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2);
        } catch (Throwable th2) {
            this.inputStream = null;
            try {
                if (this.assetFileDescriptor != null) {
                    this.assetFileDescriptor.close();
                }
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th2;
            } catch (IOException e3) {
                throw new ContentDataSourceException(e3);
            } catch (Throwable th3) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th3;
            }
        }
    }
}
