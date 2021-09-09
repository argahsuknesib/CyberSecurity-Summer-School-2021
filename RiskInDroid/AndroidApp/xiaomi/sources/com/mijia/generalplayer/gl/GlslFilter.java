package com.mijia.generalplayer.gl;

import _m_j.cjq;
import _m_j.cjt;
import _m_j.cju;
import android.content.Context;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public class GlslFilter extends cjq {
    private static final float[] O00000Oo = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static final float[] O00000o = {-1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f};
    private static final float[] O00000o0 = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] O0000o00 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f5196O000000o = "camera_glsl";
    public int O00000oO = 3553;
    protected int O00000oo;
    final float[] O0000O0o = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    final float[] O0000OOo = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    GlslFilter O0000Oo;
    boolean O0000Oo0 = false;
    cju O0000OoO;
    public ArrayList<cjt> O0000Ooo = new ArrayList<>();
    private int O0000o;
    private final String O0000o0 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES inputImageTexture;\nvarying vec2 textureCoordinate;\nvoid main() {\n  gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
    private int O0000o0O;
    private int O0000o0o;
    private FloatBuffer O0000oO;
    private FloatBuffer O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private int[] O0000oo0 = {0};

    /* access modifiers changed from: protected */
    public void O00000Oo() {
    }

    public final cjq O000000o(cjt cjt) {
        if (cjt == null) {
            return this;
        }
        for (int i = 0; i < this.O0000Ooo.size(); i++) {
            if (cjt.O00000Oo.equals(this.O0000Ooo.get(i).O00000Oo)) {
                this.O0000Ooo.remove(i);
                this.O0000Ooo.add(cjt);
                return this;
            }
        }
        this.O0000Ooo.add(cjt);
        return this;
    }

    public GlslFilter(Context context) {
    }

    public String O000000o() {
        return this.O00000oO == 3553 ? "precision mediump float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nvoid main() {\n  gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n" : "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES inputImageTexture;\nvarying vec2 textureCoordinate;\nvoid main() {\n  gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
    }

    public final void O00000o() {
        GlslFilter glslFilter = this;
        while (!glslFilter.O0000Oo0) {
            glslFilter.O0000Oo0 = true;
            int O000000o2 = O000000o(35633, "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nuniform mat4 u_texture_mat; \nuniform mat4 u_model_view; \nvarying vec2 textureCoordinate;\nvoid main() {\n  gl_Position = u_model_view*a_position;\n  vec4 tmp = u_texture_mat*vec4(a_texcoord.x,a_texcoord.y,0.0,1.0);\n  textureCoordinate = tmp.xy;\n}\n");
            O000000o("glCreateProgram");
            if (O000000o2 != 0) {
                int O000000o3 = O000000o(35632, glslFilter.O000000o());
                if (O000000o3 != 0) {
                    glslFilter.O00000oo = GLES20.glCreateProgram();
                    int i = glslFilter.O00000oo;
                    if (i != 0) {
                        GLES20.glAttachShader(i, O000000o2);
                        O000000o("glAttachShader");
                        GLES20.glAttachShader(glslFilter.O00000oo, O000000o3);
                        O000000o("glAttachShader");
                        GLES20.glLinkProgram(glslFilter.O00000oo);
                        int[] iArr = new int[1];
                        GLES20.glGetProgramiv(glslFilter.O00000oo, 35714, iArr, 0);
                        if (iArr[0] == 1) {
                            glslFilter.O0000o0O = GLES20.glGetUniformLocation(glslFilter.O00000oo, "inputImageTexture");
                            glslFilter.O0000o0o = GLES20.glGetAttribLocation(glslFilter.O00000oo, "a_texcoord");
                            glslFilter.O0000o = GLES20.glGetAttribLocation(glslFilter.O00000oo, "a_position");
                            glslFilter.O0000oOO = GLES20.glGetUniformLocation(glslFilter.O00000oo, "u_texture_mat");
                            glslFilter.O0000oOo = GLES20.glGetUniformLocation(glslFilter.O00000oo, "u_model_view");
                            if (glslFilter.O00000oO == 3553) {
                                glslFilter.O0000oO0 = O00000Oo(O00000Oo);
                            } else {
                                glslFilter.O0000oO0 = O00000Oo(O00000o0);
                            }
                            glslFilter.O0000oO = O00000Oo(O00000o);
                            glslFilter.O00000Oo();
                            glslFilter = glslFilter.O0000Oo;
                            if (glslFilter == null) {
                                return;
                            }
                        } else {
                            String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glslFilter.O00000oo);
                            GLES20.glDeleteProgram(glslFilter.O00000oo);
                            glslFilter.O00000oo = 0;
                            throw new RuntimeException("Could not link program: ".concat(String.valueOf(glGetProgramInfoLog)));
                        }
                    } else {
                        throw new RuntimeException("Could not create program");
                    }
                } else {
                    throw new RuntimeException("Could not load fragment shader: " + glslFilter.O000000o());
                }
            } else {
                throw new RuntimeException(new StringBuilder("Could not load vertex shader: attribute vec4 a_position;\nattribute vec2 a_texcoord;\nuniform mat4 u_texture_mat; \nuniform mat4 u_model_view; \nvarying vec2 textureCoordinate;\nvoid main() {\n  gl_Position = u_model_view*a_position;\n  vec4 tmp = u_texture_mat*vec4(a_texcoord.x,a_texcoord.y,0.0,1.0);\n  textureCoordinate = tmp.xy;\n}\n").toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void O00000o0() {
        for (int i = 0; i < this.O0000Ooo.size(); i++) {
            this.O0000Ooo.get(i).O000000o(this.O00000oo);
        }
    }

    public final void O00000oO() {
        if (this.O0000Oo0) {
            this.O0000Oo0 = false;
            cju cju = this.O0000OoO;
            if (cju != null) {
                cju.O000000o();
                this.O0000OoO = null;
            }
            GlslFilter glslFilter = this.O0000Oo;
            if (glslFilter != null) {
                glslFilter.O00000oO();
            }
            for (int i = 0; i < this.O0000Ooo.size(); i++) {
                this.O0000Ooo.get(i);
            }
            int i2 = this.O00000oo;
            if (i2 > 0) {
                GLES20.glDeleteProgram(i2);
                this.O00000oo = 0;
            }
            int[] iArr = this.O0000oo0;
            if (iArr[0] > 0) {
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.O0000oo0[0] = 0;
            }
        }
    }

    public final void O000000o(float[] fArr) {
        for (int i = 0; i < fArr.length; i++) {
            this.O0000O0o[i] = fArr[i];
        }
    }

    public final void O000000o(cju cju, cju cju2) {
        if (this.O0000Oo == null) {
            O00000Oo(cju, cju2);
            return;
        }
        if (this.O0000OoO == null) {
            cju cju3 = cju == null ? cju2 : cju;
            if (cju3 != null) {
                this.O0000OoO = cju.O000000o(cju3.O00000Oo, cju3.O00000o0);
            }
        }
        O00000Oo(cju, this.O0000OoO);
        this.O0000Oo.O00000Oo(this.O0000OoO, cju2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
     arg types: [int, int, int, int, int, java.nio.FloatBuffer]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void} */
    private void O00000Oo(cju cju, cju cju2) {
        cju cju3 = cju;
        cju cju4 = cju2;
        if (this.O00000oo != 0) {
            if (cju4 == null) {
                GLES20.glBindFramebuffer(36160, 0);
            } else {
                int[] iArr = this.O0000oo0;
                if (iArr[0] == 0) {
                    GLES20.glGenFramebuffers(1, iArr, 0);
                }
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, cju4.f13951O000000o);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, cju4.O00000Oo, cju4.O00000o0, 0, 6408, 5121, null);
                GLES20.glBindFramebuffer(36160, this.O0000oo0[0]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, cju4.f13951O000000o, 0);
                O000000o("glBindFramebuffer");
            }
            GLES20.glUseProgram(this.O00000oo);
            O000000o("glUseProgram");
            GLES20.glViewport(0, 0, cju4.O00000Oo, cju4.O00000o0);
            O000000o("glViewport");
            GLES20.glDisable(3042);
            GLES20.glVertexAttribPointer(this.O0000o0o, 2, 5126, false, 0, (Buffer) this.O0000oO0);
            GLES20.glEnableVertexAttribArray(this.O0000o0o);
            GLES20.glVertexAttribPointer(this.O0000o, 3, 5126, false, 0, (Buffer) this.O0000oO);
            GLES20.glEnableVertexAttribArray(this.O0000o);
            O000000o("vertex attribute setup");
            if (cju3 != null && this.O0000o0O >= 0) {
                GLES20.glActiveTexture(33984);
                O000000o("glActiveTexture");
                GLES20.glBindTexture(this.O00000oO, cju3.f13951O000000o);
                O000000o("glBindTexture");
                GLES20.glTexParameteri(this.O00000oO, 10240, 9729);
                GLES20.glTexParameteri(this.O00000oO, 10241, 9729);
                GLES20.glTexParameteri(this.O00000oO, 10242, 33071);
                GLES20.glTexParameteri(this.O00000oO, 10243, 33071);
                GLES20.glUniform1i(this.O0000o0O, 0);
                O000000o("texSamplerHandle");
            }
            GLES20.glUniformMatrix4fv(this.O0000oOO, 1, false, this.O0000O0o, 0);
            O000000o("texCoordMatHandle");
            GLES20.glUniformMatrix4fv(this.O0000oOo, 1, false, this.O0000OOo, 0);
            O000000o("modelViewMatHandle");
            O00000o0();
            GLES20.glDrawArrays(6, 0, 4);
            O000000o("glDrawArrays");
            GLES20.glFinish();
            if (cju4 != null) {
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
            O000000o("after process");
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

    private static FloatBuffer O00000Oo(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    public static void O000000o(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new RuntimeException(O000000o(str, glGetError));
        }
    }

    private static String O000000o(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" - ");
        if (i == 0) {
            stringBuffer.append("No errors.");
        } else if (i == 1286) {
            stringBuffer.append("OpenGL invalid framebuffer operation.");
        } else if (i == 36057) {
            stringBuffer.append("OpenGL framebuffer attached images must have same dimensions.");
        } else if (i != 36061) {
            switch (i) {
                case 1280:
                    stringBuffer.append("Invalid enum");
                    break;
                case 1281:
                    stringBuffer.append("Invalid value");
                    break;
                case 1282:
                    stringBuffer.append("Invalid operation");
                    break;
                default:
                    switch (i) {
                        case 36053:
                            stringBuffer.append("Framebuffer complete.");
                            break;
                        case 36054:
                            stringBuffer.append("OpenGL framebuffer attached images must have same format.");
                            break;
                        case 36055:
                            stringBuffer.append("OpenGL framebuffer missing attachment.");
                            break;
                        default:
                            stringBuffer.append("OpenGL error: ".concat(String.valueOf(i)));
                            break;
                    }
            }
        } else {
            stringBuffer.append("OpenGL framebuffer format not supported. ");
        }
        return stringBuffer.toString();
    }
}
