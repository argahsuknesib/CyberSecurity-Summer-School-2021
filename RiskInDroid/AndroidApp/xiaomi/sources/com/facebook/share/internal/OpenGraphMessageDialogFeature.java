package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphMessageDialogFeature implements DialogFeature {
    OG_MESSAGE_DIALOG(20140204);
    
    private int minVersion;

    public final String getAction() {
        return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    }

    private OpenGraphMessageDialogFeature(int i) {
        this.minVersion = i;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
