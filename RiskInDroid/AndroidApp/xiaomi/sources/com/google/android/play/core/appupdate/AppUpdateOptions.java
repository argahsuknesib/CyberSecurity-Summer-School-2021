package com.google.android.play.core.appupdate;

import com.google.android.play.core.install.model.AppUpdateType;

public abstract class AppUpdateOptions {

    public static abstract class Builder {
        public abstract AppUpdateOptions build();

        public abstract Builder setAllowAssetPackDeletion(boolean z);

        public abstract Builder setAppUpdateType(@AppUpdateType int i);
    }

    public static AppUpdateOptions defaultOptions(@AppUpdateType int i) {
        return newBuilder(i).build();
    }

    public static Builder newBuilder(@AppUpdateType int i) {
        n nVar = new n();
        nVar.setAppUpdateType(i);
        nVar.setAllowAssetPackDeletion(false);
        return nVar;
    }

    public abstract boolean allowAssetPackDeletion();

    @AppUpdateType
    public abstract int appUpdateType();
}
