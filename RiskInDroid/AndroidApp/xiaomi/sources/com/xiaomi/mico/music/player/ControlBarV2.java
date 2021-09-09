package com.xiaomi.mico.music.player;

import _m_j.hxi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.favourite.FavouriteManager;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class ControlBarV2 extends LinearLayout implements PlayerStatusTrack.onTrackListener {
    private MLAlertDialog countDownTimerDialog;
    public boolean isLoadingShutdown;
    private long mListID = -1;
    @BindView(6814)
    ImageView mLoop;
    WeakReference<ImageView> mLove;
    private int mMediaType = -1;
    @BindView(6816)
    ImageView mNext;
    private OnMusicUpdateListener mOnMusicUpdateListener;
    @BindView(6817)
    ImageView mPlay;
    @BindView(6818)
    ImageView mPrev;
    private List<Long> mSongList;
    private Music.Song mSongV3;
    public Music.Station mStation;
    private int mStatus = -1;
    private Subscription mSubscription;
    @BindView(6821)
    ImageView mTime;
    private List<Remote.Response.TrackData> mTrackList = null;
    private Remote.Response.TrackData mTrackingData;
    @BindView(6822)
    ImageView mVolume;
    @BindView(6832)
    PlayerProgressBar playerProgressBar;
    private PlayerShutdownTimer playerShutdownTimer;
    private Remote.Response.PlayerStatus playerStatusOld;

    interface OnMusicUpdateListener {
        void onPlayerPositionUpdate(int i, boolean z);

        void onPlayingDirectiveUpdate(Remote.Response.Directive directive);

        void onPlayingMusicUpdate(int i, Remote.Response.TrackData trackData);

        void onPlayingMusicUpdate(Serializable serializable);

        void onPlayingStatusUpdate(boolean z);

        void onPlaylistUpdate(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2);

        void onPlaylistUpdateV3(Remote.Response.PlayerStatus playerStatus, boolean z);
    }

    public ControlBarV2(Context context) {
        super(context);
    }

    public ControlBarV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        WeakReference<ImageView> weakReference;
        super.onFinishInflate();
        ButterKnife.bind(this);
        this.mTime.setEnabled(MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.PLAYER_PAUSE_TIMER));
        if (!(AppCapability.hasCapabilitySongCollection() || (weakReference = this.mLove) == null || weakReference.get() == null)) {
            this.mLove.get().setImageResource(R.drawable.mico_icon_player_love_disabled);
        }
        Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
        if (playerStatus != null) {
            this.mMediaType = playerStatus.media_type;
            this.mListID = playerStatus.list_id;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelSubscription();
    }

    @OnClick({6814, 6818, 6817, 6816, 6821, 6813, 6822})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.player_control_bar_loop) {
            int nextLoop = nextLoop();
            hxi.O00000o.f952O000000o.O000000o("content_playpage_mode", "type", Integer.valueOf(nextLoop));
        } else if (id == R.id.player_control_bar_time) {
            showPlayerShutdownTimer();
            hxi.O00000o.f952O000000o.O000000o("content_playpage_shutdown", new Object[0]);
        } else if (id == R.id.player_control_bar_list) {
            int i = this.mStatus;
            if (i == 1 || i == 2) {
                PlayerListManager.shareInstance().popupPlayList(getContext());
            }
            hxi.O00000o.f952O000000o.O000000o("content_playpage_list", new Object[0]);
        } else if (id == R.id.player_control_bar_prev) {
            PlayerManager.getInstance().prev(null);
            hxi.O00000o.f952O000000o.O000000o("content_playpage_prev", new Object[0]);
        } else if (id == R.id.player_control_bar_play) {
            setPlayButtonState();
            PlayerManager.getInstance().playOrPause(null);
            hxi.O00000o.f952O000000o.O000000o("content_playpage_pause", new Object[0]);
        } else if (id == R.id.player_control_bar_next) {
            PlayerManager.getInstance().next(null);
            hxi.O00000o.f952O000000o.O000000o("content_playpage_next", new Object[0]);
        } else if (id == R.id.player_control_bar_volume) {
            Context context = getContext();
            if (context instanceof PlayerActivityV2) {
                ((PlayerActivityV2) context).showSoundBar();
            }
            hxi.O00000o.f952O000000o.O000000o("content_playpage_volume", new Object[0]);
        }
    }

    private void setPlayButtonState() {
        if (this.mStatus == 1) {
            this.mPlay.setImageResource(R.drawable.mico_icon_player_paused);
            this.mStatus = 2;
            return;
        }
        this.mPlay.setImageResource(R.drawable.mico_icon_player_playing);
        this.mStatus = 1;
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            updatePlayerStatusV3(playerStatus);
        } else {
            updatePlayerStatus(playerStatus);
        }
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        PlayerStatusTrack.getInstance().register(this);
        this.playerProgressBar.onResume();
    }

    /* access modifiers changed from: package-private */
    public void onPause() {
        PlayerStatusTrack.getInstance().unregister(this);
        this.mStatus = -1;
        this.playerProgressBar.onPause();
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

    public void addOnPlayingMusicUpdateListener(OnMusicUpdateListener onMusicUpdateListener) {
        this.mOnMusicUpdateListener = onMusicUpdateListener;
    }

    public void setLoveView(ImageView imageView) {
        if (this.mLove == null) {
            this.mLove = new WeakReference<>(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.player.$$Lambda$ControlBarV2$xag466kAyB617AwJCiQt8x84d3I */

                public final void onClick(View view) {
                    ControlBarV2.this.lambda$setLoveView$0$ControlBarV2(view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setLoveView$0$ControlBarV2(View view) {
        hxi.O00000o.f952O000000o.O000000o("content_playpage_collect", new Object[0]);
        if (!AppCapability.hasCapabilitySongCollection()) {
            ToastUtil.showToast((int) R.string.mico_tool_open_not_support);
            return;
        }
        WeakReference<ImageView> weakReference = this.mLove;
        if (weakReference == null || weakReference.get() == null || !this.mLove.get().isSelected()) {
            if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
                add2FavouriteV3();
            } else {
                addToFavourite();
            }
        } else if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            delFavouriteV3();
        } else {
            removeToFavourite();
        }
    }

    private void updatePlayerStatus(Remote.Response.PlayerStatus playerStatus) {
        WeakReference<ImageView> weakReference;
        boolean isPlayingSong = MusicHelper.isPlayingSong(playerStatus.media_type);
        boolean isPlayingStation = MusicHelper.isPlayingStation(playerStatus.media_type);
        boolean z = false;
        if (isPlayingSong || isPlayingStation) {
            if (playerStatus.loop_type == 3) {
                this.mLoop.setImageResource(R.drawable.mico_icon_player_shuffle);
            } else if (playerStatus.loop_type == 0) {
                this.mLoop.setImageResource(R.drawable.mico_icon_player_single_loop);
            } else {
                this.mLoop.setImageResource(R.drawable.mico_icon_player_list_loop);
            }
            this.mLoop.setEnabled(true);
        } else {
            this.mLoop.setImageResource(R.drawable.mico_icon_player_list_loop_disable);
            this.mLoop.setEnabled(false);
        }
        if (!(!AppCapability.hasCapabilitySongCollection() || (weakReference = this.mLove) == null || weakReference.get() == null)) {
            this.mLove.get().setEnabled(isPlayingSong || MusicHelper.isPlayingRadioStation(playerStatus.media_type));
        }
        if (this.mStatus != playerStatus.status) {
            if (playerStatus.status == 1) {
                this.mPlay.setImageResource(R.drawable.mico_icon_player_playing);
            } else {
                this.mPlay.setImageResource(R.drawable.mico_icon_player_paused);
            }
            this.mStatus = playerStatus.status;
            if (this.mStatus == 1) {
                z = true;
            }
            notifyUpdatePlayingStatus(z);
        }
        Remote.Response.PlayingData playingData = playerStatus.play_song_detail;
        if (playingData == null) {
            updateMusic(-1);
        } else if (isPlayingSong || isPlayingStation || MusicHelper.isPlayingDirective(playerStatus.media_type)) {
            updateMusic(playerStatus.media_type, playerStatus.list_id, playerStatus.track_list, playerStatus.extra_track_list, playingData.getTrackingData());
        } else {
            updateMusic(playerStatus.media_type);
        }
    }

    private void updatePlayerStatusV3(Remote.Response.PlayerStatus playerStatus) {
        if (playerStatus.loop_type == 3) {
            this.mLoop.setImageResource(R.drawable.mico_icon_player_shuffle);
        } else if (playerStatus.loop_type == 0) {
            this.mLoop.setImageResource(R.drawable.mico_icon_player_single_loop);
        } else {
            this.mLoop.setImageResource(R.drawable.mico_icon_player_list_loop);
        }
        boolean z = true;
        this.mLoop.setEnabled(true);
        if (this.mStatus != playerStatus.status) {
            if (playerStatus.status == 1) {
                this.mPlay.setImageResource(R.drawable.mico_icon_player_playing);
            } else {
                this.mPlay.setImageResource(R.drawable.mico_icon_player_paused);
            }
            this.mStatus = playerStatus.status;
            if (this.mStatus != 1) {
                z = false;
            }
            notifyUpdatePlayingStatus(z);
        }
        if (playerStatus.play_song_detail != null) {
            updateMusicV3(playerStatus);
        } else {
            updateMusic(-1);
        }
    }

    public void updateMusicV3(Remote.Response.PlayerStatus playerStatus) {
        Remote.Response.PlayerStatus playerStatus2 = this.playerStatusOld;
        boolean z = playerStatus2 == null || playerStatus2.play_song_detail.audio_id != playerStatus.play_song_detail.audio_id;
        this.playerStatusOld = playerStatus;
        if (z) {
            getCurrentPlayingMusicV3(playerStatus.play_song_detail.audio_id);
        }
    }

    private void getCurrentPlayingMusicV3(long j) {
        cancelSubscription();
        this.mSubscription = MusicCache.getSong(j).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.player.$$Lambda$ControlBarV2$RxxR3ygDuspkcGCPdkBdyXeRKaA */

            public final void call(Object obj) {
                ControlBarV2.this.lambda$getCurrentPlayingMusicV3$1$ControlBarV2((Music.Song) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.player.$$Lambda$ControlBarV2$nFcbtu0mNNk5fgAYrXgTD6u6olA */

            public final void call(Object obj) {
                ControlBarV2.this.lambda$getCurrentPlayingMusicV3$2$ControlBarV2((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getCurrentPlayingMusicV3$1$ControlBarV2(Music.Song song) {
        WeakReference<ImageView> weakReference;
        this.mSongV3 = song;
        if (!(!AppCapability.hasCapabilitySongCollection() || (weakReference = this.mLove) == null || weakReference.get() == null)) {
            this.mLove.get().setEnabled(MusicHelper.isFavoriteEnableV3(song));
            ImageView imageView = this.mLove.get();
            boolean z = true;
            if (song.collection != 1) {
                z = false;
            }
            imageView.setSelected(z);
        }
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayingMusicUpdate(song);
        }
    }

    public /* synthetic */ void lambda$getCurrentPlayingMusicV3$2$ControlBarV2(Throwable th) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayingMusicUpdate(null);
        }
    }

    private void updateMusic(int i) {
        updateMusic(i, -1, null, null, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    private void updateMusic(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2, Remote.Response.TrackData trackData) {
        boolean z;
        boolean z2;
        WeakReference<ImageView> weakReference;
        boolean z3 = true;
        if (this.mMediaType != i) {
            this.mMediaType = i;
            z2 = true;
            z = true;
        } else {
            z2 = isListIDChanged(j) || isMusicListChanged(list) || !ContainerUtil.equals(this.mTrackList, list2);
            z = !CommonUtils.equals(this.mTrackingData, trackData);
            if (!ContainerUtil.equals(this.mSongList, list)) {
                z2 = true;
            }
        }
        if (z2) {
            this.mListID = j;
            this.mTrackList = list2;
            this.mSongList = list;
            notifyUpdatePlaylist(i, j, list, list2);
        }
        if (z) {
            this.mTrackingData = trackData;
            notifyUpdatePlayingMusic(i, trackData);
            if (!(!AppCapability.hasCapabilitySongCollection() || (weakReference = this.mLove) == null || weakReference.get() == null)) {
                this.mLove.get().setSelected(false);
            }
            if (MusicHelper.isPlayingValid(trackData)) {
                if (MusicHelper.isPlayingSong(i)) {
                    getSong(trackData.musicID);
                } else if (MusicHelper.isPlayingDirective(i)) {
                    notifyUpdatePlayingDirective(trackData.toDirective());
                } else {
                    int playingStationType = MusicHelper.getPlayingStationType(i, -1);
                    if (playingStationType != -1) {
                        getStation(trackData.musicID, trackData.cpID, trackData.cpOrigin, playingStationType);
                    }
                }
                if (z3) {
                    notifyUpdatePlayingMusic(null);
                    return;
                }
                return;
            }
            z3 = false;
            if (z3) {
            }
        }
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

    private void notifyUpdatePlayingStatus(boolean z) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayingStatusUpdate(z);
        }
    }

    private void notifyUpdatePlaylist(int i, long j, List<Long> list, List<Remote.Response.TrackData> list2) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlaylistUpdate(i, j, list, list2);
        }
    }

    private void notifyUpdatePlayingMusic(int i, Remote.Response.TrackData trackData) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayingMusicUpdate(i, trackData);
        }
    }

    private void notifyUpdatePlayerPosition(int i, boolean z) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayerPositionUpdate(i, z);
        }
    }

    public void notifyUpdatePlayingMusic(Serializable serializable) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayingMusicUpdate(serializable);
        }
    }

    private void notifyUpdatePlayingDirective(Remote.Response.Directive directive) {
        OnMusicUpdateListener onMusicUpdateListener = this.mOnMusicUpdateListener;
        if (onMusicUpdateListener != null) {
            onMusicUpdateListener.onPlayingDirectiveUpdate(directive);
        }
    }

    private int nextLoopType() {
        Remote.Response.PlayerStatus playerStatus = PlayerManager.getInstance().getPlayerStatus();
        int i = (playerStatus == null || playerStatus.status == 0 || playerStatus.loop_type == 4) ? 2 : playerStatus.loop_type;
        if (i == 3) {
            return 0;
        }
        return i == 0 ? 1 : 3;
    }

    private void getSong(final long j) {
        cancelSubscription();
        this.mSubscription = MusicCache.getSong(j).subscribe(new Action1<Music.Song>() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass1 */

            public void call(Music.Song song) {
                if (j == ControlBarV2.this.getPlayingSongID()) {
                    ControlBarV2.this.notifyUpdatePlayingMusic(song);
                    if (AppCapability.hasCapabilitySongCollection()) {
                        ControlBarV2.this.getLikeStatus(song);
                    }
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass2 */

            public void call(Throwable th) {
                if (j == ControlBarV2.this.getPlayingSongID()) {
                    ControlBarV2.this.notifyUpdatePlayingMusic(null);
                }
            }
        });
    }

    public void getLikeStatus(final Music.Song song) {
        FavouriteManager.getInstance().getLikeStatus(song, new ApiRequest.Listener<List<Music.Favourite>>() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass3 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Favourite>) ((List) obj));
            }

            public void onSuccess(List<Music.Favourite> list) {
                if (list != null && !list.isEmpty()) {
                    Music.Favourite favourite = list.get(0);
                    if (favourite.isSameSong(song) && ControlBarV2.this.mLove != null && ControlBarV2.this.mLove.get() != null) {
                        ControlBarV2.this.mLove.get().setSelected(favourite.isFavourite);
                    }
                }
            }
        });
    }

    private void getStation(long j, final String str, String str2, int i) {
        cancelSubscription();
        this.mSubscription = ObservableApiHelper.getStationInfo(new Music.Station.Simple(j, str, str2, i)).subscribe(new Action1<Music.Station>() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass4 */

            public void call(Music.Station station) {
                ControlBarV2 controlBarV2 = ControlBarV2.this;
                controlBarV2.mStation = station;
                if (CommonUtils.equals(str, controlBarV2.getPlayingStationID())) {
                    ControlBarV2.this.notifyUpdatePlayingMusic(station);
                }
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass5 */

            public void call(Throwable th) {
                if (CommonUtils.equals(str, ControlBarV2.this.getPlayingStationID())) {
                    ControlBarV2.this.notifyUpdatePlayingMusic(null);
                }
            }
        });
    }

    private void getLikeStation(Music.Station station) {
        final Music.Song song = new Music.Song();
        song.origin = station.origin;
        song.originSongID = station.stationID;
        FavouriteManager.getInstance().getLikeStatus(song, new ApiRequest.Listener<List<Music.Favourite>>() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass6 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Music.Favourite>) ((List) obj));
            }

            public void onSuccess(List<Music.Favourite> list) {
                if (list != null && !list.isEmpty()) {
                    Music.Favourite favourite = list.get(0);
                    if (favourite.isSameSong(song) && ControlBarV2.this.mLove != null && ControlBarV2.this.mLove.get() != null) {
                        ControlBarV2.this.mLove.get().setSelected(favourite.isFavourite);
                    }
                }
            }
        });
    }

    private void showPlayerShutdownTimer() {
        if (!this.isLoadingShutdown) {
            this.isLoadingShutdown = true;
            ApiHelper.getPlayerShutdownTimer(new ApiRequest.Listener<Remote.Response.PlayerShutdownTimerResp>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass7 */

                public void onSuccess(Remote.Response.PlayerShutdownTimerResp playerShutdownTimerResp) {
                    if (Build.VERSION.SDK_INT >= 19 && ControlBarV2.this.isAttachedToWindow()) {
                        ControlBarV2.this.popShutdownTimerView(playerShutdownTimerResp);
                    }
                    ControlBarV2.this.isLoadingShutdown = false;
                }

                public void onFailure(ApiError apiError) {
                    ControlBarV2.this.isLoadingShutdown = false;
                    ToastUtil.showToast((int) R.string.music_player_shutdown_timer_load_faild);
                }
            });
        }
    }

    public void popShutdownTimerView(Remote.Response.PlayerShutdownTimerResp playerShutdownTimerResp) {
        if (this.playerShutdownTimer == null) {
            this.playerShutdownTimer = (PlayerShutdownTimer) LayoutInflater.from(getContext()).inflate((int) R.layout.view_player_shutdown_timer, (ViewGroup) null);
        }
        if (this.countDownTimerDialog == null) {
            this.countDownTimerDialog = new MLAlertDialog.Builder(getContext()).O00000o();
        }
        this.playerShutdownTimer.setCloseBtnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.player.$$Lambda$ControlBarV2$NxtrB357FOa73D6r9anS5QWeJYU */

            public final void onClick(View view) {
                ControlBarV2.this.lambda$popShutdownTimerView$3$ControlBarV2(view);
            }
        });
        this.playerShutdownTimer.setup(this.countDownTimerDialog, playerShutdownTimerResp);
        this.countDownTimerDialog.setView(this.playerShutdownTimer, 0, 0, 0, 0);
        this.countDownTimerDialog.show();
    }

    public /* synthetic */ void lambda$popShutdownTimerView$3$ControlBarV2(View view) {
        this.countDownTimerDialog.dismiss();
    }

    private void add2FavouriteV3() {
        if (this.mSongV3 != null) {
            ChannelManager.getInstance().add2FavouriteV3(this.mSongV3).subscribe(new Action1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$ControlBarV2$l9UwBLfh5V6ddrNZghb6Fg3guLU */

                public final void call(Object obj) {
                    ControlBarV2.this.lambda$add2FavouriteV3$4$ControlBarV2((String) obj);
                }
            }, $$Lambda$ControlBarV2$5sQ58mLGZ5p7W6FxH7wy2rvow_U.INSTANCE);
        }
    }

    public /* synthetic */ void lambda$add2FavouriteV3$4$ControlBarV2(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(R.string.music_channel_default);
        }
        ToastUtil.showToast(getContext().getString(R.string.music_channel_add_song_success, str));
        WeakReference<ImageView> weakReference = this.mLove;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.mLove.get().setSelected(true);
        }
        PlayerManager.getInstance().refreshMicoLoveStatus();
    }

    private void delFavouriteV3() {
        if (this.mSongV3 != null) {
            ChannelManager.getInstance().delFavouriteV3(this.mSongV3).subscribe(new Action1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$ControlBarV2$hJJ6izLpX7f6vsdii6xnL79kFrw */

                public final void call(Object obj) {
                    ControlBarV2.this.lambda$delFavouriteV3$6$ControlBarV2((Boolean) obj);
                }
            }, $$Lambda$ControlBarV2$wwo2o8uvHid_DbC2f9SKKTceQVE.INSTANCE);
        }
    }

    public /* synthetic */ void lambda$delFavouriteV3$6$ControlBarV2(Boolean bool) {
        WeakReference<ImageView> weakReference = this.mLove;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.mLove.get().setSelected(false);
        }
        PlayerManager.getInstance().refreshMicoLoveStatus();
    }

    private void addToFavourite() {
        if (MusicHelper.isPlayingRadioStation(this.mMediaType)) {
            collectionRadioStation();
        } else if (MusicHelper.isPlayingSong(this.mMediaType) && MusicHelper.isPlayingValid(this.mTrackingData)) {
            MusicCache.getSong(this.mTrackingData.musicID).flatMap(new Func1<Music.Song, Observable<String>>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass10 */

                public Observable<String> call(Music.Song song) {
                    return ChannelManager.getInstance().addToFavourite(song);
                }
            }).subscribe(new Action1<String>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass8 */

                public void call(String str) {
                    if (TextUtils.isEmpty(str)) {
                        str = ControlBarV2.this.getContext().getString(R.string.music_channel_default);
                    }
                    ToastUtil.showToast(ControlBarV2.this.getContext().getString(R.string.music_channel_add_song_success, str));
                    if (!(ControlBarV2.this.mLove == null || ControlBarV2.this.mLove.get() == null)) {
                        ControlBarV2.this.mLove.get().setSelected(true);
                    }
                    PlayerManager.getInstance().refreshMicoLoveStatus();
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass9 */

                public void call(Throwable th) {
                    ToastUtil.showToast((int) R.string.music_channel_add_song_failed);
                }
            });
        }
    }

    private void removeToFavourite() {
        if (MusicHelper.isPlayingRadioStation(this.mMediaType)) {
            uncollectionRadioStation();
        } else if (MusicHelper.isPlayingSong(this.mMediaType) && MusicHelper.isPlayingValid(this.mTrackingData)) {
            MusicCache.getSong(this.mTrackingData.musicID).flatMap(new Func1<Music.Song, Observable<Boolean>>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass13 */

                public Observable<Boolean> call(Music.Song song) {
                    return ChannelManager.getInstance().removeToFavourite(song);
                }
            }).subscribe(new Action1<Boolean>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass11 */

                public void call(Boolean bool) {
                    if (!(ControlBarV2.this.mLove == null || ControlBarV2.this.mLove.get() == null)) {
                        ControlBarV2.this.mLove.get().setSelected(false);
                    }
                    PlayerManager.getInstance().refreshMicoLoveStatus();
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass12 */

                public void call(Throwable th) {
                    ToastUtil.showToast((int) R.string.common_failed);
                }
            });
        }
    }

    private void collectionRadioStation() {
        Music.Station station = this.mStation;
        if (station != null && this.mTrackingData != null && station.stationID.equals(this.mTrackingData.cpID)) {
            ApiHelper.like(4, this.mStation.globalID, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass14 */

                public void onSuccess(String str) {
                    String string = ControlBarV2.this.getContext().getString(R.string.music_favourite);
                    ToastUtil.showToast(ControlBarV2.this.getContext().getString(R.string.music_channel_add_song_success, string));
                }

                public void onFailure(ApiError apiError) {
                    ToastUtil.showToast((int) R.string.common_failed);
                }
            });
        }
    }

    private void uncollectionRadioStation() {
        Music.Station station = this.mStation;
        if (station != null && this.mTrackingData != null && station.stationID.equals(this.mTrackingData.cpID)) {
            ApiHelper.unlike(4, this.mStation.globalID, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass15 */

                public void onSuccess(String str) {
                    if (ControlBarV2.this.mLove != null && ControlBarV2.this.mLove.get() != null) {
                        ControlBarV2.this.mLove.get().setSelected(false);
                    }
                }

                public void onFailure(ApiError apiError) {
                    ToastUtil.showToast((int) R.string.common_failed);
                }
            });
        }
    }

    private int nextLoop() {
        if (!MicoManager.getInstance().currentMicoIsAiProtocolV3() && !MusicHelper.isPlayingSong(this.mMediaType) && !MusicHelper.isPlayingStation(this.mMediaType)) {
            return 0;
        }
        this.mLoop.setEnabled(false);
        final int nextLoopType = nextLoopType();
        PlayerManager.getInstance().loop(nextLoopType, new IncompleteApiListener() {
            /* class com.xiaomi.mico.music.player.ControlBarV2.AnonymousClass16 */

            public void onSuccess() {
                int i = nextLoopType;
                if (i == 0) {
                    ToastUtil.showToast((int) R.string.toast_loop_type_single);
                } else if (i == 2 || i == 1) {
                    ToastUtil.showToast((int) R.string.toast_loop_type_order);
                } else if (i == 3) {
                    ToastUtil.showToast((int) R.string.toast_loop_type_shuffle);
                }
                ControlBarV2.this.mLoop.setEnabled(true);
            }

            public void onFailure(ApiError apiError) {
                ControlBarV2.this.mLoop.setEnabled(true);
            }
        });
        return nextLoopType;
    }
}
