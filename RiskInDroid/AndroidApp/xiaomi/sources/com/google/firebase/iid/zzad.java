package com.google.firebase.iid;

import android.os.Bundle;

final class zzad extends zzab<Bundle> {
    zzad(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        finish(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw() {
        return false;
    }
}
