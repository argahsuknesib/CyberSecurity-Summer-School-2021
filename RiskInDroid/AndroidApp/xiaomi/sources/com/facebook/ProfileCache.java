package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

final class ProfileCache {
    private final SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    ProfileCache() {
    }

    /* access modifiers changed from: package-private */
    public final Profile load() {
        String string = this.sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void save(Profile profile) {
        Validate.notNull(profile, "profile");
        JSONObject jSONObject = profile.toJSONObject();
        if (jSONObject != null) {
            this.sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
