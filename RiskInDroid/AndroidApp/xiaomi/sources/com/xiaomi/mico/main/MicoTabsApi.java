package com.xiaomi.mico.main;

import _m_j.fss;
import _m_j.gpy;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONObject;

public class MicoTabsApi {
    private static final String CACHED_DATA = ("_cached_data_" + CoreApi.O000000o().O0000o0());
    private static volatile MicoTabsApi sMicoTabsApi;
    public OnTabsInfoReadyListener mOnTabsReadyListener;

    public interface OnTabsInfoReadyListener {
        void onErrorTabs();

        void onTabsInfoReady(List<TabInfo> list);
    }

    private static String getUserSpecPrefs() {
        return "prefs_lite_config";
    }

    private MicoTabsApi() {
    }

    public static MicoTabsApi getInstance() {
        if (sMicoTabsApi == null) {
            synchronized (MicoTabsApi.class) {
                if (sMicoTabsApi == null) {
                    sMicoTabsApi = new MicoTabsApi();
                }
            }
        }
        return sMicoTabsApi;
    }

    public void getMicoTabInfo(OnTabsInfoReadyListener onTabsInfoReadyListener, String str) {
        this.mOnTabsReadyListener = onTabsInfoReadyListener;
        ApiHelper.getTabInfo(hasDevice(), str, new ApiRequest.Listener<MicoTabsInfo>() {
            /* class com.xiaomi.mico.main.MicoTabsApi.AnonymousClass1 */

            public void onSuccess(MicoTabsInfo micoTabsInfo) {
                if (MicoTabsApi.this.mOnTabsReadyListener != null) {
                    MicoTabsApi.this.mOnTabsReadyListener.onTabsInfoReady(micoTabsInfo.getList());
                }
            }

            public void onFailure(ApiError apiError) {
                if (MicoTabsApi.this.mOnTabsReadyListener != null) {
                    MicoTabsApi.this.mOnTabsReadyListener.onErrorTabs();
                }
            }
        });
    }

    public static <T> Observable<T> fetch(gsj gsj, fss<T> fss) {
        return Observable.create(new ObservableOnSubscribe(fss) {
            /* class com.xiaomi.mico.main.$$Lambda$MicoTabsApi$q2Li_Ob06tm1cuFRPAg4g5Ws6k */
            private final /* synthetic */ fss f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                MicoTabsApi.lambda$fetch$0(gsj.this, this.f$1, observableEmitter);
            }
        });
    }

    static /* synthetic */ void lambda$fetch$0(gsj gsj, final fss fss, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class com.xiaomi.mico.main.MicoTabsApi.AnonymousClass2 */

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

    public void setCachedTabInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context appContext = CommonApplication.getAppContext();
            String userSpecPrefs = getUserSpecPrefs();
            gpy.O000000o(appContext, userSpecPrefs, getCachedKey() + CACHED_DATA, str);
        }
    }

    public String getCachedTabInfo() {
        Context appContext = CommonApplication.getAppContext();
        String userSpecPrefs = getUserSpecPrefs();
        return gpy.O00000o0(appContext, userSpecPrefs, getCachedKey() + CACHED_DATA, "");
    }

    /* access modifiers changed from: protected */
    public String getCachedKey() {
        return getClass().getSimpleName();
    }

    public boolean hasDevice() {
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        return !TextUtils.isEmpty(currentMico.deviceID) && !TextUtils.isEmpty(currentMico.serialNumber);
    }

    public void removeTabsReadyListener() {
        this.mOnTabsReadyListener = null;
    }
}
