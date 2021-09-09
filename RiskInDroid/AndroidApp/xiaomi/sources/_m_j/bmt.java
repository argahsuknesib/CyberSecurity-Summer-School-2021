package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

public final class bmt {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13115O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;

    public static class O000000o {
        /* access modifiers changed from: private */

        /* renamed from: O000000o  reason: collision with root package name */
        public static final bmt f13116O000000o = new bmt((byte) 0);
    }

    private bmt() {
        try {
            this.f13115O000000o = bnd.O00000o0("89968d8b8a9e93");
            this.O00000Oo = bnd.O00000o0("89968d8b8a9e939c918b");
            this.O00000o0 = bnd.O00000o0("89968d8b8a9e938a969b");
            this.O00000o = bnd.O00000o0("89968d8b8a9e938f8d909c");
        } catch (Exception unused) {
        }
    }

    /* synthetic */ bmt(byte b) {
        this();
    }

    private static String O000000o(int i) {
        Method method;
        if (Build.VERSION.SDK_INT > 27) {
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(i - 10000));
        }
        try {
            Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(null);
            if (!(obj == null || (method = obj.getClass().getMethod("getpwuid", Integer.TYPE)) == null)) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                Object invoke = method.invoke(obj, Integer.valueOf(i));
                if (invoke != null) {
                    Field declaredField2 = invoke.getClass().getDeclaredField("pw_name");
                    if (!declaredField2.isAccessible()) {
                        declaredField2.setAccessible(true);
                    }
                    return (String) declaredField2.get(invoke);
                }
            }
            return null;
        } catch (Exception unused) {
            return String.format(Locale.CHINA, "u0_a%d", Integer.valueOf(i - 10000));
        }
    }

    private static String O000000o(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                bmz.O000000o(e);
            }
        } while (read >= 512);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037 A[SYNTHETIC, Splitter:B:23:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0049 A[SYNTHETIC, Splitter:B:33:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053  */
    private static String O000000o(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            process = Runtime.getRuntime().exec(str);
            try {
                bufferedInputStream = new BufferedInputStream(process.getInputStream());
                try {
                    process.waitFor();
                    String O000000o2 = O000000o(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        bmz.O000000o(e);
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return O000000o2;
                } catch (Exception unused) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            bmz.O000000o(e2);
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return null;
                } catch (Throwable th2) {
                    BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e3) {
                            bmz.O000000o(e3);
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedInputStream = null;
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            process = null;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            if (process != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            if (bufferedInputStream2 != null) {
            }
            if (process != null) {
            }
            throw th;
        }
    }

    public final void O000000o(blh blh) {
        O00000Oo(blh);
    }

    private void O00000Oo(blh blh) {
        try {
            String O000000o2 = O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                String O000000o3 = O000000o("ps");
                if (!TextUtils.isEmpty(O000000o3)) {
                    String[] split = O000000o3.split("\n");
                    if (split.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        int i = 0;
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (split[i2].contains(O000000o2)) {
                                int lastIndexOf = split[i2].lastIndexOf(" ");
                                String substring = split[i2].substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1, split[i2].length());
                                if (!TextUtils.isEmpty(substring)) {
                                    if (new File(String.format("/data/data/%s", substring)).exists()) {
                                        arrayList.add(substring);
                                        i++;
                                    }
                                }
                            }
                        }
                        Locale locale = Locale.CHINA;
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(i > 1 ? 1 : 0);
                        blh.O000o000 = String.format(locale, "%d", objArr);
                        blh.O000o00 = String.format(Locale.CHINA, "%d", Integer.valueOf(i));
                        blh.O000o00O = O000000o2;
                        blh.O000o00o = arrayList;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[Catch:{ Exception -> 0x005a }] */
    private String O000000o() {
        boolean z;
        int i = 0;
        try {
            String O000000o2 = O000000o("cat /proc/self/cgroup");
            if (!TextUtils.isEmpty(O000000o2)) {
                int lastIndexOf = O000000o2.lastIndexOf("uid");
                int lastIndexOf2 = O000000o2.lastIndexOf("/pid");
                if (lastIndexOf >= 0) {
                    if (lastIndexOf2 <= 0) {
                        lastIndexOf2 = O000000o2.length();
                    }
                    String replaceAll = O000000o2.substring(lastIndexOf + 4, lastIndexOf2).replaceAll("\n", "");
                    if (replaceAll != null) {
                        if (replaceAll.length() != 0) {
                            int i2 = 0;
                            while (i2 < replaceAll.length()) {
                                if (Character.isDigit(replaceAll.charAt(i2))) {
                                    i2++;
                                }
                            }
                            z = true;
                            if (z) {
                                i = Integer.valueOf(replaceAll).intValue();
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (i == 0) {
            try {
                Context context = blw.f13081O000000o;
                if (context != null) {
                    i = context.getApplicationInfo().uid;
                }
            } catch (Exception unused2) {
            }
        }
        if (i == 0) {
            return null;
        }
        return O000000o(i);
    }
}
