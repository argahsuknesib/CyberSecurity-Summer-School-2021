package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private boolean opened;
    private Uri uri;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public static final class Factory implements DataSource.Factory {
        private TransferListener listener;

        public final Factory setListener(TransferListener transferListener) {
            this.listener = transferListener;
            return this;
        }

        public final FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.listener;
            if (transferListener != null) {
                fileDataSource.addTransferListener(transferListener);
            }
            return fileDataSource;
        }
    }

    public FileDataSource() {
        super(false);
    }

    public final long open(DataSpec dataSpec) throws FileDataSourceException {
        try {
            Uri uri2 = dataSpec.uri;
            this.uri = uri2;
            transferInitializing(dataSpec);
            this.file = openLocalFile(uri2);
            this.file.seek(dataSpec.position);
            this.bytesRemaining = dataSpec.length == -1 ? this.file.length() - dataSpec.position : dataSpec.length;
            if (this.bytesRemaining >= 0) {
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.castNonNull(this.file)).read(bArr, i, (int) Math.min(this.bytesRemaining, (long) i2));
            if (read > 0) {
                this.bytesRemaining -= (long) read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws FileDataSourceException {
        this.uri = null;
        try {
            if (this.file != null) {
                this.file.close();
            }
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        } catch (Throwable th) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th;
        }
    }

    private static RandomAccessFile openLocalFile(Uri uri2) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) Assertions.checkNotNull(uri2.getPath()), "r");
        } catch (FileNotFoundException e) {
            if (!TextUtils.isEmpty(uri2.getQuery()) || !TextUtils.isEmpty(uri2.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri2.getPath(), uri2.getQuery(), uri2.getFragment()), e);
            }
            throw new FileDataSourceException(e);
        }
    }
}
