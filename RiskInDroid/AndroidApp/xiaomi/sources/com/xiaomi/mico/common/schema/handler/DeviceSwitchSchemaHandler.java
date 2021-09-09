package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mico.application.MicoManager;
import java.util.Arrays;
import java.util.List;

public class DeviceSwitchSchemaHandler extends TabSchemaHandler {
    private static final List<String> SUPPORT_PATHS = Arrays.asList(new String[0]);

    /* access modifiers changed from: protected */
    public String authority() {
        return "switch";
    }

    /* access modifiers changed from: protected */
    public String tabKey() {
        return "homepage";
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    /* access modifiers changed from: protected */
    public List<String> supportPaths() {
        return SUPPORT_PATHS;
    }

    /* access modifiers changed from: protected */
    public void doProcess(Context context, String str, Uri uri) {
        String queryParameter = uri.getQueryParameter("deviceId");
        String queryParameter2 = uri.getQueryParameter("miotDID");
        if (!TextUtils.isEmpty(queryParameter)) {
            MicoManager.getInstance().selectMicoById(queryParameter);
        } else if (!TextUtils.isEmpty(queryParameter2)) {
            MicoManager.getInstance().selectMicoByMiotDID(queryParameter2);
        }
    }
}
