package com.xiaomi.mico.music.patchwall.group;

import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.music.section.BannerViewHolder;
import java.util.List;

public class BannerGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
    private List<Banner.Item> banners;

    public String getID() {
        return "BANNER";
    }

    public int getItemViewType(int i) {
        return 3;
    }

    public void updateBanner(Banner banner) {
        this.banners = banner.banners;
    }

    public Banner.Item getBanner(int i) {
        return this.banners.get(i);
    }

    public int getHeaderCount() {
        List<Banner.Item> list = this.banners;
        return (list == null || list.isEmpty()) ? 0 : 1;
    }

    public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        ((BannerViewHolder) viewHolder).bindView(this.banners);
    }
}
