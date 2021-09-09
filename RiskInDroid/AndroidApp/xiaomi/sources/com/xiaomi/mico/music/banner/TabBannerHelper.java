package com.xiaomi.mico.music.banner;

import _m_j.ftd;
import _m_j.gpp;
import _m_j.gsi;
import _m_j.gsj;
import _m_j.gsy;
import _m_j.hsk;
import android.text.TextUtils;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.main.MicoTabsApi;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TabBannerHelper {
    private static volatile TabBannerHelper sInstance;
    private volatile boolean mIsCacheLoaded = false;
    public AtomicBoolean mIsLoading = new AtomicBoolean(false);
    public BehaviorSubject<Map<Integer, Banner>> mSubject = BehaviorSubject.create();

    private static boolean usingStgDev() {
        return false;
    }

    private TabBannerHelper() {
    }

    public static TabBannerHelper getInstance() {
        if (sInstance == null) {
            synchronized (TabBannerHelper.class) {
                if (sInstance == null) {
                    sInstance = new TabBannerHelper();
                }
            }
        }
        return sInstance;
    }

    public void updateBanner() {
        Observable<Map<Integer, Banner>> observable;
        if (!this.mIsLoading.getAndSet(true)) {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                /* class com.xiaomi.mico.music.banner.$$Lambda$TabBannerHelper$hm2xuzalzOHXzROeNUCAJu2is */

                public final void run() {
                    TabBannerHelper.this.lambda$updateBanner$0$TabBannerHelper();
                }
            }, 5000);
            if (this.mIsCacheLoaded) {
                observable = Observable.empty();
            } else {
                observable = loadFromCache();
            }
            this.mIsCacheLoaded = true;
            observable.mergeWith(getBanners()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Map<Integer, Banner>>() {
                /* class com.xiaomi.mico.music.banner.TabBannerHelper.AnonymousClass1 */

                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    onNext((Map<Integer, Banner>) ((Map) obj));
                }

                public void onSubscribe(Disposable disposable) {
                    gsy.O00000Oo("TabBannerHelper", "updateBanner onSubscribe");
                }

                public void onNext(Map<Integer, Banner> map) {
                    TabBannerHelper.this.mSubject.onNext(map);
                    gsy.O00000Oo("TabBannerHelper", "updateBanner onNext");
                }

                public void onError(Throwable th) {
                    gsy.O00000Oo("TabBannerHelper", "updateBanner onError");
                    TabBannerHelper.this.mIsLoading.set(false);
                }

                public void onComplete() {
                    gsy.O00000Oo("TabBannerHelper", "updateBanner onComplete");
                    TabBannerHelper.this.mIsLoading.set(false);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updateBanner$0$TabBannerHelper() {
        this.mIsLoading.set(false);
    }

    private Observable<Map<Integer, Banner>> loadFromCache() {
        return Observable.create(new ObservableOnSubscribe<Map<Integer, Banner>>() {
            /* class com.xiaomi.mico.music.banner.TabBannerHelper.AnonymousClass2 */

            public void subscribe(ObservableEmitter<Map<Integer, Banner>> observableEmitter) throws Exception {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onNext(TabBannerStore.parseFromCache());
                }
            }
        });
    }

    public Observable<Map<Integer, Banner>> getBanner() {
        return this.mSubject;
    }

    private Observable<Map<Integer, Banner>> getBanners() {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(3);
        stringBuffer.append(",4,5");
        stringBuffer.append(",6");
        arrayList.add(new gsi("typeIds", stringBuffer.toString()));
        String O00000Oo = usingStgDev() ? "http://st.iot.home.mi.com" : hsk.O00000Oo(CommonApplication.getAppContext());
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        gsj.O000000o O00000Oo2 = o000000o.O00000Oo(O00000Oo + "/cgi-op/api/v1/content/toApp/tab/banner");
        O00000Oo2.O00000oO = arrayList;
        return MicoTabsApi.fetch(O00000Oo2.O000000o(), $$Lambda$TabBannerHelper$59YDZTfn7oNWYz5bE89LxRXs.INSTANCE);
    }

    static /* synthetic */ Map lambda$getBanners$1(JSONObject jSONObject) throws JSONException {
        gsy.O00000Oo("TabBannerHelper", "getBanners:".concat(String.valueOf(jSONObject)));
        String jSONObject2 = jSONObject.toString();
        TabBannerStore.saveToStore(jSONObject2);
        return TabBannerStore.parse(jSONObject2);
    }

    static class TabBannerStore {
        private TabBannerStore() {
        }

        private static String getFilePath() {
            return ServiceApplication.getAppContext().getFilesDir() + File.separator + "mico" + File.separator + "mico_tab_banner_data" + gpp.O000000o(CoreApi.O000000o().O0000o0());
        }

        public static void saveToStore(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                gsy.O00000Oo("TabBannerHelper", "saveToStore start");
                jSONObject.put("save_ts", System.currentTimeMillis());
                jSONObject.put("data", str);
                ftd.O000000o(jSONObject.toString(), getFilePath());
            } catch (Exception e) {
                gsy.O00000Oo("TabBannerHelper", "saveToStore exception " + e.getMessage());
                e.printStackTrace();
            }
        }

        public static Map<Integer, Banner> parseFromCache() {
            try {
                gsy.O00000Oo("TabBannerHelper", "parseFromCache start");
                return parse(ftd.O0000O0o(getFilePath()));
            } catch (Exception e) {
                gsy.O00000Oo("TabBannerHelper", "parseFromCache exeption " + e.getMessage());
                e.printStackTrace();
                return new HashMap();
            }
        }

        public static Map<Integer, Banner> parse(String str) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            JSONArray optJSONArray2;
            HashMap hashMap = new HashMap();
            try {
                if (!(TextUtils.isEmpty(str) || (optJSONObject = new JSONObject(str).optJSONObject("data")) == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null)) {
                    if (optJSONArray.length() != 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            String optString = optJSONObject2.optString("type");
                            int optInt = optJSONObject2.optInt("typeId");
                            if (!(TextUtils.isEmpty(optString) || (optJSONArray2 = optJSONObject2.optJSONArray("cards")) == null || optJSONArray2.length() == 0)) {
                                ArrayList arrayList = new ArrayList(optJSONObject.length());
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject3 != null) {
                                        Banner.Item item = new Banner.Item();
                                        Banner.Data data = new Banner.Data();
                                        data.id = optJSONObject3.optInt("id");
                                        data.url = optJSONObject3.optString("jumpLink");
                                        data.image = optJSONObject3.optString("picture");
                                        data.mainTitle = optJSONObject3.optString("mainTitle");
                                        item.data = data;
                                        arrayList.add(item);
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    Banner banner = new Banner();
                                    banner.banners = arrayList;
                                    banner.view_type = optString;
                                    banner.typeId = optInt;
                                    hashMap.put(Integer.valueOf(optInt), banner);
                                }
                            }
                        }
                        return hashMap;
                    }
                }
                return hashMap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
