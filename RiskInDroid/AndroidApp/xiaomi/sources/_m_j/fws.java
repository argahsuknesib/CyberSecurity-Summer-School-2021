package _m_j;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class fws {
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

    public static void O00000Oo(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists()) {
                            O00000Oo(file2.getAbsolutePath());
                        }
                    }
                }
                file.delete();
            }
        }
    }

    public static File O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException unused) {
        }
        return file;
    }
}
