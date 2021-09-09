package com.miui.tsmclient.entity;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.net.request.d;
import com.miui.tsmclient.util.IOUtils;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.PrefUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Pattern;

public class e extends CommonResponseInfo {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private a f3863a;

    public static class a {
        @SerializedName("swipeCardConfig")

        /* renamed from: a  reason: collision with root package name */
        private List<Object> f3864a;
        @SerializedName("activatedAidConfig")
        private List<String> b;

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
        public static a a(Context context) {
            String str;
            e eVar;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = new CardInfo("DUMMY").getTerminal().getCPLC();
            } catch (IOException e) {
                LogUtils.e("failed to fetch nfc configs from server", e);
                str = "";
                if (TextUtils.isEmpty(str)) {
                }
            } catch (InterruptedException unused) {
                LogUtils.d("failed to fetch nfc configs from server for operation has been interrupted");
                str = "";
                if (TextUtils.isEmpty(str)) {
                }
            }
            if (TextUtils.isEmpty(str)) {
                LogUtils.d("failed to fetch nfc configs from server, cplc is empty");
                return null;
            }
            try {
                eVar = (e) HttpClient.getInstance(context).execute(new d(str)).getResult();
            } catch (IOException e2) {
                LogUtils.e("fetchNfcConfigFromServer Exception occurred", e2);
                eVar = null;
            }
            LogUtils.v("fetchNfcConfigFromServer time = " + (System.currentTimeMillis() - currentTimeMillis));
            if (eVar == null) {
                return null;
            }
            a a2 = eVar.a();
            PrefUtils.putLong(context, "key_fetch_swipe_card_config_time", System.currentTimeMillis());
            PrefUtils.putString(context, "pref_key_swipe_card_config", a2.a());
            a2.c(context);
            return a2;
        }

        public static a b(Context context) {
            FileInputStream fileInputStream;
            String str;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = context.openFileInput("nfc_configs");
                try {
                    IOUtils.copy(fileInputStream, byteArrayOutputStream);
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    LogUtils.d("string from nfc config file: ".concat(str2));
                    a aVar = (a) new Gson().fromJson(str2, a.class);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    return aVar;
                } catch (FileNotFoundException unused) {
                    str = "failed to open file: nfc_configs";
                    try {
                        LogUtils.w(str);
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((InputStream) fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                        IOUtils.closeQuietly((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (IOException unused2) {
                    str = "failed to write file: nfc_configs";
                    LogUtils.w(str);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    return null;
                }
            } catch (FileNotFoundException unused3) {
                fileInputStream = null;
                str = "failed to open file: nfc_configs";
                LogUtils.w(str);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return null;
            } catch (IOException unused4) {
                fileInputStream = null;
                str = "failed to write file: nfc_configs";
                LogUtils.w(str);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
        }

        private void c(Context context) {
            String aVar = toString();
            if (!TextUtils.isEmpty(aVar)) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = context.openFileOutput("nfc_configs", 0);
                    fileOutputStream.write(aVar.getBytes());
                } catch (FileNotFoundException unused) {
                    LogUtils.w("failed to open file: nfc_configs");
                } catch (IOException unused2) {
                    LogUtils.w("failed to write file: nfc_configs");
                } finally {
                    IOUtils.closeQuietly((OutputStream) fileOutputStream);
                }
            }
        }

        public String a() {
            if (this.f3864a != null) {
                return new Gson().toJson(this.f3864a);
            }
            return null;
        }

        public boolean a(String str) {
            if (this.b != null && !TextUtils.isEmpty(str)) {
                for (String compile : this.b) {
                    if (Pattern.compile(compile).matcher(str).matches()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public a a() {
        return this.f3863a;
    }
}
