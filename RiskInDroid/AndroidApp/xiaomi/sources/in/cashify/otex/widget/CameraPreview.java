package in.cashify.otex.widget;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f12275O000000o = "CameraPreview";
    public Camera O00000Oo;
    public O000000o O00000o;
    public Camera.Size O00000o0;
    public boolean O00000oO;

    public interface O000000o {
        void O000000o();
    }

    public CameraPreview(Context context) {
        super(context);
        O00000Oo();
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    private void O00000Oo() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setType(3);
    }

    public final void O000000o() {
        Camera camera = this.O00000Oo;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.O00000Oo.release();
                this.O00000Oo = null;
            } catch (Throwable unused) {
            }
        }
    }

    public void setPreviewSize(Camera.Size size) {
        this.O00000o0 = size;
    }

    public void setPreviewStartListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Camera camera;
        if (surfaceHolder.getSurface() != null && (camera = this.O00000Oo) != null) {
            camera.stopPreview();
            try {
                this.O00000Oo.reconnect();
                Camera.Parameters parameters = this.O00000Oo.getParameters();
                parameters.setPreviewSize(this.O00000o0.width, this.O00000o0.height);
                requestLayout();
                this.O00000Oo.setParameters(parameters);
                this.O00000Oo.setPreviewDisplay(surfaceHolder);
                this.O00000Oo.startPreview();
            } catch (Exception e) {
                String str = f12275O000000o;
                Log.d(str, "Error starting camera preview: " + e.getMessage());
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.O00000oO = true;
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        try {
            this.O00000oO = false;
            this.O00000Oo.stopPreview();
        } catch (RuntimeException unused) {
        }
    }
}
