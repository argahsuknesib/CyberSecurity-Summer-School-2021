package org.apache.commons.codec.language;

import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class DoubleMetaphone implements StringEncoder {
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", "S", "N", "M", "B", "Z"};
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    protected int maxCodeLen = 4;

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (charAt(r8, r3) == 'V') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r1 = r1 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (charAt(r8, r3) == 'Q') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        if (charAt(r8, r3) == 'N') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        if (conditionM0(r8, r1) != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        if (charAt(r8, r3) == 'K') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        if (charAt(r8, r3) == 'F') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e3, code lost:
        if (charAt(r8, r3) == 'B') goto L_0x005b;
     */
    public String doubleMetaphone(String str, boolean z) {
        int i;
        String cleanInput = cleanInput(str);
        if (cleanInput == null) {
            return null;
        }
        boolean isSlavoGermanic = isSlavoGermanic(cleanInput);
        int isSilentStart = isSilentStart(cleanInput);
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(this, getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && isSilentStart <= cleanInput.length() - 1) {
            char charAt = cleanInput.charAt(isSilentStart);
            if (charAt == 199) {
                doubleMetaphoneResult.append('S');
            } else if (charAt != 209) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        isSilentStart = handleAEIOUY(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'B':
                        doubleMetaphoneResult.append('P');
                        i = isSilentStart + 1;
                        break;
                    case 'C':
                        isSilentStart = handleC(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'D':
                        isSilentStart = handleD(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'F':
                        doubleMetaphoneResult.append('F');
                        i = isSilentStart + 1;
                        break;
                    case 'G':
                        isSilentStart = handleG(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'H':
                        isSilentStart = handleH(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'J':
                        isSilentStart = handleJ(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'K':
                        doubleMetaphoneResult.append('K');
                        i = isSilentStart + 1;
                        break;
                    case 'L':
                        isSilentStart = handleL(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'M':
                        doubleMetaphoneResult.append('M');
                        break;
                    case 'N':
                        doubleMetaphoneResult.append('N');
                        i = isSilentStart + 1;
                        break;
                    case 'P':
                        isSilentStart = handleP(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'Q':
                        doubleMetaphoneResult.append('K');
                        i = isSilentStart + 1;
                        break;
                    case XiaomiOAuthConstants.VERSION_MINOR:
                        isSilentStart = handleR(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'S':
                        isSilentStart = handleS(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'T':
                        isSilentStart = handleT(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'V':
                        doubleMetaphoneResult.append('F');
                        i = isSilentStart + 1;
                        break;
                    case 'W':
                        isSilentStart = handleW(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'X':
                        isSilentStart = handleX(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'Z':
                        isSilentStart = handleZ(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N');
            }
            isSilentStart++;
        }
        return z ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return doubleMetaphone(str, z).equals(doubleMetaphone(str2, z));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    private int handleAEIOUY(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        String str2 = str;
        DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphoneResult;
        int i2 = i;
        if (conditionC0(str2, i2)) {
            doubleMetaphoneResult2.append('K');
        } else if (i2 == 0 && contains(str2, i2, 6, "CAESAR")) {
            doubleMetaphoneResult2.append('S');
        } else if (contains(str2, i2, 2, "CH")) {
            return handleCH(str, doubleMetaphoneResult, i);
        } else {
            if (!contains(str2, i2, 2, "CZ") || contains(str2, i2 - 2, 4, "WICZ")) {
                int i3 = i2 + 1;
                if (contains(str2, i3, 3, "CIA")) {
                    doubleMetaphoneResult2.append('X');
                } else if (contains(str2, i2, 2, "CC") && (i2 != 1 || charAt(str2, 0) != 'M')) {
                    return handleCC(str, doubleMetaphoneResult, i);
                } else {
                    if (contains(str, i, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult2.append('K');
                    } else if (!contains(str, i, 2, "CI", "CE", "CY")) {
                        doubleMetaphoneResult2.append('K');
                        if (!contains(str, i3, 2, " C", " Q", " G")) {
                            if (!contains(str, i3, 1, "C", "K", "Q") || contains(str2, i3, 2, "CE", "CI")) {
                                return i3;
                            }
                        }
                    } else if (contains(str, i, 3, "CIO", "CIE", "CIA")) {
                        doubleMetaphoneResult2.append('S', 'X');
                    } else {
                        doubleMetaphoneResult2.append('S');
                    }
                }
                return i2 + 3;
            }
            doubleMetaphoneResult2.append('S', 'X');
        }
        return i2 + 2;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (!contains(str, i2, 1, "I", "E", "H") || contains(str, i2, 2, "HU")) {
            doubleMetaphoneResult.append('K');
            return i2;
        }
        if (!(i == 1 && charAt(str, i - 1) == 'A') && !contains(str, i - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append('X');
        } else {
            doubleMetaphoneResult.append("KS");
        }
        return i + 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && contains(str, i, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else if (conditionCH0(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (conditionCH1(str, i)) {
            doubleMetaphoneResult.append('K');
        } else {
            if (i <= 0) {
                doubleMetaphoneResult.append('X');
            } else if (contains(str, 0, 2, "MC")) {
                doubleMetaphoneResult.append('K');
            } else {
                doubleMetaphoneResult.append('X', 'K');
            }
            return i + 2;
        }
        return i + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 2, "DG")) {
            int i2 = i + 2;
            if (contains(str, i2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.append('J');
                return i + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        } else if (contains(str, i, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T');
            return 2 + i;
        } else {
            doubleMetaphoneResult.append('T');
            return i + 1;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2;
        String str2 = str;
        DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphoneResult;
        int i3 = i;
        int i4 = i3 + 1;
        if (charAt(str2, i4) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i);
        }
        if (charAt(str2, i4) == 'N') {
            if (i3 == 1 && isVowel(charAt(str2, 0)) && !z) {
                doubleMetaphoneResult2.append("KN", "N");
            } else if (contains(str2, i3 + 2, 2, "EY") || charAt(str2, i4) == 'Y' || z) {
                doubleMetaphoneResult2.append("KN");
            } else {
                doubleMetaphoneResult2.append("N", "KN");
            }
        } else if (contains(str2, i4, 2, "LI") && !z) {
            doubleMetaphoneResult2.append("KL", "L");
        } else if (i3 != 0 || (charAt(str2, i4) != 'Y' && !contains(str2, i4, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            if (contains(str2, i4, 2, "ER") || charAt(str2, i4) == 'Y') {
                i2 = 3;
                if (!contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i5 = i3 - 1;
                    if (!contains(str2, i5, 1, "E", "I") && !contains(str2, i5, 3, "RGY", "OGY")) {
                        doubleMetaphoneResult2.append('K', 'J');
                    }
                }
            } else {
                i2 = 3;
            }
            if (contains(str, i4, 1, "E", "I", "Y") || contains(str2, i3 - 1, 4, "AGGI", "OGGI")) {
                if (contains(str2, 0, 4, "VAN ", "VON ") || contains(str2, 0, i2, "SCH") || contains(str2, i4, 2, "ET")) {
                    doubleMetaphoneResult2.append('K');
                } else if (contains(str2, i4, i2, "IER")) {
                    doubleMetaphoneResult2.append('J');
                } else {
                    doubleMetaphoneResult2.append('J', 'K');
                }
            } else if (charAt(str2, i4) == 'G') {
                int i6 = i3 + 2;
                doubleMetaphoneResult2.append('K');
                return i6;
            } else {
                doubleMetaphoneResult2.append('K');
                return i4;
            }
        } else {
            doubleMetaphoneResult2.append('K', 'J');
        }
        return i3 + 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        if (contains(r16, r11 - 2, 1, "B", "H", "D") == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        if (contains(r16, r11 - 3, 1, "B", "H", "D") == false) goto L_0x005c;
     */
    private int handleGH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        String str2 = str;
        DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphoneResult;
        int i2 = i;
        if (i2 > 0 && !isVowel(charAt(str2, i2 - 1))) {
            doubleMetaphoneResult2.append('K');
        } else if (i2 == 0) {
            int i3 = i2 + 2;
            if (charAt(str2, i3) == 'I') {
                doubleMetaphoneResult2.append('J');
                return i3;
            }
            doubleMetaphoneResult2.append('K');
            return i3;
        } else {
            if (i2 > 1) {
            }
            if (i2 > 2) {
            }
            if (i2 <= 3 || !contains(str2, i2 - 4, 1, "B", "H")) {
                if (i2 > 2 && charAt(str2, i2 - 1) == 'U') {
                    if (contains(str, i2 - 3, 1, "C", "G", "L", "R", "T")) {
                        doubleMetaphoneResult2.append('F');
                    }
                }
                if (i2 > 0 && charAt(str2, i2 - 1) != 'I') {
                    doubleMetaphoneResult2.append('K');
                }
            }
        }
        return i2 + 2;
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i != 0 && !isVowel(charAt(str, i - 1))) || !isVowel(charAt(str, i + 1))) {
            return i + 1;
        }
        doubleMetaphoneResult.append('H');
        return i + 2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleJ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i;
        if (contains(str, i2, 4, "JOSE") || contains(str, 0, 4, "SAN ")) {
            if ((i2 == 0 && charAt(str, i2 + 4) == ' ') || str.length() == 4 || contains(str, 0, 4, "SAN ")) {
                doubleMetaphoneResult.append('H');
            } else {
                doubleMetaphoneResult.append('J', 'H');
            }
            return i2 + 1;
        }
        if (i2 != 0 || contains(str, i2, 4, "JOSE")) {
            int i3 = i2 - 1;
            if (isVowel(charAt(str, i3)) && !z) {
                int i4 = i2 + 1;
                if (charAt(str, i4) == 'A' || charAt(str, i4) == 'O') {
                    doubleMetaphoneResult.append('J', 'H');
                }
            }
            if (i2 == str.length() - 1) {
                doubleMetaphoneResult.append('J', ' ');
            } else if (!contains(str, i2 + 1, 1, L_T_K_S_N_M_B_Z) && !contains(str, i3, 1, "S", "K", "L")) {
                doubleMetaphoneResult.append('J');
            }
        } else {
            doubleMetaphoneResult.append('J', 'A');
        }
        int i5 = i2 + 1;
        if (charAt(str, i5) == 'J') {
            return i2 + 2;
        }
        return i5;
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'L') {
            if (conditionL0(str, i)) {
                doubleMetaphoneResult.appendPrimary('L');
            } else {
                doubleMetaphoneResult.append('L');
            }
            return i + 2;
        }
        doubleMetaphoneResult.append('L');
        return i2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (i != str.length() - 1 || z || !contains(str, i - 2, 2, "IE") || contains(str, i - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append('R');
        } else {
            doubleMetaphoneResult.appendAlternate('R');
        }
        int i2 = i + 1;
        return charAt(str, i2) == 'R' ? i + 2 : i2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        if (contains(r16, r9 + 1, 1, "M", "N", "L", "W") == false) goto L_0x007d;
     */
    private int handleS(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        String str2 = str;
        DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphoneResult;
        int i2 = i;
        if (!contains(str2, i2 - 1, 3, "ISL", "YSL")) {
            if (i2 != 0 || !contains(str2, i2, 5, "SUGAR")) {
                if (contains(str2, i2, 2, "SH")) {
                    if (contains(str, i2 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        doubleMetaphoneResult2.append('S');
                    } else {
                        doubleMetaphoneResult2.append('X');
                    }
                } else if (contains(str2, i2, 3, "SIO", "SIA") || contains(str2, i2, 4, "SIAN")) {
                    if (z) {
                        doubleMetaphoneResult2.append('S');
                    } else {
                        doubleMetaphoneResult2.append('S', 'X');
                    }
                    return i2 + 3;
                } else {
                    if (i2 == 0) {
                    }
                    int i3 = i2 + 1;
                    if (!contains(str2, i3, 1, "Z")) {
                        if (contains(str2, i2, 2, "SC")) {
                            return handleSC(str, doubleMetaphoneResult, i);
                        }
                        if (i2 != str.length() - 1 || !contains(str2, i2 - 2, 2, "AI", "OI")) {
                            doubleMetaphoneResult2.append('S');
                        } else {
                            doubleMetaphoneResult2.appendAlternate('S');
                        }
                        if (!contains(str2, i3, 1, "S", "Z")) {
                            return i3;
                        }
                    }
                    doubleMetaphoneResult2.append('S', 'X');
                    int i4 = i2 + 1;
                    if (!contains(str2, i4, 1, "Z")) {
                        return i4;
                    }
                }
                return i2 + 2;
            }
            doubleMetaphoneResult2.append('X', 'S');
        }
        return i2 + 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        String str2 = str;
        DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphoneResult;
        int i2 = i + 2;
        if (charAt(str2, i2) == 'H') {
            int i3 = i + 3;
            if (contains(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str2, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult2.append("X", "SK");
                } else {
                    doubleMetaphoneResult2.append("SK");
                }
            } else if (i != 0 || isVowel(charAt(str2, 3)) || charAt(str2, 3) == 'W') {
                doubleMetaphoneResult2.append('X');
            } else {
                doubleMetaphoneResult2.append('X', 'S');
            }
        } else if (contains(str, i2, 1, "I", "E", "Y")) {
            doubleMetaphoneResult2.append('S');
        } else {
            doubleMetaphoneResult2.append("SK");
        }
        return i + 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 4, "TION")) {
            doubleMetaphoneResult.append('X');
        } else if (contains(str, i, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
        } else if (contains(str, i, 2, "TH") || contains(str, i, 3, "TTH")) {
            int i2 = i + 2;
            if (contains(str, i2, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.append('T');
                return i2;
            }
            doubleMetaphoneResult.append('0', 'T');
            return i2;
        } else {
            doubleMetaphoneResult.append('T');
            int i3 = i + 1;
            return contains(str, i3, 1, "T", "D") ? i + 2 : i3;
        }
        return i + 3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void
     arg types: [int, int]
     candidates:
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(java.lang.String, java.lang.String):void
      org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult.append(char, char):void */
    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = 2;
        if (contains(str, i, 2, "WR")) {
            doubleMetaphoneResult.append('R');
        } else {
            if (i == 0) {
                int i3 = i + 1;
                if (isVowel(charAt(str, i3)) || contains(str, i, 2, "WH")) {
                    if (isVowel(charAt(str, i3))) {
                        doubleMetaphoneResult.append('A', 'F');
                    } else {
                        doubleMetaphoneResult.append('A');
                    }
                    return i3;
                }
            }
            if (i != str.length() - 1 || !isVowel(charAt(str, i - 1))) {
                if (!contains(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !contains(str, 0, 3, "SCH")) {
                    i2 = 4;
                    if (contains(str, i, 4, "WICZ", "WITZ")) {
                        doubleMetaphoneResult.append("TS", "FX");
                    }
                    return i + 1;
                }
            }
            doubleMetaphoneResult.appendAlternate('F');
            return i + 1;
        }
        return i + i2;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('S');
            return i + 1;
        }
        if (i != str.length() - 1 || (!contains(str, i - 3, 3, "IAU", "EAU") && !contains(str, i - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i2 = i + 1;
        return contains(str, i2, 1, "C", "X") ? i + 2 : i2;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", "ZA") || (z && i > 0 && charAt(str, i - 1) != 'T')) {
            doubleMetaphoneResult.append("S", "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    private boolean conditionC0(String str, int i) {
        if (contains(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (isVowel(charAt(str, i2)) || !contains(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        return !(charAt == 'I' || charAt == 'E') || contains(str, i2, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        return (contains(str, i2, 5, "HARAC", "HARIS") || contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH")) {
            if (!contains(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
                int i2 = i + 2;
                if (!contains(str, i2, 1, "T", "S")) {
                    return (contains(str, i + -1, 1, "A", "O", "U", "E") || i == 0) && (contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) || i + 1 == str.length() - 1);
                }
            }
        }
    }

    private boolean conditionL0(String str, int i) {
        if (i == str.length() - 3) {
            if (contains(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
                return true;
            }
        }
        if ((contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, "A", "O")) && contains(str, i - 1, 4, "ALLE")) {
            return true;
        }
        return false;
    }

    private boolean conditionM0(String str, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        if (!contains(str, i - 1, 3, "UMB")) {
            return false;
        }
        if (i2 == str.length() - 1 || contains(str, i + 2, 2, "ER")) {
            return true;
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) >= 0 || str.indexOf(75) >= 0 || str.indexOf("CZ") >= 0 || str.indexOf("WITZ") >= 0;
    }

    private boolean isVowel(char c) {
        return "AEIOUY".indexOf(c) != -1;
    }

    private boolean isSilentStart(String str) {
        int i = 0;
        while (true) {
            String[] strArr = SILENT_START;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: protected */
    public char charAt(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    private static boolean contains(String str, int i, int i2, String str2) {
        return contains(str, i, i2, new String[]{str2});
    }

    private static boolean contains(String str, int i, int i2, String str2, String str3) {
        return contains(str, i, i2, new String[]{str2, str3});
    }

    private static boolean contains(String str, int i, int i2, String str2, String str3, String str4) {
        return contains(str, i, i2, new String[]{str2, str3, str4});
    }

    private static boolean contains(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        return contains(str, i, i2, new String[]{str2, str3, str4, str5});
    }

    private static boolean contains(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        return contains(str, i, i2, new String[]{str2, str3, str4, str5, str6});
    }

    private static boolean contains(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        return contains(str, i, i2, new String[]{str2, str3, str4, str5, str6, str7});
    }

    protected static boolean contains(String str, int i, int i2, String[] strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public class DoubleMetaphoneResult {
        private StringBuffer alternate = new StringBuffer(this.this$0.getMaxCodeLen());
        private int maxLength;
        private StringBuffer primary = new StringBuffer(this.this$0.getMaxCodeLen());
        private final DoubleMetaphone this$0;

        public DoubleMetaphoneResult(DoubleMetaphone doubleMetaphone, int i) {
            this.this$0 = doubleMetaphone;
            this.maxLength = i;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }
}
