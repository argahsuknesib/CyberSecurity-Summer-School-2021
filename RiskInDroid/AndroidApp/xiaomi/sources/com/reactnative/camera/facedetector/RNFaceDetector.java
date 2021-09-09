package com.reactnative.camera.facedetector;

import _m_j.ctl;
import _m_j.cts;
import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class RNFaceDetector {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f5478O000000o = 1;
    public static int O00000Oo = 0;
    public static int O00000o = 0;
    public static int O00000o0 = 1;
    public static int O00000oO = 1;
    public static int O00000oo;
    public FaceDetector.Builder O0000O0o = null;
    private FaceDetector O0000OOo = null;
    private int O0000Oo = O00000Oo;
    private cts O0000Oo0;
    private int O0000OoO = O00000o;
    private float O0000Ooo = 0.15f;
    private int O0000o00 = O00000oo;

    public RNFaceDetector(Context context) {
        this.O0000O0o = new FaceDetector.Builder(context);
        this.O0000O0o.setMinFaceSize(this.O0000Ooo);
        this.O0000O0o.setMode(this.O0000o00);
        this.O0000O0o.setLandmarkType(this.O0000OoO);
        this.O0000O0o.setClassificationType(this.O0000Oo);
    }

    public final boolean O000000o() {
        if (this.O0000OOo == null) {
            O00000o();
        }
        return this.O0000OOo.isOperational();
    }

    public final void O000000o(int i) {
        if (i != this.O0000Oo) {
            O00000Oo();
            this.O0000O0o.setClassificationType(i);
            this.O0000Oo = i;
        }
    }

    public final void O00000Oo(int i) {
        if (i != this.O0000OoO) {
            O00000Oo();
            this.O0000O0o.setLandmarkType(i);
            this.O0000OoO = i;
        }
    }

    public final void O00000o0(int i) {
        if (i != this.O0000o00) {
            O00000Oo();
            this.O0000O0o.setMode(i);
            this.O0000o00 = i;
        }
    }

    public final void O00000Oo() {
        O00000o0();
        this.O0000Oo0 = null;
    }

    private void O00000o0() {
        FaceDetector faceDetector = this.O0000OOo;
        if (faceDetector != null) {
            faceDetector.release();
            this.O0000OOo = null;
        }
    }

    private void O00000o() {
        this.O0000OOo = this.O0000O0o.build();
    }

    public final SparseArray<Face> O000000o(ctl ctl) {
        if (!ctl.O00000Oo.equals(this.O0000Oo0)) {
            O00000o0();
        }
        if (this.O0000OOo == null) {
            O00000o();
            this.O0000Oo0 = ctl.O00000Oo;
        }
        return this.O0000OOo.detect(ctl.f14345O000000o);
    }
}
