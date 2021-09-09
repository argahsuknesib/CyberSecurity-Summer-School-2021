package com.facebook.appevents;

enum FlushReason {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT
}
