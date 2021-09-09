package com.google.android.exoplayer2.text.webvtt;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser {
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map<String, Integer> DEFAULT_BACKGROUND_COLORS;
    private static final Map<String, Integer> DEFAULT_TEXT_COLORS;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        DEFAULT_TEXT_COLORS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        DEFAULT_BACKGROUND_COLORS = Collections.unmodifiableMap(hashMap2);
    }

    public static WebvttCueInfo parseCue(ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        String readLine = parsableByteArray.readLine();
        if (readLine == null) {
            return null;
        }
        Matcher matcher = CUE_HEADER_PATTERN.matcher(readLine);
        if (matcher.matches()) {
            return parseCue(null, matcher, parsableByteArray, list);
        }
        String readLine2 = parsableByteArray.readLine();
        if (readLine2 == null) {
            return null;
        }
        Matcher matcher2 = CUE_HEADER_PATTERN.matcher(readLine2);
        if (matcher2.matches()) {
            return parseCue(readLine.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    static Cue.Builder parseCueSettingsList(String str) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        parseCueSettingsList(str, webvttCueInfoBuilder);
        return webvttCueInfoBuilder.toCueBuilder();
    }

    static Cue newCueForText(CharSequence charSequence) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        webvttCueInfoBuilder.text = charSequence;
        return webvttCueInfoBuilder.toCueBuilder().build();
    }

    static SpannedString parseCueText(String str, String str2, List<WebvttCssStyle> list) {
        String str3 = str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str3.charAt(i);
            if (charAt == '&') {
                i++;
                int indexOf = str3.indexOf(59, i);
                int indexOf2 = str3.indexOf(32, i);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    applyEntity(str3.substring(i, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i++;
            } else {
                int i2 = i + 1;
                if (i2 >= str2.length()) {
                    i = i2;
                } else {
                    int i3 = 1;
                    boolean z = str3.charAt(i2) == '/';
                    int findEndOfTag = findEndOfTag(str3, i2);
                    int i4 = findEndOfTag - 2;
                    boolean z2 = str3.charAt(i4) == '/';
                    if (z) {
                        i3 = 2;
                    }
                    int i5 = i + i3;
                    if (!z2) {
                        i4 = findEndOfTag - 1;
                    }
                    String substring = str3.substring(i5, i4);
                    if (!substring.trim().isEmpty()) {
                        String tagName = getTagName(substring);
                        if (isSupportedTag(tagName)) {
                            if (z) {
                                while (!arrayDeque.isEmpty()) {
                                    StartTag startTag = (StartTag) arrayDeque.pop();
                                    applySpansForTag(str, startTag, arrayList2, spannableStringBuilder, list, arrayList);
                                    if (!arrayDeque.isEmpty()) {
                                        arrayList2.add(new Element(startTag, spannableStringBuilder.length()));
                                    } else {
                                        arrayList2.clear();
                                    }
                                    if (startTag.name.equals(tagName)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                arrayDeque.push(StartTag.buildStartTag(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                    i = findEndOfTag;
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            applySpansForTag(str, (StartTag) arrayDeque.pop(), arrayList2, spannableStringBuilder, list, arrayList);
        }
        applySpansForTag(str, StartTag.buildWholeCueVirtualTag(), Collections.emptyList(), spannableStringBuilder, list, arrayList);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static WebvttCueInfo parseCue(String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            webvttCueInfoBuilder.startTimeUs = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(1)));
            webvttCueInfoBuilder.endTimeUs = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(2)));
            parseCueSettingsList((String) Assertions.checkNotNull(matcher.group(3)), webvttCueInfoBuilder);
            StringBuilder sb = new StringBuilder();
            String readLine = parsableByteArray.readLine();
            while (!TextUtils.isEmpty(readLine)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(readLine.trim());
                readLine = parsableByteArray.readLine();
            }
            webvttCueInfoBuilder.text = parseCueText(str, sb.toString(), list);
            return webvttCueInfoBuilder.build();
        } catch (NumberFormatException unused) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    private static void parseCueSettingsList(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
        while (matcher.find()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    parseLineAttribute(str3, webvttCueInfoBuilder);
                } else if ("align".equals(str2)) {
                    webvttCueInfoBuilder.textAlignment = parseTextAlignment(str3);
                } else if ("position".equals(str2)) {
                    parsePositionAttribute(str3, webvttCueInfoBuilder);
                } else if ("size".equals(str2)) {
                    webvttCueInfoBuilder.size = WebvttParserUtil.parsePercentage(str3);
                } else if ("vertical".equals(str2)) {
                    webvttCueInfoBuilder.verticalType = parseVerticalAttribute(str3);
                } else {
                    Log.w("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    private static void parseLineAttribute(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.lineAnchor = parsePositionAnchor(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.line = WebvttParserUtil.parsePercentage(str);
            webvttCueInfoBuilder.lineType = 0;
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        webvttCueInfoBuilder.line = (float) parseInt;
        webvttCueInfoBuilder.lineType = 1;
    }

    private static void parsePositionAttribute(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.positionAnchor = parsePositionAnchor(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        webvttCueInfoBuilder.position = WebvttParserUtil.parsePercentage(str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int parsePositionAnchor(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1 || c == 2) {
            return 1;
        }
        if (c == 3) {
            return 2;
        }
        Log.w("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(str)));
        return Integer.MIN_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[RETURN] */
    private static int parseVerticalAttribute(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 3462) {
            if (hashCode == 3642 && str.equals("rl")) {
                c = 0;
                if (c == 0) {
                    return 1;
                }
                if (c == 1) {
                    return 2;
                }
                Log.w("WebvttCueParser", "Invalid 'vertical' value: ".concat(String.valueOf(str)));
                return Integer.MIN_VALUE;
            }
        } else if (str.equals("lr")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int parseTextAlignment(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 4;
        }
        if (c == 2 || c == 3) {
            return 2;
        }
        if (c == 4) {
            return 3;
        }
        if (c == 5) {
            return 5;
        }
        Log.w("WebvttCueParser", "Invalid alignment value: ".concat(String.valueOf(str)));
        return 2;
    }

    private static int findEndOfTag(String str, int i) {
        int indexOf = str.indexOf(62, i);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    private static void applyEntity(String str, SpannableStringBuilder spannableStringBuilder) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 3309) {
            if (hashCode != 3464) {
                if (hashCode != 96708) {
                    if (hashCode == 3374865 && str.equals("nbsp")) {
                        c = 2;
                        if (c == 0) {
                            spannableStringBuilder.append('<');
                            return;
                        } else if (c == 1) {
                            spannableStringBuilder.append('>');
                            return;
                        } else if (c == 2) {
                            spannableStringBuilder.append(' ');
                            return;
                        } else if (c != 3) {
                            Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                            return;
                        } else {
                            spannableStringBuilder.append('&');
                            return;
                        }
                    }
                } else if (str.equals("amp")) {
                    c = 3;
                    if (c == 0) {
                    }
                }
            } else if (str.equals("lt")) {
                c = 0;
                if (c == 0) {
                }
            }
        } else if (str.equals("gt")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[RETURN] */
    private static boolean isSupportedTag(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 98) {
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 3650) {
                        if (hashCode != 3314158) {
                            if (hashCode != 3511770) {
                                if (hashCode != 117) {
                                    if (hashCode == 118 && str.equals("v")) {
                                        c = 7;
                                        switch (c) {
                                            case 0:
                                            case 1:
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                return true;
                                            default:
                                                return false;
                                        }
                                    }
                                } else if (str.equals("u")) {
                                    c = 6;
                                    switch (c) {
                                    }
                                }
                            } else if (str.equals("ruby")) {
                                c = 4;
                                switch (c) {
                                }
                            }
                        } else if (str.equals("lang")) {
                            c = 3;
                            switch (c) {
                            }
                        }
                    } else if (str.equals("rt")) {
                        c = 5;
                        switch (c) {
                        }
                    }
                } else if (str.equals("i")) {
                    c = 2;
                    switch (c) {
                    }
                }
            } else if (str.equals("c")) {
                c = 1;
                switch (c) {
                }
            }
        } else if (str.equals("b")) {
            c = 0;
            switch (c) {
            }
        }
        c = 65535;
        switch (c) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b7 A[LOOP:0: B:50:0x00b5->B:51:0x00b7, LOOP_END] */
    private static void applySpansForTag(String str, StartTag startTag, List<Element> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2, List<StyleMatch> list3) {
        char c;
        int size;
        int i = startTag.position;
        int length = spannableStringBuilder.length();
        String str2 = startTag.name;
        int hashCode = str2.hashCode();
        if (hashCode != 0) {
            if (hashCode != 105) {
                if (hashCode != 3314158) {
                    if (hashCode != 3511770) {
                        if (hashCode != 98) {
                            if (hashCode != 99) {
                                if (hashCode != 117) {
                                    if (hashCode == 118 && str2.equals("v")) {
                                        c = 6;
                                        switch (c) {
                                            case 0:
                                                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                                                break;
                                            case 1:
                                                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                                                break;
                                            case 2:
                                                applyRubySpans(list, spannableStringBuilder, i);
                                                break;
                                            case 3:
                                                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                                                break;
                                            case 4:
                                                applyDefaultColors(spannableStringBuilder, startTag.classes, i, length);
                                                break;
                                            case 5:
                                            case 6:
                                            case 7:
                                                break;
                                            default:
                                                return;
                                        }
                                        list3.clear();
                                        getApplicableStyles(list2, str, startTag, list3);
                                        size = list3.size();
                                        for (int i2 = 0; i2 < size; i2++) {
                                            applyStyleToText(spannableStringBuilder, list3.get(i2).style, i, length);
                                        }
                                    }
                                } else if (str2.equals("u")) {
                                    c = 3;
                                    switch (c) {
                                    }
                                    list3.clear();
                                    getApplicableStyles(list2, str, startTag, list3);
                                    size = list3.size();
                                    while (i2 < size) {
                                    }
                                }
                            } else if (str2.equals("c")) {
                                c = 4;
                                switch (c) {
                                }
                                list3.clear();
                                getApplicableStyles(list2, str, startTag, list3);
                                size = list3.size();
                                while (i2 < size) {
                                }
                            }
                        } else if (str2.equals("b")) {
                            c = 0;
                            switch (c) {
                            }
                            list3.clear();
                            getApplicableStyles(list2, str, startTag, list3);
                            size = list3.size();
                            while (i2 < size) {
                            }
                        }
                    } else if (str2.equals("ruby")) {
                        c = 2;
                        switch (c) {
                        }
                        list3.clear();
                        getApplicableStyles(list2, str, startTag, list3);
                        size = list3.size();
                        while (i2 < size) {
                        }
                    }
                } else if (str2.equals("lang")) {
                    c = 5;
                    switch (c) {
                    }
                    list3.clear();
                    getApplicableStyles(list2, str, startTag, list3);
                    size = list3.size();
                    while (i2 < size) {
                    }
                }
            } else if (str2.equals("i")) {
                c = 1;
                switch (c) {
                }
                list3.clear();
                getApplicableStyles(list2, str, startTag, list3);
                size = list3.size();
                while (i2 < size) {
                }
            }
        } else if (str2.equals("")) {
            c = 7;
            switch (c) {
            }
            list3.clear();
            getApplicableStyles(list2, str, startTag, list3);
            size = list3.size();
            while (i2 < size) {
            }
        }
        c = 65535;
        switch (c) {
        }
        list3.clear();
        getApplicableStyles(list2, str, startTag, list3);
        size = list3.size();
        while (i2 < size) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.text.SpannableStringBuilder.delete(int, int):android.text.SpannableStringBuilder}
     arg types: [int, int]
     candidates:
      ClspMth{android.text.SpannableStringBuilder.delete(int, int):android.text.Editable}
      ClspMth{android.text.SpannableStringBuilder.delete(int, int):android.text.SpannableStringBuilder} */
    private static void applyRubySpans(List<Element> list, SpannableStringBuilder spannableStringBuilder, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, Element.BY_START_POSITION_ASC);
        int i2 = i;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if ("rt".equals(((Element) arrayList.get(i4)).startTag.name)) {
                Element element = (Element) arrayList.get(i4);
                int i5 = element.startTag.position - i3;
                int i6 = element.endPosition - i3;
                CharSequence subSequence = spannableStringBuilder.subSequence(i5, i6);
                spannableStringBuilder.delete(i5, i6);
                spannableStringBuilder.setSpan(new RubySpan(subSequence.toString(), 1), i2, i5, 33);
                i3 += subSequence.length();
                i2 = i5;
            }
        }
    }

    private static void applyDefaultColors(SpannableStringBuilder spannableStringBuilder, String[] strArr, int i, int i2) {
        for (String str : strArr) {
            if (DEFAULT_TEXT_COLORS.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(DEFAULT_TEXT_COLORS.get(str).intValue()), i, i2, 33);
            } else if (DEFAULT_BACKGROUND_COLORS.containsKey(str)) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(DEFAULT_BACKGROUND_COLORS.get(str).intValue()), i, i2, 33);
            }
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i, int i2) {
        if (webvttCssStyle != null) {
            if (webvttCssStyle.getStyle() != -1) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new StyleSpan(webvttCssStyle.getStyle()), i, i2, 33);
            }
            if (webvttCssStyle.isLinethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
            if (webvttCssStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (webvttCssStyle.hasFontColor()) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.getFontColor()), i, i2, 33);
            }
            if (webvttCssStyle.hasBackgroundColor()) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i, i2, 33);
            }
            if (webvttCssStyle.getFontFamily() != null) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.getFontFamily()), i, i2, 33);
            }
            Layout.Alignment textAlign = webvttCssStyle.getTextAlign();
            if (textAlign != null) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new AlignmentSpan.Standard(textAlign), i, i2, 33);
            }
            int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
            if (fontSizeUnit == 1) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i, i2, 33);
            } else if (fontSizeUnit == 2) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.getFontSize()), i, i2, 33);
            } else if (fontSizeUnit == 3) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i, i2, 33);
            }
            if (webvttCssStyle.getCombineUpright()) {
                spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i, i2, 33);
            }
        }
    }

    private static String getTagName(String str) {
        String trim = str.trim();
        Assertions.checkArgument(!trim.isEmpty());
        return Util.splitAtFirst(trim, "[ \\.]")[0];
    }

    private static void getApplicableStyles(List<WebvttCssStyle> list, String str, StartTag startTag, List<StyleMatch> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            WebvttCssStyle webvttCssStyle = list.get(i);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.name, startTag.classes, startTag.voice);
            if (specificityScore > 0) {
                list2.add(new StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(list2);
    }

    static final class WebvttCueInfoBuilder {
        public long endTimeUs = 0;
        public float line = -3.4028235E38f;
        public int lineAnchor = 0;
        public int lineType = 1;
        public float position = -3.4028235E38f;
        public int positionAnchor = Integer.MIN_VALUE;
        public float size = 1.0f;
        public long startTimeUs = 0;
        public CharSequence text;
        public int textAlignment = 2;
        public int verticalType = Integer.MIN_VALUE;

        private static float computeLine(float f, int i) {
            if (f == -3.4028235E38f || i != 0 || (f >= 0.0f && f <= 1.0f)) {
                return f != -3.4028235E38f ? f : i == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static float derivePosition(int i) {
            if (i != 4) {
                return i != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int derivePositionAnchor(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 3) {
                return 2;
            }
            if (i != 4) {
                return i != 5 ? 1 : 2;
            }
            return 0;
        }

        public final WebvttCueInfo build() {
            return new WebvttCueInfo(toCueBuilder().build(), this.startTimeUs, this.endTimeUs);
        }

        public final Cue.Builder toCueBuilder() {
            float f = this.position;
            if (f == -3.4028235E38f) {
                f = derivePosition(this.textAlignment);
            }
            int i = this.positionAnchor;
            if (i == Integer.MIN_VALUE) {
                i = derivePositionAnchor(this.textAlignment);
            }
            Cue.Builder verticalType2 = new Cue.Builder().setTextAlignment(convertTextAlignment(this.textAlignment)).setLine(computeLine(this.line, this.lineType), this.lineType).setLineAnchor(this.lineAnchor).setPosition(f).setPositionAnchor(i).setSize(Math.min(this.size, deriveMaxSize(i, f))).setVerticalType(this.verticalType);
            CharSequence charSequence = this.text;
            if (charSequence != null) {
                verticalType2.setText(charSequence);
            }
            return verticalType2;
        }

        private static Layout.Alignment convertTextAlignment(int i) {
            if (i != 1) {
                if (i == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            Log.w("WebvttCueParser", "Unknown textAlignment: ".concat(String.valueOf(i)));
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float deriveMaxSize(int i, float f) {
            if (i == 0) {
                return 1.0f - f;
            }
            if (i == 1) {
                return f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            }
            if (i == 2) {
                return f;
            }
            throw new IllegalStateException(String.valueOf(i));
        }
    }

    static final class StyleMatch implements Comparable<StyleMatch> {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int i, WebvttCssStyle webvttCssStyle) {
            this.score = i;
            this.style = webvttCssStyle;
        }

        public final int compareTo(StyleMatch styleMatch) {
            return this.score - styleMatch.score;
        }
    }

    static final class StartTag {
        private static final String[] NO_CLASSES = new String[0];
        public final String[] classes;
        public final String name;
        public final int position;
        public final String voice;

        private StartTag(String str, int i, String str2, String[] strArr) {
            this.position = i;
            this.name = str;
            this.voice = str2;
            this.classes = strArr;
        }

        public static StartTag buildStartTag(String str, int i) {
            String str2;
            String[] strArr;
            String trim = str.trim();
            Assertions.checkArgument(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = Util.split(trim, "\\.");
            String str3 = split[0];
            if (split.length > 1) {
                strArr = (String[]) Util.nullSafeArrayCopyOfRange(split, 1, split.length);
            } else {
                strArr = NO_CLASSES;
            }
            return new StartTag(str3, i, str2, strArr);
        }

        public static StartTag buildWholeCueVirtualTag() {
            return new StartTag("", 0, "", new String[0]);
        }
    }

    static class Element {
        public static final Comparator<Element> BY_START_POSITION_ASC = $$Lambda$WebvttCueParser$Element$4KhPRsWvpiZYEaC2rBkxMGYdSI8.INSTANCE;
        public final int endPosition;
        public final StartTag startTag;

        private Element(StartTag startTag2, int i) {
            this.startTag = startTag2;
            this.endPosition = i;
        }
    }
}
