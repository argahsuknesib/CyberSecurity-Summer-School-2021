package _m_j;

import _m_j.egc;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.BindPhoneActivity;
import com.xiaomi.passport.ui.settings.CaptchaView;
import com.xiaomi.smarthome.R;

public final class ejv extends ejj {
    public CaptchaView O0000O0o;

    public static ejv O000000o(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("phone", str);
        ejv ejv = new ejv();
        ejv.setArguments(bundle);
        return ejv;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getArguments() == null) {
            AccountLog.i("InputBindedVerifyCodeFr", "args is null");
            getActivity().finish();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000o0.setVisibility(8);
        this.O0000O0o = (CaptchaView) view.findViewById(R$id.captcha_layout);
    }

    public final void O00000Oo(String str) {
        O00000o0(str);
        Analytics.O00000Oo("change_phone_resend_code");
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        super.O000000o();
        Analytics.O00000Oo("change_phone_submit_code");
    }

    public final void O00000o0(String str) {
        String str2;
        final BindPhoneActivity bindPhoneActivity = (BindPhoneActivity) getActivity();
        if (this.O0000O0o.getVisibility() == 0) {
            str2 = this.O0000O0o.getCaptchaCode();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
        } else {
            str2 = null;
        }
        bindPhoneActivity.sendModifySafePhoneTicket(str, str2, this.O0000O0o.getCaptchaIck(), new BindPhoneActivity.O00000Oo() {
            /* class _m_j.ejv.AnonymousClass2 */

            public final void O000000o(String str) {
                if (ejv.this.O0000O0o.getVisibility() == 0) {
                    ejv ejv = ejv.this;
                    ejv.O000000o(ejv.getString(R.string.passport_wrong_captcha));
                }
                ejv.this.O0000O0o.setVisibility(0);
                ejv.this.O0000O0o.O000000o(str, egd.f15248O000000o);
            }

            public final void O000000o(int i) {
                ejv ejv = ejv.this;
                ejv.O000000o(ejv.getString(i));
            }

            public final void O000000o() {
                ejv.this.O00000o0();
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

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle((int) R.string.restart_phone_bind_title);
        builder.setMessage((int) R.string.restart_phone_bind_message);
        builder.setPositiveButton((int) R.string.restart_action, new DialogInterface.OnClickListener() {
            /* class _m_j.ejv.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ejv.this.getActivity().finish();
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.create().show();
        return true;
    }

    public final void O000000o(String str, String str2) {
        final BindPhoneActivity bindPhoneActivity = (BindPhoneActivity) getActivity();
        bindPhoneActivity.modifySafePhone(str, null, str2, new BindPhoneActivity.O000000o() {
            /* class _m_j.ejv.AnonymousClass1 */

            public final void O000000o(String str) {
                ejv.this.O00000o0(str);
            }

            public final void O000000o(int i) {
                ejv ejv = ejv.this;
                ejv.O000000o(ejv.getString(i));
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
}
