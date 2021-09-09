package com.xiaomi.mico.music.viewholder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.smarthome.R;

public class HeaderViewHolder {

    public static class PlayAll extends ItemClickableAdapter.ViewHolder {
        TextView total = ((TextView) this.itemView.findViewById(R.id.music_play_all_total));

        public void bindView(Resources resources, int i) {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public PlayAll(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_play_all, viewGroup, false), onItemClickListener);
        }
    }

    public static class Comment extends ItemClickableAdapter.ViewHolder {
        TextView comment = ((TextView) this.itemView.findViewById(R.id.music_item_comment));

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public Comment(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener, String str) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_comment, viewGroup, false), onItemClickListener);
            this.comment.setText(str);
        }
    }

    public static class Expand extends ItemClickableAdapter.ViewHolder {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public Expand(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_expand, viewGroup, false), onItemClickListener);
        }
    }
}
