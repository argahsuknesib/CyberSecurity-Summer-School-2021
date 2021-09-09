package _m_j;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;

public final class gbt {
    private static File O00000o0(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException unused) {
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6 A[SYNTHETIC, Splitter:B:40:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b1 A[SYNTHETIC, Splitter:B:46:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bd A[SYNTHETIC, Splitter:B:55:0x00bd] */
    public static boolean O000000o(String str, String str2) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            zipFile = O00000o(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                byte[] bArr = new byte[4096];
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        String name = zipEntry.getName();
                        if (!(name == null || name.indexOf("\\") == -1)) {
                            name = name.replaceAll("\\\\", File.separator);
                        }
                        String str3 = str2 + File.separator + name;
                        if (!O00000Oo(str2, str3)) {
                            throw new FileNotFoundException();
                        } else if (TextUtils.isEmpty(null) || str3.indexOf((String) null) != -1) {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(O00000o0(str3)));
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            bufferedOutputStream.flush();
                            bufferedInputStream.close();
                            bufferedOutputStream.close();
                        }
                    }
                }
                try {
                    zipFile.close();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (FileNotFoundException unused) {
                if (zipFile != null) {
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (zipFile != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            zipFile = null;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
    }

    private static ZipFile O00000o(String str) throws Exception {
        ZipFile zipFile = new ZipFile(str);
        if (Build.VERSION.SDK_INT <= 24) {
            return zipFile;
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        if (!entries.hasMoreElements()) {
            return zipFile;
        }
        try {
            entries.nextElement();
            zipFile.close();
            return new ZipFile(str);
        } catch (Exception unused) {
            return new ZipFile(str, Charset.forName("GBK"));
        }
    }

    public static boolean O00000Oo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gbu.O00000Oo("VerifyFile   fileAbsolutePathName=".concat(String.valueOf(str2)));
            return false;
        }
        String[] split = str2.split(File.separator);
        ArrayList arrayList = new ArrayList();
        for (String add : split) {
            arrayList.add(add);
        }
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if ("..".equals(arrayList.get(i))) {
                if (stack.size() <= 0) {
                    break;
                }
                stack.pop();
            } else if (!"".equals(arrayList.get(i))) {
                stack.push(arrayList.get(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        int size2 = stack.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (i2 == size2 - 1) {
                sb.append((String) stack.get(i2));
            } else {
                sb.append((String) stack.get(i2));
                sb.append(File.separator);
            }
        }
        int length = File.separator.length();
        while (str.startsWith(File.separator)) {
            try {
                str = str.substring(length, str.length());
            } catch (Exception unused) {
            }
        }
        boolean startsWith = sb.toString().startsWith(str);
        gbu.O000000o("VerifyFile   fileAbsolutePathName=".concat(String.valueOf(str2)));
        gbu.O000000o("VerifyFile   resultFilePathName=" + sb.toString());
        gbu.O000000o("VerifyFile   result=".concat(String.valueOf(startsWith)));
        return startsWith;
    }

    public static boolean O000000o(String str) {
        boolean booleanValue = ((Boolean) gat.O000000o("opt_plugin_process_reuse_enable", Boolean.FALSE)).booleanValue();
        boolean O000000o2 = gbj.O000000o((JSONArray) gat.O000000o("opt_plugin_process_reuse_model", null), str);
        boolean O000000o3 = gbj.O000000o((JSONArray) gat.O000000o("opt_plugin_process_un_reuse_model", null), str);
        gbu.O00000oo("RnPluginFileUtils-->pluginProcessReuseEnable processReuseEnable: " + booleanValue + "  modelCanReuseProcess: " + O000000o2 + "  modelCanUnReuseProcess: " + O000000o3);
        if (!O000000o3) {
            return booleanValue || O000000o2;
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (gfr.O0000OOo || gfr.O0000Oo) {
            fvo.O000000o();
            if (fvo.O00000oO()) {
                fvo.O000000o();
                if (fvo.O0000OoO()) {
                    gbu.O00000oo("RnPluginFileUtils-->modelIsSupportMultiRNRuntimeReuse(),force return false");
                    return false;
                }
                fvo.O000000o();
                if (fvo.O0000Oo()) {
                    gbu.O00000oo("RnPluginFileUtils-->modelIsSupportMultiRNRuntimeReuse(),force return true");
                    return true;
                }
            }
        }
        boolean O00000oO = O00000oO(str);
        gbu.O00000oo("RnPluginFileUtils-->modelIsSupportMultiRNRuntimeReuse(),return ".concat(String.valueOf(O00000oO)));
        return O00000oO;
    }

    private static boolean O00000oO(String str) {
        return O000000o(str, "multi_rn_runtime_model", "multi_rn_runtime_un_reuse_model") || O000000o(str, "multi_rn_runtime_model_api_10058", "multi_rn_runtime_un_reuse_model_api_10058");
    }

    private static boolean O000000o(String str, String str2, String str3) {
        return !gbj.O000000o((JSONArray) gat.O000000o(str3, null), str) && gbj.O000000o((JSONArray) gat.O000000o(str2, null), str);
    }

    public static boolean O000000o() {
        if (gfr.O0000OOo || gfr.O0000Oo) {
            fvo.O000000o();
            if (fvo.O00000oO()) {
                fvo.O000000o();
                if (fvo.O0000Oo()) {
                    gbu.O00000oo("RnPluginFileUtils-->multiRNRuntimeReuseEnable(),force return true");
                    return true;
                }
            }
        }
        boolean booleanValue = ((Boolean) gat.O000000o("multi_rn_runtime_reuse_enable", Boolean.TRUE)).booleanValue();
        gbu.O00000oo("RnPluginFileUtils-->multiRNRuntimeReuseEnable(),return ".concat(String.valueOf(booleanValue)));
        return booleanValue;
    }

    public static boolean O00000Oo() {
        boolean z = ((Boolean) gat.O000000o("reinit_new_rn_runtime_enable_all", Boolean.FALSE)).booleanValue() || ((Boolean) gat.O000000o("reinit_new_rn_runtime_enable_api_10058", Boolean.FALSE)).booleanValue();
        gbu.O00000oo("RnPluginFileUtils-->reInitNewRNRuntimeEnable(),return ".concat(String.valueOf(z)));
        return z;
    }

    public static int O00000o0() {
        int i = 5;
        int intValue = ((Integer) gat.O000000o("max_plugin_cache_count", 5)).intValue();
        if (intValue > 0 && intValue <= 15) {
            i = intValue;
        }
        gbu.O00000oo("RnPluginFileUtils.java:maxPluginCacheCount -->>return ".concat(String.valueOf(i)));
        return i;
    }

    public static int O00000o() {
        int i = 50;
        int intValue = ((Integer) gat.O000000o("max_runtime_memory_percent_when_reuse", 50)).intValue();
        if (intValue >= 0 && intValue <= 100) {
            i = intValue;
        }
        gbu.O00000oo("RnPluginFileUtils.java:maxRuntimeMemoryPercentWhenReuse -->>return ".concat(String.valueOf(i)));
        return i;
    }

    public static boolean O00000oO() {
        boolean booleanValue = ((Boolean) gat.O000000o("report_rn_memory_info_enable", Boolean.TRUE)).booleanValue();
        gbu.O00000oo("RnPluginFileUtils-->reportRNMemoryInfoEnable(),return ".concat(String.valueOf(booleanValue)));
        return booleanValue;
    }

    public static boolean O00000oo() {
        boolean booleanValue = ((Boolean) gat.O000000o("is_record_package_name_operation", Boolean.FALSE)).booleanValue();
        gbu.O00000oo("RnPluginFileUtils-->recordPackageNameOperation(),return ".concat(String.valueOf(booleanValue)));
        return booleanValue;
    }
}
