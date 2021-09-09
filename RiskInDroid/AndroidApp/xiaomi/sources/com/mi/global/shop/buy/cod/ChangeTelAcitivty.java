package com.mi.global.shop.buy.cod;

import _m_j.byl;
import _m_j.ccr;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.PhoneNumberEdit;
import com.xiaomi.smarthome.R;

public class ChangeTelAcitivty extends BaseActivity implements TextWatcher, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private PhoneNumberEdit f4862O000000o = null;
    private CommonButton O00000Oo = null;
    private View O00000o;
    private CommonButton O00000o0 = null;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onCreate(Bundle bundle) {
        ccr.O00000Oo("changeTelActivity", "onCreate");
        super.onCreate(bundle);
        this.mCartView.setVisibility(4);
        this.O00000o = findViewById(R.id.title_bar_home);
        this.O00000o.setVisibility(0);
        this.O00000o.setOnClickListener(this);
        O000000o((int) R.layout.shop_buy_confirm_payment_cod_changetel);
        setTitle((int) R.string.buy_confirm_COD_changetel_title);
        this.f4862O000000o = (PhoneNumberEdit) findViewById(R.id.buy_confirm_payment_cod_change_tel_tel_text);
        PhoneNumberEdit phoneNumberEdit = this.f4862O000000o;
        phoneNumberEdit.setPrefix(byl.O00000oO().getString(R.string.user_address_phoneareacode) + "  ");
        this.O00000Oo = (CommonButton) findViewById(R.id.buy_confirm_payment_cod_change_tel_confirm);
        this.O00000o0 = (CommonButton) findViewById(R.id.buy_confirm_payment_cod_change_tel_cancel);
        this.O00000Oo.setOnClickListener(this);
        this.O00000Oo.setEnabled(false);
        this.O00000o0.setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("tel");
        if (stringExtra != null) {
            this.f4862O000000o.setText(stringExtra);
        }
        this.f4862O000000o.addTextChangedListener(this);
    }

    public void onClick(View view) {
        if (view == this.O00000Oo) {
            String obj = this.f4862O000000o.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("tel", obj);
            setResult(-1, intent);
            finish();
        } else if (view == this.O00000o0) {
            setResult(0);
            finish();
        } else if (view == this.O00000o) {
            setResult(0);
            finish();
        }
    }

    public void afterTextChanged(Editable editable) {
        if (editable.toString().getBytes().length == 10) {
            this.O00000Oo.setEnabled(true);
        } else {
            this.O00000Oo.setEnabled(false);
        }
    }
}
