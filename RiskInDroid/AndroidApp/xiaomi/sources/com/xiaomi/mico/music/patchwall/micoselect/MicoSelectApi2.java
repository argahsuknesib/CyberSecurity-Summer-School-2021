package com.xiaomi.mico.music.patchwall.micoselect;

import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsi;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.hsk;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.music.patchwall.micoselect.MicoSelectApi;
import com.xiaomi.mico.music.patchwall.micoselect.model.MicoHandpickInfo;
import com.xiaomi.mico.music.patchwall.micoselect.model.MicoSelectInfo;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

public class MicoSelectApi2 {
    private static volatile MicoSelectApi2 sMicoSelectApi;

    private static boolean usingStgDev() {
        return false;
    }

    private MicoSelectApi2() {
    }

    public static MicoSelectApi2 getInstance() {
        if (sMicoSelectApi == null) {
            synchronized (MicoSelectApi.class) {
                if (sMicoSelectApi == null) {
                    sMicoSelectApi = new MicoSelectApi2();
                }
            }
        }
        return sMicoSelectApi;
    }

    private void getSelectInfo(boolean z, final MicoSelectApi.OnSelectInfoReadyListener onSelectInfoReadyListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gsi("uid", CoreApi.O000000o().O0000o0()));
        arrayList.add(new gsi("platform", "2"));
        String str = z ? "/cgi-op/api/v1/content/toApp/xiaoai/handpick" : "/cgi-op/api/v1/content/toApp/noDevice/handpick";
        String O00000Oo = usingStgDev() ? "http://st.iot.home.mi.com" : hsk.O00000Oo(CommonApplication.getAppContext());
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        gsj.O000000o O00000Oo2 = o000000o.O00000Oo(O00000Oo + str);
        O00000Oo2.O00000oO = arrayList;
        gsg.O00000Oo(O00000Oo2.O000000o(), new gsl() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectApi2.AnonymousClass1 */

            public void onSuccess(Object obj, Response response) {
            }

            public void processResponse(Response response) {
                try {
                    List<MicoSelectInfo> parse = MicoSelectInfo.parse(response.body().string());
                    if (onSelectInfoReadyListener != null) {
                        onSelectInfoReadyListener.onSelectInfoReady(parse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    onSelectInfoReadyListener.onSelectInfoReady(null);
                }
            }

            public void processFailure(Call call, IOException iOException) {
                onSelectInfoReadyListener.onSelectInfoReady(null);
            }

            public void onFailure(gsf gsf, Exception exc, Response response) {
                onSelectInfoReadyListener.onSelectInfoReady(null);
            }
        });
    }

    public void getSelectApi(boolean z, final MicoSelectApi.OnSelectInfoReadyListener onSelectInfoReadyListener) {
        ApiHelper.getMicoSelectInfo(z, new ApiRequest.Listener<MicoHandpickInfo>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectApi2.AnonymousClass2 */

            public void onSuccess(MicoHandpickInfo micoHandpickInfo) {
                if (micoHandpickInfo != null) {
                    MicoSelectApi.OnSelectInfoReadyListener onSelectInfoReadyListener = onSelectInfoReadyListener;
                    if (onSelectInfoReadyListener != null) {
                        onSelectInfoReadyListener.onSelectInfoReady(micoHandpickInfo.getList());
                        return;
                    }
                    return;
                }
                MicoSelectApi.OnSelectInfoReadyListener onSelectInfoReadyListener2 = onSelectInfoReadyListener;
                if (onSelectInfoReadyListener2 != null) {
                    onSelectInfoReadyListener2.onSelectInfoReady(null);
                }
            }

            public void onFailure(ApiError apiError) {
                MicoSelectApi.OnSelectInfoReadyListener onSelectInfoReadyListener = onSelectInfoReadyListener;
                if (onSelectInfoReadyListener != null) {
                    onSelectInfoReadyListener.onSelectInfoReady(null);
                }
            }
        });
    }

    public Observable<List<MicoSelectInfo>> getObservableSelectInfo(boolean z) {
        return Observable.unsafeCreate(new Observable.OnSubscribe(z) {
            /* class com.xiaomi.mico.music.patchwall.micoselect.$$Lambda$MicoSelectApi2$6Orl3WXWWRdgEwCfXBa33PT9DE0 */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                MicoSelectApi2.this.lambda$getObservableSelectInfo$0$MicoSelectApi2(this.f$1, (Subscriber) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getObservableSelectInfo$0$MicoSelectApi2(boolean z, final Subscriber subscriber) {
        getSelectApi(z, new MicoSelectApi.OnSelectInfoReadyListener() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectApi2.AnonymousClass3 */

            public void onSelectInfoReady(List<MicoSelectInfo> list) {
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        });
    }
}
