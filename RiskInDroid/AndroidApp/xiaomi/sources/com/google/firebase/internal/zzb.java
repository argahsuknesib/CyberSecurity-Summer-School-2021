package com.google.firebase.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzb {
    private static final AtomicReference<zzb> zzq = new AtomicReference<>();

    private zzb(Context context) {
    }

    public static FirebaseOptions zzb(String str) {
        return null;
    }

    public static void zzb(FirebaseApp firebaseApp) {
    }

    public static zzb zze(Context context) {
        zzq.compareAndSet(null, new zzb(context));
        return zzq.get();
    }

    public static zzb zzq() {
        return zzq.get();
    }

    public static Set<String> zzr() {
        return Collections.emptySet();
    }
}
