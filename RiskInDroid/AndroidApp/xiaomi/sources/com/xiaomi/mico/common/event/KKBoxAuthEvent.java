package com.xiaomi.mico.common.event;

import android.net.Uri;

public class KKBoxAuthEvent {
    public boolean success;

    public static KKBoxAuthEvent completeEvent(Uri uri) {
        KKBoxAuthEvent kKBoxAuthEvent = new KKBoxAuthEvent();
        if (uri != null) {
            if ("fail".equalsIgnoreCase(uri.getQueryParameter("status"))) {
                kKBoxAuthEvent.success = false;
            } else {
                kKBoxAuthEvent.success = true;
            }
        }
        return kKBoxAuthEvent;
    }

    static KKBoxAuthEvent cancelEvent() {
        KKBoxAuthEvent kKBoxAuthEvent = new KKBoxAuthEvent();
        kKBoxAuthEvent.success = false;
        return kKBoxAuthEvent;
    }

    static KKBoxAuthEvent successEvent() {
        KKBoxAuthEvent kKBoxAuthEvent = new KKBoxAuthEvent();
        kKBoxAuthEvent.success = true;
        return kKBoxAuthEvent;
    }
}
