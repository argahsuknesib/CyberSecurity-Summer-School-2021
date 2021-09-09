package com.alipay.security.mobile.module.b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3236a;

    c(b bVar) {
        this.f3236a = bVar;
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
