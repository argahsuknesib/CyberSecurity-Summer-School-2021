package _m_j;

import android.text.SpannableStringBuilder;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public final class av {

    /* renamed from: O000000o  reason: collision with root package name */
    static final ax f12631O000000o = ay.O00000o0;
    static final av O00000Oo = new av(false, 2, f12631O000000o);
    static final av O00000o0 = new av(true, 2, f12631O000000o);
    private static final String O00000oO = Character.toString(8206);
    private static final String O00000oo = Character.toString(8207);
    public final ax O00000o;
    private final boolean O0000O0o;
    private final int O0000OOo;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f12632O000000o = av.O000000o(Locale.getDefault());
        int O00000Oo = 2;
        ax O00000o0 = av.f12631O000000o;
    }

    public static av O000000o() {
        O000000o o000000o = new O000000o();
        if (o000000o.O00000Oo != 2 || o000000o.O00000o0 != f12631O000000o) {
            return new av(o000000o.f12632O000000o, o000000o.O00000Oo, o000000o.O00000o0);
        }
        if (o000000o.f12632O000000o) {
            return O00000o0;
        }
        return O00000Oo;
    }

    private av(boolean z, int i, ax axVar) {
        this.O0000O0o = z;
        this.O0000OOo = i;
        this.O00000o = axVar;
    }

    public final CharSequence O000000o(CharSequence charSequence, ax axVar, boolean z) {
        ax axVar2;
        ax axVar3;
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean O000000o2 = axVar.O000000o(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str2 = "";
        if ((this.O0000OOo & 2) != 0) {
            if (O000000o2) {
                axVar3 = ay.O00000Oo;
            } else {
                axVar3 = ay.f12694O000000o;
            }
            boolean O000000o3 = axVar3.O000000o(charSequence, charSequence.length());
            if (!this.O0000O0o && (O000000o3 || O00000Oo(charSequence) == 1)) {
                str = O00000oO;
            } else if (!this.O0000O0o || (O000000o3 && O00000Oo(charSequence) != -1)) {
                str = str2;
            } else {
                str = O00000oo;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        if (O000000o2 != this.O0000O0o) {
            spannableStringBuilder.append(O000000o2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (O000000o2) {
            axVar2 = ay.O00000Oo;
        } else {
            axVar2 = ay.f12694O000000o;
        }
        boolean O000000o4 = axVar2.O000000o(charSequence, charSequence.length());
        if (!this.O0000O0o && (O000000o4 || O000000o(charSequence) == 1)) {
            str2 = O00000oO;
        } else if (this.O0000O0o && (!O000000o4 || O000000o(charSequence) == -1)) {
            str2 = O00000oo;
        }
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }

    static boolean O000000o(Locale locale) {
        return az.O000000o(locale) == 1;
    }

    private static int O000000o(CharSequence charSequence) {
        return new O00000Oo(charSequence).O00000Oo();
    }

    private static int O00000Oo(CharSequence charSequence) {
        return new O00000Oo(charSequence).O000000o();
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final byte[] f12633O000000o = new byte[1792];
        private final CharSequence O00000Oo;
        private final int O00000o;
        private final boolean O00000o0 = false;
        private int O00000oO;
        private char O00000oo;

        static {
            for (int i = 0; i < 1792; i++) {
                f12633O000000o[i] = Character.getDirectionality(i);
            }
        }

        O00000Oo(CharSequence charSequence) {
            this.O00000Oo = charSequence;
            this.O00000o = charSequence.length();
        }

        /* access modifiers changed from: package-private */
        public final int O000000o() {
            this.O00000oO = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.O00000oO < this.O00000o && i == 0) {
                byte O00000o02 = O00000o0();
                if (O00000o02 != 0) {
                    if (O00000o02 == 1 || O00000o02 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (O00000o02 != 9) {
                        switch (O00000o02) {
                            case 14:
                            case GmsLogger.MAX_PII_TAG_LENGTH:
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
            while (this.O00000oO > 0) {
                switch (O00000o()) {
                    case 14:
                    case GmsLogger.MAX_PII_TAG_LENGTH:
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
        public final int O00000Oo() {
            this.O00000oO = this.O00000o;
            int i = 0;
            int i2 = 0;
            while (this.O00000oO > 0) {
                byte O00000o2 = O00000o();
                if (O00000o2 != 0) {
                    if (O00000o2 == 1 || O00000o2 == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i != 0) {
                        }
                    } else if (O00000o2 != 9) {
                        switch (O00000o2) {
                            case 14:
                            case GmsLogger.MAX_PII_TAG_LENGTH:
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

        private static byte O000000o(char c) {
            return c < 1792 ? f12633O000000o[c] : Character.getDirectionality(c);
        }

        private byte O00000o0() {
            this.O00000oo = this.O00000Oo.charAt(this.O00000oO);
            if (Character.isHighSurrogate(this.O00000oo)) {
                int codePointAt = Character.codePointAt(this.O00000Oo, this.O00000oO);
                this.O00000oO += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.O00000oO++;
            byte O000000o2 = O000000o(this.O00000oo);
            if (!this.O00000o0) {
                return O000000o2;
            }
            char c = this.O00000oo;
            if (c == '<') {
                return O00000oO();
            }
            return c == '&' ? O0000O0o() : O000000o2;
        }

        private byte O00000o() {
            this.O00000oo = this.O00000Oo.charAt(this.O00000oO - 1);
            if (Character.isLowSurrogate(this.O00000oo)) {
                int codePointBefore = Character.codePointBefore(this.O00000Oo, this.O00000oO);
                this.O00000oO -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.O00000oO--;
            byte O000000o2 = O000000o(this.O00000oo);
            if (!this.O00000o0) {
                return O000000o2;
            }
            char c = this.O00000oo;
            if (c == '>') {
                return O00000oo();
            }
            return c == ';' ? O0000OOo() : O000000o2;
        }

        private byte O00000oO() {
            char charAt;
            int i = this.O00000oO;
            while (true) {
                int i2 = this.O00000oO;
                if (i2 < this.O00000o) {
                    CharSequence charSequence = this.O00000Oo;
                    this.O00000oO = i2 + 1;
                    this.O00000oo = charSequence.charAt(i2);
                    char c = this.O00000oo;
                    if (c == '>') {
                        return 12;
                    }
                    if (c == '\"' || c == '\'') {
                        char c2 = this.O00000oo;
                        do {
                            int i3 = this.O00000oO;
                            if (i3 >= this.O00000o) {
                                break;
                            }
                            CharSequence charSequence2 = this.O00000Oo;
                            this.O00000oO = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.O00000oo = charAt;
                        } while (charAt != c2);
                    }
                } else {
                    this.O00000oO = i;
                    this.O00000oo = '<';
                    return 13;
                }
            }
        }

        private byte O00000oo() {
            char charAt;
            int i = this.O00000oO;
            while (true) {
                int i2 = this.O00000oO;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.O00000Oo;
                int i3 = i2 - 1;
                this.O00000oO = i3;
                this.O00000oo = charSequence.charAt(i3);
                char c = this.O00000oo;
                if (c != '<') {
                    if (c == '>') {
                        break;
                    } else if (c == '\"' || c == '\'') {
                        char c2 = this.O00000oo;
                        do {
                            int i4 = this.O00000oO;
                            if (i4 <= 0) {
                                break;
                            }
                            CharSequence charSequence2 = this.O00000Oo;
                            int i5 = i4 - 1;
                            this.O00000oO = i5;
                            charAt = charSequence2.charAt(i5);
                            this.O00000oo = charAt;
                        } while (charAt != c2);
                    }
                } else {
                    return 12;
                }
            }
            this.O00000oO = i;
            this.O00000oo = '>';
            return 13;
        }

        private byte O0000O0o() {
            char charAt;
            do {
                int i = this.O00000oO;
                if (i >= this.O00000o) {
                    return 12;
                }
                CharSequence charSequence = this.O00000Oo;
                this.O00000oO = i + 1;
                charAt = charSequence.charAt(i);
                this.O00000oo = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte O0000OOo() {
            char c;
            int i = this.O00000oO;
            do {
                int i2 = this.O00000oO;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.O00000Oo;
                int i3 = i2 - 1;
                this.O00000oO = i3;
                this.O00000oo = charSequence.charAt(i3);
                c = this.O00000oo;
                if (c == '&') {
                    return 12;
                }
            } while (c != ';');
            this.O00000oO = i;
            this.O00000oo = ';';
            return 13;
        }
    }
}
