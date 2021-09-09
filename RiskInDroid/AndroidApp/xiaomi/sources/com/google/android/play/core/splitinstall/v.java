package com.google.android.play.core.splitinstall;

import android.content.Context;

public final class v {
    private v() {
    }

    public static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
