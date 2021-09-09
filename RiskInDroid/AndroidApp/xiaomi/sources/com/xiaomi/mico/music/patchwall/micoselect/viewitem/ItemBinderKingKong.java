package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.mico.music.patchwall.micoselect.model.Card;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class ItemBinderKingKong extends BaseItemBinder<KingKongViewHolder> {
    public ItemBinderKingKong(Context context) {
        super(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public KingKongViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new KingKongViewHolder(layoutInflater.inflate((int) R.layout.mico_intelligent_kingkong_view, viewGroup, false));
    }

    class KingKongViewHolder extends BaseItemBinder.ViewHolder {
        List<ViewGroup> mVewGroups = new ArrayList();
        int[] tabIds = {R.id.mico_tab1, R.id.mico_tab2, R.id.mico_tab3, R.id.mico_tab4};

        public KingKongViewHolder(View view) {
            super(view);
            for (int i = 0; i < 4; i++) {
                this.mVewGroups.add((ViewGroup) view.findViewById(this.tabIds[i]));
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void
         arg types: [java.lang.String, android.widget.ImageView, ?, int, int]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, int):void
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void */
        public void updateData(ViewSection viewSection, int i) {
            for (int i2 = 0; i2 < viewSection.cards.size(); i2++) {
                final Card card = viewSection.cards.get(i2);
                if (card != null) {
                    ViewGroup viewGroup = this.mVewGroups.get(i2);
                    viewGroup.setVisibility(0);
                    MusicHelper.loadPatchWallCropSquareCover(card.picture, (ImageView) viewGroup.getChildAt(0), (int) R.color.mj_color_gray_lighter, 0, true);
                    ((TextView) viewGroup.getChildAt(1)).setText(card.mainTitle);
                    viewGroup.setTag(Integer.valueOf(i2));
                    viewGroup.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderKingKong.KingKongViewHolder.AnonymousClass1 */

                        public void onClick(View view) {
                            MicoApplication.getInstance().getMicoHelperListener().jumpSmartHome(card.jumpLink, "");
                            hxk hxk = hxi.O00000o;
                            int intValue = ((Integer) view.getTag()).intValue();
                            String str = card.mainTitle;
                            hxk.f952O000000o.O000000o("content_recommend_guide", "position", Integer.valueOf(intValue), "name", str);
                        }
                    });
                }
            }
        }
    }
}
