package com.xiaomi.mico.common.schema.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.mico.tool.embedded.activity.SkillDetailActivity;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.List;

public class SkillSchemaHandler extends TabSchemaHandler {
    private static final List<String> SUPPORT_PATHS = Arrays.asList("/alert", "/web", "/voip", "/ai", "/alarm", "/timer", "/chatlog", "/voicememo", "/category", "/skill", "/evernote", "/tts", "/chatlog_feedback", "/rss", "/tencent", "/express", "/oauth", "/dedao", "/didi", "/stock", "/skill_web", "/skill_web_full", "/growth");

    /* access modifiers changed from: protected */
    public String authority() {
        return "services";
    }

    /* access modifiers changed from: protected */
    public String tabKey() {
        return "services";
    }

    public /* bridge */ /* synthetic */ Object getExtras() {
        return super.getExtras();
    }

    public static String buildWebSchema(String str, String str2, boolean z) {
        return new Uri.Builder().scheme("mico").authority("services").appendPath("web").appendQueryParameter("title", str).appendQueryParameter("url", encodeParam(str2)).appendQueryParameter("fullscreen", String.valueOf(z)).build().toString();
    }

    public static String buildWebSchema(String str, String str2, boolean z, boolean z2) {
        return new Uri.Builder().scheme("mico").authority("services").appendPath("web").appendQueryParameter("title", str).appendQueryParameter("url", str2).appendQueryParameter("fullscreen", String.valueOf(z)).appendQueryParameter("need_device_id", String.valueOf(z2)).build().toString();
    }

    /* access modifiers changed from: protected */
    public List<String> supportPaths() {
        return SUPPORT_PATHS;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r9.equals("/oauth") != false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    public void doProcess(Context context, String str, Uri uri) {
        String queryParameter;
        String queryParameter2 = uri.getQueryParameter("skillId");
        char c = 0;
        if (TextUtils.isEmpty(queryParameter2)) {
            Toast.makeText(context, (int) R.string.common_not_support, 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("skill_id", queryParameter2);
        int hashCode = str.hashCode();
        if (hashCode != 1451086792) {
            if (hashCode == 1455067010 && str.equals("/skill")) {
                c = 1;
                if (c != 0 || c == 1) {
                    intent.setClass(context, SkillDetailActivity.class);
                    queryParameter = uri.getQueryParameter("providerID");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        intent.putExtra("auth_provider", queryParameter);
                    }
                    "0ad81092-de3c-43f5-8b69-bce64d26caea".equals(queryParameter2);
                    context.startActivity(intent);
                }
                return;
            }
        }
        c = 65535;
        if (c != 0) {
        }
        intent.setClass(context, SkillDetailActivity.class);
        queryParameter = uri.getQueryParameter("providerID");
        if (!TextUtils.isEmpty(queryParameter)) {
        }
        "0ad81092-de3c-43f5-8b69-bce64d26caea".equals(queryParameter2);
        context.startActivity(intent);
    }

    private void goGrowth(Context context, Uri uri, String str) {
        uri.getQueryParameter("url");
        uri.getQueryParameter("title");
        uri.getBooleanQueryParameter("fullscreen", false);
        uri.getBooleanQueryParameter("darkmode", false);
    }
}
