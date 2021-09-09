package com.ximalaya.ting.android.opensdk.player.service;

import _m_j.iio;
import _m_j.iis;
import _m_j.iit;
import _m_j.iiu;
import _m_j.iiw;
import _m_j.iiz;
import _m_j.ijc;
import _m_j.ijd;
import _m_j.ije;
import _m_j.ijg;
import _m_j.ijk;
import _m_j.ijn;
import _m_j.ijo;
import _m_j.ijp;
import _m_j.ijq;
import _m_j.ijv;
import _m_j.ijw;
import _m_j.ijx;
import _m_j.ijy;
import _m_j.ijz;
import _m_j.ika;
import _m_j.ikb;
import _m_j.ikd;
import _m_j.ike;
import _m_j.ikg;
import _m_j.ikh;
import _m_j.iki;
import _m_j.ikn;
import _m_j.iks;
import _m_j.ikt;
import _m_j.ikw;
import _m_j.ikx;
import _m_j.ikz;
import _m_j.ila;
import _m_j.ilc;
import _m_j.ilg;
import _m_j.ilj;
import _m_j.ilk;
import _m_j.ilo;
import _m_j.ilp;
import _m_j.ilv;
import _m_j.ima;
import _m_j.ime;
import _m_j.imf;
import _m_j.imj;
import _m_j.imk;
import _m_j.imq;
import _m_j.imw;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.category.CategoryModel;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.opensdk.player.appwidget.WidgetProvider;
import com.ximalaya.ting.android.opensdk.player.mediacontrol.MediaControlManager;
import com.ximalaya.ting.android.opensdk.player.receive.WireControlReceiver;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayer;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl;
import com.ximalaya.ting.android.opensdk.util.NetworkType;
import com.ximalaya.ting.android.player.MediadataCrytoUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class XmPlayerService extends Service {
    public static Service mService;

    /* renamed from: O000000o  reason: collision with root package name */
    protected XmPlayListControl f12208O000000o;
    private SharedPreferences O00000Oo;
    private XmPlayerImpl O00000o;
    private SharedPreferences O00000o0;
    private ikz O00000oO;
    private int O00000oo = 0;
    private imw O0000O0o;
    private imk.O0000OOo O0000OOo;
    private WidgetProvider O0000Oo;
    private ima O0000Oo0;
    private boolean O0000OoO = false;
    private ikh O0000Ooo = new ikh() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass2 */
        private byte[] O00000Oo = new byte[0];

        public final void O000000o(Advertis advertis, int i) {
            ilk.O000000o("mAdsListener onStartPlayAds XmPlayerService 556:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                if (XmPlayerService.this.mWillPause) {
                    XmPlayerService.this.mWillPause = false;
                    XmPlayerService.this.pausePlay();
                    return;
                }
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i2).onStartPlayAds(advertis, i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public final void O000000o() {
            ilk.O000000o("mAdsListener onStartGetAdsInfo XmPlayerService 580:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i).onStartGetAdsInfo();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public final void O000000o(AdvertisList advertisList) {
            ilk.O000000o("mAdsListener onGetAdsInfo XmPlayerService 598:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                XmPlayerService.this.startCheckIsPauseTime();
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i).onGetAdsInfo(advertisList);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public final void O000000o(int i, int i2) {
            ilk.O000000o("mAdsListener onError XmPlayerService 618:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i3).onError(i, i2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public final void O00000o() {
            ilk.O000000o("mAdsListener onCompletePlayAds XmPlayerService 636:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i).onCompletePlayAds();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public final void O00000o0() {
            ilk.O000000o("mAdsListener onAdsStopBuffering XmPlayerService 654:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i).onAdsStopBuffering();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public final void O00000Oo() {
            ilk.O000000o("mAdsListener onAdsStartBuffering XmPlayerService 672:" + System.currentTimeMillis());
            synchronized (this.O00000Oo) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i).onAdsStartBuffering();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }
    };
    private String O0000o0 = "__xm__";
    private long O0000o00 = -813934592;
    private Handler O0000o0O;
    private XmPlayerControl.O000000o O0000o0o = new XmPlayerControl.O000000o() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass9 */
    };
    public boolean isContinuePlay = false;
    public boolean isDLNAState = false;
    public boolean isLossAudioFocus = false;
    public RemoteCallbackList<IXmAdsEventDispatcher> mAdsDispatcher = new ikx();
    public ikn mAdsManager;
    public Context mAppCtx;
    public String mAppSecret;
    public Runnable mCheckIsPauseTimeRunnable;
    public Config mConfig;
    public RemoteCallbackList<IXmCustomDataCallBack> mCustomDataCallBack = new ikx();
    public IXmCommonBusinessDispatcher mIXmCommonBusinessDispatcher;
    public int mLastDuration;
    public PlayableModel mLastModel;
    public RemoteCallbackList<IXmMainDataSupportDataCallback> mMainDataSupportCallbackList = new ikx();
    public MediaControlManager mMediaControlManager;
    public Notification mNotification;
    public int mNotificationId;
    public NotificationManager mNotificationManager;
    public long mPauseTimeInMills = 0;
    public ikn.O000000o mPlayStartCallBack;
    public XmPlayerAudioFocusControl mPlayerAudioFocusControl;
    public XmPlayerControl mPlayerControl;
    public RemoteCallbackList<IXmPlayerEventDispatcher> mPlayerDispatcher = new ikx();
    public ikw mPlayerStatusListener = new ikw() {
        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass1 */

        public final void O00000oO() {
            ilk.O000000o("onSoundPrepared XmPlayerService 192:" + System.currentTimeMillis());
            XmPlayerService xmPlayerService = XmPlayerService.this;
            xmPlayerService.mLastDuration = xmPlayerService.mPlayerControl.O0000OOo;
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onSoundPrepared();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
        }

        public final void O000000o(PlayableModel playableModel, PlayableModel playableModel2) {
            ilk.O000000o("onSoundSwitch XmPlayerService 221:" + System.currentTimeMillis());
            if (XmPlayerService.this.getPlayerImpl() != null) {
                XmPlayerService.this.getPlayerImpl().lastRequestTime = System.currentTimeMillis();
            }
            XmPlayerService.this.mWillPause = false;
            StringBuilder sb = new StringBuilder();
            sb.append(ilv.O00000Oo);
            ilk.O00000Oo("XmPlayerService", sb.toString());
            ilp O000000o2 = ilp.O000000o(XmPlayerService.this.mAppCtx);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ilv.O00000Oo);
            O000000o2.O000000o("downloadedSize", sb2.toString());
            ilv.O00000Oo = 0;
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onSoundSwitch((Track) playableModel, (Track) playableModel2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            if (playableModel != null && (playableModel instanceof Track)) {
                int O000000o3 = XmPlayerService.this.mPlayerControl.O000000o();
                XmPlayerService.this.mStatisticsManager.O000000o((Track) playableModel, O000000o3);
            }
            ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.f12208O000000o, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, iks.O000000o(XmPlayerService.this.mAppCtx));
        }

        public final void O00000o0() {
            ilk.O000000o("onPlayStop XmPlayerService 271:" + System.currentTimeMillis());
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onPlayStop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            int O000000o2 = XmPlayerService.this.mPlayerControl.O000000o();
            XmPlayerService.this.mStatisticsManager.O000000o((Track) XmPlayerService.this.f12208O000000o.O00000o, O000000o2);
            MediaControlManager mediaControlManager = XmPlayerService.this.mMediaControlManager;
            if (ikz.O000000o(mediaControlManager.O00000o).O00000oo()) {
                if (Build.VERSION.SDK_INT >= 21 && mediaControlManager.f12182O000000o != null) {
                    mediaControlManager.f12182O000000o.setPlaybackState(new PlaybackState.Builder().setState(1, 0, 1.0f).build());
                }
                if (Build.VERSION.SDK_INT >= 14 && mediaControlManager.O00000Oo != null) {
                    mediaControlManager.O00000Oo.setPlaybackState(1);
                }
            }
        }

        public final void O000000o() {
            XmPlayerService playerSrvice;
            Track track;
            String str;
            String str2;
            Track track2;
            ilk.O000000o("onPlayStart XmPlayerService 294:" + System.currentTimeMillis());
            if (XmPlayerService.this.mPlayStartCallBack != null && XmPlayerService.this.mPlayStartCallBack.O000000o()) {
                return;
            }
            if (XmPlayerService.this.mWillPause) {
                XmPlayerService xmPlayerService = XmPlayerService.this;
                xmPlayerService.mWillPause = false;
                xmPlayerService.pausePlay();
                return;
            }
            XmPlayerService.this.removeCheckIsPauseTime();
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onPlayStart();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            boolean O000000o2 = iks.O000000o(XmPlayerService.this.mAppCtx);
            ikt O000000o3 = ikt.O000000o(XmPlayerService.this.mAppCtx);
            NotificationManager notificationManager = XmPlayerService.this.mNotificationManager;
            Notification notification = XmPlayerService.this.mNotification;
            int i2 = XmPlayerService.this.mNotificationId;
            if (notification != null) {
                O000000o3.O00000o = O000000o3.O000000o(O000000o3.O00000oO, O000000o2);
                if (Build.VERSION.SDK_INT >= 16) {
                    notification.bigContentView = O000000o3.O00000o;
                }
                O000000o3.O00000o0 = O000000o3.O00000Oo(O000000o3.O00000oO, O000000o2);
                notification.contentView = O000000o3.O00000o0;
                O000000o3.O0000O0o.O00000o = O000000o2;
                O000000o3.O0000O0o.O0000O0o = false;
                O000000o3.O000000o(O000000o3.O0000O0o, notificationManager, notification, i2);
            }
            XmPlayerService.this.sendPlayerStartBroadCast();
            Track track3 = (Track) XmPlayerService.this.f12208O000000o.O00000o;
            int O000000o4 = XmPlayerService.this.mPlayerControl.O000000o();
            boolean O00000Oo = XmPlayerService.this.mPlayerControl.O00000Oo();
            ilc ilc = XmPlayerService.this.mStatisticsManager;
            String curPlayUrl = XmPlayerService.this.getCurPlayUrl();
            if (!(track3 == null || ilc.O00000o0 == null)) {
                ilc.O00000oO = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (track3.f12166O000000o != ilc.O00000o0.O0000OOo || (track3.f12166O000000o == ilc.O00000o0.O0000OOo && XmPlayerService.getPlayerSrvice() != null && XmPlayerService.getPlayerSrvice().getXmPlayMode() == XmPlayListControl.PlayMode.PLAY_MODEL_SINGLE_LOOP)) {
                    ilc.O0000o0o = 0;
                    ilc.O0000o0 = false;
                    ilc.O0000o0O = 0;
                    ilc.O0000Ooo = 0;
                    ilc.O0000o00 = 0;
                    ilc.O00000o0.O000000o(0);
                    XmPlayerControl.O0000o0O = 0;
                    ilc.O00000o0.O0000o00 = currentTimeMillis;
                    if (!TextUtils.isEmpty(curPlayUrl)) {
                        ilc.O00000o0.O0000oO = curPlayUrl;
                    }
                    if ("schedule".equals(track3.O00000Oo) || "radio".equals(track3.O00000Oo)) {
                        if (track3.O0000OOo) {
                            ilc.O00000o0.O0000OOo = track3.f12166O000000o;
                            ilc.O00000o0.O00000oo = track3.O000O0oo;
                            ilc.O00000o0.O00000o = false;
                            ilc.O00000o0.O00000oO = true;
                        } else {
                            if (ilg.O000000o(track3.O00oOooO + "-" + track3.O00oOooo) != 0) {
                                ilc.O00000o0.O00000o = true;
                                ilc.O00000o0.O0000OOo = track3.f12166O000000o;
                                ilk.O00000Oo("StatisticsManager", "object :track" + ilc.O00000o0.O0000OOo);
                            } else {
                                if ("schedule".equals(track3.O00000Oo)) {
                                    ilc.O00000o0.O0000OOo = track3.O000O0Oo;
                                } else if ("radio".equals(track3.O00000Oo)) {
                                    ilc.O00000o0.O0000OOo = track3.f12166O000000o;
                                }
                                ilc.O00000o0.O00000o = false;
                                ilc.O00000o0.O00000oO = false;
                            }
                        }
                        ilk.O00000Oo("StatisticsManager", "object :radio" + ilc.O00000o0.O0000OOo + " isPlayTrack:" + ilc.O00000o0.O00000o + " isActivity:" + ilc.O00000o0.O00000oO);
                    } else if ("track".equals(track3.O00000Oo) || "tts".equals(track3.O00000Oo)) {
                        ilc.O00000o0.O00000o = true;
                        ilc.O00000o0.O0000OOo = track3.f12166O000000o;
                        ilc.O00000o0.O0000O0o = 1;
                        if (track3.O0000oo != null) {
                            ilc.O00000o0.O0000Oo0 = track3.O0000oo.f12174O000000o;
                        }
                        ilk.O00000Oo("StatisticsManager", "object :track" + ilc.O00000o0.O0000OOo);
                    } else if ("live_flv".equals(track3.O00000Oo)) {
                        ilc.O00000o0.O00000o = true;
                        ilc.O00000o0.O0000OOo = track3.f12166O000000o;
                        ilc.O00000o0.O000O0OO = track3.O000OOoO;
                        if (track3.O000000o() != null) {
                            ilc.O00000o0.O000O0Oo = track3.O000000o().f12171O000000o;
                        }
                        ilc.O00000o0.O0000O0o = 4;
                    }
                    ilc.O00000o0.f1374O000000o = O00000Oo ^ true ? 1 : 0;
                    if (ilc.O00000Oo != null && ilc.O000000o(track3)) {
                        ilc.O00000o0.O0000oO0 = 1;
                        ilc.O00000Oo.O000000o(ilc.O00000o0);
                    } else if (ilc.O00000Oo != null && ilc.O00000Oo(track3)) {
                        ilc.O00000o0.O0000oO0 = 2;
                        ilc.O00000Oo.O000000o(ilc.O00000o0);
                    } else if (ilc.O00000Oo != null && ilc.O00000o0(track3)) {
                        ilc.O00000o0.O0000oO0 = 3;
                        ilc.O00000Oo.O000000o(ilc.O00000o0);
                    }
                }
                if (!ilc.O00000o0.O00000o) {
                    XmPlayerControl.O0000o0o = System.currentTimeMillis();
                } else {
                    XmPlayerControl.O0000o0o = (long) O000000o4;
                }
            }
            XmPlayerService.this.mPlayerControl.O00000oo();
            MediaControlManager mediaControlManager = XmPlayerService.this.mMediaControlManager;
            if (ikz.O000000o(mediaControlManager.O00000o).O00000oo()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    PlaybackState build = new PlaybackState.Builder().setActions(1591).setState(3, 0, 1.0f, SystemClock.elapsedRealtime()).build();
                    if (mediaControlManager.f12182O000000o != null) {
                        MediaSession mediaSession = mediaControlManager.f12182O000000o;
                        if (ikz.O000000o(mediaControlManager.O00000o).O00000oo() && mediaSession != null && Build.VERSION.SDK_INT >= 21) {
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.setComponent(new ComponentName(mediaControlManager.O00000o, WireControlReceiver.class));
                            mediaSession.setMediaButtonReceiver(PendingIntent.getBroadcast(mediaControlManager.O00000o.getApplicationContext(), 0, intent, 0));
                            AudioAttributes.Builder builder = new AudioAttributes.Builder();
                            builder.setUsage(1).setContentType(2);
                            mediaSession.setPlaybackToLocal(builder.build());
                        }
                        mediaControlManager.f12182O000000o.setActive(true);
                        mediaControlManager.f12182O000000o.setPlaybackState(build);
                    }
                    XmPlayerService playerSrvice2 = XmPlayerService.getPlayerSrvice();
                    if (!(playerSrvice2 == null || (track2 = (Track) playerSrvice2.getPlayListControl().O00000o) == null)) {
                        int i3 = mediaControlManager.O00000o.getResources().getDisplayMetrics().widthPixels;
                        int i4 = mediaControlManager.O00000o.getResources().getDisplayMetrics().heightPixels;
                        ilj.O000000o(mediaControlManager.O00000o, track2, 0, 0, new ilj.O00000Oo(track2) {
                            /* class com.ximalaya.ting.android.opensdk.player.mediacontrol.MediaControlManager.AnonymousClass2 */

                            /* renamed from: O000000o */
                            final /* synthetic */ Track f12184O000000o;

                            {
                                this.f12184O000000o = r2;
                            }

                            public final void O000000o(Bitmap bitmap) {
                                if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT >= 21) {
                                    MediaMetadata.Builder builder = new MediaMetadata.Builder();
                                    if (bitmap != null && !bitmap.isRecycled()) {
                                        builder.putBitmap("android.media.metadata.ART", bitmap);
                                    }
                                    builder.putString("android.media.metadata.TITLE", this.f12184O000000o.O0000Oo0);
                                    if (this.f12184O000000o.O0000oo != null) {
                                        builder.putString("android.media.metadata.ALBUM", this.f12184O000000o.O0000oo.O00000Oo);
                                    }
                                    if (this.f12184O000000o.O000000o() != null) {
                                        builder.putString("android.media.metadata.ARTIST", this.f12184O000000o.O000000o().O00000Oo);
                                    }
                                    if (MediaControlManager.this.f12182O000000o != null) {
                                        MediaControlManager.this.f12182O000000o.setMetadata(builder.build());
                                    }
                                }
                            }
                        });
                    }
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    mediaControlManager.O00000o0 = (AudioManager) mediaControlManager.O00000o.getSystemService("audio");
                    mediaControlManager.O00000oO = new ComponentName(mediaControlManager.O00000o.getPackageName(), WireControlReceiver.class.getName());
                    mediaControlManager.O00000o0.registerMediaButtonEventReceiver(mediaControlManager.O00000oO);
                    Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent2.setComponent(mediaControlManager.O00000oO);
                    mediaControlManager.O00000Oo = new RemoteControlClient(PendingIntent.getBroadcast(mediaControlManager.O00000o, 0, intent2, 134217728));
                    mediaControlManager.O00000o0.registerRemoteControlClient(mediaControlManager.O00000Oo);
                    mediaControlManager.O00000Oo.setTransportControlFlags(669);
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
                    intentFilter.setPriority(C.MSG_CUSTOM_BASE);
                    mediaControlManager.O00000o.registerReceiver(mediaControlManager.O00000oo, intentFilter);
                    if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 21) {
                        if (!(Build.VERSION.SDK_INT < 14 || mediaControlManager.O00000Oo == null || (playerSrvice = XmPlayerService.getPlayerSrvice()) == null || playerSrvice.getPlayListControl() == null || (track = (Track) playerSrvice.getPlayListControl().O00000o) == null)) {
                            String str3 = track.O0000Oo0;
                            if (track.O0000oo != null) {
                                str = track.O0000oo.O00000Oo;
                            } else {
                                str = "";
                            }
                            if (track.O000000o() != null) {
                                str2 = track.O000000o().O00000Oo;
                            } else {
                                str2 = "";
                            }
                            long j = (long) track.O0000o0;
                            mediaControlManager.O000000o(str3, str, str2, j, null);
                            int i5 = mediaControlManager.O00000o.getResources().getDisplayMetrics().widthPixels;
                            int i6 = mediaControlManager.O00000o.getResources().getDisplayMetrics().heightPixels;
                            MediaControlManager.AnonymousClass3 r5 = r10;
                            Context context = mediaControlManager.O00000o;
                            MediaControlManager.AnonymousClass3 r10 = new ilj.O00000Oo(str3, str, str2, j) {
                                /* class com.ximalaya.ting.android.opensdk.player.mediacontrol.MediaControlManager.AnonymousClass3 */

                                /* renamed from: O000000o */
                                final /* synthetic */ String f12185O000000o;
                                final /* synthetic */ String O00000Oo;
                                final /* synthetic */ long O00000o;
                                final /* synthetic */ String O00000o0;

                                {
                                    this.f12185O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                    this.O00000o = r5;
                                }

                                public final void O000000o(Bitmap bitmap) {
                                    if (MediaControlManager.this.O00000Oo != null && bitmap != null) {
                                        MediaControlManager.this.O000000o(this.f12185O000000o, this.O00000Oo, this.O00000o0, this.O00000o, bitmap);
                                    }
                                }
                            };
                            ilj.O000000o(context, track, 0, 0, r5);
                        }
                        if (mediaControlManager.O00000Oo != null) {
                            mediaControlManager.O00000Oo.setPlaybackState(3);
                        }
                    }
                    mediaControlManager.O0000O0o = true;
                }
            }
            XmPlayerService.this.saveLastPlayTrackInAlbum(track3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c4, code lost:
            return;
         */
        public final void O000000o(int i, int i2) {
            ilk.O000000o("onPlayProgress XmPlayerService 336:" + System.currentTimeMillis());
            synchronized (XmPlayerService.class) {
                PlayableModel playableModel = XmPlayerService.this.f12208O000000o.O00000o;
                PlayableModel playableModel2 = XmPlayerService.this.mPlayerControl.O0000oO;
                if (playableModel != null) {
                    if (playableModel2 != null) {
                        if (playableModel.equals(playableModel2)) {
                            Track track = (Track) playableModel;
                            if (i > 0 && i < i2 - 1000) {
                                track.O00000o0 = i;
                                if (track.O00000o0()) {
                                    XmPlayerService.this.saveSoundHistoryPos(playableModel.f12166O000000o, i);
                                }
                            } else if (i >= i2 - 1000) {
                                track.O00000o0 = 0;
                                if (track.O00000o0()) {
                                    XmPlayerService.this.saveSoundHistoryPos(playableModel.f12166O000000o, 0);
                                }
                            }
                            int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                                try {
                                    XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i3).onPlayProgress(i, i2);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
                        }
                        ilc ilc = XmPlayerService.this.mStatisticsManager;
                        ilc.O0000OoO = i;
                        if (Math.abs(i - ilc.O0000OoO) > 1200) {
                            ilc.O00000oo = true;
                        } else {
                            ilc.O00000oo = false;
                        }
                        if (XmPlayerService.this.mPlayerControl != null) {
                            XmPlayerService.this.mPlayerControl.O00000oo();
                        }
                        XmPlayerService.this.checkIsPauseTime();
                        if (XmPlayerService.this.mAdsManager != null) {
                            ikn ikn = XmPlayerService.this.mAdsManager;
                            if (ikn.O00000oo != null) {
                                ikn.O00000oo.O000000o(i, i2);
                            }
                        }
                    }
                }
            }
        }

        public final void O00000Oo() {
            ilk.O000000o("onPlayPause XmPlayerService 393:" + System.currentTimeMillis());
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onPlayPause();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            ilk.O000000o("xmplayerservice onPlayPause" + new Date());
            ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, iks.O000000o(XmPlayerService.this.mAppCtx));
            XmPlayerService.this.sendPlayerPauseBroadCast();
            MediaControlManager mediaControlManager = XmPlayerService.this.mMediaControlManager;
            if (ikz.O000000o(mediaControlManager.O00000o).O00000oo()) {
                if (Build.VERSION.SDK_INT >= 21 && mediaControlManager.f12182O000000o != null) {
                    mediaControlManager.f12182O000000o.setPlaybackState(new PlaybackState.Builder().setState(2, 0, 1.0f).build());
                }
                if (Build.VERSION.SDK_INT >= 14 && mediaControlManager.O00000Oo != null) {
                    mediaControlManager.O00000Oo.setPlaybackState(2);
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
         arg types: [com.ximalaya.ting.android.opensdk.model.track.Track, int, com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$1$1, int]
         candidates:
          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
          _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a1, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0109, code lost:
            return;
         */
        public final void O00000o() {
            final boolean z;
            ilk.O000000o("onSoundPlayComplete XmPlayerService 417:" + System.currentTimeMillis());
            synchronized (XmPlayerService.class) {
                if (XmPlayerService.this.mPauseTimeInMills == -1) {
                    XmPlayerService.this.mPauseTimeInMills = 0;
                    z = false;
                } else {
                    z = true;
                }
                final int O000000o2 = XmPlayerService.this.f12208O000000o.O000000o(false);
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onSoundPlayComplete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
                ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, iks.O000000o(XmPlayerService.this.mAppCtx));
                XmPlayerService.this.sendPlayCompleteBroadCast();
                Track track = (Track) XmPlayerService.this.mLastModel;
                if (track == null || !track.O00000Oo()) {
                    if (O000000o2 >= 0) {
                        track = (Track) XmPlayerService.this.f12208O000000o.O00000Oo(O000000o2);
                    }
                    AnonymousClass1 r4 = new ikn.O00000Oo() {
                        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass1.AnonymousClass1 */

                        public final void O000000o(boolean z) {
                            if (O000000o2 >= 0) {
                                XmPlayerService.this.play(O000000o2, z, 1);
                                return;
                            }
                            if (XmPlayListControl.PlayMode.PLAY_MODEL_SINGLE.equals(XmPlayerService.this.f12208O000000o.O0000OoO)) {
                                XmPlayerService.this.f12208O000000o.O0000OoO = XmPlayListControl.PlayMode.PLAY_MODEL_LIST;
                            }
                            if (XmPlayerService.this.mPlayerStatusListener != null) {
                                XmPlayerService.this.mPlayerStatusListener.O000000o(XmPlayerService.this.mLastModel, (PlayableModel) null);
                            }
                        }
                    };
                    if (!XmPlayerService.this.isDLNAState && track != null && ((ilg.O000000o() || !"schedule".equals(track.O00000Oo)) && !"radio".equals(track.O00000Oo))) {
                        if (!"live_flv".equals(track.O00000Oo)) {
                            XmPlayerService.this.mAdsManager.O000000o(track, 4, (ikn.O00000Oo) r4, false);
                        }
                    }
                    XmPlayerService.this.mAdsManager.O00000o0();
                    ilk.O000000o("play 11:" + System.currentTimeMillis());
                    r4.O000000o(true);
                } else if (XmPlayerService.this.mPlayerStatusListener != null) {
                    XmPlayerService.this.mPlayerStatusListener.O000000o(XmPlayerService.this.mLastModel, (PlayableModel) null);
                }
            }
        }

        public final boolean O000000o(XmPlayerException xmPlayerException) {
            ilk.O000000o("onError XmPlayerService 475:" + System.currentTimeMillis());
            synchronized (XmPlayerService.class) {
                ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, iks.O000000o(XmPlayerService.this.mAppCtx));
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onError(xmPlayerException);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            return false;
        }

        public final void O000000o(int i) {
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i2).onBufferProgress(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
                ilc ilc = XmPlayerService.this.mStatisticsManager;
                int i3 = XmPlayerService.this.mPlayerControl.O0000OOo;
                int O000000o2 = XmPlayerService.this.mPlayerControl.O000000o();
                int i4 = i != 0 ? (i * i3) / 100 : 0;
                if (O000000o2 > 15000 && O000000o2 < i3 - 15000 && i > 5) {
                    if (O000000o2 >= i4) {
                        ilc.O0000o0 = true;
                        if (ilc.O0000o0 && !ilc.O00000oo) {
                            ilc.O0000o0O++;
                            ilc.O0000Ooo = System.currentTimeMillis();
                        }
                    } else if (O000000o2 < i4 + 3000 && ilc.O0000o0) {
                        ilc.O0000o00 = System.currentTimeMillis();
                        if (ilc.O0000Ooo != 0) {
                            ilc.O0000o0o += ilc.O0000o00 - ilc.O0000Ooo;
                            ilc.O0000o0 = false;
                        }
                    }
                }
            }
        }

        public final void O00000oo() {
            XmPlayerService.this.startCheckIsPauseTime();
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onBufferingStart();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
        }

        public final void O0000O0o() {
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i).onBufferingStop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
        }
    };
    public ilc mStatisticsManager;
    public boolean mWillPause = false;

    public static final Intent getIntent(Context context) {
        return new Intent(context, XmPlayerService.class);
    }

    @SuppressLint({"NewApi"})
    public void onCreate() {
        super.onCreate();
        O000000o();
        ilk.O00000Oo("XmPlayerService", "---onCreate");
    }

    private void O000000o() {
        mService = this;
        ilp.O00000Oo(this);
        if (this.O0000Oo0 == null) {
            if (ilg.O000000o()) {
                this.O0000Oo0 = new ima() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass3 */

                    public final String[][] O000000o(String str) {
                        return iiu.O000000o(str);
                    }

                    public final String O00000Oo(String str) {
                        PlayableModel playableModel;
                        String str2;
                        if (TextUtils.isEmpty(str) || (playableModel = XmPlayerService.this.getPlayableModel()) == null) {
                            return null;
                        }
                        Track track = (Track) playableModel;
                        if (!track.O000O0o || !str.contains("is_charge")) {
                            return null;
                        }
                        if (ilg.O000000o()) {
                            str2 = iiu.O000000o(track);
                        } else {
                            str2 = ilo.O000000o(track.f12166O000000o);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            XmPlayerService.this.mPlayerControl.O0000Oo0 = str2;
                        }
                        return str2;
                    }

                    public final void O000000o(String str, String str2, String str3) {
                        try {
                            Class.forName("com.sina.util.dnscache.DNSCache").getDeclaredMethod("setBadIp", String.class, String.class, String.class).invoke(null, str, str2, str3);
                        } catch (Exception unused) {
                        }
                    }
                };
            } else {
                this.O0000Oo0 = ijc.O000000o(this);
            }
            imj.O000000o(this.O0000Oo0);
        }
        imj.O000000o(iit.O0000OOo());
        if (this.mAppCtx == null) {
            this.mAppCtx = getApplicationContext();
        }
        if (this.O0000Oo == null) {
            this.O0000Oo = new WidgetProvider();
        }
        if (this.O00000oO == null) {
            this.O00000oO = ikz.O000000o(this.mAppCtx);
        }
        if (this.mPlayerControl == null) {
            this.mPlayerControl = new XmPlayerControl(this.mAppCtx);
            XmPlayerControl xmPlayerControl = this.mPlayerControl;
            xmPlayerControl.O00000o = this.mPlayerStatusListener;
            xmPlayerControl.O000000o(this.O0000OOo);
            this.mPlayerControl.O0000o0 = this.O0000o0o;
        }
        if (this.f12208O000000o == null) {
            this.f12208O000000o = new XmPlayListControl();
        }
        if (this.O00000o == null) {
            this.O00000o = new XmPlayerImpl();
        }
        if (this.O00000Oo == null) {
            this.O00000Oo = getSharedPreferences("play_history_record", 0);
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = getSharedPreferences("play_track_history_record", 0);
        }
        if (this.mPlayerAudioFocusControl == null) {
            this.mPlayerAudioFocusControl = new XmPlayerAudioFocusControl(this.mAppCtx);
        }
        this.mStatisticsManager = ilc.O000000o();
        this.mStatisticsManager.O0000O0o = this;
        this.mAdsManager = ikn.O000000o(this.mAppCtx);
        this.mAdsManager.f1404O000000o = this.O0000Ooo;
        this.mNotificationManager = (NotificationManager) this.mAppCtx.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("com.ximalaya.android.sdk", "播放通知栏", 4);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(false);
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
        if (this.mMediaControlManager == null) {
            try {
                this.mMediaControlManager = new MediaControlManager(this);
                this.mMediaControlManager.O000000o();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.O0000O0o == null) {
            this.O0000O0o = new ikb();
            imj.O000000o(this.O0000O0o);
        }
        ijg.O000000o().O000000o(mService.getApplicationContext());
    }

    public static XmPlayerService getPlayerSrvice() {
        return (XmPlayerService) mService;
    }

    public XmPlayerImpl getPlayerImpl() {
        return this.O00000o;
    }

    public void setVolume(float f, float f2) {
        XmPlayerControl xmPlayerControl = this.mPlayerControl;
        if (xmPlayerControl != null) {
            xmPlayerControl.O000000o(f, f2);
        }
    }

    public boolean isPlaying() {
        XmPlayerControl xmPlayerControl = this.mPlayerControl;
        boolean z = xmPlayerControl != null && xmPlayerControl.O00000oO == 3;
        ikn ikn = this.mAdsManager;
        return z || (ikn != null ? ikn.O000000o() : false);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        O000000o();
        iiu.O000000o();
        return 1;
    }

    public IBinder onBind(Intent intent) {
        O000000o();
        iiu.O000000o();
        ilk.O00000Oo("XmPlayerService", "onBind " + this.O00000o.hashCode());
        return this.O00000o;
    }

    public void closeNotification() {
        if (this.mNotificationManager != null) {
            stopForeground(true);
            this.mNotificationManager.cancel(this.mNotificationId);
            ilk.O000000o((Object) ("process closeNotification mNotificationId:" + this.mNotificationId));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
    public void onDestroy() {
        SharedPreferences sharedPreferences;
        ilk.O00000Oo("XmPlayerService", "---onDestroy");
        super.onDestroy();
        closeNotification();
        sendPlayerPauseBroadCast();
        stopPlay();
        stopForeground(true);
        MediaControlManager mediaControlManager = this.mMediaControlManager;
        if (ikz.O000000o(mediaControlManager.O00000o).O00000oo()) {
            if (Build.VERSION.SDK_INT >= 21 && mediaControlManager.f12182O000000o != null) {
                mediaControlManager.f12182O000000o.setActive(false);
                mediaControlManager.f12182O000000o.release();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                AudioManager audioManager = (AudioManager) mediaControlManager.O00000o.getSystemService("audio");
                if (audioManager != null) {
                    if (mediaControlManager.O00000oO != null) {
                        audioManager.unregisterMediaButtonEventReceiver(mediaControlManager.O00000oO);
                    }
                    if (mediaControlManager.O00000Oo != null) {
                        audioManager.unregisterRemoteControlClient(mediaControlManager.O00000Oo);
                    }
                }
                if (mediaControlManager.O00000oo != null && mediaControlManager.O0000O0o) {
                    try {
                        mediaControlManager.O00000o.unregisterReceiver(mediaControlManager.O00000oo);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        XmPlayerControl xmPlayerControl = this.mPlayerControl;
        xmPlayerControl.O00000oO = 8;
        if (xmPlayerControl.f12199O000000o != null) {
            try {
                if (xmPlayerControl.f12199O000000o != null) {
                    xmPlayerControl.f12199O000000o.O000000o((imk.O00000Oo) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O00000o0) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O0000Oo) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O0000o00) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O00000o) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O0000O0o) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O0000Oo0) null);
                    xmPlayerControl.f12199O000000o.O000000o((imk.O0000OOo) null);
                }
                xmPlayerControl.f12199O000000o.O0000Oo0();
                try {
                    xmPlayerControl.f12199O000000o.O0000Oo();
                } catch (Exception e) {
                    e = e;
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                try {
                    xmPlayerControl.f12199O000000o.O0000Oo();
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                try {
                    xmPlayerControl.f12199O000000o.O0000Oo();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                xmPlayerControl.f12199O000000o = null;
                throw th;
            }
            xmPlayerControl.f12199O000000o = null;
        }
        xmPlayerControl.O0000oOo = 1.0f;
        xmPlayerControl.O0000oo0 = 0.0f;
        xmPlayerControl.O0000oo = 1.0f;
        synchronized (ilc.f1433O000000o) {
            XmPlayerControl.O0000o0O = 0;
            XmPlayerControl.O0000o0o = 0;
        }
        ikn ikn = this.mAdsManager;
        if (ikn.O00000o0 != null) {
            ikn.O00000o0.O00000Oo();
        }
        if (ikn.O00000oO != null) {
            ikn.O00000oO.O00000Oo = true;
        }
        ikn.O00000o = false;
        ikn.O00000o0 = null;
        ikn.O00000oO = null;
        ikn.f1404O000000o = null;
        if (ikn.O00000oo != null) {
            ikn.O00000oo.O000000o();
        }
        ikt.O00000oO();
        mService = null;
        this.mPlayerDispatcher.kill();
        this.mCustomDataCallBack.kill();
        this.mAdsDispatcher.kill();
        imj.O000000o();
        this.O0000Oo0 = null;
        ilj.O000000o();
        ime.O00000Oo();
        iit.O0000O0o();
        MediadataCrytoUtil.O000000o();
        if (!(ike.f1384O000000o == null || ike.f1384O000000o.O00000o == null)) {
            ike.f1384O000000o.O00000o.clear();
        }
        if (ilg.O000000o() && (sharedPreferences = this.mAppCtx.getSharedPreferences("plugin_share_file", 4)) != null && sharedPreferences.getBoolean("need_exit_process_play", false)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("need_exit_process_play", false);
            ilk.O00000Oo("ApplicationManager", "kill process play : plugin_share_file ".concat(String.valueOf(edit.commit())));
            Process.killProcess(Process.myPid());
            System.exit(0);
            return;
        }
        return;
        e.printStackTrace();
        xmPlayerControl.f12199O000000o = null;
        xmPlayerControl.O0000oOo = 1.0f;
        xmPlayerControl.O0000oo0 = 0.0f;
        xmPlayerControl.O0000oo = 1.0f;
        synchronized (ilc.f1433O000000o) {
        }
    }

    public String getTrackUrl(Track track) {
        String str;
        String O000000o2 = O000000o(track);
        if (!TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        boolean O00000Oo2 = NetworkType.O00000Oo(this.mAppCtx);
        if (O00000Oo2) {
            O00000Oo2 = !this.O00000oO.O000000o();
        }
        if (this.f12208O000000o.O000000o() == 2) {
            if (O00000Oo2) {
                if (TextUtils.isEmpty(track.O000OOo)) {
                    str = track.O0000oO0;
                } else {
                    str = track.O0000oO;
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String str2 = track.O0000oO0;
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                String str3 = track.O0000oO;
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                String str4 = track.O000OOo;
                if (!TextUtils.isEmpty(str4)) {
                    return str4;
                }
                String str5 = track.O0000o0o;
                if (TextUtils.isEmpty(str5)) {
                    return track.O0000o;
                }
                return str5;
            }
            String str6 = track.O000OOo;
            if (!TextUtils.isEmpty(str6)) {
                return str6;
            }
            String str7 = track.O0000oO;
            if (!TextUtils.isEmpty(str7)) {
                return str7;
            }
            String str8 = track.O0000oO0;
            if (!TextUtils.isEmpty(str8)) {
                return str8;
            }
            String str9 = track.O0000o;
            if (TextUtils.isEmpty(str9)) {
                return track.O0000o0o;
            }
            return str9;
        } else if (this.f12208O000000o.O000000o() != 3) {
            return O000000o2;
        } else {
            if (this.O00000oO.O00000Oo()) {
                if (O00000Oo2) {
                    String str10 = track.O000OO;
                    if (TextUtils.isEmpty(str10)) {
                        return track.O000OOo0;
                    }
                    return str10;
                }
                String str11 = track.O000OOo0;
                if (TextUtils.isEmpty(str11)) {
                    return track.O000OO;
                }
                return str11;
            } else if (O00000Oo2) {
                String str12 = track.O000OO0o;
                if (TextUtils.isEmpty(str12)) {
                    return track.O000OOOo;
                }
                return str12;
            } else {
                String str13 = track.O000OOOo;
                return TextUtils.isEmpty(str13) ? track.O000OO0o : str13;
            }
        }
    }

    private String O000000o(Radio radio) {
        boolean O00000Oo2 = NetworkType.O00000Oo(this.mAppCtx);
        if (O00000Oo2) {
            O00000Oo2 = !this.O00000oO.O000000o();
        }
        if (this.O00000oO.O00000Oo()) {
            if (O00000Oo2) {
                String str = radio.O0000o0;
                if (TextUtils.isEmpty(str)) {
                    return radio.O0000o0o;
                }
                return str;
            }
            String str2 = radio.O0000o0o;
            if (TextUtils.isEmpty(str2)) {
                return radio.O0000o0;
            }
            return str2;
        } else if (O00000Oo2) {
            String str3 = radio.O0000o00;
            if (TextUtils.isEmpty(str3)) {
                return radio.O0000o0O;
            }
            return str3;
        } else {
            String str4 = radio.O0000o00;
            return TextUtils.isEmpty(str4) ? radio.O0000o0O : str4;
        }
    }

    private int O000000o(long j) {
        if (!this.O00000oO.f1428O000000o.getBoolean("KEY_BREAKPOINT_RESUME", true) || j <= 0) {
            return -1;
        }
        try {
            return this.O00000Oo.getInt(String.valueOf(j), -1);
        } catch (Exception unused) {
            return (int) this.O00000Oo.getLong(String.valueOf(j), -1);
        }
    }

    @SuppressLint({"NewApi"})
    public void saveSoundHistoryPos(long j, int i) {
        if (j > 0) {
            SharedPreferences.Editor edit = this.O00000Oo.edit();
            edit.putInt(String.valueOf(j), i);
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public String getSoundHistoryPos(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                split[i] = String.valueOf(O000000o(Long.valueOf(split[i]).longValue()));
            }
            return TextUtils.join(",", split);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getLastPlayTrackInAlbumInner(String str) {
        try {
            String string = this.O00000o0.getString(str, null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string.split(this.O0000o0)[0];
        } catch (Exception unused) {
            return null;
        }
    }

    public void playTrack(final Track track, final boolean z) {
        ilk.O000000o("playTrack 13:" + System.currentTimeMillis());
        String O000000o2 = O000000o(track);
        if (!(track.O000O0o && !track.O00oOoOo) || !TextUtils.isEmpty(O000000o2)) {
            ilk.O000000o("playTrack 16:" + System.currentTimeMillis());
            if (TextUtils.isEmpty(O000000o2)) {
                O000000o2 = getTrackUrl(track);
            }
            if (!TextUtils.isEmpty(O000000o2) || (track.O0000oOO == 4 && track.O000OOoo)) {
                playTrackInner(O000000o2, track, z);
                return;
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(track.f12166O000000o);
            hashMap.put("track_id", sb.toString());
            iit.O0000Oo0(hashMap, new iiw<ijy>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass5 */

                public final /* synthetic */ void O000000o(Object obj) {
                    XmPlayerService xmPlayerService = XmPlayerService.this;
                    xmPlayerService.playTrackInner(xmPlayerService.getTrackUrlByBaseInfo((ijy) obj), track, z);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService.this.playTrackInner(null, track, z);
                }
            });
            return;
        }
        ikw ikw = this.mPlayerStatusListener;
        if (ikw != null) {
            ikw.O00000oo();
        }
        iit.O000000o(new HashMap(), new iiw<String>() {
            /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                ilk.O000000o("playTrack 14:" + System.currentTimeMillis());
                if (XmPlayerService.this.mPlayerStatusListener != null) {
                    XmPlayerService.this.mPlayerStatusListener.O0000O0o();
                }
                XmPlayerService.this.playTrackInner(str, track, z);
            }

            public final void O000000o(int i, String str) {
                ilk.O000000o("playTrack 15:" + System.currentTimeMillis());
                if (XmPlayerService.this.mPlayerStatusListener != null) {
                    XmPlayerService.this.mPlayerStatusListener.O0000O0o();
                }
                XmPlayerService.this.playTrackInner(null, track, z);
                if (i == 726) {
                    track.O000O0o0 = false;
                    XmPlayerService.this.mPlayerStatusListener.O000000o(track, (PlayableModel) null);
                }
                ilk.O000000o((Object) ("playTrack updateTrackForPlay error code:" + i + " msg:" + str));
            }
        }, track);
    }

    public String getTrackUrlByBaseInfo(ijy ijy) {
        boolean O00000Oo2 = NetworkType.O00000Oo(this.mAppCtx);
        if (O00000Oo2) {
            O00000Oo2 = !this.O00000oO.O000000o();
        }
        if (O00000Oo2) {
            String str = ijy.O00000Oo;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = ijy.O00000o0;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            String str3 = ijy.O00000o;
            if (TextUtils.isEmpty(str3)) {
                return ijy.O00000oO;
            }
            return str3;
        }
        String str4 = ijy.O00000o0;
        if (!TextUtils.isEmpty(str4)) {
            return str4;
        }
        String str5 = ijy.O00000Oo;
        if (!TextUtils.isEmpty(str5)) {
            return str5;
        }
        String str6 = ijy.O00000o;
        return TextUtils.isEmpty(str6) ? ijy.O00000oO : str6;
    }

    public boolean playPre() {
        ilk.O000000o("playPre:" + Arrays.toString(Thread.currentThread().getStackTrace()) + ":playPre");
        int O00000o02 = this.f12208O000000o.O00000o0();
        if (O00000o02 >= 0) {
            return play(O00000o02, true, 2);
        }
        return false;
    }

    public boolean playNext() {
        int O000000o2 = this.f12208O000000o.O000000o(true);
        ilk.O000000o("playNext index:".concat(String.valueOf(O000000o2)));
        if (O000000o2 >= 0) {
            return play(O000000o2, true, 2);
        }
        return false;
    }

    public boolean playCurrent() {
        int i = this.f12208O000000o.O0000Oo;
        if (i >= 0) {
            return play(i);
        }
        return false;
    }

    public boolean pausePlay() {
        ilk.O000000o("pausePlay0:" + Arrays.toString(Thread.currentThread().getStackTrace()) + ":0pausePlay");
        if (this.mAdsManager.O00000o) {
            ikn ikn = this.mAdsManager;
            if (ikn.O00000o0 != null) {
                iki iki = ikn.O00000o0;
                ilk.O000000o("Ad pausePlay 0:" + System.currentTimeMillis());
                try {
                    if (iki.O00000o == 2) {
                        iki.f1386O000000o.pause();
                        iki.O00000o = 3;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    iki.O00000o = -1;
                }
            }
            ikw ikw = this.mPlayerStatusListener;
            if (ikw != null) {
                ikw.O00000Oo();
            }
            return true;
        }
        XmPlayerAudioFocusControl xmPlayerAudioFocusControl = this.mPlayerAudioFocusControl;
        if (xmPlayerAudioFocusControl != null) {
            xmPlayerAudioFocusControl.O00000o = false;
        }
        return this.mPlayerControl.O00000Oo(true);
    }

    public boolean stopPlay() {
        ilk.O000000o("stopPlay:" + Arrays.toString(Thread.currentThread().getStackTrace()) + ":stopPlay");
        XmPlayerAudioFocusControl xmPlayerAudioFocusControl = this.mPlayerAudioFocusControl;
        if (xmPlayerAudioFocusControl != null) {
            if (ikz.O000000o(xmPlayerAudioFocusControl.f12193O000000o).O00000o0()) {
                xmPlayerAudioFocusControl.O00000Oo.abandonAudioFocus(xmPlayerAudioFocusControl.O00000oO);
            }
            this.mPlayerAudioFocusControl.O00000o = false;
        }
        this.mLastModel = null;
        return this.mPlayerControl.O00000o();
    }

    public void setSoundTouchAllParams(float f, float f2, float f3) {
        XmPlayerControl xmPlayerControl = this.mPlayerControl;
        if (xmPlayerControl != null) {
            xmPlayerControl.O0000oOo = f;
            xmPlayerControl.O0000oo0 = f2;
            xmPlayerControl.O0000oo = f3;
            if (xmPlayerControl.f12199O000000o != null) {
                ilk.O000000o((Object) ("setSoundTouchAllParams2 tempo:" + f + " pitch:" + f2 + " rate:" + f3));
                xmPlayerControl.f12199O000000o.O000000o(f, f2, f3);
            }
        }
    }

    public void requestAudioFocusControl() {
        this.mPlayerAudioFocusControl.O00000o0();
    }

    public boolean startPlay(boolean z) {
        ilk.O000000o("startPlay:" + Arrays.toString(Thread.currentThread().getStackTrace()) + ":startPlay");
        this.mPlayerAudioFocusControl.O00000o0();
        ikn ikn = this.mAdsManager;
        if (ikn == null || !ikn.O00000o) {
            XmPlayerControl xmPlayerControl = this.mPlayerControl;
            if (xmPlayerControl == null) {
                ilk.O000000o("startPlay 3");
                return false;
            } else if (!z || xmPlayerControl.O00000oO != 9) {
                boolean O000000o2 = this.mPlayerControl.O000000o(true);
                ilk.O000000o("startPlay 5 ret:".concat(String.valueOf(O000000o2)));
                if (O000000o2) {
                    return O000000o2;
                }
                int i = this.f12208O000000o.O0000Oo;
                ilk.O000000o("startPlay 6 index:".concat(String.valueOf(i)));
                if (i < 0) {
                    return O000000o2;
                }
                ilk.O000000o("startPlay 7");
                return play(i);
            } else {
                ilk.O000000o("startPlay 4");
                this.mPlayerControl.O00000oo = true;
                return false;
            }
        } else {
            ilk.O000000o("startPlay 0");
            int O00000o2 = this.mAdsManager.O00000o();
            if (O00000o2 != 1 && O00000o2 != 3) {
                ilk.O000000o("startPlay 2");
            } else if (this.mAdsManager.O00000o0 != null) {
                this.mAdsManager.O00000Oo();
                ilk.O000000o("startPlay 1");
                ikw ikw = this.mPlayerStatusListener;
                if (ikw != null) {
                    ikw.O000000o();
                }
                return true;
            }
            return false;
        }
    }

    public boolean startPlay() {
        return startPlay(false);
    }

    public boolean play(int i) {
        return play(i, true);
    }

    public boolean play(int i, boolean z) {
        return play(i, z, 0);
    }

    @Deprecated
    public boolean playRadio(Radio radio) {
        this.mPlayerAudioFocusControl.O00000o0();
        if (this.O00000oO.O00000Oo() || radio == null) {
            return false;
        }
        try {
            if (radio.equals(this.mLastModel)) {
                return false;
            }
            this.mPlayerControl.O00000o();
            this.f12208O000000o.O000000o(radio);
            this.mPlayerStatusListener.O000000o(this.mLastModel, radio);
            this.mPlayerControl.O00000Oo(O000000o(radio), 0);
            this.mLastModel = radio;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b3 A[Catch:{ Exception -> 0x016a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5 A[Catch:{ Exception -> 0x016a }] */
    public boolean play(int i, boolean z, int i2) {
        boolean z2;
        ilk.O000000o("play 0:" + System.currentTimeMillis());
        if (i < 0 || i >= this.f12208O000000o.O0000Ooo) {
            ilk.O00000o0("XmPlayerService", "Index Out Of Bound, index:" + i + ", total:" + this.f12208O000000o.O0000Ooo);
            this.mLastModel = null;
        } else {
            try {
                this.f12208O000000o.O000000o(i);
                Track track = (Track) this.f12208O000000o.O00000Oo(i);
                if (track == null) {
                    ilk.O00000o0("XmPlayerService", "Get current model return null, play fail");
                    this.mLastModel = null;
                    ilk.O000000o("play 1:" + System.currentTimeMillis());
                    return false;
                }
                int indexOf = this.f12208O000000o.O00000o0.indexOf(this.mLastModel);
                PlayableModel playableModel = indexOf >= 0 ? this.f12208O000000o.O00000o0.get(indexOf) : null;
                if (playableModel == null) {
                    playableModel = this.mLastModel;
                }
                if ((playableModel instanceof Track) && ((Track) playableModel).O0000oo != null) {
                    ilk.O000000o((Object) ("Test statistic track" + ((Track) playableModel).O0000oo.O00000oo));
                }
                if (this.mLastModel != null) {
                    if (track.equals(this.mLastModel)) {
                        z2 = false;
                        if (this.mLastModel != null && track.equals(this.mLastModel)) {
                            if (track.O000O0o0 != ((Track) this.mLastModel).O000O0o0) {
                                if (!(this.mLastModel == null || track.O0000oo == null || ((Track) this.mLastModel).O0000oo == null || track.O0000oo.f12174O000000o == ((Track) this.mLastModel).O0000oo.f12174O000000o)) {
                                    this.mPlayerStatusListener.O000000o(playableModel, track);
                                }
                                ilk.O000000o("play 3:" + System.currentTimeMillis());
                                this.mLastModel = track;
                                if (!z) {
                                    ilk.O000000o("play 5:" + System.currentTimeMillis());
                                    return false;
                                } else if (this.mAdsManager.O00000o) {
                                    int O00000o2 = this.mAdsManager.O00000o();
                                    if (O00000o2 == 1 || O00000o2 == 3) {
                                        this.mAdsManager.O00000Oo();
                                    }
                                    ilk.O000000o("play 4:" + System.currentTimeMillis());
                                    return false;
                                } else {
                                    boolean O000000o2 = this.mPlayerControl.O000000o(true);
                                    return !O000000o2 ? O000000o(this.mLastModel, z, i2, z2) : O000000o2;
                                }
                            }
                        }
                        this.mPlayerControl.O00000Oo(false);
                        this.mPlayerStatusListener.O000000o(playableModel, track);
                        this.mLastModel = track;
                        ilk.O000000o("play 2:" + System.currentTimeMillis());
                        return O000000o(track, z, i2, z2);
                    }
                }
                z2 = true;
                if (track.O000O0o0 != ((Track) this.mLastModel).O000O0o0) {
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.mLastModel = null;
                new StringBuilder("play(0):").append(e.toString());
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014b, code lost:
        if (r0.O0000O0o < 0) goto L_0x014d;
     */
    public void setPlayList(Map<String, String> map, List<Track> list) {
        XmPlayListControl xmPlayListControl = this.f12208O000000o;
        if (map != null) {
            if (map.containsKey("local_is_asc")) {
                xmPlayListControl.O0000o0 = Boolean.parseBoolean(map.remove("local_is_asc"));
            } else {
                if (map.containsKey("asc")) {
                    xmPlayListControl.O0000o0 = Boolean.parseBoolean(map.get("asc"));
                }
                if (map.containsKey("isAsc")) {
                    xmPlayListControl.O0000o0 = Boolean.parseBoolean(map.get("isAsc"));
                }
            }
            if (!map.containsKey("track_base_url")) {
                map = null;
            }
        }
        xmPlayListControl.f12189O000000o = 2;
        xmPlayListControl.O00000Oo();
        synchronized (xmPlayListControl.O00000o0) {
            xmPlayListControl.O0000Oo0 = 0;
            xmPlayListControl.O00000oO = map;
            if (xmPlayListControl.O00000oO != null) {
                if (map.containsKey("trackId")) {
                    map.remove("trackId");
                }
                String remove = xmPlayListControl.O00000oO.remove("positive_seq");
                if (!TextUtils.isEmpty(remove)) {
                    xmPlayListControl.O0000o0O = Boolean.valueOf(remove).booleanValue();
                }
                if (!xmPlayListControl.O00000oO.containsKey("total_page") || xmPlayListControl.O00000oO.get("total_page") == null) {
                    xmPlayListControl.O0000Oo0 = 0;
                } else {
                    xmPlayListControl.O0000Oo0 = Integer.valueOf(xmPlayListControl.O00000oO.remove("total_page")).intValue() + 1;
                }
                if (!xmPlayListControl.O00000oO.containsKey("count") || xmPlayListControl.O00000oO.get("count") == null) {
                    xmPlayListControl.O0000OOo = 0;
                } else {
                    xmPlayListControl.O0000OOo = Integer.valueOf(xmPlayListControl.O00000oO.get("count")).intValue();
                }
                if (xmPlayListControl.O0000OOo <= 0) {
                    xmPlayListControl.O0000OOo = iit.O00000o0;
                }
                if (!xmPlayListControl.O00000oO.containsKey("page") || xmPlayListControl.O00000oO.get("page") == null) {
                    xmPlayListControl.O00000oo = 0;
                } else {
                    xmPlayListControl.O00000oo = Integer.valueOf(xmPlayListControl.O00000oO.get("page")).intValue();
                }
                if (xmPlayListControl.O00000oo <= 0) {
                    xmPlayListControl.O00000oo = list.size() / xmPlayListControl.O0000OOo;
                }
                if (xmPlayListControl.O00000oO.containsKey("pre_page") && xmPlayListControl.O00000oO.get("pre_page") != null) {
                    xmPlayListControl.O0000O0o = Integer.valueOf(xmPlayListControl.O00000oO.get("pre_page")).intValue();
                }
                xmPlayListControl.O0000O0o = 0;
            } else {
                xmPlayListControl.O0000OOo = 0;
                xmPlayListControl.O00000oo = 0;
                xmPlayListControl.O0000O0o = 0;
            }
            xmPlayListControl.O00000o0.clear();
            xmPlayListControl.O00000o0.addAll(list);
            xmPlayListControl.O0000Ooo = xmPlayListControl.O00000o0.size();
            if (xmPlayListControl.O00000o0.contains(xmPlayListControl.O00000o)) {
                xmPlayListControl.O0000Oo = xmPlayListControl.O00000o0.indexOf(xmPlayListControl.O00000o);
            } else {
                xmPlayListControl.O0000Oo = -1;
            }
        }
    }

    public int getPlayListSize() {
        List<Track> list = this.f12208O000000o.O00000o0;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public synchronized boolean isLossAudioFocus() {
        return this.isLossAudioFocus;
    }

    public synchronized void setLossAudioFocus(boolean z) {
        this.isLossAudioFocus = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
     arg types: [com.ximalaya.ting.android.opensdk.model.track.Track, int, com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$6, int]
     candidates:
      _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
      _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void */
    private boolean O000000o(PlayableModel playableModel, boolean z, int i, boolean z2) throws Exception {
        setLossAudioFocus(false);
        if (z) {
            this.mPlayerAudioFocusControl.O00000o0();
        }
        if (!z) {
            boolean O000000o2 = iks.O000000o(this.mAppCtx);
            ikt.O000000o(this.mAppCtx).O000000o(this.f12208O000000o, this.mNotificationManager, this.mNotification, this.mNotificationId, O000000o2);
            ikt.O000000o(this.mAppCtx).O000000o(this.mNotificationManager, this.mNotification, this.mNotificationId, O000000o2);
        }
        ilk.O000000o("play 6_0 mPlayerControl.resetMediaPlayer:" + System.currentTimeMillis());
        this.mPlayerControl.O00000o0();
        if (playableModel instanceof Track) {
            final Track track = (Track) playableModel;
            if (z) {
                ilk.O000000o("play 6:" + System.currentTimeMillis());
                AnonymousClass6 r10 = new ikn.O00000Oo() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass6 */

                    public final void O000000o(boolean z) {
                        ilk.O000000o("play 7:" + System.currentTimeMillis());
                        try {
                            if (XmPlayerService.this.isLossAudioFocus()) {
                                XmPlayerService.this.setLossAudioFocus(false);
                                XmPlayerService.this.playTrack(track, false);
                                if (XmPlayerService.this.mPlayerStatusListener != null) {
                                    XmPlayerService.this.mPlayerStatusListener.O00000Oo();
                                    return;
                                }
                                return;
                            }
                            XmPlayerService.this.playTrack(track, z);
                        } catch (Exception e) {
                            e.printStackTrace();
                            XmPlayerService.this.mLastModel = null;
                            ilk.O000000o("play 8:" + System.currentTimeMillis());
                            new StringBuilder("playAdsCallback:").append(e.toString());
                        }
                    }
                };
                if (this.isDLNAState || ((!ilg.O000000o() && "schedule".equals(playableModel.O00000Oo)) || "radio".equals(playableModel.O00000Oo) || "live_flv".equals(playableModel.O00000Oo) || !z2)) {
                    this.mAdsManager.O00000o0();
                    ilk.O000000o("play 11:" + System.currentTimeMillis());
                    r10.O000000o(true);
                } else {
                    ilk.O000000o("play 12:" + System.currentTimeMillis());
                    this.mAdsManager.O000000o(track, i, (ikn.O00000Oo) r10, false);
                }
            } else {
                ilk.O000000o("play 9:" + System.currentTimeMillis());
                try {
                    playTrack(track, false);
                } catch (Exception e) {
                    ilk.O000000o("play 10:" + System.currentTimeMillis());
                    this.mLastModel = null;
                    e.printStackTrace();
                    new StringBuilder("playTrack:").append(e.toString());
                }
            }
            return true;
        } else if (!(playableModel instanceof Radio)) {
            return false;
        } else {
            this.mPlayerControl.O000000o(O000000o((Radio) playableModel), 0);
            return true;
        }
    }

    class XmPlayerImpl extends IXmPlayer.Stub {
        public long lastRequestTime;

        public int getDefultPageSize() throws RemoteException {
            return 20;
        }

        public boolean haveNextPlayList() throws RemoteException {
            return false;
        }

        public boolean havePrePlayList() throws RemoteException {
            return false;
        }

        XmPlayerImpl() {
        }

        public void setSoundTouchAllParams(float f, float f2, float f3) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() != null) {
                XmPlayerService.getPlayerSrvice().setSoundTouchAllParams(f, f2, f3);
            }
        }

        public boolean stopPlay() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().stopPlay();
        }

        public boolean playPre() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().playPre();
        }

        public boolean playNext() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().playNext();
        }

        public boolean setPlayIndex(int i) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().play(i, false);
        }

        public boolean play(int i) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().play(i);
        }

        public boolean pausePlay() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().pausePlay();
        }

        public boolean startPlay() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().startPlay();
        }

        public void registePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
            ilk.O00000Oo("XmPlayerService", "Process " + Binder.getCallingPid() + "has register PlayerListener");
            if (iXmPlayerEventDispatcher != null && XmPlayerService.this.mPlayerDispatcher != null) {
                XmPlayerService.this.mPlayerDispatcher.register(iXmPlayerEventDispatcher, new ikx.O000000o(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void unregistePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
            if (iXmPlayerEventDispatcher != null && XmPlayerService.this.mPlayerDispatcher != null) {
                XmPlayerService.this.mPlayerDispatcher.unregister(iXmPlayerEventDispatcher);
            }
        }

        public void setPlayMode(String str) throws RemoteException {
            if (XmPlayerService.this.f12208O000000o != null) {
                XmPlayerService.this.f12208O000000o.O0000OoO = XmPlayListControl.PlayMode.valueOf(str);
            }
        }

        public String getPlayMode() throws RemoteException {
            return XmPlayerService.this.f12208O000000o != null ? XmPlayerService.this.f12208O000000o.O0000OoO.toString() : "";
        }

        public void setPlayList(Map map, List<Track> list) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() != null) {
                XmPlayerService.getPlayerSrvice().setPlayList(map, list);
            }
        }

        public void addPlayList(List<Track> list) throws RemoteException {
            if (XmPlayerService.this.f12208O000000o != null) {
                XmPlayListControl xmPlayListControl = XmPlayerService.this.f12208O000000o;
                synchronized (xmPlayListControl.O00000o0) {
                    if (xmPlayListControl.O00000o0 == null) {
                        xmPlayListControl.O00000o0 = new ArrayList();
                    }
                    xmPlayListControl.O00000o0.addAll(list);
                    xmPlayListControl.O0000Ooo = xmPlayListControl.O00000o0.size();
                    if (xmPlayListControl.O00000o0.contains(xmPlayListControl.O00000o)) {
                        xmPlayListControl.O0000Oo = xmPlayListControl.O00000o0.indexOf(xmPlayListControl.O00000o);
                    }
                }
            }
        }

        public int getPlayerStatus() throws RemoteException {
            if (XmPlayerService.this.mAdsManager == null || XmPlayerService.this.mPlayerControl == null) {
                return 7;
            }
            if (XmPlayerService.this.mAdsManager.O00000o) {
                return 3;
            }
            return XmPlayerService.this.mPlayerControl.O00000oO;
        }

        public int getCurrIndex() throws RemoteException {
            if (XmPlayerService.this.f12208O000000o != null) {
                return XmPlayerService.this.f12208O000000o.O0000Oo;
            }
            return -1;
        }

        public Track getTrack(int i) throws RemoteException {
            return (Track) XmPlayerService.this.f12208O000000o.O00000Oo(i);
        }

        public int getPlaySourceType() throws RemoteException {
            return XmPlayerService.this.f12208O000000o.O000000o();
        }

        public Radio getRadio() throws RemoteException {
            XmPlayListControl xmPlayListControl = XmPlayerService.this.f12208O000000o;
            if (xmPlayListControl.O00000o instanceof Radio) {
                return (Radio) xmPlayListControl.O00000o;
            }
            return null;
        }

        public boolean seekTo(int i) throws RemoteException {
            if (XmPlayerService.this.mAdsManager.O00000o || XmPlayerService.this.f12208O000000o.O000000o() == 3) {
                return false;
            }
            XmPlayerControl xmPlayerControl = XmPlayerService.this.mPlayerControl;
            Track track = (Track) xmPlayerControl.O0000oO;
            if (!track.O00000Oo() || i < track.O000O0oO * 1000) {
                xmPlayerControl.O0000o = i;
                xmPlayerControl.O0000oO0 = true;
                int i2 = xmPlayerControl.O00000oO;
                if (i2 != 0) {
                    if (i2 != 9) {
                        if (i2 == 2 || i2 == 3 || i2 == 5) {
                            xmPlayerControl.f12199O000000o.O000000o(i);
                            return true;
                        } else if (i2 == 6) {
                            xmPlayerControl.f12199O000000o.O0000OOo();
                            if (xmPlayerControl.O00000o != null) {
                                xmPlayerControl.O00000o.O000000o();
                            }
                            xmPlayerControl.f12199O000000o.O000000o(i);
                            return true;
                        }
                    }
                } else if (xmPlayerControl.O0000o00) {
                    xmPlayerControl.O0000o00 = false;
                    int O000000o2 = xmPlayerControl.f12199O000000o.O000000o();
                    if (O000000o2 == 3 || O000000o2 == 7 || O000000o2 == 4 || O000000o2 == 5 || O000000o2 == 11) {
                        xmPlayerControl.O00000oO = 6;
                        xmPlayerControl.O000000o(false);
                        xmPlayerControl.f12199O000000o.O000000o(i);
                    }
                    return true;
                }
                xmPlayerControl.O0000O0o = i;
                return true;
            }
            xmPlayerControl.O00000Oo(true);
            xmPlayerControl.O00000o0.O000000o(xmPlayerControl.f12199O000000o, track.O000O0oO * 1000);
            xmPlayerControl.O00000Oo.O000000o();
            return false;
        }

        public int getDuration() throws RemoteException {
            return XmPlayerService.this.mPlayerControl.O0000OOo;
        }

        public boolean hasPreSound() throws RemoteException {
            int i;
            return XmPlayerService.this.f12208O000000o.O0000Ooo > 1 && (i = XmPlayerService.this.f12208O000000o.O0000Oo) > 0 && i + -1 >= 0;
        }

        public boolean hasNextSound() throws RemoteException {
            int i = XmPlayerService.this.f12208O000000o.O0000Ooo;
            if (i <= 1) {
                return false;
            }
            return XmPlayerService.this.f12208O000000o.O0000Oo + 1 < i || XmPlayerService.this.f12208O000000o.O0000o00;
        }

        public void setAppSecret(String str) throws RemoteException {
            ilk.O00000Oo("XmPlayerService", "setAppSecret ".concat(String.valueOf(str)));
            XmPlayerService.this.mAppSecret = str;
            iit.O000000o().O000000o(XmPlayerService.this.mAppCtx, XmPlayerService.this.mAppSecret);
        }

        public List<Track> getPlayList(int i) throws RemoteException {
            List<Track> list = XmPlayerService.this.f12208O000000o.O00000o0;
            if (list == null || list.size() < 30) {
                return list;
            }
            int size = list.size();
            int i2 = i * 30;
            int i3 = i2 + 30;
            if (size <= i2) {
                return null;
            }
            if (i3 > size) {
                i3 = i2 + (size % 30);
            }
            return list.subList(i2, i3);
        }

        public void setNotification(int i, Notification notification) throws RemoteException {
            if (notification != null) {
                try {
                    if (XmPlayerService.mService != null) {
                        ilk.O00000Oo("XmPlayerService", "setNotification");
                        XmPlayerService.mService.startForeground(i, notification);
                        XmPlayerService.this.mNotification = notification;
                        XmPlayerService.this.mNotificationId = i;
                        if (XmPlayerService.this.mAppCtx != null && XmPlayerService.this.f12208O000000o != null && XmPlayerService.this.mNotificationManager != null) {
                            boolean O000000o2 = iks.O000000o(XmPlayerService.this.mAppCtx);
                            ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.f12208O000000o, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, O000000o2);
                            ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, O000000o2);
                        }
                    }
                } catch (Exception e) {
                    new StringBuilder("setNotification:").append(e.toString());
                }
            }
        }

        public boolean playRadio(Radio radio) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().playRadio(radio);
        }

        public void registeAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
            ilk.O00000Oo("XmPlayerService", "Process " + Binder.getCallingPid() + "has register AdsListener");
            if (iXmAdsEventDispatcher != null) {
                XmPlayerService.this.mAdsDispatcher.register(iXmAdsEventDispatcher, new ikx.O000000o(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void unregisteAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
            if (iXmAdsEventDispatcher != null) {
                XmPlayerService.this.mAdsDispatcher.unregister(iXmAdsEventDispatcher);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[Catch:{ Exception -> 0x0043 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        public void setPageSize(int i) throws RemoteException {
            boolean z;
            iit.O000000o();
            if (iit.O00000o0 != i) {
                iit O000000o2 = iit.O000000o();
                if (iit.O00000o0 != i) {
                    iit.O00000o0 = i;
                    ikd O000000o3 = ikd.O000000o(O000000o2.f1325O000000o);
                    if (ikd.O0000OOo != i) {
                        ikd.O0000OOo = i;
                        try {
                            if (!(!O000000o3.O00000o0 || O000000o3.f1381O000000o == null || O000000o3.f1381O000000o.asBinder() == null)) {
                                if (O000000o3.f1381O000000o.asBinder().isBinderAlive()) {
                                    z = false;
                                    if (z) {
                                        O000000o3.O0000Oo();
                                        return;
                                    }
                                    return;
                                }
                            }
                            z = true;
                            if (z) {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        public boolean isOnlineSource() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                return XmPlayerService.this.mPlayerControl.O00000Oo();
            }
            return false;
        }

        public void clearPlayCache() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                imf.O00000Oo(XmPlayerService.this.mPlayerControl.O0000Oo0);
            }
        }

        public void registeCommonBusinessListener(IXmCommonBusinessDispatcher iXmCommonBusinessDispatcher) throws RemoteException {
            XmPlayerService.this.mIXmCommonBusinessDispatcher = iXmCommonBusinessDispatcher;
        }

        public int getPlayListSize() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return 0;
            }
            return XmPlayerService.getPlayerSrvice().getPlayListSize();
        }

        public Map<String, String> getParam() throws RemoteException {
            XmPlayListControl xmPlayListControl = XmPlayerService.this.f12208O000000o;
            if (xmPlayListControl.O00000oO == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(xmPlayListControl.O00000oO);
            StringBuilder sb = new StringBuilder();
            sb.append(xmPlayListControl.O0000O0o);
            hashMap.put("pre_page", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xmPlayListControl.O00000oo);
            hashMap.put("page", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(xmPlayListControl.O0000o0O);
            hashMap.put("positive_seq", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(xmPlayListControl.O0000Oo0);
            hashMap.put("total_page", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(xmPlayListControl.O0000o0);
            hashMap.put("local_is_asc", sb5.toString());
            return hashMap;
        }

        public boolean isPlaying() throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() == null) {
                return false;
            }
            return XmPlayerService.getPlayerSrvice().isPlaying();
        }

        public boolean isAdsActive() throws RemoteException {
            if (XmPlayerService.this.mAdsManager != null) {
                return XmPlayerService.this.mAdsManager.O00000o;
            }
            return false;
        }

        public void getNextPlayList() throws RemoteException {
            XmPlayerService.this.f12208O000000o.O00000Oo(false);
        }

        public void getPrePlayList() throws RemoteException {
            XmPlayerService.this.f12208O000000o.O00000o0(false);
        }

        public void setPlayListChangeListener(IXmDataCallback iXmDataCallback) throws RemoteException {
            XmPlayerService.this.f12208O000000o.O0000o0o = iXmDataCallback;
        }

        public boolean permutePlayList() throws RemoteException {
            XmPlayerService.this.f12208O000000o.O00000o();
            return true;
        }

        public void setProxy(String str, int i, String str2, Map map) throws RemoteException {
            Config config = new Config();
            config.O00000o0 = str;
            config.O00000o = i;
            config.O00000oo = str2;
            config.O0000OoO = map;
            setProxyNew(config);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void
         arg types: [com.ximalaya.ting.android.opensdk.model.track.Track, int, ?[OBJECT, ARRAY], int]
         candidates:
          _m_j.ikn.O000000o(_m_j.ikn$O00000o0, java.lang.String, boolean, int):void
          _m_j.ikn.O000000o(com.ximalaya.ting.android.opensdk.model.track.Track, int, _m_j.ikn$O00000Oo, boolean):void */
        public void requestSoundAd() throws RemoteException {
            ilk.O000000o("requestSoundAd");
            if (!isAdsActive() && XmPlayerService.this.mAdsManager != null && (XmPlayerService.this.mLastModel instanceof Track) && System.currentTimeMillis() - this.lastRequestTime > 3000) {
                this.lastRequestTime = System.currentTimeMillis();
                ilk.O000000o("requestSoundAd playAds");
                XmPlayerService.this.mAdsManager.O000000o((Track) XmPlayerService.this.mLastModel, 0, (ikn.O00000Oo) null, true);
            }
        }

        public void pausePlayInMillis(long j) throws RemoteException {
            XmPlayerService.this.mPauseTimeInMills = j;
        }

        public boolean isAdPlaying() throws RemoteException {
            if (XmPlayerService.this.mAdsManager != null) {
                return XmPlayerService.this.mAdsManager.O000000o();
            }
            return false;
        }

        public boolean isBuffering() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl == null) {
                return false;
            }
            if (XmPlayerService.this.mPlayerControl.O0000Oo || getPlayerStatus() == 9) {
                return true;
            }
            return false;
        }

        public void setProxyNew(Config config) throws RemoteException {
            ilk.O00000o0("XmPlayerService", "代理 setProxyNew ".concat(String.valueOf(config)));
            XmPlayerService xmPlayerService = XmPlayerService.this;
            xmPlayerService.mConfig = config;
            XmPlayerControl xmPlayerControl = xmPlayerService.mPlayerControl;
            ilk.O000000o("XmPlayerControl", "setProxy ".concat(String.valueOf(config)));
            xmPlayerControl.O0000OoO = config;
            if (xmPlayerControl.f12199O000000o != null) {
                xmPlayerControl.f12199O000000o.O000000o(ijk.O000000o(config));
            }
            iit.O000000o().O0000OOo = config;
            iiz O000000o2 = iiz.O000000o();
            OkHttpClient.Builder newBuilder = O000000o2.O00000oO.newBuilder();
            Context context = iiz.O00000o;
            ijk.O000000o(config, newBuilder, false);
            if (iiz.O00000o != null) {
                newBuilder.cache(new Cache(new File(iiz.O00000o.getCacheDir(), "request_cache"), 52428800));
            }
            O000000o2.O00000oO = newBuilder.build();
            ilj.O000000o(config);
            ijd.f1359O000000o = config;
        }

        public void exitSoundAd() throws RemoteException {
            String[] packagesForUid = XmPlayerService.this.getPackageManager().getPackagesForUid(getCallingUid());
            String str = (packagesForUid == null || packagesForUid.length <= 0) ? null : packagesForUid[0];
            if (!TextUtils.isEmpty("com.ximalaya.ting.android") && "com.ximalaya.ting.android".equals(str) && ilg.O000000o() && XmPlayerService.this.mAdsManager != null) {
                ikn ikn = XmPlayerService.this.mAdsManager;
                boolean isPlaying = isPlaying();
                if (ikn.O00000oO != null) {
                    if (ikn.O00000oO.O00000o != null) {
                        ikn.O00000oO.O00000o.O000000o(isPlaying);
                    }
                    ikn.O00000o0();
                    if (ikn.f1404O000000o != null) {
                        ikn.f1404O000000o.O00000o();
                    }
                }
            }
        }

        public void setBreakpointResume(boolean z) throws RemoteException {
            SharedPreferences.Editor putBoolean = ikz.O000000o(XmPlayerService.this).f1428O000000o.edit().putBoolean("KEY_BREAKPOINT_RESUME", z);
            if (Build.VERSION.SDK_INT >= 9) {
                putBoolean.apply();
            } else {
                putBoolean.commit();
            }
        }

        public boolean isLoading() throws RemoteException {
            if (!(XmPlayerService.this.mAdsManager == null || XmPlayerService.this.mPlayerControl == null)) {
                if (XmPlayerService.this.mPlayerControl.O00000oO == 9) {
                    return true;
                }
                if (!XmPlayerService.this.mAdsManager.O00000o || XmPlayerService.this.mAdsManager.O0000O0o || XmPlayerService.this.mAdsManager.O00000o() == 2) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public void init(String str, String str2, String str3) throws RemoteException {
            iit.O000000o().O00000o = str2;
            iit.O000000o().O00000oO = str3;
            iit.O000000o().O000000o(XmPlayerService.this, str);
        }

        public void setPlayModel(String str, int i, final long j) throws RemoteException {
            if (TextUtils.isEmpty(str)) {
                XmPlayerService.this.setCustomCallBackErrData("内容为null", j);
                return;
            }
            final HashMap hashMap = new HashMap();
            hashMap.put("q", str);
            if (i >= 0) {
                hashMap.put("category_id", String.valueOf(i));
            }
            iit.O00000o0(hashMap, new iiw<ijx>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    ijx ijx = (ijx) obj;
                    if (ijx == null || ijx.f1378O000000o == null || ijx.f1378O000000o.size() <= 0) {
                        XmPlayerService xmPlayerService = XmPlayerService.this;
                        xmPlayerService.setCustomCallBackErrData(((String) hashMap.get("q")) + "没有搜索的数据", j);
                        return;
                    }
                    XmPlayerService.getPlayerSrvice().setPlayList(hashMap, ijx.f1378O000000o);
                    XmPlayerService.getPlayerSrvice().play(0);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService xmPlayerService = XmPlayerService.this;
                    xmPlayerService.setCustomCallBackErrData(((String) hashMap.get("q")) + str, j);
                }
            });
        }

        public void setCategoryId(int i, final long j) throws RemoteException {
            final HashMap hashMap = new HashMap();
            hashMap.put("category_id", String.valueOf(i));
            iit.O00000oO(hashMap, new iiw<ijz>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass5 */

                public final /* synthetic */ void O000000o(Object obj) {
                    ijz ijz = (ijz) obj;
                    if (ijz == null || ijz.f1378O000000o == null || ijz.f1378O000000o.size() <= 0) {
                        XmPlayerService.this.setCustomCallBackErrData((String) hashMap.get("q"), j);
                        return;
                    }
                    XmPlayerService.getPlayerSrvice().setPlayList(hashMap, ijz.f1378O000000o);
                    XmPlayerService.getPlayerSrvice().play(0);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService xmPlayerService = XmPlayerService.this;
                    xmPlayerService.setCustomCallBackErrData(((String) hashMap.get("q")) + str, j);
                }
            });
        }

        public void getCategoryModelList(final long j) throws RemoteException {
            iit.O000000o(new HashMap(), new iiw<ijq>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass6 */

                public final /* synthetic */ void O000000o(Object obj) {
                    ArrayList arrayList = new ArrayList();
                    for (ijp next : ((ijq) obj).f1373O000000o) {
                        CategoryModel categoryModel = new CategoryModel();
                        categoryModel.f12175O000000o = (int) next.f1372O000000o;
                        categoryModel.O00000Oo = next.O00000Oo;
                        arrayList.add(categoryModel);
                    }
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(arrayList), 4, j);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j);
                }
            });
        }

        public void getSourseLists(String str, int i, int i2, int i3, final int i4, final long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("q", str);
            hashMap.put("category_id", String.valueOf(i));
            hashMap.put("page", String.valueOf(i2));
            hashMap.put("count", String.valueOf(i3));
            if (i4 == 1) {
                iit.O00000Oo(hashMap, new iiw<ijo>() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass7 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ijo) obj), i4, j);
                    }

                    public final void O000000o(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }
                });
            } else if (i4 == 2) {
                iit.O00000o0(hashMap, new iiw<ijx>() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass8 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ijx) obj), i4, j);
                    }

                    public final void O000000o(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }
                });
            }
        }

        public void browseAlbums(long j, int i, int i2, final long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("album_id", String.valueOf(j));
            hashMap.put("page", String.valueOf(i));
            hashMap.put("count", String.valueOf(i2));
            iit.O0000OOo(hashMap, new iiw<ika>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass9 */

                public final /* synthetic */ void O000000o(Object obj) {
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ika) obj), 3, j2);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j2);
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
            if (com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice().play(0) == false) goto L_0x0049;
         */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        public void setPlayByTrack(String str, long j) throws RemoteException {
            boolean isEmpty = TextUtils.isEmpty(str);
            if (XmPlayerService.getPlayerSrvice() != null) {
                if (!isEmpty) {
                    try {
                        XmPlayerService.getPlayerSrvice().setPlayList(null, Arrays.asList((Track) new Gson().fromJson(str, Track.class)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        new StringBuilder("setPlayByTrack:").append(e.toString());
                    }
                }
                if (!isEmpty) {
                    XmPlayerService.this.setCustomCallBackErrData("播放失败", j);
                    return;
                }
                return;
            }
            return;
            isEmpty = true;
            if (!isEmpty) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
            if (com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice().play(r7) == false) goto L_0x005d;
         */
        public void setPlayByAlbumTracks(String str, int i, long j) throws RemoteException {
            boolean z = true;
            boolean z2 = TextUtils.isEmpty(str) || i < 0;
            if (!z2) {
                try {
                    ijv ijv = (ijv) new Gson().fromJson(str, new TypeToken<ijv<Track>>() {
                        /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass10 */
                    }.getType());
                    if (ijv.f1378O000000o == null || ijv.f1378O000000o.size() == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        XmPlayerService.getPlayerSrvice().setPlayList(ijv.O00000Oo, ijv.f1378O000000o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    new StringBuilder("setPlayByAlbumTracks:").append(e.toString());
                }
            }
            z = z2;
            if (z) {
                XmPlayerService.this.setCustomCallBackErrData("播放失败", j);
            } else {
                XmPlayerService.this.setCustomCallBackSuccessData("播放成功", 0, j);
            }
        }

        public void registeCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
            ilk.O00000Oo("XmPlayerService", "Process " + Binder.getCallingPid() + "has register CustomDataCallBack");
            if (iXmCustomDataCallBack != null) {
                XmPlayerService.this.mCustomDataCallBack.register(iXmCustomDataCallBack, new ikx.O000000o(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void unregisteCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
            if (iXmCustomDataCallBack != null) {
                XmPlayerService.this.mCustomDataCallBack.unregister(iXmCustomDataCallBack);
            }
        }

        public boolean updateTrackInPlayList(Track track) throws RemoteException {
            int indexOf;
            if (track == null || (indexOf = XmPlayerService.this.f12208O000000o.O00000o0.indexOf(track)) < 0) {
                return false;
            }
            XmPlayListControl xmPlayListControl = XmPlayerService.this.f12208O000000o;
            xmPlayListControl.O00000o0.set(indexOf, track);
            if (!(xmPlayListControl.O00000o == null || track == null || xmPlayListControl.O00000o.f12166O000000o != track.f12166O000000o)) {
                xmPlayListControl.O00000o = track;
            }
            if (!(XmPlayerService.this.mLastModel == null || track == null || XmPlayerService.this.mLastModel.f12166O000000o != track.f12166O000000o)) {
                XmPlayerService.this.mLastModel = track;
            }
            ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.f12208O000000o, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, iks.O000000o(XmPlayerService.this.mAppCtx));
            return true;
        }

        public void getHotContent(boolean z, int i, int i2, final long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("category_id", "0");
            hashMap.put("page", String.valueOf(i));
            hashMap.put("count", String.valueOf(i2));
            if (!z) {
                iit.O00000oo(hashMap, new iiw<ijn>() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass11 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ijn) obj), 6, j);
                    }

                    public final void O000000o(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }
                });
            } else {
                iit.O00000oO(hashMap, new iiw<ijz>() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass12 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ijz) obj), 5, j);
                    }

                    public final void O000000o(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }
                });
            }
        }

        public void getTrackListByLastTrack(long j, long j2, int i, final long j3) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("album_id", String.valueOf(j));
            hashMap.put("track_id", String.valueOf(j2));
            hashMap.put("count", String.valueOf(i));
            iit.O0000O0o(hashMap, new iiw<ijw>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass2 */

                public final /* synthetic */ void O000000o(Object obj) {
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ijw) obj), 8, j3);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j3);
                }
            });
        }

        public int getPlayCurrPosition() throws RemoteException {
            return XmPlayerService.this.mPlayerControl.O000000o();
        }

        public boolean getPlayListOrder() throws RemoteException {
            return XmPlayerService.this.f12208O000000o.O0000o0;
        }

        public void updateTrackDownloadUrlInPlayList(Track track) throws RemoteException {
            int indexOf = XmPlayerService.this.f12208O000000o.O00000o0.indexOf(track);
            if (indexOf >= 0) {
                XmPlayerService.this.f12208O000000o.O00000o0.get(indexOf).O0000ooo = track.O0000ooo;
            }
        }

        public String getCurPlayUrl() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                return XmPlayerService.this.mPlayerControl.O0000Oo0;
            }
            return null;
        }

        public void setVolume(float f, float f2) throws RemoteException {
            XmPlayerService.this.mPlayerControl.O000000o(f, f2);
        }

        public void getAlbumByCategoryId(long j, int i, int i2, final long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("category_id", String.valueOf(j));
            hashMap.put("page", String.valueOf(i));
            hashMap.put("count", String.valueOf(i2));
            iit.O00000oo(hashMap, new iiw<ijn>() {
                /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass3 */

                public final /* synthetic */ void O000000o(Object obj) {
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson((ijn) obj), 9, j2);
                }

                public final void O000000o(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j2);
                }
            });
        }

        public void registeMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
            if (iXmMainDataSupportDataCallback != null) {
                XmPlayerService.this.mMainDataSupportCallbackList.register(iXmMainDataSupportDataCallback, new ikx.O000000o(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
            if (iXmMainDataSupportDataCallback != null) {
                XmPlayerService.this.mMainDataSupportCallbackList.unregister(iXmMainDataSupportDataCallback);
            }
        }

        public void getMyCollect(int i, int i2, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("pageId", String.valueOf(i));
            hashMap.put("pageSize", String.valueOf(i2));
            XmPlayerService.this.getRequestMData(hashMap, 100, j, "openSDK_getSubscribtAlbumList");
        }

        public void getAttentionAlbum(int i, String str, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("timeline", str);
                hashMap.put("sign", "1");
            } else {
                hashMap.put("sign", "2");
            }
            hashMap.put("size", String.valueOf(i));
            XmPlayerService.this.getRequestMData(hashMap, 107, j, "openSDK_getAttentionAlbumList");
        }

        public void getAlbumInfo(long j, int i, int i2, String str, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("page", String.valueOf(i));
            if (i2 > 0) {
                hashMap.put("pageSize", String.valueOf(i2));
            } else {
                hashMap.put("pageSize", "20");
            }
            hashMap.put("albumId", String.valueOf(j));
            hashMap.put("isAsc", "true");
            hashMap.put("device", "android");
            hashMap.put("url_from", str);
            XmPlayerService.this.getRequestMData(hashMap, 101, j2, "openSDK_getAlbumData");
        }

        public void getRank(String str, String str2, int i, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            hashMap.put("key", str2);
            hashMap.put("pageId", String.valueOf(i));
            hashMap.put("pageSize", "20");
            if ("track".equals(str)) {
                XmPlayerService.this.getRequestMData(hashMap, 102, j, "openSDK_getRankList");
            } else if ("album".equals(str)) {
                XmPlayerService.this.getRequestMData(hashMap, 103, j, "openSDK_getRankAlbumList");
            } else if ("anchor".equals(str)) {
                XmPlayerService.this.getRequestMData(hashMap, 104, j, "openSDK_getRankAnchorList");
            }
        }

        public void getMainHotContent(int i, int i2, int i3, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("page", String.valueOf(i2));
            hashMap.put("per_page", String.valueOf(i3));
            hashMap.put("condition", "hot");
            hashMap.put("category_name", "all");
            hashMap.put("tag_name", "");
            hashMap.put("device", "android");
            if (i == 1) {
                XmPlayerService.this.getRequestMData(hashMap, 105, j, "openSDK_recommentTrack");
            } else if (i == 2) {
                hashMap.put("status", "0");
                XmPlayerService.this.getRequestMData(hashMap, 115, j, "openSDK_recommentAlbum");
            }
        }

        public void getNewRank(int i, int i2, int i3, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            hashMap.put("pageId", String.valueOf(i2));
            hashMap.put("pageSize", String.valueOf(i3));
            hashMap.put("target", "main");
            if (i == 0) {
                hashMap.put("rankingListId", "21");
                XmPlayerService.this.getRequestMData(hashMap, 132, j, "openSDK_getNewRankAlbum");
            } else if (i == 1) {
                hashMap.put("rankingListId", "57");
                XmPlayerService.this.getRequestMData(hashMap, 133, j, "openSDK_getNewRankTrack");
            } else if (i == 2) {
                hashMap.put("rankingListId", "50");
                XmPlayerService.this.getRequestMData(hashMap, 132, j, "openSDK_getNewRankAlbum");
            }
        }

        public void getUserInfo(long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), 106, j, "openSDK_getUserInfo");
        }

        public void setPlayStatisticClassName(String str) throws RemoteException {
            ilc ilc = XmPlayerService.this.mStatisticsManager;
            if (!TextUtils.isEmpty(str)) {
                try {
                    ilc.O00000Oo = (ila) Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void setAdsDataHandlerClassName(String str) throws RemoteException {
            ikn ikn = XmPlayerService.this.mAdsManager;
            ilk.O000000o("XmAdsManager ==  2 ".concat(String.valueOf(str)));
            if (!TextUtils.isEmpty(str)) {
                try {
                    ikn.O00000oo = (ikg) Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    ilk.O000000o("XmAdsManager ==  3 " + ikn.O00000oo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void getParseDeviceInfo(long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), 117, j, "opensdk_get_parse_device_info");
        }

        public void getSuggestAlbums(int i, int i2, boolean z, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("pageId", String.valueOf(i));
            hashMap.put("pageSize", String.valueOf(i2));
            hashMap.put("isLogin", String.valueOf(z));
            XmPlayerService.this.getRequestMData(hashMap, 118, j, "opensdk_get_suggest_albums");
        }

        public void getSpecialListenList(int i, int i2, int i3, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("categoryId", String.valueOf(i3));
            hashMap.put("scale", "2");
            hashMap.put("pageId", String.valueOf(i));
            hashMap.put("pageSize", String.valueOf(i2));
            XmPlayerService.this.getRequestMData(hashMap, 119, j, "opensdk_get_speciallisten");
        }

        public void getSubjectDetail(int i, int i2, long j, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(j));
            hashMap.put("page", String.valueOf(i));
            hashMap.put("count", String.valueOf(i2));
            XmPlayerService.this.getRequestMData(hashMap, 120, j2, "opensdk_get_subjectdetail");
        }

        public void subscribeAlbum(String str, boolean z, long j) throws RemoteException {
            long j2;
            HashMap hashMap = new HashMap();
            try {
                j2 = ((Album) new Gson().fromJson(str, Album.class)).f12170O000000o;
            } catch (Exception e) {
                e.printStackTrace();
                j2 = 0;
            }
            hashMap.put("albumId", String.valueOf(j2));
            hashMap.put("album", str);
            hashMap.put("isSubscribed", String.valueOf(z));
            XmPlayerService.this.getRequestMData(hashMap, 121, j, "opensdk_subscribe_album");
        }

        public void getTrackListByTrackIdAtAlbum(long j, long j2, boolean z, long j3) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("trackId", String.valueOf(j));
            hashMap.put("albumId", String.valueOf(j2));
            hashMap.put("asc", String.valueOf(z));
            XmPlayerService.this.getRequestMData(hashMap, 122, j3, "opensdk_get_tracklist_bytrackidatalbum");
        }

        public void getRecommendAlbumListByTrackId(long j, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("trackId", String.valueOf(j));
            XmPlayerService.this.getRequestMData(hashMap, 124, j2, "opensdk_get_recommend_albumlist_by_trackid");
        }

        public void getRecommendAlbumListByAlbumId(long j, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("albumId", String.valueOf(j));
            XmPlayerService.this.getRequestMData(hashMap, 123, j2, "opensdk_get_recommend_albumlist_by_albumid");
        }

        public void getProvinces(long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), 125, j, "opensdk_get_provinces");
        }

        public void getRadioList(int i, long j, int i2, int i3, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("radioType", String.valueOf(i));
            if (i == 2) {
                hashMap.put("provinceCode", String.valueOf(j));
            }
            hashMap.put("pageSize", String.valueOf(i3));
            hashMap.put("pageNum", String.valueOf(i2));
            XmPlayerService.this.getRequestMData(hashMap, 126, j2, "opensdk_get_radio_list");
        }

        public void getRadioSchedules(String str, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("radio", str);
            XmPlayerService.this.getRequestMData(hashMap, 127, j, "opensdk_get_radio_schedules");
        }

        public void getCategoriesList(int i, int i2, long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), NotificationCompat.FLAG_HIGH_PRIORITY, j, "opensdk_get_categories_list");
        }

        public void getAlbumByCategoryIdAndTag(long j, int i, int i2, int i3, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("id", String.valueOf(j));
            hashMap.put("page", String.valueOf(i2));
            hashMap.put("count", String.valueOf(i3));
            if (i != 0) {
                hashMap.put("keywordId", String.valueOf(i));
            }
            XmPlayerService.this.getRequestMData(hashMap, 129, j2, "opensdk_get_albums_by_category_id_and_tag");
        }

        public void getTags(long j, long j2) {
            HashMap hashMap = new HashMap();
            hashMap.put("categoryId", String.valueOf(j));
            XmPlayerService.this.getRequestMData(hashMap, 130, j2, "opensdk_get_tags_by_category_id");
        }

        public void getTrackDetailInfo(long j, long j2) {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            hashMap.put("trackId", String.valueOf(j));
            XmPlayerService.this.getRequestMData(hashMap, 131, j2, "openSDK_getTrackInfoDetail");
        }

        public Track getTrackInfoSync(long j) {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            hashMap.put("trackId", String.valueOf(j));
            try {
                Class O00000Oo = iiz.O00000Oo();
                if (O00000Oo != null) {
                    return (Track) O00000Oo.getMethod("getTrackInfoDetailSync", Map.class).invoke(null, hashMap);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
            return null;
        }

        public void setTokenInvalidForSDK(final IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack) throws RemoteException {
            if (iXmTokenInvalidForSDKCallBack != null) {
                iit.O000000o().O000000o(new iit.O00000Oo() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.XmPlayerImpl.AnonymousClass4 */

                    public final boolean O000000o() {
                        return false;
                    }

                    public final boolean O00000Oo() {
                        return false;
                    }

                    public final void O00000o0() {
                        IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack = iXmTokenInvalidForSDKCallBack;
                        if (iXmTokenInvalidForSDKCallBack != null) {
                            try {
                                iXmTokenInvalidForSDKCallBack.tokenInvalid();
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iit.O000000o().O000000o((iit.O00000Oo) null);
            }
        }

        public void setTokenToPlayForSDK(AccessToken accessToken) throws RemoteException {
            iis.O000000o().O00000Oo = XmPlayerService.this.getApplicationContext();
            iis.O000000o().f1323O000000o = accessToken;
        }

        public void setDLNAState(boolean z) throws RemoteException {
            XmPlayerService xmPlayerService = XmPlayerService.this;
            xmPlayerService.isDLNAState = z;
            if (xmPlayerService.mPlayerControl != null) {
                XmPlayerService.this.mPlayerControl.O0000Ooo = z;
            }
        }

        public void resetPlayList() throws RemoteException {
            if (XmPlayerService.this.f12208O000000o != null) {
                XmPlayerService.this.f12208O000000o.O00000Oo();
            }
            ikt.O000000o(XmPlayerService.this.mAppCtx).O000000o(XmPlayerService.this.f12208O000000o, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, iks.O000000o(XmPlayerService.this.mAppCtx));
            if (XmPlayerService.this.mAdsManager != null) {
                XmPlayerService.this.mAdsManager.O00000o0();
            }
        }

        public void removeListByIndex(int i) throws RemoteException {
            if (XmPlayerService.this.f12208O000000o != null) {
                XmPlayListControl xmPlayListControl = XmPlayerService.this.f12208O000000o;
                if (xmPlayListControl.O00000o0 != null && xmPlayListControl.O00000o0.size() >= i) {
                    xmPlayListControl.O00000o0.remove(i);
                    int i2 = XmPlayListControl.AnonymousClass3.f12192O000000o[xmPlayListControl.O0000OoO.ordinal()];
                    if ((i2 == 1 || i2 == 2) && i <= xmPlayListControl.O0000Oo) {
                        xmPlayListControl.O0000Oo--;
                    }
                    xmPlayListControl.O0000Ooo--;
                }
            }
        }

        public String getHistoryPos(String str) throws RemoteException {
            return XmPlayerService.this.getSoundHistoryPos(str);
        }

        public void setHistoryPosById(long j, int i) throws RemoteException {
            XmPlayerService.this.saveSoundHistoryPos(j, i);
        }

        public String getLastPlayTrackInAlbum(String str) throws RemoteException {
            return XmPlayerService.this.getLastPlayTrackInAlbumInner(str);
        }

        public void needContinuePlay(boolean z) throws RemoteException {
            XmPlayerService xmPlayerService = XmPlayerService.this;
            xmPlayerService.isContinuePlay = z;
            if (xmPlayerService.mPlayerAudioFocusControl != null) {
                XmPlayerService.this.mPlayerAudioFocusControl.O00000o0 = z;
            }
        }

        public void setRecordModel(RecordModel recordModel) throws RemoteException {
            if (XmPlayerService.this.mStatisticsManager != null) {
                XmPlayerService.this.mStatisticsManager.O00000o = recordModel;
            }
        }

        public boolean isDLNAState() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl == null) {
                return XmPlayerService.this.isDLNAState;
            }
            XmPlayerService xmPlayerService = XmPlayerService.this;
            xmPlayerService.isDLNAState = xmPlayerService.mPlayerControl.O0000Ooo;
            return XmPlayerService.this.isDLNAState;
        }

        public void setPlayerProcessRequestEnvironment(int i) throws RemoteException {
            if (ilg.O000000o()) {
                try {
                    Field declaredField = Class.forName("com.ximalaya.ting.android.host.util.constant.AppConstants").getDeclaredField("environmentId");
                    declaredField.setAccessible(true);
                    declaredField.set(null, Integer.valueOf(i));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
        }

        public void resetPlayer() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                XmPlayerService.this.mPlayerControl.O00000o0();
            }
        }

        public void setCheckAdContent(boolean z) throws RemoteException {
            if (ilg.O000000o()) {
                try {
                    Field declaredField = Class.forName("com.ximalaya.ting.android.host.manager.ad.AdManager").getDeclaredField("checkAdContent");
                    declaredField.setAccessible(true);
                    declaredField.set(null, Boolean.valueOf(z));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                    if (iio.f1319O000000o) {
                        throw new RuntimeException("AdManager 类路径发生变化");
                    }
                }
            }
        }

        public void insertPlayListHead(List<Track> list) throws RemoteException {
            if (XmPlayerService.this.f12208O000000o != null) {
                XmPlayListControl xmPlayListControl = XmPlayerService.this.f12208O000000o;
                synchronized (xmPlayListControl.O00000o0) {
                    if (xmPlayListControl.O00000o0 == null) {
                        xmPlayListControl.O00000o0 = new ArrayList();
                    }
                    xmPlayListControl.O00000o0.addAll(0, list);
                    xmPlayListControl.O0000Ooo = xmPlayListControl.O00000o0.size();
                    if (xmPlayListControl.O00000o0.contains(xmPlayListControl.O00000o)) {
                        xmPlayListControl.O0000Oo = xmPlayListControl.O00000o0.indexOf(xmPlayListControl.O00000o);
                    }
                }
            }
        }

        public long getCurrentTrackPlayedDuration() {
            return XmPlayerControl.O0000o0O;
        }

        public float getTempo() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                return XmPlayerService.this.mPlayerControl.O0000oOo;
            }
            return 0.0f;
        }

        public void setAppkeyAndPackId(String str, String str2) throws RemoteException {
            iit.O000000o().O00000o = str;
            iit.O000000o().O00000oO = str2;
        }

        public void setPlayCdnConfigureModel(CdnConfigModel cdnConfigModel) throws RemoteException {
            imq.f1481O000000o = cdnConfigModel;
        }
    }

    public void getRequestMData(Map<String, String> map, final int i, final long j, String str) {
        ilk.O00000o0("XmPlayerService", "getRequestMData   type = " + i + "   ; urlKey = " + str);
        getDataWithXDCS("getStringByUrlForOpenSDK", map, new ije<String>() {
            /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass7 */
        }, str);
    }

    public static <T> void getDataWithXDCS(String str, Map<String, String> map, ije<T> ije, Object... objArr) {
        Class O00000Oo2 = iiz.O00000Oo();
        if (O00000Oo2 != null) {
            Class[] clsArr = new Class[(objArr.length + 2)];
            clsArr[0] = Map.class;
            clsArr[1] = ije.class;
            for (int i = 2; i < clsArr.length; i++) {
                clsArr[i] = objArr[i - 2].getClass();
            }
            try {
                Method declaredMethod = O00000Oo2.getDeclaredMethod(str, clsArr);
                Object[] objArr2 = new Object[(objArr.length + 2)];
                objArr2[0] = map;
                objArr2[1] = ije;
                for (int i2 = 2; i2 < objArr2.length; i2++) {
                    objArr2[i2] = objArr[i2 - 2];
                }
                if (objArr2.length >= 2) {
                    declaredMethod.invoke(null, objArr2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setMainDataSupportCallBackSuccessData(String str, int i, long j) {
        RemoteCallbackList<IXmMainDataSupportDataCallback> remoteCallbackList = this.mMainDataSupportCallbackList;
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                try {
                    this.mMainDataSupportCallbackList.getBroadcastItem(i2).onSuccess(str, i, j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mMainDataSupportCallbackList.finishBroadcast();
        }
    }

    public void setMainDataSupportCallBackErrorData(String str, long j) {
        RemoteCallbackList<IXmMainDataSupportDataCallback> remoteCallbackList = this.mMainDataSupportCallbackList;
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    this.mMainDataSupportCallbackList.getBroadcastItem(i).onError(str, j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mMainDataSupportCallbackList.finishBroadcast();
        }
    }

    public void setCustomCallBackSuccessData(String str, int i, long j) {
        setMainDataSupportCallBackSuccessData(str, i, j);
        RemoteCallbackList<IXmCustomDataCallBack> remoteCallbackList = this.mCustomDataCallBack;
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                try {
                    this.mCustomDataCallBack.getBroadcastItem(i2).onSuccess(str, i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mCustomDataCallBack.finishBroadcast();
        }
    }

    public void setCustomCallBackErrData(String str, long j) {
        setMainDataSupportCallBackErrorData(str, j);
        RemoteCallbackList<IXmCustomDataCallBack> remoteCallbackList = this.mCustomDataCallBack;
        if (remoteCallbackList != null) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    this.mCustomDataCallBack.getBroadcastItem(i).onError(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mCustomDataCallBack.finishBroadcast();
        }
    }

    public void sendPlayerStartBroadCast() {
        if (this.O0000Oo != null && this.mAppCtx != null) {
            this.O0000Oo.onReceive(this.mAppCtx, new Intent("com.ximalaya.ting.android.ACTION_PLAY_START"));
        }
    }

    public void sendPlayerPauseBroadCast() {
        if (this.O0000Oo != null && this.mAppCtx != null) {
            this.O0000Oo.onReceive(this.mAppCtx, new Intent("com.ximalaya.ting.android.ACTION_PLAY_PAUSE"));
        }
    }

    public void sendPlayCompleteBroadCast() {
        this.O0000Oo.onReceive(this.mAppCtx, new Intent("com.ximalaya.ting.android.ACTION_COMPLETE"));
    }

    public PlayableModel getPlayableModel() {
        return this.f12208O000000o.O00000o;
    }

    public XmPlayListControl.PlayMode getPlayMode() {
        XmPlayListControl xmPlayListControl = this.f12208O000000o;
        if (xmPlayListControl != null) {
            return xmPlayListControl.O0000OoO;
        }
        return XmPlayListControl.PlayMode.PLAY_MODEL_LIST;
    }

    public boolean isContinuePlay() {
        return this.isContinuePlay;
    }

    public boolean isOnlineResource() {
        return this.mPlayerControl.O00000Oo();
    }

    public XmPlayListControl getPlayListControl() {
        return this.f12208O000000o;
    }

    public XmPlayerControl getPlayControl() {
        return this.mPlayerControl;
    }

    public String getCurPlayUrl() {
        XmPlayerControl xmPlayerControl = this.mPlayerControl;
        if (xmPlayerControl != null) {
            return xmPlayerControl.O0000Oo0;
        }
        return null;
    }

    public void checkIsPauseTime() {
        long currentTimeMillis = this.mPauseTimeInMills - System.currentTimeMillis();
        if (this.mPauseTimeInMills > 0 && currentTimeMillis <= 0) {
            this.mPauseTimeInMills = 0;
            try {
                if (getPlayerImpl().getPlayerStatus() == 3) {
                    pausePlay();
                } else {
                    this.mWillPause = true;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public Handler getTimeHander() {
        if (this.O0000o0O == null) {
            this.O0000o0O = new Handler(Looper.getMainLooper());
        }
        return this.O0000o0O;
    }

    public void startCheckIsPauseTime() {
        if (this.mPauseTimeInMills > 0) {
            if (this.mCheckIsPauseTimeRunnable == null) {
                this.mCheckIsPauseTimeRunnable = new Runnable() {
                    /* class com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.AnonymousClass8 */

                    public final void run() {
                        XmPlayerService.this.checkIsPauseTime();
                        XmPlayerService.this.getTimeHander().postDelayed(XmPlayerService.this.mCheckIsPauseTimeRunnable, 500);
                    }
                };
            }
            getTimeHander().postDelayed(this.mCheckIsPauseTimeRunnable, 500);
        }
    }

    public void removeCheckIsPauseTime() {
        if (getTimeHander() != null && this.mCheckIsPauseTimeRunnable != null) {
            getTimeHander().removeCallbacks(this.mCheckIsPauseTimeRunnable);
        }
    }

    public void closeApp() {
        try {
            if (this.mIXmCommonBusinessDispatcher != null) {
                this.mIXmCommonBusinessDispatcher.closeApp();
            }
        } catch (RemoteException e) {
            ilk.O00000Oo("XmPlayerService", "close app " + e.toString());
        }
        try {
            ikd.O00000o0();
            if (!(ike.f1384O000000o == null || ike.f1384O000000o.O00000Oo == null || ike.f1384O000000o.O00000oO == null || ike.f1384O000000o.O00000o0 == null || ike.f1384O000000o.O00000o0.asBinder() == null || !ike.f1384O000000o.O00000o0.asBinder().isBinderAlive())) {
                ike.f1384O000000o.O00000Oo.unbindService(ike.f1384O000000o.O00000oO);
            }
            stopSelf();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (mService != null && !ilg.O000000o(this, "com.ximalaya.ting.android")) {
            ilk.O00000Oo("XmPlayerService", "close app use stopself");
            try {
                stopSelf();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void setNotification() {
        Notification.Builder builder;
        Notification notification;
        if (!this.O0000OoO) {
            this.O0000OoO = true;
            Class<?> cls = null;
            try {
                cls = Class.forName("com.ximalaya.ting.android.host.activity.MainActivity");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cls != null) {
                ikt O000000o2 = ikt.O000000o(mService.getApplicationContext());
                Context applicationContext = mService.getApplicationContext();
                O000000o2.O00000Oo();
                O000000o2.O00000o0();
                O000000o2.O000000o();
                O000000o2.O00000o();
                boolean O000000o3 = iks.O000000o(applicationContext);
                O000000o2.O00000Oo = O000000o2.O000000o(applicationContext, O000000o3);
                O000000o2.f1422O000000o = O000000o2.O00000Oo(applicationContext, O000000o3);
                O000000o2.O000000o(O000000o2.O00000Oo, O000000o2.f1422O000000o);
                if (Build.VERSION.SDK_INT >= 26) {
                    builder = new Notification.Builder(applicationContext, "com.ximalaya.android.sdk");
                } else {
                    builder = new Notification.Builder(applicationContext);
                }
                Intent intent = new Intent(applicationContext, cls);
                intent.putExtra("notification_entry", "com.ximalaya.ting.android.EXTRY_NOTIFICATION_TO_MAINACTIVITY");
                builder.setContentIntent(PendingIntent.getActivity(applicationContext, 0, intent, 134217728)).setContentTitle("喜马拉雅").setContentText("随时随地 听我想听").setOngoing(true).setSmallIcon(O000000o2.O000000o(Build.VERSION.SDK_INT >= 21 ? "notification_icon" : "ting", "drawable"));
                if (Build.VERSION.SDK_INT >= 16) {
                    builder.setPriority(2);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    builder.setCustomContentView(O000000o2.f1422O000000o);
                    builder.setCustomBigContentView(O000000o2.O00000Oo);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    notification = builder.build();
                } else {
                    notification = builder.getNotification();
                }
                if (Build.VERSION.SDK_INT < 24) {
                    notification.contentView = O000000o2.f1422O000000o;
                    if (Build.VERSION.SDK_INT >= 16) {
                        notification.bigContentView = O000000o2.O00000Oo;
                    }
                }
                if (notification != null) {
                    try {
                        if (mService != null) {
                            ilk.O00000Oo("XmPlayerService", "setNotification");
                            mService.startForeground(16842960, notification);
                            this.mNotification = notification;
                            this.mNotificationId = 16842960;
                            if (this.mAppCtx != null && this.f12208O000000o != null && this.mNotificationManager != null) {
                                boolean O000000o4 = iks.O000000o(this.mAppCtx);
                                ikt.O000000o(this.mAppCtx).O000000o(this.f12208O000000o, this.mNotificationManager, this.mNotification, this.mNotificationId, O000000o4);
                                ikt.O000000o(this.mAppCtx).O000000o(this.mNotificationManager, this.mNotification, this.mNotificationId, O000000o4);
                            }
                        }
                    } catch (Exception e2) {
                        new StringBuilder("setNotification:").append(e2.toString());
                    }
                }
            }
        }
    }

    public PlayableModel getCurrPlayModel() {
        XmPlayListControl xmPlayListControl = this.f12208O000000o;
        if (xmPlayListControl != null) {
            return xmPlayListControl.O00000o;
        }
        return null;
    }

    public void setPlayDataOutPutListener(imk.O0000OOo o0000OOo) {
        XmPlayerControl xmPlayerControl = this.mPlayerControl;
        if (xmPlayerControl != null) {
            xmPlayerControl.O000000o(o0000OOo);
        }
        this.O0000OOo = o0000OOo;
    }

    public void seekTo(int i) {
        if (getPlayerImpl() != null) {
            try {
                getPlayerImpl().seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getDuration() {
        if (getPlayerImpl() == null) {
            return 0;
        }
        try {
            return getPlayerImpl().getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getPlayCurrPosition() {
        if (getPlayerImpl() == null) {
            return 0;
        }
        try {
            return getPlayerImpl().getPlayCurrPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public XmPlayListControl.PlayMode getXmPlayMode() {
        if (getPlayListControl() != null) {
            try {
                return getPlayListControl().O0000OoO;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return XmPlayListControl.PlayMode.PLAY_MODEL_LIST;
    }

    public void notifProgress(int i, int i2) {
        ikw ikw = this.mPlayerStatusListener;
        if (ikw != null) {
            ikw.O000000o(i, i2);
        }
    }

    public void setPlayStartCallback(ikn.O000000o o000000o) {
        this.mPlayStartCallBack = o000000o;
    }

    public void playPauseNoNotif() {
        if (this.mPlayerControl != null) {
            ilk.O000000o("playPauseNoNotif:" + Arrays.toString(Thread.currentThread().getStackTrace()) + ":playPauseNoNotif");
            this.mPlayerControl.O00000Oo(false);
        }
    }

    /* access modifiers changed from: protected */
    public final String O000000o(Track track) {
        if (!(track.O000O0o0 || track.O000O0oO > 0 || track.O00oOoOo || !track.O000O0o)) {
            return "";
        }
        String str = track.O0000ooo;
        if (TextUtils.isEmpty(str)) {
            try {
                if (this.mIXmCommonBusinessDispatcher != null) {
                    str = this.mIXmCommonBusinessDispatcher.getDownloadPlayPath(track);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!new File(str).exists()) {
                return null;
            }
            if (str.contains(".xm")) {
                try {
                    this.mIXmCommonBusinessDispatcher.isOldTrackDownload(track);
                    return "null";
                } catch (Throwable unused) {
                    str = "";
                }
            }
            ilk.O000000o("XmPlayerService:method=getTrackUrl:path=".concat(String.valueOf(str)));
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void saveLastPlayTrackInAlbum(Track track) {
        if (track != null && "track".equals(track.O00000Oo) && track.O0000oo != null) {
            SharedPreferences.Editor edit = this.O00000o0.edit();
            Map<String, ?> all = this.O00000o0.getAll();
            if (all != null && all.size() > 500) {
                for (Map.Entry next : all.entrySet()) {
                    Object value = next.getValue();
                    if (value != null) {
                        if (System.currentTimeMillis() - Long.parseLong(value.toString().split(this.O0000o0)[1]) > this.O0000o00) {
                            edit.remove((String) next.getKey());
                        }
                    }
                }
            }
            if (track.O0000oo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(track.O0000oo.f12174O000000o);
                String sb2 = sb.toString();
                edit.putString(sb2, new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(track) + this.O0000o0 + System.currentTimeMillis());
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        }
    }

    public void playTrackInner(String str, Track track, boolean z) {
        boolean z2;
        int O000000o2 = O000000o(track.f12166O000000o);
        if (O000000o2 < 0 || track.O00000Oo() || O000000o2 > track.O0000o0 * 1000) {
            O000000o2 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = getTrackUrl(track);
        }
        if (z) {
            z2 = this.mPlayerControl.O00000Oo(str, O000000o2);
        } else {
            XmPlayerControl xmPlayerControl = this.mPlayerControl;
            xmPlayerControl.O00000oo = false;
            z2 = xmPlayerControl.O000000o(str, O000000o2);
        }
        if (!z2) {
            this.mLastModel = null;
        }
    }
}
