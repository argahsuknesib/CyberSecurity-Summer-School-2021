package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Arrays;
import java.util.List;

public final class zzb {
    private static final List<String> zzboj = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open");
    private static final List<String> zzbok = Arrays.asList("auto", "app", "am");
    private static final List<String> zzbol = Arrays.asList("_r", "_dbg");
    private static final List<String> zzbom = Arrays.asList((String[]) ArrayUtils.concat(AppMeasurement.UserProperty.zzadb, AppMeasurement.UserProperty.zzadc));
    private static final List<String> zzbon = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean zza(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.origin) == null || str.isEmpty()) {
            return false;
        }
        if ((conditionalUserProperty.value != null && zzka.zzf(conditionalUserProperty.value) == null) || !zzfd(str) || !zzfe(conditionalUserProperty.name)) {
            return false;
        }
        if ((conditionalUserProperty.name.equals("_ce1") || conditionalUserProperty.name.equals("_ce2")) && !str.equals("fcm") && !str.equals("frc")) {
            return false;
        }
        if (conditionalUserProperty.expiredEventName != null && (!zza(conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams) || !zzb(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
            return false;
        }
        if (conditionalUserProperty.triggeredEventName != null && (!zza(conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams) || !zzb(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
            return false;
        }
        if (conditionalUserProperty.timedOutEventName != null) {
            return zza(conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams) && zzb(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams);
        }
        return true;
    }

    public static boolean zza(String str, Bundle bundle) {
        if (zzboj.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        for (String containsKey : zzbol) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static AppMeasurement.ConditionalUserProperty zzb(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty2.mOrigin = conditionalUserProperty.origin;
        conditionalUserProperty2.mActive = conditionalUserProperty.active;
        conditionalUserProperty2.mCreationTimestamp = conditionalUserProperty.creationTimestamp;
        conditionalUserProperty2.mExpiredEventName = conditionalUserProperty.expiredEventName;
        if (conditionalUserProperty.expiredEventParams != null) {
            conditionalUserProperty2.mExpiredEventParams = new Bundle(conditionalUserProperty.expiredEventParams);
        }
        conditionalUserProperty2.mName = conditionalUserProperty.name;
        conditionalUserProperty2.mTimedOutEventName = conditionalUserProperty.timedOutEventName;
        if (conditionalUserProperty.timedOutEventParams != null) {
            conditionalUserProperty2.mTimedOutEventParams = new Bundle(conditionalUserProperty.timedOutEventParams);
        }
        conditionalUserProperty2.mTimeToLive = conditionalUserProperty.timeToLive;
        conditionalUserProperty2.mTriggeredEventName = conditionalUserProperty.triggeredEventName;
        if (conditionalUserProperty.triggeredEventParams != null) {
            conditionalUserProperty2.mTriggeredEventParams = new Bundle(conditionalUserProperty.triggeredEventParams);
        }
        conditionalUserProperty2.mTriggeredTimestamp = conditionalUserProperty.triggeredTimestamp;
        conditionalUserProperty2.mTriggerEventName = conditionalUserProperty.triggerEventName;
        conditionalUserProperty2.mTriggerTimeout = conditionalUserProperty.triggerTimeout;
        if (conditionalUserProperty.value != null) {
            conditionalUserProperty2.mValue = zzka.zzf(conditionalUserProperty.value);
        }
        return conditionalUserProperty2;
    }

    public static boolean zzb(String str, String str2, Bundle bundle) {
        String str3;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzfd(str) || bundle == null) {
            return false;
        }
        for (String containsKey : zzbol) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode == 101230 && str.equals("fdl")) {
                c = 1;
            }
        } else if (str.equals("fcm")) {
            c = 0;
        }
        if (c == 0) {
            str3 = "fcm_integration";
        } else if (c != 1) {
            return false;
        } else {
            str3 = "fdl_integration";
        }
        bundle.putString("_cis", str3);
        return true;
    }

    public static AnalyticsConnector.ConditionalUserProperty zzd(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty2 = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty2.origin = conditionalUserProperty.mOrigin;
        conditionalUserProperty2.active = conditionalUserProperty.mActive;
        conditionalUserProperty2.creationTimestamp = conditionalUserProperty.mCreationTimestamp;
        conditionalUserProperty2.expiredEventName = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            conditionalUserProperty2.expiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        conditionalUserProperty2.name = conditionalUserProperty.mName;
        conditionalUserProperty2.timedOutEventName = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            conditionalUserProperty2.timedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        conditionalUserProperty2.timeToLive = conditionalUserProperty.mTimeToLive;
        conditionalUserProperty2.triggeredEventName = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            conditionalUserProperty2.triggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        conditionalUserProperty2.triggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
        conditionalUserProperty2.triggerEventName = conditionalUserProperty.mTriggerEventName;
        conditionalUserProperty2.triggerTimeout = conditionalUserProperty.mTriggerTimeout;
        if (conditionalUserProperty.mValue != null) {
            conditionalUserProperty2.value = zzka.zzf(conditionalUserProperty.mValue);
        }
        return conditionalUserProperty2;
    }

    public static boolean zzfd(String str) {
        return !zzbok.contains(str);
    }

    public static boolean zzfe(String str) {
        if (zzbom.contains(str)) {
            return false;
        }
        for (String matches : zzbon) {
            if (str.matches(matches)) {
                return false;
            }
        }
        return true;
    }
}
