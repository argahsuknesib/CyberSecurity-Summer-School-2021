package _m_j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bsk {
    private static Map<Class<? extends bsj>, bsj> O00000o = new HashMap();

    /* renamed from: O000000o  reason: collision with root package name */
    private bsn f13240O000000o;
    private SQLiteDatabase O00000Oo;
    private bsj O00000o0;

    public bsk(Context context, bsj bsj) {
        try {
            this.f13240O000000o = new bsn(context.getApplicationContext(), bsj.O000000o(), bsj);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O00000o0 = bsj;
    }

    public static synchronized bsj O000000o(Class<? extends bsj> cls) throws IllegalAccessException, InstantiationException {
        bsj bsj;
        synchronized (bsk.class) {
            if (O00000o.get(cls) == null) {
                O00000o.put(cls, cls.newInstance());
            }
            bsj = O00000o.get(cls);
        }
        return bsj;
    }

    private static ContentValues O000000o(Object obj, bsl bsl) {
        ContentValues contentValues = new ContentValues();
        for (Field field : O000000o(obj.getClass(), bsl.O00000Oo())) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(bsm.class);
            if (annotation != null) {
                bsm bsm = (bsm) annotation;
                switch (bsm.O00000Oo()) {
                    case 1:
                        contentValues.put(bsm.O000000o(), Short.valueOf(field.getShort(obj)));
                        continue;
                    case 2:
                        contentValues.put(bsm.O000000o(), Integer.valueOf(field.getInt(obj)));
                        continue;
                    case 3:
                        contentValues.put(bsm.O000000o(), Float.valueOf(field.getFloat(obj)));
                        continue;
                    case 4:
                        contentValues.put(bsm.O000000o(), Double.valueOf(field.getDouble(obj)));
                        continue;
                    case 5:
                        contentValues.put(bsm.O000000o(), Long.valueOf(field.getLong(obj)));
                        continue;
                    case 6:
                        contentValues.put(bsm.O000000o(), (String) field.get(obj));
                        continue;
                    case 7:
                        try {
                            contentValues.put(bsm.O000000o(), (byte[]) field.get(obj));
                            continue;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                }
            }
        }
        return contentValues;
    }

    private SQLiteDatabase O000000o() {
        try {
            if (this.O00000Oo == null || this.O00000Oo.isReadOnly()) {
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                }
                this.O00000Oo = this.f13240O000000o.getWritableDatabase();
            }
        } catch (Throwable th) {
            bsc.O000000o(th, "dbs", "gwd");
        }
        return this.O00000Oo;
    }

    private SQLiteDatabase O000000o(boolean z) {
        try {
            if (this.O00000Oo == null) {
                this.O00000Oo = this.f13240O000000o.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                bsc.O000000o(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.O00000Oo;
    }

    private static <T> T O000000o(Cursor cursor, Class cls, bsl bsl) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj;
        Field[] O000000o2 = O000000o(cls, bsl.O00000Oo());
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : O000000o2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(bsm.class);
            if (annotation != null) {
                bsm bsm = (bsm) annotation;
                int O00000Oo2 = bsm.O00000Oo();
                int columnIndex = cursor.getColumnIndex(bsm.O000000o());
                switch (O00000Oo2) {
                    case 1:
                        obj = Short.valueOf(cursor.getShort(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 2:
                        obj = Integer.valueOf(cursor.getInt(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 3:
                        obj = Float.valueOf(cursor.getFloat(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 4:
                        obj = Double.valueOf(cursor.getDouble(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 5:
                        obj = Long.valueOf(cursor.getLong(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 6:
                        obj = cursor.getString(columnIndex);
                        field.set(newInstance, obj);
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> String O000000o(bsl bsl) {
        if (bsl == null) {
            return null;
        }
        return bsl.O000000o();
    }

    public static String O000000o(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : map.keySet()) {
            if (z) {
                sb.append(next);
                sb.append(" = '");
                sb.append(map.get(next));
                sb.append("'");
                z = false;
            } else {
                sb.append(" and ");
                sb.append(next);
                sb.append(" = '");
                sb.append(map.get(next));
                sb.append("'");
            }
        }
        return sb.toString();
    }

    private static Field[] O000000o(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private static <T> bsl O00000Oo(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(bsl.class);
        if (!(annotation != null)) {
            return null;
        }
        return (bsl) annotation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x00fc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d7 A[SYNTHETIC, Splitter:B:86:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00e9 A[Catch:{ Throwable -> 0x00f1 }] */
    public final <T> List<T> O000000o(String str, Class cls, boolean z) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.O00000o0) {
            ArrayList arrayList = new ArrayList();
            bsl O00000Oo2 = O00000Oo(cls);
            String O000000o2 = O000000o(O00000Oo2);
            if (this.O00000Oo == null) {
                this.O00000Oo = O000000o(z);
            }
            if (this.O00000Oo != null && !TextUtils.isEmpty(O000000o2) && str != null) {
                try {
                    cursor = this.O00000Oo.query(O000000o2, null, str, null, null, null, null);
                    if (cursor == null) {
                        try {
                            this.O00000Oo.close();
                            this.O00000Oo = null;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th) {
                                    if (!z) {
                                        bsc.O000000o(th, "dbs", "sld");
                                    }
                                }
                            }
                            try {
                                if (this.O00000Oo != null) {
                                    this.O00000Oo.close();
                                    this.O00000Oo = null;
                                }
                            } catch (Throwable th2) {
                                if (!z) {
                                    bsc.O000000o(th2, "dbs", "sld");
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (!z) {
                            }
                            if (cursor != null) {
                            }
                            try {
                                if (this.O00000Oo != null) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (!z) {
                                    str2 = "dbs";
                                    str3 = "sld";
                                    bsc.O000000o(th, str2, str3);
                                }
                            }
                            return arrayList;
                        }
                    } else {
                        while (cursor.moveToNext()) {
                            arrayList.add(O000000o(cursor, cls, O00000Oo2));
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th5) {
                                if (!z) {
                                    bsc.O000000o(th5, "dbs", "sld");
                                }
                            }
                        }
                        try {
                            if (this.O00000Oo != null) {
                                this.O00000Oo.close();
                                this.O00000Oo = null;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (!z) {
                                str2 = "dbs";
                                str3 = "sld";
                                bsc.O000000o(th, str2, str3);
                            }
                        }
                        return arrayList;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    cursor = null;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th8) {
                            if (!z) {
                                bsc.O000000o(th8, "dbs", "sld");
                            }
                        }
                    }
                    try {
                        if (this.O00000Oo != null) {
                            this.O00000Oo.close();
                            this.O00000Oo = null;
                        }
                    } catch (Throwable th9) {
                        if (!z) {
                            bsc.O000000o(th9, "dbs", "sld");
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final <T> void O000000o(Object obj) {
        synchronized (this.O00000o0) {
            this.O00000Oo = O000000o();
            if (this.O00000Oo != null) {
                try {
                    SQLiteDatabase sQLiteDatabase = this.O00000Oo;
                    bsl O00000Oo2 = O00000Oo(obj.getClass());
                    String O000000o2 = O000000o(O00000Oo2);
                    if (!TextUtils.isEmpty(O000000o2) && obj != null) {
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.insert(O000000o2, null, O000000o(obj, O00000Oo2));
                        }
                    }
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                        this.O00000Oo = null;
                    }
                } catch (Throwable th) {
                    try {
                        bsc.O000000o(th, "dbs", "itd");
                        if (this.O00000Oo != null) {
                            this.O00000Oo.close();
                        }
                    } catch (Throwable th2) {
                        if (this.O00000Oo != null) {
                            this.O00000Oo.close();
                            this.O00000Oo = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T>
     arg types: [java.lang.String, java.lang.Class<?>, int]
     candidates:
      _m_j.bsk.O000000o(android.database.Cursor, java.lang.Class, _m_j.bsl):T
      _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T> */
    public final void O000000o(Object obj, String str) {
        synchronized (this.O00000o0) {
            if (O000000o(str, (Class) obj.getClass(), false).size() == 0) {
                O000000o(obj);
            } else {
                O000000o(str, obj);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final <T> void O000000o(String str, Object obj) {
        synchronized (this.O00000o0) {
            if (obj != null) {
                bsl O00000Oo2 = O00000Oo(obj.getClass());
                String O000000o2 = O000000o(O00000Oo2);
                if (!TextUtils.isEmpty(O000000o2)) {
                    ContentValues O000000o3 = O000000o(obj, O00000Oo2);
                    this.O00000Oo = O000000o();
                    if (this.O00000Oo != null) {
                        try {
                            this.O00000Oo.update(O000000o2, O000000o3, str, null);
                            if (this.O00000Oo != null) {
                                this.O00000Oo.close();
                                this.O00000Oo = null;
                            }
                        } catch (Throwable th) {
                            try {
                                bsc.O000000o(th, "dbs", "udd");
                                if (this.O00000Oo != null) {
                                    this.O00000Oo.close();
                                }
                            } catch (Throwable th2) {
                                if (this.O00000Oo != null) {
                                    this.O00000Oo.close();
                                    this.O00000Oo = null;
                                }
                                throw th2;
                            }
                        }
                    }
                }
            }
        }
    }
}
