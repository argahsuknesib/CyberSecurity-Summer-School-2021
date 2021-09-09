package com.xiaomi.mico.common.schema.handler;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.common.schema.SchemaHandler;

public class NonMicoSchemaHandler implements SchemaHandler {
    public boolean needLogin() {
        return true;
    }

    public boolean canHandle(Uri uri) {
        return !"mico".equals(uri.getScheme()) && !"micoSdk".equals(uri.getScheme());
    }

    public void process(Context context, Uri uri, Object obj) {
        String scheme = uri.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            MicoApplication.getInstance().getMicoHelperListener().jumpSmartHome(uri.toString(), "");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
