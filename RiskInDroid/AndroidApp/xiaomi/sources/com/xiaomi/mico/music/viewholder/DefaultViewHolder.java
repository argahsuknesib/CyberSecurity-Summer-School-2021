package com.xiaomi.mico.music.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import com.xiaomi.mico.music.viewholder.ItemViewHolder;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DefaultViewHolder {

    public static class Lovable extends ItemViewHolder.Lovable {
        TextView description = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));

        public Lovable(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener, LovableAdapter.Lovable lovable) {
            super(DefaultViewHolder.getItemView(viewGroup), onItemClickListener, lovable);
        }

        public void bindView(Serializable serializable) {
            MusicHelper.fillItem(serializable, this.title, this.description, this.image);
        }

        public void bindView(Serializable serializable, String str) {
            DefaultViewHolder.bindView(serializable, str, this.image, this.title, this.description);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
         arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, int, com.xiaomi.mico.common.transformation.CropSquareTransformation]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
          com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void */
        public void bindViewV2(Serializable serializable, String str) {
            boolean equals = CommonUtils.equals(MusicHelper.getID(serializable), str);
            boolean isLegal = MusicHelper.isLegal(serializable);
            this.title.setSelected(equals);
            this.description.setSelected(equals);
            boolean z = false;
            this.title.setEnabled(equals || isLegal);
            TextView textView = this.description;
            if (equals || isLegal) {
                z = true;
            }
            textView.setEnabled(z);
            this.title.setText(MusicHelper.getTitle(serializable));
            this.description.setText(MusicHelper.getDescription2(serializable));
            MusicHelper.loadCover(MusicHelper.getCover(serializable), this.image, (int) R.dimen.music_cover_size_medium, (int) R.dimen.music_cover_size_medium, (int) R.drawable.img_cover_default, true, (Transformation) new CropSquareTransformation());
        }
    }

    public static class Editable extends ItemViewHolder.Editable {
        TextView description = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));

        public Editable(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(DefaultViewHolder.getItemView(viewGroup), onItemClickListener, null);
        }

        public void bindView(Serializable serializable) {
            MusicHelper.fillItem(serializable, this.title, this.description, this.image);
        }

        public void bindView(Serializable serializable, String str) {
            DefaultViewHolder.bindView(serializable, str, this.image, this.title, this.description);
        }
    }

    public static class EditableStation extends ItemViewHolder.Editable {
        TextView author = ((TextView) this.itemView.findViewById(R.id.patchwall_item_author));
        TextView category = ((TextView) this.itemView.findViewById(R.id.item_category));
        public Context context;
        TextView desc = ((TextView) this.itemView.findViewById(R.id.music_item_description));
        TextView episodes = ((TextView) this.itemView.findViewById(R.id.episodes));
        ImageView image = ((ImageView) this.itemView.findViewById(R.id.music_item_image));
        public Music.Station station;
        ImageView tagRich = ((ImageView) this.itemView.findViewById(R.id.tag_rich));
        TextView title = ((TextView) this.itemView.findViewById(R.id.music_item_title));
        TextView updateTime = ((TextView) this.itemView.findViewById(R.id.update_time));

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public EditableStation(ViewGroup viewGroup, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_player_item_song_v2, viewGroup, false), onItemClickListener, null);
            this.context = viewGroup.getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.viewholder.DefaultViewHolder.EditableStation.AnonymousClass1 */

                public void onClick(View view) {
                    MusicHelper.processMusic(EditableStation.this.context, EditableStation.this.station);
                }
            });
        }

        public void bindView(Serializable serializable) {
            if (serializable instanceof Music.Station) {
                this.station = (Music.Station) serializable;
                MusicHelper.loadPatchWallCropSquareCover(this.station.cover, this.image, R.drawable.img_cover_default_rectangle, MusicHelper.getDefaultCornerRadius(this.context));
                this.title.setText(this.station.title);
                this.author.setText("");
                int i = 0;
                this.category.setText(this.context.getString(R.string.mico_music_category, this.station.cpNameOrBoradcaster(), this.station.category));
                if (TextUtils.isEmpty(this.station.albumAbstract)) {
                    this.desc.setText(this.context.getString(R.string.music_desc_nothing));
                } else {
                    this.desc.setText(this.context.getString(R.string.music_desc, this.station.albumAbstract));
                }
                this.updateTime.setText(this.context.getString(R.string.mico_music_update_time, DefaultViewHolder.updateTimeString(this.station.updateTime), String.valueOf(this.station.episodes)));
                this.episodes.setText("");
                ImageView imageView = this.tagRich;
                if (this.station.saleType <= 0) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
        }

        /* access modifiers changed from: protected */
        public void onPlay(List<Music.Station> list, int i, MusicHelper.OnPlayingListener onPlayingListener) {
            MusicHelper.playStations(list, i, onPlayingListener, this.station.stationID, this.station.isReverse);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static View getItemView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_item_default, viewGroup, false);
    }

    public static void bindView(Serializable serializable, String str, ImageView imageView, TextView textView, TextView textView2) {
        boolean equals = CommonUtils.equals(MusicHelper.getID(serializable), str);
        boolean isLegal = MusicHelper.isLegal(serializable);
        textView.setSelected(equals);
        textView2.setSelected(equals);
        boolean z = false;
        textView.setEnabled(equals || isLegal);
        if (equals || isLegal) {
            z = true;
        }
        textView2.setEnabled(z);
        MusicHelper.fillItem(serializable, textView, textView2, imageView);
    }

    public static String updateTimeString(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }
}
