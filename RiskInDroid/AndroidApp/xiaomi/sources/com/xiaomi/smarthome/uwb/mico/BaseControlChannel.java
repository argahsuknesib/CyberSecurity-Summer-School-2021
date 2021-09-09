package com.xiaomi.smarthome.uwb.mico;

import _m_j.gsy;
import _m_j.ixc;
import _m_j.ixe;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import com.xiaomi.miplay.audioclient.sdk.MiPlayClient;
import com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi;
import com.xiaomi.smarthome.uwb.mico.BaseControlChannel;
import kotlin.Metadata;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel;", "", "()V", "MIPLAY", "REMOTE", "UWB", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel$MIPLAY;", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel$REMOTE;", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel$UWB;", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BaseControlChannel {
    public /* synthetic */ BaseControlChannel(ixc ixc) {
        this();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel$MIPLAY;", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel;", "Lcom/xiaomi/smarthome/uwb/mico/MicoBaseAction;", "()V", "modifyVolumeByValue", "", "int", "", "next", "playOrPause", "play", "", "prev", "seek", "position", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MIPLAY extends BaseControlChannel implements MicoBaseAction {
        public static final MIPLAY INSTANCE = new MIPLAY();

        private MIPLAY() {
            super(null);
        }

        public final void playOrPause(boolean z) {
            String str = null;
            if (!z) {
                MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
                if (mMiPlayClient != null) {
                    String[] strArr = new String[1];
                    MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                    if (value != null) {
                        str = value.f6039O000000o;
                    }
                    strArr[0] = str;
                    mMiPlayClient.f6040O000000o.O00000Oo(strArr);
                    return;
                }
                return;
            }
            MiPlayClient mMiPlayClient2 = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
            if (mMiPlayClient2 != null) {
                String[] strArr2 = new String[1];
                MiPlayDevice value2 = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                if (value2 != null) {
                    str = value2.f6039O000000o;
                }
                strArr2[0] = str;
                mMiPlayClient2.f6040O000000o.O00000o0(strArr2);
            }
        }

        public final void prev() {
            MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
            if (mMiPlayClient != null) {
                String[] strArr = new String[1];
                MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                strArr[0] = value == null ? null : value.f6039O000000o;
                mMiPlayClient.f6040O000000o.O0000OOo(strArr);
            }
        }

        public final void next() {
            MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
            if (mMiPlayClient != null) {
                String[] strArr = new String[1];
                MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                strArr[0] = value == null ? null : value.f6039O000000o;
                mMiPlayClient.f6040O000000o.O0000O0o(strArr);
            }
        }

        public final void modifyVolumeByValue(int i) {
            MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
            if (mMiPlayClient != null) {
                String[] strArr = new String[1];
                MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                strArr[0] = value == null ? null : value.f6039O000000o;
                mMiPlayClient.f6040O000000o.O000000o(strArr, i);
            }
        }

        public final void seek(long j) {
            Integer num;
            Remote.Response.PlayerStatus playerStatus;
            MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
            Remote.Response.PlayingData playingData = null;
            if (mMiPlayClient == null) {
                num = null;
            } else {
                String[] strArr = new String[1];
                MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                strArr[0] = value == null ? null : value.f6039O000000o;
                num = Integer.valueOf(mMiPlayClient.f6040O000000o.O000000o(strArr, j));
            }
            if (num != null && num.intValue() == 0) {
                ContentInfo value2 = UwbMicoPlayerManager.INSTANCE.getMiplayLiveData().getValue();
                if (!(value2 == null || (playerStatus = value2.getPlayerStatus()) == null)) {
                    playingData = playerStatus.play_song_detail;
                }
                if (playingData != null) {
                    playingData.position = j;
                }
            }
        }
    }

    private BaseControlChannel() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel$REMOTE;", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel;", "Lcom/xiaomi/smarthome/uwb/mico/MicoBaseAction;", "()V", "modifyVolumeByValue", "", "int", "", "next", "playOrPause", "play", "", "prev", "seek", "position", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class REMOTE extends BaseControlChannel implements MicoBaseAction {
        public static final REMOTE INSTANCE = new REMOTE();

        private REMOTE() {
            super(null);
        }

        public final void playOrPause(boolean z) {
            PlayerManager.getInstance().playOrPause(null);
        }

        public final void prev() {
            PlayerManager.getInstance().prev(null);
        }

        public final void next() {
            PlayerManager.getInstance().next(null);
        }

        public final void modifyVolumeByValue(int i) {
            PlayerManager.getInstance().modifyVolumeByValue(i).subscribeOn(Schedulers.newThread()).subscribe(new Action1(i) {
                /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$BaseControlChannel$REMOTE$DQwPzwqlU0XRvb1nXCFOQZnwc */
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void call(Object obj) {
                    BaseControlChannel.REMOTE.m519modifyVolumeByValue$lambda0(this.f$0, (Remote.Response.NullInfo) obj);
                }
            }, new Action1(i) {
                /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$BaseControlChannel$REMOTE$dcN0VzvUpAptiG9GZDjX427QAms */
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void call(Object obj) {
                    BaseControlChannel.REMOTE.m520modifyVolumeByValue$lambda1(this.f$0, (Throwable) obj);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: modifyVolumeByValue$lambda-0  reason: not valid java name */
        public static final void m519modifyVolumeByValue$lambda0(int i, Remote.Response.NullInfo nullInfo) {
            Remote.Response.PlayerStatus value = UwbMicoPlayerManager.INSTANCE.getRemoteLiveData().getValue();
            if (value != null) {
                value.volume = i;
            }
            UwbMicoPlayerManager.INSTANCE.getRemoteLiveData().postValue(UwbMicoPlayerManager.INSTANCE.getRemoteLiveData().getValue());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Throwable]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        /* renamed from: modifyVolumeByValue$lambda-1  reason: not valid java name */
        public static final void m520modifyVolumeByValue$lambda1(int i, Throwable th) {
            gsy.O00000Oo("PlayerVolumeBar", ixe.O000000o("modifyVolume: ", (Object) th));
            Remote.Response.PlayerStatus value = UwbMicoPlayerManager.INSTANCE.getRemoteLiveData().getValue();
            if (value != null) {
                value.volume = i;
            }
            UwbMicoPlayerManager.INSTANCE.getRemoteLiveData().postValue(UwbMicoPlayerManager.INSTANCE.getRemoteLiveData().getValue());
        }

        public final void seek(long j) {
            PlayerManager.getInstance().setPosition(j, null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel$UWB;", "Lcom/xiaomi/smarthome/uwb/mico/BaseControlChannel;", "Lcom/xiaomi/smarthome/uwb/mico/MicoBaseAction;", "()V", "modifyVolumeByValue", "", "int", "", "next", "playOrPause", "play", "", "prev", "seek", "position", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UWB extends BaseControlChannel implements MicoBaseAction {
        public static final UWB INSTANCE = new UWB();

        public final void seek(long j) {
        }

        private UWB() {
            super(null);
        }

        public final void playOrPause(boolean z) {
            UwbLouderSpeakerApi.playOrPause(z);
        }

        public final void prev() {
            UwbLouderSpeakerApi.prev();
        }

        public final void next() {
            UwbLouderSpeakerApi.next();
        }

        public final void modifyVolumeByValue(int i) {
            UwbLouderSpeakerApi.setVolume(i);
        }
    }
}
