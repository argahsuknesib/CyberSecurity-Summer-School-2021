package com.xiaomi.mico.music.patchwall.adapter;

import _m_j.gpc;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.QQRankBlockAdapter;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.smarthome.R;
import java.util.List;

public class QQRankBlockAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    public static int borderRadius;
    private PatchWall.Block mBlock;
    private final Context mContext;
    FloorChildClickListener mFloorChildClickListener;

    public QQRankBlockAdapter(Context context, PatchWall.Block block) {
        this.mContext = context;
        updateUiTypeAndDataList(block);
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public QQRankBlockAdapter(Context context, PatchWall.Block block, FloorChildClickListener floorChildClickListener) {
        this.mContext = context;
        this.mFloorChildClickListener = floorChildClickListener;
        updateUiTypeAndDataList(block);
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public void updateUiTypeAndDataList(PatchWall.Block block) {
        this.mBlock = block;
        updateDataList(block.items);
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_qq_item_rank, viewGroup, false));
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        viewHolder.registerItemClickEvent(this);
        ((ItemViewHolder) viewHolder).bindView(this.mBlock, (PatchWall.Item) getData(i));
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        SchemaManager.handleSchema(this.mContext, ((PatchWall.Item) getData(i)).target);
        FloorChildClickListener floorChildClickListener = this.mFloorChildClickListener;
        if (floorChildClickListener != null) {
            floorChildClickListener.onClick(getData(i), i + 1);
        }
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private PatchWall.Block block;
        ImageView image;
        private int imageSize;
        private PatchWall.Item item;
        TextView textSongNameOne;
        TextView textSongNameThree;
        TextView textSongNameTwo;
        TextView textSongOneArtist;
        TextView textSongThreeArtist;
        TextView textSongTwoArtist;

        ItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.textSongNameOne = (TextView) view.findViewById(R.id.song_one_name);
            this.textSongOneArtist = (TextView) view.findViewById(R.id.song_one_artist);
            this.textSongNameTwo = (TextView) view.findViewById(R.id.song_two_name);
            this.textSongTwoArtist = (TextView) view.findViewById(R.id.song_two_artist);
            this.textSongNameThree = (TextView) view.findViewById(R.id.song_three_name);
            this.textSongThreeArtist = (TextView) view.findViewById(R.id.song_three_artist);
            view.findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$QQRankBlockAdapter$ItemViewHolder$QtXUWpoe0URVQTH__TmQGF8VZBc */

                public final void onClick(View view) {
                    QQRankBlockAdapter.ItemViewHolder.this.lambda$new$0$QQRankBlockAdapter$ItemViewHolder(view);
                }
            });
            this.imageSize = gpc.O00000o0(view.getContext(), 100.0f);
        }

        public /* synthetic */ void lambda$new$0$QQRankBlockAdapter$ItemViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block2, PatchWall.Item item2) {
            this.item = item2;
            this.block = block2;
            MusicHelper.loadCenterCover(item2.images.poster.url, R.drawable.mico_cover_patchwall_default_small_rectangle, R.drawable.mico_cover_patchwall_default_small_rectangle, this.image, new CropSquareTransformation(QQRankBlockAdapter.borderRadius), this.imageSize);
            List<PatchWall.Song> list = item2.songs;
            if (list == null || list.size() < 3) {
                this.textSongNameOne.setText("");
                this.textSongOneArtist.setText("");
                this.textSongNameTwo.setText("");
                this.textSongTwoArtist.setText("");
                this.textSongNameThree.setText("");
                this.textSongThreeArtist.setText("");
                return;
            }
            this.textSongNameOne.setText(list.get(0).name);
            String str = list.get(0).artist.name;
            if (!TextUtils.isEmpty(str)) {
                this.textSongOneArtist.setText(" - ".concat(String.valueOf(str)));
            } else {
                this.textSongOneArtist.setText("");
            }
            this.textSongNameTwo.setText(list.get(1).name);
            String str2 = list.get(1).artist.name;
            if (!TextUtils.isEmpty(str2)) {
                this.textSongTwoArtist.setText(" - ".concat(String.valueOf(str2)));
            } else {
                this.textSongTwoArtist.setText("");
            }
            this.textSongNameThree.setText(list.get(2).name);
            String str3 = list.get(2).artist.name;
            if (!TextUtils.isEmpty(str3)) {
                this.textSongThreeArtist.setText(" - ".concat(String.valueOf(str3)));
            } else {
                this.textSongThreeArtist.setText("");
            }
        }

        public void onClick() {
            SchemaManager.handleSchema(this.itemView.getContext(), HomepageSchemaHandler.buildPlaySheetSchema(this.item.target));
        }
    }
}
