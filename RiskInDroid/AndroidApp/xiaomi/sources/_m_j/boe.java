package _m_j;

import _m_j.bob;
import _m_j.bog;
import android.content.Context;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;

public final class boe implements bob.O000000o, bob.O00000Oo, bog.O000000o, bog.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    bnw f13156O000000o;
    public bob O00000Oo;
    Thread O00000o;
    public bog O00000o0;
    Thread O00000oO;
    int O00000oo;
    public O000000o O0000O0o;
    private Handler O0000OOo;

    public interface O000000o {
        void O000000o(String str);
    }

    public boe(Context context, O000000o o000000o) {
        this(context, o000000o, (byte) 0);
    }

    private boe(Context context, O000000o o000000o, byte b) {
        this.O00000oo = 2;
        this.O0000O0o = o000000o;
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        this.f13156O000000o = new bnw(3, minBufferSize);
        this.O00000Oo = new bob(this, minBufferSize);
        this.O00000Oo.O00000Oo = this;
        this.O00000o0 = new bog(this);
        bog bog = this.O00000o0;
        bog.O00000Oo = this;
        bog.O00000oo = context;
        bog.O00000oO.create(bog.O00000oo, "com.sinvoice.demo", "SinVoice");
        this.O0000OOo = new Handler(new Handler.Callback() {
            /* class _m_j.boe.AnonymousClass1 */

            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    O000000o o000000o = boe.this.O0000O0o;
                    return false;
                } else if (i != 2 || boe.this.O0000O0o == null) {
                    return false;
                } else {
                    boe.this.O0000O0o.O000000o((String) message.obj);
                    return false;
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c  */
    public final bnv O000000o() {
        bnv bnv;
        bnw bnw = this.f13156O000000o;
        if (1 == bnw.f13150O000000o) {
            if (bnw.O00000Oo != null) {
                bnv = bnw.O00000Oo.O00000Oo();
                if (bnv == null) {
                    bnz.O000000o("SinVoiceReceiver", "get null empty buffer");
                }
                return bnv;
            }
            bnz.O000000o("BufferQueue", "getEmpty queue is null");
        }
        bnv = null;
        if (bnv == null) {
        }
        return bnv;
    }

    public final void O000000o(bnv bnv) {
        if (bnv != null && !this.f13156O000000o.O00000Oo(bnv)) {
            bnz.O000000o("SinVoiceReceiver", "put full buffer failed");
        }
    }

    public final bnv O00000Oo() {
        bnv O00000o02 = this.f13156O000000o.O00000o0();
        if (O00000o02 == null) {
            bnz.O000000o("SinVoiceReceiver", "get null full buffer");
        }
        return O00000o02;
    }

    public final void O00000Oo(bnv bnv) {
        if (bnv != null && !this.f13156O000000o.O000000o(bnv)) {
            bnz.O000000o("SinVoiceReceiver", "put empty buffer failed");
        }
    }

    public final void O00000o0() {
        this.O0000OOo.sendEmptyMessage(3);
    }

    public final void O00000o() {
        this.O0000OOo.sendEmptyMessage(4);
    }
}
