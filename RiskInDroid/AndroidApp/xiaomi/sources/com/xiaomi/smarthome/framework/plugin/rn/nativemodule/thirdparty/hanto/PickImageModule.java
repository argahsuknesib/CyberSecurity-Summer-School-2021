package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.ayz;
import _m_j.gsy;
import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.hannto.print.entity.PickPhotoEntity;
import com.hannto.print.pickimage.activity.PickPhotoActivity;
import java.util.ArrayList;

public class PickImageModule extends HTReactContextBaseJavaModule {
    ActivityEventListener activityEventListener = new ActivityEventListener() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.PickImageModule.AnonymousClass1 */

        public final void onNewIntent(Intent intent) {
        }

        public final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i != 1101) {
                return;
            }
            if (i2 == -1) {
                gsy.O000000o(3, "PickImageModule", "onActivityResult: RESULT_OK");
                if (PickImageModule.this.pickImageCallbackListener != null) {
                    PickImageModule.this.pickImageCallbackListener.O000000o(intent);
                } else {
                    gsy.O000000o(3, "PickImageModule", "onActivityResult: pickImageCallbackListener is null");
                }
            } else if (i2 == 1005) {
                gsy.O000000o(3, "PickImageModule", "onActivityResult: RESULT_ERROR_PICK_IMAGE");
                PickImageModule.this.pickImageCallbackListener.O00000Oo(intent);
            } else {
                gsy.O000000o(3, "PickImageModule", "onActivityResult: ".concat(String.valueOf(i2)));
            }
        }
    };
    public O000000o pickImageCallbackListener;

    interface O000000o {
        void O000000o(Intent intent);

        void O00000Oo(Intent intent);
    }

    public String getName() {
        return "HTRCTPhotoPickerModule";
    }

    public PickImageModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this.activityEventListener);
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        int i;
        ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        if (callback2 == null) {
            showMessage("回调函数不能为空");
        } else if (isNoNull(readableMap2, "sandBoxFolder")) {
            String string = readableMap2.getString("sandBoxFolder");
            int i2 = isNoNull(readableMap2, "w") ? readableMap2.getInt("w") : 0;
            int i3 = isNoNull(readableMap2, "h") ? readableMap2.getInt("h") : 0;
            boolean z = isNoNull(readableMap2, "isSingle") ? readableMap2.getBoolean("isSingle") : false;
            int i4 = 9;
            if (isNoNull(readableMap2, "maxNumber")) {
                i4 = readableMap2.getInt("maxNumber");
            }
            boolean z2 = isNoNull(readableMap2, "isSupportCamera") ? readableMap2.getBoolean("isSupportCamera") : false;
            boolean z3 = isNoNull(readableMap2, "pushAnimated") ? readableMap2.getBoolean("pushAnimated") : true;
            int i5 = isNoNull(readableMap2, "pickPhotoType") ? readableMap2.getInt("pickPhotoType") : 0;
            int i6 = isNoNull(readableMap2, "targetWidth") ? readableMap2.getInt("targetWidth") : 2400;
            int i7 = isNoNull(readableMap2, "targetHeight") ? readableMap2.getInt("targetHeight") : 3600;
            if (isNoNull(readableMap2, "maxSize")) {
                i = readableMap2.getInt("maxSize");
            } else {
                i = 10240;
            }
            if (z) {
                i4 = 1;
            }
            PickPhotoEntity pickPhotoEntity = new PickPhotoEntity(i5 == 1 ? 1 : i4, i2, i3, z2, z3, string, i5, i6, i7, i);
            Intent intent = new Intent(getCurrentActivity(), PickPhotoActivity.class);
            intent.putExtra("intent_pick_photo_config", pickPhotoEntity);
            getCurrentActivity().startActivityForResult(intent, 1101);
            if (!z3) {
                getCurrentActivity().overridePendingTransition(0, 0);
            }
            this.pickImageCallbackListener = new O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.PickImageModule.AnonymousClass2 */

                public final void O000000o(Intent intent) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("intent_pick_image_path");
                    gsy.O000000o(3, "PickImageModule", "onResult: path:" + stringArrayListExtra.toString());
                    WritableNativeArray writableNativeArray = new WritableNativeArray();
                    for (String O000000o2 : stringArrayListExtra) {
                        writableNativeArray.pushString(ayz.O000000o(O000000o2));
                    }
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putArray("paths", writableNativeArray);
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putInt(HTReactContextBaseJavaModule.RESULT_CODE, HTReactContextBaseJavaModule.SUCCESS_CODE);
                    writableNativeMap2.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                    callback2.invoke(writableNativeMap2);
                }

                public final void O00000Oo(Intent intent) {
                    String stringExtra = intent.getStringExtra("intent_pick_image_error");
                    gsy.O000000o(3, "PickImageModule", "onError: ".concat(String.valueOf(stringExtra)));
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putInt(HTReactContextBaseJavaModule.RESULT_CODE, -1);
                    writableNativeMap.putString(HTReactContextBaseJavaModule.RESULT_MESSAGE, stringExtra);
                    callback2.invoke(writableNativeMap);
                }
            };
        } else {
            showMessage("sandBoxFolder is not null");
        }
    }
}
