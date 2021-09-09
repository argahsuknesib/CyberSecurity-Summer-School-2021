package _m_j;

import _m_j.gvk;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@RouterService
public class gve implements gvd {
    private static volatile gve INSTANCE;
    public Set<String> mDeviceSyncSet = new HashSet();
    public Map<String, gvj> mMiBrainTips = new ConcurrentHashMap();
    public Set<String> mSupportMiBrainCtrlDids = new HashSet();
    public gvk mVoiceDeviceListInfo;

    @cug
    public static gve getInstance() {
        if (INSTANCE == null) {
            synchronized (gve.class) {
                if (INSTANCE == null) {
                    INSTANCE = new gve();
                }
            }
        }
        return INSTANCE;
    }

    public void destroy() {
        INSTANCE = null;
    }

    public void clear() {
        this.mSupportMiBrainCtrlDids.clear();
        this.mMiBrainTips.clear();
        INSTANCE = new gve();
    }

    public List<gvl> getMiBrainAiDevices(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            return new ArrayList();
        }
        gvj gvj = this.mMiBrainTips.get(O000000o2.model);
        if (gvj == null || gvj.f18377O000000o == null) {
            return new ArrayList();
        }
        return gvj.f18377O000000o;
    }

    public void syncDeviceIsMiBrain(List<String> list, boolean z, final fsm fsm) {
        if (ggb.O0000o00()) {
            if (fsm != null) {
                fsm.onFailure(null);
            }
        } else if (list != null && list.size() != 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (fno.O000000o().O000000o(list.get(size)) == null) {
                    list.remove(size);
                }
            }
            if (list.size() != 0) {
                if (!z) {
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(list);
                    hashSet.retainAll(this.mDeviceSyncSet);
                    if (!hashSet.isEmpty()) {
                        hashSet.removeAll(list);
                        if (hashSet.isEmpty()) {
                            if (fsm != null) {
                                fsm.onSuccess(this.mVoiceDeviceListInfo);
                                return;
                            }
                            return;
                        }
                    }
                }
                try {
                    ggy.O000000o().O00000Oo();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    updateMiBrainCtrlDidAndMore(arrayList).subscribe(new Observer<gvk>() {
                        /* class _m_j.gve.AnonymousClass1 */

                        public final void onComplete() {
                        }

                        public final void onSubscribe(Disposable disposable) {
                        }

                        public final /* synthetic */ void onNext(Object obj) {
                            List<gvk.O000000o> list;
                            gvk gvk = (gvk) obj;
                            gve.this.mVoiceDeviceListInfo = gvk;
                            if (!(gvk == null || (list = gvk.f18378O000000o) == null || list.size() <= 0)) {
                                HashSet hashSet = new HashSet();
                                for (gvk.O000000o next : list) {
                                    if (next != null && !TextUtils.isEmpty(next.f18379O000000o)) {
                                        hashSet.add(next.f18379O000000o);
                                    }
                                }
                                gve.this.mSupportMiBrainCtrlDids = hashSet;
                            }
                            if (gvk != null) {
                                fsm fsm = fsm;
                                if (fsm != null) {
                                    fsm.onSuccess(gve.this.mVoiceDeviceListInfo);
                                    return;
                                }
                                return;
                            }
                            fsm fsm2 = fsm;
                            if (fsm2 != null) {
                                fsm2.onFailure(null);
                            }
                        }

                        public final void onError(Throwable th) {
                            fsm fsm = fsm;
                            if (fsm != null) {
                                fsm.onFailure(new fso(-1, th.getMessage()));
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    if (fsm != null) {
                        fsm.onFailure(new fso(-1, e.getMessage()));
                    }
                }
            } else if (fsm != null) {
                fsm.onFailure(null);
            }
        } else if (fsm != null) {
            fsm.onFailure(null);
        }
    }

    public void syncMiBrainDeviceIfNeed(final String str, boolean z, final fsm fsm) {
        if (ggb.O0000o00()) {
            if (fsm != null) {
                fsm.onSuccess(new Object());
            }
        } else if (!this.mDeviceSyncSet.contains(str) || z) {
            final Device O000000o2 = fno.O000000o().O000000o(str);
            if (O000000o2 != null) {
                try {
                    ggy.O000000o().O00000Oo();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    updateMiBrainCtrlDidAndMore(arrayList).flatMap(new Function<gvk, ObservableSource<gvj>>() {
                        /* class _m_j.gve.AnonymousClass4 */

                        public final /* synthetic */ Object apply(Object obj) throws Exception {
                            gvk gvk = (gvk) obj;
                            if (gvk == null) {
                                return Observable.error(new Exception("dids is empty"));
                            }
                            gve.this.mVoiceDeviceListInfo = gvk;
                            List<gvk.O000000o> list = gvk.f18378O000000o;
                            if (list != null && list.size() > 0) {
                                HashSet hashSet = new HashSet();
                                for (gvk.O000000o next : list) {
                                    if (next != null && !TextUtils.isEmpty(next.f18379O000000o)) {
                                        hashSet.add(next.f18379O000000o);
                                    }
                                }
                                gve.this.mSupportMiBrainCtrlDids = hashSet;
                                if (!hashSet.contains(str)) {
                                    return Observable.error(new Exception("dids is empty"));
                                }
                            }
                            return gve.this.updateMiBrainTips(str);
                        }
                    }).map(new Function<gvj, Object>() {
                        /* class _m_j.gve.AnonymousClass3 */

                        public final /* synthetic */ Object apply(Object obj) throws Exception {
                            gve.this.mDeviceSyncSet.add(str);
                            gve.this.mMiBrainTips.put(O000000o2.model, (gvj) obj);
                            return new Object();
                        }
                    }).subscribe(new Observer<Object>() {
                        /* class _m_j.gve.AnonymousClass2 */

                        public final void onNext(Object obj) {
                        }

                        public final void onSubscribe(Disposable disposable) {
                        }

                        public final void onError(Throwable th) {
                            fsm fsm = fsm;
                            if (fsm != null) {
                                fsm.onFailure(new fso(-1, th.getMessage()));
                            }
                        }

                        public final void onComplete() {
                            fsm fsm = fsm;
                            if (fsm != null) {
                                fsm.onSuccess(null);
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    if (fsm != null) {
                        fsm.onFailure(new fso(-1, e.getMessage()));
                    }
                }
            } else if (fsm != null) {
                fsm.onFailure(null);
            }
        } else if (fsm != null) {
            fsm.onSuccess(new Object());
        }
    }

    private Observable<gvk> updateMiBrainCtrlDidAndMore(final List<String> list) {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return Observable.error(new IllegalStateException("not login"));
        }
        return Observable.create(new ObservableOnSubscribe<gvk>() {
            /* class _m_j.gve.AnonymousClass5 */

            public final void subscribe(final ObservableEmitter<gvk> observableEmitter) throws Exception {
                fru.O000000o().O00000oO(list, new fsm<JSONObject, fso>() {
                    /* class _m_j.gve.AnonymousClass5.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject == null) {
                            observableEmitter.onError(new Exception("result is null"));
                            return;
                        }
                        try {
                            observableEmitter.onNext(gvk.O000000o(jSONObject));
                            observableEmitter.onComplete();
                        } catch (Exception e) {
                            observableEmitter.onError(e);
                            e.printStackTrace();
                        }
                    }

                    public final void onFailure(fso fso) {
                        gsy.O00000Oo(LogType.GENERAL, "MiBrainManager", "updateCtrlDid error:".concat(String.valueOf(fso)));
                        observableEmitter.onError(new Exception(fso.O00000Oo));
                    }
                });
            }
        });
    }

    public List<String> getMasterControlDevice(String str) {
        ArrayList arrayList = new ArrayList();
        List<Device> O0000Oo = ggb.O00000Oo().O0000Oo();
        if (O0000Oo != null && !O0000Oo.isEmpty()) {
            for (int i = 0; i < O0000Oo.size(); i++) {
                Device device = O0000Oo.get(i);
                if (device != null && device.voiceCtrl == 2) {
                    arrayList.add(device.did);
                }
            }
        }
        return arrayList;
    }

    public Observable<gvj> updateMiBrainTips(final String str) {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return Observable.error(new IllegalStateException("not login"));
        }
        return Observable.just(str).flatMap(new Function<String, ObservableSource<gvj>>() {
            /* class _m_j.gve.AnonymousClass6 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                final String str = (String) obj;
                return Observable.create(new ObservableOnSubscribe<gvj>() {
                    /* class _m_j.gve.AnonymousClass6.AnonymousClass1 */

                    public final void subscribe(final ObservableEmitter<gvj> observableEmitter) throws Exception {
                        fru.O000000o().O000000o(str, gve.this.getMasterControlDevice(str), new fsm<JSONObject, fso>() {
                            /* class _m_j.gve.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                JSONObject jSONObject = (JSONObject) obj;
                                gsy.O00000Oo(LogType.GENERAL, "MiBrainManager", jSONObject == null ? "" : jSONObject.toString());
                                observableEmitter.onNext(gve.this.extractTips(jSONObject));
                                observableEmitter.onComplete();
                            }

                            public final void onFailure(fso fso) {
                                gsy.O00000Oo(LogType.GENERAL, "MiBrainManager", "updateMiBrainTips error:".concat(String.valueOf(fso)));
                                observableEmitter.onError(new Exception(fso.O00000Oo));
                            }
                        });
                    }
                });
            }
        });
    }

    public void enableXiaoAiBleSwitch(String str, String str2, final fsm fsm) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        enableXiaoAiBleSwitchOb(str, arrayList).subscribe(new Observer<Object>() {
            /* class _m_j.gve.AnonymousClass7 */

            public final void onComplete() {
            }

            public final void onSubscribe(Disposable disposable) {
            }

            public final void onNext(Object obj) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(new Object());
                }
            }

            public final void onError(Throwable th) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(new fso(-1, th.getMessage()));
                }
            }
        });
    }

    private Observable<Object> enableXiaoAiBleSwitchOb(final String str, final List<String> list) {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return Observable.error(new IllegalStateException("not login"));
        }
        return Observable.create(new ObservableOnSubscribe<Object>() {
            /* class _m_j.gve.AnonymousClass8 */

            public final void subscribe(final ObservableEmitter<Object> observableEmitter) throws Exception {
                fru.O000000o().O00000Oo(str, list, new fsm<JSONObject, fso>() {
                    /* class _m_j.gve.AnonymousClass8.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (((JSONObject) obj) == null) {
                            observableEmitter.onError(new Exception("result is null"));
                            return;
                        }
                        try {
                            observableEmitter.onNext(new Object());
                            observableEmitter.onComplete();
                        } catch (Exception e) {
                            observableEmitter.onError(e);
                            e.printStackTrace();
                        }
                    }

                    public final void onFailure(fso fso) {
                        observableEmitter.onError(new Exception(fso.O00000Oo));
                    }
                });
            }
        });
    }

    public gvj extractTips(JSONObject jSONObject) {
        gvj gvj = new gvj();
        if (jSONObject == null) {
            return gvj;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("ai_devices");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    gvl gvl = new gvl();
                    String optString = optJSONObject.optString("ctrl_did");
                    String optString2 = optJSONObject.optString("method");
                    gvl gvl2 = null;
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        gvl.f18380O000000o = optString;
                        gvl.O00000Oo = optString2;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("device");
                        if (optJSONObject2 != null) {
                            gvm O000000o2 = gvm.O000000o(optJSONObject2);
                            if (O000000o2 != null) {
                                gvl.O00000o0 = O000000o2;
                            }
                        }
                        gvl2 = gvl;
                    }
                    if (gvl2 != null) {
                        arrayList.add(gvl2);
                    }
                }
            }
            gvj.f18377O000000o = arrayList;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("device");
        if (optJSONObject3 != null) {
            gvj.O00000Oo = gvm.O000000o(optJSONObject3);
        }
        gvj.O00000o0 = jSONObject.optString("query");
        return gvj;
    }
}
