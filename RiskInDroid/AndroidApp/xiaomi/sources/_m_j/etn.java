package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;

public final class etn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f15800O000000o = "etn";
    public final Activity O00000Oo;
    private boolean O00000o = false;
    private final BroadcastReceiver O00000o0 = new O00000Oo(this, (byte) 0);
    private AsyncTask<Object, Object, Object> O00000oO;

    public etn(Activity activity) {
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
        Log.w(f15800O000000o, "PowerStatusReceiver was never registered?");
    }

    public final synchronized void O00000o0() {
        if (this.O00000o) {
            Log.w(f15800O000000o, "PowerStatusReceiver was already registered?");
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

        /* synthetic */ O00000Oo(etn etn, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    etn.this.O000000o();
                } else {
                    etn.this.O00000o();
                }
            }
        }
    }

    final class O000000o extends AsyncTask<Object, Object, Object> {
        private O000000o() {
        }

        /* synthetic */ O000000o(etn etn, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000);
                Log.i(etn.f15800O000000o, "Finishing activity due to inactivity");
                etn.this.O00000Oo.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }
}
