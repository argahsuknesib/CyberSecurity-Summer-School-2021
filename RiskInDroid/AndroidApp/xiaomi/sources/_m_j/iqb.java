package _m_j;

import android.graphics.Matrix;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.yqritc.scalablevideoview.PivotPoint;
import com.yqritc.scalablevideoview.ScalableType;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class iqb {

    /* renamed from: O000000o  reason: collision with root package name */
    private iqc f1549O000000o;
    private iqc O00000Oo;

    public iqb(iqc iqc, iqc iqc2) {
        this.f1549O000000o = iqc;
        this.O00000Oo = iqc2;
    }

    public final Matrix O000000o(ScalableType scalableType) {
        switch (AnonymousClass1.f1550O000000o[scalableType.ordinal()]) {
            case 1:
                return O000000o();
            case 2:
                return O00000Oo();
            case 3:
                return O000000o(PivotPoint.CENTER);
            case 4:
                return O000000o(PivotPoint.LEFT_TOP);
            case 5:
                return O000000o(PivotPoint.RIGHT_BOTTOM);
            case 6:
                return O00000Oo(PivotPoint.LEFT_TOP);
            case 7:
                return O00000Oo(PivotPoint.LEFT_CENTER);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return O00000Oo(PivotPoint.LEFT_BOTTOM);
            case 9:
                return O00000Oo(PivotPoint.CENTER_TOP);
            case 10:
                return O00000Oo(PivotPoint.CENTER);
            case 11:
                return O00000Oo(PivotPoint.CENTER_BOTTOM);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return O00000Oo(PivotPoint.RIGHT_TOP);
            case 13:
                return O00000Oo(PivotPoint.RIGHT_CENTER);
            case 14:
                return O00000Oo(PivotPoint.RIGHT_BOTTOM);
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                return O00000o0(PivotPoint.LEFT_TOP);
            case 16:
                return O00000o0(PivotPoint.LEFT_CENTER);
            case 17:
                return O00000o0(PivotPoint.LEFT_BOTTOM);
            case 18:
                return O00000o0(PivotPoint.CENTER_TOP);
            case 19:
                return O00000o0(PivotPoint.CENTER);
            case 20:
                return O00000o0(PivotPoint.CENTER_BOTTOM);
            case 21:
                return O00000o0(PivotPoint.RIGHT_TOP);
            case 22:
                return O00000o0(PivotPoint.RIGHT_CENTER);
            case 23:
                return O00000o0(PivotPoint.RIGHT_BOTTOM);
            case 24:
                return O00000o0();
            case 25:
                return O00000o();
            case 26:
                return O00000oO();
            default:
                return null;
        }
    }

    private static Matrix O000000o(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    /* renamed from: _m_j.iqb$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1550O000000o = new int[ScalableType.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[PivotPoint.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(71:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|(3:87|88|90)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(78:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Can't wrap try/catch for region: R(80:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|90) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0081 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00bd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00f5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x010d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0119 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0131 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x013d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0149 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0155 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0161 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x016d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0179 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0185 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0191 */
        static {
            try {
                O00000Oo[PivotPoint.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[PivotPoint.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[PivotPoint.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[PivotPoint.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                O00000Oo[PivotPoint.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                O00000Oo[PivotPoint.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                O00000Oo[PivotPoint.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                O00000Oo[PivotPoint.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                O00000Oo[PivotPoint.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f1550O000000o[ScalableType.NONE.ordinal()] = 1;
            f1550O000000o[ScalableType.FIT_XY.ordinal()] = 2;
            f1550O000000o[ScalableType.FIT_CENTER.ordinal()] = 3;
            f1550O000000o[ScalableType.FIT_START.ordinal()] = 4;
            f1550O000000o[ScalableType.FIT_END.ordinal()] = 5;
            f1550O000000o[ScalableType.LEFT_TOP.ordinal()] = 6;
            f1550O000000o[ScalableType.LEFT_CENTER.ordinal()] = 7;
            f1550O000000o[ScalableType.LEFT_BOTTOM.ordinal()] = 8;
            f1550O000000o[ScalableType.CENTER_TOP.ordinal()] = 9;
            f1550O000000o[ScalableType.CENTER.ordinal()] = 10;
            f1550O000000o[ScalableType.CENTER_BOTTOM.ordinal()] = 11;
            f1550O000000o[ScalableType.RIGHT_TOP.ordinal()] = 12;
            f1550O000000o[ScalableType.RIGHT_CENTER.ordinal()] = 13;
            f1550O000000o[ScalableType.RIGHT_BOTTOM.ordinal()] = 14;
            f1550O000000o[ScalableType.LEFT_TOP_CROP.ordinal()] = 15;
            f1550O000000o[ScalableType.LEFT_CENTER_CROP.ordinal()] = 16;
            f1550O000000o[ScalableType.LEFT_BOTTOM_CROP.ordinal()] = 17;
            f1550O000000o[ScalableType.CENTER_TOP_CROP.ordinal()] = 18;
            f1550O000000o[ScalableType.CENTER_CROP.ordinal()] = 19;
            f1550O000000o[ScalableType.CENTER_BOTTOM_CROP.ordinal()] = 20;
            f1550O000000o[ScalableType.RIGHT_TOP_CROP.ordinal()] = 21;
            f1550O000000o[ScalableType.RIGHT_CENTER_CROP.ordinal()] = 22;
            f1550O000000o[ScalableType.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            f1550O000000o[ScalableType.START_INSIDE.ordinal()] = 24;
            f1550O000000o[ScalableType.CENTER_INSIDE.ordinal()] = 25;
            try {
                f1550O000000o[ScalableType.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private Matrix O000000o(float f, float f2, PivotPoint pivotPoint) {
        switch (AnonymousClass1.O00000Oo[pivotPoint.ordinal()]) {
            case 1:
                return O000000o(f, f2, 0.0f, 0.0f);
            case 2:
                return O000000o(f, f2, 0.0f, ((float) this.f1549O000000o.O00000Oo) / 2.0f);
            case 3:
                return O000000o(f, f2, 0.0f, (float) this.f1549O000000o.O00000Oo);
            case 4:
                return O000000o(f, f2, ((float) this.f1549O000000o.f1551O000000o) / 2.0f, 0.0f);
            case 5:
                return O000000o(f, f2, ((float) this.f1549O000000o.f1551O000000o) / 2.0f, ((float) this.f1549O000000o.O00000Oo) / 2.0f);
            case 6:
                return O000000o(f, f2, ((float) this.f1549O000000o.f1551O000000o) / 2.0f, (float) this.f1549O000000o.O00000Oo);
            case 7:
                return O000000o(f, f2, (float) this.f1549O000000o.f1551O000000o, 0.0f);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return O000000o(f, f2, (float) this.f1549O000000o.f1551O000000o, ((float) this.f1549O000000o.O00000Oo) / 2.0f);
            case 9:
                return O000000o(f, f2, (float) this.f1549O000000o.f1551O000000o, (float) this.f1549O000000o.O00000Oo);
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix O000000o() {
        return O000000o(((float) this.O00000Oo.f1551O000000o) / ((float) this.f1549O000000o.f1551O000000o), ((float) this.O00000Oo.O00000Oo) / ((float) this.f1549O000000o.O00000Oo), PivotPoint.LEFT_TOP);
    }

    private Matrix O000000o(PivotPoint pivotPoint) {
        float f = ((float) this.f1549O000000o.f1551O000000o) / ((float) this.O00000Oo.f1551O000000o);
        float f2 = ((float) this.f1549O000000o.O00000Oo) / ((float) this.O00000Oo.O00000Oo);
        float min = Math.min(f, f2);
        return O000000o(min / f, min / f2, pivotPoint);
    }

    private Matrix O00000Oo() {
        return O000000o(1.0f, 1.0f, PivotPoint.LEFT_TOP);
    }

    private Matrix O00000Oo(PivotPoint pivotPoint) {
        return O000000o(((float) this.O00000Oo.f1551O000000o) / ((float) this.f1549O000000o.f1551O000000o), ((float) this.O00000Oo.O00000Oo) / ((float) this.f1549O000000o.O00000Oo), pivotPoint);
    }

    private Matrix O00000o0(PivotPoint pivotPoint) {
        float f = ((float) this.f1549O000000o.f1551O000000o) / ((float) this.O00000Oo.f1551O000000o);
        float f2 = ((float) this.f1549O000000o.O00000Oo) / ((float) this.O00000Oo.O00000Oo);
        float max = Math.max(f, f2);
        return O000000o(max / f, max / f2, pivotPoint);
    }

    private Matrix O00000o0() {
        return (this.O00000Oo.O00000Oo > this.f1549O000000o.f1551O000000o || this.O00000Oo.O00000Oo > this.f1549O000000o.O00000Oo) ? O000000o(PivotPoint.LEFT_TOP) : O00000Oo(PivotPoint.LEFT_TOP);
    }

    private Matrix O00000o() {
        return (this.O00000Oo.O00000Oo > this.f1549O000000o.f1551O000000o || this.O00000Oo.O00000Oo > this.f1549O000000o.O00000Oo) ? O000000o(PivotPoint.CENTER) : O00000Oo(PivotPoint.CENTER);
    }

    private Matrix O00000oO() {
        return (this.O00000Oo.O00000Oo > this.f1549O000000o.f1551O000000o || this.O00000Oo.O00000Oo > this.f1549O000000o.O00000Oo) ? O000000o(PivotPoint.RIGHT_BOTTOM) : O00000Oo(PivotPoint.RIGHT_BOTTOM);
    }
}
