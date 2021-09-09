package _m_j;

import _m_j.gsj;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fxy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17391O000000o = (CommonApplication.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "rn_ext_module_cache");
    private static final Set<String> O00000o;
    private static volatile fxy O0000O0o;
    public List<O000000o> O00000Oo = new ArrayList();
    public boolean O00000o0 = false;
    private Handler O00000oO = new Handler(fxz.O000000o().getLooper());
    private List<fkv<Integer, Integer>> O00000oo = new ArrayList();

    static {
        HashSet hashSet = new HashSet();
        O00000o = hashSet;
        hashSet.add("null");
    }

    public static fxy O000000o() {
        if (O0000O0o == null) {
            synchronized (fxy.class) {
                if (O0000O0o == null) {
                    O0000O0o = new fxy();
                }
            }
        }
        return O0000O0o;
    }

    private fxy() {
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f17397O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;

        O000000o() {
        }
    }

    public final synchronized void O000000o(fkv<Integer, Integer> fkv) {
        if (fkv != null) {
            this.O00000oo.add(fkv);
        }
        new AppConfigHelper(CommonApplication.getAppContext()).O000000o("android_rn_ext_module_config", "1", "en", "plugin_config/android_rn_ext_module_config.json", new AppConfigHelper.O00000Oo() {
            /* class _m_j.fxy.AnonymousClass1 */

            public final boolean O000000o(String str) throws Exception {
                fxy.this.O000000o(str);
                return fxy.this.O00000o0;
            }

            public final boolean O00000Oo(String str) throws Exception {
                return O000000o(str);
            }
        }, new AppConfigHelper.O000000o() {
            /* class _m_j.fxy.AnonymousClass2 */

            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                fxy fxy = fxy.this;
                fxy.O00000o0 = true;
                fxy.O000000o(str);
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                if (gsf != null) {
                    fyc.O00000o0("RnExtModuleManager", String.format("requestUpdateConfig,requestConfigWitchCache failed, code:%d,msg:%s", Integer.valueOf(gsf.f18205O000000o), gsf.O00000Oo));
                }
            }
        });
    }

    public final void O000000o(String str) {
        final List<O000000o> O00000o02 = O00000o0(str);
        this.O00000oO.post(new Runnable() {
            /* class _m_j.fxy.AnonymousClass3 */

            public final void run() {
                List list = O00000o02;
                if (list != null) {
                    fxy.this.O000000o(list);
                    fxy fxy = fxy.this;
                    HashSet hashSet = new HashSet();
                    for (O000000o O000000o2 : fxy.O00000Oo) {
                        hashSet.add(fxy.O000000o(O000000o2));
                    }
                    File[] listFiles = new File(fxy.f17391O000000o).listFiles(new FileFilter() {
                        /* class _m_j.fxy.AnonymousClass4 */

                        public final boolean accept(File file) {
                            return file.getAbsolutePath().endsWith(".apk");
                        }
                    });
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file : listFiles) {
                            String name = file.getName();
                            if (!hashSet.contains(name)) {
                                fyc.O00000Oo("RnExtModuleManager", "clearUnusedModules, delete file:".concat(String.valueOf(name)));
                                file.delete();
                            }
                        }
                    }
                }
                if (fxy.this.O00000Oo.size() > 0) {
                    fxy fxy2 = fxy.this;
                    fxy.this.O000000o(fxy2.O00000Oo(fxy2.O00000Oo));
                    return;
                }
                fxy.this.O000000o(true);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083 A[Catch:{ JSONException -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087 A[Catch:{ JSONException -> 0x0098 }] */
    private static List<O000000o> O00000o0(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !O00000o.contains(str)) {
            ArrayList arrayList = new ArrayList();
            try {
                fyc.O000000o("RnExtModuleManager", "parse, content:".concat(String.valueOf(str)));
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        O000000o o000000o = new O000000o();
                        o000000o.f17397O000000o = optJSONObject.optString("module_name");
                        o000000o.O00000Oo = optJSONObject.optString("md5");
                        o000000o.O00000o0 = optJSONObject.optString("download_url");
                        o000000o.O00000o = optJSONObject.optString("app_abi");
                        if (!TextUtils.isEmpty(o000000o.f17397O000000o) && !TextUtils.isEmpty(o000000o.O00000Oo) && !TextUtils.isEmpty(o000000o.O00000o0)) {
                            if (!TextUtils.isEmpty(o000000o.O00000o)) {
                                z = true;
                                if (!z) {
                                    arrayList.add(o000000o);
                                } else {
                                    fyc.O00000o0("RnExtModuleManager", "parse config error, config is invalid,content:".concat(String.valueOf(optJSONObject)));
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                fyc.O000000o("RnExtModuleManager", "parse config error, exception:" + Log.getStackTraceString(e));
            }
        }
        return null;
    }

    public final synchronized void O000000o(List<O000000o> list) {
        this.O00000Oo.clear();
        if (list != null && list.size() > 0) {
            this.O00000Oo.addAll(list);
        }
    }

    public final boolean O00000Oo(List<O000000o> list) {
        File file = new File(f17391O000000o);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = fxw.O000000o() ? "arm64-v8a" : "armeabi-v7a";
        boolean z = true;
        fyc.O000000o("RnExtModuleManager", "doDownloadModule: start download ext-module files,targetAbi:".concat(str));
        for (O000000o next : list) {
            if (TextUtils.isEmpty(next.O00000o) || next.O00000o.contains(str)) {
                File file2 = new File(O00000Oo(next));
                if (file2.exists()) {
                    fyc.O000000o("RnExtModuleManager", "moduleSaveFile already exist:" + file2.getAbsolutePath());
                } else {
                    String str2 = f17391O000000o;
                    final File file3 = new File(str2, "temp_" + System.currentTimeMillis());
                    gsj.O000000o o000000o = new gsj.O000000o();
                    o000000o.f18212O000000o = "GET";
                    try {
                        gsg.O000000o(o000000o.O00000Oo(next.O00000o0).O000000o(), new gsp<File>() {
                            /* class _m_j.fxy.AnonymousClass5 */

                            /* JADX INFO: finally extract failed */
                            /* access modifiers changed from: private */
                            /* renamed from: O00000Oo */
                            public File O000000o(Response response) throws Exception {
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(response.body().byteStream());
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                try {
                                    byte[] bArr = new byte[16384];
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read != -1) {
                                            bufferedOutputStream.write(bArr, 0, read);
                                        } else {
                                            bufferedOutputStream.flush();
                                            jcr.O000000o(bufferedInputStream);
                                            jcr.O000000o(bufferedOutputStream);
                                            return file3;
                                        }
                                    }
                                } catch (Throwable th) {
                                    bufferedOutputStream.flush();
                                    jcr.O000000o(bufferedInputStream);
                                    jcr.O000000o(bufferedOutputStream);
                                    throw th;
                                }
                            }
                        });
                    } catch (Exception e) {
                        fyc.O00000o0("RnExtModuleManager", "downloadModule error:" + Log.getStackTraceString(e));
                    }
                    if (next.O00000Oo.equalsIgnoreCase(gbk.O000000o(file3))) {
                        fyc.O000000o("RnExtModuleManager", "doDownloadModule: try install ext-module");
                        file3.renameTo(file2);
                        if (next != null) {
                            String O00000Oo2 = O00000Oo(next);
                            if (!TextUtils.isEmpty(O00000Oo2)) {
                                fxw.O000000o(new File(O00000Oo2));
                            }
                        }
                    } else {
                        fyc.O00000o0("RnExtModuleManager", "doDownloadModule: md5 check failed");
                        file3.delete();
                        z = false;
                    }
                }
            }
        }
        fyc.O000000o("RnExtModuleManager", "doDownloadModule: finish download ext-module files: allSuccess=".concat(String.valueOf(z)));
        return z;
    }

    public final synchronized void O000000o(boolean z) {
        for (fkv call : this.O00000oo) {
            try {
                call.call(Integer.valueOf(z ? 4 : 0));
            } catch (Throwable th) {
                fyc.O00000o0("RnExtModuleManager", "notifyDownloadResult,callback error:" + Log.getStackTraceString(th));
            }
        }
        this.O00000oo.clear();
    }

    public static boolean O00000Oo(String str) {
        return fxw.O000000o(str);
    }

    private static String O00000Oo(O000000o o000000o) {
        return new File(f17391O000000o, O000000o(o000000o)).getAbsolutePath();
    }

    static String O000000o(O000000o o000000o) {
        return o000000o.f17397O000000o + "_" + o000000o.O00000Oo + ".apk";
    }
}
