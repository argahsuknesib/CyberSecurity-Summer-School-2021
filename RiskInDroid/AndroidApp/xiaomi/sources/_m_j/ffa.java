package _m_j;

import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.List;

public class ffa extends ChannelManager {
    private static volatile ffa O00000o;

    public final boolean O000000o() {
        return false;
    }

    private ffa() {
    }

    public static ffa O00000Oo() {
        if (O00000o == null) {
            synchronized (ffa.class) {
                if (O00000o == null) {
                    O00000o = new ffa();
                }
            }
        }
        return O00000o;
    }

    public final synchronized IBleChannelWriter O00000Oo(String str, IBleChannelReader iBleChannelReader) {
        return O00000o0(str, iBleChannelReader);
    }

    public static void O00000o0() {
        gnk.O00000o("StandardChannelManager init");
    }

    public final void O000000o(String str, byte[] bArr, final glh glh, boolean z) {
        glw.O000000o().writeNoRsp(str, glb.f17954O000000o, glb.O0000o, bArr, new BleWriteResponse() {
            /* class _m_j.ffa.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    public final void O000000o(String str, List<byte[]> list, final glh glh) {
        glw.O000000o().writeBatchNoRsp(str, glb.f17954O000000o, glb.O0000o, list, new BleWriteResponse() {
            /* class _m_j.ffa.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }
}
