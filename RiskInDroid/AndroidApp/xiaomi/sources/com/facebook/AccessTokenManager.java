package com.facebook;

import _m_j.ft;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AccessTokenManager {
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final ft localBroadcastManager;
    public AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    AccessTokenManager(ft ftVar, AccessTokenCache accessTokenCache2) {
        Validate.notNull(ftVar, "localBroadcastManager");
        Validate.notNull(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = ftVar;
        this.accessTokenCache = accessTokenCache2;
    }

    static AccessTokenManager getInstance() {
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                if (instance == null) {
                    instance = new AccessTokenManager(ft.O000000o(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: package-private */
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    /* access modifiers changed from: package-private */
    public final boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
    }

    /* access modifiers changed from: package-private */
    public final void currentAccessTokenChanged() {
        AccessToken accessToken = this.currentAccessToken;
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken, accessToken);
    }

    private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.localBroadcastManager.O000000o(intent);
    }

    private void setTokenExpirationBroadcastAlarm() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken2 = AccessToken.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (AccessToken.isCurrentAccessTokenActive() && currentAccessToken2.getExpires() != null && alarmManager != null) {
            Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            try {
                alarmManager.set(1, currentAccessToken2.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 0));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken(null);
        }
    }

    private boolean shouldExtendAccessToken() {
        if (this.currentAccessToken == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (!this.currentAccessToken.getSource().canExtendToken() || valueOf.longValue() - this.lastAttemptedTokenExtendDate.getTime() <= 3600000 || valueOf.longValue() - this.currentAccessToken.getLastRefresh().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, HttpMethod.GET, callback);
    }

    static class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;

        private RefreshResult() {
        }
    }

    /* access modifiers changed from: package-private */
    public final void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.facebook.AccessTokenManager.AnonymousClass1 */

                public void run() {
                    AccessTokenManager.this.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
                }
            });
        }
    }

    public final void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
        AccessToken accessToken = this.currentAccessToken;
        if (accessToken == null) {
            if (accessTokenRefreshCallback2 != null) {
                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            AnonymousClass2 r8 = r0;
            final HashSet hashSet4 = hashSet;
            final HashSet hashSet5 = hashSet2;
            HashSet hashSet6 = hashSet2;
            final HashSet hashSet7 = hashSet3;
            AnonymousClass2 r0 = new GraphRequest.Callback() {
                /* class com.facebook.AccessTokenManager.AnonymousClass2 */

                public void onCompleted(GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                        atomicBoolean2.set(true);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("permission");
                                String optString2 = optJSONObject.optString("status");
                                if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                                    String lowerCase = optString2.toLowerCase(Locale.US);
                                    if (lowerCase.equals("granted")) {
                                        hashSet4.add(optString);
                                    } else if (lowerCase.equals("declined")) {
                                        hashSet5.add(optString);
                                    } else if (lowerCase.equals("expired")) {
                                        hashSet7.add(optString);
                                    } else {
                                        Log.w("AccessTokenManager", "Unexpected status: ".concat(String.valueOf(lowerCase)));
                                    }
                                }
                            }
                        }
                    }
                }
            };
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, r8), createExtendAccessTokenRequest(accessToken, new GraphRequest.Callback() {
                /* class com.facebook.AccessTokenManager.AnonymousClass3 */

                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null) {
                        refreshResult.accessToken = jSONObject.optString("access_token");
                        refreshResult.expiresAt = jSONObject.optInt("expires_at");
                        refreshResult.dataAccessExpirationTime = Long.valueOf(jSONObject.optLong("data_access_expiration_time"));
                    }
                }
            }));
            final AccessToken accessToken2 = accessToken;
            final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback3 = accessTokenRefreshCallback;
            final AtomicBoolean atomicBoolean3 = atomicBoolean;
            final RefreshResult refreshResult2 = refreshResult;
            final HashSet hashSet8 = hashSet;
            final HashSet hashSet9 = hashSet6;
            final HashSet hashSet10 = hashSet3;
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                /* class com.facebook.AccessTokenManager.AnonymousClass4 */

                /* JADX WARNING: Unknown top exception splitter block from list: {B:51:0x0107=Splitter:B:51:0x0107, B:18:0x004f=Splitter:B:18:0x004f} */
                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    AccessToken accessToken;
                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback;
                    String str;
                    Set<String> set;
                    Set<String> set2;
                    Set<String> set3;
                    Date date;
                    Date date2;
                    try {
                        if (AccessTokenManager.getInstance().getCurrentAccessToken() != null) {
                            if (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() == accessToken2.getUserId()) {
                                if (!atomicBoolean3.get() && refreshResult2.accessToken == null && refreshResult2.expiresAt == 0) {
                                    if (accessTokenRefreshCallback3 != null) {
                                        accessTokenRefreshCallback3.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                                    }
                                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                }
                                if (refreshResult2.accessToken != null) {
                                    str = refreshResult2.accessToken;
                                } else {
                                    str = accessToken2.getToken();
                                }
                                String str2 = str;
                                String applicationId = accessToken2.getApplicationId();
                                String userId = accessToken2.getUserId();
                                if (atomicBoolean3.get()) {
                                    set = hashSet8;
                                } else {
                                    set = accessToken2.getPermissions();
                                }
                                Set<String> set4 = set;
                                if (atomicBoolean3.get()) {
                                    set2 = hashSet9;
                                } else {
                                    set2 = accessToken2.getDeclinedPermissions();
                                }
                                Set<String> set5 = set2;
                                if (atomicBoolean3.get()) {
                                    set3 = hashSet10;
                                } else {
                                    set3 = accessToken2.getExpiredPermissions();
                                }
                                Set<String> set6 = set3;
                                AccessTokenSource source = accessToken2.getSource();
                                if (refreshResult2.expiresAt != 0) {
                                    date = new Date(((long) refreshResult2.expiresAt) * 1000);
                                } else {
                                    date = accessToken2.getExpires();
                                }
                                Date date3 = new Date();
                                if (refreshResult2.dataAccessExpirationTime != null) {
                                    date2 = new Date(1000 * refreshResult2.dataAccessExpirationTime.longValue());
                                } else {
                                    date2 = accessToken2.getDataAccessExpirationTime();
                                }
                                AccessToken accessToken2 = new AccessToken(str2, applicationId, userId, set4, set5, set6, source, date, date3, date2);
                                try {
                                    AccessTokenManager.getInstance().setCurrentAccessToken(accessToken2);
                                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback3;
                                    if (accessTokenRefreshCallback2 != null) {
                                        accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    accessToken = accessToken2;
                                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                    accessTokenRefreshCallback = accessTokenRefreshCallback3;
                                    if (!(accessTokenRefreshCallback == null || accessToken == null)) {
                                        accessTokenRefreshCallback.OnTokenRefreshed(accessToken);
                                    }
                                    throw th;
                                }
                            }
                        }
                        if (accessTokenRefreshCallback3 != null) {
                            accessTokenRefreshCallback3.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                        }
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                    } catch (Throwable th2) {
                        th = th2;
                        accessToken = null;
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                        accessTokenRefreshCallback = accessTokenRefreshCallback3;
                        accessTokenRefreshCallback.OnTokenRefreshed(accessToken);
                        throw th;
                    }
                }
            });
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback2 != null) {
            accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }
}
