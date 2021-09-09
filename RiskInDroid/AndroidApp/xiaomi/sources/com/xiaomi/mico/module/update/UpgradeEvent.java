package com.xiaomi.mico.module.update;

import com.xiaomi.mico.module.update.UpdatePresenter;

public class UpgradeEvent {
    private final UpdatePresenter.UpdateInfo mUpdateInfo;

    public UpdatePresenter.UpdateInfo getUpdateInfo() {
        return this.mUpdateInfo;
    }

    public UpgradeEvent(UpdatePresenter.UpdateInfo updateInfo) {
        this.mUpdateInfo = updateInfo;
    }
}
