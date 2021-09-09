package _m_j;

import android.os.Environment;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class cjn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final File f13945O000000o = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Xiaomi");
    public static final File O00000Oo = new File(f13945O000000o, "local");

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clw.O000000o(long, boolean):java.lang.String
     arg types: [long, int]
     candidates:
      _m_j.clw.O000000o(java.lang.String, boolean):long
      _m_j.clw.O000000o(long, boolean):java.lang.String */
    public static String O000000o(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = O00000Oo + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        } else {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + File.separator + clw.O000000o().O000000o(currentTimeMillis, false) + ".jpg";
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC, Splitter:B:31:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005b A[Catch:{ IOException -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0066 A[SYNTHETIC, Splitter:B:40:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006e A[Catch:{ IOException -> 0x006a }] */
    public static byte[] O00000Oo(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                fileInputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return byteArray;
                        } catch (IOException e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = null;
                        if (fileInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileInputStream = null;
                    byteArrayOutputStream = null;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    public static void O000000o(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File O000000o2 : listFiles) {
                O000000o(O000000o2);
            }
            file.delete();
        }
    }
}
