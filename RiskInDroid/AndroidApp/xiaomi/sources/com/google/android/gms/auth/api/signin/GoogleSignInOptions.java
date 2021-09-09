package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new GoogleSignInOptionsCreator();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES_LITE, new Scope[0]).build();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    @VisibleForTesting
    public static final Scope SCOPE_EMAIL = new Scope("email");
    @VisibleForTesting
    public static final Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    @VisibleForTesting
    public static final Scope SCOPE_GAMES_LITE = new Scope("https://www.googleapis.com/auth/games_lite");
    @VisibleForTesting
    public static final Scope SCOPE_OPEN_ID = new Scope("openid");
    @VisibleForTesting
    public static final Scope SCOPE_PROFILE = new Scope("profile");
    private static Comparator<Scope> zzaa = new zzb();
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getScopes", id = 2)
    public final ArrayList<Scope> zzr;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAccount", id = 3)
    public Account zzs;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    public boolean zzt;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    public final boolean zzu;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    public final boolean zzv;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    public String zzw;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getHostedDomain", id = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public String zzx;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    public ArrayList<GoogleSignInOptionsExtensionParcelable> zzy;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzz;

    public static final class Builder {
        private Set<Scope> mScopes = new HashSet();
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzab = new HashMap();
        private Account zzs;
        private boolean zzt;
        private boolean zzu;
        private boolean zzv;
        private String zzw;
        private String zzx;

        public Builder() {
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            Preconditions.checkNotNull(googleSignInOptions);
            this.mScopes = new HashSet(googleSignInOptions.zzr);
            this.zzu = googleSignInOptions.zzu;
            this.zzv = googleSignInOptions.zzv;
            this.zzt = googleSignInOptions.zzt;
            this.zzw = googleSignInOptions.zzw;
            this.zzs = googleSignInOptions.zzs;
            this.zzx = googleSignInOptions.zzx;
            this.zzab = GoogleSignInOptions.zza(googleSignInOptions.zzy);
        }

        private final String zza(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.zzw;
            Preconditions.checkArgument(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        public final Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.zzab.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                if (googleSignInOptionsExtension.getImpliedScopes() != null) {
                    this.mScopes.addAll(googleSignInOptionsExtension.getImpliedScopes());
                }
                this.zzab.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        public final GoogleSignInOptions build() {
            if (this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES) && this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES_LITE)) {
                this.mScopes.remove(GoogleSignInOptions.SCOPE_GAMES_LITE);
            }
            if (this.zzt && (this.zzs == null || !this.mScopes.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.mScopes), this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx, this.zzab, null);
        }

        public final Builder requestEmail() {
            this.mScopes.add(GoogleSignInOptions.SCOPE_EMAIL);
            return this;
        }

        public final Builder requestId() {
            this.mScopes.add(GoogleSignInOptions.SCOPE_OPEN_ID);
            return this;
        }

        public final Builder requestIdToken(String str) {
            this.zzt = true;
            this.zzw = zza(str);
            return this;
        }

        public final Builder requestPhatIdToken(String str) {
            return requestIdToken(str).requestProfile().requestEmail();
        }

        public final Builder requestProfile() {
            this.mScopes.add(GoogleSignInOptions.SCOPE_PROFILE);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.mScopes.add(scope);
            this.mScopes.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            this.zzu = true;
            this.zzw = zza(str);
            this.zzv = z;
            return this;
        }

        public final Builder setAccount(Account account) {
            this.zzs = (Account) Preconditions.checkNotNull(account);
            return this;
        }

        public final Builder setAccountName(String str) {
            this.zzs = new Account(Preconditions.checkNotEmpty(str), "com.google");
            return this;
        }

        public final Builder setHostedDomain(String str) {
            this.zzx = Preconditions.checkNotEmpty(str);
            return this;
        }
    }

    @SafeParcelable.Constructor
    GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, zza(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.versionCode = i;
        this.zzr = arrayList;
        this.zzs = account;
        this.zzt = z;
        this.zzu = z2;
        this.zzv = z3;
        this.zzw = str;
        this.zzx = str2;
        this.zzy = new ArrayList<>(map.values());
        this.zzz = map;
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, zzb zzb) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }

    public static GoogleSignInOptions fromJsonString(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    /* access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> zza(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.getType()), next);
        }
        return hashMap;
    }

    private final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzr, zzaa);
            ArrayList arrayList = this.zzr;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzs != null) {
                jSONObject.put("accountName", this.zzs.name);
            }
            jSONObject.put("idTokenRequested", this.zzt);
            jSONObject.put("forceCodeForRefreshToken", this.zzv);
            jSONObject.put("serverAuthRequested", this.zzu);
            if (!TextUtils.isEmpty(this.zzw)) {
                jSONObject.put("serverClientId", this.zzw);
            }
            if (!TextUtils.isEmpty(this.zzx)) {
                jSONObject.put("hostedDomain", this.zzx);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r3.zzs.equals(r4.getAccount()) != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        if (r3.zzw.equals(r4.getServerClientId()) != false) goto L_0x006b;
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzy.size() <= 0) {
                if (googleSignInOptions.zzy.size() <= 0) {
                    if (this.zzr.size() == googleSignInOptions.getScopes().size()) {
                        if (this.zzr.containsAll(googleSignInOptions.getScopes())) {
                            if (this.zzs == null) {
                                if (googleSignInOptions.getAccount() == null) {
                                }
                            }
                            if (TextUtils.isEmpty(this.zzw)) {
                                if (TextUtils.isEmpty(googleSignInOptions.getServerClientId())) {
                                }
                            }
                            return this.zzv == googleSignInOptions.isForceCodeForRefreshToken() && this.zzt == googleSignInOptions.isIdTokenRequested() && this.zzu == googleSignInOptions.isServerAuthCodeRequested();
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
    }

    public Account getAccount() {
        return this.zzs;
    }

    public GoogleSignInOptionsExtensionParcelable getExtension(@GoogleSignInOptionsExtension.TypeId int i) {
        return this.zzz.get(Integer.valueOf(i));
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zzy;
    }

    public String getHostedDomain() {
        return this.zzx;
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zzr;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zzr);
    }

    public String getServerClientId() {
        return this.zzw;
    }

    public boolean hasExtension(@GoogleSignInOptionsExtension.TypeId int i) {
        return this.zzz.containsKey(Integer.valueOf(i));
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zzr;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).getScopeUri());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().addObject(arrayList).addObject(this.zzs).addObject(this.zzw).addBoolean(this.zzv).addBoolean(this.zzt).addBoolean(this.zzu).hash();
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zzv;
    }

    public boolean isIdTokenRequested() {
        return this.zzt;
    }

    public boolean isServerAuthCodeRequested() {
        return this.zzu;
    }

    public String toJson() {
        return zza().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, getHostedDomain(), false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
