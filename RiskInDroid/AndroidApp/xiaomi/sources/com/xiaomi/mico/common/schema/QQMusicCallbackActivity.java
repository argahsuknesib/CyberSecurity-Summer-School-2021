package com.xiaomi.mico.common.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.mico.base.MicoBaseActivity;

public class QQMusicCallbackActivity extends MicoBaseActivity {
    private boolean isQQMusicAuthCallback(Uri uri) {
        return uri != null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new View(this));
        processIntent(getIntent());
    }

    private void processIntent(Intent intent) {
        if (!(intent == null || intent.getData() == null)) {
            Uri data = intent.getData();
            new Object[1][0] = "schema uri=" + data.toString();
            Context applicationContext = getApplicationContext();
            if (applicationContext != null) {
                SchemaManager.doOnlyHomepageHandleSchema(applicationContext, data.toString());
            }
        }
        finish();
    }
}
