package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.BlockLayoutManager;
import com.xiaomi.mico.music.patchwall.adapter.QQBlockAdapter;
import com.xiaomi.mico.music.patchwall.micoselect.FloorChildClickListener;
import com.xiaomi.smarthome.R;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class QQBlockAdapter extends SingleAdapter<ItemClickableAdapter.ViewHolder, PatchWall.Item> implements ItemClickableAdapter.OnItemClickListener {
    public static int borderRadius;
    private final int TYPE_QQ_DAILY_RECOMMEND = 1;
    private PatchWall.Block mBlock;
    private boolean mCircle;
    private final Context mContext;
    private boolean mCropSquare;
    private boolean mDisplayText;
    FloorChildClickListener mFloorChildClickListener;

    public QQBlockAdapter(Context context, boolean z, boolean z2, boolean z3, PatchWall.Block block) {
        this.mContext = context;
        updateUiTypeAndDataList(z, z3, z2, block);
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public QQBlockAdapter(Context context, boolean z, boolean z2, boolean z3, PatchWall.Block block, FloorChildClickListener floorChildClickListener) {
        this.mContext = context;
        this.mFloorChildClickListener = floorChildClickListener;
        updateUiTypeAndDataList(z, z3, z2, block);
        borderRadius = context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }

    public void updateUiTypeAndDataList(boolean z, boolean z2, boolean z3, PatchWall.Block block) {
        this.mCircle = z;
        this.mDisplayText = z3;
        this.mBlock = block;
        this.mCropSquare = z2;
        updateDataList(block.items);
    }

    public int getItemViewType(int i) {
        if ("daily_songs".equals(((PatchWall.Item) getData(i)).itemUiType.name)) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        if (1 == i) {
            return new RecommendItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_item_qq_daily_recommend, viewGroup, false));
        }
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_qq_item, viewGroup, false));
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
        if (viewHolder instanceof ItemViewHolder) {
            ((ItemViewHolder) viewHolder).bindView(this.mBlock, item, this.mCircle, this.mCropSquare, this.mDisplayText);
        } else if (viewHolder instanceof RecommendItemViewHolder) {
            ((RecommendItemViewHolder) viewHolder).bindView(item, this.mCircle, this.mCropSquare, this.mDisplayText);
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof RecommendItemViewHolder) {
            Context context = this.mContext;
            SchemaManager.handleSchema(context, ((PatchWall.Item) getData(i)).target + "&name=" + ((PatchWall.Item) getData(i)).title + "&cover=" + ((PatchWall.Item) getData(i)).images.poster.url);
            return;
        }
        String str = ((PatchWall.Item) getData(i)).target;
        boolean equals = Uri.parse(str).getPath().equals("/music");
        boolean isAreaCodeInTaiWan = ApiConstants.isAreaCodeInTaiWan();
        if (!equals || !isAreaCodeInTaiWan) {
            SchemaManager.handleSchema(this.mContext, str);
            return;
        }
        SchemaManager.handleSchema(this.mContext, appendUri(str, "parseAudioId=true"));
    }

    public static String appendUri(String str, String str2) {
        URI uri;
        try {
            URI uri2 = new URI(str);
            String query = uri2.getQuery();
            if (query != null) {
                str2 = query + "&" + str2;
            }
            uri = new URI(uri2.getScheme(), uri2.getAuthority(), uri2.getPath(), str2, uri2.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            uri = null;
        }
        return uri.toString();
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private PatchWall.Block block;
        ImageView image;
        private PatchWall.Item item;
        TextView playCountText;
        TextView text;

        ItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.playCountText = (TextView) view.findViewById(R.id.patchwall_item_play_count);
            view.findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$QQBlockAdapter$ItemViewHolder$k0nCTNgQY2WNl9fhFROY58608kw */

                public final void onClick(View view) {
                    QQBlockAdapter.ItemViewHolder.this.lambda$new$0$QQBlockAdapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$QQBlockAdapter$ItemViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Block block2, PatchWall.Item item2, boolean z, boolean z2, boolean z3) {
            this.item = item2;
            this.block = block2;
            String str = item2.images.poster.url;
            if (TextUtils.isEmpty(str) && item2.target != null) {
                String queryParameter = Uri.parse(item2.target).getQueryParameter("cover");
                if (!TextUtils.isEmpty(queryParameter)) {
                    str = URLDecoder.decode(queryParameter);
                }
            }
            if (z2) {
                MusicHelper.loadPatchWallCropSquareCover(str, this.image, R.drawable.mico_cover_patchwall_default_small_rectangle, QQBlockAdapter.borderRadius);
            } else if (z) {
                MusicHelper.loadPatchWallCircleCover(str, this.image, R.drawable.mico_cover_patchwall_default_small_rectangle);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.text.getLayoutParams();
            if (block2.blockUiType.columns == 3) {
                layoutParams.height = DisplayUtils.dip2px(this.text.getContext(), 32.0f);
            } else {
                layoutParams.height = -2;
            }
            if (z3) {
                this.text.setVisibility(0);
                this.text.setText(item2.title);
            } else {
                this.text.setVisibility(8);
            }
            String playCount = getPlayCount(item2.playCount);
            if (!TextUtils.isEmpty(playCount)) {
                this.playCountText.setText(playCount);
                this.playCountText.setVisibility(0);
                return;
            }
            this.playCountText.setVisibility(8);
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
        }
    }

    static class RecommendItemViewHolder extends ItemClickableAdapter.ViewHolder {
        ImageView image;
        private PatchWall.Item item;
        TextView mDay;
        TextView mMonth;
        TextView text;

        RecommendItemViewHolder(View view) {
            super(view, null);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.text = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.mMonth = (TextView) view.findViewById(R.id.patchwall_item_month);
            this.mDay = (TextView) view.findViewById(R.id.patchwall_item_day);
            view.findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$QQBlockAdapter$RecommendItemViewHolder$UcywosTAWFjeZIPvRQqFugjR7B8 */

                public final void onClick(View view) {
                    QQBlockAdapter.RecommendItemViewHolder.this.lambda$new$0$QQBlockAdapter$RecommendItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$QQBlockAdapter$RecommendItemViewHolder(View view) {
            onClick();
        }

        /* access modifiers changed from: package-private */
        public void bindView(PatchWall.Item item2, boolean z, boolean z2, boolean z3) {
            this.item = item2;
            if (z2) {
                MusicHelper.loadPatchWallCropSquareCover(item2.images.poster.url, this.image, R.drawable.mico_cover_patchwall_default_small_rectangle, QQBlockAdapter.borderRadius);
            } else if (z) {
                MusicHelper.loadPatchWallCircleCover(item2.images.poster.url, this.image, R.drawable.mico_cover_patchwall_default_small_rectangle);
            }
            if (z3) {
                this.text.setVisibility(0);
                this.text.setText(item2.title);
            } else {
                this.text.setVisibility(8);
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            String[] stringArray = this.itemView.getContext().getResources().getStringArray(R.array.month_all);
            TextView textView = this.mMonth;
            textView.setText(stringArray[instance.get(2)]);
            TextView textView2 = this.mDay;
            StringBuilder sb = new StringBuilder();
            sb.append(instance.get(5));
            textView2.setText(sb.toString());
        }

        public void onClick() {
            SchemaManager.handleSchema(this.itemView.getContext(), HomepageSchemaHandler.buildPlaySheetSchema(this.item.target));
        }
    }
}
