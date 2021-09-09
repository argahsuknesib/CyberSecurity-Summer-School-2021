package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;
import com.reactnative.camera.RCTCamera.RCTCameraModule;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

public final class cta extends TextureView implements Camera.PreviewCallback, TextureView.SurfaceTextureListener {
    public static volatile boolean O00000o = false;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f14330O000000o;
    public int O00000Oo;
    public boolean O00000o0 = false;
    public final MultiFormatReader O00000oO = new MultiFormatReader();
    private SurfaceTexture O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private boolean O0000Oo0;
    private Camera O0000OoO;
    private float O0000Ooo;

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public cta(Context context, int i) {
        super(context);
        setSurfaceTextureListener(this);
        this.f14330O000000o = i;
        O000000o(csz.O000000o().O00000o);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.O00000oo = surfaceTexture;
        this.O0000O0o = i;
        this.O0000OOo = i2;
        O00000o();
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.O0000O0o = i;
        this.O0000OOo = i2;
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.O00000oo = null;
        this.O0000O0o = 0;
        this.O0000OOo = 0;
        O00000oO();
        return true;
    }

    public final double O000000o() {
        return (double) (((float) csz.O000000o().O00000o(this.f14330O000000o)) / ((float) csz.O000000o().O00000oO(this.f14330O000000o)));
    }

    public final void O000000o(int i) {
        csz.O000000o().O000000o(this.f14330O000000o, i);
    }

    public final void O00000Oo(int i) {
        csz.O000000o().O00000Oo(this.f14330O000000o, i);
    }

    public final void O00000o0(int i) {
        csz.O000000o().O00000o0(this.f14330O000000o, i);
    }

    public final void O00000Oo() {
        if (this.O00000oo != null) {
            O00000o();
        }
    }

    public final void O00000o0() {
        if (this.O0000OoO != null) {
            O00000oO();
        }
    }

