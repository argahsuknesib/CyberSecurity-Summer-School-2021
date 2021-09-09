package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeProtocol {
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(20170417, 20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101);
    private static final String TAG = "com.facebook.internal.NativeProtocol";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap = buildActionToAppInfoMap();
    private static final List<NativeAppInfo> effectCameraAppInfoList = buildEffectCameraAppInfoList();
    public static final List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
    public static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        /* access modifiers changed from: protected */
        public abstract String getLoginActivity();

        /* access modifiers changed from: protected */
        public abstract String getPackage();

        private NativeAppInfo() {
        }

        public TreeSet<Integer> getAvailableVersions() {
            TreeSet<Integer> treeSet = this.availableVersions;
            if (treeSet == null || treeSet.isEmpty()) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
            if (r0.availableVersions.isEmpty() == false) goto L_0x0015;
         */
        public synchronized void fetchAvailableVersions(boolean z) {
            if (!z) {
                if (this.availableVersions != null) {
                }
            }
            this.availableVersions = NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(this);
        }
    }

    static class KatanaAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.katana";
        }

        private KatanaAppInfo() {
            super();
        }
    }

    static class MessengerAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return null;
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.orca";
        }

        private MessengerAppInfo() {
            super();
        }
    }

    static class WakizashiAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.wakizashi";
        }

        private WakizashiAppInfo() {
            super();
        }
    }

    static class FBLiteAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.lite";
        }

        private FBLiteAppInfo() {
            super();
        }
    }

    static class EffectTestAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return null;
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }

        private EffectTestAppInfo() {
            super();
        }
    }

    private static List<NativeAppInfo> buildFacebookAppList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KatanaAppInfo());
        arrayList.add(new WakizashiAppInfo());
        return arrayList;
    }

    private static List<NativeAppInfo> buildEffectCameraAppInfoList() {
        ArrayList arrayList = new ArrayList(buildFacebookAppList());
        arrayList.add(0, new EffectTestAppInfo());
        return arrayList;
    }

    private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessengerAppInfo());
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", facebookAppInfoList);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", effectCameraAppInfoList);
        hashMap.put("com.facebook.platform.action.request.SHARE_STORY", facebookAppInfoList);
        return hashMap;
    }

    static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveActivity;
        if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || !FacebookSignatureValidator.validateSignature(context, resolveActivity.activityInfo.packageName)) {
            return null;
        }
        return intent;
    }

    static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveService;
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null || !FacebookSignatureValidator.validateSignature(context, resolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }

    public static Intent createFacebookLiteIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        FBLiteAppInfo fBLiteAppInfo = new FBLiteAppInfo();
        return validateActivityIntent(context, createNativeAppIntent(fBLiteAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), fBLiteAppInfo);
    }

    private static Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        String loginActivity = nativeAppInfo.getLoginActivity();
        if (loginActivity == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
        putExtra.putExtra("facebook_sdk_version", FacebookSdk.getSdkVersion());
        if (!Utility.isNullOrEmpty(collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.isNullOrEmpty(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra("response_type", "token,signed_request");
        putExtra.putExtra("return_scopes", "true");
        if (z2) {
            putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra("legacy_override", FacebookSdk.getGraphApiVersion());
        putExtra.putExtra("auth_type", str4);
        return putExtra;
    }

    public static Intent createProxyAuthIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        for (NativeAppInfo next : facebookAppInfoList) {
            Intent validateActivityIntent = validateActivityIntent(context, createNativeAppIntent(next, str, collection, str2, z, z2, defaultAudience, str3, str4), next);
            if (validateActivityIntent != null) {
                return validateActivityIntent;
            }
        }
        return null;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        for (NativeAppInfo next : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(next.getPackage(), "com.facebook.katana.platform.TokenRefreshService"), next);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static final int getLatestKnownVersion() {
        return KNOWN_PROTOCOL_VERSIONS.get(0).intValue();
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i) {
        return KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        NativeAppInfo nativeAppInfo;
        Intent validateActivityIntent;
        if (protocolVersionQueryResult == null || (nativeAppInfo = protocolVersionQueryResult.nativeAppInfo) == null || (validateActivityIntent = validateActivityIntent(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo)) == null) {
            return null;
        }
        setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.protocolVersion, bundle);
        return validateActivityIntent;
    }

    public static void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", str2).putExtra("com.facebook.platform.extra.APPLICATION_ID", applicationId);
        if (isVersionCompatibleWithBucketedIntent(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, "app_name", applicationName);
            intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
            return;
        }
        intent.putExtra("com.facebook.platform.protocol.CALL_ID", str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", applicationName);
        }
        intent.putExtras(bundle);
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle != null) {
            intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        }
        return intent2;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        for (NativeAppInfo next : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(next.getPackage()).addCategory("android.intent.category.DEFAULT"), next);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            str = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            str = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (str == null) {
            return null;
        }
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return null;
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        return (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) ? extras : extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    }

    public static boolean isErrorResult(Intent intent) {
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.containsKey("error");
        }
        return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        if (!isErrorResult(intent)) {
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.getBundle("error");
        }
        return intent.getExtras();
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (string == null || !string.equalsIgnoreCase("UserCanceled")) {
            return new FacebookException(string2);
        }
        return new FacebookOperationCanceledException(string2);
    }

    public static Bundle createBundleForException(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString("error_type", "UserCanceled");
        }
        return bundle;
    }

    public static int getLatestAvailableProtocolVersionForService(int i) {
        return getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i}).getProtocolVersion();
    }

    public static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        return getLatestAvailableProtocolVersionForAppInfoList(actionToAppInfoMap.get(str), iArr);
    }

    private static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> list, int[] iArr) {
        updateAllAvailableProtocolVersionsAsync();
        if (list == null) {
            return ProtocolVersionQueryResult.createEmpty();
        }
        for (NativeAppInfo next : list) {
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(next.getAvailableVersions(), getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                return ProtocolVersionQueryResult.create(next, computeLatestAvailableVersionFromVersionSpec);
            }
        }
        return ProtocolVersionQueryResult.createEmpty();
    }

    public static void updateAllAvailableProtocolVersionsAsync() {
        if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.internal.NativeProtocol.AnonymousClass1 */

                public final void run() {
                    try {
                        for (NativeAppInfo fetchAvailableVersions : NativeProtocol.facebookAppInfoList) {
                            fetchAvailableVersions.fetchAvailableVersions(true);
                        }
                    } finally {
                        NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        android.util.Log.e(com.facebook.internal.NativeProtocol.TAG, "Failed to query content resolver.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
    public static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo nativeAppInfo) {
        Object obj;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
        String[] strArr = {"version"};
        Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(nativeAppInfo);
        Cursor cursor = null;
        try {
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            obj = packageManager.resolveContentProvider(nativeAppInfo.getPackage() + ".provider.PlatformProvider", 0);
        } catch (RuntimeException e) {
            Log.e(TAG, "Failed to query content resolver.", e);
            obj = cursor;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (obj != null) {
            cursor = contentResolver.query(buildPlatformProviderVersionURI, strArr, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("version"))));
                }
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return treeSet;
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int length = iArr.length - 1;
        int i2 = -1;
        while (true) {
            if (!descendingIterator.hasNext()) {
                break;
            }
            int intValue = descendingIterator.next().intValue();
            i2 = Math.max(i2, intValue);
            while (length >= 0 && iArr[length] > intValue) {
                length--;
            }
            if (length < 0) {
                return -1;
            }
            if (iArr[length] == intValue) {
                if (length % 2 == 0) {
                    return Math.min(i2, i);
                }
            }
        }
        return -1;
    }

    private static Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        return Uri.parse("content://" + nativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
    }

    public static class ProtocolVersionQueryResult {
        public NativeAppInfo nativeAppInfo;
        public int protocolVersion;

        public static ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo2, int i) {
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.nativeAppInfo = nativeAppInfo2;
            protocolVersionQueryResult.protocolVersion = i;
            return protocolVersionQueryResult;
        }

        public static ProtocolVersionQueryResult createEmpty() {
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.protocolVersion = -1;
            return protocolVersionQueryResult;
        }

        private ProtocolVersionQueryResult() {
        }

        public NativeAppInfo getAppInfo() {
            return this.nativeAppInfo;
        }

        public int getProtocolVersion() {
            return this.protocolVersion;
        }
    }
}
