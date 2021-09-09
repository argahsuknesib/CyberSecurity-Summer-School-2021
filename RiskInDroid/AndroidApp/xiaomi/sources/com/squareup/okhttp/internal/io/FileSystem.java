package com.squareup.okhttp.internal.io;

import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        /* class com.squareup.okhttp.internal.io.FileSystem.AnonymousClass1 */

        public final jbn source(File file) throws FileNotFoundException {
            return jbg.O000000o(file);
        }

        public final jbm sink(File file) throws FileNotFoundException {
            try {
                return jbg.O00000Oo(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return jbg.O00000Oo(file);
            }
        }

        public final jbm appendingSink(File file) throws FileNotFoundException {
            try {
                return jbg.O00000o0(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return jbg.O00000o0(file);
            }
        }

        public final void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        public final boolean exists(File file) throws IOException {
            return file.exists();
        }

        public final long size(File file) {
            return file.length();
        }

        public final void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public final void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
    };

    jbm appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file) throws IOException;

    void rename(File file, File file2) throws IOException;

    jbm sink(File file) throws FileNotFoundException;

    long size(File file);

    jbn source(File file) throws FileNotFoundException;
}
