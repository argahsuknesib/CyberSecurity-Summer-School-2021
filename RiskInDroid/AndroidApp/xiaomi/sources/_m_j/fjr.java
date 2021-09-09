package _m_j;

import _m_j.fdi;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fjr {

    /* renamed from: O000000o  reason: collision with root package name */
    private volatile fdi f16491O000000o;

    /* access modifiers changed from: private */
    public static /* synthetic */ ArrayList O000000o(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) throws Exception {
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        return arrayList4;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(fdh fdh, ArrayList arrayList) throws Exception {
        fdh.onSuccess(arrayList);
        LogType logType = LogType.NETWORK;
        gsy.O00000o0(logType, "DeviceListApi", "updateAllDeviceList onSuccess size:" + arrayList.size());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(fdh fdh, Throwable th) throws Exception {
        String stackTraceString = Log.getStackTraceString(th);
        gsy.O00000o0(LogType.NETWORK, "DeviceListApi", "updateAllDeviceList onFailure error:".concat(String.valueOf(stackTraceString)));
        fdh.onFailure(new NetError(-1, stackTraceString));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final ObservableEmitter observableEmitter) throws Exception {
        fdt.O000000o().O000000o(O000000o(new JSONObject(), "/v2/home/local_device_list"), new fdh<NetResult, NetError>() {
            /* class _m_j.fjr.AnonymousClass2 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                gsy.O00000o0(LogType.DEVICE_LIST, "DeviceListApi", "core /v2/home/local_device_list onFailure error:".concat(String.valueOf(netError)));
                observableEmitter.tryOnError(new Exception(String.valueOf(netError)));
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                if (netResult == null || netResult.O00000o0 == null) {
                    gsy.O00000Oo(LogType.NETWORK, "DeviceListApi", "core /v2/home/local_device_list result.mResponse null");
                    observableEmitter.tryOnError(new Exception("result.mResponse null"));
                    return;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONObject optJSONObject = new JSONObject(netResult.O00000o0).optJSONObject("result");
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("local_list");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("third_list");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    arrayList.add(fjb.O000000o(optJSONObject2));
                                }
                            }
                        }
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    arrayList.add(fjb.O000000o(optJSONObject3));
                                }
                            }
                        }
                        LogType logType = LogType.NETWORK;
                        gsy.O00000Oo(logType, "DeviceListApi", "core /v2/home/local_device_list onSuccess size:" + arrayList.size());
                    } else {
                        LogType logType2 = LogType.NETWORK;
                        gsy.O00000Oo(logType2, "DeviceListApi", "core /v2/home/local_device_list onSuccess result:" + netResult.O00000o0);
                    }
                    observableEmitter.onNext(arrayList);
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    LogType logType3 = LogType.NETWORK;
                    gsy.O00000Oo(logType3, "DeviceListApi", "core /v2/home/local_device_list Exception result:" + netResult.O00000o0);
                    observableEmitter.tryOnError(e);
                }
            }
        });
    }

    public static NetRequest O000000o(JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return new NetRequest.O000000o().O000000o("POST").O00000Oo(str).O000000o(arrayList).O000000o();
    }

    public final fdi O000000o(final JSONObject jSONObject, fdh<ArrayList<Device>, NetError> fdh) {
        if (this.f16491O000000o != null) {
            synchronized (this) {
                if (this.f16491O000000o != null) {
                    this.f16491O000000o.O000000o();
                    this.f16491O000000o = null;
                }
            }
        }
        gsy.O00000Oo(LogType.NETWORK, "DeviceListApi", "updateBindDeviceList core /v2/home/device_list_page");
        final long currentTimeMillis = System.currentTimeMillis();
        Observable create = Observable.create(new ObservableOnSubscribe<ArrayList<Device>>() {
            /* class _m_j.fjr.AnonymousClass4 */

            public final void subscribe(@NonNull final ObservableEmitter<ArrayList<Device>> observableEmitter) throws Exception {
                fdt.O000000o().O000000o(fjr.O000000o(jSONObject, "/v2/home/device_list_page"), new fdh<NetResult, NetError>() {
                    /* class _m_j.fjr.AnonymousClass4.AnonymousClass1 */
                    private final ArrayList<Device> O00000o0 = new ArrayList<>();

                    public final /* synthetic */ void onFailure(Error error) {
                        LogType logType = LogType.DEVICE_LIST;
                        gsy.O00000o0(logType, "DeviceListApi", "core /v2/home/device_list_page onFailure times:" + this.O00000o0.size() + " " + ((NetError) error));
                        observableEmitter.tryOnError(new Exception("updateBindDeviceList onFailure null error"));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        NetResult netResult = (NetResult) obj;
                        if (netResult == null || TextUtils.isEmpty(netResult.O00000o0)) {
                            LogType logType = LogType.NETWORK;
                            gsy.O00000Oo(logType, "DeviceListApi", "core /v2/home/device_list_page no netResult times:" + this.O00000o0.size() + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                            observableEmitter.onNext(this.O00000o0);
                            observableEmitter.onComplete();
                            return;
                        }
                        try {
                            JSONObject optJSONObject = new JSONObject(netResult.O00000o0).optJSONObject("result");
                            if (optJSONObject != null) {
                                JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                                if (optJSONArray != null) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                        if (optJSONObject2 != null) {
                                            this.O00000o0.add(fjb.O000000o(optJSONObject2));
                                        }
                                    }
                                }
                                LogType logType2 = LogType.NETWORK;
                                StringBuilder sb = new StringBuilder("core /v2/home/device_list_page content:list=");
                                sb.append(optJSONArray == null ? null : Integer.valueOf(optJSONArray.length()));
                                sb.append(",has_more=");
                                sb.append(optJSONObject.optBoolean("has_more"));
                                gsy.O00000Oo(logType2, "DeviceListApi", sb.toString());
                                if (optJSONObject.optBoolean("has_more")) {
                                    String optString = optJSONObject.optString("next_start_did");
                                    gsy.O00000Oo(LogType.NETWORK, "DeviceListApi", "core /v2/home/device_list_page request next page with did:".concat(String.valueOf(optString)));
                                    jSONObject.put("start_did", optString);
                                    fdt.O000000o().O000000o(fjr.O000000o(jSONObject, "/v2/home/device_list_page"), this);
                                    return;
                                }
                                LogType logType3 = LogType.NETWORK;
                                gsy.O00000Oo(logType3, "DeviceListApi", "core /v2/home/device_list_page success times:" + this.O00000o0.size() + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                                observableEmitter.onNext(this.O00000o0);
                                observableEmitter.onComplete();
                                return;
                            }
                            LogType logType4 = LogType.NETWORK;
                            gsy.O00000Oo(logType4, "DeviceListApi", "core /v2/home/device_list_page resultObject null times:" + this.O00000o0.size() + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                            observableEmitter.onNext(this.O00000o0);
                            observableEmitter.onComplete();
                        } catch (JSONException e) {
                            LogType logType5 = LogType.NETWORK;
                            gsy.O00000Oo(logType5, "DeviceListApi", "core /v2/home/device_list_page JSONException times:" + this.O00000o0.size());
                            observableEmitter.tryOnError(e);
                        }
                    }
                });
            }
        });
        gsy.O00000Oo(LogType.NETWORK, "DeviceListApi", "updateLocalDeviceList core /v2/home/local_device_list");
        Observable create2 = Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$fjr$rGUI01OhTJEznHlZIJwZhZG6b0 */

            public final void subscribe(ObservableEmitter observableEmitter) {
                fjr.this.O000000o(observableEmitter);
            }
        });
        gsy.O00000Oo("DeviceListApi", "updateSharedHomeDeviceList");
        final Disposable subscribe = Observable.zip(create, create2, Observable.create(new ObservableOnSubscribe<ArrayList<Device>>() {
            /* class _m_j.fjr.AnonymousClass3 */

            public final void subscribe(@NonNull final ObservableEmitter<ArrayList<Device>> observableEmitter) throws Exception {
                fjx O000000o2 = fjx.O000000o();
                AnonymousClass1 r1 = new fdh<ArrayList<Device>, NetError>() {
                    /* class _m_j.fjr.AnonymousClass3.AnonymousClass1 */

                    public final /* synthetic */ void onFailure(Error error) {
                        String str;
                        NetError netError = (NetError) error;
                        LogType logType = LogType.DEVICE_LIST;
                        StringBuilder sb = new StringBuilder("updateSharedHomeDeviceList onFailure ");
                        if (netError == null) {
                            str = null;
                        } else {
                            str = netError.f6718O000000o + ":" + netError.O00000Oo;
                        }
                        sb.append(str);
                        gsy.O00000o0(logType, "DeviceListApi", sb.toString());
                        observableEmitter.tryOnError(new Exception(String.valueOf(netError)));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        ArrayList arrayList = (ArrayList) obj;
                        gsy.O00000Oo("DeviceListApi", "updateSharedHomeDeviceList onSuccess");
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        observableEmitter.onNext(arrayList);
                        observableEmitter.onComplete();
                    }
                };
                Home home = O000000o2.O00000o0;
                if (home == null || home.isOwner()) {
                    O000000o2.O000000o(home, (ArrayList<Device>) null, r1);
                    new fdi(null);
                    return;
                }
                LogType logType = LogType.HOME_ROOM;
                String str = fjx.f16504O000000o;
                gsy.O00000Oo(logType, str, "updateSharedHomeDeviceList " + home.getId());
                O000000o2.O000000o(home.getOwnerUid(), Long.parseLong(home.getId()), new fdh<ArrayList<Device>, NetError>(home, r1) {
                    /* class _m_j.fjx.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Home f16505O000000o;
                    final /* synthetic */ fdh O00000Oo;

                    {
                        this.f16505O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* bridge */ /* synthetic */ void onFailure(Error error) {
                        NetError netError = (NetError) error;
                        fdh fdh = this.O00000Oo;
                        if (fdh != null) {
                            fdh.onFailure(netError);
                        }
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fjx.this.O000000o(this.f16505O000000o, (ArrayList) obj, this.O00000Oo);
                    }
                });
            }
        }), $$Lambda$fjr$tgeE6PM7VQabHRuB4ZgVAyV7oJc.INSTANCE).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$fjr$p75UT6BW1er9dwJ5_LO_h0Iucdw */

            public final void accept(Object obj) {
                fjr.O000000o(fdh.this, (ArrayList) obj);
            }
        }, new Consumer() {
            /* class _m_j.$$Lambda$fjr$ze75EWsEj6QWnPejwuu0_2F9A */

            public final void accept(Object obj) {
                fjr.O000000o(fdh.this, (Throwable) obj);
            }
        });
        return new fdi.O000000o() {
            /* class _m_j.fjr.AnonymousClass1 */

            public final void O000000o() {
                super.O000000o();
                subscribe.dispose();
            }
        };
    }
}
