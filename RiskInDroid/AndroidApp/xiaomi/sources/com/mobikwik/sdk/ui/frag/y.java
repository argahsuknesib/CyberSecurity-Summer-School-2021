package com.mobikwik.sdk.ui.frag;

import _m_j.ei;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletAPIs;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.data.b;
import com.xiaomi.smarthome.R;

public class y extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f5336a;
    private Transaction b;
    private Double c;
    /* access modifiers changed from: private */
    public ProgressDialog d;
    private b e;
    private WalletAPIs f;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public CheckBox h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public String j;
    private boolean k;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void a(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.layout_promo_parent);
        View inflate = LayoutInflater.from(this.f5336a).inflate((int) R.layout.mk_layout_couponcode, (ViewGroup) null, false);
        inflate.findViewById(R.id.btn_apply_promo).setOnClickListener(null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.checkbox_promocode);
        viewGroup.addView(inflate, layoutParams);
        viewGroup.requestLayout();
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ac(this, inflate, viewGroup));
    }

    /* access modifiers changed from: private */
    public void b() {
        if (Network.isConnected(this.f5336a)) {
            this.d = ProgressDialog.show(this.f5336a, "", "Processing...", false);
            this.f.debitWallet(this.b.getUser().getEmail(), this.b.getUser().getCell(), this.b.getOrderId(), this.b.getAmount(), this.e.f().getMbkId(), b.b(this.f5336a).i(), true, a.a(this.f5336a, this.b.getUser()), true, this.e.f().getPgResponseUrl(), this.e.f().getMerchantName(), new ah(this));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: private */
    public void b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) getView().findViewById(R.id.layout_promo_parent);
        if (z) {
            View inflate = LayoutInflater.from(this.f5336a).inflate((int) R.layout.mk_layout_couponcode, (ViewGroup) null, false);
            inflate.findViewById(R.id.btn_apply_promo).setOnClickListener(null);
            int height = viewGroup.getHeight();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.checkbox_promocode);
            viewGroup.addView(inflate, layoutParams);
            this.h.bringToFront();
            com.mobikwik.sdk.ui.util.a aVar = new com.mobikwik.sdk.ui.util.a(viewGroup, inflate, height, height + this.g, 1);
            aVar.setDuration(200);
            inflate.startAnimation(aVar);
            inflate.findViewById(R.id.btn_apply_promo).setOnClickListener(new ad(this));
            EditText editText = (EditText) getView().findViewById(R.id.editText_promo);
            editText.requestFocus();
            editText.addTextChangedListener(new ae(this));
            return;
        }
        a();
        this.h.bringToFront();
        View findViewById = viewGroup.findViewById(R.id.layout_promo);
        com.mobikwik.sdk.ui.util.a aVar2 = new com.mobikwik.sdk.ui.util.a(viewGroup, findViewById, viewGroup.getHeight(), viewGroup.getHeight() - findViewById.getHeight(), 2);
        aVar2.a(true);
        findViewById.startAnimation(aVar2);
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        String str;
        String str2;
        this.i = 0;
        this.k = z;
        if (!z || !this.h.isChecked()) {
            str = "";
        } else {
            EditText editText = (EditText) getView().findViewById(R.id.editText_promo);
            str = editText.getText().toString();
            if (Utils.isNull(str)) {
                editText.setError("Enter coupon code");
                editText.requestFocus();
                return;
            }
            Utils.hideKeyBoard(editText);
        }
        if (Network.isConnected(this.f5336a)) {
            if (!z) {
                str2 = "Removing coupon code...";
                str = "nopevalue";
            } else {
                str2 = "Applying coupon code...";
            }
            this.d = ProgressDialog.show(this.f5336a, "", str2, false);
            this.f.applyCBCoupon(str, this.b.getOrderId(), this.b.getAmount(), this.e.f().getMbkId(), b.b(this.f5336a).i(), new af(this, z));
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        View findViewById = getView().findViewById(R.id.layout_promo_result_desc);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        EditText editText = (EditText) getView().findViewById(R.id.editText_promo);
        if (editText != null) {
            editText.setError(null);
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.f.generateOtp(this.b.getUser().getEmail(), this.b.getUser().getCell(), this.b.getOrderId(), this.b.getAmount(), this.e.f().getMbkId(), b.b(this.f5336a).i(), this.e.f().getPgResponseUrl(), this.e.f().getMerchantName(), new ai(this, z));
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5336a = activity;
        Utils.print("WalletRequestHandler: onAttach");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = Double.valueOf(getArguments().getDouble("BALANCE"));
        b.b(getActivity());
        this.f = WalletAPIs.getInstance("1".equals(b.b(getActivity()).f().getMode()), getActivity());
        View inflate = layoutInflater.inflate((int) R.layout.mk_frag_wallet_debit_confirmation, viewGroup, false);
        this.b = b.b(this.f5336a).d();
        this.e = b.b(this.f5336a);
        ((TextView) inflate.findViewById(R.id.walletUsr)).setText(Html.fromHtml("Dear <font color=#01b7c2><b>" + this.b.getUser().getEmail() + "</b></font>,<br>"));
        StringBuilder sb = new StringBuilder("Rs. ");
        sb.append(this.c);
        ((TextView) inflate.findViewById(R.id.walletBalAmt)).setText(sb.toString());
        ((TextView) inflate.findViewById(R.id.walletPayAmt)).setText("Rs. " + String.valueOf(Double.parseDouble(this.b.getAmount())));
        ((Button) inflate.findViewById(R.id.confPay)).setOnClickListener(new z(this));
        this.h = (CheckBox) inflate.findViewById(R.id.checkbox_promocode);
        this.h.setOnTouchListener(new aa(this));
        this.h.setOnCheckedChangeListener(new ab(this));
        a(inflate);
        return inflate;
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putString("MSG", str);
        bundle.putString(z ? "NEWUSER" : "ISTODEBIT", "true");
        fVar.setArguments(bundle);
        ei O000000o2 = ((FragmentActivity) this.f5336a).getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, fVar, null);
        O000000o2.O00000Oo();
    }
}
