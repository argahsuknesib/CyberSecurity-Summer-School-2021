package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class dhv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dhv f14649O000000o = null;
    private static dhw O00000Oo = null;
    private static boolean O00000o0 = false;

    private dhv(Context context, List<dgl> list) {
        O00000Oo = new dhw(context, list);
    }

    public static synchronized dhv O000000o(Context context, List<dgl> list) {
        dhv dhv;
        synchronized (dhv.class) {
            if (f14649O000000o == null) {
                f14649O000000o = new dhv(context, list);
            }
            dhv = f14649O000000o;
        }
        return dhv;
    }

    public static synchronized dhv O000000o() {
        dhv dhv;
        synchronized (dhv.class) {
            dhv = f14649O000000o;
        }
        return dhv;
    }

    public final Cursor O000000o(String str, String[] strArr, String str2) {
        return O000000o(false, str, strArr, str2, null, null, null, null, null, null);
    }

    public final int O000000o(String str, String str2) {
        return O000000o(str, str2, (String[]) null, (dhu) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r9 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        java.lang.Long.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r9 != null) goto L_0x002f;
     */
    public final synchronized long O000000o(String str, ContentValues contentValues, dhu dhu) {
        long j;
        j = 0;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (!(writableDatabase == null || contentValues == null)) {
                long replace = writableDatabase.replace(str, "_id", contentValues);
                if (replace >= 0) {
                    did.O00000o0("[Database] insert %s success.", str);
                } else {
                    did.O00000o("[Database] replace %s error.", str);
                }
                j = replace;
            }
        } catch (Throwable th) {
            try {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                if (dhu != null) {
                    Long.valueOf(0);
                }
                throw th2;
            }
        }
        return j;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r0;
     */
    public synchronized Cursor O000000o(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, dhu dhu) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
        }
        return cursor;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        if (r6 != null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r6 != null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        java.lang.Integer.valueOf(r0);
     */
    public synchronized int O000000o(String str, String str2, String[] strArr, dhu dhu) {
        int i;
        i = 0;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (writableDatabase != null) {
                i = writableDatabase.delete(str, str2, strArr);
            }
        } catch (Throwable th) {
            try {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                if (dhu != null) {
                    Integer.valueOf(0);
                }
                throw th2;
            }
        }
        return i;
    }

    public final boolean O000000o(int i, String str, byte[] bArr, boolean z) {
        if (z) {
            return O000000o(i, str, bArr, (dhu) null);
        }
        O000000o o000000o = new O000000o();
        o000000o.O000000o(i, str, bArr);
        dic.O000000o().O000000o(o000000o);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean O000000o(int i, String str, byte[] bArr, dhu dhu) {
        try {
            dhx dhx = new dhx();
            dhx.f14652O000000o = (long) i;
            dhx.O00000oo = str;
            dhx.O00000oO = System.currentTimeMillis();
            dhx.O0000O0o = bArr;
            boolean O00000Oo2 = O00000Oo(dhx);
            if (dhu == null) {
                return O00000Oo2;
            }
            Boolean.valueOf(O00000Oo2);
            return O00000Oo2;
        } catch (Throwable th) {
            if (dhu != null) {
                Boolean bool = Boolean.FALSE;
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    public final Map<String, byte[]> O000000o(int i, dhu dhu) {
        HashMap hashMap = null;
        try {
            List<dhx> O00000o02 = O00000o0(i);
            if (O00000o02 == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (dhx next : O00000o02) {
                    byte[] bArr = next.O0000O0o;
                    if (bArr != null) {
                        hashMap2.put(next.O00000oo, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th) {
                th = th;
                hashMap = hashMap2;
                if (!did.O000000o(th)) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!did.O000000o(th)) {
                return hashMap;
            }
            th.printStackTrace();
            return hashMap;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        return false;
     */
    public final synchronized boolean O000000o(dhx dhx) {
        ContentValues O00000o02;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (writableDatabase != null && (O00000o02 = O00000o0(dhx)) != null) {
                long replace = writableDatabase.replace("t_lr", "_id", O00000o02);
                if (replace < 0) {
                    return false;
                }
                did.O00000o0("[Database] insert %s success.", "t_lr");
                dhx.f14652O000000o = replace;
                return true;
            }
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        return false;
     */
    private synchronized boolean O00000Oo(dhx dhx) {
        ContentValues O00000o;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (writableDatabase != null && (O00000o = O00000o(dhx)) != null) {
                long replace = writableDatabase.replace("t_pf", "_id", O00000o);
                if (replace < 0) {
                    return false;
                }
                did.O00000o0("[Database] insert %s success.", "t_pf");
                dhx.f14652O000000o = replace;
                return true;
            }
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9 A[SYNTHETIC, Splitter:B:49:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b0 A[Catch:{ all -> 0x00ad }] */
    public final synchronized List<dhx> O000000o(int i) {
        Cursor cursor;
        String str;
        SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = ".concat(String.valueOf(i));
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            cursor = writableDatabase.query("t_lr", null, str, null, null, null, null);
            if (cursor != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        dhx O000000o2 = O000000o(cursor);
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                        } else {
                            long j = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb.append(" or _id = ");
                            sb.append(j);
                        }
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        did.O00000o("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2.substring(4), null)));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!did.O000000o(th)) {
                    }
                    if (cursor != null) {
                    }
                    return null;
                }
            } else if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0076, code lost:
        return;
     */
    public final synchronized void O000000o(List<dhx> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (dhx dhx : list) {
                        sb.append(" or _id = ");
                        sb.append(dhx.f14652O000000o);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        did.O00000o0("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    } catch (Throwable th) {
                        if (!did.O000000o(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final synchronized void O00000Oo(int i) {
        String str;
        SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = ".concat(String.valueOf(i));
                } catch (Throwable th) {
                    if (!did.O000000o(th)) {
                        th.printStackTrace();
                    }
                    return;
                }
            } else {
                str = null;
            }
            did.O00000o0("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
            return;
        }
        return;
    }

    private static ContentValues O00000o0(dhx dhx) {
        if (dhx == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (dhx.f14652O000000o > 0) {
                contentValues.put("_id", Long.valueOf(dhx.f14652O000000o));
            }
            contentValues.put("_tp", Integer.valueOf(dhx.O00000Oo));
            contentValues.put("_pc", dhx.O00000o0);
            contentValues.put("_th", dhx.O00000o);
            contentValues.put("_tm", Long.valueOf(dhx.O00000oO));
            if (dhx.O0000O0o != null) {
                contentValues.put("_dt", dhx.O0000O0o);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static dhx O000000o(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            dhx dhx = new dhx();
            dhx.f14652O000000o = cursor.getLong(cursor.getColumnIndex("_id"));
            dhx.O00000Oo = cursor.getInt(cursor.getColumnIndex("_tp"));
            dhx.O00000o0 = cursor.getString(cursor.getColumnIndex("_pc"));
            dhx.O00000o = cursor.getString(cursor.getColumnIndex("_th"));
            dhx.O00000oO = cursor.getLong(cursor.getColumnIndex("_tm"));
            dhx.O0000O0o = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return dhx;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        return r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0 A[Catch:{ all -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5 A[SYNTHETIC, Splitter:B:44:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ad A[SYNTHETIC, Splitter:B:50:0x00ad] */
    private synchronized List<dhx> O00000o0(int i) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (writableDatabase != null) {
                String concat = "_id = ".concat(String.valueOf(i));
                cursor = writableDatabase.query("t_pf", null, concat, null, null, null, null);
                if (cursor != null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        ArrayList arrayList = new ArrayList();
                        while (cursor.moveToNext()) {
                            dhx O00000Oo2 = O00000Oo(cursor);
                            if (O00000Oo2 != null) {
                                arrayList.add(O00000Oo2);
                            } else {
                                String string = cursor.getString(cursor.getColumnIndex("_tp"));
                                sb.append(" or _tp = ");
                                sb.append(string);
                            }
                        }
                        if (sb.length() > 0) {
                            sb.append(" and _id = ");
                            sb.append(i);
                            did.O00000o("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", concat.substring(4), null)));
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!did.O000000o(th)) {
                            }
                            if (cursor != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                } else if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean O000000o(int i, String str, dhu dhu) {
        boolean z;
        String str2;
        z = false;
        try {
            SQLiteDatabase writableDatabase = O00000Oo.getWritableDatabase();
            if (writableDatabase != null) {
                if (dif.O000000o(str)) {
                    str2 = "_id = ".concat(String.valueOf(i));
                } else {
                    str2 = "_id = " + i + " and _tp = \"" + str + jdn.f1779O000000o;
                }
                int delete = writableDatabase.delete("t_pf", str2, null);
                did.O00000o0("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                if (delete > 0) {
                    z = true;
                }
            }
            if (dhu != null) {
                Boolean.valueOf(z);
            }
        } catch (Throwable th) {
            try {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
                if (dhu != null) {
                    Boolean bool = Boolean.FALSE;
                }
            } catch (Throwable th2) {
                if (dhu != null) {
                    Boolean bool2 = Boolean.FALSE;
                }
                throw th2;
            }
        }
        return z;
    }

    private static ContentValues O00000o(dhx dhx) {
        if (dhx != null && !dif.O000000o(dhx.O00000oo)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (dhx.f14652O000000o > 0) {
                    contentValues.put("_id", Long.valueOf(dhx.f14652O000000o));
                }
                contentValues.put("_tp", dhx.O00000oo);
                contentValues.put("_tm", Long.valueOf(dhx.O00000oO));
                if (dhx.O0000O0o != null) {
                    contentValues.put("_dt", dhx.O0000O0o);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!did.O000000o(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static dhx O00000Oo(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            dhx dhx = new dhx();
            dhx.f14652O000000o = cursor.getLong(cursor.getColumnIndex("_id"));
            dhx.O00000oO = cursor.getLong(cursor.getColumnIndex("_tm"));
            dhx.O00000oo = cursor.getString(cursor.getColumnIndex("_tp"));
            dhx.O0000O0o = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return dhx;
        } catch (Throwable th) {
            if (!did.O000000o(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f14650O000000o = 4;
        private dhu O00000Oo = null;
        private ContentValues O00000o;
        private String O00000o0;
        private boolean O00000oO;
        private String[] O00000oo;
        private String O0000O0o;
        private String[] O0000OOo;
        private String O0000Oo;
        private String O0000Oo0;
        private String O0000OoO;
        private String O0000Ooo;
        private byte[] O0000o;
        private String[] O0000o0;
        private String O0000o00;
        private int O0000o0O;
        private String O0000o0o;

        public O000000o() {
        }

        public final void O000000o(int i, String str, byte[] bArr) {
            this.O0000o0O = i;
            this.O0000o0o = str;
            this.O0000o = bArr;
        }

        public final void run() {
            switch (this.f14650O000000o) {
                case 1:
                    long unused = dhv.this.O000000o(this.O00000o0, this.O00000o, this.O00000Oo);
                    return;
                case 2:
                    int unused2 = dhv.this.O000000o(this.O00000o0, this.O0000o00, this.O0000o0, this.O00000Oo);
                    return;
                case 3:
                    Cursor unused3 = dhv.this.O000000o(this.O00000oO, this.O00000o0, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000Ooo, this.O00000Oo);
                    return;
                case 4:
                    boolean unused4 = dhv.this.O000000o(this.O0000o0O, this.O0000o0o, this.O0000o, this.O00000Oo);
                    return;
                case 5:
                    Map unused5 = dhv.this.O000000o(this.O0000o0O, this.O00000Oo);
                    return;
                case 6:
                    boolean unused6 = dhv.this.O000000o(this.O0000o0O, this.O0000o0o, this.O00000Oo);
                    return;
                default:
                    return;
            }
        }
    }
}
