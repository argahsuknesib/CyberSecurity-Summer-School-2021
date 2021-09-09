package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.common.CharacterSetECI;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xiaomi.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class igz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f1286O000000o = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0111 A[LOOP:0: B:1:0x001e->B:72:0x0111, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ef A[SYNTHETIC] */
    static ido O000000o(byte[] bArr, ihd ihd, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        String str;
        int i;
        int O000000o2;
        int i2;
        ihd ihd2 = ihd;
        idn idn = new idn(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i3 = 1;
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        int i4 = -1;
        int i5 = -1;
        while (true) {
            try {
                if (idn.O000000o() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(idn.O000000o(4));
                }
                Mode mode2 = forBits;
                if (mode2 != Mode.TERMINATOR) {
                    if (mode2 != Mode.FNC1_FIRST_POSITION) {
                        if (mode2 != Mode.FNC1_SECOND_POSITION) {
                            if (mode2 == Mode.STRUCTURED_APPEND) {
                                if (idn.O000000o() >= 16) {
                                    i4 = idn.O000000o(8);
                                    i5 = idn.O000000o(8);
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            } else if (mode2 == Mode.ECI) {
                                int O000000o3 = idn.O000000o(8);
                                if ((O000000o3 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                                    i = O000000o3 & 127;
                                } else {
                                    if ((O000000o3 & 192) == 128) {
                                        O000000o2 = idn.O000000o(8);
                                        i2 = (O000000o3 & 63) << 8;
                                    } else if ((O000000o3 & 224) == 192) {
                                        O000000o2 = idn.O000000o(16);
                                        i2 = (O000000o3 & 31) << 16;
                                    } else {
                                        throw FormatException.getFormatInstance();
                                    }
                                    i = i2 | O000000o2;
                                }
                                characterSetECI = CharacterSetECI.getCharacterSetECIByValue(i);
                                if (characterSetECI == null) {
                                    throw FormatException.getFormatInstance();
                                }
                            } else if (mode2 == Mode.HANZI) {
                                int O000000o4 = idn.O000000o(4);
                                int O000000o5 = idn.O000000o(mode2.getCharacterCountBits(ihd2));
                                if (O000000o4 == i3) {
                                    O000000o(idn, sb, O000000o5);
                                }
                            } else {
                                int O000000o6 = idn.O000000o(mode2.getCharacterCountBits(ihd2));
                                if (mode2 == Mode.NUMERIC) {
                                    O00000o0(idn, sb, O000000o6);
                                } else if (mode2 == Mode.ALPHANUMERIC) {
                                    O000000o(idn, sb, O000000o6, z);
                                } else {
                                    if (mode2 == Mode.BYTE) {
                                        mode = mode2;
                                        O000000o(idn, sb, O000000o6, characterSetECI, arrayList, map);
                                    } else {
                                        mode = mode2;
                                        if (mode == Mode.KANJI) {
                                            O00000Oo(idn, sb, O000000o6);
                                        } else {
                                            throw FormatException.getFormatInstance();
                                        }
                                    }
                                    if (mode == Mode.TERMINATOR) {
                                        String sb2 = sb.toString();
                                        ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
                                        if (errorCorrectionLevel == null) {
                                            str = null;
                                        } else {
                                            str = errorCorrectionLevel.toString();
                                        }
                                        return new ido(bArr, sb2, arrayList2, str, i4, i5);
                                    }
                                    i3 = 1;
                                }
                            }
                        }
                    }
                    mode = mode2;
                    z = true;
                    if (mode == Mode.TERMINATOR) {
                    }
                }
                mode = mode2;
                if (mode == Mode.TERMINATOR) {
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void O000000o(idn idn, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= idn.O000000o()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int O000000o2 = idn.O000000o(13);
                int i3 = (O000000o2 % 96) | ((O000000o2 / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) ((i4 >> 8) & 255);
                bArr[i2 + 1] = (byte) (i4 & 255);
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void O00000Oo(idn idn, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= idn.O000000o()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int O000000o2 = idn.O000000o(13);
                int i3 = (O000000o2 % 192) | ((O000000o2 / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void O000000o(idn idn, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String str;
        if (i * 8 <= idn.O000000o()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) idn.O000000o(8);
            }
            if (characterSetECI == null) {
                str = idv.O000000o(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static char O000000o(int i) throws FormatException {
        char[] cArr = f1286O000000o;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }

    private static void O000000o(idn idn, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (idn.O000000o() >= 11) {
                int O000000o2 = idn.O000000o(11);
                sb.append(O000000o(O000000o2 / 45));
                sb.append(O000000o(O000000o2 % 45));
                i -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 1) {
            if (idn.O000000o() >= 6) {
                sb.append(O000000o(idn.O000000o(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void O00000o0(idn idn, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (idn.O000000o() >= 10) {
                int O000000o2 = idn.O000000o(10);
                if (O000000o2 < 1000) {
                    sb.append(O000000o(O000000o2 / 100));
                    sb.append(O000000o((O000000o2 / 10) % 10));
                    sb.append(O000000o(O000000o2 % 10));
                    i -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 2) {
            if (idn.O000000o() >= 7) {
                int O000000o3 = idn.O000000o(7);
                if (O000000o3 < 100) {
                    sb.append(O000000o(O000000o3 / 10));
                    sb.append(O000000o(O000000o3 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i != 1) {
        } else {
            if (idn.O000000o() >= 4) {
                int O000000o4 = idn.O000000o(4);
                if (O000000o4 < 10) {
                    sb.append(O000000o(O000000o4));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }
}
