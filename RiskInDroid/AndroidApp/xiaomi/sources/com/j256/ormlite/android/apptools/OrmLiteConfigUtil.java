package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class OrmLiteConfigUtil {
    private static final ClassComparator classComparator = new ClassComparator();
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    protected static int maxFindSourceLevel = 20;

    public static void main(String[] strArr) throws Exception {
        int i = 0;
        boolean z = false;
        while (i < strArr.length && strArr[i].equals("-s")) {
            i++;
            z = true;
        }
        if (i == strArr.length - 1) {
            writeConfigFile(strArr[i], z);
            return;
        }
        throw new IllegalArgumentException("Usage: OrmLiteConfigUtil [-s] config-file-name");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[]):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[]):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[]):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, boolean):void */
    public static void writeConfigFile(String str) throws SQLException, IOException {
        writeConfigFile(str, false);
    }

    public static void writeConfigFile(String str, boolean z) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, new File("."), 0);
        writeConfigFile(str, (Class[]) arrayList.toArray(new Class[arrayList.size()]), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[], boolean):void
     arg types: [java.lang.String, java.lang.Class<?>[], int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[], boolean):void */
    public static void writeConfigFile(String str, Class<?>[] clsArr) throws SQLException, IOException {
        writeConfigFile(str, clsArr, false);
    }

    public static void writeConfigFile(String str, Class<?>[] clsArr, boolean z) throws SQLException, IOException {
        File findRawDir = findRawDir(new File("."));
        if (findRawDir == null) {
            System.err.println("Could not find raw directory which is typically in the res directory");
        } else {
            writeConfigFile(new File(findRawDir, str), clsArr, z);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, boolean):void
     arg types: [java.io.File, int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[]):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[]):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[]):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, boolean):void */
    public static void writeConfigFile(File file) throws SQLException, IOException {
        writeConfigFile(file, false);
    }

    public static void writeConfigFile(File file, boolean z) throws SQLException, IOException {
        writeConfigFile(file, new File("."), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File, boolean):void
     arg types: [java.io.File, java.io.File, int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File, boolean):void */
    public static void writeConfigFile(File file, File file2) throws SQLException, IOException {
        writeConfigFile(file, file2, false);
    }

    public static void writeConfigFile(File file, File file2, boolean z) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file2, 0);
        writeConfigFile(file, (Class[]) arrayList.toArray(new Class[arrayList.size()]), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[], boolean):void
     arg types: [java.io.File, java.lang.Class<?>[], int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[], boolean):void */
    public static void writeConfigFile(File file, Class<?>[] clsArr) throws SQLException, IOException {
        writeConfigFile(file, clsArr, false);
    }

    public static void writeConfigFile(File file, Class<?>[] clsArr, boolean z) throws SQLException, IOException {
        PrintStream printStream = System.out;
        printStream.println("Writing configurations to " + file.getAbsolutePath());
        writeConfigFile(new FileOutputStream(file), clsArr, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File, boolean):void
     arg types: [java.io.OutputStream, java.io.File, int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File, boolean):void */
    public static void writeConfigFile(OutputStream outputStream, File file) throws SQLException, IOException {
        writeConfigFile(outputStream, file, false);
    }

    public static void writeConfigFile(OutputStream outputStream, File file, boolean z) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file, 0);
        writeConfigFile(outputStream, (Class[]) arrayList.toArray(new Class[arrayList.size()]), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[], boolean):void
     arg types: [java.io.OutputStream, java.lang.Class<?>[], int]
     candidates:
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.File, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.io.File, boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.lang.String, java.lang.Class<?>[], boolean):void
      com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile(java.io.OutputStream, java.lang.Class<?>[], boolean):void */
    public static void writeConfigFile(OutputStream outputStream, Class<?>[] clsArr) throws SQLException, IOException {
        writeConfigFile(outputStream, clsArr, false);
    }

    public static void writeConfigFile(OutputStream outputStream, Class<?>[] clsArr, boolean z) throws SQLException, IOException {
        if (z) {
            Class<?>[] clsArr2 = new Class[clsArr.length];
            System.arraycopy(clsArr, 0, clsArr2, 0, clsArr.length);
            Arrays.sort(clsArr2, classComparator);
            clsArr = clsArr2;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 4096);
        try {
            writeHeader(bufferedWriter);
            for (Class<?> writeConfigForTable : clsArr) {
                writeConfigForTable(bufferedWriter, writeConfigForTable, z);
            }
            System.out.println("Done.");
        } finally {
            bufferedWriter.close();
        }
    }

    protected static File findRawDir(File file) {
        int i = 0;
        while (file != null && i < 20) {
            File findResRawDir = findResRawDir(file);
            if (findResRawDir != null) {
                return findResRawDir;
            }
            file = file.getParentFile();
            i++;
        }
        return null;
    }

    private static void writeHeader(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.append('#');
        bufferedWriter.newLine();
        bufferedWriter.append((CharSequence) "# generated on ").append((CharSequence) new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
        bufferedWriter.newLine();
        bufferedWriter.append('#');
        bufferedWriter.newLine();
    }

    private static void findAnnotatedClasses(List<Class<?>> list, File file, int i) throws SQLException, IOException {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                if (i < maxFindSourceLevel) {
                    findAnnotatedClasses(list, file2, i + 1);
                }
            } else if (file2.getName().endsWith(".java")) {
                String packageOfClass = getPackageOfClass(file2);
                if (packageOfClass == null) {
                    System.err.println("Could not find package name for: ".concat(String.valueOf(file2)));
                } else {
                    String name = file2.getName();
                    try {
                        Class<?> cls = Class.forName(packageOfClass + "." + name.substring(0, name.length() - 5));
                        if (classHasAnnotations(cls)) {
                            list.add(cls);
                        }
                        try {
                            for (Class<?> cls2 : cls.getDeclaredClasses()) {
                                if (classHasAnnotations(cls2)) {
                                    list.add(cls2);
                                }
                            }
                        } catch (Throwable th) {
                            System.err.println("Could not load inner classes for: ".concat(String.valueOf(cls)));
                            System.err.println("     ".concat(String.valueOf(th)));
                        }
                    } catch (Throwable th2) {
                        System.err.println("Could not load class file for: ".concat(String.valueOf(file2)));
                        System.err.println("     ".concat(String.valueOf(th2)));
                    }
                }
            }
        }
    }

    private static void writeConfigForTable(BufferedWriter bufferedWriter, Class<?> cls, boolean z) throws SQLException, IOException {
        String extractTableName = DatabaseTableConfig.extractTableName(databaseType, cls);
        ArrayList arrayList = new ArrayList();
        Class<?> cls2 = cls;
        while (cls2 != null) {
            try {
                for (Field fromField : cls2.getDeclaredFields()) {
                    DatabaseFieldConfig fromField2 = DatabaseFieldConfig.fromField(databaseType, extractTableName, fromField);
                    if (fromField2 != null) {
                        arrayList.add(fromField2);
                    }
                }
                cls2 = cls2.getSuperclass();
            } catch (Error e) {
                System.err.println("Skipping " + cls + " because we got an error finding its definition: " + e.getMessage());
                return;
            }
        }
        if (arrayList.isEmpty()) {
            System.out.println("Skipping " + cls + " because no annotated fields found");
            return;
        }
        DatabaseTableConfigLoader.write(bufferedWriter, new DatabaseTableConfig(cls, extractTableName, arrayList));
        bufferedWriter.append((CharSequence) "#################################");
        bufferedWriter.newLine();
        System.out.println("Wrote config for ".concat(String.valueOf(cls)));
    }

    private static boolean classHasAnnotations(Class<?> cls) {
        while (cls != null) {
            if (cls.getAnnotation(DatabaseTable.class) != null) {
                return true;
            }
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.getAnnotation(DatabaseField.class) != null || field.getAnnotation(ForeignCollectionField.class) != null) {
                        return true;
                    }
                }
                try {
                    cls = cls.getSuperclass();
                } catch (Throwable th) {
                    System.err.println("Could not get super class for: ".concat(String.valueOf(cls)));
                    System.err.println("     ".concat(String.valueOf(th)));
                    return false;
                }
            } catch (Throwable th2) {
                System.err.println("Could not load get delcared fields from: ".concat(String.valueOf(cls)));
                System.err.println("     ".concat(String.valueOf(th2)));
            }
        }
        return false;
    }

    private static String getPackageOfClass(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return null;
                } else if (readLine.contains("package")) {
                    String[] split = readLine.split("[ \t;]");
                    if (split.length > 1 && split[0].equals("package")) {
                        return split[1];
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    private static File findResRawDir(File file) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().equals("res") && file2.isDirectory()) {
                File[] listFiles = file2.listFiles(new FileFilter() {
                    /* class com.j256.ormlite.android.apptools.OrmLiteConfigUtil.AnonymousClass1 */

                    public final boolean accept(File file) {
                        return file.getName().equals("raw") && file.isDirectory();
                    }
                });
                if (listFiles.length == 1) {
                    return listFiles[0];
                }
            }
        }
        return null;
    }

    static class ClassComparator implements Comparator<Class<?>> {
        private ClassComparator() {
        }

        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return compare((Class<?>) ((Class) obj), (Class<?>) ((Class) obj2));
        }

        public int compare(Class<?> cls, Class<?> cls2) {
            return cls.getName().compareTo(cls2.getName());
        }
    }
}
