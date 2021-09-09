package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile {
    private final File backupName;
    private final File baseName;

    public AtomicFile(File file) {
        this.baseName = file;
        this.backupName = new File(file.getPath() + ".bak");
    }

    public final boolean exists() {
        return this.baseName.exists() || this.backupName.exists();
    }

    public final void delete() {
        this.baseName.delete();
        this.backupName.delete();
    }

    public final OutputStream startWrite() throws IOException {
        if (this.baseName.exists()) {
            if (this.backupName.exists()) {
                this.baseName.delete();
            } else if (!this.baseName.renameTo(this.backupName)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.baseName + " to backup file " + this.backupName);
            }
        }
        try {
            return new AtomicFileOutputStream(this.baseName);
        } catch (FileNotFoundException e) {
            File parentFile = this.baseName.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.baseName, e);
            }
            try {
                return new AtomicFileOutputStream(this.baseName);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.baseName, e2);
            }
        }
    }

    public final void endWrite(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.backupName.delete();
    }

    public final InputStream openRead() throws FileNotFoundException {
        restoreBackup();
        return new FileInputStream(this.baseName);
    }

    private void restoreBackup() {
        if (this.backupName.exists()) {
            this.baseName.delete();
            this.backupName.renameTo(this.baseName);
        }
    }

    static final class AtomicFileOutputStream extends OutputStream {
        private boolean closed = false;
        private final FileOutputStream fileOutputStream;

        public AtomicFileOutputStream(File file) throws FileNotFoundException {
            this.fileOutputStream = new FileOutputStream(file);
        }

        public final void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                flush();
                try {
                    this.fileOutputStream.getFD().sync();
                } catch (IOException e) {
                    Log.w("AtomicFile", "Failed to sync file descriptor:", e);
                }
                this.fileOutputStream.close();
            }
        }

        public final void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        public final void write(int i) throws IOException {
            this.fileOutputStream.write(i);
        }

        public final void write(byte[] bArr) throws IOException {
            this.fileOutputStream.write(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            this.fileOutputStream.write(bArr, i, i2);
        }
    }
}
