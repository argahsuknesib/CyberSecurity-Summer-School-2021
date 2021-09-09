package com.facebook.applinks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData {
    private static final String TAG = "com.facebook.applinks.AppLinkData";
    private JSONObject appLinkData;
    private Bundle argumentBundle;
    private JSONObject arguments;
    private String promotionCode;
    private String ref;
    private Uri targetUri;

    public interface CompletionHandler {
        void onDeferredAppLinkDataFetched(AppLinkData appLinkData);
    }

    public static void fetchDeferredAppLinkData(Context context, CompletionHandler completionHandler) {
        fetchDeferredAppLinkData(context, null, completionHandler);
    }

    public static void fetchDeferredAppLinkData(Context context, final String str, final CompletionHandler completionHandler) {
        Validate.notNull(context, "context");
        Validate.notNull(completionHandler, "completionHandler");
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(str, "applicationId");
        final Context applicationContext = context.getApplicationContext();
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.applinks.AppLinkData.AnonymousClass1 */

            public final void run() {
                AppLinkData.fetchDeferredAppLinkFromServer(applicationContext, str, completionHandler);
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.facebook.internal.Utility.logd(com.facebook.applinks.AppLinkData.TAG, "Unable to put tap time in AppLinkData.arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        com.facebook.internal.Utility.logd(com.facebook.applinks.AppLinkData.TAG, "Unable to put app link class name in AppLinkData.arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.facebook.internal.Utility.logd(com.facebook.applinks.AppLinkData.TAG, "Unable to put app link URL in AppLinkData.arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cd, code lost:
        com.facebook.internal.Utility.logd(com.facebook.applinks.AppLinkData.TAG, "Unable to fetch deferred applink from server");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00a7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00c5 */
    public static void fetchDeferredAppLinkFromServer(Context context, String str, CompletionHandler completionHandler) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "DEFERRED_APP_LINK");
            Utility.setAppEventAttributionParameters(jSONObject, AttributionIdentifiers.getAttributionIdentifiers(context), AppEventsLogger.getAnonymousAppDeviceGUID(context), FacebookSdk.getLimitEventAndDataUsage(context));
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, FacebookSdk.getApplicationContext());
            jSONObject.put("application_package_name", context.getPackageName());
            Object[] objArr = {str};
            AppLinkData appLinkData2 = null;
            JSONObject jSONObject2 = GraphRequest.newPostRequest(null, String.format("%s/activities", objArr), jSONObject, null).executeAndWait().getJSONObject();
            if (jSONObject2 != null) {
                String optString = jSONObject2.optString("applink_args");
                long optLong = jSONObject2.optLong("click_time", -1);
                String optString2 = jSONObject2.optString("applink_class");
                String optString3 = jSONObject2.optString("applink_url");
                if (!TextUtils.isEmpty(optString) && (appLinkData2 = createFromJson(optString)) != null) {
                    if (optLong != -1) {
                        if (appLinkData2.arguments != null) {
                            appLinkData2.arguments.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", optLong);
                        }
                        if (appLinkData2.argumentBundle != null) {
                            appLinkData2.argumentBundle.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", Long.toString(optLong));
                        }
                    }
                    if (optString2 != null) {
                        if (appLinkData2.arguments != null) {
                            appLinkData2.arguments.put("com.facebook.platform.APPLINK_NATIVE_CLASS", optString2);
                        }
                        if (appLinkData2.argumentBundle != null) {
                            appLinkData2.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", optString2);
                        }
                    }
                    if (optString3 != null) {
                        if (appLinkData2.arguments != null) {
                            appLinkData2.arguments.put("com.facebook.platform.APPLINK_NATIVE_URL", optString3);
                        }
                        if (appLinkData2.argumentBundle != null) {
                            appLinkData2.argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_URL", optString3);
                        }
                    }
                }
            }
            completionHandler.onDeferredAppLinkDataFetched(appLinkData2);
        } catch (JSONException e) {
            throw new FacebookException("An error occurred while preparing deferred app link", e);
        }
    }

    public static AppLinkData createFromActivity(Activity activity) {
        Validate.notNull(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        AppLinkData createFromAlApplinkData = createFromAlApplinkData(intent);
        if (createFromAlApplinkData == null) {
            createFromAlApplinkData = createFromJson(intent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
        }
        return createFromAlApplinkData == null ? createFromUri(intent.getData()) : createFromAlApplinkData;
    }

    public static AppLinkData createFromAlApplinkData(Intent intent) {
        Bundle bundleExtra;
        String string;
        String string2;
        if (intent == null || (bundleExtra = intent.getBundleExtra("al_applink_data")) == null) {
            return null;
        }
        AppLinkData appLinkData2 = new AppLinkData();
        appLinkData2.targetUri = intent.getData();
        appLinkData2.appLinkData = getAppLinkData(appLinkData2.targetUri);
        if (appLinkData2.targetUri == null && (string2 = bundleExtra.getString("target_url")) != null) {
            appLinkData2.targetUri = Uri.parse(string2);
        }
        appLinkData2.argumentBundle = bundleExtra;
        appLinkData2.arguments = null;
        Bundle bundle = bundleExtra.getBundle("referer_data");
        if (bundle != null) {
            appLinkData2.ref = bundle.getString("fb_ref");
        }
        Bundle bundle2 = bundleExtra.getBundle("extras");
        if (!(bundle2 == null || (string = bundle2.getString("deeplink_context")) == null)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("promo_code")) {
                    appLinkData2.promotionCode = jSONObject.getString("promo_code");
                }
            } catch (JSONException e) {
                Utility.logd(TAG, "Unable to parse deeplink_context JSON", e);
            }
        }
        return appLinkData2;
    }

    private static AppLinkData createFromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("version");
            if (jSONObject.getJSONObject("bridge_args").getString("method").equals("applink") && string.equals("2")) {
                AppLinkData appLinkData2 = new AppLinkData();
                appLinkData2.arguments = jSONObject.getJSONObject("method_args");
                if (appLinkData2.arguments.has("ref")) {
                    appLinkData2.ref = appLinkData2.arguments.getString("ref");
                } else if (appLinkData2.arguments.has("referer_data")) {
                    JSONObject jSONObject2 = appLinkData2.arguments.getJSONObject("referer_data");
                    if (jSONObject2.has("fb_ref")) {
                        appLinkData2.ref = jSONObject2.getString("fb_ref");
                    }
                }
                if (appLinkData2.arguments.has("target_url")) {
                    appLinkData2.targetUri = Uri.parse(appLinkData2.arguments.getString("target_url"));
                    appLinkData2.appLinkData = getAppLinkData(appLinkData2.targetUri);
                }
                if (appLinkData2.arguments.has("extras")) {
                    JSONObject jSONObject3 = appLinkData2.arguments.getJSONObject("extras");
                    if (jSONObject3.has("deeplink_context")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("deeplink_context");
                        if (jSONObject4.has("promo_code")) {
                            appLinkData2.promotionCode = jSONObject4.getString("promo_code");
                        }
                    }
                }
                appLinkData2.argumentBundle = toBundle(appLinkData2.arguments);
                return appLinkData2;
            }
        } catch (JSONException e) {
            Utility.logd(TAG, "Unable to parse AppLink JSON", e);
        } catch (FacebookException e2) {
            Utility.logd(TAG, "Unable to parse AppLink JSON", e2);
        }
        return null;
    }

    private static AppLinkData createFromUri(Uri uri) {
        if (uri == null) {
            return null;
        }
        AppLinkData appLinkData2 = new AppLinkData();
        appLinkData2.targetUri = uri;
        appLinkData2.appLinkData = getAppLinkData(appLinkData2.targetUri);
        return appLinkData2;
    }

    private static Bundle toBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                bundle.putBundle(next, toBundle((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                int i = 0;
                if (jSONArray.length() == 0) {
                    bundle.putStringArray(next, new String[0]);
                } else {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        Bundle[] bundleArr = new Bundle[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            bundleArr[i] = toBundle(jSONArray.getJSONObject(i));
                            i++;
                        }
                        bundle.putParcelableArray(next, bundleArr);
                    } else if (!(obj2 instanceof JSONArray)) {
                        String[] strArr = new String[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            strArr[i] = jSONArray.get(i).toString();
                            i++;
                        }
                        bundle.putStringArray(next, strArr);
                    } else {
                        throw new FacebookException("Nested arrays are not supported.");
                    }
                }
            } else {
                bundle.putString(next, obj.toString());
            }
        }
        return bundle;
    }

    private static JSONObject getAppLinkData(Uri uri) {
        String queryParameter;
        if (uri == null || (queryParameter = uri.getQueryParameter("al_applink_data")) == null) {
            return null;
        }
        try {
            return new JSONObject(queryParameter);
        } catch (JSONException unused) {
            return null;
        }
    }

    private AppLinkData() {
    }

    public boolean isAutoAppLink() {
        Uri uri = this.targetUri;
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        String scheme = this.targetUri.getScheme();
        String format = String.format("fb%s", FacebookSdk.getApplicationId());
        JSONObject jSONObject = this.appLinkData;
        if (!(jSONObject != null && jSONObject.optBoolean("is_auto_applink")) || !"applinks".equals(host) || !format.equals(scheme)) {
            return false;
        }
        return true;
    }

    public Uri getTargetUri() {
        return this.targetUri;
    }

    public String getRef() {
        return this.ref;
    }

    public String getPromotionCode() {
        return this.promotionCode;
    }

    public Bundle getArgumentBundle() {
        return this.argumentBundle;
    }

    public Bundle getRefererData() {
        Bundle bundle = this.argumentBundle;
        if (bundle != null) {
            return bundle.getBundle("referer_data");
        }
        return null;
    }

    public JSONObject getAppLinkData() {
        JSONObject jSONObject = this.appLinkData;
        return jSONObject != null ? jSONObject : new JSONObject();
    }
}
