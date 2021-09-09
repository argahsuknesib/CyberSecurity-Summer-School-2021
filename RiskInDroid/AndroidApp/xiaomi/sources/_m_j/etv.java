package _m_j;

import android.hardware.Camera;
import com.xiaomi.qrcode2.camera.open.CameraFacing;

public final class etv {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Camera f15809O000000o;
    public final CameraFacing O00000Oo;
    private final int O00000o;
    public final int O00000o0;

    public etv(int i, Camera camera, CameraFacing cameraFacing, int i2) {
        this.O00000o = i;
        this.f15809O000000o = camera;
        this.O00000Oo = cameraFacing;
        this.O00000o0 = i2;
    }

    public final String toString() {
        return "Camera #" + this.O00000o + " : " + this.O00000Oo + ',' + this.O00000o0;
    }
}
