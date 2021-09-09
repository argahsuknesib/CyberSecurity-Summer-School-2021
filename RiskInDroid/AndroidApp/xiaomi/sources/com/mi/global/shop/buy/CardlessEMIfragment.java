package com.mi.global.shop.buy;

import _m_j.cak;
import _m_j.cam;
import _m_j.can;
import _m_j.cau;
import _m_j.cav;
import _m_j.cck;
import _m_j.ccr;
import _m_j.ced;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.PayResultWebActivity;
import com.mi.global.shop.adapter.checkout.CardlessPlanListAdapter;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.checkout.NewCardlessEMIPlanResult;
import com.mi.global.shop.newmodel.checkout.NewCreateLoanApplicationResult;
import com.mi.global.shop.newmodel.checkout.NewLoanPayResult;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.global.shop.widget.dialog.CustomProgressDialog;
import com.mi.global.shop.widget.dialog.CustomVerifyOTPDialog;
import com.mi.global.shop.widget.dialog.EMIAgreementDialog;
import com.mi.global.shop.widget.dialog.EMIConfirmDialog;
import com.xiaomi.smarthome.R;
import java.util.List;

public class CardlessEMIfragment extends can implements CustomVerifyOTPDialog.O000000o, EMIAgreementDialog.Builder.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public NewCardlessEMIPlanResult.EmiPlansData f4839O000000o;
    List<NewCardlessEMIPlanResult.CardlessEMIPlanOption> O00000Oo;
    public EMIConfirmDialog O00000o;
    CardlessPlanListAdapter O00000o0;
    public EMIAgreementDialog O00000oO;
    public CustomProgressDialog O00000oo;
    String O0000O0o;
    DefaultRetryPolicy O0000OOo = new DefaultRetryPolicy(30000, 0, 1.0f);
    private CustomVerifyOTPDialog O0000Oo;
    private View O0000Oo0;
    private String O0000OoO;
    @BindView(2131493669)
    RelativeLayout mContentGroup;
    @BindView(2131493294)
    CustomTextView mEMIErrorTip;
    @BindView(2131493008)
    CustomButtonView mPayNowBtn;
    @BindView(2131493700)
    NoScrollListView mPlanListView;
    @BindView(2131494246)
    CustomTextView mPlanTips;

    public void onCreate(Bundle bundle) {
        ccr.O00000Oo("CardlessEMIfragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ccr.O00000Oo("CardlessEMIfragment", "onCreateView");
        View view = this.O0000Oo0;
        if (view == null) {
            this.O0000Oo0 = layoutInflater.inflate((int) R.layout.shop_activity_cardless_emi, viewGroup, false);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O0000Oo0);
                ccr.O00000Oo("CardlessEMIfragment", "onCreateView remove from parent");
            }
        }
        return this.O0000Oo0;
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null) {
            ButterKnife.bind(this, this.O0000Oo0);
            cck.O000000o(getActivity());
            this.mContentGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, cck.O00000Oo - cck.O000000o(65.0f)));
            getActivity().setTitle(getString(R.string.cardless_emi_title));
            this.O00000o0 = new CardlessPlanListAdapter(getActivity());
            this.O00000oo = new CustomProgressDialog(getActivity());
            this.O00000oo.O000000o();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.O0000O0o = arguments.getString("order_id_extra");
                this.O0000OoO = arguments.getString("order_total_extra");
            }
            Uri.Builder buildUpon = Uri.parse(cav.O000o00()).buildUpon();
            buildUpon.appendQueryParameter("basketamount", this.O0000OoO);
            buildUpon.appendQueryParameter("order_id", this.O0000O0o);
            cam cam = new cam(buildUpon.toString(), NewCardlessEMIPlanResult.class, new cak<NewCardlessEMIPlanResult>() {
                /* class com.mi.global.shop.buy.CardlessEMIfragment.AnonymousClass1 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewCardlessEMIPlanResult newCardlessEMIPlanResult = (NewCardlessEMIPlanResult) baseResult;
                    CardlessEMIfragment.this.O00000oo.O00000Oo();
                    if (newCardlessEMIPlanResult != null && newCardlessEMIPlanResult.data != null) {
                        CardlessEMIfragment.this.f4839O000000o = newCardlessEMIPlanResult.data;
                        CardlessEMIfragment cardlessEMIfragment = CardlessEMIfragment.this;
                        if (cardlessEMIfragment.f4839O000000o.status != 4) {
                            cardlessEMIfragment.mContentGroup.setVisibility(0);
                            cardlessEMIfragment.mPlanListView.setAdapter((ListAdapter) cardlessEMIfragment.O00000o0);
                            if (cardlessEMIfragment.f4839O000000o.status < 3) {
                                if (!TextUtils.isEmpty(cardlessEMIfragment.f4839O000000o.statusMessage)) {
                                    cardlessEMIfragment.mEMIErrorTip.setVisibility(0);
                                    cardlessEMIfragment.mEMIErrorTip.setText(cardlessEMIfragment.f4839O000000o.statusMessage);
                                }
                            } else if (cardlessEMIfragment.f4839O000000o.emiPlans != null) {
                                CustomTextView customTextView = cardlessEMIfragment.mPlanTips;
                                customTextView.setText(cardlessEMIfragment.getString(R.string.cardless_emi_tips, cardlessEMIfragment.f4839O000000o.emiPlans.basketAmount));
                                cardlessEMIfragment.O00000Oo = cardlessEMIfragment.f4839O000000o.emiPlans.emiOptions;
                                cardlessEMIfragment.O000000o();
                                cardlessEMIfragment.O00000o0.O000000o(cardlessEMIfragment.O00000Oo);
                            }
                        } else if (!TextUtils.isEmpty(cardlessEMIfragment.f4839O000000o.statusMessage)) {
                            EMIAgreementDialog.Builder builder = new EMIAgreementDialog.Builder(cardlessEMIfragment.getActivity(), cardlessEMIfragment);
                            builder.f4999O000000o = cardlessEMIfragment.f4839O000000o.statusMessage;
                            cardlessEMIfragment.O00000oO = builder.O000000o();
                            cardlessEMIfragment.O00000oO.O000000o();
                        }
                    }
                }

                public final void onErrorResponse(VolleyError volleyError) {
                    super.onErrorResponse(volleyError);
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    CardlessEMIfragment.this.O00000oo.O00000Oo();
                    CardlessEMIfragment.this.mContentGroup.setVisibility(4);
                }
            });
            cam.setTag("CardlessEMIfragment");
            cam.setRetryPolicy(this.O0000OOo);
            ced.f13683O000000o.add(cam);
        }
        super.onViewCreated(view, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        List<NewCardlessEMIPlanResult.CardlessEMIPlanOption> list = this.O00000Oo;
        if (list != null) {
            for (NewCardlessEMIPlanResult.CardlessEMIPlanOption cardlessEMIPlanOption : list) {
                if (cardlessEMIPlanOption.isDefault) {
                    return;
                }
            }
            List<NewCardlessEMIPlanResult.CardlessEMIPlanOption> list2 = this.O00000Oo;
            if (list2 != null && list2.size() > 0) {
                this.O00000Oo.get(0).isDefault = true;
            }
        }
    }

    @OnClick({2131493008})
    public void cardlessPayNow(View view) {
        NewCardlessEMIPlanResult.CardlessEMIPlanOption O00000o2;
        if (!cau.O000000o() && (O00000o2 = O00000o()) != null) {
            StringBuilder sb = new StringBuilder(" ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O00000o2.numberOfMonths);
            sb.append(getString(R.string.cardless_emi_confirm_dialog_content_amt, O00000o2.totalMonthlyAmount, sb2.toString()));
            String sb3 = sb.toString();
            EMIConfirmDialog.Builder builder = new EMIConfirmDialog.Builder(getActivity());
            builder.O00000o0 = getString(R.string.cardless_emi_confirm_dialog_title);
            builder.O00000o = sb3;
            builder.O00000oO = getString(R.string.cardless_emi_otp_cancel);
            builder.O0000OOo = null;
            String string = getString(R.string.cardless_emi_otp_confirm);
            AnonymousClass2 r2 = new DialogInterface.OnClickListener() {
                /* class com.mi.global.shop.buy.CardlessEMIfragment.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    CardlessEMIfragment cardlessEMIfragment = CardlessEMIfragment.this;
                    cardlessEMIfragment.O00000oo.O000000o();
                    cardlessEMIfragment.mPayNowBtn.setClickable(false);
                    cardlessEMIfragment.mPayNowBtn.setBackgroundColor(cardlessEMIfragment.getResources().getColor(R.color.light_grey));
                    Uri.Builder buildUpon = Uri.parse(cav.O000o00O()).buildUpon();
                    buildUpon.appendQueryParameter("order_id", cardlessEMIfragment.O0000O0o);
                    StringBuilder sb = new StringBuilder();
                    sb.append(cardlessEMIfragment.O00000o().numberOfMonths);
                    buildUpon.appendQueryParameter("terms", sb.toString());
                    cam cam = new cam(buildUpon.toString(), NewCreateLoanApplicationResult.class, new cak<NewCreateLoanApplicationResult>() {
                        /* class com.mi.global.shop.buy.CardlessEMIfragment.AnonymousClass3 */

                        public final /* synthetic */ void O000000o(BaseResult baseResult) {
                            NewCreateLoanApplicationResult newCreateLoanApplicationResult = (NewCreateLoanApplicationResult) baseResult;
                            if (CardlessEMIfragment.this.O00000o != null) {
                                EMIConfirmDialog eMIConfirmDialog = CardlessEMIfragment.this.O00000o;
                                if (BaseActivity.isActivityAlive(eMIConfirmDialog.f5003O000000o)) {
                                    eMIConfirmDialog.dismiss();
                                }
                            }
                            CardlessEMIfragment.this.O00000oO();
                            if (newCreateLoanApplicationResult != null && newCreateLoanApplicationResult.data != null && newCreateLoanApplicationResult.data.result && !TextUtils.isEmpty(newCreateLoanApplicationResult.data.content)) {
                                CardlessEMIfragment cardlessEMIfragment = CardlessEMIfragment.this;
                                EMIAgreementDialog.Builder builder = new EMIAgreementDialog.Builder(cardlessEMIfragment.getActivity(), CardlessEMIfragment.this);
                                builder.f4999O000000o = newCreateLoanApplicationResult.data.content;
                                cardlessEMIfragment.O00000oO = builder.O000000o();
                                CardlessEMIfragment.this.O00000oO.O000000o();
                            }
                        }

                        public final void onErrorResponse(VolleyError volleyError) {
                            super.onErrorResponse(volleyError);
                        }

                        public final void O000000o(String str) {
                            super.O000000o(str);
                            CardlessEMIfragment.this.O00000oO();
                        }
                    });
                    cam.setTag("CardlessEMIfragment");
                    cam.setRetryPolicy(cardlessEMIfragment.O0000OOo);
                    ced.f13683O000000o.add(cam);
                }
            };
            builder.O00000oo = string;
            builder.O0000O0o = r2;
            EMIConfirmDialog eMIConfirmDialog = new EMIConfirmDialog(builder.f5004O000000o, (byte) 0);
            View inflate = ((LayoutInflater) builder.f5004O000000o.getSystemService("layout_inflater")).inflate((int) R.layout.shop_emi_confirm_dialog, (ViewGroup) null);
            ButterKnife.bind(builder, inflate);
            eMIConfirmDialog.setCanceledOnTouchOutside(builder.O00000Oo);
            if (TextUtils.isEmpty(builder.O00000o0)) {
                builder.tvTitle.setVisibility(8);
            } else {
                builder.tvTitle.setVisibility(0);
                builder.tvTitle.setText(builder.O00000o0);
            }
            if (TextUtils.isEmpty(builder.O00000o)) {
                builder.tvContent.setVisibility(8);
            } else {
                builder.tvContent.setVisibility(0);
                builder.tvContent.setText(builder.O00000o);
            }
            if (builder.O00000oO != null) {
                builder.btnNo.setText(builder.O00000oO);
            }
            if (builder.O00000oo != null) {
                builder.btnYes.setText(builder.O00000oo);
            }
            builder.btnNo.setOnClickListener(new View.OnClickListener(eMIConfirmDialog) {
                /* class com.mi.global.shop.widget.dialog.EMIConfirmDialog.Builder.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ EMIConfirmDialog f5005O000000o;

                {
                    this.f5005O000000o = r2;
                }

                public final void onClick(View view) {
                    this.f5005O000000o.dismiss();
                }
            });
            if (builder.O0000O0o != null) {
                builder.btnYes.setOnClickListener(new View.OnClickListener(eMIConfirmDialog) {
                    /* class com.mi.global.shop.widget.dialog.EMIConfirmDialog.Builder.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ EMIConfirmDialog f5006O000000o;

                    {
                        this.f5006O000000o = r2;
                    }

                    public final void onClick(View view) {
                        Builder.this.O0000O0o.onClick(this.f5006O000000o, -1);
                    }
                });
            }
            if (builder.O0000OOo != null) {
                builder.btnNo.setOnClickListener(new View.OnClickListener(eMIConfirmDialog) {
                    /* class com.mi.global.shop.widget.dialog.EMIConfirmDialog.Builder.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ EMIConfirmDialog f5007O000000o;

                    {
                        this.f5007O000000o = r2;
                    }

                    public final void onClick(View view) {
                        Builder.this.O0000OOo.onClick(this.f5007O000000o, -2);
                    }
                });
            }
            eMIConfirmDialog.setContentView(inflate);
            this.O00000o = eMIConfirmDialog;
            EMIConfirmDialog eMIConfirmDialog2 = this.O00000o;
            if (BaseActivity.isActivityAlive(eMIConfirmDialog2.f5003O000000o)) {
                eMIConfirmDialog2.show();
            }
        }
    }

    public final void O000000o(String str) {
        StringBuilder sb;
        int i;
        this.O00000oo.O000000o();
        if (O00000o() != null) {
            Uri.Builder buildUpon = Uri.parse(cav.O000o0O0()).buildUpon();
            buildUpon.appendQueryParameter("id", this.O0000O0o);
            buildUpon.appendQueryParameter("bank", "mifinance");
            buildUpon.appendQueryParameter("type", "emi");
            buildUpon.appendQueryParameter("phonecode", str);
            if (this.f4839O000000o.status == 4) {
                sb = new StringBuilder();
                i = this.f4839O000000o.terms;
            } else {
                sb = new StringBuilder();
                i = O00000o().numberOfMonths;
            }
            sb.append(i);
            buildUpon.appendQueryParameter("terms", sb.toString());
            cam cam = new cam(buildUpon.toString(), NewLoanPayResult.class, null, new cak<NewLoanPayResult>() {
                /* class com.mi.global.shop.buy.CardlessEMIfragment.AnonymousClass5 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewLoanPayResult.Params params;
                    NewLoanPayResult newLoanPayResult = (NewLoanPayResult) baseResult;
                    CardlessEMIfragment.this.O00000oo.O00000Oo();
                    if (newLoanPayResult != null && newLoanPayResult.data != null && CardlessEMIfragment.this.getActivity() != null) {
                        if (TextUtils.isEmpty(newLoanPayResult.data.params) || (params = (NewLoanPayResult.Params) new Gson().fromJson(newLoanPayResult.data.params, NewLoanPayResult.Params.class)) == null || TextUtils.isEmpty(params.url)) {
                            CardlessEMIfragment.this.getActivity().finish();
                            return;
                        }
                        Intent intent = new Intent(CardlessEMIfragment.this.getActivity(), PayResultWebActivity.class);
                        intent.putExtra("url", params.url);
                        CardlessEMIfragment.this.getActivity().startActivityForResult(intent, 101);
                    }
                }

                public final void onErrorResponse(VolleyError volleyError) {
                    super.onErrorResponse(volleyError);
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    CardlessEMIfragment.this.O00000oo.O00000Oo();
                }
            });
            cam.setTag("CardlessEMIfragment");
            cam.setRetryPolicy(this.O0000OOo);
            ced.f13683O000000o.add(cam);
        }
    }

    /* access modifiers changed from: package-private */
    public final NewCardlessEMIPlanResult.CardlessEMIPlanOption O00000o() {
        List<NewCardlessEMIPlanResult.CardlessEMIPlanOption> list = this.O00000Oo;
        if (list == null) {
            return null;
        }
        for (NewCardlessEMIPlanResult.CardlessEMIPlanOption next : list) {
            if (next.isDefault) {
                return next;
            }
        }
        return null;
    }

    public void onDestroyView() {
        if (getActivity() != null) {
            getActivity().setTitle((int) R.string.buy_confirm_title);
        }
        super.onDestroyView();
    }

    public final void O00000oO() {
        this.O00000oo.O00000Oo();
        this.mPayNowBtn.setClickable(true);
        this.mPayNowBtn.setBackgroundColor(getResources().getColor(R.color.orange_red));
    }

    public final void O00000Oo() {
        Uri.Builder buildUpon = Uri.parse(cav.O000o00o()).buildUpon();
        cam cam = new cam(buildUpon.toString(), NewCreateLoanApplicationResult.class, new cak<NewCreateLoanApplicationResult>() {
            /* class com.mi.global.shop.buy.CardlessEMIfragment.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ void O000000o(BaseResult baseResult) {
            }

            public final void onErrorResponse(VolleyError volleyError) {
                super.onErrorResponse(volleyError);
            }

            public final void O000000o(String str) {
                super.O000000o(str);
            }
        });
        cam.setTag("CardlessEMIfragment");
        cam.setRetryPolicy(this.O0000OOo);
        ced.f13683O000000o.add(cam);
    }

    public final void O00000o0() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new CustomVerifyOTPDialog(getActivity(), this);
        }
        this.O0000Oo.O00000Oo = this.f4839O000000o.phoneNumber;
        CustomVerifyOTPDialog customVerifyOTPDialog = this.O0000Oo;
        if (BaseActivity.isActivityAlive(customVerifyOTPDialog.f4995O000000o)) {
            customVerifyOTPDialog.show();
            customVerifyOTPDialog.O000000o();
        }
    }
}
