package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.TimeUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class BlockStationListAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, Music.Station> implements ItemClickableAdapter.OnItemClickListener {
    private Context context;

    public BlockStationListAdapter(Context context2) {
        this.context = context2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_item_station, viewGroup, false), this);
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        MusicHelper.processMusic(this.context, (Serializable) getData(i));
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        ((ItemViewHolder) viewHolder).bindView((Music.Station) getData(i));
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        TextView author = ((TextView) this.itemView.findViewById(R.id.patchwall_item_author));
        TextView category = ((TextView) this.itemView.findViewById(R.id.item_category));
        private Context context;
        TextView desc = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        TextView episodes = ((TextView) this.itemView.findViewById(R.id.episodes));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        private int imageSize;
        ImageView tagRich = ((ImageView) this.itemView.findViewById(R.id.tag_rich));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));
        TextView updateTime = ((TextView) this.itemView.findViewById(R.id.update_time));

        public ItemViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(view, onItemClickListener);
            this.context = view.getContext();
            this.imageSize = DisplayUtils.dip2px(this.context, 110.0f);
        }

        public void bindView(Music.Station station) {
            MusicHelper.loadCenterCover(station.cover, R.drawable.img_cover_error_corner, R.drawable.cover_patchwall_default_rectangle, this.image, new CropSquareTransformation(), this.imageSize);
            this.title.setText(station.title);
            this.author.setText(station.cpNameOrBoradcaster());
            int i = 0;
            if (!TextUtils.isEmpty(station.category)) {
                this.category.setText(this.context.getString(R.string.music_category, station.category));
            } else {
                this.category.setText("");
            }
            if (TextUtils.isEmpty(station.albumAbstract)) {
                this.desc.setText(this.context.getString(R.string.music_desc_nothing));
            } else {
                this.desc.setText(this.context.getString(R.string.music_desc, station.albumAbstract));
            }
            this.updateTime.setText(this.context.getString(R.string.music_update_time, TimeUtil.updateTimeString(station.updateTime)));
            this.episodes.setText(this.context.getString(R.string.music_episodes, String.valueOf(station.episodes)));
            ImageView imageView = this.tagRich;
            if (station.saleType <= 0) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }
}
