package _m_j;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

final class inp implements inv {
    private static final Camera.PreviewCallback O00000Oo = new Camera.PreviewCallback() {
        /* class _m_j.inp.AnonymousClass1 */

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    };
    private static final SurfaceHolder.Callback O00000o0 = new SurfaceHolder.Callback() {
        /* class _m_j.inp.AnonymousClass2 */

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private SurfaceHolder f1502O000000o;

    inp(Context context) {
        this.f1502O000000o = new SurfaceView(context).getHolder();
        this.f1502O000000o.addCallback(O00000o0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    public final boolean O000000o() throws Throwable {
        Camera camera;
        try {
            camera = Camera.open();
            try {
                camera.setParameters(camera.getParameters());
                camera.setPreviewDisplay(this.f1502O000000o);
                camera.setPreviewCallback(O00000Oo);
                camera.startPreview();
                if (camera == null) {
                    return true;
                }
                camera.stopPreview();
                camera.setPreviewDisplay(null);
                camera.setPreviewCallback(null);
                camera.release();
                return true;
            } catch (Throwable th) {
                th = th;
                if (camera != null) {
                    camera.stopPreview();
                    camera.setPreviewDisplay(null);
                    camera.setPreviewCallback(null);
                    camera.release();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            camera = null;
            if (camera != null) {
            }
            throw th;
        }
    }
}
