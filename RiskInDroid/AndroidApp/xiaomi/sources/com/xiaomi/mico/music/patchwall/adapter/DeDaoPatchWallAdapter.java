package com.xiaomi.mico.music.patchwall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.banner.TabBannerPatchWallGroup;
import com.xiaomi.mico.music.patchwall.group.DedaoAuthGroup;
import com.xiaomi.mico.music.patchwall.group.DedaoBlockViewHolder;
import com.xiaomi.mico.music.patchwall.group.DedaoPatchWallGroup;
import com.xiaomi.mico.music.patchwall.group.EmptyGroup;
import com.xiaomi.mico.music.patchwall.group.HeaderViewHolder;
import com.xiaomi.mico.music.patchwall.group.QQHeaderViewHolder;
import com.xiaomi.mico.music.patchwall.group.QQPatchWallRankGroup;
import com.xiaomi.smarthome.R;
import java.util.Iterator;
import java.util.List;

public class DeDaoPatchWallAdapter extends GroupAdapter<ItemClickableAdapter.ViewHolder> implements RatioBanner.OnStateChange {
    private String blockType;
    private boolean mIsActivate;
    private boolean needShowAuth;

    public DeDaoPatchWallAdapter(Context context) {
    }

    public void setNeedShowAuth(boolean z) {
        this.needShowAuth = z;
    }

    public void addMihomeBanner(Banner banner) {
        removeGroup(TabBannerPatchWallGroup.class);
        addGroup(0, new TabBannerPatchWallGroup(banner));
    }

    public void updateBlocks(List<PatchWall.Block> list, boolean z) {
        if (!z) {
            removeGroup(DedaoPatchWallGroup.class);
            removeGroup(QQPatchWallRankGroup.class);
        }
        removeGroup(EmptyGroup.class);
        if (this.needShowAuth) {
            addGroup(new DedaoAuthGroup());
        } else {
            removeGroup(DedaoAuthGroup.class);
        }
        Iterator<PatchWall.Block> it = list.iterator();
        while (it.hasNext()) {
            PatchWall.Block next = it.next();
            String str = next.blockUiType.name;
            if (!"block_grid".equals(str) && !"block_grid_has_details".equals(str) && !"block_grid_feature".equals(str)) {
                it.remove();
            } else if (ContainerUtil.isEmpty(next.items)) {
                Object[] objArr = {"block items isEmpty= %s", next.title};
                it.remove();
            } else if ("block_grid_has_details".equals(str)) {
                addGroup(new QQPatchWallRankGroup(next));
            } else {
                addGroup(new DedaoPatchWallGroup(next));
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
        if (i == 14) {
            return new DedaoAuthGroup.DedaoAuthViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_dedao_auth_header, viewGroup, false));
        }
        if (i == 1) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_header_dedao, viewGroup, false), this.blockType);
        }
        if (i == 10) {
            return new EmptyGroup.EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_channel_empty, viewGroup, false));
        }
        if (i == 13) {
            return new DedaoBlockViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block, viewGroup, false));
        }
        if (i == 8) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_block_rank, viewGroup, false);
            inflate.setFocusableInTouchMode(false);
            return new QQPatchWallRankGroup.QQRankBlockViewHolder(inflate);
        } else if (i == 4) {
            return new QQHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_patchwall_header_dedao, viewGroup, false), this.blockType);
        } else {
            return null;
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

    private boolean showPersonal() {
        String str;
        return (ApiConstants.getAreaCode() == AreaCode.TW || (str = this.blockType) == null || !str.equals("block_type_music_kids")) ? false : true;
    }
}
