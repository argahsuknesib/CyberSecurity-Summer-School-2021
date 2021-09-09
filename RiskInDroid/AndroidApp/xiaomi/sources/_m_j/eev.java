package _m_j;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;

public interface eev {
    AccountManagerFuture<Boolean> O000000o(Account account, AccountManagerCallback<Boolean> accountManagerCallback, Handler handler);

    AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler);

    AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler);

    AccountManagerFuture<Bundle> O000000o(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler);

    MiAccountManagerFuture<XmAccountVisibility> O000000o(Context context);

    ServiceTokenFuture O000000o(Context context, ServiceTokenResult serviceTokenResult);

    ServiceTokenFuture O000000o(Context context, String str);

    String O000000o(Account account);

    String O000000o(Account account, String str);

    void O000000o(Account account, String str, String str2);

    void O000000o(String str, String str2);

    boolean O000000o(Account account, String str, Bundle bundle);

    Account[] O000000o();

    Account[] O000000o(String str);

    void O00000Oo(Account account, String str);

    void O00000Oo(Account account, String str, String str2);
}
