package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class cz implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private final String f3693a;

    cz(String str) {
        this.f3693a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f3693a).concat("-")) && str.endsWith(".apk");
    }
}
