package _m_j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import okhttp3.Response;

public final class gpg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f18117O000000o = {"jpg", "png", "bmp", "gif", "webp"};

    public static boolean O000000o(List<File> list, String str) {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                byte[] bArr = new byte[2048];
                for (File next : list) {
                    if (next.isDirectory()) {
                        for (File file : next.listFiles()) {
                            zipOutputStream2.putNextEntry(new ZipEntry(next.getName() + "/" + file.getName()));
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 2048);
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream2.write(bArr, 0, read);
                            }
                            bufferedInputStream.close();
                        }
                    } else {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(next), 2048);
                        zipOutputStream2.putNextEntry(new ZipEntry(next.getName()));
                        while (true) {
                            int read2 = bufferedInputStream2.read(bArr, 0, 2048);
                            if (read2 == -1) {
                                break;
                            }
                            zipOutputStream2.write(bArr, 0, read2);
                        }
                        bufferedInputStream2.close();
                    }
                }
                zipOutputStream2.close();
                O000000o(zipOutputStream2);
                return true;
            } catch (Exception e) {
                e = e;
                zipOutputStream = zipOutputStream2;
                try {
                    e.printStackTrace();
                    O000000o(zipOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream2 = zipOutputStream;
                    O000000o(zipOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                O000000o(zipOutputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            O000000o(zipOutputStream);
            return false;
        }
    }

    public static void O000000o(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    public static void O000000o(OutputStream outputStream) {
        if (outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
    }

    public static void O000000o(Response response) {
        if (response != null && response.body() != null) {
            response.close();
        }
    }

    public static void O000000o(File file) {
        File file2 = new File(file, ".nomedia");
        if (!file2.exists() || !file2.isFile()) {
            try {
                file2.createNewFile();
            } catch (IOException unused) {
            }
        }
    }

    public static String O000000o(Resources resources, int i) {
        if (i < 0) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resources.openRawResource(i)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static Bitmap.CompressFormat O00000Oo(String str) {
        if (str.equals("png")) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static String O000000o(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str2 = str.substring(lastIndexOf + 1);
        } else {
            str2 = "";
        }
        return (str2 == null || str2 == "" || !str2.toLowerCase().equals("png")) ? "jpg" : "png";
    }
}
