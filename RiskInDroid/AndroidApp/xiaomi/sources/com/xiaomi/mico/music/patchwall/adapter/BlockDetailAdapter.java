package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.BlockDetailAdapter;
import com.xiaomi.smarthome.R;
import java.text.DecimalFormat;

public class BlockDetailAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    public static int borderRadius;
    public static int imageWidth;
    private PatchWall.Block mBlock;
    public String mBlockType;
    private boolean mCircle;
    private final Context mContext;
    private boolean mDisplayText;

    public BlockDetailAdapter(Context context, String str) {
        this.mContext = context;
        this.mBlockType = str;
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
        imageWidth = (DisplayUtils.getScreenWidthPixels(context) - DisplayUtils.dip2px(context, 42.0f)) / 2;
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
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_item_block_detail, viewGroup, false));
    }

    public void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        super.onBindItemViewHolder(viewHolder, i);
        viewHolder.registerItemClickEvent(this);
        ((ItemViewHolder) viewHolder).bindView(this.mBlock, (PatchWall.Item) getData(i), this.mCircle, true, this.mDisplayText);
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        SchemaManager.handleSchema(this.mContext, ((PatchWall.Item) getData(i)).target);
    }

    class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private PatchWall.Block block;
        ImageView image;
        View imageContain;
        private PatchWall.Item item;
        View playButton;
        TextView playCountText;
        ImageView richTag;
        TextView shortDescription;
        TextView text;

        ItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.shortDescription = (TextView) view.findViewById(R.id.patchwall_item_short_description);
            this.playCountText = (TextView) view.findViewById(R.id.patchwall_item_play_count);
            this.imageContain = view.findViewById(R.id.patchwall_item);
            this.playButton = view.findViewById(R.id.play_button);
            this.richTag = (ImageView) view.findViewById(R.id.tag_rich);
            view.findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$BlockDetailAdapter$ItemViewHolder$P3asmAiE980kFKF_LQlACG3hx8 */

                public final void onClick(View view) {
                    BlockDetailAdapter.ItemViewHolder.this.lambda$new$0$BlockDetailAdapter$ItemViewHolder(view);
                }
            });
            ViewGroup.LayoutParams layoutParams = this.imageContain.getLayoutParams();
            layoutParams.height = BlockDetailAdapter.imageWidth;
            layoutParams.width = BlockDetailAdapter.imageWidth;
            this.imageContain.setLayoutParams(layoutParams);
        }

        public /* synthetic */ void lambda$new$0$BlockDetailAdapter$ItemViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block2, PatchWall.Item item2, boolean z, boolean z2, boolean z3) {
            this.item = item2;
            this.block = block2;
            String str = item2.images.poster.url;
            if (z2) {
                MusicHelper.loadPatchWallCropSquareCover(str, this.image, R.drawable.cover_patchwall_default_rectangle, BlockDetailAdapter.borderRadius);
            } else if (z) {
                MusicHelper.loadPatchWallCircleCover(str, this.image, R.drawable.cover_patchwall_default_circle);
            }
            int i = 0;
            if (z3) {
                this.text.setVisibility(0);
                this.text.setText(item2.title);
                this.shortDescription.setVisibility(TextUtils.isEmpty(item2.shortDescription) ? 8 : 0);
                this.shortDescription.setText(item2.shortDescription);
            } else {
                this.text.setVisibility(8);
                this.shortDescription.setVisibility(8);
            }
            String playCount = getPlayCount(item2.playCount);
            if (!TextUtils.isEmpty(playCount)) {
                this.playCountText.setText(playCount);
                this.playCountText.setVisibility(0);
            } else {
                this.playCountText.setVisibility(8);
            }
            if ("block_type_music_kids".equals(BlockDetailAdapter.this.mBlockType)) {
                this.playButton.setVisibility(8);
            } else {
                this.playButton.setVisibility(0);
            }
            ImageView imageView = this.richTag;
            if (!showRichTag(item2)) {
                i = 8;
            }
            imageView.setVisibility(i);
        }

        public String getPlayCount(long j) {
            if (j <= 0) {
                return null;
            }
            if (j > 100000000) {
                String format = new DecimalFormat("##0.00").format((double) (((float) j) / 1.0E8f));
                return format + this.itemView.getContext().getString(R.string.hundred_million);
            } else if (j <= 10000) {
                return String.valueOf(j);
            } else {
                String format2 = new DecimalFormat("##0.0").format((double) (((float) j) / 10000.0f));
                return format2 + this.itemView.getContext().getString(R.string.ten_thousand);
            }
        }

        public void onClick() {
            SchemaManager.handleSchema(this.itemView.getContext(), HomepageSchemaHandler.buildPlaySheetSchema(this.item.target));
            new Object[1][0] = "item.target" + this.item.target;
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

    public static class SpacingItemDecoration extends RecyclerView.O0000Oo {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;
        private int topSpace;

        public SpacingItemDecoration(int i, int i2, boolean z, int i3) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
            this.topSpace = i3;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                int i3 = this.spacing;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                if (childAdapterPosition < i) {
                    rect.top = this.topSpace;
                }
                rect.bottom = this.spacing;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition < i) {
                rect.top = this.topSpace;
            }
            rect.bottom = this.spacing;
        }
    }
}
