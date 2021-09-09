package com.xiaomi.mico.common.event;

public class QQMusicAuthEvent {
    public boolean cancel;
    public boolean success;

    public static class QQMusicCancelLogin {
    }

    public static class QQMusicLogin {
    }

    public QQMusicAuthEvent(boolean z) {
        this.success = z;
    }
}
