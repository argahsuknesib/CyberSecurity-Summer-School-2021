package com.drew.metadata.bmp;

import _m_j.xr;
import _m_j.ye;
import com.google.android.exoplayer2.C;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class BmpHeaderDirectory extends xr {
    protected static final HashMap<Integer, String> O0000O0o;

    public final String O000000o() {
        return "BMP Header";
    }

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        O0000O0o = hashMap;
        hashMap.put(-2, "Bitmap type");
        O0000O0o.put(-1, "Header Size");
        O0000O0o.put(1, "Image Height");
        O0000O0o.put(2, "Image Width");
        O0000O0o.put(3, "Planes");
        O0000O0o.put(4, "Bits Per Pixel");
        O0000O0o.put(5, "Compression");
        O0000O0o.put(6, "X Pixels per Meter");
        O0000O0o.put(7, "Y Pixels per Meter");
        O0000O0o.put(8, "Palette Colour Count");
        O0000O0o.put(9, "Important Colour Count");
        O0000O0o.put(10, "Rendering");
        O0000O0o.put(11, "Color Encoding");
        O0000O0o.put(12, "Red Mask");
        O0000O0o.put(13, "Green Mask");
        O0000O0o.put(14, "Blue Mask");
        O0000O0o.put(15, "Alpha Mask");
        O0000O0o.put(16, "Color Space Type");
        O0000O0o.put(17, "Red Gamma Curve");
        O0000O0o.put(18, "Green Gamma Curve");
        O0000O0o.put(19, "Blue Gamma Curve");
        O0000O0o.put(20, "Rendering Intent");
        O0000O0o.put(21, "Linked Profile File Name");
    }

    public BmpHeaderDirectory() {
        O000000o(new ye(this));
    }

    public final HashMap<Integer, String> O00000Oo() {
        return O0000O0o;
    }

    public enum BitmapType {
        BITMAP(19778),
        OS2_BITMAP_ARRAY(16706),
        OS2_ICON(17225),
        OS2_COLOR_ICON(18755),
        OS2_COLOR_POINTER(20547),
        OS2_POINTER(21584);
        
        private final int value;

        private BitmapType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static BitmapType typeOf(int i) {
            for (BitmapType bitmapType : values()) {
                if (bitmapType.value == i) {
                    return bitmapType;
                }
            }
            return null;
        }

        public final String toString() {
            switch (this) {
                case BITMAP:
                    return "Standard";
                case OS2_BITMAP_ARRAY:
                    return "Bitmap Array";
                case OS2_COLOR_ICON:
                    return "Color Icon";
                case OS2_COLOR_POINTER:
                    return "Color Pointer";
                case OS2_ICON:
                    return "Monochrome Icon";
                case OS2_POINTER:
                    return "Monochrome Pointer";
                default:
                    throw new IllegalStateException("Unimplemented bitmap type " + super.toString());
            }
        }
    }

    public enum Compression {
        BI_RGB(0),
        BI_RLE8(1),
        BI_RLE4(2),
        BI_BITFIELDS(3),
        BI_HUFFMAN_1D(3),
        BI_JPEG(4),
        BI_RLE24(4),
        BI_PNG(5),
        BI_ALPHABITFIELDS(6),
        BI_CMYK(11),
        BI_CMYKRLE8(12),
        BI_CMYKRLE4(13);
        
        private final int value;

        private Compression(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static Compression typeOf(BmpHeaderDirectory bmpHeaderDirectory) {
            Integer O00000o0;
            Integer O00000o02 = bmpHeaderDirectory.O00000o0(5);
            if (O00000o02 == null || (O00000o0 = bmpHeaderDirectory.O00000o0(-1)) == null) {
                return null;
            }
            return typeOf(O00000o02.intValue(), O00000o0.intValue());
        }

        public static Compression typeOf(int i, int i2) {
            switch (i) {
                case 0:
                    return BI_RGB;
                case 1:
                    return BI_RLE8;
                case 2:
                    return BI_RLE4;
                case 3:
                    return i2 == 64 ? BI_HUFFMAN_1D : BI_BITFIELDS;
                case 4:
                    return i2 == 64 ? BI_RLE24 : BI_JPEG;
                case 5:
                    return BI_PNG;
                case 6:
                    return BI_ALPHABITFIELDS;
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                case 9:
                case 10:
                default:
                    return null;
                case 11:
                    return BI_CMYK;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return BI_CMYKRLE8;
                case 13:
                    return BI_CMYKRLE4;
            }
        }

        public final String toString() {
            switch (AnonymousClass1.O00000Oo[ordinal()]) {
                case 1:
                    return "None";
                case 2:
                    return "RLE 8-bit/pixel";
                case 3:
                    return "RLE 4-bit/pixel";
                case 4:
                    return "Bit Fields";
                case 5:
                    return "Huffman 1D";
                case 6:
                    return "JPEG";
                case 7:
                    return "RLE 24-bit/pixel";
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    return "PNG";
                case 9:
                    return "RGBA Bit Fields";
                case 10:
                    return "CMYK Uncompressed";
                case 11:
                    return "CMYK RLE-8";
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return "CMYK RLE-4";
                default:
                    throw new IllegalStateException("Unimplemented compression type " + super.toString());
            }
        }
    }

    public enum RenderingHalftoningAlgorithm {
        NONE(0),
        ERROR_DIFFUSION(1),
        PANDA(2),
        SUPER_CIRCLE(3);
        
        private final int value;

        private RenderingHalftoningAlgorithm(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static RenderingHalftoningAlgorithm typeOf(int i) {
            for (RenderingHalftoningAlgorithm renderingHalftoningAlgorithm : values()) {
                if (renderingHalftoningAlgorithm.value == i) {
                    return renderingHalftoningAlgorithm;
                }
            }
            return null;
        }

        public final String toString() {
            int i = AnonymousClass1.O00000o0[ordinal()];
            if (i == 1) {
                return "No Halftoning Algorithm";
            }
            if (i == 2) {
                return "Error Diffusion Halftoning";
            }
            if (i == 3) {
                return "Processing Algorithm for Noncoded Document Acquisition";
            }
            if (i == 4) {
                return "Super-circle Halftoning";
            }
            throw new IllegalStateException("Unimplemented rendering halftoning algorithm type " + super.toString());
        }
    }

    public enum ColorEncoding {
        RGB(0);
        
        private final int value;

        private ColorEncoding(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static ColorEncoding typeOf(int i) {
            if (i == 0) {
                return RGB;
            }
            return null;
        }
    }

    public enum ColorSpaceType {
        LCS_CALIBRATED_RGB(0),
        LCS_sRGB(1934772034),
        LCS_WINDOWS_COLOR_SPACE(1466527264),
        PROFILE_LINKED(1279872587),
        PROFILE_EMBEDDED(1296188740);
        
        private final long value;

        private ColorSpaceType(long j) {
            this.value = j;
        }

        public final long getValue() {
            return this.value;
        }

        public static ColorSpaceType typeOf(long j) {
            for (ColorSpaceType colorSpaceType : values()) {
                if (colorSpaceType.value == j) {
                    return colorSpaceType;
                }
            }
            return null;
        }

        public final String toString() {
            int i = AnonymousClass1.O00000o[ordinal()];
            if (i == 1) {
                return "Calibrated RGB";
            }
            if (i == 2) {
                return "sRGB Color Space";
            }
            if (i == 3) {
                return "System Default Color Space, sRGB";
            }
            if (i == 4) {
                return "Linked Profile";
            }
            if (i == 5) {
                return "Embedded Profile";
            }
            throw new IllegalStateException("Unimplemented color space type " + super.toString());
        }
    }

    public enum RenderingIntent {
        LCS_GM_BUSINESS(1),
        LCS_GM_GRAPHICS(2),
        LCS_GM_IMAGES(4),
        LCS_GM_ABS_COLORIMETRIC(8);
        
        private final int value;

        private RenderingIntent(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public static RenderingIntent typeOf(long j) {
            for (RenderingIntent renderingIntent : values()) {
                if (((long) renderingIntent.value) == j) {
                    return renderingIntent;
                }
            }
            return null;
        }

        public final String toString() {
            int i = AnonymousClass1.O00000oO[ordinal()];
            if (i == 1) {
                return "Graphic, Saturation";
            }
            if (i == 2) {
                return "Proof, Relative Colorimetric";
            }
            if (i == 3) {
                return "Picture, Perceptual";
            }
            if (i == 4) {
                return "Match, Absolute Colorimetric";
            }
            throw new IllegalStateException("Unimplemented rendering intent " + super.toString());
        }
    }

    /* renamed from: com.drew.metadata.bmp.BmpHeaderDirectory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] O00000Oo = new int[Compression.values().length];
        static final /* synthetic */ int[] O00000o = new int[ColorSpaceType.values().length];
        static final /* synthetic */ int[] O00000o0 = new int[RenderingHalftoningAlgorithm.values().length];
        static final /* synthetic */ int[] O00000oO = new int[RenderingIntent.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|(3:79|80|82)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(67:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00ff */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x010b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0117 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0123 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0142 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x014c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0156 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0160 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x016a */
        static {
            try {
                O00000oO[RenderingIntent.LCS_GM_BUSINESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000oO[RenderingIntent.LCS_GM_GRAPHICS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000oO[RenderingIntent.LCS_GM_IMAGES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000oO[RenderingIntent.LCS_GM_ABS_COLORIMETRIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            O00000o[ColorSpaceType.LCS_CALIBRATED_RGB.ordinal()] = 1;
            O00000o[ColorSpaceType.LCS_sRGB.ordinal()] = 2;
            O00000o[ColorSpaceType.LCS_WINDOWS_COLOR_SPACE.ordinal()] = 3;
            try {
                O00000o[ColorSpaceType.PROFILE_LINKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                O00000o[ColorSpaceType.PROFILE_EMBEDDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            O00000o0[RenderingHalftoningAlgorithm.NONE.ordinal()] = 1;
            O00000o0[RenderingHalftoningAlgorithm.ERROR_DIFFUSION.ordinal()] = 2;
            O00000o0[RenderingHalftoningAlgorithm.PANDA.ordinal()] = 3;
            try {
                O00000o0[RenderingHalftoningAlgorithm.SUPER_CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            O00000Oo[Compression.BI_RGB.ordinal()] = 1;
            O00000Oo[Compression.BI_RLE8.ordinal()] = 2;
            O00000Oo[Compression.BI_RLE4.ordinal()] = 3;
            O00000Oo[Compression.BI_BITFIELDS.ordinal()] = 4;
            try {
                O00000Oo[Compression.BI_HUFFMAN_1D.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            O00000Oo[Compression.BI_JPEG.ordinal()] = 6;
            O00000Oo[Compression.BI_RLE24.ordinal()] = 7;
            O00000Oo[Compression.BI_PNG.ordinal()] = 8;
            O00000Oo[Compression.BI_ALPHABITFIELDS.ordinal()] = 9;
            O00000Oo[Compression.BI_CMYK.ordinal()] = 10;
            O00000Oo[Compression.BI_CMYKRLE8.ordinal()] = 11;
            O00000Oo[Compression.BI_CMYKRLE4.ordinal()] = 12;
            f3581O000000o = new int[BitmapType.values().length];
            f3581O000000o[BitmapType.BITMAP.ordinal()] = 1;
            f3581O000000o[BitmapType.OS2_BITMAP_ARRAY.ordinal()] = 2;
            f3581O000000o[BitmapType.OS2_COLOR_ICON.ordinal()] = 3;
            f3581O000000o[BitmapType.OS2_COLOR_POINTER.ordinal()] = 4;
            f3581O000000o[BitmapType.OS2_ICON.ordinal()] = 5;
            try {
                f3581O000000o[BitmapType.OS2_POINTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
