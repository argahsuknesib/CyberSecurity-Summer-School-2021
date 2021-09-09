package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum AppInviteDialogFeature implements DialogFeature {
    APP_INVITES_DIALOG(20140701);
    
    private int minVersion;

    public final String getAction() {
        return "com.facebook.platform.action.request.APPINVITES_DIALOG";
    }

    private AppInviteDialogFeature(int i) {
        this.minVersion = i;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
