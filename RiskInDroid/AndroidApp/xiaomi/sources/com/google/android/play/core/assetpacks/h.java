package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

final /* synthetic */ class h implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    static final OnFailureListener f3720a = new h();

    private h() {
    }

    public final void onFailure(Exception exc) {
        j.f3722a.d(String.format("Could not sync active asset packs. %s", exc), new Object[0]);
    }
}
