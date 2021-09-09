package com.xiaomi.youpin.login.api.manager;

import _m_j.ibi;
import _m_j.ibm;
import _m_j.ibp;
import android.content.Context;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import java.util.List;

public abstract class CoreBaseLoginManager {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f12065O000000o;
    protected int O00000Oo = ibm.f1156O000000o.O00000Oo;
    protected List<String> O00000o = ibm.f1156O000000o.O0000Oo0;
    protected String O00000o0 = ibm.f1156O000000o.O0000OOo;
    protected List<String> O00000oO = ibm.f1156O000000o.O0000Oo;
    protected boolean O00000oo;
    protected boolean O0000O0o;

    public CoreBaseLoginManager(Context context) {
        this.f12065O000000o = context;
        ibi ibi = ibm.f1156O000000o.O0000OoO;
        if (ibi != null) {
            this.O0000O0o = ibi.O000000o();
        }
        this.O00000oo = ibm.f1156O000000o.O0000Ooo;
    }

    protected static void O000000o(LoginMiAccount loginMiAccount, ibp ibp) {
        ibp.O000000o(loginMiAccount);
    }
}
