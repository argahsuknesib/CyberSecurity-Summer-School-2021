package _m_j;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class euf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15821O000000o = "euf";
    private static final String[] O00000Oo = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
    private static final String[] O00000o = {"com.koushikdutta.rommanager", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine"};
    private static final String[] O00000o0 = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su"};
    private static final String[] O00000oO = {"com.devadvance.rootcloak", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.devadvance.rootcloakplus", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.formyhm.hideroot"};
    private static final String[] O00000oo = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};
    private static final Map<String, String> O0000O0o = new HashMap();

    public static boolean O000000o(Context context) {
        euh.O000000o(f15821O000000o, "Root is start");
        String[] O00000o2 = O00000o();
        ArrayList arrayList = new ArrayList();
        char c = 1;
        if (O00000o2 != null) {
            int length = O00000o2.length;
            int i = 0;
            while (i < length) {
                String[] split = O00000o2[i].split(" ");
                if (split.length >= 4) {
                    String str = split[c];
                    String str2 = split[3];
                    for (String str3 : O00000oo) {
                        if (str.equalsIgnoreCase(str3)) {
                            String[] split2 = str2.split(",");
                            int length2 = split2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    break;
                                } else if ("rw".equalsIgnoreCase(split2[i2])) {
                                    arrayList.add(str3);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                }
                i++;
                c = 1;
            }
        }
        if (arrayList.size() > 0 || O00000Oo(context).size() > 0 || O00000Oo().size() > 0 || O000000o().size() > 0) {
            return true;
        }
        return false;
    }

    private static List<String> O000000o() {
        ArrayList arrayList = new ArrayList();
        for (String str : O00000Oo) {
            if (new File(str).exists()) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static List<String> O00000Oo(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(O00000o0));
        arrayList.addAll(Arrays.asList(O00000o));
        arrayList.addAll(Arrays.asList(O00000oO));
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                packageManager.getPackageInfo(str, 0);
                arrayList2.add(str);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return arrayList2;
    }

    private static List<String> O00000Oo() {
        O0000O0o.put("[ro.debuggable]", "[1]");
        O0000O0o.put("[ro.secure]", "[0]");
        String[] O00000o02 = O00000o0();
        ArrayList arrayList = new ArrayList();
        if (O00000o02 == null) {
            return arrayList;
        }
        for (String str : O00000o02) {
            for (String next : O0000O0o.keySet()) {
                if (str.contains(next) && str.contains(O0000O0o.get(next))) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private static String[] O00000o0() {
        InputStream inputStream;
        String str;
        try {
            inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        try {
            str = new Scanner(inputStream).useDelimiter("\\A").next();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (NoSuchElementException unused3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            str = "";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
        return str.split("\n");
    }

    private static String[] O00000o() {
        InputStream inputStream;
        String str;
        try {
            inputStream = Runtime.getRuntime().exec("mount").getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        try {
            str = new Scanner(inputStream).useDelimiter("\\A").next();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (NoSuchElementException unused3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            str = "";
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
        return str.split("\n");
    }
}
