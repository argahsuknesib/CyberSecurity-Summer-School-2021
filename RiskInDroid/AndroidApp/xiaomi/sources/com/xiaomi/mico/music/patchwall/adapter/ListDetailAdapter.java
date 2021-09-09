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
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListDetailAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, Music.Station> implements ItemClickableAdapter.OnItemClickListener {
    private String blockType;
    private final Context context;
    private List<Music.Station> stations;

    public ListDetailAdapter(Context context2, String str) {
        this.context = context2;
        this.blockType = str;
    }

    public void updateUiTypeAndDataList(List<Music.Station> list) {
        this.stations = list;
        updateDataList(list);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_block_detail_station_item, viewGroup, false), this.context);
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        viewHolder.registerItemClickEvent(this);
        ((ItemViewHolder) viewHolder).bindView((Music.Station) getData(i));
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        MusicHelper.processMusic(this.context, (Serializable) getData(i));
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        TextView author;
        TextView category;
        private final Context context;
        TextView desc;
        TextView episodes;
        ImageView image;
        private Music.Station station;
        ImageView tagRich;
        TextView text;
        TextView updateTime;

        public ItemViewHolder(View view, Context context2) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.music_item_image);
            this.text = (TextView) view.findViewById(R.id.music_item_title);
            this.author = (TextView) view.findViewById(R.id.patchwall_item_author);
            this.category = (TextView) view.findViewById(R.id.item_category);
            this.desc = (TextView) view.findViewById(R.id.music_item_description);
            this.updateTime = (TextView) view.findViewById(R.id.update_time);
            this.episodes = (TextView) view.findViewById(R.id.episodes);
            this.tagRich = (ImageView) view.findViewById(R.id.tag_rich);
            this.context = context2;
        }

        /* access modifiers changed from: package-private */
        public void bindView(Music.Station station2) {
            this.station = station2;
            MusicHelper.loadPatchWallCropSquareCover(station2.cover, this.image, R.drawable.img_cover_default_rectangle, MusicHelper.getDefaultCornerRadius(this.context));
            this.text.setText(station2.title);
            this.author.setText(station2.cpNameOrBoradcaster());
            int i = 0;
            this.category.setText(this.context.getString(R.string.music_category, station2.category));
            if (TextUtils.isEmpty(station2.albumAbstract)) {
                this.desc.setText(this.context.getString(R.string.music_desc_nothing));
            } else {
                this.desc.setText(this.context.getString(R.string.music_desc, station2.albumAbstract));
            }
            this.updateTime.setText(this.context.getString(R.string.music_update_time, updateTimeString(station2.updateTime)));
            this.episodes.setText(this.context.getString(R.string.music_episodes, String.valueOf(station2.episodes)));
            ImageView imageView = this.tagRich;
            if (station2.saleType <= 0) {
                i = 8;
            }
            imageView.setVisibility(i);
        }

        private String updateTimeString(long j) {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
        }
    }
}
