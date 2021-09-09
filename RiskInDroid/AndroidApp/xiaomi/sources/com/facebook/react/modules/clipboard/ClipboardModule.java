package com.facebook.react.modules.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Clipboard")
public class ClipboardModule extends ContextBaseJavaModule {
    public String getName() {
        return "Clipboard";
    }

    public ClipboardModule(Context context) {
        super(context);
    }

    private ClipboardManager getClipboardService() {
        Context context = getContext();
        getContext();
        return (ClipboardManager) context.getSystemService("clipboard");
    }

    @ReactMethod
    public void getString(Promise promise) {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipData primaryClip = clipboardService.getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                promise.resolve("");
                return;
            }
            ClipData.Item itemAt = clipboardService.getPrimaryClip().getItemAt(0);
            StringBuilder sb = new StringBuilder();
            sb.append((Object) itemAt.getText());
            promise.resolve(sb.toString());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setString(String str) {
        getClipboardService().setPrimaryClip(ClipData.newPlainText(null, str));
    }
}
