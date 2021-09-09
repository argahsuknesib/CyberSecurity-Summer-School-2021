package com.xiaomi.passport.ui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;
import com.xiaomi.smarthome.R;
import java.util.HashMap;
import java.util.Map;

public class PassportGroupEditText extends EditText {
    static Map<Style, Integer> sNormalBackgroundMap = new HashMap(4);
    static Map<Style, Integer> sWarnBackgroundMap = new HashMap(4);
    private Style mStyle;
    private boolean mWarning;

    public enum Style {
        NONE,
        FirstItem,
        MiddleItem,
        LastItem,
        SingleItem
    }

    static {
        sNormalBackgroundMap.put(Style.NONE, 17301674);
        sNormalBackgroundMap.put(Style.FirstItem, Integer.valueOf((int) R.drawable.passport_group_first_item_normal_bg));
        sNormalBackgroundMap.put(Style.MiddleItem, Integer.valueOf((int) R.drawable.passport_group_middle_item_normal_bg));
        sNormalBackgroundMap.put(Style.LastItem, Integer.valueOf((int) R.drawable.passport_group_last_item_normal_bg));
        sNormalBackgroundMap.put(Style.SingleItem, Integer.valueOf((int) R.drawable.passport_group_single_item_normal_bg));
        sWarnBackgroundMap.put(Style.NONE, 17301674);
        sWarnBackgroundMap.put(Style.FirstItem, Integer.valueOf((int) R.drawable.passport_group_first_item_warn_bg));
        sWarnBackgroundMap.put(Style.MiddleItem, Integer.valueOf((int) R.drawable.passport_group_middle_item_warn_bg));
        sWarnBackgroundMap.put(Style.LastItem, Integer.valueOf((int) R.drawable.passport_group_last_item_warn_bg));
        sWarnBackgroundMap.put(Style.SingleItem, Integer.valueOf((int) R.drawable.passport_group_single_item_warn_bg));
    }

    public PassportGroupEditText(Context context) {
        super(context);
    }

    public PassportGroupEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PassportGroupEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStyle(Style style) {
        this.mStyle = style;
        refreshViewState();
    }

    public void setWarning(boolean z) {
        this.mWarning = z;
        refreshViewState();
    }

    public void setError(CharSequence charSequence, Drawable drawable) {
        requestFocus();
        super.setError(charSequence, drawable);
    }

    private void refreshViewState() {
        setTextColor(getTextColor());
        setBackgroundResource(getBackgroundResource());
    }

    public void setBackgroundResource(int i) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        super.setBackgroundResource(i);
        if (Build.VERSION.SDK_INT >= 17) {
            setPaddingRelative(getPaddingStart(), paddingTop, getPaddingEnd(), paddingBottom);
        } else {
            setPadding(getPaddingLeft(), paddingTop, getPaddingRight(), paddingBottom);
        }
    }

    private int getTextColor() {
        if (this.mWarning) {
            return getResources().getColor(R.color.passport_text_color_warn);
        }
        return getResources().getColor(R.color.passport_text_color_black);
    }

    private int getBackgroundResource() {
        return getBackgroundMap().get(this.mStyle).intValue();
    }

    private Map<Style, Integer> getBackgroundMap() {
        return this.mWarning ? sWarnBackgroundMap : sNormalBackgroundMap;
    }
}
