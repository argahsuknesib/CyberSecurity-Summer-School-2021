package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public abstract class DirectoryWalker<T> {

    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file2, int i) {
            this("Operation Cancelled", file2, i);
        }

        public CancelException(String str, File file2, int i) {
            super(str);
            this.file = file2;
            this.depth = i;
        }

        public File getFile() {
            return this.file;
        }

        public int getDepth() {
            return this.depth;
        }
    }
}
