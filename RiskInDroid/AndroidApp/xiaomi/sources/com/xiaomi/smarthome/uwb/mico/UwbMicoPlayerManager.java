package com.xiaomi.smarthome.uwb.mico;

import _m_j.fdt;
import _m_j.fg;
import _m_j.gsy;
import _m_j.ixe;
import android.os.RemoteException;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import com.xiaomi.miplay.audioclient.sdk.MiPlayClient;
import com.xiaomi.miplay.audioclient.sdk.MiracastClient;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.mico.BaseControlChannel;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONObject;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u000201H\u0007J8\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070605042\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u000201J\u0006\u0010>\u001a\u000201J\u0006\u0010?\u001a\u000201J\u0010\u0010@\u001a\u0002012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010A\u001a\u000201R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R \u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R \u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#¨\u0006B"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerManager;", "", "()V", "_defaultBaseControlChannel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel;", "_defaultSeekControlChannel", "mBaseControlChannel", "Lcom/xiaomi/smarthome/uwb/mico/MicoBaseAction;", "getMBaseControlChannel", "()Lcom/xiaomi/smarthome/uwb/mico/MicoBaseAction;", "mMiPlayClient", "Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClient;", "getMMiPlayClient", "()Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClient;", "setMMiPlayClient", "(Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClient;)V", "mMiPlayIsPlaying", "", "mMiplayDisable", "getMMiplayDisable", "()Z", "mSeekControlChannel", "getMSeekControlChannel", "mUwbScanDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "getMUwbScanDevice", "()Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "setMUwbScanDevice", "(Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;)V", "miplayDeviceLiveData", "Lcom/xiaomi/miplay/audioclient/MiPlayDevice;", "getMiplayDeviceLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setMiplayDeviceLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "miplayLiveData", "Lcom/xiaomi/smarthome/uwb/mico/ContentInfo;", "getMiplayLiveData", "setMiplayLiveData", "remoteLiveData", "Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;", "getRemoteLiveData", "setRemoteLiveData", "uwbLiveData", "Lcom/xiaomi/smarthome/uwb/mico/BaseControl;", "getUwbLiveData", "setUwbLiveData", "changeBaseControlChannelIfNeed", "", "changeSeekChannelIfNeed", "getUwbRemoteObservable", "Lrx/Observable;", "Lretrofit2/Response;", "Lcom/xiaomi/mico/api/model/MinaResponse;", "Lcom/xiaomi/mico/api/model/Remote$Response;", "deviceId", "", "path", "method", "message", "initMiplayClientIfNeed", "miplayAudioPlay", "miplayAudioStop", "setUwbScanDevice", "unInitMiplayClientIfNeed", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoPlayerManager {
    public static final UwbMicoPlayerManager INSTANCE = new UwbMicoPlayerManager();
    private static final fg<BaseControlChannel> _defaultBaseControlChannel;
    private static final fg<BaseControlChannel> _defaultSeekControlChannel;
    private static MiPlayClient mMiPlayClient;
    private static boolean mMiPlayIsPlaying = true;
    private static final boolean mMiplayDisable = true;
    private static UwbScanDevice mUwbScanDevice;
    private static fg<MiPlayDevice> miplayDeviceLiveData = new fg<>();
    private static fg<ContentInfo> miplayLiveData = new fg<>();
    private static fg<Remote.Response.PlayerStatus> remoteLiveData = new RemoteLiveData();
    private static fg<BaseControl> uwbLiveData = new fg<>();

    private UwbMicoPlayerManager() {
    }

    static {
        fg<BaseControlChannel> fgVar = new fg<>();
        fgVar.setValue(BaseControlChannel.UWB.INSTANCE);
        _defaultBaseControlChannel = fgVar;
        fg<BaseControlChannel> fgVar2 = new fg<>();
        fgVar2.setValue(BaseControlChannel.REMOTE.INSTANCE);
        _defaultSeekControlChannel = fgVar2;
    }

    public final MicoBaseAction getMBaseControlChannel() {
        BaseControlChannel value = _defaultBaseControlChannel.getValue();
        if (value instanceof MicoBaseAction) {
            return (MicoBaseAction) value;
        }
        return null;
    }

    public final MicoBaseAction getMSeekControlChannel() {
        BaseControlChannel value = _defaultSeekControlChannel.getValue();
        if (value instanceof MicoBaseAction) {
            return (MicoBaseAction) value;
        }
        return null;
    }

    public final fg<ContentInfo> getMiplayLiveData() {
        return miplayLiveData;
    }

    public final void setMiplayLiveData(fg<ContentInfo> fgVar) {
        ixe.O00000o(fgVar, "<set-?>");
        miplayLiveData = fgVar;
    }

    public final fg<BaseControl> getUwbLiveData() {
        return uwbLiveData;
    }

    public final void setUwbLiveData(fg<BaseControl> fgVar) {
        ixe.O00000o(fgVar, "<set-?>");
        uwbLiveData = fgVar;
    }

    public final fg<Remote.Response.PlayerStatus> getRemoteLiveData() {
        return remoteLiveData;
    }

    public final void setRemoteLiveData(fg<Remote.Response.PlayerStatus> fgVar) {
        ixe.O00000o(fgVar, "<set-?>");
        remoteLiveData = fgVar;
    }

    public final fg<MiPlayDevice> getMiplayDeviceLiveData() {
        return miplayDeviceLiveData;
    }

    public final void setMiplayDeviceLiveData(fg<MiPlayDevice> fgVar) {
        ixe.O00000o(fgVar, "<set-?>");
        miplayDeviceLiveData = fgVar;
    }

    public final MiPlayClient getMMiPlayClient() {
        return mMiPlayClient;
    }

    public final void setMMiPlayClient(MiPlayClient miPlayClient) {
        mMiPlayClient = miPlayClient;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void changeBaseControlChannelIfNeed() {
        Class<?> cls;
        DidInfo didInfo;
        String str = null;
        if (mMiPlayClient != null) {
            UwbScanDevice uwbScanDevice = mUwbScanDevice;
            String did = (uwbScanDevice == null || (didInfo = uwbScanDevice.getDidInfo()) == null) ? null : didInfo.getDid();
            MiPlayDevice value = miplayDeviceLiveData.getValue();
            if (UwbDeviceUtil.isUwbHashEnd(did, value == null ? null : value.O0000O0o)) {
                _defaultBaseControlChannel.setValue(BaseControlChannel.MIPLAY.INSTANCE);
                LogType logType = LogType.LOG_UWB;
                BaseControlChannel value2 = _defaultBaseControlChannel.getValue();
                if (!(value2 == null || (cls = value2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                gsy.O000000o(logType, "", 3, "zxtUwbMicoPlayerManager", ixe.O000000o("changeBaseControlChannelIfNeed: ", (Object) str));
            }
        }
        if (UwbLouderSpeakerApi.isUWBAvailable()) {
            _defaultBaseControlChannel.setValue(BaseControlChannel.UWB.INSTANCE);
        } else {
            _defaultBaseControlChannel.setValue(BaseControlChannel.REMOTE.INSTANCE);
        }
        LogType logType2 = LogType.LOG_UWB;
        BaseControlChannel value22 = _defaultBaseControlChannel.getValue();
        str = cls.getSimpleName();
        gsy.O000000o(logType2, "", 3, "zxtUwbMicoPlayerManager", ixe.O000000o("changeBaseControlChannelIfNeed: ", (Object) str));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void changeSeekChannelIfNeed() {
        Class<?> cls;
        DidInfo didInfo;
        String str = null;
        if (mMiPlayClient != null) {
            UwbScanDevice uwbScanDevice = mUwbScanDevice;
            String did = (uwbScanDevice == null || (didInfo = uwbScanDevice.getDidInfo()) == null) ? null : didInfo.getDid();
            MiPlayDevice value = miplayDeviceLiveData.getValue();
            if (UwbDeviceUtil.isUwbHashEnd(did, value == null ? null : value.O0000O0o)) {
                _defaultSeekControlChannel.setValue(BaseControlChannel.MIPLAY.INSTANCE);
                LogType logType = LogType.LOG_UWB;
                BaseControlChannel value2 = _defaultSeekControlChannel.getValue();
                if (!(value2 == null || (cls = value2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                gsy.O000000o(logType, "", 3, "zxtUwbMicoPlayerManager", ixe.O000000o("changeSeekChannelIfNeed: ", (Object) str));
            }
        }
        _defaultSeekControlChannel.setValue(BaseControlChannel.REMOTE.INSTANCE);
        LogType logType2 = LogType.LOG_UWB;
        BaseControlChannel value22 = _defaultSeekControlChannel.getValue();
        str = cls.getSimpleName();
        gsy.O000000o(logType2, "", 3, "zxtUwbMicoPlayerManager", ixe.O000000o("changeSeekChannelIfNeed: ", (Object) str));
    }

    public final Observable<Response<MinaResponse<Remote.Response>>> getUwbRemoteObservable(String str, String str2, String str3, String str4) {
        ixe.O00000o(str, "deviceId");
        ixe.O00000o(str2, "path");
        ixe.O00000o(str3, "method");
        ixe.O00000o(str4, "message");
        Observable<Response<MinaResponse<Remote.Response>>> unsafeCreate = Observable.unsafeCreate(new Observable.OnSubscribe(str, str2, str3, str4) {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerManager$RWbQ8SQwDSOcwNNS2YXKa6iV7s */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void call(Object obj) {
                UwbMicoPlayerManager.m537getUwbRemoteObservable$lambda3(this.f$0, this.f$1, this.f$2, this.f$3, (Subscriber) obj);
            }
        });
        ixe.O00000Oo(unsafeCreate, "unsafeCreate { subscriber ->\n            val params: ArrayList<KeyValuePair> = ArrayList()\n            val dataObj = JSONObject().run {\n                put(\"did\", deviceId)\n                put(\"path\", path)\n                put(\"method\", method)\n                put(\"message\", JSONObject(message))\n                toString()\n            }\n            params.add(KeyValuePair(\"data\", dataObj))\n            val request = NetRequest.Builder()\n                    .method(NetRequest.METHOD_POST)\n                    .path(\"/v2/remote/ubus\")\n                    .addQueries(params)\n                    .build()\n\n            SmartHomeRc4Api.getInstance().sendRequest(request, object : NetCallback<NetResult, NetError> {\n                override fun onCache(result: NetResult) {}\n\n                override fun onSuccess(result: NetResult) {\n                    try {\n                        val jsonObject = JSONObject(result.mResponse)\n                        MiJiaLog.writeLogOnAll(LogType.LOG_UWB, \"\", Log.INFO, \"zxt${TAG}\", \"ubus $jsonObject\")\n                        val success = MinaResponse<Remote.Response>().run {\n                            data = Remote.sGson.fromJson(jsonObject.optString(\"result\"), Remote.Response::class.java)\n                            Response.success(this)\n                        }\n                        if (!subscriber.isUnsubscribed) {\n                            subscriber.onNext(success)\n                            subscriber.onCompleted()\n                        }\n                    } catch (e: Exception) {\n                        MiJiaLog.writeLogOnAll(LogType.LOG_UWB, \"\", Log.ERROR, \"zxt${TAG}\", \"ubus error\" + result.mResponse)\n                        e.printStackTrace()\n                    }\n                }\n\n                override fun onFailure(error: NetError) {\n                    if (!subscriber.isUnsubscribed) {\n                        subscriber.onError(ApiError.generateError(error.code, error.detail).toThrowable())\n                    }\n                }\n            })\n        }");
        return unsafeCreate;
    }

    /* access modifiers changed from: private */
    /* renamed from: getUwbRemoteObservable$lambda-3  reason: not valid java name */
    public static final void m537getUwbRemoteObservable$lambda3(String str, String str2, String str3, String str4, Subscriber subscriber) {
        ixe.O00000o(str, "$deviceId");
        ixe.O00000o(str2, "$path");
        ixe.O00000o(str3, "$method");
        ixe.O00000o(str4, "$message");
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("did", str);
        jSONObject.put("path", str2);
        jSONObject.put("method", str3);
        jSONObject.put("message", new JSONObject(str4));
        String jSONObject2 = jSONObject.toString();
        ixe.O00000Oo(jSONObject2, "JSONObject().run {\n                put(\"did\", deviceId)\n                put(\"path\", path)\n                put(\"method\", method)\n                put(\"message\", JSONObject(message))\n                toString()\n            }");
        arrayList.add(new KeyValuePair("data", jSONObject2));
        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/remote/ubus").O000000o(arrayList).O000000o(), new UwbMicoPlayerManager$getUwbRemoteObservable$1$1(subscriber));
    }

    public final boolean getMMiplayDisable() {
        return mMiplayDisable;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Boolean]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void initMiplayClientIfNeed() {
        UwbScanDevice uwbScanDevice = mUwbScanDevice;
        if (uwbScanDevice != null) {
            Boolean bool = null;
            Integer valueOf = uwbScanDevice == null ? null : Integer.valueOf(uwbScanDevice.getDeviceType());
            if (valueOf != null && valueOf.intValue() == 1 && !mMiplayDisable) {
                mMiPlayClient = new MiPlayClient(CommonApplication.getAppContext());
                MiPlayClient miPlayClient = mMiPlayClient;
                ixe.O000000o(miPlayClient);
                UwbScanDevice uwbScanDevice2 = mUwbScanDevice;
                ixe.O000000o(uwbScanDevice2);
                MiPlayClientCallBackImpl miPlayClientCallBackImpl = new MiPlayClientCallBackImpl(miPlayClient, uwbScanDevice2);
                MiPlayClient miPlayClient2 = mMiPlayClient;
                if (miPlayClient2 != null) {
                    bool = Boolean.valueOf(miPlayClient2.f6040O000000o.O000000o(miPlayClientCallBackImpl, ""));
                }
                gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtUwbMicoPlayerManager", ixe.O000000o("initMiplayClientIfNeed: initAsync == ", (Object) bool));
            }
        }
    }

    public final void unInitMiplayClientIfNeed() {
        MiPlayClient miPlayClient = mMiPlayClient;
        if (miPlayClient != null) {
            miPlayClient.O000000o();
            MiracastClient miracastClient = miPlayClient.f6040O000000o;
            if (miracastClient.O00000o0 != null) {
                try {
                    miracastClient.O00000o0.unInit(miracastClient.O00000oo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                miracastClient.O00000Oo.unbindService(miracastClient.O0000Oo);
            }
            mMiPlayIsPlaying = true;
        }
        mMiPlayClient = null;
        miplayDeviceLiveData.setValue(null);
        miplayLiveData.setValue(null);
    }

    public final void miplayAudioPlay() {
        MiPlayClient miPlayClient = mMiPlayClient;
        if (miPlayClient != null) {
            String[] strArr = new String[1];
            MiPlayDevice value = miplayDeviceLiveData.getValue();
            strArr[0] = value == null ? null : value.f6039O000000o;
            miPlayClient.f6040O000000o.O000000o(strArr, "", 3);
        }
        mMiPlayIsPlaying = false;
    }

    public final void miplayAudioStop() {
        MiPlayClient miPlayClient = mMiPlayClient;
        if (miPlayClient != null) {
            String[] strArr = new String[1];
            MiPlayDevice value = miplayDeviceLiveData.getValue();
            strArr[0] = value == null ? null : value.f6039O000000o;
            miPlayClient.f6040O000000o.O000000o(strArr);
        }
        mMiPlayIsPlaying = true;
    }

    public final UwbScanDevice getMUwbScanDevice() {
        return mUwbScanDevice;
    }

    public final void setMUwbScanDevice(UwbScanDevice uwbScanDevice) {
        mUwbScanDevice = uwbScanDevice;
    }

    public final void setUwbScanDevice(UwbScanDevice uwbScanDevice) {
        mUwbScanDevice = uwbScanDevice;
    }
}
