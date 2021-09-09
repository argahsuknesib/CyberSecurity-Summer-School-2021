package _m_j;

import android.app.Activity;
import android.content.Context;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class eko {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ExecutorService f15576O000000o = Executors.newFixedThreadPool(3);
    public final Context O00000Oo;
    public SimpleFutureTask<AccountInfo> O00000o0;

    public interface O000000o {
        void O000000o(Throwable th);
    }

    public interface O00000Oo {
        void O000000o(AccountInfo accountInfo);
    }

    public eko(Activity activity) {
        this.O00000Oo = activity.getApplicationContext();
    }
}
