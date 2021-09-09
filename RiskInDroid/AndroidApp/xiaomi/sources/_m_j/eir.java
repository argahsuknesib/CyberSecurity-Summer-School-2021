package _m_j;

import _m_j.eky;
import android.app.FragmentManager;
import android.content.Context;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;

public final class eir {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15325O000000o = "AccountInNetDateHelper";
    private Context O00000Oo;
    private boolean O00000o = true;
    private FragmentManager O00000o0;
    private Object O00000oO = new Object();

    private eir(Context context, FragmentManager fragmentManager) {
        this.O00000Oo = context;
        this.O00000o0 = fragmentManager;
    }

    public static RegisterUserInfo O000000o(Context context, FragmentManager fragmentManager, RegisterUserInfo registerUserInfo, QueryPhoneInfoParams queryPhoneInfoParams) {
        return new eir(context, fragmentManager).O000000o(registerUserInfo, queryPhoneInfoParams);
    }

    private RegisterUserInfo O000000o(RegisterUserInfo registerUserInfo, QueryPhoneInfoParams queryPhoneInfoParams) {
        if (!(registerUserInfo.status == RegisterUserInfo.RegisterStatus.STATUS_USED_POSSIBLY_RECYCLED && registerUserInfo.needGetActiveTime)) {
            return registerUserInfo;
        }
        if (registerUserInfo.needToast) {
            try {
                synchronized (this.O00000oO) {
                    this.O00000oO.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return eky.O000000o(this.O00000Oo, registerUserInfo, new eky.O000000o(queryPhoneInfoParams.phone, queryPhoneInfoParams.ticket, queryPhoneInfoParams.activatorPhoneInfo), this.O00000o);
    }
}
