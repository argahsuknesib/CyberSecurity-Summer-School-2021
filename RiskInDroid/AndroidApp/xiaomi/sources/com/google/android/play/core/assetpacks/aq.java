package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;

final class aq extends al<AssetPackStates> {
    private final cb c;
    private final ba d;

    aq(as asVar, i<AssetPackStates> iVar, cb cbVar, ba baVar) {
        super(asVar, iVar);
        this.c = cbVar;
        this.d = baVar;
    }

    public final void c(Bundle bundle, Bundle bundle2) {
        super.c(bundle, bundle2);
        this.f3637a.b(AssetPackStates.a(bundle, this.c, this.d));
    }
}
