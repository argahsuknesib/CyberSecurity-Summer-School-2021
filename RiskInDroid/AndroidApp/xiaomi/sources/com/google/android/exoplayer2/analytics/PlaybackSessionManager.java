package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaSource;

public interface PlaybackSessionManager {

    public interface Listener {
        void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2);

        void onSessionActive(AnalyticsListener.EventTime eventTime, String str);

        void onSessionCreated(AnalyticsListener.EventTime eventTime, String str);

        void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z);
    }

    boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str);

    String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId);

    void handlePositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i);

    void handleTimelineUpdate(AnalyticsListener.EventTime eventTime);

    void setListener(Listener listener);

    void updateSessions(AnalyticsListener.EventTime eventTime);
}
