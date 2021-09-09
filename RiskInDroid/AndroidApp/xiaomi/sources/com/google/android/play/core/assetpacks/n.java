package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3727a;

    public n(Context context) {
        this.f3727a = context;
    }

    static String a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
            if (bundle != null) {
                return bundle.getString("local_testing_dir");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f3727a;
    }
}
