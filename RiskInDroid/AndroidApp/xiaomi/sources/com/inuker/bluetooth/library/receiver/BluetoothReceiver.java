package com.inuker.bluetooth.library.receiver;

import _m_j.bjz;
import _m_j.bka;
import _m_j.bkb;
import _m_j.bkc;
import _m_j.bkd;
import _m_j.bke;
import _m_j.bkf;
import _m_j.bkm;
import _m_j.bky;
import _m_j.bkz;
import _m_j.blb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BluetoothReceiver extends BroadcastReceiver implements bke, Handler.Callback {
    private static bke O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, List<bkm>> f4492O000000o = new HashMap();
    private bkf O00000o = new bkf() {
        /* class com.inuker.bluetooth.library.receiver.BluetoothReceiver.AnonymousClass1 */

        public final List<bkm> O000000o(Class<?> cls) {
            return BluetoothReceiver.this.f4492O000000o.get(cls.getSimpleName());
        }
    };
    private Handler O00000o0 = new Handler(Looper.getMainLooper(), this);
    private bjz[] O00000oO = {bkd.O000000o(this.O00000o), bkc.O000000o(this.O00000o), bkb.O000000o(this.O00000o), bka.O000000o(this.O00000o)};

    public static bke O000000o() {
        if (O00000Oo == null) {
            synchronized (BluetoothReceiver.class) {
                if (O00000Oo == null) {
                    O00000Oo = new BluetoothReceiver();
                }
            }
        }
        return O00000Oo;
    }

    private BluetoothReceiver() {
        bkz.O000000o(this, O00000Oo());
    }

    private IntentFilter O00000Oo() {
        IntentFilter intentFilter = new IntentFilter();
        for (bjz O000000o2 : this.O00000oO) {
            for (String addAction : O000000o2.O000000o()) {
                intentFilter.addAction(addAction);
            }
        }
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                bky.O00000Oo(String.format("BluetoothReceiver onReceive: %s", action));
                for (bjz bjz : this.O00000oO) {
                    List<String> O000000o2 = bjz.O000000o();
                    if (blb.O000000o(O000000o2) || TextUtils.isEmpty(action)) {
                        z = false;
                    } else {
                        z = O000000o2.contains(action);
                    }
                    if (z) {
                        bjz.O000000o(intent);
                        return;
                    }
                }
            }
        }
    }

    public final void O000000o(bkm bkm) {
        this.O00000o0.obtainMessage(1, bkm).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        bkm bkm;
        if (message.what == 1 && (bkm = (bkm) message.obj) != null) {
            List list = this.f4492O000000o.get(bkm.O00000Oo());
            if (list == null) {
                list = new LinkedList();
                this.f4492O000000o.put(bkm.O00000Oo(), list);
            }
            list.add(bkm);
        }
        return true;
    }
}
