package com.miui.tsmclient.util;

import android.content.Context;
import com.miui.tsmclientsdk.UnSupportedException;

public class NfcConfig {
    private static INfcConfig sNfcConfig;

    public interface INfcConfig {
        boolean setConfigByUrl(Context context, String str) throws UnSupportedException;
    }

    public static boolean setConfigByUrl(Context context, String str) throws UnSupportedException {
        INfcConfig nfcConfig = getNfcConfig(context);
        if (nfcConfig != null) {
            return nfcConfig.setConfigByUrl(context, str);
        }
        throw new UnSupportedException();
    }

    private static synchronized INfcConfig getNfcConfig(Context context) {
        INfcConfig iNfcConfig;
        synchronized (NfcConfig.class) {
            if (sNfcConfig == null) {
                Object newInstance = ReflectUtil.newInstance(context.getPackageName() + ".mitsmsdk.NfcConfigImpl", new Class[0], new Object[0]);
                if (newInstance instanceof INfcConfig) {
                    sNfcConfig = (INfcConfig) newInstance;
                }
            }
            iNfcConfig = sNfcConfig;
        }
        return iNfcConfig;
    }
}
