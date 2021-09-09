package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3618a;

    l(Context context) {
        this.f3618a = context;
    }

    private static long a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File a2 : listFiles) {
                j += a(a2);
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public final long a() {
        return a(new File(this.f3618a.getFilesDir(), "assetpacks"));
    }
}
