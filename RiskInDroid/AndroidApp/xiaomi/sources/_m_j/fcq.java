package _m_j;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;

public final class fcq extends DexClassLoader {

    /* renamed from: O000000o  reason: collision with root package name */
    private ClassLoader f16087O000000o;
    private ClassLoader O00000Oo;

    private fcq(String str, String str2, String str3, ClassLoader classLoader, ClassLoader classLoader2) {
        super(str, str2, str3, classLoader);
        this.O00000Oo = classLoader;
        this.f16087O000000o = classLoader2;
    }

    public final Class<?> loadClass(String str) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            findLoadedClass = super.loadClass(str, false);
        } catch (ClassNotFoundException unused) {
        }
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return this.f16087O000000o.loadClass(str);
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    public final String findLibrary(String str) {
        return super.findLibrary(str);
    }

    public static ClassLoader O000000o(Context context, long j, long j2, String str) {
        String O000000o2 = hsi.O000000o(context, j);
        File file = new File(O000000o2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String O000000o3 = fkm.O000000o(context, j, j2);
        String O000000o4 = O000000o3 == null ? hsi.O000000o(context, j, j2) : O000000o3;
        gsy.O00000Oo("PluginDexClassLoader", "createDexClassLoader load so path:".concat(String.valueOf(O000000o4)));
        return new fcq(str, O000000o2, O000000o4, context.getClassLoader().getParent(), context.getClassLoader());
    }
}
