package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public final class d extends AsyncTask<Void, Void, a> {
    /* access modifiers changed from: private */
    public static final boolean ai = (Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite());
    /* access modifiers changed from: private */
    public static final String aj = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png");
    private static String ak;
    private String al;
    private String am;
    private OAuthListener an;
    private f ao;
    private String appId;
    private String scope;
    private String signature;

    static class a {
        public OAuthErrCode ap;
        public String aq;
        public String ar;
        public String as;
        public int at;
        public String au;
        public byte[] av;

        private a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[SYNTHETIC, Splitter:B:20:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x003c A[SYNTHETIC, Splitter:B:25:0x003c] */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        private static boolean a(String str, byte[] bArr) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.d("MicroMsg.SDK.GetQRCodeResult", "writeToFile ok!");
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        Log.w("MicroMsg.SDK.GetQRCodeResult", "write to file error");
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                Log.w("MicroMsg.SDK.GetQRCodeResult", "write to file error");
                if (fileOutputStream != null) {
                }
            }
        }

        public static a d(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i)));
                            aVar.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.at = i;
                            aVar.au = jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null) {
                            if (string.length() != 0) {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode != null) {
                                    if (decode.length != 0) {
                                        if (d.ai) {
                                            File file = new File(d.aj);
                                            file.mkdirs();
                                            if (file.exists()) {
                                                file.delete();
                                            }
                                            if (!a(d.aj, decode)) {
                                                Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("writeToFile fail, qrcodeBuf length = %d", Integer.valueOf(decode.length)));
                                                aVar.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
                                                return aVar;
                                            }
                                            aVar.ap = OAuthErrCode.WechatAuth_Err_OK;
                                            aVar.as = d.aj;
                                            aVar.aq = jSONObject.getString("uuid");
                                            aVar.ar = jSONObject.getString("appname");
                                            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in external storage, uuid = %s, appname = %s, imgPath = %s", aVar.aq, aVar.ar, aVar.as));
                                            return aVar;
                                        }
                                        aVar.ap = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.av = decode;
                                        aVar.aq = jSONObject.getString("uuid");
                                        aVar.ar = jSONObject.getString("appname");
                                        Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.aq, aVar.ar, Integer.valueOf(aVar.av.length)));
                                        return aVar;
                                    }
                                }
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                aVar.ap = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                return aVar;
                            }
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.ap = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e) {
                        format = String.format("parse json fail, ex = %s", e.getMessage());
                        Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.ap = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.ap = oAuthErrCode;
                    return aVar;
                }
            }
            aVar.ap = oAuthErrCode;
            return aVar;
        }
    }

    static {
        ak = null;
        ak = "http://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.al = str3;
        this.am = str4;
        this.signature = str5;
        this.an = oAuthListener;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "external storage available = " + ai);
        String format = String.format(ak, this.appId, this.al, this.am, this.scope, this.signature);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] b = e.b(format, -1);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.d(b);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        if (aVar.ap == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
            this.an.onAuthGotQrcode(aVar.as, aVar.av);
            this.ao = new f(aVar.aq, this.an);
            f fVar = this.ao;
            if (Build.VERSION.SDK_INT >= 11) {
                fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                fVar.execute(new Void[0]);
            }
        } else {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", aVar.ap));
            this.an.onAuthFinish(aVar.ap, null);
        }
    }

    public final boolean q() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        f fVar = this.ao;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }
}
