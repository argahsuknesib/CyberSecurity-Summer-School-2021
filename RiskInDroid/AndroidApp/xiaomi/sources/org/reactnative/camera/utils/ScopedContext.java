package org.reactnative.camera.utils;

import android.content.Context;
import java.io.File;

public class ScopedContext {

    /* renamed from: O000000o  reason: collision with root package name */
    public File f15478O000000o = null;

    public ScopedContext(Context context) {
        this.f15478O000000o = new File(context.getCacheDir() + "/Camera/");
    }
}
