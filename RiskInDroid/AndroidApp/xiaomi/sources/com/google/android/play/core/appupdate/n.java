package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

final class n extends AppUpdateOptions.Builder {

    /* renamed from: a  reason: collision with root package name */
    private Integer f3620a;
    private Boolean b;

    n() {
    }

    public final AppUpdateOptions build() {
        String str = "";
        if (this.f3620a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new o(this.f3620a.intValue(), this.b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() == 0 ? new String("Missing required properties:") : "Missing required properties:".concat(valueOf));
    }

    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.f3620a = Integer.valueOf(i);
        return this;
    }
}
