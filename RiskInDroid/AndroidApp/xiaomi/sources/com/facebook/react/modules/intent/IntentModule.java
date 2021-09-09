package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "IntentAndroid")
public class IntentModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "IntentAndroid";
    }

    public IntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getInitialURL(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            String str = null;
            if (currentActivity != null) {
                Intent intent = currentActivity.getIntent();
                String action = intent.getAction();
                Uri data = intent.getData();
                if (data != null && ("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) {
                    str = data.toString();
                }
            }
            promise.resolve(str);
        } catch (Exception e) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not get the initial URL : " + e.getMessage()));
        }
    }

    @ReactMethod
    public void openURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(new JSApplicationIllegalArgumentException("Invalid URL: ".concat(String.valueOf(str))));
            return;
        }
        try {
            Activity currentActivity = getCurrentActivity();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).normalizeScheme());
            String packageName = getReactApplicationContext().getPackageName();
            ComponentName resolveActivity = intent.resolveActivity(getReactApplicationContext().getPackageManager());
            String packageName2 = resolveActivity != null ? resolveActivity.getPackageName() : "";
            if (currentActivity == null || !packageName.equals(packageName2)) {
                intent.addFlags(268435456);
            }
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
            } else {
                getReactApplicationContext().startActivity(intent);
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not open URL '" + str + "': " + e.getMessage()));
        }
    }

    @ReactMethod
    public void canOpenURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(new JSApplicationIllegalArgumentException("Invalid URL: ".concat(String.valueOf(str))));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            promise.resolve(Boolean.valueOf(intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null));
        } catch (Exception e) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not check if URL '" + str + "' can be opened: " + e.getMessage()));
        }
    }

    @ReactMethod
    public void openSettings(Promise promise) {
        try {
            Intent intent = new Intent();
            Activity currentActivity = getCurrentActivity();
            String packageName = getReactApplicationContext().getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:".concat(String.valueOf(packageName))));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            currentActivity.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not open the Settings: " + e.getMessage()));
        }
    }

    @ReactMethod
    public void sendIntent(String str, ReadableArray readableArray, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.reject(new JSApplicationIllegalArgumentException("Invalid Action: " + str + "."));
            return;
        }
        Intent intent = new Intent(str);
        if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) == null) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not launch Intent with action " + str + "."));
            return;
        }
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                String nextKey = map.keySetIterator().nextKey();
                int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[map.getType(nextKey).ordinal()];
                if (i2 == 1) {
                    intent.putExtra(nextKey, map.getString(nextKey));
                } else if (i2 == 2) {
                    intent.putExtra(nextKey, Double.valueOf(map.getDouble(nextKey)));
                } else if (i2 != 3) {
                    promise.reject(new JSApplicationIllegalArgumentException("Extra type for " + nextKey + " not supported."));
                    return;
                } else {
                    intent.putExtra(nextKey, map.getBoolean(nextKey));
                }
            }
        }
        getReactApplicationContext().startActivity(intent);
    }

    /* renamed from: com.facebook.react.modules.intent.IntentModule$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 1;
            $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
