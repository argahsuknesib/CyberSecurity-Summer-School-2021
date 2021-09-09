package _m_j;

import _m_j.ehp;
import _m_j.eic;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.passport.ui.internal.Source$get$1;
import com.xiaomi.passport.ui.internal.Source$getSuccess$1;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0007J\"\u0010\u0004\u001a\u00020\u00052\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\"\u0010\f\u001a\u00020\u00052\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u001a\u0010\r\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007J\r\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000fJ\"\u0010\u000e\u001a\u00020\u00052\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J5\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0000\"\u0004\b\u0001\u0010\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\u00110\u0007J\r\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/passport/ui/internal/Source;", "V", "", "()V", "get", "", "success", "Lkotlin/Function1;", "fail", "", "observer", "Lcom/xiaomi/passport/ui/internal/Result;", "getAsync", "getSuccess", "getSync", "()Ljava/lang/Object;", "next", "T", "func1", "Lkotlin/ParameterName;", "name", "value", "process", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public abstract class eib<V> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15310O000000o = new O000000o((byte) 0);

    public abstract V O000000o();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007¨\u0006\b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/Source$Companion;", "", "()V", "from", "Lcom/xiaomi/passport/ui/internal/Source;", "V", "func", "Lkotlin/Function0;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/xiaomi/passport/ui/internal/Source$Companion$from$1", "Lcom/xiaomi/passport/ui/internal/Source;", "(Lkotlin/jvm/functions/Function0;)V", "process", "()Ljava/lang/Object;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
        /* renamed from: _m_j.eib$O000000o$O000000o  reason: collision with other inner class name */
        public static final class C0104O000000o extends eib<V> {
            final /* synthetic */ iwb O00000Oo;

            C0104O000000o(iwb iwb) {
                this.O00000Oo = iwb;
            }

            public final V O000000o() {
                return this.O00000Oo.invoke();
            }
        }

        public static <V> eib<V> O000000o(iwb<? extends V> iwb) {
            ixe.O00000o0(iwb, "func");
            return new C0104O000000o(iwb);
        }
    }

    private final void O00000o0(iwc<? super ehp<V>, iuh> iwc) {
        eic.O000000o o000000o = eic.O00000Oo;
        boolean z = eic.f15314O000000o;
        if (z) {
            try {
                iwc.invoke(new ehp.O00000Oo(O000000o()));
            } catch (Throwable th) {
                iwc.invoke(new ehp.O000000o(th));
            }
        } else if (!z) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new O00000Oo(this, iwc));
        }
    }

    public final void O000000o(iwc<? super V, iuh> iwc, iwc<? super Throwable, iuh> iwc2) {
        ixe.O00000o0(iwc, "success");
        ixe.O00000o0(iwc2, "fail");
        O00000o0(new Source$get$1(iwc, iwc2));
    }

    public final void O000000o(iwc<? super V, iuh> iwc) {
        ixe.O00000o0(iwc, "success");
        O000000o(iwc, Source$getSuccess$1.f6261O000000o);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/xiaomi/passport/ui/internal/Source$next$1", "Lcom/xiaomi/passport/ui/internal/Source;", "(Lcom/xiaomi/passport/ui/internal/Source;Lkotlin/jvm/functions/Function1;)V", "process", "()Ljava/lang/Object;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000o0 extends eib<T> {
        final /* synthetic */ eib O00000Oo;
        final /* synthetic */ iwc O00000o0;

        O00000o0(eib eib, iwc iwc) {
            this.O00000Oo = eib;
            this.O00000o0 = iwc;
        }

        public final T O000000o() {
            return this.O00000o0.invoke(this.O00000Oo.O000000o());
        }
    }

    public final <T> eib<T> O00000Oo(iwc<? super V, ? extends T> iwc) {
        ixe.O00000o0(iwc, "func1");
        return new O00000o0(this, iwc);
    }

    public final V O00000Oo() {
        try {
            return O000000o();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "V", "run"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eib f15311O000000o;
        final /* synthetic */ iwc O00000Oo;

        O00000Oo(eib eib, iwc iwc) {
            this.f15311O000000o = eib;
            this.O00000Oo = iwc;
        }

        public final void run() {
            Handler handler = new Handler(Looper.getMainLooper());
            try {
                final Object O000000o2 = this.f15311O000000o.O000000o();
                handler.post(new Runnable(this) {
                    /* class _m_j.eib.O00000Oo.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O00000Oo f15312O000000o;

                    {
                        this.f15312O000000o = r1;
                    }

                    public final void run() {
                        this.f15312O000000o.O00000Oo.invoke(new ehp.O00000Oo(O000000o2));
                    }
                });
            } catch (Throwable th) {
                handler.post(new Runnable(this) {
                    /* class _m_j.eib.O00000Oo.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O00000Oo f15313O000000o;

                    {
                        this.f15313O000000o = r1;
                    }

                    public final void run() {
                        this.f15313O000000o.O00000Oo.invoke(new ehp.O000000o(th));
                    }
                });
            }
        }
    }
}
