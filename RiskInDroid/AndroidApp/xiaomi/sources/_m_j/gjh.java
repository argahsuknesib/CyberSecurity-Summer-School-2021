package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

public final class gjh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile gjh f17844O000000o;

    private gjh() {
    }

    public static gjh O000000o() {
        if (f17844O000000o == null) {
            synchronized (gjh.class) {
                if (f17844O000000o == null) {
                    f17844O000000o = new gjh();
                }
            }
        }
        return f17844O000000o;
    }

    public final Observable<List<ServerBean>> O00000Oo() {
        return Observable.defer(new Callable() {
            /* class _m_j.$$Lambda$gjh$ZO87Fed7hCTpQ78Frkck1y1R3pI */

            public final Object call() {
                return gjh.this.O00000o();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000o() throws Exception {
        Context appContext = ServiceApplication.getAppContext();
        List<ServerBean> O000000o2 = ftn.O000000o(ftn.O00000o0(appContext), appContext);
        if (!O000000o2.isEmpty()) {
            return Observable.just(O000000o2);
        }
        return Observable.just(O00000o0());
    }

    private static List<ServerBean> O00000o0() {
        gsy.O000000o(6, "ServerApi", "获取服务器列表失败， 使用兜底方案");
        return ftn.O000000o(Locale.ENGLISH, ServiceApplication.getAppContext());
    }

    public static void O000000o(boolean z) {
        new gjj().O000000o(z);
    }

    public final Observable<String> O000000o(ServerBean serverBean) {
        return Observable.defer(new Callable(serverBean) {
            /* class _m_j.$$Lambda$gjh$PffiPVr4GKgqS5x8AtKaSUSqqA */
            private final /* synthetic */ ServerBean f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return gjh.this.O00000Oo(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O00000Oo(ServerBean serverBean) throws Exception {
        if (serverBean == null) {
            return Observable.error(new IllegalArgumentException());
        }
        String O000000o2 = ftn.O000000o(ServiceApplication.getAppContext(), serverBean.O00000Oo);
        if (!TextUtils.isEmpty(O000000o2)) {
            return Observable.just(O000000o2);
        }
        return Observable.just(O00000o0()).zipWith(Observable.just(serverBean), $$Lambda$gjh$Ty0ifXO4gq08n2RPKrVQxo3wI.INSTANCE).map($$Lambda$gjh$NH65MgJcYxA28oZFhKzEaToU.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ServerBean O000000o(List list, ServerBean serverBean) throws Exception {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ServerBean serverBean2 = (ServerBean) it.next();
                if (TextUtils.equals(serverBean2.O00000Oo, serverBean.O00000Oo)) {
                    return serverBean2;
                }
            }
        }
        serverBean.O00000o0 = "";
        return serverBean;
    }
}
