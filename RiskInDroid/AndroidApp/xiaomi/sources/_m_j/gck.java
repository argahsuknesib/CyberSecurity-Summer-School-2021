package _m_j;

import com.xiaomi.smarthome.mjbuffer.MjBuffer;

public final class gck extends gch {
    private boolean O0000Oo;
    private ckc O0000Oo0;

    public gck(cid cid, boolean z) {
        super(cid, z);
        cki.O00000o("RNIjkCameraPlayer", "create:" + cid.getDid());
        O0000o0O();
    }

    public final void O000000o() {
        cki.O00000o("RNIjkCameraPlayer", "startAudioPlay");
        if (this.O0000Oo0 != null) {
            this.O00000o = false;
            if (this.O0000OOo) {
                this.O00000o0.O000000o();
            } else {
                this.O0000Oo0.O000000o(1.0f);
            }
        }
    }

    public final void O00000Oo() {
        cki.O00000o("RNIjkCameraPlayer", "stopAudioPlay");
        if (this.O0000Oo0 != null) {
            this.O00000o = true;
            if (this.O0000OOo) {
                this.O00000o0.O00000oo();
            } else {
                this.O0000Oo0.O000000o(0.0f);
            }
        }
    }

    public final void O000000o(ckc ckc) {
        cki.O00000o0("RNIjkCameraPlayer", "FIRST_RENDER:startPlayer stop:%b", Boolean.valueOf(this.O0000Oo));
        if (this.O0000Oo) {
            O0000o0O();
            this.O0000Oo = false;
        }
        MjBuffer.enableGet(this.f17525O000000o.getDid(), 20, 10);
        this.O0000Oo0 = ckc;
        this.O0000Oo0.O000000o(this.O00000o ? 0.0f : 1.0f);
        ckc ckc2 = this.O0000Oo0;
        if (ckc2 != null) {
            ckc2.O0000Oo0();
        }
    }

    public final void O00000Oo(ckc ckc) {
        cki.O00000o("RNIjkCameraPlayer", "stopPlayer");
        if (ckc != null) {
            ckc.O0000OOo();
        }
        if (this.O0000Oo0 == ckc) {
            this.O0000Oo0 = null;
        }
        O0000o0();
    }

    public final void O0000o0() {
        this.O0000Oo = true;
        MjBuffer.clear(this.f17525O000000o.getDid());
    }

    private void O0000o0O() {
        MjBuffer.init(gfr.O0000OOo || gfr.O0000o0o, this.f17525O000000o.getDid());
    }

    public final void O000000o(int i, int i2, int i3, int i4) {
        super.O000000o(i, i2, i3, i4);
        if (!this.O00000o) {
            this.O0000Oo0.O000000o(0.0f);
            if (this.O00000o0 != null) {
                this.O00000o0.O000000o();
            }
        }
    }

    public final void O00000o0() {
        if (this.O00000o0 != null) {
            this.O00000o0.O00000oo();
        }
        super.O00000o0();
        ckc ckc = this.O0000Oo0;
        if (ckc != null) {
            ckc.O000000o(this.O00000o ? 0.0f : 1.0f);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i, short s, short s2, int i2, long j) {
        if (this.O0000OOo && this.O00000o0 != null) {
            this.O00000o0.O000000o(bArr, j, i2, i, s, s2);
        }
    }
}
