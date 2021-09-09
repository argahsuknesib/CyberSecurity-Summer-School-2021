package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

@GwtCompatible
@Beta
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() {
        /* class com.google.common.escape.Escapers.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final char[] escape(char c) {
            return null;
        }

        public final String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    };

    private Escapers() {
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Beta
    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        public String unsafeReplacement;

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = 65535;
            this.unsafeReplacement = null;
        }

        @CanIgnoreReturnValue
        public final Builder setSafeRange(char c, char c2) {
            this.safeMin = c;
            this.safeMax = c2;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder addEscape(char c, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c), str);
            return this;
        }

        public final Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                /* class com.google.common.escape.Escapers.Builder.AnonymousClass1 */
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                /* access modifiers changed from: protected */
                public char[] escapeUnsafe(char c) {
                    return this.replacementChars;
                }
            };
        }
    }

    static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static String computeReplacement(CharEscaper charEscaper, char c) {
        return stringOrNull(charEscaper.escape(c));
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i) {
        return stringOrNull(unicodeEscaper.escape(i));
    }

    private static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            /* class com.google.common.escape.Escapers.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final char[] escape(int i) {
                if (i < 65536) {
                    return charEscaper.escape((char) i);
                }
                char[] cArr = new char[2];
                Character.toChars(i, cArr, 0);
                char[] escape = charEscaper.escape(cArr[0]);
                char[] escape2 = charEscaper.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                int length = escape != null ? escape.length : 1;
                char[] cArr2 = new char[((escape2 != null ? escape2.length : 1) + length)];
                if (escape != null) {
                    for (int i2 = 0; i2 < escape.length; i2++) {
                        cArr2[i2] = escape[i2];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i3 = 0; i3 < escape2.length; i3++) {
                        cArr2[length + i3] = escape2[i3];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }
}
