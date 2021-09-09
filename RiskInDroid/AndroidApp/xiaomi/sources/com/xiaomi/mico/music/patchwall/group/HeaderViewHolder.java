package com.xiaomi.mico.music.patchwall.group;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.patchwall.BlockDetailActivity;
import com.xiaomi.mico.music.patchwall.BlockDetailActivityV2;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class HeaderViewHolder extends ItemClickableAdapter.ViewHolder {
    PatchWall.Block block;
    String blockType;
    TextView desc;
    View more;
    TextView title;

    public HeaderViewHolder(View view, String str) {
        super(view, null);
        this.title = (TextView) view.findViewById(R.id.patchwall_header_title);
        this.more = view.findViewById(R.id.patchwall_header_more);
        this.desc = (TextView) view.findViewById(R.id.patchwall_header_desc);
        this.blockType = str;
        this.more.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.patchwall.group.HeaderViewHolder.AnonymousClass1 */

            public void onClick(View view) {
                HeaderViewHolder.this.onClick();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onClick() {
        Intent intent;
        if (!ApiConstants.isAreaCodeInCN() || !this.blockType.equals("block_type_audio_boox")) {
            intent = new Intent(this.itemView.getContext(), BlockDetailActivity.class);
            intent.putExtra("block_id", this.block.id);
            intent.putExtra("block_title", this.block.title);
            intent.putExtra("block_type", this.blockType);
            intent.putExtra("category_type", this.block.categoryType);
            if (this.block.cpList != null) {
                intent.putStringArrayListExtra("block_cp_list", (ArrayList) this.block.cpList);
            }
        } else {
            intent = new Intent(this.itemView.getContext(), BlockDetailActivityV2.class);
            intent.putExtra("block_id", this.block.id);
            intent.putExtra("block_title", this.block.title);
            intent.putExtra("block_category_type", this.block.categoryType);
            intent.putStringArrayListExtra("block_cp_list", (ArrayList) this.block.cpList);
            intent.putExtra("block_type", this.blockType);
        }
        this.itemView.getContext().startActivity(intent);
    }

    public void bindView(PatchWall.Block block2) {
        this.title.setText(block2.title);
        this.more.setVisibility(block2.displayMore ? 0 : 8);
        this.block = block2;
        if (!TextUtils.isEmpty(block2.description)) {
            this.desc.setText(block2.description);
        }
    }
}
