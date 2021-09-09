package _m_j;

import _m_j.cjd;
import android.content.Context;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.VideoFrame;
import com.xiaomi.smarthome.mjbuffer.MjBuffer;
import java.util.Locale;

public final class ciz extends cix {
    public cjh O00000o;
    private ckc O00000oO;
    private String O00000oo;
    private boolean O0000O0o;

    public ciz(Context context, dty dty, cia cia) {
        super(context, dty, cia);
        cki.O00000o0("GeneralCameraPlayer", "create GeneralCameraPlayer");
    }

    public final void O000000o() {
        super.O000000o();
        this.O00000Oo.O000000o(new cjd.O000000o() {
            /* class _m_j.$$Lambda$ciz$SBLkRCjAOvFtXNQMYtYWq4UjFY */

            public final void onLoad() {
                ciz.this.O0000oo();
            }
        });
        this.O00000Oo.O000000o(new cjf() {
            /* class _m_j.ciz.AnonymousClass1 */

            public final void O000000o(byte[] bArr, int i, int i2) {
            }

            public final void O000000o(VideoFrame videoFrame) {
                if (ciz.this.O00000o != null) {
                    ciz.this.O00000o.O000000o(videoFrame.distrot);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000oo() {
        if (O0000o00()) {
            cki.O00000o("GeneralCameraPlayer", "startPlay after pause");
        }
    }

    public final void O000000o(cjh cjh) {
        int i;
        if (cjh instanceof cja) {
            this.O00000o = cjh;
            this.O00000oO = ((cja) cjh).O00000Oo;
            if ("mijia.camera.v3".equals(this.O00000o0.getModel())) {
                cki.O00000o("GeneralCameraPlayer", "videoType:h264");
                i = 1;
            } else {
                i = 2;
            }
            cki.O00000o0("GeneralCameraPlayer", "setCameraView");
            this.O00000oo = String.format(Locale.US, "rtmj:did=%1$s&videoType=%2$d&sampleRate=%3$d&audioType=1&channel=1&dataBits=1", this.O00000o0.getDid(), Integer.valueOf(i), Integer.valueOf(this.O00000o0.O000O0OO()));
        }
    }

    public final void O0000OOo() {
        cki.O00000Oo("GeneralCameraPlayer", "pausePlay %b", Boolean.valueOf(this.O0000O0o));
        super.O0000OOo();
        MjBuffer.clear(this.O00000o0.getDid());
        ckc ckc = this.O00000oO;
        if (ckc != null) {
            ckc.O0000OOo();
            this.O00000oO.O0000Oo();
            this.O0000O0o = false;
        }
        ckj.O000000o().O00000Oo("GeneralCameraPlayer", "FIRST_RENDER:");
    }

    public final void O000000o(boolean z) {
        cki.O00000o("GeneralCameraPlayer", "release");
        super.O000000o(z);
        cqh.O00000Oo(this.f13929O000000o, "abandonFoucs");
    }

    private void O0000oo0() {
        cki.O00000Oo("GeneralCameraPlayer", "startPlay %b", Boolean.valueOf(this.O0000O0o));
        if (!this.O0000O0o) {
            this.O0000O0o = true;
            MjBuffer.init(ckh.O0000Oo, this.O00000o0.getDid());
            MjBuffer.enableGet(this.O00000o0.getDid(), 20, 10);
            if (this.O00000oO != null) {
                cki.O00000o("GeneralCameraPlayer", "startPlayer");
                this.O00000oO.O000000o(this.O00000oo, null);
                this.O00000oO.O000000o(O0000OoO() ? 0.0f : 1.0f);
                this.O00000oO.O0000Oo0();
                ckj.O000000o().O000000o(this, "FIRST_RENDER:startPlayer");
            }
        }
    }

    public final void O00000o0(boolean z) {
        super.O00000o0(z);
        this.O00000oO.O000000o(z ? 0.0f : 1.0f);
        if (z) {
            cqh.O00000Oo(this.f13929O000000o, "abandonFoucs");
        } else {
            cqh.O000000o(this.f13929O000000o, "audioFoucs");
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(IXmConnectionClient.XmActionCallback xmActionCallback) {
        super.O00000o0(xmActionCallback);
        O0000oo0();
    }

    public final void O000000o(int i, int i2, int i3, IXmConnectionClient.XmActionCallback xmActionCallback) {
        super.O000000o(i, i2, i3, xmActionCallback);
        O0000oo0();
    }
}
