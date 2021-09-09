package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.mico.music.patchwall.micoselect.SelectPagerListener;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;

public class ItemBinderTitle extends BaseItemBinder<TitleViewHolder> {
    SelectPagerListener mSelectPagerListener;

    public ItemBinderTitle(Context context, SelectPagerListener selectPagerListener) {
        super(context);
        this.mSelectPagerListener = selectPagerListener;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public TitleViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new TitleViewHolder(layoutInflater.inflate((int) R.layout.mico_select_view_patchwall_title, viewGroup, false));
    }

    class TitleViewHolder extends BaseItemBinder.ViewHolder {
        TextView desc;
        TextView more;
        TextView title;

        public TitleViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.patchwall_header_title);
            this.more = (TextView) view.findViewById(R.id.patchwall_header_more);
            this.desc = (TextView) view.findViewById(R.id.patchwall_header_desc);
        }

        public void updateData(final ViewSection viewSection, int i) {
            this.title.setText(viewSection.title);
            if (TextUtils.isEmpty(viewSection.titleType)) {
                this.more.setVisibility(8);
            } else {
                this.more.setVisibility(0);
                this.more.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderTitle.TitleViewHolder.AnonymousClass1 */

                    public void onClick(View view) {
                        if (ItemBinderTitle.this.mSelectPagerListener != null) {
                            ItemBinderTitle.this.mSelectPagerListener.switchMusicPage(viewSection.titleType);
                        }
                        TitleViewHolder.this.handleStatType(viewSection.titleType, viewSection.title);
                    }
                });
            }
            this.desc.setVisibility(4);
        }

        public void handleStatType(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.equals(str, "intelligent")) {
                    hxi.O00000o.O000000o(0, "", str2, 1);
                } else if (TextUtils.equals(str, "music")) {
                    hxi.O00000o.O000000o(0, "", str2, 2);
                } else if (TextUtils.equals(str, "kid")) {
                    hxi.O00000o.O000000o(0, "", str2, 4);
                } else if (TextUtils.equals(str, "audioBook")) {
                    hxi.O00000o.O000000o(0, "", str2, 5);
                } else if (TextUtils.equals(str, "dedao")) {
                    hxi.O00000o.O000000o(0, "", str2, 6);
                }
            }
        }
    }
}
