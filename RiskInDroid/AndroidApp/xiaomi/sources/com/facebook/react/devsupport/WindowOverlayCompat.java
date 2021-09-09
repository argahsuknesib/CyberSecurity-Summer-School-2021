package com.facebook.react.devsupport;

import android.os.Build;

class WindowOverlayCompat {
    static final int TYPE_SYSTEM_ALERT = (Build.VERSION.SDK_INT < 26 ? 2003 : 2038);
    static final int TYPE_SYSTEM_OVERLAY;

    WindowOverlayCompat() {
    }

    static {
        int i = 2038;
        if (Build.VERSION.SDK_INT < 26) {
            i = 2006;
        }
        TYPE_SYSTEM_OVERLAY = i;
    }
}
