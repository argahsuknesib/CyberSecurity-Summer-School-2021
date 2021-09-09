package com.xiaomi.mico.common.schema;

import android.content.Context;
import android.net.Uri;

public interface SchemaHandler {
    boolean canHandle(Uri uri);

    boolean needLogin();

    void process(Context context, Uri uri, Object obj);
}
