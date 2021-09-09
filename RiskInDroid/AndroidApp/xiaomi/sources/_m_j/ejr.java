package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;

public final class ejr extends AsyncTask<Void, Void, O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f15530O000000o = "GetIdentityAuthUrlTask";
    @SuppressLint({"StaticFieldLeak"})
    private Context O00000Oo;
    private IdentityAuthReason O00000o;
    private String O00000o0;
    private O000000o O00000oO;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);

        void O000000o(ServerError serverError);

        void O000000o(String str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        O00000Oo o00000Oo = (O00000Oo) obj;
        super.onPostExecute(o00000Oo);
        if (o00000Oo == null) {
            AccountLog.w("GetIdentityAuthUrlTask", "null result");
            return;
        }
        if (o00000Oo.f15531O000000o != null && o00000Oo.f15531O000000o.O000000o()) {
            if (o00000Oo.O00000o0 != null) {
                this.O00000oO.O000000o(o00000Oo.O00000o0);
            } else {
                this.O00000oO.O000000o(o00000Oo.f15531O000000o.O00000Oo());
            }
        } else if (TextUtils.isEmpty(o00000Oo.O00000Oo)) {
            this.O00000oO.O000000o();
        } else {
            this.O00000oO.O000000o(o00000Oo.O00000Oo);
        }
    }

    public ejr(Context context, String str, IdentityAuthReason identityAuthReason, O000000o o000000o) {
        this.O00000Oo = context != null ? context.getApplicationContext() : null;
        this.O00000o0 = str;
        this.O00000o = identityAuthReason;
        this.O00000oO = o000000o;
    }

    private O00000Oo O000000o() {
        Context context;
        if (this.O00000oO == null || (context = this.O00000Oo) == null) {
            AccountLog.w("GetIdentityAuthUrlTask", "null callback");
            return null;
        }
        eez O000000o2 = eez.O000000o(context, "passportapi");
        if (O000000o2 == null) {
            AccountLog.w("GetIdentityAuthUrlTask", "null passportInfo");
            return null;
        }
        int i = 0;
        int i2 = 5;
        while (i < 2) {
            try {
                return new O00000Oo(XMPassport.getIdentityAuthUrl(O000000o2, this.O00000o0, this.O00000o), 0, null);
            } catch (IOException e) {
                AccountLog.e("GetIdentityAuthUrlTask", "IOException", e);
                i2 = 2;
            } catch (AuthenticationFailureException e2) {
                AccountLog.e("GetIdentityAuthUrlTask", "AuthenticationFailureException", e2);
                O000000o2.O000000o(this.O00000Oo);
                i++;
                i2 = 1;
            } catch (AccessDeniedException e3) {
                AccountLog.e("GetIdentityAuthUrlTask", "AccessDeniedException", e3);
                i2 = 4;
            } catch (InvalidResponseException e4) {
                AccountLog.e("GetIdentityAuthUrlTask", "InvalidResponseException", e4);
                ServerError serverError = e4.getServerError();
                if (serverError != null) {
                    return new O00000Oo(null, 3, serverError);
                }
                i2 = 3;
            } catch (CipherException e5) {
                AccountLog.e("GetIdentityAuthUrlTask", "CipherException", e5);
                i2 = 3;
            }
        }
        return new O00000Oo(null, i2, null);
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        ejo f15531O000000o;
        String O00000Oo;
        ServerError O00000o0;

        public O00000Oo(String str, int i, ServerError serverError) {
            this.f15531O000000o = new ejo(i);
            this.O00000Oo = str;
            this.O00000o0 = serverError;
        }
    }
}
