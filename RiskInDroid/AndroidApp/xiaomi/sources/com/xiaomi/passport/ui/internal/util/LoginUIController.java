package com.xiaomi.passport.ui.internal.util;

import _m_j.ehv;
import _m_j.eir;
import android.app.Activity;
import android.app.FragmentManager;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.account.data.Step2LoginParams;
import com.xiaomi.passport.uicontroller.PhoneLoginController;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.FutureTask;

public final class LoginUIController {

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<UIControllerType, FutureTask> f6263O000000o = new HashMap();
    public final Activity O00000Oo;
    private PhoneLoginController O00000o;
    public PhoneLoginController.O00000o0 O00000o0;
    private ehv O00000oO;

    public interface O000000o {
        void O000000o(int i);

        void O000000o(AccountInfo accountInfo);

        void O000000o(Step2LoginParams step2LoginParams);

        void O000000o(String str);

        void O000000o(String str, String str2);
    }

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i);

        void O000000o(AccountInfo accountInfo);

        void O00000Oo();
    }

    public enum UIControllerType {
        PASSWORD_LOGIN,
        PHONE_LOGIN,
        PHONE_REGISTER,
        SEND_PHONE_TICKET,
        ADD_OR_UPDATE_ACCOUNT_MANAGER,
        QUERY_PHONE_USER_INFO
    }

    public LoginUIController(Activity activity) {
        this.O00000Oo = activity;
        this.O00000o = new PhoneLoginController();
        this.O00000o0 = new PhoneLoginController.O00000o0() {
            /* class com.xiaomi.passport.ui.internal.util.LoginUIController.AnonymousClass1 */

            public final RegisterUserInfo O000000o(QueryPhoneInfoParams queryPhoneInfoParams) throws Exception {
                return eir.O000000o(LoginUIController.this.O00000Oo.getApplicationContext(), LoginUIController.this.O00000Oo.getFragmentManager(), super.O000000o(queryPhoneInfoParams), queryPhoneInfoParams);
            }
        };
        this.O00000o.f6340O000000o = this.O00000o0;
    }

    public final void O000000o(FragmentManager fragmentManager, String str) {
        if (this.O00000oO != null) {
            O000000o();
        }
        ehv.O000000o o000000o = new ehv.O000000o();
        o000000o.f15303O000000o = str;
        this.O00000oO = o000000o.O000000o();
        this.O00000oO.O000000o(fragmentManager, "LoginUIController");
    }

    public final void O000000o() {
        ehv ehv = this.O00000oO;
        if (ehv != null && ehv.getActivity() != null && !this.O00000oO.getActivity().isFinishing()) {
            this.O00000oO.dismissAllowingStateLoss();
            this.O00000oO = null;
        }
    }

    public final boolean O000000o(UIControllerType uIControllerType) {
        FutureTask futureTask = this.f6263O000000o.get(uIControllerType);
        return futureTask != null && !futureTask.isDone();
    }
}
