package _m_j;

import _m_j.hcc;
import _m_j.hcd;
import _m_j.hcv;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.newui.card.DeviceCardApi;
import com.xiaomi.smarthome.service.CardActive;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class hcv extends hcd implements fba {
    private static final hcv INSTANCE = new hcv();
    public ArrayMap<String, heb> mAllCardInfo = new ArrayMap<>();
    private final AppConfigHelper mAppConfigHelper;
    private fbf mClientDeviceListener = new fbf() {
        /* class _m_j.hcv.AnonymousClass1 */

        public final void O000000o(int i) {
            gsy.O000000o(6, "mijia-card", "onRefreshClientDeviceSuccess type:" + i + "  ");
            if (i == 3 && fcn.O000000o().O0000OOo()) {
                hcv.this.loadPropsFromServer(true, null, "onRefreshClientDeviceSuccess");
            }
        }
    };
    private frb mDevicePropSubscriber;
    public boolean mHasParseCompleteData = false;
    private Set<O000000o> mListener = new HashSet();
    private final Object mLock = new Object();
    private AtomicBoolean mTdsBatchLoading = new AtomicBoolean(false);
    private ArrayMap<String, Boolean> mTdsLoadCache = new ArrayMap<>();
    public O00000Oo mWorkerHandler;

    public interface O000000o {
    }

    @cug
    public static hcv provideInstance() {
        return INSTANCE;
    }

    public static hcv getInstance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    private hcv() {
        if (gfr.O0000OOo || gfr.O0000Oo) {
            gfr.O0000oo = gpy.O00000o0(CommonApplication.getAppContext(), "appconfig_cache", "debug_spec_preview_appconfig", false);
        }
        gpq gpq = new gpq("ControlCardInfoManager");
        gpq.start();
        this.mWorkerHandler = new O00000Oo(gpq.getLooper());
        Context appContext = CommonApplication.getAppContext();
        this.mAppConfigHelper = new AppConfigHelper(appContext);
        if (appContext != null) {
            ft.O000000o(appContext).O000000o(new BroadcastReceiver() {
                /* class _m_j.hcv.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    hcv.this.mWorkerHandler.post(new Runnable() {
                        /* class _m_j.$$Lambda$hcv$2$qbsvgnpVwYIriWZWZnUb1hsnHG8 */

                        public final void run() {
                            hcv.AnonymousClass2.this.O000000o();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    if (!hcv.this.mHasParseCompleteData) {
                        hcv.this.mWorkerHandler.sendEmptyMessage(100);
                    }
                }
            }, new IntentFilter("ACTION_APP_HAS_ENTERED_FOREGROUND"));
            fbd.O000000o().registerDeviceRefreshListener(this.mClientDeviceListener);
            gsy.O000000o(4, "mijia-card", "constructor ControlCardInfoManager:" + this + " ProfileCardVersion:8");
            init();
        }
    }

    class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            String str;
            boolean z;
            super.handleMessage(message);
            if (CommonApplication.getAppContext() != null) {
                int i = message.what;
                if (i == 100) {
                    gsy.O00000Oo("mijia-card", "ControlCardInfoManager.handleMessage refresh");
                    hcv.this.loadPropsFromLocal();
                    hcv.this.loadConfigFromServer();
                } else if (i == 201) {
                    gsy.O00000Oo("mijia-card", "ControlCardInfoManager.handleMessage loadprops");
                    fsm fsm = null;
                    if (message.obj == null || Array.getLength(message.obj) != 3) {
                        str = null;
                        z = true;
                    } else {
                        z = ((Boolean) ((Object[]) message.obj)[0]).booleanValue();
                        fsm = (fsm) ((Object[]) message.obj)[1];
                        str = (String) ((Object[]) message.obj)[2];
                    }
                    hcv.this.loadPropsFromServer(fsm, str);
                    if (z) {
                        hcv.this.subscribeGridProp();
                    }
                }
            }
        }
    }

    public heb getCardInfo(String str) {
        if (gfr.O0000oo) {
            return null;
        }
        return this.mAllCardInfo.get(str);
    }

    public String getCardIconPath(String str) {
        return hcz.getInstance().getCardIconPath(str);
    }

    public void init() {
        this.mWorkerHandler.sendEmptyMessage(100);
    }

    public void loadConfigFromServer() {
        this.mAppConfigHelper.O000000o("card_control_config", "13", "zh_CN", "cardControl/configDes.json", new AppConfigHelper.O00000Oo() {
            /* class _m_j.hcv.AnonymousClass3 */

            public final boolean O000000o(String str) throws Exception {
                if (!AppConfigHelper.O000000o(str)) {
                    return false;
                }
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    return false;
                }
                hcv.this.mAllCardInfo.clear();
                hcv.this.mAllCardInfo.putAll(hcv.this.parseConfigData(jSONArray));
                hcv.this.dispatchOnCardInfo();
                gsy.O00000Oo("mijia-card", "ControlCardInfoManager.loadConfigFromServer processCache mAllCardInfo.size:" + hcv.this.mAllCardInfo.size());
                return true;
            }

            public final boolean O00000Oo(String str) throws Exception {
                return O000000o(str);
            }
        }, new AppConfigHelper.O000000o() {
            /* class _m_j.hcv.AnonymousClass4 */

            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                try {
                    if (AppConfigHelper.O000000o(str)) {
                        JSONArray jSONArray = new JSONArray(str);
                        if (jSONArray.length() != 0) {
                            hcv.this.mAllCardInfo.clear();
                            hcv.this.mAllCardInfo.putAll(hcv.this.parseConfigData(jSONArray));
                            gsy.O00000Oo("mijia-card", "ControlCardInfoManager.loadConfigFromServer onSuccess mAllCardInfo.size:" + hcv.this.mAllCardInfo.size());
                            hcv.this.dispatchOnCardInfo();
                        }
                    }
                } catch (Exception e) {
                    gsy.O000000o(6, "mijia-card", Log.getStackTraceString(e));
                }
                hcv.this.loadPropsFromServer(true, null, "processResponse");
                hcv.this.noticeMinusCard();
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                hcv.this.dispatchOnCardInfo();
                hcv.this.noticeMinusCard();
                gsy.O000000o(6, "mijia-card", "ControlCardInfoManager.loadConfigFromServer onFailure");
            }
        });
    }

    public Map<String, heb> parseConfigData(JSONArray jSONArray) {
        boolean z;
        List list;
        boolean z2;
        String str;
        ArrayList arrayList;
        int i;
        JSONArray jSONArray2 = jSONArray;
        ArrayMap arrayMap = new ArrayMap();
        new ArrayMap();
        if (!(jSONArray2 == null || jSONArray.length() == 0)) {
            int i2 = 0;
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                int i4 = -1;
                ArrayList<hed> arrayList2 = new ArrayList<>();
                List arrayList3 = new ArrayList();
                JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
                if (optJSONObject != null) {
                    ArrayList<String> arrayList4 = new ArrayList<>();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("models");
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        arrayList4.add(optJSONArray.optString(i5));
                    }
                    ArrayMap arrayMap2 = new ArrayMap();
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("props");
                    if (optJSONArray2 != null) {
                        for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                            hee O000000o2 = hee.O000000o(optJSONArray2.optJSONObject(i6));
                            if (O000000o2.f18836O000000o != null) {
                                arrayMap2.put(O000000o2.f18836O000000o, O000000o2);
                            }
                        }
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("cards");
                    if (optJSONObject2 != null) {
                        i4 = optJSONObject2.optInt("layout_type");
                        boolean z3 = optJSONObject2.optInt("lowPower", i2) == 1;
                        String optString = optJSONObject2.optString("min_firmware_version");
                        boolean z4 = optJSONObject2.optInt("need_ble_parse", 1) == 1;
                        if (optJSONObject2.optInt("min_support_version", i2) <= 8) {
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("card_items");
                            if (optJSONArray3 != null) {
                                arrayList2.addAll(parseCardItem(arrayMap2, optJSONArray3));
                            }
                            for (hed hed : arrayList2) {
                                if (hed.O0000o0 != 0) {
                                    arrayList3.add(hed);
                                }
                            }
                            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("grid_items");
                            if (optJSONArray4 != null) {
                                arrayList3 = parseCardItem(arrayMap2, optJSONArray4);
                                gsy.O00000Oo("mijia-card", "ControlCardInfoManager.parse gridCardItems model:" + arrayList4 + " gridCardItems.size:" + arrayList3.size());
                            }
                            list = arrayList3;
                            z2 = z3;
                            str = optString;
                            z = z4;
                        } else {
                            gsy.O000000o(6, "mijia-card", "8 current version not support  model:".concat(String.valueOf(arrayList4)));
                        }
                    } else {
                        str = "";
                        list = arrayList3;
                        z2 = false;
                        z = true;
                    }
                    for (String str2 : arrayList4) {
                        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
                            Iterator<Device> it = fbd.O000000o().getAllDevices().values().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (TextUtils.equals(it.next().getModel(), str2)) {
                                        i = i3;
                                        heb heb = r6;
                                        arrayList = arrayList2;
                                        heb heb2 = new heb(i4, z2, str, z, arrayList2, list);
                                        arrayMap.put(str2, heb);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            i = i3;
                            arrayList = arrayList2;
                            this.mHasParseCompleteData = true;
                            heb heb3 = r6;
                            heb heb4 = new heb(i4, z2, str, z, arrayList, list);
                            arrayMap.put(str2, heb3);
                        }
                        i3 = i;
                        arrayList2 = arrayList;
                    }
                }
                i3++;
                jSONArray2 = jSONArray;
                i2 = 0;
            }
        }
        return arrayMap;
    }

    private List<hed> parseCardItem(Map<String, hee> map, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(hed.O000000o(map, jSONArray.optJSONObject(i)));
            }
            if (arrayList.size() == 0) {
                arrayList.add(new hed(map, new JSONObject()));
            }
        }
        return arrayList;
    }

    public JSONArray getPropsParams(Device device) {
        JSONArray jSONArray = new JSONArray();
        if (device != null) {
            try {
                heb cardInfo = getCardInfo(device.model);
                if (cardInfo != null) {
                    List<hed> O00000Oo2 = cardInfo.O00000Oo();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("did", device.did);
                    JSONArray jSONArray2 = new JSONArray();
                    for (hed O000000o2 : O00000Oo2) {
                        hee O000000o3 = O000000o2.O000000o();
                        if (O000000o3 != null) {
                            jSONArray2.put(O000000o3.f18836O000000o);
                            if (O000000o3.O00000o.size() > 0) {
                                for (String put : O000000o3.O00000o.keySet()) {
                                    jSONArray2.put(put);
                                }
                            }
                        }
                    }
                    jSONObject.put("props", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e) {
                Log.e("mijia-card", "fatal", e);
            }
        }
        return jSONArray;
    }

    public void loadCardPropsFromServerAsync(Device device, final fsm<Object, fso> fsm, String str) {
        JSONArray propsParams = getPropsParams(device);
        if (propsParams != null && propsParams.length() != 0) {
            DeviceCardApi.O000000o(CommonApplication.getAppContext(), propsParams, new fsm<String, fso>() {
                /* class _m_j.hcv.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    String str = (String) obj;
                    gsy.O00000Oo("mijia-card", "ControlCardInfoManager.batchGetDeviceProps result = ".concat(String.valueOf(str)));
                    hcv.this.parseDeviceProps(str);
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(6, "mijia-card", "ControlCardInfoManager.batchGetDeviceProps result error: ".concat(String.valueOf(fso)));
                }
            }, "ControlCardInfoManager:".concat(String.valueOf(str)));
        }
    }

    public void loadPropsFromServer(boolean z, fsm<Object, fso> fsm, String str) {
        Message obtain = Message.obtain();
        obtain.what = 201;
        obtain.obj = new Object[]{Boolean.valueOf(z), fsm, str};
        this.mWorkerHandler.sendMessage(obtain);
    }

    public void loadPropsFromServer(final fsm<Object, fso> fsm, String str) {
        heb cardInfo;
        List<hed> O000000o2;
        Map<String, Device> allDevices = fbd.O000000o().getAllDevices();
        if (allDevices == null || allDevices.size() == 0 || this.mAllCardInfo.size() == 0) {
            noticeMinusCard();
            if (fsm != null) {
                fsm.onSuccess(null);
            }
            gsy.O00000Oo("mijia-card", "ControlCardInfoManager.loadPropsFromServer device size 0 or cardconfig size 0");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<String, Device> value : allDevices.entrySet()) {
                Device device = (Device) value.getValue();
                if (!(device == null || TextUtils.isEmpty(device.did) || TextUtils.isEmpty(device.model) || (cardInfo = getCardInfo(device.model)) == null || (O000000o2 = cardInfo.O000000o()) == null || O000000o2.size() == 0)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("did", device.did);
                    JSONArray jSONArray2 = new JSONArray();
                    for (hcc.O000000o next : O000000o2) {
                        jSONArray2.put(next.O00000o0);
                        hee O000000o3 = next.O000000o();
                        if (O000000o3 != null && O000000o3.O00000o.size() > 0) {
                            for (String put : O000000o3.O00000o.keySet()) {
                                jSONArray2.put(put);
                            }
                        }
                    }
                    jSONObject.put("props", jSONArray2);
                    jSONArray.put(jSONObject);
                    if (jSONArray.length() >= 300) {
                        arrayList.add(jSONArray);
                        jSONArray = new JSONArray();
                    }
                }
            }
        } catch (JSONException e) {
            gsy.O000000o(6, "mijia-card", Log.getStackTraceString(e));
        }
        if (jSONArray.length() > 0) {
            arrayList.add(jSONArray);
        }
        if (arrayList.size() == 0) {
            noticeMinusCard();
            if (fsm != null) {
                fsm.onSuccess(null);
            }
            gsy.O000000o(6, "mijia-card", "ControlCardInfoManager.loadPropsFromServer rquest size  0");
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
        gsy.O00000Oo("mijia-card", "ControlCardInfoManager.loadPropsFromServer rquest size:" + atomicInteger.get());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DeviceCardApi.O000000o(CommonApplication.getAppContext(), (JSONArray) it.next(), new fsm<String, fso>() {
                /* class _m_j.hcv.AnonymousClass6 */
                private ArrayList<String> O00000o = new ArrayList<>();
                private fso O00000oO;

                /* access modifiers changed from: private */
                /* renamed from: O000000o */
                public void onSuccess(String str) {
                    if (str != null) {
                        this.O00000o.add(str);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        gsy.O00000Oo("mijia-card", "ControlCardInfoManager.loadPropsFromServer onSuccess size:" + this.O00000o.size());
                        if (this.O00000o.size() > 0) {
                            Iterator<String> it = this.O00000o.iterator();
                            while (it.hasNext()) {
                                hcv.this.parseDeviceProps(it.next());
                            }
                            hcv.this.batchGetTDS();
                            fsm fsm = fsm;
                            if (fsm != null) {
                                fsm.sendSuccessMessage(null);
                            }
                        } else {
                            fsm fsm2 = fsm;
                            if (fsm2 != null) {
                                fsm2.sendFailureMessage(this.O00000oO);
                            }
                        }
                        hcv.this.savePropsCache();
                        hcv.this.noticeMinusCard();
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O00000Oo("mijia-card", "ControlCardInfoManager.loadPropsFromServer onFailure index:" + atomicInteger.decrementAndGet());
                    this.O00000oO = fso;
                    onSuccess(null);
                }
            }, "ControlCardInfoManager:".concat(String.valueOf(str)));
        }
    }

    public void setDeviceProp(Device device, hed hed, String str, hdc hdc, Object obj, fsm<JSONObject, fso> fsm) {
        final Object obj2;
        final Object obj3;
        Device device2 = device;
        hed hed2 = hed;
        Object obj4 = obj;
        fsm<JSONObject, fso> fsm2 = fsm;
        hee O000000o2 = hed.O000000o();
        if (O000000o2 == null || O000000o2.O0000Oo == null) {
            obj3 = null;
            obj2 = null;
        } else {
            String str2 = device2.did;
            String str3 = hed2.O00000o0;
            Object O000000o3 = O000000o2.O0000Oo.O000000o(obj4, (List<Object>) null);
            Object notifyPropChangedListener = notifyPropChangedListener(str2, str3, O000000o3, (byte) 1);
            if (obj4 == null || !obj4.equals(notifyPropChangedListener)) {
                obj3 = O000000o3;
                obj2 = notifyPropChangedListener;
            } else {
                gsy.O000000o(6, "mijia-card", "ControlCardInfoManager.setDeviceProp no change value:".concat(String.valueOf(obj)));
                notifyPropChangedListener(device2.did, hed2.O00000o0, O000000o3, (byte) 2);
                if (fsm2 != null) {
                    fsm2.onSuccess(null);
                    return;
                }
                return;
            }
        }
        final hed hed3 = hed;
        final Device device3 = device;
        final fsm<JSONObject, fso> fsm3 = fsm;
        DeviceCardApi.ProfileRpcApi.instance.rpcAsync(device2.did, device2.token, str, hdc, obj, new fsm<JSONObject, fso>() {
            /* class _m_j.hcv.AnonymousClass7 */

            public final void onFailure(fso fso) {
                hcv.this.notifyPropChangedListener(device3.did, hed3.O00000o0, obj2, (byte) 3);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (hed3.O0000OOo == null) {
                    hcv.this.notifyPropChangedListener(device3.did, hed3.O00000o0, obj3, (byte) 2);
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                        return;
                    }
                    return;
                }
                hcv.this.loadCardPropsFromServerAsync(device3, new fsm<Object, fso>() {
                    /* class _m_j.hcv.AnonymousClass7.AnonymousClass1 */

                    public final void onSuccess(Object obj) {
                        hcv.this.notifyPropChangedListener(device3.did, hed3.O00000o0, obj3, (byte) 2);
                        if (fsm3 != null) {
                            fsm3.sendSuccessMessage(null);
                        }
                    }

                    public final void onFailure(fso fso) {
                        hcv.this.notifyPropChangedListener(device3.did, hed3.O00000o0, obj2, (byte) 3);
                        if (fsm3 != null) {
                            fsm3.sendFailureMessage(fso);
                        }
                    }
                }, "updatePropValue");
            }
        });
        fbd.O000000o().operateCardStat(device);
    }

    public void subscribeGridProp() {
        Map<String, Device> allDevices = fbd.O000000o().getAllDevices();
        gsy.O00000Oo("mijia-card", "ControlCardInfoManager.subscribeGridProp onlineDevices:" + allDevices.size());
        if (this.mDevicePropSubscriber == null) {
            this.mDevicePropSubscriber = fbd.O000000o().createDevicePropSubscriber();
        }
        this.mDevicePropSubscriber.init(new ArrayList(allDevices.values()), new hcd.O000000o(getInstance()));
    }

    public void parseDeviceProps(String str) {
        hdi hdi;
        hdi hdi2;
        new ArrayMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        if (next2.equals("event.pure_water_record")) {
                            Object opt = optJSONObject.opt("event.pure_water_record");
                            if (opt != null) {
                                if (!"".equals(opt)) {
                                    notifyPropChangedListener(next, "event.pure_water_record", opt, (byte) 5);
                                }
                            }
                            Map<String, hdi> propsMap = getPropsMap(next);
                            if (propsMap == null || !propsMap.containsKey(next2) || ((hdi2 = propsMap.get(next2)) != null && !"".equals(hdi2.f18812O000000o))) {
                                notifyPropChangedListener(next, next2, opt, (byte) 5);
                            }
                        } else {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next2);
                            if (optJSONObject2 != null) {
                                String optString = optJSONObject2.optString("value");
                                long optLong = optJSONObject2.optLong("timestamp", -1);
                                if ("".equals(optString)) {
                                    Map<String, hdi> propsMap2 = getPropsMap(next);
                                    if (propsMap2 == null || !propsMap2.containsKey(next2) || ((hdi = propsMap2.get(next2)) != null && !"".equals(hdi.f18812O000000o))) {
                                        notifyPropChangedListener(next, next2, optString, optLong, (byte) 5);
                                    }
                                } else {
                                    notifyPropChangedListener(next, next2, optString, optLong, (byte) 5);
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            Log.e("mijia-card", "fatal", e);
        }
    }

    public void batchGetTDS() {
        if (!this.mTdsBatchLoading.get()) {
            this.mTdsBatchLoading.set(true);
            this.mTdsLoadCache.clear();
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry entry : this.mPropsMap.entrySet()) {
                if (((Map) entry.getValue()).get("event.pure_water_record") != null) {
                    arrayList.add(entry.getKey());
                    this.mTdsLoadCache.put(entry.getKey(), Boolean.FALSE);
                }
            }
            if (arrayList.size() > 0) {
                for (String currentTDS : arrayList) {
                    getCurrentTDS(currentTDS);
                }
                return;
            }
            this.mTdsBatchLoading.set(false);
            noticeMinusCard();
        }
    }

    private void getCurrentTDS(final String str) {
        fbd.O000000o().callMethod(str, "{\"id\":100,\"method\":\"get_prop\",\"params\":[]}", new Callback<String>() {
            /* class _m_j.hcv.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray optJSONArray;
                String str = (String) obj;
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.isNull("result") && (optJSONArray = jSONObject.optJSONArray("result")) != null && optJSONArray.length() > 2) {
                            hcv.this.notifyPropChangedListener(str, "event.pure_water_record", optJSONArray.opt(1), (byte) 5);
                        }
                    } catch (JSONException e) {
                        Log.e("mijia-card", "fatal", e);
                    }
                }
                hcv.this.tdsLoadComplete(str);
            }

            public final void onFailure(int i, String str) {
                hcv.this.tdsLoadComplete(str);
            }
        }, new Parser<String>() {
            /* class _m_j.hcv.AnonymousClass9 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public void tdsLoadComplete(String str) {
        synchronized (this.mLock) {
            this.mTdsLoadCache.put(str, Boolean.TRUE);
            boolean z = true;
            Iterator<Map.Entry<String, Boolean>> it = this.mTdsLoadCache.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((Boolean) it.next().getValue()).booleanValue()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                this.mTdsBatchLoading.set(false);
                this.mTdsLoadCache.clear();
                ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("action_water_record_update"));
                noticeMinusCard();
            }
        }
    }

    public void noticeMinusCard() {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("light_device_card_info_ready"));
    }

    /* access modifiers changed from: protected */
    public File getCacheFile() {
        if (!fcn.O000000o().O0000OOo()) {
            return null;
        }
        File file = new File(fkw.O000000o(CommonApplication.getAppContext()) + File.separator + fcn.O000000o().O00000Oo() + "_control_props_profile");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }
        return file;
    }

    public void destroy() {
        if (CommonApplication.getAppContext() != null && !CardActive.instance.isActive()) {
            frb frb = this.mDevicePropSubscriber;
            if (frb != null) {
                frb.destroy();
                this.mDevicePropSubscriber = null;
            }
            this.mWorkerHandler.post(new Runnable() {
                /* class _m_j.$$Lambda$M6hgPrD9ZdcHn9WWyD5KuLt_8g */

                public final void run() {
                    hcv.this.savePropsCache();
                }
            });
        }
    }

    public void dispatchOnCardInfo() {
        Set<O000000o> set = this.mListener;
        if (set != null) {
            Iterator<O000000o> it = set.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.mListener = null;
        }
    }

    public void registCardInfoListener(O000000o o000000o) {
        Set<O000000o> set;
        if (o000000o != null && (set = this.mListener) != null) {
            set.add(o000000o);
        }
    }
}
