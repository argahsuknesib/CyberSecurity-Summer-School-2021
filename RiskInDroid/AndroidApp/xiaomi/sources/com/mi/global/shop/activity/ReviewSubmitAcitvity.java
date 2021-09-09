package com.mi.global.shop.activity;

import _m_j.bzy;
import _m_j.bzz;
import _m_j.cah;
import _m_j.cav;
import _m_j.cbh;
import _m_j.cbk;
import _m_j.cbq;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import _m_j.ceh;
import _m_j.cek;
import _m_j.cem;
import _m_j.cen;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.dialog.ReviewSubmitCancelDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ReviewSubmitAcitvity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private ProgressDialog f4679O000000o;
    @BindView(2131493038)
    CustomButtonView btnSubmit;
    @BindView(2131493323)
    CustomEditTextView etReviewContent;
    @BindView(2131493325)
    CustomEditTextView etTitle;
    @BindView(2131493521)
    RatingBar itemRating;
    @BindView(2131493523)
    CustomTextView itemTitle;
    @BindView(2131493558)
    SimpleDraweeView ivOrder;
    @BindView(2131493691)
    LinearLayout loading;
    public bzz mGridAdapter;
    @BindView(2131493397)
    GridView mGridView;
    @BindView(2131493466)
    CustomTextView mImageCountTipView;
    public ReviewSubmitCancelDialog reviewSubmitCancelDialog;
    @BindView(2131494156)
    LinearLayout topReview;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_order_review_submit);
        ButterKnife.bind(this);
        this.mBackView.setVisibility(0);
        this.mCartView.setVisibility(8);
        initValue();
        this.mGridAdapter = new bzz(this);
        this.mGridView.setAdapter((ListAdapter) this.mGridAdapter);
        this.mGridView.setOnItemClickListener(this);
    }

    public void initValue() {
        if (getIntent().getStringExtra("order_item_id") == null || getIntent().getStringExtra("goods_sku") == null || getIntent().getStringExtra("goods_name") == null || getIntent().getStringExtra("goods_img") == null) {
            cec.O000000o(this, getString(R.string.error_invalid_order), 3000);
            finish();
        }
        String stringExtra = getIntent().getStringExtra("goods_name");
        setTitle(stringExtra + " review");
        this.itemTitle.setText(stringExtra);
        cbq.O000000o(getIntent().getStringExtra("goods_img"), this.ivOrder);
        this.itemRating.setRating(5.0f);
        checkStar(this.itemRating.getRating());
        this.itemRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass1 */

            public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                ReviewSubmitAcitvity.this.itemRating.setRating(f);
                ReviewSubmitAcitvity.this.checkStar(f);
            }
        });
        this.btnSubmit.setOnClickListener(this);
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass2 */

            public final void onClick(View view) {
                ReviewSubmitCancelDialog.Builder builder = new ReviewSubmitCancelDialog.Builder(ReviewSubmitAcitvity.this);
                builder.O00000Oo = new DialogInterface.OnClickListener() {
                    /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ReviewSubmitAcitvity.this.finish();
                    }
                };
                ReviewSubmitAcitvity reviewSubmitAcitvity = ReviewSubmitAcitvity.this;
                ReviewSubmitCancelDialog reviewSubmitCancelDialog = new ReviewSubmitCancelDialog(builder.f5012O000000o, (byte) 0);
                View inflate = ((LayoutInflater) builder.f5012O000000o.getSystemService("layout_inflater")).inflate((int) R.layout.shop_review_submit_cancel_dialog, (ViewGroup) null);
                ButterKnife.bind(builder, inflate);
                reviewSubmitCancelDialog.setCanceledOnTouchOutside(true);
                builder.btnCancel.setOnClickListener(new View.OnClickListener(reviewSubmitCancelDialog) {
                    /* class com.mi.global.shop.widget.dialog.ReviewSubmitCancelDialog.Builder.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ ReviewSubmitCancelDialog f5013O000000o;

                    {
                        this.f5013O000000o = r2;
                    }

                    public final void onClick(View view) {
                        this.f5013O000000o.dismiss();
                    }
                });
                if (builder.O00000Oo != null) {
                    builder.btnLeave.setOnClickListener(new View.OnClickListener(reviewSubmitCancelDialog) {
                        /* class com.mi.global.shop.widget.dialog.ReviewSubmitCancelDialog.Builder.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ ReviewSubmitCancelDialog f5014O000000o;

                        {
                            this.f5014O000000o = r2;
                        }

                        public final void onClick(View view) {
                            Builder.this.O00000Oo.onClick(this.f5014O000000o, -2);
                        }
                    });
                }
                reviewSubmitCancelDialog.setContentView(inflate);
                reviewSubmitAcitvity.reviewSubmitCancelDialog = reviewSubmitCancelDialog;
                ReviewSubmitAcitvity.this.reviewSubmitCancelDialog.show();
            }
        });
        this.f4679O000000o = new ProgressDialog(this);
        this.f4679O000000o.setMessage(getString(R.string.please_wait));
        this.f4679O000000o.setIndeterminate(true);
        this.f4679O000000o.setCancelable(false);
        this.f4679O000000o.setCanceledOnTouchOutside(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        if (r4 != 1000) goto L_0x00ae;
     */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 999) {
            if (i2 == -1) {
                this.mGridAdapter.O000000o(intent.getStringArrayListExtra("select_result"));
            }
        }
        if (intent != null) {
            if (i2 == 100 && !TextUtils.isEmpty(intent.getStringExtra("deleteUrl"))) {
                String stringExtra = intent.getStringExtra("deleteUrl");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mGridAdapter.O00000Oo);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((String) arrayList.get(size)).equals(stringExtra)) {
                        arrayList.remove(size);
                    }
                }
                this.mGridAdapter.O000000o(arrayList);
            }
            if (i2 == 101 && !TextUtils.isEmpty(intent.getStringExtra("currentPath")) && !TextUtils.isEmpty(intent.getStringExtra("newPath"))) {
                String stringExtra2 = intent.getStringExtra("currentPath");
                String stringExtra3 = intent.getStringExtra("newPath");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mGridAdapter.O00000Oo);
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    if (((String) arrayList2.get(size2)).equals(stringExtra2)) {
                        arrayList2.remove(size2);
                        arrayList2.add(stringExtra3);
                    }
                }
                this.mGridAdapter.O000000o(arrayList2);
            }
        }
        if (this.mGridAdapter.O00000Oo == null || this.mGridAdapter.O00000Oo.size() <= 0) {
            this.mImageCountTipView.setVisibility(0);
        } else {
            this.mImageCountTipView.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit) {
            checkData();
        }
    }

    public void checkStar(float f) {
        if (f >= 3.0f && f < 4.0f) {
            this.etTitle.setText(getString(R.string.default_three_star));
        } else if (f >= 4.0f && f < 5.0f) {
            this.etTitle.setText(getString(R.string.default_four_star));
        } else if (f == 5.0f) {
            this.etTitle.setText(getString(R.string.default_fine_star));
        } else {
            this.etTitle.setText("");
        }
    }

    public void checkData() {
        if (this.etTitle.getText().toString().trim().isEmpty()) {
            cec.O000000o(this, getString(R.string.review_title_cannot_empty), 3000);
        } else if (this.etReviewContent.getText().toString().trim().isEmpty()) {
            cec.O000000o(this, getString(R.string.content_cannot_empty), 3000);
        } else {
            uploadImage();
        }
    }

    public void uploadImage() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.mGridAdapter.O00000Oo) {
            arrayList.add(add);
        }
        showLoading();
        if (arrayList.size() > 0) {
            AnonymousClass3 r1 = new cbk.O000000o() {
                /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass3 */

                public final void O000000o(ArrayList<String> arrayList) {
                    ReviewSubmitAcitvity.this.doSubmit(arrayList);
                }

                public final void O000000o() {
                    ReviewSubmitAcitvity reviewSubmitAcitvity = ReviewSubmitAcitvity.this;
                    cec.O000000o(reviewSubmitAcitvity, reviewSubmitAcitvity.getString(R.string.shop_network_unavaliable), 3000);
                    ReviewSubmitAcitvity.this.hideLoading();
                }
            };
            if (arrayList.size() == 0) {
                r1.O000000o();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("area", "in");
            hashMap.put("authId", "101");
            ceh.O000000o(new Runnable(arrayList, hashMap, r1) {
                /* class _m_j.cbk.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ ArrayList f13595O000000o;
                final /* synthetic */ Map O00000Oo;
                final /* synthetic */ O000000o O00000o0;

                {
                    this.f13595O000000o = r1;
                    this.O00000Oo = r2;
                    this.O00000o0 = r3;
                }

                public final void run() {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < this.f13595O000000o.size(); i++) {
                        Bitmap O000000o2 = cbb.O000000o((String) this.f13595O000000o.get(i), 400, 400);
                        String str = byl.O00000oO().getCacheDir().getAbsolutePath() + "/comment_image_" + i + ".jpg";
                        cbb.O000000o(O000000o2, str, Bitmap.CompressFormat.JPEG, 100);
                        arrayList.add(str);
                        if (O000000o2 != null) {
                            O000000o2.recycle();
                        }
                    }
                    Map map = this.O00000Oo;
                    O000000o o000000o = this.O00000o0;
                    caj caj = new caj("http://upload.global.mi.com/upload/multiimgs", map, arrayList, new Response.Listener<JSONObject>(o000000o) {
                        /* class _m_j.cbk.AnonymousClass2 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000000o f13596O000000o;

                        {
                            this.f13596O000000o = r1;
                        }

                        public final /* synthetic */ void onResponse(Object obj) {
                            JSONObject optJSONObject;
                            ArrayList arrayList;
                            JSONObject jSONObject = (JSONObject) obj;
                            if (!(jSONObject == null || (optJSONObject = jSONObject.optJSONObject("result")) == null)) {
                                if (optJSONObject.optInt("code", -1) == 0) {
                                    String optString = optJSONObject.optString("urls");
                                    if (!TextUtils.isEmpty(optString) && (arrayList = (ArrayList) new Gson().fromJson(optString, new TypeToken<ArrayList<String>>() {
                                        /* class _m_j.cbk.AnonymousClass2.AnonymousClass1 */
                                    }.getType())) != null && arrayList.size() > 0) {
                                        ArrayList arrayList2 = new ArrayList();
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            String str = (String) it.next();
                                            if (!TextUtils.isEmpty(str) && !str.startsWith("http:")) {
                                                str = str.startsWith("//") ? "http:".concat(String.valueOf(str)) : "http://".concat(String.valueOf(str));
                                            }
                                            arrayList2.add(str);
                                        }
                                        this.f13596O000000o.O000000o(arrayList2);
                                        return;
                                    }
                                }
                                TextUtils.isEmpty(optJSONObject.optString("message"));
                            }
                            this.f13596O000000o.O000000o();
                        }
                    }, new Response.ErrorListener(o000000o) {
                        /* class _m_j.cbk.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000000o f13598O000000o;

                        {
                            this.f13598O000000o = r1;
                        }

                        public final void onErrorResponse(VolleyError volleyError) {
                            this.f13598O000000o.O000000o();
                        }
                    });
                    caj.setRetryPolicy(new DefaultRetryPolicy(((arrayList.size() * 2) + 1) * 2500, 0, 1.0f));
                    ced.f13683O000000o.add(caj);
                }
            });
            return;
        }
        doSubmit(new ArrayList());
    }

    public void doSubmit(ArrayList<String> arrayList) {
        this.btnSubmit.setEnabled(false);
        HashMap hashMap = new HashMap();
        hashMap.put("goods_id", getIntent().getStringExtra("goods_sku"));
        hashMap.put("order_item_id", getIntent().getStringExtra("order_item_id"));
        StringBuilder sb = new StringBuilder();
        sb.append((int) this.itemRating.getRating());
        hashMap.put("total_grade", sb.toString());
        hashMap.put("comment_title", this.etTitle.getText().toString().trim());
        hashMap.put("comment_content", this.etReviewContent.getText().toString().trim());
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                hashMap.put("comment_pictures[" + i + "]", arrayList.get(i));
            }
        }
        hashMap.put("ot", "5");
        cah cah = new cah(1, cav.O000Ooo(), cbh.O000000o(cbh.O000000o(hashMap), "UTF-8"), new Response.Listener<JSONObject>() {
            /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass4 */

            public final /* synthetic */ void onResponse(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                ReviewSubmitAcitvity.this.btnSubmit.setEnabled(true);
                ReviewSubmitAcitvity.this.hideLoading();
                if (jSONObject == null) {
                    try {
                        ccr.O00000Oo("ReviewSubmitAcitvity", "get response json null");
                        ReviewSubmitAcitvity.this.submitError();
                    } catch (Exception e) {
                        ccr.O00000Oo("ReviewSubmitAcitvity", "loadInfo Exception:" + e.toString());
                        e.printStackTrace();
                        ReviewSubmitAcitvity.this.submitError();
                    }
                } else {
                    ccr.O00000Oo("ReviewSubmitAcitvity", "get response json:" + jSONObject.toString());
                    try {
                        if (!jSONObject.has("errno") || jSONObject.getInt("errno") != 0) {
                            cec.O000000o(ReviewSubmitAcitvity.this, jSONObject.optString("errmsg"), 3000);
                            return;
                        }
                        ccr.O00000Oo("ReviewSubmitAcitvity", "loadInfo errno = 0");
                        jSONObject.optJSONObject("data");
                        ccr.O00000Oo("ReviewSubmitAcitvity", "Parse json reuslt");
                        cec.O000000o(ReviewSubmitAcitvity.this, ReviewSubmitAcitvity.this.getString(R.string.submit_success), 3000);
                        Intent intent = new Intent();
                        intent.putExtra("submit_success", 102);
                        intent.putExtra("order_item_id", ReviewSubmitAcitvity.this.getIntent().getStringExtra("order_item_id"));
                        ReviewSubmitAcitvity.this.setResult(-1, intent);
                        ReviewSubmitAcitvity.this.finish();
                    } catch (Exception e2) {
                        ccr.O00000Oo("ReviewSubmitAcitvity", "loadInfo Exception:" + e2.toString());
                        e2.printStackTrace();
                        ReviewSubmitAcitvity.this.submitError();
                    }
                }
            }
        }, new Response.ErrorListener() {
            /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass5 */

            public final void onErrorResponse(VolleyError volleyError) {
                ReviewSubmitAcitvity.this.hideLoading();
                ReviewSubmitAcitvity.this.btnSubmit.setEnabled(true);
                ccr.O00000Oo("ReviewSubmitAcitvity", "VolleyError error:" + volleyError.getMessage());
                ReviewSubmitAcitvity.this.submitError();
            }
        });
        cah.setTag("ReviewSubmitAcitvity");
        ced.f13683O000000o.add(cah);
    }

    public void submitError() {
        cec.O000000o(this, getString(R.string.shop_error_network), 3000);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == this.mGridAdapter.O00000Oo.size()) {
            cem.O000000o(this, new cen() {
                /* class com.mi.global.shop.activity.ReviewSubmitAcitvity.AnonymousClass6 */

                public final void O000000o() {
                    bzy.O000000o().O000000o(5).O00000o0 = (ArrayList) ReviewSubmitAcitvity.this.mGridAdapter.O00000Oo;
                    bzy.O00000o.O000000o(ReviewSubmitAcitvity.this, 999);
                }

                public final void O00000Oo() {
                    ReviewSubmitAcitvity reviewSubmitAcitvity = ReviewSubmitAcitvity.this;
                    cem.O000000o(reviewSubmitAcitvity, reviewSubmitAcitvity.getString(R.string.permission_storage_error));
                }
            }, cek.O000000o.O0000Oo0);
            return;
        }
        Intent intent = new Intent(this, ReviewImageEditActivity.class);
        intent.putExtra("path", this.mGridAdapter.O00000Oo.get(i));
        startActivityForResult(intent, 1000);
    }

    public void showLoading() {
        ProgressDialog progressDialog = this.f4679O000000o;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    public void hideLoading() {
        ProgressDialog progressDialog = this.f4679O000000o;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4679O000000o.dismiss();
        }
    }
}
