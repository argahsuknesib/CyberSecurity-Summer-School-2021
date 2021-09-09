package _m_j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import com.xiaomi.smarthome.R;

public final class Oo000 {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f12343O000000o = {-16842910};
    static final int[] O00000Oo = {16842908};
    static final int[] O00000o = {16842919};
    static final int[] O00000o0 = {16843518};
    static final int[] O00000oO = {16842912};
    static final int[] O00000oo = {16842913};
    static final int[] O0000O0o = {-16842919, -16842908};
    static final int[] O0000OOo = new int[0];
    private static final int[] O0000Oo = new int[1];
    private static final ThreadLocal<TypedValue> O0000Oo0 = new ThreadLocal<>();

    public static int O000000o(Context context, int i) {
        int[] iArr = O0000Oo;
        iArr[0] = i;
        Oo O000000o2 = Oo.O000000o(context, (AttributeSet) null, iArr);
        try {
            return O000000o2.O00000Oo(0, 0);
        } finally {
            O000000o2.f12340O000000o.recycle();
        }
    }

    public static ColorStateList O00000Oo(Context context, int i) {
        int[] iArr = O0000Oo;
        iArr[0] = i;
        Oo O000000o2 = Oo.O000000o(context, (AttributeSet) null, iArr);
        try {
            return O000000o2.O00000oO(0);
        } finally {
            O000000o2.f12340O000000o.recycle();
        }
    }

    public static int O00000o0(Context context, int i) {
        ColorStateList O00000Oo2 = O00000Oo(context, i);
        if (O00000Oo2 != null && O00000Oo2.isStateful()) {
            return O00000Oo2.getColorForState(f12343O000000o, O00000Oo2.getDefaultColor());
        }
        TypedValue typedValue = O0000Oo0.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            O0000Oo0.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f = typedValue.getFloat();
        int O000000o2 = O000000o(context, i);
        return q.O00000Oo(O000000o2, Math.round(((float) Color.alpha(O000000o2)) * f));
    }

    public static void O000000o(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16842839, 16842926, R.attr.actionBarDivider, R.attr.actionBarItemBackground, R.attr.actionBarPopupTheme, R.attr.actionBarSize, R.attr.actionBarSplitStyle, R.attr.actionBarStyle, R.attr.actionBarTabBarStyle, R.attr.actionBarTabStyle, R.attr.actionBarTabTextStyle, R.attr.actionBarTheme, R.attr.actionBarWidgetTheme, R.attr.actionButtonStyle, R.attr.actionDropDownStyle, R.attr.actionMenuTextAppearance, R.attr.actionMenuTextColor, R.attr.actionModeBackground, R.attr.actionModeCloseButtonStyle, R.attr.actionModeCloseDrawable, R.attr.actionModeCopyDrawable, R.attr.actionModeCutDrawable, R.attr.actionModeFindDrawable, R.attr.actionModePasteDrawable, R.attr.actionModePopupWindowStyle, R.attr.actionModeSelectAllDrawable, R.attr.actionModeShareDrawable, R.attr.actionModeSplitBackground, R.attr.actionModeStyle, R.attr.actionModeWebSearchDrawable, R.attr.actionOverflowButtonStyle, R.attr.actionOverflowMenuStyle, R.attr.activityChooserViewStyle, R.attr.alertDialogButtonGroupStyle, R.attr.alertDialogCenterButtons, R.attr.alertDialogStyle, R.attr.alertDialogTheme, R.attr.autoCompleteTextViewStyle, R.attr.borderlessButtonStyle, R.attr.buttonBarButtonStyle, R.attr.buttonBarNegativeButtonStyle, R.attr.buttonBarNeutralButtonStyle, R.attr.buttonBarPositiveButtonStyle, R.attr.buttonBarStyle, R.attr.buttonStyle, R.attr.buttonStyleSmall, R.attr.checkboxStyle, R.attr.checkedTextViewStyle, R.attr.colorAccent, R.attr.colorBackgroundFloating, R.attr.colorButtonNormal, R.attr.colorControlActivated, R.attr.colorControlHighlight, R.attr.colorControlNormal, R.attr.colorError, R.attr.colorPrimary, R.attr.colorPrimaryDark, R.attr.colorSwitchThumbNormal, R.attr.controlBackground, R.attr.dialogCornerRadius, R.attr.dialogPreferredPadding, R.attr.dialogTheme, R.attr.dividerHorizontal, R.attr.dividerVertical, R.attr.dropDownListViewStyle, R.attr.dropdownListPreferredItemHeight, R.attr.editTextBackground, R.attr.editTextColor, R.attr.editTextStyle, R.attr.homeAsUpIndicator, R.attr.imageButtonStyle, R.attr.listChoiceBackgroundIndicator, R.attr.listChoiceIndicatorMultipleAnimated, R.attr.listChoiceIndicatorSingleAnimated, R.attr.listDividerAlertDialog, R.attr.listMenuViewStyle, R.attr.listPopupWindowStyle, R.attr.listPreferredItemHeight, R.attr.listPreferredItemHeightLarge, R.attr.listPreferredItemHeightSmall, R.attr.listPreferredItemPaddingEnd, R.attr.listPreferredItemPaddingLeft, R.attr.listPreferredItemPaddingRight, R.attr.listPreferredItemPaddingStart, R.attr.panelBackground, R.attr.panelMenuListTheme, R.attr.panelMenuListWidth, R.attr.popupMenuStyle, R.attr.popupWindowStyle, R.attr.radioButtonStyle, R.attr.ratingBarStyle, R.attr.ratingBarStyleIndicator, R.attr.ratingBarStyleSmall, R.attr.searchViewStyle, R.attr.seekBarStyle, R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless, R.attr.spinnerDropDownItemStyle, R.attr.spinnerStyle, R.attr.switchStyle, R.attr.textAppearanceLargePopupMenu, R.attr.textAppearanceListItem, R.attr.textAppearanceListItemSecondary, R.attr.textAppearanceListItemSmall, R.attr.textAppearancePopupMenuHeader, R.attr.textAppearanceSearchResultSubtitle, R.attr.textAppearanceSearchResultTitle, R.attr.textAppearanceSmallPopupMenu, R.attr.textColorAlertDialogListItem, R.attr.textColorSearchUrl, R.attr.toolbarNavigationButtonStyle, R.attr.toolbarStyle, R.attr.tooltipForegroundColor, R.attr.tooltipFrameBackground, R.attr.viewInflaterClass, R.attr.windowActionBar, R.attr.windowActionBarOverlay, R.attr.windowActionModeOverlay, R.attr.windowFixedHeightMajor, R.attr.windowFixedHeightMinor, R.attr.windowFixedWidthMajor, R.attr.windowFixedWidthMinor, R.attr.windowMinWidthMajor, R.attr.windowMinWidthMinor, R.attr.windowNoTitle});
        try {
            if (!obtainStyledAttributes.hasValue(115)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
