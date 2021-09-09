package _m_j;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public final class gsv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final boolean f18220O000000o = (Build.VERSION.SDK_INT < 21);
    static gsv O00000Oo = null;
    public O000000o O00000o = new O000000o();
    Context O00000o0;
    CookieManager O00000oO;

    private gsv(Context context) {
        this.O00000o0 = context;
    }

    public static void O000000o(Context context) {
        O00000Oo = new gsv(context);
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Handler f18222O000000o;

        public O000000o() {
            this.f18222O000000o = new Handler(Looper.getMainLooper(), new Handler.Callback(gsv.this) {
                /* class _m_j.gsv.O000000o.AnonymousClass1 */

                public final boolean handleMessage(Message message) {
                    if (message.what != 1) {
                        return false;
                    }
                    O000000o o000000o = O000000o.this;
                    o000000o.f18222O000000o.removeMessages(1);
                    new AsyncTask<Void, Void, Void>(new Runnable() {
                        /* class _m_j.gsv.O000000o.AnonymousClass2 */

                        public final void run() {
                            if (gsv.f18220O000000o) {
                                CookieSyncManager.getInstance().sync();
                                return;
                            }
                            gsv gsv = gsv.this;
                            if (gsv.O00000oO == null) {
                                Context context = gsv.O00000o0;
                                if (gsv.f18220O000000o) {
                                    CookieSyncManager.createInstance(context).sync();
                                }
                                gsv.O00000oO = CookieManager.getInstance();
                                if (gsv.f18220O000000o) {
                                    gsv.O00000oO.removeExpiredCookie();
                                }
                            }
                            gsv.O00000oO.flush();
                        }
                    }) {
                        /* class _m_j.gsv.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Runnable f18221O000000o;

                        {
                            this.f18221O000000o = r2;
                        }

                        /* access modifiers changed from: protected */
                        public final /* synthetic */ Object doInBackground(Object[] objArr) {
                            this.f18221O000000o.run();
                            return null;
                        }
                    }.execute(new Void[0]);
                    return true;
                }
            });
        }
    }
}
