package _m_j;

import android.opengl.GLES20;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class csl {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<csq> f14305O000000o = new ArrayList();
    public int O00000Oo;
    public int O00000o = 0;
    public int O00000o0 = 0;
    private Executor O00000oO;

    public csl(Executor executor) {
        this.O00000oO = executor;
        O000000o o000000o = new O000000o();
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.O00000Oo = iArr[0];
        GLES20.glBindFramebuffer(36160, this.O00000Oo);
        for (int i = 0; i <= 0; i++) {
            List<csq> list = this.f14305O000000o;
            int i2 = this.O00000o0;
            int i3 = this.O00000o;
            csq csq = new csq(this.O00000oO);
            csq.O000000o();
            csq.O000000o(i2, i3);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, csq.f14314O000000o, 0);
            list.add(csq);
        }
        o000000o.O000000o();
    }

    public class O000000o {
        private int O00000Oo;
        private int O00000o;
        private int O00000o0;

        public O000000o() {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            GLES20.glGetIntegerv(36006, iArr, 0);
            GLES20.glGetIntegerv(36007, iArr2, 0);
            GLES20.glGetIntegerv(32873, iArr3, 0);
            this.O00000Oo = iArr[0];
            this.O00000o0 = iArr2[0];
            this.O00000o = iArr3[0];
        }

        public final void O000000o() {
            GLES20.glBindFramebuffer(36160, this.O00000Oo);
            GLES20.glBindRenderbuffer(36161, this.O00000o0);
            GLES20.glBindTexture(3553, this.O00000o);
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        super.finalize();
        this.O00000oO.execute(new Runnable() {
            /* class _m_j.csl.AnonymousClass1 */

            public final void run() {
                GLES20.glDeleteFramebuffers(1, new int[]{csl.this.O00000Oo}, 0);
            }
        });
    }
}
