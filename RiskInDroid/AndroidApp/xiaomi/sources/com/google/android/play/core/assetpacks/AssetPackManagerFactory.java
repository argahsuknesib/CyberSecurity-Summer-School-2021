package com.google.android.play.core.assetpacks;

import android.content.Context;

public class AssetPackManagerFactory {
    public static synchronized AssetPackManager getInstance(Context context) {
        AssetPackManager a2;
        synchronized (AssetPackManagerFactory.class) {
            a2 = dd.a(context).a();
        }
        return a2;
    }
}
