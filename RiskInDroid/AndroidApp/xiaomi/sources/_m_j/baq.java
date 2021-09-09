package _m_j;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.horcrux.svg.SVGLengthUnitType;
import java.util.ArrayList;

public final class baq {

    /* renamed from: O000000o  reason: collision with root package name */
    public final double f12752O000000o;
    public final SVGLengthUnitType O00000Oo;

    private baq() {
        this.f12752O000000o = 0.0d;
        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_UNKNOWN;
    }

    public baq(double d) {
        this.f12752O000000o = d;
        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00df  */
    private baq(String str) {
        char c;
        String trim = str.trim();
        int length = trim.length();
        int i = length - 1;
        if (length == 0 || trim.equals("normal")) {
            this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_UNKNOWN;
            this.f12752O000000o = 0.0d;
        } else if (trim.codePointAt(i) == 37) {
            this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_PERCENTAGE;
            this.f12752O000000o = Double.valueOf(trim.substring(0, i)).doubleValue();
        } else {
            int i2 = length - 2;
            if (i2 > 0) {
                String substring = trim.substring(i2);
                int hashCode = substring.hashCode();
                if (hashCode != 3178) {
                    if (hashCode != 3240) {
                        if (hashCode != 3251) {
                            if (hashCode != 3365) {
                                if (hashCode != 3488) {
                                    if (hashCode != 3571) {
                                        if (hashCode != 3588) {
                                            if (hashCode == 3592 && substring.equals("px")) {
                                                c = 0;
                                                switch (c) {
                                                    case 0:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                        length = i2;
                                                        break;
                                                    case 1:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                                        length = i2;
                                                        break;
                                                    case 2:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                                        length = i2;
                                                        break;
                                                    case 3:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                                        length = i2;
                                                        break;
                                                    case 4:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                                        length = i2;
                                                        break;
                                                    case 5:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                                        length = i2;
                                                        break;
                                                    case 6:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                                        length = i2;
                                                        break;
                                                    case 7:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                                        length = i2;
                                                        break;
                                                    default:
                                                        this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                        break;
                                                }
                                                this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                                                return;
                                            }
                                        } else if (substring.equals("pt")) {
                                            c = 3;
                                            switch (c) {
                                            }
                                            this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                                            return;
                                        }
                                    } else if (substring.equals("pc")) {
                                        c = 4;
                                        switch (c) {
                                        }
                                        this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                                        return;
                                    }
                                } else if (substring.equals("mm")) {
                                    c = 5;
                                    switch (c) {
                                    }
                                    this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                                    return;
                                }
                            } else if (substring.equals("in")) {
                                c = 7;
                                switch (c) {
                                }
                                this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                                return;
                            }
                        } else if (substring.equals("ex")) {
                            c = 2;
                            switch (c) {
                            }
                            this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                            return;
                        }
                    } else if (substring.equals("em")) {
                        c = 1;
                        switch (c) {
                        }
                        this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                        return;
                    }
                } else if (substring.equals("cm")) {
                    c = 6;
                    switch (c) {
                    }
                    this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                    return;
                }
                c = 65535;
                switch (c) {
                }
                this.f12752O000000o = Double.valueOf(trim.substring(0, length)).doubleValue();
                return;
            }
            this.O00000Oo = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
            this.f12752O000000o = Double.valueOf(trim).doubleValue();
        }
    }

    /* renamed from: _m_j.baq$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final /* synthetic */ int[] f12753O000000o = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f12753O000000o[ReadableType.Number.ordinal()] = 1;
            f12753O000000o[ReadableType.String.ordinal()] = 2;
            try {
                f12753O000000o[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static baq O000000o(Dynamic dynamic) {
        int i = AnonymousClass1.f12753O000000o[dynamic.getType().ordinal()];
        if (i == 1) {
            return new baq(dynamic.asDouble());
        }
        if (i != 2) {
            return new baq();
        }
        return new baq(dynamic.asString());
    }

    public static ArrayList<baq> O00000Oo(Dynamic dynamic) {
        int i = AnonymousClass1.f12753O000000o[dynamic.getType().ordinal()];
        if (i == 1) {
            ArrayList<baq> arrayList = new ArrayList<>(1);
            arrayList.add(new baq(dynamic.asDouble()));
            return arrayList;
        } else if (i == 2) {
            ArrayList<baq> arrayList2 = new ArrayList<>(1);
            arrayList2.add(new baq(dynamic.asString()));
            return arrayList2;
        } else if (i != 3) {
            return null;
        } else {
            ReadableArray asArray = dynamic.asArray();
            int size = asArray.size();
            ArrayList<baq> arrayList3 = new ArrayList<>(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList3.add(O000000o(asArray.getDynamic(i2)));
            }
            return arrayList3;
        }
    }
}
