package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import com.xiaomi.mico.common.util.ToastUtil;

public class ShareSchemaHandler extends MicoSchemaHandler {
    /* access modifiers changed from: protected */
    public String authority() {
        return "share";
    }

    public /* bridge */ /* synthetic */ boolean canHandle(Uri uri) {
        return super.canHandle(uri);
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    /* access modifiers changed from: protected */
    public void doProcess(Context context, Uri uri) {
        ToastUtil.showToast("TODO ShareSchemaHandler");
    }
}
