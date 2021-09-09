package _m_j;

import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class hj extends Element {
    android.renderscript.Element O00000oo;

    public final int O000000o() {
        try {
            return this.O00000oo.getBytesSize();
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    /* renamed from: _m_j.hj$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f18972O000000o = new int[Element.DataKind.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[Element.DataType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0105 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x010f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0119 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0123 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x012d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0137 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0141 */
        static {
            try {
                O00000Oo[Element.DataType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[Element.DataType.FLOAT_32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[Element.DataType.FLOAT_64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[Element.DataType.SIGNED_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                O00000Oo[Element.DataType.SIGNED_16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                O00000Oo[Element.DataType.SIGNED_32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                O00000Oo[Element.DataType.SIGNED_64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            O00000Oo[Element.DataType.UNSIGNED_8.ordinal()] = 8;
            O00000Oo[Element.DataType.UNSIGNED_16.ordinal()] = 9;
            O00000Oo[Element.DataType.UNSIGNED_32.ordinal()] = 10;
            O00000Oo[Element.DataType.UNSIGNED_64.ordinal()] = 11;
            O00000Oo[Element.DataType.BOOLEAN.ordinal()] = 12;
            O00000Oo[Element.DataType.MATRIX_4X4.ordinal()] = 13;
            O00000Oo[Element.DataType.MATRIX_3X3.ordinal()] = 14;
            O00000Oo[Element.DataType.MATRIX_2X2.ordinal()] = 15;
            O00000Oo[Element.DataType.RS_ELEMENT.ordinal()] = 16;
            O00000Oo[Element.DataType.RS_TYPE.ordinal()] = 17;
            O00000Oo[Element.DataType.RS_ALLOCATION.ordinal()] = 18;
            O00000Oo[Element.DataType.RS_SAMPLER.ordinal()] = 19;
            O00000Oo[Element.DataType.RS_SCRIPT.ordinal()] = 20;
            f18972O000000o[Element.DataKind.USER.ordinal()] = 1;
            f18972O000000o[Element.DataKind.PIXEL_L.ordinal()] = 2;
            f18972O000000o[Element.DataKind.PIXEL_A.ordinal()] = 3;
            f18972O000000o[Element.DataKind.PIXEL_LA.ordinal()] = 4;
            f18972O000000o[Element.DataKind.PIXEL_RGB.ordinal()] = 5;
            f18972O000000o[Element.DataKind.PIXEL_RGBA.ordinal()] = 6;
            f18972O000000o[Element.DataKind.PIXEL_DEPTH.ordinal()] = 7;
            try {
                f18972O000000o[Element.DataKind.PIXEL_YUV.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static Element.DataType O000000o(Element.DataType dataType) {
        switch (AnonymousClass1.O00000Oo[dataType.ordinal()]) {
            case 1:
                return Element.DataType.NONE;
            case 2:
                return Element.DataType.FLOAT_32;
            case 3:
                return Element.DataType.FLOAT_64;
            case 4:
                return Element.DataType.SIGNED_8;
            case 5:
                return Element.DataType.SIGNED_16;
            case 6:
                return Element.DataType.SIGNED_32;
            case 7:
                return Element.DataType.SIGNED_64;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Element.DataType.UNSIGNED_8;
            case 9:
                return Element.DataType.UNSIGNED_16;
            case 10:
                return Element.DataType.UNSIGNED_32;
            case 11:
                return Element.DataType.UNSIGNED_64;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                return Element.DataType.BOOLEAN;
            case 13:
                return Element.DataType.MATRIX_4X4;
            case 14:
                return Element.DataType.MATRIX_3X3;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return Element.DataType.MATRIX_2X2;
            case 16:
                return Element.DataType.RS_ELEMENT;
            case 17:
                return Element.DataType.RS_TYPE;
            case 18:
                return Element.DataType.RS_ALLOCATION;
            case 19:
                return Element.DataType.RS_SAMPLER;
            case 20:
                return Element.DataType.RS_SCRIPT;
            default:
                return null;
        }
    }

    hj(RenderScript renderScript, android.renderscript.Element element) {
        super(renderScript);
        this.O00000oo = element;
    }

    static androidx.renderscript.Element O000000o(RenderScript renderScript, Element.DataType dataType) {
        hm hmVar = (hm) renderScript;
        android.renderscript.Element element = null;
        try {
            switch (AnonymousClass1.O00000Oo[dataType.ordinal()]) {
                case 2:
                    element = android.renderscript.Element.F32(hmVar.O0000oO);
                    break;
                case 3:
                    element = android.renderscript.Element.F64(hmVar.O0000oO);
                    break;
                case 4:
                    element = android.renderscript.Element.I8(hmVar.O0000oO);
                    break;
                case 5:
                    element = android.renderscript.Element.I16(hmVar.O0000oO);
                    break;
                case 6:
                    element = android.renderscript.Element.I32(hmVar.O0000oO);
                    break;
                case 7:
                    element = android.renderscript.Element.I64(hmVar.O0000oO);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    element = android.renderscript.Element.U8(hmVar.O0000oO);
                    break;
                case 9:
                    element = android.renderscript.Element.U16(hmVar.O0000oO);
                    break;
                case 10:
                    element = android.renderscript.Element.U32(hmVar.O0000oO);
                    break;
                case 11:
                    element = android.renderscript.Element.U64(hmVar.O0000oO);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                    element = android.renderscript.Element.BOOLEAN(hmVar.O0000oO);
                    break;
                case 13:
                    element = android.renderscript.Element.MATRIX_4X4(hmVar.O0000oO);
                    break;
                case 14:
                    element = android.renderscript.Element.MATRIX_3X3(hmVar.O0000oO);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    element = android.renderscript.Element.MATRIX_2X2(hmVar.O0000oO);
                    break;
                case 16:
                    element = android.renderscript.Element.ELEMENT(hmVar.O0000oO);
                    break;
                case 17:
                    element = android.renderscript.Element.TYPE(hmVar.O0000oO);
                    break;
                case 18:
                    element = android.renderscript.Element.ALLOCATION(hmVar.O0000oO);
                    break;
                case 19:
                    element = android.renderscript.Element.SAMPLER(hmVar.O0000oO);
                    break;
                case 20:
                    element = android.renderscript.Element.SCRIPT(hmVar.O0000oO);
                    break;
            }
            return new hj(renderScript, element);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public static androidx.renderscript.Element O000000o(RenderScript renderScript, Element.DataType dataType, int i) {
        try {
            return new hj(renderScript, android.renderscript.Element.createVector(((hm) renderScript).O0000oO, O000000o(dataType), 4));
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public static androidx.renderscript.Element O00000Oo(RenderScript renderScript, Element.DataType dataType, Element.DataKind dataKind) {
        Element.DataKind dataKind2;
        try {
            android.renderscript.RenderScript renderScript2 = ((hm) renderScript).O0000oO;
            Element.DataType O000000o2 = O000000o(dataType);
            switch (AnonymousClass1.f18972O000000o[dataKind.ordinal()]) {
                case 1:
                    dataKind2 = Element.DataKind.USER;
                    break;
                case 2:
                    dataKind2 = Element.DataKind.PIXEL_L;
                    break;
                case 3:
                    dataKind2 = Element.DataKind.PIXEL_A;
                    break;
                case 4:
                    dataKind2 = Element.DataKind.PIXEL_LA;
                    break;
                case 5:
                    dataKind2 = Element.DataKind.PIXEL_RGB;
                    break;
                case 6:
                    dataKind2 = Element.DataKind.PIXEL_RGBA;
                    break;
                case 7:
                    dataKind2 = Element.DataKind.PIXEL_DEPTH;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    dataKind2 = Element.DataKind.PIXEL_YUV;
                    break;
                default:
                    dataKind2 = null;
                    break;
            }
            return new hj(renderScript, android.renderscript.Element.createPixel(renderScript2, O000000o2, dataKind2));
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public final boolean O000000o(androidx.renderscript.Element element) {
        try {
            return ((hj) element).O00000oo.isCompatible(this.O00000oo);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ BaseObj O00000Oo() {
        return this.O00000oo;
    }
}
