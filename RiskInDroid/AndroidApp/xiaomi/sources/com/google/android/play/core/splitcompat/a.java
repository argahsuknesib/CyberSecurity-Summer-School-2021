package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.play.core.internal.bl;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final d f3776a;

    a(d dVar) {
        this.f3776a = dVar;
    }

    static final synchronized void b(Context context, Set<File> set) {
        synchronized (a.class) {
            AssetManager assets = context.getAssets();
            for (File path : set) {
                int intValue = ((Integer) bl.a(assets, "addAssetPath", Integer.class, String.class, path.getPath())).intValue();
                StringBuilder sb = new StringBuilder(39);
                sb.append("addAssetPath completed with ");
                sb.append(intValue);
                Log.d("SplitCompat", sb.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[Catch:{ Exception -> 0x0045 }, LOOP:0: B:14:0x0022->B:16:0x0028, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A[SYNTHETIC, Splitter:B:19:0x003d] */
    public final synchronized boolean a(Context context, Set<String> set) {
        StrictMode.ThreadPolicy threadPolicy;
        boolean z;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            threadPolicy = null;
            Log.i("SplitCompat", "Unable to set up strict mode.", e);
            HashSet hashSet = new HashSet();
            while (r6.hasNext()) {
            }
            b(context, hashSet);
            if (threadPolicy != null) {
            }
            z = true;
            return z;
        }
        try {
            HashSet hashSet2 = new HashSet();
            for (String b : set) {
                hashSet2.add(this.f3776a.b(b));
            }
            b(context, hashSet2);
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
            z = true;
        } catch (Exception e3) {
            try {
                Log.e("SplitCompat", "Error installing additional splits", e3);
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                z = false;
            } catch (Throwable th) {
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                throw th;
            }
        }
        return z;
    }
}
