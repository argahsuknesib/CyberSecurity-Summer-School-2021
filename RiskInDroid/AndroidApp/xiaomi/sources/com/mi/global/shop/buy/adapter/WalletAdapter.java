package com.mi.global.shop.buy.adapter;

import _m_j.bzi;
import _m_j.cbl;
import _m_j.cbq;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class WalletAdapter extends RecyclerView.O000000o<WalletViewHolder> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<bzi.O00000Oo> f4859O000000o = new ArrayList<>();
    private Context O00000Oo;

    public class WalletViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private WalletViewHolder f4861O000000o;

        public WalletViewHolder_ViewBinding(WalletViewHolder walletViewHolder, View view) {
            this.f4861O000000o = walletViewHolder;
            walletViewHolder.itemLogo = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.item_logo, "field 'itemLogo'", SimpleDraweeView.class);
            walletViewHolder.itemHint = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_hint, "field 'itemHint'", CustomTextView.class);
            walletViewHolder.itemBg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.item_bg, "field 'itemBg'", LinearLayout.class);
        }

        public void unbind() {
            WalletViewHolder walletViewHolder = this.f4861O000000o;
            if (walletViewHolder != null) {
                this.f4861O000000o = null;
                walletViewHolder.itemLogo = null;
                walletViewHolder.itemHint = null;
                walletViewHolder.itemBg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        WalletViewHolder walletViewHolder = (WalletViewHolder) o000OOo0;
        bzi.O00000Oo o00000Oo = this.f4859O000000o.get(i);
        if (!TextUtils.isEmpty(o00000Oo.O00000oO)) {
            cbq.O000000o(cbl.O000000o(o00000Oo.O00000oO), walletViewHolder.itemLogo);
        }
        if (TextUtils.isEmpty(o00000Oo.O00000Oo)) {
            walletViewHolder.itemHint.setVisibility(8);
        } else {
            walletViewHolder.itemHint.setText(o00000Oo.O00000Oo);
            walletViewHolder.itemHint.setVisibility(0);
        }
        if (o00000Oo.O0000OOo) {
            walletViewHolder.itemBg.setBackgroundResource(R.drawable.shop_wallet_select_bg);
        } else {
            walletViewHolder.itemBg.setBackgroundResource(R.drawable.shop_rectangle_grey_border_bold);
        }
        walletViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.buy.adapter.WalletAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                for (int i = 0; i < WalletAdapter.this.f4859O000000o.size(); i++) {
                    if (i == i) {
                        WalletAdapter.this.f4859O000000o.get(i).O0000OOo = true;
                    } else {
                        WalletAdapter.this.f4859O000000o.get(i).O0000OOo = false;
                    }
                }
                WalletAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public WalletAdapter(Context context) {
        this.O00000Oo = context;
    }

    public int getItemCount() {
        return this.f4859O000000o.size();
    }

    static class WalletViewHolder extends RecyclerView.O000OOo0 {
        @BindView(2131493504)
        LinearLayout itemBg;
        @BindView(2131493512)
        CustomTextView itemHint;
        @BindView(2131493515)
        SimpleDraweeView itemLogo;

        WalletViewHolder(View view) {
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
        return new WalletViewHolder(LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.shop_pay_wallet_item, viewGroup, false));
    }
}
