package _m_j;

import _m_j.gsj;
import com.xiaomi.smarthome.application.CommonApplication;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class fly {
    public static Observable<String> O000000o(String str) {
        if (ftn.O00000oO(CommonApplication.getAppContext())) {
            return Observable.empty();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new gsi("model", str));
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        gsj.O000000o O00000Oo = o000000o.O00000Oo(hsk.O00000Oo(CommonApplication.getAppContext()) + "/newoperation/productBaike");
        O00000Oo.O00000oO = arrayList;
        return Observable.create(new ObservableOnSubscribe($$Lambda$fly$pvkcjvoGl3rmOs1uFfWQMgw2I4.INSTANCE) {
            /* class _m_j.$$Lambda$fly$4Cp2OrlL2Kp8lHEyZjaHNC7WvWM */
            private final /* synthetic */ fss f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                fly.O000000o(gsj.this, this.f$1, observableEmitter);
            }
        }).onErrorReturn($$Lambda$fly$IAaSIS3ssxwhNsMlowkW3f41UQg.INSTANCE).filter($$Lambda$fly$F0JucuqIuJutDJ5pGvdDYMub3ig.INSTANCE).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String O000000o(JSONObject jSONObject) throws JSONException {
        try {
            return jSONObject.getJSONObject("data").getString("baikeUrl");
        } catch (Exception e) {
            gsy.O000000o(3, "BaikeApi", "parse: " + e.getLocalizedMessage());
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O00000Oo(String str) throws Exception {
        return !str.isEmpty();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(gsj gsj, final fss fss, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class _m_j.fly.AnonymousClass1 */

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
}
