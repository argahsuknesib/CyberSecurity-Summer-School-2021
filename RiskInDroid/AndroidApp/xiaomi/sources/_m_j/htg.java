package _m_j;

import _m_j.cbm;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.mi.global.shop.activity.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;

public class htg extends caq implements fvn, fvq {
    private long O0000ooo = 0;
    private volatile boolean O00oOooO = true;

    public htg() {
        try {
            gsy.O00000Oo("ShopGlobalFragment", "ShopGlobalFragment new");
            if (byl.O00000oo() == null) {
                hth.O000000o(true);
            }
            String str = ftn.O0000Oo(getContext()) ? cad.O00000o : "";
            if (!TextUtils.isEmpty(str)) {
                cad.O000000o(str);
            }
            setArguments(new Bundle());
        } catch (Throwable th) {
            th.printStackTrace();
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "ShopGlobalFragment", "ShopGlobalFragment exception " + th.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00oOooO = false;
        gsy.O00000Oo("ShopGlobalFragment", "onCreate " + this.O00oOooO);
    }

    public void onDestroy() {
        this.O00oOooO = true;
        gsy.O00000Oo("ShopGlobalFragment", "onDestroy " + this.O00oOooO);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        gsy.O00000Oo("ShopGlobalFragment", "onResume " + this.O00oOooO);
    }

    public void onPause() {
        super.onPause();
        gsy.O00000Oo("ShopGlobalFragment", "onPause " + this.O00oOooO);
    }

    public void onStart() {
        super.onStart();
        gsy.O00000Oo("ShopGlobalFragment", "onStart " + this.O00oOooO);
    }

    public void onStop() {
        super.onStop();
        gsy.O00000Oo("ShopGlobalFragment", "onStop " + this.O00oOooO);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        gsy.O00000Oo("ShopGlobalFragment", "onAttach " + this.O00oOooO);
    }

    public void onDetach() {
        super.onDetach();
        gsy.O00000Oo("ShopGlobalFragment", "onDetach " + this.O00oOooO);
    }

    public void refreshTitleBar() {
        gwg.O00000Oo(((Activity) getContext()).getWindow());
    }

    public void onSwitchtoPage(int i, boolean z) {
        if (z) {
            this.O0000ooo = hxi.O00000Oo.O000000o(this, null);
        } else if (this.O0000ooo > 0) {
            hxi.O00000Oo.O000000o(this, this.O0000ooo, null);
            this.O0000ooo = 0;
        }
        try {
            byl.O00000Oo(z);
        } catch (Throwable th) {
            gsy.O00000o0(LogType.DEVICE_LIST, "ShopGlobalFragment", Log.getStackTraceString(th));
        }
        if (z) {
            ccr.O00000Oo(caq.f13532O000000o, "update cart as pref value");
            if (ccn.O0000o00().O0000o0O()) {
                if (BaseActivity.unpaidNum == -1) {
                    BaseActivity.unpaidNum = cbm.O00000o0.O000000o(getContext(), "pref_key_unpaid_number", 0);
                }
                super.O00000o0(BaseActivity.unpaidNum);
            }
            ccr.O00000Oo(caq.f13532O000000o, "update cart as pref value");
            if (BaseActivity.shoppingCartNum == -1) {
                BaseActivity.shoppingCartNum = cbm.O00000o0.O000000o(getContext(), "pref_key_shoppingcart_number", 0);
            }
            super.O00000Oo(BaseActivity.shoppingCartNum);
            O00000Oo();
        }
    }
}
