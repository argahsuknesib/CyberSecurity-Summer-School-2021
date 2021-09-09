package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.eld;
import _m_j.ele;
import _m_j.eml;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static long f6502a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f6503a;

        /* renamed from: a  reason: collision with other field name */
        byte[] f253a;

        public a(byte[] bArr, int i) {
            this.f253a = bArr;
            this.f6503a = i;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f6504a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f254a;

        public b(Bitmap bitmap, long j) {
            this.f254a = bitmap;
            this.f6504a = j;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            duv.O000000o("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a2;
        Uri parse = Uri.parse(str);
        try {
            inputStream2 = context.getContentResolver().openInputStream(parse);
            try {
                a2 = a(context, inputStream2);
                inputStream = context.getContentResolver().openInputStream(parse);
            } catch (IOException e) {
                e = e;
                inputStream = null;
                try {
                    duv.O000000o(e);
                    ele.O000000o(inputStream);
                    ele.O000000o(inputStream2);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    ele.O000000o(inputStream);
                    ele.O000000o(inputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
                ele.O000000o(inputStream);
                ele.O000000o(inputStream2);
                throw th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a2;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                ele.O000000o(inputStream);
                ele.O000000o(inputStream2);
                return decodeStream;
            } catch (IOException e2) {
                e = e2;
                duv.O000000o(e);
                ele.O000000o(inputStream);
                ele.O000000o(inputStream2);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            inputStream2 = null;
            duv.O000000o(e);
            ele.O000000o(inputStream);
            ele.O000000o(inputStream2);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            inputStream2 = null;
            ele.O000000o(inputStream);
            ele.O000000o(inputStream2);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
        if (r1 == null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d8, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ee, code lost:
        if (r1 == null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f1, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f9  */
    private static a a(String str, boolean z) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (!z || contentLength <= 102400) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        duv.O000000o("Invalid Http Response Code " + responseCode + " received");
                        ele.O000000o((Closeable) null);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int i = z ? 102400 : 2048000;
                        byte[] bArr = new byte[1024];
                        while (i > 0) {
                            int read = inputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            i -= read;
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (i <= 0) {
                            duv.O000000o("length 102400 exhausted.");
                            a aVar = new a(null, 102400);
                            ele.O000000o(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return aVar;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        a aVar2 = new a(byteArray, byteArray.length);
                        ele.O000000o(inputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return aVar2;
                    } catch (SocketTimeoutException unused) {
                        duv.O00000o("Connect timeout to ".concat(String.valueOf(str)));
                        ele.O000000o(inputStream);
                    } catch (IOException e) {
                        e = e;
                        try {
                            duv.O000000o(e);
                            ele.O000000o(inputStream);
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            ele.O000000o(inputStream2);
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    duv.O000000o("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                    ele.O000000o((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
            } catch (SocketTimeoutException unused2) {
                inputStream = null;
                duv.O00000o("Connect timeout to ".concat(String.valueOf(str)));
                ele.O000000o(inputStream);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                duv.O000000o(e);
                ele.O000000o(inputStream);
            } catch (Throwable th2) {
                th = th2;
                ele.O000000o(inputStream2);
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (SocketTimeoutException unused3) {
            httpURLConnection = null;
            inputStream = null;
            duv.O00000o("Connect timeout to ".concat(String.valueOf(str)));
            ele.O000000o(inputStream);
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            inputStream = null;
            duv.O000000o(e);
            ele.O000000o(inputStream);
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            ele.O000000o(inputStream2);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static b a(Context context, String str, boolean z) {
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0);
        Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.f254a = b2;
            return bVar;
        }
        try {
            a a2 = a(str, z);
            if (a2 == null) {
                ele.O000000o((Closeable) null);
                return bVar;
            }
            bVar.f6504a = (long) a2.f6503a;
            byte[] bArr = a2.f253a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a3 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.f254a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e) {
                        e = e;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            duv.O000000o(e);
                            ele.O000000o(byteArrayInputStream);
                            return bVar;
                        } catch (Throwable th) {
                            th = th;
                            ele.O000000o(byteArrayInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream = byteArrayInputStream2;
                        ele.O000000o(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f254a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a2.f253a, str);
            ele.O000000o(byteArrayInputStream);
            return bVar;
        } catch (Exception e2) {
            e = e2;
            duv.O000000o(e);
            ele.O000000o(byteArrayInputStream);
            return bVar;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f6502a == 0) {
                f6502a = eld.O000000o(file);
            }
            if (f6502a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (Exception e) {
                    duv.O000000o(e);
                }
                f6502a = 0;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private static void a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            duv.O000000o("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, eml.O000000o(str));
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e) {
                e = e;
                try {
                    duv.O000000o(e);
                    ele.O000000o(bufferedOutputStream2);
                    ele.O000000o(fileOutputStream);
                    if (f6502a != 0) {
                    }
                } catch (Throwable th) {
                    th = th;
                    ele.O000000o(bufferedOutputStream2);
                    ele.O000000o(fileOutputStream);
                    throw th;
                }
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                ele.O000000o(bufferedOutputStream);
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream2 = bufferedOutputStream;
                duv.O000000o(e);
                ele.O000000o(bufferedOutputStream2);
                ele.O000000o(fileOutputStream);
                if (f6502a != 0) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                ele.O000000o(bufferedOutputStream2);
                ele.O000000o(fileOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            duv.O000000o(e);
            ele.O000000o(bufferedOutputStream2);
            ele.O000000o(fileOutputStream);
            if (f6502a != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            ele.O000000o(bufferedOutputStream2);
            ele.O000000o(fileOutputStream);
            throw th;
        }
        ele.O000000o(fileOutputStream);
        if (f6502a != 0) {
            f6502a = eld.O000000o(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static Bitmap b(Context context, String str) {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", eml.O000000o(str));
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream3);
                file.setLastModified(System.currentTimeMillis());
                fileInputStream2 = decodeStream;
                ele.O000000o(fileInputStream3);
                return decodeStream;
            } catch (Exception e) {
                e = e;
                FileInputStream fileInputStream4 = fileInputStream2;
                fileInputStream2 = fileInputStream3;
                bitmap = fileInputStream4;
                try {
                    duv.O000000o(e);
                    ele.O000000o(fileInputStream2);
                    return bitmap;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    ele.O000000o(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream = fileInputStream3;
                th = th3;
                ele.O000000o(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
            duv.O000000o(e);
            ele.O000000o(fileInputStream2);
            return bitmap;
        }
    }
}
