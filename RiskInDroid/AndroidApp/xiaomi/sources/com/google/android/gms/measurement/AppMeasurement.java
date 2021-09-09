package com.google.android.gms.measurement;

import _m_j.o0O0OOO0;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzka;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;

@Deprecated
@Keep
public class AppMeasurement {
    private final zzgl zzacw;

    @KeepForSdk
    public static class ConditionalUserProperty {
        @KeepForSdk
        @Keep
        public boolean mActive;
        @KeepForSdk
        @Keep
        public String mAppId;
        @KeepForSdk
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @KeepForSdk
        @Keep
        public String mName;
        @KeepForSdk
        @Keep
        public String mOrigin;
        @KeepForSdk
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @KeepForSdk
        @Keep
        public String mTriggerEventName;
        @KeepForSdk
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @KeepForSdk
        @Keep
        public long mTriggeredTimestamp;
        @KeepForSdk
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                this.mValue = zzka.zzf(obj);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }

    @KeepForSdk
    public static final class Event extends FirebaseAnalytics.Event {
        public static final String[] zzacx = {"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};
        public static final String[] zzacy = {"_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep"};

        private Event() {
        }

        public static String zzak(String str) {
            return zzka.zza(str, zzacx, zzacy);
        }
    }

    @KeepForSdk
    public interface EventInterceptor {
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    @KeepForSdk
    public interface OnEventListener {
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @KeepForSdk
    public static final class Param extends FirebaseAnalytics.Param {
        public static final String[] zzacz = {"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection"};
        public static final String[] zzada = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac"};

        private Param() {
        }

        public static String zzak(String str) {
            return zzka.zza(str, zzacz, zzada);
        }
    }

    @KeepForSdk
    public static final class UserProperty extends FirebaseAnalytics.UserProperty {
        public static final String[] zzadb = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement"};
        public static final String[] zzadc = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte"};

        private UserProperty() {
        }

        public static String zzak(String str) {
            return zzka.zza(str, zzadb, zzadc);
        }
    }

    public AppMeasurement(zzgl zzgl) {
        Preconditions.checkNotNull(zzgl);
        this.zzacw = zzgl;
    }

    @Deprecated
    @Keep
    public static AppMeasurement getInstance(Context context) {
        return zzgl.zzg(context).zzjr();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzacw.zzft().beginAdUnitExposure(str);
    }

    @KeepForSdk
    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzacw.zzfu().clearConditionalUserProperty(str, str2, bundle);
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zzacw.zzfu().clearConditionalUserPropertyAs(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzacw.zzft().endAdUnitExposure(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzacw.zzgb().zzlb();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzacw.zzfu().zzja();
    }

    @KeepForSdk
    public Boolean getBoolean() {
        return this.zzacw.zzfu().zzjx();
    }

    @KeepForSdk
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zzacw.zzfu().getConditionalUserProperties(str, str2);
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zzacw.zzfu().getConditionalUserPropertiesAs(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        zzie zzkd = this.zzacw.zzfy().zzkd();
        if (zzkd != null) {
            return zzkd.zzaoi;
        }
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        zzie zzkd = this.zzacw.zzfy().zzkd();
        if (zzkd != null) {
            return zzkd.zzul;
        }
        return null;
    }

    @KeepForSdk
    public Double getDouble() {
        return this.zzacw.zzfu().zzka();
    }

    @Keep
    public String getGmpAppId() {
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzacw.zzge().zzim().zzg("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @KeepForSdk
    public Integer getInteger() {
        return this.zzacw.zzfu().zzjz();
    }

    @KeepForSdk
    public Long getLong() {
        return this.zzacw.zzfu().zzjy();
    }

    @KeepForSdk
    @Keep
    public int getMaxUserProperties(String str) {
        this.zzacw.zzfu();
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @KeepForSdk
    public String getString() {
        return this.zzacw.zzfu().zzhm();
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzacw.zzfu().getUserProperties(str, str2, z);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        List<zzjx> zzj = this.zzacw.zzfu().zzj(z);
        o0O0OOO0 o0o0ooo0 = new o0O0OOO0(zzj.size());
        for (zzjx next : zzj) {
            o0o0ooo0.put(next.name, next.getValue());
        }
        return o0o0ooo0;
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.zzacw.zzfu().getUserPropertiesAs(str, str2, str3, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzhk.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void
     arg types: [java.lang.String, java.lang.String, android.os.Bundle, int]
     candidates:
      com.google.android.gms.internal.measurement.zzhk.zza(java.lang.String, java.lang.String, long, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzhk.zza(java.lang.String, java.lang.String, java.lang.Object, long):void
      com.google.android.gms.internal.measurement.zzhk.zza(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void
      com.google.android.gms.internal.measurement.zzhk.zza(java.lang.String, java.lang.String, android.os.Bundle, long):void
      com.google.android.gms.internal.measurement.zzhk.zza(java.lang.String, java.lang.String, android.os.Bundle, boolean):void */
    public final void logEvent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().zza("app", str, bundle, true);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().logEvent(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.zzfu().zza(str, str2, bundle, j);
    }

    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzacw.zzfu().registerOnMeasurementEventListener(onEventListener);
    }

    @KeepForSdk
    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zzacw.zzfu().setConditionalUserProperty(conditionalUserProperty);
    }

    /* access modifiers changed from: protected */
    @Keep
    @VisibleForTesting
    public void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zzacw.zzfu().setConditionalUserPropertyAs(conditionalUserProperty);
    }

    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzacw.zzfu().setEventInterceptor(eventInterceptor);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zzacw.zzfu().setMeasurementEnabled(z);
    }

    public final void setMinimumSessionDuration(long j) {
        this.zzacw.zzfu().setMinimumSessionDuration(j);
    }

    public final void setSessionTimeoutDuration(long j) {
        this.zzacw.zzfu().setSessionTimeoutDuration(j);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String */
    public final void setUserProperty(String str, String str2) {
        int zzce = this.zzacw.zzgb().zzce(str);
        if (zzce != 0) {
            this.zzacw.zzgb();
            this.zzacw.zzgb().zza(zzce, "_ev", zzka.zza(str, 24, true), str != null ? str.length() : 0);
            return;
        }
        setUserPropertyInternal("app", str, str2);
    }

    @KeepForSdk
    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zzacw.zzfu().setUserProperty(str, str2, obj);
    }

    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzacw.zzfu().unregisterOnMeasurementEventListener(onEventListener);
    }
}
