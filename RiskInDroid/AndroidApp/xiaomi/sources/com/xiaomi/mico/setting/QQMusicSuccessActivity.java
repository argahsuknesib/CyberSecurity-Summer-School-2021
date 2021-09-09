package com.xiaomi.mico.setting;

import _m_j.ftn;
import _m_j.hzc;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.setting.adapter.QqMusicVipPriceAdapter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.List;

public class QQMusicSuccessActivity extends MicoBaseActivity implements QqMusicVipPriceAdapter.SupportContractListener {
    View bgContainer;
    CheckedTextView ctvRenewal;
    public QqMusicVipPriceAdapter qqMusicVipPriceAdapter;
    RecyclerView rlPrice;
    TextView tvTitle;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_qq_music_auth_success);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.rlPrice = (RecyclerView) findViewById(R.id.rlPrice);
        this.ctvRenewal = (CheckedTextView) findViewById(R.id.ctvRenewal);
        this.bgContainer = findViewById(R.id.bgContainer);
        Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("card_setting"))).into((ImageView) findViewById(R.id.ivBg));
        findViewById(R.id.tvSkip).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$QQMusicSuccessActivity$bVvQLs_8MTql0bWENk3PUGtFlA */

            public final void onClick(View view) {
                QQMusicSuccessActivity.this.lambda$onCreate$0$QQMusicSuccessActivity(view);
            }
        });
        findViewById(R.id.tvOpenNow).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$QQMusicSuccessActivity$M8CMjzZcwLxtT8fcs94cXxj4gPg */

            public final void onClick(View view) {
                QQMusicSuccessActivity.this.lambda$onCreate$1$QQMusicSuccessActivity(view);
            }
        });
        if (!DisplayUtils.isAllScreenDevice(getContext())) {
            ((LinearLayout.LayoutParams) this.tvTitle.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.size_40dp);
        }
        this.bgContainer.post(new Runnable() {
            /* class com.xiaomi.mico.setting.$$Lambda$QQMusicSuccessActivity$KjdWfzZtDC6SnZ4uwAgAdEBQu3s */

            public final void run() {
                QQMusicSuccessActivity.this.lambda$onCreate$2$QQMusicSuccessActivity();
            }
        });
        this.qqMusicVipPriceAdapter = new QqMusicVipPriceAdapter(this);
        this.rlPrice.setAdapter(this.qqMusicVipPriceAdapter);
        getQQMusicVIPPriceList();
    }

    public /* synthetic */ void lambda$onCreate$2$QQMusicSuccessActivity() {
        ViewGroup.LayoutParams layoutParams = this.bgContainer.getLayoutParams();
        double measuredWidth = (double) this.bgContainer.getMeasuredWidth();
        Double.isNaN(measuredWidth);
        layoutParams.height = (int) (measuredWidth * 0.75d);
        this.bgContainer.setLayoutParams(layoutParams);
    }

    /* renamed from: onClick */
    public void lambda$onCreate$1$QQMusicSuccessActivity(View view) {
        QqMusicVipPriceAdapter qqMusicVipPriceAdapter2;
        int id = view.getId();
        if (id == R.id.tvSkip) {
            finish();
        } else if (id == R.id.tvOpenNow && (qqMusicVipPriceAdapter2 = this.qqMusicVipPriceAdapter) != null) {
            qqMusicVipPriceAdapter2.startPaymentWebActivity(this);
        }
    }

    private void getQQMusicVIPPriceList() {
        ApiHelper.getQQMusicVIPPriceList(new ApiRequest.Listener<List<Payment.PriceItem>>() {
            /* class com.xiaomi.mico.setting.QQMusicSuccessActivity.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Payment.PriceItem>) ((List) obj));
            }

            public void onSuccess(List<Payment.PriceItem> list) {
                if (QQMusicSuccessActivity.this.qqMusicVipPriceAdapter != null) {
                    QQMusicSuccessActivity.this.qqMusicVipPriceAdapter.setData(list);
                }
            }
        });
    }

    public void onSupportContractChanged(Payment.PriceItem priceItem) {
        boolean hasData = ContainerUtil.hasData(priceItem.contractDesc);
        this.ctvRenewal.setVisibility(hasData ? 0 : 4);
        if (hasData) {
            this.ctvRenewal.setText(priceItem.contractDesc);
        }
    }
}
