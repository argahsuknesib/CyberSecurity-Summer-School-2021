package _m_j;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public final class cjp {

    public static abstract class O000000o implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: O000000o  reason: collision with root package name */
        protected int[] f13948O000000o;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public O000000o(int[] iArr) {
            int[] iArr2 = new int[15];
            System.arraycopy(iArr, 0, iArr2, 0, 12);
            iArr2[12] = 12352;
            iArr2[13] = 4;
            iArr2[14] = 12344;
            this.f13948O000000o = iArr2;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f13948O000000o, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f13948O000000o, eGLConfigArr, i, iArr)) {
                        EGLConfig O000000o2 = O000000o(egl10, eGLDisplay, eGLConfigArr);
                        if (O000000o2 != null) {
                            return O000000o2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    public static class O00000Oo extends O000000o {
        protected int O00000Oo = 8;
        protected int O00000o = 8;
        protected int O00000o0 = 8;
        protected int O00000oO = 8;
        protected int O00000oo = 0;
        protected int O0000O0o = 0;
        private int[] O0000OOo = new int[1];

        public O00000Oo() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344});
        }

        public final EGLConfig O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int O000000o2 = O000000o(egl10, eGLDisplay, eGLConfig, 12325);
                int O000000o3 = O000000o(egl10, eGLDisplay, eGLConfig, 12326);
                if (O000000o2 >= this.O00000oo && O000000o3 >= this.O0000O0o) {
                    int O000000o4 = O000000o(egl10, eGLDisplay, eGLConfig, 12324);
                    int O000000o5 = O000000o(egl10, eGLDisplay, eGLConfig, 12323);
                    int O000000o6 = O000000o(egl10, eGLDisplay, eGLConfig, 12322);
                    int O000000o7 = O000000o(egl10, eGLDisplay, eGLConfig, 12321);
                    if (O000000o4 == this.O00000Oo && O000000o5 == this.O00000o0 && O000000o6 == this.O00000o && O000000o7 == this.O00000oO) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int O000000o(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.O0000OOo)) {
                return this.O0000OOo[0];
            }
            return 0;
        }
    }
}
