package com.xiaomi.mico.music.patchwall.adapter;

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
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.smarthome.R;

public class DedaoBlockAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    public static int borderRadius;
    public static int imageWidth;
    private String blockType;
    private PatchWall.Block mBlock;
    private final Context mContext;
    FloorChildClickListener mFloorChildClickListener;
    private int spanCount;

    public DedaoBlockAdapter(Context context, String str) {
        this.mContext = context;
        this.blockType = str;
        borderRadius = MusicHelper.getDefaultCornerRadius(context);
    }

    public DedaoBlockAdapter(Context context, String str, FloorChildClickListener floorChildClickListener) {
        this.mContext = context;
        this.mFloorChildClickListener = floorChildClickListener;
        this.blockType = str;
        borderRadius = MusicHelper.getDefaultCornerRadius(context);
    }

    public void updateUiTypeAndDataList(PatchWall.Block block) {
        this.mBlock = block;
        updateDataList(block.items);
        int i = block.blockUiType.columns;
        if (this.spanCount != i) {
            this.spanCount = i;
            imageWidth = ((DisplayUtils.getScreenWidthPixels(this.mContext) - (DisplayUtils.dip2px(this.mContext, 12.0f) * (i - 1))) - DisplayUtils.dip2px(this.mContext, 30.0f)) / i;
        }
    }

    public void updateSelectUiTypeAndDataList(PatchWall.Block block) {
        this.mBlock = block;
        updateDataList(block.items);
        int i = block.blockUiType.columns;
        if (this.spanCount != i) {
            this.spanCount = i;
            imageWidth = ((DisplayUtils.getScreenWidthPixels(this.mContext) - (DisplayUtils.dip2px(this.mContext, 12.0f) * (i - 1))) - DisplayUtils.dip2px(this.mContext, 30.0f)) / i;
        }
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
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_dedao_block_item, viewGroup, false));
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        viewHolder.registerItemClickEvent(this);
        ((ItemViewHolder) viewHolder).bindView(this.mBlock, (PatchWall.Item) getData(i));
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        PatchWall.Item item = (PatchWall.Item) getData(i);
        if (item != null) {
            FloorChildClickListener floorChildClickListener = this.mFloorChildClickListener;
            if (floorChildClickListener != null) {
                floorChildClickListener.onClick(item, i);
            }
            SchemaManager.handleSchema(this.mContext, item.target);
        }
    }

    class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private int cornerSize;
        ImageView image;
        View imageContain;
        View richTag;
        TextView text;

        ItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.imageContain = view.findViewById(R.id.patchwall_item);
            this.richTag = view.findViewById(R.id.tag_rich);
            ViewGroup.LayoutParams layoutParams = this.imageContain.getLayoutParams();
            layoutParams.height = DedaoBlockAdapter.imageWidth;
            layoutParams.width = DedaoBlockAdapter.imageWidth;
            this.imageContain.setLayoutParams(layoutParams);
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block, PatchWall.Item item) {
            MusicHelper.loadCenterCover(item.images.poster.url, R.drawable.mico_cover_patchwall_default_small_rectangle, R.drawable.mico_cover_patchwall_default_small_rectangle, this.image, new CropSquareTransformation(DedaoBlockAdapter.borderRadius), DedaoBlockAdapter.imageWidth);
            this.richTag.setVisibility(item.saleType > 0 ? 0 : 8);
            if (!TextUtils.isEmpty(item.title)) {
                this.text.setVisibility(0);
                this.text.setText(item.title);
                return;
            }
            this.text.setVisibility(8);
        }
    }
}
