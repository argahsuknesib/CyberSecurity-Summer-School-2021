package _m_j;

import bolts.AndroidExecutors;
import bolts.BoltsExecutors;
import bolts.ExecutorException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class kq<TResult> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ExecutorService f2144O000000o = BoltsExecutors.O000000o();
    public static final Executor O00000Oo = BoltsExecutors.O00000Oo();
    private static volatile O00000Oo O00000o;
    public static final Executor O00000o0 = AndroidExecutors.O00000Oo();
    private static kq<Boolean> O0000o0 = new kq<>(Boolean.TRUE);
    private static kq<?> O0000o00 = new kq<>((Object) null);
    private static kq<Boolean> O0000o0O = new kq<>(Boolean.FALSE);
    private static kq<?> O0000o0o = new kq<>((byte) 0);
    private final Object O00000oO = new Object();
    private boolean O00000oo;
    private boolean O0000O0o;
    private TResult O0000OOo;
    private boolean O0000Oo;
    private Exception O0000Oo0;
    private ks O0000OoO;
    private List<ko<TResult, Void>> O0000Ooo = new ArrayList();

    public interface O00000Oo {
    }

    public static O00000Oo O000000o() {
        return O00000o;
    }

    kq() {
    }

    private kq(TResult tresult) {
        O00000Oo((Object) tresult);
    }

    private kq(byte b) {
        O0000OOo();
    }

    public static <TResult> kq<TResult>.O000000o O00000Oo() {
        kq kqVar = new kq();
        kqVar.getClass();
        return new O000000o();
    }

    private boolean O0000Oo0() {
        boolean z;
        synchronized (this.O00000oO) {
            z = this.O00000oo;
        }
        return z;
    }

    public final boolean O00000o0() {
        boolean z;
        synchronized (this.O00000oO) {
            z = this.O0000O0o;
        }
        return z;
    }

    public final boolean O00000o() {
        boolean z;
        synchronized (this.O00000oO) {
            z = O00000oo() != null;
        }
        return z;
    }

    public final TResult O00000oO() {
        TResult tresult;
        synchronized (this.O00000oO) {
            tresult = this.O0000OOo;
        }
        return tresult;
    }

    public final Exception O00000oo() {
        Exception exc;
        synchronized (this.O00000oO) {
            if (this.O0000Oo0 != null) {
                this.O0000Oo = true;
                if (this.O0000OoO != null) {
                    this.O0000OoO.f2153O000000o = null;
                    this.O0000OoO = null;
                }
            }
            exc = this.O0000Oo0;
        }
        return exc;
    }

    public static <TResult> kq<TResult> O000000o(TResult tresult) {
        if (tresult == null) {
            return O0000o00;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? O0000o0 : O0000o0O;
        }
        kr krVar = new kr();
        krVar.O000000o((Object) tresult);
        return krVar.O00000Oo;
    }

    public static <TResult> kq<TResult> O000000o(Exception exc) {
        kr krVar = new kr();
        krVar.O000000o(exc);
        return krVar.O00000Oo;
    }

    public static <TResult> kq<TResult> O0000O0o() {
        return O0000o0o;
    }

    public static <TResult> kq<TResult> O000000o(Callable<TResult> callable, Executor executor) {
        return O00000Oo(callable, executor);
    }

    private static <TResult> kq<TResult> O00000Oo(Callable<TResult> callable, Executor executor) {
        kr krVar = new kr();
        try {
            executor.execute(new Runnable(null, krVar, callable) {
                /* class _m_j.kq.AnonymousClass6 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ kk f2151O000000o = null;
                final /* synthetic */ kr O00000Oo;
                final /* synthetic */ Callable O00000o0;

                {
                    this.O00000Oo = r2;
                    this.O00000o0 = r3;
                }

                public final void run() {
                    kk kkVar = this.f2151O000000o;
                    if (kkVar == null || !kkVar.f2139O000000o.O000000o()) {
                        try {
                            this.O00000Oo.O000000o(this.O00000o0.call());
                        } catch (CancellationException unused) {
                            this.O00000Oo.O000000o();
                        } catch (Exception e) {
                            this.O00000Oo.O000000o(e);
                        }
                    } else {
                        this.O00000Oo.O000000o();
                    }
                }
            });
        } catch (Exception e) {
            krVar.O000000o((Exception) new ExecutorException(e));
        }
        return krVar.O00000Oo;
    }

    private <TContinuationResult> kq<TContinuationResult> O00000Oo(ko<TResult, TContinuationResult> koVar, Executor executor) {
        boolean O0000Oo02;
        kr krVar = new kr();
        synchronized (this.O00000oO) {
            O0000Oo02 = O0000Oo0();
            if (!O0000Oo02) {
                this.O0000Ooo.add(new ko<TResult, Void>(krVar, koVar, executor, null) {
                    /* class _m_j.kq.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ kr f2145O000000o;
                    final /* synthetic */ ko O00000Oo;
                    final /* synthetic */ kk O00000o = null;
                    final /* synthetic */ Executor O00000o0;

                    {
                        this.f2145O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    public final /* synthetic */ Object then(kq kqVar) throws Exception {
                        kq.O000000o(this.f2145O000000o, this.O00000Oo, kqVar, this.O00000o0, this.O00000o);
                        return null;
                    }
                });
            }
        }
        if (O0000Oo02) {
            O000000o(krVar, koVar, this, executor, null);
        }
        return krVar.O00000Oo;
    }

    public final <TContinuationResult> kq<TContinuationResult> O000000o(ko<TResult, TContinuationResult> koVar) {
        return O00000Oo(koVar, O00000Oo);
    }

    public final <TContinuationResult> kq<TContinuationResult> O000000o(ko<TResult, kq<TContinuationResult>> koVar, Executor executor) {
        boolean O0000Oo02;
        kr krVar = new kr();
        synchronized (this.O00000oO) {
            O0000Oo02 = O0000Oo0();
            if (!O0000Oo02) {
                this.O0000Ooo.add(new ko<TResult, Void>(krVar, koVar, executor, null) {
                    /* class _m_j.kq.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ kr f2146O000000o;
                    final /* synthetic */ ko O00000Oo;
                    final /* synthetic */ kk O00000o = null;
                    final /* synthetic */ Executor O00000o0;

                    {
                        this.f2146O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    public final /* synthetic */ Object then(kq kqVar) throws Exception {
                        kq.O00000Oo(this.f2146O000000o, this.O00000Oo, kqVar, this.O00000o0, this.O00000o);
                        return null;
                    }
                });
            }
        }
        if (O0000Oo02) {
            O00000Oo(krVar, koVar, this, executor, null);
        }
        return krVar.O00000Oo;
    }

    public static <TContinuationResult, TResult> void O000000o(final kr<TContinuationResult> krVar, final ko<TResult, TContinuationResult> koVar, final kq<TResult> kqVar, Executor executor, final kk kkVar) {
        try {
            executor.execute(new Runnable() {
                /* class _m_j.kq.AnonymousClass4 */

                public final void run() {
                    kk kkVar = kkVar;
                    if (kkVar == null || !kkVar.f2139O000000o.O000000o()) {
                        try {
                            krVar.O000000o(koVar.then(kqVar));
                        } catch (CancellationException unused) {
                            krVar.O000000o();
                        } catch (Exception e) {
                            krVar.O000000o(e);
                        }
                    } else {
                        krVar.O000000o();
                    }
                }
            });
        } catch (Exception e) {
            krVar.O000000o((Exception) new ExecutorException(e));
        }
    }

    public static <TContinuationResult, TResult> void O00000Oo(final kr<TContinuationResult> krVar, final ko<TResult, kq<TContinuationResult>> koVar, final kq<TResult> kqVar, Executor executor, final kk kkVar) {
        try {
            executor.execute(new Runnable() {
                /* class _m_j.kq.AnonymousClass5 */

                public final void run() {
                    kk kkVar = kkVar;
                    if (kkVar == null || !kkVar.f2139O000000o.O000000o()) {
                        try {
                            kq kqVar = (kq) koVar.then(kqVar);
                            if (kqVar == null) {
                                krVar.O000000o((Object) null);
                            } else {
                                kqVar.O000000o((ko) new ko<TContinuationResult, Void>() {
                                    /* class _m_j.kq.AnonymousClass5.AnonymousClass1 */

                                    public final /* synthetic */ Object then(kq kqVar) throws Exception {
                                        if (kkVar != null && kkVar.f2139O000000o.O000000o()) {
                                            krVar.O000000o();
                                            return null;
                                        } else if (kqVar.O00000o0()) {
                                            krVar.O000000o();
                                            return null;
                                        } else if (kqVar.O00000o()) {
                                            krVar.O000000o(kqVar.O00000oo());
                                            return null;
                                        } else {
                                            krVar.O000000o(kqVar.O00000oO());
                                            return null;
                                        }
                                    }
                                });
                            }
                        } catch (CancellationException unused) {
                            krVar.O000000o();
                        } catch (Exception e) {
                            krVar.O000000o(e);
                        }
                    } else {
                        krVar.O000000o();
                    }
                }
            });
        } catch (Exception e) {
            krVar.O000000o((Exception) new ExecutorException(e));
        }
    }

    private void O0000Oo() {
        synchronized (this.O00000oO) {
            for (ko then : this.O0000Ooo) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.O0000Ooo = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O0000OOo() {
        synchronized (this.O00000oO) {
            if (this.O00000oo) {
                return false;
            }
            this.O00000oo = true;
            this.O0000O0o = true;
            this.O00000oO.notifyAll();
            O0000Oo();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo(TResult tresult) {
        synchronized (this.O00000oO) {
            if (this.O00000oo) {
                return false;
            }
            this.O00000oo = true;
            this.O0000OOo = tresult;
            this.O00000oO.notifyAll();
            O0000Oo();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return true;
     */
    public final boolean O00000Oo(Exception exc) {
        synchronized (this.O00000oO) {
            if (this.O00000oo) {
                return false;
            }
            this.O00000oo = true;
            this.O0000Oo0 = exc;
            this.O0000Oo = false;
            this.O00000oO.notifyAll();
            O0000Oo();
            if (!this.O0000Oo && O00000o != null) {
                this.O0000OoO = new ks(this);
            }
        }
    }

    public class O000000o extends kr<TResult> {
        O000000o() {
        }
    }
}
