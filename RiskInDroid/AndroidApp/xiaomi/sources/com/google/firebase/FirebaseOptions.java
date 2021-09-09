package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions {
    /* access modifiers changed from: private */
    public final String zzr;
    /* access modifiers changed from: private */
    public final String zzs;
    /* access modifiers changed from: private */
    public final String zzt;
    /* access modifiers changed from: private */
    public final String zzu;
    /* access modifiers changed from: private */
    public final String zzv;
    /* access modifiers changed from: private */
    public final String zzw;
    /* access modifiers changed from: private */
    public final String zzx;

    public static final class Builder {
        private String zzr;
        private String zzs;
        private String zzt;
        private String zzu;
        private String zzv;
        private String zzw;
        private String zzx;

        public Builder() {
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.zzs = firebaseOptions.zzs;
            this.zzr = firebaseOptions.zzr;
            this.zzt = firebaseOptions.zzt;
            this.zzu = firebaseOptions.zzu;
            this.zzv = firebaseOptions.zzv;
            this.zzw = firebaseOptions.zzw;
            this.zzx = firebaseOptions.zzx;
        }

        public final FirebaseOptions build() {
            return new FirebaseOptions(this.zzs, this.zzr, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx);
        }

        public final Builder setApiKey(String str) {
            this.zzr = Preconditions.checkNotEmpty(str, "ApiKey must be set.");
            return this;
        }

        public final Builder setApplicationId(String str) {
            this.zzs = Preconditions.checkNotEmpty(str, "ApplicationId must be set.");
            return this;
        }

        public final Builder setDatabaseUrl(String str) {
            this.zzt = str;
            return this;
        }

        public final Builder setGcmSenderId(String str) {
            this.zzv = str;
            return this;
        }

        public final Builder setProjectId(String str) {
            this.zzx = str;
            return this;
        }

        public final Builder setStorageBucket(String str) {
            this.zzw = str;
            return this;
        }
    }

    private FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.zzs = str;
        this.zzr = str2;
        this.zzt = str3;
        this.zzu = str4;
        this.zzv = str5;
        this.zzw = str6;
        this.zzx = str7;
    }

    public static FirebaseOptions fromResource(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return Objects.equal(this.zzs, firebaseOptions.zzs) && Objects.equal(this.zzr, firebaseOptions.zzr) && Objects.equal(this.zzt, firebaseOptions.zzt) && Objects.equal(this.zzu, firebaseOptions.zzu) && Objects.equal(this.zzv, firebaseOptions.zzv) && Objects.equal(this.zzw, firebaseOptions.zzw) && Objects.equal(this.zzx, firebaseOptions.zzx);
    }

    public final String getApiKey() {
        return this.zzr;
    }

    public final String getApplicationId() {
        return this.zzs;
    }

    public final String getDatabaseUrl() {
        return this.zzt;
    }

    public final String getGcmSenderId() {
        return this.zzv;
    }

    public final String getProjectId() {
        return this.zzx;
    }

    public final String getStorageBucket() {
        return this.zzw;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzs, this.zzr, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.zzs).add("apiKey", this.zzr).add("databaseUrl", this.zzt).add("gcmSenderId", this.zzv).add("storageBucket", this.zzw).add("projectId", this.zzx).toString();
    }
}
