package org.opencv.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

@TargetApi(21)
public class JavaCamera2View extends CameraBridgeViewBase {
    static final /* synthetic */ boolean O00000oo = (!JavaCamera2View.class.desiredAssertionStatus());

    /* renamed from: O000000o  reason: collision with root package name */
    public int f15456O000000o = 35;
    public CameraDevice O00000Oo;
    public CaptureRequest.Builder O00000o;
    public CameraCaptureSession O00000o0;
    public Handler O00000oO;
    private ImageReader O0000O0o;
    private String O0000OOo;
    private HandlerThread O0000Oo;
    private Size O0000Oo0 = new Size(-1, -1);
    private final CameraDevice.StateCallback O0000OoO = new CameraDevice.StateCallback() {
        /* class org.opencv.android.JavaCamera2View.AnonymousClass1 */

        public final void onOpened(CameraDevice cameraDevice) {
            JavaCamera2View javaCamera2View = JavaCamera2View.this;
            javaCamera2View.O00000Oo = cameraDevice;
            javaCamera2View.O000000o();
        }

        public final void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            JavaCamera2View.this.O00000Oo = null;
        }

        public final void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            JavaCamera2View.this.O00000Oo = null;
        }
    };

    public JavaCamera2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void O00000oo() {
        Log.i("JavaCamera2View", "stopBackgroundThread");
        HandlerThread handlerThread = this.O0000Oo;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.O0000Oo.join();
                this.O0000Oo = null;
                this.O00000oO = null;
            } catch (InterruptedException e) {
                Log.e("JavaCamera2View", "stopBackgroundThread", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        r11.O0000OOo = r7;
     */
    private boolean O0000O0o() {
        Log.i("JavaCamera2View", "initializeCamera");
        CameraManager cameraManager = (CameraManager) getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("JavaCamera2View", "Error: camera isn't detected.");
                return false;
            }
            if (this.O0000oO0 != -1) {
                int length = cameraIdList.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = cameraIdList[i];
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if (!((this.O0000oO0 == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (this.O0000oO0 == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0))) {
                        i++;
                    }
                }
            } else {
                this.O0000OOo = cameraIdList[0];
            }
            if (this.O0000OOo != null) {
                Log.i("JavaCamera2View", "Opening camera: " + this.O0000OOo);
                cameraManager.openCamera(this.O0000OOo, this.O0000OoO, this.O00000oO);
            }
            return true;
        } catch (CameraAccessException e) {
            Log.e("JavaCamera2View", "OpenCamera - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e("JavaCamera2View", "OpenCamera - Illegal Argument Exception", e2);
            return false;
        } catch (SecurityException e3) {
            Log.e("JavaCamera2View", "OpenCamera - Security Exception", e3);
            return false;
        }
    }

    public final void O000000o() {
        final int width = this.O0000Oo0.getWidth();
        final int height = this.O0000Oo0.getHeight();
        Log.i("JavaCamera2View", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0 && height >= 0) {
            try {
                if (this.O00000Oo == null) {
                    Log.e("JavaCamera2View", "createCameraPreviewSession: camera isn't opened");
                } else if (this.O00000o0 != null) {
                    Log.e("JavaCamera2View", "createCameraPreviewSession: mCaptureSession is already started");
                } else {
                    this.O0000O0o = ImageReader.newInstance(width, height, this.f15456O000000o, 2);
                    this.O0000O0o.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                        /* class org.opencv.android.JavaCamera2View.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        static final /* synthetic */ boolean f15458O000000o = (!JavaCamera2View.class.desiredAssertionStatus());

                        public final void onImageAvailable(ImageReader imageReader) {
                            Image acquireLatestImage = imageReader.acquireLatestImage();
                            if (acquireLatestImage != null) {
                                Image.Plane[] planes = acquireLatestImage.getPlanes();
                                if (!f15458O000000o && planes.length != 3) {
                                    throw new AssertionError();
                                } else if (!f15458O000000o && acquireLatestImage.getFormat() != JavaCamera2View.this.f15456O000000o) {
                                    throw new AssertionError();
                                } else if (!f15458O000000o && planes[0].getPixelStride() != 1) {
                                    throw new AssertionError();
                                } else if (!f15458O000000o && planes[1].getPixelStride() != 2) {
                                    throw new AssertionError();
                                } else if (f15458O000000o || planes[2].getPixelStride() == 2) {
                                    ByteBuffer buffer = planes[0].getBuffer();
                                    ByteBuffer buffer2 = planes[1].getBuffer();
                                    O000000o o000000o = new O000000o(new Mat(height, width, CvType.CV_8UC1, buffer), new Mat(height / 2, width / 2, CvType.CV_8UC2, buffer2), width, height);
                                    JavaCamera2View.this.O00000Oo(o000000o);
                                    o000000o.f15460O000000o.release();
                                    acquireLatestImage.close();
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                    }, this.O00000oO);
                    Surface surface = this.O0000O0o.getSurface();
                    this.O00000o = this.O00000Oo.createCaptureRequest(1);
                    this.O00000o.addTarget(surface);
                    this.O00000Oo.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                        /* class org.opencv.android.JavaCamera2View.AnonymousClass3 */

                        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            Log.i("JavaCamera2View", "createCaptureSession::onConfigured");
                            if (JavaCamera2View.this.O00000Oo != null) {
                                JavaCamera2View javaCamera2View = JavaCamera2View.this;
                                javaCamera2View.O00000o0 = cameraCaptureSession;
                                try {
                                    javaCamera2View.O00000o.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                    JavaCamera2View.this.O00000o.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                    JavaCamera2View.this.O00000o0.setRepeatingRequest(JavaCamera2View.this.O00000o.build(), null, JavaCamera2View.this.O00000oO);
                                    Log.i("JavaCamera2View", "CameraPreviewSession has been started");
                                } catch (Exception e) {
                                    Log.e("JavaCamera2View", "createCaptureSession failed", e);
                                }
                            }
                        }

                        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Log.e("JavaCamera2View", "createCameraPreviewSession failed");
                        }
                    }, null);
                }
            } catch (CameraAccessException e) {
                Log.e("JavaCamera2View", "createCameraPreviewSession", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        Log.i("JavaCamera2View", "closeCamera");
        try {
            CameraDevice cameraDevice = this.O00000Oo;
            this.O00000Oo = null;
            if (this.O00000o0 != null) {
                this.O00000o0.close();
                this.O00000o0 = null;
            }
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            if (this.O0000O0o != null) {
                this.O0000O0o.close();
                this.O0000O0o = null;
            }
        } finally {
            O00000oo();
        }
    }

    private boolean O000000o(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        Log.i("JavaCamera2View", "calcPreviewSize: " + i3 + "x" + i4);
        if (this.O0000OOo == null) {
            Log.e("JavaCamera2View", "Camera isn't initialized!");
            return false;
        }
        try {
            float f = ((float) i3) / ((float) i4);
            Size[] outputSizes = ((StreamConfigurationMap) ((CameraManager) getContext().getSystemService("camera")).getCameraCharacteristics(this.O0000OOo).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(ImageReader.class);
            int width = outputSizes[0].getWidth();
            int height = outputSizes[0].getHeight();
            int i5 = height;
            int i6 = width;
            for (Size size : outputSizes) {
                int width2 = size.getWidth();
                int height2 = size.getHeight();
                Log.d("JavaCamera2View", "trying size: " + width2 + "x" + height2);
                if (i3 >= width2 && i4 >= height2 && i6 <= width2 && i5 <= height2 && ((double) Math.abs(f - (((float) width2) / ((float) height2)))) < 0.2d) {
                    i5 = height2;
                    i6 = width2;
                }
            }
            Log.i("JavaCamera2View", "best size: " + i6 + "x" + i5);
            if (!O00000oo) {
                if (i6 == 0 || i5 == 0) {
                    throw new AssertionError();
                }
            }
            if (this.O0000Oo0.getWidth() == i6 && this.O0000Oo0.getHeight() == i5) {
                return false;
            }
            this.O0000Oo0 = new Size(i6, i5);
            return true;
        } catch (CameraAccessException e) {
            Log.e("JavaCamera2View", "calcPreviewSize - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e("JavaCamera2View", "calcPreviewSize - Illegal Argument Exception", e2);
            return false;
        } catch (SecurityException e3) {
            Log.e("JavaCamera2View", "calcPreviewSize - Security Exception", e3);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean O00000Oo(int i, int i2) {
        Log.i("JavaCamera2View", "setCameraPreviewSize(" + i + "x" + i2 + ")");
        Log.i("JavaCamera2View", "startBackgroundThread");
        O00000oo();
        this.O0000Oo = new HandlerThread("OpenCVCameraBackground");
        this.O0000Oo.start();
        this.O00000oO = new Handler(this.O0000Oo.getLooper());
        O0000O0o();
        try {
            boolean O000000o2 = O000000o(i, i2);
            this.O0000Ooo = this.O0000Oo0.getWidth();
            this.O0000o00 = this.O0000Oo0.getHeight();
            if (getLayoutParams().width == -1 && getLayoutParams().height == -1) {
                this.O0000o0o = Math.min(((float) i2) / ((float) this.O0000o00), ((float) i) / ((float) this.O0000Ooo));
            } else {
                this.O0000o0o = 0.0f;
            }
            O00000oO();
            if (!O000000o2) {
                return true;
            }
            if (this.O00000o0 != null) {
                Log.d("JavaCamera2View", "closing existing previewSession");
                this.O00000o0.close();
                this.O00000o0 = null;
            }
            O000000o();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }

    class O000000o implements CameraBridgeViewBase.O000000o {
        static final /* synthetic */ boolean O00000Oo = (!JavaCamera2View.class.desiredAssertionStatus());

        /* renamed from: O000000o  reason: collision with root package name */
        Mat f15460O000000o = new Mat();
        private Mat O00000o;
        private Mat O00000oO;
        private int O00000oo;
        private int O0000O0o;

        public final Mat O00000Oo() {
            return this.O00000o.submat(0, this.O0000O0o, 0, this.O00000oo);
        }

        public final Mat O000000o() {
            if (JavaCamera2View.this.f15456O000000o == 17) {
                Imgproc.cvtColor(this.O00000o, this.f15460O000000o, 96, 4);
            } else if (JavaCamera2View.this.f15456O000000o == 842094169) {
                Imgproc.cvtColor(this.O00000o, this.f15460O000000o, 100, 4);
            } else if (JavaCamera2View.this.f15456O000000o != 35) {
                throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
            } else if (O00000Oo || this.O00000oO != null) {
                Imgproc.cvtColorTwoPlane(this.O00000o, this.O00000oO, this.f15460O000000o, 96);
            } else {
                throw new AssertionError();
            }
            return this.f15460O000000o;
        }

        public O000000o(Mat mat, Mat mat2, int i, int i2) {
            this.O00000oo = i;
            this.O0000O0o = i2;
            this.O00000o = mat;
            this.O00000oO = mat2;
        }
    }
}
