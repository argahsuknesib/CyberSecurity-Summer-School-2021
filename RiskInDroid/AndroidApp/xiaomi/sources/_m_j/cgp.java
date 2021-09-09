package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.pay.ui.PayListItem;
import com.mibi.sdk.pay.ui.imageloader.ImageHelper;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class cgp extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<RechargeType> f13784O000000o;
    private Context O00000Oo;

    public cgp(Context context, List<RechargeType> list) {
        this.O00000Oo = context;
        this.f13784O000000o = list;
    }

    public final int getCount() {
        List<RechargeType> list = this.f13784O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final Object getItem(int i) {
        return this.f13784O000000o.get(i);
    }

    public final long getItemId(int i) {
        if (this.f13784O000000o == null) {
            return 0;
        }
        return (long) i;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        PayListItem payListItem = view;
        if (view == null) {
            PayListItem payListItem2 = (PayListItem) LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.mibi_pay_type_list_item, viewGroup, false);
            if (i == 0) {
                payListItem2.findViewById(R.id.divider).setVisibility(8);
            }
            payListItem2.f5160O000000o = (ImageView) payListItem2.findViewById(R.id.icon);
            payListItem2.O00000Oo = (TextView) payListItem2.findViewById(R.id.label);
            payListItem2.O00000o0 = (TextView) payListItem2.findViewById(R.id.sub_label);
            payListItem = payListItem2;
        }
        PayListItem payListItem3 = (PayListItem) payListItem;
        RechargeType rechargeType = this.f13784O000000o.get(i);
        payListItem3.O00000o = rechargeType;
        if (rechargeType != null) {
            payListItem3.O00000Oo.setText(rechargeType.mTitle);
            if (!TextUtils.isEmpty(rechargeType.mTitleHint)) {
                payListItem3.O00000o0.setVisibility(0);
                payListItem3.O00000o0.setText(rechargeType.mTitleHint);
            }
            if (!TextUtils.isEmpty(rechargeType.mIcon)) {
                ImageHelper.get(payListItem3.getContext()).load(ImageHelper.getAbsoluteUrl(rechargeType.mIcon)).placeholder((int) R.drawable.mibi_ic_recharge_item_default).into(payListItem3.f5160O000000o);
            } else if (rechargeType.mLocalIconRes != -1) {
                payListItem3.f5160O000000o.setImageDrawable(payListItem3.getResources().getDrawable(rechargeType.mLocalIconRes));
            } else {
                payListItem3.f5160O000000o.setImageDrawable(payListItem3.getResources().getDrawable(R.drawable.mibi_ic_recharge_item_default));
            }
            return payListItem;
        }
        throw new IllegalArgumentException("mRechargeType in PayType should not be null");
    }
}
