package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

final /* synthetic */ class ds implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    static final FilenameFilter f3712a = new ds();

    private ds() {
    }

    public final boolean accept(File file, String str) {
        return dt.f3713a.matcher(str).matches();
    }
}
