package com.xiaomi.smarthome.framework.bluetooth;

import _m_j.ezv;
import _m_j.fpd;
import _m_j.fpe;
import _m_j.fpf;
import _m_j.fpg;
import _m_j.gnl;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;

public class BluetoothReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    public static BluetoothReceiver f7550O000000o;
    private static final fpg[] O00000Oo = {fpd.O00000Oo(), fpe.O00000Oo(), fpf.O00000Oo()};
    private static Handler O00000o0 = new Handler(Looper.getMainLooper());

    public static IntentFilter O000000o() {
        IntentFilter intentFilter = new IntentFilter();
        for (fpg O000000o2 : O00000Oo) {
            for (String addAction : O000000o2.O000000o()) {
                intentFilter.addAction(addAction);
            }
        }
        return intentFilter;
    }

    public static void O00000Oo() {
        O00000o0.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.framework.bluetooth.BluetoothReceiver.AnonymousClass1 */

            public final void run() {
                if (BluetoothReceiver.f7550O000000o == null) {
                    BluetoothReceiver bluetoothReceiver = new BluetoothReceiver();
                    BluetoothReceiver.f7550O000000o = bluetoothReceiver;
                    gnl.O000000o(bluetoothReceiver, BluetoothReceiver.O000000o());
                }
            }
        }, 1000);
    }

    public static void O00000o0() {
        O00000o0.removeCallbacksAndMessages(null);
        BluetoothReceiver bluetoothReceiver = f7550O000000o;
        if (bluetoothReceiver != null) {
            gnl.O000000o(bluetoothReceiver);
            f7550O000000o = null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (CommonApplication.isApplicationStart()) {
            O000000o(context, intent);
        } else if (!ezv.O000000o(CommonApplication.getAppContext()) && ezv.O00000Oo(CommonApplication.getAppContext())) {
            O000000o(context, intent);
        }
    }

    private static void O000000o(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                fpg[] fpgArr = O00000Oo;
                int length = fpgArr.length;
                int i = 0;
                while (i < length) {
                    fpg fpg = fpgArr[i];
                    if (!fpg.O000000o().contains(action) || !fpg.O000000o(context, intent)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
