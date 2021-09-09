package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.util.List;

public class fev extends ChannelManager {
    private static volatile fev O00000o;

    public final boolean O000000o() {
        return false;
    }

    private fev() {
    }

    public static fev O00000Oo() {
        if (O00000o == null) {
            synchronized (fev.class) {
                if (O00000o == null) {
                    O00000o = new fev();
                }
            }
        }
        return O00000o;
    }

    public final void O000000o(String str, byte[] bArr, glh glh, boolean z) {
        final glh glh2 = glh;
        if (z) {
            glw.O000000o().writeNoRspFast(str, glb.f17954O000000o, glb.O0000o0o, bArr, new BleWriteResponse() {
                /* class _m_j.fev.AnonymousClass1 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    gnk.O00000o("writeble onResponse");
                    glh glh = glh2;
                    if (glh != null) {
                        glh.O000000o(i);
                    }
                }
            });
            return;
        }
        glw.O000000o().writeNoRsp(str, glb.f17954O000000o, glb.O0000o0o, bArr, new BleWriteResponse() {
            /* class _m_j.fev.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                glh glh = glh2;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }

    public final void O000000o(String str, List<byte[]> list, final glh glh) {
        glw.O000000o().writeBatchNoRsp(str, glb.f17954O000000o, glb.O0000o0o, list, new BleWriteResponse() {
            /* class _m_j.fev.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                gnk.O00000o("writeBatchBleData onResponse");
                glh glh = glh;
                if (glh != null) {
                    glh.O000000o(i);
                }
            }
        });
    }
}
