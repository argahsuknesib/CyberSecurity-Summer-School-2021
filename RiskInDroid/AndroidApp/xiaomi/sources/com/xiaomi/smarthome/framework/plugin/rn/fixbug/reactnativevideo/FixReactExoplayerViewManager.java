package com.xiaomi.smarthome.framework.plugin.rn.fixbug.reactnativevideo;

import _m_j.fxo;
import _m_j.fxq;
import _m_j.ul;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.brentvatne.exoplayer.ReactExoplayerViewManager;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.HashMap;

public class FixReactExoplayerViewManager extends ReactExoplayerViewManager {
    public ul createViewInstance(ThemedReactContext themedReactContext) {
        return new fxo(themedReactContext);
    }

    public void setSrc(ul ulVar, ReadableMap readableMap) {
        Uri buildRawResourceUri;
        MiServiceTokenInfo O000000o2;
        Context applicationContext = ulVar.getContext().getApplicationContext();
        HashMap hashMap = null;
        String string = readableMap.hasKey("uri") ? readableMap.getString("uri") : null;
        String string2 = readableMap.hasKey("type") ? readableMap.getString("type") : null;
        if (readableMap.hasKey("requestHeaders")) {
            hashMap = toStringMap(readableMap.getMap("requestHeaders"));
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (validUri(string)) {
            Uri parse = Uri.parse(string);
            if (parse != null) {
                if (fxq.O000000o(parse) && (O000000o2 = CoreApi.O000000o().O000000o("xiaomiio")) != null) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put("Cookie", "yetAnotherServiceToken=" + O000000o2.O00000o0);
                }
                ulVar.O000000o(parse, string2, hashMap);
                return;
            }
            return;
        }
        int identifier = applicationContext.getResources().getIdentifier(string, "drawable", applicationContext.getPackageName());
        if (identifier == 0) {
            identifier = applicationContext.getResources().getIdentifier(string, "raw", applicationContext.getPackageName());
        }
        if (identifier > 0 && (buildRawResourceUri = RawResourceDataSource.buildRawResourceUri(identifier)) != null) {
            ulVar.O00000Oo(buildRawResourceUri, string2);
        }
    }

    private boolean validUri(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || str.startsWith("content://") || str.startsWith("file://") || str.startsWith("asset://");
    }
}
