package _m_j;

import java.io.File;
import java.io.FileFilter;

final class elf implements FileFilter {
    elf() {
    }

    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
