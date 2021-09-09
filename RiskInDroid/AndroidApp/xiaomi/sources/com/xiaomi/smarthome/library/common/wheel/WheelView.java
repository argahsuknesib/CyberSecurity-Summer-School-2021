package com.xiaomi.smarthome.library.common.wheel;

import _m_j.gpc;
import _m_j.gqk;
import _m_j.gql;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
    private static final int O0000Oo = gpc.O000000o(20.0f);
    private static final int O0000OoO = ServiceApplication.getAppContext().getResources().getColor(R.color.mj_color_red_normal);
    private static final int O0000Ooo = ServiceApplication.getAppContext().getResources().getColor(R.color.mj_color_black_40_transparent);
    private static final int[] O0000o00 = {-15658735, 11184810, 11184810};

    /* renamed from: O000000o  reason: collision with root package name */
    public gql f9130O000000o;
    public int O00000Oo;
    public int O00000o;
    public boolean O00000o0;
    public Scroller O00000oO;
    public int O00000oo;
    boolean O0000O0o;
    List<Object> O0000OOo;
    public Handler O0000Oo0;
    private int O0000o;
    private int O0000o0;
    private int O0000o0O;
    private int O0000o0o;
    private TextPaint O0000oO;
    private TextPaint O0000oO0;
    private StaticLayout O0000oOO;
    private StaticLayout O0000oOo;
    private String O0000oo;
    private StaticLayout O0000oo0;
    private Drawable O0000ooO;
    private GestureDetector O0000ooo;
    private int O000O00o;
    private int O000O0OO;
    private GestureDetector.SimpleOnGestureListener O000O0Oo;
    private final int O000O0o0;
    private final int O00oOoOo;
    private List<gqk> O00oOooO;
    private int O00oOooo;

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9130O000000o = null;
        this.O00000Oo = 0;
        this.O0000o0 = 0;
        this.O0000o0O = 0;
        this.O0000o0o = 5;
        this.O0000o = 0;
        this.O0000O0o = false;
        this.O00oOooO = new LinkedList();
        this.O0000OOo = new LinkedList();
        this.O000O00o = O0000Oo;
        this.O000O0OO = 0;
        this.O000O0Oo = new GestureDetector.SimpleOnGestureListener() {
            /* class com.xiaomi.smarthome.library.common.wheel.WheelView.AnonymousClass1 */

            public final boolean onDown(MotionEvent motionEvent) {
                if (!WheelView.this.O00000o0) {
                    return false;
                }
                WheelView.this.O00000oO.forceFinished(true);
                WheelView.this.O000000o();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView wheelView = WheelView.this;
                if (!wheelView.O00000o0) {
                    wheelView.O00000o0 = true;
                    Iterator<Object> it = wheelView.O0000OOo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                WheelView.this.O000000o((int) (-f2));
                return true;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView wheelView = WheelView.this;
                wheelView.O00000oo = (wheelView.O00000Oo * WheelView.this.getItemHeight()) + WheelView.this.O00000o;
                int O000000o2 = WheelView.this.O0000O0o ? Integer.MAX_VALUE : WheelView.this.f9130O000000o.O000000o() * WheelView.this.getItemHeight();
                WheelView.this.O00000oO.fling(0, WheelView.this.O00000oo, 0, ((int) (-f2)) / 2, 0, 0, WheelView.this.O0000O0o ? -O000000o2 : 0, O000000o2);
                WheelView.this.setNextMessage(0);
                return true;
            }
        };
        this.O00oOoOo = 0;
        this.O000O0o0 = 1;
        this.O0000Oo0 = new Handler() {
            /* class com.xiaomi.smarthome.library.common.wheel.WheelView.AnonymousClass2 */

            public final void handleMessage(Message message) {
                WheelView.this.O00000oO.computeScrollOffset();
                int currY = WheelView.this.O00000oO.getCurrY();
                int i = WheelView.this.O00000oo - currY;
                WheelView wheelView = WheelView.this;
                wheelView.O00000oo = currY;
                if (i != 0) {
                    wheelView.O000000o(i);
                }
                if (Math.abs(currY - WheelView.this.O00000oO.getFinalY()) <= 0) {
                    WheelView.this.O00000oO.getFinalY();
                    WheelView.this.O00000oO.forceFinished(true);
                }
                if (!WheelView.this.O00000oO.isFinished()) {
                    WheelView.this.O0000Oo0.sendEmptyMessage(message.what);
                } else if (message.what == 0) {
                    WheelView.this.O00000Oo();
                } else {
                    WheelView.this.O00000o0();
                }
            }
        };
        this.O00oOooo = attributeSet.getAttributeIntValue(null, "WheelViewTextSize", 32);
        this.O000O00o = attributeSet.getAttributeIntValue(null, "WheelViewItemHeight", O0000Oo);
        this.O000O0OO = attributeSet.getAttributeIntValue(null, "WheelViewItemSpace", 0);
        O000000o(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9130O000000o = null;
        this.O00000Oo = 0;
        this.O0000o0 = 0;
        this.O0000o0O = 0;
        this.O0000o0o = 5;
        this.O0000o = 0;
        this.O0000O0o = false;
        this.O00oOooO = new LinkedList();
        this.O0000OOo = new LinkedList();
        this.O000O00o = O0000Oo;
        this.O000O0OO = 0;
        this.O000O0Oo = new GestureDetector.SimpleOnGestureListener() {
            /* class com.xiaomi.smarthome.library.common.wheel.WheelView.AnonymousClass1 */

            public final boolean onDown(MotionEvent motionEvent) {
                if (!WheelView.this.O00000o0) {
                    return false;
                }
                WheelView.this.O00000oO.forceFinished(true);
                WheelView.this.O000000o();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView wheelView = WheelView.this;
                if (!wheelView.O00000o0) {
                    wheelView.O00000o0 = true;
                    Iterator<Object> it = wheelView.O0000OOo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                WheelView.this.O000000o((int) (-f2));
                return true;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView wheelView = WheelView.this;
                wheelView.O00000oo = (wheelView.O00000Oo * WheelView.this.getItemHeight()) + WheelView.this.O00000o;
                int O000000o2 = WheelView.this.O0000O0o ? Integer.MAX_VALUE : WheelView.this.f9130O000000o.O000000o() * WheelView.this.getItemHeight();
                WheelView.this.O00000oO.fling(0, WheelView.this.O00000oo, 0, ((int) (-f2)) / 2, 0, 0, WheelView.this.O0000O0o ? -O000000o2 : 0, O000000o2);
                WheelView.this.setNextMessage(0);
                return true;
            }
        };
        this.O00oOoOo = 0;
        this.O000O0o0 = 1;
        this.O0000Oo0 = new Handler() {
            /* class com.xiaomi.smarthome.library.common.wheel.WheelView.AnonymousClass2 */

            public final void handleMessage(Message message) {
                WheelView.this.O00000oO.computeScrollOffset();
                int currY = WheelView.this.O00000oO.getCurrY();
                int i = WheelView.this.O00000oo - currY;
                WheelView wheelView = WheelView.this;
                wheelView.O00000oo = currY;
                if (i != 0) {
                    wheelView.O000000o(i);
                }
                if (Math.abs(currY - WheelView.this.O00000oO.getFinalY()) <= 0) {
                    WheelView.this.O00000oO.getFinalY();
                    WheelView.this.O00000oO.forceFinished(true);
                }
                if (!WheelView.this.O00000oO.isFinished()) {
                    WheelView.this.O0000Oo0.sendEmptyMessage(message.what);
                } else if (message.what == 0) {
                    WheelView.this.O00000Oo();
                } else {
                    WheelView.this.O00000o0();
                }
            }
        };
        this.O00oOooo = attributeSet.getAttributeIntValue(null, "WheelViewTextSize", 32);
        this.O000O00o = attributeSet.getAttributeIntValue(null, "WheelViewItemHeight", O0000Oo);
        this.O000O0OO = attributeSet.getAttributeIntValue(null, "WheelViewItemSpace", 0);
        O000000o(context);
    }

    public WheelView(Context context) {
        super(context);
        this.f9130O000000o = null;
        this.O00000Oo = 0;
        this.O0000o0 = 0;
        this.O0000o0O = 0;
        this.O0000o0o = 5;
        this.O0000o = 0;
        this.O0000O0o = false;
        this.O00oOooO = new LinkedList();
        this.O0000OOo = new LinkedList();
        this.O000O00o = O0000Oo;
        this.O000O0OO = 0;
        this.O000O0Oo = new GestureDetector.SimpleOnGestureListener() {
            /* class com.xiaomi.smarthome.library.common.wheel.WheelView.AnonymousClass1 */

            public final boolean onDown(MotionEvent motionEvent) {
                if (!WheelView.this.O00000o0) {
                    return false;
                }
                WheelView.this.O00000oO.forceFinished(true);
                WheelView.this.O000000o();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView wheelView = WheelView.this;
                if (!wheelView.O00000o0) {
                    wheelView.O00000o0 = true;
                    Iterator<Object> it = wheelView.O0000OOo.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                WheelView.this.O000000o((int) (-f2));
                return true;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelView wheelView = WheelView.this;
                wheelView.O00000oo = (wheelView.O00000Oo * WheelView.this.getItemHeight()) + WheelView.this.O00000o;
                int O000000o2 = WheelView.this.O0000O0o ? Integer.MAX_VALUE : WheelView.this.f9130O000000o.O000000o() * WheelView.this.getItemHeight();
                WheelView.this.O00000oO.fling(0, WheelView.this.O00000oo, 0, ((int) (-f2)) / 2, 0, 0, WheelView.this.O0000O0o ? -O000000o2 : 0, O000000o2);
                WheelView.this.setNextMessage(0);
                return true;
            }
        };
        this.O00oOoOo = 0;
        this.O000O0o0 = 1;
        this.O0000Oo0 = new Handler() {
            /* class com.xiaomi.smarthome.library.common.wheel.WheelView.AnonymousClass2 */

            public final void handleMessage(Message message) {
                WheelView.this.O00000oO.computeScrollOffset();
                int currY = WheelView.this.O00000oO.getCurrY();
                int i = WheelView.this.O00000oo - currY;
                WheelView wheelView = WheelView.this;
                wheelView.O00000oo = currY;
                if (i != 0) {
                    wheelView.O000000o(i);
                }
                if (Math.abs(currY - WheelView.this.O00000oO.getFinalY()) <= 0) {
                    WheelView.this.O00000oO.getFinalY();
                    WheelView.this.O00000oO.forceFinished(true);
                }
                if (!WheelView.this.O00000oO.isFinished()) {
                    WheelView.this.O0000Oo0.sendEmptyMessage(message.what);
                } else if (message.what == 0) {
                    WheelView.this.O00000Oo();
                } else {
                    WheelView.this.O00000o0();
                }
            }
        };
        this.O00oOooo = 32;
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.O000O00o = O000000o(context, this.O000O00o);
        this.O000O0OO = O000000o(context, this.O000O0OO);
        this.O00oOooo = O000000o(context, this.O00oOooo);
        this.O0000ooo = new GestureDetector(context, this.O000O0Oo);
        this.O0000ooo.setIsLongpressEnabled(false);
        this.O00000oO = new Scroller(context);
    }

    public gql getAdapter() {
        return this.f9130O000000o;
    }

    public void setAdapter(gql gql) {
        this.f9130O000000o = gql;
        O00000oO();
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.O00000oO.forceFinished(true);
        this.O00000oO = new Scroller(getContext(), interpolator);
    }

    public int getVisibleItems() {
        return this.O0000o0o;
    }

    public void setVisibleItems(int i) {
        this.O0000o0o = i;
        invalidate();
    }

    public String getLabel() {
        return this.O0000oo;
    }

    public void setLabel(String str) {
        String str2 = this.O0000oo;
        if (str2 == null || !str2.equals(str)) {
            this.O0000oo = str;
            this.O0000oOo = null;
            invalidate();
        }
    }

    public final void O000000o(gqk gqk) {
        this.O00oOooO.add(gqk);
    }

    private void O00000o() {
        Iterator<Object> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public int getCurrentItem() {
        return this.O00000Oo;
    }

    public final void setCurrentItem$2563266(int i) {
        gql gql = this.f9130O000000o;
        if (gql != null && gql.O000000o() != 0) {
            if (i < 0 || i >= this.f9130O000000o.O000000o()) {
                if (this.O0000O0o) {
                    while (i < 0) {
                        i += this.f9130O000000o.O000000o();
                    }
                    i %= this.f9130O000000o.O000000o();
                } else {
                    return;
                }
            }
            if (i != this.O00000Oo) {
                O00000oO();
                this.O00000Oo = i;
                for (gqk O000000o2 : this.O00oOooO) {
                    O000000o2.O000000o();
                }
                invalidate();
            }
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem$2563266(i);
    }

    public void setCyclic(boolean z) {
        this.O0000O0o = z;
        invalidate();
        O00000oO();
    }

    private void O00000oO() {
        this.O0000oOO = null;
        this.O0000oo0 = null;
        this.O00000o = 0;
    }

    private String O00000Oo(int i) {
        gql gql = this.f9130O000000o;
        if (gql == null || gql.O000000o() == 0) {
            return null;
        }
        int O000000o2 = this.f9130O000000o.O000000o();
        if ((i < 0 || i >= O000000o2) && !this.O0000O0o) {
            return null;
        }
        while (i < 0) {
            i += O000000o2;
        }
        return this.f9130O000000o.O000000o(i % O000000o2);
    }

    private String O000000o(boolean z) {
        String O00000Oo2;
        StringBuilder sb = new StringBuilder();
        int i = (this.O0000o0o / 2) + 1;
        int i2 = this.O00000Oo - i;
        while (true) {
            int i3 = this.O00000Oo;
            if (i2 > i3 + i) {
                return sb.toString();
            }
            if ((z || i2 != i3) && (O00000Oo2 = O00000Oo(i2)) != null) {
                sb.append(O00000Oo2);
            }
            if (i2 < this.O00000Oo + i) {
                sb.append("\n");
            }
            i2++;
        }
    }

    private int getMaxTextLength() {
        gql adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int O00000Oo2 = adapter.O00000Oo();
        if (O00000Oo2 > 0) {
            return O00000Oo2;
        }
        String str = null;
        for (int max = Math.max(this.O00000Oo - (this.O0000o0o / 2), 0); max < Math.min(this.O00000Oo + this.O0000o0o, adapter.O000000o()); max++) {
            String O000000o2 = adapter.O000000o(max);
            if (O000000o2 != null && (str == null || str.length() < O000000o2.length())) {
                str = O000000o2;
            }
        }
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    public int getItemHeight() {
        int i = this.O0000o;
        if (i != 0) {
            return i;
        }
        StaticLayout staticLayout = this.O0000oOO;
        if (staticLayout == null || staticLayout.getLineCount() <= 2) {
            return getHeight() / this.O0000o0o;
        }
        this.O0000o = this.O0000oOO.getLineTop(2) - this.O0000oOO.getLineTop(1);
        return this.O0000o;
    }

    private void O00000Oo(int i, int i2) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2 = this.O0000oOO;
        if (staticLayout2 == null || staticLayout2.getWidth() > i) {
            this.O0000oOO = new StaticLayout(O000000o(this.O00000o0), this.O0000oO0, i, i2 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, (float) this.O000O00o, false);
        } else {
            this.O0000oOO.increaseWidthTo(i);
        }
        String str = null;
        if (!this.O00000o0 && ((staticLayout = this.O0000oo0) == null || staticLayout.getWidth() > i)) {
            if (getAdapter() != null) {
                str = getAdapter().O000000o(this.O00000Oo);
            }
            if (str == null) {
                str = "";
            }
            this.O0000oo0 = new StaticLayout(str, this.O0000oO, i, i2 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, (float) this.O000O00o, false);
        } else if (this.O00000o0) {
            this.O0000oo0 = null;
        } else {
            this.O0000oo0.increaseWidthTo(i);
        }
        if (i2 > 0) {
            StaticLayout staticLayout3 = this.O0000oOo;
            if (staticLayout3 == null || staticLayout3.getWidth() > i2) {
                this.O0000oOo = new StaticLayout(this.O0000oo, this.O0000oO, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, (float) this.O000O00o, false);
            } else {
                this.O0000oOo.increaseWidthTo(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int O000000o2 = O000000o(size, mode);
        if (mode2 != 1073741824) {
            if (this.O0000oOO == null) {
                i3 = 0;
            } else {
                i3 = Math.max(((getItemHeight() * this.O0000o0o) - 32) - this.O000O00o, getSuggestedMinimumHeight());
            }
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(i3, size2) : i3;
        }
        setMeasuredDimension(O000000o2, size2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O0000oOO == null) {
            int i = this.O0000o0;
            if (i == 0) {
                O000000o(getWidth(), 1073741824);
            } else {
                O00000Oo(i, this.O0000o0O);
            }
        }
        if (this.O0000o0 > 0) {
            canvas.save();
            canvas.translate(10.0f, -16.0f);
            canvas.save();
            canvas.translate(0.0f, (float) ((-this.O0000oOO.getLineTop(1)) + this.O00000o));
            this.O0000oO0.setColor(O0000Ooo);
            this.O0000oO0.drawableState = getDrawableState();
            this.O0000oOO.draw(canvas);
            canvas.restore();
            this.O0000oO.setColor(O0000OoO);
            this.O0000oO.drawableState = getDrawableState();
            Rect rect = new Rect();
            this.O0000oOO.getLineBounds(this.O0000o0o / 2, rect);
            if (this.O0000oOo != null) {
                canvas.save();
                canvas.translate((float) (this.O0000oOO.getWidth() + 8), (float) rect.top);
                this.O0000oOo.draw(canvas);
                canvas.restore();
            }
            if (this.O0000oo0 != null) {
                canvas.save();
                canvas.translate(0.0f, (float) (rect.top + this.O00000o));
                this.O0000oo0.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
        }
        int height = getHeight() / 2;
        int itemHeight = getItemHeight() / 2;
        this.O0000ooO.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
        this.O0000ooO.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getAdapter() != null && !this.O0000ooo.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            O00000Oo();
        }
        return true;
    }

    public final void O000000o(int i) {
        this.O00000o += i;
        int itemHeight = this.O00000o / getItemHeight();
        int i2 = this.O00000Oo - itemHeight;
        if (this.O0000O0o && this.f9130O000000o.O000000o() > 0) {
            while (i2 < 0) {
                i2 += this.f9130O000000o.O000000o();
            }
            i2 %= this.f9130O000000o.O000000o();
        } else if (!this.O00000o0) {
            i2 = Math.min(Math.max(i2, 0), this.f9130O000000o.O000000o() - 1);
        } else if (i2 < 0) {
            itemHeight = this.O00000Oo;
            i2 = 0;
        } else if (i2 >= this.f9130O000000o.O000000o()) {
            itemHeight = (this.O00000Oo - this.f9130O000000o.O000000o()) + 1;
            i2 = this.f9130O000000o.O000000o() - 1;
        }
        int i3 = this.O00000o;
        if (i2 != this.O00000Oo) {
            setCurrentItem$2563266(i2);
        } else {
            invalidate();
        }
        this.O00000o = i3 - (itemHeight * getItemHeight());
        if (this.O00000o > getHeight()) {
            this.O00000o = (this.O00000o % getHeight()) + getHeight();
        }
    }

    public void setNextMessage(int i) {
        O000000o();
        this.O0000Oo0.sendEmptyMessage(i);
    }

    public final void O000000o() {
        this.O0000Oo0.removeMessages(0);
        this.O0000Oo0.removeMessages(1);
    }

    public final void O00000Oo() {
        if (this.f9130O000000o != null) {
            boolean z = false;
            this.O00000oo = 0;
            int i = this.O00000o;
            int itemHeight = getItemHeight();
            if (i <= 0 ? this.O00000Oo > 0 : this.O00000Oo < this.f9130O000000o.O000000o()) {
                z = true;
            }
            if ((this.O0000O0o || z) && Math.abs((float) i) > ((float) itemHeight) / 2.0f) {
                i = i < 0 ? i + itemHeight + 1 : i - (itemHeight + 1);
            }
            int i2 = i;
            if (Math.abs(i2) > 1) {
                this.O00000oO.startScroll(0, 0, 0, i2, 400);
                setNextMessage(1);
                return;
            }
            O00000o0();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        if (this.O00000o0) {
            O00000o();
            this.O00000o0 = false;
        }
        O00000oO();
        invalidate();
    }

    private static int O000000o(Context context, int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (((float) (i / 2)) * displayMetrics.density);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void}
     arg types: [int, int, int, int]
     candidates:
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, long):void}
      ClspMth{android.graphics.Paint.setShadowLayer(float, float, float, int):void} */
    private int O000000o(int i, int i2) {
        boolean z = true;
        if (this.O0000oO0 == null) {
            this.O0000oO0 = new TextPaint(1);
            this.O0000oO0.setTextSize((float) this.O00oOooo);
        }
        if (this.O0000oO == null) {
            this.O0000oO = new TextPaint(5);
            this.O0000oO.setTextSize((float) this.O00oOooo);
            this.O0000oO.setShadowLayer(0.1f, 0.0f, 0.1f, -4144960);
        }
        if (this.O0000ooO == null) {
            this.O0000ooO = getContext().getResources().getDrawable(R.drawable.group_time_select_bg);
        }
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            double ceil = Math.ceil((double) Layout.getDesiredWidth("0", this.O0000oO0));
            double d = (double) maxTextLength;
            Double.isNaN(d);
            this.O0000o0 = (int) (d * ceil);
        } else {
            this.O0000o0 = 0;
        }
        this.O0000o0 += this.O000O0OO;
        this.O0000o0O = 0;
        String str = this.O0000oo;
        if (str != null && str.length() > 0) {
            this.O0000o0O = (int) Math.ceil((double) Layout.getDesiredWidth(this.O0000oo, this.O0000oO));
        }
        if (i2 != 1073741824) {
            int i3 = this.O0000o0;
            int i4 = this.O0000o0O;
            int i5 = i3 + i4 + 20;
            if (i4 > 0) {
                i5 += 8;
            }
            int max = Math.max(i5, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= max) {
                i = max;
                z = false;
            }
        }
        if (z) {
            int i6 = (i - 8) - 20;
            if (i6 <= 0) {
                this.O0000o0O = 0;
                this.O0000o0 = 0;
            }
            int i7 = this.O0000o0O;
            if (i7 > 0) {
                int i8 = this.O0000o0;
                double d2 = (double) i8;
                double d3 = (double) i6;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = (double) (i8 + i7);
                Double.isNaN(d4);
                this.O0000o0 = (int) ((d2 * d3) / d4);
                this.O0000o0O = i6 - this.O0000o0;
            } else {
                this.O0000o0 = i6 + 8;
            }
        }
        int i9 = this.O0000o0;
        if (i9 > 0) {
            O00000Oo(i9, this.O0000o0O);
        }
        return i;
    }
}
