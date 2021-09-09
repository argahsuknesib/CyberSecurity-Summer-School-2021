package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.loc.ee;
import java.util.ArrayList;
import java.util.zip.CRC32;

@SuppressLint({"NewApi"})
public final class bvx {
    protected static String O000OO;
    protected static String O000OO00;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13324O000000o = "1";
    protected short O00000Oo = 0;
    protected String O00000o = null;
    protected String O00000o0 = null;
    protected String O00000oO = null;
    protected String O00000oo = null;
    protected String O0000O0o = null;
    public String O0000OOo = null;
    protected String O0000Oo = null;
    public String O0000Oo0 = null;
    protected String O0000OoO = null;
    protected String O0000Ooo = null;
    protected String O0000o = null;
    protected String O0000o0 = null;
    protected String O0000o00 = null;
    protected String O0000o0O = null;
    protected String O0000o0o = null;
    protected String O0000oO = null;
    protected String O0000oO0 = null;
    protected String O0000oOO = null;
    protected String O0000oOo = null;
    protected String O0000oo = null;
    protected String O0000oo0 = null;
    protected String O0000ooO = null;
    protected String O0000ooo = null;
    protected String O000O00o = null;
    protected ArrayList<bvm> O000O0OO = new ArrayList<>();
    protected String O000O0Oo = null;
    protected String O000O0o = null;
    protected ArrayList<ScanResult> O000O0o0 = new ArrayList<>();
    protected String O000O0oO = null;
    protected byte[] O000O0oo = null;
    protected String O000OO0o = null;
    protected String O000OOOo = null;
    private byte[] O000OOo = null;
    protected String O000OOo0 = null;
    private int O000OOoO = 0;
    protected String O00oOoOo = null;
    protected int O00oOooO = 0;
    protected String O00oOooo = null;

