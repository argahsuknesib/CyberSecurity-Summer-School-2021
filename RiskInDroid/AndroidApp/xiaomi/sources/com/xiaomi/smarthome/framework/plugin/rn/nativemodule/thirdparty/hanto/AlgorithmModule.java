package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.O00o0000;
import _m_j.ayt;
import _m_j.ayu;
import _m_j.ayy;
import _m_j.gsy;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.hannto.opencv.SmartCropper;
import com.xiaomi.smarthome.R;

public class AlgorithmModule extends HTReactContextBaseJavaModule {
    public String getName() {
        return "HTRCTOpenCVModule";
    }

    public AlgorithmModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void crop(String str, ReadableNativeArray readableNativeArray, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        String O000000o2 = ayu.O000000o(SmartCropper.O000000o(ayu.O000000o(str), getPoints(readableNativeArray)));
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("dst", O000000o2);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    @ReactMethod
    public void autoIncrease(String str, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        gsy.O000000o(3, "AlgorithmModule", "native接收到数据");
        Bitmap O000000o2 = ayu.O000000o(str);
        SmartCropper.O00000o0(O000000o2);
        String O000000o3 = ayu.O000000o(O000000o2);
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("dst", O000000o3);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        successResultMap.putString("scan_lib_code", ayt.f12712O000000o);
        callback.invoke(successResultMap);
        gsy.O000000o(3, "AlgorithmModule", "native返回数据");
    }

    @ReactMethod
    public void icCameraIdentify(String str, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        Point[] O000000o2 = SmartCropper.O000000o(ayu.O000000o(str));
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeArray pointsMap = getPointsMap(O000000o2);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putArray("points", pointsMap);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    @ReactMethod
    public void icCameraCrop(String str, ReadableNativeArray readableNativeArray, boolean z, Callback callback) {
        int i;
        Resources resources;
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        Point[] points = getPoints(readableNativeArray);
        Activity currentActivity = getCurrentActivity();
        Bitmap O000000o2 = SmartCropper.O000000o(ayu.O000000o(str), points, O00o0000.O00000Oo, O00o0000.O00000o0);
        if (z) {
            resources = currentActivity.getResources();
            i = R.drawable.myfront;
        } else {
            resources = currentActivity.getResources();
            i = R.drawable.myback;
        }
        SmartCropper.O000000o(O000000o2, ayy.O000000o(BitmapFactory.decodeResource(resources, i), O000000o2.getWidth(), O000000o2.getHeight()));
        String O000000o3 = ayu.O000000o(O000000o2);
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("dst", O000000o3);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    @ReactMethod
    public void icCameraScan(String str, boolean z, Callback callback) {
        Resources resources;
        int i;
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        Bitmap O000000o2 = ayu.O000000o(str);
        double width = (double) O000000o2.getWidth();
        Double.isNaN(width);
        double d = width / 1080.0d;
        double height = (double) O000000o2.getHeight();
        Double.isNaN(height);
        double d2 = height / 1440.0d;
        int i2 = (int) (120.0d * d);
        int i3 = (int) (453.0d * d2);
        double height2 = (double) O000000o2.getHeight();
        Double.isNaN(height2);
        int i4 = (int) (height2 * 0.3d);
        int i5 = (int) (100.0d * d);
        Bitmap createBitmap = Bitmap.createBitmap(O000000o2, i2, i3, (int) (d * 840.0d), (int) (d2 * 534.0d));
        int width2 = O000000o2.getWidth() - (i5 * 2);
        double height3 = (double) O000000o2.getHeight();
        Double.isNaN(height3);
        Bitmap createBitmap2 = Bitmap.createBitmap(O000000o2, i5, i4, width2, (int) (height3 * 0.4d));
        int i6 = i2 - i5;
        int i7 = i3 - i4;
        Point[] pointArr = {new Point(i6, i7), new Point(createBitmap.getWidth() + i6, i7), new Point(createBitmap.getWidth() + i6, createBitmap.getHeight() + i7), new Point(i6, createBitmap.getHeight() + i7)};
        Point[] O000000o3 = SmartCropper.O000000o(createBitmap2);
        Bitmap O000000o4 = SmartCropper.O000000o(O000000o3) ? SmartCropper.O000000o(createBitmap2, O000000o3, O00o0000.O00000Oo, O00o0000.O00000o0) : SmartCropper.O000000o(createBitmap2, pointArr, O00o0000.O00000Oo, O00o0000.O00000o0);
        if (z) {
            resources = currentActivity.getResources();
            i = R.drawable.myfront;
        } else {
            resources = currentActivity.getResources();
            i = R.drawable.myback;
        }
        SmartCropper.O000000o(O000000o4, ayy.O000000o(BitmapFactory.decodeResource(resources, i), O000000o4.getWidth(), O000000o4.getHeight()));
        String O000000o5 = ayu.O000000o(O000000o4);
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("dst", O000000o5);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    @ReactMethod
    public void icFlatbedIdentify(String str, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        Point[] O00000Oo = SmartCropper.O00000Oo(ayu.O000000o(str));
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeArray pointsMap = getPointsMap(O00000Oo);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putArray("points", pointsMap);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    @ReactMethod
    public void icFlatbedCrop(String str, ReadableNativeArray readableNativeArray, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        String O000000o2 = ayu.O000000o(str, getPoints(readableNativeArray));
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("dst", O000000o2);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    @ReactMethod
    public void icFlatbedScan(String str, Callback callback) {
        if (callback == null) {
            showMessage("回调函数不能为空");
            return;
        }
        String O000000o2 = ayu.O000000o(str, SmartCropper.O00000Oo(ayu.O000000o(str)));
        WritableNativeMap successResultMap = getSuccessResultMap();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("dst", O000000o2);
        successResultMap.putMap(RESULT_DATA, writableNativeMap);
        callback.invoke(successResultMap);
    }

    private WritableNativeMap getSuccessResultMap() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt(RESULT_CODE, 0);
        return writableNativeMap;
    }

    private WritableNativeArray getPointsMap(Point[] pointArr) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < pointArr.length; i++) {
            Point point = pointArr[i];
            if (point == null) {
                point = new Point(0, 0);
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("y", point.y);
            writableNativeMap.putInt("x", point.x);
            writableNativeArray.pushMap(writableNativeMap);
            pointArr[i] = point;
        }
        return writableNativeArray;
    }

    private Point[] getPoints(ReadableNativeArray readableNativeArray) {
        if (readableNativeArray.size() != 4) {
            showMessage("需要传入四个点");
            return null;
        }
        Point[] pointArr = new Point[4];
        for (int i = 0; i < readableNativeArray.size(); i++) {
            ReadableNativeMap map = readableNativeArray.getMap(i);
            pointArr[i] = new Point(map.getInt("x"), map.getInt("y"));
        }
        return pointArr;
    }
}
