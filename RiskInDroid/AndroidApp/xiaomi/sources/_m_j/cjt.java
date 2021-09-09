package _m_j;

import android.opengl.GLES20;

public class cjt {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13950O000000o;
    public String O00000Oo;

    public cjt(String str) {
        this.O00000Oo = str;
    }

    public void O000000o(int i) {
        this.f13950O000000o = GLES20.glGetUniformLocation(i, this.O00000Oo);
    }

    public String toString() {
        return this.O00000Oo;
    }

    public static class O000000o extends cjt {
        float O00000o0;

        public O000000o(String str, float f) {
            super(str);
            this.O00000o0 = f;
        }

        public void O000000o(float f) {
            this.O00000o0 = f;
        }

        public void O000000o(int i) {
            cjt.super.O000000o(i);
            if (this.f13950O000000o >= 0) {
                GLES20.glUniform1f(this.f13950O000000o, this.O00000o0);
            }
        }

        public String toString() {
            return this.O00000Oo + "=" + this.O00000o0;
        }
    }

    public static class O00000Oo extends O000000o {
        float O00000o;
        float O00000oO;

        public O00000Oo(String str, float f, float f2, float f3) {
            super(str, f);
            this.O00000o = f2;
            this.O00000oO = f3;
        }

        public final void O000000o(float f) {
            this.O00000o0 = f;
        }
    }

    public static class O00000o0 extends O00000Oo {
        public O00000o0(String str) {
            super(str, 1.1f, 0.8f, 2.5f);
        }

        public final void O000000o(int i) {
            this.f13950O000000o = GLES20.glGetUniformLocation(i, this.O00000Oo);
            if (this.f13950O000000o >= 0) {
                float f = this.O00000o0;
                if (f == 0.0f) {
                    f = 1.0E-5f;
                }
                GLES20.glUniform1f(this.f13950O000000o, f);
            }
        }
    }
}
