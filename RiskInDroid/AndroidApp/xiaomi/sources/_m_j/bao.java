package _m_j;

import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.horcrux.svg.SVGLengthUnitType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class bao {
    public static int O000000o(ReadableArray readableArray, float[] fArr, float f) {
        int size = readableArray.size();
        if (size != 6) {
            return size;
        }
        fArr[0] = (float) readableArray.getDouble(0);
        fArr[1] = (float) readableArray.getDouble(2);
        fArr[2] = ((float) readableArray.getDouble(4)) * f;
        fArr[3] = (float) readableArray.getDouble(1);
        fArr[4] = (float) readableArray.getDouble(3);
        fArr[5] = ((float) readableArray.getDouble(5)) * f;
        return 6;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a8 A[PHI: r8 10  PHI: (r8v3 int) = (r8v1 int), (r8v4 int) binds: [B:46:0x00a4, B:47:0x00a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bf  */
    public static double O000000o(String str, double d, double d2, double d3) {
        double doubleValue;
        char c;
        String trim = str.trim();
        int length = trim.length();
        int i = length - 1;
        if (length == 0 || trim.equals("normal")) {
            return 0.0d;
        }
        if (trim.codePointAt(i) == 37) {
            return (Double.valueOf(trim.substring(0, i)).doubleValue() / 100.0d) * d;
        }
        int i2 = length - 2;
        if (i2 > 0) {
            String substring = trim.substring(i2);
            int hashCode = substring.hashCode();
            if (hashCode != 3178) {
                if (hashCode != 3240) {
                    if (hashCode != 3365) {
                        if (hashCode != 3488) {
                            if (hashCode != 3571) {
                                if (hashCode != 3588) {
                                    if (hashCode == 3592 && substring.equals("px")) {
                                        c = 0;
                                        switch (c) {
                                            case 0:
                                                d3 = 1.0d;
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                d3 = 1.25d;
                                                break;
                                            case 3:
                                                d3 = 15.0d;
                                                break;
                                            case 4:
                                                d3 = 3.543307d;
                                                break;
                                            case 5:
                                                d3 = 35.43307d;
                                                break;
                                            case 6:
                                                d3 = 90.0d;
                                                break;
                                            default:
                                                i2 = length;
                                                d3 = 1.0d;
                                                break;
                                        }
                                        doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
                                    }
                                } else if (substring.equals("pt")) {
                                    c = 2;
                                    switch (c) {
                                    }
                                    doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
                                }
                            } else if (substring.equals("pc")) {
                                c = 3;
                                switch (c) {
                                }
                                doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
                            }
                        } else if (substring.equals("mm")) {
                            c = 4;
                            switch (c) {
                            }
                            doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
                        }
                    } else if (substring.equals("in")) {
                        c = 6;
                        switch (c) {
                        }
                        doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
                    }
                } else if (substring.equals("em")) {
                    c = 1;
                    switch (c) {
                    }
                    doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
                }
            } else if (substring.equals("cm")) {
                c = 5;
                switch (c) {
                }
                doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
            }
            c = 65535;
            switch (c) {
            }
            doubleValue = Double.valueOf(trim.substring(0, i2)).doubleValue() * d3;
        } else {
            doubleValue = Double.valueOf(trim).doubleValue();
        }
        return doubleValue * d2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static double O000000o(baq baq, double d, double d2, double d3, double d4) {
        double d5;
        if (baq == null) {
            return d2;
        }
        SVGLengthUnitType sVGLengthUnitType = baq.O00000Oo;
        double d6 = baq.f12752O000000o;
        switch (AnonymousClass1.f12749O000000o[sVGLengthUnitType.ordinal()]) {
            case 1:
            case 2:
                d4 = 1.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 3:
                d5 = (d6 / 100.0d) * d;
                break;
            case 4:
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 5:
                d4 /= 2.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 6:
                d4 = 35.43307d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 7:
                d4 = 3.543307d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                d4 = 90.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 9:
                d4 = 1.25d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            case 10:
                d4 = 15.0d;
                d6 *= d4;
                d5 = d6 * d3;
                break;
            default:
                d5 = d6 * d3;
                break;
        }
        return d5 + d2;
    }

    /* renamed from: _m_j.bao$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12749O000000o = new int[SVGLengthUnitType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER.ordinal()] = 1;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_PX.ordinal()] = 2;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_PERCENTAGE.ordinal()] = 3;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_EMS.ordinal()] = 4;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_EXS.ordinal()] = 5;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_CM.ordinal()] = 6;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_MM.ordinal()] = 7;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_IN.ordinal()] = 8;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_PT.ordinal()] = 9;
            f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_PC.ordinal()] = 10;
            try {
                f12749O000000o[SVGLengthUnitType.SVG_LENGTHTYPE_UNKNOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final Pattern f12750O000000o = Pattern.compile("[a-df-z]|[\\-+]?(?:[\\d.]e[\\-+]?|[^\\s\\-+,a-z])+", 2);
        public static final Pattern O00000Oo = Pattern.compile("(\\.\\d+)(?=-?\\.)");
        public Path O00000o;
        public Matcher O00000o0;
        public final String O00000oO;
        public boolean O00000oo = true;
        public WritableArray O0000O0o;
        private float O0000OOo = 0.0f;
        private float O0000Oo;
        private float O0000Oo0 = 0.0f;
        private float O0000OoO;
        private float O0000Ooo = 0.0f;
        private String O0000o;
        private final float O0000o0;
        private float O0000o00 = 0.0f;
        private boolean O0000o0O = false;
        private String O0000o0o;
        private WritableMap O0000oO0;

        public O000000o(String str, float f) {
            this.O0000o0 = f;
            this.O00000oO = str;
        }

        public final void O000000o(String str) {
            String str2 = str;
            while (true) {
                char c = 65535;
                switch (str2.hashCode()) {
                    case 65:
                        if (str2.equals("A")) {
                            c = 17;
                            break;
                        }
                        break;
                    case 67:
                        if (str2.equals("C")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 72:
                        if (str2.equals("H")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 76:
                        if (str2.equals("L")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 77:
                        if (str2.equals("M")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 81:
                        if (str2.equals("Q")) {
                            c = 13;
                            break;
                        }
                        break;
                    case 83:
                        if (str2.equals("S")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 84:
                        if (str2.equals("T")) {
                            c = 15;
                            break;
                        }
                        break;
                    case 86:
                        if (str2.equals("V")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 90:
                        if (str2.equals("Z")) {
                            c = 18;
                            break;
                        }
                        break;
                    case 97:
                        if (str2.equals("a")) {
                            c = 16;
                            break;
                        }
                        break;
                    case 99:
                        if (str2.equals("c")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 104:
                        if (str2.equals("h")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 108:
                        if (str2.equals("l")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 109:
                        if (str2.equals("m")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 113:
                        if (str2.equals("q")) {
                            c = 12;
                            break;
                        }
                        break;
                    case 115:
                        if (str2.equals("s")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 116:
                        if (str2.equals("t")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 118:
                        if (str2.equals("v")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 122:
                        if (str2.equals("z")) {
                            c = 19;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        O00000Oo(O00000Oo() + this.O0000OOo, O00000Oo() + this.O0000Oo0);
                        break;
                    case 1:
                        O00000Oo(O00000Oo(), O00000Oo());
                        break;
                    case 2:
                        O00000o0(O00000Oo(), O00000Oo());
                        break;
                    case 3:
                        O00000o(O00000Oo(), O00000Oo());
                        break;
                    case 4:
                        O00000o0(O00000Oo(), 0.0f);
                        break;
                    case 5:
                        O00000o(O00000Oo(), this.O0000Oo0);
                        break;
                    case 6:
                        O00000o0(0.0f, O00000Oo());
                        break;
                    case 7:
                        O00000o(this.O0000OOo, O00000Oo());
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        float O00000Oo2 = O00000Oo();
                        float O00000Oo3 = O00000Oo();
                        float O00000Oo4 = O00000Oo();
                        float O00000Oo5 = O00000Oo();
                        float O00000Oo6 = O00000Oo();
                        float O00000Oo7 = O00000Oo();
                        float f = this.O0000OOo;
                        float f2 = O00000Oo2 + f;
                        float f3 = this.O0000Oo0;
                        O000000o(f2, O00000Oo3 + f3, O00000Oo4 + f, O00000Oo5 + f3, f + O00000Oo6, O00000Oo7 + f3);
                        break;
                    case 9:
                        O000000o(O00000Oo(), O00000Oo(), O00000Oo(), O00000Oo(), O00000Oo(), O00000Oo());
                        break;
                    case 10:
                        float O00000Oo8 = O00000Oo();
                        float O00000Oo9 = O00000Oo();
                        float O00000Oo10 = O00000Oo();
                        float O00000Oo11 = O00000Oo();
                        float f4 = this.O0000OOo;
                        float f5 = this.O0000Oo0;
                        O000000o(O00000Oo8 + f4, O00000Oo9 + f5, O00000Oo10 + f4, O00000Oo11 + f5);
                        break;
                    case 11:
                        O000000o(O00000Oo(), O00000Oo(), O00000Oo(), O00000Oo());
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        float O00000Oo12 = O00000Oo();
                        float O00000Oo13 = O00000Oo();
                        float O00000Oo14 = O00000Oo();
                        float O00000Oo15 = O00000Oo();
                        float f6 = this.O0000OOo;
                        float f7 = this.O0000Oo0;
                        O00000Oo(O00000Oo12 + f6, O00000Oo13 + f7, O00000Oo14 + f6, O00000Oo15 + f7);
                        break;
                    case 13:
                        O00000Oo(O00000Oo(), O00000Oo(), O00000Oo(), O00000Oo());
                        break;
                    case 14:
                        O00000oO(O00000Oo() + this.O0000OOo, O00000Oo() + this.O0000Oo0);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        O00000oO(O00000Oo(), O00000Oo());
                        break;
                    case 16:
                        float O00000Oo16 = O00000Oo();
                        float O00000Oo17 = O00000Oo();
                        float O00000Oo18 = O00000Oo();
                        boolean O000000o2 = O000000o();
                        boolean O000000o3 = O000000o();
                        float O00000Oo19 = O00000Oo();
                        float O00000Oo20 = O00000Oo();
                        O000000o(O00000Oo16, O00000Oo17, O00000Oo18, O000000o2, O000000o3, this.O0000OOo + O00000Oo19, O00000Oo20 + this.O0000Oo0);
                        break;
                    case 17:
                        O000000o(O00000Oo(), O00000Oo(), O00000Oo(), O000000o(), O000000o(), O00000Oo(), O00000Oo());
                        break;
                    case 18:
                    case 19:
                        if (this.O0000o0O) {
                            this.O0000OOo = this.O0000Oo;
                            this.O0000Oo0 = this.O0000OoO;
                            this.O0000o0O = false;
                            this.O00000o.close();
                            WritableArray createArray = Arguments.createArray();
                            createArray.pushMap(O000000o(this.O0000oO0));
                            createArray.pushMap(O000000o(this.O0000oO0));
                            createArray.pushMap(O000000o(this.O0000oO0));
                            this.O0000O0o.pushArray(createArray);
                            break;
                        }
                        break;
                    default:
                        this.O0000o = str2;
                        str2 = this.O0000o0o;
                }
            }
            this.O0000o0o = str2;
            if (str2.equals("m")) {
                this.O0000o0o = "l";
            } else if (str2.equals("M")) {
                this.O0000o0o = "L";
            }
        }

        private WritableMap O000000o(float f, float f2) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", (double) (f * this.O0000o0));
            createMap.putDouble("y", (double) (f2 * this.O0000o0));
            return createMap;
        }

        private static WritableMap O000000o(WritableMap writableMap) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", writableMap.getDouble("x"));
            createMap.putDouble("y", writableMap.getDouble("y"));
            return createMap;
        }

        private boolean O000000o() {
            if (this.O00000o0.find()) {
                return this.O00000o0.group().equals("1");
            }
            this.O00000oo = false;
            this.O00000o = new Path();
            return false;
        }

        private float O00000Oo() {
            String str = this.O0000o;
            if (str != null) {
                this.O0000o = null;
                return Float.parseFloat(str);
            } else if (this.O00000o0.find()) {
                return Float.parseFloat(this.O00000o0.group());
            } else {
                this.O00000oo = false;
                this.O00000o = new Path();
                return 0.0f;
            }
        }

        private void O00000Oo(float f, float f2) {
            this.O0000OOo = f;
            this.O0000Ooo = f;
            this.O0000Oo = f;
            this.O0000Oo0 = f2;
            this.O0000o00 = f2;
            this.O0000OoO = f2;
            Path path = this.O00000o;
            float f3 = this.O0000o0;
            path.moveTo(f * f3, f3 * f2);
            this.O0000oO0 = O000000o(f, f2);
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(O000000o(f, f2));
            this.O0000O0o.pushArray(createArray);
        }

        private void O00000o0(float f, float f2) {
            O00000o(f + this.O0000OOo, f2 + this.O0000Oo0);
        }

        private void O00000o(float f, float f2) {
            O00000o0();
            this.O0000OOo = f;
            this.O0000Ooo = f;
            this.O0000Oo0 = f2;
            this.O0000o00 = f2;
            Path path = this.O00000o;
            float f3 = this.O0000o0;
            path.lineTo(f * f3, f3 * f2);
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(O000000o(f, f2));
            createArray.pushMap(O000000o(f, f2));
            createArray.pushMap(O000000o(f, f2));
            this.O0000O0o.pushArray(createArray);
        }

        private void O000000o(float f, float f2, float f3, float f4, float f5, float f6) {
            this.O0000Ooo = f3;
            this.O0000o00 = f4;
            O00000Oo(f, f2, f3, f4, f5, f6);
        }

        private void O00000Oo(float f, float f2, float f3, float f4, float f5, float f6) {
            O00000o0();
            this.O0000OOo = f5;
            this.O0000Oo0 = f6;
            Path path = this.O00000o;
            float f7 = this.O0000o0;
            path.cubicTo(f * f7, f2 * f7, f3 * f7, f4 * f7, f5 * f7, f6 * f7);
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(O000000o(f, f2));
            createArray.pushMap(O000000o(f3, f4));
            createArray.pushMap(O000000o(f5, f6));
            this.O0000O0o.pushArray(createArray);
        }

        private void O000000o(float f, float f2, float f3, float f4) {
            this.O0000Ooo = f;
            this.O0000o00 = f2;
            O00000Oo((this.O0000OOo * 2.0f) - this.O0000Ooo, (this.O0000Oo0 * 2.0f) - this.O0000o00, f, f2, f3, f4);
        }

        private void O00000Oo(float f, float f2, float f3, float f4) {
            this.O0000Ooo = f;
            this.O0000o00 = f2;
            float f5 = f * 2.0f;
            float f6 = f2 * 2.0f;
            float f7 = (this.O0000OOo + f5) / 3.0f;
            float f8 = (this.O0000Oo0 + f6) / 3.0f;
            O00000Oo(f7, f8, (f3 + f5) / 3.0f, (f4 + f6) / 3.0f, f3, f4);
        }

        private void O00000oO(float f, float f2) {
            O00000Oo((this.O0000OOo * 2.0f) - this.O0000Ooo, (this.O0000Oo0 * 2.0f) - this.O0000o00, f, f2);
        }

        private void O000000o(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            float f6;
            float f7;
            float f8;
            boolean z3 = z;
            boolean z4 = z2;
            float f9 = f4;
            float f10 = f5;
            float f11 = this.O0000OOo;
            float f12 = this.O0000Oo0;
            float abs = Math.abs(f2 == 0.0f ? f == 0.0f ? f10 - f12 : f : f2);
            float abs2 = Math.abs(f == 0.0f ? f9 - f11 : f);
            if (abs2 == 0.0f || abs == 0.0f || (f9 == f11 && f10 == f12)) {
                O00000o(f9, f10);
                return;
            }
            float radians = (float) Math.toRadians((double) f3);
            double d = (double) radians;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float f13 = f9 - f11;
            float f14 = f10 - f12;
            float f15 = ((cos * f13) / 2.0f) + ((sin * f14) / 2.0f);
            float f16 = -sin;
            float f17 = ((f16 * f13) / 2.0f) + ((cos * f14) / 2.0f);
            float f18 = abs2 * abs2;
            float f19 = f18 * abs * abs;
            float f20 = abs * abs * f15 * f15;
            float f21 = f18 * f17 * f17;
            float f22 = (f19 - f21) - f20;
            if (f22 < 0.0f) {
                f6 = f16;
                float sqrt = (float) Math.sqrt((double) (1.0f - (f22 / f19)));
                abs2 *= sqrt;
                abs *= sqrt;
                f7 = f14 / 2.0f;
                f8 = f13 / 2.0f;
            } else {
                f6 = f16;
                float sqrt2 = (float) Math.sqrt((double) (f22 / (f21 + f20)));
                if (z3 == z4) {
                    sqrt2 = -sqrt2;
                }
                float f23 = (((-sqrt2) * f17) * abs2) / abs;
                float f24 = ((sqrt2 * f15) * abs) / abs2;
                f8 = ((cos * f23) - (sin * f24)) + (f13 / 2.0f);
                f7 = (f14 / 2.0f) + (f23 * sin) + (f24 * cos);
            }
            float f25 = cos / abs2;
            float f26 = sin / abs2;
            float f27 = f6 / abs;
            float f28 = cos / abs;
            float f29 = -f8;
            float f30 = -f7;
            float f31 = abs2;
            float f32 = abs;
            float f33 = f13 - f8;
            float f34 = f14 - f7;
            float atan2 = (float) Math.atan2((double) ((f27 * f29) + (f28 * f30)), (double) ((f29 * f25) + (f30 * f26)));
            float atan22 = (float) Math.atan2((double) ((f27 * f33) + (f28 * f34)), (double) ((f25 * f33) + (f26 * f34)));
            float f35 = f8 + f11;
            float f36 = f7 + f12;
            float f37 = f13 + f11;
            float f38 = f14 + f12;
            O00000o0();
            this.O0000Ooo = f37;
            this.O0000OOo = f37;
            this.O0000o00 = f38;
            this.O0000Oo0 = f38;
            if (f31 == f32 && radians == 0.0f) {
                float degrees = (float) Math.toDegrees((double) atan2);
                float abs3 = Math.abs((degrees - ((float) Math.toDegrees((double) atan22))) % 360.0f);
                if (!z ? abs3 > 180.0f : abs3 < 180.0f) {
                    abs3 = 360.0f - abs3;
                }
                if (!z2) {
                    abs3 = -abs3;
                }
                float f39 = this.O0000o0;
                this.O00000o.arcTo(new RectF((f35 - f31) * f39, (f36 - f31) * f39, (f35 + f31) * f39, (f36 + f31) * f39), degrees, abs3);
                return;
            }
            O000000o(f35, f36, f31, f32, atan2, atan22, z2, radians);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0073 A[LOOP:0: B:10:0x0071->B:11:0x0073, LOOP_END] */
        private void O000000o(float f, float f2, float f3, float f4, float f5, float f6, boolean z, float f7) {
            int ceil;
            int i;
            double d;
            float f8 = f5;
            double d2 = (double) f7;
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float f9 = cos * f3;
            float f10 = (-sin) * f4;
            float f11 = sin * f3;
            float f12 = cos * f4;
            float f13 = f6 - f8;
            if (f13 >= 0.0f || !z) {
                if (f13 > 0.0f && !z) {
                    double d3 = (double) f13;
                    Double.isNaN(d3);
                    d = d3 - 6.283185307179586d;
                }
                double d4 = (double) f13;
                Double.isNaN(d4);
                ceil = (int) Math.ceil(Math.abs(O000000o(d4 / 1.5707963267948966d)));
                float f14 = f13 / ((float) ceil);
                float tan = (float) (Math.tan((double) (f14 / 4.0f)) * 1.3333333333333333d);
                double d5 = (double) f8;
                float cos2 = (float) Math.cos(d5);
                float sin2 = (float) Math.sin(d5);
                i = 0;
                while (i < ceil) {
                    float f15 = cos2 - (tan * sin2);
                    float f16 = sin2 + (cos2 * tan);
                    float f17 = f8 + f14;
                    double d6 = (double) f17;
                    float f18 = f14;
                    int i2 = ceil;
                    float cos3 = (float) Math.cos(d6);
                    float sin3 = (float) Math.sin(d6);
                    float f19 = (tan * sin3) + cos3;
                    float f20 = sin3 - (tan * cos3);
                    float f21 = f17;
                    Path path = this.O00000o;
                    float f22 = f11;
                    float f23 = this.O0000o0;
                    Path path2 = path;
                    path2.cubicTo((f + (f9 * f15) + (f10 * f16)) * f23, (f2 + (f15 * f11) + (f16 * f12)) * f23, (f + (f9 * f19) + (f10 * f20)) * f23, (f2 + (f19 * f11) + (f20 * f12)) * f23, (f + (f9 * cos3) + (f10 * sin3)) * f23, (f2 + (f11 * cos3) + (f12 * sin3)) * f23);
                    i++;
                    f8 = f21;
                    f11 = f22;
                    sin2 = sin3;
                    ceil = i2;
                    cos2 = cos3;
                    f14 = f18;
                }
            }
            double d7 = (double) f13;
            Double.isNaN(d7);
            d = d7 + 6.283185307179586d;
            f13 = (float) d;
            double d42 = (double) f13;
            Double.isNaN(d42);
            ceil = (int) Math.ceil(Math.abs(O000000o(d42 / 1.5707963267948966d)));
            float f142 = f13 / ((float) ceil);
            float tan2 = (float) (Math.tan((double) (f142 / 4.0f)) * 1.3333333333333333d);
            double d52 = (double) f8;
            float cos22 = (float) Math.cos(d52);
            float sin22 = (float) Math.sin(d52);
            i = 0;
            while (i < ceil) {
            }
        }

        private void O00000o0() {
            if (!this.O0000o0O) {
                this.O0000Oo = this.O0000OOo;
                this.O0000OoO = this.O0000Oo0;
                this.O0000o0O = true;
            }
        }

        private static double O000000o(double d) {
            double pow = Math.pow(10.0d, 4.0d);
            double round = (double) Math.round(d * pow);
            Double.isNaN(round);
            return round / pow;
        }
    }
}
