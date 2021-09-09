package com.xiaomi.mico.api.interceptor;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class UAInterceptor implements Interceptor {
    private Context context;
    private final String userAgent = getUserAgent();

    public UAInterceptor(Context context2) {
        this.context = context2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.userAgent).build());
    }

    private String getUserAgent() {
        return "MICO/AndroidApp/" + "mijia" + "/" + getVersionName();
    }

    private String getVersionName() {
        try {
            return CommonApplication.getAppContext().getPackageManager().getPackageInfo(CommonApplication.getAppContext().getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }
}
