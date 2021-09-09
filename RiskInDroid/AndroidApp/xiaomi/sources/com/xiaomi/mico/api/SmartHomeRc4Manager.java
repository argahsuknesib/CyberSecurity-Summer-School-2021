package com.xiaomi.mico.api;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.fcn;
import _m_j.fdh;
import _m_j.fdt;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.mico.api.AccountInfo;
import com.xiaomi.mico.api.SmartHomeRc4Manager;
import com.xiaomi.mico.api.model.Miot;
import com.xiaomi.mico.common.util.NetworkUtil;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class SmartHomeRc4Manager {
    public static String ADD_ROOM = "addroom";
    public static String ADD_TRANSFER_ROOM = "transfer";
    public static String PATH_ADD_ROOM = "/homeroom/addroom";
    public static String PATH_BIND_DEVICE_TO_ROOM = "/homeroom/bind_device_to_room";
    public static String PATH_DEVICE_LIST = "/home/device_list";
    public static String PATH_GETHOME = "/homeroom/gethome";
    public static String PATH_GETROOM = "/homeroom/getroom";
    public static String SID = "xiaomiio";
    private static volatile SmartHomeRc4Manager manager;
    public boolean inited;
    public ahg loggerNew = new ahg();

    private SmartHomeRc4Manager() {
        new ahh();
    }

    public static SmartHomeRc4Manager getInstance() {
        if (manager == null) {
            synchronized (SmartHomeRc4Manager.class) {
                if (manager == null) {
                    manager = new SmartHomeRc4Manager();
                }
            }
        }
        return manager;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void setTokenInfo(String str, String str2, String str3, String str4, String str5, long j) {
        char c;
        String str6;
        String str7;
        fcn.O000000o().O0000Oo0();
        fcn O000000o2 = fcn.O000000o();
        String str8 = SID;
        switch (str8.hashCode()) {
            case -1419722781:
                if (str8.equals("mi_huodong")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1308845963:
                if (str8.equals("mipaycom")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1104067068:
                if (str8.equals("miot-third-test")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -513303352:
                if (str8.equals("passportapi")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -360749757:
                if (str8.equals("xiaoqiang")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 265338657:
                if (str8.equals("xiaomiio")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1587352602:
                if (str8.equals("xiaomihome")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1781001842:
                if (str8.equals("mi_eshopm_go")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2026863872:
                if (str8.equals("miotstore")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                str6 = ".io.mi.com";
                break;
            case 1:
                str7 = "api.gorouter.info";
                str6 = str7;
                break;
            case 2:
                str7 = "account.xiaomi.com";
                str6 = str7;
                break;
            case 3:
                str7 = ".home.mi.com";
                str6 = str7;
                break;
            case 4:
                str7 = "shopapi.io.mi.com";
                str6 = str7;
                break;
            case 5:
                str7 = "web.recharge.pay.xiaomi.com";
                str6 = str7;
                break;
            case 6:
                str7 = "m.mi.com";
                str6 = str7;
                break;
            case 7:
                str7 = ".huodong.mi.com";
                str6 = str7;
                break;
            default:
                str7 = "";
                str6 = str7;
                break;
        }
        O000000o2.O000000o(str3, str4, str2, str5, str6, j);
        this.inited = true;
    }

    public Observable<String> refreshToken() {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    AccountInfo.ServiceInfo serviceInfo = LoginManager.getInstance().getServiceInfo(SmartHomeRc4Manager.SID);
                    if (!SmartHomeRc4Manager.this.inited || serviceInfo == null || !serviceInfo.isServiceTokenValid()) {
                        LoginManager.getInstance().refreshServiceToken(SmartHomeRc4Manager.SID).subscribe(new Action1(subscriber) {
                            /* class com.xiaomi.mico.api.$$Lambda$SmartHomeRc4Manager$1$YPKFlRJ21pB87uv74fCvx5oOBic */
                            private final /* synthetic */ Subscriber f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void call(Object obj) {
                                SmartHomeRc4Manager.AnonymousClass1.this.lambda$call$0$SmartHomeRc4Manager$1(this.f$1, (String) obj);
                            }
                        }, new Action1() {
                            /* class com.xiaomi.mico.api.$$Lambda$SmartHomeRc4Manager$1$VbREdBOhWBcLUzOOVA8gTjhm7E */

                            public final void call(Object obj) {
                                Subscriber.this.onError((Throwable) obj);
                            }
                        });
                        return;
                    }
                    subscriber.onNext(null);
                    subscriber.onCompleted();
                }
            }

            public /* synthetic */ void lambda$call$0$SmartHomeRc4Manager$1(Subscriber subscriber, String str) {
                AccountInfo.ServiceInfo serviceInfo = LoginManager.getInstance().getServiceInfo(SmartHomeRc4Manager.SID);
                AccountInfo.PassportInfo passportInfo = LoginManager.getInstance().getPassportInfo();
                if (!(serviceInfo == null || passportInfo == null)) {
                    SmartHomeRc4Manager.this.setTokenInfo(passportInfo.getUserId(), passportInfo.getCUserId(), serviceInfo.getSid(), serviceInfo.getServiceToken(), serviceInfo.getSsecurity(), -5);
                    subscriber.onNext(serviceInfo.getServiceToken());
                }
                subscriber.onCompleted();
            }
        });
    }

    public Observable<String> refreshServiceToken() {
        return LoginManager.getInstance().refreshServiceToken(SID);
    }

    public void doUnAuthorized(int i) {
        Object[] objArr = {"SmartHomeRc4Manager doUnAuthorized code=%d", Integer.valueOf(i)};
        LoginManager.getInstance().remoceServiceInfo(SID);
        this.inited = false;
    }

    public List<KeyValuePair> buildParams(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(str, str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return arrayList;
    }

    public Observable<String> getRoomInfo() {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super String> subscriber) {
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo(SmartHomeRc4Manager.PATH_GETROOM).O000000o(), new fdh<NetResult, NetError>() {
                    /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass2.AnonymousClass1 */

                    public void onCache(NetResult netResult) {
                        ahg.O00000Oo("onCache");
                    }

                    public void onSuccess(NetResult netResult) {
                        if (!subscriber.isUnsubscribed()) {
                            if (netResult == null || netResult.f6731O000000o != 0) {
                                subscriber.onError(new Throwable("SmartHomeRc4Api result not 0"));
                                return;
                            }
                            subscriber.onNext(netResult.O00000o0);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(NetError netError) {
                        subscriber.onError(new Throwable("on failure"));
                    }
                });
            }
        });
    }

    public Observable<String> getHomeInfo() {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
             arg types: [java.lang.String, int]
             candidates:
              org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
            public void call(final Subscriber<? super String> subscriber) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("fetch_share_dev", true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("GET").O000000o(arrayList).O00000Oo(SmartHomeRc4Manager.PATH_GETHOME).O000000o(), new fdh<NetResult, NetError>() {
                    /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass3.AnonymousClass1 */

                    public void onCache(NetResult netResult) {
                        ahg.O00000Oo("onCache");
                    }

                    public void onSuccess(NetResult netResult) {
                        if (!subscriber.isUnsubscribed()) {
                            if (netResult == null || netResult.f6731O000000o != 0) {
                                subscriber.onError(new Throwable("SmartHomeRc4Api result not 0"));
                                return;
                            }
                            subscriber.onNext(netResult.O00000o0);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(NetError netError) {
                        subscriber.onError(new Throwable("on failure"));
                    }
                });
            }
        });
    }

    public Observable<String> getMiotDevcieInfo() {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
             arg types: [java.lang.String, int]
             candidates:
              org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
            public void call(final Subscriber<? super String> subscriber) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                try {
                    String bssid = NetworkUtil.getBSSID(CommonApplication.getAppContext().getApplicationContext());
                    String ssid = NetworkUtil.getSSID(CommonApplication.getAppContext().getApplicationContext());
                    if (!TextUtils.isEmpty(ssid) && !TextUtils.isEmpty(bssid) && !TextUtils.equals(bssid, "02:00:00:00:00:00")) {
                        jSONObject.put("ssid", ssid);
                        jSONObject.put("bssid", bssid.toUpperCase());
                    }
                    jSONObject.put("getVirtualModel", true);
                    jSONObject.put("getHuamiDevices", 1);
                } catch (JSONException unused) {
                }
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo(SmartHomeRc4Manager.PATH_DEVICE_LIST).O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
                    /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass4.AnonymousClass1 */

                    public void onCache(NetResult netResult) {
                        ahg.O00000Oo("onCache");
                    }

                    public void onSuccess(NetResult netResult) {
                        if (!subscriber.isUnsubscribed()) {
                            if (netResult == null || netResult.f6731O000000o != 0) {
                                subscriber.onError(new Throwable("SmartHomeRc4Api result not 0"));
                                return;
                            }
                            subscriber.onNext(netResult.O00000o0);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(NetError netError) {
                        subscriber.onError(new Throwable("on failure"));
                    }
                });
            }
        });
    }

    public Observable<String> addTransferRoom(final String str, final List<Miot.Room> list) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass5 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
             arg types: [java.lang.String, java.util.List<java.lang.String>]
             candidates:
              org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
              org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject */
            public void call(final Subscriber<? super String> subscriber) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", SmartHomeRc4Manager.ADD_TRANSFER_ROOM);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("home_name", str);
                    JSONArray jSONArray = new JSONArray();
                    for (Miot.Room room : list) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", room.name);
                        jSONObject3.put("dids", (Object) room.dids);
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject2.put("room", jSONArray);
                    jSONObject.put("para", jSONObject2);
                } catch (JSONException unused) {
                }
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo(SmartHomeRc4Manager.PATH_ADD_ROOM).O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
                    /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass5.AnonymousClass1 */

                    public void onCache(NetResult netResult) {
                    }

                    public void onSuccess(NetResult netResult) {
                        subscriber.onNext(netResult.O00000o0);
                        subscriber.onCompleted();
                    }

                    public void onFailure(NetError netError) {
                        subscriber.onError(new Throwable("on failure"));
                    }
                });
            }
        });
    }

    public Observable<String> addRoom(final String str, final String str2, final String[] strArr) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass6 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super String> subscriber) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", SmartHomeRc4Manager.ADD_ROOM);
                    jSONObject.put("name", str);
                    jSONObject.put("parent_id", str2);
                    jSONObject.put("did", new JSONArray(strArr));
                } catch (JSONException unused) {
                }
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo(SmartHomeRc4Manager.PATH_ADD_ROOM).O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
                    /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass6.AnonymousClass1 */

                    public void onCache(NetResult netResult) {
                    }

                    public void onSuccess(NetResult netResult) {
                        subscriber.onNext(netResult.O00000o0);
                        subscriber.onCompleted();
                    }

                    public void onFailure(NetError netError) {
                        subscriber.onError(new Throwable("on failure"));
                    }
                });
            }
        });
    }

    public Observable<String> bindDeviceToRome(final String str, final String str2) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass7 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super String>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super String> subscriber) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    jSONObject.put("did", str2);
                } catch (JSONException unused) {
                }
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                Object[] objArr = {"bindDeviceToRome called id %s, did %s", str, str2};
                fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo(SmartHomeRc4Manager.PATH_BIND_DEVICE_TO_ROOM).O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
                    /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass7.AnonymousClass1 */

                    public void onCache(NetResult netResult) {
                    }

                    public void onSuccess(NetResult netResult) {
                        subscriber.onNext(netResult.O00000o0);
                        subscriber.onCompleted();
                    }

                    public void onFailure(NetError netError) {
                        subscriber.onError(new Throwable("on failure"));
                    }
                });
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public void test(Context context) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            String bssid = NetworkUtil.getBSSID(context.getApplicationContext());
            String ssid = NetworkUtil.getSSID(context.getApplicationContext());
            if (!TextUtils.isEmpty(ssid) && !TextUtils.isEmpty(bssid) && !TextUtils.equals(bssid, "02:00:00:00:00:00")) {
                jSONObject.put("ssid", ssid);
                jSONObject.put("bssid", bssid.toUpperCase());
            }
            jSONObject.put("getVirtualModel", true);
            jSONObject.put("getHuamiDevices", 1);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/device_list").O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
            /* class com.xiaomi.mico.api.SmartHomeRc4Manager.AnonymousClass8 */

            public void onCache(NetResult netResult) {
            }

            public void onSuccess(NetResult netResult) {
                ahg.O00000o("onSuccess");
            }

            public void onFailure(NetError netError) {
                ahg.O00000o("onFailure:" + netError.O00000Oo);
            }
        });
    }
}
