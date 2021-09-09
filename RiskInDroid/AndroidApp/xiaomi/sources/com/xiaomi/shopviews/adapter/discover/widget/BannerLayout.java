package com.xiaomi.shopviews.adapter.discover.widget;

import _m_j.evp;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class BannerLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f3913O000000o;
    public Drawable O00000Oo;
    public int O00000o;
    public Drawable O00000o0;
    public RecyclerView O00000oO;
    public BannerLayoutManager O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    int O0000Oo;
    public int O0000Oo0;
    float O0000OoO;
    float O0000Ooo;
    private boolean O0000o;
    private boolean O0000o0;
    protected Handler O0000o00;
    private RecyclerView O0000o0O;
    private O000000o O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;

    public BannerLayout(Context context) {
        this(context, null);
    }

    public BannerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000O0o = 1000;
        int i2 = 1;
        this.O0000OOo = 1;
        this.O0000oO0 = false;
        this.O0000oO = true;
        this.O0000o00 = new Handler(new Handler.Callback() {
            /* class com.xiaomi.shopviews.adapter.discover.widget.BannerLayout.AnonymousClass1 */

            public final boolean handleMessage(Message message) {
                if (message.what != BannerLayout.this.O0000O0o || BannerLayout.this.O0000Oo0 != BannerLayout.this.O00000oo.O00000o()) {
                    return false;
                }
                BannerLayout.this.O0000Oo0++;
                BannerLayout.this.O00000oO.smoothScrollToPosition(BannerLayout.this.O0000Oo0);
                BannerLayout.this.O0000o00.sendEmptyMessageDelayed(BannerLayout.this.O0000O0o, (long) BannerLayout.this.f3913O000000o);
                BannerLayout.this.O000000o();
                return false;
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.autoPlaying, R.attr.centerScale, R.attr.interval, R.attr.itemSpace, R.attr.moveSpeed, R.attr.orientation, R.attr.showIndicator});
        this.O0000o0 = obtainStyledAttributes.getBoolean(6, true);
        this.f3913O000000o = obtainStyledAttributes.getInt(2, 4000);
        this.O0000oO = obtainStyledAttributes.getBoolean(0, true);
        this.O0000Oo = obtainStyledAttributes.getInt(3, 20);
        this.O0000OoO = obtainStyledAttributes.getFloat(1, 1.2f);
        this.O0000Ooo = obtainStyledAttributes.getFloat(4, 1.0f);
        if (this.O00000Oo == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-65536);
            gradientDrawable.setSize(O000000o(5), O000000o(5));
            gradientDrawable.setCornerRadius((float) (O000000o(5) / 2));
            this.O00000Oo = new LayerDrawable(new Drawable[]{gradientDrawable});
        }
        if (this.O00000o0 == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(-7829368);
            gradientDrawable2.setSize(O000000o(5), O000000o(5));
            gradientDrawable2.setCornerRadius((float) (O000000o(5) / 2));
            this.O00000o0 = new LayerDrawable(new Drawable[]{gradientDrawable2});
        }
        this.O00000o = O000000o(4);
        int O000000o2 = O000000o(16);
        int O000000o3 = O000000o(0);
        int O000000o4 = O000000o(11);
        int i3 = obtainStyledAttributes.getInt(5, 0);
        i2 = (i3 == 0 || i3 != 1) ? 0 : i2;
        obtainStyledAttributes.recycle();
        this.O00000oO = new RecyclerView(context);
        addView(this.O00000oO, new FrameLayout.LayoutParams(-1, -1));
        getContext();
        this.O00000oo = new BannerLayoutManager(i2);
        BannerLayoutManager bannerLayoutManager = this.O00000oo;
        bannerLayoutManager.O0000Ooo = this.O0000Oo;
        bannerLayoutManager.O0000o00 = this.O0000OoO;
        bannerLayoutManager.O000000o(this.O0000Ooo);
        this.O00000oO.setLayoutManager(this.O00000oo);
        evp evp = new evp();
        RecyclerView recyclerView = this.O00000oO;
        if (evp.f15858O000000o != recyclerView) {
            if (evp.f15858O000000o != null) {
                evp.f15858O000000o.removeOnScrollListener(evp.O00000o);
                evp.f15858O000000o.setOnFlingListener(null);
            }
            evp.f15858O000000o = recyclerView;
            if (evp.f15858O000000o != null) {
                RecyclerView.LayoutManager layoutManager = evp.f15858O000000o.getLayoutManager();
                if (layoutManager instanceof BannerLayoutManager) {
                    if (evp.f15858O000000o.getOnFlingListener() == null) {
                        evp.f15858O000000o.addOnScrollListener(evp.O00000o);
                        evp.f15858O000000o.setOnFlingListener(evp);
                        evp.O00000Oo = new Scroller(evp.f15858O000000o.getContext(), new DecelerateInterpolator());
                        BannerLayoutManager bannerLayoutManager2 = (BannerLayoutManager) layoutManager;
                        evp.O000000o(bannerLayoutManager2, bannerLayoutManager2.O0000Oo);
                    } else {
                        throw new IllegalStateException("An instance of OnFlingListener already set.");
                    }
                }
            }
        }
        this.O0000o0O = new RecyclerView(context);
        this.O0000o0O.setLayoutManager(new LinearLayoutManager(context, i2, false));
        this.O0000o0o = new O000000o();
        this.O0000o0O.setAdapter(this.O0000o0o);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388691;
        layoutParams.setMargins(O000000o2, 0, O000000o3, O000000o4);
        addView(this.O0000o0O, layoutParams);
        if (!this.O0000o0) {
            this.O0000o0O.setVisibility(8);
        }
    }

    public void setAutoPlaying(boolean z) {
        this.O0000oO = z;
        setPlaying(this.O0000oO);
    }

    public void setShowIndicator(boolean z) {
        this.O0000o0 = z;
        this.O0000o0O.setVisibility(z ? 0 : 8);
    }

    public void setCenterScale(float f) {
        this.O0000OoO = f;
        this.O00000oo.O0000o00 = f;
    }

    public void setMoveSpeed(float f) {
        this.O0000Ooo = f;
        this.O00000oo.O000000o(f);
    }

    public void setItemSpace(int i) {
        this.O0000Oo = i;
        this.O00000oo.O0000Ooo = i;
    }

    public void setAutoPlayDuration(int i) {
        this.f3913O000000o = i;
    }

    public void setOrientation(int i) {
        this.O00000oo.O000000o(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        return;
     */
    public synchronized void setPlaying(boolean z) {
        if (this.O0000oO && this.O0000o) {
            if (!this.O0000oO0 && z) {
                this.O0000o00.sendEmptyMessageDelayed(this.O0000O0o, (long) this.f3913O000000o);
                this.O0000oO0 = true;
            } else if (this.O0000oO0 && !z) {
                this.O0000o00.removeMessages(this.O0000O0o);
                this.O0000oO0 = false;
            }
        }
    }

    public void setAdapter(RecyclerView.O000000o o000000o) {
        boolean z = false;
        this.O0000o = false;
        this.O00000oO.setAdapter(o000000o);
        this.O0000OOo = o000000o.getItemCount();
        BannerLayoutManager bannerLayoutManager = this.O00000oo;
        if (this.O0000OOo >= 3) {
            z = true;
        }
        bannerLayoutManager.assertNotInLayoutOrScroll(null);
        if (z != bannerLayoutManager.O0000OoO) {
            bannerLayoutManager.O0000OoO = z;
            bannerLayoutManager.requestLayout();
        }
        setPlaying(true);
        this.O00000oO.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.shopviews.adapter.discover.widget.BannerLayout.AnonymousClass2 */

            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i != 0) {
                    BannerLayout.this.setPlaying(false);
                }
            }

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int O00000o = BannerLayout.this.O00000oo.O00000o();
                Log.d("xxx", "onScrollStateChanged");
                if (BannerLayout.this.O0000Oo0 != O00000o) {
                    BannerLayout.this.O0000Oo0 = O00000o;
                }
                if (i == 0) {
                    BannerLayout.this.setPlaying(true);
                }
                BannerLayout.this.O000000o();
            }
        });
        this.O0000o = true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setPlaying(false);
        } else if (action == 1 || action == 3) {
            setPlaying(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPlaying(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setPlaying(false);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            setPlaying(true);
        } else {
            setPlaying(false);
        }
    }

    public class O000000o extends RecyclerView.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f3916O000000o = 0;

        protected O000000o() {
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ImageView imageView = new ImageView(BannerLayout.this.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
            layoutParams.setMargins(BannerLayout.this.O00000o, BannerLayout.this.O00000o, BannerLayout.this.O00000o, BannerLayout.this.O00000o);
            imageView.setLayoutParams(layoutParams);
            return new RecyclerView.O000OOo0(imageView) {
                /* class com.xiaomi.shopviews.adapter.discover.widget.BannerLayout.O000000o.AnonymousClass1 */
            };
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ((ImageView) o000OOo0.itemView).setImageDrawable(this.f3916O000000o == i ? BannerLayout.this.O00000Oo : BannerLayout.this.O00000o0);
        }

        public final int getItemCount() {
            return BannerLayout.this.O0000OOo;
        }
    }

    private static int O000000o(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, Resources.getSystem().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public final synchronized void O000000o() {
        if (this.O0000o0 && this.O0000OOo > 1) {
            this.O0000o0o.f3916O000000o = this.O0000Oo0 % this.O0000OOo;
            this.O0000o0o.notifyDataSetChanged();
        }
    }
}
