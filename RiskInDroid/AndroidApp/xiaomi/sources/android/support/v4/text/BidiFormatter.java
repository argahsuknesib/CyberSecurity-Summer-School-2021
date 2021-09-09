package android.support.v4.text;

import android.text.SpannableStringBuilder;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public final class BidiFormatter {
    public static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String LRM_STRING = Character.toString(8206);
    private static final String RLM_STRING = Character.toString(8207);
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public final Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public final Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        public final BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public final boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public final boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getExitDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            return (!isRtl || getExitDir(charSequence) == -1) ? RLM_STRING : "";
        }
        return "";
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getEntryDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            return (!isRtl || getEntryDir(charSequence) == -1) ? RLM_STRING : "";
        }
        return "";
    }

    public final boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public final boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence
     arg types: [java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean]
     candidates:
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence */
    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public final CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((CharSequence) markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String
     arg types: [java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, int]
     candidates:
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String */
    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence
     arg types: [java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, int]
     candidates:
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence */
    public final CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public final String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public final CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String
     arg types: [java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, int]
     candidates:
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String */
    public final String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence
     arg types: [java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, int]
     candidates:
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.String, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.String
      android.support.v4.text.BidiFormatter.unicodeWrap(java.lang.CharSequence, android.support.v4.text.TextDirectionHeuristicCompat, boolean):java.lang.CharSequence */
    public final CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[1792];
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        /* access modifiers changed from: package-private */
        public int getEntryDir() {
            this.charIndex = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex < this.length && i == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != 0) {
                    if (dirTypeForward == 1 || dirTypeForward == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (dirTypeForward != 9) {
                        switch (dirTypeForward) {
                            case 14:
                            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 14:
                    case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int getExitDir() {
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
                byte dirTypeBackward = dirTypeBackward();
                if (dirTypeBackward != 0) {
                    if (dirTypeBackward == 1 || dirTypeBackward == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i != 0) {
                        }
                    } else if (dirTypeBackward != 9) {
                        switch (dirTypeBackward) {
                            case 14:
                            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                                if (i == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i != 0) {
                                    break;
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                } else if (i2 == 0) {
                    return -1;
                } else {
                    if (i != 0) {
                    }
                }
                i = i2;
            }
            return 0;
        }

        private static byte getCachedDirectionality(char c) {
            return c < 1792 ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }

        /* access modifiers changed from: package-private */
        public byte dirTypeForward() {
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c = this.lastChar;
            if (c == '<') {
                return skipTagForward();
            }
            return c == '&' ? skipEntityForward() : cachedDirectionality;
        }

        /* access modifiers changed from: package-private */
        public byte dirTypeBackward() {
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (!this.isHtml) {
                return cachedDirectionality;
            }
            char c = this.lastChar;
            if (c == '>') {
                return skipTagBackward();
            }
            return c == ';' ? skipEntityBackward() : cachedDirectionality;
        }

        private byte skipTagForward() {
            char charAt;
            int i = this.charIndex;
            while (true) {
                int i2 = this.charIndex;
                if (i2 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i2 + 1;
                    this.lastChar = charSequence.charAt(i2);
                    char c = this.lastChar;
                    if (c == '>') {
                        return 12;
                    }
                    if (c == '\"' || c == '\'') {
                        char c2 = this.lastChar;
                        do {
                            int i3 = this.charIndex;
                            if (i3 >= this.length) {
                                break;
                            }
                            CharSequence charSequence2 = this.text;
                            this.charIndex = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.lastChar = charAt;
                        } while (charAt != c2);
                    }
                } else {
                    this.charIndex = i;
                    this.lastChar = '<';
                    return 13;
                }
            }
        }

        private byte skipTagBackward() {
            char charAt;
            int i = this.charIndex;
            while (true) {
                int i2 = this.charIndex;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i3 = i2 - 1;
                this.charIndex = i3;
                this.lastChar = charSequence.charAt(i3);
                char c = this.lastChar;
                if (c != '<') {
                    if (c == '>') {
                        break;
                    } else if (c == '\"' || c == '\'') {
                        char c2 = this.lastChar;
                        do {
                            int i4 = this.charIndex;
                            if (i4 <= 0) {
                                break;
                            }
                            CharSequence charSequence2 = this.text;
                            int i5 = i4 - 1;
                            this.charIndex = i5;
                            charAt = charSequence2.charAt(i5);
                            this.lastChar = charAt;
                        } while (charAt != c2);
                    }
                } else {
                    return 12;
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return 13;
        }

        private byte skipEntityForward() {
            char charAt;
            do {
                int i = this.charIndex;
                if (i >= this.length) {
                    return 12;
                }
                CharSequence charSequence = this.text;
                this.charIndex = i + 1;
                charAt = charSequence.charAt(i);
                this.lastChar = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte skipEntityBackward() {
            char c;
            int i = this.charIndex;
            do {
                int i2 = this.charIndex;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i3 = i2 - 1;
                this.charIndex = i3;
                this.lastChar = charSequence.charAt(i3);
                c = this.lastChar;
                if (c == '&') {
                    return 12;
                }
            } while (c != ';');
            this.charIndex = i;
            this.lastChar = ';';
            return 13;
        }
    }
}
