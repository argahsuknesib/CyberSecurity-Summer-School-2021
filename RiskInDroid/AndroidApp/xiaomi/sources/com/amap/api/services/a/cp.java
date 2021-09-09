package com.amap.api.services.a;

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

public class cp {
    private static Map<Class<? extends co>, co> d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private cs f3375a;
    private SQLiteDatabase b;
    private co c;

    private boolean a(Annotation annotation) {
        return annotation != null;
    }

    public static synchronized co a(Class<? extends co> cls) throws IllegalAccessException, InstantiationException {
        co coVar;
        synchronized (cp.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            coVar = d.get(cls);
        }
        return coVar;
    }

    public cp(Context context, co coVar) {
        try {
            this.f3375a = new cs(context.getApplicationContext(), coVar.a(), null, coVar.b(), coVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = coVar;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
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

    public <T> void a(String str, Object obj, boolean z) {
        synchronized (this.c) {
            if (obj != null) {
                cq b2 = b(obj.getClass());
                String a2 = a(b2);
                if (!TextUtils.isEmpty(a2)) {
                    ContentValues a3 = a(obj, b2);
                    if (a3 != null) {
                        this.b = b(z);
                        if (this.b != null) {
                            try {
                                this.b.update(a2, a3, str, null);
                                if (this.b != null) {
                                    this.b.close();
                                    this.b = null;
                                }
                            } catch (Throwable th) {
                                if (!z) {
                                    try {
                                        ci.a(th, "dbs", "udd");
                                    } catch (Throwable th2) {
                                        if (this.b != null) {
                                            this.b.close();
                                            this.b = null;
                                        }
                                        throw th2;
                                    }
                                } else {
                                    th.printStackTrace();
                                }
                                if (this.b != null) {
                                    this.b.close();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object, boolean):void
     arg types: [java.lang.String, java.lang.Object, int]
     candidates:
      com.amap.api.services.a.cp.a(android.database.Cursor, java.lang.Class, com.amap.api.services.a.cq):T
      com.amap.api.services.a.cp.a(java.lang.Object, java.lang.reflect.Field, android.content.ContentValues):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class, boolean):java.util.List<T>
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object, boolean):void */
    public <T> void a(String str, Object obj) {
        a(str, obj, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(java.lang.Object, boolean):void
     arg types: [java.lang.Object, int]
     candidates:
      com.amap.api.services.a.cp.a(java.lang.Object, com.amap.api.services.a.cq):android.content.ContentValues
      com.amap.api.services.a.cp.a(android.database.sqlite.SQLiteDatabase, java.lang.Object):void
      com.amap.api.services.a.cp.a(java.lang.Class<?>, boolean):java.lang.reflect.Field[]
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class):java.util.List<T>
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object):void
      com.amap.api.services.a.cp.a(java.lang.Object, boolean):void */
    public <T> void a(Object obj) {
        a(obj, false);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(android.database.sqlite.SQLiteDatabase, java.lang.Object):void
     arg types: [android.database.sqlite.SQLiteDatabase, T]
     candidates:
      com.amap.api.services.a.cp.a(java.lang.Object, com.amap.api.services.a.cq):android.content.ContentValues
      com.amap.api.services.a.cp.a(java.lang.Class<?>, boolean):java.lang.reflect.Field[]
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class):java.util.List<T>
      com.amap.api.services.a.cp.a(java.lang.Object, boolean):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object):void
      com.amap.api.services.a.cp.a(android.database.sqlite.SQLiteDatabase, java.lang.Object):void */
    public <T> void a(T t, boolean z) {
        synchronized (this.c) {
            this.b = b(z);
            if (this.b != null) {
                try {
                    a(this.b, (Object) t);
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    try {
                        ci.a(th, "dbs", "itd");
                        if (this.b != null) {
                            this.b.close();
                        }
                    } catch (Throwable th2) {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(java.lang.Object, com.amap.api.services.a.cq):android.content.ContentValues
     arg types: [T, com.amap.api.services.a.cq]
     candidates:
      com.amap.api.services.a.cp.a(android.database.sqlite.SQLiteDatabase, java.lang.Object):void
      com.amap.api.services.a.cp.a(java.lang.Class<?>, boolean):java.lang.reflect.Field[]
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class):java.util.List<T>
      com.amap.api.services.a.cp.a(java.lang.Object, boolean):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object):void
      com.amap.api.services.a.cp.a(java.lang.Object, com.amap.api.services.a.cq):android.content.ContentValues */
    private <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        ContentValues a2;
        cq b2 = b(t.getClass());
        String a3 = a(b2);
        if (!TextUtils.isEmpty(a3) && t != null && sQLiteDatabase != null && (a2 = a((Object) t, b2)) != null) {
            sQLiteDatabase.insert(a3, null, a2);
        }
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
    public <T> List<T> a(String str, Class<T> cls, boolean z) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            cq b2 = b(cls);
            String a2 = a(b2);
            if (this.b == null) {
                this.b = a(z);
            }
            if (this.b != null && !TextUtils.isEmpty(a2) && str != null) {
                try {
                    cursor = this.b.query(a2, null, str, null, null, null, null);
                    if (cursor == null) {
                        try {
                            this.b.close();
                            this.b = null;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th) {
                                    if (!z) {
                                        ci.a(th, "dbs", "sld");
                                    }
                                }
                            }
                            try {
                                if (this.b != null) {
                                    this.b.close();
                                    this.b = null;
                                }
                            } catch (Throwable th2) {
                                if (!z) {
                                    ci.a(th2, "dbs", "sld");
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (!z) {
                            }
                            if (cursor != null) {
                            }
                            try {
                                if (this.b != null) {
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (!z) {
                                    str2 = "dbs";
                                    str3 = "sld";
                                    ci.a(th, str2, str3);
                                }
                            }
                            return arrayList;
                        }
                    } else {
                        while (cursor.moveToNext()) {
                            arrayList.add(a(cursor, cls, b2));
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th5) {
                                if (!z) {
                                    ci.a(th5, "dbs", "sld");
                                }
                            }
                        }
                        try {
                            if (this.b != null) {
                                this.b.close();
                                this.b = null;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (!z) {
                                str2 = "dbs";
                                str3 = "sld";
                                ci.a(th, str2, str3);
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
                                ci.a(th8, "dbs", "sld");
                            }
                        }
                    }
                    try {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th9) {
                        if (!z) {
                            ci.a(th9, "dbs", "sld");
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class, boolean):java.util.List<T>
     arg types: [java.lang.String, java.lang.Class<T>, int]
     candidates:
      com.amap.api.services.a.cp.a(android.database.Cursor, java.lang.Class, com.amap.api.services.a.cq):T
      com.amap.api.services.a.cp.a(java.lang.Object, java.lang.reflect.Field, android.content.ContentValues):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object, boolean):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class, boolean):java.util.List<T> */
    public <T> List<T> a(String str, Class<T> cls) {
        return a(str, (Class) cls, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.cp.a(java.lang.Class<?>, boolean):java.lang.reflect.Field[]
     arg types: [java.lang.Class<T>, boolean]
     candidates:
      com.amap.api.services.a.cp.a(java.lang.Object, com.amap.api.services.a.cq):android.content.ContentValues
      com.amap.api.services.a.cp.a(android.database.sqlite.SQLiteDatabase, java.lang.Object):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Class):java.util.List<T>
      com.amap.api.services.a.cp.a(java.lang.Object, boolean):void
      com.amap.api.services.a.cp.a(java.lang.String, java.lang.Object):void
      com.amap.api.services.a.cp.a(java.lang.Class<?>, boolean):java.lang.reflect.Field[] */
    private <T> T a(Cursor cursor, Class<T> cls, cq cqVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a2 = a((Class<?>) cls, cqVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(cr.class);
            if (annotation != null) {
                cr crVar = (cr) annotation;
                int b2 = crVar.b();
                int columnIndex = cursor.getColumnIndex(crVar.a());
                switch (b2) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    private void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(cr.class);
        if (annotation != null) {
            cr crVar = (cr) annotation;
            switch (crVar.b()) {
                case 1:
                    contentValues.put(crVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(crVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(crVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(crVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(crVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(crVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    try {
                        contentValues.put(crVar.a(), (byte[]) field.get(obj));
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private ContentValues a(Object obj, cq cqVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), cqVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.f3375a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                ci.a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    private SQLiteDatabase b(boolean z) {
        try {
            if (this.b == null || this.b.isReadOnly()) {
                if (this.b != null) {
                    this.b.close();
                }
                this.b = this.f3375a.getWritableDatabase();
            }
        } catch (Throwable th) {
            ci.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private <T> String a(cq cqVar) {
        if (cqVar == null) {
            return null;
        }
        return cqVar.a();
    }

    private <T> cq b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(cq.class);
        if (!a(annotation)) {
            return null;
        }
        return (cq) annotation;
    }
}
