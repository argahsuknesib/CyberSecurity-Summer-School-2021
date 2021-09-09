package _m_j;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

public final class O0o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Field f6695O000000o;
    private static boolean O00000Oo;
    private static boolean O00000o;
    private static Class<?> O00000o0;
    private static Field O00000oO;
    private static boolean O00000oo;
    private static Field O0000O0o;
    private static boolean O0000OOo;

    public static void O000000o(Resources resources) {
        if (Build.VERSION.SDK_INT < 28) {
            if (Build.VERSION.SDK_INT >= 24) {
                O00000o(resources);
            } else if (Build.VERSION.SDK_INT >= 23) {
                O00000o0(resources);
            } else if (Build.VERSION.SDK_INT >= 21) {
                O00000Oo(resources);
            }
        }
    }

    private static void O00000Oo(Resources resources) {
        Map map;
        if (!O00000Oo) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f6695O000000o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            O00000Oo = true;
        }
        Field field = f6695O000000o;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void O00000o0(Resources resources) {
        if (!O00000Oo) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f6695O000000o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            O00000Oo = true;
        }
        Object obj = null;
        Field field = f6695O000000o;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj != null) {
            O000000o(obj);
        }
    }

    private static void O00000o(Resources resources) {
        Object obj;
        if (!O0000OOo) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                O0000O0o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            O0000OOo = true;
        }
        Field field = O0000O0o;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                obj = null;
            }
            if (obj != null) {
                if (!O00000Oo) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f6695O000000o = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e3) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                    }
                    O00000Oo = true;
                }
                Field field2 = f6695O000000o;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                    }
                }
                if (obj2 != null) {
                    O000000o(obj2);
                }
            }
        }
    }

    private static void O000000o(Object obj) {
        LongSparseArray longSparseArray;
        if (!O00000o) {
            try {
                O00000o0 = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            O00000o = true;
        }
        Class<?> cls = O00000o0;
        if (cls != null) {
            if (!O00000oo) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    O00000oO = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                O00000oo = true;
            }
            Field field = O00000oO;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
