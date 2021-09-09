package com.miui.tsmclient.util;

import android.content.Context;

public class NfcFeatureImpl implements INfcFeature {
    public boolean isSupportNfc() {
        return true;
    }

    public NfcFeatureImpl(Context context) {
    }
}
