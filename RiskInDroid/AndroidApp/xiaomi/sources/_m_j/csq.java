package _m_j;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.util.concurrent.Executor;

public final class csq {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14314O000000o;
    private Bitmap O00000Oo = null;
    private Executor O00000o0;

    public csq(Executor executor) {
        this.O00000o0 = executor;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f14314O000000o = iArr[0];
        GLES20.glBindTexture(3553, this.f14314O000000o);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        super.finalize();
        this.O00000Oo = null;
        this.O00000o0.execute(new Runnable() {
            /* class _m_j.csq.AnonymousClass1 */

            public final void run() {
                GLES20.glDeleteTextures(1, new int[]{csq.this.f14314O000000o}, 0);
            }
        });
    }

    public final void O000000o() {
        GLES20.glBindTexture(3553, this.f14314O000000o);
    }

    public final void O000000o(Bitmap bitmap) {
        if (bitmap != this.O00000Oo) {
            this.O00000Oo = bitmap;
            O000000o();
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
    }

    public final void O000000o(int i, int i2) {
        O000000o();
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
    }
}
