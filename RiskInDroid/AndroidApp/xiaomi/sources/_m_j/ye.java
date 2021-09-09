package _m_j;

import com.drew.metadata.bmp.BmpHeaderDirectory;
import com.google.android.gms.common.internal.GmsLogger;
import java.text.DecimalFormat;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ye extends xx<BmpHeaderDirectory> {
    public ye(BmpHeaderDirectory bmpHeaderDirectory) {
        super(bmpHeaderDirectory);
    }

    public final String O000000o(int i) {
        BmpHeaderDirectory.BitmapType bitmapType;
        BmpHeaderDirectory.RenderingHalftoningAlgorithm renderingHalftoningAlgorithm;
        BmpHeaderDirectory.ColorEncoding colorEncoding;
        BmpHeaderDirectory.ColorSpaceType colorSpaceType;
        BmpHeaderDirectory.RenderingIntent renderingIntent;
        if (i == -2) {
            Integer O00000o0 = ((BmpHeaderDirectory) this.f2602O000000o).O00000o0(-2);
            if (O00000o0 == null) {
                bitmapType = null;
            } else {
                bitmapType = BmpHeaderDirectory.BitmapType.typeOf(O00000o0.intValue());
            }
            if (bitmapType == null) {
                return null;
            }
            return bitmapType.toString();
        } else if (i != 5) {
            switch (i) {
                case 10:
                    Integer O00000o02 = ((BmpHeaderDirectory) this.f2602O000000o).O00000o0(10);
                    if (O00000o02 == null) {
                        renderingHalftoningAlgorithm = null;
                    } else {
                        renderingHalftoningAlgorithm = BmpHeaderDirectory.RenderingHalftoningAlgorithm.typeOf(O00000o02.intValue());
                    }
                    if (renderingHalftoningAlgorithm == null) {
                        return null;
                    }
                    return renderingHalftoningAlgorithm.toString();
                case 11:
                    Integer O00000o03 = ((BmpHeaderDirectory) this.f2602O000000o).O00000o0(11);
                    if (O00000o03 == null) {
                        colorEncoding = null;
                    } else {
                        colorEncoding = BmpHeaderDirectory.ColorEncoding.typeOf(O00000o03.intValue());
                    }
                    if (colorEncoding == null) {
                        return null;
                    }
                    return colorEncoding.toString();
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                case 14:
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    Long O0000Oo = ((BmpHeaderDirectory) this.f2602O000000o).O0000Oo(i);
                    if (O0000Oo == null) {
                        return null;
                    }
                    return String.format("0x%08" + "X", Long.valueOf(O0000Oo.longValue()));
                case 16:
                    Long O0000Oo2 = ((BmpHeaderDirectory) this.f2602O000000o).O0000Oo(16);
                    if (O0000Oo2 == null) {
                        colorSpaceType = null;
                    } else {
                        colorSpaceType = BmpHeaderDirectory.ColorSpaceType.typeOf(O0000Oo2.longValue());
                    }
                    if (colorSpaceType == null) {
                        return null;
                    }
                    return colorSpaceType.toString();
                case 17:
                case 18:
                case 19:
                    Long O0000Oo3 = ((BmpHeaderDirectory) this.f2602O000000o).O0000Oo(i);
                    if (O0000Oo3 == null) {
                        return null;
                    }
                    double longValue = (double) O0000Oo3.longValue();
                    Double.isNaN(longValue);
                    return new DecimalFormat("0.###").format(Double.valueOf(longValue / 65536.0d));
                case 20:
                    Integer O00000o04 = ((BmpHeaderDirectory) this.f2602O000000o).O00000o0(20);
                    if (O00000o04 == null) {
                        renderingIntent = null;
                    } else {
                        renderingIntent = BmpHeaderDirectory.RenderingIntent.typeOf((long) O00000o04.intValue());
                    }
                    if (renderingIntent == null) {
                        return null;
                    }
                    return renderingIntent.toString();
                default:
                    return super.O000000o(i);
            }
        } else {
            BmpHeaderDirectory.Compression typeOf = BmpHeaderDirectory.Compression.typeOf((BmpHeaderDirectory) this.f2602O000000o);
            if (typeOf != null) {
                return typeOf.toString();
            }
            Integer O00000o05 = ((BmpHeaderDirectory) this.f2602O000000o).O00000o0(5);
            if (O00000o05 == null) {
                return null;
            }
            return "Illegal value 0x" + Integer.toHexString(O00000o05.intValue());
        }
    }
}
