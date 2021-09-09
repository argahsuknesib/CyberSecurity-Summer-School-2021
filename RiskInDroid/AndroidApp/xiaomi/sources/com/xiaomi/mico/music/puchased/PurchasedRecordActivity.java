package com.xiaomi.mico.music.puchased;

import _m_j.czx;
import _m_j.dai;
import _m_j.gsy;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.ApiProviderV2;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.GetPurchasedRecordResponse;
import com.xiaomi.mico.api.service.PaymentService;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.PurchasedRecordAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter;
import com.xiaomi.mico.common.util.ViewUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;
import rx.Observable;
import rx.functions.Action1;

public class PurchasedRecordActivity extends MicoBaseActivity {
    public LEEAdapter mLEEAdapter;
    public long nextIndex;
    public PurchasedRecordAdapter purchasedRecordAdapter;
    SmartRefreshLayout refreshLayout;
    RecyclerView rlRecord;
    TitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_transaction_record);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.rlRecord = (RecyclerView) findViewById(R.id.rlRecord);
        this.refreshLayout = (SmartRefreshLayout) findViewById(R.id.refresh_layout);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.puchased.$$Lambda$UZEDcJxZXTfQPDlplq5_qqow9Wg */

            public final void onLeftIconClick() {
                PurchasedRecordActivity.this.onBackPressed();
            }
        });
        this.titleBar.setTitle((int) R.string.music_purchased);
        this.purchasedRecordAdapter = new PurchasedRecordAdapter();
        this.purchasedRecordAdapter.setOnItemClickListener(new ItemClickableAdapter.OnItemClickListener() {
            /* class com.xiaomi.mico.music.puchased.$$Lambda$PurchasedRecordActivity$yxAHShVQDx1E8_QrkPVhyEbmI */

            public final void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
                PurchasedRecordActivity.this.lambda$onCreate$0$PurchasedRecordActivity(viewHolder, i);
            }
        });
        this.rlRecord.setLayoutManager(new LinearLayoutManager(getContext()));
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(true);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.music.puchased.$$Lambda$PurchasedRecordActivity$2XVkiO2soKfkyhhL6vGwvXDLdOo */

            public final void onLoadMore(czx czx) {
                PurchasedRecordActivity.this.lambda$onCreate$1$PurchasedRecordActivity(czx);
            }
        });
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.view_loading, (ViewGroup) this.rlRecord, false);
        View inflate2 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.rlRecord, false);
        ViewUtil.setupEmptyView(inflate2, null);
        View inflate3 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.rlRecord, false);
        ViewUtil.setupErrorView(inflate3, new Action1() {
            /* class com.xiaomi.mico.music.puchased.$$Lambda$PurchasedRecordActivity$Tz5AioHy0agRDL_Sy4rxeelfQ50 */

            public final void call(Object obj) {
                PurchasedRecordActivity.this.lambda$onCreate$2$PurchasedRecordActivity((Void) obj);
            }
        });
        this.mLEEAdapter = new LEEAdapter(this.purchasedRecordAdapter, inflate, inflate2, inflate3);
        this.rlRecord.setAdapter(this.mLEEAdapter);
        getTransactionRecord();
        this.nextIndex = System.currentTimeMillis();
    }

    public /* synthetic */ void lambda$onCreate$0$PurchasedRecordActivity(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        GetPurchasedRecordResponse.PurchasedItem purchasedItem = (GetPurchasedRecordResponse.PurchasedItem) this.purchasedRecordAdapter.getData(i);
        if (purchasedItem != null) {
            purchasedItem.handleItemClick(getContext());
        }
    }

    public /* synthetic */ void lambda$onCreate$1$PurchasedRecordActivity(czx czx) {
        getTransactionRecord();
    }

    public /* synthetic */ void lambda$onCreate$2$PurchasedRecordActivity(Void voidR) {
        this.mLEEAdapter.setCurrentView(101);
        getTransactionRecord();
    }

    private void getTransactionRecord() {
        showProgressDialog("");
        ApiManager.getInstance().enqueue(new ApiProviderV2() {
            /* class com.xiaomi.mico.music.puchased.$$Lambda$PurchasedRecordActivity$YIVLdsDOTglKCUBBL1nxVkR5SL8 */

            public final Observable observable(Object obj) {
                return PurchasedRecordActivity.this.lambda$getTransactionRecord$3$PurchasedRecordActivity((PaymentService) obj);
            }
        }, PaymentService.class, new ApiRequest.Listener<GetPurchasedRecordResponse>() {
            /* class com.xiaomi.mico.music.puchased.PurchasedRecordActivity.AnonymousClass1 */

            public void onSuccess(GetPurchasedRecordResponse getPurchasedRecordResponse) {
                PurchasedRecordActivity.this.dismissProgressDialog();
                PurchasedRecordActivity.this.refreshLayout.O0000O0o();
                PurchasedRecordActivity.this.refreshLayout.O0000O0o(getPurchasedRecordResponse.hasMoreData());
                PurchasedRecordActivity.this.nextIndex = getPurchasedRecordResponse.nextIndex;
                PurchasedRecordActivity.this.purchasedRecordAdapter.addDataList(getPurchasedRecordResponse.list);
                if (PurchasedRecordActivity.this.purchasedRecordAdapter.getDataSize() == 0) {
                    PurchasedRecordActivity purchasedRecordActivity = PurchasedRecordActivity.this;
                    purchasedRecordActivity.nextIndex = 0;
                    purchasedRecordActivity.mLEEAdapter.setCurrentView(102);
                    return;
                }
                PurchasedRecordActivity.this.mLEEAdapter.setCurrentView(100);
            }

            public void onFailure(ApiError apiError) {
                PurchasedRecordActivity.this.dismissProgressDialog();
                gsy.O00000Oo(12000, "12000.4.5", "");
                PurchasedRecordActivity.this.refreshLayout.O0000O0o();
                PurchasedRecordActivity.this.refreshLayout.O00000o(false);
                if (PurchasedRecordActivity.this.purchasedRecordAdapter.getDataSize() == 0) {
                    PurchasedRecordActivity.this.mLEEAdapter.setCurrentView(103);
                }
            }
        });
    }

    public /* synthetic */ Observable lambda$getTransactionRecord$3$PurchasedRecordActivity(PaymentService paymentService) {
        return paymentService.getPurchasedRecord(20, this.nextIndex);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
