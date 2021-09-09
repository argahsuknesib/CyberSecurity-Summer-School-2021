package _m_j;

import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ias {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f1138O000000o = "_m_j.ias";

    private static boolean O00000Oo() {
        try {
            if (!new File("/system/app/Superuser.apk").exists()) {
                return false;
            }
            Log.i(f1138O000000o, "/system/app/Superuser.apk exist");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean O00000o0() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < 5) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    String str = f1138O000000o;
                    Log.i(str, "find su in : " + strArr[i]);
                    return true;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static ArrayList<String> O000000o(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Log.i(f1138O000000o, "to shell exec which for find su :");
            Process exec = Runtime.getRuntime().exec(strArr);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.i(f1138O000000o, "–> Line received: ".concat(String.valueOf(readLine)));
                    arrayList.add(readLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Log.i(f1138O000000o, "–> Full response was: ".concat(String.valueOf(arrayList)));
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static synchronized boolean O00000o() {
        synchronized (ias.class) {
            try {
                Log.i(f1138O000000o, "to write /data");
                if (O000000o("/data/su_test", "test_ok").booleanValue()) {
                    Log.i(f1138O000000o, "write ok");
                } else {
                    Log.i(f1138O000000o, "write failed");
                }
                Log.i(f1138O000000o, "to read /data");
                String O000000o2 = O000000o("/data/su_test");
                Log.i(f1138O000000o, "strRead=".concat(String.valueOf(O000000o2)));
                if ("test_ok".equals(O000000o2)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                String str = f1138O000000o;
                Log.i(str, "Unexpected error - Here is what I know: " + e.getMessage());
                return false;
            }
        }
    }

    private static Boolean O000000o(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    private static String O000000o(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    Log.i(f1138O000000o, str2);
                    return str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean O000000o() {
        boolean z;
        boolean z2;
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            z = false;
        } else {
            Log.i(f1138O000000o, "buildTags=".concat(String.valueOf(str)));
            z = true;
        }
        if (z || O00000Oo() || O00000o0()) {
            return true;
        }
        ArrayList<String> O000000o2 = O000000o(new String[]{"/system/xbin/which", "su"});
        if (O000000o2 != null) {
            String str2 = f1138O000000o;
            Log.i(str2, "execResult=" + O000000o2.toString());
            z2 = true;
        } else {
            Log.i(f1138O000000o, "execResult=null");
            z2 = false;
        }
        return z2 || O00000o();
    }
}