    private static int O000000o(String str, byte[] bArr, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i] = 0;
                return i + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i] = (byte) length;
            int i2 = i + 1;
            System.arraycopy(bytes, 0, bArr, i2, length);
            return i2 + length;
        } catch (Throwable th) {
            bvz.O000000o(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
    }

    private String O000000o(String str, int i) {
        String[] split = this.O000O00o.split("\\*")[i].split(",");
        if ("lac".equals(str)) {
            return split[0];
        }
        if ("cellid".equals(str)) {
            return split[1];
        }
        if ("signal".equals(str)) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r0.length != 6) goto L_0x000f;
     */
    private byte[] O000000o(String str) {
        String[] split = str.split(":");
        byte[] bArr = new byte[6];
        if (split != null) {
            try {
            } catch (Throwable th) {
                bvz.O000000o(th, "Req", "getMacBa ".concat(String.valueOf(str)));
                return O000000o("00:00:00:00:00:00");
            }
        }
        split = new String[6];
        for (int i = 0; i < 6; i++) {
            split[i] = "0";
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].length() > 2) {
                split[i2] = split[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(split[i2], 16);
        }
        return bArr;
    }

    private String O00000Oo(String str) {
        String str2 = this.O00oOooo;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.O00oOooo;
        int indexOf = str3.indexOf(str + ">");
        return this.O00oOooo.substring(indexOf + str.length() + 1, this.O00oOooo.indexOf("</".concat(String.valueOf(str))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04a6  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x056b  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0627 A[Catch:{ Throwable -> 0x063c }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x062a A[Catch:{ Throwable -> 0x063c }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x062e A[Catch:{ Throwable -> 0x063c }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x064e A[Catch:{ Throwable -> 0x066e }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0660 A[SYNTHETIC, Splitter:B:302:0x0660] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x068e  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x069d  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x06b7  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06c3  */
    public final byte[] O000000o() {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        byte b;
        int i6;
        byte b2;
        int min;
        byte b3;
        int i7;
        int i8;
        int i9;
        byte[] bArr;
        int i10;
        int i11;
        byte[] bArr2;
        int i12;
        byte[] bArr3;
        int i13;
        boolean isEmpty;
        byte[] bytes;
        int i14;
        int i15;
        String[] split;
        int i16;
        int i17;
        int i18;
        int i19;
        int parseInt;
        int length;
        int length2;
        if (TextUtils.isEmpty(this.f13324O000000o)) {
            this.f13324O000000o = "";
        }
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o0 = "";
        }
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O00000o = "";
        }
        if (TextUtils.isEmpty(this.O00000oO)) {
            this.O00000oO = "";
        }
        if (TextUtils.isEmpty(this.O00000oo)) {
            this.O00000oo = "";
        }
        if (TextUtils.isEmpty(this.O0000O0o)) {
            this.O0000O0o = "";
        }
        if (TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000OOo = "";
        }
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            this.O0000Oo0 = "";
        }
        if (TextUtils.isEmpty(this.O0000Oo) || (!"0".equals(this.O0000Oo) && !"2".equals(this.O0000Oo))) {
            this.O0000Oo = "0";
        }
        if (TextUtils.isEmpty(this.O0000OoO) || (!"0".equals(this.O0000OoO) && !"1".equals(this.O0000OoO))) {
            this.O0000OoO = "0";
        }
        if (TextUtils.isEmpty(this.O0000Ooo)) {
            this.O0000Ooo = "";
        }
        if (TextUtils.isEmpty(this.O0000o00)) {
            this.O0000o00 = "";
        }
        if (TextUtils.isEmpty(this.O0000o0)) {
            this.O0000o0 = "";
        }
        if (TextUtils.isEmpty(this.O0000o0O)) {
            this.O0000o0O = "";
        }
        if (TextUtils.isEmpty(this.O0000o0o)) {
            this.O0000o0o = "";
        }
        if (TextUtils.isEmpty(this.O0000o)) {
            this.O0000o = "";
        }
        if (TextUtils.isEmpty(this.O0000oO0)) {
            this.O0000oO0 = "";
        }
        if (TextUtils.isEmpty(this.O0000oO)) {
            this.O0000oO = "";
        }
        if (TextUtils.isEmpty(this.O0000oOO)) {
            this.O0000oOO = "";
        }
        if (TextUtils.isEmpty(this.O0000oOo)) {
            this.O0000oOo = "";
        }
        if (TextUtils.isEmpty(this.O0000oo0)) {
            this.O0000oo0 = "";
        }
        if (TextUtils.isEmpty(this.O0000oo)) {
            this.O0000oo = "";
        }
        if (TextUtils.isEmpty(this.O0000ooO)) {
            this.O0000ooO = "";
        }
        if (TextUtils.isEmpty(this.O0000ooo) || (!"1".equals(this.O0000ooo) && !"2".equals(this.O0000ooo))) {
            this.O0000ooo = "0";
        }
        int i20 = this.O00oOooO;
        if (!(i20 > 0 && i20 <= 15)) {
            this.O00oOooO = 0;
        }
        if (TextUtils.isEmpty(this.O00oOooo)) {
            this.O00oOooo = "";
        }
        if (TextUtils.isEmpty(this.O000O00o)) {
            this.O000O00o = "";
        }
        if (TextUtils.isEmpty(this.O00oOoOo)) {
            this.O00oOoOo = "";
        }
        if (TextUtils.isEmpty(this.O000O0o)) {
            this.O000O0o = "";
        }
        if (TextUtils.isEmpty(this.O000O0oO)) {
            this.O000O0oO = "";
        }
        if (TextUtils.isEmpty(O000OO00)) {
            O000OO00 = "";
        }
        if (this.O000O0oo == null) {
            this.O000O0oo = new byte[0];
        }
        if (TextUtils.isEmpty(this.O000OOo0)) {
            this.O000OOo0 = "";
        }
        int i21 = 2;
        byte[] bArr4 = new byte[2];
        byte[] bArr5 = new byte[4];
        int i22 = 4096;
        byte[] bArr6 = this.O000O0oo;
        if (bArr6 != null) {
            i22 = bArr6.length + 1 + 4096;
        }
        byte[] bArr7 = this.O000OOo;
        if (bArr7 == null || i22 > this.O000OOoO) {
            bArr7 = new byte[i22];
            this.O000OOo = bArr7;
            this.O000OOoO = i22;
        }
        bArr7[0] = bwi.O0000Oo0(this.f13324O000000o);
        byte[] O000000o2 = bwi.O000000o(this.O00000Oo, (byte[]) null);
        System.arraycopy(O000000o2, 0, bArr7, 1, O000000o2.length);
        int O000000o3 = O000000o(this.O0000o, bArr7, O000000o(this.O0000o0o, bArr7, O000000o(this.O0000OOo, bArr7, O000000o(this.O0000oOo, bArr7, O000000o(this.O0000O0o, bArr7, O000000o(this.O00000oo, bArr7, O000000o(this.O00000oO, bArr7, O000000o(this.O0000o0O, bArr7, O000000o(this.O00000o, bArr7, O000000o(this.O00000o0, bArr7, O000000o2.length + 1))))))))));
        try {
            if (TextUtils.isEmpty(this.O0000oOO)) {
                bArr7[O000000o3] = 0;
                i = O000000o3 + 1;
                int O000000o4 = O000000o(this.O0000ooO, bArr7, O000000o(O000OO, bArr7, O000000o(O000OO00, bArr7, O000000o(this.O0000oo, bArr7, O000000o(this.O0000oo0, bArr7, i)))));
                bArr7[O000000o4] = Byte.parseByte(this.O0000ooo);
                int i23 = O000000o4 + 1;
                bArr7[i23] = Byte.parseByte(this.O0000Oo);
                int i24 = i23 + 1;
                int i25 = this.O00oOooO;
                i2 = i25 & 3;
                bArr7[i24] = (byte) i25;
                i3 = i24 + 1;
                if (i2 == 1 || i2 == 2) {
                    byte[] O00000Oo2 = bwi.O00000Oo(O00000Oo("mcc"));
                    System.arraycopy(O00000Oo2, 0, bArr7, i3, O00000Oo2.length);
                    int length3 = i3 + O00000Oo2.length;
                    if (i2 != 1) {
                        byte[] O00000Oo3 = bwi.O00000Oo(O00000Oo("mnc"));
                        System.arraycopy(O00000Oo3, 0, bArr7, length3, O00000Oo3.length);
                        int length4 = length3 + O00000Oo3.length;
                        byte[] O00000Oo4 = bwi.O00000Oo(O00000Oo("lac"));
                        System.arraycopy(O00000Oo4, 0, bArr7, length4, O00000Oo4.length);
                        length = length4 + O00000Oo4.length;
                        byte[] O00000o02 = bwi.O00000o0(O00000Oo("cellid"));
                        System.arraycopy(O00000o02, 0, bArr7, length, O00000o02.length);
                        length2 = O00000o02.length;
                    } else {
                        if (i2 == 2) {
                            byte[] O00000Oo5 = bwi.O00000Oo(O00000Oo("sid"));
                            System.arraycopy(O00000Oo5, 0, bArr7, length3, O00000Oo5.length);
                            int length5 = length3 + O00000Oo5.length;
                            byte[] O00000Oo6 = bwi.O00000Oo(O00000Oo("nid"));
                            System.arraycopy(O00000Oo6, 0, bArr7, length5, O00000Oo6.length);
                            int length6 = length5 + O00000Oo6.length;
                            byte[] O00000Oo7 = bwi.O00000Oo(O00000Oo("bid"));
                            System.arraycopy(O00000Oo7, 0, bArr7, length6, O00000Oo7.length);
                            int length7 = length6 + O00000Oo7.length;
                            byte[] O00000o03 = bwi.O00000o0(O00000Oo("lon"));
                            System.arraycopy(O00000o03, 0, bArr7, length7, O00000o03.length);
                            length = length7 + O00000o03.length;
                            byte[] O00000o04 = bwi.O00000o0(O00000Oo("lat"));
                            System.arraycopy(O00000o04, 0, bArr7, length, O00000o04.length);
                            length2 = O00000o04.length;
                        }
                        parseInt = Integer.parseInt(O00000Oo("signal"));
                        if (parseInt > 127 || parseInt < -128) {
                            parseInt = 0;
                        }
                        bArr7[length3] = (byte) parseInt;
                        int i26 = length3 + 1;
                        byte[] O000000o5 = bwi.O000000o(0, bArr4);
                        System.arraycopy(O000000o5, 0, bArr7, i26, O000000o5.length);
                        i3 = i26 + 2;
                        if (i2 == 1) {
                            if (TextUtils.isEmpty(this.O000O00o)) {
                                bArr7[i3] = 0;
                            } else {
                                int length8 = this.O000O00o.split("\\*").length;
                                bArr7[i3] = (byte) length8;
                                int i27 = i3 + 1;
                                for (int i28 = 0; i28 < length8; i28++) {
                                    byte[] O00000Oo8 = bwi.O00000Oo(O000000o("lac", i28));
                                    System.arraycopy(O00000Oo8, 0, bArr7, i27, O00000Oo8.length);
                                    int length9 = i27 + O00000Oo8.length;
                                    byte[] O00000o05 = bwi.O00000o0(O000000o("cellid", i28));
                                    System.arraycopy(O00000o05, 0, bArr7, length9, O00000o05.length);
                                    int length10 = length9 + O00000o05.length;
                                    int parseInt2 = Integer.parseInt(O000000o("signal", i28));
                                    if (parseInt2 > 127 || parseInt2 < -128) {
                                        parseInt2 = 0;
                                    }
                                    bArr7[length10] = (byte) parseInt2;
                                    i27 = length10 + 1;
                                }
                                i3 = i27;
                            }
                        } else if (i2 == 2) {
                            bArr7[i3] = 0;
                        }
                        i3++;
                    }
                    length3 = length + length2;
                    parseInt = Integer.parseInt(O00000Oo("signal"));
                    parseInt = 0;
                    bArr7[length3] = (byte) parseInt;
                    int i262 = length3 + 1;
                    byte[] O000000o52 = bwi.O000000o(0, bArr4);
                    System.arraycopy(O000000o52, 0, bArr7, i262, O000000o52.length);
                    i3 = i262 + 2;
                    if (i2 == 1) {
                    }
                    i3++;
                }
                str = this.O000O0Oo;
                if (str != null && (this.O00oOooO & 8) == 8) {
                    try {
                        byte[] bytes2 = str.getBytes("GBK");
                        int min2 = Math.min(bytes2.length, 60);
                        bArr7[i3] = (byte) min2;
                        i3++;
                        System.arraycopy(bytes2, 0, bArr7, i3, min2);
                        i4 = i3 + min2;
                    } catch (Exception unused) {
                    }
                    ArrayList<bvm> arrayList = this.O000O0OO;
                    int size = arrayList.size();
                    if ((this.O00oOooO & 4) == 4 || size <= 0) {
                        b = 0;
                        bArr7[i4] = 0;
                        i5 = i4 + 1;
                    } else {
                        if (!arrayList.get(0).O0000o0o) {
                            size--;
                        }
                        bArr7[i4] = (byte) size;
                        i5 = i4 + 1;
                        int i29 = 0;
                        while (i29 < size) {
                            bvm bvm = arrayList.get(i29);
                            if (bvm.O0000o0o) {
                                if (bvm.O0000OoO == 1 || bvm.O0000OoO == 3 || bvm.O0000OoO == 4) {
                                    byte b4 = (byte) bvm.O0000OoO;
                                    if (bvm.O0000o0) {
                                        b4 = (byte) (b4 | 8);
                                    }
                                    bArr7[i5] = b4;
                                    int i30 = i5 + 1;
                                    byte[] O000000o6 = bwi.O000000o(bvm.f13313O000000o, bArr4);
                                    System.arraycopy(O000000o6, 0, bArr7, i30, O000000o6.length);
                                    int length11 = i30 + O000000o6.length;
                                    byte[] O000000o7 = bwi.O000000o(bvm.O00000Oo, bArr4);
                                    System.arraycopy(O000000o7, 0, bArr7, length11, O000000o7.length);
                                    int length12 = length11 + O000000o7.length;
                                    byte[] O000000o8 = bwi.O000000o(bvm.O00000o0, bArr4);
                                    System.arraycopy(O000000o8, 0, bArr7, length12, O000000o8.length);
                                    i18 = length12 + O000000o8.length;
                                    byte[] O00000Oo9 = bwi.O00000Oo(bvm.O00000o, bArr5);
                                    System.arraycopy(O00000Oo9, 0, bArr7, i18, O00000Oo9.length);
                                    i19 = O00000Oo9.length;
                                } else {
                                    if (bvm.O0000OoO == i21) {
                                        byte b5 = (byte) bvm.O0000OoO;
                                        if (bvm.O0000o0) {
                                            b5 = (byte) (b5 | 8);
                                        }
                                        bArr7[i5] = b5;
                                        int i31 = i5 + 1;
                                        byte[] O000000o9 = bwi.O000000o(bvm.f13313O000000o, bArr4);
                                        System.arraycopy(O000000o9, 0, bArr7, i31, O000000o9.length);
                                        int length13 = i31 + O000000o9.length;
                                        byte[] O000000o10 = bwi.O000000o(bvm.O0000O0o, bArr4);
                                        System.arraycopy(O000000o10, 0, bArr7, length13, O000000o10.length);
                                        int length14 = length13 + O000000o10.length;
                                        byte[] O000000o11 = bwi.O000000o(bvm.O0000OOo, bArr4);
                                        System.arraycopy(O000000o11, 0, bArr7, length14, O000000o11.length);
                                        int length15 = length14 + O000000o11.length;
                                        byte[] O000000o12 = bwi.O000000o(bvm.O0000Oo0, bArr4);
                                        System.arraycopy(O000000o12, 0, bArr7, length15, O000000o12.length);
                                        int length16 = length15 + O000000o12.length;
                                        byte[] O00000Oo10 = bwi.O00000Oo(bvm.O00000oo, bArr5);
                                        System.arraycopy(O00000Oo10, 0, bArr7, length16, O00000Oo10.length);
                                        i18 = length16 + O00000Oo10.length;
                                        byte[] O00000Oo11 = bwi.O00000Oo(bvm.O00000oO, bArr5);
                                        System.arraycopy(O00000Oo11, 0, bArr7, i18, O00000Oo11.length);
                                        i19 = O00000Oo11.length;
                                    }
                                    i17 = bvm.O0000Oo;
                                    if (i17 > 127 || i17 < -128) {
                                        i17 = 99;
                                    }
                                    bArr7[i5] = (byte) i17;
                                    int i32 = i5 + 1;
                                    byte[] O000000o13 = bwi.O000000o(bvm.O0000Ooo, bArr4);
                                    System.arraycopy(O000000o13, 0, bArr7, i32, O000000o13.length);
                                    i5 = i32 + O000000o13.length;
                                    if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                                        if (bvm.O0000OoO != 3) {
                                            if (bvm.O0000OoO != 4) {
                                                i29++;
                                                i21 = 2;
                                            }
                                        }
                                        int i33 = bvm.O0000o0O;
                                        if (i33 > 32767) {
                                            i33 = 32767;
                                        }
                                        if (i33 < 0) {
                                            i33 = 32767;
                                        }
                                        byte[] O000000o14 = bwi.O000000o(i33, bArr4);
                                        System.arraycopy(O000000o14, 0, bArr7, i5, O000000o14.length);
                                        i5 += O000000o14.length;
                                        i29++;
                                        i21 = 2;
                                    }
                                }
                                i5 = i18 + i19;
                                i17 = bvm.O0000Oo;
                                i17 = 99;
                                bArr7[i5] = (byte) i17;
                                int i322 = i5 + 1;
                                byte[] O000000o132 = bwi.O000000o(bvm.O0000Ooo, bArr4);
                                System.arraycopy(O000000o132, 0, bArr7, i322, O000000o132.length);
                                i5 = i322 + O000000o132.length;
                                if (Double.valueOf("5.1").doubleValue() >= 5.0d) {
                                }
                            }
                            i29++;
                            i21 = 2;
                        }
                        b = 0;
                    }
                    if (this.O00oOoOo.length() == 0) {
                        bArr7[i5] = b;
                    } else {
                        bArr7[i5] = 1;
                        int i34 = i5 + 1;
                        try {
                            split = this.O00oOoOo.split(",");
                            byte[] O000000o15 = O000000o(split[0]);
                            System.arraycopy(O000000o15, 0, bArr7, i34, O000000o15.length);
                            i34 += O000000o15.length;
                            byte[] bytes3 = split[2].getBytes("GBK");
                            int length17 = bytes3.length;
                            if (length17 > 127) {
                                length17 = 127;
                            }
                            bArr7[i34] = (byte) length17;
                            int i35 = i34 + 1;
                            System.arraycopy(bytes3, 0, bArr7, i35, length17);
                            i16 = i35 + length17;
                        } catch (Throwable th) {
                            bvz.O000000o(th, "Req", "buildV4Dot216");
                            byte[] O000000o16 = O000000o("00:00:00:00:00:00");
                            b2 = 0;
                            System.arraycopy(O000000o16, 0, bArr7, i34, O000000o16.length);
                            int length18 = i34 + O000000o16.length;
                            bArr7[length18] = 0;
                            int i36 = length18 + 1;
                            bArr7[i36] = Byte.parseByte("0");
                            i6 = i36 + 1;
                        }
                        int parseInt3 = Integer.parseInt(split[1]);
                        if (parseInt3 <= 127) {
                            if (parseInt3 < -128) {
                            }
                            bArr7[i5] = Byte.parseByte(String.valueOf(parseInt3));
                        }
                        parseInt3 = 0;
                        bArr7[i5] = Byte.parseByte(String.valueOf(parseInt3));
                    }
                    i6 = i5 + 1;
                    b2 = 0;
                    ArrayList<ScanResult> arrayList2 = this.O000O0o0;
                    min = Math.min(arrayList2.size(), 25);
                    if (min == 0) {
                        bArr7[i6] = b2;
                        i7 = i6 + 1;
                        b3 = 0;
                    } else {
                        bArr7[i6] = (byte) min;
                        int i37 = i6 + 1;
                        boolean z = bwi.O00000o() >= 17;
                        long j = 0;
                        if (z) {
                            j = bwi.O00000o0() / 1000;
                        }
                        for (int i38 = 0; i38 < min; i38++) {
                            ScanResult scanResult = arrayList2.get(i38);
                            byte[] O000000o17 = O000000o(scanResult.BSSID);
                            System.arraycopy(O000000o17, 0, bArr7, i37, O000000o17.length);
                            int length19 = i37 + O000000o17.length;
                            try {
                                byte[] bytes4 = scanResult.SSID.getBytes("GBK");
                                bArr7[length19] = (byte) bytes4.length;
                                length19++;
                                System.arraycopy(bytes4, 0, bArr7, length19, bytes4.length);
                                i14 = length19 + bytes4.length;
                            } catch (Exception unused2) {
                                bArr7[length19] = 0;
                                i14 = length19 + 1;
                            }
                            int i39 = scanResult.level;
                            if (i39 > 127) {
                                i39 = 0;
                            } else if (i39 < -128) {
                                i39 = 0;
                            }
                            bArr7[i14] = Byte.parseByte(String.valueOf(i39));
                            int i40 = i14 + 1;
                            if (!z || (i15 = (int) (j - ((scanResult.timestamp / 1000000) + 1))) < 0) {
                                i15 = 0;
                            }
                            if (i15 > 65535) {
                                i15 = 65535;
                            }
                            byte[] O000000o18 = bwi.O000000o(i15, bArr4);
                            System.arraycopy(O000000o18, 0, bArr7, i40, O000000o18.length);
                            int length20 = i40 + O000000o18.length;
                            byte[] O000000o19 = bwi.O000000o(scanResult.frequency, bArr4);
                            System.arraycopy(O000000o19, 0, bArr7, length20, O000000o19.length);
                            i37 = length20 + O000000o19.length;
                        }
                        b3 = 0;
                        byte[] O000000o20 = bwi.O000000o(Integer.parseInt(this.O000O0o), bArr4);
                        System.arraycopy(O000000o20, 0, bArr7, i37, O000000o20.length);
                        i7 = i37 + O000000o20.length;
                    }
                    bArr7[i7] = b3;
                    i8 = i7 + 1;
                    bytes = this.O000O0oO.getBytes("GBK");
                    if (bytes.length > 127) {
                        bytes = null;
                    }
                    if (bytes == null) {
                        bArr7[i8] = 0;
                        i9 = i8 + 1;
                        bArr = new byte[]{0, 0};
                        try {
                            isEmpty = TextUtils.isEmpty(this.O000OO0o);
                            if (!isEmpty) {
                                bArr = bwi.O000000o(this.O000OO0o.length(), bArr4);
                            }
                            System.arraycopy(bArr, 0, bArr7, i9, 2);
                            i10 = i9 + 2;
                            if (!isEmpty) {
                                try {
                                    byte[] bytes5 = this.O000OO0o.getBytes("GBK");
                                    System.arraycopy(bytes5, 0, bArr7, i10, bytes5.length);
                                    i10 += bytes5.length;
                                } catch (Throwable unused3) {
                                }
                            }
                            i11 = 2;
                        } catch (Throwable unused4) {
                            i11 = 2;
                            i10 = i9 + 2;
                        }
                        // fill-array-data instruction
                        new byte[i11][0] = 0;
                        new byte[i11][1] = 0;
                        try {
                            System.arraycopy(bwi.O000000o(0, bArr4), 0, bArr7, i10, i11);
                        } catch (Throwable unused5) {
                        }
                        int i41 = i10 + i11;
                        byte[] bArr8 = new byte[i11];
                        // fill-array-data instruction
                        bArr8[0] = 0;
                        bArr8[1] = 0;
                        try {
                            System.arraycopy(bArr8, 0, bArr7, i41, i11);
                        } catch (Throwable unused6) {
                        }
                        int i42 = i41 + i11;
                        bArr2 = this.O000O0oo;
                        if (bArr2 == null) {
                            i12 = bArr2.length;
                            bArr3 = null;
                        } else {
                            bArr3 = null;
                            i12 = 0;
                        }
                        byte[] O000000o21 = bwi.O000000o(i12, bArr3);
                        System.arraycopy(O000000o21, 0, bArr7, i42, O000000o21.length);
                        int length21 = i42 + O000000o21.length;
                        if (i12 > 0) {
                            byte[] bArr9 = this.O000O0oo;
                            System.arraycopy(bArr9, 0, bArr7, length21, bArr9.length);
                            length21 += this.O000O0oo.length;
                        }
                        if (Double.valueOf("5.1").doubleValue() < 5.0d) {
                            i13 = 0;
                            bArr7[length21] = 0;
                            length21 = O000000o(this.O000OOo0, bArr7, length21 + 1);
                        } else {
                            i13 = 0;
                        }
                        byte[] bArr10 = new byte[length21];
                        System.arraycopy(bArr7, i13, bArr10, i13, length21);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr10);
                        byte[] O000000o22 = bwi.O000000o(crc32.getValue());
                        byte[] bArr11 = new byte[(length21 + 8)];
                        System.arraycopy(bArr10, i13, bArr11, i13, length21);
                        System.arraycopy(O000000o22, i13, bArr11, length21, 8);
                        return bArr11;
                    }
                    bArr7[i8] = (byte) bytes.length;
                    int i43 = i8 + 1;
                    System.arraycopy(bytes, 0, bArr7, i43, bytes.length);
                    i9 = i43 + bytes.length;
                    bArr = new byte[]{0, 0};
                    isEmpty = TextUtils.isEmpty(this.O000OO0o);
                    if (!isEmpty) {
                    }
                    System.arraycopy(bArr, 0, bArr7, i9, 2);
                    i10 = i9 + 2;
                    if (!isEmpty) {
                    }
                    i11 = 2;
                    // fill-array-data instruction
                    new byte[i11][0] = 0;
                    new byte[i11][1] = 0;
                    System.arraycopy(bwi.O000000o(0, bArr4), 0, bArr7, i10, i11);
                    int i412 = i10 + i11;
                    byte[] bArr82 = new byte[i11];
                    // fill-array-data instruction
                    bArr82[0] = 0;
                    bArr82[1] = 0;
                    System.arraycopy(bArr82, 0, bArr7, i412, i11);
                    int i422 = i412 + i11;
                    bArr2 = this.O000O0oo;
                    if (bArr2 == null) {
                    }
                    byte[] O000000o212 = bwi.O000000o(i12, bArr3);
                    System.arraycopy(O000000o212, 0, bArr7, i422, O000000o212.length);
                    int length212 = i422 + O000000o212.length;
                    if (i12 > 0) {
                    }
                    if (Double.valueOf("5.1").doubleValue() < 5.0d) {
                    }
                    byte[] bArr102 = new byte[length212];
                    System.arraycopy(bArr7, i13, bArr102, i13, length212);
                    CRC32 crc322 = new CRC32();
                    crc322.update(bArr102);
                    byte[] O000000o222 = bwi.O000000o(crc322.getValue());
                    byte[] bArr112 = new byte[(length212 + 8)];
                    System.arraycopy(bArr102, i13, bArr112, i13, length212);
                    System.arraycopy(O000000o222, i13, bArr112, length212, 8);
                    return bArr112;
                }
                bArr7[i3] = 0;
                i4 = i3 + 1;
                ArrayList<bvm> arrayList3 = this.O000O0OO;
                int size2 = arrayList3.size();
                if ((this.O00oOooO & 4) == 4) {
                }
                b = 0;
                bArr7[i4] = 0;
                i5 = i4 + 1;
                if (this.O00oOoOo.length() == 0) {
                }
                i6 = i5 + 1;
                b2 = 0;
                ArrayList<ScanResult> arrayList22 = this.O000O0o0;
                min = Math.min(arrayList22.size(), 25);
                if (min == 0) {
                }
                bArr7[i7] = b3;
                i8 = i7 + 1;
                try {
                    bytes = this.O000O0oO.getBytes("GBK");
                    if (bytes.length > 127) {
                    }
                    if (bytes == null) {
                    }
                } catch (Throwable unused7) {
                    bArr7[i8] = 0;
                }
            } else {
                byte[] O000000o23 = O000000o(this.O0000oOO);
                bArr7[O000000o3] = (byte) O000000o23.length;
                int i44 = O000000o3 + 1;
                System.arraycopy(O000000o23, 0, bArr7, i44, O000000o23.length);
                i = i44 + O000000o23.length;
                int O000000o42 = O000000o(this.O0000ooO, bArr7, O000000o(O000OO, bArr7, O000000o(O000OO00, bArr7, O000000o(this.O0000oo, bArr7, O000000o(this.O0000oo0, bArr7, i)))));
                bArr7[O000000o42] = Byte.parseByte(this.O0000ooo);
                int i232 = O000000o42 + 1;
                bArr7[i232] = Byte.parseByte(this.O0000Oo);
                int i242 = i232 + 1;
                int i252 = this.O00oOooO;
                i2 = i252 & 3;
                bArr7[i242] = (byte) i252;
                i3 = i242 + 1;
                byte[] O00000Oo22 = bwi.O00000Oo(O00000Oo("mcc"));
                System.arraycopy(O00000Oo22, 0, bArr7, i3, O00000Oo22.length);
                int length32 = i3 + O00000Oo22.length;
                if (i2 != 1) {
                }
                length32 = length + length2;
                parseInt = Integer.parseInt(O00000Oo("signal"));
                parseInt = 0;
                bArr7[length32] = (byte) parseInt;
                int i2622 = length32 + 1;
                byte[] O000000o522 = bwi.O000000o(0, bArr4);
                System.arraycopy(O000000o522, 0, bArr7, i2622, O000000o522.length);
                i3 = i2622 + 2;
                if (i2 == 1) {
                }
                i3++;
                str = this.O000O0Oo;
                byte[] bytes22 = str.getBytes("GBK");
                int min22 = Math.min(bytes22.length, 60);
                bArr7[i3] = (byte) min22;
                i3++;
                System.arraycopy(bytes22, 0, bArr7, i3, min22);
                i4 = i3 + min22;
                ArrayList<bvm> arrayList32 = this.O000O0OO;
                int size22 = arrayList32.size();
                if ((this.O00oOooO & 4) == 4) {
                }
                b = 0;
                bArr7[i4] = 0;
                i5 = i4 + 1;
                if (this.O00oOoOo.length() == 0) {
                }
                i6 = i5 + 1;
                b2 = 0;
                ArrayList<ScanResult> arrayList222 = this.O000O0o0;
                min = Math.min(arrayList222.size(), 25);
                if (min == 0) {
                }
                bArr7[i7] = b3;
                i8 = i7 + 1;
                bytes = this.O000O0oO.getBytes("GBK");
                if (bytes.length > 127) {
                }
                if (bytes == null) {
                }
            }
        } catch (Throwable th2) {
            bvz.O000000o(th2, "Req", "buildV4Dot219");
            bArr7[O000000o3] = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(1:2)(1:3)|4|(1:6)(1:7)|8|(8:10|(2:12|13)|16|(1:20)|21|(2:23|24)|28|(1:32))(1:33)|34|(2:35|36)|39|(2:41|(1:43)(1:44))(1:45)|46|(3:48|(2:50|(1:52)(3:53|(1:57)|58))(3:59|(4:62|(2:64|119)(1:120)|65|60)|118)|66)(1:67)|68|(1:73)(1:72)|74|(2:(2:77|(8:79|(1:81)|84|85|86|87|(1:90)|91))|(1:95))(2:96|(1:98))|99|(1:101)|102|103|104|(1:106)|107|108|(1:110)|111|112|(1:114)|115|117) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x032d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x033b */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0335 A[Catch:{ Throwable -> 0x033b }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0343 A[Catch:{ Throwable -> 0x0349 }] */
    public final void O000000o(Context context, boolean z, boolean z2, ee eeVar, bvn bvn, ConnectivityManager connectivityManager, String str, String str2) {
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        ArrayList<ScanResult> arrayList;
        ee eeVar2 = eeVar;
        String O00000oo2 = bwt.O00000oo(context);
        int O0000O0o2 = bwi.O0000O0o();
        this.O000OO0o = str2;
        if (!z2) {
            str4 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        } else {
            str4 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        }
        String str12 = str3;
        String str13 = str4;
        StringBuilder sb = new StringBuilder();
        int i2 = eeVar2.f4531O000000o;
        int i3 = eeVar2.f4531O000000o & 3;
        TelephonyManager telephonyManager = eeVar2.O00000oo;
        ArrayList<bvm> arrayList2 = eeVar2.O00000Oo;
        ArrayList<bvm> arrayList3 = eeVar2.O00000o;
        ArrayList<ScanResult> O00000Oo2 = bvn.O00000Oo();
        String str14 = "1";
        String str15 = i3 == 2 ? str14 : "0";
        if (telephonyManager != null) {
            if (TextUtils.isEmpty(bvz.O00000o)) {
                try {
                    bvz.O00000o = bww.O0000oOo(context);
                } catch (Throwable th) {
                    bvz.O000000o(th, "Aps", "getApsReq part4");
                }
            }
            i = O0000O0o2;
            if (TextUtils.isEmpty(bvz.O00000o) && Build.VERSION.SDK_INT < 29) {
                bvz.O00000o = "888888888888888";
            }
            if (TextUtils.isEmpty(bvz.O00000oO)) {
                try {
                    bvz.O00000oO = telephonyManager.getSubscriberId();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    bvz.O000000o(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(bvz.O00000oO) && Build.VERSION.SDK_INT < 29) {
                bvz.O00000oO = "888888888888888";
            }
        } else {
            i = O0000O0o2;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            bvz.O000000o(th3, "Aps", "getApsReq part");
        }
        boolean O000000o2 = bvn.O000000o(connectivityManager);
        String str16 = "";
        if (bwi.O000000o(networkInfo) != -1) {
            str6 = bwi.O00000Oo(telephonyManager);
            str5 = O000000o2 ? "2" : str14;
        } else {
            str6 = str16;
            str5 = str6;
        }
        String str17 = str5;
        String str18 = str6;
        if (!arrayList2.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            str11 = str16;
            str10 = O00000oo2;
            str9 = "0";
            str8 = str12;
            if (i3 == 1) {
                bvm bvm = arrayList2.get(0);
                str7 = str13;
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(bvm.f13313O000000o);
                sb2.append("</mcc>");
                sb2.append("<mnc>");
                sb2.append(bvm.O00000Oo);
                sb2.append("</mnc>");
                sb2.append("<lac>");
                sb2.append(bvm.O00000o0);
                sb2.append("</lac>");
                sb2.append("<cellid>");
                sb2.append(bvm.O00000o);
                sb2.append("</cellid>");
                sb2.append("<signal>");
                sb2.append(bvm.O0000Oo);
                sb2.append("</signal>");
                str16 = sb2.toString();
                for (int i4 = 1; i4 < arrayList2.size(); i4++) {
                    bvm bvm2 = arrayList2.get(i4);
                    sb.append(bvm2.O00000o0);
                    sb.append(",");
                    sb.append(bvm2.O00000o);
                    sb.append(",");
                    sb.append(bvm2.O0000Oo);
                    if (i4 < arrayList2.size() - 1) {
                        sb.append("*");
                    }
                }
            } else if (i3 != 2) {
                str7 = str13;
                str16 = str11;
            } else {
                bvm bvm3 = arrayList2.get(0);
                sb2.delete(0, sb2.length());
                sb2.append("<mcc>");
                sb2.append(bvm3.f13313O000000o);
                sb2.append("</mcc>");
                sb2.append("<sid>");
                sb2.append(bvm3.O0000O0o);
                sb2.append("</sid>");
                sb2.append("<nid>");
                sb2.append(bvm3.O0000OOo);
                sb2.append("</nid>");
                sb2.append("<bid>");
                sb2.append(bvm3.O0000Oo0);
                sb2.append("</bid>");
                if (bvm3.O00000oo > 0 && bvm3.O00000oO > 0) {
                    sb2.append("<lon>");
                    sb2.append(bvm3.O00000oo);
                    sb2.append("</lon>");
                    sb2.append("<lat>");
                    sb2.append(bvm3.O00000oO);
                    sb2.append("</lat>");
                }
                sb2.append("<signal>");
                sb2.append(bvm3.O0000Oo);
                sb2.append("</signal>");
                str16 = sb2.toString();
                str7 = str13;
            }
            sb2.delete(0, sb2.length());
        } else {
            str10 = O00000oo2;
            str7 = str13;
            str8 = str12;
            str9 = "0";
            str11 = str16;
        }
        if ((i2 & 4) != 4 || arrayList3.isEmpty()) {
            this.O000O0OO.clear();
        } else {
            this.O000O0OO.clear();
            this.O000O0OO.addAll(arrayList3);
        }
        StringBuilder sb3 = new StringBuilder();
        if (bvn.O0000o0o) {
            if (O000000o2) {
                WifiInfo O00000o2 = bvn.O00000o();
                if (bvn.O000000o(O00000o2)) {
                    sb3.append(O00000o2.getBSSID());
                    sb3.append(",");
                    int rssi = O00000o2.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = O00000o2.getSSID();
                    int i5 = 32;
                    try {
                        i5 = O00000o2.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                    }
                    if (i5 >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", "."));
                }
            }
            if (!(O00000Oo2 == null || (arrayList = this.O000O0o0) == null)) {
                arrayList.clear();
                this.O000O0o0.addAll(O00000Oo2);
            }
        } else {
            bvn.O00000o0();
            ArrayList<ScanResult> arrayList4 = this.O000O0o0;
            if (arrayList4 != null) {
                arrayList4.clear();
            }
        }
        this.O00000Oo = 0;
        if (!z) {
            this.O00000Oo = (short) (this.O00000Oo | 2);
        }
        this.O00000o0 = str7;
        this.O00000o = str8;
        this.O00000oo = bwi.O00000oO();
        this.O0000O0o = "android" + bwi.O00000oo();
        this.O0000OOo = bwi.O00000Oo(context);
        this.O0000Oo0 = str15;
        String str19 = str9;
        this.O0000Oo = str19;
        this.O0000OoO = str19;
        this.O0000Ooo = str19;
        this.O0000o00 = str19;
        this.O0000o0 = str19;
        this.O0000o0O = str10;
        this.O0000o0o = bvz.O00000o;
        this.O0000o = bvz.O00000oO;
        this.O0000oO = String.valueOf(i);
        this.O0000oOO = bwi.O0000Oo(context);
        this.O0000oo0 = "4.7.1";
        this.O0000oo = str;
        this.O0000oOo = str11;
        this.O0000ooO = str18;
        this.O0000ooo = str17;
        this.O00oOooO = i2;
        this.O00oOooo = str16;
        this.O000O00o = sb.toString();
        this.O000O0Oo = eeVar.O00000o0;
        this.O000O0o = bvn.O00000oo();
        this.O00oOoOo = sb3.toString();
        if (TextUtils.isEmpty(O000OO00)) {
            O000OO00 = bww.O0000O0o(context);
        }
        if (TextUtils.isEmpty(O000OO)) {
            O000OO = bww.O000000o(context);
        }
        if (TextUtils.isEmpty(this.O000OOo0)) {
            this.O000OOo0 = bww.O0000OOo(context);
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }
}
