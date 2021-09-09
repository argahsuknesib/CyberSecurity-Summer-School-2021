package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

final class o0000 {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Context f2221O000000o;
    private final View O00000Oo;
    private final WindowManager.LayoutParams O00000o = new WindowManager.LayoutParams();
    private final TextView O00000o0;
    private final Rect O00000oO = new Rect();
    private final int[] O00000oo = new int[2];
    private final int[] O0000O0o = new int[2];

    o0000(Context context) {
        this.f2221O000000o = context;
        this.O00000Oo = LayoutInflater.from(this.f2221O000000o).inflate((int) R.layout.abc_tooltip, (ViewGroup) null);
        this.O00000o0 = (TextView) this.O00000Oo.findViewById(R.id.message);
        this.O00000o.setTitle(getClass().getSimpleName());
        this.O00000o.packageName = this.f2221O000000o.getPackageName();
        WindowManager.LayoutParams layoutParams = this.O00000o;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 2132738054;
        layoutParams.flags = 24;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (O00000Oo()) {
            O000000o();
        }
        this.O00000o0.setText(charSequence);
        O000000o(view, i, i2, z, this.O00000o);
        ((WindowManager) this.f2221O000000o.getSystemService("window")).addView(this.O00000Oo, this.O00000o);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (O00000Oo()) {
            ((WindowManager) this.f2221O000000o.getSystemService("window")).removeView(this.O00000Oo);
        }
    }

    private boolean O00000Oo() {
        return this.O00000Oo.getParent() != null;
    }

    private void O000000o(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int i3;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f2221O000000o.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f2221O000000o.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            i4 = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            i4 = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f2221O000000o.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View O000000o2 = O000000o(view);
        if (O000000o2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        O000000o2.getWindowVisibleDisplayFrame(this.O00000oO);
        if (this.O00000oO.left < 0 && this.O00000oO.top < 0) {
            Resources resources = this.f2221O000000o.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.O00000oO.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        O000000o2.getLocationOnScreen(this.O0000O0o);
        view.getLocationOnScreen(this.O00000oo);
        int[] iArr = this.O00000oo;
        int i5 = iArr[0];
        int[] iArr2 = this.O0000O0o;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (O000000o2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.O00000Oo.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.O00000Oo.getMeasuredHeight();
        int[] iArr3 = this.O00000oo;
        int i6 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + i4 + dimensionPixelOffset3;
        if (z) {
            if (i6 < 0) {
                layoutParams.y = i7;
                return;
            }
        } else if (measuredHeight + i7 <= this.O00000oO.height()) {
            layoutParams.y = i7;
            return;
        }
        layoutParams.y = i6;
    }

    private static View O000000o(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
