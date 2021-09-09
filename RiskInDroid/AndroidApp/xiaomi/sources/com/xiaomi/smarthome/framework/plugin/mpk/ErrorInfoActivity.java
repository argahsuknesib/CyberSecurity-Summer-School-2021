package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.gfr;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.crash.PluginCrashHandler;
import com.xiaomi.smarthome.framework.page.BaseWhiteActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorInfoActivity extends BaseWhiteActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.error_info_activity);
        ((TextView) findViewById(R.id.info)).setText(getIntent().getStringExtra("info"));
    }

    public static void showErrorInfo(Context context, XmPluginPackage xmPluginPackage, Throwable th) {
        long j;
        if (gfr.O0000Oo || gfr.O0000OOo) {
            gsy.O00000o0(LogType.GENERAL, "", th.getMessage());
            Intent intent = new Intent(context, ErrorInfoActivity.class);
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            intent.putExtra("info", stringWriter.toString());
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        long j2 = 0;
        if (xmPluginPackage != null) {
            j2 = xmPluginPackage.getPluginId();
            j = xmPluginPackage.getPackageId();
        } else {
            j = 0;
        }
        PluginCrashHandler.O000000o(th, j2, j);
    }
}
