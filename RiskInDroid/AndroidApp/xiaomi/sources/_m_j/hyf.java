package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.smarthome.stat.report.StatLogCache;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public final class hyf {
    private static AtomicInteger O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f978O000000o;
    public final String O00000Oo;
    public int O00000o = 100;
    public SharedPreferences O00000o0;
    hyc[] O00000oO;
    private int O00000oo;
    private int[] O0000O0o = {-2, -2};
    private boolean[][] O0000OOo;

    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyf.O000000o(int, boolean):java.lang.String
     arg types: [int, int]
     candidates:
      _m_j.hyf.O000000o(java.lang.String, int):java.lang.String
      _m_j.hyf.O000000o(int, int):void
      _m_j.hyf.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyf.O000000o(int, boolean):java.lang.String */
    public hyf(SharedPreferences sharedPreferences, String str, int i) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        int i2 = i;
        SharedPreferences.Editor editor = null;
        ? r7 = 1;
        this.O00000oO = new hyc[]{null, null};
        this.O0000OOo = new boolean[][]{new boolean[]{false, false}, new boolean[]{false, false}};
        this.O00000oo = i2;
        this.O00000Oo = "read_" + i2 + "_";
        this.O00000o0 = sharedPreferences2;
        this.f978O000000o = O00000Oo(str, i);
        int i3 = 0;
        while (true) {
            int[] iArr = this.O0000O0o;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = sharedPreferences2.getInt(this.O00000Oo + i3, -2);
            File file = new File(O000000o(i3, (boolean) r7));
            File file2 = new File(O000000o(i3, false));
            long length = file.exists() ? file.length() : 0;
            this.O0000OOo[i3][0] = length > 0;
            long length2 = file2.exists() ? file2.length() : 0;
            this.O0000OOo[i3][r7] = length2 > 0;
            int[] iArr2 = this.O0000O0o;
            if (iArr2[i3] != -2 && length + length2 < 1) {
                iArr2[i3] = -2;
                editor = editor == null ? sharedPreferences.edit() : editor;
                editor.putInt(this.O00000Oo + i3, -2);
            }
            if (length + length2 > 0) {
                int[] iArr3 = this.O0000O0o;
                if (iArr3[i3] < 0) {
                    iArr3[i3] = 0;
                    editor = editor == null ? sharedPreferences.edit() : editor;
                    editor.putInt(this.O00000Oo + i3, 0);
                    if (length < 1) {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            if (length2 > 0) {
                                file2.renameTo(file);
                            }
                            try {
                                this.O0000OOo[i3][0] = true;
                                this.O0000OOo[i3][1] = false;
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                        }
                        this.O00000oO[i3] = new hyc(this, i3);
                        i3++;
                        r7 = 1;
                    }
                }
            }
            this.O00000oO[i3] = new hyc(this, i3);
            i3++;
            r7 = 1;
        }
        if (editor != null) {
            editor.apply();
        }
    }

    private static final String O00000Oo(String str, int i) {
        String str2 = str + "d" + i + "/";
        StatLogCache.O000000o(str2);
        return str2;
    }

    public static final String O000000o(String str, int i) {
        return O00000Oo(str, i) + "w0.log";
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f978O000000o);
        sb.append(z ? "r" : "w");
        sb.append(i);
        sb.append(".log");
        return sb.toString();
    }

    public final boolean O000000o(Context context, String str) {
        this.O00000oO[1].O000000o(str);
        synchronized (this) {
            this.O0000OOo[1][1] = true;
        }
        return true;
    }

    public final void O000000o() {
        SharedPreferences.Editor edit = this.O00000o0.edit();
        SharedPreferences.Editor remove = edit.remove(this.O00000Oo + 0);
        remove.remove(this.O00000Oo + 1).apply();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyf.O000000o(int, boolean):java.lang.String
     arg types: [int, int]
     candidates:
      _m_j.hyf.O000000o(java.lang.String, int):java.lang.String
      _m_j.hyf.O000000o(int, int):void
      _m_j.hyf.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyf.O000000o(int, boolean):java.lang.String */
    public final synchronized int O00000Oo() {
        for (int i = 1; i >= 0; i--) {
            if (this.O0000O0o[i] >= 0) {
                return i;
            }
        }
        int i2 = 1;
        while (i2 >= 0) {
            File file = new File(O000000o(i2, true));
            if (file.exists()) {
                if (file.length() > 0) {
                    this.O0000O0o[i2] = 0;
                    return i2;
                }
                file.delete();
                this.O0000OOo[i2][0] = false;
            }
            File file2 = new File(O000000o(i2, false));
            if (!file2.exists() || file2.length() <= 0) {
                i2--;
            } else {
                file2.renameTo(file);
                this.O0000O0o[i2] = 0;
                this.O0000OOo[i2][0] = true;
                this.O0000OOo[i2][1] = false;
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int O000000o(int i) {
        return this.O0000O0o[i];
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(int i, int i2) {
        if (this.O00000oO[0] != null) {
            this.O0000O0o[i] = i2;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hyf.O000000o(int, boolean):java.lang.String
     arg types: [int, int]
     candidates:
      _m_j.hyf.O000000o(java.lang.String, int):java.lang.String
      _m_j.hyf.O000000o(int, int):void
      _m_j.hyf.O000000o(android.content.Context, java.lang.String):boolean
      _m_j.hyf.O000000o(int, boolean):java.lang.String */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:4|5|6|7|8|9|(1:11)|12|(1:14)|15|(1:17)|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0017 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[Catch:{ Exception -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ Exception -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058 A[Catch:{ Exception -> 0x0066 }] */
    public final synchronized void O00000Oo(int i) {
        if (this.O0000O0o[i] == -1) {
            String O000000o2 = O000000o(i, true);
            new File(O000000o2).delete();
            StringBuilder sb = new StringBuilder();
            sb.append(O000000o2);
            if (O0000Oo0 == null) {
                O0000Oo0 = new AtomicInteger(0);
            }
            Integer valueOf = Integer.valueOf(O0000Oo0.getAndIncrement());
            if (valueOf.intValue() > 2147450880) {
                O0000Oo0.set(0);
            }
            sb.append(valueOf.intValue());
            File file = new File(sb.toString());
            if (file.exists()) {
                file.delete();
            }
            new File(O000000o2).renameTo(file);
            file.delete();
            this.O0000O0o[i] = -2;
            this.O0000OOo[i][0] = false;
        }
        SharedPreferences.Editor edit = this.O00000o0.edit();
        edit.putInt(this.O00000Oo + i, this.O0000O0o[i]).apply();
    }
}
