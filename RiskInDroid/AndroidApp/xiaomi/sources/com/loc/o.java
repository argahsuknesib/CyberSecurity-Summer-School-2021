package com.loc;

import _m_j.bvy;
import _m_j.bvz;
import _m_j.bwf;
import _m_j.bwi;
import _m_j.bwt;
import _m_j.bwu;
import _m_j.bww;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.amap.api.location.APSServiceBase;
import com.loc.n;

public final class o implements APSServiceBase {

    /* renamed from: O000000o  reason: collision with root package name */
    n f4544O000000o = null;
    Context O00000Oo = null;
    Messenger O00000o0 = null;

    public o(Context context) {
        this.O00000Oo = context.getApplicationContext();
        this.f4544O000000o = new n(this.O00000Oo);
    }

    public final IBinder onBind(Intent intent) {
        n nVar = this.f4544O000000o;
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            bwu.O000000o(nVar.O00000oO, stringExtra);
        }
        nVar.f4540O000000o = intent.getStringExtra("b");
        bwt.O000000o(nVar.f4540O000000o);
        String stringExtra2 = intent.getStringExtra("d");
        if (!TextUtils.isEmpty(stringExtra2)) {
            bww.O000000o(stringExtra2);
        }
        bvy.f13325O000000o = intent.getBooleanExtra("f", true);
        n nVar2 = this.f4544O000000o;
        if ("true".equals(intent.getStringExtra("as")) && nVar2.O00000o != null) {
            nVar2.O00000o.sendEmptyMessageDelayed(9, 100);
        }
        this.O00000o0 = new Messenger(this.f4544O000000o.O00000o);
        return this.O00000o0.getBinder();
    }

    public final void onCreate() {
        try {
            n.O00000o0();
            this.f4544O000000o.O0000Oo = bwi.O00000o0();
            this.f4544O000000o.O0000OoO = bwi.O00000Oo();
            n nVar = this.f4544O000000o;
            nVar.O0000Oo0 = new bwf();
            nVar.O00000Oo = new n.O00000Oo("amapLocCoreThread");
            nVar.O00000Oo.setPriority(5);
            nVar.O00000Oo.start();
            nVar.O00000o = new n.O000000o(nVar.O00000Oo.getLooper());
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void onDestroy() {
        try {
            if (this.f4544O000000o != null) {
                this.f4544O000000o.O00000o.sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "ApsServiceCore", "onDestroy");
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return 0;
    }
}
