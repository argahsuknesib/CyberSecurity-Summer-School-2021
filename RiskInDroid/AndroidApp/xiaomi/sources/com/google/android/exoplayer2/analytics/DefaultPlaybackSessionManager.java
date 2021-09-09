package com.google.android.exoplayer2.analytics;

import android.util.Base64;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Supplier;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    public static final Supplier<String> DEFAULT_SESSION_ID_GENERATOR = $$Lambda$DefaultPlaybackSessionManager$wo7Env8Gf7Dk7wiBvx8S78XsvC8.INSTANCE;
    private static final Random RANDOM = new Random();
    private String currentSessionId;
    private Timeline currentTimeline;
    private PlaybackSessionManager.Listener listener;
    public final Timeline.Period period;
    private final Supplier<String> sessionIdGenerator;
    private final HashMap<String, SessionDescriptor> sessions;
    public final Timeline.Window window;

    public DefaultPlaybackSessionManager() {
        this(DEFAULT_SESSION_ID_GENERATOR);
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.sessionIdGenerator = supplier;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.sessions = new HashMap<>();
        this.currentTimeline = Timeline.EMPTY;
    }

    public final void setListener(PlaybackSessionManager.Listener listener2) {
        this.listener = listener2;
    }

    public final synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return getOrAddSession(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId).sessionId;
    }

    public final synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = this.sessions.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.maybeSetWindowSequenceNumber(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.belongsToSession(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        return;
     */
    public final synchronized void updateSessions(AnalyticsListener.EventTime eventTime) {
        Assertions.checkNotNull(this.listener);
        SessionDescriptor sessionDescriptor = this.sessions.get(this.currentSessionId);
        if (!(eventTime.mediaPeriodId == null || sessionDescriptor == null)) {
            boolean z = false;
            if (sessionDescriptor.windowSequenceNumber != -1 ? eventTime.mediaPeriodId.windowSequenceNumber < sessionDescriptor.windowSequenceNumber : sessionDescriptor.windowIndex != eventTime.windowIndex) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        SessionDescriptor orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
        if (this.currentSessionId == null) {
            this.currentSessionId = orAddSession.sessionId;
        }
        if (!orAddSession.isCreated) {
            orAddSession.isCreated = true;
            this.listener.onSessionCreated(eventTime, orAddSession.sessionId);
        }
        if (orAddSession.sessionId.equals(this.currentSessionId) && !orAddSession.isActive) {
            orAddSession.isActive = true;
            this.listener.onSessionActive(eventTime, orAddSession.sessionId);
        }
    }

    public final synchronized void handleTimelineUpdate(AnalyticsListener.EventTime eventTime) {
        Assertions.checkNotNull(this.listener);
        Timeline timeline = this.currentTimeline;
        this.currentTimeline = eventTime.timeline;
        Iterator<SessionDescriptor> it = this.sessions.values().iterator();
        while (it.hasNext()) {
            SessionDescriptor next = it.next();
            if (!next.tryResolvingToNewTimeline(timeline, this.currentTimeline)) {
                it.remove();
                if (next.isCreated) {
                    if (next.sessionId.equals(this.currentSessionId)) {
                        this.currentSessionId = null;
                    }
                    this.listener.onSessionFinished(eventTime, next.sessionId, false);
                }
            }
        }
        handlePositionDiscontinuity(eventTime, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    public final synchronized void handlePositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        boolean z;
        Iterator<SessionDescriptor> it;
        SessionDescriptor orAddSession;
        SessionDescriptor orAddSession2;
        Assertions.checkNotNull(this.listener);
        if (i != 0) {
            if (i != 3) {
                z = false;
                it = this.sessions.values().iterator();
                while (it.hasNext()) {
                    SessionDescriptor next = it.next();
                    if (next.isFinishedAtEventTime(eventTime)) {
                        it.remove();
                        if (next.isCreated) {
                            boolean equals = next.sessionId.equals(this.currentSessionId);
                            boolean z2 = z && equals && next.isActive;
                            if (equals) {
                                this.currentSessionId = null;
                            }
                            this.listener.onSessionFinished(eventTime, next.sessionId, z2);
                        }
                    }
                }
                SessionDescriptor sessionDescriptor = this.sessions.get(this.currentSessionId);
                orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
                this.currentSessionId = orAddSession.sessionId;
                if (!(eventTime.mediaPeriodId == null || !eventTime.mediaPeriodId.isAd() || (sessionDescriptor != null && sessionDescriptor.windowSequenceNumber == eventTime.mediaPeriodId.windowSequenceNumber && sessionDescriptor.adMediaPeriodId != null && sessionDescriptor.adMediaPeriodId.adGroupIndex == eventTime.mediaPeriodId.adGroupIndex && sessionDescriptor.adMediaPeriodId.adIndexInAdGroup == eventTime.mediaPeriodId.adIndexInAdGroup))) {
                    orAddSession2 = getOrAddSession(eventTime.windowIndex, new MediaSource.MediaPeriodId(eventTime.mediaPeriodId.periodUid, eventTime.mediaPeriodId.windowSequenceNumber));
                    if (orAddSession2.isCreated && orAddSession.isCreated) {
                        this.listener.onAdPlaybackStarted(eventTime, orAddSession2.sessionId, orAddSession.sessionId);
                    }
                }
            }
        }
        z = true;
        it = this.sessions.values().iterator();
        while (it.hasNext()) {
        }
        SessionDescriptor sessionDescriptor2 = this.sessions.get(this.currentSessionId);
        orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
        this.currentSessionId = orAddSession.sessionId;
        orAddSession2 = getOrAddSession(eventTime.windowIndex, new MediaSource.MediaPeriodId(eventTime.mediaPeriodId.periodUid, eventTime.mediaPeriodId.windowSequenceNumber));
        this.listener.onAdPlaybackStarted(eventTime, orAddSession2.sessionId, orAddSession.sessionId);
    }

    private SessionDescriptor getOrAddSession(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        SessionDescriptor sessionDescriptor = null;
        long j = Long.MAX_VALUE;
        for (SessionDescriptor next : this.sessions.values()) {
            next.maybeSetWindowSequenceNumber(i, mediaPeriodId);
            if (next.belongsToSession(i, mediaPeriodId)) {
                long j2 = next.windowSequenceNumber;
                if (j2 == -1 || j2 < j) {
                    sessionDescriptor = next;
                    j = j2;
                } else if (!(j2 != j || ((SessionDescriptor) Util.castNonNull(sessionDescriptor)).adMediaPeriodId == null || next.adMediaPeriodId == null)) {
                    sessionDescriptor = next;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.sessionIdGenerator.get();
        SessionDescriptor sessionDescriptor2 = new SessionDescriptor(str, i, mediaPeriodId);
        this.sessions.put(str, sessionDescriptor2);
        return sessionDescriptor2;
    }

    /* access modifiers changed from: private */
    public static String generateDefaultSessionId() {
        byte[] bArr = new byte[12];
        RANDOM.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    final class SessionDescriptor {
        public MediaSource.MediaPeriodId adMediaPeriodId;
        public boolean isActive;
        public boolean isCreated;
        public final String sessionId;
        public int windowIndex;
        public long windowSequenceNumber;

        public SessionDescriptor(String str, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            long j;
            this.sessionId = str;
            this.windowIndex = i;
            if (mediaPeriodId == null) {
                j = -1;
            } else {
                j = mediaPeriodId.windowSequenceNumber;
            }
            this.windowSequenceNumber = j;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                this.adMediaPeriodId = mediaPeriodId;
            }
        }

        public final boolean tryResolvingToNewTimeline(Timeline timeline, Timeline timeline2) {
            this.windowIndex = resolveWindowIndexToNewTimeline(timeline, timeline2, this.windowIndex);
            if (this.windowIndex == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.adMediaPeriodId;
            if (mediaPeriodId != null && timeline2.getIndexOfPeriod(mediaPeriodId.periodUid) == -1) {
                return false;
            }
            return true;
        }

        public final boolean belongsToSession(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            return mediaPeriodId == null ? i == this.windowIndex : this.adMediaPeriodId == null ? !mediaPeriodId.isAd() && mediaPeriodId.windowSequenceNumber == this.windowSequenceNumber : mediaPeriodId.windowSequenceNumber == this.adMediaPeriodId.windowSequenceNumber && mediaPeriodId.adGroupIndex == this.adMediaPeriodId.adGroupIndex && mediaPeriodId.adIndexInAdGroup == this.adMediaPeriodId.adIndexInAdGroup;
        }

        public final void maybeSetWindowSequenceNumber(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.windowSequenceNumber == -1 && i == this.windowIndex && mediaPeriodId != null) {
                this.windowSequenceNumber = mediaPeriodId.windowSequenceNumber;
            }
        }

        public final boolean isFinishedAtEventTime(AnalyticsListener.EventTime eventTime) {
            if (this.windowSequenceNumber == -1) {
                return false;
            }
            if (eventTime.mediaPeriodId == null) {
                if (this.windowIndex != eventTime.windowIndex) {
                    return true;
                }
                return false;
            } else if (eventTime.mediaPeriodId.windowSequenceNumber > this.windowSequenceNumber) {
                return true;
            } else {
                if (this.adMediaPeriodId == null) {
                    return false;
                }
                int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
                int indexOfPeriod2 = eventTime.timeline.getIndexOfPeriod(this.adMediaPeriodId.periodUid);
                if (eventTime.mediaPeriodId.windowSequenceNumber < this.adMediaPeriodId.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                    return false;
                }
                if (indexOfPeriod > indexOfPeriod2) {
                    return true;
                }
                if (eventTime.mediaPeriodId.isAd()) {
                    int i = eventTime.mediaPeriodId.adGroupIndex;
                    int i2 = eventTime.mediaPeriodId.adIndexInAdGroup;
                    if (i > this.adMediaPeriodId.adGroupIndex || (i == this.adMediaPeriodId.adGroupIndex && i2 > this.adMediaPeriodId.adIndexInAdGroup)) {
                        return true;
                    }
                    return false;
                } else if (eventTime.mediaPeriodId.nextAdGroupIndex == -1 || eventTime.mediaPeriodId.nextAdGroupIndex > this.adMediaPeriodId.adGroupIndex) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        private int resolveWindowIndexToNewTimeline(Timeline timeline, Timeline timeline2, int i) {
            if (i < timeline.getWindowCount()) {
                timeline.getWindow(i, DefaultPlaybackSessionManager.this.window);
                for (int i2 = DefaultPlaybackSessionManager.this.window.firstPeriodIndex; i2 <= DefaultPlaybackSessionManager.this.window.lastPeriodIndex; i2++) {
                    int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
                    if (indexOfPeriod != -1) {
                        return timeline2.getPeriod(indexOfPeriod, DefaultPlaybackSessionManager.this.period).windowIndex;
                    }
                }
                return -1;
            } else if (i < timeline2.getWindowCount()) {
                return i;
            } else {
                return -1;
            }
        }
    }
}
