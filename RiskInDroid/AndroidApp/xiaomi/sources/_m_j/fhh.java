package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class fhh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Map<String, O00000Oo> f16351O000000o = new ConcurrentHashMap();
    public static ScheduledExecutorService O00000Oo = Executors.newScheduledThreadPool(3);
    private static UUID O00000o = O000000o(4097);
    private static UUID O00000o0 = O000000o(4096);
    private static UUID O00000oO = O000000o(4098);
    private static UUID O00000oo = O000000o(4099);
    private static byte[] O0000O0o = {0};
    private static byte[] O0000OOo = {1};
    private static BroadcastReceiver O0000Oo = null;
    private static byte[] O0000Oo0 = {2};

    private static UUID O000000o(int i) {
        return UUID.fromString(String.format("0000%04x-0065-6C62-2E74-6F696D2E696D", Integer.valueOf(i)));
    }

    public static void O000000o() {
        if (O0000Oo == null) {
            O0000Oo = new O000000o((byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
            intentFilter.addAction("com.xiaomi.smarthome.bluetooth.character_changed");
            gnl.O000000o(O0000Oo, intentFilter);
        }
    }

    public static synchronized void O000000o(String str, int i, BleReadResponse bleReadResponse) {
        synchronized (fhh.class) {
            O000000o();
            if (i == 0) {
                O000000o(str, O0000O0o, bleReadResponse);
            } else if (i == 1) {
                O000000o(str, O0000OOo, bleReadResponse);
            } else if (i != 2) {
                fte.O00000Oo(String.format("operator(%d) is invalid", Integer.valueOf(i)));
                bleReadResponse.onResponse(-1, null);
            } else {
                O000000o(str, O0000Oo0, bleReadResponse);
            }
        }
    }

    private static void O000000o(final String str, final byte[] bArr, final BleReadResponse bleReadResponse) {
        if (f16351O000000o.get(str) != null) {
            fte.O00000Oo("有上一次开锁操作正在进行，等待操作完成...");
            if (bleReadResponse != null) {
                bleReadResponse.onResponse(-13, null);
                return;
            }
            return;
        }
        glw.O000000o().notify(str, O00000o0, O00000oo, new BleNotifyResponse() {
            /* class _m_j.fhh.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ void onResponse(int i, Object obj) {
            }
        });
        glw.O000000o().notify(str, O00000o0, O00000oO, new BleNotifyResponse() {
            /* class _m_j.fhh.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("sendOperator notify code = ".concat(String.valueOf(i)));
                if (i == 0) {
                    fhe.O000000o(str, bArr, new BleReadResponse() {
                        /* class _m_j.fhh.AnonymousClass2.AnonymousClass1 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            byte[] bArr = (byte[]) obj;
                            if (i == 0) {
                                fte.O00000Oo("operator encrypt success  code=".concat(String.valueOf(i)));
                                O00000Oo o00000Oo = new O00000Oo((byte) 0);
                                o00000Oo.f16359O000000o = bleReadResponse;
                                fhh.f16351O000000o.put(str, o00000Oo);
                                o00000Oo.O00000Oo = fhh.O00000Oo.schedule(new O00000o0(str), 12, TimeUnit.SECONDS);
                                fhh.O000000o(str, bArr);
                                return;
                            }
                            fte.O00000Oo("operator encrypt failed  code=" + i + "  mac=" + str + "  operator=" + bArr);
                            if (bleReadResponse != null) {
                                bleReadResponse.onResponse(-1, null);
                            }
                        }
                    });
                } else if (bleReadResponse != null) {
                    fte.O00000Oo("Code.REQUEST_NOTIFY_FAILED code = ".concat(String.valueOf(i)));
                    bleReadResponse.onResponse(-27, null);
                }
            }
        });
    }

    public static void O000000o(final String str, byte[] bArr) {
        glw.O000000o().write(str, O00000o0, O00000o, bArr, new BleWriteResponse() {
            /* class _m_j.fhh.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i != 0) {
                    fhh.O000000o(str, -1, (byte[]) null);
                }
            }
        });
    }

    static class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.hasExtra("key_device_address")) {
                String stringExtra = intent.getStringExtra("key_device_address");
                String action = intent.getAction();
                if (TextUtils.equals(action, "com.xiaomi.smarthome.bluetooth.connect_status_changed")) {
                    if (intent.getIntExtra("key_connect_status", 0) == 32) {
                        fhh.O000000o(stringExtra, -1, (byte[]) null);
                    }
                } else if (TextUtils.equals(action, "com.xiaomi.smarthome.bluetooth.character_changed")) {
                    fhh.O000000o(stringExtra, intent);
                }
            }
        }
    }

    public static void O000000o(final String str, Intent intent) {
        UUID uuid = (UUID) intent.getSerializableExtra("key_character_uuid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
        if (!O00000o0.equals((UUID) intent.getSerializableExtra("key_service_uuid"))) {
            return;
        }
        if (O00000oO.equals(uuid)) {
            fhe.O00000Oo(str, byteArrayExtra, new BleReadResponse() {
                /* class _m_j.fhh.AnonymousClass4 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    byte[] bArr = (byte[]) obj;
                    fte.O00000Oo(String.format("decrypt lock state: code = %d, data = %s", Integer.valueOf(i), got.O00000o0(bArr)));
                    if (i == 0) {
                        fhh.O000000o(str, 0, bArr);
                        return;
                    }
                    fte.O00000Oo("operator decrypt failed");
                    fhh.O000000o(str, -1, (byte[]) null);
                }
            });
        } else if (O00000oo.equals(uuid)) {
            fhe.O00000Oo(str, byteArrayExtra, new BleReadResponse() {
                /* class _m_j.fhh.AnonymousClass5 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    byte[] bArr = (byte[]) obj;
                    fte.O00000Oo(String.format("decrypt lock log: code = %d, data = %s", Integer.valueOf(i), got.O00000o0(bArr)));
                    if (i == 0) {
                        fhh.O00000Oo(str, bArr);
                    }
                }
            });
        }
    }

    public static void O00000Oo(final String str, final byte[] bArr) {
        final AnonymousClass6 r0 = new BleResponse<String>() {
            /* class _m_j.fhh.AnonymousClass6 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                if (i != 0 || TextUtils.isEmpty(str)) {
                    fte.O00000Oo("reportLockEvent, get ble firmware version failed");
                    return;
                }
                fte.O00000Oo("reportLockEvent, get ble firmware version = ".concat(String.valueOf(str)));
                String O00000oo = ffr.O00000oo(str);
                String[] split = str.split("[._]");
                if (split.length >= 3) {
                    try {
                        int intValue = Integer.valueOf(split[0]).intValue();
                        int intValue2 = Integer.valueOf(split[1]).intValue();
                        int intValue3 = Integer.valueOf(split[2]).intValue();
                        if (intValue < 2) {
                            fhh.O000000o(O00000oo, "5", got.O00000o0(bArr));
                        } else if (intValue != 2) {
                            fhh.O00000o0(O00000oo, bArr);
                        } else if (intValue2 <= 0) {
                            fhh.O000000o(O00000oo, "5", got.O00000o0(bArr));
                        } else if (intValue2 == 1) {
                            if (intValue3 < 7) {
                                fhh.O000000o(O00000oo, "5", got.O00000o0(bArr));
                            } else if (intValue3 < 11) {
                                fhh.O000000o(O00000oo, "11", got.O00000o0(bArr));
                            } else {
                                fhh.O00000o0(O00000oo, bArr);
                            }
                        } else if (intValue2 != 2) {
                            fhh.O00000o0(O00000oo, bArr);
                        } else if (intValue3 <= 0) {
                            fhh.O000000o(O00000oo, "5", got.O00000o0(bArr));
                        } else if (intValue3 < 5) {
                            fhh.O000000o(O00000oo, "11", got.O00000o0(bArr));
                        } else {
                            fhh.O00000o0(O00000oo, bArr);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    fte.O00000Oo("reportLockEvent, firmware version illegal format");
                }
            }
        };
        glw.O000000o().read(str, glb.f17954O000000o, glb.O00000oO, new BleReadResponse() {
            /* class _m_j.fhh.AnonymousClass8 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                byte[] bArr = (byte[]) obj;
                if (i == 0 && !got.O00000o(bArr)) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < bArr.length && bArr[i2] != 0) {
                        i3++;
                        i2++;
                    }
                    if (i3 != 0) {
                        byte[] bArr2 = new byte[i3];
                        for (int i4 = 0; i4 < i3; i4++) {
                            bArr2[i4] = bArr[i4];
                        }
                        r0.onResponse(0, new String(bArr2));
                        return;
                    }
                }
                r0.onResponse(-1, "");
            }
        });
    }

    public static void O00000o0(String str, byte[] bArr) {
        if (bArr.length > 2) {
            byte[] bArr2 = new byte[2];
            byte[] bArr3 = new byte[(bArr.length - 2)];
            System.arraycopy(bArr, 0, bArr2, 0, 2);
            System.arraycopy(bArr, 2, bArr3, 0, bArr3.length);
            O000000o(str, String.valueOf((int) ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getShort()), got.O00000o0(bArr3));
            return;
        }
        fte.O00000Oo("parseLockEvent data is wrong");
    }

    public static void O000000o(String str, String str2, String str3) {
        fgo.O00000o0(str, "event", str2, str3, new feo<String, fes>() {
            /* class _m_j.fhh.AnonymousClass7 */

            public final void O000000o(fes fes) {
            }

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
            }
        });
    }

    public static void O000000o(String str, int i, byte[] bArr) {
        O00000Oo o00000Oo = f16351O000000o.get(str);
        if (o00000Oo != null) {
            if (o00000Oo.O00000Oo != null) {
                o00000Oo.O00000Oo.cancel(true);
                o00000Oo.O00000Oo = null;
            }
            if (o00000Oo.f16359O000000o != null) {
                o00000Oo.f16359O000000o.onResponse(i, bArr);
                o00000Oo.f16359O000000o = null;
            }
            f16351O000000o.remove(str);
        }
    }

    static class O00000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        private String f16360O000000o;

        public O00000o0(String str) {
            this.f16360O000000o = str;
        }

        public final void run() {
            O00000Oo o00000Oo = fhh.f16351O000000o.get(this.f16360O000000o);
            if (o00000Oo != null) {
                o00000Oo.O00000Oo = null;
                fte.O00000Oo("BleSecurityChipOperate timeout, mac = " + fte.O000000o(this.f16360O000000o));
                glw.O000000o().disconnect(this.f16360O000000o);
                fhh.O000000o(this.f16360O000000o, -7, (byte[]) null);
            }
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        BleReadResponse f16359O000000o;
        ScheduledFuture O00000Oo;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }
}
