package com.xiaomi.mico.music.patchwall.adapter;

import _m_j.gpc;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.QQSingerBlockAdapter;
import com.xiaomi.smarthome.R;

public class QQSingerBlockAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    private int cellWidth = ((gpc.O00000oO(this.mContext) - gpc.O00000o0(this.mContext, 54.0f)) / 3);
    private PatchWall.Block mBlock;
    private final Context mContext;

    public QQSingerBlockAdapter(Context context, PatchWall.Block block) {
        this.mContext = context;
        updateUiTypeAndDataList(block);
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
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_qq_item_singer, viewGroup, false), this.cellWidth);
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        ((ItemViewHolder) viewHolder).bindView(this.mBlock, (PatchWall.Item) getData(i));
    }

    public int getItemCount() {
        int dataSize = getDataSize();
        if (dataSize > 6) {
            return 6;
        }
        return dataSize;
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        SchemaManager.handleSchema(this.mContext, ((PatchWall.Item) getData(i)).target);
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private PatchWall.Block block;
        ImageView image;
        private PatchWall.Item item;
        TextView text;

        ItemViewHolder(View view, int i) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            view.findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$QQSingerBlockAdapter$ItemViewHolder$OJOYxZNJl5fTxHxkfp7aAmGWg1c */

                public final void onClick(View view) {
                    QQSingerBlockAdapter.ItemViewHolder.this.lambda$new$0$QQSingerBlockAdapter$ItemViewHolder(view);
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.image.getLayoutParams();
            layoutParams.height = i;
            this.image.setLayoutParams(layoutParams);
        }

        public /* synthetic */ void lambda$new$0$QQSingerBlockAdapter$ItemViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block2, PatchWall.Item item2) {
            this.item = item2;
            this.block = block2;
            MusicHelper.loadPatchWallCircleCover(item2.images.poster.url, this.image, R.drawable.cover_patchwall_default_circle);
            this.text.setText(item2.title);
            this.item = item2;
        }

        public void onClick() {
            SchemaManager.handleSchema(this.itemView.getContext(), HomepageSchemaHandler.buildPlaySheetSchema(this.item.target));
        }
    }
}
