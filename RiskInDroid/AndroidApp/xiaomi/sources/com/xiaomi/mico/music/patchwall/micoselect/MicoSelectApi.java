package com.xiaomi.mico.music.patchwall.micoselect;

import _m_j.fss;
import _m_j.gpy;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsi;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mico.main.MicoTabsApi;
import com.xiaomi.mico.music.patchwall.micoselect.model.MicoSelectInfo;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class MicoSelectApi {
    private static volatile MicoSelectApi sMicoSelectApi;
    private Disposable mFetchDisposable;
    private final BehaviorSubject<List<MicoSelectInfo>> mMicoSelectSubject = BehaviorSubject.create();
    private OnSelectInfoReadyListener mOnSelectInfoReadyListener;

    public interface OnSelectInfoReadyListener {
        void onSelectInfoReady(List<MicoSelectInfo> list);
    }

    private static String getUserSpecPrefs() {
        return "prefs_lite_config";
    }

    private static boolean usingStgDev() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onError(Throwable th) {
    }

    private MicoSelectApi() {
    }

    public static MicoSelectApi getInstance() {
        if (sMicoSelectApi == null) {
            synchronized (MicoSelectApi.class) {
                if (sMicoSelectApi == null) {
                    sMicoSelectApi = new MicoSelectApi();
                }
            }
        }
        return sMicoSelectApi;
    }

    public void init(OnSelectInfoReadyListener onSelectInfoReadyListener, boolean z) {
        if (!haveValidResponse()) {
            this.mOnSelectInfoReadyListener = onSelectInfoReadyListener;
            this.mFetchDisposable = getSelectInfo(z).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.$$Lambda$MicoSelectApi$4ijFnaaupH2gzJjljj8DdSisU0 */

                public final void accept(Object obj) {
                    MicoSelectApi.this.lambda$init$0$MicoSelectApi((List) obj);
                }
            }, new Consumer<Throwable>() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectApi.AnonymousClass1 */

                public void accept(Throwable th) throws Exception {
                    gsy.O000000o(3, "MicoTabsApi", "accept: " + Log.getStackTraceString(th));
                }
            });
        }
    }

    public /* synthetic */ void lambda$init$0$MicoSelectApi(List list) throws Exception {
        try {
            onSelectInfoReady(list);
            gsy.O00000Oo("MicoTabsApi", "onTabInfoReady: ");
        } catch (Exception e) {
            onError(e);
        }
    }

    public boolean haveValidResponse() {
        return this.mMicoSelectSubject.hasValue();
    }

    public List<MicoSelectInfo> getSelectInfo() {
        return this.mMicoSelectSubject.getValue();
    }

    private Observable<List<MicoSelectInfo>> getSelectInfo(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gsi("uid", CoreApi.O000000o().O0000o0()));
        arrayList.add(new gsi("platform", "2"));
        String str = z ? "/cgi-op/api/v1/content/toApp/xiaoai/handpick" : "/cgi-op/api/v1/content/toApp/noDevice/handpick";
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        gsj.O000000o O00000Oo = o000000o.O00000Oo("http://st.iot.home.mi.com".concat(str));
        O00000Oo.O00000oO = arrayList;
        return fetch(O00000Oo.O000000o(), new fss() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.$$Lambda$MicoSelectApi$yTCvyEJ_dp00RTl5Srq_dZxbyk */

            public final Object parse(JSONObject jSONObject) {
                return MicoSelectApi.this.lambda$getSelectInfo$1$MicoSelectApi(jSONObject);
            }
        });
    }

    public /* synthetic */ List lambda$getSelectInfo$1$MicoSelectApi(JSONObject jSONObject) throws JSONException {
        gsy.O00000Oo("MicoTabsApi", "TabInfo: ".concat(String.valueOf(jSONObject)));
        String jSONObject2 = jSONObject.toString();
        setCachedTabInfo(jSONObject2);
        List<MicoSelectInfo> parse = MicoSelectInfo.parse(jSONObject2);
        for (MicoSelectInfo micoSelectInfo : parse) {
            micoSelectInfo.isFromCache = false;
        }
        return parse;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        Disposable disposable = this.mFetchDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        synchronized (MicoTabsApi.class) {
            sMicoSelectApi = null;
        }
    }

    public static <T> Observable<T> fetch(gsj gsj, fss<T> fss) {
        return Observable.create(new ObservableOnSubscribe(fss) {
            /* class com.xiaomi.mico.music.patchwall.micoselect.$$Lambda$MicoSelectApi$zThWo8SWqtmqZ2ZKK7yi6NFcyM */
            private final /* synthetic */ fss f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                MicoSelectApi.lambda$fetch$2(gsj.this, this.f$1, observableEmitter);
            }
        });
    }

    static /* synthetic */ void lambda$fetch$2(gsj gsj, final fss fss, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectApi.AnonymousClass2 */

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                }

                public final void onSuccess(Object obj, Response response) {
                }

                public final void processResponse(Response response) {
                    if (!observableEmitter.isDisposed()) {
                        try {
                            observableEmitter.onNext(fss.parse(new JSONObject(response.body().string())));
                            observableEmitter.onComplete();
                        } catch (Exception e) {
                            observableEmitter.onError(e);
                            e.printStackTrace();
                        }
                    }
                }

                public final void processFailure(Call call, IOException iOException) {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onError(iOException);
                    }
                }
            });
        }
    }

    public void onSelectInfoReady(List<MicoSelectInfo> list) {
        OnSelectInfoReadyListener onSelectInfoReadyListener = this.mOnSelectInfoReadyListener;
        if (onSelectInfoReadyListener != null) {
            onSelectInfoReadyListener.onSelectInfoReady(list);
        }
    }

    public void OnSelectInfoReadyListener(OnSelectInfoReadyListener onSelectInfoReadyListener) {
        this.mOnSelectInfoReadyListener = onSelectInfoReadyListener;
    }

    public void setCachedTabInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context appContext = CommonApplication.getAppContext();
            String userSpecPrefs = getUserSpecPrefs();
            gpy.O000000o(appContext, userSpecPrefs, getCachedKey() + "_cached_data", str);
        }
    }

    public String getCachedTabInfo() {
        Context appContext = CommonApplication.getAppContext();
        String userSpecPrefs = getUserSpecPrefs();
        return gpy.O00000o0(appContext, userSpecPrefs, getCachedKey() + "_cached_data", "");
    }

    /* access modifiers changed from: protected */
    public String getCachedKey() {
        return getClass().getSimpleName();
    }
}
