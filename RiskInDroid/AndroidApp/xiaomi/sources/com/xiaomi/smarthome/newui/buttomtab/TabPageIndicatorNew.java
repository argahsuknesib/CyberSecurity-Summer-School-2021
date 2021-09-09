package com.xiaomi.smarthome.newui.buttomtab;

import _m_j.ftn;
import _m_j.gpv;
import _m_j.gqs;
import _m_j.gqt;
import _m_j.gqu;
import _m_j.gsy;
import _m_j.gue;
import _m_j.gus;
import _m_j.gva;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.widget.TabPageIndicator;
import com.xiaomi.smarthome.library.common.widget.ViewPager;
import com.xiaomi.smarthome.ui.LinearViewPager;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

public class TabPageIndicatorNew extends LinearLayout implements gqt {
    private static final CharSequence O0000O0o = "";

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000Oo f10198O000000o;
    public O00000o0 O00000Oo;
    public int O00000o;
    public LinearViewPager O00000o0;
    public TabPageIndicator.O000000o O00000oO;
    public O00000o O00000oo;
    private Runnable O0000OOo;
    private ViewPager.O00000o0 O0000Oo;
    private final View.OnClickListener O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private Object O0000o0;
    private Bitmap O0000o00;
    private ArrayList<O00000o> O0000o0O;
    private O00000o O0000o0o;

    public interface O00000Oo {
        boolean onIntercept(O00000o o00000o);
    }

    public interface O00000o0 {
        boolean onDoubleTap(O00000o o00000o);
    }

    public void setViewPager(ViewPager viewPager) {
    }

    public void setOnClickInterceptListener(O00000Oo o00000Oo) {
        this.f10198O000000o = o00000Oo;
    }

