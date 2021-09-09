package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;
import java.util.List;

final class ar extends al<AssetPackStates> {
    private final List<String> c;
    private final cb d;

    ar(as asVar, i<AssetPackStates> iVar, cb cbVar, List<String> list) {
        super(asVar, iVar);
        this.d = cbVar;
        this.c = list;
    }

    public final void a(int i, Bundle bundle) {
        super.a(i, bundle);
        this.f3637a.b(AssetPackStates.a(bundle, this.d, this.c));
    }
}
