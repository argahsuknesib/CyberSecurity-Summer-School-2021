package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

class AccessTokenCache {
    private final SharedPreferences sharedPreferences;
    private LegacyTokenHelper tokenCachingStrategy;
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;

    AccessTokenCache(SharedPreferences sharedPreferences2, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        this.sharedPreferences = sharedPreferences2;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    public AccessTokenCache() {
        this(FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new SharedPreferencesTokenCachingStrategyFactory());
    }

    public AccessToken load() {
        if (hasCachedAccessToken()) {
            return getCachedAccessToken();
        }
        if (!shouldCheckLegacyToken()) {
            return null;
        }
        AccessToken legacyAccessToken = getLegacyAccessToken();
        if (legacyAccessToken == null) {
            return legacyAccessToken;
        }
        save(legacyAccessToken);
        getTokenCachingStrategy().clear();
        return legacyAccessToken;
    }

    public void save(AccessToken accessToken) {
        Validate.notNull(accessToken, "accessToken");
        try {
            this.sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.toJSONObject().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public void clear() {
        this.sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
    }

    private boolean hasCachedAccessToken() {
        return this.sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private AccessToken getCachedAccessToken() {
        String string = this.sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string != null) {
            try {
                return AccessToken.createFromJSONObject(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private boolean shouldCheckLegacyToken() {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    private AccessToken getLegacyAccessToken() {
        Bundle load = getTokenCachingStrategy().load();
        if (load == null || !LegacyTokenHelper.hasTokenInformation(load)) {
            return null;
        }
        return AccessToken.createFromLegacyCache(load);
    }

    private LegacyTokenHelper getTokenCachingStrategy() {
        if (this.tokenCachingStrategy == null) {
            synchronized (this) {
                if (this.tokenCachingStrategy == null) {
                    this.tokenCachingStrategy = this.tokenCachingStrategyFactory.create();
                }
            }
        }
        return this.tokenCachingStrategy;
    }

    static class SharedPreferencesTokenCachingStrategyFactory {
        SharedPreferencesTokenCachingStrategyFactory() {
        }

        public LegacyTokenHelper create() {
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext());
        }
    }
}
