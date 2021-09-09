package com.xiaomi.mico.music.patchwall.micoselect.viewitem;

import _m_j.hxi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.mico.music.patchwall.micoselect.model.Card;
import com.xiaomi.smarthome.R;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemBinderBanner extends BaseItemBinder<BannerViewHolder> {
    public final RecyclerView.O000000o mAdapter;
    OnBannerListener mOnBannerListener;

    public ItemBinderBanner(Context context, RecyclerView.O000000o o000000o, OnBannerListener onBannerListener) {
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
        public List<Card> banners;

        public BannerViewHolder(View view) {
            super(view);
            this.banner = (RatioBanner) view.findViewById(R.id.mico_select_banner);
            this.banner.setCorner(12.0f);
            this.banner.setImageLoader(new ImageLoader(ItemBinderBanner.this) {
                /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderBanner.BannerViewHolder.AnonymousClass2 */

                public void displayImage(Context context, Object obj, ImageView imageView) {
                    String str = ((Card) obj).picture;
                    if (!TextUtils.isEmpty(str)) {
                        Picasso.get().load(str).placeholder((int) R.drawable.mico_img_banner_music).error((int) R.drawable.mico_img_banner_music).noFade().into(imageView);
                        return;
                    }
                    Picasso.get().load((int) R.drawable.mico_img_banner_music).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.mico_img_banner_music).into(imageView);
                }
            }).setOnBannerListener(new OnBannerListener(ItemBinderBanner.this) {
                /* class com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderBanner.BannerViewHolder.AnonymousClass1 */

                public void OnBannerClick(int i) {
                    if (!(BannerViewHolder.this.banners == null || BannerViewHolder.this.banners.get(i) == null)) {
                        SchemaManager.handleSchema(ItemBinderBanner.this.mContext, BannerViewHolder.this.banners.get(i).jumpLink);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("position", i + 1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    hxi.O00000o.O000000o("content_recommend_banner", jSONObject);
                }
            });
        }

        public void updateData(ViewSection viewSection, int i) {
            if (!ContainerUtil.equals(this.banners, viewSection.cards)) {
                this.banners = viewSection.cards;
                this.banner.update(this.banners);
                if (!(ItemBinderBanner.this.mAdapter instanceof RatioBanner.OnStateChange) || !((RatioBanner.OnStateChange) ItemBinderBanner.this.mAdapter).isActivate()) {
                    this.banner.stopAutoPlay();
                } else {
                    this.banner.startAutoPlay();
                }
            }
        }
    }
}
