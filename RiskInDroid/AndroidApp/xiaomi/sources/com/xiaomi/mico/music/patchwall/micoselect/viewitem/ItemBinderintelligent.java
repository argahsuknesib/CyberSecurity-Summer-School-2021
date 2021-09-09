package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
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
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderintelligent;
import com.xiaomi.smarthome.R;

public class ItemBinderintelligent extends BaseItemBinder<IntelligentViewHolder> {
    public static int borderRadius;

    public ItemBinderintelligent(Context context) {
        super(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public IntelligentViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new IntelligentViewHolder(layoutInflater.inflate((int) R.layout.mico_view_patch_intelligent, viewGroup, false));
    }

    class IntelligentViewHolder extends BaseItemBinder.ViewHolder {
        ImageView mBigViewImg;
        View mLeftView;
        ImageView mLeftViewImg;
        TextView mLeftViewSubTitle;
        TextView mLeftViewTitle;
        View mRightView;
        ImageView mRightViewImg;
        TextView mRightViewSubTitle;
        TextView mRightViewTitle;

        public IntelligentViewHolder(View view) {
            super(view);
            this.mBigViewImg = (ImageView) view.findViewById(R.id.mico_intelligent_row_one_img);
            this.mLeftViewImg = (ImageView) view.findViewById(R.id.mico_intelligent_column_two_left_img);
            this.mLeftViewTitle = (TextView) view.findViewById(R.id.mico_intelligent_row_two_left_title);
            this.mLeftViewSubTitle = (TextView) view.findViewById(R.id.mico_intelligent_row_two_left_subtitle);
            this.mLeftView = view.findViewById(R.id.mico_intelligent_column_left_layout);
            this.mRightViewImg = (ImageView) view.findViewById(R.id.mico_intelligent_column_two_right_img);
            this.mRightViewTitle = (TextView) view.findViewById(R.id.mico_intelligent_row_two_right_title);
            this.mRightViewSubTitle = (TextView) view.findViewById(R.id.mico_intelligent_row_two_right_subtitle);
            this.mRightView = view.findViewById(R.id.mico_intelligent_column_right_layout);
            ItemBinderintelligent.borderRadius = ItemBinderintelligent.this.getContext().getResources().getDimensionPixelSize(R.dimen.radius_12dp);
        }

        public void updateData(ViewSection viewSection, int i) {
            if (viewSection != null && viewSection.cards != null && viewSection.cards.size() > 0) {
                Card card = viewSection.cards.get(0);
                if (card != null) {
                    this.mBigViewImg.setOnClickListener(new View.OnClickListener(card) {
                        /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.$$Lambda$ItemBinderintelligent$IntelligentViewHolder$BeCYxjWQ_626knvQpnQNsZMw74 */
                        private final /* synthetic */ Card f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            ItemBinderintelligent.IntelligentViewHolder.this.lambda$updateData$0$ItemBinderintelligent$IntelligentViewHolder(this.f$1, view);
                        }
                    });
                    MusicHelper.loadPatchWallCropSquareCover(card.picture, this.mBigViewImg, R.drawable.mico_img_cover_default_singleimg, ItemBinderintelligent.borderRadius);
                }
                for (int i2 = 1; i2 < viewSection.cards.size(); i2++) {
                    if (i2 == 1) {
                        updateLeftChildView(viewSection.cards.get(1));
                    } else if (i2 == 2) {
                        updateRightChildView(viewSection.cards.get(2));
                    } else {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ void lambda$updateData$0$ItemBinderintelligent$IntelligentViewHolder(Card card, View view) {
            onClickView(card.jumpLink, 1);
        }

        private void onClickView(String str, int i) {
            MicoApplication.getInstance().getMicoHelperListener().jumpSmartHome(str, "");
            hxi.O00000o.O000000o(i, "", "", 1);
        }

        private void updateLeftChildView(Card card) {
            if (card != null) {
                MusicHelper.loadPatchWallCropSquareCover(card.picture, this.mLeftViewImg, R.drawable.mico_img_cover_default_row2img, ItemBinderintelligent.borderRadius);
                this.mLeftViewTitle.setText(card.mainTitle);
                this.mLeftViewSubTitle.setText(card.subTitle);
                this.mLeftView.setOnClickListener(new View.OnClickListener(card) {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.$$Lambda$ItemBinderintelligent$IntelligentViewHolder$6EF9D8fZE8TSYjz1rwZj7Oa24Z0 */
                    private final /* synthetic */ Card f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ItemBinderintelligent.IntelligentViewHolder.this.lambda$updateLeftChildView$1$ItemBinderintelligent$IntelligentViewHolder(this.f$1, view);
                    }
                });
                return;
            }
            MusicHelper.loadPatchWallCropSquareCover("", this.mLeftViewImg, R.drawable.mico_img_cover_default_row2img, ItemBinderintelligent.borderRadius);
            this.mLeftViewTitle.setText("");
            this.mLeftViewSubTitle.setText("");
            this.mLeftView.setOnClickListener(null);
        }

        public /* synthetic */ void lambda$updateLeftChildView$1$ItemBinderintelligent$IntelligentViewHolder(Card card, View view) {
            onClickView(card.jumpLink, 2);
        }

        private void updateRightChildView(Card card) {
            if (card != null) {
                MusicHelper.loadPatchWallCropSquareCover(card.picture, this.mRightViewImg, R.drawable.mico_img_cover_default_row2img, ItemBinderintelligent.borderRadius);
                this.mRightViewTitle.setText(card.mainTitle);
                this.mRightViewSubTitle.setText(card.subTitle);
                this.mRightView.setOnClickListener(new View.OnClickListener(card) {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.$$Lambda$ItemBinderintelligent$IntelligentViewHolder$0VBYGhPSx0JrTWafNmKcpmb1oNc */
                    private final /* synthetic */ Card f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ItemBinderintelligent.IntelligentViewHolder.this.lambda$updateRightChildView$2$ItemBinderintelligent$IntelligentViewHolder(this.f$1, view);
                    }
                });
                return;
            }
            MusicHelper.loadPatchWallCropSquareCover("", this.mRightViewImg, R.drawable.mico_img_cover_default_row2img, ItemBinderintelligent.borderRadius);
            this.mRightViewTitle.setText("");
            this.mRightViewSubTitle.setText("");
            this.mRightView.setOnClickListener(null);
        }

        public /* synthetic */ void lambda$updateRightChildView$2$ItemBinderintelligent$IntelligentViewHolder(Card card, View view) {
            onClickView(card.jumpLink, 3);
        }
    }
}
