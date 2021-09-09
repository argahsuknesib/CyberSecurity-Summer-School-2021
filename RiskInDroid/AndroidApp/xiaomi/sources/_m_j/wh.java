package _m_j;

import com.drew.imaging.FileType;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.tiff.TiffProcessingException;
import com.drew.metadata.MetadataException;
import com.drew.metadata.gif.GifControlDirectory;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class wh {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, byte]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, short]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.yf.O000000o(_m_j.xm, _m_j.xu, boolean):void
     arg types: [_m_j.xn, _m_j.xu, int]
     candidates:
      _m_j.yf.O000000o(_m_j.xm, com.drew.metadata.bmp.BmpHeaderDirectory, _m_j.xu):void
      _m_j.yf.O000000o(_m_j.xm, _m_j.xu, boolean):void */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r2.O000000o(new _m_j.xs("GIF did not had hasGlobalColorTable bit."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x057e, code lost:
        r2.O000000o(new _m_j.xs("IOException processing GIF data"));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0395 */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03a2 A[Catch:{ IOException -> 0x057e }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0428 A[Catch:{ IOException -> 0x057e }] */
    public static xu O000000o(InputStream inputStream, long j) throws ImageProcessingException, IOException {
        xu xuVar;
        Integer num;
        byte O00000Oo;
        xs xsVar;
        BufferedInputStream bufferedInputStream = (BufferedInputStream) inputStream;
        FileType O000000o2 = wg.O000000o(bufferedInputStream);
        int i = 6;
        int i2 = 5;
        int i3 = 0;
        switch (AnonymousClass1.f2574O000000o[O000000o2.ordinal()]) {
            case 1:
                xuVar = wj.O000000o(bufferedInputStream);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                xk xkVar = new xk(bufferedInputStream, j);
                xu xuVar2 = new xu();
                yw ywVar = new yw(xuVar2, null);
                new xb();
                xb.O000000o(xkVar, ywVar, 0);
                xuVar = xuVar2;
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                xuVar = new xu();
                new agr();
                agr.O000000o(new xn(bufferedInputStream), xuVar);
                break;
            case 9:
                xuVar = wu.O000000o(bufferedInputStream);
                break;
            case 10:
                xuVar = new xu();
                yf yfVar = new yf();
                xn xnVar = new xn(bufferedInputStream);
                xnVar.f2595O000000o = false;
                yfVar.O000000o((xm) xnVar, xuVar, true);
                break;
            case 11:
                xuVar = new xu();
                new aca();
                xn xnVar2 = new xn(bufferedInputStream);
                xnVar2.f2595O000000o = false;
                try {
                    abx abx = new abx();
                    if (!xnVar2.O00000Oo(3).equals("GIF")) {
                        abx.O000000o("Invalid GIF file signature");
                    } else {
                        String O00000Oo2 = xnVar2.O00000Oo(3);
                        if (O00000Oo2.equals("87a") || O00000Oo2.equals("89a")) {
                            abx.O000000o(1, O00000Oo2);
                            abx.O000000o(2, xnVar2.O00000oO());
                            abx.O000000o(3, xnVar2.O00000oO());
                            short O00000o = xnVar2.O00000o();
                            int i4 = 1 << ((O00000o & 7) + 1);
                            int i5 = ((O00000o & 112) >> 4) + 1;
                            boolean z = (O00000o >> 7) != 0;
                            abx.O000000o(4, i4);
                            if (O00000Oo2.equals("89a")) {
                                abx.O000000o(5, (O00000o & 8) != 0);
                            }
                            abx.O000000o(6, i5);
                            abx.O000000o(7, z);
                            abx.O000000o(8, (int) xnVar2.O00000o());
                            short O00000o2 = xnVar2.O00000o();
                            if (O00000o2 != 0) {
                                double d = (double) O00000o2;
                                Double.isNaN(d);
                                abx.O000000o(9, (float) ((d + 15.0d) / 64.0d));
                            }
                        } else {
                            abx.O000000o("Unexpected GIF version");
                        }
                    }
                    xuVar.O000000o(abx);
                    if (!(abx.O00000o0.size() > 0)) {
                        Boolean O0000OoO = abx.O0000OoO(7);
                        if (O0000OoO != null) {
                            if (O0000OoO.booleanValue()) {
                                num = abx.O00000o0(4);
                                if (num != null) {
                                    xnVar2.O000000o((long) (num.intValue() * 3));
                                }
                                while (true) {
                                    try {
                                        O00000Oo = xnVar2.O00000Oo();
                                        if (O00000Oo != 33) {
                                            byte O00000Oo3 = xnVar2.O00000Oo();
                                            short O00000o3 = xnVar2.O00000o();
                                            long O000000o3 = xnVar2.O000000o();
                                            if (O00000Oo3 == -7) {
                                                GifControlDirectory gifControlDirectory = new GifControlDirectory();
                                                short O00000o4 = xnVar2.O00000o();
                                                gifControlDirectory.O000000o(2, GifControlDirectory.DisposalMethod.typeOf((O00000o4 >> 2) & 7));
                                                gifControlDirectory.O000000o(3, ((O00000o4 & 2) >> 1) == 1);
                                                gifControlDirectory.O000000o(4, (O00000o4 & 1) == 1);
                                                gifControlDirectory.O000000o(1, xnVar2.O00000oO());
                                                gifControlDirectory.O000000o(i2, (int) xnVar2.O00000o());
                                                xnVar2.O000000o(1L);
                                                xuVar.O000000o(gifControlDirectory);
                                            } else if (O00000Oo3 == 1) {
                                                if (O00000o3 != 12) {
                                                    xsVar = new xs(String.format("Invalid GIF plain text block size. Expected 12, got %d.", Integer.valueOf(O00000o3)));
                                                } else {
                                                    xnVar2.O000000o(12L);
                                                    aca.O00000Oo(xnVar2);
                                                    xsVar = null;
                                                }
                                                if (xsVar != null) {
                                                    xuVar.O000000o(xsVar);
                                                }
                                            } else if (O00000Oo3 == -2) {
                                                xuVar.O000000o(new abu(new xv(aca.O000000o(xnVar2, O00000o3), xf.O00000o)));
                                            } else if (O00000Oo3 != -1) {
                                                xuVar.O000000o(new xs(String.format("Unsupported GIF extension block with type 0x%02X.", Byte.valueOf(O00000Oo3))));
                                            } else if (O00000o3 != 11) {
                                                xuVar.O000000o(new xs(String.format("Invalid GIF application extension block size. Expected 11, got %d.", Integer.valueOf(O00000o3))));
                                            } else {
                                                String str = new String(xnVar2.O000000o((int) O00000o3), xf.f2590O000000o);
                                                if (str.equals("XMP DataXMP")) {
                                                    byte[] O000000o4 = aca.O000000o(xnVar2);
                                                    new ahf();
                                                    ahf.O000000o(O000000o4, O000000o4.length - 257, xuVar, (xr) null);
                                                } else if (str.equals("ICCRGBG1012")) {
                                                    byte[] O000000o5 = aca.O000000o(xnVar2, xnVar2.O00000Oo() & 255);
                                                    if (O000000o5.length != 0) {
                                                        new acd();
                                                        acd.O000000o(new xc(O000000o5), xuVar, (xr) null);
                                                    }
                                                } else if (str.equals("NETSCAPE2.0")) {
                                                    xnVar2.O000000o(2L);
                                                    int O00000oO = xnVar2.O00000oO();
                                                    xnVar2.O000000o(1L);
                                                    abs abs = new abs();
                                                    abs.O000000o(1, O00000oO);
                                                    xuVar.O000000o(abs);
                                                } else {
                                                    aca.O00000Oo(xnVar2);
                                                }
                                            }
                                            long O000000o6 = (O000000o3 + ((long) O00000o3)) - xnVar2.O000000o();
                                            if (O000000o6 > 0) {
                                                xnVar2.O000000o(O000000o6);
                                            }
                                            i = 6;
                                            i2 = 5;
                                        } else if (O00000Oo != 44) {
                                            if (O00000Oo != 59) {
                                                xuVar.O000000o(new xs("Unknown gif block marker found."));
                                                break;
                                            }
                                        } else {
                                            abz abz = new abz();
                                            abz.O000000o(1, xnVar2.O00000oO());
                                            abz.O000000o(2, xnVar2.O00000oO());
                                            abz.O000000o(3, xnVar2.O00000oO());
                                            abz.O000000o(4, xnVar2.O00000oO());
                                            byte O00000Oo4 = xnVar2.O00000Oo();
                                            boolean z2 = (O00000Oo4 >> 7) != 0;
                                            boolean z3 = (O00000Oo4 & 64) != 0;
                                            abz.O000000o(i2, z2);
                                            abz.O000000o(i, z3);
                                            if (z2) {
                                                abz.O000000o(7, (O00000Oo4 & 32) != 0);
                                                byte b = O00000Oo4 & 7;
                                                abz.O000000o(8, b + 1);
                                                xnVar2.O000000o((long) ((2 << b) * 3));
                                            }
                                            xnVar2.O00000Oo();
                                            xuVar.O000000o(abz);
                                            aca.O00000Oo(xnVar2);
                                        }
                                    } catch (IOException unused) {
                                        break;
                                    }
                                }
                            }
                            num = null;
                            if (num != null) {
                            }
                            while (true) {
                                O00000Oo = xnVar2.O00000Oo();
                                if (O00000Oo != 33) {
                                }
                            }
                        } else {
                            Object O0000o0o = abx.O0000o0o(7);
                            if (O0000o0o == null) {
                                throw new MetadataException("Tag '" + abx.O0000o(7) + "' has not been set -- check using containsTag() first");
                            }
                            throw new MetadataException("Tag '7" + "' cannot be converted to a boolean.  It is of type '" + O0000o0o.getClass() + "'.");
                        }
                        break;
                    }
                } catch (IOException unused2) {
                    xuVar.O000000o(new xs("IOException processing GIF data"));
                    break;
                }
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                xuVar = new xu();
                new acg();
                acg.O000000o(new xn(bufferedInputStream), xuVar);
                break;
            case 13:
                xuVar = new xu();
                new agh();
                xn xnVar3 = new xn(bufferedInputStream);
                xnVar3.f2595O000000o = false;
                agg agg = new agg();
                xuVar.O000000o(agg);
                try {
                    if (xnVar3.O00000Oo() == 10) {
                        agg.O000000o(1, (int) xnVar3.O00000Oo());
                        if (xnVar3.O00000Oo() == 1) {
                            agg.O000000o(2, (int) xnVar3.O00000o());
                            agg.O000000o(3, xnVar3.O00000oO());
                            agg.O000000o(4, xnVar3.O00000oO());
                            agg.O000000o(5, xnVar3.O00000oO());
                            agg.O000000o(6, xnVar3.O00000oO());
                            agg.O000000o(7, xnVar3.O00000oO());
                            agg.O000000o(8, xnVar3.O00000oO());
                            agg.O000000o(9, xnVar3.O000000o(48));
                            xnVar3.O000000o(1L);
                            agg.O000000o(10, (int) xnVar3.O00000o());
                            agg.O000000o(11, xnVar3.O00000oO());
                            int O00000oO2 = xnVar3.O00000oO();
                            if (O00000oO2 != 0) {
                                agg.O000000o(12, O00000oO2);
                            }
                            int O00000oO3 = xnVar3.O00000oO();
                            if (O00000oO3 != 0) {
                                agg.O000000o(13, O00000oO3);
                            }
                            int O00000oO4 = xnVar3.O00000oO();
                            if (O00000oO4 != 0) {
                                agg.O000000o(14, O00000oO4);
                                break;
                            }
                        } else {
                            throw new ImageProcessingException("Invalid PCX encoding byte");
                        }
                    } else {
                        throw new ImageProcessingException("Invalid PCX identifier byte");
                    }
                } catch (Exception e) {
                    agg.O000000o("Exception reading PCX file metadata: " + e.getMessage());
                    break;
                }
                break;
            case 14:
                xuVar = new xu();
                new wy().O000000o(new xn(bufferedInputStream), new ahc(xuVar));
                break;
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                if (bufferedInputStream.markSupported()) {
                    bufferedInputStream.mark(512);
                    byte[] bArr = new byte[512];
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        bufferedInputStream.reset();
                        while (true) {
                            if (i3 < read - 2) {
                                if (bArr[i3] == -1 && bArr[i3 + 1] == -40 && bArr[i3 + 2] == -1) {
                                    long j2 = (long) i3;
                                    if (bufferedInputStream.skip(j2) != j2) {
                                        throw new IOException("Skipping stream bytes failed");
                                    }
                                } else {
                                    i3++;
                                }
                            }
                        }
                        xuVar = wj.O000000o(bufferedInputStream);
                        break;
                    } else {
                        throw new IOException("Stream is empty");
                    }
                } else {
                    throw new IOException("Stream must support mark/reset");
                }
                break;
            case 16:
                xuVar = new xu();
                new wy().O000000o(new xn(bufferedInputStream), new yd(xuVar));
                break;
            case 17:
                xuVar = new xu();
                new wy().O000000o(new xn(bufferedInputStream), new agz(xuVar));
                break;
            case 18:
                xuVar = new xu();
                ada ada = new ada(xuVar);
                xn xnVar4 = new xn(bufferedInputStream);
                xnVar4.f2595O000000o = true;
                ww.O000000o(xnVar4, -1, ada);
                break;
            case 19:
                xuVar = new xu();
                aew aew = new aew(xuVar);
                xn xnVar5 = new xn(bufferedInputStream);
                xnVar5.f2595O000000o = true;
                wo.O000000o(xnVar5, -1, aew);
                break;
            case 20:
                xuVar = new xu();
                yi yiVar = new yi();
                xk xkVar2 = new xk(bufferedInputStream);
                yh yhVar = new yh();
                xuVar.O000000o(yhVar);
                int O0000Oo0 = xkVar2.O0000Oo0(0);
                if (O0000Oo0 != -976170042) {
                    if (O0000Oo0 == 622940243) {
                        bufferedInputStream.reset();
                        yiVar.O000000o(yhVar, xuVar, new xn(bufferedInputStream));
                        break;
                    } else {
                        yhVar.O000000o("File type not supported.");
                        break;
                    }
                } else {
                    xkVar2.f2594O000000o = false;
                    int O0000Oo02 = xkVar2.O0000Oo0(4);
                    int O0000Oo03 = xkVar2.O0000Oo0(8);
                    int O0000Oo04 = xkVar2.O0000Oo0(12);
                    int O0000Oo05 = xkVar2.O0000Oo0(16);
                    int O0000Oo06 = xkVar2.O0000Oo0(20);
                    int O0000Oo07 = xkVar2.O0000Oo0(24);
                    if (O0000Oo07 != 0) {
                        yhVar.O000000o(32, O0000Oo07);
                        yhVar.O000000o(33, O0000Oo06);
                        try {
                            xc xcVar = new xc(xkVar2.O00000o0(O0000Oo06, O0000Oo07));
                            new xb();
                            xb.O000000o(xcVar, new ago(xuVar), 0);
                        } catch (TiffProcessingException e2) {
                            yhVar.O000000o("Unable to process TIFF data: " + e2.getMessage());
                        }
                    } else if (O0000Oo05 != 0) {
                        yhVar.O000000o(34, O0000Oo05);
                        yhVar.O000000o(35, O0000Oo04);
                    }
                    yiVar.O000000o(yhVar, xuVar, new xl(xkVar2.O00000o0(O0000Oo02, O0000Oo03)));
                    break;
                }
            case 21:
                throw new ImageProcessingException("File format could not be determined");
            default:
                xuVar = new xu();
                break;
        }
        xuVar.O000000o(new abq(O000000o2));
        return xuVar;
    }

    /* renamed from: _m_j.wh$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2574O000000o = new int[FileType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00da */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f2574O000000o[FileType.Jpeg.ordinal()] = 1;
            f2574O000000o[FileType.Tiff.ordinal()] = 2;
            f2574O000000o[FileType.Arw.ordinal()] = 3;
            f2574O000000o[FileType.Cr2.ordinal()] = 4;
            f2574O000000o[FileType.Nef.ordinal()] = 5;
            f2574O000000o[FileType.Orf.ordinal()] = 6;
            f2574O000000o[FileType.Rw2.ordinal()] = 7;
            f2574O000000o[FileType.Psd.ordinal()] = 8;
            f2574O000000o[FileType.Png.ordinal()] = 9;
            f2574O000000o[FileType.Bmp.ordinal()] = 10;
            f2574O000000o[FileType.Gif.ordinal()] = 11;
            f2574O000000o[FileType.Ico.ordinal()] = 12;
            f2574O000000o[FileType.Pcx.ordinal()] = 13;
            f2574O000000o[FileType.WebP.ordinal()] = 14;
            f2574O000000o[FileType.Raf.ordinal()] = 15;
            f2574O000000o[FileType.Avi.ordinal()] = 16;
            f2574O000000o[FileType.Wav.ordinal()] = 17;
            f2574O000000o[FileType.Mov.ordinal()] = 18;
            f2574O000000o[FileType.Mp4.ordinal()] = 19;
            f2574O000000o[FileType.Eps.ordinal()] = 20;
            try {
                f2574O000000o[FileType.Unknown.ordinal()] = 21;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
