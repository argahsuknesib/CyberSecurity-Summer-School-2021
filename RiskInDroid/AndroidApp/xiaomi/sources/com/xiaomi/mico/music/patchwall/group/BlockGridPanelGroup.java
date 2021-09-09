package com.xiaomi.mico.music.patchwall.group;

import _m_j.gpc;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.smarthome.R;

public class BlockGridPanelGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> implements ItemClickableAdapter.OnItemClickListener {
    protected PatchWall.Block mBlock;

    public int getHeaderCount() {
        return 0;
    }

    public int getItemViewType(int i) {
        return 11;
    }

    public BlockGridPanelGroup(PatchWall.Block block) {
        this.mBlock = block;
    }

    public String getID() {
        return String.valueOf(this.mBlock.id);
    }

    public int getItemCount() {
        if (TextUtils.isEmpty(this.mBlock.items.get(0).images.poster.url)) {
            return 0;
        }
        return 1;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        ((BlockGridPanelViewHolder) viewHolder).bindView(this.mBlock);
        viewHolder.registerItemClickEvent(this);
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        SchemaManager.handleSchema(((BlockGridPanelViewHolder) viewHolder).imageView.getContext(), this.mBlock.items.get(0).target);
    }

    public static class BlockGridPanelViewHolder extends ItemClickableAdapter.ViewHolder {
        private int borderRadius = this.imageView.getContext().getResources().getDimensionPixelSize(R.dimen.radius_12dp);
        ImageView imageView;

        public BlockGridPanelViewHolder(View view) {
            super(view, null);
            this.imageView = (ImageView) view.findViewById(R.id.patchwall_block_grid_panel_image);
            double O00000oO = (double) (gpc.O00000oO(this.imageView.getContext()) - gpc.O00000o0(view.getContext(), 20.0f));
            Double.isNaN(O00000oO);
            ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
            layoutParams.height = (int) (O00000oO * 0.4d);
            this.imageView.setLayoutParams(layoutParams);
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block) {
            Picasso.get().load(block.items.get(0).images.poster.url).noFade().into(this.imageView);
        }
    }
}
