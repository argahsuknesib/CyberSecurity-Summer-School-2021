package org.opencv.android;

import _m_j.jlj;
import _m_j.jlk;
import _m_j.jll;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import com.xiaomi.smarthome.R;

public class CameraGLSurfaceView extends GLSurfaceView {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f15455O000000o;
    private jlk O00000Oo;

    public interface O000000o {
        boolean O000000o();
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.camera_id, R.attr.show_fps});
        int i = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.O00000Oo = new jlj(this);
        } else {
            this.O00000Oo = new jll(this);
        }
        setCameraIndex(i);
        setEGLContextClientVersion(2);
        setRenderer(this.O00000Oo);
        setRenderMode(0);
    }

    public void setCameraTextureListener(O000000o o000000o) {
        this.f15455O000000o = o000000o;
    }

    public O000000o getCameraTextureListener() {
        return this.f15455O000000o;
    }

    public void setCameraIndex(int i) {
        this.O00000Oo.O00000Oo(i);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.O00000Oo.O0000o0o = false;
        super.surfaceDestroyed(surfaceHolder);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void onResume() {
        Log.i("CameraGLSurfaceView", "onResume");
        super.onResume();
        jlk.O00000oO();
    }

    public void onPause() {
        Log.i("CameraGLSurfaceView", "onPause");
        this.O00000Oo.O00000oo();
        super.onPause();
    }
}
