package _m_j;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.whichOne;
import in.cashify.otex.widget.CameraPreview;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.face.Face;
import org.opencv.face.Facemark;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoWriter;

public class gdc extends JavaCameraView implements CameraBridgeViewBase.O00000o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17552O000000o = "gdc";
    private static final Scalar O000OO = new Scalar(255.0d, 255.0d, 0.0d, 255.0d);
    public SurfaceHolder O00000Oo;
    public int O00000o;
    public ThemedReactContext O00000o0;
    public int O00000oO = -1;
    public boolean O00000oo = false;
    public gdj O0000O0o;
    public gdi O0000OOo;
    public boolean O0000Oo = false;
    public gdf O0000Oo0;
    public ReadableMap O0000OoO;
    private ReadableMap O000O00o;
    private Mat O000O0OO;
    private int O000O0Oo = 0;
    private CascadeClassifier O000O0o;
    private CascadeClassifier O000O0o0;
    private CascadeClassifier O000O0oO;
    private CascadeClassifier O000O0oo;
    private boolean O000OO00;
    private Facemark O000OO0o;
    private boolean O000OOOo = false;
    private boolean O000OOo = false;
    private boolean O000OOo0 = false;
    private boolean O000OOoO = true;
    private float O000OOoo = 0.2f;
    private int O000Oo0 = -1;
    private int O000Oo00 = 0;
    private long O000Oo0O = -1;
    private int O000Oo0o = -1;
    private VideoWriter O000OoO0 = null;
    private ReadableMap O00oOoOo;

    private static double O000000o(double d, double d2, double d3, double d4) {
        double d5 = d3 - d;
        double d6 = d4 - d2;
        if (d5 < 0.0d) {
            d5 = -d5;
        }
        if (d6 < 0.0d) {
            d6 = -d6;
        }
        return d5 + d6;
    }

    public gdc(ThemedReactContext themedReactContext) {
        super(themedReactContext, -1);
        gsy.O000000o(3, f17552O000000o, "Creating and setting view");
        this.O00000o = -1;
        this.O00000o0 = themedReactContext;
        setVisibility(4);
        setCvCameraViewListener(this);
        try {
            fya.O000000o();
        } catch (Exception e) {
            Log.e(f17552O000000o, "OpencvLoader.load", e);
        }
        this.O00000Oo = getHolder();
        this.O00000Oo.addCallback(this);
        this.O00000Oo.setType(3);
        if (ContextCompat.O000000o(getContext(), "android.permission.CAMERA") == 0) {
            this.O0000Oo0 = new gdf(this, null);
            this.O0000Oo0.run();
        }
        new OrientationEventListener(this.O00000o0) {
            /* class _m_j.gdc.AnonymousClass1 */

            public final void onOrientationChanged(int i) {
                if ((i >= 0 && i <= 45) || i > 315) {
                    gdc.this.O00000oO = 0;
                } else if (i > 45 && i <= 135) {
                    gdc.this.O00000oO = 1;
                } else if (i <= 135 || i > 225) {
                    gdc.this.O00000oO = -1;
                } else {
                    gdc.this.O00000oO = 2;
                }
                String str = gdc.f17552O000000o;
                gsy.O000000o(3, str, "orientation = " + gdc.this.O00000oO);
            }
        }.enable();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        gsy.O000000o(3, f17552O000000o, "In surfaceCreated ...");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        gsy.O000000o(3, f17552O000000o, "In surfaceChanged ...");
        if (this.O00000Oo.getSurface() == null) {
            gsy.O000000o(6, f17552O000000o, "In surfaceChanged surface is null ...");
            return;
        }
        try {
            O00000o0();
        } catch (Exception e) {
            gsy.O000000o(6, CameraPreview.f12275O000000o, "Error enabling camera preview: " + e.getMessage());
        }
    }

    public void setCvInvokeGroup(ReadableMap readableMap) {
        this.O00oOoOo = readableMap;
    }

    private File O000000o(String str) {
        File file = null;
        try {
            InputStream O00000Oo2 = fxx.O00000Oo(str);
            if (O00000Oo2 == null) {
                gsy.O000000o(6, f17552O000000o, "Input stream is nullified!");
            }
            File file2 = new File(this.O00000o0.getCacheDir(), str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = O00000Oo2.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        O00000Oo2.close();
                        fileOutputStream.close();
                        return file2;
                    }
                }
            } catch (IOException e) {
                e = e;
                file = file2;
                try {
                    String str2 = f17552O000000o;
                    gsy.O000000o(6, str2, "Failed to load cascade. IOException thrown: " + e.getMessage());
                    return file;
                } catch (Throwable unused) {
                    return file;
                }
            } catch (Throwable unused2) {
                return file2;
            }
        } catch (IOException e2) {
            e = e2;
            String str22 = f17552O000000o;
            gsy.O000000o(6, str22, "Failed to load cascade. IOException thrown: " + e.getMessage());
            return file;
        }
    }

    public void setOverlay(ReadableMap readableMap) {
        if (readableMap != null) {
            this.O000O00o = readableMap;
            int i = readableMap.getInt("matIndex");
            gdg.O000000o();
            Mat mat = (Mat) gdg.O000000o(i);
            if (this.O000O0OO == null) {
                this.O000O0OO = new Mat(mat.rows(), mat.cols(), CvType.CV_8UC4);
            }
            mat.copyTo(this.O000O0OO);
            mat.setTo(Scalar.all(0.0d));
            gdg.O000000o();
            gdg.O000000o(i, mat);
            this.O000OOo = true;
        }
    }

    public void setOverlayInterval(int i) {
        this.O000O0Oo = i;
    }

    public void setLandmarksModel(String str) {
        this.O000OOOo = true;
        File O000000o2 = O000000o(str + ".yaml");
        this.O000OO0o = Face.O000000o();
        this.O000OO0o.O000000o(O000000o2.getAbsolutePath());
    }

    public final void O000000o(String str, whichOne whichone) {
        this.O000OOo0 = true;
        File O000000o2 = O000000o(str + ".xml");
        if (O000000o2 != null) {
            CascadeClassifier cascadeClassifier = new CascadeClassifier(O000000o2.getAbsolutePath());
            if (cascadeClassifier.O000000o()) {
                gsy.O000000o(6, f17552O000000o, "Failed to load cascade classifier");
                cascadeClassifier = null;
            } else {
                String str2 = f17552O000000o;
                gsy.O000000o(4, str2, "Loaded classifier from " + O000000o2.getAbsolutePath());
            }
            O000000o2.delete();
            int i = AnonymousClass2.f17554O000000o[whichone.ordinal()];
            if (i == 1) {
                this.O000O0o = cascadeClassifier;
            } else if (i == 2) {
                this.O000O0oO = cascadeClassifier;
            } else if (i != 3) {
                this.O000O0o0 = cascadeClassifier;
            } else {
                this.O000O0oo = cascadeClassifier;
            }
        }
    }

    /* renamed from: _m_j.gdc$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f17554O000000o = new int[whichOne.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f17554O000000o[whichOne.EYES_CLASSIFIER.ordinal()] = 1;
            f17554O000000o[whichOne.NOSE_CLASSIFIER.ordinal()] = 2;
            f17554O000000o[whichOne.MOUTH_CLASSIFIER.ordinal()] = 3;
            try {
                f17554O000000o[whichOne.FACE_CLASSIFIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void O000000o(int i, int i2) {
        String str = f17552O000000o;
        gsy.O000000o(3, str, "In onCameraViewStarted ... width is: " + i + " height is: " + i2);
    }

    public final void O000000o() {
        gsy.O000000o(3, f17552O000000o, "In onCameraViewStopped ...");
        O00000o();
    }

    private static byte[] O000000o(Bitmap bitmap, int i) throws OutOfMemoryError {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        try {
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                Log.e(f17552O000000o, "In toJpeg problem compressing jpeg: ", e);
            }
        }
    }

    private String O000000o(Mat mat, String str, Rect rect) {
        double d;
        double d2;
        String str2 = str;
        StringBuffer stringBuffer = new StringBuffer();
        if (str2 != null) {
            stringBuffer.append(",\"" + str2 + "\":");
        }
        double cols = (double) mat.cols();
        double rows = (double) mat.rows();
        double d3 = rect.tl().x;
        double d4 = rect.tl().y;
        double d5 = rect.br().x;
        double d6 = rect.br().y;
        Double.isNaN(cols);
        double d7 = d3 / cols;
        Double.isNaN(rows);
        double d8 = d4 / rows;
        Double.isNaN(cols);
        Double.isNaN(rows);
        double d9 = (d6 - d4) / rows;
        double d10 = (d5 - d3) / cols;
        int i = this.O00000oO;
        if (i != 0) {
            if (i == 1) {
                Double.isNaN(cols);
                d7 = 1.0d - (d5 / cols);
                Double.isNaN(rows);
                d2 = 1.0d - (d6 / rows);
                d = d9;
            } else if (i != 2) {
                d = d9;
                d2 = d8;
            } else {
                Double.isNaN(rows);
                d = d10;
                d2 = d7;
                d7 = 1.0d - (d6 / rows);
            }
            d9 = d10;
        } else {
            Double.isNaN(cols);
            d2 = 1.0d - (d5 / cols);
            d7 = d8;
            d = d10;
        }
        stringBuffer.append("{\"x\":" + d7 + ",\"y\":" + d2 + ",\"width\":" + d9 + ",\"height\":" + d);
        if (str2 != null) {
            stringBuffer.append("}");
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0575  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0592  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0624  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0108  */
    public final Mat O000000o(CameraBridgeViewBase.O000000o o000000o) {
        Mat mat;
        Mat mat2;
        String str;
        String str2;
        Mat mat3;
        Mat mat4;
        MatOfRect matOfRect;
        ArrayList arrayList;
        boolean z;
        Rect[] array;
        String str3;
        String str4;
        int i;
        String str5;
        Mat mat5;
        Rect[] rectArr;
        boolean z2;
        Mat mat6;
        StringBuffer stringBuffer;
        int i2;
        double d;
        double d2;
        int i3;
        Mat O000000o2 = o000000o.O000000o();
        Mat O00000Oo2 = o000000o.O00000Oo();
        if (this.O000Oo0O == -1) {
            this.O000Oo0O = System.currentTimeMillis();
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        String str6 = "payload";
        writableNativeMap.putString(str6, "{\"frameSize\":{\"frameWidth\":" + O000000o2.size().width + ",\"frameHeight\":" + O000000o2.size().height + "}}");
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.O00000o0.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFrameSize", writableNativeMap);
        if (this.O00000o == 1) {
            Core.flip(O000000o2, O000000o2, 1);
            Core.flip(O00000Oo2, O00000Oo2, 1);
        }
        if (this.O000OOo0) {
            Imgproc.equalizeHist(O00000Oo2, O00000Oo2);
            int i4 = this.O00000oO;
            if (i4 != -1) {
                Core.rotate(O00000Oo2, O00000Oo2, i4);
            }
            float rows = (float) O00000Oo2.rows();
            if (Math.round(this.O000OOoo * rows) > 0) {
                this.O000Oo00 = Math.round(rows * this.O000OOoo);
            }
            MatOfRect matOfRect2 = new MatOfRect();
            ArrayList arrayList2 = new ArrayList();
            CascadeClassifier cascadeClassifier = this.O000O0o0;
            if (cascadeClassifier == null || O00000Oo2 == null) {
                arrayList = arrayList2;
                matOfRect = matOfRect2;
                str = "";
            } else if (this.O000OOOo) {
                int i5 = this.O000Oo00;
                Size size = new Size((double) i5, (double) i5);
                matOfRect = matOfRect2;
                arrayList = arrayList2;
                cascadeClassifier.O000000o(O00000Oo2, matOfRect2, 1.3d, 5, size, new Size());
                this.O000OO0o.O000000o(O00000Oo2, matOfRect, arrayList);
                if (arrayList.size() > 0) {
                    str = "";
                    z = true;
                    array = matOfRect.toArray();
                    if (array.length <= 0) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("{\"faces\":[");
                        int i6 = 0;
                        while (i6 < array.length) {
                            stringBuffer2.append(O000000o(O00000Oo2, null, array[i6]));
                            String concat = "faceId".concat(String.valueOf(i6));
                            stringBuffer2.append(",\"faceId\":\"" + concat + jdn.f1779O000000o);
                            if (this.O000O0o == null && this.O000O0oO == null && this.O000O0oo == null) {
                                z2 = z;
                                rectArr = array;
                                stringBuffer = stringBuffer2;
                                i = i6;
                                mat6 = O00000Oo2;
                                mat5 = O000000o2;
                                str5 = str6;
                            } else {
                                Mat submat = O00000Oo2.submat(array[i6]);
                                if (this.O000O0o != null) {
                                    MatOfRect matOfRect3 = new MatOfRect();
                                    this.O000O0o.O000000o(submat, matOfRect3);
                                    Rect[] array2 = matOfRect3.toArray();
                                    double d3 = (double) array[i6].height;
                                    Double.isNaN(d3);
                                    double d4 = d3 * 0.2d;
                                    if (array2.length > 0) {
                                        int i7 = 0;
                                        int i8 = -1;
                                        double d5 = 10000.0d;
                                        while (i7 < array2.length) {
                                            double d6 = (double) array[i6].width;
                                            Double.isNaN(d6);
                                            double d7 = 0.3d * d6;
                                            double d8 = (double) array2[i7].x;
                                            Mat mat7 = O000000o2;
                                            String str7 = str6;
                                            double d9 = (double) array2[i7].width;
                                            Double.isNaN(d9);
                                            Double.isNaN(d8);
                                            double d10 = d8 + (d9 * 0.5d);
                                            double d11 = (double) array2[i7].y;
                                            double d12 = (double) array2[i7].height;
                                            Double.isNaN(d12);
                                            Double.isNaN(d11);
                                            double O000000o3 = O000000o(d7, d4, d10, d11 + (d12 * 0.5d));
                                            if (O000000o3 < d5) {
                                                d5 = O000000o3;
                                                i8 = i7;
                                            }
                                            i7++;
                                            O000000o2 = mat7;
                                            str6 = str7;
                                        }
                                        mat5 = O000000o2;
                                        str5 = str6;
                                        stringBuffer2.append(O000000o(submat, "firstEye", array2[i8]));
                                        i3 = i8;
                                    } else {
                                        mat5 = O000000o2;
                                        str5 = str6;
                                        i3 = -1;
                                    }
                                    if (array2.length > 1) {
                                        mat6 = O00000Oo2;
                                        int i9 = 0;
                                        int i10 = -1;
                                        double d13 = 10000.0d;
                                        while (i9 < array2.length) {
                                            boolean z3 = z;
                                            Rect[] rectArr2 = array;
                                            double d14 = (double) array[i6].width;
                                            Double.isNaN(d14);
                                            double d15 = 0.7d * d14;
                                            double d16 = (double) array2[i9].x;
                                            StringBuffer stringBuffer3 = stringBuffer2;
                                            int i11 = i6;
                                            double d17 = (double) array2[i9].width;
                                            Double.isNaN(d17);
                                            Double.isNaN(d16);
                                            double d18 = d16 + (d17 * 0.5d);
                                            double d19 = (double) array2[i9].y;
                                            double d20 = (double) array2[i9].height;
                                            Double.isNaN(d20);
                                            Double.isNaN(d19);
                                            double O000000o4 = O000000o(d15, d4, d18, d19 + (d20 * 0.5d));
                                            if (O000000o4 < d13 && i3 != i9) {
                                                d13 = O000000o4;
                                                i10 = i9;
                                            }
                                            i9++;
                                            z = z3;
                                            array = rectArr2;
                                            stringBuffer2 = stringBuffer3;
                                            i6 = i11;
                                        }
                                        z2 = z;
                                        rectArr = array;
                                        i = i6;
                                        stringBuffer = stringBuffer2;
                                        stringBuffer.append(O000000o(submat, "secondEye", array2[i10]));
                                    } else {
                                        z2 = z;
                                        rectArr = array;
                                        stringBuffer = stringBuffer2;
                                        i = i6;
                                        mat6 = O00000Oo2;
                                    }
                                } else {
                                    z2 = z;
                                    rectArr = array;
                                    stringBuffer = stringBuffer2;
                                    i = i6;
                                    mat6 = O00000Oo2;
                                    mat5 = O000000o2;
                                    str5 = str6;
                                }
                                if (this.O000O0oO != null) {
                                    MatOfRect matOfRect4 = new MatOfRect();
                                    this.O000O0oO.O000000o(submat, matOfRect4);
                                    Rect[] array3 = matOfRect4.toArray();
                                    if (array3.length > 0) {
                                        int i12 = -1;
                                        double d21 = 10000.0d;
                                        for (int i13 = 0; i13 < array3.length; i13++) {
                                            double d22 = (double) rectArr[i].width;
                                            Double.isNaN(d22);
                                            double d23 = d22 * 0.5d;
                                            double d24 = (double) rectArr[i].height;
                                            Double.isNaN(d24);
                                            double d25 = d24 * 0.5d;
                                            double d26 = (double) array3[i13].x;
                                            double d27 = (double) array3[i13].width;
                                            Double.isNaN(d27);
                                            Double.isNaN(d26);
                                            double d28 = d26 + (d27 * 0.5d);
                                            double d29 = (double) array3[i13].y;
                                            double d30 = (double) array3[i13].height;
                                            Double.isNaN(d30);
                                            Double.isNaN(d29);
                                            double O000000o5 = O000000o(d23, d25, d28, d29 + (d30 * 0.5d));
                                            if (O000000o5 < d21) {
                                                i12 = i13;
                                                d21 = O000000o5;
                                            }
                                        }
                                        stringBuffer.append(O000000o(submat, "nose", array3[i12]));
                                    }
                                }
                                if (this.O000O0oo != null) {
                                    double rows2 = (double) submat.rows();
                                    Double.isNaN(rows2);
                                    int round = (int) Math.round(rows2 * 0.6d);
                                    int cols = submat.cols();
                                    double rows3 = (double) submat.rows();
                                    Double.isNaN(rows3);
                                    Mat submat2 = submat.submat(new Rect(0, round, cols, (int) Math.round(rows3 * 0.4d)));
                                    MatOfRect matOfRect5 = new MatOfRect();
                                    this.O000O0oo.O000000o(submat2, matOfRect5);
                                    Rect[] array4 = matOfRect5.toArray();
                                    if (array4.length > 0) {
                                        int i14 = -1;
                                        double d31 = 10000.0d;
                                        for (int i15 = 0; i15 < array4.length; i15++) {
                                            double d32 = (double) rectArr[i].width;
                                            Double.isNaN(d32);
                                            double d33 = d32 * 0.5d;
                                            double d34 = (double) rectArr[i].height;
                                            Double.isNaN(d34);
                                            double d35 = d34 * 0.8d;
                                            double d36 = (double) array4[i15].x;
                                            double d37 = (double) array4[i15].width;
                                            Double.isNaN(d37);
                                            Double.isNaN(d36);
                                            double d38 = d36 + (d37 * 0.5d);
                                            double d39 = (double) array4[i15].y;
                                            double d40 = (double) array4[i15].height;
                                            Double.isNaN(d40);
                                            Double.isNaN(d39);
                                            double d41 = d39 + (d40 * 0.5d);
                                            double d42 = (double) rectArr[i].height;
                                            Double.isNaN(d42);
                                            double O000000o6 = O000000o(d33, d35, d38, d41 + (d42 * 0.6d));
                                            if (O000000o6 < d31) {
                                                i14 = i15;
                                                d31 = O000000o6;
                                            }
                                        }
                                        int i16 = array4[i14].x;
                                        double d43 = (double) array4[i14].y;
                                        double rows4 = (double) submat.rows();
                                        Double.isNaN(rows4);
                                        Double.isNaN(d43);
                                        stringBuffer.append(O000000o(submat, "mouth", new Rect(i16, (int) Math.round(d43 + (rows4 * 0.6d)), array4[i14].width, array4[i14].height)));
                                    }
                                }
                            }
                            if (!this.O000OOOo || !z2) {
                                i2 = i;
                            } else {
                                stringBuffer.append(",\"landmarks\":[");
                                i2 = i;
                                MatOfPoint2f matOfPoint2f = (MatOfPoint2f) arrayList.get(i2);
                                for (int i17 = 0; i17 < matOfPoint2f.rows(); i17++) {
                                    double[] dArr = matOfPoint2f.get(i17, 0);
                                    Point point = new Point(dArr[0], dArr[1]);
                                    double cols2 = (double) mat6.cols();
                                    double rows5 = (double) mat6.rows();
                                    int i18 = this.O00000oO;
                                    if (i18 == 0) {
                                        double d44 = point.y;
                                        Double.isNaN(rows5);
                                        d2 = d44 / rows5;
                                        double d45 = point.x;
                                        Double.isNaN(cols2);
                                        d = 1.0d - (d45 / cols2);
                                    } else if (i18 == 1) {
                                        double d46 = point.x;
                                        Double.isNaN(cols2);
                                        d2 = 1.0d - (d46 / cols2);
                                        double d47 = point.y;
                                        Double.isNaN(rows5);
                                        d = 1.0d - (d47 / rows5);
                                    } else if (i18 != 2) {
                                        double d48 = point.x;
                                        Double.isNaN(cols2);
                                        d2 = d48 / cols2;
                                        double d49 = point.y;
                                        Double.isNaN(rows5);
                                        d = d49 / rows5;
                                    } else {
                                        double d50 = point.y;
                                        Double.isNaN(rows5);
                                        d2 = 1.0d - (d50 / rows5);
                                        double d51 = point.x;
                                        Double.isNaN(cols2);
                                        d = d51 / cols2;
                                    }
                                    Point point2 = new Point(d2, d);
                                    stringBuffer.append("{\"x\":" + point2.x + ",\"y\":" + point2.y + "}");
                                    if (i17 != matOfPoint2f.rows() - 1) {
                                        stringBuffer.append(",");
                                    }
                                }
                                stringBuffer.append("]");
                            }
                            Rect[] rectArr3 = rectArr;
                            if (i2 != rectArr3.length - 1) {
                                stringBuffer.append("},");
                            } else {
                                stringBuffer.append("}");
                            }
                            stringBuffer2 = stringBuffer;
                            array = rectArr3;
                            O00000Oo2 = mat6;
                            O000000o2 = mat5;
                            str6 = str5;
                            i6 = i2 + 1;
                            z = z2;
                        }
                        StringBuffer stringBuffer4 = stringBuffer2;
                        mat2 = O00000Oo2;
                        mat = O000000o2;
                        str3 = str6;
                        stringBuffer4.append("]}");
                        str4 = stringBuffer4.toString();
                    } else {
                        mat2 = O00000Oo2;
                        mat = O000000o2;
                        str3 = str6;
                        str4 = str;
                    }
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    str2 = str3;
                    writableNativeMap2.putString(str2, str4);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.O00000o0.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFacesDetectedCv", writableNativeMap2);
                } else {
                    str = "";
                }
            } else {
                arrayList = arrayList2;
                matOfRect = matOfRect2;
                int i19 = this.O000Oo00;
                str = "";
                cascadeClassifier.O000000o(O00000Oo2, matOfRect, 1.1d, 2, new Size((double) i19, (double) i19), new Size());
            }
            z = false;
            array = matOfRect.toArray();
            if (array.length <= 0) {
            }
            WritableNativeMap writableNativeMap22 = new WritableNativeMap();
            str2 = str3;
            writableNativeMap22.putString(str2, str4);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.O00000o0.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onFacesDetectedCv", writableNativeMap22);
        } else {
            mat2 = O00000Oo2;
            mat = O000000o2;
            str2 = str6;
            str = "";
        }
        if (this.O00oOoOo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.O000Oo0O >= ((long) this.O000O0Oo)) {
                this.O000Oo0O = currentTimeMillis;
                mat3 = mat;
                gdd gdd = new gdd(mat3, mat2);
                WritableArray O000000o7 = gdd.O000000o(this.O00oOoOo);
                String str8 = gdd.O00000Oo;
                int i20 = gdd.f17555O000000o;
                if (str8 == null || str8.equals(str) || i20 < 0 || i20 >= 1000) {
                    if (i20 == 1000) {
                        gsy.O000000o(6, f17552O000000o, "SecurityException thrown attempting to invoke method.  Check your method name and parameters and make sure they are correct.");
                    } else if (i20 == 1001) {
                        gsy.O000000o(6, f17552O000000o, "IllegalAccessException thrown attempting to invoke method.  Check your method name and parameters and make sure they are correct.");
                    } else if (i20 == 1002) {
                        gsy.O000000o(6, f17552O000000o, "InvocationTargetException thrown attempting to invoke method.  Check your method name and parameters and make sure they are correct.");
                    }
                    mat4 = this.O000O0OO;
                    if (mat4 != null) {
                        Core.addWeighted(mat3, 1.0d, mat4, 1.0d, 0.0d, mat3);
                    }
                    if (this.O00000oo) {
                        this.O00000oo = false;
                        gdj gdj = this.O0000O0o;
                        gdj.f17561O000000o = mat3;
                        gdj.run();
                    }
                    if (this.O0000Oo) {
                        if (this.O000OoO0 == null) {
                            Size size2 = mat3.size();
                            this.O000Oo0 = this.O00000oO;
                            int i21 = this.O000Oo0;
                            if (i21 == 0 || i21 == 2) {
                                size2 = new Size(mat3.size().height, mat3.size().width);
                            }
                            this.O000OoO0 = new VideoWriter(this.O0000OoO.getString("filename"), VideoWriter.O000000o(), size2);
                        }
                        Mat mat8 = new Mat();
                        Core.rotate(mat3, mat8, this.O000Oo0);
                        this.O000OoO0.O000000o(mat8);
                        mat8.release();
                    } else {
                        VideoWriter videoWriter = this.O000OoO0;
                        if (videoWriter != null) {
                            videoWriter.O00000Oo();
                            this.O000OoO0 = null;
                            int i22 = this.O000Oo0;
                            if (i22 == 0 || i22 == 2) {
                                this.O0000OOo.O00000Oo = (int) mat3.size().height;
                                this.O0000OOo.O00000o0 = (int) mat3.size().width;
                            } else {
                                this.O0000OOo.O00000Oo = (int) mat3.size().width;
                                this.O0000OOo.O00000o0 = (int) mat3.size().height;
                            }
                            this.O0000OOo.run();
                        }
                    }
                    if (this.O000OO00) {
                        Bitmap createBitmap = Bitmap.createBitmap(mat3.cols(), mat3.rows(), Bitmap.Config.ARGB_8888);
                        Utils.O000000o(mat3, createBitmap);
                        String encodeToString = Base64.encodeToString(O000000o(createBitmap, 60), 2);
                        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                        writableNativeMap3.putString(str2, encodeToString);
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.O00000o0.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onCameraFrame", writableNativeMap3);
                    }
                    return mat3;
                }
                WritableNativeMap writableNativeMap4 = new WritableNativeMap();
                writableNativeMap4.putArray(str2, O000000o7);
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.O00000o0.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str8, writableNativeMap4);
                mat4 = this.O000O0OO;
                if (mat4 != null) {
                }
                if (this.O00000oo) {
                }
                if (this.O0000Oo) {
                }
                if (this.O000OO00) {
                }
                return mat3;
            }
        }
        mat3 = mat;
        mat4 = this.O000O0OO;
        if (mat4 != null) {
        }
        if (this.O00000oo) {
        }
        if (this.O0000Oo) {
        }
        if (this.O000OO00) {
        }
        return mat3;
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo2 = super.O00000Oo(i, i2);
        gsy.O000000o(3, f17552O000000o, "In connectCamera ...");
        return O00000Oo2;
    }

    public final void O00000Oo() {
        super.O00000Oo();
        gsy.O000000o(3, f17552O000000o, "In disconnectCamera ...");
    }
}
