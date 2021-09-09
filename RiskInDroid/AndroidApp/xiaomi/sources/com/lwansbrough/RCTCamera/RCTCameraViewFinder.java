package com.lwansbrough.RCTCamera;

import _m_j.icy;
import _m_j.idb;
import _m_j.idc;
import _m_j.idf;
import _m_j.idg;
import _m_j.idt;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.tencent.mmkv.MMKVRecoverStrategic;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

class RCTCameraViewFinder extends TextureView implements Camera.PreviewCallback, TextureView.SurfaceTextureListener {
    public static volatile boolean barcodeScannerTaskLock = false;
    private Camera _camera;
    public int _cameraType;
    private int _captureMode;
    private boolean _clearWindowBackground = false;
    private boolean _isStarting;
    private boolean _isStopping;
    public final idb _multiFormatReader = new idb();
    private SurfaceTexture _surfaceTexture;
    private int _surfaceTextureHeight;
    private int _surfaceTextureWidth;
    private float mFingerSpacing;

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public RCTCameraViewFinder(Context context, int i) {
        super(context);
        setSurfaceTextureListener(this);
        this._cameraType = i;
        initBarcodeReader(RCTCamera.getInstance().getBarCodeTypes());
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this._surfaceTexture = surfaceTexture;
        this._surfaceTextureWidth = i;
        this._surfaceTextureHeight = i2;
        startCamera();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this._surfaceTextureWidth = i;
        this._surfaceTextureHeight = i2;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this._surfaceTexture = null;
        this._surfaceTextureWidth = 0;
        this._surfaceTextureHeight = 0;
        stopCamera();
        return true;
    }

    public int getCameraType() {
        return this._cameraType;
    }

    public double getRatio() {
        return (double) (((float) RCTCamera.getInstance().getPreviewWidth(this._cameraType)) / ((float) RCTCamera.getInstance().getPreviewHeight(this._cameraType)));
    }

    public void setCameraType(final int i) {
        if (this._cameraType != i) {
            new Thread(new Runnable() {
                /* class com.lwansbrough.RCTCamera.RCTCameraViewFinder.AnonymousClass1 */

                public void run() {
                    RCTCameraViewFinder.this.stopPreview();
                    RCTCameraViewFinder rCTCameraViewFinder = RCTCameraViewFinder.this;
                    rCTCameraViewFinder._cameraType = i;
                    rCTCameraViewFinder.startPreview();
                }
            }).start();
        }
    }

    public void setCaptureMode(int i) {
        RCTCamera.getInstance().setCaptureMode(this._cameraType, i);
        this._captureMode = i;
    }

    public void setCaptureQuality(String str) {
        RCTCamera.getInstance().setCaptureQuality(this._cameraType, str);
    }

    public void setTorchMode(int i) {
        RCTCamera.getInstance().setTorchMode(this._cameraType, i);
    }

    public void setFlashMode(int i) {
        RCTCamera.getInstance().setFlashMode(this._cameraType, i);
    }

    public void setClearWindowBackground(boolean z) {
        this._clearWindowBackground = z;
    }

    public void setZoom(int i) {
        RCTCamera.getInstance().setZoom(this._cameraType, i);
    }

    public void startPreview() {
        if (this._surfaceTexture != null) {
            startCamera();
        }
    }

    public void stopPreview() {
        if (this._camera != null) {
            stopCamera();
        }
    }

