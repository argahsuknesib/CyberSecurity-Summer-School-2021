package com.xiaomi.smarthome.acp;

import _m_j.gsc;
import _m_j.gsy;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ACPService extends IntentService {
    public static String FILE_DIR = String.format("/data/data/%s/", "com.xiaomi.smarthome");
    private static ArrayList<String> O00000Oo = new ArrayList<>();

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f4140O000000o = new Handler() {
        /* class com.xiaomi.smarthome.acp.ACPService.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 5) {
                Process.killProcess(Process.myPid());
            }
        }
    };

    public ACPService() {
        super("ACPService");
        O000000o();
    }

    public ACPService(String str) {
        super(str);
        O000000o();
    }

    private static void O000000o() {
        if (FILE_DIR == null) {
            FILE_DIR = String.format("/data/data/%s/", "com.xiaomi.smarthome");
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Intent intent2 = intent;
        if (intent2 != null) {
            String action = intent.getAction();
            gsy.O00000Oo("ACPService", "onHandleIntent ".concat(String.valueOf(action)));
            if (TextUtils.equals(action, "acp_action")) {
                this.f4140O000000o.removeMessages(5);
                int intExtra = intent2.getIntExtra("acp_repeated_crash", 0);
                gsy.O00000Oo("ACPService", "processACPAction ".concat(String.valueOf(intExtra)));
                if (intExtra == 0) {
                    this.f4140O000000o.sendEmptyMessageDelayed(5, 3000);
                    return;
                }
                if (intExtra == 1) {
                    String stringExtra = intent2.getStringExtra("acp_data");
                    long currentTimeMillis = System.currentTimeMillis();
                    O000000o O00000o = O00000o();
                    StringBuilder sb = new StringBuilder("processRepeatedCrash currentCrashTimes=");
                    sb.append(O00000o == null ? 0 : O00000o.f4142O000000o);
                    gsy.O00000Oo("ACPService", sb.toString());
                    long j = currentTimeMillis - ((O00000o == null || O00000o.O00000o0 == 0) ? currentTimeMillis : O00000o.O00000o0);
                    if (O00000o == null || (O00000o.f4142O000000o < 2 && j <= 10000)) {
                        gsy.O00000Oo("ACPService", "increaseCrashTimes");
                        try {
                            O000000o();
                            File file = new File(FILE_DIR + "crash_time");
                            if (!file.exists()) {
                                file.getParentFile().mkdirs();
                                file.createNewFile();
                            }
                            JSONObject jSONObject = O00000o == null ? new JSONObject() : O00000o.O000000o();
                            jSONObject.put("crash_times", jSONObject.optInt("crash_times", 0) + 1);
                            jSONObject.put("crash_content", stringExtra);
                            jSONObject.put("crash_time", System.currentTimeMillis());
                            gsc.O000000o(getApplicationContext(), Uri.fromFile(new File(FILE_DIR + "crash_time")), jSONObject.toString().getBytes("UTF-8"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else if (j > 10000) {
                        O00000Oo();
                    } else {
                        gsy.O00000Oo("ACPService", "showRepeatedCrashDialog");
                        gsc.O000000o(FILE_DIR + "crash_time", FILE_DIR + "crash_time_backup");
                        O00000o0();
                    }
                } else if (intExtra == 2) {
                    O00000o0();
                } else if (intExtra == 3) {
                    O00000Oo();
                } else if (intExtra == 4) {
                    File file2 = new File(FILE_DIR + "crash_time_backup");
                    if (file2.exists()) {
                        try {
                            byte[] O00000o0 = gsc.O00000o0(getApplicationContext(), Uri.fromFile(file2));
                            if (O00000o0 != null) {
                                if (O00000o0.length >= 2) {
                                    if (!TextUtils.isEmpty(O000000o.O000000o(new String(O00000o0, "UTF-8")).O00000o)) {
                                        file2.delete();
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else if (intExtra == 5) {
                    logAppStartTime(intent2.getLongExtra("acp_data", 0));
                }
                this.f4140O000000o.sendEmptyMessageDelayed(5, 3000);
            }
        }
    }

    private void O00000Oo() {
        gsy.O00000Oo("ACPService", "resetRepeatedCrash");
        try {
            O000000o();
            O000000o O00000o = O00000o();
            if (O00000o == null) {
                O00000o = new O000000o((byte) 0);
            }
            O00000o.f4142O000000o = 0;
            O00000o.O00000Oo = 0;
            O00000o.O00000o = "";
            Context applicationContext = getApplicationContext();
            gsc.O000000o(applicationContext, Uri.fromFile(new File(FILE_DIR + "crash_time")), O00000o.O000000o().toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O00000o0() {
        gsy.O00000Oo("ACPService", "clearCacheData");
        Context applicationContext = getApplicationContext();
        deleteFile(applicationContext.getCacheDir(), true);
        deleteFile(applicationContext.getFilesDir(), true);
        File databasePath = applicationContext.getDatabasePath("miio.db");
        if (databasePath != null) {
            deleteFile(databasePath.getParentFile(), true);
        }
        deleteFile(applicationContext.getExternalCacheDir(), true);
        File filesDir = applicationContext.getFilesDir();
        if (filesDir != null) {
            File parentFile = filesDir.getParentFile();
            try {
                deleteFile(new File(parentFile.getCanonicalPath() + File.separator + "app_dex"), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                deleteFile(new File(parentFile.getCanonicalPath() + File.separator + "shared_prefs"), true);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                deleteFile(new File(parentFile.getCanonicalPath() + File.separator + "app_webview"), true);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        O00000Oo();
    }

    public static boolean deleteFile(File file, boolean z) {
        boolean z2;
        if (file == null) {
            return true;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                z2 = true;
                for (int i = 0; i < list.length; i++) {
                    z2 = deleteFile(new File(file, list[i]), true) && z2;
                }
            } else {
                z2 = true;
            }
            if (z) {
                try {
                    if (O00000Oo.contains(file.getCanonicalPath())) {
                        return true;
                    }
                    file.delete();
                } catch (Exception unused) {
                    return false;
                }
            }
            return z2;
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public void logAppStartTime(long j) {
        O000000o o000000o;
        try {
            O000000o();
            File file = new File(FILE_DIR + "crash_time");
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] O00000o0 = gsc.O00000o0(getApplicationContext(), Uri.fromFile(file));
            if (O00000o0 != null) {
                if (O00000o0.length >= 2) {
                    o000000o = O000000o.O000000o(new String(O00000o0, "UTF-8"));
                    o000000o.O00000o0 = j;
                    Context applicationContext = getApplicationContext();
                    gsc.O000000o(applicationContext, Uri.fromFile(new File(FILE_DIR + "crash_time")), o000000o.O000000o().toString().getBytes("UTF-8"));
                }
            }
            o000000o = new O000000o((byte) 0);
            o000000o.O00000o0 = j;
            Context applicationContext2 = getApplicationContext();
            gsc.O000000o(applicationContext2, Uri.fromFile(new File(FILE_DIR + "crash_time")), o000000o.O000000o().toString().getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isReachMaxCrashTimes(Context context) {
        try {
            byte[] O00000o0 = gsc.O00000o0(context, Uri.fromFile(new File(FILE_DIR + "crash_time")));
            if (O00000o0 == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(O00000o0, "UTF-8"));
            if (!jSONObject.isNull("crash_times") && jSONObject.optInt("crash_times", 0) >= 2) {
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private O000000o O00000o() {
        gsy.O00000Oo("ACPService", "readCrashTimes");
        try {
            O000000o();
            Context applicationContext = getApplicationContext();
            byte[] O00000o0 = gsc.O00000o0(applicationContext, Uri.fromFile(new File(FILE_DIR + "crash_time")));
            if (O00000o0 == null) {
                return null;
            }
            if (O00000o0.length < 2) {
                return null;
            }
            return O000000o.O000000o(new String(O00000o0, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f4142O000000o;
        long O00000Oo;
        String O00000o;
        long O00000o0;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public static O000000o O000000o(String str) {
            O000000o o000000o = new O000000o();
            if (TextUtils.isEmpty(str)) {
                return o000000o;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("crash_times")) {
                    o000000o.f4142O000000o = jSONObject.optInt("crash_times", 0);
                }
                if (!jSONObject.isNull("crash_time")) {
                    o000000o.O00000Oo = (long) jSONObject.optInt("crash_time", 0);
                }
                if (!jSONObject.isNull("crash_content")) {
                    o000000o.O00000o = jSONObject.optString("crash_content", "");
                }
                if (!jSONObject.isNull("app_start_time")) {
                    o000000o.O00000o0 = jSONObject.optLong("app_start_time", 0);
                }
                return o000000o;
            } catch (Throwable th) {
                th.printStackTrace();
                return o000000o;
            }
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("crash_times", this.f4142O000000o);
                jSONObject.put("crash_time", this.O00000Oo);
                jSONObject.put("crash_content", this.O00000o);
                jSONObject.put("app_start_time", this.O00000o0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }
}
