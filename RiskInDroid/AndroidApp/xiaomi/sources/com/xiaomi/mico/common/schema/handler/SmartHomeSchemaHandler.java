package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import com.xiaomi.mico.common.util.ToastUtil;
import java.util.Arrays;
import java.util.List;

public class SmartHomeSchemaHandler extends TabSchemaHandler {
    private static final List<String> SUPPORT_PATHS = Arrays.asList("/mitv", "/ir_category");

    /* access modifiers changed from: protected */
    public String authority() {
        return "smarthome";
    }

    /* access modifiers changed from: protected */
    public String tabKey() {
        return "smarthome";
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
        ToastUtil.showToast("TODO SmartHomeSchemaHandler");
    }
}
