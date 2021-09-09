package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Base64;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.ishumei.dfp.SMSDK;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

public class bmh {
    private static bmh O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f13095O000000o;

    bmh() {
        this.f13095O000000o = null;
        this.f13095O000000o = blw.f13081O000000o;
    }

    public static bmh O000000o() {
        if (O00000Oo == null) {
            synchronized (bmh.class) {
                if (O00000Oo == null) {
                    O00000Oo = new bmh();
                }
            }
        }
        return O00000Oo;
    }

    private static String O000000o(Constructor constructor, Method method, Object obj) {
        try {
            return Base64.encodeToString((byte[]) method.invoke(constructor.newInstance(obj), bnd.O00000o0("9b9a89969c9aaa91968e8a9ab69b")), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void O000000o(Class<?> cls, String str, Set<Object> set) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            set.addAll(((Map) declaredField.get(null)).keySet());
        } catch (Throwable unused) {
        }
    }

    private static boolean O000000o(ClassLoader classLoader, String str) {
        if (classLoader == null || !(classLoader instanceof BaseDexClassLoader)) {
            return false;
        }
        try {
            Class<?> cls = Class.forName(bnd.O00000o0("9b9e93899694d18c868c8b9a92d1bb9a87af9e8b97b3968c8b"));
            Method method = Class.forName(bnd.O00000o0("9b9e93899694d18c868c8b9a92d1bb9a87af9e8b97b3968c8bdbba939a929a918b")).getMethod(bnd.O00000o0("8b90ac8b8d969198"), null);
            Field declaredField = cls.getDeclaredField(bnd.O00000o0("9b9a87ba939a929a918b8c"));
            declaredField.setAccessible(true);
            Field declaredField2 = BaseDexClassLoader.class.getDeclaredField(bnd.O00000o0("8f9e8b97b3968c8b"));
            declaredField2.setAccessible(true);
            for (Object invoke : (Object[]) declaredField.get(declaredField2.get(classLoader))) {
                String str2 = (String) method.invoke(invoke, null);
                if (str2 != null && str2.contains(str)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean O000000o(String str) {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (O000000o(systemClassLoader, str) || O000000o(systemClassLoader.getParent(), str)) {
                return true;
            }
            ClassLoader classLoader = getClass().getClassLoader();
            return O000000o(classLoader, str) || O000000o(classLoader.getParent(), str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> O00000Oo() {
        InputMethodManager inputMethodManager;
        List<InputMethodInfo> inputMethodList;
        ArrayList arrayList = new ArrayList();
        try {
            Context context = blw.f13081O000000o;
            if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null || (inputMethodList = inputMethodManager.getInputMethodList()) == null) {
                return arrayList;
            }
            for (InputMethodInfo inputMethodInfo : inputMethodList) {
                arrayList.add(inputMethodInfo.toString());
            }
            return arrayList;
        } catch (Exception unused) {
        }
    }

    public static String O00000o0() {
        Parcel obtain;
        Parcel obtain2;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Field declaredField = Class.forName(bnd.O00000o0("9e919b8d90969bd19d938a9a8b90908b97d1bd938a9a8b90908b97be9b9e8f8b9a8d")).getDeclaredField(bnd.O00000o0("92ac9a8d89969c9a"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(defaultAdapter);
            if (obj != null) {
                Object invoke = Class.forName(bnd.O00000o0("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97dbac8b8a9ddbaf8d908786")).getMethod(bnd.O00000o0("989a8bbe9b9b8d9a8c8c"), null).invoke(obj, null);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
                throw new Exception();
            }
            throw new Exception();
        } catch (Exception unused) {
            try {
                Class<?> cls = Class.forName(bnd.O00000o0("9e919b8d90969bd1908cd1ac9a8d89969c9ab29e919e989a8d"));
                Class.forName(bnd.O00000o0("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8d"));
                Class<?> cls2 = Class.forName(bnd.O00000o0("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8ddbac8b8a9d"));
                Field field = cls2.getField(bnd.O00000o0("b9b6adacaba0bcbeb3b3a0abadbeb1acbebcabb6b0b1"));
                IBinder iBinder = (IBinder) cls.getMethod(bnd.O00000o0("989a8bac9a8d89969c9a"), String.class).invoke(null, bnd.O00000o0("9d938a9a8b90908b97a0929e919e989a8d"));
                field.getInt(cls2);
                obtain = Parcel.obtain();
                obtain2 = Parcel.obtain();
                obtain.writeInterfaceToken(bnd.O00000o0("9e919b8d90969bd19d938a9a8b90908b97d1b6bd938a9a8b90908b97b29e919e989a8d"));
                if (Build.VERSION.SDK_INT >= 21) {
                    iBinder.transact(5, obtain, obtain2, 0);
                } else {
                    iBinder.transact(10, obtain, obtain2, 0);
                }
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString == null ? "" : readString;
            } catch (Exception unused2) {
                return "";
            }
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public static Set<Object> O00000oO() {
        HashSet hashSet = new HashSet();
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(bnd.O00000o0("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bb79a938f9a8d8c"));
            O000000o(loadClass, bnd.O00000o0("99969a939bbc9e9c979a"), hashSet);
            O000000o(loadClass, bnd.O00000o0("929a8b97909bbc9e9c979a"), hashSet);
            O000000o(loadClass, bnd.O00000o0("9c90918c8b8d8a9c8b908dbc9e9c979a"), hashSet);
        } catch (Throwable unused) {
        }
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r1 = false;
     */
    public static Map<String, Object> O00000oo() {
        Field field;
        boolean z;
        Method method;
        Class<?> cls;
        HashMap hashMap = new HashMap();
        try {
            Field[] declaredFields = ClassLoader.getSystemClassLoader().loadClass(bnd.O00000o0("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bbd8d969b989a")).getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i];
                if (bnd.O00000o0("8cb79090949a9bb29a8b97909bbc9e93939d9e9c948c").equals(field.getName())) {
                    break;
                } else if (bnd.O00000o0("979090949a9bb29a8b97909bbc9e93939d9e9c948c").equals(field.getName())) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (field == null) {
                return hashMap;
            }
            field.setAccessible(true);
            Map map = (Map) field.get(null);
            if (!z) {
                cls = ClassLoader.getSystemClassLoader().loadClass(bnd.O00000o0("9b9ad18d909d89d19e919b8d90969bd1878f908c9a9bd1a78f908c9a9bbd8d969b989adbbc908f86b091a88d968b9aac908d8b9a9bac9a8b"));
                method = cls.getDeclaredMethod(bnd.O00000o0("989a8bac919e8f8c97908b"), new Class[0]);
                method.setAccessible(true);
            } else {
                cls = null;
                method = null;
            }
            for (Object next : map.entrySet()) {
                String obj = ((Map.Entry) next).getKey().toString();
                Set set = (Set) hashMap.get(obj);
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(obj, set);
                }
                Object value = ((Map.Entry) next).getValue();
                Object[] array = (cls == null || !cls.isInstance(value)) ? TreeSet.class.isInstance(value) ? ((TreeSet) value).toArray() : null : (Object[]) method.invoke(value, new Object[0]);
                if (array != null) {
                    for (Object obj2 : array) {
                        set.add(obj2.getClass().getName());
                    }
                }
            }
            return hashMap;
        } catch (Exception unused) {
        }
    }

    public static Map<String, Object> O0000O0o() {
        HashMap hashMap = new HashMap();
        try {
            Object invoke = Class.forName(bnd.O00000o0("9e919b8d90969bd19c90918b9a918bd1bc90918b9a878b")).getDeclaredMethod(bnd.O00000o0("989a8bac868c8b9a92ac9a8d89969c9a"), String.class).invoke(blw.f13081O000000o, bnd.O00000o0("9e9c9c9a8c8c969d9693968b86"));
            Method declaredMethod = invoke.getClass().getDeclaredMethod(bnd.O00000o0("968cba919e9d939a9b"), new Class[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod(bnd.O00000o0("989a8bba919e9d939a9bbe9c9c9a8c8c969d9693968b86ac9a8d89969c9ab3968c8b"), Integer.TYPE);
            Object invoke2 = declaredMethod.invoke(invoke, new Object[0]);
            ArrayList arrayList = new ArrayList();
            for (Object next : (List) declaredMethod2.invoke(invoke, -1)) {
                Object invoke3 = next.getClass().getDeclaredMethod(bnd.O00000o0("989a8bb69b"), new Class[0]).invoke(next, new Object[0]);
                if (invoke3 == null) {
                    Object invoke4 = next.getClass().getDeclaredMethod(bnd.O00000o0("989a8bad9a8c9093899ab6919990"), new Class[0]).invoke(next, new Object[0]);
                    arrayList.add(invoke4 == null ? next.toString() : invoke4.toString());
                } else {
                    arrayList.add((String) invoke3);
                }
            }
            hashMap.put("enable", ((Boolean) invoke2).booleanValue() ? "1" : "0");
            hashMap.put("service", arrayList);
            hashMap.put("suc", "1");
        } catch (Throwable th) {
            hashMap.put("e", th.getMessage());
            hashMap.put("suc", "-1");
        }
        return hashMap;
    }

    public static String O0000Oo() {
        StringBuilder sb = new StringBuilder();
        try {
            Method method = Class.forName(bnd.O00000o0("9e919b8d90969bd1908cd1ac9a8d89969c9ab29e919e989a8d")).getMethod(bnd.O00000o0("989a8bac9a8d89969c9a"), String.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, "location");
            Object invoke2 = method.invoke(null, "phone");
            sb.append("locateServiceName:");
            sb.append(invoke.getClass().getName());
            sb.append("|");
            sb.append("phoneServiceName:");
            sb.append(invoke2.getClass().getName());
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String O0000Oo0() {
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> cls = Class.forName(bnd.O00000o0("959e899ed18a8b9693d1aaaab6bb"));
            Class<?> cls2 = Class.forName(bnd.O00000o0("9e919b8d90969bd1929a9b969ed1b29a9b969ebb8d92"));
            Constructor<?> constructor = cls.getConstructor(Long.TYPE, Long.TYPE);
            Constructor<?> constructor2 = cls2.getConstructor(cls);
            Method method = cls2.getMethod(bnd.O00000o0("989a8baf8d908f9a8d8b86bd868b9abe8d8d9e86"), String.class);
            sb.append(O000000o(constructor2, method, constructor.newInstance(-1301668207276963122L, -6645017420763422227L)));
            sb.append("_");
            sb.append(O000000o(constructor2, method, constructor.newInstance(1186680826959645954L, -5988876978535335093L)));
            sb.append("_");
            sb.append(O000000o(constructor2, method, constructor.newInstance(-2129748144642739255L, 8654423357094679310L)));
            sb.append("_");
            sb.append(O000000o(constructor2, method, constructor.newInstance(-7348484286925749626L, -6083546864340672619L)));
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public final boolean O00000o() {
        try {
            return O000000o(bnd.O00000o0("a78f908c9a9bbd8d969b989ad1959e8d"));
        } catch (Exception unused) {
            return false;
        }
    }

    public static void O000000o(blh blh, String str, boolean z, String str2) {
        try {
            String O000000o2 = SMSDK.O000000o(true, str, z, str2);
            String[] split = O000000o2.split("@@@@");
            if (split.length == 2) {
                O000000o2 = split[0];
                blh.O000oOoO = split[1];
            }
            if (O000000o2 == null) {
                blh.O0000o0o = "";
                blh.O000oOo = "0";
                return;
            }
            try {
                blh.O0000o0o = new JSONObject(O000000o2);
                blh.O000oOo = "0";
            } catch (JSONException unused) {
                blh.O0000o0o = O000000o2;
                blh.O000oOo = "4";
            } catch (Exception unused2) {
                blh.O0000o0o = O000000o2;
                blh.O000oOo = "0";
            }
        } catch (Exception unused3) {
            blh.O0000o0o = "";
            blh.O000oOo = "0";
        }
    }

    public static String O0000OOo() {
        Context context = blw.f13081O000000o;
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 23) {
            return "1111111";
        }
        Locale locale = Locale.CHINA;
        Object[] objArr = new Object[7];
        int i = 1;
        objArr[0] = Integer.valueOf(context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? 1 : 0);
        objArr[1] = Integer.valueOf(context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? 1 : 0);
        objArr[2] = Integer.valueOf(context.checkSelfPermission("android.permission.WRITE_SETTINGS") == 0 ? 1 : 0);
        objArr[3] = Integer.valueOf(context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0 ? 1 : 0);
        objArr[4] = Integer.valueOf(context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0);
        objArr[5] = Integer.valueOf(context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? 1 : 0);
        if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            i = 0;
        }
        objArr[6] = Integer.valueOf(i);
        return String.format(locale, "%d%d%d%d%d%d%d", objArr);
    }
}