    private synchronized void O00000o() {
        List<Camera.Size> list;
        Activity O00000oo2;
        if (!this.O0000Oo0) {
            boolean z = true;
            this.O0000Oo0 = true;
            try {
                this.O0000OoO = csz.O000000o().O00000Oo(this.f14330O000000o);
                Camera.Parameters parameters = this.O0000OoO.getParameters();
                boolean z2 = this.O00000Oo == 0;
                if (this.O00000Oo != 1) {
                    z = false;
                }
                if (!z2) {
                    if (!z) {
                        throw new RuntimeException("Unsupported capture mode:" + this.O00000Oo);
                    }
                }
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (z2 && supportedFocusModes.contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                } else if (z && supportedFocusModes.contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    parameters.setFocusMode("auto");
                }
                if (z2) {
                    list = parameters.getSupportedPictureSizes();
                } else if (z) {
                    csz.O000000o();
                    list = csz.O000000o(this.O0000OoO);
                } else {
                    throw new RuntimeException("Unsupported capture mode:" + this.O00000Oo);
                }
                csz.O000000o();
                Camera.Size O000000o2 = csz.O000000o(list, Integer.MAX_VALUE, Integer.MAX_VALUE);
                parameters.setPictureSize(O000000o2.width, O000000o2.height);
                this.O0000OoO.setParameters(parameters);
                this.O0000OoO.setPreviewTexture(this.O00000oo);
                this.O0000OoO.startPreview();
                if (this.O00000o0 && (O00000oo2 = O00000oo()) != null) {
                    O00000oo2.getWindow().setBackgroundDrawable(null);
                }
                this.O0000OoO.setPreviewCallback(this);
                this.O0000Oo0 = false;
            } catch (NullPointerException e) {
                e.printStackTrace();
                this.O0000Oo0 = false;
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    O00000oO();
                } finally {
                    this.O0000Oo0 = false;
                }
            }
        }
    }

    private synchronized void O00000oO() {
        if (!this.O0000Oo) {
            this.O0000Oo = true;
            try {
                if (this.O0000OoO != null) {
                    this.O0000OoO.stopPreview();
                    this.O0000OoO.setPreviewCallback(null);
                    csz.O000000o().O00000o0(this.f14330O000000o);
                    this.O0000OoO = null;
                }
                this.O0000Oo = false;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } finally {
                    this.O0000Oo = false;
                }
            }
        }
    }

    private Activity O00000oo() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.google.zxing.DecodeHintType, java.util.EnumSet]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    private void O000000o(List<String> list) {
        BarcodeFormat barcodeFormat;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
        if (list != null) {
            for (String next : list) {
                if ("aztec".equals(next)) {
                    barcodeFormat = BarcodeFormat.AZTEC;
                } else if ("ean13".equals(next)) {
                    barcodeFormat = BarcodeFormat.EAN_13;
                } else if ("ean8".equals(next)) {
                    barcodeFormat = BarcodeFormat.EAN_8;
                } else if ("qr".equals(next)) {
                    barcodeFormat = BarcodeFormat.QR_CODE;
                } else if ("pdf417".equals(next)) {
                    barcodeFormat = BarcodeFormat.PDF_417;
                } else if ("upce".equals(next)) {
                    barcodeFormat = BarcodeFormat.UPC_E;
                } else if ("datamatrix".equals(next)) {
                    barcodeFormat = BarcodeFormat.DATA_MATRIX;
                } else if ("code39".equals(next)) {
                    barcodeFormat = BarcodeFormat.CODE_39;
                } else if ("code93".equals(next)) {
                    barcodeFormat = BarcodeFormat.CODE_93;
                } else if ("interleaved2of5".equals(next)) {
                    barcodeFormat = BarcodeFormat.ITF;
                } else if ("codabar".equals(next)) {
                    barcodeFormat = BarcodeFormat.CODABAR;
                } else if ("code128".equals(next)) {
                    barcodeFormat = BarcodeFormat.CODE_128;
                } else if ("maxicode".equals(next)) {
                    barcodeFormat = BarcodeFormat.MAXICODE;
                } else if ("rss14".equals(next)) {
                    barcodeFormat = BarcodeFormat.RSS_14;
                } else if ("rssexpanded".equals(next)) {
                    barcodeFormat = BarcodeFormat.RSS_EXPANDED;
                } else if ("upca".equals(next)) {
                    barcodeFormat = BarcodeFormat.UPC_A;
                } else if ("upceanextension".equals(next)) {
                    barcodeFormat = BarcodeFormat.UPC_EAN_EXTENSION;
                } else {
                    Log.v("RCTCamera", "Unsupported code.. [" + next + "]");
                    barcodeFormat = null;
                }
                if (barcodeFormat != null) {
                    noneOf.add(barcodeFormat);
                }
            }
        }
        enumMap.put((MMKVRecoverStrategic) DecodeHintType.POSSIBLE_FORMATS, (Integer) noneOf);
        this.O00000oO.setHints(enumMap);
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (csz.O000000o().O00000o0 && !O00000o) {
            O00000o = true;
            new O000000o(camera, bArr).execute(new Void[0]);
        }
    }

    class O000000o extends AsyncTask<Void, Void, Void> {
        private byte[] O00000Oo;
        private final Camera O00000o0;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        O000000o(Camera camera, byte[] bArr) {
            this.O00000o0 = camera;
            this.O00000Oo = bArr;
        }

        /* JADX INFO: finally extract failed */
        private Result O000000o(int i, int i2) {
            try {
                Result decodeWithState = cta.this.O00000oO.decodeWithState(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(this.O00000Oo, i, i2, 0, 0, i, i2, false))));
                cta.this.O00000oO.reset();
                return decodeWithState;
            } catch (Throwable th) {
                cta.this.O00000oO.reset();
                throw th;
            }
        }

        private Void O000000o() {
            if (isCancelled()) {
                return null;
            }
            try {
                Camera.Size previewSize = this.O00000o0.getParameters().getPreviewSize();
                int i = previewSize.width;
                int i2 = previewSize.height;
                Result O000000o2 = O000000o(i, i2);
                if (O000000o2 == null) {
                    byte[] bArr = new byte[this.O00000Oo.length];
                    for (int i3 = 0; i3 < i2; i3++) {
                        for (int i4 = 0; i4 < i; i4++) {
                            bArr[(((i4 * i2) + i2) - i3) - 1] = this.O00000Oo[(i3 * i) + i4];
                        }
                    }
                    this.O00000Oo = bArr;
                    O000000o2 = O000000o(previewSize.height, previewSize.width);
                }
                if (O000000o2 != null) {
                    ReactApplicationContext reactContextSingleton = RCTCameraModule.getReactContextSingleton();
                    WritableMap createMap = Arguments.createMap();
                    WritableArray createArray = Arguments.createArray();
                    ResultPoint[] resultPoints = O000000o2.getResultPoints();
                    if (resultPoints != null) {
                        for (ResultPoint resultPoint : resultPoints) {
                            WritableMap createMap2 = Arguments.createMap();
                            createMap2.putString("x", String.valueOf(resultPoint.getX()));
                            createMap2.putString("y", String.valueOf(resultPoint.getY()));
                            createArray.pushMap(createMap2);
                        }
                    }
                    createMap.putArray("bounds", createArray);
                    createMap.putString("data", O000000o2.getText());
                    createMap.putString("type", O000000o2.getBarcodeFormat().toString());
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContextSingleton.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CameraBarCodeReadAndroid", createMap);
                    cta.this.O00000oO.reset();
                    cta.O00000o = false;
                    return null;
                }
                throw new Exception();
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        List<String> supportedFocusModes;
        Camera camera = this.O0000OoO;
        if (camera == null) {
            return false;
        }
        Camera.Parameters parameters = camera.getParameters();
        int action = motionEvent.getAction();
        if (motionEvent.getPointerCount() > 1) {
            if (action == 5) {
                this.O0000Ooo = O000000o(motionEvent);
            } else if (action == 2 && parameters.isZoomSupported()) {
                this.O0000OoO.cancelAutoFocus();
                int maxZoom = parameters.getMaxZoom();
                int zoom = parameters.getZoom();
                float O000000o2 = O000000o(motionEvent);
                float f = this.O0000Ooo;
                if (O000000o2 > f) {
                    if (zoom < maxZoom) {
                        zoom++;
                    }
                } else if (O000000o2 < f && zoom > 0) {
                    zoom--;
                }
                this.O0000Ooo = O000000o2;
                parameters.setZoom(zoom);
                this.O0000OoO.setParameters(parameters);
            }
        } else if (action == 1 && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains("auto") && parameters.getMaxNumFocusAreas() != 0) {
            this.O0000OoO.cancelAutoFocus();
            try {
                int i = this.O0000O0o;
                int i2 = this.O0000OOo;
                int findPointerIndex = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                RectF rectF = new RectF(x - 100.0f, y - 100.0f, x + 100.0f, y + 100.0f);
                float f2 = (float) i;
                float f3 = (float) i2;
                if (rectF.intersect(new RectF(0.0f, 0.0f, f2, f3))) {
                    RectF rectF2 = new RectF(((rectF.left / f2) * 2000.0f) - 1000.0f, ((rectF.top / f3) * 2000.0f) - 1000.0f, ((rectF.right / f2) * 2000.0f) - 1000.0f, ((rectF.bottom / f3) * 2000.0f) - 1000.0f);
                    Rect rect = new Rect();
                    rectF2.round(rect);
                    Camera.Area area = new Camera.Area(rect, 1000);
                    parameters.setFocusMode("auto");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(area);
                    parameters.setFocusAreas(arrayList);
                    if (parameters.getMaxNumMeteringAreas() > 0) {
                        parameters.setMeteringAreas(arrayList);
                    }
                    this.O0000OoO.setParameters(parameters);
                    try {
                        this.O0000OoO.autoFocus(new Camera.AutoFocusCallback() {
                            /* class _m_j.cta.AnonymousClass2 */

                            public final void onAutoFocus(boolean z, Camera camera) {
                                if (z) {
                                    camera.cancelAutoFocus();
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("MotionEvent rect does not intersect with SurfaceTexture rect; unable to compute focus area");
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    private static float O000000o(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }
}
