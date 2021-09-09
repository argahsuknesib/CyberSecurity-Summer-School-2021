package _m_j;

import android.content.Intent;
import android.net.Uri;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;

public final class fxj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17373O000000o = "log.zip";
    public static SimpleDateFormat O00000Oo = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean O000000o(File file) {
        if (file == null || file.isFile()) {
            return false;
        }
        if (file.getName().startsWith("plug_") || file.getName().startsWith("app")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2 A[RETURN] */
    private static String O00000Oo() {
        FileOutputStream fileOutputStream;
        File externalFilesDir = CommonApplication.getAppContext().getExternalFilesDir("logs");
        File file = new File(externalFilesDir, f17373O000000o);
        if (file.exists()) {
            file.delete();
        }
        HashSet hashSet = new HashSet();
        try {
            AnonymousClass1 r3 = new FileFilter() {
                /* class _m_j.fxj.AnonymousClass1 */

                public final boolean accept(File file) {
                    if (file.isFile()) {
                        return true;
                    }
                    return fxj.O000000o(file);
                }
            };
            ftd.O000000o(externalFilesDir.listFiles(r3), new Comparator<File>() {
                /* class _m_j.fxj.AnonymousClass2 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return O000000o((File) obj, (File) obj2);
                }

                private static int O000000o(File file, File file2) {
                    String name = file.getName();
                    String name2 = file2.getName();
                    if (name.endsWith(".txt")) {
                        name = name.substring(0, name.length() - 4);
                    } else if (name.startsWith("mijia_log_v2_")) {
                        name = name.substring(13);
                    } else if (name.startsWith("mijia_log_v3_")) {
                        name = name.substring(13);
                    }
                    if (name2.endsWith(".txt")) {
                        name2 = name2.substring(0, name2.length() - 4);
                    } else if (name2.startsWith("mijia_log_v2_")) {
                        name2 = name2.substring(13);
                    } else if (name2.startsWith("mijia_log_v3_")) {
                        name2 = name2.substring(13);
                    }
                    try {
                        return (int) (fxj.O00000Oo.parse(name).getTime() - fxj.O00000Oo.parse(name2).getTime());
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                }
            });
            hashSet.addAll(Arrays.asList(externalFilesDir.listFiles(r3)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file2 = new File(externalFilesDir, "plugin.txt");
            fileOutputStream = new FileOutputStream(file2);
            try {
                for (Map.Entry<String, PluginPackageInfo> value : fkl.O000000o().O0000OOo.entrySet()) {
                    PluginPackageInfo pluginPackageInfo = (PluginPackageInfo) value.getValue();
                    if (pluginPackageInfo != null) {
                        fileOutputStream.write(("Model - " + pluginPackageInfo.O0000OoO() + ", PackageId - " + pluginPackageInfo.O00000Oo() + "\n").getBytes());
                    }
                }
                fileOutputStream.close();
                hashSet.add(file2);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    gpg.O000000o(fileOutputStream);
                    if (gpg.O000000o(new ArrayList(hashSet), file.getAbsolutePath())) {
                    }
                } catch (Throwable th) {
                    th = th;
                    gpg.O000000o(fileOutputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            e.printStackTrace();
            gpg.O000000o(fileOutputStream);
            if (gpg.O000000o(new ArrayList(hashSet), file.getAbsolutePath())) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            gpg.O000000o(fileOutputStream);
            throw th;
        }
        gpg.O000000o(fileOutputStream);
        if (gpg.O000000o(new ArrayList(hashSet), file.getAbsolutePath())) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static Intent O000000o() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(O00000Oo())), "*/*");
        intent.addFlags(2);
        intent.addFlags(1);
        return intent;
    }
}
