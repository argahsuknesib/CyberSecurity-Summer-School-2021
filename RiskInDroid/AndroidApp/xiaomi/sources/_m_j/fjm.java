package _m_j;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.core.entity.device.MiioDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public final class fjm {
    public static void O000000o(final Context context, final fjk<List<Device>> fjk) {
        new Handler(Looper.getMainLooper()) {
            /* class _m_j.fjm.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            int f16479O000000o;

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        fjk fjk = fjk;
                        if (fjk != null) {
                            fjk.O000000o(ErrorCode.INVALID.getCode());
                        }
                    } else if (i != 3) {
                        return;
                    }
                    try {
                        InetAddress O000000o2 = fjm.O000000o(context);
                        if (O000000o2 != null) {
                            MiioLocalAPI.O000000o(O000000o2, new dxa() {
                                /* class _m_j.fjm.AnonymousClass1.AnonymousClass1 */

                                public final void O000000o(dxb dxb) {
                                    AnonymousClass1.this.obtainMessage(1, dxb).sendToTarget();
                                }
                            });
                        }
                    } catch (IOException unused) {
                        int i2 = this.f16479O000000o + 1;
                        this.f16479O000000o = i2;
                        if (i2 < 4) {
                            sendEmptyMessage(3);
                        }
                    }
                } else {
                    dxb dxb = (dxb) message.obj;
                    ArrayList arrayList = new ArrayList();
                    if (dxb.O00000Oo != null) {
                        for (dxf next : dxb.O00000Oo) {
                            MiioDevice miioDevice = new MiioDevice(String.valueOf(next.O00000o0), "");
                            miioDevice.setLocalIP(next.O00000oo);
                            miioDevice.setLocation(Device.Location.LOCAL);
                            miioDevice.setUnbind();
                            arrayList.add(miioDevice);
                        }
                    }
                    fjk.O000000o(arrayList);
                }
            }
        }.sendEmptyMessage(3);
    }

    public static InetAddress O000000o(Context context) throws IOException {
        DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
        if (dhcpInfo == null) {
            return null;
        }
        int i = (dhcpInfo.netmask ^ -1) | (dhcpInfo.ipAddress & dhcpInfo.netmask);
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return InetAddress.getByAddress(bArr);
    }
}
