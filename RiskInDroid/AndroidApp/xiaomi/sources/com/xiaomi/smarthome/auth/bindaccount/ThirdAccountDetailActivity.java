package com.xiaomi.smarthome.auth.bindaccount;

import _m_j.fal;
import _m_j.gqg;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hyg;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class ThirdAccountDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f4293O000000o;
    private SimpleDraweeView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    public ThirdAccount mThirdAccount;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.mThirdAccount = fal.getInstance().O000000o(intent.getStringExtra("account_id"));
        if (this.mThirdAccount == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_third_account_detail_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDetailActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ThirdAccountDetailActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.third_account_platform_detail);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        this.f4293O000000o = findViewById(R.id.common_white_empty_view);
        findViewById(R.id.bind_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountDetailActivity.AnonymousClass1 */

            public final void onClick(View view) {
                Intent intent = new Intent(ThirdAccountDetailActivity.this, ThirdAccountAuthWebActivity.class);
                intent.putExtra("account_id", ThirdAccountDetailActivity.this.mThirdAccount.O00000Oo);
                ThirdAccountDetailActivity.this.startActivityForResult(intent, 1);
                hxk hxk = hxi.O00000o;
                String str = ThirdAccountDetailActivity.this.mThirdAccount.f4322O000000o;
                hyg hyg = hxk.f952O000000o;
                Object[] objArr = new Object[2];
                objArr[0] = "name";
                if (str == null) {
                    str = "null";
                }
                objArr[1] = str;
                hyg.O000000o("ctoc_detail_binding", objArr);
            }
        });
        this.O00000Oo = (SimpleDraweeView) findViewById(R.id.partner_icon);
        this.O00000o0 = (TextView) findViewById(R.id.partner_name);
        this.O00000o0.setText(this.mThirdAccount.f4322O000000o);
        this.O00000o = (TextView) findViewById(R.id.partner_desc);
        this.O00000o.setText(this.mThirdAccount.O00000o);
        fal.O000000o(this.O00000Oo, this.mThirdAccount.O00000o0);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 != -1 && i2 == 0) {
            gqg.O00000Oo((int) R.string.third_account_auth_canceled);
        }
    }
}
