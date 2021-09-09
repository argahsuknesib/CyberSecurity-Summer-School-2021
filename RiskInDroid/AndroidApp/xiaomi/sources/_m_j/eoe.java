package _m_j;

import _m_j.elr;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.service.bo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class eoe {
    private static volatile eoe O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final ConcurrentLinkedQueue<O00000Oo> f15669O000000o = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */
    public Context O00000Oo;

    class O000000o extends O00000Oo {
        O000000o() {
            super();
        }

        public final void b() {
            eoe.O00000o0(eoe.this);
        }
    }

    class O00000Oo extends elr.O00000Oo {
        long O00000Oo = System.currentTimeMillis();

        O00000Oo() {
        }

        public boolean O000000o() {
            return true;
        }

        public void b() {
        }
    }

    class O00000o0 extends O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f15671O000000o;
        String O00000o;
        File O00000oO;
        int O00000oo;
        boolean O0000O0o;
        boolean O0000OOo;

        O00000o0(String str, String str2, File file, boolean z) {
            super();
            this.f15671O000000o = str;
            this.O00000o = str2;
            this.O00000oO = file;
            this.O0000OOo = z;
        }

        private boolean O00000Oo() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = eoe.this.O00000Oo.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else if (i > 10) {
                return false;
            } else {
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                duv.O00000o0("JSONException on put " + e.getMessage());
            }
            return true;
        }

        public final boolean O000000o() {
            if (!emf.O00000o(eoe.this.O00000Oo)) {
                return this.O0000OOo && emf.O000000o(eoe.this.O00000Oo);
            }
            return true;
        }

        public final void b() {
            try {
                if (O00000Oo()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", bo.m191a());
                    hashMap.put("token", this.O00000o);
                    hashMap.put("net", emf.O0000Oo0(eoe.this.O00000Oo));
                    emf.O000000o(this.f15671O000000o, hashMap, this.O00000oO, "file");
                }
                this.O0000O0o = true;
            } catch (IOException unused) {
            }
        }

        public final void c() {
            if (!this.O0000O0o) {
                this.O00000oo++;
                if (this.O00000oo < 3) {
                    eoe.this.f15669O000000o.add(this);
                }
            }
            if (this.O0000O0o || this.O00000oo >= 3) {
                this.O00000oO.delete();
            }
            eoe.this.O00000Oo((long) ((1 << this.O00000oo) * 1000));
        }
    }

    private eoe(Context context) {
        this.O00000Oo = context;
        this.f15669O000000o.add(new O000000o());
        O000000o(0);
    }

    public static eoe O000000o(Context context) {
        if (O00000o0 == null) {
            synchronized (eoe.class) {
                if (O00000o0 == null) {
                    O00000o0 = new eoe(context);
                }
            }
        }
        O00000o0.O00000Oo = context;
        return O00000o0;
    }

    /* access modifiers changed from: private */
    public void O00000Oo(long j) {
        O00000Oo peek = this.f15669O000000o.peek();
        if (peek != null && peek.O000000o()) {
            O000000o(j);
        }
    }

    public final void O000000o(long j) {
        if (!this.f15669O000000o.isEmpty()) {
            erc.O000000o(new eog(this), j);
        }
    }

    public final void O000000o() {
        while (!this.f15669O000000o.isEmpty()) {
            O00000Oo peek = this.f15669O000000o.peek();
            if (peek != null) {
                if (!(System.currentTimeMillis() - peek.O00000Oo > 172800000) && this.f15669O000000o.size() <= 6) {
                    break;
                }
                duv.O00000o0("remove Expired task");
                this.f15669O000000o.remove(peek);
            }
        }
        O00000Oo(0);
    }

    static /* synthetic */ void O00000o0(eoe eoe) {
        if (!elg.O00000Oo() && !elg.O000000o()) {
            try {
                File file = new File(eoe.O00000Oo.getExternalFilesDir(null) + "/.logcache");
                if (file.exists() && file.isDirectory()) {
                    for (File delete : file.listFiles()) {
                        delete.delete();
                    }
                }
            } catch (NullPointerException unused) {
            }
        }
    }
}
