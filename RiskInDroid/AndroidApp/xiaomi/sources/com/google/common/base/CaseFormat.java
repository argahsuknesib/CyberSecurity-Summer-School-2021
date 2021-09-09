package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.is('-'), "-") {
        /* access modifiers changed from: package-private */
        public final String normalizeWord(String str) {
            return Ascii.toLowerCase(str);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
          ClspMth{java.lang.String.replace(char, char):java.lang.String} */
        /* access modifiers changed from: package-private */
        public final String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(str.replace('-', '_'));
            }
            return CaseFormat.super.convert(caseFormat, str);
        }
    },
    LOWER_UNDERSCORE(CharMatcher.is('_'), "_") {
        /* access modifiers changed from: package-private */
        public final String normalizeWord(String str) {
            return Ascii.toLowerCase(str);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
          ClspMth{java.lang.String.replace(char, char):java.lang.String} */
        /* access modifiers changed from: package-private */
        public final String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(str);
            }
            return CaseFormat.super.convert(caseFormat, str);
        }
    },
    LOWER_CAMEL(CharMatcher.inRange('A', 'Z'), "") {
        /* access modifiers changed from: package-private */
        public final String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_CAMEL(CharMatcher.inRange('A', 'Z'), "") {
        /* access modifiers changed from: package-private */
        public final String normalizeWord(String str) {
            return CaseFormat.firstCharOnlyToUpper(str);
        }
    },
    UPPER_UNDERSCORE(CharMatcher.is('_'), "_") {
        /* access modifiers changed from: package-private */
        public final String normalizeWord(String str) {
            return Ascii.toUpperCase(str);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
         arg types: [int, int]
         candidates:
          ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
          ClspMth{java.lang.String.replace(char, char):java.lang.String} */
        /* access modifiers changed from: package-private */
        public final String convert(CaseFormat caseFormat, String str) {
            if (caseFormat == LOWER_HYPHEN) {
                return Ascii.toLowerCase(str.replace('_', '-'));
            }
            if (caseFormat == LOWER_UNDERSCORE) {
                return Ascii.toLowerCase(str);
            }
            return CaseFormat.super.convert(caseFormat, str);
        }
    };
    
    private final CharMatcher wordBoundary;
    private final String wordSeparator;

    /* access modifiers changed from: package-private */
    public abstract String normalizeWord(String str);

    private CaseFormat(CharMatcher charMatcher, String str) {
        this.wordBoundary = charMatcher;
        this.wordSeparator = str;
    }

    public final String to(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(str);
        if (caseFormat == this) {
            return str;
        }
        return convert(caseFormat, str);
    }

    /* access modifiers changed from: package-private */
    public String convert(CaseFormat caseFormat, String str) {
        int i = 0;
        StringBuilder sb = null;
        int i2 = -1;
        while (true) {
            i2 = this.wordBoundary.indexIn(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                sb.append(caseFormat.normalizeFirstWord(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.normalizeWord(str.substring(i, i2)));
            }
            sb.append(caseFormat.wordSeparator);
            i = this.wordSeparator.length() + i2;
        }
        if (i == 0) {
            return caseFormat.normalizeFirstWord(str);
        }
        sb.append(caseFormat.normalizeWord(str.substring(i)));
        return sb.toString();
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new StringConverter(this, caseFormat);
    }

    static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        private final CaseFormat sourceFormat;
        private final CaseFormat targetFormat;

        StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.sourceFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat);
            this.targetFormat = (CaseFormat) Preconditions.checkNotNull(caseFormat2);
        }

        /* access modifiers changed from: protected */
        public final String doForward(String str) {
            return this.sourceFormat.to(this.targetFormat, str);
        }

        /* access modifiers changed from: protected */
        public final String doBackward(String str) {
            return this.targetFormat.to(this.sourceFormat, str);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                StringConverter stringConverter = (StringConverter) obj;
                if (!this.sourceFormat.equals(stringConverter.sourceFormat) || !this.targetFormat.equals(stringConverter.targetFormat)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
        }

        public final String toString() {
            return this.sourceFormat + ".converterTo(" + this.targetFormat + ")";
        }
    }

    private String normalizeFirstWord(String str) {
        return this == LOWER_CAMEL ? Ascii.toLowerCase(str) : normalizeWord(str);
    }

    public static String firstCharOnlyToUpper(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.toUpperCase(str.charAt(0)) + Ascii.toLowerCase(str.substring(1));
    }
}
