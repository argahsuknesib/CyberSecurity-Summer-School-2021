package com.xiaomi.smarthome.download;

import _m_j.frm;
import _m_j.gsy;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Helpers {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Random f7316O000000o = new Random(SystemClock.uptimeMillis());
    private static final Pattern O00000Oo = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    private static String O00000o0(String str) {
        try {
            Matcher matcher = O00000Oo.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static class GenerateSaveFileError extends Exception {
        private static final long serialVersionUID = 4293675292408637112L;
        String mMessage;
        int mStatus;

        public GenerateSaveFileError(int i, String str) {
            this.mStatus = i;
            this.mMessage = str;
        }
    }

    public static File O000000o(String str) {
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        if (str.startsWith(downloadCacheDirectory.getPath())) {
            return downloadCacheDirectory;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (str.startsWith(externalStorageDirectory.getPath())) {
            return externalStorageDirectory;
        }
        throw new IllegalArgumentException("Cannot determine filesystem root for ".concat(String.valueOf(str)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.download.Helpers.O000000o(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.download.Helpers.O000000o(java.lang.String, java.util.Set<java.lang.String>):void
      com.xiaomi.smarthome.download.Helpers.O000000o(java.lang.String, boolean):java.lang.String */
    private static String O000000o(String str, String str2, String str3, String str4, String str5) throws GenerateSaveFileError {
        String str6;
        String O000000o2 = O000000o(str2, str3, str4);
        int indexOf = O000000o2.indexOf(46);
        if (indexOf < 0) {
            str6 = O000000o(str5, true);
        } else {
            String O000000o3 = O000000o(str5, O000000o2, indexOf);
            O000000o2 = O000000o2.substring(0, indexOf);
            str6 = O000000o3;
        }
        boolean equalsIgnoreCase = "recovery".equalsIgnoreCase(O000000o2 + str6);
        String str7 = str + File.separator + O000000o2;
        gsy.O000000o(2, "DownloadManager", "target file: " + str7 + str6);
        return O000000o(str7, str6, equalsIgnoreCase);
    }

    public static boolean O000000o() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        gsy.O000000o(3, "DownloadManager", "no external storage");
        return false;
    }

    public static long O000000o(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
    }

    private static String O000000o(String str, String str2, String str3) {
        String str4;
        String decode;
        int lastIndexOf;
        String decode2;
        if (str2 != null) {
            str4 = O00000o0(str2);
            if (str4 != null) {
                gsy.O000000o(2, "DownloadManager", "getting filename from content-disposition");
                int lastIndexOf2 = str4.lastIndexOf(47) + 1;
                if (lastIndexOf2 > 0) {
                    str4 = str4.substring(lastIndexOf2);
                }
            }
        } else {
            str4 = null;
        }
        if (str4 == null && str3 != null && (decode2 = Uri.decode(str3)) != null && !decode2.endsWith("/") && decode2.indexOf(63) < 0) {
            gsy.O000000o(2, "DownloadManager", "getting filename from content-location");
            int lastIndexOf3 = decode2.lastIndexOf(47) + 1;
            str4 = lastIndexOf3 > 0 ? decode2.substring(lastIndexOf3) : decode2;
        }
        if (str4 == null && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
            gsy.O000000o(2, "DownloadManager", "getting filename from uri");
            str4 = decode.substring(lastIndexOf);
        }
        if (str4 == null) {
            gsy.O000000o(2, "DownloadManager", "using default filename");
            str4 = "downloadfile";
        }
        return str4.replaceAll("[^a-zA-Z0-9\\.\\-_]+", "_");
    }

    private static String O000000o(String str, boolean z) {
        String str2;
        if (str != null) {
            str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            if (str2 != null) {
                gsy.O000000o(2, "DownloadManager", "adding extension from type");
                str2 = ".".concat(String.valueOf(str2));
            } else {
                gsy.O000000o(2, "DownloadManager", "couldn't find extension for ".concat(String.valueOf(str)));
            }
        } else {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        if (str == null || !str.toLowerCase().startsWith("text/")) {
            if (!z) {
                return str2;
            }
            gsy.O000000o(2, "DownloadManager", "adding default binary extension");
            return ".bin";
        } else if (str.equalsIgnoreCase("text/html")) {
            gsy.O000000o(2, "DownloadManager", "adding default html extension");
            return ".html";
        } else if (!z) {
            return str2;
        } else {
            gsy.O000000o(2, "DownloadManager", "adding default text extension");
            return ".txt";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.download.Helpers.O000000o(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.download.Helpers.O000000o(java.lang.String, java.util.Set<java.lang.String>):void
      com.xiaomi.smarthome.download.Helpers.O000000o(java.lang.String, boolean):java.lang.String */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    private static String O000000o(String str, String str2, int i) {
        String str3;
        if (str != null) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.substring(str2.lastIndexOf(46) + 1));
            if (mimeTypeFromExtension == null || !mimeTypeFromExtension.equalsIgnoreCase(str)) {
                str3 = O000000o(str, false);
                if (str3 != null) {
                    gsy.O000000o(2, "DownloadManager", "substituting extension from type");
                } else {
                    gsy.O000000o(2, "DownloadManager", "couldn't find extension for ".concat(String.valueOf(str)));
                }
                if (str3 == null) {
                    return str3;
                }
                gsy.O000000o(2, "DownloadManager", "keeping extension");
                return str2.substring(i);
            }
        }
        str3 = null;
        if (str3 == null) {
        }
    }

    private static String O000000o(String str, String str2, boolean z) throws GenerateSaveFileError {
        String str3 = str + str2;
        if (!new File(str3).exists() && !z) {
            return str3;
        }
        String str4 = str + "-";
        int i = 1;
        for (int i2 = 1; i2 < 1000000000; i2 *= 10) {
            for (int i3 = 0; i3 < 9; i3++) {
                String str5 = str4 + i + str2;
                if (!new File(str5).exists()) {
                    return str5;
                }
                gsy.O000000o(2, "DownloadManager", "file with sequence number " + i + " exists");
                i += f7316O000000o.nextInt(i2) + 1;
            }
        }
        throw new GenerateSaveFileError(492, "failed to generate an unused filename on internal download storage");
    }

    public static boolean O000000o(frm frm) {
        return frm.O00000Oo() != null;
    }

    public static boolean O00000Oo(String str) {
        String replaceFirst = str.replaceFirst("/+", "/");
        return replaceFirst.startsWith(Environment.getDownloadCacheDirectory().toString()) || replaceFirst.startsWith(Environment.getExternalStorageDirectory().toString());
    }

    public static void O000000o(String str, Set<String> set) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    O000000o o000000o = new O000000o(str, set);
                    O000000o(o000000o);
                    if (o000000o.f7317O000000o != 9) {
                        throw new IllegalArgumentException("syntax error");
                    }
                }
            } catch (RuntimeException e) {
                gsy.O000000o(3, "DownloadManager", "invalid selection triggered ".concat(String.valueOf(e)));
                throw e;
            }
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f7317O000000o = 0;
        private final String O00000Oo;
        private int O00000o = 0;
        private final Set<String> O00000o0;
        private final char[] O00000oO;

        private static final boolean O000000o(char c) {
            if (c == '_') {
                return true;
            }
            if (c < 'A' || c > 'Z') {
                return c >= 'a' && c <= 'z';
            }
            return true;
        }

        private static final boolean O00000Oo(char c) {
            if (c == '_') {
                return true;
            }
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
            if (c < 'a' || c > 'z') {
                return c >= '0' && c <= '9';
            }
            return true;
        }

        public O000000o(String str, Set<String> set) {
            this.O00000Oo = str;
            this.O00000o0 = set;
            this.O00000oO = new char[this.O00000Oo.length()];
            String str2 = this.O00000Oo;
            char[] cArr = this.O00000oO;
            str2.getChars(0, cArr.length, cArr, 0);
            O000000o();
        }

        public final void O000000o() {
            char[] cArr = this.O00000oO;
            while (true) {
                int i = this.O00000o;
                if (i >= cArr.length || cArr[i] != ' ') {
                    int i2 = this.O00000o;
                } else {
                    this.O00000o = i + 1;
                }
            }
            int i22 = this.O00000o;
            if (i22 == cArr.length) {
                this.f7317O000000o = 9;
            } else if (cArr[i22] == '(') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 1;
            } else if (cArr[i22] == ')') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 2;
            } else if (cArr[i22] == '?') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 6;
            } else if (cArr[i22] == '=') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 5;
                int i3 = this.O00000o;
                if (i3 < cArr.length && cArr[i3] == '=') {
                    this.O00000o = i3 + 1;
                }
            } else if (cArr[i22] == '>') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 5;
                int i4 = this.O00000o;
                if (i4 < cArr.length && cArr[i4] == '=') {
                    this.O00000o = i4 + 1;
                }
            } else if (cArr[i22] == '<') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 5;
                int i5 = this.O00000o;
                if (i5 >= cArr.length) {
                    return;
                }
                if (cArr[i5] == '=' || cArr[i5] == '>') {
                    this.O00000o++;
                }
            } else if (cArr[i22] == '!') {
                this.O00000o = i22 + 1;
                this.f7317O000000o = 5;
                int i6 = this.O00000o;
                if (i6 >= cArr.length || cArr[i6] != '=') {
                    throw new IllegalArgumentException("Unexpected character after !");
                }
                this.O00000o = i6 + 1;
            } else if (O000000o(cArr[i22])) {
                int i7 = this.O00000o;
                this.O00000o = i7 + 1;
                while (true) {
                    int i8 = this.O00000o;
                    if (i8 >= cArr.length || !O00000Oo(cArr[i8])) {
                        String substring = this.O00000Oo.substring(i7, this.O00000o);
                    } else {
                        this.O00000o++;
                    }
                }
                String substring2 = this.O00000Oo.substring(i7, this.O00000o);
                if (this.O00000o - i7 <= 4) {
                    if (substring2.equals("IS")) {
                        this.f7317O000000o = 7;
                        return;
                    } else if (substring2.equals("OR") || substring2.equals("AND")) {
                        this.f7317O000000o = 3;
                        return;
                    } else if (substring2.equals("NULL")) {
                        this.f7317O000000o = 8;
                        return;
                    }
                }
                if (this.O00000o0.contains(substring2)) {
                    this.f7317O000000o = 4;
                    return;
                }
                throw new IllegalArgumentException("unrecognized column or keyword");
            } else {
                int i9 = this.O00000o;
                if (cArr[i9] == '\'') {
                    this.O00000o = i9 + 1;
                    while (true) {
                        int i10 = this.O00000o;
                        if (i10 >= cArr.length) {
                            break;
                        }
                        if (cArr[i10] == '\'') {
                            if (i10 + 1 >= cArr.length || cArr[i10 + 1] != '\'') {
                                break;
                            }
                            this.O00000o = i10 + 1;
                        }
                        this.O00000o++;
                    }
                    int i11 = this.O00000o;
                    if (i11 != cArr.length) {
                        this.O00000o = i11 + 1;
                        this.f7317O000000o = 6;
                        return;
                    }
                    throw new IllegalArgumentException("unterminated string");
                }
                throw new IllegalArgumentException("illegal character: " + cArr[this.O00000o]);
            }
        }
    }

    public static void O000000o(ContentResolver contentResolver, long j, String str) {
        try {
            new File(str).delete();
        } catch (Exception e) {
            Log.w("DownloadManager", "file: '" + str + "' couldn't be deleted", e);
        }
        contentResolver.delete(Downloads.ALL_DOWNLOADS_CONTENT_URI, "_id = ? ", new String[]{String.valueOf(j)});
    }

    public static String O000000o(Context context, String str, String str2, String str3, String str4, String str5, int i, long j, boolean z) throws GenerateSaveFileError {
        if (!z && i == 0) {
            if (str5 != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                PackageManager packageManager = context.getPackageManager();
                intent.setDataAndType(Uri.fromParts("file", "", null), str5);
                if (packageManager.resolveActivity(intent, 65536) == null) {
                    throw new GenerateSaveFileError(406, "no handler found for this download type");
                }
            } else {
                throw new GenerateSaveFileError(406, "external download with no mime type not allowed");
            }
        }
        if (i == 4) {
            if (O000000o()) {
                String path = Uri.parse(str2).getPath();
                if (path.endsWith("/")) {
                    path = O000000o(path.substring(0, path.length() - 1), str, str3, str4, str5);
                } else if (new File(path).exists()) {
                    gsy.O000000o(3, "DownloadManager", "File already exists: " + path + ",delete");
                    new File(path).delete();
                }
                if (O000000o(O000000o(path)) >= j) {
                    return path;
                }
                throw new GenerateSaveFileError(498, "insufficient space on external storage");
            }
            throw new GenerateSaveFileError(499, "external media not mounted");
        } else if (O000000o()) {
            File externalFilesDir = CommonApplication.getAppContext().getExternalFilesDir("external");
            if (externalFilesDir == null || O000000o(externalFilesDir) < j) {
                gsy.O000000o(3, "DownloadManager", "download aborted - not enough free space");
                throw new GenerateSaveFileError(498, "insufficient space on external media");
            }
            File file = new File(externalFilesDir.getPath() + "/download");
            if (file.isDirectory() || file.mkdir()) {
                return O000000o(file.getPath(), str, str3, str4, str5);
            }
            throw new GenerateSaveFileError(492, "unable to create external downloads directory " + file.getPath());
        } else {
            throw new GenerateSaveFileError(499, "external media not mounted");
        }
    }

    private static void O000000o(O000000o o000000o) {
        while (true) {
            if (o000000o.f7317O000000o == 1) {
                o000000o.O000000o();
                O000000o(o000000o);
                if (o000000o.f7317O000000o == 2) {
                    o000000o.O000000o();
                } else {
                    throw new IllegalArgumentException("syntax error, unmatched parenthese");
                }
            } else {
                O00000Oo(o000000o);
            }
            if (o000000o.f7317O000000o == 3) {
                o000000o.O000000o();
            } else {
                return;
            }
        }
    }

    private static void O00000Oo(O000000o o000000o) {
        if (o000000o.f7317O000000o == 4) {
            o000000o.O000000o();
            if (o000000o.f7317O000000o == 5) {
                o000000o.O000000o();
                if (o000000o.f7317O000000o == 6) {
                    o000000o.O000000o();
                    return;
                }
                throw new IllegalArgumentException("syntax error, expected quoted string");
            } else if (o000000o.f7317O000000o == 7) {
                o000000o.O000000o();
                if (o000000o.f7317O000000o == 8) {
                    o000000o.O000000o();
                    return;
                }
                throw new IllegalArgumentException("syntax error, expected NULL");
            } else {
                throw new IllegalArgumentException("syntax error after column name");
            }
        } else {
            throw new IllegalArgumentException("syntax error, expected column name");
        }
    }
}
