package _m_j;

import android.content.Context;
import android.os.AsyncTask;
import com.xiaomi.accountsdk.account.exception.InvalidBindAddressException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.UsedEmailAddressException;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;

public class ejy extends AsyncTask<Void, Void, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f15548O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;

    /* access modifiers changed from: protected */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    ejy(Context context, String str, String str2, String str3, String str4) {
        this.f15548O000000o = context.getApplicationContext();
        this.O00000Oo = str;
        this.O00000o0 = str2;
        this.O00000o = str3;
        this.O00000oO = str4;
    }

    private O000000o O000000o() {
        eez O000000o2 = eez.O000000o(this.f15548O000000o, "passportapi");
        String str = null;
        int i = 5;
        if (O000000o2 == null) {
            AccountLog.w("SendEmailActivateMessag", "null passportInfo");
            return new O000000o(5, null);
        }
        Context context = this.f15548O000000o;
        MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(context);
        boolean O00000Oo3 = O00000Oo2.O00000Oo();
        if (O00000Oo3) {
            O00000Oo2.O00000oO();
        }
        String hashedDeviceIdNoThrow = new HashedDeviceIdUtil(context).getHashedDeviceIdNoThrow();
        if (O00000Oo3) {
            O00000Oo2.O00000o();
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                i2 = i;
                break;
            }
            try {
                ejw.O000000o(O000000o2, this.O00000Oo, this.O00000o0, hashedDeviceIdNoThrow, this.O00000o, this.O00000oO);
                break;
            } catch (IOException e) {
                AccountLog.e("SendEmailActivateMessag", "IOException", e);
                i2 = 2;
            } catch (AuthenticationFailureException e2) {
                AccountLog.e("SendEmailActivateMessag", "AuthenticationFailureException", e2);
                O000000o2.O000000o(this.f15548O000000o);
                i3++;
                i = 1;
            } catch (AccessDeniedException e3) {
                AccountLog.e("SendEmailActivateMessag", "AccessDeniedException", e3);
                i2 = 4;
            } catch (InvalidResponseException e4) {
                AccountLog.e("SendEmailActivateMessag", "InvalidResponseException", e4);
                i2 = 3;
            } catch (CipherException e5) {
                AccountLog.e("SendEmailActivateMessag", "CipherException", e5);
                i2 = 3;
            } catch (InvalidBindAddressException e6) {
                AccountLog.e("SendEmailActivateMessag", "InvalidBindAddressException", e6);
                i2 = 9;
            } catch (NeedCaptchaException e7) {
                AccountLog.e("SendEmailActivateMessag", "NeedCaptchaException", e7);
                str = e7.getCaptchaUrl();
                i2 = 12;
            } catch (UsedEmailAddressException e8) {
                AccountLog.e("SendEmailActivateMessag", "UsedEmailAddressException", e8);
                i2 = 8;
            } catch (ReachLimitException e9) {
                AccountLog.e("SendEmailActivateMessag", "ReachLimitException", e9);
                i2 = 13;
            }
        }
        return new O000000o(i2, str);
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f15549O000000o;
        String O00000Oo;

        O000000o(int i, String str) {
            this.f15549O000000o = i;
            this.O00000Oo = str;
        }
    }
}
