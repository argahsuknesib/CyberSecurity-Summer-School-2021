package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.BlockLayoutManager;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.smarthome.R;

public class BlockAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    public static int borderRadius;
    private PatchWall.Block mBlock;
    private boolean mCircle;
    private final Context mContext;
    private boolean mDisplayText;
    FloorChildClickListener mFloorChildClickListener;

    public BlockAdapter(Context context, boolean z, boolean z2, PatchWall.Block block) {
        this.mContext = context;
        updateUiTypeAndDataList(z, z2, block);
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public BlockAdapter(Context context, boolean z, boolean z2, PatchWall.Block block, FloorChildClickListener floorChildClickListener) {
        this.mContext = context;
        this.mFloorChildClickListener = floorChildClickListener;
        updateUiTypeAndDataList(z, z2, block);
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public void updateUiTypeAndDataList(boolean z, boolean z2, PatchWall.Block block) {
        this.mCircle = z;
        this.mDisplayText = z2;
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
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_item_v2, viewGroup, false));
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        viewHolder.registerItemClickEvent(this);
        View view = viewHolder.itemView;
        PatchWall.Item item = (PatchWall.Item) getData(i);
        PatchWall.Pos pos = item.itemUiType.pos;
        BlockLayoutManager.LayoutParams layoutParams = (BlockLayoutManager.LayoutParams) view.getLayoutParams();
        if (!(layoutParams.x == pos.x && layoutParams.y == pos.y && layoutParams.w == pos.w && layoutParams.h == pos.h)) {
            layoutParams.x = pos.x;
            layoutParams.y = pos.y;
            layoutParams.w = pos.w;
            layoutParams.h = pos.h;
            view.setLayoutParams(layoutParams);
        }
        ((ItemViewHolder) viewHolder).bindView(item, this.mCircle, this.mDisplayText);
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        SchemaManager.handleSchema(this.mContext, ((PatchWall.Item) getData(i)).target);
        FloorChildClickListener floorChildClickListener = this.mFloorChildClickListener;
        if (floorChildClickListener != null) {
            floorChildClickListener.onClick(getData(i), i);
        }
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        ImageView image;
        ImageView tagRich;
        TextView text;

        ItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.tagRich = (ImageView) view.findViewById(R.id.tag_rich);
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Item item, boolean z, boolean z2) {
            if (z) {
                MusicHelper.loadPatchWallCircleCover(item.images.poster.url, this.image, R.drawable.cover_patchwall_default_rectangle2);
            } else {
                MusicHelper.loadPatchWallCropSquareCover(item.images.poster.url, this.image, (int) R.drawable.img_cover_error_corner, (int) R.drawable.cover_patchwall_default_rectangle2, BlockAdapter.borderRadius);
            }
            this.tagRich.setVisibility(item.saleType > 0 ? 0 : 8);
            if (z2) {
                this.text.setVisibility(0);
                this.text.setText(item.title);
                return;
            }
            this.text.setVisibility(8);
        }
    }
}
