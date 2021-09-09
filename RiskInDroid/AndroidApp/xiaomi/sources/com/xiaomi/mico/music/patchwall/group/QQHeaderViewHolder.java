package com.xiaomi.mico.music.patchwall.group;

import android.content.Intent;
import android.view.View;
import com.xiaomi.mico.music.patchwall.BlockDetailActivity;
import com.xiaomi.smarthome.R;

public class QQHeaderViewHolder extends HeaderViewHolder {
    public QQHeaderViewHolder(View view, String str) {
        super(view, str);
        view.findViewById(R.id.patchwall_header_more).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$QQHeaderViewHolder$JdffsKTGh7BOSFozVc9kMqh8bC0 */

            public final void onClick(View view) {
                QQHeaderViewHolder.this.lambda$new$0$QQHeaderViewHolder(view);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$QQHeaderViewHolder(View view) {
        onClick();
    }

    /* access modifiers changed from: package-private */
    public void onClick() {
        Intent intent = new Intent(this.itemView.getContext(), BlockDetailActivity.class);
        intent.putExtra("block_id", this.block.id);
        intent.putExtra("block_title", this.block.title);
        intent.putExtra("block_type", this.blockType);
        intent.putExtra("category_type", this.block.categoryType);
        this.itemView.getContext().startActivity(intent);
    }
}
