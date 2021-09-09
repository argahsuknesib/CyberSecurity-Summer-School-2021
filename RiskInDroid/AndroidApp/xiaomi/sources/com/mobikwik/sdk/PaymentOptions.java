package com.mobikwik.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.wallet.WalletAPIs;
import com.mobikwik.sdk.ui.data.b;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class PaymentOptions extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f5278a;
    private Transaction b;
    private WalletAPIs c;
    private b d;
    private TransactionConfiguration e;

    private void a() {
        if (Network.isConnected(this)) {
            this.d.a(true);
            Intent intent = new Intent();
            intent.setClass(getBaseContext(), PaymentActivity.class);
            intent.putExtra("extraData", PaymentInstrumentType.MK_WALLET);
            a(intent);
        } else if (this.d.b().size() < 2) {
            a(null, SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
        }
    }

    private void a(Intent intent) {
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, String str, String str2) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2.putExtra("statuscode", str);
            intent2.putExtra("statusmessage", str2);
        }
        setResult(1, intent2);
        finish();
    }

    public void a(boolean z) {
        int i;
        if (this.f5278a.size() != 1) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.new_po_container);
            linearLayout.removeAllViews();
            int applyDimension = (int) TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
            ArrayList arrayList = new ArrayList();
            if (this.f5278a.contains(PaymentInstrumentType.SAVED_CARD) && b.b(this).h() != null && b.b(this).h().length > 0) {
                Button button = new Button(this);
                button.setText("\t\tSaved Card");
                button.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_credit_debit), (Drawable) null, (Drawable) null, (Drawable) null);
                arrayList.add(button);
                button.setOnClickListener(new r(this));
            }
            if (this.f5278a.contains(PaymentInstrumentType.CREDIT_CARD)) {
                Button button2 = new Button(this);
                button2.setText("\t\tCredit Card");
                button2.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_credit_debit), (Drawable) null, (Drawable) null, (Drawable) null);
                arrayList.add(button2);
                button2.setOnClickListener(new s(this));
            }
            if (this.f5278a.contains(PaymentInstrumentType.DEBIT_CARD)) {
                Button button3 = new Button(this);
                button3.setText("\t\tDebit Card");
                button3.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_credit_debit), (Drawable) null, (Drawable) null, (Drawable) null);
                arrayList.add(button3);
                button3.setOnClickListener(new t(this));
            }
            if (this.f5278a.contains(PaymentInstrumentType.NETBANKING)) {
                Button button4 = new Button(this);
                button4.setText("\t\tNetbanking");
                button4.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_netbanking), (Drawable) null, (Drawable) null, (Drawable) null);
                arrayList.add(button4);
                button4.setOnClickListener(new u(this));
            }
            if (this.f5278a.contains(PaymentInstrumentType.MK_WALLET)) {
                Button button5 = new Button(this);
                button5.setText("\t\tMobikwik Wallet");
                button5.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.mk_btn_src_wallet), (Drawable) null, (Drawable) null, (Drawable) null);
                arrayList.add(button5);
                button5.setOnClickListener(new v(this));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                Button button6 = (Button) arrayList.get(i2);
                if (i2 == 0) {
                    i = R.drawable.mk_sel_btn_top;
                } else if (i2 == arrayList.size() - 1) {
                    layoutParams.setMargins(0, 2, 0, 0);
                    i = R.drawable.mk_sel_btn_bottom;
                } else {
                    layoutParams.setMargins(0, 2, 0, 0);
                    i = R.drawable.mk_sel_btn;
                }
                button6.setBackgroundResource(i);
                button6.setGravity(19);
                button6.setPadding(applyDimension, applyDimension, 0, applyDimension);
                button6.setTextColor(getResources().getColorStateList(R.color.mk_s_btn_txt));
                linearLayout.addView(button6, layoutParams);
            }
            arrayList.clear();
        } else if (this.f5278a.contains(PaymentInstrumentType.MK_WALLET) && z) {
            payByMkWallet(null);
        } else if (this.f5278a.contains(PaymentInstrumentType.CREDIT_CARD) && z) {
            payByCC(null);
        } else if (this.f5278a.contains(PaymentInstrumentType.DEBIT_CARD) && z) {
            payByDC(null);
        } else if (this.f5278a.contains(PaymentInstrumentType.NETBANKING) && z) {
            payByNetbanking(null);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.b.updateUser((User) intent.getSerializableExtra("user"));
                a();
            } else {
                a(null, SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorCode(), SDKErrorCodes.USER_CANCELLED_TRANSACTION.getErrorDescription());
            }
        }
        if (i == 2 && i2 == 1) {
            a(intent, null, null);
        }
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false).setIcon(17301543).setTitle("Quit Payment?").setMessage("Press YES if you want to cancel your transaction.").setPositiveButton("Yes", new x(this)).setNegativeButton("No", new w(this));
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.mk_activity_payment_options);
        this.d = b.b(this);
        this.e = b.b(this).f();
        this.c = WalletAPIs.getInstance("1".equals(this.e.getMode()), this);
        this.b = b.b(this).d();
        this.f5278a = b.b(this).b();
        if (bundle == null) {
            a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        b.b(this).a();
    }

    public void payByCC(View view) {
        b.b(this).a(false);
        Intent intent = new Intent();
        intent.setClass(getBaseContext(), PaymentActivity.class);
        intent.putExtra("extraData", PaymentInstrumentType.CREDIT_CARD);
        a(intent);
    }

    public void payByDC(View view) {
        b.b(this).a(false);
        Intent intent = new Intent();
        intent.setClass(getBaseContext(), PaymentActivity.class);
        intent.putExtra("extraData", PaymentInstrumentType.DEBIT_CARD);
        a(intent);
    }

    public void payByMkWallet(View view) {
        b.b(this).a(true);
        Intent intent = new Intent(this, GetUserDetailsActivity.class);
        intent.putExtra("user", this.b.getUser());
        startActivityForResult(intent, 1);
    }

    public void payByNetbanking(View view) {
        b.b(this).a(false);
        Intent intent = new Intent();
        intent.setClass(getBaseContext(), PaymentActivity.class);
        intent.putExtra("extraData", PaymentInstrumentType.NETBANKING);
        a(intent);
    }

    public void payBySC(View view) {
        b.b(this).a(false);
        Intent intent = new Intent();
        intent.setClass(getBaseContext(), PaymentActivity.class);
        intent.putExtra("extraData", PaymentInstrumentType.SAVED_CARD);
        a(intent);
    }
}
