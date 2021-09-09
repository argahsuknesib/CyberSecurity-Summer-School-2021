package com.xiaomi.qrcode2.camera;

import _m_j.etr;
import _m_j.ets;
import _m_j.ett;
import _m_j.etu;
import _m_j.etv;
import _m_j.etw;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.xiaomi.qrcode2.camera.open.CameraFacing;
import java.io.IOException;

public final class CameraManager {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f6610O000000o = "CameraManager";
    private final Context O00000Oo;
    private etv O00000o;
    private final ets O00000o0;
    private etr O00000oO;
    private Rect O00000oo;
    private Rect O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo = -1;
    private boolean O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private final etu O0000o00;

    public CameraManager(Context context) {
        this.O00000Oo = context;
        this.O00000o0 = new ets(context);
        this.O0000o00 = new etu(this.O00000o0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ets.O000000o(_m_j.etv, boolean):void
     arg types: [_m_j.etv, int]
     candidates:
      _m_j.ets.O000000o(android.hardware.Camera$Parameters, boolean):void
      _m_j.ets.O000000o(_m_j.etv, boolean):void */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x01b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x01d8 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c8  */
    public final synchronized void O000000o(SurfaceHolder surfaceHolder) throws IOException {
        String str;
        int i;
        etv etv = this.O00000o;
        if (etv == null) {
            etv = etw.O000000o(this.O0000Oo);
            if (etv != null) {
                this.O00000o = etv;
            } else {
                throw new IOException("Camera.open() failed to return object from driver");
            }
        }
        if (!this.O0000OOo) {
            this.O0000OOo = true;
            ets ets = this.O00000o0;
            Camera.Parameters parameters = etv.f15809O000000o.getParameters();
            Display defaultDisplay = ((WindowManager) ets.f15806O000000o.getSystemService("window")).getDefaultDisplay();
            int rotation = defaultDisplay.getRotation();
            if (rotation == 0) {
                i = 0;
            } else if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            } else if (rotation % 90 == 0) {
                i = (rotation + 360) % 360;
            } else {
                throw new IllegalArgumentException("Bad rotation: ".concat(String.valueOf(rotation)));
            }
            Log.i("CameraConfiguration", "Display at: ".concat(String.valueOf(i)));
            int i2 = etv.O00000o0;
            Log.i("CameraConfiguration", "Camera at: ".concat(String.valueOf(i2)));
            if (etv.O00000Oo == CameraFacing.FRONT) {
                i2 = (360 - i2) % 360;
                Log.i("CameraConfiguration", "Front camera overriden to: ".concat(String.valueOf(i2)));
            }
            ets.O00000o0 = ((i2 + 360) - i) % 360;
            Log.i("CameraConfiguration", "Final display orientation: " + ets.O00000o0);
            if (etv.O00000Oo == CameraFacing.FRONT) {
                Log.i("CameraConfiguration", "Compensating rotation for front camera");
                ets.O00000Oo = (360 - ets.O00000o0) % 360;
            } else {
                ets.O00000Oo = ets.O00000o0;
            }
            Log.i("CameraConfiguration", "Clockwise rotation from display to camera: " + ets.O00000Oo);
            Point point = new Point();
            defaultDisplay.getSize(point);
            ets.O00000o = point;
            Log.i("CameraConfiguration", "Screen resolution in current orientation: " + ets.O00000o);
            ets.O00000oO = ett.O000000o(parameters, ets.O00000o);
            Log.i("CameraConfiguration", "Camera resolution: " + ets.O00000oO);
            ets.O00000oo = ett.O000000o(parameters, ets.O00000o);
            Log.i("CameraConfiguration", "Best available preview size: " + ets.O00000oo);
            if ((ets.O00000o.x < ets.O00000o.y) == (ets.O00000oo.x < ets.O00000oo.y)) {
                ets.O0000O0o = ets.O00000oo;
            } else {
                ets.O0000O0o = new Point(ets.O00000oo.y, ets.O00000oo.x);
            }
            Log.i("CameraConfiguration", "Preview size on screen: " + ets.O0000O0o);
            if (this.O0000OoO > 0 && this.O0000Ooo > 0) {
                O000000o(this.O0000OoO, this.O0000Ooo);
                this.O0000OoO = 0;
                this.O0000Ooo = 0;
            }
        }
        Camera camera = etv.f15809O000000o;
        Camera.Parameters parameters2 = camera.getParameters();
        if (parameters2 == null) {
            str = null;
        } else {
            str = parameters2.flatten();
        }
        this.O00000o0.O000000o(etv, false);
        Log.w(f6610O000000o, "Camera rejected parameters. Setting only minimal safe-mode parameters");
        Log.i(f6610O000000o, "Resetting to saved camera params: ".concat(String.valueOf(str)));
        if (str != null) {
            Camera.Parameters parameters3 = camera.getParameters();
            parameters3.unflatten(str);
            camera.setParameters(parameters3);
            this.O00000o0.O000000o(etv, true);
            Log.w(f6610O000000o, "Camera rejected even safe-mode parameters! No configuration");
        }
        camera.setPreviewDisplay(surfaceHolder);
    }

    public final synchronized boolean O000000o() {
        return this.O00000o != null;
    }

    public final synchronized void O00000Oo() {
        if (this.O00000o != null) {
            this.O00000o.f15809O000000o.release();
            this.O00000o = null;
            this.O00000oo = null;
            this.O0000O0o = null;
        }
    }

    public final synchronized void O00000o0() {
        etv etv = this.O00000o;
        if (etv != null && !this.O0000Oo0) {
            etv.f15809O000000o.startPreview();
            this.O0000Oo0 = true;
            this.O00000oO = new etr(etv.f15809O000000o);
        }
    }

    public final synchronized void O00000o() {
        if (this.O00000oO != null) {
            this.O00000oO.O00000Oo();
            this.O00000oO = null;
        }
        if (this.O00000o != null && this.O0000Oo0) {
            this.O00000o.f15809O000000o.stopPreview();
            this.O0000o00.O000000o(null, 0);
            this.O0000Oo0 = false;
        }
    }

    public final synchronized void O000000o(boolean z) {
        String flashMode;
        etv etv = this.O00000o;
        if (etv != null) {
            Camera camera = etv.f15809O000000o;
            boolean z2 = true;
            if (z != ((camera == null || camera.getParameters() == null || (flashMode = camera.getParameters().getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true)) {
                if (this.O00000oO == null) {
                    z2 = false;
                }
                if (z2) {
                    this.O00000oO.O00000Oo();
                    this.O00000oO = null;
                }
                ets ets = this.O00000o0;
                Camera camera2 = etv.f15809O000000o;
                Camera.Parameters parameters = camera2.getParameters();
                ets.O000000o(parameters, z);
                camera2.setParameters(parameters);
                if (z2) {
                    this.O00000oO = new etr(etv.f15809O000000o);
                    this.O00000oO.O000000o();
                }
            }
        }
    }

    public final synchronized void O000000o(Handler handler) {
        etv etv = this.O00000o;
        if (etv != null && this.O0000Oo0) {
            this.O0000o00.O000000o(handler, 5);
            etv.f15809O000000o.setOneShotPreviewCallback(this.O0000o00);
        }
    }

    public final synchronized Rect O00000oO() {
        if (this.O00000oo == null) {
            if (this.O00000o == null) {
                return null;
            }
            Point point = this.O00000o0.O00000o;
            if (point == null) {
                return null;
            }
            int i = this.O00000o0.O0000OOo;
            int i2 = (point.x - i) / 2;
            int i3 = this.O00000o0.O0000Oo0;
            this.O00000oo = new Rect(i2, i3, i2 + i, i + i3);
            String str = f6610O000000o;
            Log.d(str, "Calculated framing rect: " + this.O00000oo);
        }
        return this.O00000oo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0087, code lost:
        return null;
     */
    public final synchronized Rect O00000oo() {
        if (this.O0000O0o == null) {
            Rect O00000oO2 = O00000oO();
            if (O00000oO2 == null) {
                return null;
            }
            Rect rect = new Rect(O00000oO2);
            Point point = this.O00000o0.O00000oO;
            Point point2 = this.O00000o0.O00000o;
            if (point != null) {
                if (point2 != null) {
                    this.O0000O0o = new Rect();
                    this.O0000O0o.left = (rect.top * point.x) / point2.y;
                    this.O0000O0o.top = ((point2.x - rect.right) * point.y) / point2.x;
                    int max = Math.max((rect.height() * point.x) / point2.y, (rect.width() * point.y) / point2.x);
                    this.O0000O0o.right = this.O0000O0o.left + max;
                    this.O0000O0o.bottom = this.O0000O0o.top + max;
                    String str = f6610O000000o;
                    Log.d(str, "getFramingRectInPreview:" + this.O0000O0o);
                }
            }
        }
        return this.O0000O0o;
    }

    private synchronized void O000000o(int i, int i2) {
        if (this.O0000OOo) {
            Point point = this.O00000o0.O00000o;
            if (i > point.x) {
                i = point.x;
            }
            if (i2 > point.y) {
                i2 = point.y;
            }
            int i3 = (point.x - i) / 2;
            int i4 = (point.y - i2) / 2;
            this.O00000oo = new Rect(i3, i4, i + i3, i2 + i4);
            String str = f6610O000000o;
            Log.d(str, "Calculated manual framing rect: " + this.O00000oo);
            this.O0000O0o = null;
            return;
        }
        this.O0000OoO = i;
        this.O0000Ooo = i2;
    }
}
