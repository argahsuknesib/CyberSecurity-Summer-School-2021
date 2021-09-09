package com.google.android.gms.common.internal;

import _m_j.o0O0OOOo;
import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
public final class ClientSettings {
    private final Set<Scope> zzcv;
    private final int zzcx;
    private final View zzcy;
    private final String zzcz;
    private final String zzda;
    private final Set<Scope> zzrz;
    private final Account zzs;
    private final Map<Api<?>, OptionalApiSettings> zzsa;
    private final SignInOptions zzsb;
    private Integer zzsc;

    public static final class Builder {
        private int zzcx = 0;
        private View zzcy;
        private String zzcz;
        private String zzda;
        private Account zzs;
        private Map<Api<?>, OptionalApiSettings> zzsa;
        private SignInOptions zzsb = SignInOptions.DEFAULT;
        private o0O0OOOo<Scope> zzsd;

        public final Builder addAllRequiredScopes(Collection<Scope> collection) {
            if (this.zzsd == null) {
                this.zzsd = new o0O0OOOo<>();
            }
            this.zzsd.addAll(collection);
            return this;
        }

        public final Builder addRequiredScope(Scope scope) {
            if (this.zzsd == null) {
                this.zzsd = new o0O0OOOo<>();
            }
            this.zzsd.add(scope);
            return this;
        }

        public final ClientSettings build() {
            return new ClientSettings(this.zzs, this.zzsd, this.zzsa, this.zzcx, this.zzcy, this.zzcz, this.zzda, this.zzsb);
        }

        public final Builder setAccount(Account account) {
            this.zzs = account;
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.zzcx = i;
            return this;
        }

        public final Builder setOptionalApiSettingsMap(Map<Api<?>, OptionalApiSettings> map) {
            this.zzsa = map;
            return this;
        }

        public final Builder setRealClientClassName(String str) {
            this.zzda = str;
            return this;
        }

        public final Builder setRealClientPackageName(String str) {
            this.zzcz = str;
            return this;
        }

        public final Builder setSignInOptions(SignInOptions signInOptions) {
            this.zzsb = signInOptions;
            return this;
        }

        public final Builder setViewForPopups(View view) {
            this.zzcy = view;
            return this;
        }
    }

    public static final class OptionalApiSettings {
        public final Set<Scope> mScopes;

        public OptionalApiSettings(Set<Scope> set) {
            Preconditions.checkNotNull(set);
            this.mScopes = Collections.unmodifiableSet(set);
        }
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions) {
        this.zzs = account;
        this.zzcv = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zzsa = map == null ? Collections.EMPTY_MAP : map;
        this.zzcy = view;
        this.zzcx = i;
        this.zzcz = str;
        this.zzda = str2;
        this.zzsb = signInOptions;
        HashSet hashSet = new HashSet(this.zzcv);
        for (OptionalApiSettings optionalApiSettings : this.zzsa.values()) {
            hashSet.addAll(optionalApiSettings.mScopes);
        }
        this.zzrz = Collections.unmodifiableSet(hashSet);
    }

    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).buildClientSettings();
    }

    public final Account getAccount() {
        return this.zzs;
    }

    @Deprecated
    public final String getAccountName() {
        Account account = this.zzs;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public final Account getAccountOrDefault() {
        Account account = this.zzs;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> getAllRequestedScopes() {
        return this.zzrz;
    }

    public final Set<Scope> getApplicableScopes(Api<?> api) {
        OptionalApiSettings optionalApiSettings = this.zzsa.get(api);
        if (optionalApiSettings == null || optionalApiSettings.mScopes.isEmpty()) {
            return this.zzcv;
        }
        HashSet hashSet = new HashSet(this.zzcv);
        hashSet.addAll(optionalApiSettings.mScopes);
        return hashSet;
    }

    public final Integer getClientSessionId() {
        return this.zzsc;
    }

    public final int getGravityForPopups() {
        return this.zzcx;
    }

    public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings() {
        return this.zzsa;
    }

    public final String getRealClientClassName() {
        return this.zzda;
    }

    public final String getRealClientPackageName() {
        return this.zzcz;
    }

    public final Set<Scope> getRequiredScopes() {
        return this.zzcv;
    }

    public final SignInOptions getSignInOptions() {
        return this.zzsb;
    }

    public final View getViewForPopups() {
        return this.zzcy;
    }

    public final void setClientSessionId(Integer num) {
        this.zzsc = num;
    }
}
