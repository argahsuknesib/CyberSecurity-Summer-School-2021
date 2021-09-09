package _m_j;

import _m_j.bvh;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;
import java.util.Map;

public final class bvi {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f13308O000000o;
    private String O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private boolean O00000oO;
    private SharedPreferences O00000oo;
    private bvh O0000O0o;
    private SharedPreferences.Editor O0000OOo;
    private Context O0000Oo;
    private bvh.O000000o O0000Oo0;
    private bvk O0000OoO;
    private boolean O0000Ooo;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[SYNTHETIC, Splitter:B:22:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0137 A[Catch:{ Exception -> 0x0143 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    public bvi(Context context, String str, String str2) {
        long j;
        long j2;
        boolean z;
        SharedPreferences sharedPreferences;
        bvk bvk;
        bvh O000000o2;
        SharedPreferences sharedPreferences2;
        this.f13308O000000o = "";
        this.O00000Oo = "";
        this.O00000o0 = false;
        this.O00000o = false;
        this.O00000oO = false;
        this.O00000oo = null;
        this.O0000O0o = null;
        this.O0000OOo = null;
        this.O0000Oo0 = null;
        this.O0000Oo = null;
        this.O0000OoO = null;
        this.O0000Ooo = false;
        this.O00000o0 = false;
        this.O0000Ooo = true;
        this.f13308O000000o = str2;
        this.O00000Oo = str;
        this.O0000Oo = context;
        if (context != null) {
            this.O00000oo = context.getSharedPreferences(str2, 0);
            j = this.O00000oo.getLong("t", 0);
        } else {
            j = 0;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (!bvf.O000000o(externalStorageState)) {
            if (externalStorageState.equals("mounted")) {
                this.O00000oO = true;
                this.O00000o = true;
            } else if (externalStorageState.equals("mounted_ro")) {
                this.O00000o = true;
                this.O00000oO = false;
            }
            if ((this.O00000o || this.O00000oO) && context != null && !bvf.O000000o(str)) {
                this.O0000OoO = O00000Oo(str);
                bvk = this.O0000OoO;
                if (bvk != null) {
                    try {
                        this.O0000O0o = bvk.O000000o(str2);
                        j2 = this.O0000O0o.O000000o("t");
                        try {
                            j = this.O00000oo.getLong("t2", 0);
                            j2 = this.O0000O0o.O000000o("t2");
                            if (j >= j2 || j <= 0) {
                                if (j > j2 && j2 > 0) {
                                    O000000o(this.O0000O0o, this.O00000oo);
                                    sharedPreferences2 = context.getSharedPreferences(str2, 0);
                                } else if (j == 0 && j2 > 0) {
                                    O000000o(this.O0000O0o, this.O00000oo);
                                    sharedPreferences2 = context.getSharedPreferences(str2, 0);
                                } else if (j2 != 0 || j <= 0) {
                                    if (j == j2) {
                                        O000000o(this.O00000oo, this.O0000O0o);
                                        O000000o2 = this.O0000OoO.O000000o(str2);
                                    }
                                    if (j == j2 || (j == 0 && j2 == 0)) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        z = this.O0000Ooo;
                                        if (z || (z && j == 0 && j2 == 0)) {
                                            sharedPreferences = this.O00000oo;
                                            if (sharedPreferences != null) {
                                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                                edit.putLong("t2", currentTimeMillis);
                                                edit.commit();
                                            }
                                            if (this.O0000O0o != null) {
                                                bvh.O000000o O00000o02 = this.O0000O0o.O00000o0();
                                                O00000o02.O000000o("t2", currentTimeMillis);
                                                O00000o02.O00000Oo();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else {
                                    O000000o(this.O00000oo, this.O0000O0o);
                                    O000000o2 = this.O0000OoO.O000000o(str2);
                                }
                                this.O00000oo = sharedPreferences2;
                                if (j == j2) {
                                }
                                long currentTimeMillis2 = System.currentTimeMillis();
                                z = this.O0000Ooo;
                                if (z) {
                                }
                                sharedPreferences = this.O00000oo;
                                if (sharedPreferences != null) {
                                }
                                if (this.O0000O0o != null) {
                                }
                            } else {
                                O000000o(this.O00000oo, this.O0000O0o);
                                O000000o2 = this.O0000OoO.O000000o(str2);
                            }
                            this.O0000O0o = O000000o2;
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                    if (j == j2) {
                    }
                    long currentTimeMillis22 = System.currentTimeMillis();
                    z = this.O0000Ooo;
                    if (z) {
                    }
                    sharedPreferences = this.O00000oo;
                    if (sharedPreferences != null) {
                    }
                    if (this.O0000O0o != null) {
                    }
                }
            }
            j2 = 0;
            if (j == j2) {
            }
            long currentTimeMillis222 = System.currentTimeMillis();
            z = this.O0000Ooo;
            if (z) {
            }
            sharedPreferences = this.O00000oo;
            if (sharedPreferences != null) {
            }
            if (this.O0000O0o != null) {
            }
        }
        this.O00000oO = false;
        this.O00000o = false;
        this.O0000OoO = O00000Oo(str);
        bvk = this.O0000OoO;
        if (bvk != null) {
        }
        j2 = 0;
        if (j == j2) {
        }
        long currentTimeMillis2222 = System.currentTimeMillis();
        z = this.O0000Ooo;
        if (z) {
        }
        sharedPreferences = this.O00000oo;
        if (sharedPreferences != null) {
        }
        try {
            if (this.O0000O0o != null) {
            }
        } catch (Exception unused3) {
        }
    }

    private static void O000000o(bvh bvh, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bvh != null && sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            for (Map.Entry next : bvh.O00000Oo().entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof String) {
                    edit.putString(str, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) value).booleanValue());
                }
            }
            edit.commit();
        }
    }

    private static void O000000o(SharedPreferences sharedPreferences, bvh bvh) {
        if (sharedPreferences != null && bvh != null) {
            bvh.O000000o O00000o02 = bvh.O00000o0();
            O00000o02.O000000o();
            for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof String) {
                    O00000o02.O000000o(str, (String) value);
                } else if (value instanceof Integer) {
                    O00000o02.O000000o(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    O00000o02.O000000o(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    O00000o02.O000000o(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    O00000o02.O000000o(str, ((Boolean) value).booleanValue());
                }
            }
            O00000o02.O00000Oo();
        }
    }

    private bvk O00000Oo(String str) {
        File file;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            file = null;
        }
        if (file == null) {
            return null;
        }
        this.O0000OoO = new bvk(file.getAbsolutePath());
        return this.O0000OoO;
    }

    private boolean O00000Oo() {
        bvh bvh = this.O0000O0o;
        if (bvh == null) {
            return false;
        }
        boolean O000000o2 = bvh.O000000o();
        if (!O000000o2) {
            O000000o();
        }
        return O000000o2;
    }

    private void O00000o0() {
        bvh bvh;
        SharedPreferences sharedPreferences;
        if (this.O0000OOo == null && (sharedPreferences = this.O00000oo) != null) {
            this.O0000OOo = sharedPreferences.edit();
        }
        if (this.O00000oO && this.O0000Oo0 == null && (bvh = this.O0000O0o) != null) {
            this.O0000Oo0 = bvh.O00000o0();
        }
        O00000Oo();
    }

    public final String O000000o(String str) {
        O00000Oo();
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!bvf.O000000o(string)) {
                return string;
            }
        }
        bvh bvh = this.O0000O0o;
        return bvh != null ? bvh.O000000o(str, "") : "";
    }

    public final void O000000o(String str, long j) {
        if (!bvf.O000000o(str) && !str.equals("t")) {
            O00000o0();
            SharedPreferences.Editor editor = this.O0000OOo;
            if (editor != null) {
                editor.putLong(str, j);
            }
            bvh.O000000o o000000o = this.O0000Oo0;
            if (o000000o != null) {
                o000000o.O000000o(str, j);
            }
        }
    }

    public final void O000000o(String str, String str2) {
        if (!bvf.O000000o(str) && !str.equals("t")) {
            O00000o0();
            SharedPreferences.Editor editor = this.O0000OOo;
            if (editor != null) {
                editor.putString(str, str2);
            }
            bvh.O000000o o000000o = this.O0000Oo0;
            if (o000000o != null) {
                o000000o.O000000o(str, str2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    public final boolean O000000o() {
        boolean z;
        String externalStorageState;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.O0000OOo;
        if (editor != null) {
            if (!this.O0000Ooo && this.O00000oo != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.O0000OOo.commit()) {
                z = false;
                if (!(this.O00000oo == null || (context = this.O0000Oo) == null)) {
                    this.O00000oo = context.getSharedPreferences(this.f13308O000000o, 0);
                }
                externalStorageState = Environment.getExternalStorageState();
                if (!bvf.O000000o(externalStorageState)) {
                    if (externalStorageState.equals("mounted")) {
                        if (this.O0000O0o == null) {
                            bvk O00000Oo2 = O00000Oo(this.O00000Oo);
                            if (O00000Oo2 != null) {
                                this.O0000O0o = O00000Oo2.O000000o(this.f13308O000000o);
                                if (!this.O0000Ooo) {
                                    O000000o(this.O00000oo, this.O0000O0o);
                                } else {
                                    O000000o(this.O0000O0o, this.O00000oo);
                                }
                                this.O0000Oo0 = this.O0000O0o.O00000o0();
                            }
                        } else {
                            bvh.O000000o o000000o = this.O0000Oo0;
                            if (o000000o != null && !o000000o.O00000Oo()) {
                                z = false;
                            }
                        }
                    }
                    if (externalStorageState.equals("mounted") || (externalStorageState.equals("mounted_ro") && this.O0000O0o != null)) {
                        try {
                            if (this.O0000OoO != null) {
                                this.O0000O0o = this.O0000OoO.O000000o(this.f13308O000000o);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                return z;
            }
        }
        z = true;
        this.O00000oo = context.getSharedPreferences(this.f13308O000000o, 0);
        externalStorageState = Environment.getExternalStorageState();
        if (!bvf.O000000o(externalStorageState)) {
        }
        return z;
    }
}
