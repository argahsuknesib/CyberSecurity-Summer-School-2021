package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.ftn;
import _m_j.ftt;
import _m_j.fwz;
import _m_j.fyc;
import _m_j.fyf;
import _m_j.fyn;
import _m_j.fyo;
import _m_j.fyu;
import _m_j.gav;
import _m_j.gbn;
import _m_j.gbq;
import _m_j.gbu;
import _m_j.gbv;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.gdw;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.hor;
import _m_j.hsk;
import _m_j.hxh;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.UserInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;
import com.xiaomi.smarthome.framework.plugin.rn.viewmanager.darkmode.AppearanceModule;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MIOTServiceModule extends MIOTBaseJavaModule {
    public static final Parser<String> PARSERFORRAWRESULT = new PluginHostApi.ParserForRawResult<String>() {
        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
            return str;
        }
    };
    fyn mMiPanTokenManager;

    static /* synthetic */ void lambda$getServerName$0() throws Exception {
    }

    public String getName() {
        return "MIOTService";
    }

    public MIOTServiceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        PluginPackageInfo pluginRecord = getPluginRecord();
        HashMap hashMap = new HashMap();
        hashMap.put("currentAccountID", XmPluginHostApi.instance().getAccountId());
        if (pluginRecord != null) {
            hashMap.put("pluginID", Long.valueOf(pluginRecord.O000000o()));
        }
        hashMap.put("currentServerName", XmPluginHostApi.instance().getGlobalSettingServer(false));
        String colorSchemeForCurrentConfiguration = AppearanceModule.colorSchemeForCurrentConfiguration(getReactApplicationContext());
        gbu.O00000Oo("MIOTServiceModule", "getConstants, color: ".concat(String.valueOf(colorSchemeForCurrentConfiguration)));
        hashMap.put("currentDarkMode", colorSchemeForCurrentConfiguration);
        return hashMap;
    }

    @ReactMethod
    public void callSmartHomeAPI(String str, String str2, final Callback callback) {
        if ("/service/getappconfig".equals(str)) {
            gsj gsj = null;
            try {
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsj = o000000o.O00000Oo(hsk.O000000o(getReactApplicationContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(str2, "UTF-8")).O000000o();
            } catch (Throwable unused) {
            }
            gsg.O00000Oo(gsj, new gsl<String, gsf>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj, Response response) {
                    callback.invoke(Boolean.TRUE, (String) obj);
                }

                public final void processResponse(Response response) {
                    try {
                        callback.invoke(Boolean.TRUE, response.body().string());
                    } catch (Throwable unused) {
                        callback.invoke(Boolean.FALSE, Integer.valueOf(response.code()), response.message());
                    }
                }

                public final void processFailure(Call call, IOException iOException) {
                    callback.invoke(Boolean.FALSE, -1, Log.getStackTraceString(iOException));
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    if (gsf == null) {
                        callback.invoke(Boolean.FALSE, -1, "");
                        return;
                    }
                    callback.invoke(Boolean.FALSE, Integer.valueOf(gsf.f18205O000000o), gsf.O00000Oo);
                }
            });
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        XmPluginHostApi.instance().callSmartHomeApi((String) null, str, str2, new com.xiaomi.smarthome.device.api.Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                JSONObject responseJSONObject = MIOTServiceModule.this.getResponseJSONObject(str, currentTimeMillis);
                Callback callback = callback;
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.TRUE;
                if (responseJSONObject != null) {
                    str = responseJSONObject.toString();
                }
                objArr[1] = str;
                callback.invoke(objArr);
            }

            public final void onFailure(int i, String str) {
                String str2 = null;
                JSONObject responseJSONObject = MIOTServiceModule.this.getResponseJSONObject(null, currentTimeMillis);
                Callback callback = callback;
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.FALSE;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = str;
                if (responseJSONObject != null) {
                    str2 = responseJSONObject.toString();
                }
                objArr[3] = str2;
                callback.invoke(objArr);
            }
        }, PARSERFORRAWRESULT);
    }

    public JSONObject getResponseJSONObject(String str, long j) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() - j;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("start", j);
            jSONObject2.put("duration", currentTimeMillis);
            if (!TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject(str);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("__api_info", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            fyc.O00000o0("MIOTServiceModule", "get jsonObject err : ".concat(String.valueOf(e)));
            return null;
        }
    }

    public boolean supportMiCloud(String str) {
        return TextUtils.equals("jiqid.sxb.v1", str);
    }

    @ReactMethod
    public void callMiCloudAPI(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-4, "device cannot be null"));
        } else if (!supportMiCloud(device.model)) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "permission denied"));
        } else {
            if (this.mMiPanTokenManager == null) {
                this.mMiPanTokenManager = new fyn();
            }
            String str3 = this.mMiPanTokenManager.f17411O000000o;
            if (TextUtils.isEmpty(str3)) {
                final String str4 = str;
                final String str5 = str2;
                final ReadableMap readableMap3 = readableMap;
                final ReadableMap readableMap4 = readableMap2;
                final Callback callback2 = callback;
                fyo.O000000o(getCurrentActivity(), new ftt<XiaomiOAuthResults>(new ftt<String>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass8 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        MIOTServiceModule.this.requestMiPan(str4, str5, readableMap3, readableMap4, (String) obj, callback2);
                    }

                    public final void O000000o(int i) {
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(i, "oauth request failed"));
                    }

                    public final void O000000o(int i, Object obj) {
                        callback2.invoke(Boolean.FALSE, gbq.O000000o(i, "oauth request failed,".concat(String.valueOf(obj))));
                    }
                }) {
                    /* class _m_j.fyn.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ ftt f17412O000000o;

                    {
                        this.f17412O000000o = r2;
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) obj;
                        fyc.O00000o0("MiPanTokenManager", "MiPanTokenManager -> onSuccess:".concat(String.valueOf(xiaomiOAuthResults)));
                        int errorCode = xiaomiOAuthResults.getErrorCode();
                        if (errorCode != 0) {
                            ftt ftt = this.f17412O000000o;
                            if (ftt != null) {
                                ftt.O000000o(errorCode);
                                return;
                            }
                            return;
                        }
                        fyn.this.f17411O000000o = xiaomiOAuthResults.getAccessToken();
                        this.f17412O000000o.O000000o(fyn.this.f17411O000000o);
                    }

                    public final void O000000o(int i) {
                        fyc.O00000o0("MiPanTokenManager", "MiPanTokenManager -> onFailure:".concat(String.valueOf(i)));
                        ftt ftt = this.f17412O000000o;
                        if (ftt != null) {
                            ftt.O000000o(i);
                        }
                    }

                    public final void O000000o(int i, Object obj) {
                        fyc.O00000o0("MiPanTokenManager", "MiPanTokenManager -> onFailure:".concat(String.valueOf(obj)));
                        ftt ftt = this.f17412O000000o;
                        if (ftt != null) {
                            ftt.O000000o(i, obj);
                        }
                    }
                });
                return;
            }
            requestMiPan(str, str2, readableMap, readableMap2, str3, callback);
        }
    }

    public void requestMiPan(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2, String str3, final Callback callback) {
        try {
            String concat = "https://micpdc.openapi.xiaomi.net/mic/open/pdc/disk/2882303761517266491/".concat(String.valueOf(str));
            String lowerCase = str2.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != 111375) {
                if (hashCode == 3446944) {
                    if (lowerCase.equals("post")) {
                        c = 0;
                    }
                }
            } else if (lowerCase.equals("put")) {
                c = 1;
            }
            String str4 = c != 0 ? c != 1 ? "GET" : "PUT" : "POST";
            String O000000o2 = gbn.O000000o(str4, readableMap, str3, concat);
            Map<String, String> O00000Oo = gbv.O00000Oo(readableMap2);
            O00000Oo.put("access_token", str3);
            O00000Oo.put("serviceToken", str3);
            O00000Oo.put("token", str3);
            gsj.O000000o o000000o = new gsj.O000000o();
            o000000o.f18212O000000o = str4;
            gsg.O00000Oo(o000000o.O000000o(gbn.O000000o(readableMap, str3)).O000000o(O00000Oo).O00000Oo(O000000o2).O000000o(), new gsl<String, gsf>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass9 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
                 arg types: [int, java.lang.String]
                 candidates:
                  _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
                  _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
                  _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
                public final /* synthetic */ void onSuccess(Object obj, Response response) {
                    String str = (String) obj;
                    fyc.O00000o0("MIOTServiceModule", "MIOTServiceModule -> onSuccess:".concat(String.valueOf(str)));
                    callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) str));
                }

                public final void processResponse(Response response) {
                    try {
                        String string = response.body().string();
                        fyc.O00000o0("MIOTServiceModule", "MIOTServiceModule -> processResponse:".concat(String.valueOf(string)));
                        callback.invoke(Boolean.TRUE, string);
                    } catch (Throwable unused) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(response.code(), response.message()));
                    }
                }

                public final void processFailure(Call call, IOException iOException) {
                    fyc.O00000o0("MIOTServiceModule", "MIOTServiceModule -> processFailure:".concat(String.valueOf(iOException)));
                    callback.invoke(Boolean.FALSE, gbq.O000000o(-5, Log.getStackTraceString(iOException)));
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    fyc.O00000o0("MIOTServiceModule", "MIOTServiceModule -> onFailure:".concat(String.valueOf(exc)));
                    if (gsf == null) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(-1, ""));
                        return;
                    }
                    callback.invoke(Boolean.FALSE, gbq.O000000o(gsf.f18205O000000o, gsf.O00000Oo));
                }
            });
        } catch (Throwable th) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-6, Log.getStackTraceString(th)));
        }
    }

    @ReactMethod
    public void callSmartHomeCameraAPI(String str, String str2, boolean z, ReadableMap readableMap, final Callback callback) {
        if (callback != null) {
            if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.PARAMS_ERROR, "url is empty..."));
            } else if (getDevice() == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.DEVICE_ERROR, "current device is null..."));
            } else {
                try {
                    XmPluginHostApi.instance().callSmartHomeApi((String) null, str2, str, z ? "POST" : "GET", fyf.O000000o(readableMap), new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass10 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            Callback callback = callback;
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.TRUE;
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            objArr[1] = jSONObject.toString();
                            callback.invoke(objArr);
                        }

                        public final void onFailure(int i, String str) {
                            callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                        }
                    }, Parser.DEFAULT_PARSER);
                } catch (Exception e) {
                    String str3 = "callSmartHomeCameraAPI params map to Json string error,api:" + str + ",errorStr:" + e.toString();
                    gbu.O00000Oo(str3);
                    callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.PARAMS_ERROR, str3));
                }
            }
        }
    }

    @ReactMethod
    public void callSmartHomeCameraAPIWithStringParam(String str, String str2, boolean z, String str3, final Callback callback) {
        if (callback != null) {
            if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.PARAMS_ERROR, "url is empty..."));
            } else if (getDevice() == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.DEVICE_ERROR, "current device is null..."));
            } else {
                XmPluginHostApi.instance().callSmartHomeApi((String) null, str2, str, z ? "POST" : "GET", str3, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass11 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Callback callback = callback;
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.TRUE;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        objArr[1] = jSONObject.toString();
                        callback.invoke(objArr);
                    }

                    public final void onFailure(int i, String str) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
                    }
                }, Parser.DEFAULT_PARSER);
            }
        }
    }

    @ReactMethod
    public void addLog(String str, String str2) {
        XmPluginHostApi.instance().logForModel(str, str2);
    }

    @SuppressLint({"CheckResult"})
    @ReactMethod
    public void getServerName(final Callback callback) {
        final WritableMap createMap = Arguments.createMap();
        ServerBean O000000o2 = ftn.O000000o(getReactApplicationContext());
        if (O000000o2 != null) {
            createMap.putString("serverCode", O000000o2.f7546O000000o);
            createMap.putString("countryCode", O000000o2.O00000Oo);
        }
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(O000000o2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass12 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                createMap.putString("countryName", (String) obj);
                callback.invoke(createMap);
            }
        }, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE, $$Lambda$MIOTServiceModule$OwmJxmVjGqGOFoc15zLY1nlJ9gU.INSTANCE);
    }

    @ReactMethod
    public void getServiceTokenWithSid(String str, final Callback callback) {
        XmPluginHostApi.instance().getServiceToken(str, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass13 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("cUserId", jSONObject.optString("cUserId"));
                createMap.putString("serviceToken", jSONObject.optString("serviceToken"));
                createMap.putString("ph", jSONObject.optString("ph"));
                createMap.putString("slh", jSONObject.optString("slh"));
                callback.invoke(Boolean.TRUE, createMap);
            }

            public final void onFailure(int i, String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("code", i);
                createMap.putString("localDescription", str);
                createMap.putString("domain", "");
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putMap("error", createMap);
                callback.invoke(Boolean.FALSE, createMap2);
            }
        });
    }

    @ReactMethod
    public void editSceneRecord(ReadableMap readableMap, Callback callback) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        if (callback2 != null) {
            if (readableMap2 == null) {
                callback2.invoke(Boolean.FALSE, "params is null...");
                return;
            }
            String O00000Oo = fyf.O00000Oo(readableMap2, "model", "");
            int O000000o2 = fyf.O000000o(readableMap2, "st_id", 0);
            String O00000Oo2 = fyf.O00000Oo(readableMap2, "us_id", "");
            String O00000Oo3 = fyf.O00000Oo(readableMap2, "did", "");
            String O00000Oo4 = fyf.O00000Oo(readableMap2, "identify", "");
            String O00000Oo5 = fyf.O00000Oo(readableMap2, "name", "");
            ReadableMap O00000o0 = fyf.O00000o0(readableMap2, "setting");
            ReadableArray O00000Oo6 = fyf.O00000Oo(readableMap2, "authed");
            try {
                JSONObject jSONObject3 = new JSONObject(O00000o0.toString());
                try {
                    jSONObject2 = jSONObject3.has("NativeMap") ? jSONObject3.getJSONObject("NativeMap") : jSONObject3;
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject3;
                    gbu.O00000Oo(e.toString());
                    jSONObject = jSONObject2;
                    jSONArray = null;
                    XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            Callback callback = callback2;
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.TRUE;
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            objArr[1] = jSONObject.toString();
                            callback.invoke(objArr);
                        }

                        public final void onFailure(int i, String str) {
                            Callback callback = callback2;
                            callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                        }
                    });
                } catch (Exception e2) {
                    e = e2;
                    jSONObject2 = jSONObject3;
                    gbu.O00000Oo(e.toString());
                    jSONObject = jSONObject2;
                    jSONArray = null;
                    XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            Callback callback = callback2;
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.TRUE;
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            objArr[1] = jSONObject.toString();
                            callback.invoke(objArr);
                        }

                        public final void onFailure(int i, String str) {
                            Callback callback = callback2;
                            callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                        }
                    });
                }
                try {
                    jSONObject = jSONObject2;
                    jSONArray = new JSONArray(O00000Oo6.toString());
                } catch (JSONException e3) {
                    e = e3;
                    gbu.O00000Oo(e.toString());
                    jSONObject = jSONObject2;
                    jSONArray = null;
                    XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            Callback callback = callback2;
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.TRUE;
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            objArr[1] = jSONObject.toString();
                            callback.invoke(objArr);
                        }

                        public final void onFailure(int i, String str) {
                            Callback callback = callback2;
                            callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                        }
                    });
                } catch (Exception e4) {
                    e = e4;
                    gbu.O00000Oo(e.toString());
                    jSONObject = jSONObject2;
                    jSONArray = null;
                    XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            Callback callback = callback2;
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.TRUE;
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            objArr[1] = jSONObject.toString();
                            callback.invoke(objArr);
                        }

                        public final void onFailure(int i, String str) {
                            Callback callback = callback2;
                            callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                        }
                    });
                }
            } catch (JSONException e5) {
                e = e5;
                jSONObject2 = null;
                gbu.O00000Oo(e.toString());
                jSONObject = jSONObject2;
                jSONArray = null;
                XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Callback callback = callback2;
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.TRUE;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        objArr[1] = jSONObject.toString();
                        callback.invoke(objArr);
                    }

                    public final void onFailure(int i, String str) {
                        Callback callback = callback2;
                        callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                    }
                });
            } catch (Exception e6) {
                e = e6;
                jSONObject2 = null;
                gbu.O00000Oo(e.toString());
                jSONObject = jSONObject2;
                jSONArray = null;
                XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Callback callback = callback2;
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.TRUE;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        objArr[1] = jSONObject.toString();
                        callback.invoke(objArr);
                    }

                    public final void onFailure(int i, String str) {
                        Callback callback = callback2;
                        callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                    }
                });
            }
            XmPluginHostApi.instance().editSceneV2(O00000Oo, O000000o2, O00000Oo2, O00000Oo3, O00000Oo4, O00000Oo5, jSONObject, jSONArray, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Callback callback = callback2;
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.TRUE;
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    objArr[1] = jSONObject.toString();
                    callback.invoke(objArr);
                }

                public final void onFailure(int i, String str) {
                    Callback callback = callback2;
                    callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                }
            });
        }
    }

    @ReactMethod
    public void deleteSceneRecords(ReadableArray readableArray, final Callback callback) {
        if (callback != null) {
            if (readableArray == null) {
                callback.invoke(Boolean.FALSE, "params is null...");
            } else if (getDevice() == null) {
                callback.invoke(Boolean.FALSE, "current device is null...");
            } else {
                ArrayList arrayList = new ArrayList();
                if (readableArray != null) {
                    ArrayList<Object> arrayList2 = readableArray.toArrayList();
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(arrayList2.get(i).toString());
                    }
                }
                XmPluginHostApi.instance().delScenes(getDevice().model, arrayList, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass3 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Callback callback = callback;
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.TRUE;
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        objArr[1] = jSONObject.toString();
                        callback.invoke(objArr);
                    }

                    public final void onFailure(int i, String str) {
                        Callback callback = callback;
                        callback.invoke(Boolean.FALSE, "code: " + i + "   errorInfo: " + str);
                    }
                });
            }
        }
    }

    @ReactMethod
    public void loadAccountInfo(String str, final Callback callback) {
        XmPluginHostApi.instance().getUserInfo(str, new com.xiaomi.smarthome.device.api.Callback<UserInfo>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                UserInfo userInfo = (UserInfo) obj;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("id", userInfo.userId);
                createMap.putString("nickName", userInfo.nickName);
                createMap.putString("avatarURL", userInfo.url);
                createMap.putString("birth", userInfo.birth);
                createMap.putString("email", userInfo.email);
                createMap.putString("phone", userInfo.phone);
                createMap.putString("sex", userInfo.sex);
                createMap.putString("shareTime", String.valueOf(userInfo.shareTime));
                callback.invoke(Boolean.TRUE, createMap);
            }

            public final void onFailure(int i, String str) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(i, str));
            }
        });
    }

    @ReactMethod
    public void callSpecificAPI(String str, String str2, ReadableMap readableMap, final Callback callback) {
        Request request;
        if (callback != null) {
            if (TextUtils.isEmpty(str)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.PARAMS_ERROR, "url is empty..."));
            } else if (getDevice() == null) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.DEVICE_ERROR, "current device is null..."));
            } else if (!checkSpecificAPIAuthority(getDevice().model)) {
                callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.AUTHORITY_ERROR, "current device has no authority..."));
            } else {
                if ("get".equalsIgnoreCase(str2)) {
                    request = new Request.Builder().url(str).get().build();
                } else if ("post".equalsIgnoreCase(str2)) {
                    FormBody.Builder builder = new FormBody.Builder();
                    if (readableMap != null) {
                        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            builder.add(nextKey, fyf.O00000Oo(readableMap, nextKey, ""));
                        }
                    }
                    request = new Request.Builder().url(str).post(builder.build()).build();
                } else {
                    callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.REQUEST_ERROR, "can not support this method, method is ".concat(String.valueOf(str2))));
                    return;
                }
                fyu.O000000o().O000000o(gbv.O00000o0(readableMap, "allow_private_certificates")).newCall(request).enqueue(new okhttp3.Callback() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTServiceModule.AnonymousClass5 */

                    public final void onFailure(Call call, IOException iOException) {
                        callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, iOException.toString()));
                    }

                    public final void onResponse(Call call, Response response) throws IOException {
                        if (!response.isSuccessful()) {
                            callback.invoke(Boolean.FALSE, gbq.O000000o(response.code(), response.message()));
                            if (response.body() != null) {
                                response.close();
                                return;
                            }
                            return;
                        }
                        try {
                            String string = response.body().string();
                            callback.invoke(Boolean.TRUE, string);
                        } catch (IOException e) {
                            callback.invoke(Boolean.FALSE, gbq.O000000o(RnApiErrorInfo.INVALID_ERROR, e.toString()));
                        }
                    }
                });
            }
        }
    }

    @ReactMethod
    public void reportEvent(String str, ReadableMap readableMap) {
        int i;
        String str2;
        String str3;
        String str4;
        long j;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject;
        ReadableMap readableMap2 = readableMap;
        DeviceStat device = getDevice();
        PluginPackageInfo pluginRecord = getPluginRecord();
        String str8 = "";
        if (device != null) {
            str4 = device.did;
            String str9 = device.model;
            String str10 = device.name;
            i = device.pid;
            str3 = str9;
            str2 = str10;
        } else {
            str4 = str8;
            str3 = str4;
            str2 = str3;
            i = 0;
        }
        long j2 = 0;
        if (pluginRecord != null) {
            j2 = pluginRecord.O00000Oo();
            j = pluginRecord.O000000o();
            str5 = String.valueOf(pluginRecord.O00000oO());
        } else {
            str5 = str8;
            j = 0;
        }
        boolean z = (readableMap2 == null || !readableMap2.hasKey("enableOldTrack")) ? false : readableMap2.getBoolean("enableOldTrack");
        if (readableMap2 != null && readableMap2.hasKey("keyName")) {
            str8 = readableMap2.getString("keyName");
        }
        if (!z || TextUtils.isEmpty(str8)) {
            str6 = str;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            Iterator<Map.Entry<String, Object>> entryIterator = readableMap.getEntryIterator();
            while (entryIterator.hasNext()) {
                Map.Entry next = entryIterator.next();
                String str11 = (String) next.getKey();
                if (!TextUtils.equals(str11, "enableOldTrack") && !TextUtils.equals(str11, "keyName")) {
                    try {
                        jSONObject2.put(str11, next.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str3) || (!str3.equals("chuangmi.camera.ipc009") && !str3.equals("chuangmi.camera.ipc019") && !str3.equals("chuangmi.camera.ipc021") && !str3.equals("chuangmi.camera.021a04"))) {
                str7 = "plugin." + str3 + "." + str4;
            } else {
                str7 = "plugin.853.0";
            }
            String str12 = str7;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", str4);
                    jSONObject.put("version", 0);
                    jSONObject.put("model", str3);
                } catch (JSONException e2) {
                    e = e2;
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObject = null;
                e.printStackTrace();
                hxh.O000000o(str12, str, str8, jSONObject2.toString(), jSONObject);
                str6 = str8;
                gav.O000000o(str6, str4, j2, j, str3, str2, str5, i, readableMap);
            }
            hxh.O000000o(str12, str, str8, jSONObject2.toString(), jSONObject);
            str6 = str8;
        }
        gav.O000000o(str6, str4, j2, j, str3, str2, str5, i, readableMap);
    }

    @ReactMethod
    public void addStat(String str, String str2, ReadableMap readableMap) {
        DeviceStat device = getDevice();
        PluginPackageInfo pluginPackageInfo = fwz.O000000o().O00000Oo().O0000OoO;
        if (device == null || pluginPackageInfo == null) {
            fyc.O00000o0("MIOTServiceModule", "reportData error: deviceStat == null || packageInfo == null ");
            return;
        }
        XmPluginPackage xmPluginPackage = new XmPluginPackage(pluginPackageInfo.O00000oo(), pluginPackageInfo.O00000o(), null, null, null, device.model, null);
        xmPluginPackage.setPluginId(pluginPackageInfo.O000000o());
        xmPluginPackage.setPackageId(pluginPackageInfo.O00000Oo());
        XmPluginHostApi.instance().addRecord(xmPluginPackage, str, str2, gbv.O00000o(readableMap));
    }

    private boolean checkSpecificAPIAuthority(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("xiaomi.router")) {
            return true;
        }
        return false;
    }

    @ReactMethod
    public void revokePrivacyLicense(Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            fyc.O00000o0("MIOTServiceModule", "revokeLicense: device is null");
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid device"));
            return;
        }
        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(device.model);
        String str = null;
        if (O0000Oo != null) {
            str = MIOTPackageModule.getPluginDir(CommonApplication.getAppContext(), O0000Oo).getAbsolutePath() + File.separator + device.did;
        }
        if (getCurrentActivity() == null) {
            fyc.O00000o0("MIOTServiceModule", "revokeLicense: activity is null");
        } else {
            ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(device.did, new gdw(str, callback) {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTServiceModule$GIRaYAbDWgl3IEqQvczUfYX8QE */
                private final /* synthetic */ String f$0;
                private final /* synthetic */ Callback f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onResult(boolean z, Object obj) {
                    MIOTServiceModule.lambda$revokePrivacyLicense$1(this.f$0, this.f$1, z, (String) obj);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap
     arg types: [int, java.lang.String]
     candidates:
      _m_j.gbq.O000000o(int, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo, java.lang.String):com.facebook.react.bridge.WritableMap
      _m_j.gbq.O000000o(int, java.lang.Object):com.facebook.react.bridge.WritableMap */
    static /* synthetic */ void lambda$revokePrivacyLicense$1(String str, Callback callback, boolean z, String str2) {
        if (z) {
            fwz.O000000o().O000000o(str);
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, (Object) "true"));
            return;
        }
        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, str2));
    }

    @ReactMethod
    public void deleteDevice(Callback callback) {
        DeviceStat device = getDevice();
        if (device == null) {
            callback.invoke(Boolean.FALSE, gbq.O000000o(-1, "invalid device"));
            return;
        }
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(device.did, device.pid, new gdw() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.$$Lambda$MIOTServiceModule$NvyZL2EXSlcTWwVyeip5019SZQs */

            public final void onResult(boolean z, Object obj) {
                MIOTServiceModule.lambda$deleteDevice$2(Callback.this, z, (String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$deleteDevice$2(Callback callback, boolean z, String str) {
        if (z) {
            callback.invoke(Boolean.TRUE, gbq.O000000o(0, Boolean.TRUE));
            return;
        }
        callback.invoke(Boolean.FALSE, gbq.O000000o(-2, str));
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        fyu O000000o2 = fyu.O000000o();
        synchronized (O000000o2.O00000Oo) {
            O000000o2.O00000o0 = null;
            O000000o2.O00000o = null;
        }
    }

    @ReactMethod
    public void goEditRecommendScene(ReadableMap readableMap) {
        hor.O000000o().openRecommendSceneDetail(getCurrentActivity(), gbv.O00000o(readableMap));
    }
}
