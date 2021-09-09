package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.smarthome.R;

public class ItemBinderImage extends BaseItemBinder<ImageViewHolder> {
    public static int borderRadius;

    public ItemBinderImage(Context context) {
        super(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public ImageViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ImageViewHolder(layoutInflater.inflate((int) R.layout.mico_select_patchwall_image, viewGroup, false));
    }

    class ImageViewHolder extends BaseItemBinder.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(View view) {
            super(view);
            ItemBinderImage.borderRadius = ItemBinderImage.this.getContext().getResources().getDimensionPixelSize(R.dimen.radius_12dp);
            this.imageView = (ImageView) view.findViewById(R.id.mico_intelligent_row_one_img);
        }

        public void updateData(final ViewSection viewSection, int i) {
            if (viewSection == null || viewSection.cards == null || viewSection.cards.size() <= 0) {
                MusicHelper.loadPatchWallCropSquareCover("", this.imageView, R.drawable.mico_img_cover_default_singleimg, ItemBinderImage.borderRadius);
                this.imageView.setVisibility(8);
            } else if (viewSection.cards.get(0) != null) {
                this.imageView.setVisibility(0);
                MusicHelper.loadPatchWallCropSquareCover(viewSection.cards.get(0).picture, this.imageView, R.drawable.mico_img_cover_default_singleimg, ItemBinderImage.borderRadius);
                this.imageView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderImage.ImageViewHolder.AnonymousClass1 */

                    public void onClick(View view) {
                        MicoApplication.getInstance().getMicoHelperListener().jumpSmartHome(viewSection.cards.get(0).jumpLink, "");
                    }
                });
            } else {
                this.imageView.setVisibility(8);
            }
        }
    }
}
