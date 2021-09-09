package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class MissingSplitsManagerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<Boolean> f3772a = new AtomicReference<>(null);

    public static MissingSplitsManager create(Context context) {
        return new b(context, Runtime.getRuntime(), new a(context, context.getPackageManager()), f3772a);
    }
}
