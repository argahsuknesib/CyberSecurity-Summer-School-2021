package com.xiaomi.zxing.datamatrix.decoder;

import _m_j.idn;
import _m_j.ido;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

public final class DecodedBitStreamParser {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f12112O000000o = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] O00000Oo = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] O00000o = O00000Oo;
    private static final char[] O00000o0 = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] O00000oO = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    public static ido O000000o(byte[] bArr) throws FormatException {
        idn idn = new idn(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            if (mode == Mode.ASCII_ENCODE) {
                mode = O000000o(idn, sb, sb2);
            } else {
                int i = AnonymousClass1.f12113O000000o[mode.ordinal()];
                if (i == 1) {
                    O000000o(idn, sb);
                } else if (i == 2) {
                    O00000Oo(idn, sb);
                } else if (i == 3) {
                    O00000o0(idn, sb);
                } else if (i == 4) {
                    O00000o(idn, sb);
                } else if (i == 5) {
                    O000000o(idn, sb, arrayList);
                } else {
                    throw FormatException.getFormatInstance();
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (idn.O000000o() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new ido(bArr, sb3, arrayList, null);
    }

    /* renamed from: com.xiaomi.zxing.datamatrix.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12113O000000o = new int[Mode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12113O000000o[Mode.C40_ENCODE.ordinal()] = 1;
            f12113O000000o[Mode.TEXT_ENCODE.ordinal()] = 2;
            f12113O000000o[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            f12113O000000o[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            f12113O000000o[Mode.BASE256_ENCODE.ordinal()] = 5;
        }
    }

    private static Mode O000000o(idn idn, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int O000000o2 = idn.O000000o(8);
            if (O000000o2 == 0) {
                throw FormatException.getFormatInstance();
            } else if (O000000o2 <= 128) {
                if (z) {
                    O000000o2 += NotificationCompat.FLAG_HIGH_PRIORITY;
                }
                sb.append((char) (O000000o2 - 1));
                return Mode.ASCII_ENCODE;
            } else if (O000000o2 == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (O000000o2 <= 229) {
                    int i = O000000o2 - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else if (O000000o2 == 230) {
                    return Mode.C40_ENCODE;
                } else {
                    if (O000000o2 == 231) {
                        return Mode.BASE256_ENCODE;
                    }
                    if (O000000o2 == 232) {
                        sb.append(29);
                    } else if (!(O000000o2 == 233 || O000000o2 == 234)) {
                        if (O000000o2 == 235) {
                            z = true;
                        } else if (O000000o2 == 236) {
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (O000000o2 == 237) {
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (O000000o2 == 238) {
                            return Mode.ANSIX12_ENCODE;
                        } else {
                            if (O000000o2 == 239) {
                                return Mode.TEXT_ENCODE;
                            }
                            if (O000000o2 == 240) {
                                return Mode.EDIFACT_ENCODE;
                            }
                            if (!(O000000o2 == 241 || O000000o2 < 242 || (O000000o2 == 254 && idn.O000000o() == 0))) {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    }
                }
            }
        } while (idn.O000000o() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void O000000o(idn idn, StringBuilder sb) throws FormatException {
        int O000000o2;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (idn.O000000o() != 8 && (O000000o2 = idn.O000000o(8)) != 254) {
            O000000o(O000000o2, idn.O000000o(8), iArr);
            boolean z2 = z;
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = O00000Oo;
                            if (i3 < cArr.length) {
                                char c = cArr[i3];
                                if (z2) {
                                    sb.append((char) (c + 128));
                                } else {
                                    sb.append(c);
                                }
                            } else if (i3 == 27) {
                                sb.append(29);
                            } else if (i3 == 30) {
                                z2 = true;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i = 0;
                        } else if (i != 3) {
                            throw FormatException.getFormatInstance();
                        } else if (z2) {
                            sb.append((char) (i3 + 224));
                        } else {
                            sb.append((char) (i3 + 96));
                            i = 0;
                        }
                    } else if (z2) {
                        sb.append((char) (i3 + NotificationCompat.FLAG_HIGH_PRIORITY));
                    } else {
                        sb.append((char) i3);
                        i = 0;
                    }
                    z2 = false;
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr2 = f12112O000000o;
                    if (i3 < cArr2.length) {
                        char c2 = cArr2[i3];
                        if (z2) {
                            sb.append((char) (c2 + 128));
                            z2 = false;
                        } else {
                            sb.append(c2);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (idn.O000000o() > 0) {
                z = z2;
            } else {
                return;
            }
        }
    }

    private static void O00000Oo(idn idn, StringBuilder sb) throws FormatException {
        int O000000o2;
        int[] iArr = new int[3];
        boolean z = false;
        int i = 0;
        while (idn.O000000o() != 8 && (O000000o2 = idn.O000000o(8)) != 254) {
            O000000o(O000000o2, idn.O000000o(8), iArr);
            boolean z2 = z;
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            char[] cArr = O00000o;
                            if (i3 < cArr.length) {
                                char c = cArr[i3];
                                if (z2) {
                                    sb.append((char) (c + 128));
                                } else {
                                    sb.append(c);
                                }
                            } else if (i3 == 27) {
                                sb.append(29);
                            } else if (i3 == 30) {
                                z2 = true;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i = 0;
                        } else if (i == 3) {
                            char[] cArr2 = O00000oO;
                            if (i3 < cArr2.length) {
                                char c2 = cArr2[i3];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                } else {
                                    sb.append(c2);
                                    i = 0;
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (z2) {
                        sb.append((char) (i3 + NotificationCompat.FLAG_HIGH_PRIORITY));
                    } else {
                        sb.append((char) i3);
                        i = 0;
                    }
                    z2 = false;
                    i = 0;
                } else if (i3 < 3) {
                    i = i3 + 1;
                } else {
                    char[] cArr3 = O00000o0;
                    if (i3 < cArr3.length) {
                        char c3 = cArr3[i3];
                        if (z2) {
                            sb.append((char) (c3 + 128));
                            z2 = false;
                        } else {
                            sb.append(c3);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (idn.O000000o() > 0) {
                z = z2;
            } else {
                return;
            }
        }
    }

    private static void O00000o0(idn idn, StringBuilder sb) throws FormatException {
        int O000000o2;
        int[] iArr = new int[3];
        while (idn.O000000o() != 8 && (O000000o2 = idn.O000000o(8)) != 254) {
            O000000o(O000000o2, idn.O000000o(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append(13);
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (idn.O000000o() <= 0) {
                return;
            }
        }
    }

    private static void O000000o(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    private static void O00000o(idn idn, StringBuilder sb) {
        while (idn.O000000o() > 16) {
            for (int i = 0; i < 4; i++) {
                int O000000o2 = idn.O000000o(6);
                if (O000000o2 == 31) {
                    int i2 = 8 - idn.O00000Oo;
                    if (i2 != 8) {
                        idn.O000000o(i2);
                        return;
                    }
                    return;
                }
                if ((O000000o2 & 32) == 0) {
                    O000000o2 |= 64;
                }
                sb.append((char) O000000o2);
            }
            if (idn.O000000o() <= 0) {
                return;
            }
        }
    }

    private static int O000000o(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }

    private static void O000000o(idn idn, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int i = idn.f1215O000000o + 1;
        int i2 = i + 1;
        int O000000o2 = O000000o(idn.O000000o(8), i);
        if (O000000o2 == 0) {
            O000000o2 = idn.O000000o() / 8;
        } else if (O000000o2 >= 250) {
            O000000o2 = ((O000000o2 - 249) * 250) + O000000o(idn.O000000o(8), i2);
            i2++;
        }
        if (O000000o2 >= 0) {
            byte[] bArr = new byte[O000000o2];
            int i3 = 0;
            while (i3 < O000000o2) {
                if (idn.O000000o() >= 8) {
                    bArr[i3] = (byte) O000000o(idn.O000000o(8), i2);
                    i3++;
                    i2++;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
