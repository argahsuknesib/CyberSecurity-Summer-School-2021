package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.elj;
import _m_j.emi;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class at {

    /* renamed from: a  reason: collision with root package name */
    private static volatile at f6507a;

    /* renamed from: a  reason: collision with other field name */
    protected SharedPreferences f261a;

    /* renamed from: a  reason: collision with other field name */
    private HashSet<a> f262a = new HashSet<>();
    protected SharedPreferences b;

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        /* access modifiers changed from: protected */
        public abstract void onCallback();

        public final void run() {
            onCallback();
        }
    }

    private at(Context context) {
        this.f261a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static at a(Context context) {
        if (f6507a == null) {
            synchronized (at.class) {
                if (f6507a == null) {
                    f6507a = new at(context);
                }
            }
        }
        return f6507a;
    }

    private String a(int i) {
        return "oc_".concat(String.valueOf(i));
    }

    private String a(hv hvVar) {
        return "oc_version_" + hvVar.a();
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            String str2 = (String) pair.second;
            if (str.equals(a(hu.aQ.a()))) {
                editor.putString(str, emi.O000000o(str2));
            } else {
                editor.putString(str, str2);
            }
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    public int a(int i, int i2) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getInt(a2, 0) : this.f261a.contains(a2) ? this.f261a.getInt(a2, 0) : i2;
        } catch (Exception e) {
            duv.O000000o(i + " oc int error " + e);
            return i2;
        }
    }

    public int a(hv hvVar, int i) {
        try {
            return this.f261a.getInt(a(hvVar), i);
        } catch (Exception e) {
            duv.O000000o(hvVar + " version error " + e);
            return i;
        }
    }

    public long a(int i, long j) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getLong(a2, 0) : this.f261a.contains(a2) ? this.f261a.getLong(a2, 0) : j;
        } catch (Exception e) {
            duv.O000000o(i + " oc long error " + e);
            return j;
        }
    }

    public String a(int i, String str) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getString(a2, null) : this.f261a.contains(a2) ? this.f261a.getString(a2, null) : str;
        } catch (Exception e) {
            duv.O000000o(i + " oc string error " + e);
            return str;
        }
    }

    public synchronized void a() {
        this.f262a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f262a.contains(aVar)) {
            this.f262a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (!elj.O000000o(list)) {
            SharedPreferences.Editor edit = this.b.edit();
            for (Pair next : list) {
                if (next.first != null) {
                    String a2 = a(((Integer) next.first).intValue());
                    if (next.second == null) {
                        edit.remove(a2);
                    } else {
                        a(edit, next, a2);
                    }
                }
            }
            edit.apply();
        }
    }

    public void a(List<Pair<hv, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (elj.O000000o(list) || elj.O000000o(list2)) {
            duv.O000000o("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f261a.edit();
        edit.clear();
        for (Pair next : list) {
            if (!(next.first == null || next.second == null)) {
                edit.putInt(a((hv) next.first), ((Integer) next.second).intValue());
            }
        }
        for (Pair next2 : list2) {
            if (!(next2.first == null || next2.second == null)) {
                a(edit, next2, a(((Integer) next2.first).intValue()));
            }
        }
        edit.apply();
    }

    public boolean a(int i, boolean z) {
        try {
            String a2 = a(i);
            return this.b.contains(a2) ? this.b.getBoolean(a2, false) : this.f261a.contains(a2) ? this.f261a.getBoolean(a2, false) : z;
        } catch (Exception e) {
            duv.O000000o(i + " oc boolean error " + e);
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        duv.O00000o0("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f262a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}
