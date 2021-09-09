package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class c implements FilenameFilter {
    c() {
    }

    public final boolean accept(File file, String str) {
        return TextUtils.isDigitsOnly(str);
    }
}
