package _m_j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.multidex.MultiDexExtractor;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class gi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Set<File> f17802O000000o = new HashSet();
    private static final boolean O00000Oo = O000000o(System.getProperty("java.vm.version"));

    public static void O000000o(Context context) {
        Log.i("MultiDex", "Installing application");
        if (O00000Oo) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (Build.VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo O00000Oo2 = O00000Oo(context);
                if (O00000Oo2 == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                O000000o(context, new File(O00000Oo2.sourceDir), new File(O00000Oo2.dataDir), "secondary-dexes", "");
                Log.i("MultiDex", "install done");
            } catch (Exception e) {
                Log.e("MultiDex", "MultiDex installation failure", e);
                throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
            }
        } else {
            throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
        android.util.Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0091 */
    private static void O000000o(Context context, File file, File file2, String str, String str2) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        synchronized (f17802O000000o) {
            if (!f17802O000000o.contains(file)) {
                f17802O000000o.add(file);
                if (Build.VERSION.SDK_INT > 20) {
                    Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the " + "case here: java.vm.version=\"" + System.getProperty("java.vm.version") + jdn.f1779O000000o);
                }
                ClassLoader classLoader = context.getClassLoader();
                if (classLoader == null) {
                    Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                    return;
                }
                try {
                    O00000o0(context);
                } catch (Throwable th) {
                    Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                }
                File O000000o2 = O000000o(context, file2, str);
                MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, O000000o2);
                IOException e = null;
                try {
                    O000000o(classLoader, O000000o2, multiDexExtractor.O000000o(context, str2, false));
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e2);
                    O000000o(classLoader, O000000o2, multiDexExtractor.O000000o(context, str2, true));
                } catch (Throwable th2) {
                    multiDexExtractor.close();
                    throw th2;
                }
                try {
                    multiDexExtractor.close();
                } catch (IOException e3) {
                    e = e3;
                }
                if (e != null) {
                    throw e;
                }
            }
        }
    }

    private static ApplicationInfo O00000Oo(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    private static boolean O000000o(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        return z;
    }

    private static void O000000o(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            O00000Oo.O000000o(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            O000000o.O000000o(classLoader, list);
        } else {
            O00000o0.O000000o(classLoader, list);
        }
    }

    public static Field O000000o(Object obj, String str) throws NoSuchFieldException {
        Class<?> cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method O000000o(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class<?> cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static void O000000o(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field O000000o2 = O000000o(obj, str);
        Object[] objArr2 = (Object[]) O000000o2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        O000000o2.set(obj, objArr3);
    }

    private static void O00000o0(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
        }
    }

    private static File O000000o(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            O000000o(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            O000000o(file2);
        }
        File file3 = new File(file2, str);
        O000000o(file3);
        return file3;
    }

    private static void O000000o(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }

    static final class O00000Oo {
        static void O000000o(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = gi.O000000o(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            gi.O000000o(obj, "dexElements", O000000o(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field O000000o2 = gi.O000000o(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) O000000o2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                O000000o2.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gi.O000000o(java.lang.Object, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
         arg types: [java.lang.Object, java.lang.String, java.lang.Class[]]
         candidates:
          _m_j.gi.O000000o(android.content.Context, java.io.File, java.lang.String):java.io.File
          _m_j.gi.O000000o(java.lang.ClassLoader, java.io.File, java.util.List<? extends java.io.File>):void
          _m_j.gi.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):void
          _m_j.gi.O000000o(java.lang.Object, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method */
        private static Object[] O000000o(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) gi.O000000o(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList, file, arrayList2);
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final int f17803O000000o = 4;
        private final C0108O000000o O00000Oo;

        /* renamed from: _m_j.gi$O000000o$O000000o  reason: collision with other inner class name */
        interface C0108O000000o {
            Object O000000o(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        static class O00000Oo implements C0108O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            private final Constructor<?> f17804O000000o;

            O00000Oo(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f17804O000000o = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f17804O000000o.setAccessible(true);
            }

            public final Object O000000o(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.f17804O000000o.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        static class O00000o0 implements C0108O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            private final Constructor<?> f17806O000000o;

            O00000o0(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f17806O000000o = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f17806O000000o.setAccessible(true);
            }

            public final Object O000000o(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f17806O000000o.newInstance(file, file, dexFile);
            }
        }

        static class O00000o implements C0108O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            private final Constructor<?> f17805O000000o;

            O00000o(Class<?> cls) throws SecurityException, NoSuchMethodException {
                this.f17805O000000o = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f17805O000000o.setAccessible(true);
            }

            public final Object O000000o(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.f17805O000000o.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        static void O000000o(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = gi.O000000o(classLoader, "pathList").get(classLoader);
            O000000o o000000o = new O000000o();
            Object[] objArr = new Object[list.size()];
            for (int i = 0; i < objArr.length; i++) {
                File file = (File) list.get(i);
                C0108O000000o o000000o2 = o000000o.O00000Oo;
                String path = file.getPath();
                File parentFile = file.getParentFile();
                String name = file.getName();
                objArr[i] = o000000o2.O000000o(file, DexFile.loadDex(path, new File(parentFile, name.substring(0, name.length() - f17803O000000o) + ".dex").getPath(), 0));
            }
            try {
                gi.O000000o(obj, "dexElements", objArr);
            } catch (NoSuchFieldException e) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                gi.O000000o(obj, "pathElements", objArr);
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        private O000000o() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            C0108O000000o o000000o = new O00000Oo(cls);
            try {
                o000000o = new O00000o0(cls);
            } catch (NoSuchMethodException unused) {
                o000000o = new O00000o(cls);
            }
            this.O00000Oo = o000000o;
        }
    }

    static final class O00000o0 {
        static void O000000o(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field O000000o2 = gi.O000000o(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) O000000o2.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            O000000o2.set(classLoader, sb.toString());
            gi.O000000o(classLoader, "mPaths", strArr);
            gi.O000000o(classLoader, "mFiles", fileArr);
            gi.O000000o(classLoader, "mZips", zipFileArr);
            gi.O000000o(classLoader, "mDexs", dexFileArr);
        }
    }
}
