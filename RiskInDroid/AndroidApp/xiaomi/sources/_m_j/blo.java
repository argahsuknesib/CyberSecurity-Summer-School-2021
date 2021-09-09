package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ishumei.dfp.SMSDK;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class blo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13057O000000o = bnd.O00000o0("9c9092d18c978a929a96");
    public static final String O00000Oo = bnd.O00000o0("9b9a89969c9a969b");
    public static final String O00000o0 = bnd.O00000o0("d18b978a929d9c9e9c979aa0969b87a0");
    /* access modifiers changed from: private */
    public static final String O00000oo = bnd.O00000o0("8c978a929a96d18b878b");
    /* access modifiers changed from: private */
    public static final String O0000O0o = bnd.O00000o0("d18b978a929d9c9e9c979aa0969b87cf");
    /* access modifiers changed from: private */
    public static final String O0000OOo = bnd.O00000o0("a08c978a929a96");
    /* access modifiers changed from: private */
    public static final String[] O0000Oo = {"", bnd.O00000o0("d0bbbcb6b2"), bnd.O00000o0("d0af969c8b8a8d9a8c"), bnd.O00000o0("d0bb90889193909e9b"), bnd.O00000o0("d0bb909c8a929a918b8c")};
    /* access modifiers changed from: private */
    public static final String O0000Oo0 = bnd.O00000o0("a09e919b8d90969b");
    private static blo O0000Ooo = null;
    public List<O0000O0o> O00000o = new LinkedList();
    public String O00000oO = "";
    /* access modifiers changed from: private */
    public String O0000OoO = null;
    private bmg O0000o00 = new bmg() {
        /* class _m_j.blo.AnonymousClass2 */

        /* renamed from: O000000o  reason: collision with root package name */
        int f13059O000000o = 0;

        public final void run() {
            synchronized (blo.this) {
                for (O0000O0o O000000o2 : blo.this.O00000o) {
                    try {
                        O000000o2.O000000o(blo.this.O0000OoO);
                    } catch (Exception unused) {
                    }
                }
                this.f13059O000000o++;
            }
            if (this.f13059O000000o < 3) {
                this.O00000o = true;
                this.O00000oO = false;
                this.O00000oo = 15000;
                this.O0000O0o = false;
                O000000o();
                return;
            }
            this.O00000o = false;
            this.O00000oO = true;
            this.O00000oo = 0;
            this.O0000O0o = true;
            this.f13059O000000o = 0;
        }
    };

    public class O000000o extends O0000O0o {
        public O000000o() {
            super((byte) 0);
            this.O00000Oo = 4;
        }

        private String O00000Oo() {
            String O00000oO = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(O00000oO, blo.O00000oo);
            int i = 0;
            bmz.O000000o("SmidManager", "exter store: %s", file.getAbsolutePath());
            try {
                return bne.O000000o(file);
            } catch (Exception unused) {
                File file2 = new File(O00000oO);
                if (!file2.canRead()) {
                    return "";
                }
                File[] listFiles = file2.listFiles();
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    File file3 = listFiles[i];
                    int i3 = i2 + 1;
                    if (i2 < 30 && file3.isDirectory() && file3.canWrite()) {
                        File file4 = new File(file3, blo.O0000O0o);
                        if (file4.canRead()) {
                            try {
                                return bne.O000000o(file4);
                            } catch (Exception unused2) {
                                i++;
                                i2 = i3;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                    i2 = i3;
                }
                return "";
            }
        }

        public final String O000000o() {
            return O00000Oo();
        }

        public final void O000000o(String str) {
        }
    }

    public class O00000o extends O0000O0o {
        public O00000o() {
            super((byte) 0);
            this.O00000Oo = 10;
        }

        private static SharedPreferences O00000Oo(String str) {
            Context context = blw.f13081O000000o;
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences(str, 0);
        }

        private static String O00000Oo() {
            Context context = blw.f13081O000000o;
            if (context == null) {
                return null;
            }
            try {
                return bne.O00000oo(context.getPackageName() + blo.O0000OOo);
            } catch (Exception unused) {
                return null;
            }
        }

        public final String O000000o() {
            SharedPreferences O00000Oo;
            Context context = blw.f13081O000000o;
            if (context == null) {
                return null;
            }
            String O00000Oo2 = O00000Oo();
            if (TextUtils.isEmpty(O00000Oo2) || (O00000Oo = O00000Oo(O00000Oo2)) == null) {
                return null;
            }
            try {
                String string = O00000Oo.getString(O00000Oo2, "");
                return SMSDK.O00000o0(context.getPackageName() + blo.O0000Oo0, string);
            } catch (Exception unused) {
                return null;
            }
        }

        public final void O000000o(String str) {
            SharedPreferences O00000Oo;
            Context context = blw.f13081O000000o;
            if (context != null) {
                String O00000Oo2 = O00000Oo();
                if (!TextUtils.isEmpty(O00000Oo2) && (O00000Oo = O00000Oo(O00000Oo2)) != null) {
                    try {
                        String O00000Oo3 = SMSDK.O00000Oo(context.getPackageName() + blo.O0000Oo0, str);
                        SharedPreferences.Editor edit = O00000Oo.edit();
                        edit.putString(O00000Oo2, O00000Oo3);
                        edit.commit();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    static abstract class O0000O0o implements Comparable {
        public int O00000Oo;

        private O0000O0o() {
            this.O00000Oo = 0;
        }

        /* synthetic */ O0000O0o(byte b) {
            this();
        }

        public abstract String O000000o();

        public abstract void O000000o(String str);

        public int compareTo(Object obj) {
            if (obj instanceof O0000O0o) {
                return ((O0000O0o) obj).O00000Oo - this.O00000Oo;
            }
            return 0;
        }
    }

    private blo() {
    }

    public static blo O000000o() {
        if (O0000Ooo == null) {
            synchronized (blo.class) {
                if (O0000Ooo == null) {
                    O0000Ooo = new blo();
                }
            }
        }
        return O0000Ooo;
    }

    public static String O00000o() {
        return SMSDK.O000000o(blw.f13081O000000o);
    }

    public synchronized void O000000o(O0000O0o o0000O0o) {
        this.O00000o.add(o0000O0o);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return;
     */
    public final synchronized void O000000o(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                this.O0000OoO = str;
                this.O0000o00.O000000o();
            }
        }
    }

    public final synchronized String O00000Oo() {
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            return this.O0000OoO;
        }
        for (O0000O0o O000000o2 : this.O00000o) {
            try {
                String O000000o3 = O000000o2.O000000o();
                if (!TextUtils.isEmpty(O000000o3)) {
                    if (O000000o3.length() == 62) {
                        this.O0000OoO = O000000o3;
                        return O000000o3;
                    }
                }
            } catch (Throwable th) {
                bmz.O00000o("SmidManager", "getSmid failed: %s", th);
            }
        }
        return "";
    }

    public final synchronized Map<String, List<Integer>> O00000o0() {
        HashMap hashMap;
        String str;
        List list;
        hashMap = new HashMap();
        for (O0000O0o next : this.O00000o) {
            try {
                str = next.O000000o();
                if (TextUtils.isEmpty(str)) {
                    list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(Integer.valueOf(next.O00000Oo));
                    hashMap.put(str, list);
                } else {
                    if (str.length() != 62) {
                        List list2 = (List) hashMap.get(str);
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        list.add(Integer.valueOf(next.O00000Oo));
                    } else {
                        List list3 = (List) hashMap.get(str);
                        if (list3 == null) {
                            list3 = new ArrayList();
                        }
                        list.add(Integer.valueOf(next.O00000Oo));
                    }
                    hashMap.put(str, list);
                }
            } catch (Throwable th) {
                str = "";
                try {
                    bmz.O00000o("SmidManager", "getAllSmid failed: %s", th);
                    List list4 = (List) hashMap.get(str);
                    if (list4 == null) {
                        list4 = new ArrayList();
                    }
                    list.add(Integer.valueOf(next.O00000Oo));
                } catch (Throwable th2) {
                    List list5 = (List) hashMap.get(str);
                    if (list5 == null) {
                        list5 = new ArrayList();
                    }
                    list5.add(Integer.valueOf(next.O00000Oo));
                    hashMap.put(str, list5);
                    throw th2;
                }
            }
        }
        return hashMap;
    }

    public class O00000Oo extends O0000O0o {
        public O00000Oo() {
            super((byte) 0);
            this.O00000Oo = 21;
        }

        public final String O000000o() {
            if (TextUtils.isEmpty(blo.this.O00000oO)) {
                return "";
            }
            String O00000oO = Environment.getExternalStorageDirectory().getAbsolutePath();
            String[] O00000oo = blo.O0000Oo;
            int length = O00000oo.length;
            int i = 0;
            while (i < length) {
                String str = O00000oo[i];
                try {
                    return SMSDK.O00000o0(blo.this.O00000oO, bne.O000000o(new File(O00000oO + str + File.separator + blo.this.O00000oO)));
                } catch (Exception unused) {
                    i++;
                }
            }
            return "";
        }

        public final void O000000o(String str) {
            if (!TextUtils.isEmpty(blo.this.O00000oO)) {
                String O00000oO = Environment.getExternalStorageDirectory().getAbsolutePath();
                String[] O00000oo = blo.O0000Oo;
                int length = O00000oo.length;
                int i = 0;
                while (i < length) {
                    String str2 = O00000oo[i];
                    File file = new File(O00000oO + str2 + File.separator + blo.this.O00000oO);
                    try {
                        String O00000Oo = SMSDK.O00000Oo(blo.this.O00000oO, str);
                        if (!bnd.O000000o(O00000Oo)) {
                            bne.O000000o(file, O00000Oo.getBytes("utf-8"));
                            i++;
                        } else {
                            throw new IOException("file or bytes empty");
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public class O00000o0 extends O0000O0o {
        public O00000o0() {
            super((byte) 0);
            this.O00000Oo = 2;
        }

        public final void O000000o(String str) {
        }

        public final String O000000o() {
            int i = Build.VERSION.SDK_INT < 23 ? 3 : 0;
            if (blw.f13081O000000o == null) {
                return null;
            }
            String string = blw.f13081O000000o.getSharedPreferences(blo.f13057O000000o, i).getString(blo.O00000Oo, "");
            bnd.O000000o(string);
            return string;
        }
    }
}
