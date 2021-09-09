package _m_j;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.util.padcompat.PadUtils;
import com.facebook.react.views.view.ReactViewGroup;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.widget.CardFrameLayout;

public final class gbs implements PadUtils {
    private static boolean O00000o = true;

    /* renamed from: O000000o  reason: collision with root package name */
    public FrameLayout f17502O000000o = null;
    public O000000o O00000Oo;
    public int O00000o0 = 0;

    public final boolean isDialogThemePlugin() {
        return O000000o();
    }

    public static boolean O000000o() {
        return hyy.O000000o() && O00000o;
    }

    public final float getScaleFactor() {
        return hyy.O00000Oo;
    }

    public final int getKeyBoardEventHeightDiff(View view, int i) {
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        if (windowManager == null) {
            return DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - i;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        return (i2 - i) - ((i2 - DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels) / 2);
    }

    public static void O000000o(boolean z) {
        O00000o = z;
    }

    public final Point getModalHostSize() {
        DisplayMetrics O00000Oo2 = hyy.O00000Oo();
        return new Point(O00000Oo2.widthPixels, O00000Oo2.heightPixels);
    }

    public final boolean interceptDimensionSize() {
        DisplayMetrics O00000Oo2 = hyy.O00000Oo();
        DisplayMetricsHolder.setScreenDisplayMetrics(O00000Oo2);
        DisplayMetricsHolder.setWindowDisplayMetrics(O00000Oo2);
        return true;
    }

    public final View handleModalContentViewWhenPad(ReactViewGroup reactViewGroup, Activity activity) {
        if (hyy.f1004O000000o) {
            return null;
        }
        CardFrameLayout cardFrameLayout = new CardFrameLayout(reactViewGroup.getContext());
        if (this.f17502O000000o == null) {
            this.f17502O000000o = new FrameLayout(CommonApplication.getAppContext());
            this.f17502O000000o.addView(reactViewGroup);
            O000000o(this.f17502O000000o, cardFrameLayout, activity);
            final View childAt = hyy.O00000o(activity).getChildAt(0);
            if (childAt != null) {
                if (this.O00000Oo == null) {
                    this.O00000Oo = new O000000o(childAt);
                }
                this.f17502O000000o.addOnLayoutChangeListener(this.O00000Oo);
                this.f17502O000000o.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                    /* class _m_j.gbs.AnonymousClass1 */

                    public final void onViewAttachedToWindow(View view) {
                        gbs.this.O00000o0 = ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    }

                    public final void onViewDetachedFromWindow(View view) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.bottomMargin = gbs.this.O00000o0;
                        childAt.setLayoutParams(layoutParams);
                        gbs gbs = gbs.this;
                        gbs.f17502O000000o = null;
                        gbs.O00000Oo = null;
                    }
                });
            }
        } else {
            FrameLayout frameLayout = new FrameLayout(reactViewGroup.getContext());
            frameLayout.addView(reactViewGroup);
            O000000o(frameLayout, cardFrameLayout, activity);
        }
        return cardFrameLayout;
    }

    private static void O000000o(FrameLayout frameLayout, FrameLayout frameLayout2, Activity activity) {
        frameLayout2.addView(frameLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        DisplayMetrics O00000Oo2 = hyy.O00000Oo(activity.getIntent());
        layoutParams.width = O00000Oo2.widthPixels;
        layoutParams.height = O00000Oo2.heightPixels;
        layoutParams.gravity = 17;
        frameLayout2.setPadding(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
        frameLayout2.setBackgroundColor(-2013265920);
    }

    static class O000000o implements View.OnLayoutChangeListener {

        /* renamed from: O000000o  reason: collision with root package name */
        View f17504O000000o;

        O000000o(View view) {
            this.f17504O000000o = view;
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (!(i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) && !hyy.f1004O000000o) {
                int top = this.f17504O000000o.getTop();
                int O00000Oo = hzf.O00000Oo(CommonApplication.getAppContext());
                int abs = Math.abs((i5 - i) + (i8 - i4));
                int i9 = top - i2;
                if (i9 != 0 && abs != 0 && abs * 2 != O00000Oo) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f17504O000000o.getLayoutParams();
                    layoutParams.bottomMargin += i9;
                    this.f17504O000000o.setLayoutParams(layoutParams);
                }
            }
        }
    }
}
