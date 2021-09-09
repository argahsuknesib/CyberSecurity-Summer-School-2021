package com.xiaomi.smarthome.uwb.mico;

import _m_j.fg;
import _m_j.fh;
import _m_j.fm;
import _m_j.fo;
import _m_j.fvm;
import _m_j.gsy;
import _m_j.ixe;
import _m_j.iyo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.cache.LrcCache;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.lrc.LrcParseImpl;
import com.xiaomi.mico.music.player.lrc.LrcViewImpl1;
import com.xiaomi.smarthome.R;
import kotlin.Metadata;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoLrcFragment;", "Lcom/xiaomi/smarthome/framework/page/BaseFragment;", "()V", "mLrcView", "Lcom/xiaomi/mico/music/player/lrc/LrcViewImpl1;", "mSubscription", "Lrx/Subscription;", "cancelLrcLoad", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "updatePlayingMusic", "music", "Lcom/xiaomi/mico/api/model/Music$Song;", "position", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoLrcFragment extends fvm {
    private LrcViewImpl1 mLrcView;
    private Subscription mSubscription;

    public final void _$_clearFindViewByIdCache() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate((int) R.layout.uwb_mico_fragment_player_lrc, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.player_lrc_view);
        ixe.O00000Oo(findViewById, "inflate.findViewById(R.id.player_lrc_view)");
        this.mLrcView = (LrcViewImpl1) findViewById;
        Context context = getContext();
        if (context != null) {
            fm O000000o2 = fo.O000000o((UwbMicoActivity) context).O000000o(UwbMicoPlayerViewModel.class);
            ixe.O00000Oo(O000000o2, "of(context as UwbMicoActivity).get(UwbMicoPlayerViewModel::class.java)");
            fg<MusicEvent.PlayerPositionEvent> playerPositionLiveData = ((UwbMicoPlayerViewModel) O000000o2).getPlayerPositionLiveData();
            Context context2 = getContext();
            if (context2 != null) {
                playerPositionLiveData.observe((UwbMicoActivity) context2, new fh() {
                    /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoLrcFragment$C1FM2ulc4MjomU98jM3Jj63ez9E */

                    public final void onChanged(Object obj) {
                        UwbMicoLrcFragment.m534onCreateView$lambda0(UwbMicoLrcFragment.this, (MusicEvent.PlayerPositionEvent) obj);
                    }
                });
                LrcViewImpl1 lrcViewImpl1 = this.mLrcView;
                if (lrcViewImpl1 != null) {
                    lrcViewImpl1.canScroll = false;
                    return inflate;
                }
                ixe.O000000o("mLrcView");
                throw null;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.uwb.mico.UwbMicoActivity");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.uwb.mico.UwbMicoActivity");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m534onCreateView$lambda0(UwbMicoLrcFragment uwbMicoLrcFragment, MusicEvent.PlayerPositionEvent playerPositionEvent) {
        ixe.O00000o(uwbMicoLrcFragment, "this$0");
        if (playerPositionEvent != null) {
            LrcViewImpl1 lrcViewImpl1 = uwbMicoLrcFragment.mLrcView;
            if (lrcViewImpl1 != null) {
                lrcViewImpl1.seekTo(playerPositionEvent.position, true, playerPositionEvent.fromUser);
            } else {
                ixe.O000000o("mLrcView");
                throw null;
            }
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        cancelLrcLoad();
    }

    private final void cancelLrcLoad() {
        Subscription subscription = this.mSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.mSubscription = null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean */
    public final void updatePlayingMusic(Music.Song song, int i) {
        ixe.O00000o(song, "music");
        LrcViewImpl1 lrcViewImpl1 = this.mLrcView;
        if (lrcViewImpl1 != null) {
            if (!ixe.O000000o(lrcViewImpl1.getTag(), (Object) 0)) {
                LrcViewImpl1 lrcViewImpl12 = this.mLrcView;
                if (lrcViewImpl12 == null) {
                    ixe.O000000o("mLrcView");
                    throw null;
                } else if (ixe.O000000o(lrcViewImpl12.getTag(), (Object) song.audioID)) {
                    return;
                }
            }
            LrcViewImpl1 lrcViewImpl13 = this.mLrcView;
            if (lrcViewImpl13 != null) {
                lrcViewImpl13.setEmptyText(getString(R.string.music_no_lyric));
                LrcViewImpl1 lrcViewImpl14 = this.mLrcView;
                if (lrcViewImpl14 != null) {
                    lrcViewImpl14.reset();
                    LrcViewImpl1 lrcViewImpl15 = this.mLrcView;
                    if (lrcViewImpl15 != null) {
                        int i2 = song.audioID;
                        if (i2 == null) {
                            i2 = 0;
                        }
                        lrcViewImpl15.setTag(i2);
                        cancelLrcLoad();
                        long j = 0;
                        try {
                            String str = song.audioID;
                            ixe.O00000Oo(str, "music.audioID");
                            j = Long.parseLong(str);
                        } catch (Exception e) {
                            if (song.audioID != null) {
                                String str2 = song.audioID;
                                ixe.O00000Oo(str2, "music.audioID");
                                if (iyo.O000000o(str2, "miplay push stream", false)) {
                                    LrcViewImpl1 lrcViewImpl16 = this.mLrcView;
                                    if (lrcViewImpl16 != null) {
                                        lrcViewImpl16.reset();
                                        return;
                                    } else {
                                        ixe.O000000o("mLrcView");
                                        throw null;
                                    }
                                }
                            }
                            e.printStackTrace();
                        }
                        this.mSubscription = LrcCache.getInstance().get(j).retryWhen(new RxUtil.RetryWithDelay(100, 1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(i) {
                            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoLrcFragment$upX8YCLpdtAA7t6iJ7zkE2Qdc0 */
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void call(Object obj) {
                                UwbMicoLrcFragment.m535updatePlayingMusic$lambda1(UwbMicoLrcFragment.this, this.f$1, (String) obj);
                            }
                        }, $$Lambda$UwbMicoLrcFragment$JcwQpwl_eVZgxQJQx4vsejUCBNM.INSTANCE);
                        return;
                    }
                    ixe.O000000o("mLrcView");
                    throw null;
                }
                ixe.O000000o("mLrcView");
                throw null;
            }
            ixe.O000000o("mLrcView");
            throw null;
        }
        ixe.O000000o("mLrcView");
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: updatePlayingMusic$lambda-1  reason: not valid java name */
    public static final void m535updatePlayingMusic$lambda1(UwbMicoLrcFragment uwbMicoLrcFragment, int i, String str) {
        ixe.O00000o(uwbMicoLrcFragment, "this$0");
        if (!TextUtils.isEmpty(str)) {
            LrcViewImpl1 lrcViewImpl1 = uwbMicoLrcFragment.mLrcView;
            if (lrcViewImpl1 != null) {
                lrcViewImpl1.setLrcRows(new LrcParseImpl().getLrcRows(str));
                LrcViewImpl1 lrcViewImpl12 = uwbMicoLrcFragment.mLrcView;
                if (lrcViewImpl12 != null) {
                    lrcViewImpl12.seekTo(i, false, false);
                } else {
                    ixe.O000000o("mLrcView");
                    throw null;
                }
            } else {
                ixe.O000000o("mLrcView");
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updatePlayingMusic$lambda-2  reason: not valid java name */
    public static final void m536updatePlayingMusic$lambda2(Throwable th) {
        ixe.O00000o(th, "throwable");
        gsy.O00000Oo("PlayerLrcFragment get lrc from remote error", String.valueOf(th));
    }
}
