package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3;

import _m_j.fya;
import _m_j.gdd;
import _m_j.gde;
import _m_j.gdg;
import _m_j.gsy;
import android.widget.Toast;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class RNOpencv3Module extends ReactContextBaseJavaModule {
    private static final String TAG = "RNOpencv3Module";
    private ReactApplicationContext reactContext;

    public String getName() {
        return "RNOpencv3";
    }

    static {
        fya.O000000o();
    }

    public RNOpencv3Module(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        fya.O000000o();
    }

    private void MakeAToast(String str) {
        Toast.makeText(this.reactContext, str, 1).show();
    }

    @ReactMethod
    public void drawLine(ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, ReadableMap readableMap4, int i) {
        fya.O000000o();
        int i2 = readableMap.getInt("matIndex");
        gdg.O000000o();
        Mat mat = (Mat) gdg.O000000o(i2);
        Imgproc.line(mat, new Point(readableMap2.getDouble("x"), readableMap2.getDouble("y")), new Point(readableMap3.getDouble("x"), readableMap3.getDouble("y")), Scalar.all(255.0d), i);
        gdg.O000000o();
        gdg.O000000o(i2, mat);
    }

    @ReactMethod
    public void cvtColor(ReadableMap readableMap, ReadableMap readableMap2, int i) {
        fya.O000000o();
        int i2 = readableMap.getInt("matIndex");
        int i3 = readableMap2.getInt("matIndex");
        gdg.O000000o();
        gdg.O000000o();
        Mat mat = (Mat) gdg.O000000o(i3);
        Imgproc.cvtColor((Mat) gdg.O000000o(i2), mat, i);
        gdg.O000000o();
        gdg.O000000o(i3, mat);
    }

    @ReactMethod
    public void imageToMat(String str, Promise promise) {
        fya.O000000o();
        gde.O000000o();
        gde.O000000o(str, promise);
    }

    @ReactMethod
    public void matToImage(ReadableMap readableMap, String str, Promise promise) {
        fya.O000000o();
        int i = readableMap.getInt("matIndex");
        gdg.O000000o();
        gde.O000000o();
        gde.O000000o((Mat) gdg.O000000o(i), str, promise);
    }

    @ReactMethod
    public void invokeMethods(ReadableMap readableMap) {
        fya.O000000o();
        gdd gdd = new gdd();
        sendCallbackData(gdd.O000000o(readableMap), gdd.O00000Oo, gdd.f17555O000000o);
    }

    public void sendCallbackData(WritableArray writableArray, String str, int i) {
        if (str != null && !str.equals("") && i >= 0 && i < 1000) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putArray("payload", writableArray);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableNativeMap);
        } else if (i == 1000) {
            gsy.O000000o(6, TAG, "SecurityException thrown attempting to invoke method.  Check your method name and parameters and make sure they are correct.");
        } else if (i == 1001) {
            gsy.O000000o(6, TAG, "IllegalAccessException thrown attempting to invoke method.  Check your method name and parameters and make sure they are correct.");
        } else if (i == 1002) {
            gsy.O000000o(6, TAG, "InvocationTargetException thrown attempting to invoke method.  Check your method name and parameters and make sure they are correct.");
        }
    }

    @ReactMethod
    public void invokeMethodWithCallback(String str, String str2, ReadableMap readableMap, String str3, String str4) {
        fya.O000000o();
        int O000000o2 = new gdd().O000000o(str, str2, readableMap, str3);
        gdg.O000000o();
        sendCallbackData(gdg.O000000o(O000000o2, 0, 0), str4, O000000o2);
    }

    @ReactMethod
    public void invokeMethod(String str, ReadableMap readableMap) {
        fya.O000000o();
        new gdd().O000000o(null, str, readableMap, null);
    }

    @ReactMethod
    public void invokeInOutMethod(String str, String str2, ReadableMap readableMap, String str3) {
        fya.O000000o();
        new gdd().O000000o(str, str2, readableMap, str3);
    }

    private void resolveMatPromise(int i, int i2, int i3, int i4, Promise promise) {
        fya.O000000o();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("rows", i2);
        writableNativeMap.putInt("cols", i3);
        if (i4 != -1) {
            writableNativeMap.putInt("CvType", i4);
        }
        writableNativeMap.putInt("matIndex", i);
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void MatWithScalar(int i, int i2, int i3, ReadableMap readableMap, Promise promise) {
        fya.O000000o();
        gdg.O000000o();
        resolveMatPromise(gdg.O000000o(i2, i, i3, readableMap), i, i2, i3, promise);
    }

    @ReactMethod
    public void MatWithParams(int i, int i2, int i3, Promise promise) {
        fya.O000000o();
        gdg.O000000o();
        resolveMatPromise(gdg.O000000o(i2, i, i3, (ReadableMap) null), i, i2, i3, promise);
    }

    @ReactMethod
    public void Mat(Promise promise) {
        fya.O000000o();
        gdg.O000000o();
        resolveMatPromise(gdg.O00000Oo(), 0, 0, -1, promise);
    }

    @ReactMethod
    public void getMatData(ReadableMap readableMap, int i, int i2, Promise promise) {
        fya.O000000o();
        gdg.O000000o();
        promise.resolve(gdg.O000000o(readableMap.getInt("matIndex"), i, i2));
    }

    @ReactMethod
    public void setTo(ReadableMap readableMap, ReadableMap readableMap2) {
        fya.O000000o();
        gdg.O000000o();
        gdg.O000000o(readableMap.getInt("matIndex"), readableMap2);
    }

    @ReactMethod
    public void put(ReadableMap readableMap, int i, int i2, ReadableArray readableArray) {
        fya.O000000o();
        gdg.O000000o();
        gdg.O000000o(readableMap.getInt("matIndex"), i, i2, readableArray);
    }

    @ReactMethod
    public void transpose(ReadableMap readableMap) {
        fya.O000000o();
        gdg.O000000o();
        gdg.O00000Oo(readableMap.getInt("matIndex"));
    }

    @ReactMethod
    public void deleteMat(ReadableMap readableMap) {
        fya.O000000o();
        gdg.O000000o();
        gdg.O00000o0(readableMap.getInt("matIndex"));
    }

    @ReactMethod
    public void deleteMats() {
        fya.O000000o();
        gdg.O000000o();
        gdg.O00000o0();
    }

    @ReactMethod
    public void MatOfInt(int i, int i2, Promise promise) {
        fya.O000000o();
        gdg.O000000o();
        int O000000o2 = gdg.O000000o(i, i2);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("matIndex", O000000o2);
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void MatOfFloat(float f, float f2, Promise promise) {
        fya.O000000o();
        gdg.O000000o();
        int O000000o2 = gdg.O000000o(f, f2);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("matIndex", O000000o2);
        promise.resolve(writableNativeMap);
    }
}
