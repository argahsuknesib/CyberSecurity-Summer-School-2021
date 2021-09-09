package com.google.android.gms.common.api.internal;

import _m_j.o0O0OOO0;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzcc extends Fragment implements LifecycleFragment {
    private static WeakHashMap<FragmentActivity, WeakReference<zzcc>> zzla = new WeakHashMap<>();
    private Map<String, LifecycleCallback> zzlb = new o0O0OOO0();
    /* access modifiers changed from: private */
    public int zzlc = 0;
    /* access modifiers changed from: private */
    public Bundle zzld;

    public static zzcc zza(FragmentActivity fragmentActivity) {
        zzcc zzcc;
        WeakReference weakReference = zzla.get(fragmentActivity);
        if (weakReference != null && (zzcc = (zzcc) weakReference.get()) != null) {
            return zzcc;
        }
        try {
            zzcc zzcc2 = (zzcc) fragmentActivity.getSupportFragmentManager().O000000o("SupportLifecycleFragmentImpl");
            if (zzcc2 == null || zzcc2.isRemoving()) {
                zzcc2 = new zzcc();
                fragmentActivity.getSupportFragmentManager().O000000o().O000000o(zzcc2, "SupportLifecycleFragmentImpl").O00000o0();
            }
            zzla.put(fragmentActivity, new WeakReference(zzcc2));
            return zzcc2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        if (!this.zzlb.containsKey(str)) {
            this.zzlb.put(str, lifecycleCallback);
            if (this.zzlc > 0) {
                new Handler(Looper.getMainLooper()).post(new zzcd(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzlb.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.zzlb.get(str));
    }

    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.zzlc > 0;
    }

    public final boolean isStarted() {
        return this.zzlc >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzlb.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzlc = 1;
        this.zzld = bundle;
        for (Map.Entry next : this.zzlb.entrySet()) {
            ((LifecycleCallback) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzlc = 5;
        for (LifecycleCallback onDestroy : this.zzlb.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzlc = 3;
        for (LifecycleCallback onResume : this.zzlb.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.zzlb.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzlc = 2;
        for (LifecycleCallback onStart : this.zzlb.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzlc = 4;
        for (LifecycleCallback onStop : this.zzlb.values()) {
            onStop.onStop();
        }
    }
}
