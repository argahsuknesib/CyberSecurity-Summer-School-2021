package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f2763O000000o = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);
    private final int O00000Oo = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f2763O000000o * 2), this.O00000Oo), 1073741824), i2);
    }
}
