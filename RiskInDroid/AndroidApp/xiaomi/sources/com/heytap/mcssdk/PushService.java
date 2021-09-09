package com.heytap.mcssdk;

import _m_j.azj;
import _m_j.azk;
import _m_j.azu;
import _m_j.azx;
import _m_j.azy;
import _m_j.bab;
import _m_j.bae;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class PushService extends Service implements azu {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        azk.O000000o(getApplicationContext(), intent, this);
        return super.onStartCommand(intent, i, i2);
    }

    public void processMessage(Context context, azx azx) {
    }

    public void processMessage(Context context, bab bab) {
    }

    public void processMessage(Context context, azy azy) {
        bae.O000000o("mcssdk-processMessage:" + azy.O00000o);
        azk.O000000o(getApplicationContext(), azy, azj.O000000o());
    }
}
