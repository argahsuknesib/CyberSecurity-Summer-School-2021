package _m_j;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class hle {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<String, O000000o> f19032O000000o;

    interface O000000o {
        boolean handle(Uri uri, Map<String, String> map);
    }

    static {
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0();
        f19032O000000o = o0o0ooo0;
        o0o0ooo0.put("webPage", $$Lambda$hle$nn_eovC2vkZ7CVKtnCvwTkLsMK0.INSTANCE);
        f19032O000000o.put("cloudvideodownloadlist", $$Lambda$hle$46dJuHnLnKjTlA5DmUlpv9L_NmI.INSTANCE);
        f19032O000000o.put("device", $$Lambda$hle$FVdxodn_0mrd2K0WqVdEwXWh1Jw.INSTANCE);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O00000o0(Uri uri, Map map) {
        String str = (String) map.get("url");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(CommonApplication.getAppContext(), OperationCommonWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", (String) map.get("title"));
        intent.putExtra("args_from_deep_link", true);
        intent.setFlags(268435456);
        CommonApplication.getAppContext().startActivity(intent);
        return true;
    }

    public static O000000o O000000o(String str) {
        return f19032O000000o.get(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(Uri uri, Map map) {
        if (!CoreApi.O000000o().O0000Ooo()) {
            gsy.O000000o(3, "JumperProvider", "process: no login,ignore.");
            return false;
        } else if (!TextUtils.equals("/goout", uri.getPath())) {
            return false;
        } else {
            String str = (String) map.get("rectemplateid");
            String str2 = (String) map.get("iconurl");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("rectemplateid", str);
                jSONObject.put("iconurl", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            hor.O000000o().openRecommendSceneDetail(CommonApplication.getAppContext(), jSONObject);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O00000Oo(Uri uri, Map map) {
        if (!CoreApi.O000000o().O0000Ooo()) {
            gsy.O000000o(3, "JumperProvider", "process: no login,ignore.");
            return false;
        }
        String str = (String) map.get("did");
        if (TextUtils.isEmpty(str)) {
            gsy.O000000o(6, "JumperProvider", "process: invalid params,empty did.");
            return false;
        }
        String userId = WebViewRouterFactory.getWebViewHelpManager().getUserId(str);
        if (TextUtils.isEmpty(userId)) {
            gsy.O000000o(6, "JumperProvider", "process: invalid params,no device found with did: ".concat(String.valueOf(str)));
            return false;
        }
        fbs.O000000o(new fbt(CommonApplication.getAppContext(), "CloudVideoDownloadActivity").O000000o("did", str).O000000o("uid", userId).O00000Oo(268435456));
        return true;
    }
}
