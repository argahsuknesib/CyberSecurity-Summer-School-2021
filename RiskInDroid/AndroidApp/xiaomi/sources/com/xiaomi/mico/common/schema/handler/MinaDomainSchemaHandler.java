package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.net.Uri;
import com.xiaomi.mico.common.schema.SchemaHandler;

public class MinaDomainSchemaHandler implements SchemaHandler {
    public boolean needLogin() {
        return false;
    }

    public boolean canHandle(Uri uri) {
        return "mina.mi.com".equals(uri.getHost());
    }

    public void process(Context context, Uri uri, Object obj) {
        String path = uri.getPath();
        if (((path.hashCode() == 3616 && path.equals("qq")) ? (char) 0 : 65535) == 0) {
            new Object[1][0] = uri.toString();
        }
    }
}
