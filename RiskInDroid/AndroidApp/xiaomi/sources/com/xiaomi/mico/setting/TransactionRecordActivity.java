package com.xiaomi.mico.setting;

import _m_j.czx;
import _m_j.dai;
import _m_j.gwg;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.TransactionRecordAdapter;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class TransactionRecordActivity extends MicoBaseActivity {
    public long nextIndex;
    @BindView(6907)
    SmartRefreshLayout refreshLayout;
    @BindView(6929)
    RecyclerView rlRecord;
    @BindView(7228)
    TitleBar titleBar;
    public TransactionRecordAdapter transactionRecordAdapter;
    private Unbinder unbinder;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_transaction_record);
        this.unbinder = ButterKnife.bind(this);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$vkBZFY8GZmMzKFzM873eFJCneg */

            public final void onLeftIconClick() {
                TransactionRecordActivity.this.onBackPressed();
            }
        });
        this.transactionRecordAdapter = new TransactionRecordAdapter();
        this.rlRecord.setAdapter(this.transactionRecordAdapter);
        this.rlRecord.setLayoutManager(new LinearLayoutManager(getContext()));
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(true);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.setting.$$Lambda$TransactionRecordActivity$nmPZTjpBo9xVBBUhKLVeYsw62g */

            public final void onLoadMore(czx czx) {
                TransactionRecordActivity.this.lambda$onCreate$0$TransactionRecordActivity(czx);
            }
        });
        getTransactionRecord();
        this.nextIndex = System.currentTimeMillis();
        gwg.O00000Oo(getWindow());
    }

    public /* synthetic */ void lambda$onCreate$0$TransactionRecordActivity(czx czx) {
        getTransactionRecord();
    }

    private void getTransactionRecord() {
        showProgressDialog("");
        ApiHelper.getTransactionRecord(20, this.nextIndex, new ApiRequest.Listener<Payment.TransactionRecord>() {
            /* class com.xiaomi.mico.setting.TransactionRecordActivity.AnonymousClass1 */

            public void onSuccess(Payment.TransactionRecord transactionRecord) {
                TransactionRecordActivity.this.dismissProgressDialog();
                TransactionRecordActivity.this.refreshLayout.O0000O0o();
                TransactionRecordActivity.this.refreshLayout.O0000O0o(transactionRecord.hasMoreData());
                TransactionRecordActivity.this.nextIndex = transactionRecord.nextIndex;
                TransactionRecordActivity.this.transactionRecordAdapter.addData(transactionRecord.billInfoList);
            }

            public void onFailure(ApiError apiError) {
                TransactionRecordActivity.this.dismissProgressDialog();
                TransactionRecordActivity.this.refreshLayout.O0000O0o();
                TransactionRecordActivity.this.refreshLayout.O00000o(false);
            }
        }).bindToLifecycle(this);
    }

    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder2 = this.unbinder;
        if (unbinder2 != null) {
            unbinder2.unbind();
        }
    }
}
