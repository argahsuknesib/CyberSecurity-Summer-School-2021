package com.xiaomi.mico.common.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import rx.functions.Action1;

public class ViewUtil {
    public static void setupEmptyView(View view, String str) {
        setupEmptyView(view, false, str, null, null);
    }

    public static void setupEmptyView(View view, boolean z, String str, String str2, Action1<Void> action1) {
        setupEEView(view, z, R.drawable.img_empty, view.getResources().getString(R.string.common_empty), str, str2, action1);
    }

    public static void setupErrorView(View view, Action1<Void> action1) {
        setupErrorView(view, false, action1);
    }

    public static void setupErrorView(View view, boolean z, Action1<Void> action1) {
        setupEEView(view, z, R.drawable.miio_fail, view.getResources().getString(R.string.common_load_failed), null, view.getResources().getString(R.string.common_reload), action1);
    }

    private static void setupEEView(View view, boolean z, int i, String str, String str2, String str3, Action1<Void> action1) {
        if (z) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.ee_padding_top_small);
            if (Build.VERSION.SDK_INT >= 17) {
                view.setPaddingRelative(view.getPaddingStart(), dimensionPixelSize, view.getPaddingEnd(), view.getPaddingBottom());
            } else {
                view.setPadding(view.getPaddingLeft(), dimensionPixelSize, view.getPaddingRight(), view.getPaddingBottom());
            }
        }
        ((ImageView) view.findViewById(16908294)).setImageResource(i);
        ((TextView) view.findViewById(16908308)).setText(str);
        ((TextView) view.findViewById(16908309)).setText(str2);
        Button button = (Button) view.findViewById(16908313);
        if (TextUtils.isEmpty(str3) || action1 == null) {
            button.setVisibility(8);
            return;
        }
        button.setText(str3);
        RxUtil.debounceClick(button, action1);
    }
}
