package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.camera.XmVideoViewGl;

public final class cjb extends cix {
    protected XmVideoViewGl O00000o;
    public cqg O00000oO;

    public cjb(Context context, dty dty, cia cia) {
        super(context, dty, cia);
    }

    public final void O000000o() {
        super.O000000o();
        this.O00000Oo.O000000o(new cjf() {
            /* class _m_j.cjb.AnonymousClass1 */

            public final void O000000o(VideoFrame videoFrame) {
                if (cjb.this.O00000o != null) {
                    cjb.this.O00000o.drawVideoFrame(videoFrame);
                }
            }

            public final void O000000o(byte[] bArr, int i, int i2) {
                if (cjb.this.O00000oO != null) {
                    cjb.this.O00000oO.O000000o(bArr, (long) i, i2);
                }
            }
        });
        this.O00000oO = this.O00000Oo.O000000o();
    }

    public final void O000000o(cjh cjh) {
        if (cjh instanceof cjc) {
            this.O00000o = ((cjc) cjh).f13936O000000o;
            XmVideoViewGl xmVideoViewGl = this.O00000o;
            if (xmVideoViewGl != null) {
                xmVideoViewGl.setDid(this.O00000o0.getDid());
            }
        }
    }

    public final void O0000OOo() {
        super.O0000OOo();
        goq.O000000o(new Runnable() {
            /* class _m_j.$$Lambda$cjb$UHXM21ee_isc5T9AcGb1NgNcYBg */

            public final void run() {
                cjb.this.O0000oo0();
            }
        });
    }

    public final void O000000o(boolean z) {
        super.O000000o(z);
        XmVideoViewGl xmVideoViewGl = this.O00000o;
        if (xmVideoViewGl != null) {
            xmVideoViewGl.release();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000oo0() {
        try {
            if (this.O00000o != null) {
                this.O00000o.clearQueue();
            }
            if (this.O00000oO != null) {
                this.O00000oO.O0000O0o();
            }
        } catch (NullPointerException e) {
            cki.O00000o("SimpleCameraPlayer", "NullPointerException clearQueue:%s", e.getLocalizedMessage());
        }
    }

    public final void O00000o0(boolean z) {
        super.O00000o0(z);
        cqg cqg = this.O00000oO;
        if (cqg == null) {
            return;
        }
        if (z) {
            cqg.O0000O0o();
            this.O00000oO.O00000Oo();
            return;
        }
        cqg.O00000o0();
        this.O00000oO.O000000o();
    }
}
