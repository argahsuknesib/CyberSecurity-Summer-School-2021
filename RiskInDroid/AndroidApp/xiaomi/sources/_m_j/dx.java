package _m_j;

import android.content.res.AssetManager;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class dx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int[] f15016O000000o = {8, 8, 8};
    public static final int[] O00000Oo = {4};
    static final byte[] O00000o = {-1, -40, -1};
    public static final int[] O00000o0 = {8};
    static final String[] O00000oO = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] O00000oo = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] O0000O0o = {65, 83, 67, 73, 73, 0, 0, 0};
    static final O00000o[][] O0000OOo;
    static final byte[] O0000Oo = "Exif\u0000\u0000".getBytes(O0000Oo0);
    static final Charset O0000Oo0 = Charset.forName("US-ASCII");
    private static final List<Integer> O0000OoO = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> O0000Ooo = Arrays.asList(2, 7, 4, 5);
    private static final O00000o[] O0000o = {new O00000o("ExposureTime", 33434, 5), new O00000o("FNumber", 33437, 5), new O00000o("ExposureProgram", 34850, 3), new O00000o("SpectralSensitivity", 34852, 2), new O00000o("PhotographicSensitivity", 34855, 3), new O00000o("OECF", 34856, 7), new O00000o("ExifVersion", 36864, 2), new O00000o("DateTimeOriginal", 36867, 2), new O00000o("DateTimeDigitized", 36868, 2), new O00000o("ComponentsConfiguration", 37121, 7), new O00000o("CompressedBitsPerPixel", 37122, 5), new O00000o("ShutterSpeedValue", 37377, 10), new O00000o("ApertureValue", 37378, 5), new O00000o("BrightnessValue", 37379, 10), new O00000o("ExposureBiasValue", 37380, 10), new O00000o("MaxApertureValue", 37381, 5), new O00000o("SubjectDistance", 37382, 5), new O00000o("MeteringMode", 37383, 3), new O00000o("LightSource", 37384, 3), new O00000o("Flash", 37385, 3), new O00000o("FocalLength", 37386, 5), new O00000o("SubjectArea", 37396, 3), new O00000o("MakerNote", 37500, 7), new O00000o("UserComment", 37510, 7), new O00000o("SubSecTime", 37520, 2), new O00000o("SubSecTimeOriginal", 37521, 2), new O00000o("SubSecTimeDigitized", 37522, 2), new O00000o("FlashpixVersion", 40960, 7), new O00000o("ColorSpace", 40961, 3), new O00000o("PixelXDimension", 40962), new O00000o("PixelYDimension", 40963), new O00000o("RelatedSoundFile", 40964, 2), new O00000o("InteroperabilityIFDPointer", 40965, 4), new O00000o("FlashEnergy", 41483, 5), new O00000o("SpatialFrequencyResponse", 41484, 7), new O00000o("FocalPlaneXResolution", 41486, 5), new O00000o("FocalPlaneYResolution", 41487, 5), new O00000o("FocalPlaneResolutionUnit", 41488, 3), new O00000o("SubjectLocation", 41492, 3), new O00000o("ExposureIndex", 41493, 5), new O00000o("SensingMethod", 41495, 3), new O00000o("FileSource", 41728, 7), new O00000o("SceneType", 41729, 7), new O00000o("CFAPattern", 41730, 7), new O00000o("CustomRendered", 41985, 3), new O00000o("ExposureMode", 41986, 3), new O00000o("WhiteBalance", 41987, 3), new O00000o("DigitalZoomRatio", 41988, 5), new O00000o("FocalLengthIn35mmFilm", 41989, 3), new O00000o("SceneCaptureType", 41990, 3), new O00000o("GainControl", 41991, 3), new O00000o("Contrast", 41992, 3), new O00000o("Saturation", 41993, 3), new O00000o("Sharpness", 41994, 3), new O00000o("DeviceSettingDescription", 41995, 7), new O00000o("SubjectDistanceRange", 41996, 3), new O00000o("ImageUniqueID", 42016, 2), new O00000o("DNGVersion", 50706, 1), new O00000o("DefaultCropSize", 50720)};
    private static final byte[] O0000o0 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] O0000o00 = {79, 76, 89, 77, 80, 0};
    private static SimpleDateFormat O0000o0O;
    private static final O00000o[] O0000o0o = {new O00000o("NewSubfileType", 254, 4), new O00000o("SubfileType", 255, 4), new O00000o("ImageWidth", 256), new O00000o("ImageLength", 257), new O00000o("BitsPerSample", 258, 3), new O00000o("Compression", 259, 3), new O00000o("PhotometricInterpretation", 262, 3), new O00000o("ImageDescription", 270, 2), new O00000o("Make", 271, 2), new O00000o("Model", 272, 2), new O00000o("StripOffsets", 273), new O00000o("Orientation", 274, 3), new O00000o("SamplesPerPixel", 277, 3), new O00000o("RowsPerStrip", 278), new O00000o("StripByteCounts", 279), new O00000o("XResolution", 282, 5), new O00000o("YResolution", 283, 5), new O00000o("PlanarConfiguration", 284, 3), new O00000o("ResolutionUnit", 296, 3), new O00000o("TransferFunction", 301, 3), new O00000o("Software", 305, 2), new O00000o("DateTime", 306, 2), new O00000o("Artist", 315, 2), new O00000o("WhitePoint", 318, 5), new O00000o("PrimaryChromaticities", 319, 5), new O00000o("SubIFDPointer", 330, 4), new O00000o("JPEGInterchangeFormat", 513, 4), new O00000o("JPEGInterchangeFormatLength", 514, 4), new O00000o("YCbCrCoefficients", 529, 5), new O00000o("YCbCrSubSampling", 530, 3), new O00000o("YCbCrPositioning", 531, 3), new O00000o("ReferenceBlackWhite", 532, 5), new O00000o("Copyright", 33432, 2), new O00000o("ExifIFDPointer", 34665, 4), new O00000o("GPSInfoIFDPointer", 34853, 4), new O00000o("SensorTopBorder", 4, 4), new O00000o("SensorLeftBorder", 5, 4), new O00000o("SensorBottomBorder", 6, 4), new O00000o("SensorRightBorder", 7, 4), new O00000o("ISO", 23, 3), new O00000o("JpgFromRaw", 46, 7)};
    private static final O00000o[] O0000oO = {new O00000o("InteroperabilityIndex", 1, 2)};
    private static final O00000o[] O0000oO0 = {new O00000o("GPSVersionID", 0, 1), new O00000o("GPSLatitudeRef", 1, 2), new O00000o("GPSLatitude", 2, 5), new O00000o("GPSLongitudeRef", 3, 2), new O00000o("GPSLongitude", 4, 5), new O00000o("GPSAltitudeRef", 5, 1), new O00000o("GPSAltitude", 6, 5), new O00000o("GPSTimeStamp", 7, 5), new O00000o("GPSSatellites", 8, 2), new O00000o("GPSStatus", 9, 2), new O00000o("GPSMeasureMode", 10, 2), new O00000o("GPSDOP", 11, 5), new O00000o("GPSSpeedRef", 12, 2), new O00000o("GPSSpeed", 13, 5), new O00000o("GPSTrackRef", 14, 2), new O00000o("GPSTrack", 15, 5), new O00000o("GPSImgDirectionRef", 16, 2), new O00000o("GPSImgDirection", 17, 5), new O00000o("GPSMapDatum", 18, 2), new O00000o("GPSDestLatitudeRef", 19, 2), new O00000o("GPSDestLatitude", 20, 5), new O00000o("GPSDestLongitudeRef", 21, 2), new O00000o("GPSDestLongitude", 22, 5), new O00000o("GPSDestBearingRef", 23, 2), new O00000o("GPSDestBearing", 24, 5), new O00000o("GPSDestDistanceRef", 25, 2), new O00000o("GPSDestDistance", 26, 5), new O00000o("GPSProcessingMethod", 27, 7), new O00000o("GPSAreaInformation", 28, 7), new O00000o("GPSDateStamp", 29, 2), new O00000o("GPSDifferential", 30, 3)};
    private static final O00000o[] O0000oOO = {new O00000o("NewSubfileType", 254, 4), new O00000o("SubfileType", 255, 4), new O00000o("ThumbnailImageWidth", 256), new O00000o("ThumbnailImageLength", 257), new O00000o("BitsPerSample", 258, 3), new O00000o("Compression", 259, 3), new O00000o("PhotometricInterpretation", 262, 3), new O00000o("ImageDescription", 270, 2), new O00000o("Make", 271, 2), new O00000o("Model", 272, 2), new O00000o("StripOffsets", 273), new O00000o("Orientation", 274, 3), new O00000o("SamplesPerPixel", 277, 3), new O00000o("RowsPerStrip", 278), new O00000o("StripByteCounts", 279), new O00000o("XResolution", 282, 5), new O00000o("YResolution", 283, 5), new O00000o("PlanarConfiguration", 284, 3), new O00000o("ResolutionUnit", 296, 3), new O00000o("TransferFunction", 301, 3), new O00000o("Software", 305, 2), new O00000o("DateTime", 306, 2), new O00000o("Artist", 315, 2), new O00000o("WhitePoint", 318, 5), new O00000o("PrimaryChromaticities", 319, 5), new O00000o("SubIFDPointer", 330, 4), new O00000o("JPEGInterchangeFormat", 513, 4), new O00000o("JPEGInterchangeFormatLength", 514, 4), new O00000o("YCbCrCoefficients", 529, 5), new O00000o("YCbCrSubSampling", 530, 3), new O00000o("YCbCrPositioning", 531, 3), new O00000o("ReferenceBlackWhite", 532, 5), new O00000o("Copyright", 33432, 2), new O00000o("ExifIFDPointer", 34665, 4), new O00000o("GPSInfoIFDPointer", 34853, 4), new O00000o("DNGVersion", 50706, 1), new O00000o("DefaultCropSize", 50720)};
    private static final O00000o O0000oOo = new O00000o("StripOffsets", 273, 3);
    private static final O00000o[] O0000oo = {new O00000o("PreviewImageStart", 257, 4), new O00000o("PreviewImageLength", 258, 4)};
    private static final O00000o[] O0000oo0 = {new O00000o("ThumbnailImage", 256, 7), new O00000o("CameraSettingsIFDPointer", 8224, 4), new O00000o("ImageProcessingIFDPointer", 8256, 4)};
    private static final O00000o[] O0000ooO = {new O00000o("AspectFrame", 4371, 3)};
    private static final O00000o[] O0000ooo = {new O00000o("ColorSpace", 55, 3)};
    private static final O00000o O000O00o = new O00000o("JPEGInterchangeFormatLength", 514, 4);
    private static final HashMap<Integer, O00000o>[] O000O0OO;
    private static final HashMap<String, O00000o>[] O000O0Oo;
    private static final HashMap<Integer, Integer> O000O0o0 = new HashMap<>();
    private static final Pattern O000OoO = Pattern.compile(".*[1-9].*");
    private static final Pattern O000OoOO = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    private static final HashSet<String> O00oOoOo = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    private static final O00000o[] O00oOooO = {new O00000o("SubIFDPointer", 330, 4), new O00000o("ExifIFDPointer", 34665, 4), new O00000o("GPSInfoIFDPointer", 34853, 4), new O00000o("InteroperabilityIFDPointer", 40965, 4), new O00000o("CameraSettingsIFDPointer", 8224, 1), new O00000o("ImageProcessingIFDPointer", 8256, 1)};
    private static final O00000o O00oOooo = new O00000o("JPEGInterchangeFormat", 513, 4);
    private final String O000O0o;
    private final AssetManager.AssetInputStream O000O0oO;
    private int O000O0oo;
    private ByteOrder O000OO;
    private final HashMap<String, O00000o0>[] O000OO00;
    private Set<Integer> O000OO0o;
    private boolean O000OOOo;
    private int O000OOo;
    private int O000OOo0;
    private byte[] O000OOoO;
    private int O000OOoo;
    private int O000Oo0;
    private int O000Oo00;
    private int O000Oo0O;
    private int O000Oo0o;
    private int O000OoO0;
    private boolean O00O0Oo;

    static {
        O00000o[] o00000oArr = O0000o0o;
        O0000OOo = new O00000o[][]{o00000oArr, O0000o, O0000oO0, O0000oO, O0000oOO, o00000oArr, O0000oo0, O0000oo, O0000ooO, O0000ooo};
        O00000o[][] o00000oArr2 = O0000OOo;
        O000O0OO = new HashMap[o00000oArr2.length];
        O000O0Oo = new HashMap[o00000oArr2.length];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        O0000o0O = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < O0000OOo.length; i++) {
            O000O0OO[i] = new HashMap<>();
            O000O0Oo[i] = new HashMap<>();
            for (O00000o o00000o : O0000OOo[i]) {
                O000O0OO[i].put(Integer.valueOf(o00000o.f15019O000000o), o00000o);
                O000O0Oo[i].put(o00000o.O00000Oo, o00000o);
            }
        }
        O000O0o0.put(Integer.valueOf(O00oOooO[0].f15019O000000o), 5);
        O000O0o0.put(Integer.valueOf(O00oOooO[1].f15019O000000o), 1);
        O000O0o0.put(Integer.valueOf(O00oOooO[2].f15019O000000o), 2);
        O000O0o0.put(Integer.valueOf(O00oOooO[3].f15019O000000o), 3);
        O000O0o0.put(Integer.valueOf(O00oOooO[4].f15019O000000o), 7);
        O000O0o0.put(Integer.valueOf(O00oOooO[5].f15019O000000o), 8);
    }

    static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final long f15021O000000o;
        public final long O00000Oo;

        O0000O0o(double d) {
            this((long) (d * 10000.0d), 10000);
        }

        O0000O0o(long j, long j2) {
            if (j2 == 0) {
                this.f15021O000000o = 0;
                this.O00000Oo = 1;
                return;
            }
            this.f15021O000000o = j;
            this.O00000Oo = j2;
        }

        public final String toString() {
            return this.f15021O000000o + "/" + this.O00000Oo;
        }

        public final double O000000o() {
            double d = (double) this.f15021O000000o;
            double d2 = (double) this.O00000Oo;
            Double.isNaN(d);
            Double.isNaN(d2);
            return d / d2;
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f15020O000000o;
        public final int O00000Oo;
        public final byte[] O00000o0;

        O00000o0(int i, int i2, byte[] bArr) {
            this.f15020O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = bArr;
        }

        public static O00000o0 O000000o(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(dx.O00000oo[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new O00000o0(3, iArr.length, wrap.array());
        }

        public static O00000o0 O000000o(int i, ByteOrder byteOrder) {
            return O000000o(new int[]{i}, byteOrder);
        }

        public static O00000o0 O000000o(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(dx.O00000oo[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new O00000o0(4, jArr.length, wrap.array());
        }

        public static O00000o0 O000000o(long j, ByteOrder byteOrder) {
            return O000000o(new long[]{j}, byteOrder);
        }

        public static O00000o0 O00000Oo(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(dx.O00000oo[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new O00000o0(9, iArr.length, wrap.array());
        }

        public static O00000o0 O000000o(String str) {
            byte[] bytes = (str + 0).getBytes(dx.O0000Oo0);
            return new O00000o0(2, bytes.length, bytes);
        }

        public static O00000o0 O000000o(O0000O0o[] o0000O0oArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(dx.O00000oo[5] * o0000O0oArr.length)]);
            wrap.order(byteOrder);
            for (O0000O0o o0000O0o : o0000O0oArr) {
                wrap.putInt((int) o0000O0o.f15021O000000o);
                wrap.putInt((int) o0000O0o.O00000Oo);
            }
            return new O00000o0(5, o0000O0oArr.length, wrap.array());
        }

        public static O00000o0 O000000o(O0000O0o o0000O0o, ByteOrder byteOrder) {
            return O000000o(new O0000O0o[]{o0000O0o}, byteOrder);
        }

        public static O00000o0 O00000Oo(O0000O0o[] o0000O0oArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(dx.O00000oo[10] * o0000O0oArr.length)]);
            wrap.order(byteOrder);
            for (O0000O0o o0000O0o : o0000O0oArr) {
                wrap.putInt((int) o0000O0o.f15021O000000o);
                wrap.putInt((int) o0000O0o.O00000Oo);
            }
            return new O00000o0(10, o0000O0oArr.length, wrap.array());
        }

        public static O00000o0 O000000o(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(dx.O00000oo[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new O00000o0(12, dArr.length, wrap.array());
        }

        public final String toString() {
            return "(" + dx.O00000oO[this.f15020O000000o] + ", data length:" + this.O00000o0.length + ")";
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x01a8 A[SYNTHETIC, Splitter:B:164:0x01a8] */
        public final Object O000000o(ByteOrder byteOrder) {
            O000000o o000000o;
            byte b;
            try {
                o000000o = new O000000o(this.O00000o0);
                try {
                    o000000o.f15017O000000o = byteOrder;
                    boolean z = true;
                    int i = 0;
                    switch (this.f15020O000000o) {
                        case 1:
                        case 6:
                            if (this.O00000o0.length != 1 || this.O00000o0[0] < 0 || this.O00000o0[0] > 1) {
                                String str = new String(this.O00000o0, dx.O0000Oo0);
                                try {
                                    o000000o.close();
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (this.O00000o0[0] + 48)});
                            try {
                                o000000o.close();
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.O00000Oo >= dx.O0000O0o.length) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 < dx.O0000O0o.length) {
                                        if (this.O00000o0[i2] != dx.O0000O0o[i2]) {
                                            z = false;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                if (z) {
                                    i = dx.O0000O0o.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (i < this.O00000Oo && (b = this.O00000o0[i]) != 0) {
                                if (b >= 32) {
                                    sb.append((char) b);
                                } else {
                                    sb.append('?');
                                }
                                i++;
                            }
                            String sb2 = sb.toString();
                            try {
                                o000000o.close();
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                iArr[i] = o000000o.readUnsignedShort();
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                jArr[i] = o000000o.O000000o();
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return jArr;
                        case 5:
                            O0000O0o[] o0000O0oArr = new O0000O0o[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                o0000O0oArr[i] = new O0000O0o(o000000o.O000000o(), o000000o.O000000o());
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return o0000O0oArr;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            int[] iArr2 = new int[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                iArr2[i] = o000000o.readShort();
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                iArr3[i] = o000000o.readInt();
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return iArr3;
                        case 10:
                            O0000O0o[] o0000O0oArr2 = new O0000O0o[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                o0000O0oArr2[i] = new O0000O0o((long) o000000o.readInt(), (long) o000000o.readInt());
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return o0000O0oArr2;
                        case 11:
                            double[] dArr = new double[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                dArr[i] = (double) o000000o.readFloat();
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return dArr;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            double[] dArr2 = new double[this.O00000Oo];
                            while (i < this.O00000Oo) {
                                dArr2[i] = o000000o.readDouble();
                                i++;
                            }
                            try {
                                o000000o.close();
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return dArr2;
                        default:
                            try {
                                o000000o.close();
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return null;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
                e = e13;
            } catch (IOException e14) {
                e = e14;
                o000000o = null;
            } catch (Throwable th) {
                th = th;
                o000000o = null;
                if (o000000o != null) {
                }
                throw th;
            }
            try {
                Log.w("ExifInterface", "IOException occurred during reading a value", e);
                if (o000000o != null) {
                    try {
                        o000000o.close();
                    } catch (IOException e15) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (o000000o != null) {
                    try {
                        o000000o.close();
                    } catch (IOException e16) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                    }
                }
                throw th;
            }
        }

        public final double O00000Oo(ByteOrder byteOrder) {
            Object O000000o2 = O000000o(byteOrder);
            if (O000000o2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (O000000o2 instanceof String) {
                return Double.parseDouble((String) O000000o2);
            } else {
                if (O000000o2 instanceof long[]) {
                    long[] jArr = (long[]) O000000o2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (O000000o2 instanceof int[]) {
                    int[] iArr = (int[]) O000000o2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (O000000o2 instanceof double[]) {
                    double[] dArr = (double[]) O000000o2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (O000000o2 instanceof O0000O0o[]) {
                    O0000O0o[] o0000O0oArr = (O0000O0o[]) O000000o2;
                    if (o0000O0oArr.length == 1) {
                        return o0000O0oArr[0].O000000o();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public final int O00000o0(ByteOrder byteOrder) {
            Object O000000o2 = O000000o(byteOrder);
            if (O000000o2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (O000000o2 instanceof String) {
                return Integer.parseInt((String) O000000o2);
            } else {
                if (O000000o2 instanceof long[]) {
                    long[] jArr = (long[]) O000000o2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (O000000o2 instanceof int[]) {
                    int[] iArr = (int[]) O000000o2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public final String O00000o(ByteOrder byteOrder) {
            Object O000000o2 = O000000o(byteOrder);
            if (O000000o2 == null) {
                return null;
            }
            if (O000000o2 instanceof String) {
                return (String) O000000o2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (O000000o2 instanceof long[]) {
                long[] jArr = (long[]) O000000o2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (O000000o2 instanceof int[]) {
                int[] iArr = (int[]) O000000o2;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (O000000o2 instanceof double[]) {
                double[] dArr = (double[]) O000000o2;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(O000000o2 instanceof O0000O0o[])) {
                return null;
            } else {
                O0000O0o[] o0000O0oArr = (O0000O0o[]) O000000o2;
                while (i < o0000O0oArr.length) {
                    sb.append(o0000O0oArr[i].f15021O000000o);
                    sb.append('/');
                    sb.append(o0000O0oArr[i].O00000Oo);
                    i++;
                    if (i != o0000O0oArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public final int O000000o() {
            return dx.O00000oo[this.f15020O000000o] * this.O00000Oo;
        }
    }

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f15019O000000o;
        public final String O00000Oo;
        public final int O00000o;
        public final int O00000o0;

        O00000o(String str, int i, int i2) {
            this.O00000Oo = str;
            this.f15019O000000o = i;
            this.O00000o0 = i2;
            this.O00000o = -1;
        }

        O00000o(String str, int i) {
            this.O00000Oo = str;
            this.f15019O000000o = i;
            this.O00000o0 = 3;
            this.O00000o = 4;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(int i) {
            int i2;
            int i3 = this.O00000o0;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.O00000o) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.O00000o0 == 9 || this.O00000o == 9) && i == 8) {
                return true;
            }
            if ((this.O00000o0 == 12 || this.O00000o == 12) && i == 11) {
                return true;
            }
            return false;
        }
    }

    public dx(String str) throws IOException {
        O00000o[][] o00000oArr = O0000OOo;
        this.O000OO00 = new HashMap[o00000oArr.length];
        this.O000OO0o = new HashSet(o00000oArr.length);
        this.O000OO = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.O000O0oO = null;
            this.O000O0o = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    O000000o((InputStream) fileInputStream2);
                    O000000o((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    O000000o((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                O000000o((Closeable) fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    public dx(InputStream inputStream) throws IOException {
        O00000o[][] o00000oArr = O0000OOo;
        this.O000OO00 = new HashMap[o00000oArr.length];
        this.O000OO0o = new HashSet(o00000oArr.length);
        this.O000OO = ByteOrder.BIG_ENDIAN;
        this.O000O0o = null;
        this.O000O0oO = null;
        O000000o(inputStream);
    }

    private O00000o0 O00000Oo(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < O0000OOo.length; i++) {
            O00000o0 o00000o0 = this.O000OO00[i].get(str);
            if (o00000o0 != null) {
                return o00000o0;
            }
        }
        return null;
    }

    public final String O000000o(String str) {
        O00000o0 O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 != null) {
            if (!O00oOoOo.contains(str)) {
                return O00000Oo2.O00000o(this.O000OO);
            }
            if (!str.equals("GPSTimeStamp")) {
                try {
                    return Double.toString(O00000Oo2.O00000Oo(this.O000OO));
                } catch (NumberFormatException unused) {
                }
            } else if (O00000Oo2.f15020O000000o == 5 || O00000Oo2.f15020O000000o == 10) {
                O0000O0o[] o0000O0oArr = (O0000O0o[]) O00000Oo2.O000000o(this.O000OO);
                if (o0000O0oArr == null || o0000O0oArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(o0000O0oArr));
                    return null;
                }
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) o0000O0oArr[0].f15021O000000o) / ((float) o0000O0oArr[0].O00000Oo))), Integer.valueOf((int) (((float) o0000O0oArr[1].f15021O000000o) / ((float) o0000O0oArr[1].O00000Oo))), Integer.valueOf((int) (((float) o0000O0oArr[2].f15021O000000o) / ((float) o0000O0oArr[2].O00000Oo))));
            } else {
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + O00000Oo2.f15020O000000o);
                return null;
            }
        }
        return null;
    }

    public final int O000000o(String str, int i) {
        O00000o0 O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 == null) {
            return i;
        }
        try {
            return O00000Oo2.O00000o0(this.O000OO);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public final double O000000o(String str, double d) {
        O00000o0 O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 == null) {
            return d;
        }
        try {
            return O00000Oo2.O00000Oo(this.O000OO);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public final void O000000o(String str, String str2) {
        String str3;
        O00000o o00000o;
        int i;
        O00000o0 o00000o0;
        String str4;
        String str5;
        String str6 = str2;
        String str7 = str;
        String str8 = "ISOSpeedRatings".equals(str7) ? "PhotographicSensitivity" : str7;
        int i2 = 2;
        String str9 = "ExifInterface";
        int i3 = 1;
        if (str6 != null && O00oOoOo.contains(str8)) {
            if (str8.equals("GPSTimeStamp")) {
                Matcher matcher = O000OoOO.matcher(str6);
                if (!matcher.find()) {
                    Log.w(str9, "Invalid value for " + str8 + " : " + str6);
                    return;
                }
                str6 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str6 = new O0000O0o(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException unused) {
                    Log.w(str9, "Invalid value for " + str8 + " : " + str6);
                    return;
                }
            }
        }
        char c = 0;
        int i4 = 0;
        while (i4 < O0000OOo.length) {
            if ((i4 != 4 || this.O000OOOo) && (o00000o = O000O0Oo[i4].get(str8)) != null) {
                if (str6 == null) {
                    this.O000OO00[i4].remove(str8);
                } else {
                    Pair<Integer, Integer> O00000o2 = O00000o(str6);
                    if (o00000o.O00000o0 == ((Integer) O00000o2.first).intValue() || o00000o.O00000o0 == ((Integer) O00000o2.second).intValue()) {
                        i = o00000o.O00000o0;
                    } else if (o00000o.O00000o != -1 && (o00000o.O00000o == ((Integer) O00000o2.first).intValue() || o00000o.O00000o == ((Integer) O00000o2.second).intValue())) {
                        i = o00000o.O00000o;
                    } else if (o00000o.O00000o0 == i3 || o00000o.O00000o0 == 7 || o00000o.O00000o0 == i2) {
                        i = o00000o.O00000o0;
                    } else {
                        StringBuilder sb = new StringBuilder("Given tag (");
                        sb.append(str8);
                        sb.append(") value didn't match with one of expected formats: ");
                        sb.append(O00000oO[o00000o.O00000o0]);
                        String str10 = "";
                        if (o00000o.O00000o == -1) {
                            str5 = str10;
                        } else {
                            str5 = ", " + O00000oO[o00000o.O00000o];
                        }
                        sb.append(str5);
                        sb.append(" (guess: ");
                        sb.append(O00000oO[((Integer) O00000o2.first).intValue()]);
                        if (((Integer) O00000o2.second).intValue() != -1) {
                            str10 = ", " + O00000oO[((Integer) O00000o2.second).intValue()];
                        }
                        sb.append(str10);
                        sb.append(")");
                        Log.w(str9, sb.toString());
                    }
                    switch (i) {
                        case 1:
                            String str11 = str9;
                            HashMap<String, O00000o0> hashMap = this.O000OO00[i4];
                            i3 = 1;
                            if (str6.length() == 1) {
                                if (str6.charAt(0) >= '0' && str6.charAt(0) <= '1') {
                                    o00000o0 = new O00000o0(1, 1, new byte[]{(byte) (str6.charAt(0) - '0')});
                                    hashMap.put(str8, o00000o0);
                                    str3 = str11;
                                    break;
                                }
                            }
                            byte[] bytes = str6.getBytes(O0000Oo0);
                            o00000o0 = new O00000o0(1, bytes.length, bytes);
                            hashMap.put(str8, o00000o0);
                            str3 = str11;
                        case 2:
                        case 7:
                            str4 = str9;
                            this.O000OO00[i4].put(str8, O00000o0.O000000o(str6));
                            str3 = str4;
                            i3 = 1;
                            break;
                        case 3:
                            str4 = str9;
                            String[] split = str6.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i5 = 0; i5 < split.length; i5++) {
                                iArr[i5] = Integer.parseInt(split[i5]);
                            }
                            this.O000OO00[i4].put(str8, O00000o0.O000000o(iArr, this.O000OO));
                            str3 = str4;
                            i3 = 1;
                            break;
                        case 4:
                            str4 = str9;
                            String[] split2 = str6.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i6 = 0; i6 < split2.length; i6++) {
                                jArr[i6] = Long.parseLong(split2[i6]);
                            }
                            this.O000OO00[i4].put(str8, O00000o0.O000000o(jArr, this.O000OO));
                            str3 = str4;
                            i3 = 1;
                            break;
                        case 5:
                            str4 = str9;
                            String[] split3 = str6.split(",", -1);
                            O0000O0o[] o0000O0oArr = new O0000O0o[split3.length];
                            for (int i7 = 0; i7 < split3.length; i7++) {
                                String[] split4 = split3[i7].split("/", -1);
                                o0000O0oArr[i7] = new O0000O0o((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                            }
                            this.O000OO00[i4].put(str8, O00000o0.O000000o(o0000O0oArr, this.O000OO));
                            str3 = str4;
                            i3 = 1;
                            break;
                        case 6:
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        case 11:
                        default:
                            str3 = str9;
                            Log.w(str3, "Data format isn't one of expected formats: ".concat(String.valueOf(i)));
                            break;
                        case 9:
                            str4 = str9;
                            String[] split5 = str6.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i8 = 0; i8 < split5.length; i8++) {
                                iArr2[i8] = Integer.parseInt(split5[i8]);
                            }
                            this.O000OO00[i4].put(str8, O00000o0.O00000Oo(iArr2, this.O000OO));
                            str3 = str4;
                            i3 = 1;
                            break;
                        case 10:
                            String[] split6 = str6.split(",", -1);
                            O0000O0o[] o0000O0oArr2 = new O0000O0o[split6.length];
                            int i9 = 0;
                            while (i9 < split6.length) {
                                String[] split7 = split6[i9].split("/", -1);
                                o0000O0oArr2[i9] = new O0000O0o((long) Double.parseDouble(split7[c]), (long) Double.parseDouble(split7[i3]));
                                i9++;
                                str9 = str9;
                                i3 = 1;
                                c = 0;
                            }
                            str4 = str9;
                            this.O000OO00[i4].put(str8, O00000o0.O00000Oo(o0000O0oArr2, this.O000OO));
                            str3 = str4;
                            i3 = 1;
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            String[] split8 = str6.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i10 = 0; i10 < split8.length; i10++) {
                                dArr[i10] = Double.parseDouble(split8[i10]);
                            }
                            this.O000OO00[i4].put(str8, O00000o0.O000000o(dArr, this.O000OO));
                            break;
                    }
                    i4++;
                    str9 = str3;
                    i2 = 2;
                    c = 0;
                }
            }
            str3 = str9;
            i4++;
            str9 = str3;
            i2 = 2;
            c = 0;
        }
    }

    private void O00000o0(String str) {
        for (int i = 0; i < O0000OOo.length; i++) {
            this.O000OO00[i].remove(str);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:101|102|103|104) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x024c, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r11.O00O0Oo = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0253, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0254, code lost:
        O00000oO();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0258, code lost:
        throw r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x024e */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062 A[Catch:{ IOException -> 0x024e }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ IOException -> 0x024e }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x023d A[Catch:{ IOException -> 0x024e }] */
    private void O000000o(InputStream inputStream) throws IOException {
        int i;
        boolean z;
        O00000o0 o00000o0;
        boolean z2;
        int i2 = 0;
        while (true) {
            if (i2 < O0000OOo.length) {
                this.O000OO00[i2] = new HashMap<>();
                i2++;
            } else {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                bufferedInputStream2.mark(5000);
                byte[] bArr = new byte[5000];
                bufferedInputStream2.read(bArr);
                bufferedInputStream2.reset();
                if (O000000o(bArr)) {
                    i = 4;
                } else if (O00000Oo(bArr)) {
                    i = 9;
                } else {
                    O000000o o000000o = new O000000o(bArr);
                    this.O000OO = O00000o0(o000000o);
                    o000000o.f15017O000000o = this.O000OO;
                    short readShort = o000000o.readShort();
                    o000000o.close();
                    if (readShort != 20306) {
                        if (readShort != 21330) {
                            z2 = false;
                            if (!z2) {
                                i = 7;
                            } else {
                                O000000o o000000o2 = new O000000o(bArr);
                                this.O000OO = O00000o0(o000000o2);
                                o000000o2.f15017O000000o = this.O000OO;
                                short readShort2 = o000000o2.readShort();
                                o000000o2.close();
                                i = readShort2 == 85 ? 10 : 0;
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
                this.O000O0oo = i;
                O000000o o000000o3 = new O000000o(bufferedInputStream);
                switch (this.O000O0oo) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    case 11:
                        O000000o(o000000o3);
                        break;
                    case 4:
                        O000000o(o000000o3, 0, 0);
                        break;
                    case 7:
                        O000000o(o000000o3);
                        O00000o0 o00000o02 = this.O000OO00[1].get("MakerNote");
                        if (o00000o02 != null) {
                            O000000o o000000o4 = new O000000o(o00000o02.O00000o0);
                            o000000o4.f15017O000000o = this.O000OO;
                            byte[] bArr2 = new byte[O0000o00.length];
                            o000000o4.readFully(bArr2);
                            o000000o4.O000000o(0);
                            byte[] bArr3 = new byte[O0000o0.length];
                            o000000o4.readFully(bArr3);
                            if (Arrays.equals(bArr2, O0000o00)) {
                                o000000o4.O000000o(8);
                            } else if (Arrays.equals(bArr3, O0000o0)) {
                                o000000o4.O000000o(12);
                            }
                            O00000Oo(o000000o4, 6);
                            O00000o0 o00000o03 = this.O000OO00[7].get("PreviewImageStart");
                            O00000o0 o00000o04 = this.O000OO00[7].get("PreviewImageLength");
                            if (!(o00000o03 == null || o00000o04 == null)) {
                                this.O000OO00[5].put("JPEGInterchangeFormat", o00000o03);
                                this.O000OO00[5].put("JPEGInterchangeFormatLength", o00000o04);
                            }
                            O00000o0 o00000o05 = this.O000OO00[8].get("AspectFrame");
                            if (o00000o05 != null) {
                                int[] iArr = (int[]) o00000o05.O000000o(this.O000OO);
                                if (iArr != null) {
                                    if (iArr.length == 4) {
                                        if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                            int i3 = (iArr[2] - iArr[0]) + 1;
                                            int i4 = (iArr[3] - iArr[1]) + 1;
                                            if (i3 < i4) {
                                                int i5 = i3 + i4;
                                                i4 = i5 - i4;
                                                i3 = i5 - i4;
                                            }
                                            O00000o0 O000000o2 = O00000o0.O000000o(i3, this.O000OO);
                                            O00000o0 O000000o3 = O00000o0.O000000o(i4, this.O000OO);
                                            this.O000OO00[0].put("ImageWidth", O000000o2);
                                            this.O000OO00[0].put("ImageLength", O000000o3);
                                            break;
                                        }
                                    }
                                }
                                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                                break;
                            }
                        }
                        break;
                    case 9:
                        O00000Oo(o000000o3);
                        break;
                    case 10:
                        O000000o(o000000o3);
                        if (this.O000OO00[0].get("JpgFromRaw") != null) {
                            O000000o(o000000o3, this.O000OoO0, 5);
                        }
                        O00000o0 o00000o06 = this.O000OO00[0].get("ISO");
                        O00000o0 o00000o07 = this.O000OO00[1].get("PhotographicSensitivity");
                        if (o00000o06 != null && o00000o07 == null) {
                            this.O000OO00[1].put("PhotographicSensitivity", o00000o06);
                            break;
                        }
                }
                HashMap<String, O00000o0> hashMap = this.O000OO00[4];
                O00000o0 o00000o08 = hashMap.get("Compression");
                if (o00000o08 != null) {
                    this.O000OOoo = o00000o08.O00000o0(this.O000OO);
                    int i6 = this.O000OOoo;
                    if (i6 != 1) {
                        if (i6 == 6) {
                            O000000o(o000000o3, hashMap);
                        } else if (i6 != 7) {
                        }
                    }
                    O00000o0 o00000o09 = hashMap.get("BitsPerSample");
                    if (o00000o09 != null) {
                        int[] iArr2 = (int[]) o00000o09.O000000o(this.O000OO);
                        if (!Arrays.equals(f15016O000000o, iArr2)) {
                            if (this.O000O0oo == 3 && (o00000o0 = hashMap.get("PhotometricInterpretation")) != null) {
                                int O00000o02 = o00000o0.O00000o0(this.O000OO);
                                if (O00000o02 != 1 || !Arrays.equals(iArr2, O00000o0)) {
                                    if (O00000o02 == 6 && Arrays.equals(iArr2, f15016O000000o)) {
                                    }
                                }
                            }
                        }
                        z = true;
                        if (z) {
                            O00000Oo(o000000o3, hashMap);
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else {
                    this.O000OOoo = 6;
                    O000000o(o000000o3, hashMap);
                }
                this.O00O0Oo = true;
                O00000oO();
                return;
            }
        }
    }

    public final void O000000o() throws IOException {
        byte[] bArr;
        Throwable th;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (!this.O00O0Oo || this.O000O0oo != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.O000O0o != null) {
            int i = this.O000OOoo;
            FileOutputStream fileOutputStream2 = null;
            if (i == 6 || i == 7) {
                bArr = O00000o();
            } else {
                bArr = null;
            }
            this.O000OOoO = bArr;
            File file = new File(this.O000O0o + ".tmp");
            if (new File(this.O000O0o).renameTo(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.O000O0o);
                    } catch (Throwable th2) {
                        th = th2;
                        O000000o((Closeable) fileInputStream);
                        O000000o((Closeable) fileOutputStream2);
                        file.delete();
                        throw th;
                    }
                    try {
                        O000000o(fileInputStream, fileOutputStream);
                        O000000o((Closeable) fileInputStream);
                        O000000o((Closeable) fileOutputStream);
                        file.delete();
                        this.O000OOoO = null;
                    } catch (Throwable th3) {
                        FileOutputStream fileOutputStream3 = fileOutputStream;
                        th = th3;
                        fileOutputStream2 = fileOutputStream3;
                        O000000o((Closeable) fileInputStream);
                        O000000o((Closeable) fileOutputStream2);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    O000000o((Closeable) fileInputStream);
                    O000000o((Closeable) fileOutputStream2);
                    file.delete();
                    throw th;
                }
            } else {
                throw new IOException("Could not rename to " + file.getAbsolutePath());
            }
        } else {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
    }

    private byte[] O00000o() {
        InputStream inputStream;
        if (!this.O000OOOo) {
            return null;
        }
        byte[] bArr = this.O000OOoO;
        if (bArr != null) {
            return bArr;
        }
        try {
            if (this.O000O0oO != null) {
                inputStream = this.O000O0oO;
                try {
                    if (inputStream.markSupported()) {
                        inputStream.reset();
                    } else {
                        Log.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");
                        O000000o((Closeable) inputStream);
                        return null;
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
                        O000000o((Closeable) inputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        O000000o((Closeable) inputStream);
                        throw th;
                    }
                }
            } else {
                inputStream = this.O000O0o != null ? new FileInputStream(this.O000O0o) : null;
            }
            if (inputStream != null) {
                if (inputStream.skip((long) this.O000OOo0) == ((long) this.O000OOo0)) {
                    byte[] bArr2 = new byte[this.O000OOo];
                    if (inputStream.read(bArr2) == this.O000OOo) {
                        this.O000OOoO = bArr2;
                        O000000o((Closeable) inputStream);
                        return bArr2;
                    }
                    throw new IOException("Corrupted image");
                }
                throw new IOException("Corrupted image");
            }
            throw new FileNotFoundException();
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
            O000000o((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            O000000o((Closeable) inputStream);
            throw th;
        }
    }

    public final double[] O00000Oo() {
        String O000000o2 = O000000o("GPSLatitude");
        String O000000o3 = O000000o("GPSLatitudeRef");
        String O000000o4 = O000000o("GPSLongitude");
        String O000000o5 = O000000o("GPSLongitudeRef");
        if (O000000o2 == null || O000000o3 == null || O000000o4 == null || O000000o5 == null) {
            return null;
        }
        try {
            return new double[]{O00000Oo(O000000o2, O000000o3), O00000Oo(O000000o4, O000000o5)};
        } catch (IllegalArgumentException unused) {
            Log.w("ExifInterface", "Latitude/longitude values are not parseable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", O000000o2, O000000o3, O000000o4, O000000o5));
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dx.O000000o(java.lang.String, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.dx.O000000o(int, int):void
      _m_j.dx.O000000o(_m_j.dx$O000000o, int):void
      _m_j.dx.O000000o(_m_j.dx$O000000o, java.util.HashMap):void
      _m_j.dx.O000000o(java.io.InputStream, java.io.OutputStream):void
      _m_j.dx.O000000o(java.lang.String, int):int
      _m_j.dx.O000000o(java.lang.String, java.lang.String):void
      _m_j.dx.O000000o(java.lang.String, double):double */
    public final double O00000o0() {
        double O000000o2 = O000000o("GPSAltitude", -1.0d);
        int i = -1;
        int O000000o3 = O000000o("GPSAltitudeRef", -1);
        if (O000000o2 < 0.0d || O000000o3 < 0) {
            return 0.0d;
        }
        if (O000000o3 != 1) {
            i = 1;
        }
        double d = (double) i;
        Double.isNaN(d);
        return O000000o2 * d;
    }

    public final void O000000o(double d) {
        String str = d >= 0.0d ? "0" : "1";
        O000000o("GPSAltitude", new O0000O0o(Math.abs(d)).toString());
        O000000o("GPSAltitudeRef", str);
    }

    private static double O00000Oo(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals("S")) {
                if (!str2.equals("W")) {
                    if (!str2.equals("N")) {
                        if (!str2.equals("E")) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static String O00000Oo(double d) {
        long j = (long) d;
        double d2 = (double) j;
        Double.isNaN(d2);
        double d3 = d - d2;
        long j2 = (long) (d3 * 60.0d);
        double d4 = (double) j2;
        Double.isNaN(d4);
        long round = Math.round((d3 - (d4 / 60.0d)) * 3600.0d * 1.0E7d);
        return j + "/1," + j2 + "/1," + round + "/10000000";
    }

    private static boolean O000000o(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = O00000o;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private static boolean O00000Oo(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x010e A[SYNTHETIC] */
    private void O000000o(O000000o o000000o, int i, int i2) throws IOException {
        o000000o.f15017O000000o = ByteOrder.BIG_ENDIAN;
        o000000o.O000000o((long) i);
        byte readByte = o000000o.readByte();
        if (readByte == -1) {
            int i3 = i + 1;
            if (o000000o.readByte() == -40) {
                int i4 = i3 + 1;
                while (true) {
                    byte readByte2 = o000000o.readByte();
                    if (readByte2 == -1) {
                        byte readByte3 = o000000o.readByte();
                        int i5 = i4 + 1 + 1;
                        if (readByte3 == -39 || readByte3 == -38) {
                            o000000o.f15017O000000o = this.O000OO;
                        } else {
                            int readUnsignedShort = o000000o.readUnsignedShort() - 2;
                            int i6 = i5 + 2;
                            if (readUnsignedShort >= 0) {
                                if (readByte3 == -31) {
                                    if (readUnsignedShort >= 6) {
                                        byte[] bArr = new byte[6];
                                        if (o000000o.read(bArr) == 6) {
                                            i6 += 6;
                                            readUnsignedShort -= 6;
                                            if (Arrays.equals(bArr, O0000Oo)) {
                                                if (readUnsignedShort > 0) {
                                                    this.O000Oo00 = i6;
                                                    byte[] bArr2 = new byte[readUnsignedShort];
                                                    if (o000000o.read(bArr2) == readUnsignedShort) {
                                                        i6 += readUnsignedShort;
                                                        O000000o o000000o2 = new O000000o(bArr2);
                                                        O000000o(o000000o2, bArr2.length);
                                                        O00000Oo(o000000o2, i2);
                                                    } else {
                                                        throw new IOException("Invalid exif");
                                                    }
                                                } else {
                                                    throw new IOException("Invalid exif");
                                                }
                                            }
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    }
                                    if (readUnsignedShort < 0) {
                                    }
                                } else if (readByte3 != -2) {
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                                default:
                                                    switch (readByte3) {
                                                        default:
                                                            switch (readByte3) {
                                                            }
                                                        case -55:
                                                        case -54:
                                                        case -53:
                                                            if (o000000o.skipBytes(1) == 1) {
                                                                this.O000OO00[i2].put("ImageLength", O00000o0.O000000o((long) o000000o.readUnsignedShort(), this.O000OO));
                                                                this.O000OO00[i2].put("ImageWidth", O00000o0.O000000o((long) o000000o.readUnsignedShort(), this.O000OO));
                                                                readUnsignedShort -= 5;
                                                                break;
                                                            } else {
                                                                throw new IOException("Invalid SOFx");
                                                            }
                                                    }
                                                case -59:
                                                case -58:
                                                case -57:
                                                    break;
                                            }
                                        case -64:
                                        case -63:
                                        case -62:
                                        case -61:
                                            break;
                                    }
                                    if (readUnsignedShort < 0) {
                                        throw new IOException("Invalid length");
                                    } else if (o000000o.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                        i4 = i6 + readUnsignedShort;
                                    } else {
                                        throw new IOException("Invalid JPEG segment");
                                    }
                                } else {
                                    byte[] bArr3 = new byte[readUnsignedShort];
                                    if (o000000o.read(bArr3) != readUnsignedShort) {
                                        throw new IOException("Invalid exif");
                                    } else if (O000000o("UserComment") == null) {
                                        this.O000OO00[1].put("UserComment", O00000o0.O000000o(new String(bArr3, O0000Oo0)));
                                    }
                                }
                                readUnsignedShort = 0;
                                if (readUnsignedShort < 0) {
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                    }
                }
                o000000o.f15017O000000o = this.O000OO;
                return;
            }
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
    }

    private void O000000o(O000000o o000000o) throws IOException {
        O00000o0 o00000o0;
        O000000o(o000000o, o000000o.available());
        O00000Oo(o000000o, 0);
        O00000o(o000000o, 0);
        O00000o(o000000o, 5);
        O00000o(o000000o, 4);
        O00000oo();
        if (this.O000O0oo == 8 && (o00000o0 = this.O000OO00[1].get("MakerNote")) != null) {
            O000000o o000000o2 = new O000000o(o00000o0.O00000o0);
            o000000o2.f15017O000000o = this.O000OO;
            o000000o2.O000000o(6);
            O00000Oo(o000000o2, 9);
            O00000o0 o00000o02 = this.O000OO00[9].get("ColorSpace");
            if (o00000o02 != null) {
                this.O000OO00[1].put("ColorSpace", o00000o02);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dx.O00000o0.O000000o(int, java.nio.ByteOrder):_m_j.dx$O00000o0
     arg types: [short, java.nio.ByteOrder]
     candidates:
      _m_j.dx.O00000o0.O000000o(long, java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(_m_j.dx$O0000O0o, java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(double[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(int[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(long[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(_m_j.dx$O0000O0o[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(int, java.nio.ByteOrder):_m_j.dx$O00000o0 */
    private void O00000Oo(O000000o o000000o) throws IOException {
        o000000o.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        o000000o.read(bArr);
        o000000o.skipBytes(4);
        o000000o.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        O000000o(o000000o, i, 5);
        o000000o.O000000o((long) i2);
        o000000o.f15017O000000o = ByteOrder.BIG_ENDIAN;
        int readInt = o000000o.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = o000000o.readUnsignedShort();
            int readUnsignedShort2 = o000000o.readUnsignedShort();
            if (readUnsignedShort == O0000oOo.f15019O000000o) {
                short readShort = o000000o.readShort();
                short readShort2 = o000000o.readShort();
                O00000o0 O000000o2 = O00000o0.O000000o((int) readShort, this.O000OO);
                O00000o0 O000000o3 = O00000o0.O000000o((int) readShort2, this.O000OO);
                this.O000OO00[0].put("ImageLength", O000000o2);
                this.O000OO00[0].put("ImageWidth", O000000o3);
                return;
            }
            o000000o.skipBytes(readUnsignedShort2);
        }
    }

    private void O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        O00000Oo o00000Oo = new O00000Oo(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            o00000Oo.O000000o(-1);
            if (dataInputStream.readByte() == -40) {
                o00000Oo.O000000o(-40);
                o00000Oo.O000000o(-1);
                o00000Oo.O000000o(-31);
                O000000o(o00000Oo);
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        o00000Oo.O000000o(-1);
                        o00000Oo.O000000o((int) readByte);
                        O00000Oo(dataInputStream, o00000Oo);
                        return;
                    } else if (readByte != -31) {
                        o00000Oo.O000000o(-1);
                        o00000Oo.O000000o((int) readByte);
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        o00000Oo.O000000o((short) readUnsignedShort);
                        int i = readUnsignedShort - 2;
                        if (i >= 0) {
                            while (i > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                                if (read < 0) {
                                    break;
                                }
                                o00000Oo.write(bArr, 0, read);
                                i -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (dataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, O0000Oo)) {
                                    int i2 = readUnsignedShort2 - 6;
                                    if (dataInputStream.skipBytes(i2) != i2) {
                                        throw new IOException("Invalid length");
                                    }
                                }
                            }
                            o00000Oo.O000000o(-1);
                            o00000Oo.O000000o((int) readByte);
                            o00000Oo.O000000o((short) (readUnsignedShort2 + 2));
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                o00000Oo.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                o00000Oo.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dx.O00000o0.O000000o(long, java.nio.ByteOrder):_m_j.dx$O00000o0
     arg types: [int, java.nio.ByteOrder]
     candidates:
      _m_j.dx.O00000o0.O000000o(int, java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(_m_j.dx$O0000O0o, java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(double[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(int[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(long[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(_m_j.dx$O0000O0o[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(long, java.nio.ByteOrder):_m_j.dx$O00000o0 */
    private void O00000oO() {
        String O000000o2 = O000000o("DateTimeOriginal");
        if (O000000o2 != null && O000000o("DateTime") == null) {
            this.O000OO00[0].put("DateTime", O00000o0.O000000o(O000000o2));
        }
        if (O000000o("ImageWidth") == null) {
            this.O000OO00[0].put("ImageWidth", O00000o0.O000000o(0L, this.O000OO));
        }
        if (O000000o("ImageLength") == null) {
            this.O000OO00[0].put("ImageLength", O00000o0.O000000o(0L, this.O000OO));
        }
        if (O000000o("Orientation") == null) {
            this.O000OO00[0].put("Orientation", O00000o0.O000000o(0L, this.O000OO));
        }
        if (O000000o("LightSource") == null) {
            this.O000OO00[1].put("LightSource", O00000o0.O000000o(0L, this.O000OO));
        }
    }

    private static ByteOrder O00000o0(O000000o o000000o) throws IOException {
        short readShort = o000000o.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void O000000o(O000000o o000000o, int i) throws IOException {
        this.O000OO = O00000o0(o000000o);
        o000000o.f15017O000000o = this.O000OO;
        int readUnsignedShort = o000000o.readUnsignedShort();
        int i2 = this.O000O0oo;
        if (i2 == 7 || i2 == 10 || readUnsignedShort == 42) {
            int readInt = o000000o.readInt();
            if (readInt < 8 || readInt >= i) {
                throw new IOException("Invalid first Ifd offset: ".concat(String.valueOf(readInt)));
            }
            int i3 = readInt - 8;
            if (i3 > 0 && o000000o.skipBytes(i3) != i3) {
                throw new IOException("Couldn't jump to first Ifd: ".concat(String.valueOf(i3)));
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x027c, code lost:
        if (r5.O00000o0(r0.O000OO) == 65535) goto L_0x027e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x028a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0287  */
    private void O00000Oo(O000000o o000000o, int i) throws IOException {
        int readInt;
        short s;
        long j;
        boolean z;
        int i2;
        short s2;
        String str;
        O00000o o00000o;
        int i3;
        int i4;
        int i5;
        O000000o o000000o2 = o000000o;
        int i6 = i;
        while (true) {
            this.O000OO0o.add(Integer.valueOf(o000000o2.O00000o0));
            if (o000000o2.O00000o0 + 2 <= o000000o2.O00000Oo) {
                short readShort = o000000o.readShort();
                if (o000000o2.O00000o0 + (readShort * 12) <= o000000o2.O00000Oo && readShort > 0) {
                    short s3 = 0;
                    while (s3 < readShort) {
                        int readUnsignedShort = o000000o.readUnsignedShort();
                        int readUnsignedShort2 = o000000o.readUnsignedShort();
                        int readInt2 = o000000o.readInt();
                        long j2 = ((long) o000000o2.O00000o0) + 4;
                        O00000o o00000o2 = O000O0OO[i6].get(Integer.valueOf(readUnsignedShort));
                        if (o00000o2 == null) {
                            Log.w("ExifInterface", "Skip the tag entry since tag number is not defined: ".concat(String.valueOf(readUnsignedShort)));
                        } else if (readUnsignedShort2 <= 0 || readUnsignedShort2 >= O00000oo.length) {
                            s = s3;
                            Log.w("ExifInterface", "Skip the tag entry since data format is invalid: ".concat(String.valueOf(readUnsignedShort2)));
                            z = false;
                            j = 0;
                            if (!z) {
                                o000000o2.O000000o(j2);
                                i2 = i6;
                                s2 = readShort;
                            } else {
                                if (j > 4) {
                                    int readInt3 = o000000o.readInt();
                                    int i7 = this.O000O0oo;
                                    s2 = readShort;
                                    if (i7 == 7) {
                                        if ("MakerNote".equals(o00000o2.O00000Oo)) {
                                            this.O000Oo0 = readInt3;
                                        } else if (i6 == 6 && "ThumbnailImage".equals(o00000o2.O00000Oo)) {
                                            this.O000Oo0O = readInt3;
                                            this.O000Oo0o = readInt2;
                                            O00000o0 O000000o2 = O00000o0.O000000o(6, this.O000OO);
                                            i3 = readUnsignedShort2;
                                            i4 = readInt2;
                                            O00000o0 O000000o3 = O00000o0.O000000o((long) this.O000Oo0O, this.O000OO);
                                            i2 = i6;
                                            O00000o0 O000000o4 = O00000o0.O000000o((long) this.O000Oo0o, this.O000OO);
                                            this.O000OO00[4].put("Compression", O000000o2);
                                            this.O000OO00[4].put("JPEGInterchangeFormat", O000000o3);
                                            this.O000OO00[4].put("JPEGInterchangeFormatLength", O000000o4);
                                        }
                                        i2 = i6;
                                        i3 = readUnsignedShort2;
                                        i4 = readInt2;
                                    } else {
                                        i2 = i6;
                                        i3 = readUnsignedShort2;
                                        i4 = readInt2;
                                        if (i7 == 10 && "JpgFromRaw".equals(o00000o2.O00000Oo)) {
                                            this.O000OoO0 = readInt3;
                                        }
                                    }
                                    long j3 = (long) readInt3;
                                    o00000o = o00000o2;
                                    str = "Compression";
                                    if (j3 + j <= ((long) o000000o2.O00000Oo)) {
                                        o000000o2.O000000o(j3);
                                    } else {
                                        Log.w("ExifInterface", "Skip the tag entry since data offset is invalid: ".concat(String.valueOf(readInt3)));
                                        o000000o2.O000000o(j2);
                                    }
                                } else {
                                    o00000o = o00000o2;
                                    str = "Compression";
                                    i2 = i6;
                                    s2 = readShort;
                                    i3 = readUnsignedShort2;
                                    i4 = readInt2;
                                }
                                Integer num = O000O0o0.get(Integer.valueOf(readUnsignedShort));
                                if (num != null) {
                                    long j4 = -1;
                                    int i8 = i3;
                                    if (i8 == 3) {
                                        i5 = o000000o.readUnsignedShort();
                                        j4 = (long) i5;
                                    } else if (i8 != 4) {
                                        if (i8 == 8) {
                                            i5 = o000000o.readShort();
                                        } else if (i8 == 9 || i8 == 13) {
                                            i5 = o000000o.readInt();
                                        }
                                        j4 = (long) i5;
                                    } else {
                                        j4 = o000000o.O000000o();
                                    }
                                    if (j4 <= 0 || j4 >= ((long) o000000o2.O00000Oo)) {
                                        Log.w("ExifInterface", "Skip jump into the IFD since its offset is invalid: ".concat(String.valueOf(j4)));
                                    } else if (!this.O000OO0o.contains(Integer.valueOf((int) j4))) {
                                        o000000o2.O000000o(j4);
                                        O00000Oo(o000000o2, num.intValue());
                                    } else {
                                        Log.w("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j4 + ")");
                                    }
                                    o000000o2.O000000o(j2);
                                } else {
                                    byte[] bArr = new byte[((int) j)];
                                    o000000o2.readFully(bArr);
                                    O00000o0 o00000o0 = new O00000o0(i3, i4, bArr);
                                    O00000o o00000o3 = o00000o;
                                    this.O000OO00[i2].put(o00000o3.O00000Oo, o00000o0);
                                    if ("DNGVersion".equals(o00000o3.O00000Oo)) {
                                        this.O000O0oo = 3;
                                    }
                                    if ((!"Make".equals(o00000o3.O00000Oo) && !"Model".equals(o00000o3.O00000Oo)) || !o00000o0.O00000o(this.O000OO).contains("PENTAX")) {
                                        if (str.equals(o00000o3.O00000Oo)) {
                                        }
                                        if (((long) o000000o2.O00000o0) == j2) {
                                            o000000o2.O000000o(j2);
                                        }
                                    }
                                    this.O000O0oo = 8;
                                    if (((long) o000000o2.O00000o0) == j2) {
                                    }
                                }
                            }
                            s3 = (short) (s + 1);
                            readShort = s2;
                            i6 = i2;
                        } else if (!o00000o2.O000000o(readUnsignedShort2)) {
                            Log.w("ExifInterface", "Skip the tag entry since data format (" + O00000oO[readUnsignedShort2] + ") is unexpected for tag: " + o00000o2.O00000Oo);
                        } else {
                            if (readUnsignedShort2 == 7) {
                                readUnsignedShort2 = o00000o2.O00000o0;
                            }
                            s = s3;
                            j = ((long) readInt2) * ((long) O00000oo[readUnsignedShort2]);
                            if (j < 0 || j > 2147483647L) {
                                Log.w("ExifInterface", "Skip the tag entry since the number of components is invalid: ".concat(String.valueOf(readInt2)));
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!z) {
                            }
                            s3 = (short) (s + 1);
                            readShort = s2;
                            i6 = i2;
                        }
                        s = s3;
                        z = false;
                        j = 0;
                        if (!z) {
                        }
                        s3 = (short) (s + 1);
                        readShort = s2;
                        i6 = i2;
                    }
                    if (o000000o2.O00000o0 + 4 <= o000000o2.O00000Oo) {
                        readInt = o000000o.readInt();
                        long j5 = (long) readInt;
                        if (j5 <= 0 || readInt >= o000000o2.O00000Oo) {
                            Log.w("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: ".concat(String.valueOf(readInt)));
                        } else if (!this.O000OO0o.contains(Integer.valueOf(readInt))) {
                            o000000o2.O000000o(j5);
                            if (this.O000OO00[4].isEmpty()) {
                                i6 = 4;
                            } else if (this.O000OO00[5].isEmpty()) {
                                i6 = 5;
                            } else {
                                return;
                            }
                        } else {
                            Log.w("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: ".concat(String.valueOf(readInt)));
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        Log.w("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: ".concat(String.valueOf(readInt)));
    }

    private void O00000o0(O000000o o000000o, int i) throws IOException {
        O00000o0 o00000o0;
        O00000o0 o00000o02 = this.O000OO00[i].get("ImageLength");
        O00000o0 o00000o03 = this.O000OO00[i].get("ImageWidth");
        if ((o00000o02 == null || o00000o03 == null) && (o00000o0 = this.O000OO00[i].get("JPEGInterchangeFormat")) != null) {
            O000000o(o000000o, o00000o0.O00000o0(this.O000OO), i);
        }
    }

    private void O000000o(O000000o o000000o, HashMap hashMap) throws IOException {
        int i;
        O00000o0 o00000o0 = (O00000o0) hashMap.get("JPEGInterchangeFormat");
        O00000o0 o00000o02 = (O00000o0) hashMap.get("JPEGInterchangeFormatLength");
        if (o00000o0 != null && o00000o02 != null) {
            int O00000o02 = o00000o0.O00000o0(this.O000OO);
            int min = Math.min(o00000o02.O00000o0(this.O000OO), o000000o.available() - O00000o02);
            int i2 = this.O000O0oo;
            if (i2 == 4 || i2 == 9 || i2 == 10) {
                i = this.O000Oo00;
            } else {
                if (i2 == 7) {
                    i = this.O000Oo0;
                }
                if (O00000o02 > 0 && min > 0) {
                    this.O000OOOo = true;
                    this.O000OOo0 = O00000o02;
                    this.O000OOo = min;
                    if (this.O000O0o == null && this.O000O0oO == null) {
                        byte[] bArr = new byte[min];
                        o000000o.O000000o((long) O00000o02);
                        o000000o.readFully(bArr);
                        this.O000OOoO = bArr;
                        return;
                    }
                    return;
                }
            }
            O00000o02 += i;
            if (O00000o02 > 0) {
            }
        }
    }

    private void O00000Oo(O000000o o000000o, HashMap hashMap) throws IOException {
        O00000o0 o00000o0 = (O00000o0) hashMap.get("StripOffsets");
        O00000o0 o00000o02 = (O00000o0) hashMap.get("StripByteCounts");
        if (o00000o0 != null && o00000o02 != null) {
            long[] O000000o2 = O000000o(o00000o0.O000000o(this.O000OO));
            long[] O000000o3 = O000000o(o00000o02.O000000o(this.O000OO));
            if (O000000o2 == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
            } else if (O000000o3 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
            } else {
                long j = 0;
                for (long j2 : O000000o3) {
                    j += j2;
                }
                byte[] bArr = new byte[((int) j)];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < O000000o2.length; i3++) {
                    int i4 = (int) O000000o2[i3];
                    int i5 = (int) O000000o3[i3];
                    int i6 = i4 - i;
                    if (i6 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    o000000o.O000000o((long) i6);
                    int i7 = i + i6;
                    byte[] bArr2 = new byte[i5];
                    o000000o.read(bArr2);
                    i = i7 + i5;
                    System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                    i2 += bArr2.length;
                }
                this.O000OOOo = true;
                this.O000OOoO = bArr;
                this.O000OOo = bArr.length;
            }
        }
    }

    private boolean O000000o(HashMap hashMap) throws IOException {
        O00000o0 o00000o0 = (O00000o0) hashMap.get("ImageLength");
        O00000o0 o00000o02 = (O00000o0) hashMap.get("ImageWidth");
        if (o00000o0 == null || o00000o02 == null) {
            return false;
        }
        return o00000o0.O00000o0(this.O000OO) <= 512 && o00000o02.O00000o0(this.O000OO) <= 512;
    }

    private void O00000oo() throws IOException {
        O000000o(0, 5);
        O000000o(0, 4);
        O000000o(5, 4);
        O00000o0 o00000o0 = this.O000OO00[1].get("PixelXDimension");
        O00000o0 o00000o02 = this.O000OO00[1].get("PixelYDimension");
        if (!(o00000o0 == null || o00000o02 == null)) {
            this.O000OO00[0].put("ImageWidth", o00000o0);
            this.O000OO00[0].put("ImageLength", o00000o02);
        }
        if (this.O000OO00[4].isEmpty() && O000000o((HashMap) this.O000OO00[5])) {
            HashMap<String, O00000o0>[] hashMapArr = this.O000OO00;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!O000000o((HashMap) this.O000OO00[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    private void O00000o(O000000o o000000o, int i) throws IOException {
        O00000o0 o00000o0;
        O00000o0 o00000o02;
        O00000o0 o00000o03 = this.O000OO00[i].get("DefaultCropSize");
        O00000o0 o00000o04 = this.O000OO00[i].get("SensorTopBorder");
        O00000o0 o00000o05 = this.O000OO00[i].get("SensorLeftBorder");
        O00000o0 o00000o06 = this.O000OO00[i].get("SensorBottomBorder");
        O00000o0 o00000o07 = this.O000OO00[i].get("SensorRightBorder");
        if (o00000o03 != null) {
            if (o00000o03.f15020O000000o == 5) {
                O0000O0o[] o0000O0oArr = (O0000O0o[]) o00000o03.O000000o(this.O000OO);
                if (o0000O0oArr == null || o0000O0oArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(o0000O0oArr));
                    return;
                }
                o00000o02 = O00000o0.O000000o(o0000O0oArr[0], this.O000OO);
                o00000o0 = O00000o0.O000000o(o0000O0oArr[1], this.O000OO);
            } else {
                int[] iArr = (int[]) o00000o03.O000000o(this.O000OO);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                o00000o02 = O00000o0.O000000o(iArr[0], this.O000OO);
                o00000o0 = O00000o0.O000000o(iArr[1], this.O000OO);
            }
            this.O000OO00[i].put("ImageWidth", o00000o02);
            this.O000OO00[i].put("ImageLength", o00000o0);
        } else if (o00000o04 == null || o00000o05 == null || o00000o06 == null || o00000o07 == null) {
            O00000o0(o000000o, i);
        } else {
            int O00000o02 = o00000o04.O00000o0(this.O000OO);
            int O00000o03 = o00000o06.O00000o0(this.O000OO);
            int O00000o04 = o00000o07.O00000o0(this.O000OO);
            int O00000o05 = o00000o05.O00000o0(this.O000OO);
            if (O00000o03 > O00000o02 && O00000o04 > O00000o05) {
                O00000o0 O000000o2 = O00000o0.O000000o(O00000o03 - O00000o02, this.O000OO);
                O00000o0 O000000o3 = O00000o0.O000000o(O00000o04 - O00000o05, this.O000OO);
                this.O000OO00[i].put("ImageLength", O000000o2);
                this.O000OO00[i].put("ImageWidth", O000000o3);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dx.O00000o0.O000000o(long, java.nio.ByteOrder):_m_j.dx$O00000o0
     arg types: [int, java.nio.ByteOrder]
     candidates:
      _m_j.dx.O00000o0.O000000o(int, java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(_m_j.dx$O0000O0o, java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(double[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(int[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(long[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(_m_j.dx$O0000O0o[], java.nio.ByteOrder):_m_j.dx$O00000o0
      _m_j.dx.O00000o0.O000000o(long, java.nio.ByteOrder):_m_j.dx$O00000o0 */
    private int O000000o(O00000Oo o00000Oo) throws IOException {
        O00000o[][] o00000oArr = O0000OOo;
        int[] iArr = new int[o00000oArr.length];
        int[] iArr2 = new int[o00000oArr.length];
        for (O00000o o00000o : O00oOooO) {
            O00000o0(o00000o.O00000Oo);
        }
        O00000o0(O00oOooo.O00000Oo);
        O00000o0(O000O00o.O00000Oo);
        for (int i = 0; i < O0000OOo.length; i++) {
            for (Object obj : this.O000OO00[i].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.O000OO00[i].remove(entry.getKey());
                }
            }
        }
        if (!this.O000OO00[1].isEmpty()) {
            this.O000OO00[0].put(O00oOooO[1].O00000Oo, O00000o0.O000000o(0L, this.O000OO));
        }
        if (!this.O000OO00[2].isEmpty()) {
            this.O000OO00[0].put(O00oOooO[2].O00000Oo, O00000o0.O000000o(0L, this.O000OO));
        }
        if (!this.O000OO00[3].isEmpty()) {
            this.O000OO00[1].put(O00oOooO[3].O00000Oo, O00000o0.O000000o(0L, this.O000OO));
        }
        if (this.O000OOOo) {
            this.O000OO00[4].put(O00oOooo.O00000Oo, O00000o0.O000000o(0L, this.O000OO));
            this.O000OO00[4].put(O000O00o.O00000Oo, O00000o0.O000000o((long) this.O000OOo, this.O000OO));
        }
        for (int i2 = 0; i2 < O0000OOo.length; i2++) {
            int i3 = 0;
            for (Map.Entry<String, O00000o0> value : this.O000OO00[i2].entrySet()) {
                int O000000o2 = ((O00000o0) value.getValue()).O000000o();
                if (O000000o2 > 4) {
                    i3 += O000000o2;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int i4 = 8;
        for (int i5 = 0; i5 < O0000OOo.length; i5++) {
            if (!this.O000OO00[i5].isEmpty()) {
                iArr[i5] = i4;
                i4 += (this.O000OO00[i5].size() * 12) + 2 + 4 + iArr2[i5];
            }
        }
        if (this.O000OOOo) {
            this.O000OO00[4].put(O00oOooo.O00000Oo, O00000o0.O000000o((long) i4, this.O000OO));
            this.O000OOo0 = i4 + 6;
            i4 += this.O000OOo;
        }
        int i6 = i4 + 8;
        if (!this.O000OO00[1].isEmpty()) {
            this.O000OO00[0].put(O00oOooO[1].O00000Oo, O00000o0.O000000o((long) iArr[1], this.O000OO));
        }
        if (!this.O000OO00[2].isEmpty()) {
            this.O000OO00[0].put(O00oOooO[2].O00000Oo, O00000o0.O000000o((long) iArr[2], this.O000OO));
        }
        if (!this.O000OO00[3].isEmpty()) {
            this.O000OO00[1].put(O00oOooO[3].O00000Oo, O00000o0.O000000o((long) iArr[3], this.O000OO));
        }
        o00000Oo.O000000o((short) i6);
        o00000Oo.write(O0000Oo);
        o00000Oo.O000000o(this.O000OO == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        o00000Oo.f15018O000000o = this.O000OO;
        o00000Oo.O000000o((short) 42);
        o00000Oo.O00000Oo(8);
        for (int i7 = 0; i7 < O0000OOo.length; i7++) {
            if (!this.O000OO00[i7].isEmpty()) {
                o00000Oo.O000000o((short) this.O000OO00[i7].size());
                int size = iArr[i7] + 2 + (this.O000OO00[i7].size() * 12) + 4;
                for (Map.Entry next : this.O000OO00[i7].entrySet()) {
                    int i8 = O000O0Oo[i7].get(next.getKey()).f15019O000000o;
                    O00000o0 o00000o0 = (O00000o0) next.getValue();
                    int O000000o3 = o00000o0.O000000o();
                    o00000Oo.O000000o((short) i8);
                    o00000Oo.O000000o((short) o00000o0.f15020O000000o);
                    o00000Oo.O00000Oo(o00000o0.O00000Oo);
                    if (O000000o3 > 4) {
                        o00000Oo.O00000Oo((int) ((long) size));
                        size += O000000o3;
                    } else {
                        o00000Oo.write(o00000o0.O00000o0);
                        if (O000000o3 < 4) {
                            while (O000000o3 < 4) {
                                o00000Oo.O000000o(0);
                                O000000o3++;
                            }
                        }
                    }
                }
                if (i7 != 0 || this.O000OO00[4].isEmpty()) {
                    o00000Oo.O00000Oo(0);
                } else {
                    o00000Oo.O00000Oo((int) ((long) iArr[4]));
                }
                for (Map.Entry<String, O00000o0> value2 : this.O000OO00[i7].entrySet()) {
                    O00000o0 o00000o02 = (O00000o0) value2.getValue();
                    if (o00000o02.O00000o0.length > 4) {
                        o00000Oo.write(o00000o02.O00000o0, 0, o00000o02.O00000o0.length);
                    }
                }
            }
        }
        if (this.O000OOOo) {
            o00000Oo.write(O00000o());
        }
        o00000Oo.f15018O000000o = ByteOrder.BIG_ENDIAN;
        return i6;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    private static Pair<Integer, Integer> O00000o(String str) {
        int i;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> O00000o2 = O00000o(split[0]);
            if (((Integer) O00000o2.first).intValue() == 2) {
                return O00000o2;
            }
            for (int i2 = 1; i2 < split.length; i2++) {
                Pair<Integer, Integer> O00000o3 = O00000o(split[i2]);
                if (((Integer) O00000o3.first).equals(O00000o2.first) || ((Integer) O00000o3.second).equals(O00000o2.first)) {
                    i = ((Integer) O00000o2.first).intValue();
                } else {
                    i = -1;
                }
                int intValue = (((Integer) O00000o2.second).intValue() == -1 || (!((Integer) O00000o3.first).equals(O00000o2.second) && !((Integer) O00000o3.second).equals(O00000o2.second))) ? -1 : ((Integer) O00000o2.second).intValue();
                if (i == -1 && intValue == -1) {
                    return new Pair<>(2, -1);
                }
                if (i == -1) {
                    O00000o2 = new Pair<>(Integer.valueOf(intValue), -1);
                } else if (intValue == -1) {
                    O00000o2 = new Pair<>(Integer.valueOf(i), -1);
                }
            }
            return O00000o2;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0) {
                        if (parseDouble2 >= 0) {
                            if (parseDouble <= 2147483647L) {
                                if (parseDouble2 <= 2147483647L) {
                                    return new Pair<>(10, 5);
                                }
                            }
                            return new Pair<>(5, -1);
                        }
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair<>(2, -1);
        } else {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            if (valueOf.longValue() >= 0 && valueOf.longValue() <= 65535) {
                return new Pair<>(3, 4);
            }
            if (valueOf.longValue() < 0) {
                return new Pair<>(9, -1);
            }
            return new Pair<>(4, -1);
        }
    }

    static class O000000o extends InputStream implements DataInput {
        private static final ByteOrder O00000o = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder O00000oO = ByteOrder.BIG_ENDIAN;

        /* renamed from: O000000o  reason: collision with root package name */
        ByteOrder f15017O000000o;
        final int O00000Oo;
        int O00000o0;
        private DataInputStream O00000oo;

        public O000000o(InputStream inputStream) throws IOException {
            this.f15017O000000o = ByteOrder.BIG_ENDIAN;
            this.O00000oo = new DataInputStream(inputStream);
            this.O00000Oo = this.O00000oo.available();
            this.O00000o0 = 0;
            this.O00000oo.mark(this.O00000Oo);
        }

        public O000000o(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        public final void O000000o(long j) throws IOException {
            int i = this.O00000o0;
            if (((long) i) > j) {
                this.O00000o0 = 0;
                this.O00000oo.reset();
                this.O00000oo.mark(this.O00000Oo);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public final int available() throws IOException {
            return this.O00000oo.available();
        }

        public final int read() throws IOException {
            this.O00000o0++;
            return this.O00000oo.read();
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.O00000oo.read(bArr, i, i2);
            this.O00000o0 += read;
            return read;
        }

        public final int readUnsignedByte() throws IOException {
            this.O00000o0++;
            return this.O00000oo.readUnsignedByte();
        }

        public final String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public final boolean readBoolean() throws IOException {
            this.O00000o0++;
            return this.O00000oo.readBoolean();
        }

        public final char readChar() throws IOException {
            this.O00000o0 += 2;
            return this.O00000oo.readChar();
        }

        public final String readUTF() throws IOException {
            this.O00000o0 += 2;
            return this.O00000oo.readUTF();
        }

        public final void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.O00000o0 += i2;
            if (this.O00000o0 > this.O00000Oo) {
                throw new EOFException();
            } else if (this.O00000oo.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final void readFully(byte[] bArr) throws IOException {
            this.O00000o0 += bArr.length;
            if (this.O00000o0 > this.O00000Oo) {
                throw new EOFException();
            } else if (this.O00000oo.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public final byte readByte() throws IOException {
            this.O00000o0++;
            if (this.O00000o0 <= this.O00000Oo) {
                int read = this.O00000oo.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final short readShort() throws IOException {
            this.O00000o0 += 2;
            if (this.O00000o0 <= this.O00000Oo) {
                int read = this.O00000oo.read();
                int read2 = this.O00000oo.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f15017O000000o;
                    if (byteOrder == O00000o) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == O00000oO) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f15017O000000o);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final int readInt() throws IOException {
            this.O00000o0 += 4;
            if (this.O00000o0 <= this.O00000Oo) {
                int read = this.O00000oo.read();
                int read2 = this.O00000oo.read();
                int read3 = this.O00000oo.read();
                int read4 = this.O00000oo.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f15017O000000o;
                    if (byteOrder == O00000o) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == O00000oO) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f15017O000000o);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.O00000Oo - this.O00000o0);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.O00000oo.skipBytes(min - i2);
            }
            this.O00000o0 += i2;
            return i2;
        }

        public final int readUnsignedShort() throws IOException {
            this.O00000o0 += 2;
            if (this.O00000o0 <= this.O00000Oo) {
                int read = this.O00000oo.read();
                int read2 = this.O00000oo.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f15017O000000o;
                    if (byteOrder == O00000o) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == O00000oO) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f15017O000000o);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final long O000000o() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public final long readLong() throws IOException {
            this.O00000o0 += 8;
            if (this.O00000o0 <= this.O00000Oo) {
                int read = this.O00000oo.read();
                int read2 = this.O00000oo.read();
                int read3 = this.O00000oo.read();
                int read4 = this.O00000oo.read();
                int read5 = this.O00000oo.read();
                int read6 = this.O00000oo.read();
                int read7 = this.O00000oo.read();
                int read8 = this.O00000oo.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f15017O000000o;
                    if (byteOrder == O00000o) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i = read2;
                    if (byteOrder == O00000oO) {
                        return (((long) read) << 56) + (((long) i) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.f15017O000000o);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    static class O00000Oo extends FilterOutputStream {

        /* renamed from: O000000o  reason: collision with root package name */
        ByteOrder f15018O000000o;
        private final OutputStream O00000Oo;

        public O00000Oo(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.O00000Oo = outputStream;
            this.f15018O000000o = byteOrder;
        }

        public final void write(byte[] bArr) throws IOException {
            this.O00000Oo.write(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            this.O00000Oo.write(bArr, i, i2);
        }

        public final void O000000o(int i) throws IOException {
            this.O00000Oo.write(i);
        }

        public final void O000000o(short s) throws IOException {
            if (this.f15018O000000o == ByteOrder.LITTLE_ENDIAN) {
                this.O00000Oo.write((s >>> 0) & 255);
                this.O00000Oo.write((s >>> 8) & 255);
            } else if (this.f15018O000000o == ByteOrder.BIG_ENDIAN) {
                this.O00000Oo.write((s >>> 8) & 255);
                this.O00000Oo.write((s >>> 0) & 255);
            }
        }

        public final void O00000Oo(int i) throws IOException {
            if (this.f15018O000000o == ByteOrder.LITTLE_ENDIAN) {
                this.O00000Oo.write((i >>> 0) & 255);
                this.O00000Oo.write((i >>> 8) & 255);
                this.O00000Oo.write((i >>> 16) & 255);
                this.O00000Oo.write((i >>> 24) & 255);
            } else if (this.f15018O000000o == ByteOrder.BIG_ENDIAN) {
                this.O00000Oo.write((i >>> 24) & 255);
                this.O00000Oo.write((i >>> 16) & 255);
                this.O00000Oo.write((i >>> 8) & 255);
                this.O00000Oo.write((i >>> 0) & 255);
            }
        }
    }

    private void O000000o(int i, int i2) throws IOException {
        if (!this.O000OO00[i].isEmpty() && !this.O000OO00[i2].isEmpty()) {
            O00000o0 o00000o0 = this.O000OO00[i].get("ImageLength");
            O00000o0 o00000o02 = this.O000OO00[i].get("ImageWidth");
            O00000o0 o00000o03 = this.O000OO00[i2].get("ImageLength");
            O00000o0 o00000o04 = this.O000OO00[i2].get("ImageWidth");
            if (o00000o0 != null && o00000o02 != null && o00000o03 != null && o00000o04 != null) {
                int O00000o02 = o00000o0.O00000o0(this.O000OO);
                int O00000o03 = o00000o02.O00000o0(this.O000OO);
                int O00000o04 = o00000o03.O00000o0(this.O000OO);
                int O00000o05 = o00000o04.O00000o0(this.O000OO);
                if (O00000o02 < O00000o04 && O00000o03 < O00000o05) {
                    HashMap<String, O00000o0>[] hashMapArr = this.O000OO00;
                    HashMap<String, O00000o0> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            }
        }
    }

    private static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private static int O00000Oo(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private static long[] O000000o(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
