package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

final class be implements at {
    be() {
    }

    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) bl.a(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
