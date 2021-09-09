package _m_j;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;
import com.xiaomi.base.utils.TopAlignSuperscriptSpan;
import com.xiaomi.shopviews.model.HomeSectionItem;

public final class ewv {
    public static boolean O000000o(String str) {
        return !TextUtils.isEmpty(str) && !str.equals("0");
    }

    public static boolean O000000o(String str, String str2) {
        return !TextUtils.equals(str, str2) && O000000o(str2);
    }

    public static SpannableString O00000Oo(String str) {
        SpannableString spannableString = new SpannableString("?".concat(String.valueOf(str)));
        spannableString.setSpan(new StrikethroughSpan(), 1, spannableString.length(), 33);
        return spannableString;
    }

    public static SpannableString O00000o0(String str) {
        SpannableString spannableString = new SpannableString("?".concat(String.valueOf(str)));
        spannableString.setSpan(new TopAlignSuperscriptSpan((byte) 0), 0, 1, 33);
        return spannableString;
    }

    public static void O000000o(TextView textView, TextView textView2, TextView textView3, HomeSectionItem homeSectionItem) {
        if (textView != null && textView2 != null && textView3 != null && homeSectionItem != null) {
            if (O000000o(homeSectionItem.mProductPrice)) {
                textView.setText(O00000o0(homeSectionItem.mProductPrice));
                if (homeSectionItem.showPriceQi) {
                    textView3.setVisibility(0);
                } else {
                    textView3.setVisibility(8);
                }
                if (O000000o(homeSectionItem.mProductPrice, homeSectionItem.mProductMarketPrice)) {
                    textView2.setVisibility(0);
                    textView2.setText(O00000Oo(homeSectionItem.mProductMarketPrice));
                    return;
                }
                textView2.setVisibility(4);
                return;
            }
            textView.setText("");
            textView3.setVisibility(4);
            textView2.setVisibility(4);
        }
    }

    public static void O00000Oo(TextView textView, TextView textView2, TextView textView3, HomeSectionItem homeSectionItem) {
        if (textView != null && textView2 != null && textView3 != null && homeSectionItem != null) {
            if (O000000o(homeSectionItem.mProductPrice)) {
                textView.setText(O00000o0(homeSectionItem.mProductPrice));
                if (homeSectionItem.showPriceQi) {
                    textView3.setVisibility(0);
                } else {
                    textView3.setVisibility(8);
                }
                if (O000000o(homeSectionItem.mProductPrice, homeSectionItem.mProductMarketPrice)) {
                    textView2.setVisibility(0);
                    textView2.setText(O00000Oo(homeSectionItem.mProductMarketPrice));
                    return;
                }
                textView2.setVisibility(8);
                return;
            }
            textView.setText("");
            textView3.setVisibility(4);
            textView2.setVisibility(4);
        }
    }
}
