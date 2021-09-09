package com.xiaomi.smarthome.frame.plugin.debug;

import _m_j.gfr;
import _m_j.gor;
import _m_j.gpc;
import _m_j.hyy;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.plugin.runtime.crash.PluginCrashHandler;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PluginErrorInfoActivity extends FragmentActivity {
    public static void showErrorInfo(Context context, XmPluginPackage xmPluginPackage, Throwable th) {
        final long j;
        final long j2;
        Log.e("PluginErrorInfoActivity", "showErrorInfo", th);
        if (gfr.O0000OOo || gfr.O0000Oo) {
            Intent intent = new Intent(context, PluginErrorInfoActivity.class);
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            intent.putExtra("info", stringWriter.toString());
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        if (xmPluginPackage != null) {
            long pluginId = xmPluginPackage.getPluginId();
            j = xmPluginPackage.getPackageId();
            j2 = pluginId;
        } else {
            j2 = 0;
            j = 0;
        }
        final Throwable th2 = th;
        gor.O000000o(new AsyncTask<Object, Object, Object>() {
            /* class com.xiaomi.smarthome.frame.plugin.debug.PluginErrorInfoActivity.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final Object doInBackground(Object... objArr) {
                try {
                    PluginCrashHandler.handlePluginException(th2, j2, j);
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }, new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        gpc.O00000o(this);
        super.onCreate(bundle);
        hyy.O000000o(this);
        setContentView((int) R.layout.plugin_error_info_activity);
        ((TextView) findViewById(R.id.info)).setText(getIntent().getStringExtra("info"));
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hyy.O000000o(this, configuration);
    }
}
