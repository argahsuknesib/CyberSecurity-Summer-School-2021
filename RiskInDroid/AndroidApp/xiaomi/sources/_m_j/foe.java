package _m_j;

import _m_j.gsj;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import java.io.File;
import java.net.URI;
import java.util.HashMap;

public final class foe {

    /* renamed from: O000000o  reason: collision with root package name */
    public static HashMap<String, O000000o> f16738O000000o = new HashMap<>();
    private static Handler O00000Oo;

    interface O00000Oo extends Response.BleResponse<Bundle> {
        void O000000o(int i);
    }

    private static Handler O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new Handler(Looper.getMainLooper());
        }
        return O00000Oo;
    }

    public static void O000000o(String str) {
        O000000o remove;
        if (!TextUtils.isEmpty(str) && (remove = f16738O000000o.remove(str)) != null && remove.f16744O000000o != null) {
            remove.f16744O000000o.O000000o();
        }
    }

    public static void O000000o(String str, final Response.FirmwareUpgradeResponse firmwareUpgradeResponse) {
        gnk.O00000o0(String.format("downloadFirmware v2", new Object[0]));
        O000000o(str, new O00000Oo() {
            /* class _m_j.foe.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str;
                Bundle bundle = (Bundle) obj;
                String str2 = null;
                if (bundle != null) {
                    str2 = bundle.getString("path");
                    str = bundle.getString("md5");
                } else {
                    str = null;
                }
                gnk.O00000o0(String.format("onResponse code = %d, path = %s, md5 = %s", Integer.valueOf(i), str2, str));
                firmwareUpgradeResponse.onResponse(i, str2, str);
            }

            public final void O000000o(int i) {
                firmwareUpgradeResponse.onProgress(i);
            }
        });
    }

    public static void O000000o(String str, final Response.BleUpgradeResponse bleUpgradeResponse) {
        gnk.O00000o0(String.format("downloadFirmware v1", new Object[0]));
        O000000o(str, new O00000Oo() {
            /* class _m_j.foe.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                Bundle bundle = (Bundle) obj;
                String string = bundle != null ? bundle.getString("path") : null;
                gnk.O00000o0(String.format("onResponse code = %d, path = %s", Integer.valueOf(i), string));
                bleUpgradeResponse.onResponse(i, string);
            }

            public final void O000000o(int i) {
                bleUpgradeResponse.onProgress(i);
            }
        });
    }

    public static void O000000o(final O00000Oo o00000Oo, final int i, final String str) {
        O000000o().post(new Runnable() {
            /* class _m_j.foe.AnonymousClass3 */

            public final void run() {
                int i = i;
                if (i != 0) {
                    o00000Oo.onResponse(i, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("path", str);
                bundle.putString("md5", foe.O00000Oo(str));
                o00000Oo.onResponse(0, bundle);
            }
        });
    }

    public static void O000000o(final O00000Oo o00000Oo, final int i) {
        O000000o().post(new Runnable() {
            /* class _m_j.foe.AnonymousClass4 */

            public final void run() {
                o00000Oo.O000000o(i);
            }
        });
    }

    private static void O000000o(final String str, final O00000Oo o00000Oo) {
        if (TextUtils.isEmpty(str)) {
            o00000Oo.onResponse(-3, null);
        } else if (f16738O000000o.containsKey(str)) {
            o00000Oo.onResponse(-13, null);
        } else {
            try {
                File O00000o0 = O00000o0(str);
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsj O000000o2 = o000000o.O00000Oo(str).O000000o();
                final String absolutePath = O00000o0.getAbsolutePath();
                f16738O000000o.put(str, new O000000o(gsg.O00000Oo(O000000o2, new gsm(O00000o0) {
                    /* class _m_j.foe.AnonymousClass5 */

                    public final /* synthetic */ void onSuccess(Object obj, okhttp3.Response response) {
                        O000000o((File) obj);
                    }

                    public final void O000000o(File file) {
                        foe.f16738O000000o.remove(str);
                        foe.O000000o(o00000Oo, 0, absolutePath);
                    }

                    public final void onFailure(gsf gsf, Exception exc, okhttp3.Response response) {
                        fws.O000000o(absolutePath);
                        foe.f16738O000000o.remove(str);
                        foe.O000000o(o00000Oo, -1, null);
                    }

                    public final void onProgress(long j, long j2) {
                        float f = j2 > 0 ? ((float) j) / ((float) j2) : 0.0f;
                        if (f < 0.0f) {
                            f = 0.0f;
                        } else if (1.0f < f) {
                            f = 1.0f;
                        }
                        foe.O000000o(o00000Oo, (int) (f * 100.0f));
                    }
                }), o00000Oo));
            } catch (Throwable th) {
                o00000Oo.onResponse(-1, null);
                gnk.O00000Oo(gnk.O00000Oo(th));
            }
        }
    }

    private static File O00000o0(String str) {
        String O00000Oo2 = O00000Oo();
        if (!TextUtils.isEmpty(O00000Oo2)) {
            File file = new File(O00000Oo2);
            if (!file.exists() && !file.mkdirs()) {
                throw new IllegalStateException("downloadDir not exist or mkdirs failed");
            } else if (!file.isFile() || (file.delete() && file.mkdirs())) {
                String str2 = O00000Oo2 + File.separator + O00000o(str);
                fws.O000000o(str2);
                File O00000o0 = fws.O00000o0(str2);
                if (O00000o0 != null) {
                    return O00000o0;
                }
                fws.O000000o(str2);
                throw new IllegalStateException("create download file failed");
            } else {
                throw new IllegalStateException("downloadDir is file, delete failed or mkdirs failed");
            }
        } else {
            throw new IllegalStateException("downloadDir null");
        }
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return "";
        }
        return grv.O000000o(file);
    }

    private static String O00000Oo() {
        String str;
        if ("mounted".equals(Environment.getExternalStorageState()) || !goa.O000000o()) {
            str = goa.O000000o(CommonApplication.getAppContext()).getPath();
        } else {
            str = CommonApplication.getAppContext().getCacheDir().getPath() + File.separator + "app";
        }
        return new File(str, "ble").getAbsolutePath();
    }

    private static String O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return grv.O000000o(str);
        }
        String path = URI.create(str).getPath();
        int lastIndexOf = path.lastIndexOf("/");
        return lastIndexOf >= 0 ? path.substring(lastIndexOf + 1) : path;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        gsn f16744O000000o;
        O00000Oo O00000Oo;

        O000000o(gsn gsn, O00000Oo o00000Oo) {
            this.f16744O000000o = gsn;
            this.O00000Oo = o00000Oo;
        }
    }
}
