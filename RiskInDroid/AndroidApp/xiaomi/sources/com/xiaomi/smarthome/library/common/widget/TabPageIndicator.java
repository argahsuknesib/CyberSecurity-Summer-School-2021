package com.xiaomi.smarthome.library.common.widget;

import _m_j.gpv;
import _m_j.gqs;
import _m_j.gqt;
import _m_j.gqu;
import _m_j.gup;
import _m_j.gus;
import _m_j.gut;
import _m_j.gva;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ViewPager;
import java.util.ArrayList;

public class TabPageIndicator extends HorizontalScrollView implements gqt, gup {
    private static final CharSequence O0000OoO = "";

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f9262O000000o;
    public ViewPager O00000Oo;
    public O000000o O00000o;
    public int O00000o0;
    public O00000Oo O00000oO;
    O00000Oo O00000oo;
    boolean O0000O0o;
    boolean O0000OOo;
    boolean O0000Oo;
    boolean O0000Oo0;
    private final View.OnClickListener O0000Ooo;
    private Bitmap O0000o;
    private ViewPager.O00000o0 O0000o0;
    private final IcsLinearLayout O0000o00;
    private int O0000o0O;
    private int O0000o0o;
    private gut O0000oO;
    private Object O0000oO0;
    private gut O0000oOO;
    private gut O0000oOo;
    private ArrayList<O00000Oo> O0000oo;
    private gut O0000oo0;

    public interface O000000o {
        void O000000o();
    }

    /* access modifiers changed from: package-private */
    public Bitmap getPointBitmap() {
        Bitmap bitmap;
        synchronized (this.O0000oO0) {
            if (this.O0000o == null) {
                this.O0000o = BitmapFactory.decodeResource(getResources(), R.drawable.common_point_now);
            }
            bitmap = this.O0000o;
        }
        return bitmap;
    }

    public TabPageIndicator(Context context) {
        this(context, null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Ooo = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
             arg types: [java.lang.String, int]
             candidates:
              _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
              _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void
             arg types: [int, int]
             candidates:
              com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, int):void
              com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void */
            public final void onClick(View view) {
                O00000Oo o00000Oo = (O00000Oo) view;
                if (o00000Oo == TabPageIndicator.this.O00000oO) {
                    gpv.O00000Oo("my_home_red_dot_clicked", true);
                    TabPageIndicator.this.O00000oO.invalidate();
                }
                int currentItem = TabPageIndicator.this.O00000Oo.getCurrentItem();
                int index = o00000Oo.getIndex();
                TabPageIndicator.this.O00000Oo.O000000o(index, false);
                if (currentItem == index && TabPageIndicator.this.O00000o != null) {
                    TabPageIndicator.this.O00000o.O000000o();
                }
            }
        };
        this.O0000oO0 = new Object();
        this.O0000oO = new gut() {
            /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass2 */

            public final boolean O000000o() {
                return TabPageIndicator.this.O0000O0o;
            }
        };
        this.O0000oOO = new gut() {
            /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass3 */

            public final boolean O000000o() {
                return TabPageIndicator.this.O0000OOo;
            }
        };
        this.O0000oOo = new gut() {
            /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass4 */

            public final boolean O000000o() {
                return TabPageIndicator.this.O0000Oo0;
            }
        };
        this.O0000oo0 = new gut() {
            /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass5 */

            public final boolean O000000o() {
                return TabPageIndicator.this.O0000Oo;
            }
        };
        this.O0000oo = new ArrayList<>();
        this.O0000O0o = false;
        this.O0000OOo = false;
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        setHorizontalScrollBarEnabled(false);
        this.O0000o00 = new IcsLinearLayout(context);
        addView(this.O0000o00, new ViewGroup.LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.O0000o00.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.O00000o0 = -1;
        } else if (childCount > 2) {
            this.O00000o0 = (int) (((float) View.MeasureSpec.getSize(i)) * 0.25f);
        } else {
            this.O00000o0 = View.MeasureSpec.getSize(i) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setCurrentItem(this.O0000o0o);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f9262O000000o;
        if (runnable != null) {
            post(runnable);
        }
        gva.O000000o().registerListenerOld("red_point_setting_page", this.O0000oO);
        gva.O000000o().registerListenerOld("red_point_setting_page", this.O0000oOO);
        gva.O000000o().registerListenerOld("red_point_setting_page", this.O0000oOo);
        gva.O000000o().registerListenerOld("red_point_setting_page", this.O0000oo0);
        gva.O000000o().notifyRedPointChangedOld("red_point_setting_page");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f9262O000000o;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        gva.O000000o().unregisterListenerOld("red_point_setting_page", this.O0000oO);
        gva.O000000o().unregisterListenerOld("red_point_setting_page", this.O0000oOO);
        gva.O000000o().unregisterListenerOld("red_point_setting_page", this.O0000oOo);
        gva.O000000o().unregisterListenerOld("red_point_setting_page", this.O0000oo0);
        gva.O000000o().removeRedPointView("red_point_setting_page");
        gva.O000000o().removeRedPointView("red_point_shop_page");
        gva.O000000o().clearRedPointListenerOld();
    }

