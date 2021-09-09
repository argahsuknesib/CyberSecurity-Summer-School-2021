package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

public final class ebt implements Thread.UncaughtExceptionHandler {
    private static ebt O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f15155O000000o;
    public Thread.UncaughtExceptionHandler O00000Oo;
    /* access modifiers changed from: private */
    public String O00000o;

    private ebt() {
    }

    public static synchronized ebt O000000o() {
        ebt ebt;
        synchronized (ebt.class) {
            if (O00000o0 == null) {
                O00000o0 = new ebt();
            }
            ebt = O00000o0;
        }
        return ebt;
    }

    /* access modifiers changed from: private */
    public boolean O00000Oo(String str) {
        if (this.f15155O000000o != null && !ecd.O000000o(str)) {
            String O00000Oo2 = ecm.O000000o().O00000Oo(this.f15155O000000o);
            List<eco> list = null;
            if (!ecd.O000000o(O00000Oo2)) {
                try {
                    list = ebz.O000000o(O00000Oo2, eco.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (list == null || list.size() <= 0) {
                list = new ArrayList<>();
            } else {
                for (eco eco : list) {
                    if (eco != null) {
                        String str2 = eco.f15169O000000o;
                        int i = eco.O00000Oo;
                        if (!ecd.O000000o(str2) && str2.equals(str)) {
                            eco.O00000Oo = i + 1;
                            ecm.O000000o().O000000o(this.f15155O000000o, ebz.O000000o(list));
                            return true;
                        }
                    }
                }
            }
            eco eco2 = new eco();
            eco2.f15169O000000o = str;
            eco2.O00000Oo = 1;
            list.add(eco2);
            ecm.O000000o().O000000o(this.f15155O000000o, ebz.O000000o(list));
        }
        return false;
    }

    public final int O000000o(String str) {
        if (this.f15155O000000o == null) {
            return 0;
        }
        try {
            List<eco> O000000o2 = ebz.O000000o(ecm.O000000o().O00000Oo(this.f15155O000000o), eco.class);
            if (O000000o2 != null && O000000o2.size() > 0) {
                for (eco eco : O000000o2) {
                    String str2 = eco.f15169O000000o;
                    int i = eco.O00000Oo;
                    if (!ecd.O000000o(str2) && str2.equals(str)) {
                        return i;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public final void O00000Oo() {
        if (this.f15155O000000o != null) {
            ecm.O000000o().O000000o(this.f15155O000000o, "");
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        new ece(this, th, thread).start();
    }

    static /* synthetic */ String O000000o(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        String obj = stringWriter.toString();
        int length = TextUtils.isEmpty(obj) ? 0 : obj.length();
        if (length <= 2048) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(obj.substring(0, 2048));
        if (th instanceof StackOverflowError) {
            sb.append("\n\t... \n");
            sb.append(obj.substring((length - 2048) - 2048, length));
        }
        return sb.toString();
    }
}
