package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.kookong;

import _m_j.fxy;
import _m_j.fyi;
import _m_j.fyj;
import _m_j.fyk;
import _m_j.fyl;
import _m_j.gbq;
import _m_j.gbu;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.hzy.tvmao.KKACZipManagerV2;
import com.hzy.tvmao.KKNonACManager;
import com.hzy.tvmao.KookongSDK;
import com.kookong.app.data.IrData;
import com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTBaseJavaModule;
import java.util.HashMap;

public class MIOTKookongModule extends MIOTBaseJavaModule {
    private static boolean sKksdkLoaded = false;
    private static boolean sLuajavaLoaded = false;
    private HashMap<String, fyi> mManagerMap = new HashMap<>();

    public String getName() {
        return "KooKong";
    }

    private static void ensureLibLoaded() {
        try {
            if (!sKksdkLoaded) {
                sKksdkLoaded = fxy.O00000Oo("kksdk");
            }
            if (!sLuajavaLoaded) {
                sLuajavaLoaded = fxy.O00000Oo("luajava");
            }
        } catch (Throwable th) {
            gbu.O00000o("MIOTKookongModule,load Kookong so error,msg+" + Log.getStackTraceString(th));
        }
    }

    public MIOTKookongModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void registerWithKey(String str, String str2, Callback callback) {
        Activity currentActivity = getCurrentActivity();
        try {
            ensureLibLoaded();
            if (KookongSDK.init(currentActivity, str, str2)) {
                callback.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
                return;
            }
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
        } catch (Throwable th) {
            gbu.O00000o("registerWithKey error, msg:" + Log.getStackTraceString(th));
            callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
        }
    }

    @ReactMethod
    public void createZipACManager(String str, String str2, ReadableMap readableMap, ReadableArray readableArray, Callback callback) {
        KKACZipManagerV2 kKACZipManagerV2;
        IrData O000000o2;
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        ensureLibLoaded();
        if (this.mManagerMap.get(str) == null) {
            try {
                kKACZipManagerV2 = new KKACZipManagerV2();
                O000000o2 = fyj.O000000o(readableMap);
                if (!TextUtils.isEmpty(str2)) {
                    O000000o2.rid = Integer.parseInt(str2);
                }
            } catch (NumberFormatException unused) {
                gbu.O00000o("createZipACManager: remoteId must be a int parameter");
            } catch (Throwable th) {
                gbu.O00000o("createZipACManager, create manager error:" + Log.getStackTraceString(th));
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "create manager fail"));
                return;
            }
            kKACZipManagerV2.initIRData(O000000o2);
            kKACZipManagerV2.setACStateV2FromString("");
            kKACZipManagerV2.onResume();
            this.mManagerMap.put(str, new fyk(kKACZipManagerV2));
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
    }

    @ReactMethod
    public void createNonACManager(String str, ReadableMap readableMap, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        ensureLibLoaded();
        if (this.mManagerMap.get(str) == null) {
            try {
                this.mManagerMap.put(str, new fyl(new KKNonACManager(fyj.O000000o(readableMap))));
            } catch (Throwable th) {
                gbu.O00000o("createNonACManager, create manager error:" + Log.getStackTraceString(th));
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "create manager fail"));
                return;
            }
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
    }

    @ReactMethod
    public void removeACManager(String str, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        fyi fyi = this.mManagerMap.get(str);
        this.mManagerMap.remove(str);
        if (fyi != null) {
            Object O0000o = fyi.O0000o();
            if (O0000o instanceof KKACZipManagerV2) {
                ((KKACZipManagerV2) O0000o).onPause();
            }
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
    }

    @ReactMethod
    public void canControlWithType(String str, int i, Callback callback) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        ensureLibLoaded();
        fyi fyi = this.mManagerMap.get(str);
        if (fyi == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-102, "not found manager, make sure you have already called createACManager yet"));
            return;
        }
        if (i == 1) {
            z = fyi.O000000o();
        } else if (i == 2) {
            z = fyi.O00000Oo();
        } else if (i != 3) {
            try {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            } catch (Throwable th) {
                gbu.O00000o("canControlWithType error, type:" + i + ",msg:" + Log.getStackTraceString(th));
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            }
        } else {
            z = fyi.O00000o0();
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("result", z);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap, "success"));
    }

    @ReactMethod
    public void getCurrentValueWithType(String str, int i, Callback callback) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        ensureLibLoaded();
        fyi fyi = this.mManagerMap.get(str);
        if (fyi == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-102, "not found manager, make sure you have already called createACManager yet"));
            return;
        }
        if (i == 0) {
            i2 = fyi.O00000o();
        } else if (i == 1) {
            i2 = fyi.O00000oO();
        } else if (i == 2) {
            i2 = fyi.O0000O0o();
        } else if (i == 3) {
            i2 = fyi.O0000OOo();
        } else if (i == 4) {
            i2 = fyi.O0000Oo0();
        } else if (i != 103) {
            try {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            } catch (Throwable th) {
                gbu.O00000o("getCurrentValueWithType error, type:" + i + ",msg:" + Log.getStackTraceString(th));
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            }
        } else {
            i2 = fyi.O00000oo();
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("result", i2);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap, "success"));
    }

    @ReactMethod
    public void getAllSupportValueWithType(String str, int i, Callback callback) {
        WritableArray writableArray;
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        ensureLibLoaded();
        fyi fyi = this.mManagerMap.get(str);
        if (fyi == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-102, "not found manager, make sure you have already called createACManager yet"));
            return;
        }
        if (i == 0) {
            writableArray = fyi.O0000Oo();
        } else if (i == 1) {
            writableArray = fyi.O0000OoO();
        } else if (i == 2) {
            writableArray = fyi.O0000Ooo();
        } else if (i == 5) {
            writableArray = fyi.O0000o00();
        } else if (i == 6) {
            writableArray = fyi.O0000o0();
        } else if (i == 101) {
            writableArray = fyi.O0000o0O();
        } else if (i != 102) {
            try {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            } catch (Throwable th) {
                gbu.O00000o("getAllSupportValueWithType error, type:" + i + ",msg:" + Log.getStackTraceString(th));
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            }
        } else {
            writableArray = fyi.O0000o0o();
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("result", writableArray);
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, createMap, "success"));
    }

    @ReactMethod
    public void changeStateValueForType(String str, int i, int i2, Callback callback) {
        if (TextUtils.isEmpty(str)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "identifier cannot be null"));
            return;
        }
        ensureLibLoaded();
        fyi fyi = this.mManagerMap.get(str);
        if (fyi == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-102, "not found manager, make sure you have already called createACManager yet"));
            return;
        }
        if (i2 == 0) {
            fyi.O000000o(i);
        } else if (i2 == 1) {
            fyi.O00000Oo(i);
        } else if (i2 == 2) {
            fyi.O00000o0(i);
        } else if (i2 == 3) {
            fyi.O00000oO(i);
        } else if (i2 == 4) {
            fyi.O00000oo(i);
        } else if (i2 != 103) {
            try {
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            } catch (Throwable th) {
                gbu.O00000o("changeStateValueForType error, type:" + i2 + ",msg:" + Log.getStackTraceString(th));
                callback.invoke(Boolean.FALSE, gbq.O000000o(-2, "input params error"));
                return;
            }
        } else {
            fyi.O00000o(i);
        }
        callback.invoke(Boolean.TRUE, gbq.O000000o(0, "success"));
    }
}
