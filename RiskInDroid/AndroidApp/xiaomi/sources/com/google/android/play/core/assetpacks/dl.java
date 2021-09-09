package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.aa;

final class dl {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3706a = new aa("PackageStateCache");
    private final Context b;
    private int c = -1;

    dl(Context context) {
        this.b = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
    public final synchronized int a() {
        if (this.c == -1) {
            this.c = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionCode;
            f3706a.b("The current version of the app could not be retrieved", new Object[0]);
        }
        return this.c;
    }
}
