package _m_j;

import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class fki {
    private static Random O00000oO = new Random();

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f16517O000000o;
    long O00000Oo;
    public String O00000o;
    public int O00000o0;
    private int O00000oo;
    private long O0000O0o;
    private long O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private long O0000Ooo;
    private gsn O0000o0;
    private boolean O0000o00;
    private O000000o O0000o0O;
    private Map<String, Object> O0000o0o = new HashMap();

    public static abstract class O000000o {
        /* access modifiers changed from: package-private */
        public abstract void O000000o(fki fki);

        /* access modifiers changed from: package-private */
        public abstract void O000000o(fki fki, float f);

        /* access modifiers changed from: package-private */
        public abstract void O000000o(fki fki, int i);

        /* access modifiers changed from: package-private */
        public abstract void O000000o(fki fki, PluginPackageInfo pluginPackageInfo);

        public abstract void O00000Oo(fki fki);
    }

    public fki(String str) {
        this.f16517O000000o = str;
        this.O00000oo = O00000oO.nextInt(Integer.MAX_VALUE);
    }

    public final synchronized <T> T O000000o(String str, T t) {
        T t2 = this.O0000o0o.get(str);
        if (t2 == null) {
            return t;
        }
        return t2;
    }

    public final synchronized void O00000Oo(String str, Object obj) {
        this.O0000o0o.put(str, obj);
    }

    public final synchronized void O000000o(long j) {
        this.O0000O0o = j;
    }

    public final synchronized void O00000Oo(long j) {
        this.O0000OOo = j;
    }

    public final synchronized void O000000o(String str) {
        this.O0000Oo0 = str;
    }

    public final synchronized void O00000Oo(String str) {
        this.O0000Oo = str;
    }

    public final synchronized void O00000o0(String str) {
        this.O0000OoO = str;
    }

    public final synchronized void O00000o0(long j) {
        this.O0000Ooo = j;
    }

    public final synchronized void O000000o(boolean z) {
        this.O0000o00 = z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(gsn gsn) {
        this.O0000o0 = gsn;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(O000000o o000000o) {
        this.O0000o0O = o000000o;
    }

    public final synchronized int O000000o() {
        return this.O00000oo;
    }

    /* access modifiers changed from: package-private */
    public final synchronized long O00000Oo() {
        return this.O0000O0o;
    }

    /* access modifiers changed from: package-private */
    public final synchronized long O00000o0() {
        return this.O0000OOo;
    }

    /* access modifiers changed from: package-private */
    public final synchronized String O00000o() {
        return this.O0000Oo0;
    }

    /* access modifiers changed from: package-private */
    public final synchronized String O00000oO() {
        return this.O0000Oo;
    }

    /* access modifiers changed from: package-private */
    public final synchronized String O00000oo() {
        return this.O0000OoO;
    }

    /* access modifiers changed from: package-private */
    public final synchronized long O0000O0o() {
        return this.O0000Ooo;
    }

    public final synchronized boolean O0000OOo() {
        return this.O0000o00;
    }

    public final synchronized gsn O0000Oo0() {
        return this.O0000o0;
    }

    public final synchronized O000000o O0000Oo() {
        return this.O0000o0O;
    }

    public final void O00000o(long j) {
        O00000Oo("rnSdkApiLevel", Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final synchronized PluginDownloadTask O0000OoO() {
        PluginDownloadTask pluginDownloadTask;
        pluginDownloadTask = new PluginDownloadTask();
        pluginDownloadTask.O00000o = this.O0000OOo;
        pluginDownloadTask.O00000oo = this.O00000oo;
        pluginDownloadTask.O0000O0o = this.O0000Oo0;
        pluginDownloadTask.f6738O000000o = this.f16517O000000o;
        pluginDownloadTask.O00000Oo = this.O00000o0;
        pluginDownloadTask.O00000o0 = this.O00000o;
        pluginDownloadTask.O00000oO = this.O0000O0o;
        return pluginDownloadTask;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            fki fki = (fki) obj;
            if (this.O0000O0o != fki.O0000O0o || this.O0000OOo != fki.O0000OOo) {
                return false;
            }
            String str = this.O0000Oo0;
            if (str != null) {
                return str.equals(fki.O0000Oo0);
            }
            if (fki.O0000Oo0 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.O0000O0o;
        long j2 = this.O0000OOo;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.O0000Oo0;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "PluginDownloadTask{mTaskId=" + this.O00000oo + ", mPluginId=" + this.O0000O0o + ", mPackageId=" + this.O0000OOo + ", mPackageUrl='" + this.O0000Oo + '\'' + ", mPackageSafeUrl='" + this.O0000OoO + '\'' + ", mModel='" + this.f16517O000000o + '\'' + '}';
    }
}
