package com.mibi.sdk.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.DiscountGiftCard;
import com.mibi.sdk.mvp.IPresenter;
import com.mibi.sdk.pay.ui.BalanceInfoActivity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class BalanceInfoActivity extends BaseMvpActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f5158O000000o;
    private TextView O00000Oo;
    private CheckBox O00000o;
    private TextView O00000o0;
    private View O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private CheckBox O0000OOo;
    private CheckBox O0000Oo;
    private TextView O0000Oo0;
    private Button O0000OoO;
    private ViewStub O0000Ooo;
    private long O0000o;
    private long O0000o0;
    /* access modifiers changed from: private */
    public TableRow[] O0000o00;
    private long O0000o0O;
    private String O0000o0o;
    private ArrayList<DiscountGiftCard> O0000oO;
    private long O0000oO0;
    /* access modifiers changed from: private */
    public int O0000oOO;
    private boolean O0000oOo;
    private boolean O0000oo;
    private boolean O0000oo0;
    private boolean O0000ooO;

    public IPresenter onCreatePresenter() {
        return null;
    }

    public void handleCreate(Bundle bundle) {
        super.handleCreate(bundle);
        setContentView((int) R.layout.mibi_activity_balance_info);
        findViewById(R.id.iv_back_balance_info).setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.$$Lambda$BalanceInfoActivity$U46B4poWKfNAzlbxubaswBubnw */

            public final void onClick(View view) {
                BalanceInfoActivity.this.O00000Oo(view);
            }
        });
        this.f5158O000000o = findViewById(R.id.tb_mibi_giftcard);
        this.O00000Oo = (TextView) findViewById(R.id.tv_giftcard_label_balance_info);
        this.O00000o0 = (TextView) findViewById(R.id.tv_giftcard_value_balance_info);
        this.O00000o = (CheckBox) findViewById(R.id.cb_giftcard_balance_info);
        this.O00000oO = findViewById(R.id.partner_giftcard);
        this.O00000oo = (TextView) findViewById(R.id.tv_market_giftcard_label_balance_info);
        this.O0000O0o = (TextView) findViewById(R.id.tv_market_giftcard_value_balance_info);
        this.O0000OOo = (CheckBox) findViewById(R.id.cb_market_giftcard_balance_info);
        this.O0000Oo0 = (TextView) findViewById(R.id.tv_balance_value_discount_item);
        this.O0000Oo = (CheckBox) findViewById(R.id.cb_balance_balance_info);
        this.O0000OoO = (Button) findViewById(R.id.btn_confirm_balance_info);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.$$Lambda$BalanceInfoActivity$PWsUQjxBeM7jEEoAN8EvtK0_Vd4 */

            public final void onClick(View view) {
                BalanceInfoActivity.this.O000000o(view);
            }
        });
        this.O0000Ooo = (ViewStub) findViewById(R.id.vs_gift_card_balance_info);
        Intent intent = getIntent();
        this.O0000oo0 = intent.getBooleanExtra("useGiftcard", true);
        this.O0000oo = intent.getBooleanExtra("usePartnerGiftcard", true);
        this.O0000ooO = intent.getBooleanExtra("useBalance", true);
        this.O0000o0O = intent.getLongExtra("giftcardValue", 0);
        this.O0000o0o = intent.getStringExtra("partnerGiftcardName");
        this.O0000o = intent.getLongExtra("partnerGiftcardValue", 0);
        this.O0000oO0 = intent.getLongExtra("balance", 0);
        this.O0000o0 = intent.getLongExtra("price", 0);
        this.O0000oO = (ArrayList) intent.getSerializableExtra("discountGiftcards");
        this.O0000oOO = intent.getIntExtra("discountGiftCardIndex", -1);
        this.O0000oOo = intent.getBooleanExtra("useConsumedDiscountGiftCard", false);
        long j = this.O0000o0O + this.O0000o + this.O0000oO0;
        this.O00000o.setChecked(this.O0000oo0);
        this.O0000OOo.setChecked(this.O0000oo);
        this.O0000Oo.setChecked(this.O0000ooO);
        if (this.O0000o0 <= j) {
            this.O00000o.setEnabled(false);
            this.O0000OOo.setEnabled(false);
            this.O0000Oo.setEnabled(false);
        }
        if (this.O0000o == 0) {
            this.O00000oO.setVisibility(8);
        } else {
            this.O00000oO.setVisibility(0);
            this.O00000oo.setText((int) R.string.mibi_giftcard_payment);
            this.O0000O0o.setText(Utils.getSimplePrice(this.O0000o));
        }
        if (this.O0000o0O == 0) {
            this.f5158O000000o.setVisibility(8);
        } else {
            this.f5158O000000o.setVisibility(0);
            this.O00000Oo.setText((int) R.string.mibi_giftcard_payment);
            this.O00000o0.setText(Utils.getSimplePrice(this.O0000o0O));
        }
        if (this.O0000o > 0) {
            this.O00000oo.setText(getString(R.string.mibi_partner_giftcard_payment_with_append, new Object[]{this.O0000o0o}));
        } else if (this.O0000o0O > 0) {
            this.O00000Oo.setText((int) R.string.mibi_giftcard_payment_with_append);
        }
        if (this.O0000oO0 == 0) {
            this.O0000Oo.setEnabled(false);
        }
        this.O0000Oo0.setText(Utils.getSimplePrice(this.O0000oO0));
        ArrayList<DiscountGiftCard> arrayList = this.O0000oO;
        if (arrayList != null && arrayList.size() > 0) {
            O000000o o000000o = new O000000o((TableLayout) this.O0000Ooo.inflate().findViewById(R.id.table_layout));
            if (BalanceInfoActivity.this.O0000oO != null && BalanceInfoActivity.this.O0000oO.size() > 0) {
                BalanceInfoActivity.this.O0000o00 = new TableRow[BalanceInfoActivity.this.O0000oO.size()];
                int i = 0;
                while (i < BalanceInfoActivity.this.O0000oO.size()) {
                    DiscountGiftCard discountGiftCard = BalanceInfoActivity.this.O0000oO.get(i);
                    TableRow O000000o2 = o000000o.O000000o();
                    ((TextView) O000000o2.findViewById(R.id.tv_giftcard_name_discount_item)).setText(BalanceInfoActivity.this.getString(R.string.mibi_giftcard_discount_detail, new Object[]{Utils.getSimplePrice(discountGiftCard.mOrderFeeRequiredValue)}));
                    ((TextView) O000000o2.findViewById(R.id.tv_balance_value_discount_item)).setText(Utils.getSimplePrice(discountGiftCard.mGiftCardValue));
                    CheckBox checkBox = (CheckBox) O000000o2.findViewById(R.id.cb_giftcard_discount_item);
                    checkBox.setChecked(BalanceInfoActivity.this.O0000oOO == i);
                    checkBox.setEnabled(!BalanceInfoActivity.this.O0000oOo);
                    o000000o.f5159O000000o.addView(O000000o2);
                    BalanceInfoActivity.this.O0000o00[i] = O000000o2;
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        MibiLog.d("BalanceInfoAct", "back button clicked");
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        MibiLog.d("BalanceInfoAct", "confirm button clicked");
        O000000o();
        finish();
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        TableLayout f5159O000000o;

        public O000000o(TableLayout tableLayout) {
            this.f5159O000000o = tableLayout;
        }

        /* access modifiers changed from: package-private */
        public final TableRow O000000o() {
            TableRow tableRow = (TableRow) ((LayoutInflater) BalanceInfoActivity.this.getSystemService("layout_inflater")).inflate((int) R.layout.mibi_payment_balance_info_item, (ViewGroup) null);
            ((CheckBox) tableRow.findViewById(R.id.cb_giftcard_discount_item)).setOnClickListener(new View.OnClickListener() {
                /* class com.mibi.sdk.pay.ui.$$Lambda$BalanceInfoActivity$O000000o$Hdycv2OXP6rqnrH9A46i9MkmQ8 */

                public final void onClick(View view) {
                    BalanceInfoActivity.O000000o.this.O000000o(view);
                }
            });
            return tableRow;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            for (int i = 0; i < BalanceInfoActivity.this.O0000o00.length; i++) {
                CheckBox checkBox = (CheckBox) BalanceInfoActivity.this.O0000o00[i].findViewById(R.id.cb_giftcard_discount_item);
                if (view == checkBox) {
                    int unused = BalanceInfoActivity.this.O0000oOO = checkBox.isChecked() ? i : -1;
                } else {
                    checkBox.setChecked(false);
                }
            }
        }
    }

    private void O000000o() {
        Intent intent = new Intent();
        intent.putExtra("useGiftcard", this.O00000o.isChecked());
        intent.putExtra("usePartnerGiftcard", this.O0000OOo.isChecked());
        intent.putExtra("useBalance", this.O0000Oo.isChecked());
        intent.putExtra("discountGiftCardIndex", this.O0000oOO);
        setResult(-1, intent);
    }

    public boolean handleBackPressed() {
        O000000o();
        return true;
    }
}
