package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.SpecChannelManager$1;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class fex extends ChannelManager {
    public static String O00000o = "SpecChannelManager";
    protected UUID O00000oO;
    private Map<String, IBleChannelWriter> O00000oo = new ConcurrentHashMap();

    public final boolean O000000o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void O00000o0() {
    }

    protected fex(UUID uuid) {
        this.O00000oO = uuid;
    }

    public final void O00000Oo() {
        gnl.O000000o(new O000000o(this), new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed"));
        O00000o0();
    }

    public final void O00000oo(String str) {
        if (O0000O0o(str) == null) {
            gnk.O000000o("%s,channel reader not ready", O00000o);
            return;
        }
        gnk.O000000o("%s,channel reader is ready", O00000o);
    }

    /* access modifiers changed from: protected */
    public final IBleChannelWriter O0000O0o(String str) {
        if (TextUtils.isEmpty(str)) {
            gnk.O000000o("%s,getWriter,but mac is empty,then return", O00000o);
            return null;
        }
        String lowerCase = str.toLowerCase();
        IBleChannelWriter iBleChannelWriter = this.O00000oo.get(lowerCase);
        if (iBleChannelWriter != null) {
            return iBleChannelWriter;
        }
        IBleChannelWriter O00000Oo = O00000Oo(str, new SpecChannelManager$1(this));
        this.O00000oo.put(lowerCase, O00000Oo);
        return O00000Oo;
    }

    static void O000000o(String str, byte[] bArr) {
        Intent intent = new Intent("action.miot.receive.specv2.ble.data");
        intent.putExtra("mac", str);
        intent.putExtra("value", bArr);
        glc.O0000O0o.sendBroadcast(intent);
    }

    public final void O000000o(String str, byte[] bArr, final glh glh, boolean z) {
        glw.O000000o().writeNoRsp(str, glb.f17954O000000o, this.O00000oO, bArr, new BleWriteResponse() {
            /* class _m_j.fex.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    public final void O000000o(String str, List<byte[]> list, final glh glh) {
        glw.O000000o().writeBatchNoRsp(str, glb.f17954O000000o, this.O00000oO, list, new BleWriteResponse() {
            /* class _m_j.fex.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    class O000000o extends BroadcastReceiver {
        private ChannelManager O00000Oo;

        public O000000o(ChannelManager channelManager) {
            this.O00000Oo = channelManager;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.xiaomi.smarthome.bluetooth.character_changed".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("key_device_address");
                UUID uuid = (UUID) intent.getSerializableExtra("key_character_uuid");
                byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                gnk.O000000o("%s ,ACTION_CHARACTER_CHANGED character %s", fex.O00000o, uuid.toString());
                if (glb.f17954O000000o.equals((UUID) intent.getSerializableExtra("key_service_uuid")) && fex.this.O00000oO.equals(uuid)) {
                    fex.this.O00000oo(stringExtra);
                    ChannelManager.O000000o O00000oO = this.O00000Oo.O00000oO(stringExtra);
                    if (O00000oO != null) {
                        O00000oO.O000000o(byteArrayExtra);
                    }
                }
            }
        }
    }
}
