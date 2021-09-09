package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class hkn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f19018O000000o;

    public static String O00000Oo() {
        return "window.MJApi.isInit = true;\nvar readyEvent = document.createEvent('Events');\nreadyEvent.initEvent('vipAccountBridgeReady');\nreadyEvent.bridge = window.MJApi;\ndocument.dispatchEvent(readyEvent);\nwindow.MJApi.callHandler('default','init');\nconsole.log('MJApi init end')\n";
    }

    public static String O000000o() {
        if (TextUtils.isEmpty(f19018O000000o)) {
            f19018O000000o = O000000o(CommonApplication.getAppContext(), "smartHomeBridge.js");
        }
        return f19018O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e A[SYNTHETIC, Splitter:B:33:0x006e] */
    private static String O000000o(Context context, String str) {
        InputStream inputStream;
        String readLine;
        try {
            inputStream = context.getAssets().open(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && !readLine.matches("^\\s*\\/\\/.*")) {
                        sb.append(readLine);
                        continue;
                    }
                } while (readLine != null);
                bufferedReader.close();
                inputStream.close();
                String sb2 = sb.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        gsy.O00000Oo("BridgeUtil", String.format("assetFile2Str inputStream close error: %s", e));
                    }
                }
                return sb2;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            gsy.O00000Oo("BridgeUtil", String.format("assetFile2Str inputStream close error: %s", e3));
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    gsy.O00000Oo("BridgeUtil", String.format("assetFile2Str inputStream close error: %s", e5));
                }
            }
            throw th;
        }
    }

    public static String O000000o(String str) {
        try {
            return new JsonParser().parse(str).getAsJsonPrimitive().getAsString();
        } catch (JsonSyntaxException unused) {
            return str;
        }
    }
}
