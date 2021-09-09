package _m_j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class gjj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17845O000000o = "ServerCodeUploader";

    /* access modifiers changed from: private */
    public void O00000o0() {
    }

    @SuppressLint({"CheckResult"})
    public final void O000000o(boolean z) {
        Observable.defer(new Callable(z) {
            /* class _m_j.$$Lambda$gjj$b9MkEGnnbhXiyvLmq1Mooh7pqME */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return gjj.this.O00000Oo(this.f$1);
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$gjj$dGbLSah1LBPI8u6zHqtC7mqcJys */

            public final void accept(Object obj) {
                gjj.this.O00000Oo((ServerBean) obj);
            }
        }, new Consumer() {
            /* class _m_j.$$Lambda$gjj$217fXrysAeZkkjZUO8UDGbScxfY */

            public final void accept(Object obj) {
                gjj.this.O000000o((Throwable) obj);
            }
        }, new Action() {
            /* class _m_j.$$Lambda$gjj$_bGX9ZWZyoSyjyMmI1WYOuj5Ql4 */

            public final void run() {
                gjj.this.O00000o0();
            }
        });
    }

    public final Observable<ServerBean> O000000o(ServerBean serverBean) {
        return Observable.create(new ObservableOnSubscribe(serverBean) {
            /* class _m_j.$$Lambda$gjj$BaLZBhVnDWv6vxWaO0TuaLDfXL8 */
            private final /* synthetic */ ServerBean f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                gjj.this.O000000o(this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(final ServerBean serverBean, final ObservableEmitter observableEmitter) throws Exception {
        if (!observableEmitter.isDisposed()) {
            final Locale O00000o0 = ftn.O00000o0(ServiceApplication.getAppContext());
            fuh.O000000o();
            fuh.O000000o(ServiceApplication.getAppContext(), O00000o0, serverBean, new fsm<Void, fso>() {
                /* class _m_j.gjj.AnonymousClass2 */

                public final void onFailure(fso fso) {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onError(new ApiErrorWrapper(fso));
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onNext(serverBean);
                        observableEmitter.onComplete();
                    }
                }
            });
        }
    }

    public static boolean O000000o() {
        ServerBean O000000o2;
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4 || (O000000o2 = ftn.O000000o(ServiceApplication.getAppContext())) == null) {
            return false;
        }
        String O00000o0 = gpy.O00000o0(ServiceApplication.getAppContext(), O00000Oo(), "key_server_code", "");
        if (TextUtils.isEmpty(O00000o0)) {
            return true;
        }
        try {
            if (!O000000o2.equals(ServerBean.O00000Oo(new JSONObject(O00000o0)))) {
                return true;
            }
            Locale O00000o02 = ftn.O00000o0(ServiceApplication.getAppContext());
            String O00000o03 = gpy.O00000o0(ServiceApplication.getAppContext(), O00000Oo(), "key_language_code", "");
            if (!TextUtils.isEmpty(O00000o03) && flk.O000000o(O00000o02).equalsIgnoreCase(O00000o03)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(ServerBean serverBean) {
        if (serverBean != null) {
            gpy.O000000o(ServiceApplication.getAppContext(), O00000Oo(), "key_server_code", serverBean.O000000o());
            gpy.O000000o(ServiceApplication.getAppContext(), O00000Oo(), "key_language_code", flk.O000000o(ftn.O00000o0(ServiceApplication.getAppContext())).toLowerCase());
        }
    }

    private static String O00000Oo() {
        return gpp.O00000Oo(CoreApi.O000000o().O0000o0()) + "_spfs_server_code_uploader";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Throwable th) throws Exception {
        gpy.O000000o(ServiceApplication.getAppContext(), O00000Oo(), "key_server_code", "");
        gpy.O000000o(ServiceApplication.getAppContext(), O00000Oo(), "key_language_code", "");
        O00000o0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000Oo(final boolean z) throws Exception {
        return Observable.timer(200, TimeUnit.MILLISECONDS).flatMap(new Function<Long, ObservableSource<ServerBean>>() {
            /* class _m_j.gjj.AnonymousClass1 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                ServerBean O000000o2 = ftn.O000000o(ServiceApplication.getAppContext());
                if (O000000o2 == null) {
                    return Observable.error(new IllegalArgumentException());
                }
                if (z || gjj.O000000o()) {
                    return gjj.this.O000000o(O000000o2);
                }
                return Observable.empty();
            }
        });
    }
}
