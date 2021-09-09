package com.xiaomi.smarthome.uwb.mico;

import _m_j.fg;
import _m_j.gsy;
import _m_j.iuh;
import _m_j.ixc;
import _m_j.ixe;
import _m_j.iyo;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.BitmapUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.miplay.audioclient.MediaMetaData;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import com.xiaomi.miplay.audioclient.sdk.MiPlayClient;
import com.xiaomi.miplay.audioclient.sdk.MiPlayClientCallback;
import com.xiaomi.miplay.audioclient.sdk.MiracastClient;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 .2\u00020\u0001:\u0001.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0002J\"\u0010\u0016\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010\u0018\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010\u0019\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nH\u0016J\"\u0010!\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\"\u0010$\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010%\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010&\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010'\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010(\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010)\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010*\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010+\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010,\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\"\u0010-\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006/"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/MiPlayClientCallBackImpl;", "Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClientCallback;", "mMiPlayClient", "Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClient;", "mUwbScanDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "(Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClient;Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;)V", "getMMiPlayClient", "()Lcom/xiaomi/miplay/audioclient/sdk/MiPlayClient;", "mMiplayDevice", "Lcom/xiaomi/miplay/audioclient/MiPlayDevice;", "getMMiplayDevice", "()Lcom/xiaomi/miplay/audioclient/MiPlayDevice;", "setMMiplayDevice", "(Lcom/xiaomi/miplay/audioclient/MiPlayDevice;)V", "getMUwbScanDevice", "()Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "getAndPostMediaInfo", "", "mediaInfoMap", "", "", "onBtFrequencyACK", "p0", "onBufferStateChange", "onChannelsAck", "onDeviceConnectStateChange", "", "p1", "", "onDeviceFound", "onDeviceLost", "onDeviceUpdate", "onDisconnectNotify", "onInitError", "onInitSuccess", "onMediaInfoAck", "onMediaInfoChange", "onMirrorModeAck", "onMirrorModeNotify", "onPlayStateAck", "onPlayStateChange", "onPositionAck", "onVolumeAck", "onVolumeChange", "volumeDisplay", "Companion", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MiPlayClientCallBackImpl extends MiPlayClientCallback {
    public static final Companion Companion = new Companion(null);
    private final MiPlayClient mMiPlayClient;
    private MiPlayDevice mMiplayDevice;
    private final UwbScanDevice mUwbScanDevice;

    public final void onBtFrequencyACK(Map<Object, Object> map) {
    }

    public final void onDisconnectNotify(Map<Object, Object> map) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/uwb/mico/MiPlayClientCallBackImpl$Companion;", "", "()V", "TAG", "", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(ixc ixc) {
            this();
        }

        private Companion() {
        }
    }

    public MiPlayClientCallBackImpl(MiPlayClient miPlayClient, UwbScanDevice uwbScanDevice) {
        ixe.O00000o(miPlayClient, "mMiPlayClient");
        ixe.O00000o(uwbScanDevice, "mUwbScanDevice");
        this.mMiPlayClient = miPlayClient;
        this.mUwbScanDevice = uwbScanDevice;
    }

    public final MiPlayClient getMMiPlayClient() {
        return this.mMiPlayClient;
    }

    public final UwbScanDevice getMUwbScanDevice() {
        return this.mUwbScanDevice;
    }

    public final MiPlayDevice getMMiplayDevice() {
        return this.mMiplayDevice;
    }

    public final void setMMiplayDevice(MiPlayDevice miPlayDevice) {
        this.mMiplayDevice = miPlayDevice;
    }

    public final void onInitSuccess() {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", "onInitSuccess");
        MiracastClient miracastClient = this.mMiPlayClient.f6040O000000o;
        if (miracastClient.O00000o0 == null) {
            return;
        }
        if (!miracastClient.O00000o0.asBinder().pingBinder()) {
            miracastClient.O000000o(miracastClient.O00000oO, miracastClient.O0000O0o);
            return;
        }
        try {
            miracastClient.O00000o.clear();
            miracastClient.O00000o0.startDiscovery(2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onInitError() {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", "onInitError");
    }

    public final void onDeviceFound(MiPlayDevice miPlayDevice) {
        ixe.O00000o(miPlayDevice, "p0");
        try {
            LogType logType = LogType.LOG_UWB;
            StringBuilder sb = new StringBuilder("onDeviceFound: ");
            sb.append((Object) miPlayDevice.O00000Oo);
            sb.append(" MiPlayDeviceMiotDidHash = ");
            String uwbHashFirst3B = UwbDeviceUtil.getUwbHashFirst3B(miPlayDevice.O0000O0o);
            ixe.O00000Oo(uwbHashFirst3B, "it");
            String substring = uwbHashFirst3B.substring(uwbHashFirst3B.length() - 6);
            ixe.O00000Oo(substring, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            sb.append(" UwbScanDeviceDidHash = ");
            String did = this.mUwbScanDevice.getDidInfo().getDid();
            ixe.O00000Oo(did, "it");
            String substring2 = did.substring(did.length() - 6);
            ixe.O00000Oo(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            sb.append(" collectAudio = ");
            sb.append(this.mMiPlayClient.f6040O000000o.O000000o());
            gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", sb.toString());
            if (UwbDeviceUtil.isUwbHashEnd(this.mUwbScanDevice.getDidInfo().getDid(), miPlayDevice.O0000O0o)) {
                this.mMiplayDevice = miPlayDevice;
                UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().postValue(this.mMiplayDevice);
                MiPlayClient miPlayClient = this.mMiPlayClient;
                String[] strArr = new String[1];
                MiPlayDevice miPlayDevice2 = this.mMiplayDevice;
                String str = null;
                strArr[0] = miPlayDevice2 == null ? null : miPlayDevice2.f6039O000000o;
                miPlayClient.O000000o(strArr);
                MiPlayClient miPlayClient2 = this.mMiPlayClient;
                String[] strArr2 = new String[1];
                MiPlayDevice miPlayDevice3 = this.mMiplayDevice;
                if (miPlayDevice3 != null) {
                    str = miPlayDevice3.f6039O000000o;
                }
                strArr2[0] = str;
                miPlayClient2.f6040O000000o.O00000o(strArr2);
                this.mMiPlayClient.O000000o();
                ToastUtil.showToastDebug("onDeviceFound " + ((Object) miPlayDevice.O00000Oo) + ' ' + ((Object) miPlayDevice.f6039O000000o));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onDeviceUpdate(MiPlayDevice miPlayDevice) {
        ixe.O00000o(miPlayDevice, "p0");
        LogType logType = LogType.LOG_UWB;
        gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", "onDeviceUpdate: " + ((Object) miPlayDevice.f6039O000000o) + ' ' + ((Object) miPlayDevice.O00000Oo) + ' ' + miPlayDevice.O00000o0 + ' ' + ((Object) miPlayDevice.O00000oo) + ' ' + ((Object) miPlayDevice.O00000o) + ' ' + ((Object) miPlayDevice.O00000oO) + ' ' + ((Object) miPlayDevice.O0000O0o) + ' ' + ((Object) miPlayDevice.O0000OOo) + ' ' + ((Object) miPlayDevice.O0000Oo0) + ' ' + ((Object) miPlayDevice.O0000Oo) + ' ' + ((Object) miPlayDevice.O0000OoO) + ' ' + ((Object) miPlayDevice.O0000Ooo) + ' ' + miPlayDevice.O0000o00 + ' ' + miPlayDevice.O0000o0 + ' ' + miPlayDevice.O0000o0O);
        String str = miPlayDevice.f6039O000000o;
        MiPlayDevice miPlayDevice2 = this.mMiplayDevice;
        if (iyo.O000000o(str, miPlayDevice2 == null ? null : miPlayDevice2.f6039O000000o)) {
            this.mMiplayDevice = miPlayDevice;
            UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().postValue(this.mMiplayDevice);
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
    public final void onDeviceLost(String str) {
        ixe.O00000o(str, "p0");
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", ixe.O000000o("onDeviceLost: ", (Object) str));
        MiPlayDevice miPlayDevice = this.mMiplayDevice;
        if (iyo.O000000o(str, miPlayDevice == null ? null : miPlayDevice.f6039O000000o)) {
            this.mMiplayDevice = null;
            UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().postValue(this.mMiplayDevice);
        }
    }

    public final void onPositionAck(Map<Object, Object> map) {
        Remote.Response.PlayerStatus playerStatus;
        LogType logType = LogType.LOG_UWB;
        StringBuilder sb = new StringBuilder("onPositionAck: ");
        Remote.Response.PlayingData playingData = null;
        sb.append(map == null ? null : map.keySet());
        sb.append(' ');
        sb.append(map == null ? null : map.values());
        gsy.O000000o(logType, "", 3, "zxtMiPlayClientCallBack", sb.toString());
        if (map != null) {
            MiPlayDevice miPlayDevice = this.mMiplayDevice;
            Object obj = map.get(miPlayDevice == null ? null : miPlayDevice.f6039O000000o);
            if (obj != null) {
                ContentInfo value = UwbMicoPlayerManager.INSTANCE.getMiplayLiveData().getValue();
                if ((value == null ? null : value.getPlayerStatus()) instanceof MiPlayStreamPlayerStatus) {
                    ContentInfo value2 = UwbMicoPlayerManager.INSTANCE.getMiplayLiveData().getValue();
                    if (!(value2 == null || (playerStatus = value2.getPlayerStatus()) == null)) {
                        playingData = playerStatus.play_song_detail;
                    }
                    if (playingData != null) {
                        playingData.position = ((Long) obj).longValue();
                    }
                }
            }
        }
    }

    public final void onDeviceConnectStateChange(String str, int i) {
        LogType logType = LogType.LOG_UWB;
        gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", "onDeviceConnectStateChange: mac " + ((Object) str) + " state " + i);
        MiPlayDevice miPlayDevice = this.mMiplayDevice;
        String str2 = null;
        if (!iyo.O000000o(str, miPlayDevice == null ? null : miPlayDevice.f6039O000000o) || !(i == 1 || i == 0)) {
            ToastUtil.showToastDebug("onDeviceConnectStateChange err mac " + ((Object) str) + " state " + i);
            return;
        }
        MiPlayDevice miPlayDevice2 = this.mMiplayDevice;
        if (miPlayDevice2 != null) {
            miPlayDevice2.O0000o0 = i;
        }
        MiPlayClient miPlayClient = this.mMiPlayClient;
        String[] strArr = new String[1];
        MiPlayDevice miPlayDevice3 = this.mMiplayDevice;
        if (miPlayDevice3 != null) {
            str2 = miPlayDevice3.f6039O000000o;
        }
        strArr[0] = str2;
        miPlayClient.O000000o(strArr);
    }

    public final void onPlayStateChange(Map<Object, Object> map) {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", "onPlayStateChange: ");
    }

    public final void onPlayStateAck(Map<Object, Object> map) {
        LogType logType = LogType.LOG_UWB;
        StringBuilder sb = new StringBuilder("onPlayStateAck: ");
        Collection<Object> collection = null;
        sb.append(map == null ? null : map.keySet());
        sb.append(' ');
        if (map != null) {
            collection = map.values();
        }
        sb.append(collection);
        gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", sb.toString());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.Map<java.lang.Object, java.lang.Object>]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onMediaInfoAck(Map<Object, Object> map) {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", ixe.O000000o("onMediaInfoAck: ", (Object) map));
        getAndPostMediaInfo(map);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.Map<java.lang.Object, java.lang.Object>]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onMediaInfoChange(Map<Object, Object> map) {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", ixe.O000000o("onMediaInfoChange: ", (Object) map));
        getAndPostMediaInfo(map);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.xiaomi.miplay.audioclient.MiPlayDevice] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, android.graphics.Bitmap]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void getAndPostMediaInfo(Map<Object, Object> map) {
        Object obj;
        Integer num;
        Integer num2;
        Remote.Response.PlayerStatus playerStatus;
        Bitmap bitmap = null;
        if (map == null) {
            obj = null;
        } else {
            MiPlayDevice miPlayDevice = this.mMiplayDevice;
            obj = map.get(miPlayDevice == null ? null : miPlayDevice.f6039O000000o);
        }
        MediaMetaData mediaMetaData = obj instanceof MediaMetaData ? (MediaMetaData) obj : null;
        if (mediaMetaData == null || MiPlayClientCallBackImplKt.isEmpty(mediaMetaData)) {
            LogType logType = LogType.LOG_UWB;
            MiPlayDevice miPlayDevice2 = this.mMiplayDevice;
            if (miPlayDevice2 != null) {
                bitmap = miPlayDevice2.O0000O0o;
            }
            gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", ixe.O000000o("getAndPostMediaInfo: 获取的mediaInfo为空 ", (Object) bitmap));
            return;
        }
        try {
            Music.Song song = new Music.Song();
            song.artistDisplayName = mediaMetaData.f6038O000000o;
            song.albumName = mediaMetaData.O00000Oo;
            song.name = mediaMetaData.O00000o0;
            song.duration = mediaMetaData.O00000o;
            song.audioType = "";
            LogType logType2 = LogType.LOG_UWB;
            MiPlayDevice miPlayDevice3 = this.mMiplayDevice;
            if (miPlayDevice3 == null) {
                num = null;
            } else {
                num = Integer.valueOf(miPlayDevice3.O0000o0O);
            }
            gsy.O000000o(logType2, "", 4, "zxtMiPlayClientCallBack", ixe.O000000o("getAndPostMediaInfo: mirrorMode = ", (Object) num));
            MiPlayDevice miPlayDevice4 = this.mMiplayDevice;
            if (miPlayDevice4 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(miPlayDevice4.O0000o0O);
            }
            if (num2 != null) {
                if (num2.intValue() == 1) {
                    song.audioID = ixe.O000000o("miplay push stream ", (Object) mediaMetaData.O00000Oo);
                    if (mediaMetaData.O0000Oo0 != null) {
                        float dip2px = (float) DisplayUtils.dip2px(CommonApplication.getAppContext(), 55.0f);
                        bitmap = BitmapUtil.roundCornerImage(BitmapUtil.resizeBitmapByScale(mediaMetaData.O0000Oo0, dip2px / ((float) mediaMetaData.O0000Oo0.getWidth()), dip2px / ((float) mediaMetaData.O0000Oo0.getHeight()), true), DisplayUtils.dip2px(CommonApplication.getAppContext(), 10.0f));
                    }
                    playerStatus = new MiPlayStreamPlayerStatus(bitmap);
                    Remote.Response.PlayingData playingData = new Remote.Response.PlayingData();
                    playingData.duration = mediaMetaData.O00000o;
                    ((MiPlayStreamPlayerStatus) playerStatus).play_song_detail = playingData;
                    UwbMicoPlayerManager.INSTANCE.getMiplayLiveData().postValue(new ContentInfo(playerStatus, song));
                }
            }
            song.audioID = mediaMetaData.O00000oO;
            song.coverURL = mediaMetaData.O00000oo;
            playerStatus = new Remote.Response.PlayerStatus();
            playerStatus.status = mediaMetaData.O0000O0o;
            Long valueOf = Long.valueOf(mediaMetaData.O0000OOo);
            playerStatus.volume = valueOf == null ? 0 : (int) valueOf.longValue();
            playerStatus.play_song_detail = new Remote.Response.PlayingData();
            playerStatus.play_song_detail.duration = mediaMetaData.O00000o;
            playerStatus.play_song_detail.position = mediaMetaData.O0000Oo;
            Remote.Response.PlayingData playingData2 = playerStatus.play_song_detail;
            String str = mediaMetaData.O00000oO;
            ixe.O00000Oo(str, "mediaInfo.id");
            playingData2.audio_id = Long.parseLong(str);
            PlayerManager.getInstance().updatePlayerStatus(playerStatus);
            fg<MiPlayDevice> miplayDeviceLiveData = UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData();
            ? r3 = this.mMiplayDevice;
            if (r3 != null) {
                r3.O0000o00 = playerStatus.status == 1 ? 2 : 3;
                iuh iuh = iuh.f1631O000000o;
                bitmap = r3;
            }
            miplayDeviceLiveData.postValue(bitmap);
            UwbMicoPlayerManager.INSTANCE.getMiplayLiveData().postValue(new ContentInfo(playerStatus, song));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onVolumeChange(Map<Object, Object> map) {
        volumeDisplay(map);
    }

    public final void onVolumeAck(Map<Object, Object> map) {
        volumeDisplay(map);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    private final void volumeDisplay(Map<Object, Object> map) {
        if (map != null) {
            MiPlayDevice miPlayDevice = this.mMiplayDevice;
            Integer num = null;
            if (map.get(miPlayDevice == null ? null : miPlayDevice.f6039O000000o) != null) {
                MiPlayDevice mMiplayDevice2 = getMMiplayDevice();
                if (mMiplayDevice2 != null) {
                    MiPlayDevice mMiplayDevice3 = getMMiplayDevice();
                    Object obj = map.get(mMiplayDevice3 == null ? null : mMiplayDevice3.f6039O000000o);
                    if (obj != null) {
                        UwbMicoPlayerManagerKt.setVolume(mMiplayDevice2, ((Integer) obj).intValue());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
                UwbMicoPlayerManager.INSTANCE.getMiplayDeviceLiveData().postValue(getMMiplayDevice());
                LogType logType = LogType.LOG_UWB;
                MiPlayDevice mMiplayDevice4 = getMMiplayDevice();
                if (mMiplayDevice4 != null) {
                    num = Integer.valueOf(UwbMicoPlayerManagerKt.getVolume(mMiplayDevice4));
                }
                gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", ixe.O000000o("volumeDisplay: ", (Object) num));
            }
        }
    }

    public final void onChannelsAck(Map<Object, Object> map) {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", "onChannelsAck: ");
    }

    public final void onBufferStateChange(Map<Object, Object> map) {
        gsy.O000000o(LogType.LOG_UWB, "", 4, "zxtMiPlayClientCallBack", "onBufferStateChange: ");
    }

    public final void onMirrorModeAck(Map<Object, Object> map) {
        LogType logType = LogType.LOG_UWB;
        StringBuilder sb = new StringBuilder("onMirrorModeAck: ");
        Collection<Object> collection = null;
        sb.append(map == null ? null : map.keySet());
        sb.append(' ');
        if (map != null) {
            collection = map.values();
        }
        sb.append(collection);
        gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", sb.toString());
    }

    public final void onMirrorModeNotify(Map<Object, Object> map) {
        LogType logType = LogType.LOG_UWB;
        StringBuilder sb = new StringBuilder("onMirrorModeNotify: ");
        Collection<Object> collection = null;
        sb.append(map == null ? null : map.keySet());
        sb.append(' ');
        if (map != null) {
            collection = map.values();
        }
        sb.append(collection);
        gsy.O000000o(logType, "", 4, "zxtMiPlayClientCallBack", sb.toString());
    }
}
