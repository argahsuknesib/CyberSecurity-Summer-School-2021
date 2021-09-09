package com.xiaomi.mico.common.recyclerview.itemdecoration;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;

public class ItemDecorationHelper {
    public static RecyclerView.O0000Oo listDivider(Context context, int i, int i2) {
        return listDivider(context, R.color.mj_color_separator, i, i2, null);
    }

    public static RecyclerView.O0000Oo listDivider(Context context, int i, int i2, Ignore ignore) {
        return listDivider(context, R.color.mj_color_separator, i, i2, ignore);
    }

    public static RecyclerView.O0000Oo listDividerVertical(Context context, int i, int i2, Ignore ignore) {
        return listDividerVertical(context, R.color.mj_color_separator, i, i2, ignore);
    }

    public static RecyclerView.O0000Oo listDivider(Context context, int i, int i2, int i3, Ignore ignore) {
        return new ListDividerItemDecoration(0, context.getResources().getColor(i), context.getResources().getDimensionPixelSize(R.dimen.common_divider_line_size), i2, i3, ignore);
    }

    public static RecyclerView.O0000Oo listDivider(Context context, int i, int i2, int i3, int i4, Ignore ignore) {
        return new ListDividerItemDecoration(0, context.getResources().getColor(i), context.getResources().getDimensionPixelSize(i2), i3, i4, ignore);
    }

    public static RecyclerView.O0000Oo listDividerVertical(Context context, int i, int i2, int i3, Ignore ignore) {
        return new ListDividerItemDecoration(1, context.getResources().getColor(i), context.getResources().getDimensionPixelSize(R.dimen.common_divider_line_size), i2, i3, ignore);
    }

    public static RecyclerView.O0000Oo listPadding(int i, int i2) {
        return listPadding(i, i2, null);
    }

    public static RecyclerView.O0000Oo listPadding(int i, int i2, Ignore ignore) {
        return new ListPaddingItemDecoration(0, i, i2, ignore);
    }
}
