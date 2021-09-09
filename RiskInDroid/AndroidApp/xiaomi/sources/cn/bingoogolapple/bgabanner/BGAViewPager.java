package cn.bingoogolapple.bgabanner;

import _m_j.cb;
import _m_j.ll;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BGAViewPager extends ViewPager {
    private boolean mAllowUserScrollable = true;
    private O000000o mAutoPlayDelegate;

    public interface O000000o {
        void O000000o(float f);
    }

    public BGAViewPager(Context context) {
        super(context);
    }

    public BGAViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setPageTransformer(boolean z, ViewPager.O0000OOo o0000OOo) {
        Class<ViewPager> cls = ViewPager.class;
        boolean z2 = o0000OOo != null;
        try {
            Field declaredField = cls.getDeclaredField("mPageTransformer");
            declaredField.setAccessible(true);
            boolean z3 = z2 != (((ViewPager.O0000OOo) declaredField.get(this)) != null);
            declaredField.set(this, o0000OOo);
            Method declaredMethod = cls.getDeclaredMethod("setChildrenDrawingOrderEnabledCompat", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Boolean.valueOf(z2));
            Field declaredField2 = cls.getDeclaredField("mDrawingOrder");
            declaredField2.setAccessible(true);
            if (z2) {
                declaredField2.setInt(this, z ? 2 : 1);
            } else {
                declaredField2.setInt(this, 0);
            }
            if (z3) {
                Method declaredMethod2 = cls.getDeclaredMethod("populate", new Class[0]);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(this, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    public void setPageChangeDuration(int i) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new ll(getContext(), i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBannerCurrentItemInternal(int i, boolean z) {
        Class<ViewPager> cls = ViewPager.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("setCurrentItemInternal", Integer.TYPE, Boolean.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.TRUE);
            cb.O00000oo(this);
        } catch (Exception unused) {
        }
    }

    public void setAllowUserScrollable(boolean z) {
        this.mAllowUserScrollable = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mAllowUserScrollable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mAllowUserScrollable) {
            return false;
        }
        if (this.mAutoPlayDelegate == null || (motionEvent.getAction() != 3 && motionEvent.getAction() != 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.mAutoPlayDelegate.O000000o(getXVelocity());
        return false;
    }

    private float getXVelocity() {
        Class<ViewPager> cls = ViewPager.class;
        try {
            Field declaredField = cls.getDeclaredField("mVelocityTracker");
            declaredField.setAccessible(true);
            VelocityTracker velocityTracker = (VelocityTracker) declaredField.get(this);
            Field declaredField2 = cls.getDeclaredField("mActivePointerId");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mMaximumVelocity");
            declaredField3.setAccessible(true);
            velocityTracker.computeCurrentVelocity(1000, (float) declaredField3.getInt(this));
            return velocityTracker.getXVelocity(declaredField2.getInt(this));
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public void setAutoPlayDelegate(O000000o o000000o) {
        this.mAutoPlayDelegate = o000000o;
    }
}
