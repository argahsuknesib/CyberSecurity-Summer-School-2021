package com.xiaomi.smarthome.miio.camera.face.util;

import _m_j.civ;
import android.app.Activity;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CameraUtils {
    public static int DEFAULT_HEIGHT = 1920;
    public static int DEFAULT_WIDTH = 1920;
    public static final String TAG = "CameraUtils";
    private static AutoFocusCallback autoFocusCallback = new AutoFocusCallback();
    private static AutoFocusCallback autoFocusListener = null;
    private static Camera.ErrorCallback errorCallback = new Camera.ErrorCallback() {
        /* class com.xiaomi.smarthome.miio.camera.face.util.CameraUtils.AnonymousClass2 */

        public final void onError(int i, Camera camera) {
            civ.O000000o(CameraUtils.TAG, "onError".concat(String.valueOf(i)));
        }
    };
    private static Camera mCamera;
    private static int mCameraID = 1;
    private static int mCameraPreviewFps;
    private static int mOrientation = 0;
    public static int mPreviewHeight;
    public static int mPreviewWidth;
    private static Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() {
        /* class com.xiaomi.smarthome.miio.camera.face.util.CameraUtils.AnonymousClass1 */

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr != null) {
                CameraUtils.yuvData = bArr;
            }
        }
    };
    private static Camera.Size previewSize;
    public static double rate;
    public static byte[] yuvData;

    static {
        double d = (double) DEFAULT_WIDTH;
        double d2 = (double) DEFAULT_HEIGHT;
        Double.isNaN(d);
        Double.isNaN(d2);
        rate = d / d2;
    }

    public static void openFrontalCamera(int i) {
        Camera camera = mCamera;
        if (camera != null) {
            camera.setDisplayOrientation(mOrientation);
            civ.O000000o(TAG, "camera already initialized!");
            return;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i2 = 0;
        while (true) {
            if (i2 >= numberOfCameras) {
                break;
            }
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                mCamera = Camera.open(i2);
                mCameraID = cameraInfo.facing;
                break;
            }
            i2++;
        }
        if (mCamera == null) {
            mCamera = Camera.open();
            mCameraID = 0;
        }
        Camera camera2 = mCamera;
        if (camera2 != null) {
            Camera.Parameters parameters = camera2.getParameters();
            mCameraPreviewFps = chooseFixedPreviewFps(parameters, i * 1000);
            parameters.setPictureFormat(256);
            parameters.setRecordingHint(true);
            parameters.setJpegQuality(100);
            if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
            }
            mCamera.setParameters(parameters);
            setPreviewSize(mCamera, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            setPictureSize(mCamera, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            mCamera.setDisplayOrientation(mOrientation);
            mCamera.cancelAutoFocus();
            mCamera.setPreviewCallback(previewCallback);
            mCamera.setErrorCallback(errorCallback);
            return;
        }
        throw new RuntimeException("Unable to open camera");
    }

    public static int getPreviewFormat() {
        return mCamera.getParameters().getPreviewFormat();
    }

    public static void openCamera(int i, int i2) {
        if (mCamera == null) {
            Camera open = Camera.open(i);
            mCamera = open;
            if (open != null) {
                mCameraID = i;
                Camera.Parameters parameters = mCamera.getParameters();
                mCameraPreviewFps = chooseFixedPreviewFps(parameters, i2 * 1000);
                parameters.setPictureFormat(256);
                parameters.setRecordingHint(true);
                parameters.setJpegQuality(100);
                if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                }
                mCamera.setParameters(parameters);
                setPreviewSize(mCamera, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                setPictureSize(mCamera, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                mCamera.setDisplayOrientation(mOrientation);
                mCamera.cancelAutoFocus();
                mCamera.setPreviewCallback(previewCallback);
                mCamera.setErrorCallback(errorCallback);
                return;
            }
            throw new RuntimeException("Unable to open camera");
        }
        throw new RuntimeException("camera already initialized!");
    }

    public static void autoFocus(AutoFocusCallback autoFocusCallback2) {
        mCamera.autoFocus(autoFocusCallback2);
    }

    static class AutoFocusCallback implements Camera.AutoFocusCallback {
        AutoFocusCallback() {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            civ.O000000o(CameraUtils.TAG, "onAutoFocus");
        }
    }

    public static void startPreviewDisplay(SurfaceHolder surfaceHolder) {
        Camera camera = mCamera;
        if (camera == null) {
            civ.O000000o(TAG, "Camera must be set when start preview");
            return;
        }
        try {
            camera.setPreviewDisplay(surfaceHolder);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchCamera(int i, SurfaceHolder surfaceHolder) {
        if (mCameraID != i) {
            mCameraID = i;
            releaseCamera();
            openCamera(i, 30);
            startPreviewDisplay(surfaceHolder);
        }
    }

    public static void releaseCamera() {
        Camera camera = mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.lock();
            mCamera.release();
            mCamera = null;
        }
    }

    public static void startPreview() {
        Camera camera = mCamera;
        if (camera != null) {
            camera.startPreview();
        }
    }

    public static void stopPreview() {
        Camera camera = mCamera;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    public static void takePicture(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        Camera camera = mCamera;
        if (camera != null) {
            camera.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
        }
    }

    public static void setPreviewSize(Camera camera, int i, int i2) {
        List<Camera.Size> supportedPreviewSizes = getSupportedPreviewSizes();
        if (supportedPreviewSizes != null) {
            civ.O000000o(TAG, "previewSizes:");
            supportedPreviewSizes.get(0);
            for (Camera.Size next : supportedPreviewSizes) {
                String str = TAG;
                civ.O000000o(str, next.width + "-" + next.height);
            }
        }
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size calculatePerfectSize = calculatePerfectSize(parameters.getSupportedPreviewSizes(), i, i2);
        String str2 = TAG;
        civ.O000000o(str2, "calculated : " + calculatePerfectSize.width + "-" + calculatePerfectSize.height);
        String str3 = TAG;
        civ.O000000o(str3, "expectWidth : " + i + "-" + i2);
        mPreviewWidth = calculatePerfectSize.width;
        mPreviewHeight = calculatePerfectSize.height;
        previewSize = calculatePerfectSize;
        parameters.setPreviewSize(calculatePerfectSize.width, calculatePerfectSize.height);
        camera.setParameters(parameters);
    }

    public static Camera.Size getPreviewSize() {
        Camera.Size size = previewSize;
        if (size != null) {
            return size;
        }
        String str = TAG;
        civ.O000000o(str, "getPreviewSize result=" + previewSize.width + "-" + previewSize.height);
        return previewSize;
    }

    public static List<Camera.Size> getSupportedPreviewSizes() {
        Camera camera = mCamera;
        if (camera != null) {
            return camera.getParameters().getSupportedPreviewSizes();
        }
        return null;
    }

    public static void setPictureSize(Camera camera, int i, int i2) {
        List<Camera.Size> supportedPictureSizes = getSupportedPictureSizes();
        if (supportedPictureSizes != null) {
            civ.O000000o(TAG, "pictureSizes:");
            supportedPictureSizes.get(0);
            for (Camera.Size next : supportedPictureSizes) {
                String str = TAG;
                civ.O000000o(str, next.width + "-" + next.height);
            }
        }
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size calculatePerfectSize = calculatePerfectSize(parameters.getSupportedPictureSizes(), i, i2);
        String str2 = TAG;
        civ.O000000o(str2, "calculated : " + calculatePerfectSize.width + "-" + calculatePerfectSize.height);
        String str3 = TAG;
        civ.O000000o(str3, "expectWidth : " + i + "-" + i2);
        parameters.setPictureSize(calculatePerfectSize.width, calculatePerfectSize.height);
        camera.setParameters(parameters);
    }

    public static Camera.Size getPictureSize() {
        Camera camera = mCamera;
        if (camera != null) {
            return camera.getParameters().getPictureSize();
        }
        return null;
    }

    public static List<Camera.Size> getSupportedPictureSizes() {
        Camera camera = mCamera;
        if (camera != null) {
            return camera.getParameters().getSupportedPictureSizes();
        }
        return null;
    }

    public static Camera.Size calculatePerfectSize(List<Camera.Size> list, int i, int i2) {
        sortList(list);
        Camera.Size size = list.get(0);
        double d = Double.MAX_VALUE;
        for (Camera.Size next : list) {
            String str = TAG;
            civ.O000000o(str, "calculatePerfectSize" + next.width + "-" + next.height);
            double d2 = (double) next.width;
            double d3 = (double) next.height;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = d2 / d3;
            double abs = Math.abs(d4 - rate);
            if (d4 > 1.5d) {
                if (next.width < 1080) {
                    break;
                } else if (abs < d) {
                    size = next;
                    d = abs;
                }
            } else {
                return next;
            }
        }
        return size;
    }

    private static void sortList(List<Camera.Size> list) {
        Collections.sort(list, new Comparator<Camera.Size>() {
            /* class com.xiaomi.smarthome.miio.camera.face.util.CameraUtils.AnonymousClass3 */

            public final int compare(Camera.Size size, Camera.Size size2) {
                if (size.width < size2.width) {
                    return 1;
                }
                return size.width > size2.width ? -1 : 0;
            }
        });
    }

    public static int chooseFixedPreviewFps(Camera.Parameters parameters, int i) {
        for (int[] next : parameters.getSupportedPreviewFpsRange()) {
            if (next[0] == next[1] && next[0] == i) {
                parameters.setPreviewFpsRange(next[0], next[1]);
                return next[0];
            }
        }
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        if (iArr[0] == iArr[1]) {
            return iArr[0];
        }
        return iArr[1] / 2;
    }

    public static int calculateCameraPreviewOrientation(Activity activity) {
        int i;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(mCameraID, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        civ.O000000o(TAG, "degrees=".concat(String.valueOf(i2)));
        String str = TAG;
        civ.O000000o(str, "info.orientation=" + cameraInfo.orientation);
        if (cameraInfo.facing == 1) {
            i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        } else {
            i = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        mOrientation = i;
        return i;
    }

    public static int getCameraID() {
        return mCameraID;
    }

    public static int getPreviewOrientation() {
        return mOrientation;
    }

    public static int getCameraPreviewThousandFps() {
        return mCameraPreviewFps;
    }
}
