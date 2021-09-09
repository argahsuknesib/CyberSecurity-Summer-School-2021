package com.mi.global.shop.adapter.checkout;

import _m_j.bzi;
import _m_j.cbl;
import _m_j.cbq;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class UPIListAdapter extends ArrayAdapter<bzi.O00000Oo> {

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4778O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4778O000000o = viewHolder;
            viewHolder.mUpiChecked = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_upi_checked, "field 'mUpiChecked'", ImageView.class);
            viewHolder.mUpiContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_upi_container, "field 'mUpiContainer'", LinearLayout.class);
            viewHolder.logoView = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.sv_logo, "field 'logoView'", SimpleDraweeView.class);
            viewHolder.itemHint = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_hint, "field 'itemHint'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4778O000000o;
            if (viewHolder != null) {
                this.f4778O000000o = null;
                viewHolder.mUpiChecked = null;
                viewHolder.mUpiContainer = null;
                viewHolder.logoView = null;
                viewHolder.itemHint = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        bzi.O00000Oo o00000Oo = (bzi.O00000Oo) obj;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (o00000Oo.O0000OOo) {
            viewHolder.mUpiContainer.setBackgroundResource(R.drawable.shop_cardless_plan_select_item_bg);
            viewHolder.mUpiChecked.setVisibility(0);
        } else {
            viewHolder.mUpiChecked.setVisibility(8);
            viewHolder.mUpiContainer.setBackgroundResource(R.drawable.shop_cardless_plan_item_bg);
        }
        if (!TextUtils.isEmpty(o00000Oo.O00000oO)) {
            cbq.O000000o(cbl.O000000o(o00000Oo.O00000oO), viewHolder.logoView);
        }
        if (TextUtils.isEmpty(o00000Oo.O00000Oo)) {
            viewHolder.itemHint.setVisibility(8);
            return;
        }
        viewHolder.itemHint.setText(o00000Oo.O00000Oo);
        viewHolder.itemHint.setVisibility(0);
    }

    public UPIListAdapter(Context context) {
        super(context);
    }

    static class ViewHolder {
        @BindView(2131493512)
        CustomTextView itemHint;
        @BindView(2131494070)
        SimpleDraweeView logoView;
        @BindView(2131493572)
        ImageView mUpiChecked;
        @BindView(2131493683)
        LinearLayout mUpiContainer;

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
        View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_tez_upi_list_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
