package _m_j;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import java.util.ArrayList;

public final class ejx extends AsyncTask<Void, Void, XiaomiUserCoreInfo> {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f15547O000000o;
    private final O000000o O00000Oo;
    private final Account O00000o0 = MiAccountManager.O00000Oo(this.f15547O000000o).O00000oo();

    public interface O000000o {
        void O000000o();
    }

    public ejx(Context context, O000000o o000000o) {
        this.f15547O000000o = context;
        this.O00000Oo = o000000o;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        XiaomiUserCoreInfo xiaomiUserCoreInfo;
        Context context = this.f15547O000000o;
        if (MiAccountManager.O00000Oo(context).O00000oo() == null) {
            AccountLog.w("QueryUserInfoTask", "no Xiaomi account, skip to query user info");
            xiaomiUserCoreInfo = null;
        } else {
            eez O000000o2 = eez.O000000o(context, "passportapi");
            ArrayList arrayList = new ArrayList();
            arrayList.add(XiaomiUserCoreInfo.Flag.BASE_INFO);
            arrayList.add(XiaomiUserCoreInfo.Flag.BIND_ADDRESS);
            arrayList.add(XiaomiUserCoreInfo.Flag.EXTRA_INFO);
            arrayList.add(XiaomiUserCoreInfo.Flag.SETTING_INFO);
            xiaomiUserCoreInfo = eis.O000000o(context, O000000o2, arrayList);
        }
        if (xiaomiUserCoreInfo != null) {
            Context context2 = this.f15547O000000o;
            Account account = this.O00000o0;
            if (account == null) {
                AccountLog.w("UserInfoSaver", "no Xiaomi account, skip to save user info");
            } else {
                UserDataProxy userDataProxy = new UserDataProxy(context2);
                userDataProxy.O000000o(account, "acc_user_name", xiaomiUserCoreInfo.userName);
                userDataProxy.O000000o(account, "acc_nick_name", xiaomiUserCoreInfo.nickName);
                userDataProxy.O000000o(account, "acc_user_email", xiaomiUserCoreInfo.emailAddress);
                userDataProxy.O000000o(account, "acc_user_phone", xiaomiUserCoreInfo.safePhone);
                if (xiaomiUserCoreInfo.gender != null) {
                    userDataProxy.O000000o(account, "acc_user_gender", xiaomiUserCoreInfo.gender.getType());
                }
                String str = "xiaomi_user_avatar_" + account.name;
                if (ekd.O000000o(context2, xiaomiUserCoreInfo, str, userDataProxy.O000000o(account, "acc_avatar_url"))) {
                    userDataProxy.O000000o(account, "acc_avatar_url", xiaomiUserCoreInfo.avatarAddress);
                    userDataProxy.O000000o(account, "acc_avatar_file_name", str);
                }
            }
        }
        return xiaomiUserCoreInfo;
    }
}
