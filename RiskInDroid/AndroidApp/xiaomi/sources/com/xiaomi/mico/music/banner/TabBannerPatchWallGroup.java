package com.xiaomi.mico.music.banner;

import _m_j.gsy;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;

public class TabBannerPatchWallGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    protected final Banner banner;

    public int getHeaderCount() {
        return 0;
    }

    public String getID() {
        return "BANNER";
    }

    public int getItemCount() {
        return 1;
    }

    public int getItemViewType(int i) {
        return 16;
    }

    public TabBannerPatchWallGroup(Banner banner2) {
        this.banner = banner2;
    }

    public Banner.Item getBanner(int i) {
        Banner banner2 = this.banner;
        if (banner2 != null && banner2.banners != null && !this.banner.banners.isEmpty() && i < this.banner.banners.size() && i >= 0) {
            return this.banner.banners.get(i);
        }
        return null;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        Banner banner2 = this.banner;
        if (banner2 == null) {
            gsy.O00000Oo("TabBannerPatchWallGroup", "banner is null");
        } else if (viewHolder instanceof TabBannerViewHolder) {
            ((TabBannerViewHolder) viewHolder).bindView(banner2.banners);
        }
    }
}
