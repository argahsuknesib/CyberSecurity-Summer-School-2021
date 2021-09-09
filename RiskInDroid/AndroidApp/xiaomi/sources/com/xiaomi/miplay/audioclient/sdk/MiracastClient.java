package com.xiaomi.miplay.audioclient.sdk;

import _m_j.gsy;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.miplay.audioclient.IMiPlayClient;
import com.xiaomi.miplay.audioclient.MiPlayDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class MiracastClient {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f6041O000000o = "MiracastClient";
    public Context O00000Oo;
    public List<MiPlayDevice> O00000o;
    public IMiPlayClient O00000o0;
    public MiPlayClientCallback O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public Handler O0000OOo = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.miplay.audioclient.sdk.MiracastClient.AnonymousClass1 */

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onInitSuccess();
                            return;
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 1:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onInitError();
                            return;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 2:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiPlayDevice miPlayDevice = (MiPlayDevice) message.obj;
                            if (MiracastClient.this.O00000o.contains(miPlayDevice)) {
                                int indexOf = MiracastClient.this.O00000o.indexOf(miPlayDevice);
                                MiracastClient.this.O00000o.remove(miPlayDevice);
                                MiracastClient.this.O00000o.add(indexOf, miPlayDevice);
                            } else {
                                MiracastClient.this.O00000o.add(miPlayDevice);
                            }
                            MiracastClient.this.O00000oO.onDeviceFound(miPlayDevice);
                            return;
                        } catch (RemoteException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 3:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiPlayDevice miPlayDevice2 = (MiPlayDevice) message.obj;
                            if (MiracastClient.this.O00000o.contains(miPlayDevice2)) {
                                int indexOf2 = MiracastClient.this.O00000o.indexOf(miPlayDevice2);
                                MiracastClient.this.O00000o.remove(miPlayDevice2);
                                MiracastClient.this.O00000o.add(indexOf2, miPlayDevice2);
                            } else {
                                MiracastClient.this.O00000o.add(miPlayDevice2);
                            }
                            MiracastClient.this.O00000oO.onDeviceUpdate(miPlayDevice2);
                            return;
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 4:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onDeviceLost((String) message.obj);
                            return;
                        } catch (RemoteException e5) {
                            e5.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onPlayStateAck((Map) message.obj);
                            return;
                        } catch (RemoteException e6) {
                            e6.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 6:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onPlayStateChange((Map) message.obj);
                            return;
                        } catch (RemoteException e7) {
                            e7.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 7:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onPositionAck((Map) message.obj);
                            return;
                        } catch (RemoteException e8) {
                            e8.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (MiracastClient.this.O00000oO != null) {
                        Object[] objArr = (Object[]) message.obj;
                        try {
                            MiracastClient.this.O00000oO.onDeviceConnectStateChange((String) objArr[0], ((Integer) objArr[1]).intValue());
                            return;
                        } catch (RemoteException e9) {
                            e9.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onMediaInfoAck((Map) message.obj);
                            return;
                        } catch (RemoteException e10) {
                            e10.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 10:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onMediaInfoChange((Map) message.obj);
                            return;
                        } catch (RemoteException e11) {
                            e11.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 11:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onChannelsAck((Map) message.obj);
                            return;
                        } catch (RemoteException e12) {
                            e12.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onVolumeAck((Map) message.obj);
                            return;
                        } catch (RemoteException e13) {
                            e13.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 13:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onVolumeChange((Map) message.obj);
                            return;
                        } catch (RemoteException e14) {
                            e14.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 14:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onBufferStateChange((Map) message.obj);
                            return;
                        } catch (RemoteException e15) {
                            e15.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onMirrorModeAck((Map) message.obj);
                            return;
                        } catch (RemoteException e16) {
                            e16.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 16:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onMirrorModeNotify((Map) message.obj);
                            return;
                        } catch (RemoteException e17) {
                            e17.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 17:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onBtFrequencyACK((Map) message.obj);
                            return;
                        } catch (RemoteException e18) {
                            e18.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 18:
                    if (MiracastClient.this.O00000oO != null) {
                        try {
                            MiracastClient.this.O00000oO.onDisconnectNotify((Map) message.obj);
                            return;
                        } catch (RemoteException e19) {
                            e19.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    public ServiceConnection O0000Oo = new ServiceConnection() {
        /* class com.xiaomi.miplay.audioclient.sdk.MiracastClient.AnonymousClass3 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MiracastClient.this.O00000o0 = IMiPlayClient.Stub.asInterface(iBinder);
            gsy.O000000o(4, MiracastClient.f6041O000000o, "onServiceConnected: ");
            if (MiracastClient.this.O00000o0 != null) {
                try {
                    MiracastClient.this.O00000o0.init(MiracastClient.this.O00000oo, MiracastClient.this.O0000Oo0, MiracastClient.this.O0000O0o);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            gsy.O000000o(4, MiracastClient.f6041O000000o, "onServiceDisconnected: ");
        }
    };
    public MiPlayClientCallback O0000Oo0 = new MiPlayClientCallback() {
        /* class com.xiaomi.miplay.audioclient.sdk.MiracastClient.AnonymousClass2 */

        public void onInitSuccess() {
            MiracastClient.this.O0000OOo.obtainMessage(0).sendToTarget();
        }

        public void onInitError() throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(1).sendToTarget();
        }

        public void onDeviceFound(MiPlayDevice miPlayDevice) {
            gsy.O000000o(3, MiracastClient.f6041O000000o, "onDeviceFound: ".concat(String.valueOf(miPlayDevice)));
            MiracastClient.this.O0000OOo.obtainMessage(2, miPlayDevice).sendToTarget();
        }

        public void onDeviceUpdate(MiPlayDevice miPlayDevice) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(3, miPlayDevice).sendToTarget();
        }

        public void onDeviceLost(String str) {
            MiracastClient.this.O0000OOo.obtainMessage(4, str).sendToTarget();
        }

        public void onPositionAck(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(7, map).sendToTarget();
        }

        public void onDeviceConnectStateChange(String str, int i) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(8, new Object[]{str, Integer.valueOf(i)}).sendToTarget();
        }

        public void onPlayStateChange(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(6, map).sendToTarget();
        }

        public void onPlayStateAck(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(5, map).sendToTarget();
        }

        public void onMediaInfoAck(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(9, map).sendToTarget();
        }

        public void onMediaInfoChange(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(10, map).sendToTarget();
        }

        public void onChannelsAck(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(11, map).sendToTarget();
        }

        public void onVolumeChange(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(13, map).sendToTarget();
        }

        public void onVolumeAck(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(12, map).sendToTarget();
        }

        public void onBufferStateChange(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(14, map).sendToTarget();
        }

        public void onMirrorModeAck(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(15, map).sendToTarget();
        }

        public void onMirrorModeNotify(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(16, map).sendToTarget();
        }

        public void onBtFrequencyACK(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(17, map).sendToTarget();
        }

        public void onDisconnectNotify(Map map) throws RemoteException {
            MiracastClient.this.O0000OOo.obtainMessage(18, map).sendToTarget();
        }
    };

    public MiracastClient(Context context) {
        this.O00000Oo = context;
        this.O00000oo = this.O00000Oo.getPackageName();
        this.O00000o = new ArrayList();
    }

    public final boolean O000000o(MiPlayClientCallback miPlayClientCallback, String str) {
        this.O00000oO = miPlayClientCallback;
        this.O0000O0o = str;
        gsy.O000000o(4, f6041O000000o, "initAsync: ");
        Intent intent = new Intent();
        intent.setPackage("com.milink.service");
        intent.setAction("com.xiaomi.miplay.action.MIPLAY_AUDIO_CLIENT_SERVICE");
        return this.O00000Oo.bindService(intent, this.O0000Oo, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
    }

    public final int O000000o(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.stop(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O00000Oo(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.onPause(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O00000o0(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.onResume(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O000000o(String[] strArr, long j) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.onSeek(strArr, j);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O000000o(String[] strArr, int i) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.setVolume(strArr, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O00000o(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.getVolume(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O00000oO(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.getPosition(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O00000oo(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null || strArr == null) {
            return -1;
        }
        try {
            return iMiPlayClient.getMediaInfo(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final boolean O000000o() {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return false;
        }
        try {
            return iMiPlayClient.getCollectAudio();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final int O0000O0o(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.onNext(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O0000OOo(String[] strArr) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.onPrev(strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final int O000000o(String[] strArr, String str, int i) {
        IMiPlayClient iMiPlayClient = this.O00000o0;
        if (iMiPlayClient == null) {
            return -1;
        }
        try {
            return iMiPlayClient.play(strArr, str, 3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
