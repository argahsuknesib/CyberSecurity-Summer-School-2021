package com.youth.banner;

import _m_j.jz;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;
import com.youth.banner.view.BannerViewPager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Banner extends FrameLayout implements ViewPager.O0000O0o {
    private BannerPagerAdapter adapter;
    private int bannerBackgroundImage;
    private ImageView bannerDefaultImage;
    public OnBannerClickListener bannerListener;
    private int bannerStyle;
    private TextView bannerTitle;
    private Context context;
    public int count;
    public int currentItem;
    public int delayTime;
    private DisplayMetrics dm;
    private int gravity;
    public WeakHandler handler;
    private ImageLoaderInterface imageLoader;
    private List imageUrls;
    public List<View> imageViews;
    private LinearLayout indicator;
    private List<ImageView> indicatorImages;
    private LinearLayout indicatorInside;
    private int indicatorSize;
    public boolean isAutoPlay;
    private boolean isScroll;
    private int lastPosition;
    public OnBannerListener listener;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorSelectedResId;
    private int mIndicatorUnselectedResId;
    private int mIndicatorWidth;
    private int mLayoutResId;
    private ViewPager.O0000O0o mOnPageChangeListener;
    private BannerScroller mScroller;
    private TextView numIndicator;
    private TextView numIndicatorInside;
    private int scaleType;
    private int scrollTime;
    public String tag;
    public final Runnable task;
    private int titleBackground;
    private int titleHeight;
    private int titleTextColor;
    private int titleTextSize;
    private LinearLayout titleView;
    private List<String> titles;
    public BannerViewPager viewPager;

    public Banner(Context context2) {
        this(context2, null);
    }

    public Banner(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public Banner(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.tag = "banner";
        this.mIndicatorMargin = 5;
        this.bannerStyle = 1;
        this.delayTime = 2000;
        this.scrollTime = 800;
        this.isAutoPlay = true;
        this.isScroll = true;
        this.mIndicatorSelectedResId = R.drawable.gray_radius;
        this.mIndicatorUnselectedResId = R.drawable.white_radius;
        this.mLayoutResId = R.layout.banner;
        this.count = 0;
        this.gravity = -1;
        this.lastPosition = 1;
        this.scaleType = 1;
        this.handler = new WeakHandler();
        this.task = new Runnable() {
            /* class com.youth.banner.Banner.AnonymousClass1 */

            public void run() {
                if (Banner.this.count > 1 && Banner.this.isAutoPlay) {
                    Banner banner = Banner.this;
                    banner.currentItem = (banner.currentItem % (Banner.this.count + 1)) + 1;
                    if (Banner.this.currentItem == 1) {
                        Banner.this.viewPager.setCurrentItem(Banner.this.currentItem, false);
                        Banner.this.handler.post(Banner.this.task);
                        return;
                    }
                    Banner.this.viewPager.setCurrentItem(Banner.this.currentItem);
                    Banner.this.handler.postDelayed(Banner.this.task, (long) Banner.this.delayTime);
                }
            }
        };
        this.context = context2;
        this.titles = new ArrayList();
        this.imageUrls = new ArrayList();
        this.imageViews = new ArrayList();
        this.indicatorImages = new ArrayList();
        this.dm = context2.getResources().getDisplayMetrics();
        this.indicatorSize = this.dm.widthPixels / 80;
        initView(context2, attributeSet);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, com.youth.banner.Banner, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void initView(Context context2, AttributeSet attributeSet) {
        this.imageViews.clear();
        handleTypedArray(context2, attributeSet);
        View inflate = LayoutInflater.from(context2).inflate(this.mLayoutResId, (ViewGroup) this, true);
        this.bannerDefaultImage = (ImageView) inflate.findViewById(R.id.bannerDefaultImage);
        this.viewPager = (BannerViewPager) inflate.findViewById(R.id.bannerViewPager);
        this.titleView = (LinearLayout) inflate.findViewById(R.id.titleView);
        this.indicator = (LinearLayout) inflate.findViewById(R.id.circleIndicator);
        this.indicatorInside = (LinearLayout) inflate.findViewById(R.id.indicatorInside);
        this.bannerTitle = (TextView) inflate.findViewById(R.id.bannerTitle);
        this.numIndicator = (TextView) inflate.findViewById(R.id.numIndicator);
        this.numIndicatorInside = (TextView) inflate.findViewById(R.id.numIndicatorInside);
        this.bannerDefaultImage.setImageResource(this.bannerBackgroundImage);
        initViewPagerScroll();
    }

    private void handleTypedArray(Context context2, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, new int[]{R.attr.banner_default_image, R.attr.banner_layout, R.attr.delay_time, R.attr.image_scale_type, R.attr.indicator_drawable_selected, R.attr.indicator_drawable_unselected, R.attr.indicator_height, R.attr.indicator_margin, R.attr.indicator_width, R.attr.is_auto_play, R.attr.scroll_time, R.attr.title_background, R.attr.title_height, R.attr.title_textcolor, R.attr.title_textsize});
            this.mIndicatorWidth = obtainStyledAttributes.getDimensionPixelSize(8, this.indicatorSize);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(6, this.indicatorSize);
            this.mIndicatorMargin = obtainStyledAttributes.getDimensionPixelSize(7, 5);
            this.mIndicatorSelectedResId = obtainStyledAttributes.getResourceId(4, R.drawable.gray_radius);
            this.mIndicatorUnselectedResId = obtainStyledAttributes.getResourceId(5, R.drawable.white_radius);
            this.scaleType = obtainStyledAttributes.getInt(3, this.scaleType);
            this.delayTime = obtainStyledAttributes.getInt(2, 2000);
            this.scrollTime = obtainStyledAttributes.getInt(10, 800);
            this.isAutoPlay = obtainStyledAttributes.getBoolean(9, true);
            this.titleBackground = obtainStyledAttributes.getColor(11, -1);
            this.titleHeight = obtainStyledAttributes.getDimensionPixelSize(12, -1);
            this.titleTextColor = obtainStyledAttributes.getColor(13, -1);
            this.titleTextSize = obtainStyledAttributes.getDimensionPixelSize(14, -1);
            this.mLayoutResId = obtainStyledAttributes.getResourceId(1, this.mLayoutResId);
            this.bannerBackgroundImage = obtainStyledAttributes.getResourceId(0, R.drawable.no_banner);
            obtainStyledAttributes.recycle();
        }
    }

    private void initViewPagerScroll() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.mScroller = new BannerScroller(this.viewPager.getContext());
            this.mScroller.setDuration(this.scrollTime);
            declaredField.set(this.viewPager, this.mScroller);
        } catch (Exception e) {
            Log.e(this.tag, e.getMessage());
        }
    }

    public Banner isAutoPlay(boolean z) {
        this.isAutoPlay = z;
        return this;
    }

    public Banner setImageLoader(ImageLoaderInterface imageLoaderInterface) {
        this.imageLoader = imageLoaderInterface;
        return this;
    }

    public Banner setDelayTime(int i) {
        this.delayTime = i;
        return this;
    }

    public Banner setIndicatorGravity(int i) {
        if (i == 5) {
            this.gravity = 19;
        } else if (i == 6) {
            this.gravity = 17;
        } else if (i == 7) {
            this.gravity = 21;
        }
        return this;
    }

    public Banner setBannerAnimation(Class<? extends ViewPager.O0000OOo> cls) {
        try {
            setPageTransformer(true, (ViewPager.O0000OOo) cls.newInstance());
        } catch (Exception unused) {
            Log.e(this.tag, "Please set the PageTransformer class");
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i) {
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setOffscreenPageLimit(i);
        }
        return this;
    }

    public Banner setPageTransformer(boolean z, ViewPager.O0000OOo o0000OOo) {
        this.viewPager.setPageTransformer(z, o0000OOo);
        return this;
    }

    public Banner setBannerTitles(List<String> list) {
        this.titles = list;
        return this;
    }

    public Banner setBannerStyle(int i) {
        this.bannerStyle = i;
        return this;
    }

    public Banner setViewPagerIsScroll(boolean z) {
        this.isScroll = z;
        return this;
    }

    public Banner setImages(List<?> list) {
        this.imageUrls = list;
        this.count = list.size();
        return this;
    }

    public void update(List<?> list, List<String> list2) {
        this.titles.clear();
        this.titles.addAll(list2);
        update(list);
    }

    public void update(List<?> list) {
        this.imageUrls.clear();
        this.imageViews.clear();
        this.indicatorImages.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        start();
    }

    public void updateBannerStyle(int i) {
        this.indicator.setVisibility(8);
        this.numIndicator.setVisibility(8);
        this.numIndicatorInside.setVisibility(8);
        this.indicatorInside.setVisibility(8);
        this.bannerTitle.setVisibility(8);
        this.titleView.setVisibility(8);
        this.bannerStyle = i;
        start();
    }

    public Banner start() {
        setBannerStyleUI();
        setImageList(this.imageUrls);
        setData();
        return this;
    }

    private void setTitleStyleUI() {
        if (this.titles.size() == this.imageUrls.size()) {
            int i = this.titleBackground;
            if (i != -1) {
                this.titleView.setBackgroundColor(i);
            }
            int i2 = this.titleHeight;
            if (i2 != -1) {
                this.titleView.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
            }
            int i3 = this.titleTextColor;
            if (i3 != -1) {
                this.bannerTitle.setTextColor(i3);
            }
            int i4 = this.titleTextSize;
            if (i4 != -1) {
                this.bannerTitle.setTextSize(0, (float) i4);
            }
            List<String> list = this.titles;
            if (list != null && list.size() > 0) {
                this.bannerTitle.setText(this.titles.get(0));
                this.bannerTitle.setVisibility(0);
                this.titleView.setVisibility(0);
                return;
            }
            return;
        }
        throw new RuntimeException("[Banner] --> The number of titles and images is different");
    }

    private void setBannerStyleUI() {
        int i = this.count > 1 ? 0 : 8;
        int i2 = this.bannerStyle;
        if (i2 == 1) {
            this.indicator.setVisibility(i);
        } else if (i2 == 2) {
            this.numIndicator.setVisibility(i);
        } else if (i2 == 3) {
            this.numIndicatorInside.setVisibility(i);
            setTitleStyleUI();
        } else if (i2 == 4) {
            this.indicator.setVisibility(i);
            setTitleStyleUI();
        } else if (i2 == 5) {
            this.indicatorInside.setVisibility(i);
            setTitleStyleUI();
        }
    }

    private void initImages() {
        this.imageViews.clear();
        int i = this.bannerStyle;
        if (i == 1 || i == 4 || i == 5) {
            createIndicator();
        } else if (i == 3) {
            TextView textView = this.numIndicatorInside;
            textView.setText("1/" + this.count);
        } else if (i == 2) {
            TextView textView2 = this.numIndicator;
            textView2.setText("1/" + this.count);
        }
    }

    private void setImageList(List<?> list) {
        Object obj;
        if (list == null || list.size() <= 0) {
            this.bannerDefaultImage.setVisibility(0);
            Log.e(this.tag, "The image data set is empty.");
            return;
        }
        this.bannerDefaultImage.setVisibility(8);
        initImages();
        for (int i = 0; i <= this.count + 1; i++) {
            View view = null;
            ImageLoaderInterface imageLoaderInterface = this.imageLoader;
            if (imageLoaderInterface != null) {
                view = imageLoaderInterface.createImageView(this.context);
            }
            if (view == null) {
                view = new ImageView(this.context);
            }
            setScaleType(view);
            if (i == 0) {
                obj = list.get(this.count - 1);
            } else if (i == this.count + 1) {
                obj = list.get(0);
            } else {
                obj = list.get(i - 1);
            }
            this.imageViews.add(view);
            ImageLoaderInterface imageLoaderInterface2 = this.imageLoader;
            if (imageLoaderInterface2 != null) {
                imageLoaderInterface2.displayImage(this.context, obj, view);
            } else {
                Log.e(this.tag, "Please set images loader.");
            }
        }
    }

    private void setScaleType(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            switch (this.scaleType) {
                case 0:
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    return;
                case 1:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                case 2:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    return;
                case 3:
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return;
                case 4:
                    imageView.setScaleType(ImageView.ScaleType.FIT_END);
                    return;
                case 5:
                    imageView.setScaleType(ImageView.ScaleType.FIT_START);
                    return;
                case 6:
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    return;
                case 7:
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    return;
                default:
                    return;
            }
        }
    }

    private void createIndicator() {
        this.indicatorImages.clear();
        this.indicator.removeAllViews();
        this.indicatorInside.removeAllViews();
        for (int i = 0; i < this.count; i++) {
            ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mIndicatorWidth, this.mIndicatorHeight);
            int i2 = this.mIndicatorMargin;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            if (i == 0) {
                imageView.setImageResource(this.mIndicatorSelectedResId);
            } else {
                imageView.setImageResource(this.mIndicatorUnselectedResId);
            }
            this.indicatorImages.add(imageView);
            int i3 = this.bannerStyle;
            if (i3 == 1 || i3 == 4) {
                this.indicator.addView(imageView, layoutParams);
            } else if (i3 == 5) {
                this.indicatorInside.addView(imageView, layoutParams);
            }
        }
    }

    private void setData() {
        this.currentItem = 1;
        if (this.adapter == null) {
            this.adapter = new BannerPagerAdapter();
            this.viewPager.addOnPageChangeListener(this);
        }
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setFocusable(true);
        this.viewPager.setCurrentItem(1);
        int i = this.gravity;
        if (i != -1) {
            this.indicator.setGravity(i);
        }
        if (!this.isScroll || this.count <= 1) {
            this.viewPager.setScrollable(false);
        } else {
            this.viewPager.setScrollable(true);
        }
        if (this.isAutoPlay) {
            startAutoPlay();
        }
    }

    public void startAutoPlay() {
        this.handler.removeCallbacks(this.task);
        this.handler.postDelayed(this.task, (long) this.delayTime);
    }

    public void stopAutoPlay() {
        this.handler.removeCallbacks(this.task);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.isAutoPlay) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startAutoPlay();
            } else if (action == 0) {
                stopAutoPlay();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int toRealPosition(int i) {
        int i2 = this.count;
        int i3 = (i - 1) % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    class BannerPagerAdapter extends jz {
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        BannerPagerAdapter() {
        }

        public int getCount() {
            return Banner.this.imageViews.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, final int i) {
            viewGroup.addView(Banner.this.imageViews.get(i));
            View view = Banner.this.imageViews.get(i);
            if (Banner.this.bannerListener != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.youth.banner.Banner.BannerPagerAdapter.AnonymousClass1 */

                    public void onClick(View view) {
                        Log.e(Banner.this.tag, "你正在使用旧版点击事件接口，下标是从1开始，为了体验请更换为setOnBannerListener，下标从0开始计算");
                        Banner.this.bannerListener.OnBannerClick(i);
                    }
                });
            }
            if (Banner.this.listener != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.youth.banner.Banner.BannerPagerAdapter.AnonymousClass2 */

                    public void onClick(View view) {
                        Banner.this.listener.OnBannerClick(Banner.this.toRealPosition(i));
                    }
                });
            }
            return view;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    public void onPageScrollStateChanged(int i) {
        ViewPager.O0000O0o o0000O0o = this.mOnPageChangeListener;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
        if (i == 0) {
            int i2 = this.currentItem;
            if (i2 == 0) {
                this.viewPager.setCurrentItem(this.count, false);
            } else if (i2 == this.count + 1) {
                this.viewPager.setCurrentItem(1, false);
            }
        } else if (i == 1) {
            int i3 = this.currentItem;
            int i4 = this.count;
            if (i3 == i4 + 1) {
                this.viewPager.setCurrentItem(1, false);
            } else if (i3 == 0) {
                this.viewPager.setCurrentItem(i4, false);
            }
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.O0000O0o o0000O0o = this.mOnPageChangeListener;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(toRealPosition(i), f, i2);
        }
    }

    public void onPageSelected(int i) {
        this.currentItem = i;
        ViewPager.O0000O0o o0000O0o = this.mOnPageChangeListener;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(toRealPosition(i));
        }
        int i2 = this.bannerStyle;
        if (i2 == 1 || i2 == 4 || i2 == 5) {
            List<ImageView> list = this.indicatorImages;
            int i3 = this.count;
            list.get(((this.lastPosition - 1) + i3) % i3).setImageResource(this.mIndicatorUnselectedResId);
            List<ImageView> list2 = this.indicatorImages;
            int i4 = this.count;
            list2.get(((i - 1) + i4) % i4).setImageResource(this.mIndicatorSelectedResId);
            this.lastPosition = i;
        }
        if (i == 0) {
            i = this.count;
        }
        if (i > this.count) {
            i = 1;
        }
        int i5 = this.bannerStyle;
        if (i5 == 1) {
            return;
        }
        if (i5 != 2) {
            if (i5 == 3) {
                TextView textView = this.numIndicatorInside;
                textView.setText(i + "/" + this.count);
            } else if (i5 == 4) {
                this.bannerTitle.setText(this.titles.get(i - 1));
                return;
            } else if (i5 != 5) {
                return;
            }
            this.bannerTitle.setText(this.titles.get(i - 1));
            return;
        }
        TextView textView2 = this.numIndicator;
        textView2.setText(i + "/" + this.count);
    }

    @Deprecated
    public Banner setOnBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.bannerListener = onBannerClickListener;
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener onBannerListener) {
        this.listener = onBannerListener;
        return this;
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.mOnPageChangeListener = o0000O0o;
    }

    public void releaseBanner() {
        this.handler.removeCallbacksAndMessages(null);
    }
}
