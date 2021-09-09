package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

public final class etb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f15786O000000o = "etb";
    public final Activity O00000Oo;
    private boolean O00000o = false;
    private final BroadcastReceiver O00000o0 = new O00000Oo(this, (byte) 0);
    private AsyncTask<Object, Object, Object> O00000oO;

    public etb(Activity activity) {
        this.O00000Oo = activity;
        O000000o();
    }

    public final synchronized void O000000o() {
        O00000o();
        this.O00000oO = new O000000o(this, (byte) 0);
        this.O00000oO.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public final synchronized void O00000Oo() {
        O00000o();
        if (this.O00000o) {
            this.O00000Oo.unregisterReceiver(this.O00000o0);
            this.O00000o = false;
            return;
        }
        gsy.O000000o(5, f15786O000000o, "PowerStatusReceiver was never registered?");
    }

    public final synchronized void O00000o0() {
        if (this.O00000o) {
            gsy.O000000o(5, f15786O000000o, "PowerStatusReceiver was already registered?");
        } else {
            this.O00000Oo.registerReceiver(this.O00000o0, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.O00000o = true;
        }
        O000000o();
    }

    public final synchronized void O00000o() {
        AsyncTask<Object, Object, Object> asyncTask = this.O00000oO;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.O00000oO = null;
        }
    }

    final class O00000Oo extends BroadcastReceiver {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(etb etb, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    etb.this.O000000o();
                } else {
                    etb.this.O00000o();
                }
            }
        }
    }

    final class O000000o extends AsyncTask<Object, Object, Object> {
        private O000000o() {
        }

        /* synthetic */ O000000o(etb etb, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000);
                gsy.O000000o(4, etb.f15786O000000o, "Finishing activity due to inactivity");
                etb.this.O00000Oo.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }
}
