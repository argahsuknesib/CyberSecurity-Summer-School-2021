package _m_j;

import android.content.Context;
import com.libra.sinvoice.VoiceEncoder;
import java.io.FileOutputStream;

public final class bnx implements VoiceEncoder.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f13151O000000o;
    FileOutputStream O00000Oo;
    VoiceEncoder O00000o;
    volatile int O00000o0 = 2;
    Context O00000oO;
    int O00000oo;
    int O0000O0o = 0;
    boolean O0000OOo;
    private O000000o O0000Oo0;

    public interface O000000o {
        void O000000o();
    }

    public interface O00000Oo {
    }

    public bnx(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
        this.O0000OOo = false;
        this.O00000o = new VoiceEncoder(this);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(byte[] bArr, int i) {
        if (1 == this.O00000o0) {
            this.O00000o.send(bArr);
            if (i > 0) {
                int i2 = 0;
                while (1 == this.O00000o0 && i2 < i) {
                    i2 += 20;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final void O000000o() {
        if (1 == this.O00000o0) {
            this.O00000o0 = 2;
            this.O0000Oo0.O000000o();
        }
    }
}
