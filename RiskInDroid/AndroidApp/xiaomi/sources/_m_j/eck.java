package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.xiaomi.mobilestats.data.SendStrategyEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;

public final class eck {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f15166O000000o = false;
    public static String O00000oO = "";
    public static String O00000oo = "";
    public static String O0000O0o = "";
    public static String O0000OOo = "";
    public static String O0000Oo = "";
    public static String O0000Oo0 = "";
    public static String O0000OoO = "";
    public static String O0000Ooo = "";
    public static boolean O0000o0 = false;
    public static String O0000o00 = "";
    private static HandlerThread O0000o0O = new HandlerThread("LogSenderThread");
    private static Handler O0000o0o;
    private static eck O0000oO0 = new eck();
    public SendStrategyEnum O00000Oo = SendStrategyEnum.REAL_TIME;
    public long O00000o = 0;
    public long O00000o0 = 1;
    private Timer O0000o = null;

    private eck() {
        O0000o0O.start();
        O0000o0o = new Handler(O0000o0O.getLooper());
    }

    public static eck O000000o() {
        return O0000oO0;
    }

    private static void O000000o(File file) {
        File file2 = new File(file.getPath() + File.separator + "cache");
        File file3 = new File(O00000oO);
        if (file2.isDirectory()) {
            File[] listFiles = file2.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i] != null && !listFiles[i].getName().equals(file3.getName())) {
                    ebx.O000000o(listFiles[i]);
                }
            }
        }
    }

    private static void O000000o(File file, String str) {
        ebs.O000000o("MobileStats", "copyToUploadDirAndDel:" + file.getName());
        if (file != null) {
            if (file.length() <= 0) {
                file.delete();
            }
            if (file == null || file.exists()) {
                File file2 = new File(str);
                File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (file2.exists()) {
                    file.delete();
                    ecj.O000000o();
                    ecj.O000000o(file2.getName(), file2);
                }
            }
        }
    }

    public static void O00000Oo() {
        try {
            File[] listFiles = new File(O00000oo).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file != null && file.exists()) {
                        O000000o(file, O0000O0o + File.separator + file.getName());
                    }
                }
                O0000OOo = "";
                O0000Oo0 = "";
                O0000Oo = "";
                O0000OoO = "";
                O0000Ooo = "";
                O0000o00 = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String O000000o(Context context, String str, byte[] bArr) {
        String str2;
        String str3 = str;
        if (ecd.O000000o(O00000oO)) {
            File file = new File(context.getFilesDir(), "StatCache");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                str2 = "cache/" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "cache/0";
            }
            O00000oO = file.getPath() + File.separator + str2;
            O000000o(file);
            O00000oo = O00000oO + File.separator + "operator";
            O0000O0o = O00000oO + File.separator + "upload";
            ebx.O000000o(O00000oo);
            ebx.O000000o(O0000O0o);
        }
        File file2 = new File(O0000O0o);
        File file3 = new File(O00000oo);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file3.exists()) {
            file3.mkdirs();
        }
        if (str3.equals("page") && TextUtils.isEmpty(O0000Oo0)) {
            O0000Oo0 = O00000oo + File.separator + System.currentTimeMillis() + "_page.json";
            File file4 = new File(O0000Oo0);
            if (!file4.exists()) {
                try {
                    file4.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (str3.equals("event") && TextUtils.isEmpty(O0000OOo)) {
            O0000OOo = O00000oo + File.separator + System.currentTimeMillis() + "_event.json";
            File file5 = new File(O0000OOo);
            if (!file5.exists()) {
                try {
                    file5.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (str3.equals("error") && TextUtils.isEmpty(O0000OoO)) {
            O0000OoO = O00000oo + File.separator + System.currentTimeMillis() + "_error.json";
            File file6 = new File(O0000OoO);
            if (!file6.exists()) {
                try {
                    file6.createNewFile();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (str3.equals("crash") && TextUtils.isEmpty(O0000Oo)) {
            O0000Oo = O00000oo + File.separator + System.currentTimeMillis() + "_crash.json";
            File file7 = new File(O0000Oo);
            if (!file7.exists()) {
                try {
                    file7.createNewFile();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
        if (str3.equals("client") && TextUtils.isEmpty(O0000Ooo)) {
            O0000Ooo = O00000oo + File.separator + System.currentTimeMillis() + "_client.json";
            File file8 = new File(O0000Ooo);
            if (!file8.exists()) {
                try {
                    file8.createNewFile();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        }
        if (str3.equalsIgnoreCase("view") && TextUtils.isEmpty(O0000o00)) {
            O0000o00 = O00000oo + File.separator + System.currentTimeMillis() + "_view.json";
            File file9 = new File(O0000o00);
            if (!file9.exists()) {
                try {
                    file9.createNewFile();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        }
        String str4 = (TextUtils.isEmpty(str) || !str3.equals("page")) ? (TextUtils.isEmpty(str) || !str3.equals("event")) ? (TextUtils.isEmpty(str) || !str3.equals("crash")) ? (TextUtils.isEmpty(str) || !str3.equals("error")) ? (TextUtils.isEmpty(str) || !str3.equals("client")) ? (TextUtils.isEmpty(str) || !str3.equalsIgnoreCase("view")) ? "" : O0000o00 : O0000Ooo : O0000OoO : O0000Oo : O0000OOo : O0000Oo0;
        File file10 = new File(str4);
        if (!file10.exists()) {
            return str4;
        }
        String str5 = "_view.json";
        String str6 = "view";
        if (file10.length() + ((long) bArr.length) <= 16384) {
            return str4;
        }
        ebs.O000000o("MobileStats", "size is over 16k");
        O000000o(file10, O0000O0o + File.separator + file10.getName());
        if (!TextUtils.isEmpty(str) && str3.equals("page")) {
            String str7 = O00000oo + File.separator + System.currentTimeMillis() + "_page.json";
            O0000Oo0 = str7;
            return str7;
        } else if (!TextUtils.isEmpty(str) && str3.equals("event")) {
            String str8 = O00000oo + File.separator + System.currentTimeMillis() + "_event.json";
            O0000OOo = str8;
            return str8;
        } else if (!TextUtils.isEmpty(str) && str3.equals("crash")) {
            String str9 = O00000oo + File.separator + System.currentTimeMillis() + "_crash.json";
            O0000Oo = str9;
            return str9;
        } else if (!TextUtils.isEmpty(str) && str3.equals("error")) {
            String str10 = O00000oo + File.separator + System.currentTimeMillis() + "_error.json";
            O0000OoO = str10;
            return str10;
        } else if (!TextUtils.isEmpty(str) && str3.equals("client")) {
            String str11 = O00000oo + File.separator + System.currentTimeMillis() + "_client.json";
            O0000Ooo = str11;
            return str11;
        } else if (TextUtils.isEmpty(str) || !str3.equalsIgnoreCase(str6)) {
            return str4;
        } else {
            String str12 = O00000oo + File.separator + System.currentTimeMillis() + str5;
            O0000o00 = str12;
            return str12;
        }
    }
}
