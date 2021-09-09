package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.splitinstall.z;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

final class j implements AssetPackManager {

    /* renamed from: a  reason: collision with root package name */
    private static final aa f3722a = new aa("AssetPackManager");
    private final bc b;
    private final ce<x> c;
    private final ax d;
    private final z e;
    private final cr f;
    private final cb g;
    /* access modifiers changed from: private */
    public final bq h;
    private final ce<Executor> i;
    private final Handler j = new Handler(Looper.getMainLooper());
    private boolean k;

    j(bc bcVar, ce<x> ceVar, ax axVar, z zVar, cr crVar, cb cbVar, bq bqVar, ce<Executor> ceVar2) {
        this.b = bcVar;
        this.c = ceVar;
        this.d = axVar;
        this.e = zVar;
        this.f = crVar;
        this.g = cbVar;
        this.h = bqVar;
        this.i = ceVar2;
    }

    private final void c() {
        this.i.a().execute(new e(this));
    }

    private final void d() {
        this.i.a().execute(new f(this));
        this.k = true;
    }

    /* access modifiers changed from: package-private */
    @AssetPackStatus
    public final int a(@AssetPackStatus int i2, String str) {
        if (!this.b.a(str) && i2 == 4) {
            return 8;
        }
        if (!this.b.a(str) || i2 == 4) {
            return i2;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        this.b.d();
        this.b.c();
        this.b.e();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str, i iVar) {
        if (this.b.d(str)) {
            iVar.a((Object) null);
            this.c.a().a(str);
            return;
        }
        iVar.a((Exception) new IOException(String.format("Failed to remove pack %s.", str)));
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        boolean b2 = this.d.b();
        this.d.a(z);
        if (z && !b2) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        bc bcVar = this.b;
        bcVar.getClass();
        this.c.a().a(this.b.b()).addOnSuccessListener(this.i.a(), g.a(bcVar)).addOnFailureListener(this.i.a(), h.f3720a);
    }

    public final AssetPackStates cancel(List<String> list) {
        Map<String, Integer> a2 = this.f.a(list);
        HashMap hashMap = new HashMap();
        for (String next : list) {
            Integer num = a2.get(next);
            hashMap.put(next, AssetPackState.a(next, num != null ? num.intValue() : 0, 0, 0, 0, 0.0d));
        }
        this.c.a().a(list);
        return AssetPackStates.a(0, hashMap);
    }

    public final void clearListeners() {
        this.d.a();
    }

    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> b2 = this.b.b();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(b2.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList.isEmpty()) {
            return this.c.a().a(arrayList2, arrayList, b2);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String next : list) {
            bundle.putInt(h.a("status", next), 4);
            bundle.putInt(h.a("error_code", next), 0);
            bundle.putLong(h.a("total_bytes_to_download", next), 0);
            bundle.putLong(h.a("bytes_downloaded", next), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.a(AssetPackStates.a(bundle, this.g));
    }

    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.k) {
            this.i.a().execute(new f(this));
            this.k = true;
        }
        if (this.b.a(str)) {
            try {
                assetPackLocation = this.b.b(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.e.a().contains(str)) {
                assetPackLocation = AssetPackLocation.a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation != null) {
            if (assetPackLocation.packStorageMethod() == 1) {
                return this.b.a(str, str2);
            }
            if (assetPackLocation.packStorageMethod() == 0) {
                return this.b.a(str, str2, assetPackLocation);
            }
            f3722a.a("The asset %s is not present in Asset Pack %s", str2, str);
        }
        return null;
    }

    public final AssetPackLocation getPackLocation(String str) {
        if (!this.k) {
            d();
        }
        if (this.b.a(str)) {
            try {
                return this.b.b(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.e.a().contains(str)) {
            return AssetPackLocation.a();
        } else {
            return null;
        }
    }

    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> a2 = this.b.a();
        HashMap hashMap = new HashMap();
        for (String put : this.e.a()) {
            hashMap.put(put, AssetPackLocation.a());
        }
        a2.putAll(hashMap);
        return a2;
    }

    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.c.a().a(list, new c(this), this.b.b());
    }

    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean b2 = this.d.b();
        this.d.a((StateUpdatedListener) assetPackStateUpdateListener);
        if (!b2) {
            c();
        }
    }

    public final Task<Void> removePack(String str) {
        i iVar = new i();
        this.i.a().execute(new d(this, str, iVar));
        return iVar.a();
    }

    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (this.h.a() == null) {
            return Tasks.a((Exception) new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.h.a());
        i iVar = new i();
        intent.putExtra("result_receiver", new i(this, this.j, iVar));
        activity.startActivity(intent);
        return iVar.a();
    }

    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.d.b(assetPackStateUpdateListener);
    }
}
