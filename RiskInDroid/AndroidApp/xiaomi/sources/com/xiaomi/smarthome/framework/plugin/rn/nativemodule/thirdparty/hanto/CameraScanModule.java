package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.ayt;
import _m_j.ayz;
import _m_j.gsy;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Parcelable;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.exoplayer2.C;
import com.hannto.print.scan.activity.CameraScanActivity;

public class CameraScanModule extends HTReactContextBaseJavaModule {
    ActivityEventListener activityEventListener = new ActivityEventListener() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.CameraScanModule.AnonymousClass1 */

        public final void onNewIntent(Intent intent) {
        }

        public final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i2 == -1 && i == 10000 && CameraScanModule.this.takePictureCallbackListener != null) {
                CameraScanModule.this.takePictureCallbackListener.O000000o(intent);
            }
        }
    };
    public O000000o takePictureCallbackListener;

    interface O000000o {
        void O000000o(Intent intent);
    }

    public String getName() {
        return "HTRCTScanModule";
    }

    public CameraScanModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this.activityEventListener);
    }

    @ReactMethod
    public void scanStart(ReadableMap readableMap, final Callback callback) {
        if (callback == null) {
            showMessage("React Native Callback is null");
        } else if (isNoNull(readableMap, "sandBoxFolder")) {
            String string = readableMap.getString("sandBoxFolder");
            boolean z = true;
            if (readableMap.hasKey("pushAnimated") && !readableMap.isNull("pushAnimated")) {
                z = readableMap.getBoolean("pushAnimated");
            }
            boolean z2 = (!readableMap.hasKey("isGaveUp") || readableMap.isNull("isGaveUp")) ? false : readableMap.getBoolean("isGaveUp");
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                Intent intent = new Intent(currentActivity, CameraScanActivity.class);
                intent.putExtra("isPushAnimated", z);
                intent.putExtra("isGaveUp", z2);
                intent.putExtra("sandBoxFolder", string);
                currentActivity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
                if (!z) {
                    getCurrentActivity().overridePendingTransition(0, 0);
                }
                this.takePictureCallbackListener = new O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.CameraScanModule.AnonymousClass2 */

                    public final void O000000o(Intent intent) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                        int intExtra = intent.getIntExtra("result_code", -1);
                        if (-1 == intExtra) {
                            String stringExtra = intent.getStringExtra("error_message");
                            writableNativeMap.putString(HTReactContextBaseJavaModule.RESULT_MESSAGE, stringExtra);
                            gsy.O000000o(6, "HTRCTScanModule", stringExtra);
                        } else if (intExtra == 0) {
                            WritableNativeArray writableNativeArray = new WritableNativeArray();
                            String stringExtra2 = intent.getStringExtra("photo_path");
                            Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("scan_points");
                            Point[] pointArr = new Point[4];
                            for (int i = 0; i < parcelableArrayExtra.length; i++) {
                                Point point = (Point) parcelableArrayExtra[i];
                                if (point == null) {
                                    point = new Point(0, 0);
                                }
                                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                                writableNativeMap3.putInt("x", point.x);
                                writableNativeMap3.putInt("y", point.y);
                                writableNativeArray.pushMap(writableNativeMap3);
                                pointArr[i] = point;
                            }
                            gsy.O000000o(5, "HTRCTScanModule", stringExtra2 + " < -- > points ==> {" + pointArr[0] + " -- " + pointArr[1] + " -- " + pointArr[2] + " -- " + pointArr[3] + "}");
                            writableNativeMap2.putArray("points", writableNativeArray);
                            writableNativeMap2.putString("filePath", ayz.O000000o(stringExtra2));
                            writableNativeMap.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap2);
                        }
                        writableNativeMap.putInt(HTReactContextBaseJavaModule.RESULT_CODE, intExtra);
                        writableNativeMap.putString("scan_lib_code", ayt.f12712O000000o);
                        callback.invoke(writableNativeMap);
                    }
                };
            }
        } else {
            showMessage("sandBoxFolder is not null");
        }
    }
}
