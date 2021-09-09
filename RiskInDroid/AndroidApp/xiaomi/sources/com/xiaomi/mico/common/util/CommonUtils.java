package com.xiaomi.mico.common.util;

import _m_j.ahh;
import _m_j.gqb;
import _m_j.jdn;
import _m_j.o0oOo0O0;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class CommonUtils {
    public static final Pattern CLEAR_FRIEND_PATTERN = Pattern.compile("@(.+?)<([1-9]{1}[0-9]{0,})>");
    public static final Pattern FRIEND_PATTERN = Pattern.compile("@<a href=\"friend://([1-9]{1}[0-9]{0,})\">(.+?)(</a>)");
    private static final String[] INVALID_NAME_TEMPLATE = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    public static final Pattern MIID_PATTERN = Pattern.compile("miid:[1-9]{1}[0-9]{0,}");
    public static final Pattern MSGTO_PATTERN = Pattern.compile("msgto://[1-9]{1}[0-9]{0,}.*");
    public static final Pattern PUTTEXT_PATTERN = Pattern.compile("puttxt://[1-9]{1}[0-9]{0,}.*");
    private static String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static Pattern regex = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    public static void DebugAssert(boolean z) {
    }

    public static boolean isLetter(char c) {
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean shouldVoIPEntryVisible(Context context) {
        return true;
    }

    public static void smoothScrollListViewToTop(ListView listView) {
        smoothScrollListView(listView, 0, 0, 100);
    }

    @SuppressLint({"NewApi"})
    public static void smoothScrollListView(ListView listView, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11) {
            listView.smoothScrollToPositionFromTop(i, i2, i3);
        } else {
            listView.setSelectionFromTop(i, i2);
        }
    }

    public static boolean isValidUrl(String str) {
        if (str == null) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    protected static URL getUrlIfValid(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static String readToString(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } catch (IOException e) {
            ahh.O000000o(e);
            return "";
        }
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        String str2 = "CREATE TABLE " + str + "(_id INTEGER  PRIMARY KEY ,";
        for (int i = 0; i < strArr.length - 1; i += 2) {
            if (i != 0) {
                str2 = str2 + ",";
            }
            str2 = str2 + strArr[i] + " " + strArr[i + 1];
        }
        sQLiteDatabase.execSQL(str2 + ");");
    }

    public static String getMd5Digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(getBytes(str));
            return String.format("%1$032X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] getBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String[] toStrArray(List<String> list) {
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return strArr;
    }

    public static long[] toLongArray(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static String getMD5(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString("bind_type").equalsIgnoreCase(str2)) {
                    return jSONObject.getString("contact_value");
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public static void printCallStack(String str) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(str);
        printWriter.println(String.format("Current thread id (%s); thread name (%s)", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName()));
        new Throwable("Call stack").printStackTrace(printWriter);
        new Object[1][0] = stringWriter.toString();
    }

    public static String getCallStack(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void printCursor(Cursor cursor) {
        new Object[1][0] = "Print out the cursor info";
        new Object[1][0] = String.format("Cursor.count = %d", Integer.valueOf(cursor.getCount()));
        String[] columnNames = cursor.getColumnNames();
        new Object[1][0] = "Columns";
        new Object[1][0] = gqb.O000000o(columnNames, ",");
        if (cursor.moveToFirst()) {
            int i = 0;
            do {
                new Object[1][0] = String.format("Row %d", Integer.valueOf(i));
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                for (int i2 = 0; i2 < cursor.getColumnCount(); i2++) {
                    printWriter.print(cursor.getColumnName(i2));
                    printWriter.print("=");
                    printWriter.print(cursor.getString(i2));
                    printWriter.println();
                }
                new Object[1][0] = stringWriter.toString();
                i++;
            } while (cursor.moveToNext());
        }
    }

    public static String partialNormalizePhoneNum(String str) {
        return str.replace("+86", "");
    }

    public static String getRecipientsDivider() {
        if ("samsung".equalsIgnoreCase(Build.BRAND)) {
            return ",";
        }
        if (TextUtils.isEmpty(Build.MODEL) || !Build.MODEL.toUpperCase().contains("OMS")) {
            return ";";
        }
        return ",";
    }

    public static boolean isSDCardUnavailable() {
        return Environment.getExternalStorageState().equals("removed");
    }

    public static boolean isSDCardBusy() {
        return !Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isSDCardFull() {
        return getSDCardAvailableBytes() <= 102400;
    }

    public static boolean isSDCardUseful() {
        return !isSDCardBusy() && !isSDCardFull() && !isSDCardUnavailable();
    }

    public static long getSDCardAvailableBytes() {
        if (isSDCardBusy()) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
    }

    public static long getSDCardTotalSize() {
        if (isSDCardBusy()) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
    }

    public static boolean isWIFIConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) {
            return false;
        }
        return true;
    }

    public static String getActiveConnPoint(Context context) {
        NetworkInfo activeNetworkInfo;
        if (isWIFIConnected(context)) {
            return "wifi";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "";
        }
        return activeNetworkInfo.getExtraInfo();
    }

    public static boolean saveBitmap(Bitmap bitmap, String str) {
        return saveBitmap(bitmap, str, Bitmap.CompressFormat.PNG, 100);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003e A[SYNTHETIC, Splitter:B:27:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public static boolean saveBitmap(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        FileOutputStream fileOutputStream = null;
        try {
            createDirForNewFile(str);
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                boolean compress = bitmap.compress(compressFormat, i, fileOutputStream2);
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                    ahh.O000000o(e);
                }
                return compress;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    ahh.O000000o(e);
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            ahh.O000000o(e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            ahh.O000000o(e);
            if (fileOutputStream != null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e5) {
                ahh.O000000o(e5);
                return false;
            }
        }
    }

    public static boolean cropImageFileAsSquare(String str, File file, int i) throws IOException {
        Rect rect;
        Bitmap decodeFile = decodeFile(str, i, i);
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        Paint paint = new Paint();
        if (width > height) {
            rect = new Rect((width - height) / 2, 0, (width + height) / 2, height);
        } else {
            rect = new Rect(0, (height - width) / 2, width, (height + width) / 2);
        }
        canvas.drawBitmap(decodeFile, rect, new Rect(0, 0, i, i), paint);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        boolean compress = createBitmap.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream);
        fileOutputStream.close();
        return compress;
    }

    public static boolean cropImageFile(String str, File file, int i, int i2, Bitmap.CompressFormat compressFormat) throws IOException {
        Rect rect;
        Bitmap decodeFile = decodeFile(str, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int width = decodeFile.getWidth();
        int height = decodeFile.getHeight();
        Paint paint = new Paint();
        if (width > height) {
            rect = new Rect((width - height) / 2, 0, (width + height) / 2, height);
        } else {
            rect = new Rect(0, (height - width) / 2, width, (height + width) / 2);
        }
        canvas.drawBitmap(decodeFile, rect, new Rect(0, 0, i, i2), paint);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        boolean compress = createBitmap.compress(compressFormat, 0, fileOutputStream);
        fileOutputStream.close();
        return compress;
    }

    public static Bitmap makeRoundImage(Bitmap bitmap, float f, int i, int i2) {
        Rect rect;
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint();
        if (width > height) {
            rect = new Rect((width - height) / 2, 0, (width + height) / 2, height);
        } else {
            rect = new Rect(0, (height - width) / 2, width, (height + width) / 2);
        }
        Rect rect2 = new Rect(0, 0, i2, i2);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap compressBitmap(Bitmap bitmap, int i, int i2, Bitmap.Config config) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < i && height < i) {
            return bitmap;
        }
        Rect rect = new Rect(0, 0, width, height);
        Rect rect2 = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        new Canvas(createBitmap).drawBitmap(bitmap, rect, rect2, new Paint());
        return createBitmap;
    }

    public static Bitmap compressBitmapWithNoDistortion(Bitmap bitmap, int i, int i2, Bitmap.Config config) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < i && height < i) {
            return bitmap;
        }
        double d = (double) width;
        double d2 = (double) i;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) height;
        double d5 = (double) i2;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        if (d3 > d6) {
            d6 = d3;
        }
        Double.isNaN(d);
        Double.isNaN(d4);
        return compressBitmap(bitmap, (int) (d / d6), (int) (d4 / d6), config);
    }

    public static void compressWithNoDistortion(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (i <= 0 || i <= 0 || (decodeFile.getWidth() <= i && decodeFile.getHeight() <= i)) {
            bitmap = decodeFile;
        } else {
            bitmap = compressBitmapWithNoDistortion(decodeFile, i, i2, Bitmap.Config.ARGB_8888);
            if (bitmap != decodeFile) {
                decodeFile.recycle();
            }
        }
        saveBitmap(bitmap, str);
        bitmap.recycle();
    }

    public static Bitmap decodeFile(String str, int i, int i2) {
        return decodeFile(str, i, i2, false);
    }

    public static Bitmap decodeFile(String str, int i, int i2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            while (i4 > i && i5 > i2) {
                i3++;
                i4 = options.outWidth / i3;
                i5 = options.outHeight / i3;
            }
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            if (!z) {
                ahh.O000000o(e);
                return null;
            }
            throw e;
        }
    }

    public static Bitmap decodeResource(int i, int i2, int i3, Context context) {
        return decodeResource(i, i2, i3, context, Bitmap.Config.RGB_565);
    }

    public static Bitmap decodeResource(int i, int i2, int i3, Context context, Bitmap.Config config) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i4 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i, options);
            int i5 = options.outWidth;
            int i6 = options.outHeight;
            while (true) {
                if (i5 <= i2) {
                    if (i6 <= i3) {
                        options.inSampleSize = i4;
                        options.inJustDecodeBounds = false;
                        options.inPreferredConfig = config;
                        return BitmapFactory.decodeResource(context.getResources(), i, options);
                    }
                }
                i4++;
                i5 = options.outWidth / i4;
                i6 = options.outHeight / i4;
            }
        } catch (OutOfMemoryError e) {
            ahh.O000000o(e);
            return null;
        }
    }

    public static Bitmap decodeFile(String str, int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            while ((i3 * i3) + (i4 * i4) > i * i) {
                i2++;
                i3 = options.outWidth / i2;
                i4 = options.outHeight / i2;
            }
            options.inSampleSize = i2;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            ahh.O000000o(e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
     candidates:
      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r6.inSampleSize = r9;
        r6.inJustDecodeBounds = false;
        r1 = android.graphics.BitmapFactory.decodeFile(r0, r6);
     */
    public static Bitmap decodeFile2(String str, int i, int i2) throws IOException {
        Bitmap bitmap;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        int i5 = 0;
        if (i3 <= 0 || i4 <= 0) {
            bitmap = BitmapFactory.decodeFile(str2, null);
        } else {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str2, options);
                int i6 = options.outWidth;
                int i7 = options.outHeight;
                int i8 = 1;
                while (true) {
                    double d = (double) i3;
                    Double.isNaN(d);
                    if (((double) i6) > d * 1.5d) {
                        double d2 = (double) i4;
                        Double.isNaN(d2);
                        if (((double) i7) > d2 * 1.5d) {
                            i8 <<= 1;
                            i6 >>= 1;
                            i7 >>= 1;
                        }
                    }
                    break;
                }
            } catch (OutOfMemoryError unused) {
                throw new IOException("decode file out of memory");
            }
        }
        if (bitmap == null) {
            return null;
        }
        try {
            i5 = (int) ImageExifUtils.exifOrientationToDegrees(new ExifInterface(str2).getAttributeInt("Orientation", 1));
        } catch (Exception e) {
            new Object[1][0] = e.getMessage();
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i5);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean mergeBitmap(Bitmap bitmap, String str, Rect rect, Paint paint) {
        try {
            return mergeBitmap(bitmap, BitmapFactory.decodeFile(str), rect, paint);
        } catch (OutOfMemoryError e) {
            ahh.O000000o(e);
            return false;
        }
    }

    public static boolean mergeBitmap(Bitmap bitmap, Bitmap bitmap2, Rect rect, Paint paint) {
        if (bitmap2 == null) {
            return false;
        }
        try {
            new Canvas(bitmap).drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), rect, paint);
            return true;
        } catch (OutOfMemoryError e) {
            ahh.O000000o(e);
            return false;
        }
    }

    public static boolean mergeBitmap(Bitmap bitmap, Bitmap bitmap2, Paint paint) {
        return mergeBitmap(bitmap, bitmap2, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), paint);
    }

    public static final class TitleAndListBitmaps {
        private final Bitmap listBitmap;
        private final Bitmap titleBitmap;

        public TitleAndListBitmaps(Bitmap bitmap, Bitmap bitmap2) {
            this.titleBitmap = bitmap;
            this.listBitmap = bitmap2;
        }

        public final Bitmap getTitleBitmap() {
            return this.titleBitmap;
        }

        public final Bitmap getListBitmap() {
            return this.listBitmap;
        }
    }

    public static boolean mergeBitmap(Bitmap bitmap, Bitmap bitmap2, Rect rect) {
        return mergeBitmap(bitmap, bitmap2, rect, new Paint());
    }

    public static boolean mergeBitmap(Bitmap bitmap, Bitmap bitmap2) {
        return mergeBitmap(bitmap, bitmap2, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
    }

    public static void createDirForNewFile(String str) {
        File file = new File(str.substring(0, str.lastIndexOf("/")));
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String getStrangerDisplayName(int i) {
        return "<" + i + ">";
    }

    public static String getStrangerDisplayName(String str) {
        return "<" + str + ">";
    }

    public static boolean isIntentAvailable(Context context, String str) {
        return context.getPackageManager().queryIntentActivities(new Intent(str), 65536).size() > 0;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    public static void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        if (!file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read >= 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream.close();
                            fileOutputStream.close();
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        }
    }

    public static void scanMediaFile(Context context, String str) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
    }

    public static boolean isSIMCardReady(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimState() == 5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A[SYNTHETIC, Splitter:B:39:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007d A[Catch:{ IOException -> 0x0080 }] */
    public static boolean compressBitmap(String str, int i) throws IOException {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        File file = new File(str + ".temp");
        int i2 = 80;
        if (1 == i) {
            try {
                bitmap = BitmapFactory.decodeFile(str);
                i2 = 50;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        throw th;
                    }
                }
                if (file.exists()) {
                    file.delete();
                }
                throw th;
            }
        } else {
            bitmap = decodeFile2(str, 480, 800);
        }
        if (bitmap == null) {
            try {
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return false;
            } catch (IOException unused2) {
                return false;
            }
        } else {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                fileOutputStream.close();
                bitmap.recycle();
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                try {
                    fileOutputStream.close();
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (IOException unused3) {
                }
                return true;
            } catch (IOException e) {
                throw e;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                }
                if (file.exists()) {
                }
                throw th;
            }
        }
    }

    public static void highlightKeyword(TextView textView, String str, String str2, int i) {
        highlightKeyword(textView, str, new String[]{str2}, i, false);
    }

    public static void highlightKeyword(TextView textView, CharSequence charSequence, CharSequence charSequence2, int i) {
        highlightKeyword(textView, charSequence, new CharSequence[]{charSequence2}, i, false);
    }

    public static void highlightKeyword(TextView textView, CharSequence charSequence, CharSequence[] charSequenceArr, int i, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        for (CharSequence charSequence2 : charSequenceArr) {
            int i2 = 0;
            while (true) {
                int indexOf = indexOf(charSequence, charSequence2, i2, z);
                if (indexOf < 0) {
                    break;
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i), indexOf, charSequence2.length() + indexOf, 33);
                i2 = indexOf + charSequence2.length();
            }
        }
        textView.setText(spannableStringBuilder);
    }

    private static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        while (i < charSequence.length()) {
            int i2 = 0;
            while (i2 < charSequence2.length() && (r1 = i + i2) < charSequence.length() && equalsChar(charSequence.charAt(r1), charSequence2.charAt(i2), z)) {
                if (i2 == charSequence2.length() - 1) {
                    return i;
                }
                i2++;
            }
            i++;
        }
        return -1;
    }

    private static boolean equalsChar(char c, char c2, boolean z) {
        return z ? c == c2 || Character.toLowerCase(c) == Character.toLowerCase(c2) : c == c2;
    }

    public static CharSequence addClickableSpan(final Context context, String str, String str2, final View.OnClickListener onClickListener, final boolean z, final int i) {
        int indexOf = str.indexOf(str2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (indexOf >= 0) {
            spannableStringBuilder.setSpan(new ClickableSpan() {
                /* class com.xiaomi.mico.common.util.CommonUtils.AnonymousClass1 */

                public final void onClick(View view) {
                    onClickListener.onClick(view);
                }
            }, indexOf, str2.length() + indexOf, 33);
            spannableStringBuilder.setSpan(new CharacterStyle() {
                /* class com.xiaomi.mico.common.util.CommonUtils.AnonymousClass2 */

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(z);
                    textPaint.setColor(context.getResources().getColor(i));
                }
            }, indexOf, str2.length() + indexOf, 33);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder addClickableSpanToMark(String str, final int i, int i2, final boolean z, final View.OnClickListener onClickListener) {
        int indexOf = str.indexOf(91);
        int lastIndexOf = str.lastIndexOf(93);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.replaceAll("\\[|\\]", ""));
        if (onClickListener != null) {
            spannableStringBuilder.setSpan(new ClickableSpan() {
                /* class com.xiaomi.mico.common.util.CommonUtils.AnonymousClass3 */

                public final void onClick(View view) {
                    onClickListener.onClick(view);
                }
            }, Math.max(0, indexOf), Math.max(0, lastIndexOf - 1), 33);
        }
        int i3 = lastIndexOf - 1;
        spannableStringBuilder.setSpan(new CharacterStyle() {
            /* class com.xiaomi.mico.common.util.CommonUtils.AnonymousClass4 */

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(z);
                textPaint.setColor(i);
            }
        }, Math.max(0, indexOf), Math.max(0, i3), 33);
        spannableStringBuilder.setSpan(new BackgroundColorSpan(i2), Math.max(0, indexOf), Math.max(0, i3), 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder addBoldSpanToMark(String str) {
        int indexOf = str.indexOf(91);
        int lastIndexOf = str.lastIndexOf(93);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.replaceAll("\\[|\\]", ""));
        spannableStringBuilder.setSpan(new StyleSpan(1), Math.max(0, indexOf), Math.max(0, lastIndexOf - 1), 33);
        return spannableStringBuilder;
    }

    public static void hideFromMediaScanner(File file) {
        File file2 = new File(file, ".nomedia");
        if (!file2.exists() || !file2.isFile()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                ahh.O000000o(e);
            }
        }
    }

    public static String getUniqueFileName(File file, String str) {
        String str2;
        File file2 = new File(file, str);
        if (!file2.exists()) {
            return file2.getAbsolutePath();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf + 1);
            str = substring;
        } else {
            str2 = "";
        }
        int i = 1;
        while (true) {
            File file3 = new File(file, String.format("%s_%d.%s", str, Integer.valueOf(i), str2));
            if (!file3.exists()) {
                return file3.getAbsolutePath();
            }
            i++;
        }
    }

    public static boolean isStupidLephone() {
        return !TextUtils.isEmpty(Build.PRODUCT) && Build.PRODUCT.contains("lephone");
    }

    public static String getCountryISO(Context context) {
        return getCountryISOFromSimCard(context);
    }

    public static boolean isAllChineseSimCard(Context context) {
        String countryISO = getCountryISO(context);
        return "CN".equalsIgnoreCase(countryISO) || "TW".equalsIgnoreCase(countryISO) || "HK".equalsIgnoreCase(countryISO);
    }

    public static boolean isChineseISO(Context context) {
        return "CN".equalsIgnoreCase(getCountryISO(context));
    }

    public static String getCountryISOFromSimCard(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
    }

    public static boolean isChinaMobile(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        return "46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator);
    }

    public static boolean isChinaUnicom(Context context) {
        return "46001".equals(((TelephonyManager) context.getSystemService("phone")).getSimOperator());
    }

    public static boolean isChinaTelecom(Context context) {
        return "46003".equals(((TelephonyManager) context.getSystemService("phone")).getSimOperator());
    }

    public static boolean isChineseSimCard(Context context) {
        return "CN".equalsIgnoreCase(getCountryISOFromSimCard(context));
    }

    public static boolean isChineseLocale(Context context) {
        return Locale.CHINA.toString().equalsIgnoreCase(Locale.getDefault().toString()) || Locale.CHINESE.toString().equalsIgnoreCase(Locale.getDefault().toString());
    }

    public static boolean isGreatChinaLocale(Context context) {
        return isChineseLocale(context) || Locale.TAIWAN.toString().equalsIgnoreCase(Locale.getDefault().toString()) || "zh_HK".equalsIgnoreCase(Locale.getDefault().toString()) || Locale.TRADITIONAL_CHINESE.toString().equalsIgnoreCase(Locale.getDefault().toString());
    }

    public static boolean isRichNoise() {
        return "Desire HD".equals(Build.MODEL);
    }

    public static boolean isMIUIRom(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.miui.cloudservice", 16384) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static <T> boolean IsTwoArrayListContainsSameElemet(ArrayList<T> arrayList, ArrayList<T> arrayList2) {
        if (arrayList != null && arrayList2 != null && !arrayList.isEmpty() && !arrayList2.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (arrayList2.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    public static int getCheckSumCRC32(File file) throws IOException {
        CheckedInputStream checkedInputStream = null;
        try {
            CheckedInputStream checkedInputStream2 = new CheckedInputStream(new FileInputStream(file), new CRC32());
            try {
                do {
                } while (checkedInputStream2.read(new byte[1024]) >= 0);
                int value = (int) checkedInputStream2.getChecksum().getValue();
                checkedInputStream2.close();
                return value;
            } catch (Throwable th) {
                th = th;
                checkedInputStream = checkedInputStream2;
                if (checkedInputStream != null) {
                    checkedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (checkedInputStream != null) {
            }
            throw th;
        }
    }

    public static String getFromAssets(Context context, String str, String str2) {
        String str3;
        byte[] bArr = new byte[8192];
        try {
            InputStream open = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            open.close();
            str3 = byteArrayOutputStream.toString();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            str3 = "";
            new Object[1][0] = "getFromAssets 读取文件错误".concat(String.valueOf(str));
            return str3;
        }
        return str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[SYNTHETIC, Splitter:B:19:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[SYNTHETIC, Splitter:B:28:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c A[SYNTHETIC, Splitter:B:35:0x006c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x004d=Splitter:B:25:0x004d, B:16:0x002f=Splitter:B:16:0x002f} */
    public static Bitmap getBitmapFromAssets(Context context, String str) {
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            inputStream = context.getResources().getAssets().open(str);
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        Object[] objArr = {"Failed to close InputStream when getting bitmap from assets.", e};
                    }
                }
            } catch (IOException e2) {
                e = e2;
                Object[] objArr2 = {"getBitmapFromAssets ".concat(String.valueOf(str)), e};
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        Object[] objArr3 = {"Failed to close InputStream when getting bitmap from assets.", e3};
                    }
                }
                return bitmap;
            } catch (OutOfMemoryError e4) {
                e = e4;
                try {
                    Object[] objArr4 = {"getBitmapFromAssets ".concat(String.valueOf(str)), e};
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            Object[] objArr5 = {"Failed to close InputStream when getting bitmap from assets.", e5};
                        }
                    }
                    return bitmap;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            Object[] objArr6 = {"Failed to close InputStream when getting bitmap from assets.", e6};
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e = e7;
            inputStream = null;
            Object[] objArr22 = {"getBitmapFromAssets ".concat(String.valueOf(str)), e};
            if (inputStream != null) {
            }
            return bitmap;
        } catch (OutOfMemoryError e8) {
            e = e8;
            inputStream = null;
            Object[] objArr42 = {"getBitmapFromAssets ".concat(String.valueOf(str)), e};
            if (inputStream != null) {
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
        return bitmap;
    }

    public static boolean isXMPhone() {
        return Build.MODEL.contains("mione") || Build.MODEL.contains("MI-ONE");
    }

    public static boolean isAudioVoiceCallDisabled() {
        return Build.MODEL.contains("ZTE");
    }

    public static String getCurrentCallstack() {
        StringWriter stringWriter = new StringWriter();
        new Exception().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static Bitmap makeRoundImage(Bitmap bitmap) {
        return makeRoundImage(bitmap, 7.0f);
    }

    public static Bitmap makeRoundImage(Bitmap bitmap, float f) {
        Rect rect;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        if (width > height) {
            rect = new Rect((width - height) / 2, 0, (width + height) / 2, height);
        } else {
            rect = new Rect(0, (height - width) / 2, width, (width + height) / 2);
        }
        Rect rect2 = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static String[] getImageInfo(Context context, Uri uri) {
        if (uri.getScheme().equalsIgnoreCase("file")) {
            String path = uri.getPath();
            return new String[]{path, getImageMimeType(path)};
        }
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data", "mime_type"}, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            query.moveToFirst();
            return new String[]{query.getString(0), query.getString(1)};
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public static String getImageMimeType(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            str2 = "";
        } else {
            str2 = str.substring(lastIndexOf + 1);
        }
        return "image/".concat(String.valueOf(str2));
    }

    public static void createHomeScreenShortcut(Context context, Intent intent, String str, int i, boolean z) {
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(context, i));
        intent2.putExtra("duplicate", z);
        context.sendBroadcast(intent2);
    }

    public static boolean isWifiEnabled(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }

    public static String getCurrentWifiSSID(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        String ssid = connectionInfo.getSSID();
        return (ssid == null || !ssid.startsWith(jdn.f1779O000000o) || !ssid.endsWith(jdn.f1779O000000o)) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    public static byte[] getFileSha1Digest(String str) throws NoSuchAlgorithmException, IOException {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                instance.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return instance.digest();
            }
        }
    }

    public static boolean isValidEmailAddress(String str) {
        return regex.matcher(str).matches();
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 16384);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void openMapByGoogle(Activity activity, double d, double d2, String str, String str2) {
        boolean isPackageInstalled = isPackageInstalled(activity, "com.google.android.apps.maps");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://maps.google.com/maps?q=loc:");
        stringBuffer.append(d);
        stringBuffer.append(",");
        stringBuffer.append(d2);
        if (isPackageInstalled) {
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append("@");
            stringBuffer.append(str2);
            stringBuffer.append(")");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            activity.startActivity(intent);
            return;
        }
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
    }

    public static void restartAppTask(Context context) {
        ToastUtil.showToast((int) R.string.mico_no_valid_device);
    }

    public static void restartAppTask(Context context, Uri uri, Bundle bundle) {
        Intent makeRestartActivityTask = Intent.makeRestartActivityTask(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent());
        if (uri != null) {
            makeRestartActivityTask.setData(uri);
        }
        if (bundle != null) {
            makeRestartActivityTask.putExtras(bundle);
        }
        context.startActivity(makeRestartActivityTask);
    }

    public static void deleteDirs(File file) {
        new Object[1][0] = "deleteDirs filePath = " + file.getAbsolutePath();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else {
                        deleteDirs(file2);
                    }
                }
            }
            file.delete();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException}
     arg types: [java.lang.Class<T>, int]
     candidates:
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int[]):java.lang.Object VARARG throws java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException}
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException} */
    public static <T> T[] newArrayByClass(Class<T> cls, int i) {
        return (Object[]) Array.newInstance((Class<?>) cls, i);
    }

    public static <T> void copyArray(T[] tArr, int i, int i2, T[] tArr2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            tArr2[i3 - i] = tArr[i3];
        }
    }

    public static <T> void addAll(T[] tArr, Collection<T> collection) {
        for (T add : tArr) {
            collection.add(add);
        }
    }

    public static <T> T[] toArray(Class<T> cls, Collection<T> collection) {
        return collection.toArray(newArrayByClass(cls, 0));
    }

    public static <T> T[] createCopyOfArray(Class<T> cls, T[] tArr, int i, int i2) {
        T[] newArrayByClass = newArrayByClass(cls, i2);
        copyArray(tArr, i, i2, newArrayByClass);
        return newArrayByClass;
    }

    public static int[] createCopyOfIntArray(int[] iArr, int i, int i2) {
        int[] iArr2 = new int[i2];
        for (int i3 = i; i3 < i + i2; i3++) {
            iArr2[i3 - i] = iArr[i3];
        }
        return iArr2;
    }

    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = (float) i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static String generateImageThumbUrl(String str, int i) {
        return generateImageThumbUrl(str, i, true);
    }

    public static String generateImageThumbUrl(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?thumb=");
        sb.append(String.valueOf(i));
        sb.append("x");
        sb.append(String.valueOf(i));
        sb.append(z ? "&scale=auto" : "");
        return sb.toString();
    }

    public static int getCurrentVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            new Object[1][0] = "cannot find package".concat(String.valueOf(e));
            return -1;
        }
    }

    public static long versionCodeToLong(String str, int i) {
        long j = 0;
        if (!(str == null || str.length() == 0)) {
            String[] split = str.split("\\.");
            int i2 = 1;
            for (int length = split.length - 1; length >= 0; length--) {
                j += (long) (Integer.valueOf(split[length]).intValue() * i2);
                i2 *= i;
            }
        }
        return j;
    }

    public static Bitmap getResourceBitmap(Context context, o0oOo0O0<String, Bitmap> o0ooo0o0, String str, int i) {
        return getResourceBitmap(context, o0ooo0o0, str, i, Bitmap.Config.ARGB_8888);
    }

    public static Bitmap getResourceBitmap(Context context, o0oOo0O0<String, Bitmap> o0ooo0o0, String str, int i, Bitmap.Config config) {
        Bitmap bitmap = o0ooo0o0 == null ? null : o0ooo0o0.get(str);
        if (bitmap == null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = config;
                bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
                if (!(o0ooo0o0 == null || bitmap == null)) {
                    o0ooo0o0.put(str, bitmap);
                }
            } catch (OutOfMemoryError e) {
                ahh.O000000o(e);
            }
        }
        return bitmap;
    }

    public static BitmapDrawable getResourceBitmapDrawable(Context context, o0oOo0O0<String, Bitmap> o0ooo0o0, String str, int i) {
        return getResourceBitmapDrawable(context, o0ooo0o0, str, i, Bitmap.Config.ARGB_8888);
    }

    public static BitmapDrawable getResourceBitmapDrawable(Context context, o0oOo0O0<String, Bitmap> o0ooo0o0, String str, int i, Bitmap.Config config) {
        Bitmap resourceBitmap = getResourceBitmap(context, o0ooo0o0, str, i, config);
        if (resourceBitmap != null) {
            return new BitmapDrawable(resourceBitmap);
        }
        return null;
    }

    public static void disableRotation(Activity activity) {
        int i;
        int i2 = activity.getResources().getConfiguration().orientation;
        int orientation = activity.getWindowManager().getDefaultDisplay().getOrientation();
        int i3 = 8;
        if (Build.VERSION.SDK_INT <= 8) {
            i = 1;
            i3 = 0;
        } else {
            i = 9;
        }
        if (orientation == 0 || orientation == 1) {
            if (i2 == 1) {
                activity.setRequestedOrientation(1);
            } else if (i2 == 2) {
                activity.setRequestedOrientation(0);
            }
        } else if (orientation != 2 && orientation != 3) {
        } else {
            if (i2 == 1) {
                activity.setRequestedOrientation(i3);
            } else if (i2 == 2) {
                activity.setRequestedOrientation(i);
            }
        }
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                Object[] objArr = {"CommonUtils.closeQuietly ", th};
            }
        }
    }

    public static Activity getRootActivity(Activity activity) {
        while (activity.getParent() != null) {
            activity = activity.getParent();
        }
        return activity;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] byteArraysConcat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static DecimalFormat getDecimalFormat(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("###");
        if (d >= 100.0d) {
            return new DecimalFormat("###");
        }
        if (d >= 10.0d) {
            return new DecimalFormat("##.0");
        }
        return d >= 0.0d ? new DecimalFormat("0.00") : decimalFormat;
    }

    public static void setFormatStorageSize(long j, TextView textView, TextView textView2) {
        float f;
        DecimalFormat decimalFormat = new DecimalFormat("###");
        String str = "TB";
        if (j < 1024) {
            f = (float) j;
            if (f >= 1000.0f) {
                f /= 1024.0f;
                decimalFormat = getDecimalFormat((double) f);
                str = "MB";
            } else {
                str = "KB";
            }
        } else {
            float f2 = ((float) j) / 1024.0f;
            if (f2 < 1024.0f) {
                if (f2 >= 1000.0f) {
                    f2 /= 1024.0f;
                    str = "GB";
                } else {
                    str = "MB";
                }
                decimalFormat = getDecimalFormat((double) f);
            } else {
                f = f2 / 1024.0f;
                if (f < 1024.0f) {
                    if (f >= 1000.0f) {
                        f /= 1024.0f;
                    } else {
                        str = "GB";
                    }
                    decimalFormat = getDecimalFormat((double) f);
                } else {
                    f /= 1024.0f;
                    decimalFormat = getDecimalFormat((double) f);
                }
            }
        }
        textView.setText(decimalFormat.format((double) f));
        textView2.setText(str);
    }

    public static String getFormatSize(long j) {
        String str;
        float f;
        if (j < 1024) {
            f = (float) j;
            str = "B";
        } else {
            f = ((float) j) / 1024.0f;
            if (f < 1024.0f) {
                str = "KB";
            } else {
                f /= 1024.0f;
                if (f < 1024.0f) {
                    str = "MB";
                } else {
                    f /= 1024.0f;
                    str = "GB";
                }
            }
        }
        if (str.equals("B")) {
            return String.valueOf(j) + str;
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.#");
        return decimalFormat.format((double) f) + str;
    }

    public static String[] getFormatSizeSeparate(long j) {
        String str;
        float f;
        if (j < 1024) {
            f = (float) j;
            str = "B";
        } else {
            f = ((float) j) / 1024.0f;
            if (f < 1024.0f) {
                str = "KB";
            } else {
                f /= 1024.0f;
                if (f < 1024.0f) {
                    str = "MB";
                } else {
                    f /= 1024.0f;
                    str = "GB";
                }
            }
        }
        if (str.equals("B")) {
            return new String[]{String.valueOf(j), str};
        }
        return new String[]{new DecimalFormat("####.#").format((double) f), str};
    }

    public static String getFormatSpeed(long j) {
        String str;
        float f;
        if (j < 1024) {
            f = (float) j;
            str = "B/S";
        } else {
            f = ((float) j) / 1024.0f;
            if (f < 1024.0f) {
                str = "KB/S";
            } else {
                f /= 1024.0f;
                if (f < 1024.0f) {
                    str = "MB/S";
                } else {
                    f /= 1024.0f;
                    str = "GB/S";
                }
            }
        }
        if (str.equals("B/S")) {
            return String.valueOf(j) + str;
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.#");
        return decimalFormat.format((double) f) + str;
    }

    public static String[] getFormatSpeedSeparate(long j) {
        String str;
        float f;
        if (j < 1024) {
            f = (float) j;
            str = "B/S";
        } else {
            f = ((float) j) / 1024.0f;
            if (f < 1024.0f) {
                str = "KB/S";
            } else {
                f /= 1024.0f;
                if (f < 1024.0f) {
                    str = "MB/S";
                } else {
                    f /= 1024.0f;
                    str = "GB/S";
                }
            }
        }
        if (str.equals("B/S")) {
            return new String[]{String.valueOf(j), str};
        }
        return new String[]{new DecimalFormat("####.#").format((double) f), str};
    }

    public static String secondToTime(long j) {
        if (j <= 0) {
            return "00:00";
        }
        int i = (int) (j / 60);
        if (i < 60) {
            int i2 = (int) (j % 60);
            return unitFormat(i) + ":" + unitFormat(i2);
        }
        int i3 = i / 60;
        if (i3 > 99) {
            return "99:59:59";
        }
        int i4 = i % 60;
        int i5 = (int) ((j - ((long) (i3 * 3600))) - ((long) (i4 * 60)));
        return unitFormat(i3) + ":" + unitFormat(i4) + ":" + unitFormat(i5);
    }

    private static String unitFormat(int i) {
        if (i < 0 || i >= 10) {
            return Integer.toString(i);
        }
        return "0" + Integer.toString(i);
    }

    public static String getUnifiedPath(String str) {
        return (str == null || !str.endsWith("/")) ? str : str.substring(0, str.length() - 1);
    }

    public static boolean isMainProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid && packageName.equals(next.processName)) {
                return true;
            }
        }
        return false;
    }

    public static String getCurProcessName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return null;
    }

    public static int comparePackageVersion(Context context, String str, int i) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo.versionCode > i) {
                return 1;
            }
            return packageInfo.versionCode == i ? 0 : -1;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static String getPackageNameOfApkFile(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 16);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.packageName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void gotoLocationSetting(Context context) {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        return (obj == null || obj2 == null || !obj.equals(obj2)) ? false : true;
    }

    public static boolean hasSpecialChar(String str) {
        return Pattern.compile("[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t").matcher(str).find();
    }
}
