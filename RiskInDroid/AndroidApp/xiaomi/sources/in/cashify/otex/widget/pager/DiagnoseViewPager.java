package in.cashify.otex.widget.pager;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

public class DiagnoseViewPager extends ViewPager {

    public class a extends Scroller {
        public a(Context context) {
            super(context);
        }

        public final void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, 500);
        }

        public final void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, 500);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public DiagnoseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(this, new a(getContext()));
            } catch (Exception unused) {
            }
        }
    }
}
