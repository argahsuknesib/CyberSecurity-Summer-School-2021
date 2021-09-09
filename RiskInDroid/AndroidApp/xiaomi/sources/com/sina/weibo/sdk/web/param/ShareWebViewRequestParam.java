package com.sina.weibo.sdk.web.param;

import _m_j.dbq;
import _m_j.dbt;
import _m_j.dby;
import _m_j.dca;
import _m_j.dci;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.network.IRequestService;
import com.sina.weibo.sdk.network.impl.RequestParam;
import com.sina.weibo.sdk.network.impl.RequestService;
import com.sina.weibo.sdk.network.target.SimpleTarget;
import com.sina.weibo.sdk.web.WebRequestType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ShareWebViewRequestParam extends dci {
    public String O00000o;
    public WeiboMultiMessage O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    private String O0000OOo;
    private byte[] O0000Oo0;

    public ShareWebViewRequestParam() {
    }

    public ShareWebViewRequestParam(Context context) {
        this.O00000Oo = context;
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, Context context) {
        super(authInfo, webRequestType, str, 1, str2, null, context);
    }

    public final boolean O000000o() {
        byte[] bArr = this.O0000Oo0;
        if (bArr == null || bArr.length <= 0) {
            return super.O000000o();
        }
        return true;
    }

    public final void O000000o(final dci.O000000o o000000o) {
        super.O000000o(o000000o);
        dbt.O00000Oo("Share", "ShareWebViewRequestParam.doExtraTask()");
        new WeiboParameters(this.f14467O000000o.authInfo.getAppKey());
        String str = new String(this.O0000Oo0);
        IRequestService instance = RequestService.getInstance();
        RequestParam.Builder builder = new RequestParam.Builder(this.O00000Oo);
        builder.setShortUrl("https://service.weibo.com/share/mobilesdk_uppic.php");
        builder.addPostParam("img", str);
        builder.addPostParam("appKey", this.f14467O000000o.authInfo.getAppKey());
        instance.asyncRequest(builder.build(), new SimpleTarget() {
            /* class com.sina.weibo.sdk.web.param.ShareWebViewRequestParam.AnonymousClass1 */

            public final void onSuccess(String str) {
                dbt.O00000Oo("Share", "ShareWebViewRequestParam.doExtraTask().onSuccess()");
                dca O000000o2 = dca.O000000o(str);
                if (O000000o2 == null || O000000o2.f14464O000000o != 1 || TextUtils.isEmpty(O000000o2.O00000Oo)) {
                    dci.O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O00000Oo();
                        return;
                    }
                    return;
                }
                ShareWebViewRequestParam.this.O00000o = O000000o2.O00000Oo;
                dci.O000000o o000000o2 = o000000o;
                if (o000000o2 != null) {
                    o000000o2.O000000o();
                }
            }

            public final void onFailure(Exception exc) {
                dbt.O00000Oo("Share", "ShareWebViewRequestParam.doExtraTask().onFailure(),e =" + exc.getMessage());
                dci.O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O00000Oo();
                }
            }
        });
    }

    public final void O000000o(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.O00000o0;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.toBundle(bundle);
        }
        bundle.putString("token", this.O00000oO);
        bundle.putString("packageName", this.O00000oo);
        bundle.putString("hashKey", this.O0000O0o);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:33|34|(2:36|37)|38|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00c4 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1 A[SYNTHETIC, Splitter:B:36:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7 A[SYNTHETIC, Splitter:B:42:0x00c7] */
    public final void O00000Oo(Bundle bundle) {
        FileInputStream fileInputStream;
        this.O00000o0 = new WeiboMultiMessage();
        this.O00000o0.toObject(bundle);
        this.O00000oO = bundle.getString("token");
        this.O00000oo = bundle.getString("packageName");
        this.O0000O0o = bundle.getString("hashKey");
        StringBuilder sb = new StringBuilder();
        if (this.O00000o0.textObject instanceof TextObject) {
            TextObject textObject = this.O00000o0.textObject;
            sb.append(textObject.text + " ");
        }
        if (this.O00000o0.mediaObject != null && (this.O00000o0.mediaObject instanceof WebpageObject) && !TextUtils.isEmpty(this.O00000o0.mediaObject.actionUrl)) {
            sb.append(this.O00000o0.mediaObject.actionUrl);
        }
        if (this.O00000o0.imageObject instanceof ImageObject) {
            ImageObject imageObject = this.O00000o0.imageObject;
            String str = imageObject.imagePath;
            byte[] bArr = imageObject.imageData;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[((int) file.length())];
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException unused) {
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (SecurityException unused2) {
                            }
                        }
                        this.O0000Oo0 = dbq.O000000o(bArr);
                        this.O0000OOo = sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    try {
                        fileInputStream.read(bArr2);
                        this.O0000Oo0 = dbq.O000000o(bArr2);
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    } catch (IOException unused4) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                        }
                        this.O0000Oo0 = dbq.O000000o(bArr);
                        this.O0000OOo = sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                }
            }
            if (bArr != null && bArr.length > 0) {
                this.O0000Oo0 = dbq.O000000o(bArr);
            }
        }
        this.O0000OOo = sb.toString();
    }

    public final String O00000Oo() {
        String appKey = this.f14467O000000o.authInfo.getAppKey();
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.O0000OOo);
        buildUpon.appendQueryParameter("version", "0041005000");
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.O00000oO)) {
            buildUpon.appendQueryParameter("access_token", this.O00000oO);
        }
        if (this.O00000Oo != null) {
            String O00000Oo = dby.O00000Oo(this.O00000Oo, appKey);
            if (!TextUtils.isEmpty(O00000Oo)) {
                buildUpon.appendQueryParameter("aid", O00000Oo);
            }
        }
        if (!TextUtils.isEmpty(this.O00000oo)) {
            buildUpon.appendQueryParameter("packagename", this.O00000oo);
        }
        if (!TextUtils.isEmpty(this.O0000O0o)) {
            buildUpon.appendQueryParameter("key_hash", this.O0000O0o);
        }
        if (!TextUtils.isEmpty(this.O00000o)) {
            buildUpon.appendQueryParameter("picinfo", this.O00000o);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_".concat(String.valueOf(appKey)));
        return buildUpon.build().toString();
    }
}
