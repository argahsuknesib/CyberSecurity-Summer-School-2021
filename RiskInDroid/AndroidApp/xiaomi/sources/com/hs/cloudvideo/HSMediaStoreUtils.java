package com.hs.cloudvideo;

import _m_j.ihs;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class HSMediaStoreUtils {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4404O000000o = Environment.DIRECTORY_DCIM;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f4405O000000o;
        public int O00000Oo;
        public int O00000o0;
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
    public static Uri O000000o(Context context, String str, String str2, String str3) throws AccessMediaError {
        if (TextUtils.isEmpty(str)) {
            throw new AccessMediaError(-1);
        } else if (new File(str).exists()) {
            O000000o O000000o2 = O000000o(str);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put("width", Integer.valueOf(O000000o2.O00000Oo));
            contentValues.put("height", Integer.valueOf(O000000o2.O00000o0));
            contentValues.put("mime_type", O000000o2.f4405O000000o);
            contentValues.put("_display_name", str3);
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
            if (Build.VERSION.SDK_INT >= 29) {
                if (!TextUtils.isEmpty(str2)) {
                    contentValues.put("relative_path", f4404O000000o + File.separator + str2);
                }
                contentValues.put("is_pending", (Integer) 1);
                contentValues.put("date_expires", Long.valueOf((System.currentTimeMillis() + 86400000) / 1000));
            } else if (!TextUtils.isEmpty(str2)) {
                File file = new File(Environment.getExternalStoragePublicDirectory(f4404O000000o), str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                contentValues.put("_data", new File(file, str3).getAbsolutePath());
            }
            try {
                Uri insert = contentResolver.insert(uri, contentValues);
                if (insert != null) {
                    try {
                        O000000o(new FileInputStream(str), contentResolver.openOutputStream(insert));
                        if (Build.VERSION.SDK_INT >= 29) {
                            contentValues.put("is_pending", (Integer) 0);
                            contentValues.putNull("date_expires");
                            contentResolver.update(insert, contentValues, null, null);
                        }
                        return insert;
                    } catch (IOException e) {
                        contentResolver.delete(insert, null, null);
                        ihs.O00000Oo("HSMediaStoreUtils", "insertImage error:" + Log.getStackTraceString(e));
                        throw new AccessMediaError(-2);
                    }
                } else {
                    ihs.O00000Oo("HSMediaStoreUtils", "insertImage error,pendingUri=null");
                    throw new AccessMediaError(-3);
                }
            } catch (Exception e2) {
                ihs.O00000Oo("HSMediaStoreUtils", "insertImage error,resolver.insert exception:" + e2.getMessage());
                throw new AccessMediaError(-3);
            }
        } else {
            throw new AccessMediaError(-1);
        }
    }

    private static O000000o O000000o(String str) throws AccessMediaError {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            O000000o o000000o = new O000000o();
            o000000o.O00000Oo = options.outWidth;
            o000000o.O00000o0 = options.outHeight;
            o000000o.f4405O000000o = options.outMimeType;
            return o000000o;
        } catch (Throwable th) {
            throw new AccessMediaError(-6, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a  */
    private static long O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        long j = 0;
        if (outputStream == null) {
            return 0;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream2.write(bArr, 0, read);
                            j += (long) read;
                        } else {
                            bufferedOutputStream2.flush();
                            bufferedInputStream.close();
                            bufferedOutputStream2.close();
                            return j;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    public static class AccessMediaError extends RuntimeException {
        private int mErrorCode;

        public AccessMediaError(int i) {
            this(i, "");
        }

        public AccessMediaError(int i, String str) {
            super(str);
            this.mErrorCode = i;
        }

        public AccessMediaError(int i, Throwable th) {
            super(th);
            this.mErrorCode = i;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }
}
