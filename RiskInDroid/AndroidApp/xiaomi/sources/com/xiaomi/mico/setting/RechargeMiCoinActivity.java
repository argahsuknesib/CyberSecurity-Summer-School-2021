package com.xiaomi.mico.setting;

import _m_j.gwg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.MiCoinPriceAdapter;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class RechargeMiCoinActivity extends MicoBaseActivity {
    public boolean justStartPaymentWebActivity;
    public float miCoinBalance;
    private MiCoinPriceAdapter miCoinPriceAdapter;
    @BindView(6928)
    RecyclerView rlPrice;
    @BindView(7228)
    TitleBar titleBar;
    @BindView(7285)
    TextView tvBalance;
    private Unbinder unbinder;

    public boolean isDarkMode() {
        return true;
    }

    public static void startForResult(Activity activity, float f) {
        Intent intent = new Intent(activity, RechargeMiCoinActivity.class);
        intent.putExtra("MI_COIN_BALANCE", f);
        activity.startActivityForResult(intent, 100);
    }

    public static void start(Activity activity) {
        startForResult(activity, 0.0f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mico_activity_recharge_mi_coin);
        this.unbinder = ButterKnife.bind(this);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$KmPhps8ojEvekaKAL6HoxLW2GQ */

            public final void onLeftIconClick() {
                RechargeMiCoinActivity.this.onBackPressed();
            }
        });
        this.titleBar.setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$RechargeMiCoinActivity$PduGBzXy19dhbWfnMvwKuFvRhY */

            public final void onRightButtonClick() {
                RechargeMiCoinActivity.this.lambda$onCreate$0$RechargeMiCoinActivity();
            }
        });
        this.miCoinBalance = getIntent().getFloatExtra("MI_COIN_BALANCE", 0.0f);
        updateTvBalance();
        this.miCoinPriceAdapter = new MiCoinPriceAdapter(getContext());
        this.rlPrice.setAdapter(this.miCoinPriceAdapter);
        gwg.O00000Oo(getWindow());
    }

    public /* synthetic */ void lambda$onCreate$0$RechargeMiCoinActivity() {
        startActivity(new Intent(this, TransactionRecordActivity.class));
    }

    public void updateTvBalance() {
        this.tvBalance.setText(MiCoinPriceAdapter.PriceItem.getFormatMiCoin(this.miCoinBalance));
    }

    public void onResume() {
        super.onResume();
        if (this.justStartPaymentWebActivity || this.miCoinBalance == 0.0f) {
            getMiCoinBalance();
        }
    }

    /* access modifiers changed from: package-private */
    @OnClick({7290})
    public void onClick(View view) {
        this.miCoinPriceAdapter.startPaymentWebActivity(this);
        this.justStartPaymentWebActivity = true;
    }

    private void getMiCoinBalance() {
        ApiHelper.getMiCoinBalance(new ApiRequest.Listener<Long>() {
            /* class com.xiaomi.mico.setting.RechargeMiCoinActivity.AnonymousClass1 */

            public void onSuccess(Long l) {
                float f = RechargeMiCoinActivity.this.miCoinBalance;
                RechargeMiCoinActivity.this.miCoinBalance = ((float) l.longValue()) / 100.0f;
                if (RechargeMiCoinActivity.this.justStartPaymentWebActivity) {
                    ToastUtil.showToast(RechargeMiCoinActivity.this.miCoinBalance != f ? R.string.common_recharge_success : R.string.common_recharge_failed);
                }
                RechargeMiCoinActivity.this.updateTvBalance();
                RechargeMiCoinActivity.this.justStartPaymentWebActivity = false;
            }

            public void onFailure(ApiError apiError) {
                RechargeMiCoinActivity.this.justStartPaymentWebActivity = false;
            }
        });
    }

    public void onBackPressed() {
        setResult();
        super.onBackPressed();
    }

    private void setResult() {
        Intent intent = new Intent();
        intent.putExtra("MI_COIN_BALANCE", this.miCoinBalance);
        setResult(-1, intent);
    }

    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder2 = this.unbinder;
        if (unbinder2 != null) {
            unbinder2.unbind();
        }
    }
}
