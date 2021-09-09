package com.xiaomi.mico.music.player;

import _m_j.gsy;
import _m_j.hxi;
import _m_j.jgc;
import _m_j.jgi;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.PlayerListManager;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class PlayerControler extends RelativeLayout implements PlayerStatusTrack.onTrackListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @BindView(6827)
    ImageView classification;
    private boolean invisible;
    @BindView(6808)
    ImageView mBackground;
    @BindView(6825)
    ImageView mCover;
    @BindView(6826)
    TextView mCp;
    private long mListID = -1;
    private int mMediaType = -1;
    @BindView(6830)
    TextView mName;
    @BindView(6831)
    ProgressBar mProgressBar;
    public Runnable mProgressUpdateRunnable = new Runnable() {
        /* class com.xiaomi.mico.music.player.PlayerControler.AnonymousClass1 */

        public void run() {
            PlayerControler.this.updateProgress();
            PlayerControler.this.mProgressBar.postDelayed(PlayerControler.this.mProgressUpdateRunnable, 1000);
        }
    };
    private List<Long> mSongList;
    @BindView(6833)
    ImageView mState;
    public Music.Station mStation;
    private int mStatus = -1;
    private Subscription mSubscription;
    private List<Remote.Response.TrackData> mTrackList = null;
    private Remote.Response.TrackData mTrackingData;
    private Remote.Response.PlayerStatus playerStatusOld;
    private boolean showing;

    public PlayerControler(Context context) {
        super(context);
    }

    public PlayerControler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerControler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        this.mProgressBar.setMax(1000);
        RxUtil.debounceClick(this, new Action1<Void>() {
            /* class com.xiaomi.mico.music.player.PlayerControler.AnonymousClass2 */

            public void call(Void voidR) {
                PlayerActivityV2.displayPlayerWithAnim(PlayerControler.this.getContext());
                hxi.O00000o.f952O000000o.O000000o("content_playbar_cover", new Object[0]);
            }
        });
        jgc.O000000o().O000000o(this);
    }

    public void showWithAnimation() {
        if (!this.showing && !this.invisible) {
            this.showing = true;
            getTranslationY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 200.0f, 0.0f);
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public void hideWithAnimation() {
        if (this.showing && !this.invisible) {
            this.showing = false;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, 200.0f);
            ofFloat.setDuration(500L);
            ofFloat.start();
        }
    }

    public void onResume() {
        PlayerStatusTrack.getInstance().register(this);
        if (this.mStatus == 1) {
            startProgress();
        }
    }

    public void onPause() {
        this.mStatus = -1;
        stopProgress();
    }

    public void onDestroy() {
        PlayerStatusTrack.getInstance().unregister(this);
        jgc.O000000o().O00000o0(this);
    }

    private void startProgress() {
        stopProgress();
        this.mProgressBar.post(this.mProgressUpdateRunnable);
    }

    private void stopProgress() {
        this.mProgressBar.removeCallbacks(this.mProgressUpdateRunnable);
    }

    @OnClick({6833, 6827})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.player_state) {
            PlayerManager.getInstance().playOrPause(null);
            hxi.O00000o.f952O000000o.O000000o("content_play_pause", new Object[0]);
        } else if (id == R.id.player_list) {
            PlayerListManager.shareInstance().popupPlayList(getContext());
            hxi.O00000o.f952O000000o.O000000o("content_play_list", new Object[0]);
        }
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        updatePlayerStatus(playerStatus);
    }

    public void updatePlayerStatus(Remote.Response.PlayerStatus playerStatus) {
        updatePlayPauseStatusAndProgress(playerStatus.status);
        Remote.Response.PlayingData playingData = playerStatus.play_song_detail;
        if (playingData == null) {
            updateMusic(playerStatus.media_type);
        } else if (MicoManager.getInstance().currentPlayingMicoIsAiProtocolV3()) {
            updateMusicV3(playerStatus, false);
        } else {
            boolean isPlayingSong = MusicHelper.isPlayingSong(playerStatus.media_type);
            boolean isPlayingStation = MusicHelper.isPlayingStation(playerStatus.media_type);
            boolean isPlayingDirective = MusicHelper.isPlayingDirective(playerStatus.media_type);
            if (isPlayingSong || isPlayingStation || isPlayingDirective) {
                updateMusic(playerStatus.media_type, playerStatus.list_id, playerStatus.track_list, playerStatus.extra_track_list, playingData.getTrackingData());
            } else {
                updateMusic(playerStatus.media_type);
            }
        }
        updateStatus(playerStatus);
    }

    private void updatePlayPauseStatusAndProgress(int i) {
        if (this.mStatus != i) {
            if (i == 1) {
                this.mState.setBackgroundResource(R.drawable.mico_icon_playcontroler_pause_selector);
                startProgress();
            } else {
                this.mState.setBackgroundResource(R.drawable.mico_icon_playcontroler_play_selector);
                stopProgress();
            }
            this.mStatus = i;
        }
        if (this.mStatus != 1) {
            updateProgress();
        }
    }

    private void updateStatus(Remote.Response.PlayerStatus playerStatus) {
        int i = 0;
        boolean z = this.mStatus == 0;
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            z = z || playerStatus.play_song_detail == null || playerStatus.track_list == null || playerStatus.track_list.isEmpty();
        }
        if (z) {
            i = 8;
        }
        setVisibility(i);
        if (z != this.invisible && !z) {
            showWithAnimation();
        }
        this.invisible = z;
    }

    public void updateMusicV3(Remote.Response.PlayerStatus playerStatus, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.playerStatusOld != null) {
            gsy.O00000Oo("PlayerControler", "V3 PlayerControler updateMusicV3 oldAudioId:" + this.playerStatusOld.play_song_detail.audio_id + " newAudioId:" + playerStatus.play_song_detail.audio_id);
            z4 = this.playerStatusOld.playingAudioIdChanged(playerStatus);
            int size = this.playerStatusOld.track_list != null ? this.playerStatusOld.track_list.size() : 0;
            if (playerStatus.track_list == null) {
                playerStatus.track_list = Collections.emptyList();
            }
            z3 = size != playerStatus.track_list.size() || !ContainerUtil.equals(this.playerStatusOld.track_list, playerStatus.track_list);
            z2 = PlayerManager.getInstance().isLoadMore(this.playerStatusOld.track_list, playerStatus.track_list);
        } else {
            z4 = true;
            z3 = true;
            z2 = false;
        }
        this.playerStatusOld = playerStatus;
        if (z3 || z) {
            PlayerListManager.shareInstance().updatePlaylistV3(playerStatus, z2);
        }
        if (z4 || z) {
            new Object[1][0] = "V3 PlayerControler 更新当前音乐信息 playerStatus.play_song_detail.audio_id " + playerStatus.play_song_detail.audio_id;
            getCurrentPlayingMusicV3(playerStatus);
        }
    }

    public void resetCachedPlayerStatus() {
        this.playerStatusOld = null;
        this.mMediaType = -1;
    }

    private void getCurrentPlayingMusicV3(Remote.Response.PlayerStatus playerStatus) {
        cancelSubscription();
        if (playerStatus.play_song_detail == null) {
            lambda$getCurrentPlayingMusicV3$0$PlayerControler(null);
        } else {
            this.mSubscription = MusicCache.getSong(playerStatus.play_song_detail.audio_id).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$PlayerControler$3e5nULuTW2NeAzliJ94zdkjXk6M */

                public final void call(Object obj) {
                    PlayerControler.this.lambda$getCurrentPlayingMusicV3$0$PlayerControler((Music.Song) obj);
                }
            }, new Action1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$PlayerControler$EWQDk7ocGB8s_t5T8I7yokdmI0c */

                public final void call(Object obj) {
                    PlayerControler.this.lambda$getCurrentPlayingMusicV3$1$PlayerControler((Throwable) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$getCurrentPlayingMusicV3$1$PlayerControler(Throwable th) {
        lambda$getCurrentPlayingMusicV3$0$PlayerControler(null);
    }

    private void updateMusic(int i) {
        updateMusic(i, -1, null, null, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    private void updateMusic(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2, Remote.Response.TrackData trackData) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (this.mMediaType != i) {
            this.mMediaType = i;
            z2 = true;
        } else {
            z2 = isListIDChanged(j) || isMusicListChanged(list) || !ContainerUtil.equals(this.mTrackList, list2);
            if (CommonUtils.equals(this.mTrackingData, trackData)) {
                z = false;
                if (z2) {
                    this.mListID = j;
                    this.mTrackList = list2;
                    this.mSongList = list;
                    notifyUpdatePlaylist(i, j, list, list2);
                }
                if (!z) {
                    this.mTrackingData = trackData;
                    updatePlayingMusic(i, trackData);
                    if (MusicHelper.isPlayingValid(trackData)) {
                        if (MusicHelper.isPlayingSong(i)) {
                            getSong(trackData.musicID);
                        } else if (MusicHelper.isPlayingDirective(i)) {
                            updatePlayingDirective(trackData.toDirective());
                        } else {
                            int playingStationType = MusicHelper.getPlayingStationType(i, -1);
                            if (playingStationType != -1) {
                                getStation(trackData.musicID, trackData.cpID, trackData.cpOrigin, playingStationType);
                            }
                        }
                        if (z3) {
                            lambda$getCurrentPlayingMusicV3$0$PlayerControler(null);
                            return;
                        }
                        return;
                    }
                    z3 = false;
                    if (z3) {
                    }
                } else {
                    return;
                }
            }
        }
        z = true;
        if (z2) {
        }
        if (!z) {
        }
    }

    private void getSong(final long j) {
        this.mSubscription = MusicCache.getSong(j).subscribe(new Action1<Music.Song>() {
            /* class com.xiaomi.mico.music.player.PlayerControler.AnonymousClass3 */

            public void call(Music.Song song) {
                if (j == PlayerControler.this.getPlayingSongID()) {
                    PlayerControler.this.lambda$getCurrentPlayingMusicV3$0$PlayerControler(song);
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.player.PlayerControler.AnonymousClass4 */

            public void call(Throwable th) {
                if (j == PlayerControler.this.getPlayingSongID()) {
                    PlayerControler.this.lambda$getCurrentPlayingMusicV3$0$PlayerControler(null);
                }
            }
        });
    }

    private void getStation(long j, final String str, String str2, int i) {
        cancelSubscription();
        this.mSubscription = ObservableApiHelper.getStationInfo(new Music.Station.Simple(j, str, str2, i)).subscribe(new Action1<Music.Station>() {
            /* class com.xiaomi.mico.music.player.PlayerControler.AnonymousClass5 */

            public void call(Music.Station station) {
                PlayerControler playerControler = PlayerControler.this;
                playerControler.mStation = station;
                if (CommonUtils.equals(str, playerControler.getPlayingStationID())) {
                    PlayerControler.this.lambda$getCurrentPlayingMusicV3$0$PlayerControler(station);
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.player.PlayerControler.AnonymousClass6 */

            public void call(Throwable th) {
                if (CommonUtils.equals(str, PlayerControler.this.getPlayingStationID())) {
                    PlayerControler.this.lambda$getCurrentPlayingMusicV3$0$PlayerControler(null);
                }
            }
        });
    }

    private boolean isListIDChanged(long j) {
        return (this.mListID > 0 || j > 0) && this.mListID != j;
    }

    private boolean isMusicListChanged(List<Long> list) {
        if (!ContainerUtil.hasData(list) || ContainerUtil.hasData(this.mSongList)) {
            return ContainerUtil.hasData(list) && ContainerUtil.hasData(this.mSongList) && list.size() != this.mSongList.size();
        }
        return true;
    }

    private void cancelSubscription() {
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
    }

    public long getPlayingSongID() {
        return MusicHelper.getPlayingSongID(this.mMediaType, this.mTrackingData);
    }

    public String getPlayingStationID() {
        return MusicHelper.getPlayingStationID(this.mMediaType, this.mTrackingData);
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingMusic(int i, Remote.Response.TrackData trackData) {
        if ("s6".equals(MicoManager.getInstance().getCurrentMicoType()) && trackData != null && trackData.title != null && trackData.title.startsWith("file:")) {
            String str = trackData.title;
            this.mName.setText(str.substring(str.lastIndexOf("/") + 1, str.length()));
        }
        PlayerListManager.shareInstance().updatePlayingMusic(i, trackData);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: updatePlayingMusic */
    public void lambda$getCurrentPlayingMusicV3$0$PlayerControler(Serializable serializable) {
        if (!"s6".equals(MicoManager.getInstance().getCurrentMicoType()) || !TextUtils.isEmpty(MusicHelper.getTitle(serializable))) {
            loadPlayerCover(MusicHelper.getCover(serializable));
            CharSequence title = MusicHelper.getTitle(serializable);
            if (!TextUtils.isEmpty(title)) {
                this.mName.setText(title);
            } else {
                this.mName.setText((int) R.string.mico_music_directive_default_title);
            }
            String artistName = serializable instanceof Music.Song ? ((Music.Song) serializable).getArtistName() : null;
            String cpName = MusicHelper.getCpName(serializable);
            if (TextUtils.isEmpty(artistName)) {
                this.mCp.setText(cpName);
            } else if (!TextUtils.isEmpty(cpName)) {
                this.mCp.setText(artistName.concat(" - ").concat(cpName));
            } else {
                this.mCp.setText(artistName);
            }
            PlayerListManager.shareInstance().updatePlayingMusic(serializable);
            return;
        }
        gsy.O000000o(3, "ControlBar", "s6 local, use trackingData");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, int, com.xiaomi.mico.common.transformation.CropSquareTransformation]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void */
    private void loadPlayerCover(String str) {
        MusicHelper.loadCover(str, this.mCover, (int) R.dimen.music_cover_size_38, (int) R.dimen.music_cover_size_38, (int) R.drawable.img_cover_player, true, (Transformation) new CropSquareTransformation(12));
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingDirective(Remote.Response.Directive directive) {
        loadPlayerCover(directive.cover);
        this.mName.setText(directive.title);
        this.mCp.setText(MusicHelper.getCpName(directive.origin));
    }

    public void updateProgress() {
        long playingPosition = getPlayingPosition();
        long playingDuration = getPlayingDuration();
        if (playingDuration > 0) {
            this.mProgressBar.setProgress((int) ((playingPosition * 1000) / playingDuration));
        } else {
            this.mProgressBar.setProgress(0);
        }
    }

    private long getPlayingPosition() {
        Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
        if (playerStatus == null || playerStatus.play_song_detail == null) {
            return 0;
        }
        return playerStatus.play_song_detail.position;
    }

    private long getPlayingDuration() {
        Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
        if (playerStatus == null || playerStatus.play_song_detail == null) {
            return 0;
        }
        return playerStatus.play_song_detail.duration;
    }

    private void notifyUpdatePlaylist(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2) {
        PlayerListManager.shareInstance().updatePlaylist(i, j, list, list2);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onMusicPlayedByUser(MusicEvent.MusicUserPlay musicUserPlay) {
        gsy.O00000Oo("PlayerController", "PlayerController onMusicPlayedByUser receive event");
        showWithAnimation();
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onForceFreshPlayingDataEvent(PlayerListManager.ForceFreshPlayingDataEvent forceFreshPlayingDataEvent) {
        updateMusicV3(this.playerStatusOld, true);
    }
}
