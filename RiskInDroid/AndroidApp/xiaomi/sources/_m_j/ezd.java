package _m_j;

import android.media.MediaRecorder;

public final class ezd {

    /* renamed from: O000000o  reason: collision with root package name */
    public MediaRecorder f15972O000000o;
    public String O00000Oo;
    public boolean O00000o;
    public String O00000o0;
    public long O00000oO;
    public long O00000oo;

    public ezd(String str) {
        this.O00000Oo = str;
    }

    public final void O000000o() {
        MediaRecorder mediaRecorder = this.f15972O000000o;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.setOnErrorListener(null);
                this.f15972O000000o.setOnInfoListener(null);
                this.f15972O000000o.setPreviewDisplay(null);
                this.f15972O000000o.stop();
            } catch (Exception | IllegalStateException | RuntimeException unused) {
            }
            this.O00000o = false;
            this.f15972O000000o.release();
            this.f15972O000000o = null;
            this.O00000oo = System.currentTimeMillis() - this.O00000oO;
        }
    }

    public final long O00000Oo() {
        if (this.O00000o) {
            return System.currentTimeMillis() - this.O00000oO;
        }
        return this.O00000oo;
    }
}
