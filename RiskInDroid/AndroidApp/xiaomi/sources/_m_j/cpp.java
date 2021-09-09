package _m_j;

import _m_j.cpx;
import android.hardware.Camera;
import com.otaliastudios.cameraview.Audio;
import com.otaliastudios.cameraview.Facing;
import com.otaliastudios.cameraview.Flash;
import com.otaliastudios.cameraview.Grid;
import com.otaliastudios.cameraview.Hdr;
import com.otaliastudios.cameraview.SessionType;
import com.otaliastudios.cameraview.VideoQuality;
import com.otaliastudios.cameraview.WhiteBalance;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class cpp {

    /* renamed from: O000000o  reason: collision with root package name */
    Set<cpz> f14213O000000o = new HashSet(15);
    boolean O00000Oo;
    boolean O00000o;
    boolean O00000o0;
    public float O00000oO;
    public float O00000oo;
    boolean O0000O0o;
    private Set<WhiteBalance> O0000OOo = new HashSet(5);
    private Set<Flash> O0000Oo = new HashSet(4);
    private Set<Facing> O0000Oo0 = new HashSet(2);
    private Set<Hdr> O0000OoO = new HashSet(2);
    private Set<cpk> O0000Ooo = new HashSet(4);

    cpp(Camera.Parameters parameters, boolean z) {
        cpx.O000000o o000000o = new cpx.O000000o();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        boolean z2 = false;
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            Facing O00000Oo2 = o000000o.O00000Oo(Integer.valueOf(cameraInfo.facing));
            if (O00000Oo2 != null) {
                this.O0000Oo0.add(O00000Oo2);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            for (String O00000o02 : supportedWhiteBalance) {
                WhiteBalance O00000o03 = o000000o.O00000o0(O00000o02);
                if (O00000o03 != null) {
                    this.O0000OOo.add(O00000o03);
                }
            }
        }
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String O000000o2 : supportedFlashModes) {
                Flash O000000o3 = o000000o.O000000o(O000000o2);
                if (O000000o3 != null) {
                    this.O0000Oo.add(O000000o3);
                }
            }
        }
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            for (String O00000o2 : supportedSceneModes) {
                Hdr O00000o3 = o000000o.O00000o(O00000o2);
                if (O00000o3 != null) {
                    this.O0000OoO.add(O00000o3);
                }
            }
        }
        this.O00000Oo = parameters.isZoomSupported();
        this.O00000o0 = parameters.isVideoSnapshotSupported();
        this.O0000O0o = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.O00000oO = ((float) parameters.getMinExposureCompensation()) * exposureCompensationStep;
        this.O00000oo = ((float) parameters.getMaxExposureCompensation()) * exposureCompensationStep;
        this.O00000o = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? z2 : true;
        for (Camera.Size next : parameters.getSupportedPictureSizes()) {
            int i2 = z ? next.height : next.width;
            int i3 = z ? next.width : next.height;
            this.f14213O000000o.add(new cpz(i2, i3));
            this.O0000Ooo.add(cpk.O000000o(i2, i3));
        }
    }

    public final boolean O000000o(cps cps) {
        return O000000o(cps.getClass()).contains(cps);
    }

    private <T extends cps> Collection<T> O000000o(Class cls) {
        if (cls.equals(Audio.class)) {
            return Arrays.asList(Audio.values());
        }
        if (cls.equals(Facing.class)) {
            return Collections.unmodifiableSet(this.O0000Oo0);
        }
        if (cls.equals(Flash.class)) {
            return Collections.unmodifiableSet(this.O0000Oo);
        }
        if (cls.equals(Grid.class)) {
            return Arrays.asList(Grid.values());
        }
        if (cls.equals(Hdr.class)) {
            return Collections.unmodifiableSet(this.O0000OoO);
        }
        if (cls.equals(SessionType.class)) {
            return Arrays.asList(SessionType.values());
        }
        if (cls.equals(VideoQuality.class)) {
            return Arrays.asList(VideoQuality.values());
        }
        return cls.equals(WhiteBalance.class) ? Collections.unmodifiableSet(this.O0000OOo) : Collections.emptyList();
    }
}
