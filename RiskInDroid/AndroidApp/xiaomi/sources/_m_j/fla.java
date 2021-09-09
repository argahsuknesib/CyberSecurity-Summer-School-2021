package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class fla {
    private static File O000000o(String str) {
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

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00af A[SYNTHETIC, Splitter:B:40:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ba A[SYNTHETIC, Splitter:B:46:0x00ba] */
    public static boolean O000000o(String str, String str2, String str3) {
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                byte[] bArr = new byte[4096];
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        if (!(name == null || name.indexOf("\\") == -1)) {
                            name = name.replaceAll("\\\\", File.separator);
                        }
                        String str4 = str2 + File.separator + name;
                        if (!O000000o(str2, str4)) {
                            throw new FileNotFoundException();
                        } else if (TextUtils.isEmpty(str3) || str4.indexOf(str3) != -1) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(O000000o(str4)));
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedOutputStream.flush();
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                        }
                    }
                }
                try {
                    zipFile2.close();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gsy.O00000o0(LogType.PLUGIN, "ZipFileUtils", Log.getStackTraceString(th));
            if (zipFile != null) {
            }
            return false;
        }
    }

    private static boolean O000000o(String str, String str2) {
        gsy.O000000o(LogType.GENERAL, "verifyFile: ", "verifyFileAbosolutePath basePath: " + str + " fileAbsolutePathName: " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str2.split(File.separator);
        ArrayList arrayList = new ArrayList();
        for (String add : split) {
            arrayList.add(add);
        }
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if ("..".equals(arrayList.get(i))) {
                if (stack.size() <= 0) {
                    break;
                }
                stack.pop();
            } else if (!"".equals(arrayList.get(i))) {
                stack.push(arrayList.get(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        int size2 = stack.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 == size2 - 1) {
                sb.append((String) stack.get(i2));
            } else {
                sb.append((String) stack.get(i2));
                sb.append(File.separator);
            }
        }
        int length = File.separator.length();
        while (str.startsWith(File.separator)) {
            try {
                str = str.substring(length, str.length());
            } catch (Exception unused) {
            }
        }
        boolean startsWith = sb.toString().startsWith(str);
        gsy.O000000o(LogType.GENERAL, "verifyFile: ", "fileAbsolutePathName=".concat(String.valueOf(str2)));
        gsy.O000000o(LogType.GENERAL, "verifyFile: ", "resultFilePathName= " + sb.toString());
        gsy.O000000o(LogType.GENERAL, "verifyFile: ", "result= ".concat(String.valueOf(startsWith)));
        return startsWith;
    }
}
