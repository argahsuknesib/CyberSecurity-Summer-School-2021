package _m_j;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class bdq extends bdp {
    public final int O0000o;
    public final int O0000o0o;
    private final String O0000oO;
    public final int O0000oO0;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 <= '4') goto L_0x0020;
     */
    private static boolean O000000o(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '1') {
            if (c == '2') {
                if (c2 >= '0') {
                }
            }
            return false;
        } else if (c2 < '0' || c2 > '9') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (!(c3 == '6' && c4 == '0')) {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        return (c5 < '0' || c5 > '5') ? c5 == '6' && c6 == '0' : c6 >= '0' && c6 <= '9';
    }

    private static boolean O000000o(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c == '1' || c == '2') && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (!(c5 == '1' && (c6 == '0' || c6 == '1' || c6 == '2'))) {
                return false;
            }
            return i == 48 ? i2 >= 49 && i2 <= 57 : (i == 49 || i == 50) ? i2 >= 48 && i2 <= 57 : i == 51 && (i2 == 48 || i2 == 49);
        }
    }

    public bdq(String str) {
        this(str, bdf.O00000Oo);
    }

    public bdq(String str, int i) {
        this.O0000o0o = 10;
        this.O0000o = 19;
        this.O0000oO0 = 23;
        this.O00000o0 = i;
        this.O0000oO = str;
        this.O00000oO = -1;
        O0000OoO();
        if (this.O00000o == 65279) {
            O0000OoO();
        }
    }

    public final char O00000o0(int i) {
        if (i >= this.O0000oO.length()) {
            return 26;
        }
        return this.O0000oO.charAt(i);
    }

    public final char O0000OoO() {
        int i = this.O00000oO + 1;
        this.O00000oO = i;
        char O00000o0 = O00000o0(i);
        this.O00000o = O00000o0;
        return O00000o0;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, int i2, char[] cArr) {
        this.O0000oO.getChars(i, i2 + i, cArr, 0);
    }

    public final String O000000o(int i, int i2, int i3, bdv bdv) {
        return bdv.O000000o(this.O0000oO, i, i2, i3);
    }

    public final byte[] O0000o0o() {
        return bib.O000000o(this.O0000oO, this.O0000Oo0 + 1, this.O0000OOo);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i, char[] cArr, int i2) {
        this.O0000oO.getChars(i, i2 + i, cArr, 0);
    }

    public final String O0000oO0() {
        if (!this.O0000Oo) {
            return this.O0000oO.substring(this.O0000Oo0 + 1, this.O0000Oo0 + 1 + this.O0000OOo);
        }
        return new String(this.O0000O0o, 0, this.O0000OOo);
    }

    private String O000000o(int i, int i2) {
        return this.O0000oO.substring(i, i2 + i);
    }

    public final String O0000OOo() {
        char O00000o0 = O00000o0((this.O0000Oo0 + this.O0000OOo) - 1);
        int i = this.O0000OOo;
        if (O00000o0 == 'L' || O00000o0 == 'S' || O00000o0 == 'B' || O00000o0 == 'F' || O00000o0 == 'D') {
            i--;
        }
        return this.O0000oO.substring(this.O0000Oo0, this.O0000Oo0 + i);
    }

    public final boolean O0000ooo() {
        return O00000Oo(true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bdq.O000000o(char, char, char, char, char, char, int, int):boolean
     arg types: [char, char, char, char, char, char, char, char]
     candidates:
      _m_j.bdq.O000000o(char, char, char, char, char, char, char, char):void
      _m_j.bdq.O000000o(char, char, char, char, char, char, int, int):boolean */
    public final boolean O00000Oo(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = this.O0000oO.length() - this.O00000oO;
        if (!z && length > 13) {
            char O00000o0 = O00000o0(this.O00000oO);
            char O00000o02 = O00000o0(this.O00000oO + 1);
            char O00000o03 = O00000o0(this.O00000oO + 2);
            char O00000o04 = O00000o0(this.O00000oO + 3);
            char O00000o05 = O00000o0(this.O00000oO + 4);
            char O00000o06 = O00000o0(this.O00000oO + 5);
            char O00000o07 = O00000o0((this.O00000oO + length) - 1);
            char O00000o08 = O00000o0((this.O00000oO + length) - 2);
            if (O00000o0 == '/' && O00000o02 == 'D' && O00000o03 == 'a' && O00000o04 == 't' && O00000o05 == 'e' && O00000o06 == '(' && O00000o07 == '/' && O00000o08 == ')') {
                int i5 = -1;
                for (int i6 = 6; i6 < length; i6++) {
                    char O00000o09 = O00000o0(this.O00000oO + i6);
                    if (O00000o09 != '+') {
                        if (O00000o09 < '0' || O00000o09 > '9') {
                            break;
                        }
                    } else {
                        i5 = i6;
                    }
                }
                if (i5 == -1) {
                    return false;
                }
                int i7 = this.O00000oO + 6;
                long parseLong = Long.parseLong(O000000o(i7, i5 - i7));
                this.O0000OoO = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                this.O0000OoO.setTimeInMillis(parseLong);
                this.f12888O000000o = 5;
                return true;
            }
        }
        if (length == 8 || length == 14 || length == 17) {
            if (z) {
                return false;
            }
            char O00000o010 = O00000o0(this.O00000oO);
            char O00000o011 = O00000o0(this.O00000oO + 1);
            char O00000o012 = O00000o0(this.O00000oO + 2);
            char O00000o013 = O00000o0(this.O00000oO + 3);
            char O00000o014 = O00000o0(this.O00000oO + 4);
            char O00000o015 = O00000o0(this.O00000oO + 5);
            char O00000o016 = O00000o0(this.O00000oO + 6);
            char O00000o017 = O00000o0(this.O00000oO + 7);
            if (!O000000o(O00000o010, O00000o011, O00000o012, O00000o013, O00000o014, O00000o015, (int) O00000o016, (int) O00000o017)) {
                return false;
            }
            O000000o(O00000o010, O00000o011, O00000o012, O00000o013, O00000o014, O00000o015, O00000o016, O00000o017);
            if (length != 8) {
                char O00000o018 = O00000o0(this.O00000oO + 8);
                char O00000o019 = O00000o0(this.O00000oO + 9);
                char O00000o020 = O00000o0(this.O00000oO + 10);
                char O00000o021 = O00000o0(this.O00000oO + 11);
                char O00000o022 = O00000o0(this.O00000oO + 12);
                char O00000o023 = O00000o0(this.O00000oO + 13);
                if (!O000000o(O00000o018, O00000o019, O00000o020, O00000o021, O00000o022, O00000o023)) {
                    return false;
                }
                if (length == 17) {
                    char O00000o024 = O00000o0(this.O00000oO + 14);
                    char O00000o025 = O00000o0(this.O00000oO + 15);
                    char O00000o026 = O00000o0(this.O00000oO + 16);
                    if (O00000o024 < '0' || O00000o024 > '9' || O00000o025 < '0' || O00000o025 > '9' || O00000o026 < '0' || O00000o026 > '9') {
                        return false;
                    }
                    i3 = (O0000o0O[O00000o024] * 100) + (O0000o0O[O00000o025] * 10) + O0000o0O[O00000o026];
                } else {
                    i3 = 0;
                }
                i4 = (O0000o0O[O00000o018] * 10) + O0000o0O[O00000o019];
                i = (O0000o0O[O00000o020] * 10) + O0000o0O[O00000o021];
                i2 = (O0000o0O[O00000o022] * 10) + O0000o0O[O00000o023];
            } else {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            }
            this.O0000OoO.set(11, i4);
            this.O0000OoO.set(12, i);
            this.O0000OoO.set(13, i2);
            this.O0000OoO.set(14, i3);
            this.f12888O000000o = 5;
            return true;
        } else if (length < this.O0000o0o || O00000o0(this.O00000oO + 4) != '-' || O00000o0(this.O00000oO + 7) != '-') {
            return false;
        } else {
            char O00000o027 = O00000o0(this.O00000oO);
            char O00000o028 = O00000o0(this.O00000oO + 1);
            char O00000o029 = O00000o0(this.O00000oO + 2);
            char O00000o030 = O00000o0(this.O00000oO + 3);
            char O00000o031 = O00000o0(this.O00000oO + 5);
            char O00000o032 = O00000o0(this.O00000oO + 6);
            char O00000o033 = O00000o0(this.O00000oO + 8);
            char O00000o034 = O00000o0(this.O00000oO + 9);
            if (!O000000o(O00000o027, O00000o028, O00000o029, O00000o030, O00000o031, O00000o032, (int) O00000o033, (int) O00000o034)) {
                return false;
            }
            O000000o(O00000o027, O00000o028, O00000o029, O00000o030, O00000o031, O00000o032, O00000o033, O00000o034);
            char O00000o035 = O00000o0(this.O00000oO + 10);
            if (O00000o035 == 'T' || (O00000o035 == ' ' && !z)) {
                if (length < this.O0000o || O00000o0(this.O00000oO + 13) != ':' || O00000o0(this.O00000oO + 16) != ':') {
                    return false;
                }
                char O00000o036 = O00000o0(this.O00000oO + 11);
                char O00000o037 = O00000o0(this.O00000oO + 12);
                char O00000o038 = O00000o0(this.O00000oO + 14);
                char O00000o039 = O00000o0(this.O00000oO + 15);
                char O00000o040 = O00000o0(this.O00000oO + 17);
                char O00000o041 = O00000o0(this.O00000oO + 18);
                if (!O000000o(O00000o036, O00000o037, O00000o038, O00000o039, O00000o040, O00000o041)) {
                    return false;
                }
                int i8 = (O0000o0O[O00000o036] * 10) + O0000o0O[O00000o037];
                int i9 = (O0000o0O[O00000o038] * 10) + O0000o0O[O00000o039];
                int i10 = (O0000o0O[O00000o040] * 10) + O0000o0O[O00000o041];
                this.O0000OoO.set(11, i8);
                this.O0000OoO.set(12, i9);
                this.O0000OoO.set(13, i10);
                if (O00000o0(this.O00000oO + 19) != '.') {
                    this.O0000OoO.set(14, 0);
                    int i11 = this.O00000oO + 19;
                    this.O00000oO = i11;
                    this.O00000o = O00000o0(i11);
                    this.f12888O000000o = 5;
                    return true;
                } else if (length < this.O0000oO0) {
                    return false;
                } else {
                    char O00000o042 = O00000o0(this.O00000oO + 20);
                    char O00000o043 = O00000o0(this.O00000oO + 21);
                    char O00000o044 = O00000o0(this.O00000oO + 22);
                    if (O00000o042 < '0' || O00000o042 > '9' || O00000o043 < '0' || O00000o043 > '9' || O00000o044 < '0' || O00000o044 > '9') {
                        return false;
                    }
                    this.O0000OoO.set(14, (O0000o0O[O00000o042] * 100) + (O0000o0O[O00000o043] * 10) + O0000o0O[O00000o044]);
                    int i12 = this.O00000oO + 23;
                    this.O00000oO = i12;
                    this.O00000o = O00000o0(i12);
                    this.f12888O000000o = 5;
                    return true;
                }
            } else if (O00000o035 != '\"' && O00000o035 != 26) {
                return false;
            } else {
                this.O0000OoO.set(11, 0);
                this.O0000OoO.set(12, 0);
                this.O0000OoO.set(13, 0);
                this.O0000OoO.set(14, 0);
                int i13 = this.O00000oO + 10;
                this.O00000oO = i13;
                this.O00000o = O00000o0(i13);
                this.f12888O000000o = 5;
                return true;
            }
        }
    }

    private void O000000o(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.O0000OoO = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        int i = (O0000o0O[c] * 1000) + (O0000o0O[c2] * 100) + (O0000o0O[c3] * 10) + O0000o0O[c4];
        int i2 = (O0000o0O[c7] * 10) + O0000o0O[c8];
        this.O0000OoO.set(1, i);
        this.O0000OoO.set(2, ((O0000o0O[c5] * 10) + O0000o0O[c6]) - 1);
        this.O0000OoO.set(5, i2);
    }

    public final boolean O0000Oo0() {
        return this.O00000oO == this.O0000oO.length() || (this.O00000o == 26 && this.O00000oO + 1 == this.O0000oO.length());
    }
}
