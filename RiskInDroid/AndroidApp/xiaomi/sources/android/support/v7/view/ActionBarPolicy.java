package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.ViewConfiguration;
import com.xiaomi.smarthome.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarPolicy {
    private Context mContext;

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public int getMaxActionButtons() {
        Resources resources = this.mContext.getResources();
        int screenWidthDp = ConfigurationHelper.getScreenWidthDp(resources);
        int screenHeightDp = ConfigurationHelper.getScreenHeightDp(resources);
        if (ConfigurationHelper.getSmallestScreenWidthDp(resources) > 600 || screenWidthDp > 600) {
            return 5;
        }
        if (screenWidthDp > 960 && screenHeightDp > 720) {
            return 5;
        }
        if (screenWidthDp > 720 && screenHeightDp > 960) {
            return 5;
        }
        if (screenWidthDp >= 500) {
            return 4;
        }
        if (screenWidthDp > 640 && screenHeightDp > 480) {
            return 4;
        }
        if (screenWidthDp <= 480 || screenHeightDp <= 640) {
            return screenWidthDp >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean showsOverflowMenuButton() {
        if (Build.VERSION.SDK_INT < 19 && ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
            return false;
        }
        return true;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(13, 0);
        Resources resources = this.mContext.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
