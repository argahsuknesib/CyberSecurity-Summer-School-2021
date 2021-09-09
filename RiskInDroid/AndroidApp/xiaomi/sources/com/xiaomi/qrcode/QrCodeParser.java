package com.xiaomi.qrcode;

import _m_j.gsy;
import java.util.Arrays;
import java.util.Comparator;

public final class QrCodeParser {
    private static final Comparator<? super O000000o> O00000oO = new Comparator<O000000o>() {
        /* class com.xiaomi.qrcode.QrCodeParser.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((O000000o) obj).O00000o0 - ((O000000o) obj2).O00000o0;
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public QrCodeType f6584O000000o;
    final O000000o O00000Oo;
    public final O000000o O00000o;
    public final O000000o O00000o0;
    private final String O00000oo;
    private final O000000o O0000O0o;
    private final O000000o O0000OOo;

    public QrCodeParser(String str) {
        this(str, null);
    }

    public QrCodeParser(String str, String str2) {
        this.O0000O0o = new O000000o("$D:");
        this.O00000Oo = new O000000o("$M:");
        this.O0000OOo = new O000000o("$S:");
        this.O00000o0 = new O000000o("$A:");
        this.O00000o = new O000000o("$I:");
        this.O00000Oo.O00000Oo = str2;
        if (str != null) {
            if (!str.startsWith("G") || str.length() <= 2) {
                gsy.O000000o(4, "QrCodeParser", " no recongise start G");
            } else {
                String substring = str.substring(1);
                String[] split = substring.split("%Z");
                if (split.length == 2) {
                    O000000o(split[0], this.O00000Oo, this.O0000O0o, this.O0000OOo);
                    O000000o(split[1], this.O00000o0, this.O00000o);
                    if (this.O00000o0.O00000Oo == null || this.O00000o.O00000Oo == null || this.O0000O0o.O00000Oo == null || this.O00000Oo.O00000Oo == null) {
                        gsy.O000000o(4, "QrCodeParser", "must not by no $A:" + this.O00000o0.O00000Oo + " $I:" + this.O00000o.O00000Oo + " $D:" + this.O0000O0o.O00000Oo + " $M:" + this.O00000Oo.O00000Oo);
                    } else {
                        this.f6584O000000o = QrCodeType.ZIGBEE_30;
                    }
                } else {
                    String[] split2 = substring.split("%N");
                    if (split2.length == 2) {
                        O000000o(split2[0], this.O00000Oo, this.O0000O0o, this.O0000OOo);
                        O000000o(split2[1], this.O00000o0, this.O00000o);
                        if (this.O00000o0.O00000Oo == null || this.O00000o.O00000Oo == null || this.O0000O0o.O00000Oo == null || this.O00000Oo.O00000Oo == null) {
                            gsy.O000000o(4, "QrCodeParser", "must not by no $A:" + this.O00000o0.O00000Oo + " $I:" + this.O00000o.O00000Oo + " $D:" + this.O0000O0o.O00000Oo + " $M:" + this.O00000Oo.O00000Oo);
                        } else {
                            this.f6584O000000o = QrCodeType.NBIOT;
                        }
                    } else {
                        String[] split3 = substring.split("%W");
                        if (split3.length == 2) {
                            O000000o(split3[0], this.O00000Oo, this.O0000O0o, this.O0000OOo);
                            O000000o(split3[1], this.O00000o0, this.O00000o);
                            if (this.O00000o0.O00000Oo == null || this.O00000o.O00000Oo == null || this.O0000O0o.O00000Oo == null || this.O00000Oo.O00000Oo == null) {
                                gsy.O000000o(4, "QrCodeParser", "must not by no $A:" + this.O00000o0.O00000Oo + " $I:" + this.O00000o.O00000Oo + " $D:" + this.O0000O0o.O00000Oo + " $M:" + this.O00000Oo.O00000Oo);
                            } else {
                                this.f6584O000000o = QrCodeType.WIFI;
                            }
                        } else {
                            gsy.O000000o(4, "QrCodeParser", " no recongise any %Z %N %W");
                        }
                    }
                }
            }
        }
        this.O00000oo = str;
    }

    private static void O000000o(String str, O000000o... o000000oArr) {
        if (str != null) {
            int i = 0;
            for (O000000o o000000o : o000000oArr) {
                o000000o.O00000o0 = str.indexOf(o000000o.f6585O000000o);
            }
            Arrays.sort(o000000oArr, O00000oO);
            int length = o000000oArr.length;
            while (i < length) {
                O000000o o000000o2 = o000000oArr[i];
                o000000o2.O00000Oo = str.substring(o000000o2.O00000o0 + o000000o2.f6585O000000o.length(), i == length + -1 ? str.length() : o000000oArr[i + 1].O00000o0);
                i++;
            }
        }
    }

    public final String toString() {
        return this.O00000oo;
    }

    public enum QrCodeType {
        WIFI("W"),
        NBIOT("N"),
        ZIGBEE_30("Z");
        
        public final String type;

        private QrCodeType(String str) {
            this.type = str;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f6585O000000o;
        public String O00000Oo;
        public int O00000o0;

        public O000000o(String str) {
            this.f6585O000000o = str;
        }
    }
}
