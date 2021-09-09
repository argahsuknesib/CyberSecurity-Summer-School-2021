package com.lwansbrough.RCTCamera;

import android.content.ContentValues;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.lwansbrough.RCTCamera.MutableImage;
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
    private long MRStartTime;
    private ReactApplicationContext _reactContext;
    public RCTSensorOrientationChecker _sensorOrientationChecker;
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

    public RCTCameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this._reactContext = reactApplicationContext;
        this._sensorOrientationChecker = new RCTSensorOrientationChecker(this._reactContext);
        this._reactContext.addLifecycleEventListener(this);
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
            /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1 */

            {
                put("Aspect", getAspectConstants());
                put("BarCodeType", getBarCodeConstants());
                put("Type", getTypeConstants());
                put("CaptureQuality", getCaptureQualityConstants());
                put("CaptureMode", getCaptureModeConstants());
                put("CaptureTarget", getCaptureTargetConstants());
                put("Orientation", getOrientationConstants());
                put("FlashMode", getFlashModeConstants());
                put("TorchMode", getTorchModeConstants());
            }

            private Map<String, Object> getAspectConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass1 */

                    {
                        put("stretch", 2);
                        put("fit", 1);
                        put("fill", 0);
                    }
                });
            }

            private Map<String, Object> getBarCodeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass2 */
                });
            }

            private Map<String, Object> getTypeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass3 */

                    {
                        put("front", 1);
                        put("back", 2);
                    }
                });
            }

            private Map<String, Object> getCaptureQualityConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass4 */

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
                });
            }

            private Map<String, Object> getCaptureModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass5 */

                    {
                        put("still", 0);
                        put("video", 1);
                    }
                });
            }

            private Map<String, Object> getCaptureTargetConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass6 */

                    {
                        put("memory", 0);
                        put("disk", 1);
                        put("cameraRoll", 2);
                        put("temp", 3);
                    }
                });
            }

            private Map<String, Object> getOrientationConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass7 */

                    {
                        put("auto", Integer.MAX_VALUE);
                        put("landscapeLeft", 1);
                        put("landscapeRight", 3);
                        put("portrait", 0);
                        put("portraitUpsideDown", 2);
                    }
                });
            }

            private Map<String, Object> getFlashModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass8 */

                    {
                        put("off", 0);
                        put("on", 1);
                        put("auto", 2);
                    }
                });
            }

            private Map<String, Object> getTorchModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass1.AnonymousClass9 */

                    {
                        put("off", 0);
                        put("on", 1);
                        put("auto", 2);
                    }
                });
            }
        });
    }

    private Throwable prepareMediaRecorder(ReadableMap readableMap, int i) {
        CamcorderProfile captureVideoQuality = RCTCamera.getInstance().setCaptureVideoQuality(readableMap.getInt("type"), readableMap.getString("quality"));
        if (captureVideoQuality == null) {
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
        captureVideoQuality.fileFormat = 2;
        this.mMediaRecorder.setProfile(captureVideoQuality);
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
            this.mCamera = RCTCamera.getInstance().acquireCameraInstance(readableMap.getInt("type"));
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
        if (r4 != 3) goto L_0x012d;
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
                        this._reactContext.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
                        addToMediaStore(this.mVideoFile.getAbsolutePath());
                    }
                }
                writableNativeMap.putString("path", Uri.fromFile(this.mVideoFile).toString());
                this.mRecordingPromise.resolve(writableNativeMap);
            } else {
                writableNativeMap.putString("data", new String(convertFileToByteArray(this.mVideoFile), 2));
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
        if (RCTCamera.getInstance() == null) {
            promise.reject("Camera is not ready yet.");
            return;
        }
        int i = readableMap.hasKey("orientation") ? readableMap.getInt("orientation") : RCTCamera.getInstance().getOrientation();
        if (i == Integer.MAX_VALUE) {
            this._sensorOrientationChecker.onResume();
            this._sensorOrientationChecker.registerOrientationListener(new RCTSensorOrientationListener() {
                /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass2 */

                public void orientationEvent() {
                    int orientation = RCTCameraModule.this._sensorOrientationChecker.getOrientation();
                    RCTCameraModule.this._sensorOrientationChecker.unregisterOrientationListener();
                    RCTCameraModule.this._sensorOrientationChecker.onPause();
                    RCTCameraModule.this.captureWithOrientation(readableMap, promise, orientation);
                }
            });
            return;
        }
        captureWithOrientation(readableMap, promise, i);
    }

    public void captureWithOrientation(final ReadableMap readableMap, final Promise promise, int i) {
        final Camera acquireCameraInstance = RCTCamera.getInstance().acquireCameraInstance(readableMap.getInt("type"));
        if (acquireCameraInstance == null) {
            promise.reject("No camera found.");
        } else if (readableMap.getInt("mode") == 1) {
            record(readableMap, promise, i);
        } else {
            RCTCamera.getInstance().setCaptureQuality(readableMap.getInt("type"), readableMap.getString("quality"));
            if (readableMap.hasKey("playSoundOnCapture") && readableMap.getBoolean("playSoundOnCapture")) {
                new MediaActionSound().play(0);
            }
            if (readableMap.hasKey("quality")) {
                RCTCamera.getInstance().setCaptureQuality(readableMap.getInt("type"), readableMap.getString("quality"));
            }
            RCTCamera.getInstance().adjustCameraRotationToDeviceOrientation(readableMap.getInt("type"), i);
            acquireCameraInstance.setPreviewCallback(null);
            AnonymousClass3 r1 = new Camera.PictureCallback() {
                /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass3 */

                public void onPictureTaken(final byte[] bArr, Camera camera) {
                    camera.stopPreview();
                    camera.startPreview();
                    AsyncTask.execute(new Runnable() {
                        /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass3.AnonymousClass1 */

                        public void run() {
                            RCTCameraModule.this.processImage(new MutableImage(bArr), readableMap, promise);
                        }
                    });
                    RCTCameraModule.this.mSafeToCapture = Boolean.TRUE;
                }
            };
            AnonymousClass4 r7 = new Camera.ShutterCallback() {
                /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass4 */

                public void onShutter() {
                    try {
                        acquireCameraInstance.setPreviewCallback(null);
                        acquireCameraInstance.setPreviewTexture(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            if (this.mSafeToCapture.booleanValue()) {
                try {
                    acquireCameraInstance.takePicture(r7, null, r1);
                    this.mSafeToCapture = Boolean.FALSE;
                } catch (RuntimeException e) {
                    Log.e("RCTCameraModule", "Couldn't capture photo.", e);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0122, code lost:
        return;
     */
    public synchronized void processImage(MutableImage mutableImage, ReadableMap readableMap, Promise promise) {
        boolean z;
        if (readableMap.hasKey("fixOrientation") && readableMap.getBoolean("fixOrientation")) {
            try {
                mutableImage.fixOrientation();
            } catch (MutableImage.ImageMutationFailedException e) {
                promise.reject("Error fixing orientation image", e);
            }
        }
        double width = (double) mutableImage.getWidth();
        double height = (double) mutableImage.getHeight();
        Double.isNaN(width);
        Double.isNaN(height);
        double d = width / height;
        try {
            int i = readableMap.getInt("type");
            double previewVisibleWidth = (double) RCTCamera.getInstance().getPreviewVisibleWidth(i);
            double previewVisibleHeight = (double) RCTCamera.getInstance().getPreviewVisibleHeight(i);
            Double.isNaN(previewVisibleWidth);
            Double.isNaN(previewVisibleHeight);
            double d2 = previewVisibleWidth / previewVisibleHeight;
            z = ((d2 > 1.0d ? 1 : (d2 == 1.0d ? 0 : -1)) > 0) != ((d > 1.0d ? 1 : (d == 1.0d ? 0 : -1)) > 0);
            d = d2;
        } catch (IllegalArgumentException unused) {
            z = false;
        }
        if (readableMap.hasKey("cropToPreview") && readableMap.getBoolean("cropToPreview")) {
            if (z) {
                d = 1.0d / d;
            }
            try {
                mutableImage.cropToPreview(d);
            } catch (IllegalArgumentException e2) {
                promise.reject("Error cropping image to preview", e2);
            }
        }
        if (readableMap.hasKey("mirrorImage") && readableMap.getBoolean("mirrorImage")) {
            try {
                mutableImage.mirrorImage();
            } catch (MutableImage.ImageMutationFailedException e3) {
                promise.reject("Error mirroring image", e3);
            }
        }
        int i2 = 80;
        if (readableMap.hasKey("jpegQuality")) {
            i2 = readableMap.getInt("jpegQuality");
        }
        int i3 = readableMap.hasKey("targetWidth") ? readableMap.getInt("targetWidth") : 0;
        int i4 = readableMap.hasKey("targetHeight") ? readableMap.getInt("targetHeight") : 0;
        int height2 = z ? mutableImage.getHeight() : mutableImage.getWidth();
        int width2 = z ? mutableImage.getWidth() : mutableImage.getHeight();
        int i5 = readableMap.getInt("target");
        if (i5 == 0) {
            String base64 = mutableImage.toBase64(i2, i3, i4);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("data", base64);
            writableNativeMap.putInt("width", height2);
            writableNativeMap.putInt("height", width2);
            promise.resolve(writableNativeMap);
        } else if (i5 == 1) {
            File outputMediaFile = getOutputMediaFile(1);
            if (outputMediaFile == null) {
                promise.reject("Error creating media file.");
                return;
            }
            try {
                mutableImage.writeDataToFile(outputMediaFile, readableMap, 85, i3, i4);
                resolveImage(outputMediaFile, height2, width2, promise, false);
            } catch (IOException e4) {
                promise.reject("failed to save image file", e4);
            }
        } else if (i5 == 2) {
            File outputCameraRollFile = getOutputCameraRollFile(1);
            if (outputCameraRollFile == null) {
                promise.reject("Error creating media file.");
                return;
            }
            try {
                mutableImage.writeDataToFile(outputCameraRollFile, readableMap, i2, i3, i4);
                addToMediaStore(outputCameraRollFile.getAbsolutePath());
                resolveImage(outputCameraRollFile, height2, width2, promise, true);
            } catch (IOException | NullPointerException e5) {
                promise.reject("failed to save image file", e5);
            }
        } else if (i5 == 3) {
            File tempMediaFile = getTempMediaFile(1);
            if (tempMediaFile == null) {
                promise.reject("Error creating media file.");
                return;
            }
            try {
                mutableImage.writeDataToFile(tempMediaFile, readableMap, 85, i3, i4);
                resolveImage(tempMediaFile, height2, width2, promise, false);
            } catch (IOException e6) {
                promise.reject("failed to save image file", e6);
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
        Camera acquireCameraInstance = RCTCamera.getInstance().acquireCameraInstance(readableMap.getInt("type"));
        if (acquireCameraInstance == null) {
            promise.reject("No camera found.");
            return;
        }
        List<String> supportedFlashModes = acquireCameraInstance.getParameters().getSupportedFlashModes();
        promise.resolve(Boolean.valueOf(supportedFlashModes != null && !supportedFlashModes.isEmpty()));
    }

    @ReactMethod
    public void setZoom(ReadableMap readableMap, int i) {
        Camera acquireCameraInstance;
        RCTCamera instance = RCTCamera.getInstance();
        if (instance != null && (acquireCameraInstance = instance.acquireCameraInstance(readableMap.getInt("type"))) != null) {
            Camera.Parameters parameters = acquireCameraInstance.getParameters();
            int maxZoom = parameters.getMaxZoom();
            if (parameters.isZoomSupported() && i >= 0 && i < maxZoom) {
                parameters.setZoom(i);
                try {
                    acquireCameraInstance.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.e("RCTCameraModule", "setParameters failed", e);
                }
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
            File cacheDir = this._reactContext.getCacheDir();
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
        MediaScannerConnection.scanFile(this._reactContext, new String[]{str}, null, null);
    }

    public void onHostResume() {
        this.mSafeToCapture = Boolean.TRUE;
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
            MediaScannerConnection.scanFile(this._reactContext, new String[]{file.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                /* class com.lwansbrough.RCTCamera.RCTCameraModule.AnonymousClass5 */

                public void onScanCompleted(String str, Uri uri) {
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
