package androidx.renderscript;

import _m_j.hi;
import _m_j.hj;
import _m_j.hm;
import com.google.android.exoplayer2.C;

public class Element extends hi {

    /* renamed from: O000000o  reason: collision with root package name */
    int f2964O000000o;
    DataType O00000Oo;
    boolean O00000o;
    DataKind O00000o0;
    int O00000oO;

    public int O000000o() {
        return this.f2964O000000o;
    }

    public enum DataType {
        NONE(0, 0),
        FLOAT_32(2, 4),
        FLOAT_64(3, 8),
        SIGNED_8(4, 1),
        SIGNED_16(5, 2),
        SIGNED_32(6, 4),
        SIGNED_64(7, 8),
        UNSIGNED_8(8, 1),
        UNSIGNED_16(9, 2),
        UNSIGNED_32(10, 4),
        UNSIGNED_64(11, 8),
        BOOLEAN(12, 1),
        UNSIGNED_5_6_5(13, 2),
        UNSIGNED_5_5_5_1(14, 2),
        UNSIGNED_4_4_4_4(15, 2),
        MATRIX_4X4(16, 64),
        MATRIX_3X3(17, 36),
        MATRIX_2X2(18, 16),
        RS_ELEMENT(1000, 4),
        RS_TYPE(1001, 4),
        RS_ALLOCATION(1002, 4),
        RS_SAMPLER(1003, 4),
        RS_SCRIPT(1004, 4);
        
        public int mID;
        int mSize;

        private DataType(int i, int i2) {
            this.mID = i;
            this.mSize = i2;
        }
    }

    public enum DataKind {
        USER(0),
        PIXEL_L(7),
        PIXEL_A(8),
        PIXEL_LA(9),
        PIXEL_RGB(10),
        PIXEL_RGBA(11),
        PIXEL_DEPTH(12),
        PIXEL_YUV(13);
        
        public int mID;

        private DataKind(int i) {
            this.mID = i;
        }
    }

    public static Element O00000Oo(RenderScript renderScript) {
        if (renderScript.O0000o0O == null) {
            renderScript.O0000o0O = O000000o(renderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
        }
        return renderScript.O0000o0O;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.renderscript.RenderScript.O000000o(int, int, boolean, int):int
     arg types: [int, int, int, int]
     candidates:
      androidx.renderscript.RenderScript.O000000o(int, int, android.graphics.Bitmap, int):int
      androidx.renderscript.RenderScript.O000000o(int, int, boolean, int):int */
    public static Element O00000o0(RenderScript renderScript) {
        Element element;
        if (renderScript.O0000o0o == null) {
            DataType dataType = DataType.UNSIGNED_8;
            if (RenderScript.O0000O0o) {
                element = hj.O000000o((hm) renderScript, dataType, 4);
            } else {
                switch (AnonymousClass1.f2965O000000o[dataType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    case 9:
                    case 10:
                    case 11:
                        break;
                    default:
                        throw new RSIllegalArgumentException("Cannot create vector of non-primitive type.");
                }
                DataKind dataKind = DataKind.USER;
                element = new Element(renderScript.O000000o(dataType.mID, dataKind.mID, false, 4), renderScript, dataType, dataKind, false, 4);
            }
            renderScript.O0000o0o = element;
        }
        return renderScript.O0000o0o;
    }

    public Element(int i, RenderScript renderScript, DataType dataType, DataKind dataKind, boolean z, int i2) {
        super(i, renderScript);
        if (dataType == DataType.UNSIGNED_5_6_5 || dataType == DataType.UNSIGNED_4_4_4_4 || dataType == DataType.UNSIGNED_5_5_5_1) {
            this.f2964O000000o = dataType.mSize;
        } else if (i2 == 3) {
            this.f2964O000000o = dataType.mSize * 4;
        } else {
            this.f2964O000000o = dataType.mSize * i2;
        }
        this.O00000Oo = dataType;
        this.O00000o0 = dataKind;
        this.O00000o = z;
        this.O00000oO = i2;
    }

    protected Element(RenderScript renderScript) {
        super(0, renderScript);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.renderscript.RenderScript.O000000o(int, int, boolean, int):int
     arg types: [int, int, int, int]
     candidates:
      androidx.renderscript.RenderScript.O000000o(int, int, android.graphics.Bitmap, int):int
      androidx.renderscript.RenderScript.O000000o(int, int, boolean, int):int */
    public static Element O000000o(RenderScript renderScript, DataType dataType, DataKind dataKind) {
        if (RenderScript.O0000O0o) {
            return hj.O00000Oo((hm) renderScript, dataType, dataKind);
        }
        if (dataKind != DataKind.PIXEL_L && dataKind != DataKind.PIXEL_A && dataKind != DataKind.PIXEL_LA && dataKind != DataKind.PIXEL_RGB && dataKind != DataKind.PIXEL_RGBA && dataKind != DataKind.PIXEL_DEPTH && dataKind != DataKind.PIXEL_YUV) {
            throw new RSIllegalArgumentException("Unsupported DataKind");
        } else if (dataType != DataType.UNSIGNED_8 && dataType != DataType.UNSIGNED_16 && dataType != DataType.UNSIGNED_5_6_5 && dataType != DataType.UNSIGNED_4_4_4_4 && dataType != DataType.UNSIGNED_5_5_5_1) {
            throw new RSIllegalArgumentException("Unsupported DataType");
        } else if (dataType == DataType.UNSIGNED_5_6_5 && dataKind != DataKind.PIXEL_RGB) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        } else if (dataType == DataType.UNSIGNED_5_5_5_1 && dataKind != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        } else if (dataType == DataType.UNSIGNED_4_4_4_4 && dataKind != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        } else if (dataType != DataType.UNSIGNED_16 || dataKind == DataKind.PIXEL_DEPTH) {
            int i = AnonymousClass1.O00000Oo[dataKind.ordinal()];
            int i2 = i != 1 ? i != 2 ? i != 3 ? 1 : 4 : 3 : 2;
            return new Element(renderScript.O000000o(dataType.mID, dataKind.mID, true, i2), renderScript, dataType, dataKind, true, i2);
        } else {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
    }

    /* renamed from: androidx.renderscript.Element$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2965O000000o = new int[DataType.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[DataKind.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a1 */
        static {
            try {
                O00000Oo[DataKind.PIXEL_LA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[DataKind.PIXEL_RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[DataKind.PIXEL_RGBA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2965O000000o[DataType.FLOAT_32.ordinal()] = 1;
            f2965O000000o[DataType.FLOAT_64.ordinal()] = 2;
            f2965O000000o[DataType.SIGNED_8.ordinal()] = 3;
            f2965O000000o[DataType.SIGNED_16.ordinal()] = 4;
            f2965O000000o[DataType.SIGNED_32.ordinal()] = 5;
            f2965O000000o[DataType.SIGNED_64.ordinal()] = 6;
            f2965O000000o[DataType.UNSIGNED_8.ordinal()] = 7;
            f2965O000000o[DataType.UNSIGNED_16.ordinal()] = 8;
            f2965O000000o[DataType.UNSIGNED_32.ordinal()] = 9;
            f2965O000000o[DataType.UNSIGNED_64.ordinal()] = 10;
            f2965O000000o[DataType.BOOLEAN.ordinal()] = 11;
        }
    }

    public boolean O000000o(Element element) {
        if (equals(element)) {
            return true;
        }
        if (this.f2964O000000o == element.f2964O000000o && this.O00000Oo != DataType.NONE && this.O00000Oo == element.O00000Oo && this.O00000oO == element.O00000oO) {
            return true;
        }
        return false;
    }
}
