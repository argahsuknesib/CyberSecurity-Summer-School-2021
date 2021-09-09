package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import com.xiaomi.smarthome.frame.core.CoreApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONObject;

@Deprecated
public final class fsv {
    public static <T> Observable<T> O000000o(NetRequest netRequest, fss fss) {
        return Observable.create(new ObservableOnSubscribe(fss) {
            /* class _m_j.$$Lambda$fsv$KWL4p1PKndSSSzhaoSwL7HGTE */
            private final /* synthetic */ fss f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                fsv.O000000o(NetRequest.this, this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(NetRequest netRequest, fss fss, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            CoreApi.O000000o().O000000o((Context) null, netRequest, fss, Crypto.RC4, new fsm<T, fso>() {
                /* class _m_j.fsv.AnonymousClass1 */

                public final void onSuccess(T t) {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onNext(t);
                        observableEmitter.onComplete();
                    }
                }

                public final void onFailure(fso fso) {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onError(new ApiErrorWrapper(fso));
                    }
                }
            });
        }
    }

    public static <T> Observable<T> O000000o(gsj gsj, fss fss) {
        return Observable.create(new ObservableOnSubscribe(fss) {
            /* class _m_j.$$Lambda$fsv$4UNPx_GDv8hXhK3Jhl_1PUrkM */
            private final /* synthetic */ fss f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                fsv.O000000o(gsj.this, this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(gsj gsj, final fss fss, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class _m_j.fsv.AnonymousClass2 */

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
