package com.xiaomi.mico.music.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.mico.music.patchwall.micoselect.model.Card;
import com.xiaomi.smarthome.R;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.List;

public class TabItemBinderBanner extends BaseItemBinder<BannerViewHolder> {
    public final RecyclerView.O000000o mAdapter;
    OnBannerListener mOnBannerListener;

    public TabItemBinderBanner(Context context, RecyclerView.O000000o o000000o, OnBannerListener onBannerListener) {
        super(context);
        this.mAdapter = o000000o;
        this.mOnBannerListener = onBannerListener;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public BannerViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new BannerViewHolder(layoutInflater.inflate((int) R.layout.mico_select_banner_view, viewGroup, false));
    }

    class BannerViewHolder extends BaseItemBinder.ViewHolder {
        RatioBanner banner;
        private List<Card> banners;

        public BannerViewHolder(View view) {
            super(view);
            this.banner = (RatioBanner) view.findViewById(R.id.mico_select_banner);
            this.banner.setCorner(12.0f);
            this.banner.setImageLoader(new ImageLoader(TabItemBinderBanner.this) {
                /* class com.xiaomi.mico.music.banner.TabItemBinderBanner.BannerViewHolder.AnonymousClass1 */

                public void displayImage(Context context, Object obj, ImageView imageView) {
                    String str = ((Card) obj).picture;
                    if (!TextUtils.isEmpty(str)) {
                        Picasso.get().load(str).placeholder((int) R.drawable.img_banner_music).error((int) R.drawable.img_banner_music).noFade().into(imageView);
                        return;
                    }
                    Picasso.get().load((int) R.drawable.img_banner_music).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.img_banner_music).into(imageView);
                }
            }).setOnBannerListener(TabItemBinderBanner.this.mOnBannerListener);
        }

        public void updateData(ViewSection viewSection, int i) {
            if (!ContainerUtil.equals(this.banners, viewSection.cards)) {
                this.banners = viewSection.cards;
                this.banner.update(this.banners);
                if (!(TabItemBinderBanner.this.mAdapter instanceof RatioBanner.OnStateChange) || !((RatioBanner.OnStateChange) TabItemBinderBanner.this.mAdapter).isActivate()) {
                    this.banner.stopAutoPlay();
                } else {
                    this.banner.startAutoPlay();
                }
            }
        }
    }
}
