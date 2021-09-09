package _m_j;

import android.content.Context;
import android.os.AsyncTask;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;

public final class ejs extends AsyncTask<Void, Void, O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f15532O000000o = "GetUserBindIdAndLimitTask";
    private Context O00000Oo;
    private O000000o O00000o;
    private String O00000o0;

    public interface O000000o {
        void O000000o(int i);

        void O000000o(O00000o0 o00000o0);

        void O000000o(ServerError serverError);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        O00000Oo o00000Oo = (O00000Oo) obj;
        ejo ejo = new ejo(o00000Oo.O00000Oo.intValue());
        if (!ejo.O000000o()) {
            this.O00000o.O000000o(o00000Oo.O00000o0);
        } else if (o00000Oo.f15533O000000o != null) {
            this.O00000o.O000000o(o00000Oo.f15533O000000o);
        } else {
            this.O00000o.O000000o(ejo.O00000Oo());
        }
    }

    public ejs(Context context, String str, O000000o o000000o) {
        this.O00000Oo = context != null ? context.getApplicationContext() : null;
        this.O00000o0 = str;
        this.O00000o = o000000o;
    }

    private O00000Oo O000000o() {
        Context context;
        int i;
        if (this.O00000o == null || (context = this.O00000Oo) == null) {
            AccountLog.w("GetUserBindIdAndLimitTask", "null callback");
            return null;
        }
        eez O000000o2 = eez.O000000o(context, "passportapi");
        if (O000000o2 == null) {
            AccountLog.w("GetUserBindIdAndLimitTask", "null passportInfo");
            return new O00000Oo(1, null, null);
        }
        i = 0;
        int i2 = 5;
        while (i < 2) {
            i2 = 3;
            try {
                return new O00000Oo(0, ejq.O000000o(O000000o2, this.O00000o0), null);
            } catch (IOException e) {
                AccountLog.e("GetUserBindIdAndLimitTask", "IOException", e);
                i2 = 2;
            } catch (AuthenticationFailureException e2) {
                AccountLog.e("GetUserBindIdAndLimitTask", "AuthenticationFailureException", e2);
                O000000o2.O000000o(this.O00000Oo);
                i2 = 1;
            } catch (AccessDeniedException e3) {
                AccountLog.e("GetUserBindIdAndLimitTask", "AccessDeniedException", e3);
                i2 = 4;
            } catch (InvalidResponseException e4) {
                AccountLog.e("GetUserBindIdAndLimitTask", "InvalidResponseException", e4);
                ServerError serverError = e4.getServerError();
                if (serverError != null) {
                    return new O00000Oo(3, null, serverError);
                }
            } catch (CipherException e5) {
                AccountLog.e("GetUserBindIdAndLimitTask", "CipherException", e5);
            } catch (InvalidPhoneNumException e6) {
                AccountLog.e("GetUserBindIdAndLimitTask", "InvalidPhoneNumException", e6);
                i2 = 17;
            }
        }
        return new O00000Oo(Integer.valueOf(i2), null, null);
        i++;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        String f15534O000000o;
        long O00000Oo;
        int O00000o0;

        public O00000o0(String str, long j, int i) {
            this.f15534O000000o = str;
            this.O00000Oo = j;
            this.O00000o0 = i;
        }
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public ServerError f15533O000000o;
        public Integer O00000Oo;
        public O00000o0 O00000o0;

        public O00000Oo(Integer num, O00000o0 o00000o0, ServerError serverError) {
            this.O00000Oo = num;
            this.f15533O000000o = serverError;
            this.O00000o0 = o00000o0;
        }
    }
}
