package _m_j;

import _m_j.fat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;

public final class ffk {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16217O000000o;
    public String O00000Oo = null;
    public String O00000o = null;
    public String O00000o0 = null;
    public String O00000oO = null;
    public String O00000oo = null;
    protected final Handler O0000O0o = new Handler(Looper.getMainLooper()) {
        /* class _m_j.ffk.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 876) {
                ffk.this.O000000o();
            }
        }
    };
    public O000000o O0000OOo = null;
    private boolean O0000Oo = false;
    private byte[] O0000Oo0 = null;
    private List<Integer> O0000OoO = new ArrayList();

    public interface O000000o {
        void O000000o();
    }

    public ffk(String str) {
        this.O0000OoO.clear();
        this.O0000OoO.add(1);
        this.O0000OoO.add(2);
        this.O0000OoO.add(3);
        this.O0000OoO.add(4);
        this.O0000OoO.add(5);
        this.f16217O000000o = str;
    }

    public final void O000000o() {
        LogType logType = LogType.BLUETOOTH;
        gsy.O00000o0(logType, "MCU-bluetooth", "finish mcu process ,isFinish:" + this.O0000Oo);
        this.O0000O0o.removeMessages(876);
        if (!this.O0000Oo) {
            this.O0000Oo = true;
            O000000o o000000o = this.O0000OOo;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
    }

    public final void O000000o(final int i) {
        gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "start write mcu opcode:".concat(String.valueOf(i)));
        glw.O000000o().write(this.f16217O000000o, glb.f17954O000000o, glb.O0000oOO, new byte[]{(byte) i}, new BleWriteResponse() {
            /* class _m_j.ffk.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    LogType logType = LogType.BLUETOOTH;
                    gsy.O00000o0(logType, "MCU-bluetooth", "write mcu opcode:" + i + " success, waiting 2.5s");
                    ffk.this.O0000O0o.sendEmptyMessageDelayed(876, 2500);
                    return;
                }
                LogType logType2 = LogType.BLUETOOTH;
                gsy.O00000o0(logType2, "MCU-bluetooth", " write mcu opcode " + i + " fail");
                ffk.this.O000000o();
            }
        });
    }

    public final void O000000o(byte[] bArr) {
        ffl O000000o2 = ffl.O000000o(bArr);
        gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", String.format(" receive mcu event result code=%d, opcode=%d,params=%s", Integer.valueOf(O000000o2.O00000o0), Integer.valueOf(O000000o2.f16222O000000o), got.O00000o0(O000000o2.O00000o)));
        if (this.O0000O0o.hasMessages(876)) {
            this.O0000O0o.removeMessages(876);
            if (O000000o2.O00000o0 == 0) {
                int i = O000000o2.f16222O000000o;
                if (i == 0) {
                    this.O0000Oo0 = O000000o2.O00000o;
                    if (O00000Oo()) {
                        return;
                    }
                } else if (i == 1) {
                    String str = O000000o2.O00000Oo;
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "=========> receive mcu version=".concat(String.valueOf(str)));
                    if (!TextUtils.isEmpty(str)) {
                        fat fat = fat.O000000o.f16039O000000o;
                        MMKV.O000000o("smart.config.cache").O00000Oo("SMART.CONFIG.KEY.MCU.VERSION".concat(String.valueOf(this.f16217O000000o)), str);
                        this.O00000Oo = str;
                    }
                    if (O00000Oo()) {
                        return;
                    }
                } else if (i == 2) {
                    String str2 = O000000o2.O00000Oo;
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "=========> receive dev SN=".concat(String.valueOf(str2)));
                    if (!TextUtils.isEmpty(str2)) {
                        this.O00000o0 = str2;
                    }
                    if (O00000Oo()) {
                        return;
                    }
                } else if (i == 3) {
                    String str3 = O000000o2.O00000Oo;
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "=========> receive hardware=".concat(String.valueOf(str3)));
                    if (!TextUtils.isEmpty(str3)) {
                        this.O00000o = str3;
                    }
                    if (O00000Oo()) {
                        return;
                    }
                } else if (i == 4) {
                    String str4 = O000000o2.O00000Oo;
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "=========> receive latitude=".concat(String.valueOf(str4)));
                    if (!TextUtils.isEmpty(str4)) {
                        this.O00000oO = str4;
                    }
                    if (O00000Oo()) {
                        return;
                    }
                } else if (i == 5) {
                    String str5 = O000000o2.O00000Oo;
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "=========> receive longitude=".concat(String.valueOf(str5)));
                    if (!TextUtils.isEmpty(str5)) {
                        this.O00000oo = str5;
                    }
                    if (O00000Oo()) {
                        return;
                    }
                }
            }
            O000000o();
            return;
        }
        gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "just receive mcu event,but not my expect response");
    }

    private boolean O00000Oo() {
        byte[] bArr = this.O0000Oo0;
        if (!(bArr == null || bArr.length == 0)) {
            while (this.O0000OoO.size() > 0) {
                int intValue = this.O0000OoO.remove(0).intValue();
                if (O000000o(this.O0000Oo0, intValue)) {
                    O000000o(intValue);
                    return true;
                }
                gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", "device support opcode array not contain local opcode=".concat(String.valueOf(intValue)));
            }
        }
        return false;
    }

    private static boolean O000000o(byte[] bArr, int i) {
        if (bArr != null && bArr.length > 0) {
            for (byte b : bArr) {
                if (b == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
