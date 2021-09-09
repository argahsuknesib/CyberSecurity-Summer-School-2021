package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.bzw;
import _m_j.cah;
import _m_j.cav;
import _m_j.cbe;
import _m_j.cbf;
import _m_j.cbx;
import _m_j.ccr;
import _m_j.cdy;
import _m_j.cec;
import _m_j.ced;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.mi.global.shop.adapter.ReviewOrderListAdapter;
import com.mi.global.shop.loader.BaseResult;
import com.mi.global.shop.model.orderreview.OrderReviewModel;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.dialog.ReviewTipsDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ReviewListAcitvity extends BaseActivity implements ReviewOrderListAdapter.O000000o {
    public static final String TAG = "ReviewListAcitvity";

    /* renamed from: O000000o  reason: collision with root package name */
    private ReviewOrderListAdapter f4674O000000o;
    private long O00000Oo = 1;
    private int O00000o0 = 0;
    @BindView(2131493299)
    EmptyLoadingViewPlus emptyError;
    @BindView(2131493673)
    LinearLayout llNoneReview;
    @BindView(2131493681)
    LinearLayout llTips;
    @BindView(2131493691)
    LinearLayout loading;
    public int loadingFlag = 0;
    @BindView(2131493946)
    RecyclerView reviewRecycleView;
    public ReviewTipsDialog reviewTipsDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_order_review_list);
        ButterKnife.bind(this);
        setTitle(getString(R.string.account_reviews));
        initTitleBar();
        initView();
        this.loading.setVisibility(0);
        O00000Oo();
    }

    public void onResume() {
        super.onResume();
    }

    public void initTitleBar() {
        this.mBackView.setVisibility(0);
        findViewById(R.id.title_bar_cart_view).setVisibility(4);
    }

    public void initView() {
        this.reviewRecycleView.setLayoutManager(new LinearLayoutManager(this));
        this.f4674O000000o = new ReviewOrderListAdapter(this, this);
        this.f4674O000000o.O00000o = this;
        this.reviewRecycleView.addItemDecoration(new cbx(this, cdy.O000000o(0.5f), getResources().getColor(R.color.divider_color)));
        this.reviewRecycleView.setAdapter(this.f4674O000000o);
        this.llTips.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.ReviewListAcitvity.AnonymousClass1 */

            public final void onClick(View view) {
                ReviewTipsDialog.Builder builder = new ReviewTipsDialog.Builder(ReviewListAcitvity.this);
                ReviewListAcitvity reviewListAcitvity = ReviewListAcitvity.this;
                ReviewTipsDialog reviewTipsDialog = new ReviewTipsDialog(builder.f5016O000000o, (byte) 0);
                View inflate = ((LayoutInflater) builder.f5016O000000o.getSystemService("layout_inflater")).inflate((int) R.layout.shop_review_tips_dialog, (ViewGroup) null);
                ButterKnife.bind(builder, inflate);
                reviewTipsDialog.setCanceledOnTouchOutside(true);
                builder.btnOk.setOnClickListener(new View.OnClickListener(reviewTipsDialog) {
                    /* class com.mi.global.shop.widget.dialog.ReviewTipsDialog.Builder.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ ReviewTipsDialog f5017O000000o;

                    {
                        this.f5017O000000o = r2;
                    }

                    public final void onClick(View view) {
                        this.f5017O000000o.dismiss();
                    }
                });
                builder.O00000Oo = new ReviewTipsDialog.Builder.TipsAdapter(builder.f5016O000000o);
                ArrayList arrayList = new ArrayList();
                arrayList.add(builder.f5016O000000o.getResources().getString(R.string.review_tips_1));
                arrayList.add(builder.f5016O000000o.getResources().getString(R.string.review_tips_2));
                arrayList.add(builder.f5016O000000o.getResources().getString(R.string.review_tips_3));
                arrayList.add(builder.f5016O000000o.getResources().getString(R.string.review_tips_4));
                builder.O00000Oo.O000000o(arrayList);
                builder.lvTips.setAdapter((ListAdapter) builder.O00000Oo);
                builder.lvTips.setDividerHeight(0);
                reviewTipsDialog.setContentView(inflate);
                reviewListAcitvity.reviewTipsDialog = reviewTipsDialog;
                ReviewListAcitvity.this.reviewTipsDialog.show();
                cbe.O000000o("review_banner", ReviewListAcitvity.TAG);
            }
        });
    }

    private void O00000Oo() {
        this.llNoneReview.setVisibility(8);
        Uri.Builder buildUpon = Uri.parse(cav.O000Ooo0()).buildUpon();
        StringBuilder sb = new StringBuilder();
        sb.append(this.O00000Oo);
        buildUpon.appendQueryParameter("pageindex", sb.toString());
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        buildUpon.appendQueryParameter("name", "pages_index");
        buildUpon.appendQueryParameter("ot", "5");
        cah cah = new cah(buildUpon.toString(), new Response.Listener<JSONObject>() {
            /* class com.mi.global.shop.activity.ReviewListAcitvity.AnonymousClass2 */

            public final /* synthetic */ void onResponse(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                ReviewListAcitvity.this.loadingFlag = 0;
                if (jSONObject == null) {
                    try {
                        ccr.O00000Oo(ReviewListAcitvity.TAG, "get response json null");
                        ReviewListAcitvity.this.loadError();
                    } catch (Exception e) {
                        String str = ReviewListAcitvity.TAG;
                        ccr.O00000Oo(str, "loadInfo Exception:" + e.toString());
                        e.printStackTrace();
                        ReviewListAcitvity.this.loadError();
                    }
                } else {
                    String str2 = ReviewListAcitvity.TAG;
                    ccr.O00000Oo(str2, "get response json:" + jSONObject.toString());
                    try {
                        if (!jSONObject.has("errno") || jSONObject.getInt("errno") != 0) {
                            ReviewListAcitvity reviewListAcitvity = ReviewListAcitvity.this;
                            if (byl.O0000OOo()) {
                                if (jSONObject != null) {
                                    cec.O000000o(reviewListAcitvity, (int) R.string.shop_error_network, 0);
                                    try {
                                        int i = jSONObject.getInt("errno");
                                        String string = jSONObject.getString("errmsg");
                                        cec.O000000o(reviewListAcitvity, "Errno:" + String.valueOf(i) + ", msg:" + string, 1);
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            ReviewListAcitvity.this.loadError();
                            return;
                        }
                        ccr.O00000Oo(ReviewListAcitvity.TAG, "loadInfo errno = 0");
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        ccr.O00000Oo(ReviewListAcitvity.TAG, "Parse json reuslt");
                        ReviewListAcitvity.this.onLoadFinish((OrderReviewModel) new Gson().fromJson(optJSONObject.toString(), OrderReviewModel.class));
                    } catch (Exception e3) {
                        String str3 = ReviewListAcitvity.TAG;
                        ccr.O00000Oo(str3, "loadInfo Exception:" + e3.toString());
                        e3.printStackTrace();
                        ReviewListAcitvity.this.loadError();
                    }
                }
            }
        }, new Response.ErrorListener() {
            /* class com.mi.global.shop.activity.ReviewListAcitvity.AnonymousClass3 */

            public final void onErrorResponse(VolleyError volleyError) {
                ReviewListAcitvity.this.loadingFlag = 0;
                String str = ReviewListAcitvity.TAG;
                ccr.O00000Oo(str, "VolleyError error:" + volleyError.getMessage());
                ReviewListAcitvity.this.loadError();
            }
        });
        cah.setTag(TAG);
        ced.f13683O000000o.add(cah);
        this.loadingFlag = 1;
    }

    public void onLoadFinish(OrderReviewModel orderReviewModel) {
        this.O00000Oo++;
        checkMoreState((long) orderReviewModel.page_total);
        this.loading.setVisibility(8);
        EmptyLoadingViewPlus emptyLoadingViewPlus = this.emptyError;
        if (emptyLoadingViewPlus != null) {
            emptyLoadingViewPlus.setVisibility(8);
        }
        if (orderReviewModel.goodsList == null || orderReviewModel.goodsList.size() <= 0) {
            this.llNoneReview.setVisibility(0);
            return;
        }
        ReviewOrderListAdapter reviewOrderListAdapter = this.f4674O000000o;
        ArrayList<OrderReviewModel.OrderReviewItemModel> arrayList = orderReviewModel.goodsList;
        if (arrayList != null) {
            reviewOrderListAdapter.O00000o0.addAll(arrayList);
            reviewOrderListAdapter.notifyDataSetChanged();
        }
    }

    public void checkMoreState(long j) {
        if (this.O00000Oo > j) {
            this.O00000o0 = 1;
            this.O00000Oo = j + 1;
            return;
        }
        this.O00000o0 = 0;
    }

    public void checkLoadMore() {
        if (this.O00000o0 == 0 && this.loadingFlag == 0) {
            O00000Oo();
        }
    }

    public void loadError() {
        this.loading.setVisibility(8);
        EmptyLoadingViewPlus emptyLoadingViewPlus = this.emptyError;
        if (emptyLoadingViewPlus != null) {
            emptyLoadingViewPlus.setVisibility(0);
            this.emptyError.O000000o(BaseResult.ResultStatus.NETWROK_ERROR);
            cec.O000000o(this, getString(R.string.shop_network_unavaliable), 3000);
            finish();
        }
    }

    public void onLoadMore() {
        checkLoadMore();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 100 && intent.getIntExtra("submit_success", 0) == 102) {
            String stringExtra = intent.getStringExtra("order_item_id");
            ReviewOrderListAdapter reviewOrderListAdapter = this.f4674O000000o;
            if (reviewOrderListAdapter.O00000o0 != null) {
                for (int size = reviewOrderListAdapter.O00000o0.size() - 1; size >= 0; size--) {
                    if (reviewOrderListAdapter.O00000o0.get(size).order_item_id.equals(stringExtra)) {
                        reviewOrderListAdapter.O00000o0.remove(size);
                    }
                }
                reviewOrderListAdapter.notifyDataSetChanged();
            }
        }
    }
}
