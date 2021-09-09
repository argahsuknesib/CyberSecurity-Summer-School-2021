package _m_j;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public final class cjr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final float[] f13949O000000o = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] O00000Oo = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] O00000o0 = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private int O00000o;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private FloatBuffer O0000OOo;
    private final LinkedList<Runnable> O0000Oo;
    private FloatBuffer O0000Oo0;

    public cjr() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    private cjr(String str, String str2) {
        int i;
        int[] iArr = new int[1];
        int O000000o2 = cjs.O000000o(str, 35633);
        if (O000000o2 == 0) {
            Log.d("Load Program", "Vertex Shader Failed");
        } else {
            int O000000o3 = cjs.O000000o(str2, 35632);
            if (O000000o3 == 0) {
                Log.d("Load Program", "Fragment Shader Failed");
            } else {
                i = GLES20.glCreateProgram();
                GLES20.glAttachShader(i, O000000o2);
                GLES20.glAttachShader(i, O000000o3);
                GLES20.glLinkProgram(i);
                GLES20.glGetProgramiv(i, 35714, iArr, 0);
                if (iArr[0] <= 0) {
                    Log.d("Load Program", "Linking Failed");
                } else {
                    GLES20.glDeleteShader(O000000o2);
                    GLES20.glDeleteShader(O000000o3);
                    this.O00000o = i;
                    this.O00000oO = GLES20.glGetAttribLocation(this.O00000o, "position");
                    this.O00000oo = GLES20.glGetUniformLocation(this.O00000o, "inputImageTexture");
                    this.O0000O0o = GLES20.glGetAttribLocation(this.O00000o, "inputTextureCoordinate");
                    this.O0000Oo0 = ByteBuffer.allocateDirect(f13949O000000o.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    this.O0000Oo0.put(f13949O000000o).position(0);
                    this.O0000OOo = ByteBuffer.allocateDirect(O00000Oo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    this.O0000OOo.put(O00000Oo).position(0);
                    this.O0000Oo = new LinkedList<>();
                }
            }
        }
        i = 0;
        this.O00000o = i;
        this.O00000oO = GLES20.glGetAttribLocation(this.O00000o, "position");
        this.O00000oo = GLES20.glGetUniformLocation(this.O00000o, "inputImageTexture");
        this.O0000O0o = GLES20.glGetAttribLocation(this.O00000o, "inputTextureCoordinate");
        this.O0000Oo0 = ByteBuffer.allocateDirect(f13949O000000o.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.O0000Oo0.put(f13949O000000o).position(0);
        this.O0000OOo = ByteBuffer.allocateDirect(O00000Oo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.O0000OOo.put(O00000Oo).position(0);
        this.O0000Oo = new LinkedList<>();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
     arg types: [int, int, int, int, int, java.nio.FloatBuffer]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void} */
    public final void O000000o(int i) {
        float[] fArr = O00000Oo;
        float[] fArr2 = f13949O000000o;
        int i2 = this.O00000o;
        if (i2 != 0) {
            GLES20.glUseProgram(i2);
            while (!this.O0000Oo.isEmpty()) {
                this.O0000Oo.removeFirst().run();
            }
            this.O0000OOo.put(fArr);
            this.O0000OOo.position(0);
            GLES20.glEnableVertexAttribArray(this.O00000oO);
            GLES20.glVertexAttribPointer(this.O00000oO, 2, 5126, false, 0, (Buffer) this.O0000OOo);
            this.O0000Oo0.put(fArr2);
            this.O0000Oo0.position(0);
            GLES20.glEnableVertexAttribArray(this.O0000O0o);
            GLES20.glVertexAttribPointer(this.O0000O0o, 2, 5126, false, 0, (Buffer) this.O0000Oo0);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glUniform1i(this.O00000oo, 0);
            }
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.O00000oO);
            GLES20.glDisableVertexAttribArray(this.O0000O0o);
            GLES20.glBindTexture(3553, 0);
        }
    }
}
