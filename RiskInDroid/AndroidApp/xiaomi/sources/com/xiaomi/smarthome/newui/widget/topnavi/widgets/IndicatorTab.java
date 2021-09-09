package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.ixe;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/IndicatorTab;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/indicator/buildins/commonnavigator/titles/ColorTransitionPagerTitleView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "measureLimit", "", "measureTitleWidth", "title", "", "setText", "", "text", "type", "Landroid/widget/TextView$BufferType;", "truncateByLanguage", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class IndicatorTab extends ColorTransitionPagerTitleView {
    public static final O000000o Companion = new O000000o((byte) 0);
    private static int limitWidthChinese = -1;
    private static int limitWidthOther = -1;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndicatorTab(Context context) {
        super(context);
        ixe.O00000o(context, "context");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/IndicatorTab$Companion;", "", "()V", "CHINESE_CHARACTER_SAMPLE", "", "OTHER_CHARACTER_SAMPLE", "limitWidthChinese", "", "limitWidthOther", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ixe.O00000o(charSequence, "text");
        ixe.O00000o(bufferType, "type");
        super.setText(truncateByLanguage(charSequence), bufferType);
    }

    private final CharSequence truncateByLanguage(CharSequence charSequence) {
        int measureLimit = measureLimit();
        if (measureTitleWidth(charSequence) <= measureLimit) {
            return charSequence;
        }
        CharSequence ellipsize = TextUtils.ellipsize(charSequence, getPaint(), (float) measureLimit, TextUtils.TruncateAt.END);
        ixe.O00000Oo(ellipsize, "{\n            TextUtils.ellipsize(text, paint, measureLimit.toFloat(), TextUtils.TruncateAt.END)\n        }");
        return ellipsize;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    private final int measureLimit() {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            str = CommonApplication.getApplication().getResources().getConfiguration().getLocales().get(0).getLanguage();
        } else {
            str = CommonApplication.getApplication().getResources().getConfiguration().locale.getLanguage();
        }
        if (ixe.O000000o((Object) str, (Object) Locale.CHINESE.getLanguage())) {
            int i = limitWidthChinese;
            return i == -1 ? measureTitleWidth("字字字字字字字") : i;
        }
        int i2 = limitWidthOther;
        return i2 == -1 ? measureTitleWidth("Living room aa") : i2;
    }

    private final int measureTitleWidth(CharSequence charSequence) {
        return (int) (getPaint().measureText(charSequence.toString()) + ((float) getPaddingLeft()) + ((float) getPaddingRight()));
    }
}
