package com.facebook.messenger;

import java.util.List;

public class MessengerThreadParams {
    public final String metadata;
    public final Origin origin;
    public final List<String> participants;
    public final String threadToken;

    public enum Origin {
        REPLY_FLOW,
        COMPOSE_FLOW,
        UNKNOWN
    }

    public MessengerThreadParams(Origin origin2, String str, String str2, List<String> list) {
        this.threadToken = str;
        this.metadata = str2;
        this.participants = list;
        this.origin = origin2;
    }
}
