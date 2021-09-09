package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import android.text.Html;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

final class SpannedToHtmlConverter {
    private static final Pattern NEWLINE_PATTERN = Pattern.compile("(&#13;)?&#10;");

    static final class Transition {
        public final List<SpanInfo> spansAdded = new ArrayList();
        public final List<SpanInfo> spansRemoved = new ArrayList();
    }

    private SpannedToHtmlConverter() {
    }

    public static String convert(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        if (!(charSequence instanceof Spanned)) {
            return escapeHtml(charSequence);
        }
        Spanned spanned = (Spanned) charSequence;
        SparseArray<Transition> findSpanTransitions = findSpanTransitions(spanned);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i = 0;
        int i2 = 0;
        while (i < findSpanTransitions.size()) {
            int keyAt = findSpanTransitions.keyAt(i);
            sb.append(escapeHtml(spanned.subSequence(i2, keyAt)));
            Transition transition = findSpanTransitions.get(keyAt);
            Collections.sort(transition.spansRemoved, SpanInfo.FOR_CLOSING_TAGS);
            for (SpanInfo spanInfo : transition.spansRemoved) {
                sb.append(spanInfo.closingTag);
            }
            Collections.sort(transition.spansAdded, SpanInfo.FOR_OPENING_TAGS);
            for (SpanInfo spanInfo2 : transition.spansAdded) {
                sb.append(spanInfo2.openingTag);
            }
            i++;
            i2 = keyAt;
        }
        sb.append(escapeHtml(spanned.subSequence(i2, spanned.length())));
        return sb.toString();
    }

    private static SparseArray<Transition> findSpanTransitions(Spanned spanned) {
        SparseArray<Transition> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String openingTag = getOpeningTag(obj);
            String closingTag = getClosingTag(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (openingTag != null) {
                Assertions.checkNotNull(closingTag);
                SpanInfo spanInfo = new SpanInfo(spanStart, spanEnd, openingTag, closingTag);
                getOrCreate(sparseArray, spanStart).spansAdded.add(spanInfo);
                getOrCreate(sparseArray, spanEnd).spansRemoved.add(spanInfo);
            }
        }
        return sparseArray;
    }

    private static String getOpeningTag(Object obj) {
        if (obj instanceof ForegroundColorSpan) {
            return Util.formatInvariant("<span style='color:%s;'>", toCssColor(((ForegroundColorSpan) obj).getForegroundColor()));
        } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        } else {
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "<b>";
                }
                if (style == 2) {
                    return "<i>";
                }
                if (style != 3) {
                    return null;
                }
                return "<b><i>";
            } else if (obj instanceof RubySpan) {
                int i = ((RubySpan) obj).position;
                if (i == -1) {
                    return "<ruby style='ruby-position:unset;'>";
                }
                if (i == 1) {
                    return "<ruby style='ruby-position:over;'>";
                }
                if (i != 2) {
                    return null;
                }
                return "<ruby style='ruby-position:under;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                return null;
            }
        }
    }

    private static String getClosingTag(Object obj) {
        if ((obj instanceof ForegroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan)) {
            return "</span>";
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style != 3) {
                return null;
            }
            return "</i></b>";
        } else if (obj instanceof RubySpan) {
            return "<rt>" + escapeHtml(((RubySpan) obj).rubyText) + "</rt></ruby>";
        } else if (obj instanceof UnderlineSpan) {
            return "</u>";
        } else {
            return null;
        }
    }

    private static String toCssColor(int i) {
        double alpha = (double) Color.alpha(i);
        Double.isNaN(alpha);
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(alpha / 255.0d));
    }

    private static Transition getOrCreate(SparseArray<Transition> sparseArray, int i) {
        Transition transition = sparseArray.get(i);
        if (transition != null) {
            return transition;
        }
        Transition transition2 = new Transition();
        sparseArray.put(i, transition2);
        return transition2;
    }

    private static String escapeHtml(CharSequence charSequence) {
        return NEWLINE_PATTERN.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    static final class SpanInfo {
        public static final Comparator<SpanInfo> FOR_CLOSING_TAGS = $$Lambda$SpannedToHtmlConverter$SpanInfo$D6dWYUBYieDhpxO4p4zfHMyb1s.INSTANCE;
        public static final Comparator<SpanInfo> FOR_OPENING_TAGS = $$Lambda$SpannedToHtmlConverter$SpanInfo$BwYjZtSUmAAZViTBWDp4c4o3QA4.INSTANCE;
        public final String closingTag;
        public final int end;
        public final String openingTag;
        public final int start;

        static /* synthetic */ int lambda$static$0(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.end, spanInfo.end);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo.openingTag.compareTo(spanInfo2.openingTag);
            if (compareTo != 0) {
                return compareTo;
            }
            return spanInfo.closingTag.compareTo(spanInfo2.closingTag);
        }

        static /* synthetic */ int lambda$static$1(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.start, spanInfo.start);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo2.openingTag.compareTo(spanInfo.openingTag);
            if (compareTo != 0) {
                return compareTo;
            }
            return spanInfo2.closingTag.compareTo(spanInfo.closingTag);
        }

        private SpanInfo(int i, int i2, String str, String str2) {
            this.start = i;
            this.end = i2;
            this.openingTag = str;
            this.closingTag = str2;
        }
    }
}