    public void setOnDoubleClickListener(O00000o0 o00000o0) {
        this.O00000Oo = o00000o0;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getPointBitmap() {
        Bitmap bitmap;
        synchronized (this.O0000o0) {
            if (this.O0000o00 == null) {
                this.O0000o00 = BitmapFactory.decodeResource(getResources(), R.drawable.common_point_now);
            }
            bitmap = this.O0000o00;
        }
        return bitmap;
    }

    public TabPageIndicatorNew(Context context) {
        this(context, null);
    }

    public TabPageIndicatorNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000Oo0 = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.buttomtab.TabPageIndicatorNew.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void
             arg types: [android.content.Context, java.lang.String, int]
             candidates:
              _m_j.gpv.O00000o0(android.content.SharedPreferences, java.lang.String, java.lang.String):void
              _m_j.gpv.O00000o0(android.content.Context, java.lang.String, boolean):void */
            public final void onClick(View view) {
                O00000o o00000o = (O00000o) view;
                if (TabPageIndicatorNew.this.f10198O000000o == null || !TabPageIndicatorNew.this.f10198O000000o.onIntercept(o00000o)) {
                    gva.O000000o().notifyViewClicked(o00000o.O00000oo);
                    if (o00000o == TabPageIndicatorNew.this.O00000oo) {
                        gpv.O00000o0(CommonApplication.getAppContext(), "my_home_red_dot_clicked", true);
                        TabPageIndicatorNew.this.O00000oo.invalidate();
                    }
                    int currentItem = TabPageIndicatorNew.this.O00000o0.getCurrentItem();
                    int index = o00000o.getIndex();
                    TabPageIndicatorNew.this.setCurrentItem(index);
                    if (currentItem == index && TabPageIndicatorNew.this.O00000oO != null) {
                        TabPageIndicatorNew.this.O00000oO.O000000o();
                    }
                    try {
                        gqu adapter = TabPageIndicatorNew.this.O00000o0.getAdapter();
                        if (adapter instanceof gqs) {
                            hxk hxk = hxi.O00000o;
                            String O00000o0 = ((gqs) adapter).O00000o0(index);
                            String O00000o02 = ((gqs) adapter).O00000o0(currentItem);
                            hxk.f952O000000o.O000000o("home_clicktab_home", "click", O00000o0, "from", O00000o02);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        };
        this.O0000o0 = new Object();
        this.O0000o0O = new ArrayList<>();
        setHorizontalScrollBarEnabled(false);
    }

    public void setOnTabReselectedListener(TabPageIndicator.O000000o o000000o) {
        this.O00000oO = o000000o;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.O0000OoO;
        if (i3 != 0) {
            this.O0000Ooo = i3;
            this.O0000OoO = 0;
        }
        setCurrentItem(this.O0000Ooo);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.O0000OOo;
        if (runnable != null) {
            post(runnable);
        }
        gva.O000000o().notifyRedPointChangedOld("red_point_setting_page");
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.O0000OOo;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        gva.O000000o().removeRedPointViewOld("red_point_setting_page");
        gva.O000000o().removeRedPointViewOld("red_point_shop_page");
        gva.O000000o().clearRedPointListenerOld();
    }

    public final void b_(int i) {
        ViewPager.O00000o0 o00000o0 = this.O0000Oo;
        if (o00000o0 != null) {
            o00000o0.b_(i);
        }
    }

    public final void c_(int i) {
        setCurrentItem(i);
        ViewPager.O00000o0 o00000o0 = this.O0000Oo;
        if (o00000o0 != null) {
            o00000o0.c_(i);
        }
    }

    public void setViewPager(LinearViewPager linearViewPager) {
        if (this.O00000o0 != linearViewPager) {
            if (linearViewPager.getAdapter() != null) {
                this.O00000o0 = linearViewPager;
                this.O00000o0.setOnPageChangeListener(this);
                O000000o();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    private void O000000o() {
        String str;
        removeAllViews();
        gqu adapter = this.O00000o0.getAdapter();
        gqs gqs = adapter instanceof gqs ? (gqs) adapter : null;
        int O000000o2 = adapter.O000000o();
        int i = 0;
        while (i < O000000o2) {
            CharSequence O00000Oo2 = adapter.O00000Oo(i);
            if (O00000Oo2 == null) {
                O00000Oo2 = O0000O0o;
            }
            int O00000o2 = gqs != null ? gqs.O00000o(i) : 0;
            if (gqs != null) {
                str = gqs.O00000oO(i);
            } else {
                str = "";
            }
            final O00000o o000000o = i == 0 ? new O000000o(getContext(), str) : new O00000o(getContext(), str);
            o000000o.O00000Oo = i;
            o000000o.setFocusable(true);
            o000000o.setOnClickListener(this.O0000Oo0);
            o000000o.O00000o.setText(O00000Oo2);
            try {
                if (Settings.System.getFloat(getContext().getContentResolver(), "font_scale") > 1.1f) {
                    ViewGroup.LayoutParams layoutParams = o000000o.O00000o.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = 0;
                        o000000o.O00000o.setLayoutParams(layoutParams);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            o000000o.O00000o.setVisibility(0);
            o000000o.O00000o0.setVisibility(0);
            if (O00000o2 != 0) {
                o000000o.O00000o0.setImageResource(O00000o2);
            }
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                gue.O000000o().setBottomTabIconByTag(str, o000000o.O00000o0);
            }
            o000000o.setOnTouchListener(new View.OnTouchListener(new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                /* class com.xiaomi.smarthome.newui.buttomtab.TabPageIndicatorNew.AnonymousClass2 */

                public final boolean onDoubleTap(MotionEvent motionEvent) {
                    if (TabPageIndicatorNew.this.O00000Oo == null) {
                        return false;
                    }
                    return TabPageIndicatorNew.this.O00000Oo.onDoubleTap(o000000o);
                }
            })) {
                /* class com.xiaomi.smarthome.newui.buttomtab.$$Lambda$TabPageIndicatorNew$FvXI1Jh1Ygf7eAPTaJxaGycAppY */
                private final /* synthetic */ GestureDetector f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.onTouchEvent(motionEvent);
                }
            });
            if (i == 1) {
                this.O0000o0o = o000000o;
                gva.O000000o().setRedPointViewOld("red_point_shop_page", new gus() {
                    /* class com.xiaomi.smarthome.newui.buttomtab.TabPageIndicatorNew.AnonymousClass3 */

                    public final void showRedPoint(boolean z) {
                        TabPageIndicatorNew.this.O000000o(z);
                    }
                });
            }
            if (i == O000000o2 - 1) {
                this.O00000oo = o000000o;
                gva.O000000o().setRedPointViewOld("red_point_setting_page", new gus() {
                    /* class com.xiaomi.smarthome.newui.buttomtab.TabPageIndicatorNew.AnonymousClass4 */

                    public final void showRedPoint(boolean z) {
                        TabPageIndicatorNew tabPageIndicatorNew = TabPageIndicatorNew.this;
                        if (tabPageIndicatorNew.O00000oo != null) {
                            if (z) {
                                tabPageIndicatorNew.O00000oo.showRedPoint(true);
                            } else {
                                tabPageIndicatorNew.O00000oo.showRedPoint(false);
                            }
                            tabPageIndicatorNew.O00000oo.postInvalidate();
                            tabPageIndicatorNew.O00000oo.requestLayout();
                        }
                    }
                });
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams2.gravity = 17;
            addView(o000000o, layoutParams2);
            this.O0000o0O.add(i, o000000o);
            i++;
        }
        if (this.O0000Ooo > O000000o2) {
            this.O0000Ooo = O000000o2 - 1;
        }
        setCurrentItem(this.O0000Ooo);
    }

    public void setCurrentItem(int i) {
        if (this.O00000o0 == null) {
            this.O0000OoO = i;
            return;
        }
        this.O0000OoO = 0;
        if (this.O0000Ooo != i) {
            this.O0000Ooo = i;
            ViewPager.O00000o0 o00000o0 = this.O0000Oo;
            if (o00000o0 != null) {
                o00000o0.c_(i);
            }
        }
        this.O00000o0.setCurrentItem(i);
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }

    public void setOnPageChangeListener(ViewPager.O00000o0 o00000o0) {
        this.O0000Oo = o00000o0;
    }

    public ArrayList<O00000o> getTabViewList() {
        return this.O0000o0O;
    }

    public class O00000o extends FrameLayout implements gus {

        /* renamed from: O000000o  reason: collision with root package name */
        private boolean f10204O000000o = false;
        public int O00000Oo;
        protected TextView O00000o;
        protected ImageView O00000o0;
        public ImageView O00000oO;
        public String O00000oo;
        public boolean O0000O0o = false;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, com.xiaomi.smarthome.newui.buttomtab.TabPageIndicatorNew$O00000o, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public O00000o(Context context, String str) {
            super(context);
            View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.bottom_bar_tab_view, (ViewGroup) this, false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(inflate, layoutParams);
            this.O00000o0 = (ImageView) inflate.findViewById(R.id.tab_img);
            this.O00000o = (TextView) inflate.findViewById(R.id.tab_text);
            this.O00000oO = (ImageView) inflate.findViewById(R.id.red_dot_iv);
            ImageView imageView = this.O00000oO;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            this.O00000oo = str;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            gsy.O00000Oo("MessageCenter", "onAttachedToWindow mViewTag" + this.O00000oo);
            gva.O000000o().setRedPointView(this.O00000oo, this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            gva.O000000o().removeRedPointView(this.O00000oo);
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (TabPageIndicatorNew.this.O00000o > 0 && getMeasuredWidth() > TabPageIndicatorNew.this.O00000o) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicatorNew.this.O00000o, 1073741824), i2);
            }
            setPadding(0, 0, 0, 0);
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            this.O00000o.setSelected(isSelected());
            postInvalidate();
        }

        public int getIndex() {
            return this.O00000Oo;
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            int i;
            super.onDraw(canvas);
            getPaddingLeft();
            getPaddingRight();
            if (this.f10204O000000o) {
                int paddingTop = getPaddingTop();
                if (this.O0000O0o) {
                    i = this.O00000o0.getMeasuredWidth();
                } else {
                    i = (getWidth() - this.O00000o.getCompoundDrawables()[1].getBounds().width()) / 2;
                }
                Bitmap pointBitmap = TabPageIndicatorNew.this.getPointBitmap();
                canvas.drawBitmap(pointBitmap, new Rect(0, 0, pointBitmap.getWidth(), pointBitmap.getHeight()), new RectF((float) ((getWidth() - i) + 10), (float) (paddingTop - (pointBitmap.getHeight() / 2)), (float) ((getWidth() - i) + 10 + pointBitmap.getWidth()), (float) (paddingTop + (pointBitmap.getHeight() / 2))), new Paint(1));
            }
        }

        public boolean getShowPoint() {
            return this.f10204O000000o;
        }

        public void showRedPoint(final boolean z) {
            ImageView imageView = this.O00000oO;
            if (imageView != null) {
                imageView.post(new Runnable() {
                    /* class com.xiaomi.smarthome.newui.buttomtab.TabPageIndicatorNew.O00000o.AnonymousClass1 */

                    public final void run() {
                        O00000o.this.O00000oO.setVisibility(z ? 0 : 8);
                    }
                });
            }
        }
    }

    public class O000000o extends O00000o implements Consumer<Boolean> {
        private final int[] O0000Oo = {R.attr.state_house};
        private final int[] O0000Oo0 = {R.attr.state_pin};
        private final int[] O0000OoO = {R.attr.state_house_inactive};
        private boolean O0000Ooo = false;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            setToPinIcon(((Boolean) obj).booleanValue());
        }

        public O000000o(Context context, String str) {
            super(context, str);
        }

        public final void setSelected(boolean z) {
            super.setSelected(z);
            O000000o();
        }

        /* access modifiers changed from: package-private */
        public final void setToPinIcon(boolean z) {
            this.O0000Ooo = z;
            O000000o();
        }

        private void O000000o() {
            if (!isSelected()) {
                this.O00000o0.setImageState(this.O0000OoO, false);
            } else if (this.O0000Ooo) {
                this.O00000o0.setImageState(this.O0000Oo0, false);
            } else {
                this.O00000o0.setImageState(this.O0000Oo, false);
            }
            this.O00000o.setText((!isSelected() || !this.O0000Ooo) ? R.string.client_manage : R.string.client_manage_pin_new);
        }

        /* access modifiers changed from: protected */
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            gue.O000000o().subscribeMainDeviceTabAnimManager(this);
        }
    }

    public int getSelectedTabIndex() {
        return this.O0000Ooo;
    }

    public int getLastTabIndex() {
        return this.O0000OoO;
    }

    public final void O000000o(boolean z) {
        O00000o o00000o = this.O0000o0o;
        if (o00000o != null) {
            o00000o.showRedPoint(z);
            this.O0000o0o.postInvalidate();
            this.O0000o0o.requestLayout();
        }
    }
}
