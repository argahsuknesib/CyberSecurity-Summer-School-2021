package _m_j;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager$2;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager$3;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager$4;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager$5;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager$6;
import com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayer;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerException;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ikd {
    public static int O0000OOo = 20;
    static Config O0000Oo0;
    public static int O0000oo = 1;
    private static volatile ikd O0000ooO;
    private static byte[] O0000ooo = new byte[0];

    /* renamed from: O000000o  reason: collision with root package name */
    public IXmPlayer f1381O000000o;
    public Context O00000Oo;
    public boolean O00000o = false;
    public boolean O00000o0 = false;
    public O00000Oo O00000oO;
    public int O00000oo = 0;
    public Notification O0000O0o;
    public boolean O0000Oo;
    List<ikw> O0000OoO = new CopyOnWriteArrayList();
    List<ikh> O0000Ooo = new CopyOnWriteArrayList();
    public ikv O0000o;
    public O000000o O0000o0;
    public Set<O000000o> O0000o00 = new HashSet();
    public IXmTokenInvalidForSDKCallBack.Stub O0000o0O = new XmPlayerManager$2(this);
    public IXmCommonBusinessDispatcher.Stub O0000o0o = new XmPlayerManager$3(this);
    public IXmPlayerEventDispatcher.Stub O0000oO = new XmPlayerManager$5(this);
    public IXmAdsEventDispatcher.Stub O0000oO0 = new XmPlayerManager$4(this);
    public IXmDataCallback O0000oOO;
    public IXmDataCallback.Stub O0000oOo = new XmPlayerManager$6(this);
    public PlayableModel O0000oo0;
    private int O000O00o = 0;
    private ServiceConnection O00oOooO = new ServiceConnection() {
        /* class _m_j.ikd.AnonymousClass1 */

        public final void onServiceDisconnected(ComponentName componentName) {
            ilk.O00000Oo("XmPlayerServiceManager", "onServiceDisconnected");
            ikd ikd = ikd.this;
            ikd.O00000o0 = false;
            ikd.O00000o = false;
            ikd.O000000o(ikd.O00000oo, ikd.this.O0000O0o);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ilk.O00000Oo("XmPlayerServiceManager", "onServiceConnected progress:" + Process.myPid());
                ikd.this.O00000o0 = true;
                ikd.this.O00000o = true;
                ikd.this.f1381O000000o = IXmPlayer.Stub.asInterface(iBinder);
                ikd.this.f1381O000000o.registePlayerListener(ikd.this.O0000oO);
                ikd.this.f1381O000000o.registeAdsListener(ikd.this.O0000oO0);
                if (ilg.O000000o(ikd.this.O00000Oo)) {
                    ikd.this.f1381O000000o.setPlayerProcessRequestEnvironment(ikd.O0000oo);
                    ikd.this.f1381O000000o.registeCommonBusinessListener(ikd.this.O0000o0o);
                    ikd.this.f1381O000000o.setPlayListChangeListener(ikd.this.O0000oOo);
                    if (ikd.this.O0000O0o != null) {
                        ikd.this.f1381O000000o.setNotification(ikd.this.O00000oo, ikd.this.O0000O0o);
                    }
                }
                if (!TextUtils.isEmpty(iit.O000000o().O00000Oo) && !ilg.O000000o() && ilg.O000000o(ikd.this.O00000Oo)) {
                    if (iit.O000000o().O0000Oo != null) {
                        ikd.this.f1381O000000o.setTokenInvalidForSDK(ikd.this.O0000o0O);
                    }
                    ikd.this.f1381O000000o.setAppSecret(iit.O000000o().O00000Oo);
                    ikd.this.f1381O000000o.setAppkeyAndPackId(iit.O000000o().O00000Oo(), iit.O000000o().O00000oO());
                    ikd.this.f1381O000000o.setTokenToPlayForSDK(iis.O000000o().O0000O0o());
                }
                if (!ilg.O000000o() && ilg.O000000o(ikd.this.O00000Oo)) {
                    ikd.this.f1381O000000o.setAdsDataHandlerClassName(ikj.class.getName());
                    ikd.this.f1381O000000o.setPlayStatisticClassName(ilb.class.getName());
                }
                ikd ikd = ikd.this;
                if (ikd.f1381O000000o != null) {
                    ikd.f1381O000000o.setProxyNew(ikd.O0000Oo0);
                }
                ikd.this.O0000Oo();
                ilk.O00000Oo("XmPlayerServiceManager", "onServiceConnected123");
                Iterator<O000000o> it = ikd.this.O0000o00.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                ikd.this.O0000oo0 = ikd.this.f1381O000000o.getTrack(ikd.this.f1381O000000o.getCurrIndex());
                boolean z = ikd.this.O0000Oo;
                if (iio.f1319O000000o) {
                    z = ilp.O000000o(ikd.this.O00000Oo).f1436O000000o.getBoolean("check_ad_content", true) && ikd.this.O0000Oo;
                }
                ikd.this.f1381O000000o.setCheckAdContent(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private List<Track> O00oOooo;

    public interface O000000o {
    }

    public static ikd O000000o(Context context) {
        if (iio.f1319O000000o) {
            Context context2 = (context != null || O0000ooO == null) ? context : O0000ooO.O00000Oo;
            if (context2 != null && !ilg.O000000o(context2) && ilg.O000000o()) {
                Thread.dumpStack();
                throw new RuntimeException("only main process can use this method");
            }
        }
        if (O0000ooO == null) {
            synchronized (O0000ooo) {
                if (O0000ooO == null) {
                    O0000ooO = new ikd(context);
                }
            }
        }
        return O0000ooO;
    }

    public final boolean O000000o() {
        IXmPlayer iXmPlayer;
        return this.O00000o0 && (iXmPlayer = this.f1381O000000o) != null && iXmPlayer.asBinder() != null && this.f1381O000000o.asBinder().isBinderAlive();
    }

    public final boolean O00000Oo() {
        IXmPlayer iXmPlayer;
        if (this.O00000o0 && (iXmPlayer = this.f1381O000000o) != null && iXmPlayer.asBinder() != null && this.f1381O000000o.asBinder().isBinderAlive()) {
            return true;
        }
        ilk.O00000Oo("XmPlayerServiceManager", "checkConnectionStatus disconnected");
        O000000o(this.O00000oo, this.O0000O0o);
        return false;
    }

    private ikd(Context context) {
        this.O00000Oo = context.getApplicationContext();
        this.O00000oO = new O00000Oo(Looper.getMainLooper());
        iml.O000000o(this.O00000Oo);
    }

    private void O0000o0() {
        try {
            this.O00000Oo.startService(XmPlayerService.getIntent(this.O00000Oo));
            this.O00000o = this.O00000Oo.bindService(XmPlayerService.getIntent(this.O00000Oo), this.O00oOooO, 1);
            ilk.O00000Oo("XmPlayerServiceManager", "Bind ret " + this.O00000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o(int i, Notification notification) {
        IXmPlayer iXmPlayer;
        if (ilg.O000000o()) {
            O0000o0();
            return;
        }
        this.O00000oo = i;
        this.O0000O0o = notification;
        O0000o0();
        if (this.O00000o0 && (iXmPlayer = this.f1381O000000o) != null && iXmPlayer.asBinder() != null && this.f1381O000000o.asBinder().isBinderAlive()) {
            try {
                this.f1381O000000o.setNotification(this.O00000oo, this.O0000O0o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void O00000o0() {
        ilk.O00000Oo("XmPlayerServiceManager", "unBind release");
        if (O0000ooO != null) {
            if (O0000ooO.O00000o || !(O0000ooO.f1381O000000o == null || O0000ooO.f1381O000000o.asBinder() == null || !O0000ooO.f1381O000000o.asBinder().isBinderAlive())) {
                O0000ooO.O00000Oo.unbindService(O0000ooO.O00oOooO);
                O0000ooO.O00000o = false;
            }
            O0000ooO.O0000O0o = null;
            O0000ooO.O0000OoO.clear();
            O0000ooO.O0000Ooo.clear();
            O0000ooO.O0000o00.clear();
            O0000ooO.O0000o0 = null;
            O0000ooO.O0000oo0 = null;
            O0000ooO.O00000o0 = false;
            O0000ooO.f1381O000000o = null;
            O0000ooO = null;
        }
    }

    public static void O00000o() {
        ilk.O00000Oo("XmPlayerServiceManager", "release");
        if (O0000ooO != null) {
            O0000ooO.O0000OOo();
            O0000ooO.O0000Oo0();
            if (O0000ooO.O00000o || !(O0000ooO.f1381O000000o == null || O0000ooO.f1381O000000o.asBinder() == null || !O0000ooO.f1381O000000o.asBinder().isBinderAlive())) {
                O0000ooO.O00000Oo.unbindService(O0000ooO.O00oOooO);
                O0000ooO.O00000o = false;
            }
            O0000ooO.O00000Oo.stopService(XmPlayerService.getIntent(O0000ooO.O00000Oo));
            O0000ooO.O0000O0o = null;
            O0000ooO.O0000OoO.clear();
            O0000ooO.O0000Ooo.clear();
            O0000ooO.O0000o00.clear();
            O0000ooO.O0000o0 = null;
            O0000ooO.O0000oo0 = null;
            O0000ooO.O00000o0 = false;
            O0000ooO.f1381O000000o = null;
        }
    }

    public final int O00000oO() {
        if (!O000000o()) {
            return -1;
        }
        try {
            return this.f1381O000000o.getCurrIndex();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private PlayableModel O000000o(Track track) {
        if (!O00000Oo()) {
            return null;
        }
        int i = -1;
        try {
            i = this.f1381O000000o.getPlaySourceType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (track != null) {
            if (i == 2) {
                if (track == null || !"schedule".equals(track.O00000Oo)) {
                    return track;
                }
                return ilm.O00000Oo(track);
            } else if (i == 3) {
                if ("radio".equals(track.O00000Oo)) {
                    return ilm.O000000o(track);
                }
                if ("schedule".equals(track.O00000Oo)) {
                    return ilm.O00000Oo(track);
                }
            }
        }
        return null;
    }

    public final PlayableModel O00000oo() {
        if (!O000000o()) {
            return null;
        }
        PlayableModel playableModel = this.O0000oo0;
        if (playableModel != null) {
            return O000000o((Track) playableModel);
        }
        try {
            return O000000o(this.f1381O000000o.getTrack(this.f1381O000000o.getCurrIndex()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O0000O0o() {
        if (O00000Oo()) {
            try {
                if (this.O000O00o == 3) {
                    ft.O000000o(this.O00000Oo).O000000o(new Intent("com.ximalaya.ting.android.action.ACTION_PLAY_VIDEO_AD"));
                } else {
                    this.f1381O000000o.startPlay();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O0000OOo() {
        if (O00000Oo()) {
            try {
                if (this.O000O00o == 2) {
                    ft.O000000o(this.O00000Oo).O000000o(new Intent("com.ximalaya.ting.android.action.ACTION_PAUSE_VIDEO_AD"));
                } else {
                    this.f1381O000000o.pausePlay();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O0000Oo0() {
        if (O00000Oo()) {
            try {
                this.f1381O000000o.stopPlay();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O0000Oo() throws RemoteException {
        IXmPlayer iXmPlayer;
        if (O00000Oo() && (iXmPlayer = this.f1381O000000o) != null) {
            iXmPlayer.setPageSize(O0000OOo);
        }
    }

    public final List<Track> O0000OoO() {
        if (!O000000o()) {
            return null;
        }
        this.O00oOooo = new ArrayList();
        int i = 0;
        while (true) {
            try {
                List<Track> playList = this.f1381O000000o.getPlayList(i);
                if (playList == null) {
                    return this.O00oOooo;
                }
                this.O00oOooo.addAll(playList);
                if (playList.size() < 30) {
                    return this.O00oOooo;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return this.O00oOooo;
            }
        }
    }

    public final Track O000000o(int i) {
        if (!O000000o()) {
            return null;
        }
        try {
            return this.f1381O000000o.getTrack(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean O000000o(Radio radio) {
        if (!O00000Oo() || radio == null) {
            return false;
        }
        ijv ijv = new ijv();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ilm.O000000o(radio));
        ijv.f1378O000000o = arrayList;
        ijv.O00000o0 = 1;
        ijv.O00000o = 1;
        O000000o(ijv);
        return true;
    }

    private void O000000o(ijv ijv) {
        if (O00000Oo() && ijv.f1378O000000o != null && ijv.f1378O000000o.size() != 0) {
            O000000o(ijv.O00000Oo, ijv.f1378O000000o, 0, true);
        }
    }

    public final void O000000o(Map<String, String> map, List<Track> list, int i, boolean z) {
        if (O00000Oo() && list != null) {
            try {
                int size = list.size();
                if (size < 30) {
                    this.f1381O000000o.setPlayList(map, list);
                } else {
                    for (int i2 = 0; i2 < size / 30; i2++) {
                        if (i2 == 0) {
                            this.f1381O000000o.setPlayList(map, list.subList(i2 * 30, (i2 + 1) * 30));
                        } else {
                            this.f1381O000000o.addPlayList(list.subList(i2 * 30, (i2 + 1) * 30));
                        }
                    }
                    int i3 = size % 30;
                    if (i3 != 0) {
                        int i4 = (size / 30) * 30;
                        this.f1381O000000o.addPlayList(list.subList(i4, i3 + i4));
                    }
                }
                if (z) {
                    this.f1381O000000o.play(i);
                } else {
                    this.f1381O000000o.setPlayIndex(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final int O0000Ooo() {
        if (!O000000o()) {
            return 0;
        }
        try {
            return this.f1381O000000o.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final void O00000Oo(int i) {
        if (O00000Oo()) {
            try {
                if (this.O000O00o != 1 && this.O000O00o != 2) {
                    if (this.O000O00o != 3) {
                        this.f1381O000000o.seekTo(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O0000o00() {
        if (O000000o()) {
            try {
                this.f1381O000000o.clearPlayCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    for (ikw O000000o2 : ikd.this.O0000OoO) {
                        O000000o2.O000000o();
                    }
                    return;
                case 2:
                    for (ikw O00000Oo : ikd.this.O0000OoO) {
                        O00000Oo.O00000Oo();
                    }
                    return;
                case 3:
                    for (ikw O00000o0 : ikd.this.O0000OoO) {
                        O00000o0.O00000o0();
                    }
                    return;
                case 4:
                    for (ikw O00000o : ikd.this.O0000OoO) {
                        O00000o.O00000o();
                    }
                    return;
                case 5:
                    for (ikw O00000oO : ikd.this.O0000OoO) {
                        O00000oO.O00000oO();
                    }
                    return;
                case 6:
                    if (message.obj instanceof Boolean) {
                        ikd ikd = ikd.this;
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        for (ikw next : ikd.O0000OoO) {
                            if (booleanValue) {
                                next.O00000oo();
                            } else {
                                next.O0000O0o();
                            }
                        }
                        return;
                    }
                    return;
                case 7:
                    ikd ikd2 = ikd.this;
                    int i = message.arg1;
                    int i2 = message.arg2;
                    for (ikw O000000o3 : ikd2.O0000OoO) {
                        O000000o3.O000000o(i, i2);
                    }
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    Object[] objArr = (Object[]) message.obj;
                    ikd ikd3 = ikd.this;
                    PlayableModel playableModel = (PlayableModel) objArr[0];
                    PlayableModel playableModel2 = (PlayableModel) objArr[1];
                    ikd3.O0000oo0 = playableModel2;
                    for (ikw O000000o4 : ikd3.O0000OoO) {
                        O000000o4.O000000o(playableModel, playableModel2);
                    }
                    return;
                case 9:
                    ikd ikd4 = ikd.this;
                    int i3 = message.arg1;
                    for (ikw O000000o5 : ikd4.O0000OoO) {
                        O000000o5.O000000o(i3);
                    }
                    return;
                case 10:
                    ikd ikd5 = ikd.this;
                    XmPlayerException xmPlayerException = (XmPlayerException) message.obj;
                    for (ikw O000000o6 : ikd5.O0000OoO) {
                        O000000o6.O000000o(xmPlayerException);
                    }
                    return;
                case 11:
                default:
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    for (ikh O000000o7 : ikd.this.O0000Ooo) {
                        O000000o7.O000000o();
                    }
                    return;
                case 13:
                    ikd ikd6 = ikd.this;
                    AdvertisList advertisList = (AdvertisList) message.obj;
                    for (ikh O000000o8 : ikd6.O0000Ooo) {
                        O000000o8.O000000o(advertisList);
                    }
                    return;
                case 14:
                    for (ikh O00000Oo2 : ikd.this.O0000Ooo) {
                        O00000Oo2.O00000Oo();
                    }
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    for (ikh O00000o02 : ikd.this.O0000Ooo) {
                        O00000o02.O00000o0();
                    }
                    return;
                case 16:
                    ikd ikd7 = ikd.this;
                    Advertis advertis = (Advertis) message.obj;
                    int i4 = message.arg1;
                    for (ikh O000000o9 : ikd7.O0000Ooo) {
                        O000000o9.O000000o(advertis, i4);
                    }
                    return;
                case 17:
                    for (ikh O00000o2 : ikd.this.O0000Ooo) {
                        O00000o2.O00000o();
                    }
                    return;
                case 18:
                    ikd ikd8 = ikd.this;
                    int i5 = message.arg1;
                    int i6 = message.arg2;
                    for (ikh O000000o10 : ikd8.O0000Ooo) {
                        O000000o10.O000000o(i5, i6);
                    }
                    return;
                case 19:
                    Object obj = message.obj;
                    return;
            }
        }
    }

    public final void O000000o(AccessToken accessToken) {
        if (O00000Oo()) {
            try {
                this.f1381O000000o.setTokenToPlayForSDK(accessToken);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
