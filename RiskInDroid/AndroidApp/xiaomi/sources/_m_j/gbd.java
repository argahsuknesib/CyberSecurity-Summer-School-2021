package _m_j;

import android.os.Handler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;

public final class gbd {

    /* renamed from: O000000o  reason: collision with root package name */
    public ReactContext f17491O000000o;
    public FpsDebugFrameCallback O00000Oo;
    public Handler O00000o;
    public O000000o O00000o0;
    public int O00000oO = 0;
    public double O00000oo = 0.0d;
    private boolean O0000O0o = false;

    public gbd(ReactContext reactContext) {
        this.f17491O000000o = reactContext;
        this.O00000o = new Handler(gbe.O000000o().O00000o0());
        this.O00000Oo = new FpsDebugFrameCallback(this.f17491O000000o);
        this.O00000o0 = new O000000o(this, (byte) 0);
    }

    public final void O000000o() {
        if (!this.O0000O0o) {
            this.O00000oO = 0;
            this.O00000oo = 0.0d;
            this.O0000O0o = true;
            this.O00000Oo.reset();
            this.O00000Oo.start();
            this.O00000o0.O000000o();
        }
    }

    public final void O00000Oo() {
        if (this.O0000O0o) {
            O00000o0();
            this.O00000Oo.stop();
            this.O00000o0.f17492O000000o = true;
            this.O0000O0o = false;
        }
    }

    public final void O00000o0() {
        double fps = this.O00000Oo.getFPS();
        if (fps > 10.0d) {
            this.O00000oO++;
            this.O00000oo += fps;
            gbu.O000000o("RnFpsInfoSubscriber fps=" + fps + "  mGetFpsCount=" + this.O00000oO + "  getNumFrames=" + this.O00000Oo.getNumFrames());
        }
        this.O00000Oo.reset();
    }

    class O000000o implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f17492O000000o;

        private O000000o() {
            this.f17492O000000o = false;
        }

        /* synthetic */ O000000o(gbd gbd, byte b) {
            this();
        }

        public final void run() {
            if (!this.f17492O000000o) {
                gbd.this.O00000o0();
                gbd.this.O00000o.postDelayed(this, 10000);
            }
        }

        public final void O000000o() {
            this.f17492O000000o = false;
            gbd.this.O00000o.post(this);
        }
    }
}
