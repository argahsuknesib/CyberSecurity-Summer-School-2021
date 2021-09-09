package _m_j;

import _m_j.ejz;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.settings.utils.AccountSmsVerifyCodeReceiver;
import com.xiaomi.smarthome.R;

public abstract class ejj extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public EditText f15504O000000o;
    public TextView O00000Oo;
    public O000000o O00000o;
    protected CheckBox O00000o0;
    public O000000o O00000oO;
    protected String O00000oo;
    private long O0000O0o = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
    private Button O0000OOo;
    private AccountSmsVerifyCodeReceiver O0000Oo0;

    public abstract void O000000o(String str, String str2);

    public abstract void O00000Oo(String str);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ejz.O000000o o000000o = new ejz.O000000o(2);
        o000000o.O00000Oo = getString(R.string.passport_trying_read_verify_code_sms);
        o000000o.O00000o0 = false;
        final ejz O000000o2 = o000000o.O000000o();
        O000000o2.O000000o(getFragmentManager(), "autoReadSmsProgress");
        this.O00000o = new O000000o() {
            /* class _m_j.ejj.AnonymousClass1 */

            public final void onTick(long j) {
            }

            public final void onFinish() {
                ejz ejz = O000000o2;
                if (!(ejz == null || ejz.getActivity() == null || O000000o2.getActivity().isFinishing())) {
                    O000000o2.dismissAllowingStateLoss();
                }
                ejj.this.O00000o = null;
            }

            public final void O000000o() {
                super.O000000o();
                onFinish();
            }
        };
        this.O00000o.start();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.passport_input_phone_vcode, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments == null) {
            AccountLog.i("AbstractVerifyCodeFragment", "args is null");
            getActivity().finish();
            return inflate;
        }
        this.O00000oo = arguments.getString("phone");
        ((TextView) inflate.findViewById(R$id.sms_send_notice)).setText(String.format(getString(R.string.passport_vcode_sms_send_prompt), this.O00000oo));
        this.f15504O000000o = (EditText) inflate.findViewById(R$id.ev_verify_code);
        this.O00000Oo = (TextView) inflate.findViewById(R$id.get_vcode_notice);
        this.O0000OOo = (Button) inflate.findViewById(R$id.btn_verify);
        this.O00000o0 = (CheckBox) inflate.findViewById(R$id.trust_device);
        this.O00000Oo.setOnClickListener(this);
        this.O0000OOo.setOnClickListener(this);
        O00000o0();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        this.O0000Oo0 = new AccountSmsVerifyCodeReceiver(new O00000Oo(this, (byte) 0));
        getActivity().registerReceiver(this.O0000Oo0, intentFilter);
    }

    public void onPause() {
        if (this.O0000Oo0 != null) {
            getActivity().unregisterReceiver(this.O0000Oo0);
            this.O0000Oo0 = null;
        }
        O00000Oo();
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O000000o();
            this.O00000oO = null;
        }
        super.onPause();
    }

    public void onClick(View view) {
        if (view == this.O00000Oo) {
            O00000Oo(this.O00000oo);
        } else if (view == this.O0000OOo) {
            O000000o();
        }
    }

    /* access modifiers changed from: protected */
    public void O000000o() {
        String obj = this.f15504O000000o.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.f15504O000000o.requestFocus();
            this.f15504O000000o.setError(getString(R.string.passport_error_empty_vcode));
            return;
        }
        String str = this.O00000oo;
        O00000o();
        O000000o(str, obj);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        new AlertDialog.Builder(getActivity()).setMessage(str).setNeutralButton(17039370, (DialogInterface.OnClickListener) null).create().show();
    }

    public final void O00000Oo() {
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            o000000o.O000000o();
            this.O00000o = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        this.O00000Oo.setEnabled(false);
        this.O0000O0o *= 2;
        this.O00000oO = new O000000o(this.O0000O0o) {
            /* class _m_j.ejj.AnonymousClass2 */

            public final void onTick(long j) {
                TextView textView = ejj.this.O00000Oo;
                textView.setText(ejj.this.getString(R.string.passport_getting_verify_code) + " (" + (j / 1000) + ")");
            }

            public final void onFinish() {
                ejj.this.O00000Oo.setText(ejj.this.getString(R.string.passport_re_get_verify_code));
                ejj.this.O00000Oo.setEnabled(true);
                ejj.this.O00000oO = null;
            }

            public final void O000000o() {
                super.O000000o();
                ejj.this.O00000oO = null;
            }
        };
        this.O00000oO.start();
    }

    class O00000Oo implements AccountSmsVerifyCodeReceiver.O000000o {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ejj ejj, byte b) {
            this();
        }

        public final void O000000o(String str) {
            if (TextUtils.isEmpty(ejj.this.f15504O000000o.getText().toString())) {
                ejj ejj = ejj.this;
                String str2 = ejj.O00000oo;
                ejj.this.O00000o();
                ejj.O000000o(str2, str);
            }
            ejj.this.O00000Oo();
        }
    }

    public final boolean O00000o() {
        CheckBox checkBox = this.O00000o0;
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }

    abstract class O000000o extends CountDownTimer {
        public O000000o(long j, long j2) {
            super(j, 1000);
        }

        public void O000000o() {
            cancel();
        }
    }
}
