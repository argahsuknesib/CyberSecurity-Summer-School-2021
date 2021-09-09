package _m_j;

import android.os.AsyncTask;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;
import java.util.Map;

public final class egp extends AsyncTask<Void, Void, NotificationAuthResult> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f15252O000000o;
    private final O000000o O00000Oo;

    public interface O000000o {
        void O000000o(NotificationAuthResult notificationAuthResult);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        NotificationAuthResult notificationAuthResult = (NotificationAuthResult) obj;
        super.onPostExecute(notificationAuthResult);
        this.O00000Oo.O000000o(notificationAuthResult);
    }

    public egp(String str, O000000o o000000o) {
        this.f15252O000000o = str;
        this.O00000Oo = o000000o;
    }

    private NotificationAuthResult O000000o() {
        Map<String, String> headers;
        try {
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(this.f15252O000000o, null, null, false);
            if (!(asString == null || (headers = asString.getHeaders()) == null)) {
                return new NotificationAuthResult.Builder().setUserId(headers.get("userId")).setServiceToken(headers.get("serviceToken")).setPSecurity_ph(headers.get("passportsecurity_ph")).setPSecurity_slh(headers.get("passportsecurity_slh")).build();
            }
        } catch (RuntimeException e) {
            new Thread() {
                /* class _m_j.egp.AnonymousClass1 */

                public final void run() {
                    throw e;
                }
            }.start();
            AccountLog.e("NotificationAuthTask", "runtime exception", e);
            return null;
        } catch (IOException e2) {
            AccountLog.e("NotificationAuthTask", "network error", e2);
        } catch (AccessDeniedException e3) {
            AccountLog.e("NotificationAuthTask", "access denied", e3);
        } catch (AuthenticationFailureException e4) {
            AccountLog.e("NotificationAuthTask", "auth error", e4);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }
}
