package com.mibi.sdk.pay.ui;

import _m_j.cgp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.BaseMvpActivity;
import com.mibi.sdk.component.EntryResultUtils;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.mvp.IPresenter;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class PayTypeListActivity extends BaseMvpActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f5161O000000o;
    /* access modifiers changed from: private */
    public cgp O00000Oo;
    private String O00000o;
    private ArrayList<RechargeType> O00000o0 = new ArrayList<>();
    private int O00000oO;
    private AdapterView.OnItemClickListener O00000oo = new AdapterView.OnItemClickListener() {
        /* class com.mibi.sdk.pay.ui.PayTypeListActivity.AnonymousClass1 */

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (PayTypeListActivity.this.O00000Oo != null) {
                RechargeType payType = ((PayListItem) view).getPayType();
                Intent intent = new Intent();
                intent.putExtra("recharge_pay_type_chosen", payType.mType);
                PayTypeListActivity.this.setResult(-1, intent);
                PayTypeListActivity.this.setVisible(false);
                PayTypeListActivity.this.finish();
            }
        }
    };

    public IPresenter onCreatePresenter() {
        return null;
    }

    public void handleCreate(Bundle bundle) {
        int i;
        super.handleCreate(bundle);
        setContentView((int) R.layout.mibi_activity_pay_type_list);
        findViewById(R.id.iv_back_pay_type_list).setOnClickListener(new View.OnClickListener() {
            /* class com.mibi.sdk.pay.ui.$$Lambda$PayTypeListActivity$cl3AaExIwh2JtmL0vyzdfecsSAQ */

            public final void onClick(View view) {
                PayTypeListActivity.this.O000000o(view);
            }
        });
        this.f5161O000000o = (ListView) findViewById(R.id.lv_pay_type_list);
        Intent intent = getIntent();
        this.O00000o0 = (ArrayList) intent.getSerializableExtra("recharge_types");
        this.O00000o = intent.getStringExtra("recharge_pay_type_chosen");
        if (this.O00000Oo == null) {
            this.O00000Oo = new cgp(this, this.O00000o0);
        }
        this.f5161O000000o.setAdapter((ListAdapter) this.O00000Oo);
        this.f5161O000000o.setOnItemClickListener(this.O00000oo);
        cgp cgp = this.O00000Oo;
        ArrayList<RechargeType> arrayList = this.O00000o0;
        if (arrayList != null) {
            cgp.f13784O000000o = arrayList;
            cgp.notifyDataSetChanged();
        } else {
            cgp.f13784O000000o = null;
            cgp.notifyDataSetInvalidated();
        }
        if (!TextUtils.isEmpty(this.O00000o)) {
            i = 0;
            while (true) {
                if (i >= this.O00000o0.size()) {
                    break;
                } else if (TextUtils.equals(this.O00000o, this.O00000o0.get(i).mType)) {
                    break;
                } else {
                    i++;
                }
            }
            this.O00000oO = i;
            this.f5161O000000o.post(new Runnable() {
                /* class com.mibi.sdk.pay.ui.$$Lambda$PayTypeListActivity$v7A1ugLYACeqK8ya4qVS9LSEqk */

                public final void run() {
                    PayTypeListActivity.this.O000000o();
                }
            });
        }
        i = 0;
        this.O00000oO = i;
        this.f5161O000000o.post(new Runnable() {
            /* class com.mibi.sdk.pay.ui.$$Lambda$PayTypeListActivity$v7A1ugLYACeqK8ya4qVS9LSEqk */

            public final void run() {
                PayTypeListActivity.this.O000000o();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        MibiLog.d("PayTypeListAct", "back button clicked");
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        this.f5161O000000o.setItemChecked(this.O00000oO, true);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.mibi_fade_in, R.anim.mibi_fade_out_immediately);
    }

    public boolean handleBackPressed() {
        setResult(9830, EntryResultUtils.makeResult(9830, "user cancel select pay type"));
        return true;
    }
}
