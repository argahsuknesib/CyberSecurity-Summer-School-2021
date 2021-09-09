package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Map;

public interface AnalyticsConnector {

    @KeepForSdk
    public interface AnalyticsConnectorHandle {
        @KeepForSdk
        void unregister();
    }

    @KeepForSdk
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void onMessageTriggered(int i, Bundle bundle);
    }

    @KeepForSdk
    public static class ConditionalUserProperty {
        @KeepForSdk
        public boolean active;
        @KeepForSdk
        public long creationTimestamp;
        @KeepForSdk
        public String expiredEventName;
        @KeepForSdk
        public Bundle expiredEventParams;
        @KeepForSdk
        public String name;
        @KeepForSdk
        public String origin;
        @KeepForSdk
        public long timeToLive;
        @KeepForSdk
        public String timedOutEventName;
        @KeepForSdk
        public Bundle timedOutEventParams;
        @KeepForSdk
        public String triggerEventName;
        @KeepForSdk
        public long triggerTimeout;
        @KeepForSdk
        public String triggeredEventName;
        @KeepForSdk
        public Bundle triggeredEventParams;
        @KeepForSdk
        public long triggeredTimestamp;
        @KeepForSdk
        public Object value;
    }

    @KeepForSdk
    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    @KeepForSdk
    List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2);

    @KeepForSdk
    int getMaxUserProperties(String str);

    @KeepForSdk
    Map<String, Object> getUserProperties(boolean z);

    @KeepForSdk
    void logEvent(String str, String str2, Bundle bundle);

    @KeepForSdk
    AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnectorListener analyticsConnectorListener);

    @KeepForSdk
    void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty);

    @KeepForSdk
    void setUserProperty(String str, String str2, Object obj);
}
