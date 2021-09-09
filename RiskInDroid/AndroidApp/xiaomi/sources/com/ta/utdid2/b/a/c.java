package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.g;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences.Editor f5802a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f11a;

    /* renamed from: a  reason: collision with other field name */
    private b.a f12a;

    /* renamed from: a  reason: collision with other field name */
    private b f13a;

    /* renamed from: a  reason: collision with other field name */
    private d f14a;
    private String b = "";
    private String c = "";
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i;
    private Context mContext;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[SYNTHETIC, Splitter:B:26:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0168 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0184 A[Catch:{ Exception -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    public c(Context context, String str, String str2, boolean z, boolean z2) {
        long j;
        long j2;
        boolean z3;
        SharedPreferences sharedPreferences;
        d dVar;
        long j3;
        String str3 = null;
        this.f11a = null;
        this.f13a = null;
        this.f5802a = null;
        this.f12a = null;
        this.mContext = null;
        this.f14a = null;
        this.i = false;
        this.f = z;
        this.i = z2;
        this.b = str2;
        this.c = str;
        this.mContext = context;
        if (context != null) {
            this.f11a = context.getSharedPreferences(str2, 0);
            j = this.f11a.getLong("t", 0);
        } else {
            j = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!g.m101a(str3)) {
            if (str3.equals("mounted")) {
                this.h = true;
                this.g = true;
            } else if (str3.equals("mounted_ro")) {
                this.g = true;
                this.h = false;
            }
            if ((this.g || this.h) && context != null && !g.m101a(str)) {
                this.f14a = a(str);
                dVar = this.f14a;
                if (dVar != null) {
                    try {
                        this.f13a = dVar.a(str2, 0);
                        j3 = this.f13a.getLong("t", 0);
                        if (!z2) {
                            if (j > j3) {
                                try {
                                    a(this.f11a, this.f13a);
                                    this.f13a = this.f14a.a(str2, 0);
                                } catch (Exception unused) {
                                }
                            } else if (j < j3) {
                                a(this.f13a, this.f11a);
                                this.f11a = context.getSharedPreferences(str2, 0);
                            } else if (j == j3) {
                                a(this.f11a, this.f13a);
                                this.f13a = this.f14a.a(str2, 0);
                            }
                            j2 = j3;
                            if (j == j2 || (j == 0 && j2 == 0)) {
                                long currentTimeMillis = System.currentTimeMillis();
                                z3 = this.i;
                                if (z3 || (z3 && j == 0 && j2 == 0)) {
                                    sharedPreferences = this.f11a;
                                    if (sharedPreferences != null) {
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong("t2", currentTimeMillis);
                                        edit.commit();
                                    }
                                    if (this.f13a == null) {
                                        b.a a2 = this.f13a.a();
                                        a2.a("t2", currentTimeMillis);
                                        a2.commit();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        j = this.f11a.getLong("t2", 0);
                        j2 = this.f13a.getLong("t2", 0);
                        if (j < j2 && j > 0) {
                            try {
                                a(this.f11a, this.f13a);
                                this.f13a = this.f14a.a(str2, 0);
                            } catch (Exception unused2) {
                                j3 = j2;
                            }
                            if (j == j2) {
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            z3 = this.i;
                            if (z3) {
                            }
                            sharedPreferences = this.f11a;
                            if (sharedPreferences != null) {
                            }
                            if (this.f13a == null) {
                            }
                        } else if (j > j2 && j2 > 0) {
                            a(this.f13a, this.f11a);
                            this.f11a = context.getSharedPreferences(str2, 0);
                            if (j == j2) {
                            }
                            long currentTimeMillis22 = System.currentTimeMillis();
                            z3 = this.i;
                            if (z3) {
                            }
                            sharedPreferences = this.f11a;
                            if (sharedPreferences != null) {
                            }
                            if (this.f13a == null) {
                            }
                        } else if (j == 0 && j2 > 0) {
                            a(this.f13a, this.f11a);
                            this.f11a = context.getSharedPreferences(str2, 0);
                            if (j == j2) {
                            }
                            long currentTimeMillis222 = System.currentTimeMillis();
                            z3 = this.i;
                            if (z3) {
                            }
                            sharedPreferences = this.f11a;
                            if (sharedPreferences != null) {
                            }
                            if (this.f13a == null) {
                            }
                        } else if (j2 != 0 || j <= 0) {
                            if (j == j2) {
                                a(this.f11a, this.f13a);
                                this.f13a = this.f14a.a(str2, 0);
                            }
                            if (j == j2) {
                            }
                            long currentTimeMillis2222 = System.currentTimeMillis();
                            z3 = this.i;
                            if (z3) {
                            }
                            sharedPreferences = this.f11a;
                            if (sharedPreferences != null) {
                            }
                            if (this.f13a == null) {
                            }
                        } else {
                            a(this.f11a, this.f13a);
                            this.f13a = this.f14a.a(str2, 0);
                            if (j == j2) {
                            }
                            long currentTimeMillis22222 = System.currentTimeMillis();
                            z3 = this.i;
                            if (z3) {
                            }
                            sharedPreferences = this.f11a;
                            if (sharedPreferences != null) {
                            }
                            if (this.f13a == null) {
                            }
                        }
                    } catch (Exception unused3) {
                        j3 = 0;
                    }
                }
            }
            j2 = 0;
            if (j == j2) {
            }
            long currentTimeMillis222222 = System.currentTimeMillis();
            z3 = this.i;
            if (z3) {
            }
            sharedPreferences = this.f11a;
            if (sharedPreferences != null) {
            }
            if (this.f13a == null) {
            }
        }
        this.h = false;
        this.g = false;
        this.f14a = a(str);
        dVar = this.f14a;
        if (dVar != null) {
        }
        j2 = 0;
        if (j == j2) {
        }
        long currentTimeMillis2222222 = System.currentTimeMillis();
        z3 = this.i;
        if (z3) {
        }
        sharedPreferences = this.f11a;
        if (sharedPreferences != null) {
        }
        try {
            if (this.f13a == null) {
            }
        } catch (Exception unused4) {
        }
    }

    private d a(String str) {
        File a2 = m102a(str);
        if (a2 == null) {
            return null;
        }
        this.f14a = new d(a2.getAbsolutePath());
        return this.f14a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m102a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences != null && bVar != null && (a2 = bVar.a()) != null) {
            a2.b();
            for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof String) {
                    a2.a(str, (String) value);
                } else if (value instanceof Integer) {
                    a2.a(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    a2.a(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    a2.a(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    a2.a(str, ((Boolean) value).booleanValue());
                }
            }
            try {
                a2.commit();
            } catch (Exception unused) {
            }
        }
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar != null && sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            for (Map.Entry next : bVar.getAll().entrySet()) {
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

    private boolean c() {
        b bVar = this.f13a;
        if (bVar == null) {
            return false;
        }
        boolean b2 = bVar.b();
        if (!b2) {
            commit();
        }
        return b2;
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f5802a == null && (sharedPreferences = this.f11a) != null) {
            this.f5802a = sharedPreferences.edit();
        }
        if (this.h && this.f12a == null && (bVar = this.f13a) != null) {
            this.f12a = bVar.a();
        }
        c();
    }

    public void putString(String str, String str2) {
        if (!g.m101a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.f5802a;
            if (editor != null) {
                editor.putString(str, str2);
            }
            b.a aVar = this.f12a;
            if (aVar != null) {
                aVar.a(str, str2);
            }
        }
    }

    public void remove(String str) {
        if (!g.m101a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.f5802a;
            if (editor != null) {
                editor.remove(str);
            }
            b.a aVar = this.f12a;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        if (r6.f12a.commit() == false) goto L_0x0085;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c A[Catch:{ Exception -> 0x00a6 }] */
    public boolean commit() {
        boolean z;
        String str;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.f5802a;
        if (editor != null) {
            if (!this.i && this.f11a != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.f5802a.commit()) {
                z = false;
                if (!(this.f11a == null || (context = this.mContext) == null)) {
                    this.f11a = context.getSharedPreferences(this.b, 0);
                }
                str = null;
                str = Environment.getExternalStorageState();
                if (!g.m101a(str)) {
                    if (str.equals("mounted")) {
                        if (this.f13a == null) {
                            d a2 = a(this.c);
                            if (a2 != null) {
                                this.f13a = a2.a(this.b, 0);
                                if (!this.i) {
                                    a(this.f11a, this.f13a);
                                } else {
                                    a(this.f13a, this.f11a);
                                }
                                this.f12a = this.f13a.a();
                            }
                        } else {
                            try {
                                if (this.f12a != null) {
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (str.equals("mounted") || (str.equals("mounted_ro") && this.f13a != null)) {
                        try {
                            if (this.f14a != null) {
                                this.f13a = this.f14a.a(this.b, 0);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
                return z;
            }
        }
        z = true;
        this.f11a = context.getSharedPreferences(this.b, 0);
        str = null;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!g.m101a(str)) {
        }
        return z;
        z = false;
        if (this.f14a != null) {
        }
        return z;
    }

    public String getString(String str) {
        c();
        SharedPreferences sharedPreferences = this.f11a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!g.m101a(string)) {
                return string;
            }
        }
        b bVar = this.f13a;
        if (bVar != null) {
            return bVar.getString(str, "");
        }
        return "";
    }
}
