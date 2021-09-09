package _m_j;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ele {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f15606O000000o = {"jpg", "png", "bmp", "gif", "webp"};

    public static void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void O000000o(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File O000000o2 : listFiles) {
                O000000o(O000000o2);
            }
            file.delete();
        } else if (file.exists()) {
            file.delete();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public static void O000000o(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                O000000o(zipOutputStream, file2, null, null);
                O000000o(zipOutputStream);
            } catch (FileNotFoundException unused) {
                O000000o(zipOutputStream);
            } catch (IOException e) {
                e = e;
                zipOutputStream2 = zipOutputStream;
                try {
                    duv.O000000o("zip file failure + " + e.getMessage());
                    O000000o(zipOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    O000000o(zipOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                O000000o(zipOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            zipOutputStream = null;
            O000000o(zipOutputStream);
        } catch (IOException e2) {
            e = e2;
            duv.O000000o("zip file failure + " + e.getMessage());
            O000000o(zipOutputStream2);
        }
    }

    public static void O000000o(File file, String str) {
        if (!file.exists()) {
            duv.O00000o0("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter2.write(str);
                O000000o(bufferedWriter2);
            } catch (IOException e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    duv.O00000o0("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    O000000o(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    O000000o(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                O000000o(bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            duv.O00000o0("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            O000000o(bufferedWriter);
        }
    }

    private static void O000000o(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        FileInputStream fileInputStream;
        ZipEntry zipEntry;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        FileInputStream fileInputStream2 = null;
        try {
            if (file.isDirectory()) {
                File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
                if (!TextUtils.isEmpty(str)) {
                    str2 = str + File.separator;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    O000000o(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), null);
                }
                File[] listFiles2 = file.listFiles(new elf());
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        O000000o(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                    }
                }
                fileInputStream = null;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    zipEntry = new ZipEntry(str);
                } else {
                    Date date = new Date();
                    zipEntry = new ZipEntry(String.valueOf(date.getTime()) + ".txt");
                }
                zipOutputStream.putNextEntry(zipEntry);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    try {
                        duv.O00000o("zipFiction failed with exception:" + e.toString());
                        O000000o(fileInputStream2);
                    } catch (Throwable th) {
                        th = th;
                        O000000o(fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    O000000o(fileInputStream2);
                    throw th;
                }
            }
            O000000o(fileInputStream);
        } catch (IOException e2) {
            e = e2;
            duv.O00000o("zipFiction failed with exception:" + e.toString());
            O000000o(fileInputStream2);
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }

    public static String O00000Oo(File file) {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter2 = stringWriter.toString();
                        O000000o(inputStreamReader);
                        O000000o(stringWriter);
                        return stringWriter2;
                    }
                }
            } catch (IOException e) {
                e = e;
                try {
                    duv.O00000o0("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    O000000o(inputStreamReader);
                    O000000o(stringWriter);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    O000000o(inputStreamReader);
                    O000000o(stringWriter);
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamReader = null;
            duv.O00000o0("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            O000000o(inputStreamReader);
            O000000o(stringWriter);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            O000000o(inputStreamReader);
            O000000o(stringWriter);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    public static void O00000Oo(File file, File file2) {
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

    public static boolean O00000o0(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
