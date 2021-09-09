package com.xiaomi.mico.music.player;

import _m_j.jgc;
import _m_j.jgi;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.cache.LrcCache;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.lrc.LrcParseImpl;
import com.xiaomi.mico.music.player.lrc.LrcViewImpl1;
import com.xiaomi.smarthome.R;
import me.wcy.lrcview.LrcView;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class PlayerLrcFragment extends BasePlayerFragment {
    @BindView(6829)
    LrcViewImpl1 mLrcView;
    @BindView(6475)
    LrcView mLrcView2;
    private Subscription mSubscription;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.mico_fragment_player_lrc, viewGroup, false);
        ButterKnife.bind(this, inflate);
        jgc.O000000o().O000000o(this);
        this.mLrcView2.setOnPlayClickListener(new LrcView.O000000o() {
            /* class com.xiaomi.mico.music.player.PlayerLrcFragment.AnonymousClass1 */

            public boolean onPlayClick(long j) {
                return true;
            }
        });
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        cancelLrcLoad();
    }

    private void cancelLrcLoad() {
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
    }

    private void resetLrcView(int i) {
        String str;
        if (MusicHelper.isPlayingSong(i)) {
            str = getString(R.string.music_no_lyric);
        } else if (MusicHelper.isPlayingStation(i)) {
            str = getString(R.string.music_no_lyric_for_station);
        } else {
            str = MusicHelper.isPlayingDirective(i) ? getString(R.string.music_no_lyric_for_directive) : null;
        }
        this.mLrcView.setEmptyText(str);
        this.mLrcView.reset();
        cancelLrcLoad();
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingMusic(int i, Remote.Response.TrackData trackData) {
        resetLrcView(i);
        if (MusicHelper.isPlayingSong(i) && MusicHelper.isPlayingValid(trackData)) {
            this.mSubscription = LrcCache.getInstance().get(trackData.musicID).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                /* class com.xiaomi.mico.music.player.PlayerLrcFragment.AnonymousClass2 */

                public void call(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        PlayerLrcFragment.this.mLrcView.setLrcRows(new LrcParseImpl().getLrcRows(str));
                    } else {
                        PlayerLrcFragment.this.mLrcView.setEmptyText(PlayerLrcFragment.this.getString(R.string.music_no_lyric));
                    }
                }
            }, new Action1() {
                /* class com.xiaomi.mico.music.player.$$Lambda$PlayerLrcFragment$DFQr9xar3vDqEbf2jxuMJ2rIvv8 */

                public final void call(Object obj) {
                    PlayerLrcFragment.this.lambda$updatePlayingMusic$0$PlayerLrcFragment((Throwable) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$updatePlayingMusic$0$PlayerLrcFragment(Throwable th) {
        this.mLrcView.setEmptyText(getString(R.string.music_no_lyric));
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingMusicV3(Music.Song song) {
        long j;
        this.mLrcView.setEmptyText(getString(MusicHelper.getDefaultLrcTextV3(song)));
        this.mLrcView.reset();
        cancelLrcLoad();
        try {
            j = Long.parseLong(song.audioID);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            j = 0;
        }
        this.mSubscription = LrcCache.getInstance().get(j).retryWhen(new RxUtil.RetryWithDelay(100, 1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.player.$$Lambda$PlayerLrcFragment$jwxndHeyfFgfknwJhpKzqXtCijM */

            public final void call(Object obj) {
                PlayerLrcFragment.this.lambda$updatePlayingMusicV3$1$PlayerLrcFragment((String) obj);
            }
        }, $$Lambda$PlayerLrcFragment$qH6o1jp77xC6OzeIGTCqaB_zQQs.INSTANCE);
    }

    public /* synthetic */ void lambda$updatePlayingMusicV3$1$PlayerLrcFragment(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mLrcView.setLrcRows(new LrcParseImpl().getLrcRows(str));
        }
    }

    /* access modifiers changed from: package-private */
    public void updatePlayerPosition(int i, boolean z) {
        LrcViewImpl1 lrcViewImpl1 = this.mLrcView;
        if (lrcViewImpl1 != null) {
            lrcViewImpl1.seekTo(i, true, z);
        }
    }

    @OnClick({6829})
    public void onClick() {
        ((PlayerActivityV2) getActivity()).setCurrentItem(0);
    }

    public void onDestroy() {
        super.onDestroy();
        jgc.O000000o().O00000o0(this);
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onPlayerPositionChanged(MusicEvent.PlayerPositionEvent playerPositionEvent) {
        updatePlayerPosition(playerPositionEvent.position, playerPositionEvent.fromUser);
    }
}
