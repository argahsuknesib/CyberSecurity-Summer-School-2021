package com.xiaomi.smarthome.miio.camera.face.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.xiaomi.smarthome.miio.camera.face.util.CameraUtils;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CameraSurfaceView";
    private SurfaceHolder mSurfaceHolder;

    public CameraSurfaceView(Context context) {
        super(context);
        init();
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.mSurfaceHolder.setType(3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        CameraUtils.openFrontalCamera(30);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        CameraUtils.startPreviewDisplay(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        CameraUtils.releaseCamera();
    }
}
