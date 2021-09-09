package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.internal.v;
import com.google.android.play.core.internal.y;
import java.util.Arrays;

final class b extends v {

    /* renamed from: a  reason: collision with root package name */
    private final aa f3645a = new aa("AssetPackExtractionService");
    private final Context b;
    private final AssetPackExtractionService c;
    private final bc d;

    b(Context context, AssetPackExtractionService assetPackExtractionService, bc bcVar) {
        this.b = context;
        this.c = assetPackExtractionService;
        this.d = bcVar;
    }

    public final void a(Bundle bundle, y yVar) throws RemoteException {
        String[] packagesForUid;
        this.f3645a.a("updateServiceState AIDL call", new Object[0]);
        if (bt.a(this.b) && (packagesForUid = this.b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) != null && Arrays.asList(packagesForUid).contains("com.android.vending")) {
            yVar.a(this.c.a(bundle), new Bundle());
            return;
        }
        yVar.a(new Bundle());
        this.c.a();
    }

    public final void a(y yVar) throws RemoteException {
        this.d.f();
        yVar.b(new Bundle());
    }
}
