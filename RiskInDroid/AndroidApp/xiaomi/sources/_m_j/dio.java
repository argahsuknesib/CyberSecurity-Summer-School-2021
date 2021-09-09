package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.connect.common.AssistActivity;
import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class dio {
    public static String O00000oo = null;
    public static String O0000O0o = null;
    public static String O0000OOo = null;
    public static boolean O0000Oo0 = false;
    protected dim O00000o;
    public dij O00000oO;

    private dio(dij dij) {
        this.O00000o = null;
        this.O00000oO = dij;
    }

    public dio(dij dij, byte b) {
        this(dij);
    }

    /* access modifiers changed from: protected */
    public final Bundle O000000o() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", "3.5.2.lite");
        bundle.putString("sdkp", "a");
        dij dij = this.O00000oO;
        if (dij != null && dij.O000000o()) {
            bundle.putString("access_token", this.O00000oO.O00000Oo);
            bundle.putString("oauth_consumer_key", this.O00000oO.f14674O000000o);
            bundle.putString("openid", this.O00000oO.O00000o0);
            bundle.putString("appid_for_getting_config", this.O00000oO.f14674O000000o);
        }
        SharedPreferences sharedPreferences = djk.O000000o().getSharedPreferences("pfStore", 0);
        if (O0000Oo0) {
            bundle.putString("pf", "desktop_m_qq-" + O0000O0o + "-android-" + O00000oo + "-" + O0000OOo);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
        }
        return bundle;
    }

    public final String O000000o(String str) {
        Bundle O000000o2 = O000000o();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            O000000o2.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.O000000o(O000000o2));
        return sb.toString();
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
    private static Intent O00000Oo(Activity activity, Intent intent, Map<String, Object> map) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(dip.O00000o0)) {
                intent2.putExtra(dip.O00000o0, ((Boolean) map.get(dip.O00000o0)).booleanValue());
            }
        } catch (Exception e) {
            diz.O00000Oo("openSDK_LOG.BaseApi", "Exception", e);
        }
        return intent2;
    }

    protected static void O000000o(Activity activity, Intent intent, Map<String, Object> map) {
        intent.putExtra("key_request_code", 11101);
        activity.startActivityForResult(O00000Oo(activity, intent, map), 11101);
    }

    protected static void O000000o(Fragment fragment, Intent intent, Map<String, Object> map) {
        intent.putExtra("key_request_code", 11101);
        fragment.startActivityForResult(O00000Oo(fragment.getActivity(), intent, map), 11101);
    }

    protected static boolean O000000o(Intent intent) {
        if (intent != null) {
            return djn.O000000o(djk.O000000o(), intent);
        }
        return false;
    }

    protected static Intent O00000Oo(String str) {
        Intent intent = new Intent();
        if (djp.O00000Oo(djk.O000000o())) {
            intent.setClassName("com.tencent.minihd.qq", str);
            if (djn.O000000o(djk.O000000o(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (djn.O000000o(djk.O000000o(), intent)) {
            return intent;
        }
        intent.setClassName("com.tencent.tim", str);
        if (djn.O000000o(djk.O000000o(), intent)) {
            return intent;
        }
        intent.setClassName("com.tencent.qqlite", str);
        if (djn.O000000o(djk.O000000o(), intent)) {
            return intent;
        }
        return null;
    }

    public class O000000o implements djy {

        /* renamed from: O000000o  reason: collision with root package name */
        final djz f14690O000000o;
        private final Handler O00000o0;

        public O000000o(djz djz) {
            this.f14690O000000o = djz;
            this.O00000o0 = new Handler(djk.O000000o().getMainLooper(), dio.this) {
                /* class _m_j.dio.O000000o.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.what == 0) {
                        O000000o.this.f14690O000000o.onComplete(message.obj);
                    } else {
                        O000000o.this.f14690O000000o.onError(new dkb(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        public final void O000000o(JSONObject jSONObject) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(IOException iOException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(MalformedURLException malformedURLException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(JSONException jSONException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(ConnectTimeoutException connectTimeoutException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = connectTimeoutException.getMessage();
            obtainMessage.what = -7;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.O00000o0.sendMessage(obtainMessage);
        }

        public final void O000000o(Exception exc) {
            Message obtainMessage = this.O00000o0.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.O00000o0.sendMessage(obtainMessage);
        }
    }
}
