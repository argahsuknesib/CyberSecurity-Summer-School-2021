package com.xiaomi.miplay.audioclient.sdk;

import android.content.Context;
import android.os.RemoteException;

public class MiPlayClient {

    /* renamed from: O000000o  reason: collision with root package name */
    public MiracastClient f6040O000000o;

    public MiPlayClient(Context context) {
        this.f6040O000000o = new MiracastClient(context);
    }

    public final void O000000o() {
        MiracastClient miracastClient = this.f6040O000000o;
        if (miracastClient.O00000o0 != null) {
            try {
                miracastClient.O00000o0.stopDiscovery();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final int O000000o(String[] strArr) {
        return this.f6040O000000o.O00000oo(strArr);
    }
}
