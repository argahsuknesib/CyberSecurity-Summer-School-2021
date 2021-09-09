package com.google.android.exoplayer2.util;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class Util {
    private static final int[] CRC32_BYTES_MSBF = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] CRC8_BYTES_MSBF = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, NotificationCompat.FLAG_HIGH_PRIORITY, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    public static final String DEVICE = Build.DEVICE;
    public static final String DEVICE_DEBUG_INFO = (DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT);
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final Pattern ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
    public static final String MANUFACTURER = Build.MANUFACTURER;
    public static final String MODEL = Build.MODEL;
    public static final int SDK_INT = Build.VERSION.SDK_INT;
    private static final Pattern XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final String[] additionalIsoLanguageReplacements = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] isoGrandfatheredTagReplacements = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static HashMap<String, String> languageTagReplacementMap;

    public static long addWithOverflowDefault(long j, long j2, long j3) {
        long j4 = j + j2;
        return ((j ^ j4) & (j2 ^ j4)) < 0 ? j3 : j4;
    }

    public static <T> T castNonNull(T t) {
        return t;
    }

    public static <T> T[] castNonNullTypeArray(T[] tArr) {
        return tArr;
    }

    public static int compareLong(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static int getAudioContentTypeForStreamType(int i) {
        if (i != 0) {
            return (i == 1 || i == 2 || i == 4 || i == 5 || i == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioUsageForStreamType(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 1) {
            return 13;
        }
        if (i == 2) {
            return 6;
        }
        int i2 = 4;
        if (i != 4) {
            i2 = 5;
            if (i != 5) {
                return i != 8 ? 1 : 3;
            }
        }
        return i2;
    }

    public static int getPcmEncoding(int i) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 2;
        }
        if (i != 24) {
            return i != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int getStreamTypeForAudioUsage(int i) {
        switch (i) {
            case 1:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    public static boolean isEncodingHighResolutionPcm(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean isEncodingLinearPcm(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    public static boolean isLinebreak(int i) {
        return i == 10 || i == 13;
    }

    private static boolean shouldEscapeCharacter(char c) {
        return c == '\"' || c == '%' || c == '*' || c == '/' || c == ':' || c == '<' || c == '\\' || c == '|' || c == '>' || c == '?';
    }

    public static long subtractWithOverflowDefault(long j, long j2, long j3) {
        long j4 = j - j2;
        return ((j ^ j4) & (j2 ^ j)) < 0 ? j3 : j4;
    }

    public static long toUnsignedLong(int i) {
        return ((long) i) & 4294967295L;
    }

    private Util() {
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        if (SDK_INT >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (Uri isLocalFileUri : uriArr) {
            if (isLocalFileUri(isLocalFileUri)) {
                return requestExternalStoragePermission(activity);
            }
        }
        return false;
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, MediaItem... mediaItemArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            if (mediaItem.playbackProperties != null) {
                if (isLocalFileUri(mediaItem.playbackProperties.sourceUri)) {
                    return requestExternalStoragePermission(activity);
                }
                for (int i = 0; i < mediaItem.playbackProperties.subtitles.size(); i++) {
                    if (isLocalFileUri(mediaItem.playbackProperties.subtitles.get(i).uri)) {
                        return requestExternalStoragePermission(activity);
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static boolean checkCleartextTrafficPermitted(MediaItem... mediaItemArr) {
        if (SDK_INT < 24) {
            return true;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            if (mediaItem.playbackProperties != null) {
                if (isTrafficRestricted(mediaItem.playbackProperties.sourceUri)) {
                    return false;
                }
                for (int i = 0; i < mediaItem.playbackProperties.subtitles.size(); i++) {
                    if (isTrafficRestricted(mediaItem.playbackProperties.subtitles.get(i).uri)) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    public static boolean isLocalFileUri(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean contains(Object[] objArr, Object obj) {
        for (Object areEqual : objArr) {
            if (areEqual(areEqual, obj)) {
                return true;
            }
        }
        return false;
    }

    public static <T> void removeRange(List<T> list, int i, int i2) {
        if (i < 0 || i2 > list.size() || i > i2) {
            throw new IllegalArgumentException();
        } else if (i != i2) {
            list.subList(i, i2).clear();
        }
    }

    public static <T> T[] nullSafeArrayCopy(T[] tArr, int i) {
        Assertions.checkArgument(i <= tArr.length);
        return Arrays.copyOf(tArr, i);
    }

    public static <T> T[] nullSafeArrayCopyOfRange(T[] tArr, int i, int i2) {
        boolean z = true;
        Assertions.checkArgument(i >= 0);
        if (i2 > tArr.length) {
            z = false;
        }
        Assertions.checkArgument(z);
        return Arrays.copyOfRange(tArr, i, i2);
    }

    public static <T> T[] nullSafeArrayAppend(T[] tArr, T t) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t;
        return castNonNullTypeArray(copyOf);
    }

    public static <T> T[] nullSafeArrayConcatenation(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    public static Handler createHandler() {
        return createHandler(null);
    }

    public static Handler createHandler(Handler.Callback callback) {
        return createHandler(getLooper(), callback);
    }

    public static Handler createHandler(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return myLooper;
        }
        return Looper.getMainLooper();
    }

    static /* synthetic */ Thread lambda$newSingleThreadExecutor$0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory(str) {
            /* class com.google.android.exoplayer2.util.$$Lambda$Util$MRC4FgxCpRGDforKjF0m_7VaCA */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Thread newThread(Runnable runnable) {
                return Util.lambda$newSingleThreadExecutor$0(this.f$0, runnable);
            }
        });
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static String getLocaleLanguageTag(Locale locale) {
        return SDK_INT >= 21 ? getLocaleLanguageTagV21(locale) : locale.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    public static String normalizeLanguageCode(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !"und".equals(replace)) {
            str = replace;
        }
        String lowerInvariant = toLowerInvariant(str);
        String str2 = splitAtFirst(lowerInvariant, "-")[0];
        if (languageTagReplacementMap == null) {
            languageTagReplacementMap = createIsoLanguageReplacementMap();
        }
        String str3 = languageTagReplacementMap.get(str2);
        if (str3 != null) {
            lowerInvariant = str3 + lowerInvariant.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? maybeReplaceGrandfatheredLanguageTags(lowerInvariant) : lowerInvariant;
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static String fromUtf8Bytes(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, Charset.forName("UTF-8"));
    }

    public static byte[] getUtf8Bytes(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static String[] split(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] splitAtFirst(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String toLowerInvariant(String str) {
        return str == null ? str : str.toLowerCase(Locale.US);
    }

    public static String toUpperInvariant(String str) {
        return str == null ? str : str.toUpperCase(Locale.US);
    }

    public static String formatInvariant(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static long ceilDivide(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int constrainValue(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static long constrainValue(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    public static float constrainValue(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    public static int linearSearch(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public static int binarySearchFloor(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i2 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (iArr[binarySearch] == i);
            i2 = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i2) : i2;
    }

    public static int binarySearchFloor(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static <T extends Comparable<? super T>> int binarySearchFloor(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (((Comparable) list.get(binarySearch)).compareTo(t) == 0);
            i = z ? binarySearch + 1 : binarySearch;
        }
        return z2 ? Math.max(0, i) : i;
    }

    public static int binarySearchFloor(LongArray longArray, long j, boolean z, boolean z2) {
        int i;
        int size = longArray.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (longArray.get(i3) < j) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        if (z && (i = size + 1) < longArray.size() && longArray.get(i) == j) {
            return i;
        }
        if (!z2 || size != -1) {
            return size;
        }
        return 0;
    }

    public static int binarySearchCeil(int[] iArr, int i, boolean z, boolean z2) {
        int i2;
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            i2 = binarySearch ^ -1;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= iArr.length) {
                    break;
                }
            } while (iArr[binarySearch] == i);
            i2 = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(iArr.length - 1, i2) : i2;
    }

    public static int binarySearchCeil(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = binarySearch ^ -1;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(jArr.length - 1, i) : i;
    }

    public static <T extends Comparable<? super T>> int binarySearchCeil(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int i;
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            i = binarySearch ^ -1;
        } else {
            int size = list.size();
            do {
                binarySearch++;
                if (binarySearch >= size) {
                    break;
                }
            } while (((Comparable) list.get(binarySearch)).compareTo(t) == 0);
            i = z ? binarySearch - 1 : binarySearch;
        }
        return z2 ? Math.min(list.size() - 1, i) : i;
    }

    public static long parseXsDuration(String str) {
        Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d = 0.0d;
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
        String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
        String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? 3600.0d * Double.parseDouble(group4) : 0.0d);
        String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
        String group6 = matcher.group(14);
        if (group6 != null) {
            d = Double.parseDouble(group6);
        }
        long j = (long) ((parseDouble5 + d) * 1000.0d);
        return isEmpty ? -j : j;
    }

    public static long parseXsDateTime(String str) throws ParserException {
        Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (matcher.matches()) {
            int i = 0;
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i *= -1;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            return i != 0 ? timeInMillis - ((long) (i * 60000)) : timeInMillis;
        }
        throw new ParserException("Invalid date/time format: ".concat(String.valueOf(str)));
    }

    public static long scaleLargeTimestamp(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        double d = (double) j2;
        double d2 = (double) j3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (double) j;
        Double.isNaN(d3);
        return (long) (d3 * (d / d2));
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long j, long j2) {
        long[] jArr = new long[list.size()];
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = list.get(i).longValue() / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d = (double) j;
            double d2 = (double) j2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d / d2;
            while (i < jArr.length) {
                double longValue = (double) list.get(i).longValue();
                Double.isNaN(longValue);
                jArr[i] = (long) (longValue * d3);
                i++;
            }
        } else {
            long j4 = j / j2;
            while (i < jArr.length) {
                jArr[i] = list.get(i).longValue() * j4;
                i++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j, long j2) {
        int i = 0;
        if (j2 >= j && j2 % j == 0) {
            long j3 = j2 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j3;
                i++;
            }
        } else if (j2 >= j || j % j2 != 0) {
            double d = (double) j;
            double d2 = (double) j2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = d / d2;
            while (i < jArr.length) {
                double d4 = (double) jArr[i];
                Double.isNaN(d4);
                jArr[i] = (long) (d4 * d3);
                i++;
            }
        } else {
            long j4 = j / j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j4;
                i++;
            }
        }
    }

    public static long getMediaDurationForPlayoutDuration(long j, float f) {
        if (f == 1.0f) {
            return j;
        }
        double d = (double) j;
        double d2 = (double) f;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d * d2);
    }

    public static long getPlayoutDurationForMediaDuration(long j, float f) {
        if (f == 1.0f) {
            return j;
        }
        double d = (double) j;
        double d2 = (double) f;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    public static int[] toArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static List<Integer> toList(int... iArr) {
        if (iArr == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static int getIntegerCodeForString(String str) {
        int length = str.length();
        Assertions.checkArgument(length <= 4);
        char c = 0;
        for (int i = 0; i < length; i++) {
            c = (c << 8) | str.charAt(i);
        }
        return c;
    }

    public static long toLong(int i, int i2) {
        return toUnsignedLong(i2) | (toUnsignedLong(i) << 32);
    }

    public static byte[] getBytesFromHexString(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(Character.forDigit((bArr[i] >> 4) & 15, 16));
            sb.append(Character.forDigit(bArr[i] & 15, 16));
        }
        return sb.toString();
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.11.4";
    }

    public static String getCodecsOfType(String str, int i) {
        String[] splitCodecs = splitCodecs(str);
        if (splitCodecs.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : splitCodecs) {
            if (i == MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static String[] splitCodecs(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return split(str.trim(), "(\\s*,\\s*)");
    }

    public static int getAudioTrackChannelConfig(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                int i2 = SDK_INT;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int getPcmFrameSize(int i, int i2) {
        if (i != 2) {
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                if (i != 268435456) {
                    if (i == 536870912) {
                        return i2 * 3;
                    }
                    if (i != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i2 * 4;
        }
        return i2 * 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c  */
    public static UUID getDrmUuid(String str) {
        char c;
        String lowerInvariant = toLowerInvariant(str);
        int hashCode = lowerInvariant.hashCode();
        if (hashCode != -1860423953) {
            if (hashCode != -1400551171) {
                if (hashCode == 790309106 && lowerInvariant.equals("clearkey")) {
                    c = 2;
                    if (c != 0) {
                        return C.WIDEVINE_UUID;
                    }
                    if (c == 1) {
                        return C.PLAYREADY_UUID;
                    }
                    if (c == 2) {
                        return C.CLEARKEY_UUID;
                    }
                    try {
                        return UUID.fromString(str);
                    } catch (RuntimeException unused) {
                        return null;
                    }
                }
            } else if (lowerInvariant.equals("widevine")) {
                c = 0;
                if (c != 0) {
                }
            }
        } else if (lowerInvariant.equals("playready")) {
            c = 1;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    public static int inferContentType(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        return inferContentType(".".concat(String.valueOf(str)));
    }

    public static int inferContentType(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return 3;
        }
        return inferContentType(path);
    }

    public static int inferContentType(String str) {
        String lowerInvariant = toLowerInvariant(str);
        if (lowerInvariant.endsWith(".mpd")) {
            return 0;
        }
        if (lowerInvariant.endsWith(".m3u8")) {
            return 2;
        }
        return lowerInvariant.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
    }

    public static String getStringForTime(StringBuilder sb, Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j2 = (j + 500) / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        sb.setLength(0);
        if (j5 > 0) {
            return formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString();
        }
        return formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder}
     arg types: [java.lang.String, int, int]
     candidates:
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(char[], int, int):java.lang.StringBuilder}
      ClspMth{java.lang.Appendable.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder} */
    public static String escapeFileName(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (shouldEscapeCharacter(str.charAt(i3))) {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder((i2 * 2) + length);
        while (i2 > 0) {
            int i4 = i + 1;
            char charAt = str.charAt(i);
            if (shouldEscapeCharacter(charAt)) {
                sb.append('%');
                sb.append(Integer.toHexString(charAt));
                i2--;
            } else {
                sb.append(charAt);
            }
            i = i4;
        }
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder}
     arg types: [java.lang.String, int, int]
     candidates:
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(char[], int, int):java.lang.StringBuilder}
      ClspMth{java.lang.Appendable.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder} */
    public static String unescapeFileName(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '%') {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        int i4 = length - (i2 * 2);
        StringBuilder sb = new StringBuilder(i4);
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
        while (i2 > 0 && matcher.find()) {
            sb.append((CharSequence) str, i, matcher.start());
            sb.append((char) Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)), 16));
            i = matcher.end();
            i2--;
        }
        if (i < length) {
            sb.append((CharSequence) str, i, length);
        }
        if (sb.length() != i4) {
            return null;
        }
        return sb.toString();
    }

    public static void sneakyThrow(Throwable th) {
        sneakyThrowInternal(th);
    }

    private static <T extends Throwable> void sneakyThrowInternal(Throwable th) throws Throwable {
        throw th;
    }

    public static void recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveDelete : listFiles) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        File createTempFile = createTempFile(context, str);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(str, null, context.getCacheDir());
    }

    public static int crc32(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = CRC32_BYTES_MSBF[((i3 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    public static int crc8(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = CRC8_BYTES_MSBF[i3 ^ (bArr[i] & 255)];
            i++;
        }
        return i3;
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager;
        int i = 0;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return getMobileNetworkType(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    public static String getCountryCode(Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return toUpperInvariant(networkCountryIso);
            }
        }
        return toUpperInvariant(Locale.getDefault().getCountry());
    }

    public static String[] getSystemLanguageCodes() {
        String[] systemLocales = getSystemLocales();
        for (int i = 0; i < systemLocales.length; i++) {
            systemLocales[i] = normalizeLanguageCode(systemLocales[i]);
        }
        return systemLocales;
    }

    public static boolean inflate(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.bytesLeft() <= 0) {
            return false;
        }
        byte[] bArr = parsableByteArray2.data;
        if (bArr.length < parsableByteArray.bytesLeft()) {
            bArr = new byte[(parsableByteArray.bytesLeft() * 2)];
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.data, parsableByteArray.getPosition(), parsableByteArray.bytesLeft());
        int i = 0;
        while (true) {
            try {
                i += inflater.inflate(bArr, i, bArr.length - i);
                if (inflater.finished()) {
                    parsableByteArray2.reset(bArr, i);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else if (i == bArr.length) {
                    bArr = Arrays.copyOf(bArr, bArr.length * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Point getCurrentDisplayModeSize(Context context) {
        return getCurrentDisplayModeSize(context, ((WindowManager) context.getSystemService("window")).getDefaultDisplay());
    }

    public static Point getCurrentDisplayModeSize(Context context, Display display) {
        String str;
        if (SDK_INT <= 29 && display.getDisplayId() == 0 && isTv(context)) {
            if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            if (SDK_INT < 28) {
                str = getSystemProperty("sys.display-size");
            } else {
                str = getSystemProperty("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = split(str.trim(), "x");
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.e("Util", "Invalid display size: ".concat(String.valueOf(str)));
            }
        }
        Point point = new Point();
        int i = SDK_INT;
        if (i >= 23) {
            getDisplaySizeV23(display, point);
        } else if (i >= 17) {
            getDisplaySizeV17(display, point);
        } else {
            getDisplaySizeV16(display, point);
        }
        return point;
    }

    public static String getTrackTypeString(int i) {
        switch (i) {
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "metadata";
            case 5:
                return "camera motion";
            case 6:
                return "none";
            default:
                if (i < 10000) {
                    return "?";
                }
                return "custom (" + i + ")";
        }
    }

    public static long getNowUnixTimeMs(long j) {
        if (j == -9223372036854775807L) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + j;
    }

    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            Log.e("Util", "Failed to read system property ".concat(String.valueOf(str)), e);
            return null;
        }
    }

    private static void getDisplaySizeV23(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    private static String[] getSystemLocales() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (SDK_INT >= 24) {
            return getSystemLocalesV24(configuration);
        }
        return new String[]{getLocaleLanguageTag(configuration.locale)};
    }

    private static String[] getSystemLocalesV24(Configuration configuration) {
        return split(configuration.getLocales().toLanguageTags(), ",");
    }

    private static String getLocaleLanguageTagV21(Locale locale) {
        return locale.toLanguageTag();
    }

    private static int getMobileNetworkType(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
            case 10:
            case 11:
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 14:
            case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return 9;
        }
    }

    private static HashMap<String, String> createIsoLanguageReplacementMap() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + additionalIsoLanguageReplacements.length);
        int i = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = additionalIsoLanguageReplacements;
            if (i >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    private static boolean requestExternalStoragePermission(Activity activity) {
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        return true;
    }

    private static boolean isTrafficRestricted(Uri uri) {
        return "http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted((String) Assertions.checkNotNull(uri.getHost()));
    }

    private static String maybeReplaceGrandfatheredLanguageTags(String str) {
        int i = 0;
        while (true) {
            String[] strArr = isoGrandfatheredTagReplacements;
            if (i >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i])) {
                return isoGrandfatheredTagReplacements[i + 1] + str.substring(isoGrandfatheredTagReplacements[i].length());
            }
            i += 2;
        }
    }
}
