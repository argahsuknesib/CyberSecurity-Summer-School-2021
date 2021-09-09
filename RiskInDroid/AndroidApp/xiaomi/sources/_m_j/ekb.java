package _m_j;

import _m_j.egc;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.Gender;
import com.xiaomi.accountsdk.account.data.XiaomiUserProfile;
import com.xiaomi.accountsdk.account.exception.InvalidParameterException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.lang.ref.WeakReference;

public final class ekb extends AsyncTask<Void, Void, O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f15560O000000o;
    private Gender O00000Oo;
    private WeakReference<Activity> O00000o;
    private O000000o O00000o0;

    public interface O000000o {
        void O000000o(String str, Gender gender);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return O000000o();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        int i;
        O00000Oo o00000Oo = (O00000Oo) obj;
        super.onPostExecute(o00000Oo);
        ejo ejo = new ejo(o00000Oo.O00000Oo.intValue());
        if (ejo.O000000o()) {
            if (o00000Oo.O00000Oo.intValue() != 16 || TextUtils.isEmpty(this.f15560O000000o)) {
                i = ejo.O00000Oo();
            } else {
                i = R.string.account_error_user_name;
            }
            Activity activity = this.O00000o.get();
            if (activity != null && !activity.isFinishing()) {
                if (o00000Oo.f15561O000000o != null) {
                    egc.O000000o o000000o = egc.O00000Oo;
                    egc.O000000o.O000000o(activity, o00000Oo.f15561O000000o);
                    return;
                }
                Toast.makeText(activity, i, 0).show();
                return;
            }
            return;
        }
        this.O00000o0.O000000o(this.f15560O000000o, this.O00000Oo);
    }

    ekb(Activity activity, String str, Gender gender, O000000o o000000o) {
        this.f15560O000000o = str;
        this.O00000Oo = gender;
        this.O00000o0 = o000000o;
        this.O00000o = new WeakReference<>(activity);
    }

    private O00000Oo O000000o() {
        int i;
        Activity activity = this.O00000o.get();
        if (activity == null) {
            AccountLog.w("UploadMiUserProfileTask", "context is null");
            return new O00000Oo(this, null, 5, (byte) 0);
        }
        Context applicationContext = activity.getApplicationContext();
        eez O000000o2 = eez.O000000o(applicationContext, "passportapi");
        if (O000000o2 == null) {
            AccountLog.w("UploadMiUserProfileTask", "null passportInfo");
            return new O00000Oo(this, null, 5, (byte) 0);
        }
        int i2 = 0;
        int i3 = 5;
        while (true) {
            if (i2 >= 2) {
                i = i3;
                break;
            }
            try {
                XMPassport.uploadXiaomiUserProfile(O000000o2, new XiaomiUserProfile(O000000o2.getUserId(), this.f15560O000000o, null, this.O00000Oo));
                i = 0;
                break;
            } catch (IOException e) {
                AccountLog.e("UploadMiUserProfileTask", "UploadUserInfoTask error", e);
                i = 2;
            } catch (AuthenticationFailureException e2) {
                AccountLog.e("UploadMiUserProfileTask", "UploadUserInfoTask error", e2);
                O000000o2.O000000o(applicationContext);
                i2++;
                i3 = 1;
            } catch (AccessDeniedException e3) {
                AccountLog.e("UploadMiUserProfileTask", "UploadUserInfoTask error", e3);
                i = 4;
            } catch (InvalidResponseException e4) {
                AccountLog.e("UploadMiUserProfileTask", "UploadUserInfoTask error", e4);
                ServerError serverError = e4.getServerError();
                if (serverError != null) {
                    return new O00000Oo(this, serverError, 3, (byte) 0);
                }
                i = 3;
            } catch (CipherException e5) {
                AccountLog.e("UploadMiUserProfileTask", "UploadUserInfoTask error", e5);
                i = 3;
            } catch (InvalidParameterException e6) {
                AccountLog.e("UploadMiUserProfileTask", "UploadUserInfoTask error", e6);
                i = 16;
            }
        }
        return new O00000Oo(this, null, Integer.valueOf(i), (byte) 0);
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public ServerError f15561O000000o;
        public Integer O00000Oo;

        /* synthetic */ O00000Oo(ekb ekb, ServerError serverError, Integer num, byte b) {
            this(serverError, num);
        }

        private O00000Oo(ServerError serverError, Integer num) {
            this.f15561O000000o = serverError;
            this.O00000Oo = num;
        }
    }
}
