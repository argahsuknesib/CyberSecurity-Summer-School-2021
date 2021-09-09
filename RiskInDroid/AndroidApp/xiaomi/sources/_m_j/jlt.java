package _m_j;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.cameraview.CameraView;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.CameraModule;
import org.reactnative.facedetector.RNFaceDetector;

public final class jlt extends CameraView implements jmg, jmi, jmk, jml, jmo, LifecycleEventListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public ThemedReactContext f1929O000000o;
    public Queue<Promise> O00000Oo = new ConcurrentLinkedQueue();
    public Map<Promise, File> O00000o = new ConcurrentHashMap();
    public Map<Promise, ReadableMap> O00000o0 = new ConcurrentHashMap();
    public Promise O00000oO;
    public Boolean O00000oo = Boolean.FALSE;
    public boolean O0000O0o = false;
    public boolean O0000OOo = true;
    public Boolean O0000Oo = Boolean.FALSE;
    public boolean O0000Oo0 = false;
    public Boolean O0000OoO = Boolean.FALSE;
    public volatile boolean O0000Ooo = false;
    public RNFaceDetector O0000o;
    public volatile boolean O0000o0 = false;
    public volatile boolean O0000o00 = false;
    public volatile boolean O0000o0O = false;
    public idb O0000o0o;
    public boolean O0000oO = false;
    public RNBarcodeDetector O0000oO0;
    public boolean O0000oOO = false;
    public boolean O0000oOo = false;
    public int O0000oo = RNBarcodeDetector.f15469O000000o;
    public boolean O0000oo0 = false;
    public int O0000ooO;
    public int O0000ooo;
    private int O000O00o = RNFaceDetector.O00000o;
    private int O000O0OO = RNFaceDetector.O00000Oo;
    private int O000O0Oo = RNBarcodeDetector.O00000o;
    private boolean O00oOoOo = true;
    private List<String> O00oOooO = null;
    private int O00oOooo = RNFaceDetector.O00000oo;

    @SuppressLint({"all"})
    public final void requestLayout() {
    }

    public jlt(ThemedReactContext themedReactContext) {
        super(themedReactContext, true);
        this.f1929O000000o = themedReactContext;
        themedReactContext.addLifecycleEventListener(this);
        addCallback(new CameraView.Callback() {
            /* class _m_j.jlt.AnonymousClass1 */

            public final void onCameraOpened(CameraView cameraView) {
                jlu.O000000o(cameraView);
            }

            public final void onMountError(CameraView cameraView) {
                jlu.O000000o(cameraView, "Camera view threw an error - component could not be rendered.");
            }

            public final void onPictureTaken(CameraView cameraView, byte[] bArr, int i) {
                Promise poll = jlt.this.O00000Oo.poll();
                ReadableMap remove = jlt.this.O00000o0.remove(poll);
                if (remove.hasKey("fastMode") && remove.getBoolean("fastMode")) {
                    poll.resolve(null);
                }
                File remove2 = jlt.this.O00000o.remove(poll);
                if (Build.VERSION.SDK_INT >= 11) {
                    new jmm(bArr, poll, remove, remove2, i, jlt.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new jmm(bArr, poll, remove, remove2, i, jlt.this).execute(new Void[0]);
                }
                jlu.O00000Oo(cameraView);
            }

            public final void onVideoRecorded(CameraView cameraView, String str, int i, int i2) {
                if (jlt.this.O00000oO != null) {
                    if (str != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("isRecordingInterrupted", jlt.this.O0000OoO.booleanValue());
                        createMap.putInt("videoOrientation", i);
                        createMap.putInt("deviceOrientation", i2);
                        createMap.putString("uri", Uri.fromFile(new File(str)).toString());
                        jlt.this.O00000oO.resolve(createMap);
                    } else {
                        jlt.this.O00000oO.reject("E_RECORDING", "Couldn't stop recording - there is none in progress");
                    }
                    jlt.this.O0000Oo = Boolean.FALSE;
                    jlt.this.O0000OoO = Boolean.FALSE;
                    jlt.this.O00000oO = null;
                }
            }

            /* JADX WARN: Type inference failed for: r15v2 */
            /* JADX WARN: Type inference failed for: r15v4 */
            /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r15v1, types: [int, boolean] */
            public final void onFramePreview(CameraView cameraView, byte[] bArr, int i, int i2, int i3) {
                ? r15;
                CameraView cameraView2 = cameraView;
                byte[] bArr2 = bArr;
                int O000000o2 = jlu.O000000o(i3, jlt.this.getFacing(), jlt.this.getCameraOrientation());
                boolean z = jlt.this.O0000oOo && !jlt.this.O0000Ooo && (cameraView2 instanceof jmg);
                boolean z2 = jlt.this.O0000oO && !jlt.this.O0000o00 && (cameraView2 instanceof jmk);
                boolean z3 = jlt.this.O0000oOO && !jlt.this.O0000o0 && (cameraView2 instanceof jmi);
                boolean z4 = jlt.this.O0000oo0 && !jlt.this.O0000o0O && (cameraView2 instanceof jmo);
                if (z || z2 || z3 || z4) {
                    double d = (double) i;
                    Double.isNaN(d);
                    double d2 = (double) i2;
                    Double.isNaN(d2);
                    if (((double) bArr2.length) >= d * 1.5d * d2) {
                        if (z) {
                            jlt jlt = jlt.this;
                            jlt.O0000Ooo = true;
                            new jmf((jmg) cameraView2, jlt.O0000o0o, bArr, i, i2).execute(new Void[0]);
                        }
                        if (z2) {
                            jlt jlt2 = jlt.this;
                            jlt2.O0000o00 = true;
                            jmj jmj = r2;
                            r15 = 0;
                            jmj jmj2 = new jmj((jmk) cameraView2, jlt2.O0000o, bArr, i, i2, O000000o2, jlt.this.getResources().getDisplayMetrics().density, jlt.this.getFacing(), jlt.this.getWidth(), jlt.this.getHeight(), jlt.this.O0000ooO, jlt.this.O0000ooo);
                            jmj.execute(new Void[0]);
                        } else {
                            r15 = 0;
                        }
                        if (z3) {
                            jlt jlt3 = jlt.this;
                            jlt3.O0000o0 = true;
                            if (jlt3.O0000oo == RNBarcodeDetector.f15469O000000o) {
                                jlt.this.O0000Oo0 = r15;
                            } else if (jlt.this.O0000oo == RNBarcodeDetector.O00000Oo) {
                                jlt jlt4 = jlt.this;
                                jlt4.O0000Oo0 = !jlt4.O0000Oo0;
                            } else if (jlt.this.O0000oo == RNBarcodeDetector.O00000o0) {
                                jlt.this.O0000Oo0 = true;
                            }
                            if (jlt.this.O0000Oo0) {
                                byte[] bArr3 = bArr;
                                for (int i4 = 0; i4 < bArr3.length; i4++) {
                                    bArr3[i4] = (byte) (bArr3[i4] ^ -1);
                                }
                            }
                            jmh jmh = r2;
                            jmh jmh2 = new jmh((jmi) cameraView, jlt.this.O0000oO0, bArr, i, i2, O000000o2, jlt.this.getResources().getDisplayMetrics().density, jlt.this.getFacing(), jlt.this.getWidth(), jlt.this.getHeight(), jlt.this.O0000ooO, jlt.this.O0000ooo);
                            jmh.execute(new Void[r15]);
                        }
                        if (z4) {
                            jlt jlt5 = jlt.this;
                            jlt5.O0000o0O = true;
                            new jmn((jmo) cameraView, jlt5.f1929O000000o, bArr, i, i2, O000000o2, jlt.this.getResources().getDisplayMetrics().density, jlt.this.getFacing(), jlt.this.getWidth(), jlt.this.getHeight(), jlt.this.O0000ooO, jlt.this.O0000ooo).execute(new Void[r15]);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        View view = getView();
        if (view != null) {
            float f = (float) (i3 - i);
            float f2 = (float) (i4 - i2);
            float f3 = getAspectRatio().toFloat();
            int i7 = getResources().getConfiguration().orientation;
            setBackgroundColor(-16777216);
            if (i7 == 2) {
                float f4 = f3 * f2;
                if (f4 < f) {
                    i6 = (int) (f / f3);
                } else {
                    i5 = (int) f4;
                    i6 = (int) f2;
                    int i8 = (int) ((f - ((float) i5)) / 2.0f);
                    int i9 = (int) ((f2 - ((float) i6)) / 2.0f);
                    this.O0000ooO = i8;
                    this.O0000ooo = i9;
                    view.layout(i8, i9, i5 + i8, i6 + i9);
                }
            } else {
                float f5 = f3 * f;
                if (f5 > f2) {
                    i6 = (int) f5;
                } else {
                    i5 = (int) (f2 / f3);
                    i6 = (int) f2;
                    int i82 = (int) ((f - ((float) i5)) / 2.0f);
                    int i92 = (int) ((f2 - ((float) i6)) / 2.0f);
                    this.O0000ooO = i82;
                    this.O0000ooo = i92;
                    view.layout(i82, i92, i5 + i82, i6 + i92);
                }
            }
            i5 = (int) f;
            int i822 = (int) ((f - ((float) i5)) / 2.0f);
            int i922 = (int) ((f2 - ((float) i6)) / 2.0f);
            this.O0000ooO = i822;
            this.O0000ooo = i922;
            view.layout(i822, i922, i5 + i822, i6 + i922);
        }
    }

    public final void setBarCodeTypes(List<String> list) {
        this.O00oOooO = list;
        O00000oO();
    }

    public final void setPlaySoundOnCapture(Boolean bool) {
        this.O00000oo = bool;
    }

    public final void O000000o(final ReadableMap readableMap, final Promise promise, final File file) {
        this.mBgHandler.post(new Runnable() {
            /* class _m_j.jlt.AnonymousClass2 */

            public final void run() {
                jlt.this.O00000Oo.add(promise);
                jlt.this.O00000o0.put(promise, readableMap);
                jlt.this.O00000o.put(promise, file);
                if (jlt.this.O00000oo.booleanValue()) {
                    new MediaActionSound().play(0);
                }
                try {
                    jlt.super.takePicture(readableMap);
                } catch (Exception e) {
                    jlt.this.O00000Oo.remove(promise);
                    jlt.this.O00000o0.remove(promise);
                    jlt.this.O00000o.remove(promise);
                    promise.reject("E_TAKE_PICTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    public final void O000000o(WritableMap writableMap) {
        jlu.O000000o(this, writableMap);
    }

    public final void O00000Oo(final ReadableMap readableMap, final Promise promise, final File file) {
        this.mBgHandler.post(new Runnable() {
            /* class _m_j.jlt.AnonymousClass3 */

            public final void run() {
                try {
                    String string = readableMap.hasKey("path") ? readableMap.getString("path") : jmr.O000000o(file, ".mp4");
                    int i = readableMap.hasKey("maxDuration") ? readableMap.getInt("maxDuration") : -1;
                    int i2 = readableMap.hasKey("maxFileSize") ? readableMap.getInt("maxFileSize") : -1;
                    CamcorderProfile O000000o2 = readableMap.hasKey("quality") ? jlu.O000000o(readableMap.getInt("quality")) : CamcorderProfile.get(1);
                    if (readableMap.hasKey("videoBitrate")) {
                        O000000o2.videoBitRate = readableMap.getInt("videoBitrate");
                    }
                    if (jlt.super.record(string, i * 1000, i2, readableMap.hasKey("mute") ? !readableMap.getBoolean("mute") : true, O000000o2, readableMap.hasKey("orientation") ? readableMap.getInt("orientation") : 0)) {
                        jlt.this.O0000Oo = Boolean.TRUE;
                        jlt.this.O00000oO = promise;
                        return;
                    }
                    promise.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.");
                } catch (IOException unused) {
                    promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.");
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.xiaomi.zxing.DecodeHintType, java.util.EnumSet]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    private void O00000oO() {
        this.O0000o0o = new idb();
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
        List<String> list = this.O00oOooO;
        if (list != null) {
            for (String str : list) {
                String str2 = (String) CameraModule.VALID_BARCODE_TYPES.get(str);
                if (str2 != null) {
                    noneOf.add(BarcodeFormat.valueOf(str2));
                }
            }
        }
        enumMap.put((MMKVRecoverStrategic) DecodeHintType.POSSIBLE_FORMATS, (Integer) noneOf);
        this.O0000o0o.O000000o(enumMap);
    }

    public final void setShouldScanBarCodes(boolean z) {
        if (z && this.O0000o0o == null) {
            O00000oO();
        }
        this.O0000oOo = z;
        setScanning(this.O0000oO || this.O0000oOO || this.O0000oOo || this.O0000oo0);
    }

    public final void O000000o() {
        this.O0000Ooo = false;
        idb idb = this.O0000o0o;
        if (idb != null) {
            idb.O000000o();
        }
    }

    public final void setFaceDetectionLandmarks(int i) {
        this.O000O00o = i;
        RNFaceDetector rNFaceDetector = this.O0000o;
        if (rNFaceDetector != null) {
            rNFaceDetector.O00000Oo(i);
        }
    }

    public final void setFaceDetectionClassifications(int i) {
        this.O000O0OO = i;
        RNFaceDetector rNFaceDetector = this.O0000o;
        if (rNFaceDetector != null) {
            rNFaceDetector.O000000o(i);
        }
    }

    public final void setFaceDetectionMode(int i) {
        this.O00oOooo = i;
        RNFaceDetector rNFaceDetector = this.O0000o;
        if (rNFaceDetector != null) {
            rNFaceDetector.O00000o0(i);
        }
    }

    public final void setTracking(boolean z) {
        this.O00oOoOo = z;
        RNFaceDetector rNFaceDetector = this.O0000o;
        if (rNFaceDetector != null) {
            rNFaceDetector.O000000o(z);
        }
    }

    public final void setShouldDetectFaces(boolean z) {
        if (z && this.O0000o == null) {
            this.O0000o = new RNFaceDetector(this.f1929O000000o);
            this.O0000o.O00000o0(this.O00oOooo);
            this.O0000o.O00000Oo(this.O000O00o);
            this.O0000o.O000000o(this.O000O0OO);
            this.O0000o.O000000o(this.O00oOoOo);
        }
        this.O0000oO = z;
        setScanning(this.O0000oO || this.O0000oOO || this.O0000oOo || this.O0000oo0);
    }

    public final void O000000o(WritableArray writableArray) {
        if (this.O0000oO) {
            jlu.O000000o(this, writableArray);
        }
    }

    public final void O000000o(RNFaceDetector rNFaceDetector) {
        if (this.O0000oO) {
            jlu.O000000o(this, rNFaceDetector);
        }
    }

    public final void O00000Oo() {
        this.O0000o00 = false;
    }

    public final void setShouldGoogleDetectBarcodes(boolean z) {
        if (z && this.O0000oO0 == null) {
            this.O0000oO0 = new RNBarcodeDetector(this.f1929O000000o);
            this.O0000oO0.O000000o(this.O000O0Oo);
        }
        this.O0000oOO = z;
        setScanning(this.O0000oO || this.O0000oOO || this.O0000oOo || this.O0000oo0);
    }

    public final void setGoogleVisionBarcodeType(int i) {
        this.O000O0Oo = i;
        RNBarcodeDetector rNBarcodeDetector = this.O0000oO0;
        if (rNBarcodeDetector != null) {
            rNBarcodeDetector.O000000o(i);
        }
    }

    public final void setGoogleVisionBarcodeMode(int i) {
        this.O0000oo = i;
    }

    public final void O00000Oo(WritableArray writableArray) {
        if (this.O0000oOO) {
            jlu.O00000Oo(this, writableArray);
        }
    }

    public final void O000000o(RNBarcodeDetector rNBarcodeDetector) {
        if (this.O0000oOO) {
            jlu.O000000o(this, rNBarcodeDetector);
        }
    }

    public final void O00000o0() {
        this.O0000o0 = false;
    }

    public final void setShouldRecognizeText(boolean z) {
        this.O0000oo0 = z;
        setScanning(this.O0000oO || this.O0000oOO || this.O0000oOo || this.O0000oo0);
    }

    public final void O00000o0(WritableArray writableArray) {
        if (this.O0000oo0) {
            jlu.O00000o0(this, writableArray);
        }
    }

    public final void O00000o() {
        this.O0000o0O = false;
    }

    public final void onHostPause() {
        if (this.O0000Oo.booleanValue()) {
            this.O0000OoO = Boolean.TRUE;
        }
        if (!this.O0000O0o && isCameraOpened()) {
            this.O0000O0o = true;
            stop();
        }
    }

    public final void onHostDestroy() {
        RNFaceDetector rNFaceDetector = this.O0000o;
        if (rNFaceDetector != null) {
            rNFaceDetector.O00000Oo();
        }
        RNBarcodeDetector rNBarcodeDetector = this.O0000oO0;
        if (rNBarcodeDetector != null) {
            rNBarcodeDetector.O00000Oo();
        }
        this.O0000o0o = null;
        stop();
        this.f1929O000000o.removeLifecycleEventListener(this);
        cleanup();
    }

    public final void O000000o(idf idf, int i, int i2) {
        String barcodeFormat = idf.O00000o.toString();
        if (this.O0000oOo && this.O00oOooO.contains(barcodeFormat)) {
            jlu.O000000o(this, idf, i, i2);
        }
    }

    public final void onHostResume() {
        if (Build.VERSION.SDK_INT < 23 || ContextCompat.O000000o(getContext(), "android.permission.CAMERA") == 0) {
            this.mBgHandler.post(new Runnable() {
                /* class _m_j.jlt.AnonymousClass4 */

                public final void run() {
                    if ((jlt.this.O0000O0o && !jlt.this.isCameraOpened()) || jlt.this.O0000OOo) {
                        jlt jlt = jlt.this;
                        jlt.O0000O0o = false;
                        jlt.O0000OOo = false;
                        jlt.start();
                    }
                }
            });
        } else {
            jlu.O000000o(this, "Camera permissions not granted - component could not be rendered.");
        }
    }
}
