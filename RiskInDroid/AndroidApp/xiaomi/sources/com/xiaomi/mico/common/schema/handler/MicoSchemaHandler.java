package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.schema.SchemaHandler;
import com.xiaomi.mico.common.util.CommonUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;

abstract class MicoSchemaHandler implements SchemaHandler {
    private Object mExtras;

    /* access modifiers changed from: protected */
    public abstract String authority();

    /* access modifiers changed from: protected */
    public abstract void doProcess(Context context, Uri uri);

    public final boolean needLogin() {
        return true;
    }

    MicoSchemaHandler() {
    }

    public boolean canHandle(Uri uri) {
        if (!"mico".equals(uri.getScheme()) || !authority().equals(uri.getAuthority())) {
            return "micoSdk".equals(uri.getScheme()) && authority().equals(uri.getAuthority());
        }
        return true;
    }

    public final void process(Context context, Uri uri, Object obj) {
        if (!MicoManager.getInstance().hasValidMico()) {
            CommonUtils.restartAppTask(context);
            return;
        }
        this.mExtras = obj;
        doProcess(context, uri);
    }

    public Object getExtras() {
        return this.mExtras;
    }

    static String decodeParam(String str) {
        return !TextUtils.isEmpty(str) ? URLDecoder.decode(str) : "";
    }

    static String encodeParam(String str) {
        return !TextUtils.isEmpty(str) ? URLEncoder.encode(str) : "";
    }
}
