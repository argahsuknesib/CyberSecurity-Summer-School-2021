package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ak;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.internal.s;
import com.google.android.play.core.splitinstall.v;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class as implements x {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final aa f3638a = new aa("AssetPackServiceImpl");
    private static final Intent b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */
    public final String c;
    /* access modifiers changed from: private */
    public final cb d;
    /* access modifiers changed from: private */
    public ak<s> e;
    /* access modifiers changed from: private */
    public ak<s> f;
    /* access modifiers changed from: private */
    public final AtomicBoolean g = new AtomicBoolean();

    as(Context context, cb cbVar) {
        this.c = context.getPackageName();
        this.d = cbVar;
        if (bt.a(context)) {
            this.e = new ak(v.a(context), f3638a, "AssetPackService", b, y.f3735a);
            this.f = new ak(v.a(context), f3638a, "AssetPackService-keepAlive", b, z.f3736a);
        }
        f3638a.a("AssetPackService initiated.", new Object[0]);
    }

    static /* synthetic */ ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static /* synthetic */ List a(as asVar, List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AssetPackState next = AssetPackStates.a((Bundle) list.get(i), asVar.d).packStates().values().iterator().next();
            if (next == null) {
                f3638a.b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (dd.a(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void a(int i, String str, int i2) {
        if (this.e != null) {
            f3638a.c("notifyModuleCompleted", new Object[0]);
            i iVar = new i();
            this.e.a(new ah(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new by("The Play Store app is not installed or is an unofficial version.", i);
    }

    static /* synthetic */ Bundle b(Map map) {
        Bundle e2 = e();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        e2.putParcelableArrayList("installed_asset_module", arrayList);
        return e2;
    }

    /* access modifiers changed from: private */
    public static Bundle c(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static Bundle c(int i, String str) {
        Bundle c2 = c(i);
        c2.putString("module_name", str);
        return c2;
    }

    static /* synthetic */ Bundle c(int i, String str, String str2, int i2) {
        Bundle c2 = c(i, str);
        c2.putString("slice_id", str2);
        c2.putInt("chunk_number", i2);
        return c2;
    }

    private static <T> Task<T> d() {
        f3638a.b("onError(%d)", -11);
        return Tasks.a((Exception) new AssetPackException(-11));
    }

    /* access modifiers changed from: private */
    public static Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10703);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    public final Task<AssetPackStates> a(List<String> list, ba baVar, Map<String, Long> map) {
        if (this.e == null) {
            return d();
        }
        f3638a.c("getPackStates(%s)", list);
        i iVar = new i();
        this.e.a(new af(this, iVar, list, map, iVar, baVar));
        return iVar.a();
    }

    public final Task<AssetPackStates> a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.e == null) {
            return d();
        }
        f3638a.c("startDownload(%s)", list2);
        i iVar = new i();
        this.e.a(new ac(this, iVar, list2, map, iVar, list));
        iVar.a().addOnSuccessListener(new aa(this));
        return iVar.a();
    }

    public final Task<List<String>> a(Map<String, Long> map) {
        if (this.e == null) {
            return d();
        }
        f3638a.c("syncPacks", new Object[0]);
        i iVar = new i();
        this.e.a(new ae(this, iVar, map, iVar));
        return iVar.a();
    }

    public final synchronized void a() {
        if (this.f != null) {
            f3638a.c("keepAlive", new Object[0]);
            if (!this.g.compareAndSet(false, true)) {
                f3638a.c("Service is already kept alive.", new Object[0]);
                return;
            }
            i iVar = new i();
            this.f.a(new ak(this, iVar, iVar));
            return;
        }
        f3638a.d("Keep alive connection manager is not initialized.", new Object[0]);
    }

    public final void a(int i) {
        if (this.e != null) {
            f3638a.c("notifySessionFailed", new Object[0]);
            i iVar = new i();
            this.e.a(new ai(this, iVar, i, iVar));
            return;
        }
        throw new by("The Play Store app is not installed or is an unofficial version.", i);
    }

    public final void a(int i, String str) {
        a(i, str, 10);
    }

    public final void a(int i, String str, String str2, int i2) {
        if (this.e != null) {
            f3638a.c("notifyChunkTransferred", new Object[0]);
            i iVar = new i();
            this.e.a(new ag(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new by("The Play Store app is not installed or is an unofficial version.", i);
    }

    public final void a(String str) {
        if (this.e != null) {
            f3638a.c("removePack(%s)", str);
            i iVar = new i();
            this.e.a(new ab(this, iVar, str, iVar));
        }
    }

    public final void a(List<String> list) {
        if (this.e != null) {
            f3638a.c("cancelDownloads(%s)", list);
            i iVar = new i();
            this.e.a(new ad(this, iVar, list, iVar));
        }
    }

    public final Task<ParcelFileDescriptor> b(int i, String str, String str2, int i2) {
        if (this.e == null) {
            return d();
        }
        f3638a.c("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        i iVar = new i();
        this.e.a(new aj(this, iVar, i, str, str2, i2, iVar));
        return iVar.a();
    }
}
