package _m_j;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.io.IOException;
import java.util.Arrays;

public final class gxo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Handler f18475O000000o = new Handler(Looper.getMainLooper());

    public static void O000000o(Activity activity, ftt<XiaomiOAuthResults> ftt) {
        O000000o(new XiaomiOAuthorize().setAppId(gxn.O000000o()).setRedirectUrl("http://api.io.mi.com/app/oauth/callback").setScope(Arrays.copyOf(new int[]{1}, 1)).startGetAccessToken(activity), ftt);
    }

    public static void O000000o(Activity activity, String str, String str2, String str3, ftt<String> ftt) {
        O000000o(new XiaomiOAuthorize().callOpenApi(activity, gxn.O000000o(), "/user/profile", str, str2, str3), ftt);
    }

    private static <V> void O000000o(final XiaomiOAuthFuture xiaomiOAuthFuture, final ftt ftt) {
        new AsyncTask<Void, Void, V>() {
            /* class _m_j.gxo.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            Exception f18476O000000o;

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            private V O000000o() {
                try {
                    return xiaomiOAuthFuture.getResult();
                } catch (IOException e) {
                    this.f18476O000000o = e;
                    return null;
                } catch (OperationCanceledException e2) {
                    this.f18476O000000o = e2;
                    return null;
                } catch (XMAuthericationException e3) {
                    this.f18476O000000o = e3;
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final void onPostExecute(final V v) {
                if (ftt != null) {
                    if (v != null) {
                        gxo.f18475O000000o.post(new Runnable() {
                            /* class _m_j.gxo.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                ftt.O000000o(v);
                            }
                        });
                    } else if (this.f18476O000000o != null) {
                        gxo.f18475O000000o.post(new Runnable() {
                            /* class _m_j.gxo.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                ftt.O000000o(AnonymousClass1.this.f18476O000000o instanceof OperationCanceledException ? 37121 : -1);
                            }
                        });
                    } else {
                        gxo.f18475O000000o.post(new Runnable() {
                            /* class _m_j.gxo.AnonymousClass1.AnonymousClass3 */

                            public final void run() {
                                ftt.O000000o(-1);
                            }
                        });
                    }
                }
            }
        }.execute(new Void[0]);
    }
}
