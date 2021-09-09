package com.mi.global.shop.activity;

import _m_j.cas;
import _m_j.cav;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mi.global.shop.adapter.DeliveryPopAdapter;
import com.mi.global.shop.newmodel.user.address.FourDeliveryData;
import com.mi.global.shop.newmodel.user.address.SmartBoxData;
import com.mi.global.shop.newmodel.user.address.SmartDetailItemData;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.PopSpinnerView;
import com.mi.global.shop.widget.dialog.CustomCloseDialog;
import com.xiaomi.smarthome.R;
import java.util.Iterator;

public class DeliveryActivity extends BaseActivity {
    private static final String O00000oo = "DeliveryActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    SmartBoxData f4613O000000o;
    FourDeliveryData O00000Oo;
    SmartDetailItemData O00000o;
    String O00000o0;
    String O00000oO;
    @BindView(2131493024)
    View btnConfirm;
    @BindView(2131493365)
    CheckBox deliveryCheckBox;
    @BindView(2131493258)
    CustomTextView deliveryFouHour;
    @BindView(2131493259)
    CustomTextView deliveryHome;
    @BindView(2131493260)
    View deliveryNoticeView;
    @BindView(2131493261)
    CustomTextView deliverySmartBox;
    @BindView(2131493366)
    ImageView deliveryView;
    public String exchangeCouponId;
    @BindView(2131493963)
    View fourHourDelivery;
    @BindView(2131493368)
    CustomTextView fourHourPrice;
    public volatile int mode = 0;
    @BindView(2131493909)
    PopSpinnerView popSpinnerView;
    public CustomCloseDialog questionMarkDialog;
    @BindView(2131493967)
    View smartBox;
    @BindView(2131494265)
    CustomTextView smartBoxConditions;
    @BindView(2131494266)
    CustomTextView smartExplain;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_delivery);
        ButterKnife.bind(this);
        setTitle(getString(R.string.devivery_service));
        this.mBackView.setVisibility(0);
        this.mCartView.setVisibility(4);
        this.mode = getIntent().getIntExtra("mode", 0);
        this.f4613O000000o = (SmartBoxData) getIntent().getSerializableExtra("delivery_smart");
        this.O00000Oo = (FourDeliveryData) getIntent().getSerializableExtra("delivery_fourhour");
        this.O00000o0 = getIntent().getStringExtra("currency");
        this.O00000oO = getIntent().getStringExtra("smartbox_id");
        this.exchangeCouponId = getIntent().getStringExtra("coupon_id");
        SmartBoxData smartBoxData = this.f4613O000000o;
        if (smartBoxData != null && smartBoxData.smartDetailListData.size() > 0) {
            if (TextUtils.isEmpty(this.O00000oO)) {
                this.O00000oO = this.f4613O000000o.defaultid;
            }
            final SmartBoxData smartBoxData2 = this.f4613O000000o;
            this.deliverySmartBox.setVisibility(0);
            this.deliverySmartBox.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass6 */

                public final void onClick(View view) {
                    DeliveryActivity.this.deliverySmartBox.setBackgroundResource(R.drawable.shop_bg_tv_selector);
                    DeliveryActivity.this.deliverySmartBox.setTextColor(DeliveryActivity.this.getResources().getColor(R.color.delivery_selected));
                    DeliveryActivity.this.deliveryHome.setBackgroundResource(R.drawable.shop_bg_tv_unselector);
                    DeliveryActivity.this.deliveryHome.setTextColor(DeliveryActivity.this.getResources().getColor(R.color.delivery_unselected));
                    DeliveryActivity.this.fourHourDelivery.setVisibility(8);
                    DeliveryActivity.this.smartBox.setVisibility(0);
                }
            });
            this.smartExplain.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass7 */

                public final void onClick(View view) {
                    CustomCloseDialog.Builder builder = new CustomCloseDialog.Builder(DeliveryActivity.this);
                    builder.f4987O000000o = smartBoxData2.title;
                    builder.O00000Oo = smartBoxData2.explain;
                    builder.O00000Oo(Boolean.FALSE).O000000o(Boolean.TRUE);
                    DeliveryActivity.this.questionMarkDialog = builder.O000000o();
                    DeliveryActivity.this.questionMarkDialog.show();
                }
            });
            PopSpinnerView popSpinnerView2 = this.popSpinnerView;
            DeliveryPopAdapter deliveryPopAdapter = new DeliveryPopAdapter(this, smartBoxData2.smartDetailListData, this.O00000oO);
            AnonymousClass8 r3 = new PopSpinnerView.O000000o() {
                /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass8 */

                public final String O000000o(int i) {
                    DeliveryActivity.this.O00000o = smartBoxData2.smartDetailListData.get(i);
                    return smartBoxData2.smartDetailListData.get(i).shortName;
                }
            };
            popSpinnerView2.O00000o = deliveryPopAdapter;
            popSpinnerView2.O00000oO = r3;
            Iterator<SmartDetailItemData> it = smartBoxData2.smartDetailListData.iterator();
            while (it.hasNext()) {
                SmartDetailItemData next = it.next();
                if (next.id.equals(this.O00000oO)) {
                    this.O00000o = next;
                    this.popSpinnerView.setContent(next.shortName);
                    this.popSpinnerView.setSelectId(next.id);
                }
            }
        }
        final FourDeliveryData fourDeliveryData = this.O00000Oo;
        if (fourDeliveryData != null) {
            this.fourHourDelivery.setVisibility(0);
            this.deliveryFouHour.setText(fourDeliveryData.brief);
            if (cas.O000000o(fourDeliveryData.amount, 0.0f) > 0.0f || TextUtils.isEmpty(fourDeliveryData.no_amount)) {
                CustomTextView customTextView = this.fourHourPrice;
                customTextView.setText(this.O00000o0 + fourDeliveryData.amount);
            } else {
                this.fourHourPrice.setText(fourDeliveryData.no_amount);
            }
            this.deliveryCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass9 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        DeliveryActivity.this.deliveryNoticeView.setBackgroundResource(R.drawable.shop_bg_tv_selector);
                        DeliveryActivity.this.mode = 1;
                        return;
                    }
                    DeliveryActivity.this.deliveryNoticeView.setBackgroundResource(R.drawable.shop_bg_tv_unselector);
                    DeliveryActivity.this.mode = 0;
                }
            });
            this.deliveryNoticeView.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass10 */

                public final void onClick(View view) {
                    if (DeliveryActivity.this.deliveryCheckBox.isChecked()) {
                        DeliveryActivity.this.deliveryCheckBox.setChecked(false);
                    } else {
                        DeliveryActivity.this.deliveryCheckBox.setChecked(true);
                    }
                }
            });
            this.deliveryView.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    CustomCloseDialog.Builder builder = new CustomCloseDialog.Builder(DeliveryActivity.this);
                    builder.f4987O000000o = fourDeliveryData.title;
                    builder.O00000Oo = fourDeliveryData.description;
                    builder.O00000Oo(Boolean.FALSE).O000000o(Boolean.TRUE);
                    DeliveryActivity.this.questionMarkDialog = builder.O000000o();
                    DeliveryActivity.this.questionMarkDialog.show();
                }
            });
        }
        this.deliveryHome.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass1 */

            public final void onClick(View view) {
                if (DeliveryActivity.this.deliveryCheckBox.isChecked()) {
                    DeliveryActivity.this.mode = 1;
                } else {
                    DeliveryActivity.this.mode = 0;
                }
                DeliveryActivity.this.deliveryHome.setBackgroundResource(R.drawable.shop_bg_tv_selector);
                DeliveryActivity.this.deliveryHome.setTextColor(DeliveryActivity.this.getResources().getColor(R.color.delivery_selected));
                DeliveryActivity.this.deliverySmartBox.setBackgroundResource(R.drawable.shop_bg_tv_unselector);
                DeliveryActivity.this.deliverySmartBox.setTextColor(DeliveryActivity.this.getResources().getColor(R.color.delivery_unselected));
                DeliveryActivity.this.smartBox.setVisibility(8);
                if (DeliveryActivity.this.O00000Oo != null) {
                    DeliveryActivity.this.fourHourDelivery.setVisibility(0);
                }
            }
        });
        this.deliverySmartBox.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass3 */

            public final void onClick(View view) {
                DeliveryActivity deliveryActivity = DeliveryActivity.this;
                deliveryActivity.mode = 2;
                deliveryActivity.deliverySmartBox.setBackgroundResource(R.drawable.shop_bg_tv_selector);
                DeliveryActivity.this.deliverySmartBox.setTextColor(DeliveryActivity.this.getResources().getColor(R.color.delivery_selected));
                DeliveryActivity.this.deliveryHome.setBackgroundResource(R.drawable.shop_bg_tv_unselector);
                DeliveryActivity.this.deliveryHome.setTextColor(DeliveryActivity.this.getResources().getColor(R.color.delivery_unselected));
                DeliveryActivity.this.fourHourDelivery.setVisibility(8);
                DeliveryActivity.this.smartBox.setVisibility(0);
            }
        });
        this.btnConfirm.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(DeliveryActivity.this.exchangeCouponId)) {
                    if (DeliveryActivity.this.mode == 1) {
                        DeliveryActivity deliveryActivity = DeliveryActivity.this;
                        deliveryActivity.handleExchangeInvalid(deliveryActivity.getString(R.string.exchange_coupon_invalid_by_delivery_dialog_title));
                        return;
                    } else if (DeliveryActivity.this.mode == 2) {
                        DeliveryActivity deliveryActivity2 = DeliveryActivity.this;
                        deliveryActivity2.handleExchangeInvalid(deliveryActivity2.getString(R.string.exchange_coupon_invalid_by_smart_box_dialog_title));
                        return;
                    }
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("mode", DeliveryActivity.this.mode);
                if (DeliveryActivity.this.mode == 2) {
                    bundle.putSerializable("smart_selected", DeliveryActivity.this.O00000o);
                }
                intent.putExtras(bundle);
                DeliveryActivity.this.setResult(-1, intent);
                DeliveryActivity.this.finish();
            }
        });
        updateUI();
    }

    public void handleExchangeInvalid(String str) {
        CustomCloseDialog.Builder builder = new CustomCloseDialog.Builder(this);
        builder.O00000Oo = str;
        builder.O000000o(Boolean.TRUE);
        CustomCloseDialog O000000o2 = builder.O000000o();
        if (!O000000o2.isShowing()) {
            O000000o2.show();
        }
    }

    public void updateUI() {
        if (this.mode == 1) {
            this.deliveryCheckBox.setChecked(true);
        } else if (this.mode == 2) {
            this.deliverySmartBox.setBackgroundResource(R.drawable.shop_bg_tv_selector);
            this.deliverySmartBox.setTextColor(getResources().getColor(R.color.delivery_selected));
            this.deliveryHome.setBackgroundResource(R.drawable.shop_bg_tv_unselector);
            this.deliveryHome.setTextColor(getResources().getColor(R.color.delivery_unselected));
            this.fourHourDelivery.setVisibility(8);
            this.smartBox.setVisibility(0);
        }
        SpannableString spannableString = new SpannableString(getString(R.string.smart_box_terms_conditions));
        spannableString.setSpan(new ClickableSpan() {
            /* class com.mi.global.shop.activity.DeliveryActivity.AnonymousClass5 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#888888"));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                Intent intent = new Intent(DeliveryActivity.this, WebActivity.class);
                intent.putExtra("url", cav.O00oOooO);
                DeliveryActivity.this.startActivity(intent);
            }
        }, 60, 80, 33);
        spannableString.setSpan(new UnderlineSpan(), 60, 80, 33);
        this.smartBoxConditions.setText(spannableString);
        this.smartBoxConditions.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        CustomCloseDialog customCloseDialog = this.questionMarkDialog;
        if (customCloseDialog != null) {
            customCloseDialog.dismiss();
        }
        super.onDestroy();
    }
}
