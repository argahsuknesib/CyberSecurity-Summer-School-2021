package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class bmr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static bmr f13113O000000o;

    public static bmr O000000o() {
        if (f13113O000000o == null) {
            synchronized (bmr.class) {
                if (f13113O000000o == null) {
                    f13113O000000o = new bmr();
                }
            }
        }
        return f13113O000000o;
    }

    public static String O000000o(String str) {
        try {
            Class<?> loadClass = Context.class.getClassLoader().loadClass(bnd.O00000o0("9e919b8d90969bd1908cd1ac868c8b9a92af8d908f9a8d8b969a8c"));
            Method method = loadClass.getMethod(bnd.O00000o0("989a8b"), String.class);
            method.setAccessible(true);
            String str2 = (String) method.invoke(loadClass, str);
            return str2 == null ? "" : str2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static HashMap<String, String> O000000o(boolean z) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Class<?> loadClass = Context.class.getClassLoader().loadClass(bnd.O00000o0("9e919b8d90969bd1908cd1ac868c8b9a92af8d908f9a8d8b969a8c"));
            Method method = loadClass.getMethod(bnd.O00000o0("989a8b"), String.class);
            method.setAccessible(true);
            String[] strArr = {bnd.O00000o0("8d90d19b9a9d8a98989e9d939a"), bnd.O00000o0("8d90d19d90908bd18c9a8d969e939190"), bnd.O00000o0("988c92d1919a8b88908d94d18b868f9a"), bnd.O00000o0("988c92d18c9692d18c8b9e8b9a"), bnd.O00000o0("8f9a8d8c968c8bd18c868cd19c908a918b8d86"), bnd.O00000o0("8f9a8d8c968c8bd18c868cd1939e91988a9e989a"), bnd.O00000o0("8c868cd18a8c9dd18c8b9e8b9a")};
            for (int i = 0; i < 7; i++) {
                String str = strArr[i];
                String str2 = (String) method.invoke(loadClass, str);
                if (str2 != null && !str2.isEmpty()) {
                    hashMap.put(str, str2);
                }
            }
            if (z) {
                String O00000o0 = bnd.O00000o0("8d90d18c9a8d969e939190");
                String str3 = (String) method.invoke(loadClass, O00000o0);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put(O00000o0, str3);
                }
            }
        } catch (Exception e) {
            bmz.O000000o(e);
        }
        return hashMap;
    }

    public static String O00000Oo() {
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> loadClass = Context.class.getClassLoader().loadClass(bnd.O00000o0("9e919b8d90969bd1908cd1ac868c8b9a92af8d908f9a8d8b969a8c"));
            Method method = loadClass.getMethod(bnd.O00000o0("989a8b"), String.class);
            method.setAccessible(true);
            String[] strArr = {bnd.O00000o0("919a8bd19b918cce"), bnd.O00000o0("919a8bd19b918ccd"), bnd.O00000o0("919a8bd19b918ccc"), bnd.O00000o0("919a8bd19b918ccb")};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(loadClass, strArr[i]);
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
            return TextUtils.join(",", arrayList);
        } catch (Exception e) {
            bmz.O000000o(e);
            return "";
        }
    }
}
