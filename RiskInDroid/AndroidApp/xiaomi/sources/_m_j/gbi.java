package _m_j;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class gbi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f17496O000000o = "FileUtils";

    public static boolean O000000o(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            FileOutputStream fileOutputStream = new FileOutputStream(O00000o(str2));
            byte[] bArr = new byte[2048];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static void O000000o(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                fyc.O000000o(f17496O000000o, "close error:", e);
            }
        }
    }

    private static File O00000o(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        return file;
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory() || !file.delete()) {
            return false;
        }
        return true;
    }

    public static boolean O00000Oo(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static void O00000o0(String str) {
        File parentFile;
        if (!TextUtils.isEmpty(str) && (parentFile = new File(str).getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Byte):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Float):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.String):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Long):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Boolean):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, byte[]):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Double):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Short):void}
      ClspMth{android.content.ContentValues.put(java.lang.String, java.lang.Integer):void} */
    public static boolean O00000Oo(String str, String str2) throws Exception {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            ContentResolver contentResolver = CommonApplication.getAppContext().getContentResolver();
            if (!TextUtils.isEmpty(str)) {
                Uri contentUri = MediaStore.Files.getContentUri("external");
                String str3 = Environment.DIRECTORY_DOCUMENTS + File.separator + "external";
                contentValues.put("_display_name", str);
                contentValues.put("mime_type", gsc.O00000Oo(str2));
                contentValues.put("relative_path", str3);
                contentValues.put("is_pending", (Integer) 1);
                Uri insert = contentResolver.insert(contentUri, contentValues);
                if (insert == null) {
                    contentValues.put("relative_path", str3 + System.currentTimeMillis());
                    insert = contentResolver.insert(contentUri, contentValues);
                }
                gsc.O000000o(new FileInputStream(str2), contentResolver.openOutputStream(insert));
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                return true;
            }
        }
        return false;
    }
}