    private synchronized void startCamera() {
        List<Camera.Size> list;
        Activity activity;
        if (!this._isStarting) {
            boolean z = true;
            this._isStarting = true;
            try {
                this._camera = RCTCamera.getInstance().acquireCameraInstance(this._cameraType);
                Camera.Parameters parameters = this._camera.getParameters();
                boolean z2 = this._captureMode == 0;
                if (this._captureMode != 1) {
                    z = false;
                }
                if (!z2) {
                    if (!z) {
                        throw new RuntimeException("Unsupported capture mode:" + this._captureMode);
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
                    list = RCTCamera.getInstance().getSupportedVideoSizes(this._camera);
                } else {
                    throw new RuntimeException("Unsupported capture mode:" + this._captureMode);
                }
                Camera.Size bestSize = RCTCamera.getInstance().getBestSize(list, Integer.MAX_VALUE, Integer.MAX_VALUE);
                parameters.setPictureSize(bestSize.width, bestSize.height);
                try {
                    this._camera.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCameraViewFinder", "setParameters failed", e);
                }
                this._camera.setPreviewTexture(this._surfaceTexture);
                this._camera.startPreview();
                if (this._clearWindowBackground && (activity = getActivity()) != null) {
                    activity.getWindow().setBackgroundDrawable(null);
                }
                this._camera.setPreviewCallback(this);
                this._isStarting = false;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                this._isStarting = false;
            } catch (Exception e3) {
                try {
                    e3.printStackTrace();
                    stopCamera();
                } finally {
                    this._isStarting = false;
                }
            }
        }
    }

    private synchronized void stopCamera() {
        if (!this._isStopping) {
            this._isStopping = true;
            try {
                if (this._camera != null) {
                    this._camera.stopPreview();
                    this._camera.setPreviewCallback(null);
                    RCTCamera.getInstance().releaseCameraInstance(this._cameraType);
                    this._camera = null;
                }
                this._isStopping = false;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } finally {
                    this._isStopping = false;
                }
            }
        }
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private BarcodeFormat parseBarCodeString(String str) {
        if ("aztec".equals(str)) {
            return BarcodeFormat.AZTEC;
        }
        if ("ean13".equals(str)) {
            return BarcodeFormat.EAN_13;
        }
        if ("ean8".equals(str)) {
            return BarcodeFormat.EAN_8;
        }
        if ("qr".equals(str)) {
            return BarcodeFormat.QR_CODE;
        }
        if ("pdf417".equals(str)) {
            return BarcodeFormat.PDF_417;
        }
        if ("upce".equals(str)) {
            return BarcodeFormat.UPC_E;
        }
        if ("datamatrix".equals(str)) {
            return BarcodeFormat.DATA_MATRIX;
        }
        if ("code39".equals(str)) {
            return BarcodeFormat.CODE_39;
        }
        if ("code93".equals(str)) {
            return BarcodeFormat.CODE_93;
        }
        if ("interleaved2of5".equals(str)) {
            return BarcodeFormat.ITF;
        }
        if ("codabar".equals(str)) {
            return BarcodeFormat.CODABAR;
        }
        if ("code128".equals(str)) {
            return BarcodeFormat.CODE_128;
        }
        if ("maxicode".equals(str)) {
            return BarcodeFormat.MAXICODE;
        }
        if ("rss14".equals(str)) {
            return BarcodeFormat.RSS_14;
        }
        if ("rssexpanded".equals(str)) {
            return BarcodeFormat.RSS_EXPANDED;
        }
        if ("upca".equals(str)) {
            return BarcodeFormat.UPC_A;
        }
        if ("upceanextension".equals(str)) {
            return BarcodeFormat.UPC_EAN_EXTENSION;
        }
        Log.v("RCTCamera", "Unsupported code.. [" + str + "]");
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [com.xiaomi.zxing.DecodeHintType, java.util.EnumSet]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    private void initBarcodeReader(List<String> list) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        EnumSet noneOf = EnumSet.noneOf(BarcodeFormat.class);
        if (list != null) {
            for (String parseBarCodeString : list) {
                BarcodeFormat parseBarCodeString2 = parseBarCodeString(parseBarCodeString);
                if (parseBarCodeString2 != null) {
                    noneOf.add(parseBarCodeString2);
                }
            }
        }
        enumMap.put((MMKVRecoverStrategic) DecodeHintType.POSSIBLE_FORMATS, (Integer) noneOf);
        this._multiFormatReader.O000000o(enumMap);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (RCTCamera.getInstance().isBarcodeScannerEnabled() && !barcodeScannerTaskLock) {
            barcodeScannerTaskLock = true;
            new ReaderAsyncTask(camera, bArr).execute(new Void[0]);
        }
    }

    class ReaderAsyncTask extends AsyncTask<Void, Void, idf> {
        private final Camera camera;
        private byte[] imageData;

        ReaderAsyncTask(Camera camera2, byte[] bArr) {
            this.camera = camera2;
            this.imageData = bArr;
        }

        /* JADX INFO: finally extract failed */
        private idf getBarcode(int i, int i2, boolean z) {
            icy icy;
            try {
                idc idc = new idc(this.imageData, i, i2, 0, 0, i, i2, false);
                if (z) {
                    icy = new icy(new idt(idc.O00000o0()));
                } else {
                    icy = new icy(new idt(idc));
                }
                idf O000000o2 = RCTCameraViewFinder.this._multiFormatReader.O000000o(icy);
                RCTCameraViewFinder.this._multiFormatReader.O000000o();
                return O000000o2;
            } catch (Throwable th) {
                RCTCameraViewFinder.this._multiFormatReader.O000000o();
                throw th;
            }
        }

        private idf getBarcodeAnyOrientation() {
            Camera.Size previewSize = this.camera.getParameters().getPreviewSize();
            int i = previewSize.width;
            int i2 = previewSize.height;
            idf barcode = getBarcode(i, i2, false);
            if (barcode != null) {
                return barcode;
            }
            idf barcode2 = getBarcode(i, i2, true);
            if (barcode2 != null) {
                return barcode2;
            }
            rotateImage(i, i2);
            int i3 = previewSize.height;
            int i4 = previewSize.width;
            idf barcode3 = getBarcode(i3, i4, false);
            if (barcode3 != null) {
                return barcode3;
            }
            return getBarcode(i3, i4, true);
        }

        private void rotateImage(int i, int i2) {
            byte[] bArr = new byte[this.imageData.length];
            for (int i3 = 0; i3 < i; i3++) {
                for (int i4 = 0; i4 < i2; i4++) {
                    int i5 = (i3 * i2) + i4;
                    int i6 = (((i4 * i) + i) - i3) - 1;
                    if (i5 >= 0) {
                        byte[] bArr2 = this.imageData;
                        if (i5 < bArr2.length && i6 >= 0 && i6 < bArr2.length) {
                            bArr[i6] = bArr2[i5];
                        }
                    }
                }
            }
            this.imageData = bArr;
        }

        /* access modifiers changed from: protected */
        public idf doInBackground(Void... voidArr) {
            if (isCancelled()) {
                return null;
            }
            try {
                if (getBarcodeAnyOrientation() == null) {
                    throw new Exception();
                }
            } catch (Throwable unused) {
            }
            RCTCameraViewFinder.this._multiFormatReader.O000000o();
            RCTCameraViewFinder.barcodeScannerTaskLock = false;
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(idf idf) {
            RCTCameraViewFinder.this.sendEvent(idf);
        }
    }

    /* access modifiers changed from: package-private */
    public void sendEvent(idf idf) {
        if (getContext() instanceof ThemedReactContext) {
            WritableMap createMap = Arguments.createMap();
            WritableArray createArray = Arguments.createArray();
            idg[] idgArr = idf.O00000o0;
            if (idgArr != null) {
                for (idg idg : idgArr) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("x", String.valueOf(idg.f1209O000000o));
                    createMap2.putString("y", String.valueOf(idg.O00000Oo));
                    createArray.pushMap(createMap2);
                }
            }
            createMap.putArray("bounds", createArray);
            createMap.putString("data", idf.f1208O000000o);
            createMap.putString("type", idf.O00000o.toString());
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ((ThemedReactContext) getContext()).getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CameraBarCodeReadAndroid", createMap);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera camera = this._camera;
        if (camera == null) {
            return false;
        }
        Camera.Parameters parameters = camera.getParameters();
        int action = motionEvent.getAction();
        if (motionEvent.getPointerCount() > 1) {
            if (action == 5) {
                this.mFingerSpacing = getFingerSpacing(motionEvent);
            } else if (action == 2 && parameters.isZoomSupported()) {
                this._camera.cancelAutoFocus();
                handleZoom(motionEvent, parameters);
            }
        } else if (action == 1) {
            handleFocus(motionEvent, parameters);
        }
        return true;
    }

    private void handleZoom(MotionEvent motionEvent, Camera.Parameters parameters) {
        int maxZoom = parameters.getMaxZoom();
        int zoom = parameters.getZoom();
        float fingerSpacing = getFingerSpacing(motionEvent);
        float f = this.mFingerSpacing;
        if (fingerSpacing > f) {
            if (zoom < maxZoom) {
                zoom++;
            }
        } else if (fingerSpacing < f && zoom > 0) {
            zoom--;
        }
        this.mFingerSpacing = fingerSpacing;
        parameters.setZoom(zoom);
        try {
            this._camera.setParameters(parameters);
        } catch (RuntimeException e) {
            Log.e("RCTCameraViewFinder", "setParameters failed", e);
        }
    }

    public void handleFocus(MotionEvent motionEvent, Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.contains("auto") && parameters.getMaxNumFocusAreas() != 0) {
            this._camera.cancelAutoFocus();
            try {
                Camera.Area computeFocusAreaFromMotionEvent = RCTCameraUtils.computeFocusAreaFromMotionEvent(motionEvent, this._surfaceTextureWidth, this._surfaceTextureHeight);
                parameters.setFocusMode("auto");
                ArrayList arrayList = new ArrayList();
                arrayList.add(computeFocusAreaFromMotionEvent);
                parameters.setFocusAreas(arrayList);
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    parameters.setMeteringAreas(arrayList);
                }
                try {
                    this._camera.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCameraViewFinder", "setParameters failed", e);
                }
                try {
                    this._camera.autoFocus(new Camera.AutoFocusCallback() {
                        /* class com.lwansbrough.RCTCamera.RCTCameraViewFinder.AnonymousClass2 */

                        public void onAutoFocus(boolean z, Camera camera) {
                            if (z) {
                                camera.cancelAutoFocus();
                            }
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            }
        }
    }

    private float getFingerSpacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }
}
