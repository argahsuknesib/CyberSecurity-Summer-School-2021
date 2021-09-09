package com.google.firebase.analytics.connector.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;

public interface Adapter {
    AnalyticsConnector.AnalyticsConnectorListener getListener();
}
