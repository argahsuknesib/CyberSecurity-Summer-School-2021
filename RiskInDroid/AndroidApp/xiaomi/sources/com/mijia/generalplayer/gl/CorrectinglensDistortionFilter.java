package com.mijia.generalplayer.gl;

import _m_j.cjt;
import android.content.Context;

public class CorrectinglensDistortionFilter extends GlslFilter {

    /* renamed from: O000000o  reason: collision with root package name */
    cjt.O00000Oo f5195O000000o = new cjt.O00000o0("correctionRadius");
    cjt.O00000Oo O00000Oo;
    cjt.O000000o O00000o;
    cjt.O000000o O00000o0;
    private final String O0000o00 = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float correctionRadius;\nuniform float zoom;\n uniform float osdx;\n uniform float osdy;\n void main()\n{\nif(textureCoordinate.x<osdx && textureCoordinate.y<osdy){\ngl_FragColor = texture2D(inputImageTexture, textureCoordinate);\nreturn;\n}\nhighp vec2 newCoor = textureCoordinate-vec2(0.5,0.5);\nhighp float dis = length(newCoor);\nhighp float r = dis / correctionRadius;\nhighp float theta = zoom*1.0;\n if(r>0.0){\ntheta = atan(r) / r;\n}\nhighp vec2 newTextureCoor = vec2(0.5,0.5)+newCoor*theta;\ngl_FragColor = texture2D(inputImageTexture, newTextureCoor);\n}";

    public final String O000000o() {
        return "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float correctionRadius;\nuniform float zoom;\n uniform float osdx;\n uniform float osdy;\n void main()\n{\nif(textureCoordinate.x<osdx && textureCoordinate.y<osdy){\ngl_FragColor = texture2D(inputImageTexture, textureCoordinate);\nreturn;\n}\nhighp vec2 newCoor = textureCoordinate-vec2(0.5,0.5);\nhighp float dis = length(newCoor);\nhighp float r = dis / correctionRadius;\nhighp float theta = zoom*1.0;\n if(r>0.0){\ntheta = atan(r) / r;\n}\nhighp vec2 newTextureCoor = vec2(0.5,0.5)+newCoor*theta;\ngl_FragColor = texture2D(inputImageTexture, newTextureCoor);\n}";
    }

    public CorrectinglensDistortionFilter(Context context) {
        super(context);
        O000000o(this.f5195O000000o);
        this.O00000Oo = new cjt.O00000Oo("zoom", 1.0f, 0.5f, 2.0f);
        O000000o(this.O00000Oo);
        this.O00000o0 = new cjt.O000000o("osdx", 0.0f);
        O000000o(this.O00000o0);
        this.O00000o = new cjt.O000000o("osdy", 0.0f);
        O000000o(this.O00000o);
    }

    public final void O000000o(float f, float f2) {
        this.O00000o0.O000000o(f);
        this.O00000o.O000000o(f2);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        super.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        super.O00000o0();
    }
}
