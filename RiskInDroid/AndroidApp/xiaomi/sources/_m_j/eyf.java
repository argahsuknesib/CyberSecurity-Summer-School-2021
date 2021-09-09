package _m_j;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;

public interface eyf {
    void assistActivity(Activity activity);

    void changeHome(Activity activity, String str);

    void cleanInstance();

    boolean dispatchToShop(String str, String str2);

    void getLocationRx(String str, hkk<String, String> hkk);

    Single<String> getServiceTokenJson(Context context, String str);

    String getUserId(String str);

    boolean isYoupinHost(String str);

    void onReceivedLoginRequest(Context context, WebView webView, String str, String str2, String str3);

    void openUrl(String str);

    void payWithMipayChinaMainland(Context context, String str, boolean z);

    void removeWXPayCallback();

    void requestCapturePermissions(Activity activity, SingleEmitter singleEmitter);

    void setShouldFitSoftKeybord(boolean z);

    void startLogin(Context context, int i, Runnable runnable);

    void startScreenShot(Activity activity, CommonWebView commonWebView);
}