    public final void b_(int i) {
        ViewPager.O00000o0 o00000o0 = this.O0000o0;
        if (o00000o0 != null) {
            o00000o0.b_(i);
        }
    }

    public final void c_(int i) {
        setCurrentItem(i);
        ViewPager.O00000o0 o00000o0 = this.O0000o0;
        if (o00000o0 != null) {
            o00000o0.c_(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.O00000Oo;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() != null) {
                this.O00000Oo = viewPager;
                viewPager.setOnPageChangeListener(this);
                O000000o();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    private void O000000o() {
        int i;
        this.O0000o00.removeAllViews();
        gqu adapter = this.O00000Oo.getAdapter();
        gqs gqs = adapter instanceof gqs ? (gqs) adapter : null;
        int O000000o2 = adapter.O000000o();
        for (int i2 = 0; i2 < O000000o2; i2++) {
            CharSequence O00000Oo2 = adapter.O00000Oo(i2);
            if (O00000Oo2 == null) {
                O00000Oo2 = O0000OoO;
            }
            if (gqs != null) {
                i = gqs.O00000o(i2);
            } else {
                i = 0;
            }
            O00000Oo o00000Oo = new O00000Oo(getContext());
            o00000Oo.f9271O000000o = i2;
            o00000Oo.setFocusable(true);
            o00000Oo.setOnClickListener(this.O0000Ooo);
            o00000Oo.O00000o0.setText(O00000Oo2);
            o00000Oo.O00000o0.setVisibility(0);
            o00000Oo.O00000Oo.setVisibility(8);
            if (i != 0) {
                o00000Oo.O00000o0.setCompoundDrawablesWithIntrinsicBounds(0, i, 0, 0);
                o00000Oo.O00000o0.setCompoundDrawablePadding(-12);
            }
            if (i2 == 1) {
                this.O00000oo = o00000Oo;
                gva.O000000o().setRedPointViewOld("red_point_shop_page", new gus() {
                    /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass7 */

                    public final void showRedPoint(boolean z) {
                        TabPageIndicator tabPageIndicator = TabPageIndicator.this;
                        if (tabPageIndicator.O00000oo != null && tabPageIndicator.O00000oo.getShowPoint() != z) {
                            tabPageIndicator.O00000oo.setShowPoint(z);
                            tabPageIndicator.O00000oo.postInvalidate();
                            tabPageIndicator.O00000oo.requestLayout();
                        }
                    }
                });
            }
            if (i2 == O000000o2 - 1) {
                this.O00000oO = o00000Oo;
                gva.O000000o().setRedPointViewOld("red_point_setting_page", new gus() {
                    /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass8 */

                    public final void showRedPoint(boolean z) {
                        TabPageIndicator tabPageIndicator = TabPageIndicator.this;
                        if (tabPageIndicator.O00000oO != null) {
                            if (z) {
                                tabPageIndicator.O00000oO.setShowPoint(true);
                            } else {
                                tabPageIndicator.O00000oO.setShowPoint(false);
                            }
                            tabPageIndicator.O00000oO.postInvalidate();
                            tabPageIndicator.O00000oO.requestLayout();
                        }
                    }
                });
            }
            this.O0000o00.addView(o00000Oo, new LinearLayout.LayoutParams(0, -1, 1.0f));
            this.O0000oo.add(i2, o00000Oo);
        }
        if (this.O0000o0o > O000000o2) {
            this.O0000o0o = O000000o2 - 1;
        }
        setCurrentItem(this.O0000o0o);
        requestLayout();
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.O00000Oo;
        if (viewPager != null) {
            this.O0000o0O = this.O0000o0o;
            this.O0000o0o = i;
            viewPager.setCurrentItem(i);
            int childCount = this.O0000o00.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.O0000o00.getChildAt(i2);
                boolean z = i2 == i;
                childAt.setSelected(z);
                if (z) {
                    final View childAt2 = this.O0000o00.getChildAt(i);
                    Runnable runnable = this.f9262O000000o;
                    if (runnable != null) {
                        removeCallbacks(runnable);
                    }
                    this.f9262O000000o = new Runnable() {
                        /* class com.xiaomi.smarthome.library.common.widget.TabPageIndicator.AnonymousClass6 */

                        public final void run() {
                            TabPageIndicator.this.smoothScrollTo(childAt2.getLeft() - ((TabPageIndicator.this.getWidth() - childAt2.getWidth()) / 2), 0);
                            TabPageIndicator.this.f9262O000000o = null;
                        }
                    };
                    post(this.f9262O000000o);
                }
                i2++;
            }
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setOnPageChangeListener(ViewPager.O00000o0 o00000o0) {
        this.O0000o0 = o00000o0;
    }

    public class O00000Oo extends FrameLayout {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f9271O000000o;
        public ImageView O00000Oo;
        public boolean O00000o = false;
        public TextView O00000o0;
        private boolean O00000oo = false;

        public O00000Oo(Context context) {
            super(context);
            this.O00000Oo = new ImageView(context);
            addView(this.O00000Oo);
            this.O00000o0 = new TextView(context, null, R.attr.vpiTabPageIndicatorStyle);
            addView(this.O00000o0);
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (TabPageIndicator.this.O00000o0 > 0 && getMeasuredWidth() > TabPageIndicator.this.O00000o0) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.O00000o0, 1073741824), i2);
            }
            setPadding(0, 0, 0, 0);
        }

        /* access modifiers changed from: protected */
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            this.O00000o0.setSelected(isSelected());
        }

        public final int getIndex() {
            return this.f9271O000000o;
        }

        /* access modifiers changed from: protected */
        public final void onDraw(Canvas canvas) {
            int i;
            super.onDraw(canvas);
            getPaddingLeft();
            getPaddingRight();
            if (this.O00000oo) {
                int paddingTop = getPaddingTop();
                if (this.O00000o) {
                    i = this.O00000Oo.getMeasuredWidth();
                } else {
                    i = (getWidth() - this.O00000o0.getCompoundDrawables()[1].getBounds().width()) / 2;
                }
                Bitmap pointBitmap = TabPageIndicator.this.getPointBitmap();
                canvas.drawBitmap(pointBitmap, new Rect(0, 0, pointBitmap.getWidth(), pointBitmap.getHeight()), new RectF((float) ((getWidth() - i) + 10), (float) (paddingTop - (pointBitmap.getHeight() / 2)), (float) ((getWidth() - i) + 10 + pointBitmap.getWidth()), (float) (paddingTop + (pointBitmap.getHeight() / 2))), new Paint(1));
            }
        }

        public final void setShowPoint(boolean z) {
            this.O00000oo = z;
        }

        public final boolean getShowPoint() {
            return this.O00000oo;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public final void O000000o(int i) {
        if (this.O00000oO != null) {
            boolean O000000o2 = gpv.O000000o("my_home_red_dot_clicked", true);
            if (i > 0) {
                this.O0000O0o = true;
                gpv.O00000Oo("my_home_red_dot_clicked", false);
            } else if (!O000000o2) {
                this.O0000O0o = true;
            } else {
                this.O0000O0o = false;
            }
            gva.O000000o().notifyRedPointChangedOld("red_point_setting_page");
        }
    }

    public final void O000000o(boolean z, boolean z2) {
        if (!z) {
            this.O0000OOo = false;
        } else if (!z2) {
            this.O0000OOo = true;
        } else {
            this.O0000OOo = false;
        }
        gva.O000000o().notifyRedPointChangedOld("red_point_setting_page");
    }

    public final void O00000Oo(int i) {
        this.O0000Oo0 = i > 0;
        gva.O000000o().notifyRedPointChangedOld("red_point_setting_page");
    }

    public final void O00000Oo(boolean z, boolean z2) {
        if (!z) {
            this.O0000Oo = false;
        } else if (!z2) {
            this.O0000Oo = true;
        } else {
            this.O0000Oo = false;
        }
        gva.O000000o().notifyRedPointChangedOld("red_point_setting_page");
    }

    public int getSelectedTabIndex() {
        return this.O0000o0o;
    }

    public int getLastTabIndex() {
        return this.O0000o0O;
    }
}
