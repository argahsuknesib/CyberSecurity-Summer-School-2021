package _m_j;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import com.xiaomi.qrcode2.camera.FrontLightMode;
import com.xiaomi.smarthome.R;

public final class ets {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f15806O000000o;
    public int O00000Oo;
    public Point O00000o;
    public int O00000o0;
    public Point O00000oO;
    public Point O00000oo;
    public Point O0000O0o;
    public int O0000OOo;
    public int O0000Oo0;

    public ets(Context context) {
        this.f15806O000000o = context;
        this.O0000OOo = context.getResources().getDimensionPixelSize(R.dimen.scan_view_size);
        this.O0000Oo0 = context.getResources().getDimensionPixelSize(R.dimen.scan_view_top);
    }

    public final void O000000o(Camera.Parameters parameters, boolean z) {
        ett.O00000Oo(parameters, z);
        PreferenceManager.getDefaultSharedPreferences(this.f15806O000000o);
    }

    public final void O000000o(etv etv, boolean z) {
        Camera camera = etv.f15809O000000o;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        O000000o(parameters, FrontLightMode.readPref(PreferenceManager.getDefaultSharedPreferences(this.f15806O000000o)) == FrontLightMode.ON);
        ett.O000000o(parameters, z);
        if (!z) {
            ett.O00000o0(parameters);
            ett.O000000o(parameters);
            ett.O00000Oo(parameters);
        }
        parameters.setPreviewSize(this.O00000oo.x, this.O00000oo.y);
        camera.setParameters(parameters);
        camera.setDisplayOrientation(this.O00000o0);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize == null) {
            return;
        }
        if (this.O00000oo.x != previewSize.width || this.O00000oo.y != previewSize.height) {
            Log.w("CameraConfiguration", "Camera said it supported preview size " + this.O00000oo.x + 'x' + this.O00000oo.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.O00000oo.x = previewSize.width;
            this.O00000oo.y = previewSize.height;
        }
    }
}
