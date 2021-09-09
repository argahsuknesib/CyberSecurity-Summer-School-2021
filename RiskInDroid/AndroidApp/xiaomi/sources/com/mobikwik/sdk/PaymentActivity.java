package com.mobikwik.sdk;

import _m_j.ei;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.mobikwik.sdk.lib.SDKErrorCodes;
import com.mobikwik.sdk.lib.Transaction;
import com.mobikwik.sdk.lib.TransactionConfiguration;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.mobikwik.sdk.lib.utils.CommonUtils;
import com.mobikwik.sdk.lib.utils.Network;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.lib.wallet.WalletAPIs;
import com.mobikwik.sdk.ui.data.a;
import com.mobikwik.sdk.ui.data.b;
import com.mobikwik.sdk.ui.frag.d;
import com.mobikwik.sdk.ui.frag.f;
import com.mobikwik.sdk.ui.frag.m;
import com.mobikwik.sdk.ui.frag.o;
import com.mobikwik.sdk.ui.frag.t;
import com.mobikwik.sdk.ui.frag.y;
import com.xiaomi.smarthome.R;

public class PaymentActivity extends FragmentActivity implements d.a, f.a, o.b, t.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f5277a;
    private Runnable b;
    private WalletAPIs c;
    /* access modifiers changed from: private */
    public b d;
    private TransactionConfiguration e;

    private void a(Intent intent) {
        PaymentInstrumentType paymentInstrumentType = (PaymentInstrumentType) intent.getSerializableExtra("extraData");
        intent.removeExtra("extraData");
        if (PaymentInstrumentType.SAVED_CARD.equals(paymentInstrumentType)) {
            b();
        } else if (PaymentInstrumentType.CREDIT_CARD.equals(paymentInstrumentType)) {
            c();
        } else if (PaymentInstrumentType.DEBIT_CARD.equals(paymentInstrumentType)) {
            d();
        } else if (PaymentInstrumentType.NETBANKING.equals(paymentInstrumentType)) {
            e();
        } else if (PaymentInstrumentType.MK_WALLET.equals(paymentInstrumentType)) {
            f();
        }
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, String str, String str2) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2 = new Intent(intent);
        }
        if (Utils.isNull(intent2.getStringExtra("statuscode"))) {
            if (Utils.isNull(str)) {
                intent2.putExtra("statuscode", "1");
            } else {
                intent2.putExtra("statuscode", str);
            }
        }
        if (Utils.isNull(intent2.getStringExtra("statusmessage"))) {
            if (Utils.isNull(str)) {
                intent2.putExtra("statusmessage", "Something went bad");
            } else {
                intent2.putExtra("statusmessage", str2);
            }
        }
        setResult(1, intent2);
        finish();
    }

    private void a(String str) {
        b b2 = b.b(this);
        String str2 = str;
        this.c.getUserBalance(b2.d().getUser().getEmail(), b2.d().getUser().getCell(), b2.d().getOrderId(), b2.d().getAmount(), b2.f().getMbkId(), b.b(this).i(), true, str2, true, !b2.f().isDebitWallet(), b2.f().getPgResponseUrl(), b2.f().getMerchantName(), new m(this, b2));
    }

    private void f() {
        if (Network.isConnected(this)) {
            this.f5277a = ProgressDialog.show(this, "", "Processing...", false);
            g();
        } else if (this.d.b().size() < 2) {
            a((Intent) null, SDKErrorCodes.INTERNET_NOT_WORKING.getErrorCode(), SDKErrorCodes.INTERNET_NOT_WORKING.getErrorDescription());
        }
    }

    private void g() {
        Transaction d2 = this.d.d();
        if (!Utils.isNull(d2.getChecksum())) {
            b.b(this).b(d2.getChecksum());
            h();
            return;
        }
        this.c.getTransactionHash(this.e.getChecksumUrl(), d2.getOrderId(), d2.getAmount(), this.e.getMbkId(), new j(this));
    }

    /* access modifiers changed from: private */
    public void h() {
        String a2 = a.a(this, this.d.d().getUser());
        TransactionConfiguration f = this.d.f();
        if (Utils.isNull(a2)) {
            this.c.resolveUser(this.d.d().getUser().getEmail(), this.d.d().getUser().getCell(), this.d.d().getOrderId(), this.d.d().getAmount(), this.e.getMbkId(), b.b(this).i(), true, f.getPgResponseUrl(), f.getMerchantName(), new k(this));
        } else {
            a(a2);
        }
    }

    public void a(int i, Intent intent) {
        if (i == -1) {
            a(Double.valueOf(intent.getDoubleExtra("balance", 0.0d)));
        } else {
            a(intent, (String) null, (String) null);
        }
    }

    public void a(PaymentInstrumentType paymentInstrumentType) {
        int i = q.f5295a[paymentInstrumentType.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            c();
        } else if (i == 3) {
            d();
        } else if (i == 4) {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        b b2 = b.b(this);
        this.c.generateOtp(b2.d().getUser().getEmail(), b2.d().getUser().getCell(), b2.d().getOrderId(), b2.d().getAmount(), b2.f().getMbkId(), b.b(this).i(), b2.f().getPgResponseUrl(), b2.f().getMerchantName(), new l(this, z));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Utils.print("PaymentActivity.onActivityResult() " + intent.getStringExtra("statuscode"));
        b b2 = b.b(this);
        if (i2 != 1 || !b2.j() || !SDKErrorCodes.SUCCESS.getErrorCode().equals(intent.getStringExtra("statuscode")) || !b2.f().isDebitWallet()) {
            a(intent, (String) null, (String) null);
        } else {
            this.b = new p(this, intent);
        }
    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false).setIcon(17301543).setTitle("Quit Payment?").setMessage("Press YES if you want to cancel your transaction.").setPositiveButton("Yes", new o(this)).setNegativeButton("No", new n(this));
        builder.create().show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.payment_page);
        this.d = b.b(this);
        this.e = b.b(this).f();
        this.c = WalletAPIs.getInstance("1".equals(this.e.getMode()), this);
        if (bundle == null) {
            a(getIntent());
        }
    }

    public void onResumeFragments() {
        super.onResumeFragments();
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        b.b(this).a();
    }

    private void b() {
        o oVar = new o();
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, oVar, null);
        O000000o2.O00000Oo();
    }

    private void c() {
        com.mobikwik.sdk.ui.frag.a aVar = new com.mobikwik.sdk.ui.frag.a();
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, aVar, null);
        O000000o2.O00000Oo();
    }

    private void d() {
        d dVar = new d();
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, dVar, null);
        O000000o2.O00000Oo();
    }

    private void e() {
        m mVar = new m();
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, mVar, null);
        O000000o2.O00000Oo();
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putString("MSG", str);
        if (z) {
            bundle.putString("NEWUSER", "true");
        }
        fVar.setArguments(bundle);
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, fVar, null);
        O000000o2.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public void a(Double d2) {
        b b2 = b.b(this);
        Double valueOf = Double.valueOf(Double.parseDouble(b2.d().getAmount()));
        if (!b2.f().isDebitWallet() || d2.doubleValue() < Double.parseDouble(b2.d().getAmount())) {
            t tVar = new t();
            Double performArithmeticCalculations = CommonUtils.performArithmeticCalculations(valueOf, d2, 2);
            if (!b2.f().isDebitWallet()) {
                performArithmeticCalculations = valueOf;
            }
            if (performArithmeticCalculations.doubleValue() < 1.0d) {
                performArithmeticCalculations = Double.valueOf(1.0d);
            }
            b2.a(String.valueOf(performArithmeticCalculations));
            ei O000000o2 = getSupportFragmentManager().O000000o();
            O000000o2.O00000Oo(R.id.payment_frame, tVar, null);
            O000000o2.O00000Oo();
            return;
        }
        y yVar = new y();
        Bundle bundle = new Bundle();
        bundle.putDouble("BALANCE", d2.doubleValue());
        yVar.setArguments(bundle);
        ei O000000o3 = getSupportFragmentManager().O000000o();
        O000000o3.O00000Oo(R.id.payment_frame, yVar, null);
        O000000o3.O00000Oo();
    }

    public void a(Bundle bundle) {
        com.mobikwik.sdk.ui.frag.a aVar = new com.mobikwik.sdk.ui.frag.a();
        aVar.setArguments(bundle);
        ei O000000o2 = getSupportFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.payment_frame, aVar, null);
        O000000o2.O00000Oo();
    }

    public void a() {
        if (b.b(this).j()) {
            t tVar = new t();
            tVar.a(false);
            ei O000000o2 = getSupportFragmentManager().O000000o();
            O000000o2.O00000Oo(R.id.payment_frame, tVar, null);
            O000000o2.O00000Oo();
            return;
        }
        finish();
    }
}
