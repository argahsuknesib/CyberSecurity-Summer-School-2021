package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
    public static final Parcelable.Creator<AccessToken> CREATOR = new Parcelable.Creator() {
        /* class com.facebook.AccessToken.AnonymousClass2 */

        public final AccessToken createFromParcel(Parcel parcel) {
            return new AccessToken(parcel);
        }

        public final AccessToken[] newArray(int i) {
            return new AccessToken[i];
        }
    };
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME;
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    private static final Date MAX_DATE;
    private final String applicationId;
    private final Date dataAccessExpirationTime;
    private final Set<String> declinedPermissions;
    private final Set<String> expiredPermissions;
    private final Date expires;
    private final Date lastRefresh;
    private final Set<String> permissions;
    private final AccessTokenSource source;
    private final String token;
    private final String userId;

    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    public final int describeContents() {
        return 0;
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        Validate.notNullOrEmpty(str, "accessToken");
        Validate.notNullOrEmpty(str2, "applicationId");
        Validate.notNullOrEmpty(str3, "userId");
        this.expires = date == null ? DEFAULT_EXPIRATION_TIME : date;
        this.permissions = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.declinedPermissions = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.expiredPermissions = Collections.unmodifiableSet(collection3 != null ? new HashSet(collection3) : new HashSet());
        this.token = str;
        this.source = accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource;
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = str2;
        this.userId = str3;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? DEFAULT_EXPIRATION_TIME : date3;
    }

    public static AccessToken getCurrentAccessToken() {
        return AccessTokenManager.getInstance().getCurrentAccessToken();
    }

    public static boolean isCurrentAccessTokenActive() {
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        return currentAccessToken != null && !currentAccessToken.isExpired();
    }

    public static boolean isDataAccessActive() {
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        return currentAccessToken != null && !currentAccessToken.isDataAccessExpired();
    }

    static void expireCurrentAccessToken() {
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken != null) {
            setCurrentAccessToken(createExpired(currentAccessToken));
        }
    }

    public static void setCurrentAccessToken(AccessToken accessToken) {
        AccessTokenManager.getInstance().setCurrentAccessToken(accessToken);
    }

    public static void refreshCurrentAccessTokenAsync() {
        AccessTokenManager.getInstance().refreshCurrentAccessToken(null);
    }

    public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessTokenManager.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
    }

    public final String getToken() {
        return this.token;
    }

    public final Date getExpires() {
        return this.expires;
    }

    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public final Set<String> getExpiredPermissions() {
        return this.expiredPermissions;
    }

    public final AccessTokenSource getSource() {
        return this.source;
    }

    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public static void createFromNativeLinkingIntent(Intent intent, final String str, final AccessTokenCreationCallback accessTokenCreationCallback) {
        Validate.notNull(intent, "intent");
        if (intent.getExtras() == null) {
            accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
            return;
        }
        final Bundle bundle = new Bundle(intent.getExtras());
        String string = bundle.getString("access_token");
        if (string == null || string.isEmpty()) {
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
            return;
        }
        String string2 = bundle.getString("user_id");
        if (string2 == null || string2.isEmpty()) {
            Utility.getGraphMeRequestWithCacheAsync(string, new Utility.GraphMeRequestWithCacheCallback() {
                /* class com.facebook.AccessToken.AnonymousClass1 */

                public final void onSuccess(JSONObject jSONObject) {
                    try {
                        bundle.putString("user_id", jSONObject.getString("id"));
                        accessTokenCreationCallback.onSuccess(AccessToken.createFromBundle(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
                    } catch (JSONException unused) {
                        accessTokenCreationCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                    }
                }

                public final void onFailure(FacebookException facebookException) {
                    accessTokenCreationCallback.onError(facebookException);
                }
            });
        } else {
            accessTokenCreationCallback.onSuccess(createFromBundle(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:");
        sb.append(tokenToString());
        appendPermissions(sb);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        return this.expires.equals(accessToken.expires) && this.permissions.equals(accessToken.permissions) && this.declinedPermissions.equals(accessToken.declinedPermissions) && this.expiredPermissions.equals(accessToken.expiredPermissions) && this.token.equals(accessToken.token) && this.source == accessToken.source && this.lastRefresh.equals(accessToken.lastRefresh) && ((str = this.applicationId) != null ? str.equals(accessToken.applicationId) : accessToken.applicationId == null) && this.userId.equals(accessToken.userId) && this.dataAccessExpirationTime.equals(accessToken.dataAccessExpirationTime);
    }

    public final int hashCode() {
        int hashCode = (((((((((((((this.expires.hashCode() + 527) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.expiredPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31;
        String str = this.applicationId;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode();
    }

    @SuppressLint({"FieldGetter"})
    static AccessToken createFromRefresh(AccessToken accessToken, Bundle bundle) {
        AccessToken accessToken2 = accessToken;
        Bundle bundle2 = bundle;
        if (accessToken2.source == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessToken2.source == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessToken2.source == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, "expires_in", new Date(0));
            String string = bundle2.getString("access_token");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, "data_access_expiration_time", new Date(0));
            if (Utility.isNullOrEmpty(string)) {
                return null;
            }
            return new AccessToken(string, accessToken2.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken2.source, bundleLongAsDate, new Date(), bundleLongAsDate2);
        }
        throw new FacebookException("Invalid token source: " + accessToken2.source);
    }

    static AccessToken createExpired(AccessToken accessToken) {
        return new AccessToken(accessToken.token, accessToken.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken.source, new Date(), new Date(), accessToken.dataAccessExpirationTime);
    }

    static AccessToken createFromLegacyCache(Bundle bundle) {
        List<String> permissionsFromBundle = getPermissionsFromBundle(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        List<String> permissionsFromBundle2 = getPermissionsFromBundle(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        List<String> permissionsFromBundle3 = getPermissionsFromBundle(bundle, "com.facebook.TokenCachingStrategy.ExpiredPermissions");
        String applicationId2 = LegacyTokenHelper.getApplicationId(bundle);
        if (Utility.isNullOrEmpty(applicationId2)) {
            applicationId2 = FacebookSdk.getApplicationId();
        }
        String str = applicationId2;
        String token2 = LegacyTokenHelper.getToken(bundle);
        try {
            return new AccessToken(token2, str, Utility.awaitGetGraphMeRequestWithCache(token2).getString("id"), permissionsFromBundle, permissionsFromBundle2, permissionsFromBundle3, LegacyTokenHelper.getSource(bundle), LegacyTokenHelper.getDate(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), LegacyTokenHelper.getDate(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"), null);
        } catch (JSONException unused) {
            return null;
        }
    }

    static List<String> getPermissionsFromBundle(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    public final boolean isExpired() {
        return new Date().after(this.expires);
    }

    public final boolean isDataAccessExpired() {
        return new Date().after(this.dataAccessExpirationTime);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.token);
        jSONObject.put("expires_at", this.expires.getTime());
        jSONObject.put("permissions", new JSONArray((Collection<?>) this.permissions));
        jSONObject.put("declined_permissions", new JSONArray((Collection<?>) this.declinedPermissions));
        jSONObject.put("expired_permissions", new JSONArray((Collection<?>) this.expiredPermissions));
        jSONObject.put("last_refresh", this.lastRefresh.getTime());
        jSONObject.put("source", this.source.name());
        jSONObject.put("application_id", this.applicationId);
        jSONObject.put("user_id", this.userId);
        jSONObject.put("data_access_expiration_time", this.dataAccessExpirationTime.getTime());
        return jSONObject;
    }

    static AccessToken createFromJSONObject(JSONObject jSONObject) throws JSONException {
        Collection collection;
        if (jSONObject.getInt("version") <= 1) {
            String string = jSONObject.getString("token");
            Date date = new Date(jSONObject.getLong("expires_at"));
            JSONArray jSONArray = jSONObject.getJSONArray("permissions");
            JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
            JSONArray optJSONArray = jSONObject.optJSONArray("expired_permissions");
            Date date2 = new Date(jSONObject.getLong("last_refresh"));
            AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString("source"));
            String string2 = jSONObject.getString("application_id");
            String string3 = jSONObject.getString("user_id");
            Date date3 = new Date(jSONObject.optLong("data_access_expiration_time", 0));
            List<String> jsonArrayToStringList = Utility.jsonArrayToStringList(jSONArray);
            List<String> jsonArrayToStringList2 = Utility.jsonArrayToStringList(jSONArray2);
            if (optJSONArray == null) {
                collection = new ArrayList();
            } else {
                collection = Utility.jsonArrayToStringList(optJSONArray);
            }
            return new AccessToken(string, string2, string3, jsonArrayToStringList, jsonArrayToStringList2, collection, valueOf, date, date2, date3);
        }
        throw new FacebookException("Unknown AccessToken serialization format.");
    }

    public static AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        String string = bundle.getString("access_token");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", date);
        String string2 = bundle.getString("user_id");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, "data_access_expiration_time", new Date(0));
        if (Utility.isNullOrEmpty(string) || bundleLongAsDate == null) {
            return null;
        }
        return new AccessToken(string, str, string2, list, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
    }

    private String tokenToString() {
        if (this.token == null) {
            return "null";
        }
        return FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.token : "ACCESS_TOKEN_REMOVED";
    }

    private void appendPermissions(StringBuilder sb) {
        sb.append(" permissions:");
        if (this.permissions == null) {
            sb.append("null");
            return;
        }
        sb.append("[");
        sb.append(TextUtils.join(", ", this.permissions));
        sb.append("]");
    }

    AccessToken(Parcel parcel) {
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.permissions = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.declinedPermissions = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.expiredPermissions = Collections.unmodifiableSet(new HashSet(arrayList));
        this.token = parcel.readString();
        this.source = AccessTokenSource.valueOf(parcel.readString());
        this.lastRefresh = new Date(parcel.readLong());
        this.applicationId = parcel.readString();
        this.userId = parcel.readString();
        this.dataAccessExpirationTime = new Date(parcel.readLong());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeStringList(new ArrayList(this.expiredPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
    }
}
