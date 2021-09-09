package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class clg {

    /* renamed from: O000000o  reason: collision with root package name */
    dty f14057O000000o;
    public boolean O00000Oo;
    public ArrayList<O000000o> O00000o = new ArrayList<>();
    public O00000Oo O00000o0;
    private O000000o O00000oO;
    private ArrayList<O000000o> O00000oo = new ArrayList<>();
    private Handler O0000O0o = new Handler(Looper.getMainLooper());

    public interface O00000Oo {
        void onDownloadFailed(O000000o o000000o, String str, int i, String str2);

        void onDownloadSuccess(O000000o o000000o, String str);

        void onDownloading(O000000o o000000o, String str, int i);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public clb f14062O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public int O00000oO = 1;

        public O000000o(clb clb) {
            this.f14062O000000o = clb;
        }
    }

    public clg(dty dty) {
        this.f14057O000000o = dty;
    }

    public final void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo == null) {
            this.O00000o0 = null;
        } else {
            this.O00000o0 = o00000Oo;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return;
     */
    public final synchronized void O000000o(clb clb) {
        if (clb != null) {
            if (!TextUtils.isEmpty(clb.O00000oo)) {
                this.O00000o.add(new O000000o(clb));
                O000000o();
            }
        }
    }

    private synchronized void O000000o() {
        if (this.O00000o.size() != 0) {
            this.O0000O0o.post(new Runnable() {
                /* class _m_j.clg.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.clw.O000000o(long, boolean):java.lang.String
                 arg types: [long, int]
                 candidates:
                  _m_j.clw.O000000o(java.lang.String, boolean):long
                  _m_j.clw.O000000o(long, boolean):java.lang.String */
                public final void run() {
                    if (clg.this.O00000o.size() != 0 && !clg.this.O00000Oo) {
                        O000000o remove = clg.this.O00000o.remove(0);
                        clg clg = clg.this;
                        clb clb = remove.f14062O000000o;
                        String O00000o0 = me.O00000o0(clg.f14057O000000o.getDid());
                        if (!TextUtils.isEmpty(O00000o0)) {
                            File file = new File(O00000o0);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            O00000o0 = O00000o0 + File.separator + clw.O000000o().O000000o(clb.O00000Oo, true) + ".mp4";
                        }
                        if (TextUtils.isEmpty(O00000o0)) {
                            clg.O000000o(remove, "", -2, "");
                        } else if (new File(O00000o0).exists()) {
                            clg.O00000Oo(remove, O00000o0);
                        } else {
                            clg.O000000o(remove, O00000o0);
                            String str = remove.f14062O000000o.O00000oo;
                            AnonymousClass2 r8 = new Callback<String>(remove, O00000o0) {
                                /* class _m_j.clg.AnonymousClass2 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ O000000o f14059O000000o;
                                final /* synthetic */ String O00000Oo;

                                {
                                    this.f14059O000000o = r2;
                                    this.O00000Oo = r3;
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    final String str = (String) obj;
                                    new Thread() {
                                        /* class _m_j.clg.AnonymousClass2.AnonymousClass1 */

                                        /* JADX WARN: Type inference failed for: r0v10, types: [java.net.URLConnection] */
                                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                         method: ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
                                         arg types: [java.lang.String, int]
                                         candidates:
                                          ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
                                          ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException} */
                                        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00dc, code lost:
                                            if (r4.O00000Oo <= 0) goto L_0x00e6;
                                         */
                                        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00de, code lost:
                                            r9 = (r4.O00000o0 * 100) / r4.O00000Oo;
                                         */
                                        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e6, code lost:
                                            r9 = 0;
                                         */
                                        /* JADX WARNING: Multi-variable type inference failed */
                                        /* JADX WARNING: Removed duplicated region for block: B:49:0x0193 A[SYNTHETIC, Splitter:B:49:0x0193] */
                                        public final void run() {
                                            HttpURLConnection httpURLConnection;
                                            int i;
                                            clg clg = clg.this;
                                            O000000o o000000o = AnonymousClass2.this.f14059O000000o;
                                            String str = str;
                                            String str2 = AnonymousClass2.this.O00000Oo;
                                            try {
                                                FileOutputStream fileOutputStream = new FileOutputStream(str2 + ".tmp", false);
                                                try {
                                                    URL url = new URL(str);
                                                    if (mf.O000000o(XmPluginHostApi.instance().context())) {
                                                        HttpURLConnection.setFollowRedirects(false);
                                                        String O000000o2 = mf.O000000o(url);
                                                        String host = url.getHost();
                                                        URL url2 = new URL(O000000o2);
                                                        dxx.O000000o();
                                                        httpURLConnection = (HttpURLConnection) dxx.O000000o(url2);
                                                        httpURLConnection.setRequestProperty("X-Online-Host", host);
                                                        int responseCode = httpURLConnection.getResponseCode();
                                                        while (responseCode >= 300 && responseCode < 400) {
                                                            String headerField = httpURLConnection.getHeaderField("location");
                                                            if (TextUtils.isEmpty(headerField)) {
                                                                break;
                                                            }
                                                            URL url3 = new URL(headerField);
                                                            String O000000o3 = mf.O000000o(url3);
                                                            String host2 = url3.getHost();
                                                            URL url4 = new URL(O000000o3);
                                                            dxx.O000000o();
                                                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) dxx.O000000o(url4);
                                                            httpURLConnection2.setRequestProperty("X-Online-Host", host2);
                                                            HttpURLConnection httpURLConnection3 = httpURLConnection2;
                                                            responseCode = httpURLConnection2.getResponseCode();
                                                            httpURLConnection = httpURLConnection3;
                                                        }
                                                    } else {
                                                        dxx.O000000o();
                                                        httpURLConnection = dxx.O000000o(url);
                                                        HttpURLConnection.setFollowRedirects(true);
                                                    }
                                                    httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
                                                    httpURLConnection.setReadTimeout(15000);
                                                    httpURLConnection.connect();
                                                    InputStream inputStream = httpURLConnection.getInputStream();
                                                    o000000o.O00000Oo = httpURLConnection.getContentLength();
                                                    o000000o.O00000o0 = 0;
                                                    byte[] bArr = new byte[1024];
                                                    loop1:
                                                    while (true) {
                                                        int i2 = 0;
                                                        while (true) {
                                                            int read = inputStream.read(bArr);
                                                            if (read <= 0) {
                                                                break loop1;
                                                            }
                                                            fileOutputStream.write(bArr, 0, read);
                                                            o000000o.O00000o0 += read;
                                                            i2 += read;
                                                            if (clg.O00000o0 != null && i2 > 10240) {
                                                                break;
                                                            }
                                                        }
                                                        if (fileOutputStream != null) {
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (IOException e) {
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                        new File(str2 + ".tmp").delete();
                                                        clg.O000000o(o000000o, str2, -1, "");
                                                        o000000o.O00000oO = 2;
                                                        o000000o.O00000o = i;
                                                        clg.O00000o0.onDownloading(o000000o, str2, i);
                                                    }
                                                    inputStream.close();
                                                    fileOutputStream.close();
                                                    fileOutputStream = null;
                                                    File file = new File(str2 + ".tmp");
                                                    File file2 = new File(str2 + ".g711");
                                                    File file3 = new File(str2);
                                                    if (!TextUtils.isEmpty(o000000o.f14062O000000o.O0000O0o)) {
                                                        String str3 = str2 + ".dec";
                                                        ml.O000000o(file.getAbsolutePath(), o000000o.f14062O000000o.O0000O0o, str3);
                                                        file.delete();
                                                        File file4 = new File(str3);
                                                        if (!mk.O000000o(str2, file4, file2) || !file2.exists()) {
                                                            file4.renameTo(file3);
                                                        } else {
                                                            file4.delete();
                                                            file2.renameTo(file3);
                                                        }
                                                    } else if (!mk.O000000o(str2, file, file2) || !file2.exists()) {
                                                        file.renameTo(file3);
                                                    } else {
                                                        file.delete();
                                                        file2.renameTo(file3);
                                                    }
                                                    if (file3.exists()) {
                                                        clg.O00000Oo(o000000o, str2);
                                                        return;
                                                    }
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                new File(str2 + ".tmp").delete();
                                                clg.O000000o(o000000o, str2, -1, "");
                                            } catch (FileNotFoundException unused) {
                                                clg.O000000o(o000000o, str2, -1, "");
                                            }
                                        }
                                    }.start();
                                }

                                public final void onFailure(int i, String str) {
                                    clg.this.O000000o(this.f14059O000000o, this.O00000Oo, i, str);
                                }
                            };
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("obj_name", str);
                            } catch (JSONException unused) {
                                r8.onFailure(-10000, null);
                            }
                            XmPluginHostApi.instance().callSmartHomeApi(clg.f14057O000000o.getModel(), "/home/getfileurl", jSONObject, r8, new Parser<String>() {
                                /* class _m_j.clg.AnonymousClass3 */

                                public final /* synthetic */ Object parse(String str) throws JSONException {
                                    return new JSONObject(str).optString("url");
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o(O000000o o000000o, String str) {
        this.O00000oO = o000000o;
        this.O00000oo.remove(o000000o);
        this.O00000Oo = true;
        o000000o.O00000oO = 2;
        if (this.O00000o0 != null) {
            this.O00000o0.onDownloading(o000000o, str, 0);
        }
    }

    public final synchronized void O000000o(O000000o o000000o, String str, int i, String str2) {
        this.O00000Oo = false;
        this.O00000oO = null;
        o000000o.O00000oO = 3;
        this.O00000oo.add(o000000o);
        if (this.O00000o0 != null) {
            this.O00000o0.onDownloadFailed(o000000o, str, i, str2);
        }
        civ.O00000o("alarm", "down fds fail ".concat(String.valueOf(i)));
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O00000Oo(O000000o o000000o, String str) {
        this.O00000Oo = false;
        this.O00000oO = null;
        o000000o.O00000oO = 4;
        if (this.O00000o0 != null) {
            this.O00000o0.onDownloadSuccess(o000000o, str);
        }
        O000000o();
    }
}
