package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum ShareDialogFeature implements DialogFeature {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);
    
    private int minVersion;

    public final String getAction() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    private ShareDialogFeature(int i) {
        this.minVersion = i;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }
}
