package com.xiaomi.mico.music.player;

import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.CommonUtils;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

class PlayingRepair {
    public Remote.Response.PlayingData mPlayingData;
    private Subscription mSubscription;

    PlayingRepair() {
    }

    /* access modifiers changed from: package-private */
    public Remote.Response.PlayingData updatePlayingData(Remote.Response.PlayingData playingData, boolean z) {
        if (playingData == null) {
            this.mPlayingData = null;
            stopRepair();
            return null;
        }
        Remote.Response.PlayingData playingData2 = this.mPlayingData;
        if (playingData2 == null || !CommonUtils.equals(playingData2.getTrackingData(), playingData.getTrackingData())) {
            this.mPlayingData = playingData;
        } else {
            if (playingData.position > this.mPlayingData.position || playingData.position + 2000 < this.mPlayingData.position) {
                this.mPlayingData.position = playingData.position;
            }
            this.mPlayingData.duration = playingData.duration;
        }
        if (z) {
            Subscription subscription = this.mSubscription;
            if (subscription == null || subscription.isUnsubscribed()) {
                startRepair();
            }
        } else {
            stopRepair();
        }
        return this.mPlayingData;
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingData(Remote.Response.TrackData trackData, long j, long j2) {
        if (this.mPlayingData != null) {
            stopRepair();
            this.mPlayingData.update(trackData, j, j2);
            startRepair();
        }
    }

    /* access modifiers changed from: package-private */
    public void setPosition(long j) {
        Remote.Response.PlayingData playingData = this.mPlayingData;
        if (playingData != null && j <= playingData.duration) {
            this.mPlayingData.position = j;
            Subscription subscription = this.mSubscription;
            if (subscription != null && !subscription.isUnsubscribed()) {
                stopRepair();
                startRepair();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resetPlayingData() {
        stopRepair();
        this.mPlayingData = null;
    }

    /* access modifiers changed from: package-private */
    public void startRepair() {
        Subscription subscription = this.mSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            this.mSubscription = Observable.interval(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
                /* class com.xiaomi.mico.music.player.PlayingRepair.AnonymousClass1 */

                public void call(Long l) {
                    if (PlayingRepair.this.mPlayingData != null) {
                        PlayingRepair.this.mPlayingData.position += 500;
                        if (PlayingRepair.this.mPlayingData.duration > 0 && PlayingRepair.this.mPlayingData.position > PlayingRepair.this.mPlayingData.duration) {
                            PlayingRepair.this.mPlayingData.position = PlayingRepair.this.mPlayingData.duration;
                        }
                    }
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.music.player.PlayingRepair.AnonymousClass2 */

                public void call(Throwable th) {
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void stopRepair() {
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
    }
}
