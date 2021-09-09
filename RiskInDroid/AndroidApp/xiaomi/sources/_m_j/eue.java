package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.safedata.util.SafeHolder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class eue {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15820O000000o = "eue";
    private static String[] O00000Oo = {"com.bly.dkplat", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic"};

    eue() {
    }

    public static boolean O000000o(Context context, boolean z) {
        euh.O000000o(f15820O000000o, "MoreOpen is start");
        boolean z2 = false;
        if (!z) {
            if (SafeHolder.checkMoreOpenByUid() == 1) {
                z2 = true;
            }
            euh.O000000o(f15820O000000o, "Native checkMoreOpenByUid value:".concat(String.valueOf(z2)));
            return z2;
        } else if (O000000o(context) || O000000o() || O00000Oo()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean O000000o(Context context) {
        try {
            String path = context.getFilesDir().getPath();
            for (String contains : O00000Oo) {
                if (path.contains(contains)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC, Splitter:B:22:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC, Splitter:B:28:0x003c] */
    private static boolean O000000o() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/self/maps"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        String[] strArr = O00000Oo;
                        int length = strArr.length;
                        int i = 0;
                        while (true) {
                            if (i < length) {
                                if (readLine.contains(strArr[i])) {
                                    try {
                                        bufferedReader2.close();
                                        return true;
                                    } catch (IOException unused) {
                                        return true;
                                    }
                                } else {
                                    i++;
                                }
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Exception unused3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused4) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
        return false;
    }

    private static boolean O00000Oo() {
        String[] split;
        try {
            String O00000o0 = O00000o0();
            if (TextUtils.isEmpty(O00000o0)) {
                return false;
            }
            String O000000o2 = eug.O000000o("ps");
            if (!TextUtils.isEmpty(O000000o2) && (split = O000000o2.split("\n")) != null) {
                if (split.length > 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2].contains(O00000o0)) {
                            int lastIndexOf = split[i2].lastIndexOf(" ");
                            if (new File(String.format("/data/data/%s", split[i2].substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1, split[i2].length()), Locale.CHINA)).exists()) {
                                i++;
                            }
                        }
                    }
                    if (i > 1) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    private static String O00000o0() {
        boolean z;
        try {
            String O000000o2 = eug.O000000o("cat /proc/self/cgroup");
            if (O000000o2 == null) {
                return null;
            }
            if (O000000o2.length() == 0) {
                return null;
            }
            int lastIndexOf = O000000o2.lastIndexOf("uid");
            int lastIndexOf2 = O000000o2.lastIndexOf("/pid");
            if (lastIndexOf < 0) {
                return null;
            }
            if (lastIndexOf2 <= 0) {
                lastIndexOf2 = O000000o2.length();
            }
            String replaceAll = O000000o2.substring(lastIndexOf + 4, lastIndexOf2).replaceAll("\n", "");
            if (replaceAll != null) {
                if (replaceAll.length() != 0) {
                    int i = 0;
                    while (i < replaceAll.length()) {
                        if (Character.isDigit(replaceAll.charAt(i))) {
                            i++;
                        }
                    }
                    z = true;
                    if (z) {
                        return null;
                    }
                    return String.format("u0_a%d", Integer.valueOf(Integer.valueOf(replaceAll).intValue() - 10000));
                }
            }
            z = false;
            if (z) {
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
