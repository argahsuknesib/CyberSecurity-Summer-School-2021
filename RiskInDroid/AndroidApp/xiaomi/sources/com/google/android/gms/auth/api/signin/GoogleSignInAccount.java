package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new GoogleSignInAccountCreator();
    @VisibleForTesting
    public static Clock sClock = DefaultClock.getInstance();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getId", id = 2)
    private String zze;
    @SafeParcelable.Field(getter = "getIdToken", id = 3)
    private String zzf;
    @SafeParcelable.Field(getter = "getEmail", id = 4)
    private String zzg;
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)
    private String zzh;
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 6)
    private Uri zzi;
    @SafeParcelable.Field(getter = "getServerAuthCode", id = 7)
    private String zzj;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    private long zzk;
    @SafeParcelable.Field(getter = "getObfuscatedIdentifier", id = 9)
    private String zzl;
    @SafeParcelable.Field(id = 10)
    private List<Scope> zzm;
    @SafeParcelable.Field(getter = "getGivenName", id = 11)
    private String zzn;
    @SafeParcelable.Field(getter = "getFamilyName", id = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    private String zzo;
    private Set<Scope> zzp = new HashSet();

    @SafeParcelable.Constructor
    GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Uri uri, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) long j, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List<Scope> list, @SafeParcelable.Param(id = 11) String str7, @SafeParcelable.Param(id = 12) String str8) {
        this.versionCode = i;
        this.zze = str;
        this.zzf = str2;
        this.zzg = str3;
        this.zzh = str4;
        this.zzi = uri;
        this.zzj = str5;
        this.zzk = j;
        this.zzl = str6;
        this.zzm = list;
        this.zzn = str7;
        this.zzo = str8;
    }

    public static GoogleSignInAccount create(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        return create(str, str2, str3, str4, null, null, uri, l, str5, set);
    }

    public static GoogleSignInAccount create(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l == null ? Long.valueOf(sClock.currentTimeMillis() / 1000) : l).longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    public static GoogleSignInAccount createDefault() {
        return zza(new Account("<<default account>>", "com.google"), new HashSet());
    }

    public static GoogleSignInAccount fromAccountAndScopes(Account account, Scope scope, Scope... scopeArr) {
        Preconditions.checkNotNull(account);
        Preconditions.checkNotNull(scope);
        HashSet hashSet = new HashSet();
        hashSet.add(scope);
        hashSet.addAll(Arrays.asList(scopeArr));
        return zza(account, hashSet);
    }

    public static GoogleSignInAccount fromJsonString(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return create(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).setServerAuthCode(jSONObject.optString("serverAuthCode", null));
    }

    private static GoogleSignInAccount zza(Account account, Set<Scope> set) {
        return create(null, null, account.name, null, null, null, null, 0L, account.name, set);
    }

    private final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzk);
            jSONObject.put("obfuscatedIdentifier", getObfuscatedIdentifier());
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.zzm.toArray(new Scope[this.zzm.size()]);
            Arrays.sort(scopeArr, zza.zzq);
            for (Scope scopeUri : scopeArr) {
                jSONArray.put(scopeUri.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.getObfuscatedIdentifier().equals(getObfuscatedIdentifier()) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
    }

    public Account getAccount() {
        String str = this.zzg;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String getDisplayName() {
        return this.zzh;
    }

    public String getEmail() {
        return this.zzg;
    }

    public long getExpirationTimeSecs() {
        return this.zzk;
    }

    public String getFamilyName() {
        return this.zzo;
    }

    public String getGivenName() {
        return this.zzn;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zzm);
    }

    public String getId() {
        return this.zze;
    }

    public String getIdToken() {
        return this.zzf;
    }

    public String getObfuscatedIdentifier() {
        return this.zzl;
    }

    public Uri getPhotoUrl() {
        return this.zzi;
    }

    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zzm);
        hashSet.addAll(this.zzp);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.zzj;
    }

    public int hashCode() {
        return ((getObfuscatedIdentifier().hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    public boolean isExpired() {
        return sClock.currentTimeMillis() / 1000 >= this.zzk - 300;
    }

    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.zzp, scopeArr);
        }
        return this;
    }

    public GoogleSignInAccount setServerAuthCode(String str) {
        this.zzj = str;
        return this;
    }

    public String toJson() {
        return zza().toString();
    }

    public String toJsonForStorage() {
        JSONObject zza = zza();
        zza.remove("serverAuthCode");
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, getExpirationTimeSecs());
        SafeParcelWriter.writeString(parcel, 9, getObfuscatedIdentifier(), false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
