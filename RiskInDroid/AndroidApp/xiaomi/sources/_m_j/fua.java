package _m_j;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class fua {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17140O000000o = "_m_j.fua";
    private static volatile fua O00000oo;
    public Map<Long, O000000o> O00000Oo = new HashMap();
    public O0000OOo O00000o = new O0000OOo();
    public final Object O00000o0 = new Object();
    public fub O00000oO = new fub();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000o0 f17145O000000o;
        O0000O0o O00000Oo;
        WeakReference<ftt> O00000o;
        int O00000o0;
    }

    public static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        JSONObject f17148O000000o;
    }

    public static int O00000o0(long j) {
        return (int) (j ^ (j >>> 32));
    }

    private fua() {
    }

    public static fua O000000o() {
        if (O00000oo == null) {
            synchronized (fua.class) {
                if (O00000oo == null) {
                    O00000oo = new fua();
                }
            }
        }
        return O00000oo;
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        long f17147O000000o;
        int O00000Oo;
        int O00000o0;

        O00000o0() {
        }
    }

    public final void O000000o(long j) {
        this.O00000o.O000000o(j);
    }

    public abstract class O00000o extends fsm<O00000o0, fso> {
        long O00000oO = -1;
        public O00000Oo O00000oo = null;

        public O00000o() {
        }
    }

    public class O00000Oo extends fuv {

        /* renamed from: O000000o  reason: collision with root package name */
        volatile boolean f17146O000000o = false;
        fsn O00000Oo;
        public O00000o O00000o0;

        public O00000Oo(fsn fsn) {
            this.O00000Oo = fsn;
            this.O00000o0 = null;
        }
    }

    public final void O00000Oo(final long j) {
        synchronized (this.O00000o0) {
            if (this.O00000Oo.get(Long.valueOf(j)) != null) {
                ftz.O000000o().O000000o(CommonApplication.getAppContext(), j, 0, new fsm<O0000O0o, fso>() {
                    /* class _m_j.fua.AnonymousClass3 */

                    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
                        return;
                     */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        O0000O0o o0000O0o = (O0000O0o) obj;
                        try {
                            synchronized (fua.this.O00000o0) {
                                O000000o remove = fua.this.O00000Oo.remove(Long.valueOf(j));
                                if (remove != null) {
                                    if (remove.O00000o != null) {
                                        fua.this.O00000o.O000000o(j);
                                        ftt ftt = remove.O00000o.get();
                                        if (ftt != null) {
                                            ftt.O000000o(o0000O0o.f17148O000000o);
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
                        return;
                     */
                    public final void onFailure(fso fso) {
                        String str;
                        synchronized (fua.this.O00000o0) {
                            O000000o remove = fua.this.O00000Oo.remove(Long.valueOf(j));
                            if (remove != null) {
                                if (remove.O00000o != null) {
                                    ftt ftt = remove.O00000o.get();
                                    if (ftt != null) {
                                        int i = fso.f17063O000000o;
                                        if (fso.O00000Oo != null) {
                                            str = fso.O00000Oo;
                                        } else {
                                            str = "";
                                        }
                                        ftt.O000000o(i, str);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public static class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Handler f17149O000000o;
        Map<Long, fsn> O00000Oo = new HashMap();
        final Object O00000o0 = new Object();

        public interface O00000Oo {
            void O000000o();

            void O000000o(int i, Object obj);
        }

        class O000000o extends gpq {
            public O000000o(String str) {
                super(str);
            }
        }

        public O0000OOo() {
            O000000o o000000o = new O000000o("retry_thread");
            o000000o.start();
            this.f17149O000000o = new Handler(o000000o.getLooper()) {
                /* class _m_j.fua.O0000OOo.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.obj instanceof O00000o0) {
                        O00000o0 o00000o0 = (O00000o0) message.obj;
                        O0000OOo o0000OOo = O0000OOo.this;
                        if (o00000o0.O00000o > 0) {
                            o00000o0.O00000o--;
                            fsn O000000o2 = ftz.O000000o().O000000o(CommonApplication.getAppContext(), o00000o0.O00000Oo, o00000o0.f17153O000000o.f17145O000000o.O00000o0 - o00000o0.O00000o, new fsm<O0000O0o, fso>(o00000o0) {
                                /* class _m_j.fua.O0000OOo.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ O00000o0 f17151O000000o;

                                {
                                    this.f17151O000000o = r2;
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    O0000O0o o0000O0o = (O0000O0o) obj;
                                    if (o0000O0o != null && this.f17151O000000o.f17153O000000o != null) {
                                        this.f17151O000000o.f17153O000000o.O00000Oo = o0000O0o;
                                        if (this.f17151O000000o.O00000o0 != null) {
                                            this.f17151O000000o.O00000o0.O000000o();
                                        }
                                    } else if (this.f17151O000000o.O00000o0 != null) {
                                        this.f17151O000000o.O00000o0.O000000o(0, "result is null or info.data is null");
                                    }
                                }

                                public final void onFailure(fso fso) {
                                    String str;
                                    String str2 = fua.f17140O000000o;
                                    gsy.O000000o(3, str2, "getApiResult onFailure shError=" + fso.f17063O000000o);
                                    if (fso.f17063O000000o == ErrorCode.ERROR_RETRY_ERROR.getCode()) {
                                        Message obtainMessage = O0000OOo.this.f17149O000000o.obtainMessage();
                                        O00000o0 o00000o0 = this.f17151O000000o;
                                        obtainMessage.obj = o00000o0;
                                        obtainMessage.what = fua.O00000o0(o00000o0.O00000Oo);
                                        O0000OOo.this.f17149O000000o.sendMessageDelayed(obtainMessage, (long) (this.f17151O000000o.f17153O000000o.f17145O000000o.O00000Oo * 1000));
                                    } else if (this.f17151O000000o.O00000o0 != null) {
                                        O00000Oo o00000Oo = this.f17151O000000o.O00000o0;
                                        int i = fso == null ? 0 : fso.f17063O000000o;
                                        if (fso == null) {
                                            str = "Unknown error";
                                        } else {
                                            str = fso.O00000Oo;
                                        }
                                        o00000Oo.O000000o(i, str);
                                    }
                                }
                            });
                            synchronized (o0000OOo.O00000o0) {
                                o0000OOo.O00000Oo.put(Long.valueOf(o00000o0.O00000Oo), O000000o2);
                            }
                        } else if (o00000o0.O00000o0 == null) {
                        } else {
                            if (o00000o0.f17153O000000o == null || o00000o0.f17153O000000o.f17145O000000o == null) {
                                o00000o0.O00000o0.O000000o(0, "leftRetry is zero");
                                return;
                            }
                            o00000o0.O00000o0.O000000o(0, "not retrieved the result in " + (o00000o0.f17153O000000o.f17145O000000o.O00000o0 * o00000o0.f17153O000000o.f17145O000000o.O00000Oo) + " seconds. leftRetry is zero");
                        }
                    }
                }
            };
        }

        public final void O000000o(long j) {
            this.f17149O000000o.removeMessages(fua.O00000o0(j));
            synchronized (this.O00000o0) {
                fsn remove = this.O00000Oo.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.cancel();
                }
            }
        }

        class O00000o0 {

            /* renamed from: O000000o  reason: collision with root package name */
            O000000o f17153O000000o;
            long O00000Oo;
            int O00000o;
            O00000Oo O00000o0;

            private O00000o0() {
            }

            /* synthetic */ O00000o0(O0000OOo o0000OOo, byte b) {
                this();
            }
        }
    }
}
