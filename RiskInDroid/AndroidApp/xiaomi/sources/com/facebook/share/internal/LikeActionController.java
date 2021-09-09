package com.facebook.share.internal;

import _m_j.ft;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class LikeActionController {
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    @Deprecated
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    @Deprecated
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    @Deprecated
    public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
    public static final String TAG = "LikeActionController";
    private static AccessTokenTracker accessTokenTracker;
    public static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap<>();
    public static FileLruCache controllerDiskCache;
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
    private static Handler handler;
    private static boolean isInitialized;
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static String objectIdForPendingController;
    public static volatile int objectSuffix;
    private Bundle facebookDialogAnalyticsBundle;
    public boolean isObjectLiked;
    public boolean isObjectLikedOnServer;
    public boolean isPendingLikeOrUnlike;
    public String likeCountStringWithLike;
    public String likeCountStringWithoutLike;
    private InternalAppEventsLogger logger;
    public String objectId;
    public boolean objectIsPage;
    public LikeView.ObjectType objectType;
    public String socialSentenceWithLike;
    public String socialSentenceWithoutLike;
    public String unlikeToken;
    public String verifiedObjectId;

    @Deprecated
    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    interface LikeRequestWrapper extends RequestWrapper {
        String getUnlikeToken();

        boolean isObjectLiked();
    }

    interface RequestCompletionCallback {
        void onComplete();
    }

    interface RequestWrapper {
        void addToBatch(GraphRequestBatch graphRequestBatch);

        FacebookRequestError getError();
    }

    @Deprecated
    public boolean shouldEnableView() {
        return false;
    }

    @Deprecated
    public static boolean handleOnActivityResult(final int i, final int i2, final Intent intent) {
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            return false;
        }
        getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new CreationCallback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass1 */

            public final void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
                if (facebookException == null) {
                    likeActionController.onActivityResult(i, i2, intent);
                } else {
                    Utility.logd(LikeActionController.TAG, facebookException);
                }
            }
        });
        return true;
    }

    @Deprecated
    public static void getControllerForObjectId(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        if (!isInitialized) {
            performFirstInitialize();
        }
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType2, creationCallback);
        } else {
            diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(str, objectType2, creationCallback));
        }
    }

    private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        FacebookException facebookException;
        LikeView.ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType2, likeActionController.objectType);
        if (mostSpecificObjectType == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.objectId, likeActionController.objectType.toString(), objectType2.toString());
            likeActionController = null;
        } else {
            likeActionController.objectType = mostSpecificObjectType;
            facebookException = null;
        }
        invokeCallbackWithController(creationCallback, likeActionController, facebookException);
    }

    public static void createControllerForObjectIdAndType(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType2, creationCallback);
            return;
        }
        LikeActionController deserializeFromDiskSynchronously = deserializeFromDiskSynchronously(str);
        if (deserializeFromDiskSynchronously == null) {
            deserializeFromDiskSynchronously = new LikeActionController(str, objectType2);
            serializeToDiskAsync(deserializeFromDiskSynchronously);
        }
        putControllerInMemoryCache(str, deserializeFromDiskSynchronously);
        handler.post(new Runnable(deserializeFromDiskSynchronously) {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass2 */
            final /* synthetic */ LikeActionController val$controllerToRefresh;

            {
                this.val$controllerToRefresh = r1;
            }

            public final void run() {
                this.val$controllerToRefresh.refreshStatusAsync();
            }
        });
        invokeCallbackWithController(creationCallback, deserializeFromDiskSynchronously, null);
    }

    private static synchronized void performFirstInitialize() {
        synchronized (LikeActionController.class) {
            if (!isInitialized) {
                handler = new Handler(Looper.getMainLooper());
                objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
                controllerDiskCache = new FileLruCache(TAG, new FileLruCache.Limits());
                registerAccessTokenTracker();
                CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new CallbackManagerImpl.Callback() {
                    /* class com.facebook.share.internal.LikeActionController.AnonymousClass3 */

                    public final boolean onActivityResult(int i, Intent intent) {
                        return LikeActionController.handleOnActivityResult(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), i, intent);
                    }
                });
                isInitialized = true;
            }
        }
    }

    private static void invokeCallbackWithController(final CreationCallback creationCallback, final LikeActionController likeActionController, final FacebookException facebookException) {
        if (creationCallback != null) {
            handler.post(new Runnable() {
                /* class com.facebook.share.internal.LikeActionController.AnonymousClass4 */

                public final void run() {
                    creationCallback.onComplete(likeActionController, facebookException);
                }
            });
        }
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new AccessTokenTracker() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass5 */

            public final void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                if (accessToken2 == null) {
                    LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % 1000;
                    applicationContext.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.objectSuffix).apply();
                    LikeActionController.cache.clear();
                    LikeActionController.controllerDiskCache.clearCache();
                }
                LikeActionController.broadcastAction(null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
            }
        };
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
    }

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, false));
        }
        return likeActionController;
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (!Utility.isNullOrEmpty(serializeToJson) && !Utility.isNullOrEmpty(cacheKeyForObjectId)) {
            diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(cacheKeyForObjectId, serializeToJson));
        }
    }

    public static void serializeToDiskSynchronously(String str, String str2) {
        OutputStream outputStream = null;
        try {
            outputStream = controllerDiskCache.openPutStream(str);
            outputStream.write(str2.getBytes());
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
            }
        } catch (IOException e) {
            Log.e(TAG, "Unable to serialize controller to disk", e);
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        com.facebook.internal.Utility.closeQuietly(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r5 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r5 != null) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039  */
    private static LikeActionController deserializeFromDiskSynchronously(String str) {
        InputStream inputStream;
        LikeActionController likeActionController = null;
        try {
            inputStream = controllerDiskCache.get(getCacheKeyForObjectId(str));
            if (inputStream != null) {
                try {
                    String readStreamToString = Utility.readStreamToString(inputStream);
                    if (!Utility.isNullOrEmpty(readStreamToString)) {
                        likeActionController = deserializeFromJson(readStreamToString);
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        Log.e(TAG, "Unable to deserialize controller from disk", e);
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            Utility.closeQuietly(inputStream);
                        }
                        throw th;
                    }
                }
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
            Log.e(TAG, "Unable to deserialize controller from disk", e);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
    }

    private static LikeActionController deserializeFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            LikeActionController likeActionController = new LikeActionController(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
            likeActionController.likeCountStringWithLike = jSONObject.optString("like_count_string_with_like", null);
            likeActionController.likeCountStringWithoutLike = jSONObject.optString("like_count_string_without_like", null);
            likeActionController.socialSentenceWithLike = jSONObject.optString("social_sentence_with_like", null);
            likeActionController.socialSentenceWithoutLike = jSONObject.optString("social_sentence_without_like", null);
            likeActionController.isObjectLiked = jSONObject.optBoolean("is_object_liked");
            likeActionController.unlikeToken = jSONObject.optString("unlike_token", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (optJSONObject != null) {
                likeActionController.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(optJSONObject);
            }
            return likeActionController;
        } catch (JSONException e) {
            Log.e(TAG, "Unable to deserialize controller from JSON", e);
            return null;
        }
    }

    private static String serializeToJson(LikeActionController likeActionController) {
        JSONObject convertToJSON;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", likeActionController.objectId);
            jSONObject.put("object_type", likeActionController.objectType.getValue());
            jSONObject.put("like_count_string_with_like", likeActionController.likeCountStringWithLike);
            jSONObject.put("like_count_string_without_like", likeActionController.likeCountStringWithoutLike);
            jSONObject.put("social_sentence_with_like", likeActionController.socialSentenceWithLike);
            jSONObject.put("social_sentence_without_like", likeActionController.socialSentenceWithoutLike);
            jSONObject.put("is_object_liked", likeActionController.isObjectLiked);
            jSONObject.put("unlike_token", likeActionController.unlikeToken);
            if (!(likeActionController.facebookDialogAnalyticsBundle == null || (convertToJSON = BundleJSONConverter.convertToJSON(likeActionController.facebookDialogAnalyticsBundle)) == null)) {
                jSONObject.put("facebook_dialog_analytics_bundle", convertToJSON);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.e(TAG, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String getCacheKeyForObjectId(String str) {
        String token = AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : null;
        if (token != null) {
            token = Utility.md5hash(token);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, Utility.coerceValueIfNullOrEmpty(token, ""), Integer.valueOf(objectSuffix));
    }

    public static void broadcastAction(LikeActionController likeActionController, String str) {
        broadcastAction(likeActionController, str, null);
    }

    public static void broadcastAction(LikeActionController likeActionController, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        ft.O000000o(FacebookSdk.getApplicationContext()).O000000o(intent);
    }

    private LikeActionController(String str, LikeView.ObjectType objectType2) {
        this.objectId = str;
        this.objectType = objectType2;
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    @Deprecated
    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    @Deprecated
    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    @Deprecated
    public void toggleLike(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        boolean z = true;
        boolean z2 = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateLikeState(z2);
            if (this.isPendingLikeOrUnlike) {
                getAppEventsLogger().logEventImplicitly("fb_like_control_did_undo_quickly", bundle);
                return;
            } else if (!publishLikeOrUnlikeAsync(z2, bundle)) {
                if (z2) {
                    z = false;
                }
                updateLikeState(z);
            } else {
                return;
            }
        }
        presentLikeDialog(activity, fragmentWrapper, bundle);
    }

    public InternalAppEventsLogger getAppEventsLogger() {
        if (this.logger == null) {
            this.logger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        }
        return this.logger;
    }

    private boolean publishLikeOrUnlikeAsync(boolean z, Bundle bundle) {
        if (canUseOGPublish()) {
            if (z) {
                publishLikeAsync(bundle);
                return true;
            } else if (!Utility.isNullOrEmpty(this.unlikeToken)) {
                publishUnlikeAsync(bundle);
                return true;
            }
        }
        return false;
    }

    public void publishDidError(boolean z) {
        updateLikeState(z);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", ERROR_PUBLISH_ERROR);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
    }

    private void updateLikeState(boolean z) {
        updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
    }

    public void updateState(boolean z, String str, String str2, String str3, String str4, String str5) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        if (z != this.isObjectLiked || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.likeCountStringWithLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.likeCountStringWithoutLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.socialSentenceWithLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.socialSentenceWithoutLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.unlikeToken)) {
            this.isObjectLiked = z;
            this.likeCountStringWithLike = coerceValueIfNullOrEmpty;
            this.likeCountStringWithoutLike = coerceValueIfNullOrEmpty2;
            this.socialSentenceWithLike = coerceValueIfNullOrEmpty3;
            this.socialSentenceWithoutLike = coerceValueIfNullOrEmpty4;
            this.unlikeToken = coerceValueIfNullOrEmpty5;
            serializeToDiskAsync(this);
            broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        }
    }

    private void presentLikeDialog(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        String str;
        String str2;
        if (LikeDialog.canShowNativeDialog()) {
            str = "fb_like_control_did_present_dialog";
        } else if (LikeDialog.canShowWebFallback()) {
            str = "fb_like_control_did_present_fallback_dialog";
        } else {
            logAppEventForError("present_dialog", bundle);
            Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
            broadcastAction(null, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
            str = null;
        }
        if (str != null) {
            LikeView.ObjectType objectType2 = this.objectType;
            if (objectType2 != null) {
                str2 = objectType2.toString();
            } else {
                str2 = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new LikeContent.Builder().setObjectId(this.objectId).setObjectType(str2).build();
            if (fragmentWrapper != null) {
                new LikeDialog(fragmentWrapper).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            saveState(bundle);
            getAppEventsLogger().logEventImplicitly("fb_like_control_did_present_dialog", bundle);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ShareInternalUtility.handleActivityResult(i, i2, intent, getResultProcessor(this.facebookDialogAnalyticsBundle));
        clearState();
    }

    private ResultProcessor getResultProcessor(final Bundle bundle) {
        return new ResultProcessor(null) {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass6 */

            public void onSuccess(AppCall appCall, Bundle bundle) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                if (bundle != null && bundle.containsKey("object_is_liked")) {
                    boolean z = bundle.getBoolean("object_is_liked");
                    String str6 = LikeActionController.this.likeCountStringWithLike;
                    String str7 = LikeActionController.this.likeCountStringWithoutLike;
                    if (bundle.containsKey("like_count_string")) {
                        str2 = bundle.getString("like_count_string");
                        str = str2;
                    } else {
                        str2 = str6;
                        str = str7;
                    }
                    String str8 = LikeActionController.this.socialSentenceWithLike;
                    String str9 = LikeActionController.this.socialSentenceWithoutLike;
                    if (bundle.containsKey("social_sentence")) {
                        str4 = bundle.getString("social_sentence");
                        str3 = str4;
                    } else {
                        str4 = str8;
                        str3 = str9;
                    }
                    if (bundle.containsKey("object_is_liked")) {
                        str5 = bundle.getString("unlike_token");
                    } else {
                        str5 = LikeActionController.this.unlikeToken;
                    }
                    String str10 = str5;
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        bundle2 = new Bundle();
                    }
                    bundle2.putString("call_id", appCall.getCallId().toString());
                    LikeActionController.this.getAppEventsLogger().logEventImplicitly("fb_like_control_dialog_did_succeed", bundle2);
                    LikeActionController.this.updateState(z, str2, str, str4, str3, str10);
                }
            }

            public void onError(AppCall appCall, FacebookException facebookException) {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", facebookException);
                Bundle bundle = bundle;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString("call_id", appCall.getCallId().toString());
                LikeActionController.this.logAppEventForError("present_dialog", bundle);
                LikeActionController.broadcastAction(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
            }

            public void onCancel(AppCall appCall) {
                onError(appCall, new FacebookOperationCanceledException());
            }
        };
    }

    private void saveState(Bundle bundle) {
        storeObjectIdForPendingController(this.objectId);
        this.facebookDialogAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
    }

    private void clearState() {
        this.facebookDialogAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
    }

    private static void storeObjectIdForPendingController(String str) {
        objectIdForPendingController = str;
        FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", objectIdForPendingController).apply();
    }

    private boolean canUseOGPublish() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return !this.objectIsPage && this.verifiedObjectId != null && AccessToken.isCurrentAccessTokenActive() && currentAccessToken.getPermissions() != null && currentAccessToken.getPermissions().contains("publish_actions");
    }

    private void publishLikeAsync(final Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new RequestCompletionCallback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass7 */

            public void onComplete() {
                if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", LikeActionController.ERROR_INVALID_OBJECT_ID);
                    LikeActionController.broadcastAction(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
                    return;
                }
                GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                LikeActionController likeActionController = LikeActionController.this;
                final PublishLikeRequestWrapper publishLikeRequestWrapper = new PublishLikeRequestWrapper(likeActionController.verifiedObjectId, LikeActionController.this.objectType);
                publishLikeRequestWrapper.addToBatch(graphRequestBatch);
                graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                    /* class com.facebook.share.internal.LikeActionController.AnonymousClass7.AnonymousClass1 */

                    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                        LikeActionController.this.isPendingLikeOrUnlike = false;
                        if (publishLikeRequestWrapper.getError() != null) {
                            LikeActionController.this.publishDidError(false);
                            return;
                        }
                        LikeActionController.this.unlikeToken = Utility.coerceValueIfNullOrEmpty(publishLikeRequestWrapper.unlikeToken, null);
                        LikeActionController.this.isObjectLikedOnServer = true;
                        LikeActionController.this.getAppEventsLogger().logEventImplicitly("fb_like_control_did_like", null, bundle);
                        LikeActionController.this.publishAgainIfNeeded(bundle);
                    }
                });
                graphRequestBatch.executeAsync();
            }
        });
    }

    private void publishUnlikeAsync(final Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        final PublishUnlikeRequestWrapper publishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(this.unlikeToken);
        publishUnlikeRequestWrapper.addToBatch(graphRequestBatch);
        graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass8 */

            public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                LikeActionController.this.isPendingLikeOrUnlike = false;
                if (publishUnlikeRequestWrapper.getError() != null) {
                    LikeActionController.this.publishDidError(true);
                    return;
                }
                LikeActionController likeActionController = LikeActionController.this;
                likeActionController.unlikeToken = null;
                likeActionController.isObjectLikedOnServer = false;
                likeActionController.getAppEventsLogger().logEventImplicitly("fb_like_control_did_unlike", null, bundle);
                LikeActionController.this.publishAgainIfNeeded(bundle);
            }
        });
        graphRequestBatch.executeAsync();
    }

    public void refreshStatusAsync() {
        if (!AccessToken.isCurrentAccessTokenActive()) {
            refreshStatusViaService();
        } else {
            fetchVerifiedObjectId(new RequestCompletionCallback() {
                /* class com.facebook.share.internal.LikeActionController.AnonymousClass9 */

                public void onComplete() {
                    final LikeRequestWrapper likeRequestWrapper;
                    if (AnonymousClass12.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeActionController.this.objectType.ordinal()] != 1) {
                        LikeActionController likeActionController = LikeActionController.this;
                        likeRequestWrapper = new GetOGObjectLikesRequestWrapper(likeActionController.verifiedObjectId, LikeActionController.this.objectType);
                    } else {
                        LikeActionController likeActionController2 = LikeActionController.this;
                        likeRequestWrapper = new GetPageLikesRequestWrapper(likeActionController2.verifiedObjectId);
                    }
                    LikeActionController likeActionController3 = LikeActionController.this;
                    final GetEngagementRequestWrapper getEngagementRequestWrapper = new GetEngagementRequestWrapper(likeActionController3.verifiedObjectId, LikeActionController.this.objectType);
                    GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                    likeRequestWrapper.addToBatch(graphRequestBatch);
                    getEngagementRequestWrapper.addToBatch(graphRequestBatch);
                    graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                        /* class com.facebook.share.internal.LikeActionController.AnonymousClass9.AnonymousClass1 */

                        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                            if (likeRequestWrapper.getError() == null && getEngagementRequestWrapper.getError() == null) {
                                LikeActionController.this.updateState(likeRequestWrapper.isObjectLiked(), getEngagementRequestWrapper.likeCountStringWithLike, getEngagementRequestWrapper.likeCountStringWithoutLike, getEngagementRequestWrapper.socialSentenceStringWithLike, getEngagementRequestWrapper.socialSentenceStringWithoutLike, likeRequestWrapper.getUnlikeToken());
                                return;
                            }
                            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", LikeActionController.this.objectId);
                        }
                    });
                    graphRequestBatch.executeAsync();
                }
            });
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController$12  reason: invalid class name */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$widget$LikeView$ObjectType = new int[LikeView.ObjectType.values().length];

        static {
            try {
                $SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeView.ObjectType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void refreshStatusViaService() {
        LikeStatusClient likeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
        if (likeStatusClient.start()) {
            likeStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener() {
                /* class com.facebook.share.internal.LikeActionController.AnonymousClass10 */

                public void completed(Bundle bundle) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    if (bundle != null && bundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                        boolean z = bundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
                        if (bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                            str = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
                        } else {
                            str = LikeActionController.this.likeCountStringWithLike;
                        }
                        String str6 = str;
                        if (bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                            str2 = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
                        } else {
                            str2 = LikeActionController.this.likeCountStringWithoutLike;
                        }
                        String str7 = str2;
                        if (bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                            str3 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
                        } else {
                            str3 = LikeActionController.this.socialSentenceWithLike;
                        }
                        String str8 = str3;
                        if (bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                            str4 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
                        } else {
                            str4 = LikeActionController.this.socialSentenceWithoutLike;
                        }
                        String str9 = str4;
                        if (bundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                            str5 = bundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
                        } else {
                            str5 = LikeActionController.this.unlikeToken;
                        }
                        LikeActionController.this.updateState(z, str6, str7, str8, str9, str5);
                    }
                }
            });
        }
    }

    public void publishAgainIfNeeded(Bundle bundle) {
        boolean z = this.isObjectLiked;
        if (z != this.isObjectLikedOnServer && !publishLikeOrUnlikeAsync(z, bundle)) {
            publishDidError(!this.isObjectLiked);
        }
    }

    private void fetchVerifiedObjectId(final RequestCompletionCallback requestCompletionCallback) {
        if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
            final GetOGObjectIdRequestWrapper getOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(this.objectId, this.objectType);
            final GetPageIdRequestWrapper getPageIdRequestWrapper = new GetPageIdRequestWrapper(this.objectId, this.objectType);
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
            getOGObjectIdRequestWrapper.addToBatch(graphRequestBatch);
            getPageIdRequestWrapper.addToBatch(graphRequestBatch);
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                /* class com.facebook.share.internal.LikeActionController.AnonymousClass11 */

                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    FacebookRequestError facebookRequestError;
                    LikeActionController.this.verifiedObjectId = getOGObjectIdRequestWrapper.verifiedObjectId;
                    if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                        LikeActionController.this.verifiedObjectId = getPageIdRequestWrapper.verifiedObjectId;
                        LikeActionController.this.objectIsPage = getPageIdRequestWrapper.objectIsPage;
                    }
                    if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.objectId);
                        LikeActionController likeActionController = LikeActionController.this;
                        if (getPageIdRequestWrapper.getError() != null) {
                            facebookRequestError = getPageIdRequestWrapper.getError();
                        } else {
                            facebookRequestError = getOGObjectIdRequestWrapper.getError();
                        }
                        likeActionController.logAppEventForError("get_verified_id", facebookRequestError);
                    }
                    RequestCompletionCallback requestCompletionCallback = requestCompletionCallback;
                    if (requestCompletionCallback != null) {
                        requestCompletionCallback.onComplete();
                    }
                }
            });
            graphRequestBatch.executeAsync();
        } else if (requestCompletionCallback != null) {
            requestCompletionCallback.onComplete();
        }
    }

    public void logAppEventForError(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.objectId);
        bundle2.putString("object_type", this.objectType.toString());
        bundle2.putString("current_action", str);
        getAppEventsLogger().logEventImplicitly("fb_like_control_error", null, bundle2);
    }

    public void logAppEventForError(String str, FacebookRequestError facebookRequestError) {
        JSONObject requestResult;
        Bundle bundle = new Bundle();
        if (!(facebookRequestError == null || (requestResult = facebookRequestError.getRequestResult()) == null)) {
            bundle.putString("error", requestResult.toString());
        }
        logAppEventForError(str, bundle);
    }

    class GetOGObjectIdRequestWrapper extends AbstractRequestWrapper {
        String verifiedObjectId;

        GetOGObjectIdRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.error = null;
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
        }

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null && (optJSONObject = tryGetJSONObjectFromResponse.optJSONObject("og_object")) != null) {
                this.verifiedObjectId = optJSONObject.optString("id");
            }
        }
    }

    class GetPageIdRequestWrapper extends AbstractRequestWrapper {
        boolean objectIsPage;
        String verifiedObjectId;

        GetPageIdRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
        }

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                this.verifiedObjectId = tryGetJSONObjectFromResponse.optString("id");
                this.objectIsPage = !Utility.isNullOrEmpty(this.verifiedObjectId);
            }
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
        }
    }

    class PublishLikeRequestWrapper extends AbstractRequestWrapper {
        String unlikeToken;

        PublishLikeRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.POST));
        }

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
            this.unlikeToken = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), "id");
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == 3501) {
                this.error = null;
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_like", facebookRequestError);
        }
    }

    class PublishUnlikeRequestWrapper extends AbstractRequestWrapper {
        private String unlikeToken;

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
        }

        PublishUnlikeRequestWrapper(String str) {
            super(null, null);
            this.unlikeToken = str;
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.unlikeToken, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_unlike", facebookRequestError);
        }
    }

    class GetPageLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
        private String pageId;

        public String getUnlikeToken() {
            return null;
        }

        GetPageLikesRequestWrapper(String str) {
            super(str, LikeView.ObjectType.PAGE);
            this.pageId = str;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id");
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/".concat(String.valueOf(str)), bundle, HttpMethod.GET));
        }

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null && tryGetJSONArrayFromResponse.length() > 0) {
                this.objectIsLiked = true;
            }
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.pageId, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_page_like", facebookRequestError);
        }

        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }
    }

    class GetOGObjectLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private final String objectId;
        private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
        private final LikeView.ObjectType objectType;
        private String unlikeToken;

        GetOGObjectLikesRequestWrapper(String str, LikeView.ObjectType objectType2) {
            super(str, objectType2);
            this.objectId = str;
            this.objectType = objectType2;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", this.objectId);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.GET));
        }

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null) {
                for (int i = 0; i < tryGetJSONArrayFromResponse.length(); i++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.objectIsLiked = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (optJSONObject2 != null && AccessToken.isCurrentAccessTokenActive() && Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString("id"))) {
                            this.unlikeToken = optJSONObject.optString("id");
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_og_object_like", facebookRequestError);
        }

        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        public String getUnlikeToken() {
            return this.unlikeToken;
        }
    }

    class GetEngagementRequestWrapper extends AbstractRequestWrapper {
        String likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
        String likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
        String socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
        String socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;

        GetEngagementRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET));
        }

        /* access modifiers changed from: protected */
        public void processSuccess(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.likeCountStringWithLike = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.likeCountStringWithLike);
                this.likeCountStringWithoutLike = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
                this.socialSentenceStringWithLike = tryGetJSONObjectFromResponse.optString("social_sentence_with_like", this.socialSentenceStringWithLike);
                this.socialSentenceStringWithoutLike = tryGetJSONObjectFromResponse.optString("social_sentence_without_like", this.socialSentenceStringWithoutLike);
            }
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_engagement", facebookRequestError);
        }
    }

    abstract class AbstractRequestWrapper implements RequestWrapper {
        protected FacebookRequestError error;
        protected String objectId;
        protected LikeView.ObjectType objectType;
        private GraphRequest request;

        /* access modifiers changed from: protected */
        public abstract void processSuccess(GraphResponse graphResponse);

        protected AbstractRequestWrapper(String str, LikeView.ObjectType objectType2) {
            this.objectId = str;
            this.objectType = objectType2;
        }

        public void addToBatch(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.request);
        }

        public FacebookRequestError getError() {
            return this.error;
        }

        /* access modifiers changed from: protected */
        public void setRequest(GraphRequest graphRequest) {
            this.request = graphRequest;
            graphRequest.setVersion(FacebookSdk.getGraphApiVersion());
            graphRequest.setCallback(new GraphRequest.Callback() {
                /* class com.facebook.share.internal.LikeActionController.AbstractRequestWrapper.AnonymousClass1 */

                public void onCompleted(GraphResponse graphResponse) {
                    AbstractRequestWrapper.this.error = graphResponse.getError();
                    if (AbstractRequestWrapper.this.error != null) {
                        AbstractRequestWrapper abstractRequestWrapper = AbstractRequestWrapper.this;
                        abstractRequestWrapper.processError(abstractRequestWrapper.error);
                        return;
                    }
                    AbstractRequestWrapper.this.processSuccess(graphResponse);
                }
            });
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
        }
    }

    static class MRUCacheWorkItem implements Runnable {
        private static ArrayList<String> mruCachedItems = new ArrayList<>();
        private String cacheItem;
        private boolean shouldTrim;

        MRUCacheWorkItem(String str, boolean z) {
            this.cacheItem = str;
            this.shouldTrim = z;
        }

        public void run() {
            String str = this.cacheItem;
            if (str != null) {
                mruCachedItems.remove(str);
                mruCachedItems.add(0, this.cacheItem);
            }
            if (this.shouldTrim && mruCachedItems.size() >= 128) {
                while (64 < mruCachedItems.size()) {
                    ArrayList<String> arrayList = mruCachedItems;
                    LikeActionController.cache.remove(arrayList.remove(arrayList.size() - 1));
                }
            }
        }
    }

    static class SerializeToDiskWorkItem implements Runnable {
        private String cacheKey;
        private String controllerJson;

        SerializeToDiskWorkItem(String str, String str2) {
            this.cacheKey = str;
            this.controllerJson = str2;
        }

        public void run() {
            LikeActionController.serializeToDiskSynchronously(this.cacheKey, this.controllerJson);
        }
    }

    static class CreateLikeActionControllerWorkItem implements Runnable {
        private CreationCallback callback;
        private String objectId;
        private LikeView.ObjectType objectType;

        CreateLikeActionControllerWorkItem(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
            this.objectId = str;
            this.objectType = objectType2;
            this.callback = creationCallback;
        }

        public void run() {
            LikeActionController.createControllerForObjectIdAndType(this.objectId, this.objectType, this.callback);
        }
    }
}
