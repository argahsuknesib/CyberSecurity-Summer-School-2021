package com.mobikwik.sdk.ui.frag;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletAPIs;
import com.mobikwik.sdk.ui.data.b;
import com.mobikwik.sdk.ui.util.d;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Permission;

public class f extends Fragment implements d.a {

    /* renamed from: a  reason: collision with root package name */
    Intent f5316a = null;
    /* access modifiers changed from: private */
    public b b;
    private TransactionConfiguration c;
    private WalletAPIs d;
    private boolean e;
    /* access modifiers changed from: private */
    public Activity f;
    private d.b g;
    /* access modifiers changed from: private */
    public String h;
    /* access modifiers changed from: private */
    public Transaction i;
    /* access modifiers changed from: private */
    public ProgressDialog j;
    private boolean k;

    public interface a {
        void a(int i, Intent intent);
    }

    private void b(String str) {
        String str2 = str;
        this.d.getUserBalance(this.i.getUser().getEmail(), this.i.getUser().getCell(), this.i.getOrderId(), this.i.getAmount(), this.c.getMbkId(), b.b(this.f).i(), false, str2, false, !this.c.isDebitWallet(), this.c.getPgResponseUrl(), this.c.getMerchantName(), new i(this));
    }

    private void c(String str) {
        this.d.createWallet(this.i.getUser().getEmail(), this.i.getUser().getCell(), this.i.getOrderId(), this.i.getAmount(), this.c.getMbkId(), b.b(this.f).i(), str, this.c.getPgResponseUrl(), this.c.getMerchantName(), new j(this));
    }

    /* access modifiers changed from: private */
    public void d() {
        if (e()) {
            this.g = d.a(this.h, this.f, false, this);
        }
    }

    private void d(String str) {
        this.d.debitWallet(this.i.getUser().getEmail(), this.i.getUser().getCell(), this.i.getOrderId(), this.i.getAmount(), this.c.getMbkId(), this.b.i(), false, str, false, this.c.getPgResponseUrl(), this.c.getMerchantName(), new k(this));
    }

    private boolean e() {
        return this.f.checkCallingOrSelfPermission(Permission.RECEIVE_SMS) == 0;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (Network.isConnected(this.f)) {
            this.j = ProgressDialog.show(this.f, "", "Processing...", false);
            b b2 = b.b(this.f);
            this.d.generateOtp(this.i.getUser().getEmail(), this.i.getUser().getCell(), this.i.getOrderId(), this.i.getAmount(), b2.f().getMbkId(), b.b(this.f).i(), b2.f().getPgResponseUrl(), b2.f().getMerchantName(), new l(this));
        }
    }

    public void a() {
        f();
    }

    public void a(View view) {
        EditText editText = (EditText) getView().findViewById(R.id.otp);
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() == 0) {
            editText.requestFocus();
            editText.setError("Please Enter OTP");
            return;
        }
        Utils.hideKeyBoard(editText);
        this.f5316a = new Intent(this.f.getIntent());
        if (Network.isConnected(this.f)) {
            this.j = ProgressDialog.show(this.f, "", "Processing...", false);
            if (this.e) {
                d(obj);
            } else if (this.k) {
                c(obj);
            } else {
                b(obj);
            }
        }
    }

    public void a(String str) {
        ((EditText) getView().findViewById(R.id.otp)).setText(str);
        a((View) null);
    }

    public void b() {
    }

    public void c() {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f5316a == null) {
            this.f5316a = this.f.getIntent();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = b.b(getActivity());
        this.c = b.b(getActivity()).f();
        this.d = WalletAPIs.getInstance("1".equals(this.c.getMode()), getActivity());
        this.h = getArguments().getString("MSG");
        this.k = "true".equalsIgnoreCase(getArguments().getString("NEWUSER"));
        this.e = "true".equalsIgnoreCase(getArguments().getString("ISTODEBIT"));
        this.i = b.b(this.f).d();
        View inflate = layoutInflater.inflate((int) R.layout.mk_frag_otplogin, viewGroup, false);
        String string = getString(R.string.otp_login_msg);
        ((TextView) inflate.findViewById(R.id.otpMsg)).setText(Html.fromHtml(string.replace("@@ee@@", "<font color=#01b7c2><b>" + this.i.getUser().getEmail() + "</b></font>,<br><br>").replace("@@mm@@", this.h)));
        Button button = (Button) inflate.findViewById(R.id.LoginButton);
        if (this.e) {
            button.setText("Confirm");
        }
        button.setOnClickListener(new g(this));
        inflate.findViewById(R.id.ResendOtpButton).setOnClickListener(new h(this));
        d();
        return inflate;
    }

    public void onStop() {
        d.b bVar = this.g;
        if (bVar != null) {
            bVar.a();
        }
        super.onStop();
    }
}
