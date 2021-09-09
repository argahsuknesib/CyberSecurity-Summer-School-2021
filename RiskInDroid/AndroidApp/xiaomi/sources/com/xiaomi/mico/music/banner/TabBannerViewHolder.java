package com.xiaomi.mico.music.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.smarthome.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.List;

public class TabBannerViewHolder extends ItemClickableAdapter.ViewHolder {
    Banner banner;
    private List<Banner.Item> banners;
    private final RecyclerView.O000000o mAdapter;

    public TabBannerViewHolder(View view, RecyclerView.O000000o o000000o, OnBannerListener onBannerListener) {
        super(view, null);
        this.banner = (com.youth.banner.Banner) view.findViewById(R.id.music_section_banner);
        this.mAdapter = o000000o;
        this.banner.setImageLoader(new ImageLoader() {
            /* class com.xiaomi.mico.music.banner.TabBannerViewHolder.AnonymousClass1 */
            private static final long serialVersionUID = 8322466637168971285L;

            public void displayImage(Context context, Object obj, ImageView imageView) {
                Banner.Data data = ((Banner.Item) obj).data;
                if (data == null) {
                    Picasso.get().load((int) R.drawable.mico_img_banner_music).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.mico_img_banner_music).into(imageView);
                    return;
                }
                String str = data.image;
                if (!TextUtils.isEmpty(str)) {
                    Picasso.get().load(str).placeholder((int) R.drawable.mico_img_banner_music).error((int) R.drawable.mico_img_banner_music).noFade().into(imageView);
                    return;
                }
                Picasso.get().load((int) R.drawable.mico_img_banner_music).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.mico_img_banner_music).into(imageView);
            }
        }).setOnBannerListener(onBannerListener);
    }

    public void bindView(List<Banner.Item> list) {
        if (!ContainerUtil.equals(this.banners, list)) {
            this.banners = list;
            this.banner.update(list);
            RecyclerView.O000000o o000000o = this.mAdapter;
            if (!(o000000o instanceof RatioBanner.OnStateChange) || !((RatioBanner.OnStateChange) o000000o).isActivate()) {
                this.banner.stopAutoPlay();
            } else {
                this.banner.startAutoPlay();
            }
        }
    }
}
