package _m_j;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

final class iou implements ipb {
    private static final Camera.PreviewCallback O00000Oo = new Camera.PreviewCallback() {
        /* class _m_j.iou.AnonymousClass1 */

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    };
    private static final SurfaceHolder.Callback O00000o0 = new SurfaceHolder.Callback() {
        /* class _m_j.iou.AnonymousClass2 */

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1524O000000o;

    iou(Context context) {
        this.f1524O000000o = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r0 = !r5.f1524O000000o.getPackageManager().hasSystemFeature("android.hardware.camera");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r3 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r3.stopPreview();
        r3.setPreviewDisplay(null);
        r3.setPreviewCallback(null);
        r3.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    public final boolean O000000o() throws Throwable {
        Camera camera;
        SurfaceHolder holder = new SurfaceView(this.f1524O000000o).getHolder();
        holder.addCallback(O00000o0);
        try {
            camera = Camera.open();
            camera.setParameters(camera.getParameters());
            camera.setPreviewDisplay(holder);
            camera.setPreviewCallback(O00000Oo);
            camera.startPreview();
            if (camera != null) {
                camera.stopPreview();
                camera.setPreviewDisplay(null);
                camera.setPreviewCallback(null);
                camera.release();
            }
            return true;
        } catch (Throwable th) {
            th = th;
            camera = null;
            if (camera != null) {
                camera.stopPreview();
                camera.setPreviewDisplay(null);
                camera.setPreviewCallback(null);
                camera.release();
            }
            throw th;
        }
    }
}
