package com.xiaomi.mico.music.patchwall.adapter;

import _m_j.jgc;
import _m_j.jgi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.banner.TabBannerPatchWallGroup;
import com.xiaomi.mico.music.banner.TabBannerViewHolder;
import com.xiaomi.mico.music.patchwall.group.BlockGridPanelGroup;
import com.xiaomi.mico.music.patchwall.group.EmptyGroup;
import com.xiaomi.mico.music.patchwall.group.HeaderViewHolder;
import com.xiaomi.mico.music.patchwall.group.KidsBlockViewHolder;
import com.xiaomi.mico.music.patchwall.group.KidsPatchWallGroup;
import com.xiaomi.mico.music.patchwall.group.KidsPersonalGroup;
import com.xiaomi.smarthome.R;
import com.youth.banner.listener.OnBannerListener;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class KidsPatchWallAdapter extends GroupAdapter<ItemClickableAdapter.ViewHolder> implements RatioBanner.OnStateChange {
    private String blockType;
    private KidsPersonalGroup.KidsPersonalViewHolder kidsPersonalViewHolder;
    private boolean mIsActivate;

    public KidsPatchWallAdapter(Context context, String str) {
        this.blockType = str;
        if (showPersonal()) {
            addGroup(new KidsPersonalGroup());
        }
    }

    public void updateKidsBanner(Banner banner) {
        removeGroup(TabBannerPatchWallGroup.class);
        if (banner != null && banner.banners != null && !banner.banners.isEmpty()) {
            addGroup(0, new TabBannerPatchWallGroup(banner));
        }
    }

    public void updateKidsBlocks(List<PatchWall.Block> list, boolean z) {
        if (!z) {
            removeGroup(KidsPatchWallGroup.class);
            removeGroup(BlockGridPanelGroup.class);
            removeGroup(EmptyGroup.class);
        }
        if (z) {
            removeGroup(EmptyGroup.class);
        }
        Iterator<PatchWall.Block> it = list.iterator();
        while (it.hasNext()) {
            PatchWall.Block next = it.next();
            String str = next.blockUiType.name;
            if (!"block_grid".equals(str) && !"block_grid_circle".equals(str) && !"block_grid_button".equals(str) && !"block_grid_panel".equals(str) && !"block_grid_rich".equals(str)) {
                it.remove();
            } else if (ContainerUtil.isEmpty(next.items)) {
                it.remove();
            } else if ("block_grid_panel".equals(str)) {
                addGroup(new BlockGridPanelGroup(next));
            } else {
                addGroup(new KidsPatchWallGroup(next));
            }
        }
        addGroup(new EmptyGroup());
        notifyDataSetChanged();
    }

    public void setBlockType(String str) {
        this.blockType = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ItemClickableAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 15) {
            this.kidsPersonalViewHolder = new KidsPersonalGroup.KidsPersonalViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_kids_header, viewGroup, false));
            return this.kidsPersonalViewHolder;
        } else if (i == 1) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mico_select_view_patchwall_title, viewGroup, false), this.blockType);
        } else {
            if (i == 10) {
                return new EmptyGroup.EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
            }
            if (i == 11) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block_grid_panel, viewGroup, false);
                inflate.setFocusableInTouchMode(false);
                return new BlockGridPanelGroup.BlockGridPanelViewHolder(inflate);
            } else if (i == 13) {
                return new KidsBlockViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block, viewGroup, false));
            } else {
                if (i == 16) {
                    return new TabBannerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_section_banner, viewGroup, false), this, new OnBannerListener(viewGroup) {
                        /* class com.xiaomi.mico.music.patchwall.adapter.$$Lambda$KidsPatchWallAdapter$hNz5qqiLG0ZQGFtPZTmXUb0AD0 */
                        private final /* synthetic */ ViewGroup f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void OnBannerClick(int i) {
                            KidsPatchWallAdapter.this.lambda$onCreateViewHolder$0$KidsPatchWallAdapter(this.f$1, i);
                        }
                    });
                }
                return null;
            }
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$KidsPatchWallAdapter(ViewGroup viewGroup, int i) {
        GroupAdapter.Group groupByID = getGroupByID("BANNER");
        if (groupByID != null) {
            SchemaManager.handleSchema(viewGroup.getContext(), ((TabBannerPatchWallGroup) groupByID).getBanner(i).data.url);
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

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        jgc O000000o2 = jgc.O000000o();
        if (!O000000o2.O00000Oo(this)) {
            O000000o2.O000000o(this);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        jgc O000000o2 = jgc.O000000o();
        if (O000000o2.O00000Oo(this)) {
            O000000o2.O00000o0(this);
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onCurrentMicoChanged(MicoEvent.CurrentMicoChanged currentMicoChanged) {
        KidsPersonalGroup.KidsPersonalViewHolder kidsPersonalViewHolder2 = this.kidsPersonalViewHolder;
        if (kidsPersonalViewHolder2 != null) {
            notifyItemChanged(kidsPersonalViewHolder2.getAdapterPosition());
        }
    }

    private boolean showPersonal() {
        String str;
        return AppCapability.hasCapabilityBabySchedule() && ApiConstants.getAreaCode() != AreaCode.TW && (str = this.blockType) != null && str.equals("block_type_music_kids");
    }
}
