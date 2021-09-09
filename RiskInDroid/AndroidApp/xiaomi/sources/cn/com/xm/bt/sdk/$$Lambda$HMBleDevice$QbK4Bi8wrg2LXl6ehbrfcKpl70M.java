package cn.com.xm.bt.sdk;

import cn.com.xm.bt.a.a;
import cn.com.xm.bt.profile.nfc.HMNFCStatus;
import cn.com.xm.bt.profile.nfc.d;

/* renamed from: cn.com.xm.bt.sdk.-$$Lambda$HMBleDevice$QbK4Bi8wrg2LXl6ehbrfcKpl70M  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$HMBleDevice$QbK4Bi8wrg2LXl6ehbrfcKpl70M implements d {
    public static final /* synthetic */ $$Lambda$HMBleDevice$QbK4Bi8wrg2LXl6ehbrfcKpl70M INSTANCE = new $$Lambda$HMBleDevice$QbK4Bi8wrg2LXl6ehbrfcKpl70M();

    private /* synthetic */ $$Lambda$HMBleDevice$QbK4Bi8wrg2LXl6ehbrfcKpl70M() {
    }

    public final void onStatusChanged(HMNFCStatus hMNFCStatus) {
        a.a("HMBleDevice", "status:".concat(String.valueOf(hMNFCStatus)));
    }
}
