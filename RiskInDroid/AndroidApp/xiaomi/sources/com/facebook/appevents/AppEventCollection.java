package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Set;

class AppEventCollection {
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    public synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        if (persistedEvents != null) {
            for (AccessTokenAppIdPair next : persistedEvents.keySet()) {
                SessionEventsState sessionEventsState = getSessionEventsState(next);
                for (AppEvent addEvent : persistedEvents.get(next)) {
                    sessionEventsState.addEvent(addEvent);
                }
            }
        }
    }

    public synchronized void addEvent(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        getSessionEventsState(accessTokenAppIdPair).addEvent(appEvent);
    }

    public synchronized Set<AccessTokenAppIdPair> keySet() {
        return this.stateMap.keySet();
    }

    public synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        return this.stateMap.get(accessTokenAppIdPair);
    }

    public synchronized int getEventCount() {
        int i;
        i = 0;
        for (SessionEventsState accumulatedEventCount : this.stateMap.values()) {
            i += accumulatedEventCount.getAccumulatedEventCount();
        }
        return i;
    }

    private synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
        if (sessionEventsState == null) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            sessionEventsState = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers(applicationContext), AppEventsLogger.getAnonymousAppDeviceGUID(applicationContext));
        }
        this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
        return sessionEventsState;
    }
}
