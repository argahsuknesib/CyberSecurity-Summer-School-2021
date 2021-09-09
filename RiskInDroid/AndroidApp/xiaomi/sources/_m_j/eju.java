package _m_j;

import _m_j.egc;
import _m_j.ejs;
import _m_j.eki;
import android.accounts.Account;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.AreaCodePickerActivity;
import com.xiaomi.passport.ui.settings.BindPhoneActivity;
import com.xiaomi.passport.ui.settings.CaptchaView;
import com.xiaomi.passport.ui.settings.utils.AccountSmsVerifyCodeReceiver;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class eju extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f15538O000000o;
    public CaptchaView O00000Oo;
    final TextWatcher O00000o = new TextWatcher() {
        /* class _m_j.eju.AnonymousClass4 */

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            eju.this.O000000o(false, null);
        }
    };
    public AsyncTask<Void, Void, ejs.O00000Oo> O00000o0;
    private eki.O000000o O00000oO;
    private TextView O00000oo;
    private EditText O0000O0o;
    private Button O0000OOo;
    private String O0000Oo;
    private Account O0000Oo0;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        eki.O000000o(getActivity());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.input_bind_phone_address, viewGroup, false);
        this.O00000oo = (TextView) inflate.findViewById(R$id.tv_area_code);
        this.O0000O0o = (EditText) inflate.findViewById(R$id.ev_phone);
        this.O0000O0o.addTextChangedListener(this.O00000o);
        this.f15538O000000o = (TextView) inflate.findViewById(R$id.error_status);
        this.O0000OOo = (Button) inflate.findViewById(R$id.btn_phone_next);
        this.O00000oo.setOnClickListener(this);
        this.O0000OOo.setOnClickListener(this);
        this.O00000Oo = (CaptchaView) inflate.findViewById(R$id.captcha_layout);
        O00000o0(Locale.getDefault().getCountry());
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        this.O0000Oo0 = MiAccountManager.O00000Oo(getActivity()).O00000oo();
        if (this.O0000Oo0 == null) {
            AccountLog.i("InputBindedPhoneFragmen", "no xiaomi account");
            getActivity().finish();
        }
    }

    public final void onDestroy() {
        AsyncTask<Void, Void, ejs.O00000Oo> asyncTask = this.O00000o0;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.O00000o0 = null;
        }
        super.onDestroy();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001 && -1 == i2) {
            O00000o0(intent.getStringExtra("country_iso"));
        }
    }

    private void O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            AccountLog.d("InputBindedPhoneFragmen", "region info is null, and set China as the default area iso");
            str = "CN";
        }
        this.O00000oO = eki.O000000o(str);
        TextView textView = this.O00000oo;
        if (textView != null) {
            textView.setText(this.O00000oO.f15572O000000o + "(+" + this.O00000oO.O00000Oo + ")");
        }
    }

    private String O000000o() {
        String obj = this.O0000O0o.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.O0000O0o.setError(getString(R.string.passport_error_empty_phone_num));
            return null;
        }
        eki.O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            obj = eki.O000000o(obj, o000000o);
            if (TextUtils.isEmpty(obj)) {
                this.O0000O0o.setError(getString(R.string.passport_wrong_phone_number_format));
                return null;
            }
        }
        if (!TextUtils.equals(new UserDataProxy(getActivity()).O000000o(this.O0000Oo0, "acc_user_phone"), obj)) {
            return obj;
        }
        this.O0000O0o.setError(getString(R.string.failed_dup_secure_phone_number));
        return null;
    }

    public final void onClick(View view) {
        if (view == this.O00000oo) {
            Intent intent = new Intent(getActivity(), AreaCodePickerActivity.class);
            intent.setPackage(getActivity().getPackageName());
            startActivityForResult(intent, 10001);
        } else if (view == this.O0000OOo) {
            final String O000000o2 = O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                Analytics.O00000Oo("change_phone_send_code");
                if (TextUtils.equals(this.O0000Oo, O000000o2)) {
                    O000000o(O000000o2);
                } else if (this.O00000o0 == null) {
                    this.O00000o0 = new ejs(getActivity(), O000000o2, new ejs.O000000o() {
                        /* class _m_j.eju.AnonymousClass1 */

                        public final void O000000o(int i) {
                            eju eju = eju.this;
                            eju.O00000o0 = null;
                            eju.O000000o(true, eju.getString(i));
                        }

                        public final void O000000o(ejs.O00000o0 o00000o0) {
                            eju eju = eju.this;
                            eju.O00000o0 = null;
                            eju.f15538O000000o.setVisibility(8);
                            try {
                                int i = o00000o0.O00000o0;
                                long j = o00000o0.O00000Oo;
                                String str = o00000o0.f15534O000000o;
                                if (i == 0) {
                                    eju.this.O000000o(true, eju.this.getString(R.string.get_phone_bind_exceed_limit));
                                } else if (TextUtils.isEmpty(str)) {
                                    eju.this.O000000o(O000000o2);
                                } else {
                                    eju eju2 = eju.this;
                                    String str2 = O000000o2;
                                    Date date = new Date();
                                    date.setTime(j);
                                    String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(eju2.getActivity());
                                    builder.setTitle((int) R.string.confirm_bundled_phone_dialog_title);
                                    builder.setMessage(String.format(eju2.getString(R.string.confirm_unbundled_phone_dialog_message), format, str, str));
                                    builder.setPositiveButton(17039370, new DialogInterface.OnClickListener(str2) {
                                        /* class _m_j.eju.AnonymousClass2 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ String f15540O000000o;

                                        {
                                            this.f15540O000000o = r2;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            eju.this.O000000o(this.f15540O000000o);
                                        }
                                    });
                                    builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
                                    builder.create().show();
                                }
                            } catch (Exception e) {
                                AccountLog.e("InputBindedPhoneFragmen", "GetUserBindIdAndLimitException", e);
                            }
                        }

                        public final void O000000o(ServerError serverError) {
                            eju eju = eju.this;
                            eju.O00000o0 = null;
                            if (eju.getActivity() != null && !eju.this.getActivity().isFinishing()) {
                                egc.O000000o o000000o = egc.O00000Oo;
                                egc.O000000o.O000000o(eju.this.getActivity(), serverError);
                            }
                        }
                    });
                    this.O00000o0.executeOnExecutor(ekx.O000000o(), new Void[0]);
                }
            }
        }
    }

    public final void O000000o(final String str) {
        String str2;
        if (this.O00000Oo.getVisibility() == 0) {
            str2 = this.O00000Oo.getCaptchaCode();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
        } else {
            str2 = null;
        }
        final BindPhoneActivity bindPhoneActivity = (BindPhoneActivity) getActivity();
        bindPhoneActivity.sendModifySafePhoneTicket(str, str2, this.O00000Oo.getCaptchaIck(), new BindPhoneActivity.O00000Oo() {
            /* class _m_j.eju.AnonymousClass3 */

            public final void O000000o(String str) {
                if (eju.this.O00000Oo.getVisibility() == 0) {
                    eju eju = eju.this;
                    eju.O000000o(true, eju.getString(R.string.passport_wrong_captcha));
                }
                eju.this.O00000Oo.setVisibility(0);
                eju.this.O00000Oo.O000000o(str, egd.f15248O000000o);
            }

            public final void O000000o(int i) {
                eju eju = eju.this;
                eju.O000000o(true, eju.getString(i));
            }

            public final void O000000o() {
                if (!AccountSmsVerifyCodeReceiver.O000000o(eju.this.getActivity())) {
                    eju.this.O00000Oo(str);
                }
            }

            public final void O000000o(ServerError serverError) {
                BindPhoneActivity bindPhoneActivity = bindPhoneActivity;
                if (bindPhoneActivity != null && !bindPhoneActivity.isFinishing()) {
                    egc.O000000o o000000o = egc.O00000Oo;
                    egc.O000000o.O000000o(bindPhoneActivity, serverError);
                }
            }
        });
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (51 == i) {
            O00000Oo(O000000o());
        }
    }

    public final void O00000Oo(String str) {
        eis.O000000o(getActivity(), ejv.O000000o(str, getArguments()), ((ViewGroup) getView().getParent()).getId());
    }

    public final void O000000o(boolean z, String str) {
        int i;
        if (z) {
            this.f15538O000000o.setVisibility(0);
            this.f15538O000000o.setText(str);
            i = R.dimen.passport_buttons_margin_v;
        } else {
            this.f15538O000000o.setVisibility(8);
            i = R.dimen.passport_reg_content_bottom_margin;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, dimensionPixelSize, 0, 0);
        this.O0000OOo.setLayoutParams(layoutParams);
    }
}
