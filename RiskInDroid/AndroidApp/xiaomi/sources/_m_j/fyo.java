package _m_j;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.account.openauth.AccountAuth;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.IOException;

public final class fyo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Handler f17413O000000o = new Handler(Looper.getMainLooper());

    public static void O000000o(Activity activity, final ftt<XiaomiOAuthResults> ftt) {
        final XiaomiOAuthFuture<XiaomiOAuthResults> startGetAccessToken = new XiaomiOAuthorize().setAppId(fym.O000000o()).setRedirectUrl("http://api.io.mi.com/app/oauth/callback").setScope(new int[]{12001}).setSkipConfirm(true).setNoMiui(true).setAccountAuth(new AccountAuth() {
            /* class _m_j.fyo.AnonymousClass1 */

            public final String getUserId() {
                return XmPluginHostApi.instance().getOauthUserId();
            }

            public final String getServiceToken() {
                return XmPluginHostApi.instance().getOauthServiceToken();
            }

            public final void invalideServiceToken() {
                XmPluginHostApi.instance().invalideOauthServiceToken();
            }
        }).startGetAccessToken(activity);
        new AsyncTask<Void, Void, V>() {
            /* class _m_j.fyo.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            Exception f17414O000000o;

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            private V O000000o() {
                try {
                    return startGetAccessToken.getResult();
                } catch (IOException e) {
                    this.f17414O000000o = e;
                    return null;
                } catch (OperationCanceledException e2) {
                    this.f17414O000000o = e2;
                    return null;
                } catch (XMAuthericationException e3) {
                    this.f17414O000000o = e3;
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final void onPostExecute(final V v) {
                if (ftt != null) {
                    if (v != null) {
                        fyo.f17413O000000o.post(new Runnable() {
                            /* class _m_j.fyo.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                ftt.O000000o(v);
                            }
                        });
                    } else if (this.f17414O000000o != null) {
                        fyo.f17413O000000o.post(new Runnable() {
                            /* class _m_j.fyo.AnonymousClass2.AnonymousClass2 */

                            public final void run() {
                                ftt.O000000o(AnonymousClass2.this.f17414O000000o instanceof OperationCanceledException ? 37121 : -1);
                            }
                        });
                    } else {
                        fyo.f17413O000000o.post(new Runnable() {
                            /* class _m_j.fyo.AnonymousClass2.AnonymousClass3 */

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
