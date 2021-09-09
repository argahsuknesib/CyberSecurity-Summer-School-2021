package com.wx.wheelview.widget;

import _m_j.dts;
import _m_j.dtu;
import _m_j.dtv;
import _m_j.dtw;
import _m_j.dtx;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.adapter.SimpleWheelAdapter;
import com.wx.wheelview.common.WheelViewException;
import java.util.HashMap;
import java.util.List;

public class WheelView<T> extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5941O000000o = 0;
    public int O00000Oo = 3;
    public List<T> O00000o = null;
    boolean O00000o0 = false;
    Skin O00000oO = Skin.None;
    O00000o0 O00000oo;
    public WheelView O0000O0o;
    public HashMap<String, List<T>> O0000OOo;
    public O000000o<T> O0000Oo;
    public O00000Oo<T> O0000Oo0;
    private int O0000OoO = -1;
    private String O0000Ooo;
    private boolean O0000o = false;
    private int O0000o0;
    private int O0000o00;
    private int O0000o0O;
    private int O0000o0o = 0;
    private dts<T> O0000oO;
    private Paint O0000oO0;
    private Handler O0000oOO = new Handler() {
        /* class com.wx.wheelview.widget.WheelView.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 256) {
                if (WheelView.this.O0000Oo0 != null) {
                    WheelView.this.O0000Oo0.onItemSelected(WheelView.this.getCurrentPosition(), WheelView.this.getSelectionItem());
                }
                if (WheelView.this.O0000O0o == null) {
                    return;
                }
                if (!WheelView.this.O0000OOo.isEmpty()) {
                    WheelView wheelView = WheelView.this.O0000O0o;
                    List list = WheelView.this.O0000OOo.get(WheelView.this.O00000o.get(WheelView.this.getCurrentPosition()));
                    if (!dtx.O000000o(list)) {
                        wheelView.postDelayed(new Runnable(list) {
                            /* class com.wx.wheelview.widget.WheelView.AnonymousClass6 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ List f5947O000000o;

                            {
                                this.f5947O000000o = r2;
                            }

                            public final void run() {
                                WheelView.this.setWheelData(this.f5947O000000o);
                                WheelView.super.setSelection(0);
                                WheelView.this.O000000o(true);
                            }
                        }, 10);
                        return;
                    }
                    throw new WheelViewException("join map data is error.");
                }
                throw new WheelViewException("JoinList is error.");
            }
        }
    };
    private AdapterView.OnItemClickListener O0000oOo = new AdapterView.OnItemClickListener() {
        /* class com.wx.wheelview.widget.WheelView.AnonymousClass2 */

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (WheelView.this.O0000Oo != null) {
                WheelView.this.getCurrentPosition();
                WheelView.this.getSelectionItem();
            }
        }
    };
    private AbsListView.OnScrollListener O0000oo = new AbsListView.OnScrollListener() {
        /* class com.wx.wheelview.widget.WheelView.AnonymousClass4 */

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            View childAt;
            if (i == 0 && (childAt = WheelView.this.getChildAt(0)) != null) {
                float y = childAt.getY();
                if (y != 0.0f && WheelView.this.f5941O000000o != 0) {
                    if (Math.abs(y) < ((float) (WheelView.this.f5941O000000o / 2))) {
                        WheelView.this.smoothScrollBy(WheelView.O000000o(y), 50);
                    } else {
                        WheelView.this.smoothScrollBy(WheelView.O000000o(((float) WheelView.this.f5941O000000o) + y), 50);
                    }
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i2 != 0) {
                WheelView.this.O000000o(false);
            }
        }
    };
    private View.OnTouchListener O0000oo0 = new View.OnTouchListener() {
        /* class com.wx.wheelview.widget.WheelView.AnonymousClass3 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    };

    public interface O000000o<T> {
    }

    public interface O00000Oo<T> {
        void onItemSelected(int i, T t);
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5949O000000o = -1;
        public int O00000Oo = -1;
        public int O00000o = -1;
        public int O00000o0 = -1;
        public int O00000oO = -1;
        public int O00000oo = -1;
        public float O0000O0o = -1.0f;
        public float O0000OOo = -1.0f;
    }

    public enum Skin {
        Common,
        Holo,
        None
    }

    public WheelView(Context context) {
        super(context);
        O000000o();
    }

    public WheelView(Context context, O00000o0 o00000o0) {
        super(context);
        setStyle(o00000o0);
        O000000o();
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public void setOnWheelItemSelectedListener(O00000Oo<T> o00000Oo) {
        this.O0000Oo0 = o00000Oo;
    }

    public void setOnWheelItemClickListener(O000000o<T> o000000o) {
        this.O0000Oo = o000000o;
    }

    private void O000000o() {
        if (this.O00000oo == null) {
            this.O00000oo = new O00000o0();
        }
        this.O0000oO0 = new Paint(1);
        setTag("com.wx.wheelview");
        setVerticalScrollBarEnabled(false);
        setScrollingCacheEnabled(false);
        setCacheColorHint(0);
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setDividerHeight(0);
        setOnItemClickListener(this.O0000oOo);
        setOnScrollListener(this.O0000oo);
        setOnTouchListener(this.O0000oo0);
        if (Build.VERSION.SDK_INT >= 21) {
            setNestedScrollingEnabled(true);
        }
        O00000Oo();
    }

    private void O00000Oo() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.wx.wheelview.widget.WheelView.AnonymousClass5 */

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX WARN: Type inference failed for: r2v8, types: [android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r3v12, types: [_m_j.dtv] */
            /* JADX WARN: Type inference failed for: r3v13, types: [_m_j.dtu] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 1 */
            public final void onGlobalLayout() {
                ? r2;
                if (Build.VERSION.SDK_INT >= 16) {
                    WheelView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    WheelView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (WheelView.this.getChildCount() > 0 && WheelView.this.f5941O000000o == 0) {
                    WheelView wheelView = WheelView.this;
                    wheelView.f5941O000000o = wheelView.getChildAt(0).getHeight();
                    if (WheelView.this.f5941O000000o != 0) {
                        WheelView.this.getLayoutParams().height = WheelView.this.f5941O000000o * WheelView.this.O00000Oo;
                        WheelView wheelView2 = WheelView.this;
                        wheelView2.O000000o(wheelView2.getFirstVisiblePosition(), WheelView.this.getCurrentPosition() + (WheelView.this.O00000Oo / 2), WheelView.this.O00000Oo / 2);
                        WheelView wheelView3 = WheelView.this;
                        Skin skin = wheelView3.O00000oO;
                        int width = wheelView3.getWidth();
                        int i = wheelView3.O00000Oo * wheelView3.f5941O000000o;
                        O00000o0 o00000o0 = wheelView3.O00000oo;
                        int i2 = wheelView3.O00000Oo;
                        int i3 = wheelView3.f5941O000000o;
                        if (skin.equals(Skin.Common)) {
                            r2 = new dtu(width, i, o00000o0, i2, i3);
                        } else if (skin.equals(Skin.Holo)) {
                            r2 = new dtv(width, i, o00000o0, i2, i3);
                        } else {
                            r2 = new dtw(width, i, o00000o0);
                        }
                        if (Build.VERSION.SDK_INT >= 16) {
                            wheelView3.setBackground(r2);
                        } else {
                            wheelView3.setBackgroundDrawable(r2);
                        }
                    } else {
                        throw new WheelViewException("wheel item is error.");
                    }
                }
            }
        });
    }

    public O00000o0 getStyle() {
        return this.O00000oo;
    }

    public void setStyle(O00000o0 o00000o0) {
        this.O00000oo = o00000o0;
    }

    public Skin getSkin() {
        return this.O00000oO;
    }

    public void setSkin(Skin skin) {
        this.O00000oO = skin;
    }

    public void setWheelSize(int i) {
        if ((i & 1) != 0) {
            this.O00000Oo = i;
            dts<T> dts = this.O0000oO;
            if (dts != null) {
                dts.setWheelSize(i);
                return;
            }
            return;
        }
        throw new WheelViewException("wheel size must be an odd number.");
    }

    public void setLoop(boolean z) {
        if (z != this.O00000o0) {
            this.O00000o0 = z;
            setSelection(0);
            dts<T> dts = this.O0000oO;
            if (dts != null) {
                dts.setLoop(z);
            }
        }
    }

    public void setWheelClickable(boolean z) {
        if (z != this.O0000o) {
            this.O0000o = z;
            dts<T> dts = this.O0000oO;
            if (dts != null) {
                dts.setClickable(z);
            }
        }
    }

    public int getSelection() {
        return this.O0000o0o;
    }

    public void setSelection(final int i) {
        this.O0000o0o = i;
        setVisibility(4);
        postDelayed(new Runnable() {
            /* class com.wx.wheelview.widget.WheelView.AnonymousClass7 */

            public final void run() {
                WheelView wheelView = WheelView.this;
                int i = i;
                if (dtx.O000000o(wheelView.O00000o)) {
                    i = 0;
                } else if (wheelView.O00000o0) {
                    i = (i + ((1073741823 / wheelView.O00000o.size()) * wheelView.O00000o.size())) - (wheelView.O00000Oo / 2);
                }
                WheelView.super.setSelection(i);
                WheelView.this.O000000o(false);
                WheelView.this.setVisibility(0);
            }
        }, 500);
    }

    public int getCurrentPosition() {
        return this.O0000OoO;
    }

    public T getSelectionItem() {
        int currentPosition = getCurrentPosition();
        if (currentPosition < 0) {
            currentPosition = 0;
        }
        List<T> list = this.O00000o;
        if (list == null || list.size() <= currentPosition) {
            return null;
        }
        return this.O00000o.get(currentPosition);
    }

    @Deprecated
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter == null || !(listAdapter instanceof dts)) {
            throw new WheelViewException("please invoke setWheelAdapter method.");
        }
        setWheelAdapter((dts) listAdapter);
    }

    public void setWheelAdapter(dts<T> dts) {
        super.setAdapter((ListAdapter) dts);
        this.O0000oO = dts;
        this.O0000oO.setData(this.O00000o).setWheelSize(this.O00000Oo).setLoop(this.O00000o0).setClickable(this.O0000o);
    }

    public void setWheelData(List<T> list) {
        if (!dtx.O000000o(list)) {
            this.O00000o = list;
            dts<T> dts = this.O0000oO;
            if (dts != null) {
                dts.setData(list);
                return;
            }
            return;
        }
        throw new WheelViewException("wheel datas are error.");
    }

    public int getWheelCount() {
        if (!dtx.O000000o(this.O00000o)) {
            return this.O00000o.size();
        }
        return 0;
    }

    public static int O000000o(float f) {
        if (Math.abs(f) <= 2.0f) {
            return (int) f;
        }
        if (Math.abs(f) < 12.0f) {
            return f > 0.0f ? 2 : -2;
        }
        return (int) (f / 6.0f);
    }

    public final void O000000o(boolean z) {
        if (getChildAt(0) != null && this.f5941O000000o != 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (!this.O00000o0 || firstVisiblePosition != 0) {
                int i = Math.abs(getChildAt(0).getY()) <= ((float) (this.f5941O000000o / 2)) ? firstVisiblePosition : firstVisiblePosition + 1;
                int i2 = this.O00000Oo;
                O000000o(firstVisiblePosition, (i2 / 2) + i, i2 / 2);
                if (this.O00000o0) {
                    i = (i + (this.O00000Oo / 2)) % getWheelCount();
                }
                if (i != this.O0000OoO || z) {
                    this.O0000OoO = i;
                    this.O0000oO.setCurrentPosition(i);
                    this.O0000oOO.removeMessages(256);
                    this.O0000oOO.sendEmptyMessageDelayed(256, 300);
                }
            }
        }
    }

    public final void O000000o(int i, int i2, int i3) {
        for (int i4 = i2 - i3; i4 <= i2 + i3; i4++) {
            View childAt = getChildAt(i4 - i);
            if (childAt != null) {
                dts<T> dts = this.O0000oO;
                if ((dts instanceof ArrayWheelAdapter) || (dts instanceof SimpleWheelAdapter)) {
                    O000000o(i4, i2, childAt, (TextView) childAt.findViewWithTag(101));
                } else {
                    TextView O000000o2 = dtx.O000000o(childAt);
                    if (O000000o2 != null) {
                        O000000o(i4, i2, childAt, O000000o2);
                    }
                }
            }
        }
    }

    private void O000000o(int i, int i2, View view, TextView textView) {
        float f = 16.0f;
        int i3 = -16777216;
        if (i2 == i) {
            if (this.O00000oo.O00000o != -1) {
                i3 = this.O00000oo.O00000o;
            } else if (this.O00000oo.O00000o0 != -1) {
                i3 = this.O00000oo.O00000o0;
            }
            if (this.O00000oo.O00000oO != -1) {
                f = (float) this.O00000oo.O00000oO;
            }
            if (this.O00000oo.O00000oo != -1) {
                f = (float) this.O00000oo.O00000oo;
            } else if (this.O00000oo.O0000OOo != -1.0f) {
                f *= this.O00000oo.O0000OOo;
            }
            O000000o(view, textView, i3, f, 1.0f);
            return;
        }
        if (this.O00000oo.O00000o0 != -1) {
            i3 = this.O00000oo.O00000o0;
        }
        if (this.O00000oo.O00000oO != -1) {
            f = (float) this.O00000oo.O00000oO;
        }
        O000000o(view, textView, i3, f, (float) Math.pow(this.O00000oo.O0000O0o != -1.0f ? (double) this.O00000oo.O0000O0o : 0.699999988079071d, (double) Math.abs(i - i2)));
    }

    private static void O000000o(View view, TextView textView, int i, float f, float f2) {
        textView.setTextColor(i);
        textView.setTextSize(1, f);
        view.setAlpha(f2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            Rect rect = new Rect(0, this.f5941O000000o * (this.O00000Oo / 2), getWidth(), this.f5941O000000o * ((this.O00000Oo / 2) + 1));
            this.O0000oO0.setTextSize((float) this.O0000o0);
            this.O0000oO0.setColor(this.O0000o00);
            Paint.FontMetricsInt fontMetricsInt = this.O0000oO0.getFontMetricsInt();
            this.O0000oO0.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.O0000Ooo, (float) (rect.centerX() + this.O0000o0O), (float) ((((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2), this.O0000oO0);
        }
    }
}
