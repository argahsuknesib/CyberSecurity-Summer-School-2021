package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Map;

final class TtmlRenderUtil {
    public static TtmlStyle resolveStyle(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        int i = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i < length) {
                    ttmlStyle2.chain(map.get(strArr[i]));
                    i++;
                }
                return ttmlStyle2;
            }
        } else if (strArr != null && strArr.length == 1) {
            return ttmlStyle.chain(map.get(strArr[0]));
        } else {
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    ttmlStyle.chain(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return ttmlStyle;
    }

    public static void applyStylesToSpan(Spannable spannable, int i, int i2, TtmlStyle ttmlStyle, TtmlNode ttmlNode) {
        TtmlNode findRubyTextNode;
        int i3 = -1;
        if (ttmlStyle.getStyle() != -1) {
            spannable.setSpan(new StyleSpan(ttmlStyle.getStyle()), i, i2, 33);
        }
        if (ttmlStyle.isLinethrough()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (ttmlStyle.isUnderline()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (ttmlStyle.hasFontColor()) {
            SpanUtil.addOrReplaceSpan(spannable, new ForegroundColorSpan(ttmlStyle.getFontColor()), i, i2, 33);
        }
        if (ttmlStyle.hasBackgroundColor()) {
            SpanUtil.addOrReplaceSpan(spannable, new BackgroundColorSpan(ttmlStyle.getBackgroundColor()), i, i2, 33);
        }
        if (ttmlStyle.getFontFamily() != null) {
            SpanUtil.addOrReplaceSpan(spannable, new TypefaceSpan(ttmlStyle.getFontFamily()), i, i2, 33);
        }
        int rubyType = ttmlStyle.getRubyType();
        if (rubyType == 2) {
            TtmlNode findRubyContainerNode = findRubyContainerNode(ttmlNode);
            if (!(findRubyContainerNode == null || (findRubyTextNode = findRubyTextNode(findRubyContainerNode)) == null)) {
                if (findRubyTextNode.getChildCount() != 1 || findRubyTextNode.getChild(0).text == null) {
                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) Util.castNonNull(findRubyTextNode.getChild(0).text);
                    if (findRubyContainerNode.style != null) {
                        i3 = findRubyContainerNode.style.getRubyPosition();
                    }
                    spannable.setSpan(new RubySpan(str, i3), i, i2, 33);
                }
            }
        } else if (rubyType == 3 || rubyType == 4) {
            spannable.setSpan(new DeleteTextSpan(), i, i2, 33);
        }
        Layout.Alignment textAlign = ttmlStyle.getTextAlign();
        if (textAlign != null) {
            SpanUtil.addOrReplaceSpan(spannable, new AlignmentSpan.Standard(textAlign), i, i2, 33);
        }
        if (ttmlStyle.getTextCombine()) {
            SpanUtil.addOrReplaceSpan(spannable, new HorizontalTextInVerticalContextSpan(), i, i2, 33);
        }
        int fontSizeUnit = ttmlStyle.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            SpanUtil.addOrReplaceSpan(spannable, new AbsoluteSizeSpan((int) ttmlStyle.getFontSize(), true), i, i2, 33);
        } else if (fontSizeUnit == 2) {
            SpanUtil.addOrReplaceSpan(spannable, new RelativeSizeSpan(ttmlStyle.getFontSize()), i, i2, 33);
        } else if (fontSizeUnit == 3) {
            SpanUtil.addOrReplaceSpan(spannable, new RelativeSizeSpan(ttmlStyle.getFontSize() / 100.0f), i, i2, 33);
        }
    }

    private static TtmlNode findRubyTextNode(TtmlNode ttmlNode) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(ttmlNode);
        while (!arrayDeque.isEmpty()) {
            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.pop();
            if (ttmlNode2.style != null && ttmlNode2.style.getRubyType() == 3) {
                return ttmlNode2;
            }
            for (int childCount = ttmlNode2.getChildCount() - 1; childCount >= 0; childCount--) {
                arrayDeque.push(ttmlNode2.getChild(childCount));
            }
        }
        return null;
    }

    private static TtmlNode findRubyContainerNode(TtmlNode ttmlNode) {
        while (ttmlNode != null) {
            TtmlStyle ttmlStyle = ttmlNode.style;
            if (ttmlStyle != null && ttmlStyle.getRubyType() == 1) {
                return ttmlNode;
            }
            ttmlNode = ttmlNode.parent;
        }
        return null;
    }

    static void endParagraph(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != 10) {
            spannableStringBuilder.append(10);
        }
    }

    static String applyTextElementSpacePolicy(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    private TtmlRenderUtil() {
    }
}
