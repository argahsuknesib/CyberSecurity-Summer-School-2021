package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mico.common.util.ContainerUtil;
import java.util.List;

abstract class TabSchemaHandler extends MicoSchemaHandler {
    private static void switchTab(Context context, String str) {
    }

    /* access modifiers changed from: package-private */
    public abstract void doProcess(Context context, String str, Uri uri);

    /* access modifiers changed from: protected */
    public abstract List<String> supportPaths();

    /* access modifiers changed from: protected */
    public abstract String tabKey();

    TabSchemaHandler() {
    }

    public final boolean canHandle(Uri uri) {
        String stripPath = stripPath(uri.getPath());
        List<String> supportPaths = supportPaths();
        if (!super.canHandle(uri)) {
            return false;
        }
        if (!TextUtils.isEmpty(stripPath)) {
            return ContainerUtil.hasData(supportPaths) && supportPaths.contains(stripPath);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void doProcess(Context context, Uri uri) {
        String stripPath = stripPath(uri.getPath());
        if (TextUtils.isEmpty(stripPath)) {
            switchTab(context, tabKey());
        } else {
            doProcess(context, stripPath, uri);
        }
    }

    private static String stripPath(String str) {
        return (TextUtils.isEmpty(str) || !str.endsWith("/")) ? str : str.substring(0, str.length() - 1);
    }
}
