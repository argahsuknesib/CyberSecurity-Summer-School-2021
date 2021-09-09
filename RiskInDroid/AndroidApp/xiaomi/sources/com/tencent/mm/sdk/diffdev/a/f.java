package com.tencent.mm.sdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import org.json.JSONObject;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener an;
    private String aq;
    private int aw;
    private String url;

    static class a {
        public OAuthErrCode ap;
        public String ax;
        public int ay;

        a() {
        }

        public static a e(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            OAuthErrCode oAuthErrCode2;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        aVar.ay = jSONObject.getInt("wx_errcode");
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(aVar.ay)));
                        int i = aVar.ay;
                        if (i == 408) {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                        } else if (i != 500) {
                            switch (i) {
                                case 402:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                    break;
                                case 403:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    break;
                                case 404:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                    break;
                                case 405:
                                    aVar.ap = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.ax = jSONObject.getString("wx_code");
                                    break;
                                default:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    break;
                            }
                            return aVar;
                        } else {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        aVar.ap = oAuthErrCode2;
                        return aVar;
                    } catch (Exception e) {
                        format = String.format("parse json fail, ex = %s", e.getMessage());
                        Log.e("MicroMsg.SDK.NoopingResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.ap = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    Log.e("MicroMsg.SDK.NoopingResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.ap = oAuthErrCode;
                    return aVar;
                }
            }
            aVar.ap = oAuthErrCode;
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.aq = str;
        this.an = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        String str2 = this.aq;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.url);
                if (this.aw == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.aw;
                }
                sb.append(str);
                String sb2 = sb.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] b = e.b(sb2, 60000);
                long currentTimeMillis2 = System.currentTimeMillis();
                a e = a.e(b);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, e.ap.toString(), Integer.valueOf(e.ay), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                if (e.ap == OAuthErrCode.WechatAuth_Err_OK) {
                    this.aw = e.ay;
                    if (e.ay == g.UUID_SCANED.getCode()) {
                        this.an.onQrcodeScanned();
                    } else if (e.ay != g.UUID_KEEP_CONNECT.getCode() && e.ay == g.UUID_CONFIRM.getCode()) {
                        if (e.ax == null || e.ax.length() == 0) {
                            Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                            e.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        return e;
                    }
                } else {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", e.ap.toString(), Integer.valueOf(e.ay)));
                    return e;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.ap = oAuthErrCode;
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.an.onAuthFinish(aVar.ap, aVar.ax);
    }
}
