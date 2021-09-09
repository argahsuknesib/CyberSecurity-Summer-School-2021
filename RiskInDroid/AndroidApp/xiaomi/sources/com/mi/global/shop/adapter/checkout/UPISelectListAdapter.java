package com.mi.global.shop.adapter.checkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class UPISelectListAdapter extends ArrayAdapter<String> {

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f4779O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f4779O000000o = viewHolder;
            viewHolder.mSelectedView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_selected, "field 'mSelectedView'", CustomTextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f4779O000000o;
            if (viewHolder != null) {
                this.f4779O000000o = null;
                viewHolder.mSelectedView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public final /* synthetic */ void O000000o(View view, int i, Object obj) {
        ((ViewHolder) view.getTag()).mSelectedView.setText((String) obj);
    }

    public UPISelectListAdapter(Context context) {
        super(context);
    }

    static class ViewHolder {
        @BindView(2131494263)
        CustomTextView mSelectedView;

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
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.shop_tez_upi_select_item, viewGroup, false);
        inflate.setTag(new ViewHolder(inflate));
        return inflate;
    }
}
