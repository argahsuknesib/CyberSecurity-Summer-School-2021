package _m_j;

import android.media.AudioRecord;

public final class bob {

    /* renamed from: O000000o  reason: collision with root package name */
    volatile int f13153O000000o = 2;
    O00000Oo O00000Oo;
    private int O00000o = 44100;
    O000000o O00000o0;
    private int O00000oO;
    private int O00000oo = 16;
    private int O0000O0o = 2;

    public interface O000000o {
        bnv O000000o();

        void O000000o(bnv bnv);
    }

    public interface O00000Oo {
    }

    public bob(O000000o o000000o, int i) {
        this.O00000o0 = o000000o;
        this.O00000o = 44100;
        this.O00000oO = i;
        this.O00000oo = 16;
        this.O0000O0o = 2;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        bnv O000000o2;
        int i = this.O00000oO;
        if (i > 0) {
            AudioRecord audioRecord = new AudioRecord(1, this.O00000o, this.O00000oo, this.O0000O0o, i * 5);
            try {
                this.f13153O000000o = 1;
                audioRecord.startRecording();
                if (this.O00000o0 != null) {
                    while (1 == this.f13153O000000o && (O000000o2 = this.O00000o0.O000000o()) != null && O000000o2.f13149O000000o != null) {
                        O000000o2.O00000Oo = audioRecord.read(O000000o2.f13149O000000o, 0, this.O00000oO);
                        this.O00000o0.O000000o(O000000o2);
                    }
                }
                audioRecord.stop();
                audioRecord.release();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                bnz.O000000o("Record", "startListen record error");
            }
            this.f13153O000000o = 2;
            return;
        }
        bnz.O000000o("Record", "bufferSize is too small");
    }
}
