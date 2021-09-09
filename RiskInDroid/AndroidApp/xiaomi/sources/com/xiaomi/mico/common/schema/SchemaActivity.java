package com.xiaomi.mico.common.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.utils.Threads;

public class SchemaActivity extends MicoBaseActivity {
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
                SchemaManager.handleSchema(applicationContext, data.toString());
            }
        }
        finish();
        Threads.getHeavyWorkHandler().post(new Runnable(intent) {
            /* class com.xiaomi.mico.common.schema.$$Lambda$SchemaActivity$NNcJOIYsU4rAPmSFs552aQ1FZ0 */
            private final /* synthetic */ Intent f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SchemaActivity.this.lambda$processIntent$0$SchemaActivity(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$processIntent$0$SchemaActivity(Intent intent) {
        if (customOperations(intent)) {
            Threads.postInMainThread(new Runnable() {
                /* class com.xiaomi.mico.common.schema.$$Lambda$c7MQGT9wyFHfNunB3qucpCvFqo */

                public final void run() {
                    SchemaActivity.this.finish();
                }
            });
        }
    }

    private boolean customOperations(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return true;
        }
        "com.xiaomi.mico.WRITE_MICO_SERVICE_TOKEN_TO_FILE".equals(action);
        return true;
    }
}
