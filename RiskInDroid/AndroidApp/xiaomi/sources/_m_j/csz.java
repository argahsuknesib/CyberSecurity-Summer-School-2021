package _m_j;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class csz {
    private static csz O0000O0o;
    private static final O00000Oo O0000Oo = new O00000Oo(1280, 720);
    private static final O00000Oo O0000Oo0 = new O00000Oo(853, 480);
    private static final O00000Oo O0000OoO = new O00000Oo(1920, 1080);

    /* renamed from: O000000o  reason: collision with root package name */
    public final HashMap<Integer, O000000o> f14326O000000o = new HashMap<>();
    public final Map<Number, Camera> O00000Oo = new HashMap();
    public List<String> O00000o = null;
    public boolean O00000o0 = false;
    public int O00000oO = -1;
    public int O00000oo = 0;
    private final HashMap<Integer, Integer> O0000OOo = new HashMap<>();
    private int O0000Ooo = 0;

    public static csz O000000o() {
        return O0000O0o;
    }

    public static void O000000o(int i) {
        O0000O0o = new csz(i);
    }

    public final synchronized Camera O00000Oo(int i) {
        if (this.O00000Oo.get(Integer.valueOf(i)) == null && this.O0000OOo.get(Integer.valueOf(i)) != null) {
            try {
                this.O00000Oo.put(Integer.valueOf(i), Camera.open(this.O0000OOo.get(Integer.valueOf(i)).intValue()));
                O00000oo(i);
            } catch (Exception e) {
                Log.e("RCTCamera", "acquireCameraInstance failed", e);
            }
        }
        return this.O00000Oo.get(Integer.valueOf(i));
    }

    public final void O00000o0(int i) {
        Camera camera = this.O00000Oo.get(Integer.valueOf(i));
        if (camera != null) {
            this.O00000Oo.remove(Integer.valueOf(i));
            camera.release();
        }
    }

    public final int O00000o(int i) {
        O000000o o000000o = this.f14326O000000o.get(Integer.valueOf(i));
        if (o000000o == null) {
            return 0;
        }
        return o000000o.O00000o0;
    }

    public final int O00000oO(int i) {
        O000000o o000000o = this.f14326O000000o.get(Integer.valueOf(i));
        if (o000000o == null) {
            return 0;
        }
        return o000000o.O00000o;
    }

    public static Camera.Size O000000o(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (next.width <= i && next.height <= i2) {
                if (size == null || next.width * next.height > size.width * size.height) {
                    size = next;
                }
            }
        }
        return size;
    }

    private static Camera.Size O000000o(List<Camera.Size> list) {
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (size == null || next.width * next.height < size.width * size.height) {
                size = next;
            }
        }
        return size;
    }

    protected static List<Camera.Size> O000000o(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            return supportedVideoSizes;
        }
        return parameters.getSupportedPreviewSizes();
    }

    public final void O000000o(int i, String str) {
        Camera O00000Oo2 = O00000Oo(i);
        if (O00000Oo2 != null) {
            Camera.Parameters parameters = O00000Oo2.getParameters();
            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
            char c = 65535;
            switch (str.hashCode()) {
                case -1078030475:
                    if (str.equals("medium")) {
                        c = 1;
                        break;
                    }
                    break;
                case -318184504:
                    if (str.equals("preview")) {
                        c = 3;
                        break;
                    }
                    break;
                case 107348:
                    if (str.equals("low")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1604548:
                    if (str.equals("480p")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1688155:
                    if (str.equals("720p")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3202466:
                    if (str.equals("high")) {
                        c = 2;
                        break;
                    }
                    break;
                case 46737913:
                    if (str.equals("1080p")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            Camera.Size size = null;
            switch (c) {
                case 0:
                    size = O000000o(supportedPictureSizes);
                    break;
                case 1:
                    size = supportedPictureSizes.get(supportedPictureSizes.size() / 2);
                    break;
                case 2:
                    size = O000000o(parameters.getSupportedPictureSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
                    break;
                case 3:
                    Camera.Size O000000o2 = O000000o(parameters.getSupportedPreviewSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
                    List<Camera.Size> supportedPictureSizes2 = parameters.getSupportedPictureSizes();
                    int i2 = O000000o2.width;
                    int i3 = O000000o2.height;
                    for (Camera.Size next : supportedPictureSizes2) {
                        if (size != null) {
                            if (Math.sqrt(Math.pow((double) (next.width - i2), 2.0d) + Math.pow((double) (next.height - i3), 2.0d)) >= Math.sqrt(Math.pow((double) (size.width - i2), 2.0d) + Math.pow((double) (size.height - i3), 2.0d))) {
                            }
                        }
                        size = next;
                    }
                    break;
                case 4:
                    size = O000000o(supportedPictureSizes, O0000Oo0.f14328O000000o, O0000Oo0.O00000Oo);
                    break;
                case 5:
                    size = O000000o(supportedPictureSizes, O0000Oo.f14328O000000o, O0000Oo.O00000Oo);
                    break;
                case 6:
                    size = O000000o(supportedPictureSizes, O0000OoO.f14328O000000o, O0000OoO.O00000Oo);
                    break;
            }
            if (size != null) {
                parameters.setPictureSize(size.width, size.height);
                O00000Oo2.setParameters(parameters);
            }
        }
    }

    public final CamcorderProfile O00000Oo(int i, String str) {
        Camera.Size size;
        CamcorderProfile camcorderProfile;
        Camera O00000Oo2 = O00000Oo(i);
        if (O00000Oo2 == null) {
            return null;
        }
        List<Camera.Size> O000000o2 = O000000o(O00000Oo2);
        char c = 65535;
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals("medium")) {
                    c = 1;
                    break;
                }
                break;
            case 107348:
                if (str.equals("low")) {
                    c = 0;
                    break;
                }
                break;
            case 1604548:
                if (str.equals("480p")) {
                    c = 3;
                    break;
                }
                break;
            case 1688155:
                if (str.equals("720p")) {
                    c = 4;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    c = 2;
                    break;
                }
                break;
            case 46737913:
                if (str.equals("1080p")) {
                    c = 5;
                    break;
                }
                break;
        }
        if (c == 0) {
            size = O000000o(O000000o2);
            camcorderProfile = CamcorderProfile.get(this.O0000OOo.get(Integer.valueOf(i)).intValue(), 4);
        } else if (c == 1) {
            size = O000000o2.get(O000000o2.size() / 2);
            camcorderProfile = CamcorderProfile.get(this.O0000OOo.get(Integer.valueOf(i)).intValue(), 5);
        } else if (c == 2) {
            size = O000000o(O000000o2, Integer.MAX_VALUE, Integer.MAX_VALUE);
            camcorderProfile = CamcorderProfile.get(this.O0000OOo.get(Integer.valueOf(i)).intValue(), 1);
        } else if (c == 3) {
            size = O000000o(O000000o2, O0000Oo0.f14328O000000o, O0000Oo0.O00000Oo);
            camcorderProfile = CamcorderProfile.get(this.O0000OOo.get(Integer.valueOf(i)).intValue(), 4);
        } else if (c == 4) {
            size = O000000o(O000000o2, O0000Oo.f14328O000000o, O0000Oo.O00000Oo);
            camcorderProfile = CamcorderProfile.get(this.O0000OOo.get(Integer.valueOf(i)).intValue(), 5);
        } else if (c != 5) {
            camcorderProfile = null;
            size = null;
        } else {
            size = O000000o(O000000o2, O0000OoO.f14328O000000o, O0000OoO.O00000Oo);
            camcorderProfile = CamcorderProfile.get(this.O0000OOo.get(Integer.valueOf(i)).intValue(), 6);
        }
        if (camcorderProfile == null) {
            return null;
        }
        if (size != null) {
            camcorderProfile.videoFrameHeight = size.height;
            camcorderProfile.videoFrameWidth = size.width;
        }
        return camcorderProfile;
    }

    public final void O000000o(int i, int i2) {
        Camera O00000Oo2 = O00000Oo(i);
        if (O00000Oo2 != null) {
            Camera.Parameters parameters = O00000Oo2.getParameters();
            String flashMode = parameters.getFlashMode();
            if (i2 == 0) {
                flashMode = "off";
            } else if (i2 == 1) {
                flashMode = "torch";
            }
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains(flashMode)) {
                parameters.setFlashMode(flashMode);
                O00000Oo2.setParameters(parameters);
            }
        }
    }

    public final void O00000Oo(int i, int i2) {
        Camera O00000Oo2 = O00000Oo(i);
        if (O00000Oo2 != null) {
            Camera.Parameters parameters = O00000Oo2.getParameters();
            String flashMode = parameters.getFlashMode();
            if (i2 == 0) {
                flashMode = "off";
            } else if (i2 == 1) {
                flashMode = "on";
            } else if (i2 == 2) {
                flashMode = "auto";
            }
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes != null && supportedFlashModes.contains(flashMode)) {
                parameters.setFlashMode(flashMode);
                O00000Oo2.setParameters(parameters);
            }
        }
    }

    public final void O00000o0(int i, int i2) {
        Camera O00000Oo2 = O00000Oo(i);
        if (O00000Oo2 != null) {
            Camera.Parameters parameters = O00000Oo2.getParameters();
            int maxZoom = parameters.getMaxZoom();
            if (parameters.isZoomSupported() && i2 >= 0 && i2 < maxZoom) {
                parameters.setZoom(i2);
                O00000Oo2.setParameters(parameters);
            }
        }
    }

    public final void O00000oo(int i) {
        int i2;
        int i3;
        Camera camera = this.O00000Oo.get(Integer.valueOf(i));
        if (camera != null) {
            O000000o o000000o = this.f14326O000000o.get(Integer.valueOf(i));
            int i4 = o000000o.f14327O000000o.orientation;
            if (o000000o.f14327O000000o.facing == 1) {
                int i5 = this.O00000oo;
                i2 = ((i5 * 90) + i4) % 360;
                i3 = ((720 - i4) - (i5 * 90)) % 360;
            } else {
                i2 = ((i4 - (this.O00000oo * 90)) + 360) % 360;
                i3 = i2;
            }
            o000000o.O00000Oo = i2;
            this.O0000Ooo = i2;
            camera.setDisplayOrientation(i3);
            Camera.Parameters parameters = camera.getParameters();
            parameters.setRotation(o000000o.O00000Oo);
            Camera.Size O000000o2 = O000000o(parameters.getSupportedPreviewSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
            int i6 = O000000o2.width;
            int i7 = O000000o2.height;
            parameters.setPreviewSize(i6, i7);
            try {
                camera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (o000000o.O00000Oo == 0 || o000000o.O00000Oo == 180) {
                o000000o.O00000o0 = i6;
                o000000o.O00000o = i7;
                return;
            }
            o000000o.O00000o0 = i7;
            o000000o.O00000o = i6;
        }
    }

    public final void O000000o(int i, int i2, int i3) {
        O000000o o000000o = this.f14326O000000o.get(Integer.valueOf(i));
        if (o000000o != null) {
            o000000o.O00000oO = i2;
            o000000o.O00000oo = i3;
        }
    }

    private csz(int i) {
        this.O00000oo = i;
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1 && this.f14326O000000o.get(1) == null) {
                this.f14326O000000o.put(1, new O000000o(cameraInfo));
                this.O0000OOo.put(1, Integer.valueOf(i2));
                O00000Oo(1);
                O00000o0(1);
            } else if (cameraInfo.facing == 0 && this.f14326O000000o.get(2) == null) {
                this.f14326O000000o.put(2, new O000000o(cameraInfo));
                this.O0000OOo.put(2, Integer.valueOf(i2));
                O00000Oo(2);
                O00000o0(2);
            }
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Camera.CameraInfo f14327O000000o;
        public int O00000Oo = 0;
        public int O00000o = -1;
        public int O00000o0 = -1;
        public int O00000oO = -1;
        public int O00000oo = -1;

        public O000000o(Camera.CameraInfo cameraInfo) {
            this.f14327O000000o = cameraInfo;
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14328O000000o;
        public int O00000Oo;

        public O00000Oo(int i, int i2) {
            this.f14328O000000o = i;
            this.O00000Oo = i2;
        }
    }
}
