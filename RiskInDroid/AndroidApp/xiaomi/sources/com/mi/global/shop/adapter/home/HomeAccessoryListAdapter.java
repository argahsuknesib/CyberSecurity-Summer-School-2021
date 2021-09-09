package com.mi.global.shop.adapter.home;

import _m_j.cbq;
import _m_j.ccd;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EasyTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class HomeAccessoryListAdapter extends RecyclerView.O000000o<AccessoryViewHolder> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4780O000000o;
    List<NewHomeBlockInfoItem> O00000Oo = new ArrayList();

    public class AccessoryViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private AccessoryViewHolder f4782O000000o;

        public AccessoryViewHolder_ViewBinding(AccessoryViewHolder accessoryViewHolder, View view) {
            this.f4782O000000o = accessoryViewHolder;
            accessoryViewHolder.accessoryImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.accessory_image, "field 'accessoryImage'", SimpleDraweeView.class);
            accessoryViewHolder.accessoryName = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.accessory_name, "field 'accessoryName'", CustomTextView.class);
            accessoryViewHolder.accessoryPrize = (EasyTextView) Utils.findRequiredViewAsType(view, R.id.accessory_prize, "field 'accessoryPrize'", EasyTextView.class);
        }

        public void unbind() {
            AccessoryViewHolder accessoryViewHolder = this.f4782O000000o;
            if (accessoryViewHolder != null) {
                this.f4782O000000o = null;
                accessoryViewHolder.accessoryImage = null;
                accessoryViewHolder.accessoryName = null;
                accessoryViewHolder.accessoryPrize = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        AccessoryViewHolder accessoryViewHolder = (AccessoryViewHolder) o000OOo0;
        final NewHomeBlockInfoItem newHomeBlockInfoItem = this.O00000Oo.get(i);
        accessoryViewHolder.accessoryName.setText(newHomeBlockInfoItem.mProductName);
        accessoryViewHolder.accessoryPrize.setPrize(newHomeBlockInfoItem);
        cbq.O000000o(newHomeBlockInfoItem.getImageUrl(), accessoryViewHolder.accessoryImage);
        accessoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.adapter.home.HomeAccessoryListAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                ccd.O000000o(HomeAccessoryListAdapter.this.f4780O000000o, newHomeBlockInfoItem);
            }
        });
        ccd.O000000o(newHomeBlockInfoItem);
    }

    public HomeAccessoryListAdapter(Context context) {
        this.f4780O000000o = context;
    }

    public int getItemCount() {
        return this.O00000Oo.size();
    }

    static class AccessoryViewHolder extends RecyclerView.O000OOo0 {
        @BindView(2131492893)
        SimpleDraweeView accessoryImage;
        @BindView(2131492897)
        CustomTextView accessoryName;
        @BindView(2131492898)
        EasyTextView accessoryPrize;

        AccessoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AccessoryViewHolder(LayoutInflater.from(this.f4780O000000o).inflate((int) R.layout.shop_accessory_list_item, viewGroup, false));
    }
}
