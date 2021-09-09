package com.reactnative.camera.RCTCamera;

import _m_j.csz;
import _m_j.ctb;
import _m_j.ctc;
import _m_j.ym;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.exoplayer2.C;
import com.reactnative.camera.RCTCamera.MutableImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RCTCameraModule extends ReactContextBaseJavaModule implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener, LifecycleEventListener {
    private static ReactApplicationContext _reactContext;
    private long MRStartTime;
    public ctb _sensorOrientationChecker;
    private Camera mCamera = null;
    private MediaRecorder mMediaRecorder;
    private ReadableMap mRecordingOptions;
    private Promise mRecordingPromise = null;
    public Boolean mSafeToCapture = Boolean.TRUE;
    private File mVideoFile;

    public String getName() {
        return "RCTCameraModule";
    }

    public void onHostDestroy() {
    }

    public void onHostResume() {
    }

    public RCTCameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        _reactContext = reactApplicationContext;
        this._sensorOrientationChecker = new ctb(_reactContext);
        _reactContext.addLifecycleEventListener(this);
    }

    public static ReactApplicationContext getReactContextSingleton() {
        return _reactContext;
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if ((i == 800 || i == 801) && this.mRecordingPromise != null) {
            releaseMediaRecorder();
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        if (this.mRecordingPromise != null) {
            releaseMediaRecorder();
        }
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1 */

            {
                put("Aspect", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass1 */

                    {
                        put("stretch", 2);
                        put("fit", 1);
                        put("fill", 0);
                    }
                }));
                put("BarCodeType", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass2 */
                }));
                put("Type", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass3 */

                    {
                        put("front", 1);
                        put("back", 2);
                    }
                }));
                put("CaptureQuality", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass4 */

                    {
                        put("low", "low");
                        put("medium", "medium");
                        put("high", "high");
                        put("photo", "high");
                        put("preview", "preview");
                        put("480p", "480p");
                        put("720p", "720p");
                        put("1080p", "1080p");
                    }
                }));
                put("CaptureMode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass5 */

                    {
                        put("still", 0);
                        put("video", 1);
                    }
                }));
                put("CaptureTarget", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass6 */

                    {
                        put("memory", 0);
                        put("disk", 1);
                        put("cameraRoll", 2);
                        put("temp", 3);
                    }
                }));
                put("Orientation", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass7 */

                    {
                        put("auto", Integer.MAX_VALUE);
                        put("landscapeLeft", 1);
                        put("landscapeRight", 3);
                        put("portrait", 0);
                        put("portraitUpsideDown", 2);
                    }
                }));
                put("FlashMode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass8 */

                    {
                        put("off", 0);
                        put("on", 1);
                        put("auto", 2);
                    }
                }));
                put("TorchMode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass9 */

                    {
                        put("off", 0);
                        put("on", 1);
                        put("auto", 2);
                    }
                }));
            }
        });
    }

    private Throwable prepareMediaRecorder(ReadableMap readableMap, int i) {
        CamcorderProfile O00000Oo = csz.O000000o().O00000Oo(readableMap.getInt("type"), readableMap.getString("quality"));
        if (O00000Oo == null) {
            return new RuntimeException("CamcorderProfile not found in prepareMediaRecorder.");
        }
        this.mCamera.unlock();
        this.mMediaRecorder = new MediaRecorder();
        this.mMediaRecorder.setOnInfoListener(this);
        this.mMediaRecorder.setOnErrorListener(this);
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setAudioSource(5);
        this.mMediaRecorder.setVideoSource(1);
        if (i == 0) {
            this.mMediaRecorder.setOrientationHint(90);
        } else if (i == 1) {
            this.mMediaRecorder.setOrientationHint(0);
        } else if (i == 2) {
            this.mMediaRecorder.setOrientationHint(270);
        } else if (i == 3) {
            this.mMediaRecorder.setOrientationHint(180);
        }
        O00000Oo.fileFormat = 2;
        this.mMediaRecorder.setProfile(O00000Oo);
        this.mVideoFile = null;
        int i2 = readableMap.getInt("target");
        if (i2 == 0) {
            this.mVideoFile = getTempMediaFile(2);
        } else if (i2 == 2) {
            this.mVideoFile = getOutputCameraRollFile(2);
        } else if (i2 != 3) {
            this.mVideoFile = getOutputMediaFile(2);
        } else {
            this.mVideoFile = getTempMediaFile(2);
        }
        File file = this.mVideoFile;
        if (file == null) {
            return new RuntimeException("Error while preparing output file in prepareMediaRecorder.");
        }
        this.mMediaRecorder.setOutputFile(file.getPath());
        if (readableMap.hasKey("totalSeconds")) {
            this.mMediaRecorder.setMaxDuration(readableMap.getInt("totalSeconds") * 1000);
        }
        if (readableMap.hasKey("maxFileSize")) {
            this.mMediaRecorder.setMaxFileSize((long) readableMap.getInt("maxFileSize"));
        }
        try {
            this.mMediaRecorder.prepare();
            return null;
        } catch (Exception e) {
            Log.e("RCTCameraModule", "Media recorder prepare error.", e);
            releaseMediaRecorder();
            return e;
        }
    }

    private void record(ReadableMap readableMap, Promise promise, int i) {
        if (this.mRecordingPromise == null) {
            this.mCamera = csz.O000000o().O00000Oo(readableMap.getInt("type"));
            if (this.mCamera == null) {
                promise.reject(new RuntimeException("No camera found."));
                return;
            }
            Throwable prepareMediaRecorder = prepareMediaRecorder(readableMap, i);
            if (prepareMediaRecorder != null) {
                promise.reject(prepareMediaRecorder);
                return;
            }
            try {
                this.mMediaRecorder.start();
                this.MRStartTime = System.currentTimeMillis();
                this.mRecordingOptions = readableMap;
                this.mRecordingPromise = promise;
            } catch (Exception e) {
                Log.e("RCTCameraModule", "Media recorder start error.", e);
                promise.reject(e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        if (r5 != 3) goto L_0x012d;
     */
    private void releaseMediaRecorder() {
        long currentTimeMillis = System.currentTimeMillis() - this.MRStartTime;
        if (currentTimeMillis < 1500) {
            try {
                Thread.sleep(1500 - currentTimeMillis);
            } catch (InterruptedException e) {
                Log.e("RCTCameraModule", "releaseMediaRecorder thread sleep error.", e);
            }
        }
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException e2) {
                Log.e("RCTCameraModule", "Media recorder stop error.", e2);
            }
            this.mMediaRecorder.reset();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
        }
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.lock();
        }
        if (this.mRecordingPromise != null) {
            File file = new File(this.mVideoFile.getPath());
            if (!file.exists()) {
                this.mRecordingPromise.reject(new RuntimeException("There is nothing recorded."));
                this.mRecordingPromise = null;
                return;
            }
            file.setReadable(true, false);
            file.setWritable(true, false);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            int i = this.mRecordingOptions.getInt("target");
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_data", this.mVideoFile.getPath());
                        contentValues.put("title", this.mRecordingOptions.hasKey("title") ? this.mRecordingOptions.getString("title") : "video");
                        if (this.mRecordingOptions.hasKey("description")) {
                            contentValues.put("description", Boolean.valueOf(this.mRecordingOptions.hasKey("description")));
                        }
                        if (this.mRecordingOptions.hasKey("latitude")) {
                            contentValues.put("latitude", this.mRecordingOptions.getString("latitude"));
                        }
                        if (this.mRecordingOptions.hasKey("longitude")) {
                            contentValues.put("longitude", this.mRecordingOptions.getString("longitude"));
                        }
                        contentValues.put("mime_type", "video/mp4");
                        _reactContext.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                        addToMediaStore(this.mVideoFile.getAbsolutePath());
                    }
                }
                writableNativeMap.putString("path", Uri.fromFile(this.mVideoFile).toString());
                this.mRecordingPromise.resolve(writableNativeMap);
            } else {
                writableNativeMap.putString("data", new String(convertFileToByteArray(this.mVideoFile), 0));
                this.mRecordingPromise.resolve(writableNativeMap);
                file.delete();
            }
            this.mRecordingPromise = null;
        }
    }

    public static byte[] convertFileToByteArray(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @ReactMethod
    public void capture(final ReadableMap readableMap, final Promise promise) {
        if (csz.O000000o() == null) {
            promise.reject("Camera is not ready yet.");
            return;
        }
        int i = readableMap.hasKey("orientation") ? readableMap.getInt("orientation") : csz.O000000o().O00000oO;
        if (i == Integer.MAX_VALUE) {
            ctb ctb = this._sensorOrientationChecker;
            ctb.O00000o0.registerListener(ctb.O00000Oo, ctb.O00000o0.getDefaultSensor(1), 3);
            this._sensorOrientationChecker.O00000o = new ctc() {
                /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass2 */

                public final void O000000o() {
                    int i = RCTCameraModule.this._sensorOrientationChecker.f14334O000000o;
                    RCTCameraModule.this._sensorOrientationChecker.O00000o = null;
                    ctb ctb = RCTCameraModule.this._sensorOrientationChecker;
                    ctb.O00000o0.unregisterListener(ctb.O00000Oo);
                    RCTCameraModule.this.captureWithOrientation(readableMap, promise, i);
                }
            };
            return;
        }
        captureWithOrientation(readableMap, promise, i);
    }

    public void captureWithOrientation(final ReadableMap readableMap, final Promise promise, int i) {
        int i2;
        final Camera O00000Oo = csz.O000000o().O00000Oo(readableMap.getInt("type"));
        if (O00000Oo == null) {
            promise.reject("No camera found.");
        } else if (readableMap.getInt("mode") == 1) {
            record(readableMap, promise, i);
        } else {
            csz.O000000o().O000000o(readableMap.getInt("type"), readableMap.getString("quality"));
            if (readableMap.hasKey("playSoundOnCapture") && readableMap.getBoolean("playSoundOnCapture")) {
                new MediaActionSound().play(0);
            }
            if (readableMap.hasKey("quality")) {
                csz.O000000o().O000000o(readableMap.getInt("type"), readableMap.getString("quality"));
            }
            csz O000000o2 = csz.O000000o();
            int i3 = readableMap.getInt("type");
            Camera camera = O000000o2.O00000Oo.get(Integer.valueOf(i3));
            if (camera != null) {
                csz.O000000o o000000o = O000000o2.f14326O000000o.get(Integer.valueOf(i3));
                int i4 = o000000o.f14327O000000o.orientation;
                if (o000000o.f14327O000000o.facing == 1) {
                    i2 = (i4 + (i * 90)) % 360;
                } else {
                    i2 = ((i4 - (i * 90)) + 360) % 360;
                }
                o000000o.O00000Oo = i2;
                Camera.Parameters parameters = camera.getParameters();
                parameters.setRotation(o000000o.O00000Oo);
                try {
                    camera.setParameters(parameters);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            O00000Oo.setPreviewCallback(null);
            AnonymousClass3 r1 = new Camera.PictureCallback() {
                /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass3 */

                public final void onPictureTaken(final byte[] bArr, Camera camera) {
                    camera.stopPreview();
                    camera.startPreview();
                    AsyncTask.execute(new Runnable() {
                        /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            RCTCameraModule.this.processImage(new MutableImage(bArr), readableMap, promise);
                        }
                    });
                    RCTCameraModule.this.mSafeToCapture = Boolean.TRUE;
                }
            };
            AnonymousClass4 r8 = new Camera.ShutterCallback() {
                /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass4 */

                public final void onShutter() {
                    try {
                        O00000Oo.setPreviewCallback(null);
                        O00000Oo.setPreviewTexture(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            if (this.mSafeToCapture.booleanValue()) {
                try {
                    O00000Oo.takePicture(r8, null, r1);
                    this.mSafeToCapture = Boolean.FALSE;
                } catch (RuntimeException e2) {
                    Log.e("RCTCameraModule", "Couldn't capture photo.", e2);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0217, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f A[Catch:{ ImageProcessingException | MetadataException | IOException -> 0x00a1, ImageMutationFailedException -> 0x009f, all -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097 A[Catch:{ ImageProcessingException | MetadataException | IOException -> 0x00a1, ImageMutationFailedException -> 0x009f, all -> 0x02a5 }] */
    public synchronized void processImage(MutableImage mutableImage, ReadableMap readableMap, Promise promise) {
        boolean z;
        double d;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int O00000Oo;
        Bitmap createBitmap;
        MutableImage mutableImage2 = mutableImage;
        ReadableMap readableMap2 = readableMap;
        Promise promise2 = promise;
        synchronized (this) {
            try {
                if (readableMap2.hasKey("fixOrientation") && readableMap2.getBoolean("fixOrientation")) {
                    ym ymVar = (ym) mutableImage.O000000o().O000000o(ym.class);
                    if (ymVar != null) {
                        if (ymVar.O000000o(274) && (O00000Oo = ymVar.O00000Oo(274)) != 1) {
                            Matrix matrix = new Matrix();
                            switch (O00000Oo) {
                                case 1:
                                    ymVar.O000000o(274, 1);
                                    break;
                                case 2:
                                    matrix.postScale(-1.0f, 1.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                        mutableImage2.f5470O000000o = createBitmap;
                                        mutableImage2.O00000Oo = true;
                                        ymVar.O000000o(274, 1);
                                        break;
                                    } else {
                                        throw new MutableImage.ImageMutationFailedException("failed to rotate");
                                    }
                                case 3:
                                    matrix.postRotate(180.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                                case 4:
                                    matrix.postRotate(180.0f);
                                    matrix.postScale(-1.0f, 1.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                                case 5:
                                    matrix.postRotate(90.0f);
                                    matrix.postScale(-1.0f, 1.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                                case 6:
                                    matrix.postRotate(90.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                                case 7:
                                    matrix.postRotate(270.0f);
                                    matrix.postScale(-1.0f, 1.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                    matrix.postRotate(270.0f);
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                                default:
                                    createBitmap = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix, false);
                                    if (createBitmap == null) {
                                    }
                                    break;
                            }
                        }
                    }
                }
            } catch (ImageProcessingException | MetadataException | IOException e) {
                throw new MutableImage.ImageMutationFailedException("failed to fix orientation", e);
            } catch (MutableImage.ImageMutationFailedException e2) {
                promise2.reject("Error fixing orientation image", e2);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
            double width = (double) mutableImage2.f5470O000000o.getWidth();
            double height = (double) mutableImage2.f5470O000000o.getHeight();
            Double.isNaN(width);
            Double.isNaN(height);
            double d2 = width / height;
            try {
                int i7 = readableMap2.getInt("type");
                csz.O000000o o000000o = csz.O000000o().f14326O000000o.get(Integer.valueOf(i7));
                if (o000000o == null) {
                    i5 = 0;
                } else {
                    i5 = o000000o.O00000oO;
                }
                double d3 = (double) i5;
                csz.O000000o o000000o2 = csz.O000000o().f14326O000000o.get(Integer.valueOf(i7));
                if (o000000o2 == null) {
                    i6 = 0;
                } else {
                    i6 = o000000o2.O00000oo;
                }
                double d4 = (double) i6;
                Double.isNaN(d3);
                Double.isNaN(d4);
                d = d3 / d4;
                z = ((d > 1.0d ? 1 : (d == 1.0d ? 0 : -1)) > 0) != ((d2 > 1.0d ? 1 : (d2 == 1.0d ? 0 : -1)) > 0);
            } catch (IllegalArgumentException unused) {
                d = d2;
                z = false;
            }
            if (readableMap2.hasKey("cropToPreview") && readableMap2.getBoolean("cropToPreview")) {
                if (z) {
                    d = 1.0d / d;
                }
                try {
                    int width2 = mutableImage2.f5470O000000o.getWidth();
                    int height2 = mutableImage2.f5470O000000o.getHeight();
                    double d5 = (double) height2;
                    Double.isNaN(d5);
                    double d6 = d5 * d;
                    double d7 = (double) width2;
                    if (d6 > d7) {
                        Double.isNaN(d7);
                        i3 = (int) (d7 / d);
                        i4 = width2;
                    } else {
                        i4 = (int) d6;
                        i3 = height2;
                    }
                    mutableImage2.f5470O000000o = Bitmap.createBitmap(mutableImage2.f5470O000000o, (width2 - i4) / 2, (height2 - i3) / 2, i4, i3);
                } catch (IllegalArgumentException e3) {
                    promise2.reject("Error cropping image to preview", e3);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            if (readableMap2.hasKey("mirrorImage") && readableMap2.getBoolean("mirrorImage")) {
                try {
                    Matrix matrix2 = new Matrix();
                    matrix2.preScale(-1.0f, 1.0f);
                    Bitmap createBitmap2 = Bitmap.createBitmap(mutableImage2.f5470O000000o, 0, 0, mutableImage2.f5470O000000o.getWidth(), mutableImage2.f5470O000000o.getHeight(), matrix2, false);
                    if (createBitmap2 != null) {
                        mutableImage2.f5470O000000o = createBitmap2;
                    } else {
                        throw new MutableImage.ImageMutationFailedException("failed to mirror");
                    }
                } catch (MutableImage.ImageMutationFailedException e4) {
                    promise2.reject("Error mirroring image", e4);
                }
            }
            int i8 = 80;
            if (readableMap2.hasKey("jpegQuality")) {
                i8 = readableMap2.getInt("jpegQuality");
            }
            if (z) {
                i = mutableImage2.f5470O000000o.getHeight();
            } else {
                i = mutableImage2.f5470O000000o.getWidth();
            }
            if (z) {
                i2 = mutableImage2.f5470O000000o.getWidth();
            } else {
                i2 = mutableImage2.f5470O000000o.getHeight();
            }
            int i9 = readableMap2.getInt("target");
            if (i9 == 0) {
                String encodeToString = Base64.encodeToString(MutableImage.O000000o(mutableImage2.f5470O000000o, i8), 0);
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("data", encodeToString);
                writableNativeMap.putInt("width", i);
                writableNativeMap.putInt("height", i2);
                promise2.resolve(writableNativeMap);
            } else if (i9 == 1) {
                File outputMediaFile = getOutputMediaFile(1);
                if (outputMediaFile == null) {
                    promise2.reject("Error creating media file.");
                    return;
                }
                try {
                    mutableImage2.O000000o(outputMediaFile, readableMap2, i8);
                    resolveImage(outputMediaFile, i, i2, promise, false);
                } catch (IOException e5) {
                    promise2.reject("failed to save image file", e5);
                }
            } else if (i9 == 2) {
                File outputCameraRollFile = getOutputCameraRollFile(1);
                if (outputCameraRollFile == null) {
                    promise2.reject("Error creating media file.");
                    return;
                }
                try {
                    mutableImage2.O000000o(outputCameraRollFile, readableMap2, i8);
                    addToMediaStore(outputCameraRollFile.getAbsolutePath());
                    resolveImage(outputCameraRollFile, i, i2, promise, true);
                } catch (IOException | NullPointerException e6) {
                    promise2.reject("failed to save image file", e6);
                }
            } else if (i9 == 3) {
                try {
                    File tempMediaFile = getTempMediaFile(1);
                    if (tempMediaFile == null) {
                        promise2.reject("Error creating media file.");
                    } else {
                        mutableImage2.O000000o(tempMediaFile, readableMap2, i8);
                        resolveImage(tempMediaFile, i, i2, promise, false);
                    }
                } catch (IOException e7) {
                    promise2.reject("failed to save image file", e7);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        }
    }

    @ReactMethod
    public void stopCapture(Promise promise) {
        if (this.mRecordingPromise != null) {
            releaseMediaRecorder();
            promise.resolve("Finished recording.");
            return;
        }
        promise.resolve("Not recording.");
    }

    @ReactMethod
    public void hasFlash(ReadableMap readableMap, Promise promise) {
        Camera O00000Oo = csz.O000000o().O00000Oo(readableMap.getInt("type"));
        if (O00000Oo == null) {
            promise.reject("No camera found.");
            return;
        }
        List<String> supportedFlashModes = O00000Oo.getParameters().getSupportedFlashModes();
        promise.resolve(Boolean.valueOf(supportedFlashModes != null && !supportedFlashModes.isEmpty()));
    }

    @ReactMethod
    public void setZoom(ReadableMap readableMap, int i) {
        Camera O00000Oo;
        csz O000000o2 = csz.O000000o();
        if (O000000o2 != null && (O00000Oo = O000000o2.O00000Oo(readableMap.getInt("type"))) != null) {
            Camera.Parameters parameters = O00000Oo.getParameters();
            int maxZoom = parameters.getMaxZoom();
            if (parameters.isZoomSupported() && i >= 0 && i < maxZoom) {
                parameters.setZoom(i);
                O00000Oo.setParameters(parameters);
            }
        }
    }

    private File getOutputMediaFile(int i) {
        String str;
        if (i == 1) {
            str = Environment.DIRECTORY_PICTURES;
        } else if (i == 2) {
            str = Environment.DIRECTORY_MOVIES;
        } else {
            Log.e("RCTCameraModule", "Unsupported media type:".concat(String.valueOf(i)));
            return null;
        }
        return getOutputFile(i, Environment.getExternalStoragePublicDirectory(str));
    }

    private File getOutputCameraRollFile(int i) {
        return getOutputFile(i, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    private File getOutputFile(int i, File file) {
        String str;
        if (file.exists() || file.mkdirs()) {
            String format = String.format("%s", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
            if (i == 1) {
                str = String.format("IMG_%s.jpg", format);
            } else if (i == 2) {
                str = String.format("VID_%s.mp4", format);
            } else {
                Log.e("RCTCameraModule", "Unsupported media type:".concat(String.valueOf(i)));
                return null;
            }
            return new File(String.format("%s%s%s", file.getPath(), File.separator, str));
        }
        Log.e("RCTCameraModule", "failed to create directory:" + file.getAbsolutePath());
        return null;
    }

    private File getTempMediaFile(int i) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File cacheDir = _reactContext.getCacheDir();
            if (i == 1) {
                return File.createTempFile("IMG_".concat(String.valueOf(format)), ".jpg", cacheDir);
            }
            if (i == 2) {
                return File.createTempFile("VID_".concat(String.valueOf(format)), ".mp4", cacheDir);
            }
            Log.e("RCTCameraModule", "Unsupported media type:".concat(String.valueOf(i)));
            return null;
        } catch (Exception e) {
            Log.e("RCTCameraModule", e.getMessage());
            return null;
        }
    }

    private void addToMediaStore(String str) {
        MediaScannerConnection.scanFile(_reactContext, new String[]{str}, null, null);
    }

    public void onHostPause() {
        if (this.mRecordingPromise != null) {
            releaseMediaRecorder();
        }
    }

    private void resolveImage(File file, int i, int i2, final Promise promise, boolean z) {
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("path", Uri.fromFile(file).toString());
        writableNativeMap.putInt("width", i);
        writableNativeMap.putInt("height", i2);
        if (z) {
            MediaScannerConnection.scanFile(_reactContext, new String[]{file.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                /* class com.reactnative.camera.RCTCamera.RCTCameraModule.AnonymousClass5 */

                public final void onScanCompleted(String str, Uri uri) {
                    if (uri != null) {
                        writableNativeMap.putString("mediaUri", uri.toString());
                    }
                    promise.resolve(writableNativeMap);
                }
            });
            return;
        }
        promise.resolve(writableNativeMap);
    }
}
