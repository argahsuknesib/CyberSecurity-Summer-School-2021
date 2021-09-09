package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class ftd {
    public static String O000000o(String str) {
        File file = new File(str);
        if (!file.isFile()) {
            return "";
        }
        try {
            return O000000o(new FileInputStream(file));
        } catch (FileNotFoundException | IOException unused) {
            return "";
        }
    }

    public static final String O000000o(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            inputStream.close();
        }
        return sb.toString();
    }

    public static byte[] O00000Oo(String str) {
        byte[] bArr = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (FileNotFoundException | IOException unused) {
            return bArr;
        }
    }

    public static void O000000o(Context context, String str, String str2) throws IOException {
        InputStream open = context.getResources().getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(O00000o0(str2));
        byte[] bArr = new byte[2048];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x003d=Splitter:B:26:0x003d, B:36:0x004f=Splitter:B:36:0x004f} */
    public static boolean O000000o(OutputStream outputStream, String str) {
        FileInputStream fileInputStream;
        FileNotFoundException e;
        IOException e2;
        File file = new File(str);
        if (!file.exists() || outputStream == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                outputStream.flush();
                gpg.O000000o(fileInputStream);
                return true;
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                try {
                    outputStream.flush();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                gpg.O000000o(fileInputStream);
                return false;
            } catch (IOException e6) {
                e2 = e6;
                try {
                    e2.printStackTrace();
                    try {
                        outputStream.flush();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    gpg.O000000o(fileInputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    try {
                        outputStream.flush();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    gpg.O000000o(fileInputStream);
                    throw th;
                }
            }
        } catch (FileNotFoundException e9) {
            fileInputStream = null;
            e = e9;
            e.printStackTrace();
            outputStream.flush();
            gpg.O000000o(fileInputStream);
            return false;
        } catch (IOException e10) {
            fileInputStream = null;
            e2 = e10;
            e2.printStackTrace();
            outputStream.flush();
            gpg.O000000o(fileInputStream);
            return false;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            outputStream.flush();
            gpg.O000000o(fileInputStream);
            throw th;
        }
    }

    public static boolean O000000o(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(O00000o0(str));
            try {
                if (!TextUtils.isEmpty(str2)) {
                    fileOutputStream.write(str2.getBytes());
                }
                if (!TextUtils.isEmpty(str3)) {
                    fileOutputStream.write(str3.getBytes());
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                gpg.O000000o((InputStream) null);
                gpg.O000000o(fileOutputStream);
                return true;
            } catch (IOException unused) {
                gpg.O000000o((InputStream) null);
                gpg.O000000o(fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                gpg.O000000o((InputStream) null);
                gpg.O000000o(fileOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
            fileOutputStream = null;
            gpg.O000000o((InputStream) null);
            gpg.O000000o(fileOutputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            gpg.O000000o((InputStream) null);
            gpg.O000000o(fileOutputStream);
            throw th;
        }
    }

    public static File O00000o0(String str) {
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

    public static boolean O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory() || !file.delete()) {
            return false;
        }
        return true;
    }

    private static void O0000OOo(String str) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists()) {
                            O0000OOo(file2.getAbsolutePath());
                        }
                    }
                }
                file.delete();
            }
        }
    }

    public static File O00000oO(String str) {
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

    public static void O000000o(File[] fileArr, Comparator<File> comparator) {
        long j = 0;
        for (File length : fileArr) {
            j += length.length();
        }
        if (j >= 104857600) {
            List asList = Arrays.asList(fileArr);
            Collections.sort(asList, comparator);
            Iterator it = asList.iterator();
            while (j > 104857600 && it.hasNext()) {
                File file = (File) it.next();
                j -= file.length();
                O00000oo(file.getPath());
            }
        }
    }

    public static boolean O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile()) {
            if (!file.exists() || !file.delete()) {
                return false;
            }
            return true;
        } else if (!file.isDirectory()) {
            return false;
        } else {
            O0000OOo(str);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d A[SYNTHETIC, Splitter:B:25:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0048 A[SYNTHETIC, Splitter:B:31:0x0048] */
    public static boolean O000000o(String str, String str2) {
        if (str == null) {
            return false;
        }
        PrintWriter printWriter = null;
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            } else {
                file.mkdirs();
                file.createNewFile();
            }
            PrintWriter printWriter2 = new PrintWriter(file);
            try {
                printWriter2.write(str);
                printWriter2.flush();
                try {
                    printWriter2.close();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (Exception e2) {
                e = e2;
                printWriter = printWriter2;
                try {
                    e.printStackTrace();
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                printWriter = printWriter2;
                if (printWriter != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (printWriter != null) {
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0040  */
    public static String O0000O0o(String str) throws IOException {
        String str2;
        File file = new File(str);
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                char[] cArr = new char[((int) file.length())];
                fileReader2.read(cArr);
                str2 = new String(cArr);
                fileReader2.close();
                fileReader2.close();
            } catch (Exception e) {
                e = e;
                fileReader = fileReader2;
                try {
                    e.printStackTrace();
                    if (fileReader != null) {
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
            e.printStackTrace();
            if (fileReader != null) {
            }
            return str2;
        }
        return str2;
    }
}
