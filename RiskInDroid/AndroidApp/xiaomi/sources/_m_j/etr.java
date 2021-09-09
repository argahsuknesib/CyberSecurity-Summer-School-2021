package _m_j;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

public final class etr implements Camera.AutoFocusCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15804O000000o = "etr";
    private static final Collection<String> O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private final boolean O00000oO;
    private final Camera O00000oo;
    private AsyncTask<?, ?, ?> O0000O0o;

    static {
        ArrayList arrayList = new ArrayList(2);
        O00000Oo = arrayList;
        arrayList.add("auto");
        O00000Oo.add("macro");
    }

    public etr(Camera camera) {
        this.O00000oo = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.O00000oO = O00000Oo.contains(focusMode);
        String str = f15804O000000o;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + this.O00000oO);
        O000000o();
    }

    public final synchronized void onAutoFocus(boolean z, Camera camera) {
        this.O00000o = false;
        O00000o0();
    }

    private synchronized void O00000o0() {
        if (!this.O00000o0 && this.O0000O0o == null) {
            O000000o o000000o = new O000000o(this, (byte) 0);
            try {
                o000000o.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.O0000O0o = o000000o;
            } catch (RejectedExecutionException e) {
                Log.w(f15804O000000o, "Could not request auto focus", e);
            }
        }
    }

    public final synchronized void O000000o() {
        if (this.O00000oO) {
            this.O0000O0o = null;
            if (!this.O00000o0 && !this.O00000o) {
                try {
                    this.O00000oo.autoFocus(this);
                    this.O00000o = true;
                } catch (RuntimeException e) {
                    Log.w(f15804O000000o, "Unexpected exception while focusing", e);
                    O00000o0();
                }
            }
        }
    }

    private synchronized void O00000o() {
        if (this.O0000O0o != null) {
            if (this.O0000O0o.getStatus() != AsyncTask.Status.FINISHED) {
                this.O0000O0o.cancel(true);
            }
            this.O0000O0o = null;
        }
    }

    public final synchronized void O00000Oo() {
        this.O00000o0 = true;
        if (this.O00000oO) {
            O00000o();
            try {
                this.O00000oo.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(f15804O000000o, "Unexpected exception while cancelling focusing", e);
            }
        }
    }

    final class O000000o extends AsyncTask<Object, Object, Object> {
        private O000000o() {
        }

        /* synthetic */ O000000o(etr etr, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException unused) {
            }
            etr.this.O000000o();
            return null;
        }
    }
}
