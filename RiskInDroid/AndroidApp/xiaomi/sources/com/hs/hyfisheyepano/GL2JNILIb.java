package com.hs.hyfisheyepano;

import android.util.Log;

public class GL2JNILIb {
    public static native void DeleteGLBuffer(int i);

    public static native void GLYUVClear(int i, int i2);

    public static native void GLYUVClearAll(int i);

    public static native void GLYUVClearSurface(int i);

    public static native void GLYUVFisheyeDblClickView(int i, float f, float f2);

    public static native void GLYUVFisheyeFlipView(int i, float f, float f2);

    public static native void GLYUVFisheyeHoverView(int i, float f, float f2, float f3, float f4);

    public static native void GLYUVFisheyeMoveView(int i, float f, float f2);

    public static native void GLYUVFisheyeOFF(int i);

    public static native void GLYUVFisheyeON(int i, int i2);

    public static native void GLYUVFisheyePressView(int i, boolean z, float f, float f2);

    public static native void GLYUVFisheyeSetExpandMode(int i, int i2);

    public static native void GLYUVFisheyeZoomView(int i, float f);

    public static native int GLYUVInit(int i, int i2);

    public static native void GLYUVRender(int i);

    public static native void GLYUVResize(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void GLYUVSetImage(int i, int i2, int i3, byte[] bArr, int i4, int i5, int i6);

    public static native void GLYUVSetPanoParam(int i, int i2, int i3, float f, float f2, float f3);

    public static native void GLYUVSetPositionON(int i, int i2, boolean z);

    public static native void GLYUVSetScale(int i, boolean z);

    public static native void GLYUVSetSelected(int i, int i2);

    public static native float GetZoom(int i);

    public static native void ResetZoomView(int i);

    public static native void SelectedBoxColor(int i, float f, float f2, float f3, float f4);

    public static native void ZoomView(int i);

    public static native String getCopyRight();

    public static native void printCopyRight();

    static {
        try {
            System.loadLibrary("HYFisheyePano");
        } catch (UnsatisfiedLinkError unused) {
            Log.e("HYFisheyePano", "Can't  link the lib.");
        }
    }
}
