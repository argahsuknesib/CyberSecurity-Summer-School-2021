package com.google.android.exoplayer2.video;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class VideoDecoderRenderer implements GLSurfaceView.Renderer, VideoDecoderOutputBufferRenderer {
    private static final String[] TEXTURE_UNIFORMS = {"y_tex", "u_tex", "v_tex"};
    private static final FloatBuffer TEXTURE_VERTICES = GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    private static final float[] kColorConversion2020 = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
    private static final float[] kColorConversion601 = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
    private static final float[] kColorConversion709 = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
    private int colorMatrixLocation;
    private final AtomicReference<VideoDecoderOutputBuffer> pendingOutputBufferReference;
    private int[] previousStrides;
    private int[] previousWidths;
    private int program;
    private VideoDecoderOutputBuffer renderedOutputBuffer;
    private final GLSurfaceView surfaceView;
    private int[] texLocations;
    private FloatBuffer[] textureCoords;
    private final int[] yuvTextures = new int[3];

    public VideoDecoderRenderer(GLSurfaceView gLSurfaceView) {
        this.surfaceView = gLSurfaceView;
        this.pendingOutputBufferReference = new AtomicReference<>();
        this.textureCoords = new FloatBuffer[3];
        this.texLocations = new int[3];
        this.previousWidths = new int[3];
        this.previousStrides = new int[3];
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.previousWidths;
            this.previousStrides[i] = -1;
            iArr[i] = -1;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
     arg types: [int, int, int, int, int, java.nio.FloatBuffer]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void} */
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.program = GlUtil.compileProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        GLES20.glUseProgram(this.program);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.program, "in_pos");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) TEXTURE_VERTICES);
        this.texLocations[0] = GLES20.glGetAttribLocation(this.program, "in_tc_y");
        GLES20.glEnableVertexAttribArray(this.texLocations[0]);
        this.texLocations[1] = GLES20.glGetAttribLocation(this.program, "in_tc_u");
        GLES20.glEnableVertexAttribArray(this.texLocations[1]);
        this.texLocations[2] = GLES20.glGetAttribLocation(this.program, "in_tc_v");
        GLES20.glEnableVertexAttribArray(this.texLocations[2]);
        GlUtil.checkGlError();
        this.colorMatrixLocation = GLES20.glGetUniformLocation(this.program, "mColorConversion");
        GlUtil.checkGlError();
        setupTextures();
        GlUtil.checkGlError();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void}
     arg types: [int, int, int, int, int, java.nio.FloatBuffer]
     candidates:
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, int):void}
      ClspMth{android.opengl.GLES20.glVertexAttribPointer(int, int, int, boolean, int, java.nio.Buffer):void} */
    public void onDrawFrame(GL10 gl10) {
        VideoDecoderOutputBuffer andSet = this.pendingOutputBufferReference.getAndSet(null);
        if (andSet != null || this.renderedOutputBuffer != null) {
            if (andSet != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.renderedOutputBuffer;
                if (videoDecoderOutputBuffer != null) {
                    videoDecoderOutputBuffer.release();
                }
                this.renderedOutputBuffer = andSet;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.renderedOutputBuffer;
            float[] fArr = kColorConversion709;
            int i = videoDecoderOutputBuffer2.colorspace;
            if (i == 1) {
                fArr = kColorConversion601;
            } else if (i == 3) {
                fArr = kColorConversion2020;
            }
            GLES20.glUniformMatrix3fv(this.colorMatrixLocation, 1, false, fArr, 0);
            int i2 = 0;
            while (i2 < 3) {
                int i3 = i2 == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
                GLES20.glActiveTexture(33984 + i2);
                GLES20.glBindTexture(3553, this.yuvTextures[i2]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, videoDecoderOutputBuffer2.yuvStrides[i2], i3, 0, 6409, 5121, videoDecoderOutputBuffer2.yuvPlanes[i2]);
                i2++;
            }
            int[] iArr = new int[3];
            iArr[0] = videoDecoderOutputBuffer2.width;
            int i4 = (iArr[0] + 1) / 2;
            iArr[2] = i4;
            iArr[1] = i4;
            for (int i5 = 0; i5 < 3; i5++) {
                if (this.previousWidths[i5] != iArr[i5] || this.previousStrides[i5] != videoDecoderOutputBuffer2.yuvStrides[i5]) {
                    Assertions.checkState(videoDecoderOutputBuffer2.yuvStrides[i5] != 0);
                    float f = ((float) iArr[i5]) / ((float) videoDecoderOutputBuffer2.yuvStrides[i5]);
                    this.textureCoords[i5] = GlUtil.createBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                    GLES20.glVertexAttribPointer(this.texLocations[i5], 2, 5126, false, 0, (Buffer) this.textureCoords[i5]);
                    this.previousWidths[i5] = iArr[i5];
                    this.previousStrides[i5] = videoDecoderOutputBuffer2.yuvStrides[i5];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
        }
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        VideoDecoderOutputBuffer andSet = this.pendingOutputBufferReference.getAndSet(videoDecoderOutputBuffer);
        if (andSet != null) {
            andSet.release();
        }
        this.surfaceView.requestRender();
    }

    private void setupTextures() {
        GLES20.glGenTextures(3, this.yuvTextures, 0);
        for (int i = 0; i < 3; i++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.program, TEXTURE_UNIFORMS[i]), i);
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, this.yuvTextures[i]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        GlUtil.checkGlError();
    }
}
