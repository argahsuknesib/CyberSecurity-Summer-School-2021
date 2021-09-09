package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.internal.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

final class cr {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3686a = new aa("ExtractorSessionStoreView");
    private final bc b;
    private final ce<x> c;
    private final cb d;
    private final ce<Executor> e;
    private final Map<Integer, co> f = new HashMap();
    private final ReentrantLock g = new ReentrantLock();

    cr(bc bcVar, ce<x> ceVar, cb cbVar, ce<Executor> ceVar2) {
        this.b = bcVar;
        this.c = ceVar;
        this.d = cbVar;
        this.e = ceVar2;
    }

    private final <T> T a(cq cqVar) {
        try {
            a();
            return cqVar.a();
        } finally {
            b();
        }
    }

    private final Map<String, co> d(List<String> list) {
        return (Map) a(new ch(this, list));
    }

    private final co e(int i) {
        Map<Integer, co> map = this.f;
        Integer valueOf = Integer.valueOf(i);
        co coVar = map.get(valueOf);
        if (coVar != null) {
            return coVar;
        }
        throw new by(String.format("Could not find session %d while trying to get it", valueOf), i);
    }

    private static String e(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new by("Session without pack received.");
    }

    private static <T> List<T> e(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Integer> a(List<String> list) {
        return (Map) a(new ck(this, list));
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.g.lock();
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        a(new cj(this, i));
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, int i, long j) {
        a(new cg(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Bundle bundle) {
        return ((Boolean) a(new ce(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map b(List list) {
        int i;
        Map<String, co> d2 = d(list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            co coVar = d2.get(str);
            if (coVar == null) {
                i = 8;
            } else {
                if (dd.a(coVar.c.c)) {
                    try {
                        coVar.c.c = 6;
                        this.e.a().execute(new cl(this, coVar));
                        this.d.a(str);
                    } catch (by unused) {
                        f3686a.c("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(coVar.f3684a), str);
                    }
                }
                i = coVar.c.c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.g.unlock();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(int i) {
        e(i).c.c = 5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(String str, int i, long j) {
        co coVar = d(Arrays.asList(str)).get(str);
        if (coVar == null || dd.b(coVar.c.c)) {
            f3686a.b(String.format("Could not find pack %s while trying to complete it", str), new Object[0]);
        }
        this.b.f(str, i, j);
        coVar.c.c = 4;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(Bundle bundle) {
        return ((Boolean) a(new cf(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean c(Bundle bundle) {
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return Boolean.TRUE;
        }
        Map<Integer, co> map = this.f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return Boolean.TRUE;
        }
        co coVar = this.f.get(valueOf);
        if (coVar.c.c == 6) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(!dd.a(coVar.c.c, bundle.getInt(h.a("status", e(bundle)))));
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, co> c() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map c(List list) {
        HashMap hashMap = new HashMap();
        for (co next : this.f.values()) {
            String str = next.c.f3683a;
            if (list.contains(str)) {
                co coVar = (co) hashMap.get(str);
                if ((coVar != null ? coVar.f3684a : -1) < next.f3684a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(int i) {
        co e2 = e(i);
        if (dd.b(e2.c.c)) {
            bc bcVar = this.b;
            cn cnVar = e2.c;
            bcVar.f(cnVar.f3683a, e2.b, cnVar.b);
            cn cnVar2 = e2.c;
            int i2 = cnVar2.c;
            if (i2 == 5 || i2 == 6) {
                this.b.d(cnVar2.f3683a);
                return;
            }
            return;
        }
        throw new by(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean d(Bundle bundle) {
        cp cpVar;
        Iterator it;
        Bundle bundle2 = bundle;
        int i = bundle2.getInt("session_id");
        if (i == 0) {
            return Boolean.FALSE;
        }
        Map<Integer, co> map = this.f;
        Integer valueOf = Integer.valueOf(i);
        boolean z = false;
        if (map.containsKey(valueOf)) {
            co e2 = e(i);
            int i2 = bundle2.getInt(h.a("status", e2.c.f3683a));
            if (dd.a(e2.c.c, i2)) {
                f3686a.a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(e2.c.c));
                cn cnVar = e2.c;
                String str = cnVar.f3683a;
                int i3 = cnVar.c;
                if (i3 == 4) {
                    this.c.a().a(i, str);
                } else if (i3 == 5) {
                    this.c.a().a(i);
                } else if (i3 == 6) {
                    this.c.a().a(Arrays.asList(str));
                }
            } else {
                e2.c.c = i2;
                if (dd.b(i2)) {
                    a(i);
                    this.d.a(e2.c.f3683a);
                } else {
                    List<cp> list = e2.c.e;
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        cp cpVar2 = list.get(i4);
                        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(h.a("chunk_intents", e2.c.f3683a, cpVar2.f3685a));
                        if (parcelableArrayList != null) {
                            for (int i5 = 0; i5 < parcelableArrayList.size(); i5++) {
                                if (!(parcelableArrayList.get(i5) == null || ((Intent) parcelableArrayList.get(i5)).getData() == null)) {
                                    cpVar2.d.get(i5).f3682a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String e3 = e(bundle);
            long j = bundle2.getLong(h.a("pack_version", e3));
            int i6 = bundle2.getInt(h.a("status", e3));
            long j2 = bundle2.getLong(h.a("total_bytes_to_download", e3));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(h.a("slice_ids", e3));
            ArrayList arrayList = new ArrayList();
            Iterator it2 = e(stringArrayList).iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(h.a("chunk_intents", e3, str2));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : e(parcelableArrayList2)) {
                    if (intent != null) {
                        it = it2;
                        z = true;
                    } else {
                        it = it2;
                    }
                    arrayList2.add(new cm(z));
                    it2 = it;
                    z = false;
                }
                Iterator it3 = it2;
                String string = bundle2.getString(h.a("uncompressed_hash_sha256", e3, str2));
                long j3 = bundle2.getLong(h.a("uncompressed_size", e3, str2));
                z = false;
                int i7 = bundle2.getInt(h.a("patch_format", e3, str2), 0);
                if (i7 == 0) {
                    cpVar = new cp(str2, string, j3, arrayList2, bundle2.getInt(h.a("compression_format", e3, str2), 0), 0);
                } else {
                    cpVar = new cp(str2, string, j3, arrayList2, 0, i7);
                }
                arrayList.add(cpVar);
                it2 = it3;
            }
            this.f.put(Integer.valueOf(i), new co(i, bundle2.getInt("app_version_code"), new cn(e3, j, i6, j2, arrayList)));
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public final void d(int i) {
        a(new ci(this, i));
    }
}
