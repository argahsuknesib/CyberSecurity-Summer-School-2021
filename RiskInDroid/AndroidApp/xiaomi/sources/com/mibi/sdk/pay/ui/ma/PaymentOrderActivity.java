package com.mibi.sdk.pay.ui.ma;

import _m_j.cgq;
import _m_j.cgr;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.mibi.sdk.basic.auth.PaymentCheckPasswordActivity;
import com.mibi.sdk.basic.sms.PaymentVerifySMSCodeActivity;
import com.mibi.sdk.common.Client;
import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.DiscountGiftCard;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeManager;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.pay.task.RxAccountGetRechargeTypeTask;
import com.mibi.sdk.pay.task.RxStartAccountPaymentTask;
import com.mibi.sdk.pay.ui.BalanceInfoActivity;
import com.mibi.sdk.pay.ui.PayTypeListActivity;
import com.mibi.sdk.pay.ui.imageloader.ImageHelper;
import com.mibi.sdk.widget.AlertDialog;
import com.mibi.sdk.widget.ProgressButton;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class PaymentOrderActivity extends BaseMvpActivity implements cgq.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f5163O000000o;
    private TextView O00000Oo;
    private View O00000o;
    private View O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private View O0000OOo;
    private TextView O0000Oo;
    private ImageView O0000Oo0;
    private TextView O0000OoO;
    private TextView O0000Ooo;
    private long O0000o;
    private ProgressButton O0000o0;
    private Button O0000o00;
    private String O0000o0O;
    private long O0000o0o;
    private boolean O0000oO = true;
    private boolean O0000oO0 = true;
    private boolean O0000oOO = true;
    private boolean O0000oOo;
    private long O0000oo;
    private long O0000oo0;
    private long O0000ooO;
    private String O0000ooo;
    private RxAccountGetRechargeTypeTask.Result O000O00o;
    private RechargeType O000O0OO;
    private int O000O0Oo = -1;
    private ArrayList<DiscountGiftCard> O00oOooO;
    private RxStartAccountPaymentTask.Result O00oOooo;

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        setContentView((int) R.layout.mibi_activity_payment_order);
        Intent intent = getIntent();
        try {
            this.O00oOooo = (RxStartAccountPaymentTask.Result) intent.getSerializableExtra("pay_type_result");
            if (this.O00oOooo == null) {
                MibiLog.d("PaymentOrderActivity", "result is null");
                setResult(9827, EntryResultUtils.makeResult(9826, "result is null"));
                finish();
            }
            this.O000O00o = (RxAccountGetRechargeTypeTask.Result) intent.getSerializableExtra("recharge_types_result");
            if (this.O000O00o == null) {
                MibiLog.d("PaymentOrderActivity", "recharge types is null");
                setResult(9828, EntryResultUtils.makeResult(9826, "recharge types is null"));
                finish();
            }
            this.O0000o0O = this.O00oOooo.mOrderTitle;
            this.O0000o0o = this.O00oOooo.mOrderPrice;
            this.O0000o = this.O00oOooo.mBalance;
            this.O0000oo = this.O00oOooo.mGiftcardValue;
            this.O0000ooO = this.O00oOooo.mPartnerGiftcardValue;
            this.O0000oO0 = this.O00oOooo.mUseGiftcard;
            this.O0000oO = this.O00oOooo.mUsePartnerGiftcard;
            this.O0000ooo = this.O00oOooo.mPartnerGiftcardName;
            this.O0000oo0 = this.O00oOooo.getTotalBalance();
            this.O00oOooO = this.O00oOooo.mDiscountGiftCards;
            if (this.O00oOooO != null && this.O00oOooO.size() > 0) {
                int i = 0;
                if (this.O00oOooo.mOrderConsumedDiscountGiftcardId == 0) {
                    this.O000O0Oo = 0;
                    this.O0000oOo = false;
                } else {
                    while (true) {
                        if (i >= this.O00oOooO.size()) {
                            break;
                        } else if (this.O00oOooO.get(i).mGiftCardId == ((long) this.O00oOooo.mOrderConsumedDiscountGiftcardId)) {
                            this.O000O0Oo = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    this.O0000oOo = true;
                }
            }
        } catch (Exception e) {
            MibiLog.d("PaymentOrderActivity", "result or rechargeTypes is null", e);
        }
        this.f5163O000000o = (TextView) findViewById(R.id.text_order_name);
        this.O00000Oo = (TextView) findViewById(R.id.text_order_value);
        this.O00000o0 = findViewById(R.id.balance);
        this.O00000oO = (TextView) findViewById(R.id.text_balance_name);
        this.O00000oo = (TextView) findViewById(R.id.text_balance_value);
        this.O00000o = findViewById(R.id.text_balance_value_with_unit);
        this.O0000O0o = (TextView) findViewById(R.id.text_balance_no_use);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.ma.$$Lambda$PaymentOrderActivity$2HAj7IzGvQ62XuRRSVtHVnk7OGk */

            public final void onClick(View view) {
                PaymentOrderActivity.this.O00000o(view);
            }
        });
        this.O0000OOo = findViewById(R.id.pay_type);
        this.O0000Oo0 = (ImageView) findViewById(R.id.icon_pay_type);
        this.O0000Oo = (TextView) findViewById(R.id.text_pay_type_name);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.ma.$$Lambda$PaymentOrderActivity$rQrWIOFk_rP8lv4nm6dxDGUrTyY */

            public final void onClick(View view) {
                PaymentOrderActivity.this.O00000o0(view);
            }
        });
        this.O0000OoO = (TextView) findViewById(R.id.discount);
        this.O0000Ooo = (TextView) findViewById(R.id.errorDesc);
        this.O0000o00 = (Button) findViewById(R.id.button_call);
        this.O0000o00.setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.ma.$$Lambda$PaymentOrderActivity$YIcIvpC4pbtPJQv31sakEBtcllM */

            public final void onClick(View view) {
                PaymentOrderActivity.this.O00000Oo(view);
            }
        });
        this.O0000o0 = (ProgressButton) findViewById(R.id.button_pay);
        this.O0000o0.setClickListener(new ProgressButton.IOnClickListener() {
            /* class com.mibi.sdk.pay.ui.ma.$$Lambda$PaymentOrderActivity$YWfkWxuCniBaRdQavpH7pJz5uyA */

            public final void onClick(View view) {
                PaymentOrderActivity.this.O000000o(view);
            }
        });
        this.f5163O000000o.setText(this.O0000o0O);
        this.O00000Oo.setText(Utils.getSimplePrice(this.O0000o0o));
        O000000o();
        O00000Oo();
        O00000o0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        MibiLog.d("PaymentOrderActivity", "balance clicked");
        MibiLog.d("PaymentOrderActivity", "go to balance info page");
        Intent intent = new Intent(this, BalanceInfoActivity.class);
        intent.putExtra("useGiftcard", this.O0000oO0);
        intent.putExtra("giftcardValue", this.O0000oo);
        intent.putExtra("usePartnerGiftcard", this.O0000oO);
        intent.putExtra("partnerGiftcardName", this.O0000ooo);
        intent.putExtra("partnerGiftcardValue", this.O0000ooO);
        intent.putExtra("useBalance", this.O0000oOO);
        intent.putExtra("balance", this.O0000o);
        intent.putExtra("price", this.O0000o0o);
        intent.putExtra("discountGiftcards", this.O00oOooO);
        intent.putExtra("discountGiftCardIndex", this.O000O0Oo);
        intent.putExtra("useConsumedDiscountGiftCard", this.O0000oOo);
        startActivityForResult(intent, 49);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        MibiLog.d("PaymentOrderActivity", "pay type clicked");
        Intent intent = new Intent(this, PayTypeListActivity.class);
        intent.putExtra("recharge_types", this.O000O00o.mRechargeTypes);
        intent.putExtra("recharge_pay_type_chosen", this.O000O0OO.mType);
        startActivityForResult(intent, 48);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        MibiLog.d("PaymentOrderActivity", "call button clicked");
        Utils.dialService(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        MibiLog.d("PaymentOrderActivity", "pay button clicked");
        this.O0000o0.startProgress();
        ((cgq.O000000o) getPresenter()).O000000o();
    }

    private void O000000o() {
        boolean z;
        this.O00000o0.setVisibility(0);
        this.O00000oO.setText((int) R.string.mibi_order_balance_label);
        if ((!this.O0000oO0 || this.O0000oo <= 0) && ((!this.O0000oO || this.O0000ooO <= 0) && this.O000O0Oo < 0)) {
            z = false;
        } else {
            z = true;
            this.O00000oO.setText((int) R.string.mibi_order_balance_lable_append);
        }
        long O00000oO2 = O00000oO();
        if (O00000oO2 != 0) {
            this.O00000o.setVisibility(0);
            this.O0000O0o.setVisibility(8);
            this.O00000oo.setText(Utils.getSimplePrice(O00000oO2));
        } else if (!z) {
            this.O00000o0.setVisibility(8);
        } else {
            this.O00000o.setVisibility(8);
            this.O0000O0o.setVisibility(0);
        }
    }

    private void O00000Oo() {
        if (this.O0000o0o <= this.O0000oo0) {
            this.O0000OOo.setVisibility(8);
            return;
        }
        this.O0000OOo.setVisibility(0);
        if (this.O000O0OO == null) {
            this.O000O0OO = this.O000O00o.mLastChargeType;
            if (this.O000O0OO == null) {
                this.O000O0OO = this.O000O00o.mRechargeTypes.get(0);
            }
        }
        this.O0000Oo.setText(this.O000O0OO.mTitle);
        ImageHelper.get(this).load(ImageHelper.getAbsoluteUrl(this.O000O0OO.mIcon)).placeholder((int) R.drawable.mibi_ic_recharge_item_default).into(this.O0000Oo0);
        if (TextUtils.isEmpty(this.O000O00o.mDirectPayDiscount)) {
            this.O0000OoO.setVisibility(8);
            return;
        }
        this.O0000OoO.setVisibility(0);
        this.O0000OoO.setText(this.O000O00o.mDirectPayDiscount);
    }

    private void O00000o0() {
        long O00000o2 = O00000o();
        if (O00000o2 > 0) {
            this.O0000o0.setText(getString(R.string.mibi_label_pay_remain, new Object[]{Utils.getSimplePrice(O00000o2)}));
            return;
        }
        this.O0000o0.setText(getString(R.string.mibi_button_pay));
    }

    private long O00000o() {
        return this.O0000o0o - O00000oO();
    }

    private long O00000oO() {
        long j = 0;
        if (this.O0000oO0) {
            j = 0 + this.O0000oo;
        }
        if (this.O0000oO) {
            j += this.O0000ooO;
        }
        if (this.O0000oOO) {
            j += this.O0000o;
        }
        int i = this.O000O0Oo;
        return i >= 0 ? j + this.O00oOooO.get(i).mGiftCardValue : j;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.mibi_fade_in, R.anim.mibi_fade_out);
    }

    public boolean handleBackPressed() {
        setResult(9826, EntryResultUtils.makeResult(9826, "user pressed back button in order info page"));
        return true;
    }

    public IPresenter onCreatePresenter() {
        return new cgr();
    }

    public void a(String str) {
        MibiLog.d("PaymentOrderActivity", "updateChosenPayType : ".concat(String.valueOf(str)));
        Iterator<RechargeType> it = this.O000O00o.mRechargeTypes.iterator();
        while (it.hasNext()) {
            RechargeType next = it.next();
            if (TextUtils.equals(str, next.mType)) {
                this.O000O0OO = next;
            }
        }
        O00000Oo();
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        MibiLog.d("PaymentOrderActivity", "updateChoices");
        this.O0000oOO = z;
        this.O0000oO0 = z2;
        this.O0000oO = z3;
        this.O000O0Oo = i;
        O000000o();
        O00000o0();
    }

    public void a() {
        MibiLog.d("PaymentOrderActivity", "onAccountFrozen");
        this.O0000OoO.setVisibility(8);
        this.O0000Ooo.setVisibility(0);
        this.O0000Ooo.setText(getString(R.string.mibi_error_frozen_summary));
        this.O0000o00.setVisibility(0);
        this.O0000o0.stopProgress();
        this.O0000o0.setVisibility(8);
    }

    public void b() {
        MibiLog.d("PaymentOrderActivity", "onProcessExpired");
        this.O0000o0.stopProgress();
    }

    public void c() {
        MibiLog.d("PaymentOrderActivity", "onPasswordCheck");
        Intent intent = new Intent(this, PaymentCheckPasswordActivity.class);
        intent.putExtra("processId", ((cgq.O000000o) getPresenter()).O00000Oo());
        startActivityForResult(intent, 50);
    }

    public void a(Bundle bundle) {
        MibiLog.d("PaymentOrderActivity", "onSmsCheck");
        Intent intent = new Intent(this, PaymentVerifySMSCodeActivity.class);
        intent.putExtra("processId", ((cgq.O000000o) getPresenter()).O00000Oo());
        intent.putExtras(bundle);
        startActivityForResult(intent, 51);
    }

    public void b(Bundle bundle) {
        String str;
        MibiLog.d("PaymentOrderActivity", "onBindPhoneCheck");
        if (bundle == null) {
            str = null;
        } else {
            str = bundle.getString("bindPhoneUrl");
        }
        String string = getResources().getString(R.string.mibi_title_bind_phone);
        AlertDialog create = new AlertDialog.Builder(this).setTitle(string).setMessage(getResources().getString(R.string.mibi_summary_bind_phone)).setClickable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.ma.$$Lambda$PaymentOrderActivity$4FE3k3aTi4kkJtkwYFnQAc9gh2I */

            public final void onClick(DialogInterface dialogInterface, int i) {
                PaymentOrderActivity.this.O000000o(dialogInterface, i);
            }
        }).setPositiveButton((int) R.string.mibi_button_bind_phone, new DialogInterface.OnClickListener(str) {
            /* class com.mibi.sdk.pay.ui.ma.$$Lambda$PaymentOrderActivity$d7PYW9Jl9IqSqQ_qFw0vRJtnBc8 */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PaymentOrderActivity.this.O000000o(this.f$1, dialogInterface, i);
            }
        }).create();
        create.setCancelable(false);
        create.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        O00000oo();
        dialogInterface.dismiss();
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(String str, DialogInterface dialogInterface, int i) {
        O00000oo();
        dialogInterface.dismiss();
        String accountBaseUrl = CommonConstants.getAccountBaseUrl("/upgradeUser");
        if (TextUtils.isEmpty(str)) {
            str = accountBaseUrl;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(67108864);
        intent.addFlags(8388608);
        startActivity(intent);
        finish();
    }

    private void O00000oo() {
        setResult(9807, EntryResultUtils.makeResult(9807, "user need bind phone"));
    }

    public void d() {
        MibiLog.d("PaymentOrderActivity", "onCheckAuthSuccess");
        ((cgq.O000000o) getPresenter()).O000000o(this.O0000oO0, this.O0000oO, this.O000O0Oo, this.O0000oOO);
    }

    public void a(int i, String str, Throwable th) {
        MibiLog.d("PaymentOrderActivity", "handleError errorCode : " + i + " ; errorDesc : " + str, th);
        this.O0000o0.stopProgress();
    }

    public void a(Bundle bundle, boolean z) {
        MibiLog.d("PaymentOrderActivity", "handleSuccess");
        Intent makeResult = EntryResultUtils.makeResult(-1, "success", bundle);
        makeResult.putExtra("isDirectPay", z);
        setResult(-1, makeResult);
        finish();
    }

    public void e() {
        MibiLog.d("PaymentOrderActivity", "do channel pay");
        Recharge recharge = RechargeManager.get().getRecharge(this.O000O0OO.mType);
        if (recharge != null) {
            Intent entryIntent = recharge.getEntryIntent(true);
            entryIntent.putExtra("processId", ((cgq.O000000o) getPresenter()).O00000Oo());
            entryIntent.setPackage(Client.getAppInfo().getPackage());
            startActivityForResult(entryIntent, 52);
            MibiLog.d("PaymentOrderActivity", "pay channel : " + this.O000O0OO.mType);
            return;
        }
        MibiLog.d("PaymentOrderActivity", "do pay failed , recharge is null, type : " + this.O000O0OO.mType);
        setResult(9835, EntryResultUtils.makeResult(9835, "can't get recharge from local map, maybe app has been killed in the bg", null));
        finish();
    }
}
