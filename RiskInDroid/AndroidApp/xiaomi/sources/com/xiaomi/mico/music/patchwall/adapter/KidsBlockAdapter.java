package com.xiaomi.mico.music.patchwall.adapter;

import _m_j.gpc;
import android.content.Context;
import android.net.Uri;
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
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.smarthome.R;

public class KidsBlockAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    public static int borderRadius;
    public static int imageWidth;
    private PatchWall.Block mBlock;
    private final Context mContext;
    FloorChildClickListener mFloorChildClickListener;
    private int spanCount;

    public KidsBlockAdapter(Context context, String str) {
        this.mContext = context;
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public KidsBlockAdapter(Context context, String str, FloorChildClickListener floorChildClickListener) {
        this.mContext = context;
        this.mFloorChildClickListener = floorChildClickListener;
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public void updateUiTypeAndDataList(PatchWall.Block block) {
        this.mBlock = block;
        updateDataList(block.items);
        int i = block.blockUiType.columns;
        if (this.spanCount != i) {
            this.spanCount = i;
            imageWidth = ((gpc.O00000oO(this.mContext) - (gpc.O00000o0(this.mContext, 12.0f) * (i - 1))) - gpc.O00000o0(this.mContext, 30.0f)) / i;
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
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_kids_block_item, viewGroup, false));
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
            floorChildClickListener.onClick(((PatchWall.Item) getData(i)).target, i);
        }
    }

    class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private PatchWall.Block block;
        TextView desc;
        ImageView image;
        View imageContain;
        private PatchWall.Item item;
        View richTag;
        TextView text;

        ItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.desc = (TextView) view.findViewById(R.id.patchwall_item_desc);
            this.imageContain = view.findViewById(R.id.patchwall_item);
            this.richTag = view.findViewById(R.id.tag_rich);
            ViewGroup.LayoutParams layoutParams = this.imageContain.getLayoutParams();
            layoutParams.height = KidsBlockAdapter.imageWidth;
            layoutParams.width = KidsBlockAdapter.imageWidth;
            this.imageContain.setLayoutParams(layoutParams);
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block2, PatchWall.Item item2) {
            this.item = item2;
            this.block = block2;
            MusicHelper.loadPatchWallCropSquareCover(item2.images.poster.url, this.image, R.drawable.cover_patchwall_default_rectangle2, KidsBlockAdapter.borderRadius);
            this.richTag.setVisibility(showRichTag(item2) ? 0 : 8);
            if (!TextUtils.isEmpty(item2.title)) {
                this.text.setVisibility(0);
                this.text.setText(item2.title);
            } else {
                this.text.setVisibility(8);
            }
            if (!TextUtils.isEmpty(item2.shortDescription)) {
                this.desc.setVisibility(0);
                this.desc.setText(item2.shortDescription);
                return;
            }
            this.desc.setVisibility(8);
        }

        private boolean showRichTag(PatchWall.Item item2) {
            if (!TextUtils.isEmpty(item2.target)) {
                String queryParameter = Uri.parse(item2.target).getQueryParameter("saleType");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        if (Integer.parseInt(queryParameter) > 0) {
                            return true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return false;
        }
    }
}
