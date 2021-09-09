package com.xiaomi.smarthome.frame.login.ui;

import _m_j.fro;
import _m_j.frp;
import _m_j.fsp;
import _m_j.ft;
import _m_j.fth;
import _m_j.ftj;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gtz;
import _m_j.gwg;
import _m_j.hxi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.Random;
import org.json.JSONObject;

public abstract class LoginBaseActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f7534O000000o;
    protected long O00000Oo;
    protected MijiaLoginManager O00000o;
    protected XQProgressDialog O00000o0;
    private BroadcastReceiver O00000oO = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.frame.login.ui.LoginBaseActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
                String action = intent.getAction();
                char c = 65535;
                if (action.hashCode() == 735880982 && action.equals("action.passwordlogin.login.complete")) {
                    c = 0;
                }
                if (c == 0 && intent.getBooleanExtra("login_success", false)) {
                    LoginBaseActivity.this.finish();
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    /* access modifiers changed from: protected */
    public boolean O00000oO() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        frp O000000o2;
        super.onCreate(bundle);
        try {
            if (gty.O000000o().shouldInitFacebookSdk() && (O000000o2 = fro.O000000o()) != null) {
                O000000o2.initFacebookSdk(false);
            }
            gty.O000000o().initAccount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView((int) R.layout.mj_login_mi_by_system_account_activity);
        if (O00000oO()) {
            int intExtra = getIntent().getIntExtra("login_type", 1);
            gsy.O000000o(3, "LoginMi", "type   :".concat(String.valueOf(intExtra)));
            if (intExtra == 3) {
                long longExtra = getIntent().getLongExtra("login_timestamp", 1);
                gsy.O000000o(3, "LoginMi", "timeStamp   :" + longExtra + "System.currentTimeMillis() - timeStamp" + (System.currentTimeMillis() - longExtra));
                if (System.currentTimeMillis() - longExtra > 10000) {
                    fsp.O000000o().O00000oo.O000000o(this.f7534O000000o);
                    finish();
                }
            }
        }
        this.f7534O000000o = this;
        this.O00000Oo = new Random().nextLong();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.passwordlogin.login.complete");
        ft.O000000o(this).O000000o(this.O00000oO, intentFilter);
        this.O00000o0 = new XQProgressDialog(this.f7534O000000o);
        this.O00000o0.setCancelable(true);
        gwg.O00000Oo(getWindow());
        this.O00000o = new MijiaLoginManager(this);
        O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        fsp.O000000o().O00000oo.O000000o(4);
        ftj.O000000o(this.f7534O000000o);
        setResult(-1);
        fth.O000000o(this.f7534O000000o, true);
        finish();
    }

    protected static void O00000o() {
        fsp.O000000o().O00000oo.O00000Oo();
    }

    protected static void O000000o(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("login_type", str);
            jSONObject.put("err_code", i);
            jSONObject.put("extra", str2);
            hxi.O0000Oo.O000000o(1, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String valueOf = String.valueOf(i);
        gtz gtz = fsp.O000000o().O00000oo;
        gtz.O000000o("loginType: " + str + " errCode " + valueOf + " errMsg " + str2);
    }

    public void onDestroy() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (!(currentFocus == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null)) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        ft.O000000o(this).O000000o(this.O00000oO);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
    }
}
