package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.banner.TabBannerPatchWallGroup;
import com.xiaomi.mico.music.banner.TabBannerViewHolder;
import com.xiaomi.mico.music.patchwall.group.BannerGroup;
import com.xiaomi.mico.music.patchwall.group.BlockViewHolder;
import com.xiaomi.mico.music.patchwall.group.EmptyGroup;
import com.xiaomi.mico.music.patchwall.group.HeaderViewHolder;
import com.xiaomi.mico.music.patchwall.group.PatchWallGroup;
import com.xiaomi.mico.music.patchwall.group.QQBlockViewHolder;
import com.xiaomi.mico.music.patchwall.group.QQHeaderViewHolder;
import com.xiaomi.mico.music.patchwall.group.QQPatchWallGroup;
import com.xiaomi.mico.music.patchwall.group.QQPatchWallRankGroup;
import com.xiaomi.mico.music.patchwall.group.QQPatchWallSingerGroup;
import com.xiaomi.mico.music.patchwall.group.QQPatchWallStationGroup;
import com.xiaomi.mico.music.section.BannerViewHolder;
import com.xiaomi.smarthome.R;
import com.youth.banner.listener.OnBannerListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PatchWallAdapter extends GroupAdapter<ItemClickableAdapter.ViewHolder> implements RatioBanner.OnStateChange {
    private String blockType;
    private final Context mContext;
    private boolean mIsActivate;
    private final RecyclerView.O0000Oo mItemDecoration;
    private final int mQQTextHeight;
    private final int mQQTextHeightOneLine;
    private final int mTextHeight;
    private final RecyclerView.O000O00o viewPool = new RecyclerView.O000O00o();

    public PatchWallAdapter(Context context) {
        this.mContext = context;
        this.viewPool.O000000o(0, 10);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mico_music_section_item_grid_padding);
        this.mItemDecoration = new BlockItemDecoration(dimensionPixelOffset, dimensionPixelOffset);
        this.mTextHeight = context.getResources().getDimensionPixelOffset(R.dimen.music_patch_wall_item_text_height);
        this.mQQTextHeight = DisplayUtils.dip2px(context, 32.0f) + DisplayUtils.dip2px(context, 8.0f);
        this.mQQTextHeightOneLine = DisplayUtils.dip2px(context, 24.0f);
        addGroup(new BannerGroup());
    }

    public PatchWallAdapter(Context context, String str) {
        this.mContext = context;
        this.viewPool.O000000o(0, 10);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mico_music_section_item_grid_padding);
        this.mItemDecoration = new BlockItemDecoration(dimensionPixelOffset, dimensionPixelOffset);
        this.mTextHeight = context.getResources().getDimensionPixelOffset(R.dimen.music_patch_wall_item_text_height);
        this.mQQTextHeight = context.getResources().getDimensionPixelOffset(R.dimen.mico_player_music_item_height);
        this.mQQTextHeightOneLine = DisplayUtils.dip2px(context, 24.0f);
        addGroup(new BannerGroup());
        this.blockType = str;
    }

    public void updateDidiStatus(String str) {
        if (!TextUtils.isEmpty(str)) {
            getGroupByID("DIDI");
        }
    }

    public void updateBanner(Banner banner) {
        GroupAdapter.Group groupByID = getGroupByID("BANNER");
        if (groupByID != null) {
            ((BannerGroup) groupByID).updateBanner(banner);
            notifyDataSetChanged();
        }
    }

    public void addMihomeBanner(Banner banner) {
        removeGroup(TabBannerPatchWallGroup.class);
        if (banner != null && banner.banners != null && !banner.banners.isEmpty()) {
            addGroup(0, new TabBannerPatchWallGroup(banner));
        }
    }

    public void updateBlocks(List<PatchWall.Block> list, boolean z) {
        if (!z) {
            removeGroup(PatchWallGroup.class);
            removeGroup(EmptyGroup.class);
        }
        if (z) {
            removeGroup(EmptyGroup.class);
        }
        Iterator<PatchWall.Block> it = list.iterator();
        while (it.hasNext()) {
            PatchWall.Block next = it.next();
            String str = next.blockUiType.name;
            if (!"block_grid".equals(str) && !"block_grid_circle".equals(str) && !"block_grid_button".equals(str) && !"block_grid_rich".equals(str) && !"block_grid_feature".equals(str)) {
                it.remove();
            } else if (ContainerUtil.isEmpty(next.items)) {
                it.remove();
            } else {
                sortItems(next.items);
                addGroup(new PatchWallGroup(next, getRows(next.items), this.mQQTextHeight));
            }
        }
        addGroup(new EmptyGroup());
        notifyDataSetChanged();
    }

    public void updateQQBlocks(List<PatchWall.Block> list, boolean z) {
        if (!z) {
            removeGroup(QQPatchWallGroup.class);
            removeGroup(QQPatchWallSingerGroup.class);
            removeGroup(QQPatchWallRankGroup.class);
            removeGroup(QQPatchWallStationGroup.class);
            removeGroup(EmptyGroup.class);
        }
        if (z) {
            removeGroup(EmptyGroup.class);
        }
        Iterator<PatchWall.Block> it = list.iterator();
        while (it.hasNext()) {
            PatchWall.Block next = it.next();
            String str = next.blockUiType.name;
            if (!"block_grid".equals(str) && !"block_grid_circle".equals(str) && !"block_grid_button".equals(str) && !"block_grid_circle_has_group_hr".equals(str) && !"block_grid_has_details".equals(str) && !"block_grid_circle_hr".equals(str)) {
                it.remove();
            } else if (ContainerUtil.isEmpty(next.items)) {
                it.remove();
            } else if ("block_grid_circle_has_group_hr".equals(str)) {
                addGroup(new QQPatchWallStationGroup(next));
            } else if ("block_grid_has_details".equals(str)) {
                addGroup(new QQPatchWallRankGroup(next));
            } else if ("block_grid_circle_hr".equals(str)) {
                sortItems(next.items);
                addGroup(new QQPatchWallSingerGroup(next, 2, this.mQQTextHeight));
            } else {
                sortItems(next.items);
                addGroup(new QQPatchWallGroup(next, getRows(next.items), next.blockUiType.columns == 2 ? this.mQQTextHeightOneLine : this.mQQTextHeight));
            }
        }
        addGroup(new EmptyGroup());
        notifyDataSetChanged();
    }

    public void setBlockType(String str) {
        this.blockType = str;
    }

    private void sortItems(List<PatchWall.Item> list) {
        Collections.sort(list, $$Lambda$PatchWallAdapter$suWAHc13FXY8mdObftnUe23I_OM.INSTANCE);
    }

    static /* synthetic */ int lambda$sortItems$0(PatchWall.Item item, PatchWall.Item item2) {
        PatchWall.Pos pos = item.itemUiType.pos;
        PatchWall.Pos pos2 = item2.itemUiType.pos;
        if (pos.y > pos2.y) {
            return 1;
        }
        if (pos.y == pos2.y) {
            if (pos.x > pos2.x) {
                return 1;
            }
            if (pos.x == pos2.x) {
                return 0;
            }
        }
        return -1;
    }

    private int getRows(List<PatchWall.Item> list) {
        PatchWall.Item item = list.get(list.size() - 1);
        return item.itemUiType.pos.y + item.itemUiType.pos.h;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemClickableAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mico_select_view_patchwall_title, viewGroup, false), this.blockType);
        }
        if (i == 4) {
            return new QQHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mico_select_view_patchwall_title, viewGroup, false), this.blockType);
        }
        if (i == 2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block, viewGroup, false);
            inflate.setFocusableInTouchMode(false);
            return new BlockViewHolder(inflate, this.viewPool, this.mItemDecoration);
        } else if (i == 7) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block, viewGroup, false);
            inflate2.setFocusableInTouchMode(false);
            return new QQBlockViewHolder(inflate2, this.viewPool, this.mItemDecoration);
        } else if (i == 8) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block_rank, viewGroup, false);
            inflate3.setFocusableInTouchMode(false);
            return new QQPatchWallRankGroup.QQRankBlockViewHolder(inflate3);
        } else if (i == 9) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block_singer, viewGroup, false);
            inflate4.setFocusableInTouchMode(false);
            return new QQPatchWallSingerGroup.QQSingerBlockViewHolder(inflate4);
        } else if (i == 6) {
            return new QQPatchWallStationGroup.QQStationViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_station, viewGroup, false));
        } else {
            if (i == 10) {
                return new EmptyGroup.EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
            }
            if (i == 16) {
                return new TabBannerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_section_banner, viewGroup, false), this, new OnBannerListener(viewGroup) {
                    /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$PatchWallAdapter$R9dWplIFrFxy0GXc_C4yfUjD7SY */
                    private final /* synthetic */ ViewGroup f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void OnBannerClick(int i) {
                        PatchWallAdapter.this.lambda$onCreateViewHolder$1$PatchWallAdapter(this.f$1, i);
                    }
                });
            }
            return new BannerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_section_banner, viewGroup, false), this, new OnBannerListener() {
                /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$PatchWallAdapter$POmHoANTBJZUju1RfMDguxsaEk */

                public final void OnBannerClick(int i) {
                    PatchWallAdapter.this.lambda$onCreateViewHolder$2$PatchWallAdapter(i);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$PatchWallAdapter(ViewGroup viewGroup, int i) {
        GroupAdapter.Group groupByID = getGroupByID("BANNER");
        if (groupByID != null) {
            SchemaManager.handleSchema(viewGroup.getContext(), ((TabBannerPatchWallGroup) groupByID).getBanner(i).data.url);
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$PatchWallAdapter(int i) {
        GroupAdapter.Group groupByID = getGroupByID("BANNER");
        if (groupByID != null) {
            MusicHelper.processBanner(this.mContext, ((BannerGroup) groupByID).getBanner(i).data);
        }
    }

    public void onActivate() {
        this.mIsActivate = true;
        notifyDataSetChanged();
    }

    public void onDeactivate() {
        this.mIsActivate = false;
        notifyDataSetChanged();
    }

    public boolean isActivate() {
        return this.mIsActivate;
    }
}
