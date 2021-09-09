package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mico.tool.embedded.activity.CommonWebActivity;

public class WebSchemaHandler extends MicoSchemaHandler {
    /* access modifiers changed from: protected */
    public String authority() {
        return "web";
    }

    public /* bridge */ /* synthetic */ boolean canHandle(Uri uri) {
        return super.canHandle(uri);
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    /* access modifiers changed from: protected */
    public void doProcess(Context context, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (!TextUtils.isEmpty(queryParameter)) {
            boolean z = false;
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("fullscreen", false);
            boolean booleanQueryParameter2 = uri.getBooleanQueryParameter("darkmode", false);
            String path = uri.getPath();
            char c = 65535;
            if (path.hashCode() == 809067071 && path.equals("/campaign")) {
                c = 0;
            }
            if (c == 0) {
                z = true;
            }
            Intent intent = new Intent(context, CommonWebActivity.class);
            intent.putExtra("common_web_url", decodeParam(queryParameter));
            intent.putExtra("fullscreen", booleanQueryParameter);
            intent.putExtra("darkmode", booleanQueryParameter2);
            intent.putExtra("auth", z);
            context.startActivity(intent);
        }
    }
}
