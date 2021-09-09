package _m_j;

import com.xiaomi.smarthome.camera.VideoFrame;

public abstract class gtp {
    protected O00000Oo O00000Oo = new O00000Oo("receiver_thread", this);
    protected O000000o O00000o0;

    public interface O000000o {
        void O000000o(String str, VideoFrame videoFrame);
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public abstract void O00000Oo();

    /* access modifiers changed from: protected */
    public abstract void O00000o();

    /* access modifiers changed from: protected */
    public abstract void O00000o0();

    public static class O00000Oo extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        protected volatile boolean f18267O000000o = false;
        private gtp O00000Oo;

        public O00000Oo(String str, gtp gtp) {
            super(str);
            setPriority(1);
            this.O00000Oo = gtp;
        }

        public final void run() {
            this.O00000Oo.O000000o();
            while (this.f18267O000000o) {
                this.O00000Oo.O00000Oo();
            }
            this.O00000Oo.O00000o0();
        }

        public final synchronized void start() {
            if (!this.f18267O000000o) {
                this.f18267O000000o = true;
                super.start();
            }
        }

        public final synchronized void O000000o() {
            if (this.f18267O000000o) {
                this.f18267O000000o = false;
                this.O00000Oo.O00000o();
            }
        }

        public final boolean O00000Oo() {
            return this.f18267O000000o;
        }
    }

    public final void O000000o(O000000o o000000o) {
        this.O00000o0 = o000000o;
    }

    public final void O00000oO() {
        if (!this.O00000Oo.O00000Oo()) {
            this.O00000Oo.start();
        }
    }

    public final void O00000oo() {
        this.O00000Oo.O000000o();
    }
}
