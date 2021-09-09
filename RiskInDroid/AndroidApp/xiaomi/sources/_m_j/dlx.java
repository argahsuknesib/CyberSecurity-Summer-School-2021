package _m_j;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class dlx implements FileFilter {
    dlx() {
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
