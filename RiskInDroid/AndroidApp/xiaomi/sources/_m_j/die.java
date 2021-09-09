package _m_j;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class die {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f14661O000000o = true;
    private static SimpleDateFormat O00000Oo = null;
    private static StringBuilder O00000o = null;
    private static int O00000o0 = 5120;
    /* access modifiers changed from: private */
    public static StringBuilder O00000oO;
    /* access modifiers changed from: private */
    public static boolean O00000oo;
    /* access modifiers changed from: private */
    public static O000000o O0000O0o;
    private static String O0000OOo;
    private static Context O0000Oo;
    private static String O0000Oo0;
    /* access modifiers changed from: private */
    public static String O0000OoO;
    private static boolean O0000Ooo;
    /* access modifiers changed from: private */
    public static final Object O0000o0 = new Object();
    private static int O0000o00;

    static {
        try {
            O00000Oo = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    private static boolean O00000Oo(String str, String str2, String str3) {
        try {
            dgs O000000o2 = dgs.O000000o();
            if (O000000o2 == null || O000000o2.O000OO == null) {
                return false;
            }
            return O000000o2.O000OO.O000000o(str, str2, str3);
        } catch (Throwable th) {
            if (did.O000000o(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        return;
     */
    public static synchronized void O000000o(Context context) {
        synchronized (die.class) {
            if (!O0000Ooo && context != null && f14661O000000o) {
                try {
                    O00000oO = new StringBuilder(0);
                    O00000o = new StringBuilder(0);
                    O0000Oo = context;
                    dgs O000000o2 = dgs.O000000o(context);
                    O0000OOo = O000000o2.O00000oo;
                    O000000o2.getClass();
                    O0000Oo0 = "";
                    O0000OoO = O0000Oo.getFilesDir().getPath() + "/buglylog_" + O0000OOo + "_" + O0000Oo0 + ".txt";
                    O0000o00 = Process.myPid();
                } catch (Throwable unused) {
                }
                O0000Ooo = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        return;
     */
    public static synchronized void O000000o(String str, String str2, String str3) {
        synchronized (die.class) {
            if (O0000Ooo) {
                if (f14661O000000o) {
                    O00000Oo(str, str2, str3);
                    long myTid = (long) Process.myTid();
                    O00000o.setLength(0);
                    if (str3.length() > 30720) {
                        str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
                    }
                    Date date = new Date();
                    String format = O00000Oo != null ? O00000Oo.format(date) : date.toString();
                    StringBuilder sb = O00000o;
                    sb.append(format);
                    sb.append(" ");
                    sb.append(O0000o00);
                    sb.append(" ");
                    sb.append(myTid);
                    sb.append(" ");
                    sb.append(str);
                    sb.append(" ");
                    sb.append(str2);
                    sb.append(": ");
                    sb.append(str3);
                    sb.append("\u0001\r\n");
                    final String sb2 = O00000o.toString();
                    synchronized (O0000o0) {
                        O00000oO.append(sb2);
                        if (O00000oO.length() > O00000o0) {
                            if (!O00000oo) {
                                O00000oo = true;
                                dic.O000000o().O000000o(new Runnable() {
                                    /* class _m_j.die.AnonymousClass1 */

                                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                                    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x007b */
                                    public final void run() {
                                        synchronized (die.O0000o0) {
                                            if (die.O0000O0o == null) {
                                                O000000o unused = die.O0000O0o = new O000000o(die.O0000OoO);
                                            } else if (die.O0000O0o.O00000Oo == null || die.O0000O0o.O00000Oo.length() + ((long) die.O00000oO.length()) > die.O0000O0o.O00000o0) {
                                                die.O0000O0o.O000000o();
                                            }
                                            if (die.O0000O0o.f14663O000000o) {
                                                die.O0000O0o.O000000o(die.O00000oO.toString());
                                                die.O00000oO.setLength(0);
                                            } else {
                                                die.O00000oO.setLength(0);
                                                die.O00000oO.append(sb2);
                                            }
                                            boolean unused2 = die.O00000oo = false;
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    }

    public static byte[] O000000o() {
        File file;
        if (!f14661O000000o) {
            return null;
        }
        synchronized (O0000o0) {
            try {
                if (O0000O0o == null || !O0000O0o.f14663O000000o) {
                    file = null;
                } else {
                    file = O0000O0o.O00000Oo;
                }
                if (O00000oO.length() == 0 && file == null) {
                    return null;
                }
                byte[] O000000o2 = dif.O000000o(file, O00000oO.toString(), "BuglyLog.txt");
                return O000000o2;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f14663O000000o;
        File O00000Oo;
        private String O00000o;
        long O00000o0 = 30720;
        private long O00000oO;

        public O000000o(String str) {
            if (str != null && !str.equals("")) {
                this.O00000o = str;
                this.f14663O000000o = O000000o();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            try {
                this.O00000Oo = new File(this.O00000o);
                if (this.O00000Oo.exists() && !this.O00000Oo.delete()) {
                    this.f14663O000000o = false;
                    return false;
                } else if (this.O00000Oo.createNewFile()) {
                    return true;
                } else {
                    this.f14663O000000o = false;
                    return false;
                }
            } catch (Throwable unused) {
                this.f14663O000000o = false;
                return true;
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
         arg types: [java.io.File, int]
         candidates:
          ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
          ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A[SYNTHETIC, Splitter:B:26:0x003a] */
        public final boolean O000000o(String str) {
            if (!this.f14663O000000o) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.O00000Oo, true);
            try {
                byte[] bytes = str.getBytes("UTF-8");
                fileOutputStream2.write(bytes);
                fileOutputStream2.flush();
                fileOutputStream2.close();
                this.O00000oO += (long) bytes.length;
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
    }
}
