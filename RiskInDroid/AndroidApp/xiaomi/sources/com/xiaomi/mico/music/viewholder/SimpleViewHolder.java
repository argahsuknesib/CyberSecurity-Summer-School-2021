package com.xiaomi.mico.music.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class SimpleViewHolder {

    public static class Normal extends ItemClickableAdapter.ViewHolder {
        TextView description = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));

        /* access modifiers changed from: protected */
        public boolean needTransparentBackground() {
            return false;
        }

        public Normal(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(SimpleViewHolder.getItemView(viewGroup), onItemClickListener);
            if (needTransparentBackground()) {
                this.itemView.setBackgroundResource(R.drawable.bg_list_selector_transparent);
            }
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            layoutParams.height = getItemHeight(viewGroup.getContext());
            this.itemView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.image.getLayoutParams();
            int imageSize = getImageSize(viewGroup.getContext());
            layoutParams2.height = imageSize;
            layoutParams2.width = imageSize;
            this.image.setLayoutParams(layoutParams2);
        }

        /* access modifiers changed from: protected */
        public int getItemHeight(Context context) {
            return context.getResources().getDimensionPixelSize(R.dimen.music_item_height_1);
        }

        /* access modifiers changed from: protected */
        public int getImageSize(Context context) {
            return context.getResources().getDimensionPixelSize(R.dimen.music_cover_size_medium);
        }

        public void bindView(Serializable serializable) {
            if (serializable != null) {
                MusicHelper.fillItem(serializable, this.title, this.description, this.image, this instanceof Small);
                this.description.setVisibility(0);
                return;
            }
            this.image.setImageResource(R.drawable.img_add_channel);
            this.title.setText((int) R.string.music_channel_new);
            this.description.setVisibility(8);
        }

        public void bindView(Music.SectionData sectionData) {
            MusicHelper.fillItem(sectionData, this.title, this.description, this.image);
        }

        public void bindView(PatchWall.Item item) {
            MusicHelper.fillItem(item, this.title, this.description, this.image);
        }
    }

    public static class Small extends Normal {
        public Small(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(viewGroup, onItemClickListener);
        }

        /* access modifiers changed from: protected */
        public int getItemHeight(Context context) {
            return context.getResources().getDimensionPixelSize(R.dimen.music_item_height_2);
        }

        /* access modifiers changed from: protected */
        public int getImageSize(Context context) {
            return context.getResources().getDimensionPixelSize(R.dimen.music_cover_size_small);
        }
    }

    public static class Nano extends Small {
        /* access modifiers changed from: protected */
        public boolean needTransparentBackground() {
            return true;
        }

        public Nano(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(viewGroup, onItemClickListener);
        }

        /* access modifiers changed from: protected */
        public int getItemHeight(Context context) {
            return context.getResources().getDimensionPixelSize(R.dimen.music_item_height_3);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static View getItemView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_simple, viewGroup, false);
    }
}
