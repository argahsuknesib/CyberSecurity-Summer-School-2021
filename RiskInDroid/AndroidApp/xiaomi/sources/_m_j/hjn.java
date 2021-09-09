package _m_j;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONObject;

public final class hjn {
    public static <T> Observable<T> O000000o(gsj gsj, fss<T> fss) {
        return Observable.create(new ObservableOnSubscribe(fss) {
            /* class _m_j.$$Lambda$hjn$8QFBmWUpvy9etarYSnCx7YvNuM0 */
            private final /* synthetic */ fss f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hjn.O000000o(gsj.this, this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(gsj gsj, final fss fss, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class _m_j.hjn.AnonymousClass1 */

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
