package _m_j;

import android.app.Activity;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public final class O0O0OO {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6664O000000o = 0;
    public Timer O00000Oo;
    public boolean O00000o = false;
    public int O00000o0 = 0;
    public O00000o O00000oO;
    public TextView O00000oo;
    public final Activity O0000O0o;

    public interface O00000o {
        void a();
    }

    public O0O0OO(Activity activity) {
        this.O0000O0o = activity;
    }

    private void O000000o(int i) {
        Activity activity = this.O0000O0o;
        if (activity != null) {
            activity.runOnUiThread(new O00000o0(i));
        }
    }

    public final void O000000o() {
        if (!this.O00000o) {
            O00000o0();
            O000000o(0);
        }
    }

    public final void O00000Oo() {
        this.O00000o = false;
        this.O00000o0 = 0;
        O00000o();
        O000000o(8);
    }

    public final void O00000o() {
        Timer timer = this.O00000Oo;
        if (timer != null) {
            timer.cancel();
            this.O00000Oo = null;
        }
    }

    public final void O00000o0() {
        this.O00000Oo = new Timer();
        this.O00000Oo.scheduleAtFixedRate(new O000000o(), 1000, 1000);
    }

    public class O000000o extends TimerTask {
        public O000000o() {
        }

        public final void run() {
            O0O0OO.this.O00000o0++;
            if (O0O0OO.this.O00000o0 >= O0O0OO.this.f6664O000000o) {
                if (O0O0OO.this.O00000Oo != null) {
                    O0O0OO.this.O00000Oo.cancel();
                }
                if (O0O0OO.this.O00000oO != null) {
                    O0O0OO.this.O00000oO.a();
                }
            }
            String valueOf = String.valueOf(O0O0OO.this.f6664O000000o - O0O0OO.this.O00000o0);
            O0O0OO o0o0oo = O0O0OO.this;
            if (o0o0oo.O00000oo != null) {
                o0o0oo.O0000O0o.runOnUiThread(new O00000Oo(valueOf));
            }
        }
    }

    public class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ String f6666O000000o;

        public O00000Oo(String str) {
            this.f6666O000000o = str;
        }

        public final void run() {
            O0O0OO.this.O00000oo.setText(this.f6666O000000o);
        }
    }

    public class O00000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ int f6667O000000o;

        public O00000o0(int i) {
            this.f6667O000000o = i;
        }

        public final void run() {
            if (O0O0OO.this.O00000oo != null) {
                O0O0OO.this.O00000oo.setText("");
                O0O0OO.this.O00000oo.setVisibility(this.f6667O000000o);
            }
        }
    }
}
