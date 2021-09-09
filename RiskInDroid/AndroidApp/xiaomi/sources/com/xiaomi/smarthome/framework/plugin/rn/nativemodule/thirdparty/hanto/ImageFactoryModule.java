package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto;

import _m_j.ayz;
import _m_j.aza;
import _m_j.azb;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;

public class ImageFactoryModule extends HTReactContextBaseJavaModule {
    public O000000o mListener;

    interface O000000o {
        void O000000o(Activity activity, int i, int i2, Intent intent);
    }

    public String getName() {
        return "HTRCTImageFactoryModule";
    }

    public ImageFactoryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new ActivityEventListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.ImageFactoryModule.AnonymousClass1 */

            public final void onNewIntent(Intent intent) {
            }

            public final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (ImageFactoryModule.this.mListener != null) {
                    ImageFactoryModule.this.mListener.O000000o(activity, i, i2, intent);
                }
            }
        });
    }

    @ReactMethod
    public void addWaterMarkWithImage(ReadableMap readableMap, Callback callback) {
        ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        int i = 0;
        if (callback2 == null) {
            Toast.makeText(getCurrentActivity(), "回调函数不能为空", 0).show();
            return;
        }
        int i2 = readableMap2.hasKey("width") ? readableMap2.getInt("width") : 0;
        if (readableMap2.hasKey("height")) {
            i = readableMap2.getInt("height");
        }
        String str = null;
        String string = readableMap2.hasKey("img") ? readableMap2.getString("img") : null;
        String string2 = readableMap2.hasKey("text") ? readableMap2.getString("text") : null;
        double d = readableMap2.hasKey("x") ? readableMap2.getDouble("x") : 0.0d;
        double d2 = readableMap2.hasKey("y") ? readableMap2.getDouble("y") : 0.0d;
        double d3 = readableMap2.hasKey("fontSize") ? readableMap2.getDouble("fontSize") : 0.0d;
        if (readableMap2.hasKey("textColor")) {
            str = readableMap2.getString("textColor");
        }
        if (readableMap2.hasKey("fontName")) {
            readableMap2.getString("fontName");
        }
        double d4 = readableMap2.hasKey("alpha") ? readableMap2.getDouble("alpha") : 0.0d;
        final WritableNativeMap writableNativeMap = new WritableNativeMap();
        String str2 = str;
        AnonymousClass2 r15 = new aza() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.ImageFactoryModule.AnonymousClass2 */

            public final void O000000o(String str) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("img", str);
                writableNativeMap.putMap(HTReactContextBaseJavaModule.RESULT_DATA, writableNativeMap);
                writableNativeMap.putInt(HTReactContextBaseJavaModule.RESULT_CODE, HTReactContextBaseJavaModule.SUCCESS_CODE);
                callback2.invoke(writableNativeMap);
            }

            public final void O00000Oo(String str) {
                writableNativeMap.putInt(HTReactContextBaseJavaModule.RESULT_CODE, -1);
                writableNativeMap.putString(HTReactContextBaseJavaModule.RESULT_MESSAGE, str);
                callback2.invoke(writableNativeMap);
            }
        };
        azb.O000000o o000000o = new azb.O000000o();
        if (d4 > 0.0d) {
            o000000o.O0000OoO = d4;
        }
        o000000o.f12720O000000o = getCurrentActivity();
        float f = (float) d3;
        if (f > 0.0f) {
            o000000o.O0000Oo = f;
        }
        o000000o.O00000o0 = string;
        o000000o.O00000Oo = string2;
        if (i2 > 0) {
            o000000o.O00000oO = i2;
        }
        if (i > 0) {
            o000000o.O00000oo = i;
        }
        if (d > 0.0d) {
            o000000o.O0000o0O = d;
        }
        if (d2 > 0.0d) {
            o000000o.O0000o0o = d2;
        }
        if (!TextUtils.isEmpty(str2)) {
            o000000o.O0000Ooo = Color.parseColor(str2);
        }
        o000000o.O0000o = r15;
        azb azb = new azb(o000000o);
        try {
            azb.O000000o();
        } catch (Exception e) {
            Exception exc = e;
            exc.printStackTrace();
            aza aza = azb.O0000oo0;
            if (aza != null) {
                aza.O00000Oo(exc.getMessage());
            }
        }
    }

    @ReactMethod
    public void getImageBase64(final Callback callback) {
        this.mListener = new O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.hanto.ImageFactoryModule.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            static final /* synthetic */ boolean f8424O000000o = (!ImageFactoryModule.class.desiredAssertionStatus());

            public final void O000000o(Activity activity, int i, int i2, Intent intent) {
                if (i == 200 && i2 == -1 && intent != null) {
                    Uri data = intent.getData();
                    String[] strArr = {"_data"};
                    if (f8424O000000o || data != null) {
                        Cursor query = activity.getContentResolver().query(data, strArr, null, null, null);
                        if (query != null) {
                            query.moveToFirst();
                            String O00000Oo2 = ayz.O00000Oo(ImageFactoryModule.this.getCurrentActivity(), query.getString(query.getColumnIndex(strArr[0])));
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            writableNativeMap.putString(HTReactContextBaseJavaModule.RESULT_DATA, O00000Oo2);
                            writableNativeMap.putInt(HTReactContextBaseJavaModule.RESULT_CODE, HTReactContextBaseJavaModule.SUCCESS_CODE);
                            callback.invoke(writableNativeMap);
                            query.close();
                            return;
                        }
                        return;
                    }
                    throw new AssertionError();
                }
            }
        };
        if (getCurrentActivity() != null) {
            getCurrentActivity().startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 200);
        }
    }
}
