package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.tasks.Task;

@Keep
public final class FirebaseAnalytics {
    private final zzgl zzacw;

    public static class Event {
        protected Event() {
        }
    }

    public static class Param {
        @Deprecated
        public static final String SIGN_UP_METHOD = "sign_up_method";

        protected Param() {
        }
    }

    public static class UserProperty {
        protected UserProperty() {
        }
    }

    public FirebaseAnalytics(zzgl zzgl) {
        Preconditions.checkNotNull(zzgl);
        this.zzacw = zzgl;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return zzgl.zzg(context).zzjs();
    }

    public final Task<String> getAppInstanceId() {
        return this.zzacw.zzfu().getAppInstanceId();
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zzacw.zzjr().logEvent(str, bundle);
    }

    public final void resetAnalyticsData() {
        this.zzacw.zzfu().resetAnalyticsData();
    }

    public final void setAnalyticsCollectionEnabled(boolean z) {
        this.zzacw.zzjr().setMeasurementEnabled(z);
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzacw.zzfy().setCurrentScreen(activity, str, str2);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzacw.zzjr().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzacw.zzjr().setSessionTimeoutDuration(j);
    }

    public final void setUserId(String str) {
        this.zzacw.zzjr().setUserPropertyInternal("app", "_id", str);
    }

    public final void setUserProperty(String str, String str2) {
        this.zzacw.zzjr().setUserProperty(str, str2);
    }
}
