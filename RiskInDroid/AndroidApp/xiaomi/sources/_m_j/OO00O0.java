package _m_j;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.xiaomi.smarthome.R;

public final class OO00O0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f6713O000000o;

    public static OO00O0 O000000o(Context context) {
        return new OO00O0(context);
    }

    private OO00O0(Context context) {
        this.f6713O000000o = context;
    }

    public final int O000000o() {
        Configuration configuration = this.f6713O000000o.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    public final boolean O00000Oo() {
        return this.f6713O000000o.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public final int O00000o0() {
        TypedArray obtainStyledAttributes = this.f6713O000000o.obtainStyledAttributes(null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
        Resources resources = this.f6713O000000o.getResources();
        if (!O00000Oo()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public final boolean O00000o() {
        return this.f6713O000000o.getApplicationInfo().targetSdkVersion < 14;
    }

    public final int O00000oO() {
        return this.f6713O000000o.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
