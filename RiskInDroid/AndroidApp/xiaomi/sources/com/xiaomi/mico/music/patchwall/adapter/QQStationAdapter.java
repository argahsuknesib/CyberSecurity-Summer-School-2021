package com.xiaomi.mico.music.patchwall.adapter;

import _m_j.gpc;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.adapter.QQStationAdapter;
import com.xiaomi.smarthome.R;
import java.util.List;

public class QQStationAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    private PatchWall.Block block;
    private Context context;
    private List<List<PatchWall.Item>> stations;
    private final int type_content = 0;
    private final int type_split = 1;

    public QQStationAdapter(Context context2) {
        this.context = context2;
    }

    public List getStations() {
        return this.stations;
    }

    public void setStations(PatchWall.Block block2, List list) {
        this.stations = list;
        this.block = block2;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new StationViewHolder(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_station_rss, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        if (o000OOo0 instanceof StationViewHolder) {
            ((StationViewHolder) o000OOo0).refreshUI(this.stations.get(i), i != 0, this.block.title);
        }
    }

    public int getItemCount() {
        List<List<PatchWall.Item>> list = this.stations;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    static class StationViewHolder extends RecyclerView.O000OOo0 {
        private StationCategoryAdapter adapter;
        View divider;
        private Context mContext;
        RecyclerView recyclerView;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void
         arg types: [android.content.Context, int, int, int]
         candidates:
          androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void
          androidx.recyclerview.widget.GridLayoutManager.<init>(android.content.Context, int, int, boolean):void */
        public StationViewHolder(Context context, View view) {
            super(view);
            this.mContext = context;
            this.recyclerView = (RecyclerView) view.findViewById(R.id.listview);
            this.divider = view.findViewById(R.id.divider_view);
            this.recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 2, 0, false));
            this.adapter = new StationCategoryAdapter(context);
            this.recyclerView.setAdapter(this.adapter);
        }

        public void refreshUI(List<PatchWall.Item> list, boolean z, String str) {
            this.adapter.setStations(list, str);
            this.divider.setVisibility(z ? 0 : 8);
        }
    }

    static class StationCategoryAdapter extends RecyclerView.O000000o<StationCategoryViewHolder> {
        private int cellSize;
        private Context context;
        private List<PatchWall.Item> stations;
        private String trackKey;

        public StationCategoryAdapter(Context context2) {
            this.context = context2;
            double O00000oO = (double) ((float) (gpc.O00000oO(context2) - gpc.O00000o0(context2, 70.0f)));
            Double.isNaN(O00000oO);
            this.cellSize = (int) (O00000oO / 3.5d);
        }

        public void setStations(List<PatchWall.Item> list, String str) {
            this.stations = list;
            this.trackKey = str;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public StationCategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new StationCategoryViewHolder(viewGroup.getContext(), LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_station_cell, viewGroup, false), this.cellSize);
        }

        public void onBindViewHolder(StationCategoryViewHolder stationCategoryViewHolder, int i) {
            stationCategoryViewHolder.refreshUI(this.stations.get(i), this.trackKey);
        }

        public int getItemCount() {
            List<PatchWall.Item> list = this.stations;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    static class StationCategoryViewHolder extends RecyclerView.O000OOo0 {
        ImageView image;
        private PatchWall.Item item;
        private Context mContext;
        TextView name;
        ImageView playButton;
        private String trackKey;

        public StationCategoryViewHolder(Context context, View view, int i) {
            super(view);
            this.mContext = context;
            this.name = (TextView) view.findViewById(R.id.patchwall_item_text);
            this.image = (ImageView) view.findViewById(R.id.patchwall_item_image);
            this.playButton = (ImageView) view.findViewById(R.id.play_button);
            this.playButton.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$QQStationAdapter$StationCategoryViewHolder$XxzDRKbdriUa2XAQ4yU56mBCkkM */

                public final void onClick(View view) {
                    QQStationAdapter.StationCategoryViewHolder.this.lambda$new$0$QQStationAdapter$StationCategoryViewHolder(view);
                }
            });
            ViewGroup.LayoutParams layoutParams = this.image.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            this.image.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.playButton.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i;
            this.playButton.setLayoutParams(layoutParams);
        }

        public /* synthetic */ void lambda$new$0$QQStationAdapter$StationCategoryViewHolder(View view) {
            onClick();
        }

        public void refreshUI(PatchWall.Item item2, String str) {
            this.item = item2;
            this.trackKey = str;
            this.name.setText(item2.title);
            if (!TextUtils.isEmpty(item2.images.poster.url)) {
                MusicHelper.loadCover(item2.images.poster.url, this.image, R.dimen.music_cover_size_84, R.dimen.music_cover_size_84, R.drawable.cover_patchwall_default_circle, true);
            }
        }

        public void onClick() {
            SchemaManager.handleSchema(this.itemView.getContext(), HomepageSchemaHandler.buildPlaySheetSchema(this.item.target));
        }
    }

    static class GridSpacingItemDecoration extends RecyclerView.O0000Oo {
        private boolean includeEdge;
        private int spacing;
        private int spanCount;

        public GridSpacingItemDecoration(int i, int i2, boolean z) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
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
                    rect.top = i3;
                }
                rect.bottom = this.spacing;
                return;
            }
            int i4 = this.spacing;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            if (childAdapterPosition >= i) {
                rect.top = i4;
            }
        }
    }
}
