package _m_j;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ilk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f1444O000000o = "";
    public static String O00000Oo = "upload_log_file";
    public static String O00000o = (Environment.getExternalStorageDirectory() + "/ting/errorLog/infor.log");
    public static boolean O00000o0 = false;
    static Map<String, String> O00000oO = new HashMap();
    private static long O00000oo = System.currentTimeMillis();
    private static int O0000O0o = 0;

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5 A[SYNTHETIC, Splitter:B:46:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bf A[SYNTHETIC, Splitter:B:51:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cc A[SYNTHETIC, Splitter:B:60:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d6 A[SYNTHETIC, Splitter:B:65:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    static {
        String str;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String[] split;
        O00000oO.clear();
        BufferedReader bufferedReader2 = null;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str.equals("mounted")) {
            String str2 = Environment.getExternalStorageDirectory() + "/ting/config.ini";
            if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                try {
                    fileReader = new FileReader(str2);
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    try {
                                        break;
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                } else if (!TextUtils.isEmpty(readLine) && (split = readLine.split("=")) != null && split.length == 2) {
                                    O00000oO.put(split[0], split[1]);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader2 = bufferedReader;
                                try {
                                    e.printStackTrace();
                                    if (bufferedReader2 != null) {
                                    }
                                    if (fileReader != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                }
                                if (fileReader != null) {
                                }
                                throw th;
                            }
                        }
                        bufferedReader.close();
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    } catch (Exception e7) {
                        e = e7;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                        }
                        if (fileReader != null) {
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileReader = null;
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    fileReader = null;
                    if (bufferedReader != null) {
                    }
                    if (fileReader != null) {
                    }
                    throw th;
                }
            }
        }
    }

    public static void O000000o(Object obj) {
        if (iio.f1319O000000o) {
            Log.i("ting", String.valueOf(obj));
        }
    }

    private static File O000000o() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File file = new File(Environment.getExternalStorageDirectory() + "/ting/errorLog/infor.log");
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static void O000000o(String str, String str2) {
        if (str2 != null && O000000o(3)) {
            Log.d(str, str2);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (str2 != null && O000000o(4)) {
            Log.i(str, str2);
        }
    }

    public static void O000000o(Exception exc) {
        String str;
        StringBuilder sb = new StringBuilder("解析json异常");
        sb.append(exc.getMessage());
        if (iio.f1319O000000o) {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            str = "@" + stackTraceElement.getFileName() + ": Line " + stackTraceElement.getLineNumber();
        } else {
            str = "";
        }
        sb.append(str);
        O00000o0("解析json异常", sb.toString());
    }

    public static void O00000o0(String str, String str2) {
        if (str2 != null && O000000o(6)) {
            Log.e(str, str2);
        }
    }

    private static boolean O000000o(int i) {
        if (iio.f1319O000000o && i >= O0000O0o) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileWriter.<init>(java.lang.String, boolean):void throws java.io.IOException}
      ClspMth{java.io.FileWriter.<init>(java.io.File, boolean):void throws java.io.IOException} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public static void O000000o(String str) {
        boolean z;
        Iterator<Map.Entry<String, String>> it = O00000oO.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Map.Entry next = it.next();
            if (str.contains((CharSequence) next.getKey()) && ((String) next.getValue()).equals("true")) {
                z = true;
                break;
            }
        }
        if (z || iio.f1319O000000o) {
            O000000o((Object) str);
            File O000000o2 = O000000o();
            if (O000000o2 != null && O000000o2 != null) {
                PrintWriter printWriter = null;
                try {
                    PrintWriter printWriter2 = new PrintWriter(new FileWriter(O000000o2, true));
                    try {
                        printWriter2.println(str);
                        printWriter2.close();
                    } catch (Throwable th) {
                        th = th;
                        printWriter = printWriter2;
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (printWriter != null) {
                    }
                    throw th;
                }
            }
        }
    }
}
