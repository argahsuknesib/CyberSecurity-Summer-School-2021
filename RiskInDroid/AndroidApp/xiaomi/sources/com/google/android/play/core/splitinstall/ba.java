package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

final class ba {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3811a;

    ba(Context context) {
        this.f3811a = context;
    }

    private final SharedPreferences b() {
        return this.f3811a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return new java.util.HashSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001b */
    public final synchronized Set<String> a() {
        Set<String> stringSet = b().getStringSet("deferred_uninstall_module_list", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(Collection<String> collection) {
        Set<String> a2 = a();
        boolean z = false;
        for (String add : collection) {
            if (a2.add(add)) {
                z = true;
            }
        }
        if (z) {
            try {
                b().edit().putStringSet("deferred_uninstall_module_list", a2).apply();
            } catch (Exception unused) {
            }
        }
    }
}
