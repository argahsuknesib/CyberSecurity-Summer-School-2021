package _m_j;

import _m_j.fli;
import _m_j.hcd;
import _m_j.hcz;
import _m_j.hee;
import _m_j.heo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.PropertyDefinition;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.card.DeviceCardApi;
import com.xiaomi.smarthome.service.CardActive;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class hcz extends hcd implements fbb {
    private static final hcz INSTANCE = new hcz();
    public boolean isLoadingProps = false;
    public Map<String, her> mAllCardConfig;
    private final AppConfigHelper mAppConfigHelper;
    private String mCardIconPath = null;
    private o0O0OOO0<String, heo> mComplexUnitMap = new o0O0OOO0<>();
    private frb mDevicePropSubscriber;
    public boolean mHasParseCompleteData = false;
    private JSONObject mImageMap;
    public o0O0OOO0<String, String> mLanguageMap = new o0O0OOO0<>();
    private o0O0OOO0<String, List<hee.O00000Oo>> mPropExtraMap = new o0O0OOO0<>();
    private ArrayList<Runnable> mReadyCallback = new ArrayList<>();
    public hdh mSpecCache;
    private final fjv mUnitChangeListener = new fjv() {
        /* class _m_j.$$Lambda$hcz$VIdJzmvuwWcx3UP9HX9dTo4Ut8I */

        public final void onUnitChange(String str, String str2, String str3) {
            hcz.this.lambda$new$0$hcz(str, str2, str3);
        }
    };
    private o0O0OOO0<String, hez> mUnitMap = new o0O0OOO0<>();
    public Handler mWorkerHandler;
    private Disposable subscribe;

    static /* synthetic */ Object lambda$init$4(Object obj, Object obj2, Object obj3) throws Exception {
        return obj;
    }

    @cug
    public static hcz provideInstance() {
        return INSTANCE;
    }

    public /* synthetic */ void lambda$new$0$hcz(String str, String str2, String str3) {
        dataReadyRefresh();
    }

    private hcz() {
        HandlerThread handlerThread = new HandlerThread("MiotSpecCardManager");
        handlerThread.start();
        this.mWorkerHandler = new Handler(handlerThread.getLooper());
        Context appContext = CommonApplication.getAppContext();
        this.mAppConfigHelper = new AppConfigHelper(appContext);
        fju.O000000o().O000000o(this.mUnitChangeListener);
        if (appContext != null) {
            ft.O000000o(appContext).O000000o(new BroadcastReceiver() {
                /* class _m_j.hcz.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    hcz.this.loadLanguageConfig().subscribe($$Lambda$hcz$1$LiYMviHsJA8TplngCUdeC4aUJGg.INSTANCE, $$Lambda$hcz$1$bjfY7HTSGkRtqesuftVPhwlSw.INSTANCE);
                    if (hcz.this.mSpecCache != null) {
                        hcz.this.mSpecCache.O00000Oo.clear();
                    }
                }
            }, new IntentFilter("ClientApiStub.onLocaleChanged"));
            fbd.O000000o().registerDeviceRefreshListener(new fbf() {
                /* class _m_j.hcz.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final Runnable f18797O000000o = new Runnable() {
                    /* class _m_j.$$Lambda$hcz$2$G0Yb9tC2rXVvIJn4v7urVRlgmU */

                    public final void run() {
                        hcz.AnonymousClass2.this.O000000o();
                    }
                };

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    if (hcz.this.mSpecCache != null) {
                        hdh hdh = hcz.this.mSpecCache;
                        Map<String, Device> allDevices = fbd.O000000o().getAllDevices();
                        $$Lambda$hcz$2$dL9QgSmJdULRJrBre0c5jh7lzHY r2 = new Runnable() {
                            /* class _m_j.$$Lambda$hcz$2$dL9QgSmJdULRJrBre0c5jh7lzHY */

                            public final void run() {
                                hcz.AnonymousClass2.this.O00000Oo();
                            }
                        };
                        if (allDevices != null) {
                            HashSet hashSet = new HashSet();
                            HashSet hashSet2 = new HashSet();
                            HashSet hashSet3 = new HashSet();
                            for (Map.Entry<String, Device> value : allDevices.entrySet()) {
                                Device device = (Device) value.getValue();
                                String str = device.specUrn;
                                if (!TextUtils.isEmpty(str)) {
                                    hashSet.add(str);
                                    if (!gfr.O0000Oo0 && fbd.O000000o().isPluginNotRelease(device.model)) {
                                        hashSet2.add(str);
                                        hashSet3.add(str);
                                    }
                                    if (hdh.f18809O000000o.get(str) == null) {
                                        hashSet2.add(str);
                                    }
                                    if (hdh.O00000Oo.get(str) == null) {
                                        hashSet3.add(str);
                                    }
                                }
                            }
                            hdh.O000000o("/miot-spec-v2/instance", hashSet2);
                            hdh.O000000o("/instance/v2/multiLanguage", hashSet3);
                            gsy.O000000o(4, "mijia-card", "SpecCache.onDeviceChange load instance size:" + hashSet2 + " language size:" + hashSet3);
                            if (r2 != null) {
                                r2.run();
                            }
                            Parcel obtain = Parcel.obtain();
                            obtain.writeInt(hashSet.size());
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                obtain.writeString((String) it.next());
                            }
                            fkw.O000000o(hdh.O000000o("spec_urns.parcel"), obtain.marshall());
                            obtain.recycle();
                        } else if (r2 != null) {
                            r2.run();
                        }
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    hcz.this.refreshDeviceProps(true, null);
                }

                public final void O000000o(int i) {
                    gsy.O000000o(6, "mijia-card", "onRefreshClientDeviceSuccess type:" + i + "  ");
                    if (i == 3 && fcn.O000000o().O0000OOo()) {
                        hcz.this.mWorkerHandler.postDelayed(this.f18797O000000o, 2000);
                    }
                }
            });
            ft.O000000o(appContext).O000000o(new BroadcastReceiver() {
                /* class _m_j.hcz.AnonymousClass3 */

                public final void onReceive(Context context, Intent intent) {
                    hcz.this.mWorkerHandler.post(new Runnable() {
                        /* class _m_j.$$Lambda$hcz$3$_fmU7WHNAQzdKFDkJUxgXT4mUU */

                        public final void run() {
                            hcz.AnonymousClass3.this.O000000o();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    if (!hcz.this.mHasParseCompleteData) {
                        hcz.this.loadSpecCardConfig().subscribe($$Lambda$hcz$3$IZ2ZONI_E00gz3ez2MaWYMC4Z4.INSTANCE, $$Lambda$hcz$3$a_ErfX7VkC6E067xXJsFDgGDcU.INSTANCE);
                    }
                }
            }, new IntentFilter("ACTION_APP_HAS_ENTERED_FOREGROUND"));
        }
        gsy.O000000o(4, "mijia-card", "constructor MiotSpecCardManager:" + this + " SpecCardVersion:1");
        init();
    }

    public Observable<Object> loadLanguageConfig() {
        return Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$hcz$SQEvR98zUYge8DURaJFYgbLBabs */

            public final void subscribe(ObservableEmitter observableEmitter) {
                hcz.this.lambda$loadLanguageConfig$1$hcz(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$loadLanguageConfig$1$hcz(final ObservableEmitter observableEmitter) throws Exception {
        this.mAppConfigHelper.O000000o("card_default_resource", "1", "en", (String) null, new AppConfigHelper.O000000o() {
            /* class _m_j.hcz.AnonymousClass4 */

            public final /* synthetic */ void sendSuccessMessage(Object obj, Response response) {
                hcz.this.parseLanguage((String) obj);
                observableEmitter.onNext(hcz.this);
                hcz.this.dataReadyRefresh();
                observableEmitter.onComplete();
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.loadLanguageConfig onSuccess mLanguageMap.size:" + hcz.this.mLanguageMap.size());
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                LogType logType = LogType.CARD;
                gsy.O00000o0(logType, "mijia-card", "MiotSpecCardManager.loadLanguageConfig onFailure" + gsf + Log.getStackTraceString(exc));
                observableEmitter.tryOnError(exc);
            }
        }, $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE);
    }

    public static hcz getInstance() {
        return INSTANCE;
    }

    private void init() {
        $$Lambda$hcz$F1MrxwmkhRq5KEFYEKQDBZu2M0g r0 = new Consumer() {
            /* class _m_j.$$Lambda$hcz$F1MrxwmkhRq5KEFYEKQDBZu2M0g */

            public final void accept(Object obj) {
                hcz.this.lambda$init$2$hcz(obj);
            }
        };
        this.subscribe = Observable.zip(loadSpecCardConfig(), loadLanguageConfig(), Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$hcz$vdwGCSkDeyUbBYFGOK7PgnSPLcw */

            public final void subscribe(ObservableEmitter observableEmitter) {
                hcz.this.lambda$init$3$hcz(observableEmitter);
            }
        }), $$Lambda$hcz$8xOKKZ0nWg8vIuACceeHhTladI.INSTANCE).subscribe(r0, r0);
    }

    public /* synthetic */ void lambda$init$2$hcz(Object obj) throws Exception {
        ArrayList<Runnable> arrayList = this.mReadyCallback;
        if (arrayList != null) {
            this.mReadyCallback = null;
            Iterator<Runnable> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public /* synthetic */ void lambda$init$3$hcz(ObservableEmitter observableEmitter) throws Exception {
        this.mSpecCache = new hdh();
        loadPropsFromLocal();
        observableEmitter.onNext(this);
        observableEmitter.onComplete();
    }

    public Observable<Object> loadSpecCardConfig() {
        return Observable.create(new ObservableOnSubscribe() {
            /* class _m_j.$$Lambda$hcz$zh61Ulgxc8_IDtP6X4VX8rJIzK8 */

            public final void subscribe(ObservableEmitter observableEmitter) {
                hcz.this.lambda$loadSpecCardConfig$5$hcz(observableEmitter);
            }
        });
    }

    public /* synthetic */ void lambda$loadSpecCardConfig$5$hcz(final ObservableEmitter observableEmitter) throws Exception {
        this.mAppConfigHelper.O000000o("card_control_miotspec_config", "2", "en", (String) null, new AppConfigHelper.O000000o() {
            /* class _m_j.hcz.AnonymousClass5 */

            public final /* synthetic */ void sendSuccessMessage(Object obj, Response response) {
                String str = (String) obj;
                try {
                    if (AppConfigHelper.O000000o(str)) {
                        Map<String, her> parseConfigData = hcz.this.parseConfigData(new JSONArray(str));
                        if (parseConfigData.size() != 0) {
                            hcz.this.createCardConfigMap(parseConfigData);
                            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.loadConfigFromServer onSuccess mAllCardInfo.size:" + hcz.this.mAllCardConfig.size());
                        } else {
                            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.loadConfigFromServer onSuccess allCards.size==0:".concat(String.valueOf(str)));
                        }
                    } else {
                        gsy.O00000Oo("mijia-card", "MiotSpecCardManager.loadConfigFromServer onSuccess isJsonNotNull:".concat(String.valueOf(str)));
                    }
                    hcz.this.dataReadyRefresh();
                    observableEmitter.onNext(hcz.this);
                    observableEmitter.onComplete();
                } catch (Exception e) {
                    gsy.O00000o0(LogType.CARD, "mijia-card", Log.getStackTraceString(e));
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                gsy.O00000o0(LogType.CARD, "mijia-card", "MiotSpecCardManager.loadConfigFromServer onFailure");
                observableEmitter.tryOnError(exc);
            }
        }, $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE);
    }

    public void createCardConfigMap(Map<String, her> map) {
        Map<String, her> map2 = this.mAllCardConfig;
        if (map2 == null) {
            this.mAllCardConfig = new o0O0OOO0();
        } else {
            map2.clear();
        }
        this.mAllCardConfig.putAll(map);
    }

    public boolean parseLanguage(String str) {
        boolean z;
        try {
            if (!AppConfigHelper.O000000o(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
            o0O0OOO0 o0o0ooo02 = new o0O0OOO0();
            o0O0OOO0 o0o0ooo03 = new o0O0OOO0();
            o0O0OOO0 o0o0ooo04 = new o0O0OOO0();
            fli.O000000o(jSONObject.optJSONObject("names"), (Map) null, new fli.O00000Oo(o0o0ooo0) {
                /* class _m_j.$$Lambda$hcz$ZQWdyBtxZLKyk1vnghwgrK1bo3o */
                private final /* synthetic */ Map f$1;

                {
                    this.f$1 = r2;
                }

                public final Object getItem(Object obj, String str) {
                    return hcz.this.lambda$parseLanguage$6$hcz(this.f$1, (JSONObject) obj, str);
                }
            });
            fli.O000000o(jSONObject.optJSONObject("units"), (Map) null, new fli.O00000Oo(o0o0ooo02) {
                /* class _m_j.$$Lambda$hcz$l7GJYmUnZZ_8lvHpLld_dkdiWv4 */
                private final /* synthetic */ Map f$1;

                {
                    this.f$1 = r2;
                }

                public final Object getItem(Object obj, String str) {
                    return hcz.this.lambda$parseLanguage$7$hcz(this.f$1, (JSONObject) obj, str);
                }
            });
            fli.O000000o(jSONObject.optJSONObject("prop_extras"), (Map) null, new fli.O00000Oo(o0o0ooo04) {
                /* class _m_j.$$Lambda$hcz$0MuVXVaVJgA22U5rF35b5A2QH4 */
                private final /* synthetic */ Map f$1;

                {
                    this.f$1 = r2;
                }

                public final Object getItem(Object obj, String str) {
                    return hcz.this.lambda$parseLanguage$9$hcz(this.f$1, (JSONObject) obj, str);
                }
            });
            fli.O000000o(jSONObject.optJSONArray("complex_units"), (List) null, new fli.O000000o(o0o0ooo03) {
                /* class _m_j.$$Lambda$hcz$_V5WzOu4Xdlk9olm_XT7akd2PWs */
                private final /* synthetic */ Map f$0;

                {
                    this.f$0 = r1;
                }

                public final Object addItem(JSONArray jSONArray, int i) {
                    return hcz.lambda$parseLanguage$11(this.f$0, jSONArray, i);
                }
            });
            if (o0o0ooo0.size() != 0) {
                this.mLanguageMap.clear();
                this.mLanguageMap.putAll(o0o0ooo0);
                z = true;
            } else {
                z = false;
            }
            if (o0o0ooo02.size() != 0) {
                this.mUnitMap.clear();
                this.mUnitMap.putAll(o0o0ooo02);
            } else {
                z = false;
            }
            if (o0o0ooo03.size() != 0) {
                this.mComplexUnitMap.putAll(o0o0ooo03);
            } else {
                z = false;
            }
            if (o0o0ooo04.size() != 0) {
                this.mPropExtraMap.clear();
                this.mPropExtraMap.putAll(o0o0ooo04);
            } else {
                z = false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("download_url");
            if (optJSONObject == null) {
                return false;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("CardItemIcons_map");
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("CardItemIcons_host");
            if (optJSONObject2 == null || optJSONObject3 == null) {
                return false;
            }
            setImage(optJSONObject2, optJSONObject3);
            return z;
        } catch (Exception e) {
            gsy.O00000o0(LogType.CARD, "mijia-card", Log.getStackTraceString(e));
            return false;
        }
    }

    public /* synthetic */ JSONObject lambda$parseLanguage$6$hcz(Map map, JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject != null) {
            map.put(translateName(str), gpl.O000000o(optJSONObject));
        }
        return optJSONObject;
    }

    public /* synthetic */ JSONObject lambda$parseLanguage$7$hcz(Map map, JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject != null) {
            map.put(translateName(str), new hez(optJSONObject.optDouble("ratio", 1.0d), gpl.O000000o(optJSONObject.optJSONObject("name"))));
        }
        return optJSONObject;
    }

    public /* synthetic */ List lambda$parseLanguage$9$hcz(Map map, JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList();
        fli.O000000o(jSONObject.optJSONArray(str), arrayList, $$Lambda$hcz$8mu4CBJIqcVpiSUTFl923sijmk.INSTANCE);
        map.put(translateName(str), arrayList);
        return arrayList;
    }

    static /* synthetic */ hee.O00000Oo lambda$null$8(JSONArray jSONArray, int i) {
        return new hee.O00000Oo(jSONArray.optJSONObject(i));
    }

    static /* synthetic */ ArrayList lambda$parseLanguage$11(Map map, JSONArray jSONArray, int i) {
        ArrayList arrayList = new ArrayList();
        fli.O000000o(jSONArray.optJSONArray(i), arrayList, new fli.O000000o(map, new heo(arrayList)) {
            /* class _m_j.$$Lambda$hcz$0zZSUdarzq2EgW3cXs2qWLYoCi4 */
            private final /* synthetic */ Map f$0;
            private final /* synthetic */ heo f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object addItem(JSONArray jSONArray, int i) {
                return hcz.lambda$null$10(this.f$0, this.f$1, jSONArray, i);
            }
        });
        return arrayList;
    }

    static /* synthetic */ heo.O000000o lambda$null$10(Map map, heo heo, JSONArray jSONArray, int i) {
        JSONObject optJSONObject = jSONArray.optJSONObject(i);
        String O000000o2 = gpl.O000000o(optJSONObject.optJSONObject("name"));
        map.put(O000000o2, heo);
        return new heo.O000000o((byte) optJSONObject.optInt("hide"), optJSONObject.optInt("times", Integer.MAX_VALUE), O000000o2);
    }

    public String getCardIconPath(String str) {
        if (this.mCardIconPath == null) {
            gsy.O00000Oo("mijia-card", "getCardIconPath is init");
            return null;
        }
        String optString = this.mImageMap.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return this.mCardIconPath + optString;
    }

    public void setImage(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mCardIconPath = ftn.O000000o(fdc.O000000o().O0000o0O(), jSONObject2);
        this.mImageMap = jSONObject;
    }

    public Map<String, her> parseConfigData(JSONArray jSONArray) {
        o0O0OOO0 o0o0ooo0;
        ArrayList arrayList;
        o0O0OOO0 o0o0ooo02;
        ArrayList arrayList2;
        ArrayList arrayList3;
        JSONArray jSONArray2 = jSONArray;
        o0O0OOO0 o0o0ooo03 = new o0O0OOO0();
        if (jSONArray2 == null || jSONArray.length() == 0) {
            return o0o0ooo03;
        }
        int i = 0;
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("card_items");
                ArrayList arrayList4 = new ArrayList();
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList4.add(new hej(optJSONArray.optJSONObject(i3)));
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("card_instance");
                int i4 = 1;
                if (optJSONArray2 != null) {
                    ArrayList arrayList5 = null;
                    ArrayList arrayList6 = null;
                    ArrayList arrayList7 = null;
                    o0O0OOO0 o0o0ooo04 = null;
                    o0O0OOO0 o0o0ooo05 = null;
                    int i5 = 0;
                    while (i5 < optJSONArray2.length()) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i5);
                        hep hep = new hep(optJSONObject2, arrayList4);
                        if (optJSONObject2.optInt("min_support_version", i) <= i4) {
                            int optInt = optJSONObject2.optInt("instance_type");
                            if (optInt == i4) {
                                if (arrayList5 == null) {
                                    arrayList5 = new ArrayList();
                                }
                                arrayList5.add(hep);
                            } else if (optInt == 3) {
                                if (arrayList6 == null) {
                                    arrayList6 = new ArrayList();
                                }
                                arrayList6.add(hep);
                            } else if (optInt == 2) {
                                if (optJSONObject2.optJSONArray("type") != null) {
                                    HashSet hashSet = new HashSet();
                                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("type");
                                    if (optJSONArray3 != null) {
                                        for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                                            hashSet.add(optJSONArray3.optString(i6));
                                        }
                                    }
                                    if (o0o0ooo04 == null) {
                                        o0o0ooo04 = new o0O0OOO0();
                                    }
                                    o0o0ooo04.put(hashSet, hep);
                                }
                            } else if (optInt == 5) {
                                if (arrayList7 == null) {
                                    arrayList7 = new ArrayList();
                                }
                                arrayList7.add(hep);
                            } else if (optInt == 6 && optJSONObject2.optJSONArray("type") != null) {
                                HashSet hashSet2 = new HashSet();
                                JSONArray optJSONArray4 = optJSONObject2.optJSONArray("type");
                                if (optJSONArray4 != null) {
                                    for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                                        hashSet2.add(optJSONArray4.optString(i7));
                                    }
                                }
                                if (o0o0ooo05 == null) {
                                    o0o0ooo05 = new o0O0OOO0();
                                }
                                o0o0ooo05.put(hashSet2, hep);
                            }
                        }
                        i5++;
                        i = 0;
                        i4 = 1;
                    }
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList6;
                    arrayList = arrayList7;
                    o0o0ooo02 = o0o0ooo04;
                    o0o0ooo0 = o0o0ooo05;
                } else {
                    arrayList3 = null;
                    arrayList2 = null;
                    o0o0ooo02 = null;
                    arrayList = null;
                    o0o0ooo0 = null;
                }
                if (arrayList != null) {
                    arrayList.trimToSize();
                }
                if (arrayList3 != null) {
                    arrayList3.trimToSize();
                }
                if (arrayList2 != null) {
                    arrayList2.trimToSize();
                }
                her her = new her(arrayList3, arrayList2, o0o0ooo02, arrayList, o0o0ooo0, fli.O000000o(optJSONObject, "disable_type"));
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("types");
                if (optJSONArray5 != null) {
                    for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                        if (fad.O000000o().isEnableMiuiWidgetMemoryOpt()) {
                            Iterator<Device> it = fbd.O000000o().getAllDevices().values().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (TextUtils.equals(optJSONArray5.optString(i8), hfa.O00000Oo(it.next()))) {
                                        o0o0ooo03.put(optJSONArray5.optString(i8), her);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } else {
                            this.mHasParseCompleteData = true;
                            o0o0ooo03.put(optJSONArray5.optString(i8), her);
                        }
                    }
                }
            }
            i2++;
            jSONArray2 = jSONArray;
            i = 0;
        }
        return o0o0ooo03;
    }

    public SpecDevice getSpecInstance(Device device) {
        if (this.mSpecCache == null) {
            gsy.O00000Oo("mijia-card", "getSpecInstance SpecCache is loading");
            return null;
        }
        String O000000o2 = hfa.O000000o(device);
        SpecDevice O00000o0 = this.mSpecCache.O00000o0(O000000o2);
        if (!TextUtils.isEmpty(O000000o2) && O00000o0 == null) {
            this.mWorkerHandler.post(new Runnable(O000000o2, device) {
                /* class _m_j.$$Lambda$hcz$boGGrSgEpiZdqmWFKqjuE7WB8CU */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Device f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    hcz.this.lambda$getSpecInstance$12$hcz(this.f$1, this.f$2);
                }
            });
        }
        return O00000o0;
    }

    public /* synthetic */ void lambda$getSpecInstance$12$hcz(String str, Device device) {
        if (this.mSpecCache.O00000o0(str) != null || this.mSpecCache.O000000o("/miot-spec-v2/instance", Collections.singleton(str)) >= 0) {
            getInstance().notifyPropChangedListener(device.did, null, null, (byte) 5);
        }
    }

    public Map<String, String> getSpecLanguage(Device device) {
        if (this.mSpecCache == null) {
            gsy.O00000Oo("mijia-card", "getSpecLanguage SpecCache is loading");
            return null;
        }
        String O000000o2 = hfa.O000000o(device);
        Map<String, String> O00000Oo = this.mSpecCache.O00000Oo(O000000o2);
        if (!TextUtils.isEmpty(O000000o2) && O00000Oo == null) {
            this.mWorkerHandler.post(new Runnable(O000000o2, device) {
                /* class _m_j.$$Lambda$hcz$NgUtOhQ8cSMXscqXXaxLhVEpAjE */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ Device f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    hcz.this.lambda$getSpecLanguage$13$hcz(this.f$1, this.f$2);
                }
            });
        }
        return O00000Oo;
    }

    public /* synthetic */ void lambda$getSpecLanguage$13$hcz(String str, Device device) {
        if (this.mSpecCache.O00000Oo(str) != null || this.mSpecCache.O000000o("/instance/v2/multiLanguage", Collections.singleton(str)) >= 0) {
            notifyPropChangedListener(device.did, null, null, (byte) 5);
        }
    }

    public hdh getSpecCache() {
        return this.mSpecCache;
    }

    public Pair<hep, Spec.SpecItem[][]> getGridCardPair(Device device) {
        SpecDevice specInstance = getSpecInstance(device);
        her specCardSelector = getSpecCardSelector(specInstance);
        if (specCardSelector != null) {
            return specCardSelector.O000000o(specInstance);
        }
        gsy.O00000Oo("mijia-card", "SpecCardSelector is null device:" + device + " SpecDevice:" + specInstance);
        return null;
    }

    public her getSpecCardSelector(SpecDevice specDevice) {
        if (specDevice != null) {
            try {
                if (this.mAllCardConfig != null) {
                    her her = this.mAllCardConfig.get(specDevice.getTypeName());
                    if (her == null) {
                        gsy.O00000Oo("mijia-card", "getSpecCardSelector not contain spec:" + specDevice + " configSize:" + this.mAllCardConfig.size());
                    }
                    return her;
                }
            } catch (Exception e) {
                gsy.O00000o0(LogType.CARD, "mijia-card", Log.getStackTraceString(e));
            }
        }
        gsy.O00000o0(LogType.CARD, "mijia-card", "getSpecCardSelector cardconfig is null".concat(String.valueOf(specDevice)));
        return null;
    }

    public Spec.SpecItem[] getGridCardProperty(Device device, int i) {
        hcz instance = getInstance();
        SpecDevice specInstance = instance.getSpecInstance(device);
        her specCardSelector = instance.getSpecCardSelector(specInstance);
        if (specCardSelector != null) {
            Pair<hep, Spec.SpecItem[][]> O000000o2 = specCardSelector.O000000o(specInstance);
            Spec.SpecItem[][] specItemArr = (O000000o2 == null || O000000o2.first == null) ? null : (Spec.SpecItem[][]) O000000o2.second;
            if (specItemArr != null && specItemArr.length > i) {
                return specItemArr[i];
            }
        }
        return null;
    }

    public Pair<hep, Spec.SpecItem[][]> getActivityCardPair(Device device, boolean z) {
        SpecDevice specInstance = getSpecInstance(device);
        her specCardSelector = getSpecCardSelector(specInstance);
        if (specCardSelector == null) {
            gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.chooseSpecCardInstance notFind. null card model:" + device.model + " null card config urn:" + specInstance);
            return null;
        }
        gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.chooseSpecCardInstance prematch. model:" + device.model + " did" + device.did + " urn:" + specInstance.getType());
        return specCardSelector.O000000o(specInstance, z);
    }

    public void refreshDeviceProps(boolean z, fsm<Object, fso> fsm) {
        SpecDevice specInstance;
        her specCardSelector;
        Pair<hep, Spec.SpecItem[][]> O000000o2;
        fsm<Object, fso> fsm2 = fsm;
        if (!this.isLoadingProps) {
            this.isLoadingProps = true;
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            Map<String, Device> allDevices = fbd.O000000o().getAllDevices();
            hcv instance = hcv.getInstance();
            Iterator<Map.Entry<String, Device>> it = allDevices.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Device device = (Device) it.next().getValue();
                if (!(instance.getCardInfo(device.model) != null || (specCardSelector = getSpecCardSelector((specInstance = getSpecInstance(device)))) == null || (O000000o2 = specCardSelector.O000000o(specInstance)) == null || O000000o2.first == null)) {
                    Spec.SpecItem[][] specItemArr = (Spec.SpecItem[][]) O000000o2.second;
                    for (int i = 0; i < specItemArr.length; i++) {
                        hfa.O000000o(device.did, ((hej) ((hep) O000000o2.first).O000000o().get(i)).O00000Oo, specItemArr[i], arrayList);
                    }
                }
            }
            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getAllDevicePropFromServer operation.size:" + arrayList.size());
            if (arrayList.size() == 0) {
                if (fsm2 != null) {
                    fsm2.onSuccess(null);
                }
                this.isLoadingProps = false;
                return;
            }
            gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getAllDevicePropFromServer rquest size:" + arrayList.size() + " spend time:" + (System.currentTimeMillis() - currentTimeMillis));
            LinkedList linkedList = new LinkedList();
            Collections.addAll(linkedList, 3, 2);
            final fsm<Object, fso> fsm3 = fsm;
            final boolean z2 = z;
            final Map<String, Device> map = allDevices;
            final ArrayList arrayList2 = arrayList;
            getDevicePropFromServer(arrayList, linkedList, new fsm<List<PropertyParam>, fso>() {
                /* class _m_j.hcz.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    hcz.this.isLoadingProps = false;
                    gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getAllDevicePropFromServer result.size:" + ((List) obj).size());
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onSuccess(null);
                    }
                    hcz.this.mWorkerHandler.post(new Runnable() {
                        /* class _m_j.$$Lambda$7wkEXv3mtvlejo57WiVcmHkFK4M */

                        public final void run() {
                            hcz.this.savePropsCache();
                        }
                    });
                    if (z2) {
                        hcz.this.subscribeDeviceProp(map);
                    }
                    hcz.this.isLoadingProps = false;
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getAllDevicePropFromServer onFailure size:" + arrayList2.size());
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                    hcz.this.isLoadingProps = false;
                }
            });
        } else if (fsm2 != null) {
            fsm2.onFailure(new fso(-1, "is refreshing"));
        }
    }

    public void subscribeDeviceProp(Map<String, Device> map) {
        if (this.mDevicePropSubscriber == null) {
            this.mDevicePropSubscriber = fbd.O000000o().createDevicePropSubscriber();
        }
        ArrayList<Device> arrayList = new ArrayList<>(map.values());
        hcv instance = hcv.getInstance();
        ArrayList arrayList2 = new ArrayList();
        for (Device device : arrayList) {
            if (hfa.O000000o(device) != null && instance.getCardInfo(device.model) == null) {
                arrayList2.add(device);
            }
        }
        this.mDevicePropSubscriber.init(arrayList2, new hcd.O000000o(this));
    }

    public void getDevicePropFromServer(List<PropertyParam> list, List<Integer> list2, fsm<List<PropertyParam>, fso> fsm) {
        int intValue = list2.get(0).intValue();
        final int size = list2.size();
        final List<Integer> list3 = list2;
        final int i = intValue;
        final fsm<List<PropertyParam>, fso> fsm2 = fsm;
        DeviceCardApi.O000000o(CommonApplication.getAppContext(), list, intValue, new fsm<List<PropertyParam>, fso>() {
            /* class _m_j.hcz.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                int i;
                List<PropertyParam> list = (List) obj;
                gsy.O00000Oo("mijia-card", "MiotSpecCardManager.getDevicePropFromServer sources:" + list3 + " result.size:" + list.size());
                ArrayList arrayList = new ArrayList();
                for (PropertyParam propertyParam : list) {
                    String O000000o2 = fax.O000000o(propertyParam.getMiid(), propertyParam.getSiid(), propertyParam.getPiid());
                    String did = propertyParam.getDid();
                    if (propertyParam.getResultCode() == 0) {
                        if (i != 2) {
                            hcz.this.notifyPropChangedListener(did, O000000o2, propertyParam.getValue(), propertyParam.getTimestamp(), (byte) 5);
                        } else {
                            hcz.this.notifyPropChangedListener(did, O000000o2, propertyParam.getValue(), (byte) 5);
                        }
                    } else if (size > 1) {
                        arrayList.add(propertyParam);
                    } else {
                        Map<String, hdi> propsMap = hcz.this.getPropsMap(did);
                        if (propsMap == null || !propsMap.containsKey(O000000o2)) {
                            hcz.this.notifyPropChangedListener(did, O000000o2, propertyParam.getValue(), (byte) 5);
                        }
                    }
                }
                if (arrayList.size() <= 0 || (i = size) <= 1) {
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.onSuccess(list);
                        return;
                    }
                    return;
                }
                hcz.this.getDevicePropFromServer(arrayList, list3.subList(1, i), fsm2);
            }

            public final void onFailure(fso fso) {
                gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.getDevicePropFromServer onFailure".concat(String.valueOf(fso)));
                fsm fsm = fsm2;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }

    public void setDeviceProp(String str, SpecProperty specProperty, Object obj, fsm<JSONObject, fso> fsm) {
        String str2 = str;
        SpecProperty specProperty2 = specProperty;
        Object obj2 = obj;
        fsm<JSONObject, fso> fsm2 = fsm;
        if (specProperty2 == null || specProperty.getParent() == null || obj2 == null) {
            gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.setDeviceProp service:" + specProperty.getParent() + "  property:" + specProperty2 + " value:" + obj2);
            if (fsm2 != null) {
                fsm2.onFailure(new fso(-1, "not property or no value"));
                return;
            }
            return;
        }
        PropertyDefinition propertyDefinition = specProperty.getPropertyDefinition();
        Context appContext = CommonApplication.getAppContext();
        if (propertyDefinition.writable()) {
            PropertyParam propertyParam = new PropertyParam(str2, specProperty2);
            propertyParam.setValue(obj2);
            final String O000000o2 = fax.O000000o(specProperty);
            final Object notifyPropChangedListener = notifyPropChangedListener(str2, O000000o2, obj2, (byte) 1);
            boolean z = obj2.equals(notifyPropChangedListener) && propertyDefinition.readable();
            if (z) {
                gsy.O000000o(6, "mijia-card", "MiotSpecCardManager.setDeviceProp no change value:".concat(String.valueOf(obj)));
                if (fsm2 != null) {
                    fsm2.onSuccess(null);
                }
            }
            gsy.O00000Oo("mijia-card", "setDeviceProp request".concat(String.valueOf(propertyParam)));
            final boolean z2 = z;
            final fsm<JSONObject, fso> fsm3 = fsm;
            final Context context = appContext;
            final String str3 = str;
            final SpecProperty specProperty3 = specProperty;
            final Object obj3 = obj;
            DeviceCardApi.SpecPropertyApi.instance.setDeviceSpecProp(appContext, propertyParam, new fsm<PropertyParam, fso>() {
                /* class _m_j.hcz.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    PropertyParam propertyParam = (PropertyParam) obj;
                    gsy.O00000Oo("mijia-card", "setDeviceProp onSuccess:" + propertyParam + " sameLast:" + z2);
                    if (z2) {
                        return;
                    }
                    if (propertyParam == null || propertyParam.getResultCode() != 0) {
                        fsm fsm = fsm3;
                        if (fsm != null) {
                            fsm.onFailure(null);
                        } else {
                            Context context = context;
                            hte.O000000o(context, DeviceCardApi.O000000o(context, propertyParam));
                        }
                        if (notifyPropChangedListener != null) {
                            hcz.this.notifyPropChangedListener(str3, fax.O000000o(specProperty3), notifyPropChangedListener, (byte) 3);
                            return;
                        }
                        return;
                    }
                    hcz.this.notifyPropChangedListener(str3, O000000o2, obj3, (byte) 2);
                    fsm fsm2 = fsm3;
                    if (fsm2 != null) {
                        fsm2.onSuccess(null);
                    }
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(6, "mijia-card", "setDeviceProp onFailure".concat(String.valueOf(fso)));
                    Object obj = notifyPropChangedListener;
                    if (obj != null) {
                        hcz.this.notifyPropChangedListener(str3, O000000o2, obj, (byte) 3);
                    }
                    fsm fsm = fsm3;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                        return;
                    }
                    Context context = context;
                    hte.O000000o(context, context.getString(R.string.network_not_stable));
                }
            });
        } else if (fsm2 != null) {
            fsm2.onFailure(new fso(-1, "cannot writable"));
        } else {
            hte.O000000o(appContext, appContext.getString(R.string.spec_propertywrite_error));
        }
    }

    public void setDeviceAction(String str, SpecAction specAction, Spec.SpecItem specItem, fsm<JSONObject, fso> fsm) {
        ActionParam actionParam = new ActionParam(str, specAction, null);
        gsy.O00000Oo("mijia-card", "setDeviceSpecAction request".concat(String.valueOf(actionParam)));
        final Object propValue = getPropValue(str, specItem);
        Context appContext = CommonApplication.getAppContext();
        final fsm<JSONObject, fso> fsm2 = fsm;
        final Context context = appContext;
        final String str2 = str;
        final ActionParam actionParam2 = actionParam;
        final Spec.SpecItem specItem2 = specItem;
        DeviceCardApi.SpecActionApi.instance.setDeviceSpecAction(appContext, actionParam, new fsm<ActionParam, fso>() {
            /* class _m_j.hcz.AnonymousClass9 */

            public final /* synthetic */ void onSuccess(Object obj) {
                ActionParam actionParam = (ActionParam) obj;
                gsy.O00000Oo("mijia-card", "setDeviceSpecAction onSuccess".concat(String.valueOf(actionParam)));
                if (actionParam == null || actionParam.getResultCode() != 0) {
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.onFailure(null);
                        return;
                    }
                    Context context = context;
                    hte.O000000o(context, DeviceCardApi.O000000o(context, actionParam));
                    return;
                }
                hcz.this.notifyPropChangedListener(str2, fax.O00000Oo(actionParam2.getMiid(), actionParam2.getSiid(), actionParam2.getAiid()), "", System.currentTimeMillis() / 1000, (byte) 5);
                fsm fsm2 = fsm2;
                if (fsm2 != null) {
                    fsm2.onSuccess(null);
                }
                final List<PropertyParam> O000000o2 = hfa.O000000o(str2, -1, new Spec.SpecItem[]{specItem2}, null);
                hcz.this.getDevicePropFromServer(O000000o2, Collections.singletonList(2), new fsm<List<PropertyParam>, fso>() {
                    /* class _m_j.hcz.AnonymousClass9.AnonymousClass1 */

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O00000Oo(List list) {
                        hcz.this.getDevicePropFromServer(list, Collections.singletonList(2), null);
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o(List list) {
                        hcz.this.getDevicePropFromServer(list, Collections.singletonList(2), null);
                    }

                    public final void onFailure(fso fso) {
                        hcz.this.mWorkerHandler.postDelayed(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                              (wrap: android.os.Handler : 0x0004: IGET  (r5v3 android.os.Handler) = 
                              (wrap: _m_j.hcz : 0x0002: IGET  (r5v2 _m_j.hcz) = 
                              (wrap: _m_j.hcz$9 : 0x0000: IGET  (r5v1 _m_j.hcz$9) = (r4v0 'this' _m_j.hcz$9$1 A[THIS]) _m_j.hcz.9.1.O00000Oo _m_j.hcz$9)
                             _m_j.hcz.9.O0000O0o _m_j.hcz)
                             _m_j.hcz.mWorkerHandler android.os.Handler)
                              (wrap: _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE : 0x000a: CONSTRUCTOR  (r1v0 _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE) = 
                              (r4v0 'this' _m_j.hcz$9$1 A[THIS])
                              (wrap: java.util.List : 0x0006: IGET  (r0v0 java.util.List) = (r4v0 'this' _m_j.hcz$9$1 A[THIS]) _m_j.hcz.9.1.O000000o java.util.List)
                             call: _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE.<init>(_m_j.hcz$9$1, java.util.List):void type: CONSTRUCTOR)
                              (1000 long)
                             type: VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean in method: _m_j.hcz.9.1.onFailure(_m_j.fso):void, dex: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r1v0 _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE) = 
                              (r4v0 'this' _m_j.hcz$9$1 A[THIS])
                              (wrap: java.util.List : 0x0006: IGET  (r0v0 java.util.List) = (r4v0 'this' _m_j.hcz$9$1 A[THIS]) _m_j.hcz.9.1.O000000o java.util.List)
                             call: _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE.<init>(_m_j.hcz$9$1, java.util.List):void type: CONSTRUCTOR in method: _m_j.hcz.9.1.onFailure(_m_j.fso):void, dex: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 99 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 105 more
                            */
                        /*
                            this = this;
                            _m_j.hcz$9 r5 = _m_j.hcz.AnonymousClass9.this
                            _m_j.hcz r5 = _m_j.hcz.this
                            android.os.Handler r5 = r5.mWorkerHandler
                            java.util.List r0 = r10
                            _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE r1 = new _m_j.-$$Lambda$hcz$9$1$cUh02izSYNu2zJLZkGKmENI_omE
                            r1.<init>(r4, r0)
                            r2 = 1000(0x3e8, double:4.94E-321)
                            r5.postDelayed(r1, r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: _m_j.hcz.AnonymousClass9.AnonymousClass1.onFailure(_m_j.fso):void");
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Object propValue = hcz.this.getPropValue(str2, specItem2);
                        if (propValue == null || propValue.equals(propValue)) {
                            hcz.this.mWorkerHandler.postDelayed(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: INVOKE  
                                  (wrap: android.os.Handler : 0x0020: IGET  (r5v6 android.os.Handler) = 
                                  (wrap: _m_j.hcz : 0x001e: IGET  (r5v5 _m_j.hcz) = 
                                  (wrap: _m_j.hcz$9 : 0x001c: IGET  (r5v4 _m_j.hcz$9) = (r4v0 'this' _m_j.hcz$9$1 A[THIS]) _m_j.hcz.9.1.O00000Oo _m_j.hcz$9)
                                 _m_j.hcz.9.O0000O0o _m_j.hcz)
                                 _m_j.hcz.mWorkerHandler android.os.Handler)
                                  (wrap: _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20 : 0x0026: CONSTRUCTOR  (r1v2 _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20) = 
                                  (r4v0 'this' _m_j.hcz$9$1 A[THIS])
                                  (wrap: java.util.List : 0x0022: IGET  (r0v2 java.util.List) = (r4v0 'this' _m_j.hcz$9$1 A[THIS]) _m_j.hcz.9.1.O000000o java.util.List)
                                 call: _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20.<init>(_m_j.hcz$9$1, java.util.List):void type: CONSTRUCTOR)
                                  (1000 long)
                                 type: VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean in method: _m_j.hcz.9.1.onSuccess(java.lang.Object):void, dex: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: CONSTRUCTOR  (r1v2 _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20) = 
                                  (r4v0 'this' _m_j.hcz$9$1 A[THIS])
                                  (wrap: java.util.List : 0x0022: IGET  (r0v2 java.util.List) = (r4v0 'this' _m_j.hcz$9$1 A[THIS]) _m_j.hcz.9.1.O000000o java.util.List)
                                 call: _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20.<init>(_m_j.hcz$9$1, java.util.List):void type: CONSTRUCTOR in method: _m_j.hcz.9.1.onSuccess(java.lang.Object):void, dex: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 106 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 112 more
                                */
                            /*
                                this = this;
                                _m_j.hcz$9 r5 = _m_j.hcz.AnonymousClass9.this
                                _m_j.hcz r5 = _m_j.hcz.this
                                _m_j.hcz$9 r0 = _m_j.hcz.AnonymousClass9.this
                                java.lang.String r0 = r4
                                _m_j.hcz$9 r1 = _m_j.hcz.AnonymousClass9.this
                                com.xiaomi.smarthome.device.api.spec.instance.Spec$SpecItem r1 = r6
                                java.lang.Object r5 = r5.getPropValue(r0, r1)
                                if (r5 == 0) goto L_0x001c
                                _m_j.hcz$9 r0 = _m_j.hcz.AnonymousClass9.this
                                java.lang.Object r0 = r7
                                boolean r5 = r5.equals(r0)
                                if (r5 == 0) goto L_0x002e
                            L_0x001c:
                                _m_j.hcz$9 r5 = _m_j.hcz.AnonymousClass9.this
                                _m_j.hcz r5 = _m_j.hcz.this
                                android.os.Handler r5 = r5.mWorkerHandler
                                java.util.List r0 = r10
                                _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20 r1 = new _m_j.-$$Lambda$hcz$9$1$CX2CriEGPAG6p7miBRjOKKwAr20
                                r1.<init>(r4, r0)
                                r2 = 1000(0x3e8, double:4.94E-321)
                                r5.postDelayed(r1, r2)
                            L_0x002e:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: _m_j.hcz.AnonymousClass9.AnonymousClass1.onSuccess(java.lang.Object):void");
                        }
                    });
                }

                public final void onFailure(fso fso) {
                    hte.O00000Oo(context, R.string.toast_failed_retry);
                    gsy.O000000o(6, "mijia-card", "setDeviceSpecAction onFailure".concat(String.valueOf(fso)));
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                        return;
                    }
                    Context context = context;
                    hte.O000000o(context, context.getString(R.string.network_not_stable));
                }
            });
        }

        public String getLanguageMap(String str) {
            return this.mLanguageMap.get(translateName(str));
        }

        public hez getUnitMap(String str) {
            return this.mUnitMap.get(translateName(str));
        }

        public heo getComplexUnitMap(String str) {
            return this.mComplexUnitMap.get(str);
        }

        public List<hee.O00000Oo> getPropExtraMap(String str) {
            return this.mPropExtraMap.get(translateName(str));
        }

        public String getValueName(Device device, Spec.SpecItem specItem, String str, Object obj) {
            String str2;
            String str3;
            Map<String, String> specLanguage = getSpecLanguage(device);
            String O000000o2 = fax.O000000o(specItem);
            if (obj != null && !"".equals(obj) && (specItem instanceof SpecProperty)) {
                O000000o2 = O000000o2 + "." + hfa.O00000Oo((SpecProperty) specItem, obj);
            }
            Spec parent = specItem.getParent();
            if (specLanguage != null) {
                String str4 = specLanguage.get(O000000o2);
                if (!TextUtils.isEmpty(str4)) {
                    gsy.O00000Oo("mijia-card", "CardItem.getSpecPropValueName match specLanguage value:" + obj + " key:" + O000000o2 + " showText:" + str4);
                    return str4;
                }
            }
            String typeName = parent.getTypeName();
            String description = parent.getDescription();
            String description2 = specItem.getDefinition().getDescription();
            String typeName2 = specItem.getParent().getParent().getTypeName();
            if (TextUtils.isEmpty(str)) {
                if (obj == null || obj.equals("")) {
                    str = description2;
                } else if (obj instanceof Boolean) {
                    str = description2 + "_" + (((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    str = description2 + "_" + obj;
                }
            }
            String str5 = null;
            if (!str.equals(description2)) {
                str5 = typeName2 + "_" + typeName + "_" + description2 + "_" + str;
                str2 = getLanguageMap(str5);
                if (str2 == null) {
                    str5 = typeName2 + "_" + description + "_" + description2 + "_" + str;
                    str2 = getLanguageMap(str5);
                }
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str5 = typeName2 + "_" + typeName + "_" + str;
                str2 = getLanguageMap(str5);
            }
            if (str2 == null) {
                str5 = typeName2 + "_" + description + "_" + str;
                str2 = getLanguageMap(str5);
            }
            if (str2 == null) {
                str5 = typeName + "_" + str;
                str2 = getLanguageMap(str5);
            }
            if (str2 == null) {
                str3 = description + "_" + str;
                str2 = getLanguageMap(str3);
            } else {
                str3 = str5;
            }
            if (str2 == null) {
                str2 = getLanguageMap(str);
                str3 = str;
            }
            if (str2 == null) {
                gsy.O000000o(6, "mijia-card", "CardItem.getSpecPropValueName notmatch value:" + obj + " config:" + typeName2 + "_" + typeName + "_" + description2 + "_" + str);
                return "";
            }
            gsy.O00000Oo("mijia-card", "CardItem.getSpecPropValueName match value:" + obj + " config:" + str3 + " showText:" + str2);
            return str2;
        }

        public Object getPropValue(String str, Spec.SpecItem specItem) {
            hdi hdi;
            Map<String, hdi> propsMap = getPropsMap(str);
            if (propsMap == null || specItem == null || specItem.getParent() == null || (hdi = propsMap.get(fax.O000000o(specItem))) == null) {
                return null;
            }
            return hdi.f18812O000000o;
        }

        public String getSpecInstanceStr(String str) {
            SpecDevice specInstance = getSpecInstance(fbd.O000000o().getDeviceByDid(str));
            if (specInstance == null) {
                return "";
            }
            return hfd.O000000o(specInstance).toString();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
         arg types: [java.lang.String, java.util.ArrayList]
         candidates:
          org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject */
        public String getSpecProptyValueStr(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", "");
            } catch (JSONException e) {
                gsy.O00000o0(LogType.CARD, "miot-spec", e.toString());
            }
            Map<String, hdi> propsMap = getPropsMap(str);
            if (propsMap == null) {
                try {
                    jSONObject.put("result", "");
                } catch (JSONException e2) {
                    gsy.O00000o0(LogType.CARD, "miot-spec", e2.toString());
                }
                return jSONObject.toString();
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : propsMap.entrySet()) {
                String str2 = (String) next.getKey();
                Object obj = ((hdi) next.getValue()).f18812O000000o;
                if (!TextUtils.isEmpty(str2)) {
                    String[] split = str2.split("\\.");
                    if (split.length == 2) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("did", str);
                            jSONObject2.put("ssid", split[0]);
                            jSONObject2.put("ppid", split[1]);
                            jSONObject2.put("code", obj);
                            arrayList.add(jSONObject2);
                        } catch (JSONException e3) {
                            gsy.O00000o0(LogType.CARD, "miot-spec", e3.toString());
                        }
                    }
                }
            }
            try {
                jSONObject.put("result", (Object) arrayList);
            } catch (JSONException e4) {
                gsy.O00000o0(LogType.CARD, "miot-spec", e4.toString());
            }
            return jSONObject.toString();
        }

        public Pair<SpecService, SpecProperty> checkSupportPower(Device device) {
            Pair<SpecService, SpecProperty> pair;
            SpecDevice specInstance = getSpecInstance(device);
            if (specInstance == null || "camera".equals(specInstance.getTypeName())) {
                return null;
            }
            int i = 0;
            Map<Integer, SpecService> services = specInstance.getServices();
            if (services != null) {
                Pair<SpecService, SpecProperty> pair2 = null;
                int i2 = 0;
                for (SpecService next : services.values()) {
                    for (SpecProperty next2 : next.getProperties().values()) {
                        if (next2.getPropertyDefinition().getTypeName().equals("on")) {
                            i2++;
                            pair2 = new Pair<>(next, next2);
                        }
                    }
                }
                pair = pair2;
                i = i2;
            } else {
                pair = null;
            }
            if (i == 1) {
                return pair;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public File getCacheFile() {
            if (!fcn.O000000o().O0000OOo()) {
                return null;
            }
            File file = new File(fkw.O000000o(CommonApplication.getAppContext()) + File.separator + fcn.O000000o().O00000Oo() + "_control_props_spec");
            if (!file.exists()) {
                file.getParentFile().mkdir();
            }
            return file;
        }

        public void destroy() {
            if (CommonApplication.getAppContext() != null && !CardActive.instance.isActive()) {
                this.subscribe.dispose();
                this.mWorkerHandler.post(new Runnable() {
                    /* class _m_j.$$Lambda$7wkEXv3mtvlejo57WiVcmHkFK4M */

                    public final void run() {
                        hcz.this.savePropsCache();
                    }
                });
                frb frb = this.mDevicePropSubscriber;
                if (frb != null) {
                    frb.destroy();
                    this.mDevicePropSubscriber = null;
                }
            }
        }

        public void isReady(Runnable runnable) {
            if (runnable != null) {
                ArrayList<Runnable> arrayList = this.mReadyCallback;
                if (arrayList == null) {
                    runnable.run();
                } else {
                    arrayList.add(runnable);
                }
            }
        }
    }
