package com.xiaomi.smarthome.frame.plugin.host;

import _m_j.exz;
import _m_j.fsl;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsr;
import _m_j.fss;
import _m_j.gsy;
import _m_j.hxh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.RunningProcess;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService;
import com.xiaomi.smarthome.plugin.service.HostService;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PluginHostApi extends BasePluginHostApi {
    protected String did;
    private Context mAppContext;
    private int nonce = -1;

    public interface ParserForRawResult<T> extends Parser<T> {
    }

    public abstract void createDeviceGroup(Context context, String str);

    public abstract void ensureService(Callback callback);

    public final int getApiLevel() {
        return 111;
    }

    public abstract DeviceTagInterface getDeviceTagManager();

    public abstract String getPluginProcess(int i, String str);

    public PluginHostApi(Context context) {
        this.mAppContext = context.getApplicationContext();
        XmPluginHostApi.sXmPluginHostApi = this;
    }

    public final int generateNonce() {
        this.nonce++;
        if (this.nonce <= 0) {
            this.nonce = new Random().nextInt(C.MSG_CUSTOM_BASE) + 1;
        }
        return this.nonce;
    }

    public final String getChannel() {
        return fsr.O0000Oo;
    }

    @Deprecated
    public final void loadLibrary(String str, String str2, ClassLoader classLoader) {
        loadLibrary(PluginRuntimeManager.getInstance().getXmPluginPackage(CoreApi.O000000o().O0000Oo(str)), str2);
    }

    public final void loadLibrary(XmPluginPackage xmPluginPackage, String str) {
        throw new UnsupportedOperationException("this method is unsupported, please use System.loadLibrary");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public final void addRecord(String str, String str2, Object obj, JSONObject jSONObject) {
        if (fsl.O000000o(this.mAppContext, this.did)) {
            String concat = "plugin.".concat(String.valueOf(str));
            String str3 = "";
            String obj2 = obj != null ? obj.toString() : str3;
            if (jSONObject != null) {
                str3 = jSONObject.toString();
            }
            String str4 = str3;
            int indexOf = str2.indexOf(":");
            if (indexOf > 0) {
                String substring = str2.substring(0, indexOf);
                str2 = str2.substring(indexOf + 1);
                hxh.O000000o(concat, substring, str2, obj2, jSONObject);
            }
            CoreApi.O000000o().O000000o(StatType.PLUGIN, concat, str2, obj2, str4, false);
        }
    }

    public final void addRecordV2(XmPluginPackage xmPluginPackage, String str, String str2, Object obj, JSONObject jSONObject) {
        if (fsl.O000000o(this.mAppContext, this.did)) {
            addRecord(xmPluginPackage, str2, obj, jSONObject);
            HashMap hashMap = new HashMap();
            if (obj != null) {
                hashMap.put("value", obj.toString());
            }
            if (jSONObject != null) {
                hashMap.put("extra", jSONObject.toString());
            }
            if (str != null) {
                hashMap.put("model", str);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public final void addRecord(XmPluginPackage xmPluginPackage, String str, Object obj, JSONObject jSONObject) {
        if (fsl.O000000o(this.mAppContext, this.did) && xmPluginPackage != null) {
            String str2 = "plugin." + xmPluginPackage.getPluginId() + "." + xmPluginPackage.getPackageId();
            String str3 = "";
            String obj2 = obj != null ? obj.toString() : str3;
            if (jSONObject != null) {
                str3 = jSONObject.toString();
            }
            String str4 = str3;
            int indexOf = str.indexOf(":");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                str = str.substring(indexOf + 1);
                hxh.O000000o(str2, substring, str, obj2, jSONObject);
            }
            CoreApi.O000000o().O000000o(StatType.PLUGIN, str2, str, obj2, str4, false);
        }
    }

    public final String getAccountId() {
        return CoreApi.O000000o().O0000o0();
    }

    /* access modifiers changed from: protected */
    public Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper == null ? Looper.getMainLooper() : myLooper;
    }

    public final <T> void callRouterRemoteApi(String str, String str2, String str3, boolean z, List<NameValuePair> list, final Callback<T> callback, final Parser<T> parser) {
        final Looper looper = getLooper();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (NameValuePair next : list) {
                arrayList.add(new KeyValuePair(next.getName(), next.getValue()));
            }
        }
        String str4 = str;
        boolean z2 = z;
        CoreApi.O000000o().O000000o(this.mAppContext, new NetRequest.O000000o().O000000o(str3).O00000Oo(str2).O000000o(arrayList).O000000o(), str4, z2, new fss<String>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass1 */

            public String parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass2 */

            public void onSuccess(String str) {
                Parser parser = parser;
                if (parser != null) {
                    try {
                        PluginHostApi.this.handlerSuccess(callback, parser.parse(str), looper);
                    } catch (Exception e) {
                        PluginHostApi.this.handlerFailed(callback, ErrorCode.ERROR_JSON_PARSER_EXCEPTION.getCode(), e.toString(), looper);
                    }
                } else {
                    PluginHostApi.this.handlerSuccess(callback, null, looper);
                }
            }

            public void onFailure(fso fso) {
                PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, "", looper);
            }
        });
    }

    public final <T> void callRouterRemoteApiV13(String str, String str2, String str3, boolean z, List<com.xiaomi.smarthome.device.api.KeyValuePair> list, final Callback<T> callback, final Parser<T> parser) {
        final Looper looper = getLooper();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.xiaomi.smarthome.device.api.KeyValuePair next : list) {
                arrayList.add(new KeyValuePair(next.getKey(), next.getValue()));
            }
        }
        String str4 = str;
        boolean z2 = z;
        CoreApi.O000000o().O000000o(this.mAppContext, new NetRequest.O000000o().O000000o(str3).O00000Oo(str2).O000000o(arrayList).O000000o(), str4, z2, new fss<String>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass3 */

            public String parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass4 */

            public void onSuccess(String str) {
                Parser parser = parser;
                if (parser != null) {
                    try {
                        PluginHostApi.this.handlerSuccess(callback, parser.parse(str), looper);
                    } catch (Exception e) {
                        PluginHostApi.this.handlerFailed(callback, ErrorCode.ERROR_JSON_PARSER_EXCEPTION.getCode(), e.toString(), looper);
                    }
                } else {
                    PluginHostApi.this.handlerSuccess(callback, null, looper);
                }
            }

            public void onFailure(fso fso) {
                PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, "", looper);
            }
        });
    }

    /* access modifiers changed from: protected */
    public <T> void handlerSuccess(final Callback<T> callback, final T t, Looper looper) {
        if (callback != null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            new Handler(looper).post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass5 */

                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(t);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public <T> void handlerFailed(final Callback<T> callback, final int i, final String str, Looper looper) {
        if (callback != null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            new Handler(looper).post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass6 */

                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            });
        }
    }

    public <T> void callSmartHomeApi(String str, String str2, JSONObject jSONObject, Callback<T> callback, Parser<T> parser) {
        callSmartHomeApi(str, str2, jSONObject.toString(), callback, parser);
    }

    public <T> void callSmartHomeApi(String str, String str2, String str3, String str4, JSONObject jSONObject, Callback<T> callback, Parser<T> parser) {
        callSmartHomeApi(str, str2, str3, str4, jSONObject.toString(), callback, parser);
    }

    public final <T> void callSmartHomeApi(String str, String str2, String str3, final Callback<T> callback, final Parser<T> parser) {
        boolean z;
        final Looper looper = getLooper();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str3));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo(str2).O000000o(arrayList).O000000o();
        if (parser == null) {
            z = false;
        } else {
            z = parser instanceof ParserForRawResult;
        }
        CoreApi.O000000o().O000000o((Context) null, O000000o2, new fss<T>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass7 */

            public T parse(JSONObject jSONObject) throws JSONException {
                Parser parser = parser;
                if (parser != null) {
                    return parser.parse(jSONObject.toString());
                }
                return null;
            }
        }, Crypto.RC4, new fsm<T, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass8 */

            public void onSuccess(T t) {
                PluginHostApi.this.handlerSuccess(callback, t, looper);
            }

            public void onFailure(fso fso) {
                if (fso != null) {
                    PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
                } else {
                    PluginHostApi.this.handlerFailed(callback, -1, "", looper);
                }
            }
        }, z);
    }

    public <T> void callSmartHomeApi(String str, String str2, String str3, String str4, String str5, final Callback<T> callback, final Parser<T> parser) {
        boolean z;
        final Looper looper = getLooper();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", str5));
        if (TextUtils.isEmpty(str4) || (!str4.toLowerCase().equals("get") && !str4.toLowerCase().equals("post"))) {
            str4 = "GET";
        }
        if (parser == null) {
            z = false;
        } else {
            z = parser instanceof ParserForRawResult;
        }
        CoreApi.O000000o().O000000o((Context) null, new NetRequest.O000000o().O00000o0(str2).O000000o(str4).O00000Oo(str3).O000000o(arrayList).O000000o(), new fss<T>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass9 */

            public T parse(JSONObject jSONObject) throws JSONException {
                Parser parser = parser;
                if (parser != null) {
                    return parser.parse(jSONObject.toString());
                }
                return null;
            }
        }, Crypto.RC4, new fsm<T, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass10 */

            public void onSuccess(T t) {
                PluginHostApi.this.handlerSuccess(callback, t, looper);
            }

            public void onFailure(fso fso) {
                if (fso != null) {
                    PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
                } else {
                    PluginHostApi.this.handlerFailed(callback, -1, "", looper);
                }
            }
        }, z);
    }

    public <T> void callMethod(String str, String str2, JSONArray jSONArray, Callback<T> callback, Parser<T> parser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", generateNonce());
            jSONObject.put("method", str2);
            jSONObject.put("params", jSONArray);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.ERROR_PARAM_JSON_ERROR.getCode(), e.toString());
            }
        }
        request(str, jSONObject.toString(), false, callback, parser);
    }

    public <T> void callMethodFromCloud(String str, String str2, Object obj, Callback<T> callback, Parser<T> parser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", generateNonce());
            jSONObject.put("method", str2);
            jSONObject.put("params", obj);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.ERROR_PARAM_JSON_ERROR.getCode(), e.toString());
            }
        }
        request(str, jSONObject.toString(), true, callback, parser);
    }

    public <T> void callMethod(String str, String str2, JSONObject jSONObject, Callback<T> callback, Parser<T> parser) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", generateNonce());
            jSONObject2.put("method", str2);
            jSONObject2.put("params", jSONObject);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.ERROR_PARAM_JSON_ERROR.getCode(), e.toString());
            }
        }
        request(str, jSONObject2.toString(), false, callback, parser);
    }

    public final <T> void callMethod(String str, String str2, Object[] objArr, Callback<T> callback, Parser<T> parser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", generateNonce());
            jSONObject.put("method", str2);
            JSONArray jSONArray = new JSONArray();
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] != null) {
                        jSONArray.put(objArr[i]);
                    }
                }
            }
            jSONObject.put("params", jSONArray);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.ERROR_PARAM_JSON_ERROR.getCode(), e.toString());
            }
        }
        request(str, jSONObject.toString(), false, callback, parser);
    }

    public final <T> void request(String str, String str2, boolean z, final Callback<T> callback, final Parser<T> parser) {
        final Looper looper = getLooper();
        DeviceStat deviceByDid = getDeviceByDid(str);
        if (deviceByDid == null) {
            handlerFailed(callback, -1, "device not found", looper);
            return;
        }
        final String str3 = deviceByDid.token;
        final AnonymousClass11 r7 = new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass11 */

            public void onSuccess(JSONObject jSONObject) {
                Parser parser = parser;
                if (parser != null) {
                    try {
                        PluginHostApi.this.handlerSuccess(callback, parser.parse(jSONObject.toString()), looper);
                    } catch (Exception e) {
                        PluginHostApi.this.handlerFailed(callback, -1, e.getMessage(), looper);
                    }
                } else {
                    PluginHostApi.this.handlerSuccess(callback, null, looper);
                }
            }

            public void onFailure(fso fso) {
                PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
            }
        };
        final boolean z2 = z;
        final String str4 = str;
        final String str5 = str2;
        final Parser<T> parser2 = parser;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass12 */

            public void run() {
                if (z2) {
                    CoreApi O000000o2 = CoreApi.O000000o();
                    String str = str4;
                    String str2 = str3;
                    String str3 = str5;
                    fsm fsm = r7;
                    Parser parser = parser2;
                    O000000o2.O000000o(str, str2, str3, fsm, parser != null && (parser instanceof ParserForRawResult));
                    return;
                }
                CoreApi O000000o3 = CoreApi.O000000o();
                String str4 = str4;
                String str5 = str3;
                String str6 = str5;
                fsm fsm2 = r7;
                Parser parser2 = parser2;
                O000000o3.O00000Oo(str4, str5, str6, fsm2, parser2 != null && (parser2 instanceof ParserForRawResult));
            }
        });
    }

    public final <T> void requestFromLocal(String str, String str2, final Callback<T> callback, final Parser<T> parser) {
        final Looper looper = getLooper();
        DeviceStat deviceByDid = getDeviceByDid(str);
        if (deviceByDid == null) {
            handlerFailed(callback, -1, "device not found", looper);
            return;
        }
        final String str3 = deviceByDid.token;
        final AnonymousClass13 r6 = new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass13 */

            public void onSuccess(JSONObject jSONObject) {
                Parser parser = parser;
                if (parser != null) {
                    try {
                        PluginHostApi.this.handlerSuccess(callback, parser.parse(jSONObject.toString()), looper);
                    } catch (Exception e) {
                        PluginHostApi.this.handlerFailed(callback, -1, e.getMessage(), looper);
                    }
                } else {
                    PluginHostApi.this.handlerSuccess(callback, null, looper);
                }
            }

            public void onFailure(fso fso) {
                PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
            }
        };
        final String str4 = str;
        final String str5 = str2;
        final Parser<T> parser2 = parser;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass14 */

            public void run() {
                CoreApi O000000o2 = CoreApi.O000000o();
                String str = str4;
                String str2 = str3;
                String str3 = str5;
                fsm fsm = r6;
                Parser parser = parser2;
                O000000o2.O00000o0(str, str2, str3, fsm, parser != null && (parser instanceof ParserForRawResult));
            }
        });
    }

    public RunningProcess pluginRunningProcess() {
        return PluginBridgeService.process;
    }

    public final void startActivity(Context context, XmPluginPackage xmPluginPackage, Intent intent, String str, Class cls) {
        RunningProcess runningProcess;
        String str2;
        Class pluginActivityClass;
        if (xmPluginPackage != null) {
            DeviceStat deviceStat = null;
            if (!TextUtils.isEmpty(str)) {
                deviceStat = XmPluginHostApi.instance().getDeviceByDid(str);
            }
            if (deviceStat == null) {
                List<String> modelList = xmPluginPackage.getModelList();
                str2 = modelList.size() > 0 ? modelList.get(0) : "";
                runningProcess = PluginBridgeService.process;
            } else {
                str2 = deviceStat.model;
                runningProcess = pluginRunningProcess();
            }
            if (runningProcess == null) {
                runningProcess = RunningProcess.PLUGIN0;
            }
            if (!TextUtils.isEmpty(str2) && (pluginActivityClass = PluginRuntimeManager.getInstance().getPluginActivityClass(runningProcess)) != null) {
                Intent intent2 = new Intent(this.mAppContext, pluginActivityClass);
                if (!TextUtils.isEmpty(str)) {
                    intent2.addCategory("did:".concat(String.valueOf(str)));
                }
                intent2.addCategory("model:".concat(String.valueOf(str2)));
                if (intent != null) {
                    intent2.putExtra("plugin_extra", intent);
                    intent2.addFlags(intent.getFlags());
                }
                exz exz = exz.f15941O000000o;
                exz.O000000o(intent2, str2);
                intent2.putExtra("extra_package", xmPluginPackage.packageName);
                intent2.putExtra("extra_class", cls.getName());
                if (!TextUtils.isEmpty(str)) {
                    intent2.putExtra("extra_device_did", str);
                }
                intent2.putExtra("extra_device_model", str2);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                context.startActivity(intent2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    public final void startService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Intent intent, Class cls, Callback<Bundle> callback) {
        final Callback<Bundle> callback2 = callback;
        if (xmPluginPackage != null) {
            Class pluginHostServiceClass = PluginRuntimeManager.getInstance().getPluginHostServiceClass(hostService);
            if (pluginHostServiceClass == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find PluginHostService");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                    return;
                }
                return;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent(this.mAppContext, pluginHostServiceClass), 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not resolve PluginHostService");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                    return;
                }
                return;
            }
            RunningProcess runningProcess = null;
            Iterator<String> it = xmPluginPackage.getModelList().iterator();
            while (it.hasNext() && (runningProcess = PluginRuntimeManager.getInstance().getPluginProcess(0, it.next())) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
            RunningProcess runningProcess2 = runningProcess;
            if (runningProcess2 == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find targetPluginProcess");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                }
            } else if (runningProcess2 != RunningProcess.getByProcessName(resolveService.serviceInfo.processName)) {
                gsy.O000000o(3, "PluginHostApi", "startService: targetPluginProcess and serviceProcess not match");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                }
            } else {
                PluginApi.getInstance().startService(runningProcess2, pluginHostServiceClass.getName(), xmPluginPackage.getPluginId(), xmPluginPackage.getPackageId(), intent, cls.getName(), new PluginApi.StartServiceCallback() {
                    /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass15 */

                    public void onSuccess() {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onSuccess(new Bundle());
                        }
                    }

                    public void onFailure(fso fso) {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                        }
                    }
                });
            }
        } else if (callback2 != null) {
            callback2.onFailure(-1, "");
        }
    }

    public final void stopService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Intent intent, Class cls, Callback<Bundle> callback) {
        if (xmPluginPackage != null) {
            Class pluginHostServiceClass = PluginRuntimeManager.getInstance().getPluginHostServiceClass(hostService);
            if (pluginHostServiceClass == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find PluginHostService");
                if (callback != null) {
                    callback.onFailure(-1, "");
                    return;
                }
                return;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent(this.mAppContext, pluginHostServiceClass), 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not resolve PluginHostService");
                if (callback != null) {
                    callback.onFailure(-1, "");
                    return;
                }
                return;
            }
            RunningProcess runningProcess = null;
            Iterator<String> it = xmPluginPackage.getModelList().iterator();
            while (it.hasNext()) {
                it.next();
                runningProcess = pluginRunningProcess();
                if (runningProcess != null) {
                    break;
                }
            }
            if (runningProcess == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find targetPluginProcess");
                if (callback != null) {
                    callback.onFailure(-1, "");
                }
            } else if (runningProcess != RunningProcess.getByProcessName(resolveService.serviceInfo.processName)) {
                gsy.O000000o(3, "PluginHostApi", "startService: targetPluginProcess and serviceProcess not match");
                if (callback != null) {
                    callback.onFailure(-1, "");
                }
            } else {
                if (this.mAppContext.stopService(new Intent(this.mAppContext, pluginHostServiceClass))) {
                    if (callback != null) {
                        callback.onSuccess(new Bundle());
                    }
                } else if (callback != null) {
                    callback.onFailure(-1, "");
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "");
        }
    }

    public void localPing(final String str, final Callback<Void> callback) {
        final Looper looper = getLooper();
        if (getDeviceByDid(str) == null) {
            handlerFailed(callback, -1, "device not found", looper);
            return;
        }
        final AnonymousClass16 r1 = new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass16 */

            public void onSuccess(Void voidR) {
                PluginHostApi.this.handlerSuccess(callback, null, looper);
            }

            public void onFailure(fso fso) {
                PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
            }
        };
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass17 */

            public void run() {
                CoreApi O000000o2 = CoreApi.O000000o();
                try {
                    O000000o2.O00000Oo().localPing(str, new IClientCallback.Stub(r1) {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass39 */
                        final /* synthetic */ fsm val$callback;

                        {
                            this.val$callback = r2;
                        }

                        public void onSuccess(Bundle bundle) {
                            fsm fsm = this.val$callback;
                            if (fsm != null) {
                                fsm.sendSuccessMessage(null);
                            }
                        }

                        public void onFailure(Bundle bundle) {
                            bundle.setClassLoader(fso.class.getClassLoader());
                            Error error = (Error) bundle.getParcelable("error");
                            fsm fsm = this.val$callback;
                            if (fsm != null) {
                                fsm.sendFailureMessage(new fso(error.f6718O000000o, error.O00000Oo));
                            }
                        }
                    });
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (CoreApi.CoreNotReadyException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void localPingWithParams(String str, int i, int i2, final Callback<Void> callback) {
        final Looper looper = getLooper();
        if (getDeviceByDid(str) == null) {
            handlerFailed(callback, -1, "device not found", looper);
            return;
        }
        final AnonymousClass18 r6 = new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass18 */

            public void onSuccess(Void voidR) {
                PluginHostApi.this.handlerSuccess(callback, null, looper);
            }

            public void onFailure(fso fso) {
                PluginHostApi.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
            }
        };
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass19 */

            public void run() {
                CoreApi O000000o2 = CoreApi.O000000o();
                try {
                    O000000o2.O00000Oo().localPingWithParams(str2, i3, i4, new IClientCallback.Stub(r6) {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass40 */
                        final /* synthetic */ fsm val$callback;

                        {
                            this.val$callback = r2;
                        }

                        public void onSuccess(Bundle bundle) {
                            fsm fsm = this.val$callback;
                            if (fsm != null) {
                                fsm.sendSuccessMessage(null);
                            }
                        }

                        public void onFailure(Bundle bundle) {
                            bundle.setClassLoader(fso.class.getClassLoader());
                            Error error = (Error) bundle.getParcelable("error");
                            fsm fsm = this.val$callback;
                            if (fsm != null) {
                                fsm.sendFailureMessage(new fso(error.f6718O000000o, error.O00000Oo));
                            }
                        }
                    });
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (CoreApi.CoreNotReadyException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    public void bindService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Class cls, ServiceConnection serviceConnection, int i, Callback<Bundle> callback) {
        final Callback<Bundle> callback2 = callback;
        if (xmPluginPackage != null) {
            Class pluginHostServiceClass = PluginRuntimeManager.getInstance().getPluginHostServiceClass(hostService);
            if (pluginHostServiceClass == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find PluginHostService");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                    return;
                }
                return;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent(this.mAppContext, pluginHostServiceClass), 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not resolve PluginHostService");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                    return;
                }
                return;
            }
            RunningProcess runningProcess = null;
            Iterator<String> it = xmPluginPackage.getModelList().iterator();
            while (it.hasNext() && (runningProcess = PluginRuntimeManager.getInstance().getPluginProcess(0, it.next())) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
            RunningProcess runningProcess2 = runningProcess;
            if (runningProcess2 == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find targetPluginProcess");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                }
            } else if (runningProcess2 != RunningProcess.getByProcessName(resolveService.serviceInfo.processName)) {
                gsy.O000000o(3, "PluginHostApi", "startService: targetPluginProcess and serviceProcess not match");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                }
            } else {
                PluginApi.getInstance().bindService(runningProcess2, pluginHostServiceClass.getName(), xmPluginPackage.getPluginId(), xmPluginPackage.getPackageId(), cls.getName(), serviceConnection, i, new PluginApi.BindServiceCallback() {
                    /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass20 */

                    public void onSuccess() {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onSuccess(null);
                        }
                    }

                    public void onFailure(fso fso) {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                        }
                    }
                });
            }
        } else if (callback2 != null) {
            callback2.onFailure(-1, "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    public void unbindService(Context context, XmPluginPackage xmPluginPackage, HostService hostService, Class cls, ServiceConnection serviceConnection, Callback<Bundle> callback) {
        final Callback<Bundle> callback2 = callback;
        if (xmPluginPackage != null) {
            Class pluginHostServiceClass = PluginRuntimeManager.getInstance().getPluginHostServiceClass(hostService);
            if (pluginHostServiceClass == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find PluginHostService");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                    return;
                }
                return;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent(this.mAppContext, pluginHostServiceClass), 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not resolve PluginHostService");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                    return;
                }
                return;
            }
            RunningProcess runningProcess = null;
            Iterator<String> it = xmPluginPackage.getModelList().iterator();
            while (it.hasNext() && (runningProcess = PluginRuntimeManager.getInstance().getPluginProcess(0, it.next())) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
            RunningProcess runningProcess2 = runningProcess;
            if (runningProcess2 == null) {
                gsy.O000000o(3, "PluginHostApi", "startService: can not find targetPluginProcess");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                }
            } else if (runningProcess2 != RunningProcess.getByProcessName(resolveService.serviceInfo.processName)) {
                gsy.O000000o(3, "PluginHostApi", "startService: targetPluginProcess and serviceProcess not match");
                if (callback2 != null) {
                    callback2.onFailure(-1, "");
                }
            } else {
                PluginApi.getInstance().unbindService(runningProcess2, pluginHostServiceClass.getName(), xmPluginPackage.getPluginId(), xmPluginPackage.getPackageId(), cls.getName(), serviceConnection, new PluginApi.UnBindServiceCallback() {
                    /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass21 */

                    public void onSuccess() {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onSuccess(null);
                        }
                    }

                    public void onFailure(fso fso) {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                        }
                    }
                });
            }
        } else if (callback2 != null) {
            callback2.onFailure(-1, "");
        }
    }

    public long getUTCTimeInMillis() {
        MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("xiaomiio");
        if (O000000o2 != null) {
            return System.currentTimeMillis() + O000000o2.O00000oO;
        }
        return System.currentTimeMillis();
    }

    public void setCurrentDid(String str) {
        this.did = str;
    }

    public void setUserDeviceData(String str, String str2, String str3, String str4, long j, Object obj, Callback<JSONArray> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("type", str3);
            jSONObject.put("key", str4);
            jSONObject.put("time", j);
            jSONObject.put("value", obj);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
                return;
            }
        }
        callSmartHomeApi(str, "/user/set_user_device_data", jSONObject, callback, new Parser<JSONArray>() {
            /* class com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.AnonymousClass22 */

            public JSONArray parse(String str) throws JSONException {
                return new JSONObject(str).getJSONArray("result");
            }
        });
    }
}
