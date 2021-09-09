package com.xiaomi.mico.common.schema.handler;

import _m_j.ahg;
import _m_j.ahh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mico.common.util.ToastUtil;

public class OAuthSchemaHandler extends MicoSchemaHandler {
    private ahg loggerNew = new ahg();

    /* access modifiers changed from: protected */
    public String authority() {
        return "oauth";
    }

    public OAuthSchemaHandler() {
        new ahh();
    }

    public /* bridge */ /* synthetic */ boolean canHandle(Uri uri) {
        return super.canHandle(uri);
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    /* access modifiers changed from: protected */
    public void doProcess(Context context, Uri uri) {
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            String queryParameter = uri.getQueryParameter("status");
            String queryParameter2 = uri.getQueryParameter("followed");
            if ("success".equals(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
                ToastUtil.showToast("TODO OAuthSchemaHandler");
            }
            path.hashCode();
            ahg.O00000o0(uri.toString());
            Intent intent = new Intent();
            intent.setData(uri);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
