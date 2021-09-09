package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import java.io.InputStream;

final class bv extends ct {

    /* renamed from: a  reason: collision with root package name */
    final int f3665a;
    final long b;
    final String c;
    final int d;
    final int e;
    final int f;
    final long g;
    @AssetPackStatus
    final int h;
    final InputStream i;

    bv(int i2, String str, int i3, long j, String str2, int i4, int i5, int i6, long j2, @AssetPackStatus int i7, InputStream inputStream) {
        super(i2, str);
        this.f3665a = i3;
        this.b = j;
        this.c = str2;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = j2;
        this.h = i7;
        this.i = inputStream;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.e + 1 == this.f;
    }
}
