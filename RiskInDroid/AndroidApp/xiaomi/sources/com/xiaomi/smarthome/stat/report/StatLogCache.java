package com.xiaomi.smarthome.stat.report;

import _m_j.hyc;
import _m_j.hyf;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class StatLogCache {
    private static String O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private SharedPreferences f11856O000000o = null;
    private int O00000o;
    private String O00000o0;
    private int O00000oO;
    private Map<Integer, hyf> O00000oo = new ConcurrentHashMap();
    private int O0000O0o;

    public static final String O000000o(Context context) {
        File file;
        String str = O00000Oo;
        if (str != null) {
            return str;
        }
        if (context == null) {
            context = CommonApplication.getAppContext();
        }
        if (context == null) {
            return null;
        }
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = context.getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            return null;
        }
        String path = file.getPath();
        O00000Oo = path;
        if (!path.endsWith("/")) {
            O00000Oo += "/";
        }
        String str2 = O00000Oo + "stats/";
        O00000Oo = str2;
        O000000o(str2);
        return O00000Oo;
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    private static int O00000o() {
        return (int) (System.currentTimeMillis() / 86400000);
    }

    private static void O000000o(File file) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        O000000o(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public StatLogCache(Context context) {
        this.O0000O0o = 0;
        this.f11856O000000o = context.getSharedPreferences("STAT_LOG_CACHE_STATUS", 0);
        this.O00000o0 = O000000o(context);
        String[] list = new File(this.O00000o0).list();
        this.O0000O0o = O00000o();
        this.O00000oO = this.O0000O0o;
        this.O00000o = this.O00000oO - 3;
        if (list != null) {
            for (String str : list) {
                if (str.matches("^d\\d+$")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    if (parseInt < this.O00000o) {
                        O000000o(parseInt);
                    } else {
                        this.O00000oo.put(Integer.valueOf(parseInt), new hyf(this.f11856O000000o, this.O00000o0, parseInt));
                    }
                }
            }
        }
    }

    private void O000000o(int i) {
        O000000o(new File(this.O00000o0 + "d" + i));
        hyf remove = this.O00000oo.remove(Integer.valueOf(i));
        if (remove != null) {
            remove.O000000o();
        }
    }

    public final Pair<Integer, hyf> O000000o() {
        int O00000Oo2;
        this.O0000O0o = O00000o();
        int i = this.O00000o;
        while (true) {
            int i2 = this.O0000O0o;
            if (i < i2) {
                hyf hyf = this.O00000oo.get(Integer.valueOf(i));
                if (hyf == null) {
                    this.O00000o++;
                } else {
                    int O00000Oo3 = hyf.O00000Oo();
                    if (O00000Oo3 >= 0) {
                        return new Pair<>(Integer.valueOf(O00000Oo3), hyf);
                    }
                    this.O00000o++;
                    O000000o(i);
                }
                i++;
            } else {
                hyf hyf2 = this.O00000oo.get(Integer.valueOf(i2));
                if (hyf2 == null || (O00000Oo2 = hyf2.O00000Oo()) < 0) {
                    return null;
                }
                return new Pair<>(Integer.valueOf(O00000Oo2), hyf2);
            }
        }
    }

    public final hyf O00000Oo() {
        this.O0000O0o = O00000o();
        hyf hyf = this.O00000oo.get(Integer.valueOf(this.O0000O0o));
        if (hyf == null) {
            synchronized (this) {
                if (!this.O00000oo.containsKey(Integer.valueOf(this.O0000O0o))) {
                    hyf = new hyf(this.f11856O000000o, this.O00000o0, this.O0000O0o);
                    this.O00000oo.put(Integer.valueOf(this.O0000O0o), hyf);
                }
            }
        }
        return hyf;
    }

    public static LinkedList<String> O00000o0() {
        return hyc.O00000Oo();
    }

    public static boolean O000000o(Context context, String str) {
        return hyc.O000000o(hyf.O000000o(O000000o(context), O00000o()), str);
    }
}
