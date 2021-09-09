package _m_j;

import android.media.CamcorderProfile;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.cameraview.CameraView;
import com.google.android.gms.vision.face.Face;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.reactnative.camera.CameraModule;
import com.reactnative.camera.facedetector.RNFaceDetector;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ctd extends CameraView implements cto, ctq, LifecycleEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public Queue<Promise> f14336O000000o = new ConcurrentLinkedQueue();
    public Map<Promise, ReadableMap> O00000Oo = new ConcurrentHashMap();
    public Promise O00000o;
    public Map<Promise, File> O00000o0 = new ConcurrentHashMap();
    public volatile boolean O00000oO = false;
    public volatile boolean O00000oo = false;
    public final MultiFormatReader O0000O0o = new MultiFormatReader();
    public final RNFaceDetector O0000OOo;
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    private ThemedReactContext O0000OoO;
    private List<String> O0000Ooo = null;
    private int O0000o = RNFaceDetector.O00000Oo;
    private boolean O0000o0 = true;
    private boolean O0000o00 = false;
    private int O0000o0O = RNFaceDetector.O00000oo;
    private int O0000o0o = RNFaceDetector.O00000o;

    public final void requestLayout() {
    }

    public ctd(ThemedReactContext themedReactContext) {
        super(themedReactContext, true);
        O00000o0();
        this.O0000OoO = themedReactContext;
        this.O0000OOo = new RNFaceDetector(themedReactContext);
        this.O0000OOo.O00000o0(this.O0000o0O);
        this.O0000OOo.O00000Oo(this.O0000o0o);
        this.O0000OOo.O000000o(this.O0000o);
        RNFaceDetector rNFaceDetector = this.O0000OOo;
        rNFaceDetector.O00000Oo();
        rNFaceDetector.O0000O0o.setTrackingEnabled(true);
        themedReactContext.addLifecycleEventListener(this);
        addCallback(new CameraView.Callback() {
            /* class _m_j.ctd.AnonymousClass1 */

            public final void onCameraOpened(CameraView cameraView) {
                cte.O00000Oo(cameraView);
            }

            public final void onMountError(CameraView cameraView) {
                cte.O000000o(cameraView);
            }

            public final void onFramePreview(CameraView cameraView, byte[] bArr, int i, int i2, int i3) {
                CameraView cameraView2 = cameraView;
                int O000000o2 = cte.O000000o(i3, ctd.this.getFacing());
                if (ctd.this.O0000Oo && !ctd.this.O00000oO && (cameraView2 instanceof cto)) {
                    ctd ctd = ctd.this;
                    ctd.O00000oO = true;
                    new ctn((cto) cameraView2, ctd.O0000O0o, bArr, i, i2).execute(new Void[0]);
                }
                if (ctd.this.O0000Oo0 && !ctd.this.O00000oo && (cameraView2 instanceof ctq)) {
                    ctd ctd2 = ctd.this;
                    ctd2.O00000oo = true;
                    new ctp((ctq) cameraView2, ctd2.O0000OOo, bArr, i, i2, O000000o2).execute(new Void[0]);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = getView();
        if (view != null) {
            setBackgroundColor(-16777216);
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    public final void onViewAdded(View view) {
        if (getView() != view && getView() != null) {
            removeView(getView());
            addView(getView(), 0);
        }
    }

    public final void setBarCodeTypes(List<String> list) {
        this.O0000Ooo = list;
        O00000o0();
    }

    public final void O000000o(ReadableMap readableMap, Promise promise, File file) {
        this.f14336O000000o.add(promise);
        this.O00000Oo.put(promise, readableMap);
        this.O00000o0.put(promise, file);
        super.takePicture();
    }

    public final void O00000Oo(ReadableMap readableMap, Promise promise, File file) {
        try {
            String O000000o2 = ctt.O000000o(file, ".mp4");
            int i = readableMap.hasKey("maxDuration") ? readableMap.getInt("maxDuration") : -1;
            if (super.record(O000000o2, i * 1000, readableMap.hasKey("maxFileSize") ? readableMap.getInt("maxFileSize") : -1, !readableMap.hasKey("mute"), readableMap.hasKey("quality") ? cte.O000000o(readableMap.getInt("quality")) : CamcorderProfile.get(1))) {
                this.O00000o = promise;
            } else {
                promise.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.");
            }
        } catch (IOException unused) {
            promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.google.zxing.DecodeHintType, java.util.EnumSet]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    private void O00000o0() {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
        List<String> list = this.O0000Ooo;
        if (list != null) {
            for (String next : list) {
                if (((String) CameraModule.VALID_BARCODE_TYPES.get(next)) != null) {
                    noneOf.add(BarcodeFormat.valueOf(next));
                }
            }
        }
        enumMap.put((MMKVRecoverStrategic) DecodeHintType.POSSIBLE_FORMATS, (Integer) noneOf);
        this.O0000O0o.setHints(enumMap);
    }

    public final void setShouldScanBarCodes(boolean z) {
        this.O0000Oo = z;
        setScanning(this.O0000Oo0 || this.O0000Oo);
    }

    public final void O000000o(Result result) {
        String barcodeFormat = result.getBarcodeFormat().toString();
        if (this.O0000Oo && this.O0000Ooo.contains(barcodeFormat)) {
            cte.O000000o(this, result);
        }
    }

    public final void O000000o() {
        this.O00000oO = false;
        this.O0000O0o.reset();
    }

    public final void setFaceDetectionLandmarks(int i) {
        this.O0000o0o = i;
        RNFaceDetector rNFaceDetector = this.O0000OOo;
        if (rNFaceDetector != null) {
            rNFaceDetector.O00000Oo(i);
        }
    }

    public final void setFaceDetectionClassifications(int i) {
        this.O0000o = i;
        RNFaceDetector rNFaceDetector = this.O0000OOo;
        if (rNFaceDetector != null) {
            rNFaceDetector.O000000o(i);
        }
    }

    public final void setFaceDetectionMode(int i) {
        this.O0000o0O = i;
        RNFaceDetector rNFaceDetector = this.O0000OOo;
        if (rNFaceDetector != null) {
            rNFaceDetector.O00000o0(i);
        }
    }

    public final void setShouldDetectFaces(boolean z) {
        this.O0000Oo0 = z;
        setScanning(this.O0000Oo0 || this.O0000Oo);
    }

    public final void O000000o(SparseArray<Face> sparseArray, int i, int i2, int i3) {
        if (this.O0000Oo0) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            cte.O000000o(this, sparseArray, new cts(i, i2, i3, getFacing()));
        }
    }

    public final void O000000o(RNFaceDetector rNFaceDetector) {
        if (this.O0000Oo0) {
            cte.O00000o0(this);
        }
    }

    public final void O00000Oo() {
        this.O00000oo = false;
    }

    public final void onHostPause() {
        if (!this.O0000o00 && isCameraOpened()) {
            this.O0000o00 = true;
            stop();
        }
    }

    public final void onHostDestroy() {
        this.O0000OOo.O00000Oo();
        stop();
    }

    public final void onHostResume() {
        if (!(Build.VERSION.SDK_INT < 23 || ContextCompat.O000000o(getContext(), "android.permission.CAMERA") == 0)) {
            Arguments.createMap().putString("message", "Camera permissions not granted - component could not be rendered.");
            cte.O000000o(this);
        } else if ((this.O0000o00 && !isCameraOpened()) || this.O0000o0) {
            this.O0000o00 = false;
            this.O0000o0 = false;
            if (!Build.FINGERPRINT.contains("generic")) {
                start();
            }
        }
    }
}
