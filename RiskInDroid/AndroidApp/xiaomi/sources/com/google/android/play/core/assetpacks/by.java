package com.google.android.play.core.assetpacks;

final class by extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    final int f3668a;

    by(String str) {
        super(str);
        this.f3668a = -1;
    }

    by(String str, int i) {
        super(str);
        this.f3668a = i;
    }

    by(String str, Exception exc) {
        super(str, exc);
        this.f3668a = -1;
    }

    by(String str, Exception exc, int i) {
        super(str, exc);
        this.f3668a = i;
    }
}
