package com.xiaomi.smarthome.fastvideo;

import android.content.Context;
import android.opengl.GLES20;
import com.mijia.generalplayer.gl.GlslFilter;

public class YUVFilter extends GlslFilter {

    /* renamed from: O000000o  reason: collision with root package name */
    int f7368O000000o;
    int O00000Oo;
    public int[] O00000o;
    int O00000o0;
    private final String O0000o00 = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nvoid main() {\n  float y = texture2D(y_tex, textureCoordinate).r;\n  float u = texture2D(u_tex, textureCoordinate).r - 0.5;\n  float v = texture2D(v_tex, textureCoordinate).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1.0);\n}\n";

    public final String O000000o() {
        return "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nvoid main() {\n  float y = texture2D(y_tex, textureCoordinate).r;\n  float u = texture2D(u_tex, textureCoordinate).r - 0.5;\n  float v = texture2D(v_tex, textureCoordinate).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1.0);\n}\n";
    }

    public YUVFilter(Context context) {
        super(context);
    }

    public final void O00000Oo() {
        super.O00000Oo();
        this.f7368O000000o = GLES20.glGetUniformLocation(this.O00000oo, "y_tex");
        this.O00000Oo = GLES20.glGetUniformLocation(this.O00000oo, "u_tex");
        this.O00000o0 = GLES20.glGetUniformLocation(this.O00000oo, "v_tex");
    }

    public final void O00000o0() {
        super.O00000o0();
        O000000o("setYuvTextures");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.O00000o[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.f7368O000000o, 0);
        O000000o("glBindTexture y");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.O00000o[1]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.O00000Oo, 1);
        O000000o("glBindTexture u");
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.O00000o[2]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glUniform1i(this.O00000o0, 2);
        O000000o("glBindTexture v");
    }
}
