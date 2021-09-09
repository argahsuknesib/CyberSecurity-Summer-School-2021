package _m_j;

import android.opengl.GLES20;
import com.projectseptember.RNGL.GLShaderCompilationFailed;
import com.projectseptember.RNGL.RNGLContext;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class cso {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, Integer> f14312O000000o;
    public List<String> O00000Oo;
    public int[] O00000o;
    public int O00000o0;
    public int O00000oO;
    public Map<String, Integer> O00000oo;
    public Map<String, Integer> O0000O0o;
    private final String O0000OOo;
    private final String O0000Oo;
    private final String O0000Oo0;
    private Integer O0000OoO;
    private RNGLContext O0000Ooo;
    private GLShaderCompilationFailed O0000o00;

    public cso(csp csp, Integer num, RNGLContext rNGLContext) {
        this.O0000OOo = csp.f14313O000000o;
        this.O0000Oo0 = csp.O00000Oo;
        this.O0000Oo = csp.O00000o0;
        this.O0000OoO = num;
        this.O0000Ooo = rNGLContext;
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        super.finalize();
        if (this.O00000o != null) {
            GLES20.glDeleteProgram(this.O00000o0);
            GLES20.glDeleteBuffers(1, this.O00000o, 0);
        }
    }

    public final void O000000o(String str) {
        throw new GLShaderCompilationFailed(this.O0000OOo, str);
    }

    private int O000000o(String str, int i) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        O000000o(GLES20.glGetShaderInfoLog(glCreateShader));
        return -1;
    }

    private boolean O00000Oo() {
        return (this.O00000o == null || this.O00000oo == null) ? false : true;
    }

    public final boolean O000000o() {
        int O000000o2;
        if (!O00000Oo()) {
            GLShaderCompilationFailed gLShaderCompilationFailed = this.O0000o00;
            if (gLShaderCompilationFailed == null) {
                try {
                    int O000000o3 = O000000o(this.O0000Oo0, 35633);
                    if (!(O000000o3 == -1 || (O000000o2 = O000000o(this.O0000Oo, 35632)) == -1)) {
                        this.O00000o0 = GLES20.glCreateProgram();
                        GLES20.glAttachShader(this.O00000o0, O000000o3);
                        GLES20.glAttachShader(this.O00000o0, O000000o2);
                        GLES20.glLinkProgram(this.O00000o0);
                        int[] iArr = new int[1];
                        GLES20.glGetProgramiv(this.O00000o0, 35714, iArr, 0);
                        if (iArr[0] == 0) {
                            O000000o(GLES20.glGetProgramInfoLog(this.O00000o0));
                        }
                        GLES20.glUseProgram(this.O00000o0);
                        GLES20.glValidateProgram(this.O00000o0);
                        int[] iArr2 = new int[1];
                        GLES20.glGetProgramiv(this.O00000o0, 35715, iArr2, 0);
                        if (iArr2[0] == 0) {
                            GLES20.glGetProgramInfoLog(this.O00000o0);
                            O000000o(GLES20.glGetProgramInfoLog(this.O00000o0));
                        }
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        HashMap hashMap3 = new HashMap();
                        ArrayList arrayList = new ArrayList();
                        int[] iArr3 = new int[1];
                        int[] iArr4 = new int[1];
                        int[] iArr5 = new int[1];
                        GLES20.glGetProgramiv(this.O00000o0, 35718, iArr3, 0);
                        int i = 0;
                        while (i < iArr3[0]) {
                            int i2 = i;
                            String glGetActiveUniform = GLES20.glGetActiveUniform(this.O00000o0, i, iArr5, 0, iArr4, 0);
                            int i3 = iArr5[0];
                            int i4 = iArr4[0];
                            if (glGetActiveUniform.contains("[0]")) {
                                glGetActiveUniform = glGetActiveUniform.substring(0, glGetActiveUniform.length() - 3);
                            }
                            arrayList.add(glGetActiveUniform);
                            hashMap.put(glGetActiveUniform, Integer.valueOf(i4));
                            hashMap3.put(glGetActiveUniform, Integer.valueOf(i3));
                            if (i3 == 1) {
                                hashMap2.put(glGetActiveUniform, Integer.valueOf(GLES20.glGetUniformLocation(this.O00000o0, glGetActiveUniform)));
                            } else {
                                for (int i5 = 0; i5 < i3; i5++) {
                                    String str = glGetActiveUniform + "[" + i5 + "]";
                                    hashMap2.put(str, Integer.valueOf(GLES20.glGetUniformLocation(this.O00000o0, str)));
                                    hashMap.put(str, Integer.valueOf(i4));
                                    hashMap3.put(str, 1);
                                }
                            }
                            i = i2 + 1;
                        }
                        this.f14312O000000o = hashMap;
                        this.O00000oo = hashMap2;
                        this.O0000O0o = hashMap3;
                        this.O00000Oo = arrayList;
                        this.O00000oO = GLES20.glGetAttribLocation(this.O00000o0, "position");
                        this.O00000o = new int[1];
                        GLES20.glGenBuffers(1, this.O00000o, 0);
                        GLES20.glBindBuffer(34962, this.O00000o[0]);
                        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(24).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        asFloatBuffer.put(new float[]{-1.0f, -1.0f, -1.0f, 4.0f, 4.0f, -1.0f}).position(0);
                        GLES20.glBufferData(34962, 24, asFloatBuffer, 35044);
                    }
                    this.O0000Ooo.shaderSucceedToCompile(this.O0000OoO, this.f14312O000000o);
                } catch (GLShaderCompilationFailed e) {
                    this.O0000o00 = e;
                    this.O0000Ooo.shaderFailedToCompile(this.O0000OoO, e);
                    throw e;
                }
            } else {
                throw gLShaderCompilationFailed;
            }
        }
        return O00000Oo();
    }
}
