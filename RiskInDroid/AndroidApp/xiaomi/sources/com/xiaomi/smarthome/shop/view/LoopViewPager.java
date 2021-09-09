package com.xiaomi.smarthome.shop.view;

import _m_j.gsy;
import _m_j.htf;
import _m_j.jz;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.library.log.LogType;

public class LoopViewPager extends ViewPager {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f11390O000000o = "LoopViewPager";
    public ViewPager.O0000O0o O00000Oo;
    public long O00000o = 3000;
    public htf O00000o0;
    public Handler O00000oO;
    private boolean O00000oo = true;
    private boolean O0000O0o = false;
    private boolean O0000OOo = false;
    private ViewPager.O0000O0o O0000Oo0 = new ViewPager.O0000O0o() {
        /* class com.xiaomi.smarthome.shop.view.LoopViewPager.AnonymousClass2 */
        private float O00000Oo = -1.0f;
        private float O00000o0 = -1.0f;

        public final void onPageSelected(int i) {
            int O000000o2 = LoopViewPager.this.O00000o0.O000000o(i);
            float f = (float) O000000o2;
            if (this.O00000o0 != f) {
                this.O00000o0 = f;
                if (LoopViewPager.this.O00000Oo != null) {
                    LoopViewPager.this.O00000Oo.onPageSelected(O000000o2);
                }
            }
        }

        public final void onPageScrolled(int i, float f, int i2) {
            if (LoopViewPager.this.O00000o0 != null) {
                i = LoopViewPager.this.O00000o0.O000000o(i);
            }
            this.O00000Oo = f;
            if (LoopViewPager.this.O00000Oo != null && LoopViewPager.this.O00000o0 != null) {
                if (i != LoopViewPager.this.O00000o0.f618O000000o.getCount() - 1) {
                    LoopViewPager.this.O00000Oo.onPageScrolled(i, f, i2);
                } else if (((double) f) > 0.5d) {
                    LoopViewPager.this.O00000Oo.onPageScrolled(0, 0.0f, 0);
                } else {
                    LoopViewPager.this.O00000Oo.onPageScrolled(i, 0.0f, 0);
                }
            }
        }

        public final void onPageScrollStateChanged(int i) {
            if (LoopViewPager.this.O00000o0 != null) {
                int O000000o2 = LoopViewPager.super.getCurrentItem();
                int O000000o3 = LoopViewPager.this.O00000o0.O000000o(O000000o2);
                if (i == 0 && (O000000o2 == 0 || O000000o2 == LoopViewPager.this.O00000o0.getCount() - 1)) {
                    gsy.O000000o(LogType.GENERAL, LoopViewPager.f11390O000000o, "setCurrentItem(realPosition, false);");
                    LoopViewPager.this.setCurrentItem(O000000o3, false);
                }
            }
            if (LoopViewPager.this.O00000Oo != null) {
                LoopViewPager.this.O00000Oo.onPageScrollStateChanged(i);
            }
        }
    };

    public LoopViewPager(Context context) {
        super(context);
        O00000o0();
    }

    public LoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o0();
    }

    private void O00000o0() {
        super.setOnPageChangeListener(this.O0000Oo0);
        this.O00000oO = new Handler(new Handler.Callback() {
            /* class com.xiaomi.smarthome.shop.view.LoopViewPager.AnonymousClass1 */

            public final boolean handleMessage(Message message) {
                if (message.what != 0) {
                    return false;
                }
                LoopViewPager loopViewPager = LoopViewPager.this;
                int currentItem = loopViewPager.getCurrentItem();
                if (loopViewPager.O00000o0 != null && loopViewPager.O00000o0.getCount() > 1) {
                    int i = currentItem + 1;
                    if (i < loopViewPager.O00000o0.getCount() - 1) {
                        loopViewPager.setCurrentItem(i, true);
                    } else {
                        loopViewPager.setCurrentItem(0, true);
                    }
                }
                LoopViewPager.this.O00000oO.sendEmptyMessageDelayed(0, LoopViewPager.this.O00000o);
                return true;
            }
        });
    }

    public void setEnableAutoScroll(boolean z) {
        this.O00000oo = z;
        if (!this.O00000oo) {
            O00000Oo();
        }
    }

    public final void O000000o() {
        this.O0000O0o = true;
        if (!this.O00000oO.hasMessages(0)) {
            this.O00000oO.sendEmptyMessageDelayed(0, this.O00000o);
        }
    }

    public final void O00000Oo() {
        this.O0000O0o = false;
        this.O00000oO.removeCallbacksAndMessages(null);
    }

    public void setAdapter(jz jzVar) {
        if (jzVar != null) {
            this.O00000o0 = new htf(jzVar);
            super.setAdapter(this.O00000o0);
        }
    }

    public jz getAdapter() {
        htf htf = this.O00000o0;
        if (htf != null) {
            return htf.f618O000000o;
        }
        return null;
    }

    public int getCurrentItem() {
        htf htf = this.O00000o0;
        if (htf != null) {
            return htf.O000000o(super.getCurrentItem());
        }
        return 0;
    }

    public void setCurrentItem(int i, boolean z) {
        if (this.O00000o0 != null) {
            super.setCurrentItem(htf.O00000Oo(i), z);
        }
    }

    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.O0000O0o) {
            this.O0000OOo = true;
            O00000Oo();
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.O0000OOo) {
            this.O0000OOo = false;
            O000000o();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnPageChangeListener(ViewPager.O0000O0o o0000O0o) {
        this.O00000Oo = o0000O0o;
    }
}
