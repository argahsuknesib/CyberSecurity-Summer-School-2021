package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.packagerconnection.RequestHandler;
import java.util.Map;

public class DevSupportManagerFactory {
    public static DevSupportManager create(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, int i) {
        return create(context, reactInstanceManagerDevHelper, str, z, null, null, i, null);
    }

    public static DevSupportManager create(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map) {
        if (!z) {
            return new DisabledDevSupportManager();
        }
        try {
            return (DevSupportManager) Class.forName(new StringBuilder("com.facebook.react.devsupport.DevSupportManagerImpl").toString()).getConstructor(Context.class, ReactInstanceManagerDevHelper.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE, Map.class).newInstance(context, reactInstanceManagerDevHelper, str, Boolean.TRUE, redBoxHandler, devBundleDownloadListener, Integer.valueOf(i), map);
        } catch (Exception e) {
            throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", e);
        }
    }
}
