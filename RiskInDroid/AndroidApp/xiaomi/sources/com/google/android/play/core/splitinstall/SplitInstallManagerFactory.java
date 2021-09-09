package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.splitcompat.q;

public class SplitInstallManagerFactory {
    public static SplitInstallManager create(Context context) {
        return u.a(context, q.a());
    }
}
