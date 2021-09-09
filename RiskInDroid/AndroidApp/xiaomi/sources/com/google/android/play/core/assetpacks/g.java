package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

final /* synthetic */ class g implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    private final bc f3719a;

    private g(bc bcVar) {
        this.f3719a = bcVar;
    }

    static OnSuccessListener a(bc bcVar) {
        return new g(bcVar);
    }

    public final void onSuccess(Object obj) {
        this.f3719a.a((List) obj);
    }
}
