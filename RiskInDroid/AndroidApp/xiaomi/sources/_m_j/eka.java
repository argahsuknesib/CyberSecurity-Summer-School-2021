package _m_j;

import _m_j.ejp;
import _m_j.ejy;
import android.accounts.Account;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.CaptchaView;
import com.xiaomi.passport.ui.settings.UserInfoManager;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;

public final class eka extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f15556O000000o;
    public String O00000Oo;
    private TextView O00000o;
    public ejp O00000o0;
    private TextView O00000oO;
    private Button O00000oo;
    private Button O0000O0o;

    public static eka O000000o(String str) {
        eka eka = new eka();
        Bundle bundle = new Bundle();
        bundle.putString("extra_email_address", str);
        eka.setArguments(bundle);
        return eka;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getString("extra_email_address") == null) {
            getActivity().finish();
            return;
        }
        this.O00000Oo = arguments.getString("extra_email_address");
        this.O00000o0 = new ejp(getActivity(), new ejp.O000000o() {
            /* class _m_j.eka.AnonymousClass1 */

            public final void O000000o(String str, String str2) {
                eka.this.O000000o(str, str2);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.unactivated_bind_email, viewGroup, false);
        this.O00000o = (TextView) inflate.findViewById(R$id.email_address);
        this.O00000o.setText(this.O00000Oo);
        this.O00000oO = (TextView) inflate.findViewById(R$id.activate_email_notice);
        this.O00000oo = (Button) inflate.findViewById(R$id.resend_email_btn);
        this.O0000O0o = (Button) inflate.findViewById(R$id.verified_email_btn);
        this.O00000oo.setOnClickListener(this);
        this.O0000O0o.setOnClickListener(this);
        String str = getString(R.string.activate_email_notice) + " ";
        String string = getString(R.string.change_activate_email);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str).append((CharSequence) string);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            /* class _m_j.eka.AnonymousClass2 */

            public final void onClick(View view) {
                eka.this.getActivity().setResult(9999);
                eka.this.getActivity().finish();
            }
        }, str.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(36), str.length(), spannableStringBuilder.length(), 33);
        this.O00000oO.setText(spannableStringBuilder);
        this.O00000oO.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }

    public final void onClick(View view) {
        if (view == this.O00000oo) {
            O000000o(null, null);
            Analytics.O00000Oo("change_email_resend_code");
        } else if (view == this.O0000O0o) {
            UserInfoManager.O000000o(getActivity().getApplicationContext());
            getActivity().finish();
            Analytics.O00000o0("click_change_email_success");
        }
    }

    public final void onDestroy() {
        O000000o o000000o = this.f15556O000000o;
        if (o000000o != null) {
            o000000o.cancel(true);
            this.f15556O000000o = null;
        }
        super.onDestroy();
    }

    public final void O000000o(String str, String str2) {
        if (this.f15556O000000o == null) {
            Account O00000oo2 = MiAccountManager.O00000Oo(getActivity()).O00000oo();
            if (O00000oo2 == null) {
                AccountLog.w("UnactivatedEmailFragmen", "no xiaomi account");
                getActivity().finish();
            }
            this.f15556O000000o = new O000000o(getActivity(), this.O00000Oo, new UserDataProxy(getActivity()).O000000o(O00000oo2, "identity_auth_token"), str, str2);
            this.f15556O000000o.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    class O000000o extends ejy {
        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onCancelled(Object obj) {
            super.onCancelled((ejy.O000000o) obj);
            eka.this.f15556O000000o = null;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            int i;
            String str;
            ejy.O000000o o000000o = (ejy.O000000o) obj;
            eka.this.f15556O000000o = null;
            if (o000000o == null) {
                return;
            }
            if (!TextUtils.isEmpty(o000000o.O00000Oo)) {
                ejp ejp = eka.this.O00000o0;
                String str2 = URLs.ACCOUNT_DOMAIN + o000000o.O00000Oo;
                String str3 = egd.f15248O000000o;
                if (ejp.f15527O000000o != null && !ejp.f15527O000000o.isFinishing()) {
                    if (ejp.O00000o0 == null || !ejp.O00000o0.isShowing()) {
                        ejp.O00000o = new CaptchaView(ejp.f15527O000000o);
                        ejp.O00000o.setOnCaptchaSwitchChange(ejp);
                        ejp.O00000o.O000000o(str2, str3);
                        ejp.O00000o0 = new AlertDialog.Builder(ejp.f15527O000000o).setTitle((int) R.string.passport_input_captcha_hint).setView(ejp.O00000o).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
                        ejp.O00000o0.getButton(-1).setOnClickListener(new View.OnClickListener() {
                            /* class _m_j.ejp.AnonymousClass1 */

                            public final void onClick(View view) {
                                ejp ejp = ejp.this;
                                String captchaCode = ejp.O00000o != null ? ejp.O00000o.getCaptchaCode() : null;
                                if (!TextUtils.isEmpty(captchaCode)) {
                                    ejp.this.O00000Oo.O000000o(captchaCode, ejp.this.O00000o.getCaptchaIck());
                                }
                            }
                        });
                    } else if (ejp.O00000o != null) {
                        CaptchaView captchaView = ejp.O00000o;
                        captchaView.O00000o0.requestFocus();
                        EditText editText = captchaView.O00000o0;
                        if (captchaView.O00000oO) {
                            str = captchaView.getResources().getString(R.string.passport_wrong_voice);
                        } else {
                            str = captchaView.getResources().getString(R.string.passport_wrong_captcha);
                        }
                        editText.setError(str);
                    }
                }
            } else {
                ejp ejp2 = eka.this.O00000o0;
                if (ejp2.O00000o0 != null) {
                    ejp2.O00000o0.dismiss();
                }
                if (o000000o.f15549O000000o == 13) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(eka.this.getActivity());
                    builder.setTitle((int) R.string.resend_email_reach_limit_title);
                    builder.setMessage((int) R.string.resend_email_reach_limit_message);
                    builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
                    builder.create().show();
                    return;
                }
                ejo ejo = new ejo(o000000o.f15549O000000o);
                if (ejo.O000000o()) {
                    i = ejo.O00000Oo();
                } else {
                    i = R.string.resend_email_success;
                    eka eka = eka.this;
                    String str4 = eka.O00000Oo;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    Account O00000oo = MiAccountManager.O00000Oo(eka.getActivity()).O00000oo();
                    if (O00000oo == null) {
                        AccountLog.w("UnactivatedEmailFragmen", "no xiaomi account");
                        eka.getActivity().finish();
                    } else {
                        SharedPreferences.Editor edit = eka.getActivity().getSharedPreferences(O00000oo.name, 0).edit();
                        edit.putString("unactivated_email_address", str4);
                        edit.putLong("unactivated_email_time_stamp", valueOf.longValue());
                        edit.apply();
                    }
                }
                Toast.makeText(eka.this.getActivity(), i, 1).show();
            }
        }

        public O000000o(Context context, String str, String str2, String str3, String str4) {
            super(context, str, str2, str3, str4);
        }
    }
}
