package _m_j;

import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.List;

public class few extends ChannelManager {
    private static volatile few O00000o;

    public final boolean O000000o() {
        return false;
    }

    private few() {
    }

    public static few O00000Oo() {
        if (O00000o == null) {
            synchronized (few.class) {
                if (O00000o == null) {
                    O00000o = new few();
                }
            }
        }
        return O00000o;
    }

    public final synchronized IBleChannelWriter O00000Oo(String str, IBleChannelReader iBleChannelReader) {
        return O00000o0(str, iBleChannelReader);
    }

    public final void O000000o(String str, byte[] bArr, final glh glh, boolean z) {
        glw.O000000o().writeNoRsp(str, glb.f17954O000000o, glb.O0000o0, bArr, new BleWriteResponse() {
            /* class _m_j.few.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    public final void O000000o(String str, List<byte[]> list, final glh glh) {
        glw.O000000o().writeBatchNoRsp(str, glb.f17954O000000o, glb.O0000o0, list, new BleWriteResponse() {
            /* class _m_j.few.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }
}
