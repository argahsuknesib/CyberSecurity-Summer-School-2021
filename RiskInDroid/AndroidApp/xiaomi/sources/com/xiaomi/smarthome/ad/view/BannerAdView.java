package com.xiaomi.smarthome.ad.view;

import _m_j.etx;
import _m_j.eyy;
import _m_j.fsp;
import _m_j.goy;
import _m_j.jz;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.router.miio.miioplugin.IPluginCallback3;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;
import java.util.ArrayList;
import java.util.List;

public class BannerAdView extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ImageView> f4150O000000o;
    public List<Advertisement> O00000Oo;
    private ImageView O00000o;
    private ViewPager O00000o0;
    private ImageView O00000oO;
    private ViewGroup O00000oo;
    private List<ImageView> O0000O0o;
    private jz O0000OOo = new jz() {
        /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass5 */

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final int getCount() {
            return BannerAdView.this.O00000Oo.size();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(BannerAdView.this.f4150O000000o.get(i % BannerAdView.this.f4150O000000o.size()));
        }

        public final Object instantiateItem(ViewGroup viewGroup, final int i) {
            int size = i % BannerAdView.this.f4150O000000o.size();
            if (BannerAdView.this.f4150O000000o.get(size).getParent() != null) {
                ((ViewGroup) BannerAdView.this.f4150O000000o.get(size).getParent()).removeView(BannerAdView.this.f4150O000000o.get(size));
            }
            viewGroup.addView(BannerAdView.this.f4150O000000o.get(size));
            BannerAdView bannerAdView = BannerAdView.this;
            bannerAdView.O000000o(size, bannerAdView.f4150O000000o.get(size));
            BannerAdView.this.f4150O000000o.get(size).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass5.AnonymousClass1 */

                public final void onClick(View view) {
                    eyy.O000000o();
                    fsp.O000000o().O0000Oo.loadWebView(BannerAdView.this.O00000Oo.get(i).O00000oO, "");
                }
            });
            return BannerAdView.this.f4150O000000o.get(size);
        }
    };

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.ad.view.BannerAdView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public BannerAdView(Context context) {
        super(context);
        LayoutInflater.from(getContext().getApplicationContext()).inflate((int) R.layout.view_ad_banner, (ViewGroup) this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.O00000o0 = (ViewPager) findViewById(R.id.view_pager);
        this.O00000o = (ImageView) findViewById(R.id.single_image);
        this.O00000oO = (ImageView) findViewById(R.id.ad_banner_close);
        this.O00000oo = (ViewGroup) findViewById(R.id.dots_parent);
    }

    private void O000000o(int i) {
        this.O0000O0o = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(R.drawable.banner_bottom_dot_unselected));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins((int) goy.O000000o(getContext(), 2.0f), 0, (int) goy.O000000o(getContext(), 2.0f), 0);
            imageView.setLayoutParams(layoutParams);
            this.O0000O0o.add(imageView);
            this.O00000oo.addView(imageView);
        }
    }

    public void setDot(int i) {
        for (int i2 = 0; i2 < this.f4150O000000o.size(); i2++) {
            if (i2 == i) {
                this.O0000O0o.get(i2).setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(R.drawable.banner_bottom_dot_focused));
            } else {
                this.O0000O0o.get(i2).setImageDrawable(getContext().getApplicationContext().getResources().getDrawable(R.drawable.banner_bottom_dot_unselected));
            }
        }
    }

    public final void O000000o(int i, final ImageView imageView) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().loadBitmap(this.O00000Oo.get(i).O00000o, new IPluginCallback3.Stub() {
                    /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass4 */

                    public void onFailed() throws RemoteException {
                    }

                    public void onSuccess(final Bitmap bitmap) throws RemoteException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setBannerAd(AdPosition adPosition) {
        this.O00000Oo = adPosition.O00000Oo;
        if (this.O00000Oo.size() == 1) {
            this.O00000o0.setVisibility(8);
            O000000o(0, this.O00000o);
            this.O00000oO.setVisibility(0);
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass1 */

                public final void onClick(View view) {
                    fsp.O000000o().O0000Oo.loadWebView(BannerAdView.this.O00000Oo.get(0).O00000oO, "");
                    eyy.O000000o();
                }
            });
        } else {
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(0);
            int size = this.O00000Oo.size();
            this.f4150O000000o = new ArrayList();
            for (int i = 0; i < size; i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f4150O000000o.add(imageView);
            }
            O000000o(this.O00000Oo.size());
            this.O00000o0.setAdapter(this.O0000OOo);
            setDot(0);
            this.O00000o0.addOnPageChangeListener(new ViewPager.O0000O0o() {
                /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass2 */

                public final void onPageScrollStateChanged(int i) {
                }

                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageSelected(int i) {
                    BannerAdView bannerAdView = BannerAdView.this;
                    bannerAdView.setDot(i % bannerAdView.f4150O000000o.size());
                }
            });
        }
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.ad.view.BannerAdView.AnonymousClass3 */

            public final void onClick(View view) {
                ViewGroup viewGroup = (ViewGroup) BannerAdView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(BannerAdView.this);
                }
                for (Advertisement O00000Oo : BannerAdView.this.O00000Oo) {
                    eyy.O00000Oo(O00000Oo);
                }
            }
        });
    }
}
