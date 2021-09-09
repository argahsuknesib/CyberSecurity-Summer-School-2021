package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public final class hlp {
    public static Observable<String> O000000o(final WebView webView, String str) {
        if (webView == null) {
            return Observable.error(new IllegalArgumentException("argumrnt webview is null"));
        }
        if (Build.VERSION.SDK_INT < 19) {
            return Observable.empty();
        }
        final String concat = "javascript:".concat(String.valueOf(str));
        return Observable.create(new ObservableOnSubscribe<String>() {
            /* class _m_j.hlp.AnonymousClass1 */

            public final void subscribe(final ObservableEmitter<String> observableEmitter) throws Exception {
                webView.evaluateJavascript(concat, new ValueCallback<String>() {
                    /* class _m_j.hlp.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void onReceiveValue(Object obj) {
                        String str = (String) obj;
                        gsy.O00000Oo("JsSdkUtils", "callJsFuncByRx: " + concat + " ;return value: " + str);
                        if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                            str = str.substring(1, str.length() - 1);
                        }
                        observableEmitter.onNext(str);
                        observableEmitter.onComplete();
                    }
                });
            }
        }).subscribeOn(AndroidSchedulers.mainThread());
    }

    private static Observable<String> O00000Oo(WebView webView, String str, String... strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("(");
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            sb.append("'");
            sb.append(str2);
            sb.append("'");
            if (i != strArr.length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return O000000o(webView, sb.toString());
    }

    @SuppressLint({"CheckResult"})
    public static void O000000o(WebView webView, String str, String... strArr) {
        O00000Oo(webView, str, strArr).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }

    public static String O000000o(Context context) {
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
            String str = context.getFilesDir().getAbsolutePath() + File.separator + "default_share_icon.jpeg";
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            decodeResource.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Bitmap O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            gsy.O000000o(6, "JsSdkUtils", "base64ImageDecoder:  empty base64: ");
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            gsy.O000000o(6, "JsSdkUtils", "base64ImageDecoder: failed with base64: " + str + " ;message: " + e.getLocalizedMessage());
            return null;
        }
    }

    public static <T> T O000000o(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void O000000o(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            CommonApplication.getGlobalHandler().post(runnable);
        }
    }

    public static void O00000Oo(Runnable runnable) {
        CommonApplication.getGlobalHandler().postDelayed(runnable, 200);
    }

    public static boolean O00000Oo(String str) {
        gsy.O00000Oo("JsSdkUtils", "isValidUrl: url: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (TextUtils.equals("http", scheme) || TextUtils.equals("https", scheme)) {
                String host = parse.getHost();
                if (TextUtils.isEmpty(host)) {
                    gsy.O00000Oo("JsSdkUtils", "isValidUrl: invalid url host: empty host");
                    return false;
                }
                List asList = Arrays.asList("mi.com", "xiaomiyoupin.com", "miui.com", "xiaomi.com");
                String[] split = host.split("\\.");
                int length = split.length;
                if (split.length >= 2) {
                    host = split[length - 2] + "." + split[length - 1];
                }
                if (asList.contains(host)) {
                    return true;
                }
                gsy.O00000Oo("JsSdkUtils", "isValidUrl : invalid url domain:" + host + ",only accept domain in the list: " + Arrays.deepToString(asList.toArray()));
                return false;
            }
            gsy.O00000Oo("JsSdkUtils", "isValidUrl: invalid url scheme: ".concat(String.valueOf(str)));
            return false;
        } catch (Exception e) {
            gsy.O00000Oo("JsSdkUtils", "isValidUrl: " + Log.getStackTraceString(e));
            return false;
        }
    }
}
