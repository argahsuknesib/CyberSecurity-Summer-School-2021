package _m_j;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class cjw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int[] f13956O000000o = new int[1];
    private static final float[] O00000Oo = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] O00000o0 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f13957O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO;
        public FloatBuffer O00000oo;
        public FloatBuffer O0000O0o;
        public float O0000OOo = 1.0f;
        public float[] O0000Oo = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        public int O0000Oo0;
    }

    public static int O000000o() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        O000000o("glGenTextures");
        return iArr[0];
    }

    public static int O000000o(Bitmap bitmap) {
        int O000000o2 = O000000o();
        GLES20.glBindTexture(3553, O000000o2);
        GLUtils.texImage2D(3553, 0, GLUtils.getInternalFormat(bitmap), bitmap, GLUtils.getType(bitmap), 0);
        O000000o("texImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        O000000o("texImage2D");
        return O000000o2;
    }

    public static int O000000o(int i, Bitmap bitmap) {
        if (i < 0) {
            i = O000000o();
        }
        GLES20.glBindTexture(3553, i);
        GLUtils.texImage2D(3553, 0, GLUtils.getInternalFormat(bitmap), bitmap, GLUtils.getType(bitmap), 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        O000000o("texImage2D");
        return i;
    }

    public static Bitmap O000000o(int i, int i2, int i3) {
        if (i < 0) {
            return null;
        }
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        O000000o("glGenFramebuffers");
        GLES20.glBindFramebuffer(36160, iArr[0]);
        O000000o("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        O000000o("glFramebufferTexture2D");
        ByteBuffer allocate = ByteBuffer.allocate(i2 * i3 * 4);
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, allocate);
        O000000o("glReadPixels");
        Bitmap O000000o2 = ckl.O000000o(i2, i3, Bitmap.Config.ARGB_8888);
        if (O000000o2 != null) {
            O000000o2.copyPixelsFromBuffer(allocate);
        }
        GLES20.glBindFramebuffer(36160, 0);
        O000000o("glBindFramebuffer");
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        O000000o("glDeleteFramebuffer");
        return O000000o2;
    }

    public static void O000000o(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        O000000o("glDeleteTextures");
    }

    public static void O000000o(O000000o o000000o, float[] fArr) {
        o000000o.O0000Oo = fArr;
    }

    public static void O000000o(O000000o o000000o, int i) {
        o000000o.O0000OOo = ((float) i) / 255.0f;
    }

    public static void O000000o(O000000o o000000o, float f, float f2, float f3) {
        GLES20.glClearColor(f, f2, f3, o000000o.O0000OOo);
        GLES20.glClear(16384);
    }

    public static void O000000o(float f) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, f);
        GLES20.glClear(16384);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
     arg types: [int, int, int, int, int, java.nio.FloatBuffer]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void} */
    public static void O000000o(O000000o o000000o, boolean z, int i, int i2, int i3) {
        GLES20.glUseProgram(o000000o.f13957O000000o);
        if (GLES20.glGetError() != 0) {
            O00000Oo();
            O000000o("createProgram");
        }
        GLES20.glViewport(0, 0, i2, i3);
        O000000o("glViewport");
        if (!z) {
            GLES20.glDisable(3042);
        }
        GLES20.glVertexAttribPointer(o000000o.O00000o, 2, 5126, false, 0, (Buffer) o000000o.O00000oo);
        GLES20.glEnableVertexAttribArray(o000000o.O00000o);
        GLES20.glVertexAttribPointer(o000000o.O00000oO, 2, 5126, false, 0, (Buffer) o000000o.O0000O0o);
        GLES20.glEnableVertexAttribArray(o000000o.O00000oO);
        O000000o("vertex attribute setup");
        GLES20.glActiveTexture(33984);
        O000000o("glActiveTexture");
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        O000000o("glBindTexture");
        GLES20.glUniform1i(o000000o.O00000Oo, 0);
        GLES20.glUniform1f(o000000o.O00000o0, o000000o.O0000OOo);
        GLES20.glUniformMatrix4fv(o000000o.O0000Oo0, 1, false, o000000o.O0000Oo, 0);
        O000000o("modelViewMatHandle");
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFinish();
    }

    private static O000000o O000000o(float[] fArr, float[] fArr2) {
        int O000000o2;
        int O000000o3 = O000000o(35633, "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nuniform mat4 u_model_view; \nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = u_model_view*a_position;\n  v_texcoord = a_texcoord;\n}\n");
        if (O000000o3 == 0 || (O000000o2 = O000000o(35632, "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform float alpha;\nvarying vec2 v_texcoord;\nvoid main() {\nvec4 color = texture2D(tex_sampler, v_texcoord);\ngl_FragColor = vec4(color.rgb, color.a * alpha);\n}\n")) == 0) {
            return null;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, O000000o3);
            O000000o("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, O000000o2);
            O000000o("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                GLES20.glDeleteProgram(glCreateProgram);
                throw new RuntimeException("Could not link program: ".concat(String.valueOf(glGetProgramInfoLog)));
            }
        }
        O000000o o000000o = new O000000o();
        o000000o.O00000Oo = GLES20.glGetUniformLocation(glCreateProgram, "tex_sampler");
        o000000o.O00000o0 = GLES20.glGetUniformLocation(glCreateProgram, "alpha");
        o000000o.O00000o = GLES20.glGetAttribLocation(glCreateProgram, "a_texcoord");
        o000000o.O00000oO = GLES20.glGetAttribLocation(glCreateProgram, "a_position");
        o000000o.O0000Oo0 = GLES20.glGetUniformLocation(glCreateProgram, "u_model_view");
        o000000o.O00000oo = O000000o(fArr2);
        o000000o.O0000O0o = O000000o(fArr);
        o000000o.f13957O000000o = glCreateProgram;
        return o000000o;
    }

    public static O000000o O00000Oo() {
        return O000000o(O00000o0, O00000Oo);
    }

    public static void O000000o(O000000o o000000o) {
        if (o000000o != null && o000000o.f13957O000000o > 0) {
            GLES20.glDeleteProgram(o000000o.f13957O000000o);
            o000000o.f13957O000000o = 0;
        }
    }

    private static int O000000o(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                throw new RuntimeException("Could not compile shader " + i + ":" + glGetShaderInfoLog);
            }
        }
        return glCreateShader;
    }

    private static FloatBuffer O000000o(float[] fArr) {
        if (fArr.length == 8) {
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(fArr).position(0);
            return asFloatBuffer;
        }
        throw new RuntimeException("Number of vertices should be four.");
    }

    private static String O00000Oo(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return " ".concat(String.valueOf(i));
        }
    }

    public static void O000000o(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            cki.O00000oO("RendererUtils", str + ": glError " + O00000Oo(glGetError));
            for (StackTraceElement stackTraceElement : Thread.getAllStackTraces().get(Thread.currentThread())) {
                cki.O00000oO("RendererUtils", "SS     " + stackTraceElement.toString());
            }
        }
    }
}
