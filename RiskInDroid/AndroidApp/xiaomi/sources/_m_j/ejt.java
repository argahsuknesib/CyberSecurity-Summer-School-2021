package _m_j;

import _m_j.ejy;
import android.accounts.Account;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.CaptchaView;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;

public final class ejt extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public EditText f15535O000000o;
    public O000000o O00000Oo;
    final TextWatcher O00000o = new TextWatcher() {
        /* class _m_j.ejt.AnonymousClass1 */

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            ejt.this.O000000o(false, null);
        }
    };
    public CaptchaView O00000o0;
    private Button O00000oO;
    private TextView O00000oo;
    private AsyncTask<Void, Void, Integer> O0000O0o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.input_bind_email_address, viewGroup, false);
        this.f15535O000000o = (EditText) inflate.findViewById(R$id.email_address);
        this.O00000oO = (Button) inflate.findViewById(R$id.btn_next);
        this.O00000oO.setOnClickListener(this);
        this.O00000o0 = (CaptchaView) inflate.findViewById(R$id.captcha_layout);
        this.O00000oo = (TextView) inflate.findViewById(R$id.error_status);
        this.f15535O000000o.addTextChangedListener(this.O00000o);
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x00a8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    public final void onClick(View view) {
        String str;
        if (view == this.O00000oO) {
            String obj = this.f15535O000000o.getText().toString();
            String str2 = null;
            if (TextUtils.isEmpty(obj)) {
                this.f15535O000000o.setError(getString(R.string.passport_error_empty_email));
            } else if (!Patterns.EMAIL_ADDRESS.matcher(obj).matches()) {
                this.f15535O000000o.setError(getString(R.string.passport_error_email));
            } else {
                str = obj;
                if (!TextUtils.isEmpty(str)) {
                    if (this.O00000o0.getVisibility() == 0) {
                        str2 = this.O00000o0.getCaptchaCode();
                    }
                    String str3 = str2;
                    Account O00000oo2 = MiAccountManager.O00000Oo(getActivity()).O00000oo();
                    if (O00000oo2 == null) {
                        AccountLog.w("InputBindedEmailFragmen", "no xiaomi account");
                        getActivity().finish();
                    } else if (this.O00000Oo == null) {
                        this.O00000Oo = new O000000o(getActivity(), str, new UserDataProxy(getActivity()).O000000o(O00000oo2, "identity_auth_token"), str3, this.O00000o0.getCaptchaIck());
                        this.O00000Oo.executeOnExecutor(ekx.O000000o(), new Void[0]);
                    }
                }
                Analytics.O00000Oo("change_email_send_code");
            }
            str = null;
            if (!TextUtils.isEmpty(str)) {
            }
            Analytics.O00000Oo("change_email_send_code");
        }
    }

    public final void onPause() {
        Activity activity = getActivity();
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus == null) {
            AccountLog.w("SysHelper", "no focused view");
        } else {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        super.onPause();
    }

    public final void onDestroy() {
        AsyncTask<Void, Void, Integer> asyncTask = this.O0000O0o;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.O0000O0o = null;
        }
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            o000000o.cancel(true);
            this.O00000Oo = null;
        }
        super.onDestroy();
    }

    class O000000o extends ejy {
        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onCancelled(Object obj) {
            super.onCancelled((ejy.O000000o) obj);
            ejt.this.O00000Oo = null;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            ejy.O000000o o000000o = (ejy.O000000o) obj;
            ejt.this.O00000Oo = null;
            if (o000000o != null) {
                if (!TextUtils.isEmpty(o000000o.O00000Oo)) {
                    CaptchaView captchaView = ejt.this.O00000o0;
                    captchaView.O000000o(URLs.ACCOUNT_DOMAIN + o000000o.O00000Oo, egd.f15248O000000o);
                    if (ejt.this.O00000o0.getVisibility() != 0) {
                        ejt.this.O00000o0.setVisibility(0);
                        return;
                    }
                }
                ejo ejo = new ejo(o000000o.f15549O000000o);
                if (ejo.O000000o()) {
                    ejt.this.O000000o(true, ejt.this.getString(ejo.O00000Oo()));
                    return;
                }
                String obj2 = ejt.this.f15535O000000o.getText().toString();
                ejt ejt = ejt.this;
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                Account O00000oo = MiAccountManager.O00000Oo(ejt.getActivity()).O00000oo();
                if (O00000oo == null) {
                    AccountLog.w("InputBindedEmailFragmen", "no xiaomi account");
                    ejt.getActivity().finish();
                } else {
                    SharedPreferences.Editor edit = ejt.getActivity().getSharedPreferences(O00000oo.name, 0).edit();
                    edit.putString("unactivated_email_address", obj2);
                    edit.putLong("unactivated_email_time_stamp", valueOf.longValue());
                    edit.commit();
                }
                eis.O000000o(ejt.this.getActivity(), eka.O000000o(obj2), ((ViewGroup) ejt.this.getView().getParent()).getId());
            }
        }

        public O000000o(Context context, String str, String str2, String str3, String str4) {
            super(context, str, str2, str3, str4);
        }
    }

    public final void O000000o(boolean z, String str) {
        int i;
        if (z) {
            this.O00000oo.setVisibility(0);
            this.O00000oo.setText(str);
            i = R.dimen.passport_buttons_margin_v;
        } else {
            this.O00000oo.setVisibility(8);
            i = R.dimen.passport_reg_content_bottom_margin;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, dimensionPixelSize, 0, 0);
        this.O00000oO.setLayoutParams(layoutParams);
    }
}
