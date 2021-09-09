package _m_j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@SuppressLint({"MissingPermission"})
public final class dus {

    public static final class O000000o {
        public static boolean O000000o(String str, String str2) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                    byte[] bArr = new byte[4096];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            File file = new File(str2 + name);
                            if (!name.endsWith("/")) {
                                File file2 = new File(file.getParent());
                                if (!file2.exists() || !file2.isDirectory()) {
                                    file2.mkdirs();
                                }
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                                while (true) {
                                    int read = zipInputStream.read(bArr, 0, 4096);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                            }
                        } else {
                            zipInputStream.close();
                            return true;
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }
    }
}
