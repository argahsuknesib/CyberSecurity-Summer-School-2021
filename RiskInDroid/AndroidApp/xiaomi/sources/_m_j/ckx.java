package _m_j;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

public abstract class ckx {

    /* renamed from: O000000o  reason: collision with root package name */
    protected volatile boolean f13974O000000o = false;
    protected volatile boolean O00000Oo = false;
    public dty O00000o;
    protected int O00000o0 = 2000;
    protected Handler O00000oO = new Handler(Looper.getMainLooper()) {
        /* class _m_j.ckx.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                gsy.O00000Oo("SdCard", "SYNC_DATA");
                ckx ckx = ckx.this;
                ckx.O00000Oo(ckx.O00000oo);
                ckx.this.O00000oO.removeMessages(1);
                if (ckx.this.O00000o0 >= 0) {
                    ckx.this.O00000oO.sendEmptyMessageDelayed(1, (long) ckx.this.O00000o0);
                }
            } else if (i == 2) {
                gsy.O000000o(6, "SdCard", "time out");
                ckx.this.O000000o(-2, "TIME_OUT_FAILED");
                if (ckx.this.O00000o0 >= 0) {
                    ckx.this.O00000oO.sendEmptyMessageDelayed(1, (long) ckx.this.O00000o0);
                }
            }
        }
    };
    public Callback<Void> O00000oo = new Callback<Void>() {
        /* class _m_j.ckx.AnonymousClass2 */

        public final void onFailure(int i, String str) {
            gsy.O000000o(6, "SdCard", "syncCallback:" + i + " errorInfo:" + str);
            ckx.this.O00000o0 = 2000;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            gsy.O00000Oo("SdCard", "syncCallback");
            ckx.this.O00000o0 = 40000;
        }
    };
    private ft O0000O0o;

    /* access modifiers changed from: protected */
    public abstract void O000000o(Callback<Void> callback);

    public abstract String O00000oO();

    public ckx(dty dty) {
        this.O00000o = dty;
        this.O0000O0o = ft.O000000o(XmPluginHostApi.instance().context());
    }

    public void O000000o() {
        gsy.O00000Oo("SdCard", new StringBuilder("startSync:40000").toString());
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(2);
        this.O00000o0 = 40000;
        this.O00000Oo = false;
        this.O00000oO.sendEmptyMessageDelayed(1, (long) this.O00000o0);
    }

    public void O00000Oo() {
        gsy.O00000Oo("SdCard", "stopSync");
        this.O00000o0 = -1;
        this.O00000Oo = false;
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(2);
    }

    public final synchronized void O00000Oo(Callback<Void> callback) {
        gsy.O00000Oo("SdCard", "syncData");
        if (this.O00000Oo) {
            gsy.O000000o(6, "SdCard", "mIsDataSyncing");
            return;
        }
        boolean z = this.f13974O000000o;
        this.O00000oO.removeMessages(2);
        this.O00000oO.sendEmptyMessageDelayed(2, 20000);
        this.O00000Oo = true;
        gsy.O00000Oo("SdCard", "doSyncData");
        O000000o(callback);
    }

    public final void O00000o0() {
        this.O0000O0o.O000000o(new Intent(O00000oO()));
    }

    public final synchronized void O00000o() {
        gsy.O00000Oo("SdCard", "notify success");
        this.O00000oO.removeMessages(2);
        this.f13974O000000o = true;
        this.O00000Oo = false;
        this.O00000o0 = 40000;
        O00000o0();
    }

    public final synchronized void O000000o(int i, String str) {
        cki.O00000o0("BaseFileLoadManager", "notifyFailed:" + i + " info:" + str);
        this.O00000oO.removeMessages(2);
        this.O00000o0 = 2000;
        this.O00000Oo = false;
    }
}
