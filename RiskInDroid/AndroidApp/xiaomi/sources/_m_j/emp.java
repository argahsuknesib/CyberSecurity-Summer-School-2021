package _m_j;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class emp implements FilenameFilter {
    emp() {
    }

    public final boolean accept(File file, String str) {
        return !TextUtils.isEmpty(str) && !str.toLowerCase().endsWith(".lock");
    }
}
