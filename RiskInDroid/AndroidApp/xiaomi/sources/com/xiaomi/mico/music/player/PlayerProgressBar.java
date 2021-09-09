package com.xiaomi.mico.music.player;

import _m_j.hxi;
import _m_j.jgc;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.PlayerStatusTrack;

public class PlayerProgressBar extends RelativeLayout implements PlayerStatusTrack.onTrackListener {
    @BindView(6811)
    TextView mEndTime;
    @BindView(6812)
    TextView mInitTime;
    public boolean mIsDragging;
    public Runnable mProgressUpdateRunnable = new Runnable() {
        /* class com.xiaomi.mico.music.player.PlayerProgressBar.AnonymousClass1 */

        public void run() {
            if (!PlayerProgressBar.this.mIsDragging) {
                PlayerProgressBar.this.updateProgress();
            }
            PlayerProgressBar.this.mSeekBar.postDelayed(PlayerProgressBar.this.mProgressUpdateRunnable, 1000);
        }
    };
    @BindView(6819)
    SeekBar mSeekBar;
    private int mStatus = -1;

    public PlayerProgressBar(Context context) {
        super(context);
    }

    public PlayerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        this.mInitTime.setText(CommonUtils.secondToTime(0));
        this.mEndTime.setText(CommonUtils.secondToTime(0));
        this.mSeekBar.setMax(1000);
        this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.xiaomi.mico.music.player.PlayerProgressBar.AnonymousClass2 */

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                long playingDuration = PlayerProgressBar.this.getPlayingDuration();
                if (playingDuration > 0) {
                    int i2 = (int) ((((long) i) * playingDuration) / 1000);
                    PlayerProgressBar.this.notifyUpdatePlayerPosition(i2, z);
                    if (z) {
                        PlayerProgressBar.this.mInitTime.setText(CommonUtils.secondToTime((long) (i2 / 1000)));
                    }
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                PlayerProgressBar.this.mIsDragging = true;
                hxi.O00000o.f952O000000o.O000000o("content_playpage_progress", new Object[0]);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                PlayerProgressBar playerProgressBar = PlayerProgressBar.this;
                playerProgressBar.mIsDragging = false;
                long playingDuration = playerProgressBar.getPlayingDuration();
                if (playingDuration > 0) {
                    PlayerManager.getInstance().setPosition((long) ((int) ((((long) seekBar.getProgress()) * playingDuration) / 1000)), null);
                }
            }
        });
    }

    public void updatePlayerStatus(int i) {
        this.mStatus = i;
        if (this.mStatus == 1) {
            startProgress();
        } else {
            stopProgress();
        }
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        PlayerStatusTrack.getInstance().register(this);
        if (this.mStatus == 1) {
            startProgress();
        }
    }

    /* access modifiers changed from: package-private */
    public void onPause() {
        PlayerStatusTrack.getInstance().unregister(this);
        this.mStatus = -1;
        stopProgress();
    }

    private void startProgress() {
        stopProgress();
        this.mSeekBar.post(this.mProgressUpdateRunnable);
    }

    private void stopProgress() {
        this.mSeekBar.removeCallbacks(this.mProgressUpdateRunnable);
    }

    public void updateProgress() {
        long playingPosition = getPlayingPosition();
        long playingDuration = getPlayingDuration();
        this.mInitTime.setText(CommonUtils.secondToTime(playingPosition / 1000));
        this.mEndTime.setText(CommonUtils.secondToTime(playingDuration / 1000));
        if (playingDuration > 0) {
            this.mSeekBar.setProgress((int) ((playingPosition * 1000) / playingDuration));
        } else {
            this.mSeekBar.setProgress(0);
        }
    }

    private long getPlayingPosition() {
        Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
        if (playerStatus == null || playerStatus.play_song_detail == null) {
            return 0;
        }
        return playerStatus.play_song_detail.position;
    }

    public long getPlayingDuration() {
        Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
        if (playerStatus == null || playerStatus.play_song_detail == null) {
            return 0;
        }
        return playerStatus.play_song_detail.duration;
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            updateProgress();
            updatePlayerStatus(playerStatus.status);
            setVisibility(0);
        } else if (MusicHelper.isPlayingSong(playerStatus.media_type) || MusicHelper.isPlayingStation(playerStatus.media_type)) {
            updateProgress();
            updatePlayerStatus(playerStatus.status);
            setVisibility(0);
        } else {
            setVisibility(4);
        }
    }

    public void notifyUpdatePlayerPosition(int i, boolean z) {
        jgc.O000000o().O00000o(new MusicEvent.PlayerPositionEvent(i, z));
    }
}
