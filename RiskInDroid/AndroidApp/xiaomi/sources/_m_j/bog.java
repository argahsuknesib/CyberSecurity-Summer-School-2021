package _m_j;

import android.content.Context;
import com.libra.sinvoice.VoiceDecoder;
import java.io.FileOutputStream;

public final class bog implements VoiceDecoder.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile int f13164O000000o = 2;
    O00000Oo O00000Oo;
    FileOutputStream O00000o;
    O000000o O00000o0;
    VoiceDecoder O00000oO;
    Context O00000oo;
    boolean O0000O0o;

    public interface O000000o {
        bnv O00000Oo();

        void O00000Oo(bnv bnv);
    }

    public interface O00000Oo {
        void O00000o();

        void O00000o0();
    }

    public bog(O000000o o000000o) {
        this.O00000o0 = o000000o;
        this.O0000O0o = false;
        this.O00000oO = new VoiceDecoder(this);
    }
}
