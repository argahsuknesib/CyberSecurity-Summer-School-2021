package _m_j;

import android.os.Looper;
import android.view.Choreographer;

public final class dyg extends dyo implements Choreographer.FrameCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f15065O000000o = 0;
    public long O00000Oo = 0;
    public boolean O00000o = false;
    public int O00000o0 = 0;
    public int O00000oO = 1;
    public String O00000oo = "";
    private final String O0000Oo0 = "fps";

    public final void O000000o(String str, int i) {
        this.O00000oO = i;
        this.O00000oo = str;
        this.f15065O000000o = this.O00000Oo;
        this.O00000o0 = 0;
        new StringBuilder("beginCal: ").append(this.O00000Oo);
    }

    public final void O000000o() {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.O000000o();
                Choreographer.getInstance().postFrameCallback(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void doFrame(long j) {
        this.O00000o0++;
        this.O00000Oo = j;
        if (this.O00000o) {
            StringBuilder sb = new StringBuilder("doFrame: ");
            sb.append(this.O00000Oo);
            sb.append("  ");
            sb.append(this.f15065O000000o);
            this.f15065O000000o = this.O00000Oo;
            this.O00000o0 = 0;
            this.O00000o = false;
        }
        if (this.f15065O000000o == 0) {
            this.f15065O000000o = this.O00000Oo;
        }
        if (O00000o0()) {
            this.O0000O0o = true;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        this.O0000O0o = false;
    }
}
