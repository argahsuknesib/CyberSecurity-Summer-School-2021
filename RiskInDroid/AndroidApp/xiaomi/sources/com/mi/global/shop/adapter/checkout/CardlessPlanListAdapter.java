package com.mi.global.shop.adapter.checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.newmodel.checkout.NewCardlessEMIPlanResult;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.Iterator;

public class CardlessPlanListAdapter extends ArrayAdapter<NewCardlessEMIPlanResult.CardlessEMIPlanOption> {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f4774O000000o = true;

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4776O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4776O000000o = viewHolder;
            viewHolder.mCardlessPlanChecked = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_cardless_plan_checked, "field 'mCardlessPlanChecked'", ImageView.class);
            viewHolder.mCardlessPlanContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_cardless_plan_container, "field 'mCardlessPlanContainer'", LinearLayout.class);
            viewHolder.mCardlessScheme = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_cardless_emi_scheme, "field 'mCardlessScheme'", CustomTextView.class);
            viewHolder.mCardlessPayment = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cardless_emi_down_payment, "field 'mCardlessPayment'", CustomTextView.class);
            viewHolder.mCardlessTotalAmount = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.cardless_emi_total_amount, "field 'mCardlessTotalAmount'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4776O000000o;
            if (viewHolder != null) {
                this.f4776O000000o = null;
                viewHolder.mCardlessPlanChecked = null;
                viewHolder.mCardlessPlanContainer = null;
                viewHolder.mCardlessScheme = null;
                viewHolder.mCardlessPayment = null;
                viewHolder.mCardlessTotalAmount = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        final NewCardlessEMIPlanResult.CardlessEMIPlanOption cardlessEMIPlanOption = (NewCardlessEMIPlanResult.CardlessEMIPlanOption) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (cardlessEMIPlanOption.isDefault) {
            viewHolder.mCardlessPlanContainer.setBackgroundResource(R.drawable.shop_cardless_plan_select_item_bg);
            viewHolder.mCardlessPlanChecked.setVisibility(0);
        } else {
            viewHolder.mCardlessPlanChecked.setVisibility(8);
            viewHolder.mCardlessPlanContainer.setBackgroundResource(R.drawable.shop_cardless_plan_item_bg);
        }
        CustomTextView customTextView = viewHolder.mCardlessScheme;
        customTextView.setText(cardlessEMIPlanOption.numberOfMonths + " " + this.O00000o.getResources().getString(R.string.cardless_emi_months));
        CustomTextView customTextView2 = viewHolder.mCardlessPayment;
        customTextView2.setText(this.O00000o.getResources().getString(R.string.cardless_emi_money) + " " + cardlessEMIPlanOption.totalMonthlyAmount);
        CustomTextView customTextView3 = viewHolder.mCardlessTotalAmount;
        customTextView3.setText(this.O00000o.getResources().getString(R.string.cardless_emi_money) + " " + cardlessEMIPlanOption.totalAmount);
        viewHolder.mCardlessPlanContainer.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.adapter.checkout.CardlessPlanListAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                if (CardlessPlanListAdapter.this.f4774O000000o) {
                    CardlessPlanListAdapter.this.O000000o();
                    cardlessEMIPlanOption.isDefault = true;
                    CardlessPlanListAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }

    public CardlessPlanListAdapter(Context context) {
        super(context);
    }

    public final void O000000o() {
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            ((NewCardlessEMIPlanResult.CardlessEMIPlanOption) it.next()).isDefault = false;
        }
    }

    static class ViewHolder {
        @BindView(2131493120)
        CustomTextView mCardlessPayment;
        @BindView(2131493535)
        ImageView mCardlessPlanChecked;
        @BindView(2131493667)
        LinearLayout mCardlessPlanContainer;
        @BindView(2131494187)
        CustomTextView mCardlessScheme;
        @BindView(2131493121)
        CustomTextView mCardlessTotalAmount;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_cardless_plan_list_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
