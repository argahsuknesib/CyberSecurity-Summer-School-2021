package _m_j;

import android.text.TextUtils;
import com.ximalaya.ting.android.player.PlayCacheByLRU$1;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ime {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f1460O000000o = 5;
    private static ime O00000o0;
    public volatile LinkedHashMap<String, String> O00000Oo;

    private ime() {
    }

    public static synchronized ime O000000o() {
        ime ime;
        synchronized (ime.class) {
            if (O00000o0 == null) {
                O00000o0 = new ime();
            }
            ime = O00000o0;
        }
        return ime;
    }

    public static void O00000Oo() {
        ime ime = O00000o0;
        if (ime != null) {
            ime.O00000o();
            O00000o0 = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        return;
     */
    public final synchronized void O00000o0() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new PlayCacheByLRU$1(this, f1460O000000o);
            try {
                Iterator<String> keys = new JSONObject(imf.O00000o0(iml.O0000O0o)).keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        this.O00000Oo.put(keys.next(), "");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final synchronized void O000000o(String str) {
        if (str != null) {
            if (str.startsWith("http")) {
                this.O00000Oo.put(imd.O00000Oo(str), "");
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry next : this.O00000Oo.entrySet()) {
                        jSONObject.put((String) next.getKey(), next.getValue());
                    }
                    imf.O000000o(jSONObject.toString(), iml.O0000O0o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized void O00000Oo(String str) {
        if (this.O00000Oo == null) {
            O00000o0();
        }
        this.O00000Oo.clear();
        O000000o(str);
    }

    private synchronized void O00000o() {
        File[] listFiles;
        try {
            File file = new File(iml.O00000oO);
            if (file.exists() && (listFiles = file.listFiles(new FilenameFilter() {
                /* class _m_j.ime.AnonymousClass1 */

                public final boolean accept(File file, String str) {
                    int lastIndexOf;
                    if (iml.O00000oo.equals(str)) {
                        return false;
                    }
                    if (ime.this.O00000Oo == null || TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) == -1 || !ime.this.O00000Oo.containsKey(str.substring(0, lastIndexOf))) {
                        return true;
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    if (file2 != null) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
