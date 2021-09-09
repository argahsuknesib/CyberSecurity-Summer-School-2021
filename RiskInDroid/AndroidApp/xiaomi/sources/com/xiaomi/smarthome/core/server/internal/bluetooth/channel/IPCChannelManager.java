package com.xiaomi.smarthome.core.server.internal.bluetooth.channel;

import _m_j.fdy;
import _m_j.ffr;
import _m_j.glb;
import _m_j.glh;
import _m_j.glw;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IPCChannelManager extends ChannelManager {
    private static volatile IPCChannelManager O00000o;

    public final boolean O000000o() {
        return true;
    }

    private IPCChannelManager() {
    }

    public static IPCChannelManager O00000Oo() {
        if (O00000o == null) {
            synchronized (IPCChannelManager.class) {
                if (O00000o == null) {
                    O00000o = new IPCChannelManager();
                }
            }
        }
        return O00000o;
    }

    public final void O000000o(String str, byte[] bArr, final glh glh, boolean z) {
        byte[] O000000o2 = BLECipher.O000000o(ffr.O0000o0o(str), bArr);
        if (z) {
            glw.O000000o().write(str, glb.f17954O000000o, glb.O0000o00, O000000o2, new BleWriteResponse() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
                }
            });
            if (glh != null) {
                glh.O000000o(0);
                return;
            }
            return;
        }
        glw.O000000o().write(str, glb.f17954O000000o, glb.O0000o00, O000000o2, new BleWriteResponse() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    public final void O000000o(String str, List<byte[]> list, final glh glh) {
        byte[] O0000o0o = ffr.O0000o0o(str);
        ArrayList arrayList = new ArrayList();
        for (byte[] O000000o2 : list) {
            arrayList.add(BLECipher.O000000o(O0000o0o, O000000o2));
        }
        glw.O000000o().writeBatchNoRsp(str, glb.f17954O000000o, glb.O0000o00, arrayList, new BleWriteResponse() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    public static class NotifyReceiver extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        private ChannelManager f6811O000000o;

        public NotifyReceiver(ChannelManager channelManager) {
            this.f6811O000000o = channelManager;
        }

        public final void onReceive(Context context, Intent intent) {
            ChannelManager.O000000o O00000oO;
            if ("com.xiaomi.smarthome.bluetooth.character_changed".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("key_device_address");
                UUID uuid = (UUID) intent.getSerializableExtra("key_character_uuid");
                byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                if (glb.f17954O000000o.equals((UUID) intent.getSerializableExtra("key_service_uuid")) && glb.O0000o00.equals(uuid) && (O00000oO = this.f6811O000000o.O00000oO(stringExtra)) != null) {
                    O00000oO.O000000o(BLECipher.O000000o(ffr.O0000o0o(stringExtra), byteArrayExtra));
                }
            }
        }
    }

    public final synchronized void O000000o(String str, byte[] bArr, final IBleResponse iBleResponse) {
        ChannelManager.O000000o O00000oO = O00000oO(str);
        if (O00000oO != null) {
            O00000oO.O000000o(fdy.O000000o(bArr), 0, new glh() {
                /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager.AnonymousClass4 */

                public final void O000000o(int i) {
                    IBleResponse iBleResponse = iBleResponse;
                    if (iBleResponse != null) {
                        try {
                            iBleResponse.onResponse(i, null);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } else if (iBleResponse != null) {
            try {
                iBleResponse.onResponse(-1, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
