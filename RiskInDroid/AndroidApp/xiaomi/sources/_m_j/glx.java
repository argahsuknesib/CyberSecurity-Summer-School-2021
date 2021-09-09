package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectMaster;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadRssiResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleRequestMtuResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse2;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

public final class glx implements gmu, Handler.Callback, IBleConnectMaster {

    /* renamed from: O000000o  reason: collision with root package name */
    public gpq f17999O000000o;
    public Handler O00000Oo;
    public glv O00000o;
    String O00000o0;
    private Handler O00000oO = new Handler(Looper.getMainLooper());
    private long O00000oo;

    private glx(String str) {
        this.O00000o0 = str;
    }

    static IBleConnectMaster O000000o(String str) {
        O000000o();
        glx glx = new glx(str);
        return (IBleConnectMaster) gmw.O000000o(glx, IBleConnectMaster.class, glx, false);
    }

    public static void O000000o() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("");
        }
    }

    public final void connect(BleConnectOptions bleConnectOptions, BleConnectResponse bleConnectResponse) {
        this.O00000o.O000000o(new gme(bleConnectOptions, gma.O000000o(bleConnectResponse)));
    }

    public final void disconnect() {
        glv glv = this.O00000o;
        glv.checkRuntime();
        gnk.O00000oO(String.format("start process disconnect", new Object[0]));
        if (glv.O00000Oo != null) {
            glv.O00000Oo.cancel();
            glv.O00000Oo = null;
        }
        for (gmj cancel : glv.f17997O000000o) {
            cancel.cancel();
        }
        glv.f17997O000000o.clear();
        glv.O00000o0.closeGatt();
    }

    public final void read(UUID uuid, UUID uuid2, BleReadResponse bleReadResponse) {
        this.O00000o.O000000o(new gmh(uuid, uuid2, gma.O000000o(bleReadResponse)));
    }

    public final void write(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        if (bleWriteResponse instanceof BleWriteResponse2) {
            writeNoRsp(uuid, uuid2, bArr, bleWriteResponse);
        } else {
            this.O00000o.O000000o(new gmp(uuid, uuid2, bArr, gma.O000000o(bleWriteResponse)));
        }
    }

    public final void writeNoRsp(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        this.O00000o.O000000o(new gmo(uuid, uuid2, bArr, gma.O000000o(bleWriteResponse)));
    }

    public final void notify(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse) {
        this.O00000o.O000000o(new gmg(uuid, uuid2, gma.O000000o(bleNotifyResponse)));
    }

    public final void unnotify(UUID uuid, UUID uuid2) {
        this.O00000o.O000000o(new gmm(uuid, uuid2));
    }

    public final void indication(UUID uuid, UUID uuid2, BleNotifyResponse bleNotifyResponse) {
        this.O00000o.O000000o(new gmf(uuid, uuid2, gma.O000000o(bleNotifyResponse)));
    }

    public final void unindication(UUID uuid, UUID uuid2) {
        this.O00000o.O000000o(new gml(uuid, uuid2));
    }

    public final void readRemoteRssi(BleReadRssiResponse bleReadRssiResponse) {
        this.O00000o.O000000o(new gmi(gma.O000000o(bleReadRssiResponse)));
    }

    public final void refreshGattCache() {
        glv glv = this.O00000o;
        glv.checkRuntime();
        glv.O00000o0.refreshDeviceCache();
    }

    public final void requestConnectionPriority(int i) {
        this.O00000o.O00000o0.requestConnectionPriority(i);
    }

    public final void requestMtu(int i, BleRequestMtuResponse bleRequestMtuResponse) {
        this.O00000o.O000000o(new gmk(i, gma.O000000o(bleRequestMtuResponse)));
    }

    public final void writeNoRspFast(UUID uuid, UUID uuid2, byte[] bArr, BleWriteResponse bleWriteResponse) {
        this.O00000o.O000000o(new gmn(uuid, uuid2, bArr, gma.O000000o(bleWriteResponse)));
    }

    public final void writeBatchNoRsp(String str, UUID uuid, UUID uuid2, List<byte[]> list, BleWriteResponse bleWriteResponse) {
        this.O00000o.O000000o(new gmd(uuid, uuid2, list, gma.O000000o(bleWriteResponse)));
    }

    public final void isCharacterExist(UUID uuid, UUID uuid2, BleResponse<Void> bleResponse) {
        this.O00000o.O00000o0.isCharacterExist(uuid, uuid2, bleResponse);
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        O000000o();
        final glx glx = (glx) obj;
        glx.O00000oo = System.currentTimeMillis();
        gly.O000000o().reportAction(glx.O00000o0);
        O000000o();
        if (glx.O00000Oo == null) {
            O000000o();
            if (glx.f17999O000000o == null) {
                glx.f17999O000000o = new gpq(String.format("BleConnectMaster(%s)", glx.O00000o0));
                glx.f17999O000000o.start();
                glx.O00000Oo = new Handler(glx.f17999O000000o.getLooper(), glx);
            }
        }
        final Method method2 = method;
        final Object obj2 = obj;
        final Object[] objArr2 = objArr;
        glx.O00000Oo.post(new Runnable() {
            /* class _m_j.glx.AnonymousClass3 */

            public final void run() {
                try {
                    glx glx = glx;
                    if (glx.O00000o == null) {
                        glx.O00000o = glv.O000000o(glx.O00000o0);
                    }
                    method2.invoke(obj2, objArr2);
                } catch (Exception e) {
                    gnk.O00000oO(gnk.O00000Oo(e));
                }
            }
        });
        return true;
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 256) {
            return true;
        }
        if (System.currentTimeMillis() - this.O00000oo <= 120000 || gnl.O00000o0(this.O00000o0)) {
            this.O00000oO.post(new Runnable() {
                /* class _m_j.glx.AnonymousClass2 */

                public final void run() {
                    if (glx.this.O00000Oo != null) {
                        glx.this.O00000Oo.sendEmptyMessageDelayed(256, 15000);
                    }
                }
            });
            return true;
        }
        this.O00000oO.post(new Runnable() {
            /* class _m_j.glx.AnonymousClass1 */

            public final void run() {
                glx.O000000o();
                if (glx.this.f17999O000000o != null) {
                    glx.this.f17999O000000o.quit();
                    glx glx = glx.this;
                    glx.f17999O000000o = null;
                    glx.O00000Oo = null;
                    glx.O00000o = null;
                }
            }
        });
        return true;
    }
}
