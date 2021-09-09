package _m_j;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.opencv.android.CameraGLSurfaceView;

@TargetApi(GmsLogger.MAX_PII_TAG_LENGTH)
public abstract class jlk implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f1922O000000o = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}";
    private final String O00000Oo = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
    private final float[] O00000o = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private final String O00000o0 = "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";
    private final float[] O00000oO = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private final float[] O00000oo = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    protected final String O0000O0o = "CameraGLRendererBase";
    protected int O0000OOo = -1;
    protected int O0000Oo = -1;
    protected int O0000Oo0 = -1;
    protected int O0000OoO = -1;
    protected int O0000Ooo = -1;
    protected boolean O0000o = false;
    protected int O0000o0 = -1;
    protected int O0000o00 = -1;
    protected SurfaceTexture O0000o0O;
    public boolean O0000o0o = false;
    protected boolean O0000oO = true;
    protected boolean O0000oO0 = false;
    protected boolean O0000oOO = false;
    protected CameraGLSurfaceView O0000oOo;
    private int[] O0000oo = {0};
    private int[] O0000oo0 = {0};
    private int[] O0000ooO = {0};
    private int[] O0000ooo = {0};
    private int O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private FloatBuffer O000O0o;
    private FloatBuffer O000O0o0;
    private FloatBuffer O000O0oO;
    private int O00oOoOo;
    private int O00oOooO = -1;
    private int O00oOooo = -1;

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i);

    /* access modifiers changed from: protected */
    public abstract void O000000o(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void O00000o0();

    public jlk(CameraGLSurfaceView cameraGLSurfaceView) {
        this.O0000oOo = cameraGLSurfaceView;
        int length = (this.O00000o.length * 32) / 8;
        this.O000O0o0 = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.O000O0o = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.O000O0oO = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.O000O0o0.put(this.O00000o).position(0);
        this.O000O0o.put(this.O00000oO).position(0);
        this.O000O0oO.put(this.O00000oo).position(0);
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.O0000oO0 = true;
        this.O0000oOo.requestRender();
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.O0000o) {
            synchronized (this) {
                if (this.O0000oO0) {
                    this.O0000o0O.updateTexImage();
                    this.O0000oO0 = false;
                }
                GLES20.glClear(16384);
                CameraGLSurfaceView.O000000o cameraTextureListener = this.O0000oOo.getCameraTextureListener();
                if (cameraTextureListener != null) {
                    O000000o(this.O0000oo0[0], true, this.O0000ooo[0]);
                    if (cameraTextureListener.O000000o()) {
                        O000000o(this.O0000ooO[0], false, 0);
                    } else {
                        O000000o(this.O0000oo[0], false, 0);
                    }
                } else {
                    Log.d("CameraGLRendererBase", "texCamera(OES) -> screen");
                    O000000o(this.O0000oo0[0], true, 0);
                }
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.i("CameraGLRendererBase", "onSurfaceChanged(" + i + "x" + i2 + ")");
        this.O0000o0o = true;
        O0000Oo0();
        O00000o0(i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i("CameraGLRendererBase", "onSurfaceCreated");
        String glGetString = GLES20.glGetString(7938);
        if (glGetString != null) {
            Log.i("CameraGLRendererBase", "OpenGL ES version: ".concat(String.valueOf(glGetString)));
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.O00oOooO = O000000o("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.O000O00o = GLES20.glGetAttribLocation(this.O00oOooO, "vPosition");
        this.O000O0OO = GLES20.glGetAttribLocation(this.O00oOooO, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.O000O00o);
        GLES20.glEnableVertexAttribArray(this.O000O0OO);
        this.O00oOooo = O000000o("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.O000O0Oo = GLES20.glGetAttribLocation(this.O00oOooo, "vPosition");
        this.O00oOoOo = GLES20.glGetAttribLocation(this.O00oOooo, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.O000O0Oo);
        GLES20.glEnableVertexAttribArray(this.O00oOoOo);
    }

    private void O00000o() {
        Log.d("CameraGLRendererBase", "deleteSurfaceTexture");
        SurfaceTexture surfaceTexture = this.O0000o0O;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.O0000o0O = null;
            O000000o(this.O0000oo0);
        }
    }

    private static void O000000o(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    private static int O000000o(String str, String str2) {
        Log.d("CameraGLRendererBase", "loadShader");
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile vertex shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile fragment shader:" + GLES20.glGetShaderInfoLog(glCreateShader2));
            GLES20.glDeleteShader(glCreateShader);
            GLES20.glDeleteShader(glCreateShader2);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not link shader program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            return 0;
        }
        GLES20.glValidateProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35715, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Shader program validation error: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        Log.d("CameraGLRendererBase", "Shader program is built OK");
        return glCreateProgram;
    }

    private void O00000Oo(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Log.d("CameraGLRendererBase", "initFBO(" + i3 + "x" + i4 + ")");
        Log.d("CameraGLRendererBase", "deleteFBO(" + this.O0000Oo + "x" + this.O0000OoO + ")");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, this.O0000ooo, 0);
        O000000o(this.O0000oo);
        O000000o(this.O0000ooO);
        this.O0000OoO = 0;
        this.O0000Oo = 0;
        GLES20.glGenTextures(1, this.O0000ooO, 0);
        GLES20.glBindTexture(3553, this.O0000ooO[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenTextures(1, this.O0000oo, 0);
        GLES20.glBindTexture(3553, this.O0000oo[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenFramebuffers(1, this.O0000ooo, 0);
        GLES20.glBindFramebuffer(36160, this.O0000ooo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.O0000oo[0], 0);
        Log.d("CameraGLRendererBase", "initFBO error status: " + GLES20.glGetError());
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            Log.e("CameraGLRendererBase", "initFBO failed, status: ".concat(String.valueOf(glCheckFramebufferStatus)));
        }
        this.O0000Oo = i3;
        this.O0000OoO = i4;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
     arg types: [int, int, int, int, int, java.nio.FloatBuffer]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void} */
    private void O000000o(int i, boolean z, int i2) {
        int i3 = i;
        int i4 = i2;
        GLES20.glBindFramebuffer(36160, i4);
        if (i4 == 0) {
            GLES20.glViewport(0, 0, this.O0000oOo.getWidth(), this.O0000oOo.getHeight());
        } else {
            GLES20.glViewport(0, 0, this.O0000Oo, this.O0000OoO);
        }
        GLES20.glClear(16384);
        if (z) {
            GLES20.glUseProgram(this.O00oOooO);
            GLES20.glVertexAttribPointer(this.O000O00o, 2, 5126, false, 8, (Buffer) this.O000O0o0);
            GLES20.glVertexAttribPointer(this.O000O0OO, 2, 5126, false, 8, (Buffer) this.O000O0o);
        } else {
            GLES20.glUseProgram(this.O00oOooo);
            GLES20.glVertexAttribPointer(this.O000O0Oo, 2, 5126, false, 8, (Buffer) this.O000O0o0);
            GLES20.glVertexAttribPointer(this.O00oOoOo, 2, 5126, false, 8, (Buffer) this.O000O0oO);
        }
        GLES20.glActiveTexture(33984);
        if (z) {
            GLES20.glBindTexture(36197, i3);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.O00oOooO, "sTexture"), 0);
        } else {
            GLES20.glBindTexture(3553, i3);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.O00oOooo, "sTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    private synchronized void O0000O0o() {
        Log.d("CameraGLRendererBase", "enableView");
        this.O0000oO = true;
        O0000Oo0();
    }

    private synchronized void O0000OOo() {
        Log.d("CameraGLRendererBase", "disableView");
        this.O0000oO = false;
        O0000Oo0();
    }

    private void O0000Oo0() {
        Log.d("CameraGLRendererBase", "updateState");
        Log.d("CameraGLRendererBase", "mEnabled=" + this.O0000oO + ", mHaveSurface=" + this.O0000o0o);
        boolean z = this.O0000oO && this.O0000o0o && this.O0000oOo.getVisibility() == 0;
        if (z == this.O0000oOO) {
            Log.d("CameraGLRendererBase", "keeping State unchanged");
        } else if (z) {
            O000000o();
        } else {
            O00000Oo();
        }
        Log.d("CameraGLRendererBase", "updateState end");
    }

    /* access modifiers changed from: protected */
    public synchronized void O000000o() {
        Log.d("CameraGLRendererBase", "doStart");
        Log.d("CameraGLRendererBase", "initSurfaceTexture");
        O00000o();
        int[] iArr = this.O0000oo0;
        if (iArr.length == 1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glTexParameteri(36197, 10241, 9728);
            GLES20.glTexParameteri(36197, 10240, 9728);
        }
        this.O0000o0O = new SurfaceTexture(this.O0000oo0[0]);
        this.O0000o0O.setOnFrameAvailableListener(this);
        O000000o(this.O0000o0);
        this.O0000oOO = true;
        if (this.O0000OOo > 0 && this.O0000Oo0 > 0) {
            O00000o0(this.O0000OOo, this.O0000Oo0);
        }
    }

    /* access modifiers changed from: protected */
    public void O00000Oo() {
        Log.d("CameraGLRendererBase", "doStop");
        synchronized (this) {
            this.O0000oO0 = false;
            this.O0000oOO = false;
            this.O0000o = false;
            O00000o0();
            O00000o();
        }
        this.O0000oOo.getCameraTextureListener();
    }

    private void O00000o0(int i, int i2) {
        synchronized (this) {
            this.O0000o = false;
            this.O0000OOo = i;
            this.O0000Oo0 = i2;
            O000000o(i, i2);
            O00000Oo(this.O0000OOo, this.O0000Oo0);
            this.O0000o = true;
        }
        this.O0000oOo.getCameraTextureListener();
    }

    public final void O00000Oo(int i) {
        O0000OOo();
        this.O0000o0 = i;
        O0000O0o();
    }

    public static void O00000oO() {
        Log.i("CameraGLRendererBase", "onResume");
    }

    public final void O00000oo() {
        Log.i("CameraGLRendererBase", "onPause");
        this.O0000o0o = false;
        O0000Oo0();
        this.O0000Oo0 = -1;
        this.O0000OOo = -1;
    }
}
