package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.RequestQueue;
import java.io.File;

public class Volley {
    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        String str;
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            str = packageName + "/" + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "volley/0";
        }
        if (httpStack == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                httpStack = new HurlStack();
            } else {
                httpStack = new HttpClientStack(AndroidHttpClient.newInstance(str));
            }
        }
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file), new BasicNetwork(httpStack));
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
}
