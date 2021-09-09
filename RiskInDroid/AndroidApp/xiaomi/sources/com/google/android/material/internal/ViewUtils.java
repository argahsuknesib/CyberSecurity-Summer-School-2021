package com.google.android.material.internal;

import _m_j.bw;
import _m_j.cb;
import _m_j.ci;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;

public class ViewUtils {

    public interface OnApplyWindowInsetsListener {
        ci onApplyWindowInsets(View view, ci ciVar, RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean isLayoutRtl(View view) {
        return cb.O0000Oo0(view) == 1;
    }

    public static float dpToPx(Context context, int i) {
        return TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static void requestFocusAndShowKeyboard(final View view) {
        view.requestFocus();
        view.post(new Runnable() {
            /* class com.google.android.material.internal.ViewUtils.AnonymousClass1 */

            public final void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static class RelativePadding {
        public int bottom;
        public int end;
        public int start;
        public int top;

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }

        public void applyToView(View view) {
            cb.O00000Oo(view, this.start, this.top, this.end, this.bottom);
        }
    }

    public static void doOnApplyWindowInsets(View view, AttributeSet attributeSet, int i, int i2) {
        doOnApplyWindowInsets(view, attributeSet, i, i2, null);
    }

    public static void doOnApplyWindowInsets(View view, AttributeSet attributeSet, int i, int i2, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.paddingBottomSystemWindowInsets, R.attr.paddingLeftSystemWindowInsets, R.attr.paddingRightSystemWindowInsets}, i, i2);
        final boolean z = obtainStyledAttributes.getBoolean(0, false);
        final boolean z2 = obtainStyledAttributes.getBoolean(1, false);
        final boolean z3 = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new OnApplyWindowInsetsListener() {
            /* class com.google.android.material.internal.ViewUtils.AnonymousClass2 */

            public final ci onApplyWindowInsets(View view, ci ciVar, RelativePadding relativePadding) {
                if (z) {
                    relativePadding.bottom += ciVar.O00000o();
                }
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
                if (z2) {
                    if (isLayoutRtl) {
                        relativePadding.end += ciVar.O000000o();
                    } else {
                        relativePadding.start += ciVar.O000000o();
                    }
                }
                if (z3) {
                    if (isLayoutRtl) {
                        relativePadding.start += ciVar.O00000o0();
                    } else {
                        relativePadding.end += ciVar.O00000o0();
                    }
                }
                relativePadding.applyToView(view);
                OnApplyWindowInsetsListener onApplyWindowInsetsListener = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.onApplyWindowInsets(view, ciVar, relativePadding) : ciVar;
            }
        });
    }

    public static void doOnApplyWindowInsets(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(cb.O0000OoO(view), view.getPaddingTop(), cb.O0000Ooo(view), view.getPaddingBottom());
        cb.O000000o(view, new bw() {
            /* class com.google.android.material.internal.ViewUtils.AnonymousClass3 */

            public final ci onApplyWindowInsets(View view, ci ciVar) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view, ciVar, new RelativePadding(relativePadding));
            }
        });
        requestApplyInsetsWhenAttached(view);
    }

    public static void requestApplyInsetsWhenAttached(View view) {
        if (cb.O000OO0o(view)) {
            cb.O0000ooO(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                /* class com.google.android.material.internal.ViewUtils.AnonymousClass4 */

                public final void onViewDetachedFromWindow(View view) {
                }

                public final void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    cb.O0000ooO(view);
                }
            });
        }
    }

    public static float getParentAbsoluteElevation(View view) {
        float f = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f += cb.O0000oOO((View) parent);
        }
        return f;
    }

    public static ViewOverlayImpl getOverlay(View view) {
        if (view == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewOverlayApi18(view);
        }
        return ViewOverlayApi14.createFrom(view);
    }

    public static ViewGroup getContentView(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ViewOverlayImpl getContentViewOverlay(View view) {
        return getOverlay(getContentView(view));
    }

    public static void addOnGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void removeOnGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            removeOnGlobalLayoutListener(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
