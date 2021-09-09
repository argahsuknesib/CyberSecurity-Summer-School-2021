package com.xiaomi.smarthome.scene.widget;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Locale;

public class IndicatorTab extends ColorTransitionPagerTitleView {
    private int limitWidthChinese = -1;
    private int limitWidthOther = -1;

    public IndicatorTab(Context context) {
        super(context);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    private CharSequence truncateByLanguage(CharSequence charSequence) {
        int measureLimit = measureLimit();
        return measureTitleWidth(charSequence) > measureLimit ? TextUtils.ellipsize(charSequence, getPaint(), (float) measureLimit, TextUtils.TruncateAt.END) : charSequence;
    }

    private int measureLimit() {
        if (Build.VERSION.SDK_INT >= 24) {
            CommonApplication.getApplication().getResources().getConfiguration().getLocales().get(0).getLanguage();
        } else {
            CommonApplication.getApplication().getResources().getConfiguration().locale.getLanguage();
        }
        if (Locale.CHINESE.getLanguage() == null) {
            int i = this.limitWidthChinese;
            return i == -1 ? measureTitleWidth("字字字字字字字") : i;
        }
        int i2 = this.limitWidthOther;
        return i2 == -1 ? measureTitleWidth("Living room aa") : i2;
    }

    private int measureTitleWidth(CharSequence charSequence) {
        return (int) (getPaint().measureText(charSequence.toString()) + ((float) getPaddingLeft()) + ((float) getPaddingRight()));
    }
}
