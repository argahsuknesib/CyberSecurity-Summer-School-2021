package com.xiaomi.smarthome.uwb.mico;

import _m_j.fe;
import _m_j.fg;
import _m_j.fh;
import _m_j.fm;
import _m_j.fno;
import _m_j.gsy;
import _m_j.hzh;
import _m_j.hzj;
import _m_j.hzk;
import _m_j.itz;
import _m_j.iua;
import _m_j.iuf;
import _m_j.iuo;
import _m_j.ivb;
import _m_j.ixc;
import _m_j.ixe;
import androidx.lifecycle.LiveData;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.RecentPlayApiHelper;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import com.xiaomi.miplay.audioclient.sdk.MiPlayClient;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.mico.MicoHelper;
import com.xiaomi.smarthome.uwb.api.UwbLouderSpeakerApi;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbMicoRpcPlatfrom;
import com.xiaomi.smarthome.uwb.mico.Command;
import com.xiaomi.smarthome.uwb.mico.UwbMicoPlayerViewModel$mMicoBaseActionImpl$2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0018\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t00J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000700J\f\u00102\u001a\b\u0012\u0004\u0012\u00020300J\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)00J\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0)00J\u0006\u00106\u001a\u00020.J\u0006\u00107\u001a\u00020.J\b\u00108\u001a\u00020.H\u0014J\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010>J\u000e\u0010?\u001a\u00020.2\u0006\u0010=\u001a\u00020>J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u001e0 j\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e`!X\u000e¢\u0006\u0002\n\u0000R \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0)0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "DURATION_UPDATE_PROGRESS", "", "contentLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/xiaomi/smarthome/uwb/mico/ContentInfo;", "controlLiveData", "Lcom/xiaomi/smarthome/uwb/mico/BaseControl;", "durationUpdateLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/lang/Void;", "getDurationUpdateLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setDurationUpdateLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "fakeMico", "Lcom/xiaomi/mico/api/model/Admin$Mico;", "getFakeMico", "()Lcom/xiaomi/mico/api/model/Admin$Mico;", "setFakeMico", "(Lcom/xiaomi/mico/api/model/Admin$Mico;)V", "mMicoBaseActionImpl", "com/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel$mMicoBaseActionImpl$2$1", "getMMicoBaseActionImpl", "()Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel$mMicoBaseActionImpl$2$1;", "mMicoBaseActionImpl$delegate", "Lkotlin/Lazy;", "mMusicCacheSubscription", "Lrx/Subscription;", "mSubscriptions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "playerPositionLiveData", "Lcom/xiaomi/mico/music/event/MusicEvent$PlayerPositionEvent;", "getPlayerPositionLiveData", "setPlayerPositionLiveData", "playerStatusOld", "Lcom/xiaomi/mico/api/model/Remote$Response$PlayerStatus;", "recentSongs", "", "Lcom/xiaomi/mico/api/model/Music$Song;", "recommendSongs", "Lcom/xiaomi/mico/api/model/PatchWall$Item;", "cancelMusicCacheSubscription", "", "getBaseController", "Landroidx/lifecycle/LiveData;", "getContents", "getMiPlayDeviceLiveData", "Lcom/xiaomi/miplay/audioclient/MiPlayDevice;", "getRecentSongs", "getRecommendSongs", "miplayAudioPlay", "miplayAudioStop", "onCleared", "sendCommand", "command", "Lcom/xiaomi/smarthome/uwb/mico/Command;", "setUwbScanDevice", "mUwbScanDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "updateCurrentMico", "updateMusic", "playerStatus", "Companion", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoPlayerViewModel extends fm {
    public static final Companion Companion = new Companion(null);
    private final long DURATION_UPDATE_PROGRESS = 1000;
    private fe<ContentInfo> contentLiveData = new fe<>();
    private fe<BaseControl> controlLiveData = new fe<>();
    private fg<Void> durationUpdateLiveData = new fg<>();
    private Admin.Mico fakeMico;
    private final itz mMicoBaseActionImpl$delegate = iua.O000000o(UwbMicoPlayerViewModel$mMicoBaseActionImpl$2.INSTANCE);
    private Subscription mMusicCacheSubscription;
    private ArrayList<Subscription> mSubscriptions = new ArrayList<>();
    private fg<MusicEvent.PlayerPositionEvent> playerPositionLiveData = new fg<>();
    private Remote.Response.PlayerStatus playerStatusOld;
    private fe<List<Music.Song>> recentSongs = new fe<>();
    private fe<List<PatchWall.Item>> recommendSongs = new fe<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel$Companion;", "", "()V", "TAG", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public UwbMicoPlayerViewModel() {
        UwbLouderSpeakerApi.isUWBAvailable();
        this.mSubscriptions.add(Observable.interval(this.DURATION_UPDATE_PROGRESS, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe((Subscriber) new Subscriber<Long>(this) {
            /* class com.xiaomi.smarthome.uwb.mico.UwbMicoPlayerViewModel.AnonymousClass1 */
            final /* synthetic */ UwbMicoPlayerViewModel this$0;

            public final void onCompleted() {
            }

            {
                this.this$0 = r1;
            }

            public final /* synthetic */ void onNext(Object obj) {
                onNext(((Number) obj).longValue());
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.Long]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final void onNext(long j) {
                Integer num;
                Integer num2;
                DidInfo didInfo;
                gsy.O000000o(LogType.LOG_UWB, "", 2, "zxtUwbMicoPlayerViewModel", ixe.O000000o("onNext: ", (Object) Long.valueOf(j)));
                UwbScanDevice mUwbScanDevice = UwbMicoPlayerManager.INSTANCE.getMUwbScanDevice();
                String did = (mUwbScanDevice == null || (didInfo = mUwbScanDevice.getDidInfo()) == null) ? null : didInfo.getDid();
                MiPlayDevice value = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().getValue();
                if (UwbDeviceUtil.isUwbHashEnd(did, value == null ? null : value.O0000O0o)) {
                    MiPlayDevice value2 = this.this$0.getMiPlayDeviceLiveData().getValue();
                    if (value2 == null) {
                        num = null;
                    } else {
                        num = Integer.valueOf(value2.O0000o0);
                    }
                    if (num != null && num.intValue() == 1) {
                        MiPlayDevice value3 = this.this$0.getMiPlayDeviceLiveData().getValue();
                        if (value3 == null) {
                            num2 = null;
                        } else {
                            num2 = Integer.valueOf(value3.O0000o00);
                        }
                        if (num2 != null && num2.intValue() == 2) {
                            MiPlayClient mMiPlayClient = UwbMicoPlayerManager.INSTANCE.getMMiPlayClient();
                            if (mMiPlayClient != null) {
                                String[] strArr = new String[1];
                                MiPlayDevice value4 = this.this$0.getMiPlayDeviceLiveData().getValue();
                                strArr[0] = value4 == null ? null : value4.f6039O000000o;
                                mMiPlayClient.f6040O000000o.O00000oO(strArr);
                            }
                            this.this$0.getDurationUpdateLiveData().postValue(null);
                        }
                    }
                }
                if (UwbLouderSpeakerApi.isUWBAvailable() && j % 5 == 0 && this.this$0.getMiPlayDeviceLiveData().getValue() == null) {
                    UwbLouderSpeakerApi.getProp(new UwbMicoPlayerViewModel$1$onNext$1());
                }
                this.this$0.getDurationUpdateLiveData().postValue(null);
            }

            public final void onError(Throwable th) {
                String str;
                String str2;
                if (th == null || (str = th.getMessage()) == null) {
                    str = "";
                }
                gsy.O000000o(3, "UwbMicoPlayerViewModel", str);
                LogType logType = LogType.LOG_UWB;
                if (th == null || (str2 = th.getMessage()) == null) {
                    str2 = "";
                }
                gsy.O000000o(logType, "", 6, "zxtUwbMicoPlayerViewModel", str2);
            }
        }));
        this.contentLiveData.O000000o(UwbMicoPlayerManager.INSTANCE.getRemoteLiveData(), new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$ennYmXv4u73l64TiLQsRBEN2egc */

            public final void onChanged(Object obj) {
                UwbMicoPlayerViewModel.m540_init_$lambda2(UwbMicoPlayerViewModel.this, (Remote.Response.PlayerStatus) obj);
            }
        });
        this.contentLiveData.O000000o(UwbMicoPlayerManager.INSTANCE.getMiplayLiveData(), new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$JopMs8SnETbK51_IDtWf9ta2fQ */

            public final void onChanged(Object obj) {
                UwbMicoPlayerViewModel.m541_init_$lambda4(UwbMicoPlayerViewModel.this, (ContentInfo) obj);
            }
        });
        this.controlLiveData.O000000o(UwbMicoPlayerManager.INSTANCE.getRemoteLiveData(), new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$CawKmgQEWjmeIjG3gVKQxeTgM */

            public final void onChanged(Object obj) {
                UwbMicoPlayerViewModel.m542_init_$lambda6(UwbMicoPlayerViewModel.this, (Remote.Response.PlayerStatus) obj);
            }
        });
        this.controlLiveData.O000000o(UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData(), new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$0IAFTKQ2j9RFOzoqQOrWJ7nWGE */

            public final void onChanged(Object obj) {
                UwbMicoPlayerViewModel.m543_init_$lambda8(UwbMicoPlayerViewModel.this, (MiPlayDevice) obj);
            }
        });
        this.controlLiveData.O000000o(UwbMicoPlayerManager.INSTANCE.getUwbLiveData(), new fh() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$vSpG7sOT0UohqojNMoKOanq0yQ */

            public final void onChanged(Object obj) {
                UwbMicoPlayerViewModel.m539_init_$lambda10(UwbMicoPlayerViewModel.this, (BaseControl) obj);
            }
        });
    }

    public final fg<Void> getDurationUpdateLiveData() {
        return this.durationUpdateLiveData;
    }

    public final void setDurationUpdateLiveData(fg<Void> fgVar) {
        ixe.O00000o(fgVar, "<set-?>");
        this.durationUpdateLiveData = fgVar;
    }

    public final fg<MusicEvent.PlayerPositionEvent> getPlayerPositionLiveData() {
        return this.playerPositionLiveData;
    }

    public final void setPlayerPositionLiveData(fg<MusicEvent.PlayerPositionEvent> fgVar) {
        ixe.O00000o(fgVar, "<set-?>");
        this.playerPositionLiveData = fgVar;
    }

    private final UwbMicoPlayerViewModel$mMicoBaseActionImpl$2.AnonymousClass1 getMMicoBaseActionImpl() {
        return (UwbMicoPlayerViewModel$mMicoBaseActionImpl$2.AnonymousClass1) this.mMicoBaseActionImpl$delegate.O000000o();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m540_init_$lambda2(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, Remote.Response.PlayerStatus playerStatus) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        if (playerStatus != null && uwbMicoPlayerViewModel.getMiPlayDeviceLiveData().getValue() == null) {
            gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", "内容播放 remote");
            if (playerStatus.play_song_detail != null) {
                uwbMicoPlayerViewModel.updateMusic(playerStatus);
                return;
            }
            gsy.O000000o(LogType.LOG_UWB, "", 6, "zxtUwbMicoPlayerViewModel", "内容播放 play_song_detai == null");
            uwbMicoPlayerViewModel.contentLiveData.postValue(new ContentInfo(playerStatus, null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final void m541_init_$lambda4(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, ContentInfo contentInfo) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        if (contentInfo != null) {
            if (contentInfo.getPlayerStatus() instanceof MiPlayStreamPlayerStatus) {
                gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", "内容播放 miplay 推流模式");
            } else {
                gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", "内容播放 miplay 独立播放");
            }
            uwbMicoPlayerViewModel.contentLiveData.postValue(contentInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-6  reason: not valid java name */
    public static final void m542_init_$lambda6(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, Remote.Response.PlayerStatus playerStatus) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        if (playerStatus != null && uwbMicoPlayerViewModel.getMiPlayDeviceLiveData().getValue() == null && !UwbLouderSpeakerApi.isUWBAvailable()) {
            gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", "基础控制 remote");
            uwbMicoPlayerViewModel.controlLiveData.postValue(new BaseControl(playerStatus.status, playerStatus.volume));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-8  reason: not valid java name */
    public static final void m543_init_$lambda8(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, MiPlayDevice miPlayDevice) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        if (miPlayDevice != null) {
            gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", "基础控制 miplay");
            int i = 2;
            if (miPlayDevice.O0000o00 == 2) {
                i = 1;
            }
            ixe.O00000Oo(miPlayDevice, "it");
            uwbMicoPlayerViewModel.controlLiveData.postValue(new BaseControl(i, UwbMicoPlayerManagerKt.getVolume(miPlayDevice)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-10  reason: not valid java name */
    public static final void m539_init_$lambda10(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, BaseControl baseControl) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        if (baseControl != null) {
            gsy.O000000o(LogType.LOG_UWB, "", 3, "zxtUwbMicoPlayerViewModel", "基础控制 uwb");
            uwbMicoPlayerViewModel.controlLiveData.postValue(baseControl);
        }
    }

    public final Admin.Mico getFakeMico() {
        return this.fakeMico;
    }

    public final void setFakeMico(Admin.Mico mico) {
        this.fakeMico = mico;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public final void updateCurrentMico(UwbScanDevice uwbScanDevice) {
        boolean z;
        Device O000000o2;
        ixe.O00000o(uwbScanDevice, "mUwbScanDevice");
        String modelByProductId = PluginDeviceManager.instance.getModelByProductId((int) uwbScanDevice.getPid());
        LogType logType = LogType.LOG_UWB;
        gsy.O000000o(logType, "", 4, "zxtUwbMicoPlayerViewModel", "updateCurrentMico plainDid = " + ((Object) uwbScanDevice.getDidInfo().getPlainDid()) + " MicoHelper sInit = " + MicoHelper.f9514O000000o + " model = " + ((Object) modelByProductId));
        if (MicoHelper.f9514O000000o) {
            hzh O00000Oo = hzj.O00000Oo();
            hzk cacheConfig = O00000Oo == null ? null : O00000Oo.getCacheConfig();
            if (cacheConfig != null) {
                ixe.O00000Oo(modelByProductId, "model");
                ixe.O00000o(cacheConfig, "<this>");
                ixe.O00000o(modelByProductId, "model");
                if (cacheConfig.f1012O000000o.f1011O000000o.contains(modelByProductId)) {
                    z = true;
                    UwbMicoRpcPlatfrom.init(z);
                    O000000o2 = fno.O000000o().O000000o(uwbScanDevice.getDidInfo().getPlainDid());
                    if (O000000o2 == null) {
                        ApiHelper.setApiProvider(new UwbMicoPlayerViewModel$updateCurrentMico$1$1(O000000o2));
                        PlayerManager.getInstance().setUwbRemoteLiveData(UwbMicoPlayerManager.INSTANCE.getRemoteLiveData());
                        setFakeMico(new Admin.Mico());
                        Admin.Mico fakeMico2 = getFakeMico();
                        if (fakeMico2 != null) {
                            fakeMico2.deviceID = O000000o2.did;
                        }
                        Admin.Mico fakeMico3 = getFakeMico();
                        if (fakeMico3 != null) {
                            fakeMico3.miotDID = O000000o2.did;
                        }
                        Admin.Mico fakeMico4 = getFakeMico();
                        if (fakeMico4 != null) {
                            fakeMico4.capabilities = ivb.O000000o(iuf.O000000o(MicoCapability.AI_PROTOCOL_3_0.toString(), 1));
                        }
                        MicoManager.getInstance().updateCurrentMico(getFakeMico());
                        PlayerManager.getInstance().startQuery();
                        return;
                    }
                    return;
                }
            }
            z = false;
            UwbMicoRpcPlatfrom.init(z);
            O000000o2 = fno.O000000o().O000000o(uwbScanDevice.getDidInfo().getPlainDid());
            if (O000000o2 == null) {
            }
        }
    }

    public final LiveData<ContentInfo> getContents() {
        return this.contentLiveData;
    }

    public final LiveData<BaseControl> getBaseController() {
        return this.controlLiveData;
    }

    public final LiveData<MiPlayDevice> getMiPlayDeviceLiveData() {
        return UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData();
    }

    public final LiveData<List<Music.Song>> getRecentSongs() {
        this.mSubscriptions.add(RecentPlayApiHelper.getRecentPlayListObservable().delay(100, TimeUnit.MILLISECONDS).onErrorReturn($$Lambda$UwbMicoPlayerViewModel$JWzA3g4tdNk7fpKs2IhydqIZxXk.INSTANCE).subscribe(new Action1() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$R2k2dciX5tUaxhAGXvMZRP3vk */

            public final void call(Object obj) {
                UwbMicoPlayerViewModel.m545getRecentSongs$lambda13(UwbMicoPlayerViewModel.this, (List) obj);
            }
        }, $$Lambda$UwbMicoPlayerViewModel$UeEvNa1O8aiC3UdAKzn45ZGVhD8.INSTANCE));
        return this.recentSongs;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRecentSongs$lambda-12  reason: not valid java name */
    public static final List m544getRecentSongs$lambda12(Throwable th) {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    /* renamed from: getRecentSongs$lambda-13  reason: not valid java name */
    public static final void m545getRecentSongs$lambda13(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, List list) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        fe<List<Music.Song>> feVar = uwbMicoPlayerViewModel.recentSongs;
        if (list == null) {
            list = EmptyList.f15376O000000o;
        }
        feVar.postValue(list);
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
    /* renamed from: getRecentSongs$lambda-14  reason: not valid java name */
    public static final void m546getRecentSongs$lambda14(Throwable th) {
        gsy.O000000o(LogType.LOG_UWB, "", 6, "zxtUwbMicoPlayerViewModel", ixe.O000000o("getRecentSongs throwable: ", (Object) th));
    }

    public final LiveData<List<PatchWall.Item>> getRecommendSongs() {
        this.mSubscriptions.add(ObservableApiHelper.getQQPatchWallFlowV2(0, 1).onErrorReturn($$Lambda$UwbMicoPlayerViewModel$I8VeJaZLzLb6vgAIPsyK0hlrbw8.INSTANCE).subscribe(new Action1() {
            /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$iBVsauTnI0q7TCA8iW8jM4LAUE */

            public final void call(Object obj) {
                UwbMicoPlayerViewModel.m548getRecommendSongs$lambda17(UwbMicoPlayerViewModel.this, (PatchWall) obj);
            }
        }, $$Lambda$UwbMicoPlayerViewModel$q9nay1yNL5goGKM7w57VOF2EuB4.INSTANCE));
        return this.recommendSongs;
    }

    /* access modifiers changed from: private */
    /* renamed from: getRecommendSongs$lambda-16  reason: not valid java name */
    public static final PatchWall m547getRecommendSongs$lambda16(Throwable th) {
        return new PatchWall();
    }

    /* access modifiers changed from: private */
    /* renamed from: getRecommendSongs$lambda-17  reason: not valid java name */
    public static final void m548getRecommendSongs$lambda17(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, PatchWall patchWall) {
        PatchWall.Block block;
        List<PatchWall.Item> list;
        List<PatchWall.Block> list2;
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        int i = 0;
        List list3 = null;
        if (patchWall == null || (list2 = patchWall.blocks) == null) {
            block = null;
        } else {
            block = list2.get(0);
        }
        if (!(block == null || (list = block.items) == null)) {
            Iterable iterable = list;
            ixe.O00000o0(iterable, "receiver$0");
            if (!(iterable instanceof Collection) || 2 < ((Collection) iterable).size()) {
                ArrayList arrayList = new ArrayList(2);
                for (Object next : iterable) {
                    int i2 = i + 1;
                    if (i == 2) {
                        break;
                    }
                    arrayList.add(next);
                    i = i2;
                }
                list3 = iuo.O00000Oo((List) arrayList);
            } else {
                list3 = iuo.O00000o0(iterable);
            }
        }
        if (list3 == null) {
            list3 = EmptyList.f15376O000000o;
        }
        uwbMicoPlayerViewModel.recommendSongs.postValue(list3);
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
    /* renamed from: getRecommendSongs$lambda-18  reason: not valid java name */
    public static final void m549getRecommendSongs$lambda18(Throwable th) {
        gsy.O000000o(LogType.LOG_UWB, "", 6, "zxtUwbMicoPlayerViewModel", ixe.O000000o("getRecommendSongs throwable: ", (Object) th));
    }

    public final void onCleared() {
        super.onCleared();
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtUwbMicoPlayerViewModel", "onCleared");
        Iterator<Subscription> it = this.mSubscriptions.iterator();
        while (it.hasNext()) {
            Subscription next = it.next();
            if (next != null && !next.isUnsubscribed()) {
                next.unsubscribe();
            }
        }
        this.mSubscriptions.clear();
        ApiHelper.setApiProvider(null);
        PlayerManager.getInstance().setUwbRemoteLiveData(null);
        if (this.fakeMico != null) {
            MicoManager instance = MicoManager.getInstance();
            instance.updateCurrentMico(instance.autoSelectMico());
            PlayerManager.getInstance().stopQuery();
        }
        UwbMicoPlayerManager.INSTANCE.setUwbScanDevice(null);
        UwbMicoPlayerManager.INSTANCE.unInitMiplayClientIfNeed();
        UwbLouderSpeakerApi.clear();
    }

    private final void updateMusic(Remote.Response.PlayerStatus playerStatus) {
        boolean z = this.playerStatusOld == null;
        Remote.Response.PlayerStatus playerStatus2 = this.playerStatusOld;
        if (playerStatus2 != null) {
            Remote.Response.PlayingData playingData = playerStatus2.play_song_detail;
            Integer num = null;
            Integer valueOf = playingData == null ? null : Integer.valueOf(playingData.hashCode());
            Remote.Response.PlayingData playingData2 = playerStatus.play_song_detail;
            if (playingData2 != null) {
                num = Integer.valueOf(playingData2.hashCode());
            }
            if (!ixe.O000000o(valueOf, num)) {
                z = true;
            }
        }
        this.playerStatusOld = playerStatus;
        if (z) {
            cancelMusicCacheSubscription();
            if (playerStatus.play_song_detail.audio_id == 0 && playerStatus.play_song_detail.musicID != 0) {
                Admin.Mico mico = this.fakeMico;
                if (mico != null) {
                    mico.capabilities = ivb.O000000o(iuf.O000000o(MicoCapability.AI_PROTOCOL_3_0.toString(), 0));
                }
                playerStatus.play_song_detail.audio_id = playerStatus.play_song_detail.musicID;
            }
            Subscription subscribe = MusicCache.getSong(playerStatus.play_song_detail.audio_id).subscribe(new Action1(playerStatus) {
                /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$FIX1f7Awjw944k8jA9JBWyZ0VE8 */
                private final /* synthetic */ Remote.Response.PlayerStatus f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    UwbMicoPlayerViewModel.m556updateMusic$lambda25(UwbMicoPlayerViewModel.this, this.f$1, (Music.Song) obj);
                }
            }, new Action1(playerStatus) {
                /* class com.xiaomi.smarthome.uwb.mico.$$Lambda$UwbMicoPlayerViewModel$7oGJwdOdSl1A9FpbLSrQ89ewRDo */
                private final /* synthetic */ Remote.Response.PlayerStatus f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    UwbMicoPlayerViewModel.m557updateMusic$lambda26(UwbMicoPlayerViewModel.this, this.f$1, (Throwable) obj);
                }
            });
            this.mSubscriptions.add(subscribe);
            this.mMusicCacheSubscription = subscribe;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateMusic$lambda-25  reason: not valid java name */
    public static final void m556updateMusic$lambda25(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, Remote.Response.PlayerStatus playerStatus, Music.Song song) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        ixe.O00000o(playerStatus, "$playerStatus");
        ixe.O00000o(song, "song");
        Admin.Mico fakeMico2 = uwbMicoPlayerViewModel.getFakeMico();
        if (fakeMico2 != null && !fakeMico2.hasCapability(MicoCapability.AI_PROTOCOL_3_0)) {
            song.audioID = String.valueOf(song.songID);
        }
        uwbMicoPlayerViewModel.contentLiveData.postValue(new ContentInfo(playerStatus, song));
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
    /* renamed from: updateMusic$lambda-26  reason: not valid java name */
    public static final void m557updateMusic$lambda26(UwbMicoPlayerViewModel uwbMicoPlayerViewModel, Remote.Response.PlayerStatus playerStatus, Throwable th) {
        ixe.O00000o(uwbMicoPlayerViewModel, "this$0");
        ixe.O00000o(playerStatus, "$playerStatus");
        gsy.O000000o(LogType.LOG_UWB, "", 6, "zxtUwbMicoPlayerViewModel", ixe.O000000o("updateMusic: ", (Object) th));
        uwbMicoPlayerViewModel.contentLiveData.postValue(new ContentInfo(playerStatus, null));
    }

    private final void cancelMusicCacheSubscription() {
        Subscription subscription = this.mMusicCacheSubscription;
        if (subscription != null) {
            ixe.O000000o(subscription);
            if (!subscription.isUnsubscribed()) {
                Subscription subscription2 = this.mMusicCacheSubscription;
                ixe.O000000o(subscription2);
                subscription2.unsubscribe();
                this.mMusicCacheSubscription = null;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void sendCommand(Command command) {
        ixe.O00000o(command, "command");
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtUwbMicoPlayerViewModel", ixe.O000000o("sendCommand: ", (Object) command.getClass().getSimpleName()));
        boolean z = command instanceof Command.Seek;
        if (!z) {
            UwbMicoPlayerManager.INSTANCE.changeBaseControlChannelIfNeed();
        } else {
            UwbMicoPlayerManager.INSTANCE.changeSeekChannelIfNeed();
        }
        if (command instanceof Command.PlayOrPause) {
            getMMicoBaseActionImpl().playOrPause(((Command.PlayOrPause) command).getPlay());
        } else if (command instanceof Command.Prev) {
            getMMicoBaseActionImpl().prev();
        } else if (command instanceof Command.Next) {
            getMMicoBaseActionImpl().next();
        } else if (command instanceof Command.ModifyVolumeByValue) {
            getMMicoBaseActionImpl().modifyVolumeByValue(((Command.ModifyVolumeByValue) command).getVolume());
        } else if (z) {
            getMMicoBaseActionImpl().seek(((Command.Seek) command).getPosition());
        }
    }

    public final void miplayAudioPlay() {
        UwbMicoPlayerManager.INSTANCE.miplayAudioPlay();
    }

    public final void miplayAudioStop() {
        UwbMicoPlayerManager.INSTANCE.miplayAudioStop();
    }

    public final void setUwbScanDevice(UwbScanDevice uwbScanDevice) {
        UwbMicoPlayerManager.INSTANCE.setUwbScanDevice(uwbScanDevice);
        UwbMicoPlayerManager.INSTANCE.initMiplayClientIfNeed();
    }
}
