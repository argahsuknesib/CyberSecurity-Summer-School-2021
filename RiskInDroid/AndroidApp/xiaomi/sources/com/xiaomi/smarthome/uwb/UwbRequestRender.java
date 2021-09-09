package com.xiaomi.smarthome.uwb;

import _m_j.fax;
import _m_j.frb;
import _m_j.frf;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import _m_j.hcc;
import _m_j.hcc.O000000o;
import _m_j.hcv;
import _m_j.hcz;
import _m_j.hdb;
import _m_j.hdc;
import _m_j.hdg;
import _m_j.hee;
import _m_j.hfa;
import _m_j.itz;
import _m_j.iua;
import _m_j.iui;
import _m_j.iuo;
import _m_j.ixc;
import _m_j.ixe;
import _m_j.iyo;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.miot.localtranslatesrv.LocalTranslateManager;
import com.xiaomi.miot.localtranslatesrv.core.ProfileProperty;
import com.xiaomi.miot.localtranslatesrv.core.SpecProperty;
import com.xiaomi.miot.localtranslatesrv.core.metaDatas.translateStatus;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutor;
import com.xiaomi.miot.localtranslatesrv.database.DatabaseExecutorBuilder;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbRequestApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0004\b\u0002\u0010\u00042\u00020\u00062\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0007:\u0001QB\u0005¢\u0006\u0002\u0010\bJ\b\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020.2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u00100\u001a\u00020 JD\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u00104\u001a\u0004\u0018\u00010$2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u0001062\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0006\u0010;\u001a\u00020\u0013JF\u0010<\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u001a\u00105\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u001f\u0012\u0004\u0012\u000208\u0018\u000106H\u0016J\"\u0010>\u001a\u00020.2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001f2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010B\u001a\u0002032\b\u0010C\u001a\u0004\u0018\u000107H\u0002J\u0006\u0010D\u001a\u00020.J\u0006\u0010E\u001a\u00020.J\u001a\u0010F\u001a\u00020.2\u0006\u0010C\u001a\u00020G2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010H\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0002JS\u0010I\u001a\u00020.2\b\u0010J\u001a\u0004\u0018\u00018\u00012\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010M\u001a\u00028\u00022\b\u0010N\u001a\u0004\u0018\u0001072\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u000208\u0018\u000106H\u0016¢\u0006\u0002\u0010PR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/xiaomi/smarthome/uwb/UwbRequestRender;", "C", "Lcom/xiaomi/smarthome/newui/card/Card;", "E", "T", "Lcom/xiaomi/smarthome/newui/card/Card$CardType;", "Lcom/xiaomi/smarthome/devicesubscribe/BaseDevicePropSubscriber;", "Lcom/xiaomi/smarthome/newui/card/RequestSender;", "()V", "delayTime", "", "getDelayTime", "()J", "setDelayTime", "(J)V", "device", "Lcom/xiaomi/smarthome/device/Device;", "list", "Ljava/util/LinkedList;", "", "getList", "()Ljava/util/LinkedList;", "list$delegate", "Lkotlin/Lazy;", "localTranslateManager", "Lcom/xiaomi/miot/localtranslatesrv/LocalTranslateManager;", "mApi", "Lcom/xiaomi/smarthome/uwb/lib/UwbRequestApi;", "mGetDidRequest", "", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "", "Ljava/lang/Runnable;", "mHandler", "Landroid/os/Handler;", "profileParam", "Lorg/json/JSONArray;", "runn", "getRunn", "()Ljava/lang/Runnable;", "specParam", "", "Lcom/xiaomi/smarthome/device/api/spec/operation/PropertyParam;", "translateRuleDBHelper", "Lcom/xiaomi/smarthome/uwb/TranslateRuleDBHelper;", "destroy", "", "getDid", "runnable", "getProfilePropsFromServer", "queue", "", "param", "asyncCallback", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/frame/Error;", "updatePropValue", "", "getRequestingSize", "getSpecPropsFromServer", "pairs", "init", "subscribedDevices", "impl", "Lcom/xiaomi/smarthome/devicesubscribe/DeviceSubscriberInterface;", "isSuccess", "json", "onCreate", "onDestroy", "putProfileDid", "Lorg/json/JSONObject;", "refreshProps", "sendRequest", "cardItem", "operation", "Lcom/xiaomi/smarthome/newui/card/Operation;", "prop", "value", "callback", "(Lcom/xiaomi/smarthome/newui/card/Card$CardType;Lcom/xiaomi/smarthome/newui/card/Operation;Lcom/xiaomi/smarthome/device/Device;Ljava/lang/Object;Ljava/lang/Object;Lcom/xiaomi/smarthome/frame/AsyncCallback;)V", "Companion", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> extends frb implements hdg<C, E, T> {
    public static final Companion Companion = new Companion(null);
    private long delayTime;
    public Device device;
    private final itz list$delegate = iua.O000000o(UwbRequestRender$list$2.INSTANCE);
    public LocalTranslateManager localTranslateManager = new LocalTranslateManager();
    private UwbRequestApi mApi = new UwbRequestApi(CommonApplication.getAppContext());
    public final Map<UwbScanDevice, List<Runnable>> mGetDidRequest = new LinkedHashMap();
    public Handler mHandler = new Handler();
    private JSONArray profileParam;
    private final Runnable runn = new UwbRequestRender$runn$1(this);
    public List<? extends PropertyParam> specParam;
    private TranslateRuleDBHelper translateRuleDBHelper;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/UwbRequestRender$Companion;", "", "()V", "TAG", "", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final void setDelayTime(long j) {
        this.delayTime = j;
    }

    public final LinkedList<Integer> getList() {
        return (LinkedList) this.list$delegate.O000000o();
    }

    public final void onCreate() {
        this.translateRuleDBHelper = new TranslateRuleDBHelper(CommonApplication.getAppContext());
        this.localTranslateManager.setDataBaseBuilder(new DatabaseExecutorBuilder() {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$tajRsZbXPgqH4wqLFzdGgvsRXXc */

            public final DatabaseExecutor createExecutor() {
                return UwbRequestRender.m513onCreate$lambda0(UwbRequestRender.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final DatabaseExecutor m513onCreate$lambda0(UwbRequestRender uwbRequestRender) {
        ixe.O00000o(uwbRequestRender, "this$0");
        return uwbRequestRender.translateRuleDBHelper;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, _m_j.hdb]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void sendRequest(E e, hdb hdb, Device device2, T t, Object obj, fsm<JSONObject, fso> fsm) {
        UwbLogUtil.d("UwbRequestRender", ixe.O000000o("sendRequest ", (Object) hdb));
        getDid(device2, new Runnable(t, device2, hdb, e, obj, this, fsm) {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$iWow8ZrxfEcDRZZh0Mp14DCEJw0 */
            private final /* synthetic */ Object f$0;
            private final /* synthetic */ Device f$1;
            private final /* synthetic */ hdb f$2;
            private final /* synthetic */ hcc.O000000o f$3;
            private final /* synthetic */ Object f$4;
            private final /* synthetic */ UwbRequestRender f$5;
            private final /* synthetic */ fsm f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void run() {
                UwbRequestRender.m514sendRequest$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02dd A[Catch:{ Throwable -> 0x033e }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e1 A[Catch:{ Throwable -> 0x033e }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02e7 A[Catch:{ Throwable -> 0x033e }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02e9 A[Catch:{ Throwable -> 0x033e }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02ed A[Catch:{ Throwable -> 0x033e }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02ef A[Catch:{ Throwable -> 0x033e }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02f6 A[Catch:{ Throwable -> 0x033e }] */
    /* renamed from: sendRequest$lambda-1  reason: not valid java name */
    public static final void m514sendRequest$lambda1(Object obj, Device device2, hdb hdb, hcc.O000000o o000000o, Object obj2, UwbRequestRender uwbRequestRender, fsm fsm) {
        Ref.ObjectRef objectRef;
        String str;
        Object obj3;
        String str2;
        hcc.O000000o o000000o2;
        hee hee;
        Object O000000o2;
        String str3;
        String str4;
        boolean z;
        T t;
        String str5;
        String str6;
        Object obj4 = obj;
        Device device3 = device2;
        hdb hdb2 = hdb;
        hcc.O000000o o000000o3 = o000000o;
        Object obj5 = obj2;
        UwbRequestRender uwbRequestRender2 = uwbRequestRender;
        ixe.O00000o(uwbRequestRender2, "this$0");
        try {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            JSONObject jSONObject = new JSONObject();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            String str7 = "";
            if (obj4 instanceof Spec.SpecItem) {
                objectRef2.element = hfa.O000000o(hcz.getInstance().getSpecInstance(device3), hdb2);
                Ref.BooleanRef booleanRef2 = booleanRef;
                if (objectRef2.element != null) {
                    if (o000000o3 == null) {
                        t = null;
                    } else {
                        t = o000000o3.O00000Oo(device3, obj4);
                    }
                    objectRef3.element = t;
                    SpecProperty specProperty = new SpecProperty();
                    objectRef = objectRef3;
                    specProperty.setServiceInstanceId(Spec.getIid((Spec) objectRef2.element, 1));
                    if (device3 == null) {
                        str5 = null;
                    } else {
                        str5 = device3.model;
                    }
                    specProperty.setModel(str5);
                    if (device3 == null) {
                        str6 = null;
                    } else {
                        str6 = device3.did;
                    }
                    specProperty.setDeviceInstanceId(str6);
                    specProperty.setPropActionEventId(Spec.getIid((Spec) objectRef2.element, 0));
                    specProperty.setValue(obj5);
                    ProfileProperty actionSpecToProfile = uwbRequestRender2.localTranslateManager.actionSpecToProfile(device3 == null ? null : device3.did, specProperty);
                    if (actionSpecToProfile.getStatus() == translateStatus.TRANSLATE_SUCCESS.getValue()) {
                        if (!TextUtils.isEmpty(actionSpecToProfile.getSpecialSetMethod())) {
                            jSONObject.put("method", actionSpecToProfile.getSpecialSetMethod());
                        } else {
                            jSONObject.put("method", actionSpecToProfile.getName());
                        }
                        jSONObject.put("params", actionSpecToProfile.getValue());
                        uwbRequestRender2.putProfileDid(jSONObject, device3);
                        LogType logType = LogType.PLUGIN;
                        gsy.O00000o0(logType, "UwbRequestRender", "sendRequest translate action " + obj4 + ' ' + obj5 + ' ' + jSONObject);
                    } else {
                        jSONObject.put("method", "action");
                        JSONObject put = new JSONObject().put("did", device3 == null ? null : device3.did).put("aiid", Spec.getIid((Spec) objectRef2.element, 0)).put("siid", Spec.getIid((Spec) objectRef2.element, 1)).put("in", new JSONArray());
                        int iid = Spec.getIid((Spec) objectRef2.element, 2);
                        if (iid > 0) {
                            put.put("miid", iid);
                        }
                        jSONObject.put("params", put);
                        LogType logType2 = LogType.PLUGIN;
                        gsy.O00000o0(logType2, "UwbRequestRender", "sendRequest Action " + ((Object) objectRef2.element) + ' ' + jSONObject);
                    }
                    hcc.O000000o o000000o4 = o000000o;
                    booleanRef = booleanRef2;
                } else {
                    objectRef = objectRef3;
                    SpecProperty specProperty2 = new SpecProperty();
                    specProperty2.setServiceInstanceId(Spec.getIid((Spec) obj4, 1));
                    if (device3 == null) {
                        str3 = null;
                    } else {
                        str3 = device3.model;
                    }
                    specProperty2.setModel(str3);
                    if (device3 == null) {
                        str4 = null;
                    } else {
                        str4 = device3.did;
                    }
                    specProperty2.setDeviceInstanceId(str4);
                    specProperty2.setPropActionEventId(Spec.getIid((Spec) obj4, 0));
                    specProperty2.setValue(obj5);
                    ProfileProperty propSpecToProfile = uwbRequestRender2.localTranslateManager.propSpecToProfile(device3 == null ? null : device3.did, specProperty2);
                    if (propSpecToProfile.getStatus() == translateStatus.TRANSLATE_SUCCESS.getValue()) {
                        if (propSpecToProfile.getSpecialSetMethod() != null) {
                            if (!ixe.O000000o((Object) str7, (Object) propSpecToProfile.getSpecialSetMethod())) {
                                jSONObject.put("method", propSpecToProfile.getSpecialSetMethod());
                                jSONObject.put("params", propSpecToProfile.getValue());
                                uwbRequestRender2.putProfileDid(jSONObject, device3);
                                LogType logType3 = LogType.PLUGIN;
                                gsy.O00000o0(logType3, "UwbRequestRender", "sendRequest translate property " + obj4 + ' ' + obj5 + ' ' + jSONObject);
                            }
                        }
                        jSONObject.put("method", ixe.O000000o("set_", (Object) propSpecToProfile.getName()));
                        jSONObject.put("params", propSpecToProfile.getValue());
                        uwbRequestRender2.putProfileDid(jSONObject, device3);
                        LogType logType32 = LogType.PLUGIN;
                        gsy.O00000o0(logType32, "UwbRequestRender", "sendRequest translate property " + obj4 + ' ' + obj5 + ' ' + jSONObject);
                    } else {
                        jSONObject.put("method", "set_properties");
                        JSONObject put2 = new JSONObject().put("did", device3 == null ? null : device3.did).put("piid", Spec.getIid((Spec) obj4, 0)).put("siid", Spec.getIid((Spec) obj4, 1));
                        put2.put("value", obj5);
                        int iid2 = Spec.getIid((Spec) obj4, 2);
                        if (iid2 > 0) {
                            put2.put("miid", iid2);
                        }
                        jSONObject.put("params", new JSONArray().put(put2));
                        LogType logType4 = LogType.PLUGIN;
                        gsy.O00000o0(logType4, "UwbRequestRender", "sendRequest setSpec " + obj4 + ' ' + jSONObject);
                    }
                    if (ixe.O000000o(obj5, hcz.getInstance().notifyPropChangedListener(device3 == null ? null : device3.did, fax.O000000o((Spec.SpecItem) obj4), obj5, (byte) 1))) {
                        com.xiaomi.smarthome.device.api.spec.instance.SpecProperty specProperty3 = obj4 instanceof com.xiaomi.smarthome.device.api.spec.instance.SpecProperty ? (com.xiaomi.smarthome.device.api.spec.instance.SpecProperty) obj4 : null;
                        PropertyDefinition propertyDefinition = specProperty3 == null ? null : specProperty3.getPropertyDefinition();
                        if (propertyDefinition == null ? true : propertyDefinition.readable()) {
                            booleanRef = booleanRef2;
                            z = true;
                            booleanRef.element = z;
                            hcc.O000000o o000000o5 = o000000o;
                        }
                    }
                    booleanRef = booleanRef2;
                    z = false;
                    booleanRef.element = z;
                    hcc.O000000o o000000o52 = o000000o;
                }
            } else {
                objectRef = objectRef3;
                if (hdb2 == null) {
                    str = null;
                } else {
                    str = hdb2.O00000o;
                }
                jSONObject.put("method", str);
                uwbRequestRender2.putProfileDid(jSONObject, device3);
                if (hdb2 != null) {
                    hdc hdc = hdb2.O00000oO;
                    if (hdc != null) {
                        obj3 = hdc.O000000o(obj5);
                        jSONObject.put("params", obj3);
                        LogType logType5 = LogType.PLUGIN;
                        gsy.O00000o0(logType5, "UwbRequestRender", "sendRequest setProfile " + obj4 + ' ' + jSONObject);
                        hcv instance = hcv.getInstance();
                        if (device3 != null) {
                            o000000o2 = o000000o;
                            str2 = null;
                        } else {
                            str2 = device3.did;
                            o000000o2 = o000000o;
                        }
                        String str8 = o000000o2 != null ? null : o000000o2.O00000o0;
                        hee = o000000o2 != null ? null : o000000o2.O00000oo;
                        if (hee != null) {
                            hdc hdc2 = hee.O0000Oo;
                            if (hdc2 != null) {
                                O000000o2 = hdc2.O000000o(obj5, (List<Object>) null);
                                instance.notifyPropChangedListener(str2, str8, O000000o2, (byte) 1);
                            }
                        }
                        O000000o2 = null;
                        instance.notifyPropChangedListener(str2, str8, O000000o2, (byte) 1);
                    }
                }
                obj3 = null;
                jSONObject.put("params", obj3);
                LogType logType52 = LogType.PLUGIN;
                gsy.O00000o0(logType52, "UwbRequestRender", "sendRequest setProfile " + obj4 + ' ' + jSONObject);
                hcv instance2 = hcv.getInstance();
                if (device3 != null) {
                }
                if (o000000o2 != null) {
                }
                if (o000000o2 != null) {
                }
                if (hee != null) {
                }
                O000000o2 = null;
                instance2.notifyPropChangedListener(str2, str8, O000000o2, (byte) 1);
            }
            if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
                str7 = jSONObject.toString();
                ixe.O00000Oo(str7, "json.toString()");
            }
            UwbLogUtil.d("UwbRequestRender", ixe.O000000o("sendRequest will start really ", (Object) str7));
            uwbRequestRender2.mApi.request(false, jSONObject, new UwbRequestRender$sendRequest$1$1(obj, objectRef2, device2, fsm, uwbRequestRender, booleanRef, obj2, o000000o, objectRef));
        } catch (Throwable th) {
            gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("sendRequest catch ", (Object) Log.getStackTraceString(th)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.Object]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final boolean isSuccess(Object obj) {
        while (true) {
            if (!(obj instanceof JSONArray)) {
                if (!(obj instanceof JSONObject)) {
                    break;
                }
                JSONObject jSONObject = (JSONObject) obj;
                Object opt = jSONObject.opt("result");
                obj = (opt == null && (opt = jSONObject.opt("error")) == null) ? jSONObject.opt("code") : opt;
            } else {
                obj = ((JSONArray) obj).opt(0);
            }
        }
        if (obj instanceof String) {
            if (ixe.O000000o((Object) "ok", obj) || ixe.O000000o((Object) "success", obj) || ixe.O000000o((Object) "true", obj) || ixe.O000000o((Object) "0", obj)) {
                return true;
            }
            return false;
        } else if (obj instanceof Number) {
            return ixe.O000000o(obj, (Object) 0);
        } else {
            return true;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean */
    private final void putProfileDid(JSONObject jSONObject, Device device2) {
        String str;
        String str2 = null;
        if (ixe.O000000o((device2 == null || (str = device2.did) == null) ? null : Boolean.valueOf(iyo.O000000o(str, "lumi.", false)), Boolean.TRUE)) {
            if (device2 != null) {
                str2 = device2.did;
            }
            jSONObject.put("sid", str2);
        }
    }

    public final void getProfilePropsFromServer(boolean z, Device device2, JSONArray jSONArray, fsm<Object, fso> fsm, String str) {
        this.device = device2;
        this.profileParam = jSONArray;
        if (jSONArray != null && jSONArray.length() != 0) {
            getDid(device2, new Runnable(this, device2, z, fsm) {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$c_imqhyrRjwbI3zEKIRFx55HSU */
                private final /* synthetic */ UwbRequestRender f$1;
                private final /* synthetic */ Device f$2;
                private final /* synthetic */ boolean f$3;
                private final /* synthetic */ fsm f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    UwbRequestRender.m501getProfilePropsFromServer$lambda7(JSONArray.this, this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, io.reactivex.disposables.Disposable]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: getProfilePropsFromServer$lambda-7  reason: not valid java name */
    public static final void m501getProfilePropsFromServer$lambda7(JSONArray jSONArray, UwbRequestRender uwbRequestRender, Device device2, boolean z, fsm fsm) {
        ixe.O00000o(uwbRequestRender, "this$0");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(Observable.create(new ObservableOnSubscribe(i, uwbRequestRender, device2, z) {
                        /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$cBtRv1YMOkGv4GrRcG7EN3sIzqg */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ UwbRequestRender f$2;
                        private final /* synthetic */ Device f$3;
                        private final /* synthetic */ boolean f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void subscribe(ObservableEmitter observableEmitter) {
                            UwbRequestRender.m502getProfilePropsFromServer$lambda7$lambda2(JSONArray.this, this.f$1, this.f$2, this.f$3, this.f$4, observableEmitter);
                        }
                    }));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("getProfilePropsFromServer subscribe ", (Object) Observable.zip(arrayList, $$Lambda$UwbRequestRender$9kRJfq_4BBnzX37eG8GdnuSumJE.INSTANCE).subscribe(new Consumer(fsm) {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$9kxLYOKHfKS3FyhXLdgVW9ag6w8 */
                private final /* synthetic */ fsm f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    UwbRequestRender.m504getProfilePropsFromServer$lambda7$lambda5(JSONArray.this, this.f$1, (JSONArray) obj);
                }
            }, new Consumer() {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$_bVuLHUiX46tsNq2IcT7uRPKBqc */

                public final void accept(Object obj) {
                    UwbRequestRender.m505getProfilePropsFromServer$lambda7$lambda6(fsm.this, (Throwable) obj);
                }
            })));
        } catch (Throwable th) {
            gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("getProfilePropsFromServer catch ", (Object) Log.getStackTraceString(th)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getProfilePropsFromServer$lambda-7$lambda-2  reason: not valid java name */
    public static final void m502getProfilePropsFromServer$lambda7$lambda2(JSONArray jSONArray, int i, UwbRequestRender uwbRequestRender, Device device2, boolean z, ObservableEmitter observableEmitter) {
        ixe.O00000o(uwbRequestRender, "this$0");
        ixe.O00000o(observableEmitter, "it");
        JSONObject optJSONObject = jSONArray.optJSONObject(i);
        ixe.O00000Oo(optJSONObject, "requestItem");
        uwbRequestRender.putProfileDid(optJSONObject, device2);
        uwbRequestRender.mApi.request(z, optJSONObject, new UwbRequestRender$getProfilePropsFromServer$1$1$1(optJSONObject, observableEmitter));
    }

    /* access modifiers changed from: private */
    /* renamed from: getProfilePropsFromServer$lambda-7$lambda-4  reason: not valid java name */
    public static final JSONArray m503getProfilePropsFromServer$lambda7$lambda4(Object[] objArr) {
        ixe.O00000o(objArr, "list");
        JSONArray jSONArray = new JSONArray();
        for (Object put : objArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, org.json.JSONArray]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: getProfilePropsFromServer$lambda-7$lambda-5  reason: not valid java name */
    public static final void m504getProfilePropsFromServer$lambda7$lambda5(JSONArray jSONArray, fsm fsm, JSONArray jSONArray2) {
        int i;
        int length = jSONArray2.length();
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                JSONArray optJSONArray = optJSONObject.optJSONArray("props");
                JSONArray optJSONArray2 = jSONArray2.optJSONObject(i2).optJSONArray("result");
                if (optJSONArray == null) {
                    i = 0;
                } else {
                    i = optJSONArray.length();
                }
                if (i > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        hcv instance = hcv.getInstance();
                        String optString = optJSONObject.optString("did");
                        Object obj = null;
                        String optString2 = optJSONArray == null ? null : optJSONArray.optString(i4);
                        if (optJSONArray2 != null) {
                            obj = optJSONArray2.opt(i4);
                        }
                        instance.notifyPropChangedListener(optString, optString2, obj, (byte) 5);
                        if (i5 >= i) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        if (fsm != null) {
            fsm.sendSuccessMessage(jSONArray2);
        }
        gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("getProfilePropsFromServer sendSuccessMessage ", (Object) jSONArray2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Throwable]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: getProfilePropsFromServer$lambda-7$lambda-6  reason: not valid java name */
    public static final void m505getProfilePropsFromServer$lambda7$lambda6(fsm fsm, Throwable th) {
        if (fsm != null) {
            fsm.sendFailureMessage(new fso(-1, th.getMessage()));
        }
        gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("getProfilePropsFromServer sendFailureMessage ", (Object) th));
    }

    public final void getSpecPropsFromServer(boolean z, Device device2, List<? extends PropertyParam> list, fsm<List<PropertyParam>, fso> fsm) {
        this.device = device2;
        this.specParam = list;
        if (list != null && list.size() != 0) {
            getDid(device2, new Runnable(list, device2, this, z, fsm) {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$NaBR0nfY_5KN4JCWxkihQMl71w */
                private final /* synthetic */ List f$0;
                private final /* synthetic */ Device f$1;
                private final /* synthetic */ UwbRequestRender f$2;
                private final /* synthetic */ boolean f$3;
                private final /* synthetic */ fsm f$4;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    UwbRequestRender.m506getSpecPropsFromServer$lambda13(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: getSpecPropsFromServer$lambda-13  reason: not valid java name */
    public static final void m506getSpecPropsFromServer$lambda13(List list, Device device2, UwbRequestRender uwbRequestRender, boolean z, fsm fsm) {
        ixe.O00000o(uwbRequestRender, "this$0");
        try {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(Observable.create(new ObservableOnSubscribe(list, i, device2, uwbRequestRender, z) {
                        /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$RGHSgFhoz9uTDzsxq2k_N5akeHo */
                        private final /* synthetic */ List f$0;
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ Device f$2;
                        private final /* synthetic */ UwbRequestRender f$3;
                        private final /* synthetic */ boolean f$4;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void subscribe(ObservableEmitter observableEmitter) {
                            UwbRequestRender.m509getSpecPropsFromServer$lambda13$lambda8(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, observableEmitter);
                        }
                    }));
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            }
            Disposable subscribe = Observable.zip(arrayList, $$Lambda$UwbRequestRender$Oyu8cQp9f9zZHodevRTP_Q8xO5k.INSTANCE).subscribe(new Consumer(device2) {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$RBuEMxrf6bp2y6jlpZM6tFDS84s */
                private final /* synthetic */ Device f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    UwbRequestRender.m507getSpecPropsFromServer$lambda13$lambda11(fsm.this, this.f$1, (List) obj);
                }
            }, new Consumer() {
                /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$cX1b3TGHmStD5oSGKsS20_TFMHk */

                public final void accept(Object obj) {
                    UwbRequestRender.m508getSpecPropsFromServer$lambda13$lambda12(fsm.this, (Throwable) obj);
                }
            });
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "UwbRequestRender", "getSpecPropsFromServer subscribe " + arrayList.size() + ' ' + subscribe);
        } catch (Throwable th) {
            gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("getSpecPropsFromServer catch ", (Object) Log.getStackTraceString(th)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, org.json.JSONObject]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: getSpecPropsFromServer$lambda-13$lambda-8  reason: not valid java name */
    public static final void m509getSpecPropsFromServer$lambda13$lambda8(List list, int i, Device device2, UwbRequestRender uwbRequestRender, boolean z, ObservableEmitter observableEmitter) {
        String str;
        String str2;
        String str3;
        ixe.O00000o(uwbRequestRender, "this$0");
        ixe.O00000o(observableEmitter, "it");
        PropertyParam propertyParam = (PropertyParam) list.get(i);
        JSONObject jSONObject = new JSONObject();
        SpecProperty specProperty = new SpecProperty();
        specProperty.setServiceInstanceId(propertyParam.getSiid());
        String str4 = null;
        if (device2 == null) {
            str = null;
        } else {
            str = device2.model;
        }
        specProperty.setModel(str);
        if (device2 == null) {
            str2 = null;
        } else {
            str2 = device2.did;
        }
        specProperty.setDeviceInstanceId(str2);
        specProperty.setPropActionEventId(propertyParam.getPiid());
        ProfileProperty propSpecToProfile = uwbRequestRender.localTranslateManager.propSpecToProfile(device2 == null ? null : device2.did, specProperty);
        if (propSpecToProfile.getStatus() == translateStatus.TRANSLATE_SUCCESS.getValue()) {
            if (propSpecToProfile.getSpecialGetMethod() == null || ixe.O000000o((Object) "", (Object) propSpecToProfile.getSpecialGetMethod())) {
                jSONObject.put("method", "get_prop");
            } else {
                jSONObject.put("method", propSpecToProfile.getSpecialGetMethod());
            }
            jSONObject.put("params", new JSONArray().put(propSpecToProfile.getName()));
            uwbRequestRender.putProfileDid(jSONObject, device2);
            gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("sendRequest translate ", (Object) jSONObject));
        } else {
            if (device2 == null) {
                str3 = null;
            } else {
                str3 = device2.did;
            }
            jSONObject.put("did", str3);
            jSONObject.put("method", "get_properties");
            JSONObject jSONObject2 = new JSONObject();
            if (device2 != null) {
                str4 = device2.did;
            }
            JSONObject put = jSONObject2.put("did", str4).put("piid", propertyParam.getPiid()).put("siid", propertyParam.getSiid());
            if (propertyParam.getMiid() > 0) {
                put.put("miid", propertyParam.getMiid());
            }
            jSONObject.put("params", new JSONArray().put(put));
            gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("sendRequest getSpec ", (Object) jSONObject));
        }
        uwbRequestRender.mApi.request(z, jSONObject, new UwbRequestRender$getSpecPropsFromServer$1$1$1(propSpecToProfile, uwbRequestRender, device2, propertyParam, jSONObject, observableEmitter));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSpecPropsFromServer$lambda-13$lambda-9  reason: not valid java name */
    public static final List m510getSpecPropsFromServer$lambda13$lambda9(Object[] objArr) {
        ixe.O00000o(objArr, "it");
        ixe.O00000o0(objArr, "receiver$0");
        ixe.O00000o0(objArr, "receiver$0");
        return new ArrayList(new iui(objArr, false));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSpecPropsFromServer$lambda-13$lambda-11  reason: not valid java name */
    public static final void m507getSpecPropsFromServer$lambda13$lambda11(fsm fsm, Device device2, List list) {
        ixe.O00000Oo(list, "it");
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            PropertyParam propertyParam = (PropertyParam) it.next();
            if (propertyParam.getResultCode() == 0) {
                hcz.getInstance().notifyPropChangedListener(device2 == null ? null : device2.did, fax.O000000o(propertyParam.getMiid(), propertyParam.getSiid(), propertyParam.getPiid()), propertyParam.getValue(), (byte) 5);
            } else {
                z = false;
            }
        }
        if (z) {
            if (fsm != null) {
                fsm.sendSuccessMessage(list);
            }
        } else if (fsm != null) {
            fsm.sendFailureMessage(new fso(-1, list.toString()));
        }
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "UwbRequestRender", "getSpecPropsFromServer sendSuccessMessage " + z + ' ' + list);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* renamed from: getSpecPropsFromServer$lambda-13$lambda-12  reason: not valid java name */
    public static final void m508getSpecPropsFromServer$lambda13$lambda12(fsm fsm, Throwable th) {
        if (fsm != null) {
            fsm.sendFailureMessage(new fso(-1, th.getMessage()));
        }
        gsy.O00000o0(LogType.PLUGIN, "UwbRequestRender", ixe.O000000o("getSpecPropsFromServer sendFailureMessage ", (Object) Log.getStackTraceString(th)));
    }

    public final void getDid(Device device2, Runnable runnable) {
        ixe.O00000o(runnable, "runnable");
        if (device2 instanceof UwbDevice) {
            UwbDevice uwbDevice = (UwbDevice) device2;
            if (TextUtils.isEmpty(uwbDevice.did)) {
                JSONObject put = new JSONObject().put("m", "get_did");
                List list = this.mGetDidRequest.get(uwbDevice.getUwbDevice());
                if (list == null || list.size() == 0) {
                    this.mGetDidRequest.put(uwbDevice.getUwbDevice(), iuo.O00000Oo(runnable));
                    this.mApi.request(false, put, UwbConst.Target.SEND_DATA_TO_TAG, new UwbRequestRender$getDid$1(device2, this));
                    return;
                }
                list.add(runnable);
                UwbLogUtil.d("UwbRequestRender", "runnables getDid " + device2 + " added");
                return;
            }
        }
        runnable.run();
    }

    public final int getRequestingSize() {
        return this.mApi.getRequestingSize();
    }

    public final void onDestroy() {
        this.mApi.destroy();
        TranslateRuleDBHelper translateRuleDBHelper2 = this.translateRuleDBHelper;
        if (translateRuleDBHelper2 != null) {
            translateRuleDBHelper2.closeConnection();
        }
    }

    public final Runnable getRunn() {
        return this.runn;
    }

    public final void refreshProps(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONArray jSONArray = this.profileParam;
        if (jSONArray != null) {
            getProfilePropsFromServer(z, this.device, jSONArray, new UwbRequestRender$refreshProps$1(this, currentTimeMillis), "updatePropValue");
            return;
        }
        List<? extends PropertyParam> list = this.specParam;
        if (list != null) {
            getSpecPropsFromServer(z, this.device, list, new UwbRequestRender$refreshProps$2(this, currentTimeMillis));
        }
    }

    public final void init(List<Device> list, frf frf) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.runn);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.postDelayed(this.runn, 1000);
        }
    }

    public final void destroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.runn);
        }
        this.mHandler = null;
    }
}
