package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.mesh.MeshDfuManager$13;
import com.xiaomi.smarthome.core.server.internal.bluetooth.mesh.MeshDfuManager$2;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ffq {
    private static volatile ffq O0000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, O0000OOo> f16225O000000o = new HashMap();
    public int O00000Oo = 30;
    public boolean O00000o = false;
    public boolean O00000o0 = false;
    public boolean O00000oO = false;
    public String O00000oo;
    public String O0000O0o;
    public IBleMeshUpgradeResponse O0000OOo;
    public O00000o O0000Oo;
    public O000000o O0000Oo0;
    public O0000O0o O0000OoO;
    public O00000Oo O0000Ooo;
    public String O0000o0;
    public int O0000o00 = 1;
    public IBleChannelWriter O0000o0O;
    public IBleChannelReader O0000o0o = new MeshDfuManager$2(this);
    private BroadcastReceiver O0000oO = new BroadcastReceiver() {
        /* class _m_j.ffq.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            O0000OOo o0000OOo;
            String str;
            String action = intent.getAction();
            if (TextUtils.equals(action, "com.xiaomi.smarthome.bluetooth.connect_status_changed")) {
                String stringExtra = intent.getStringExtra("key_device_address");
                if (ffq.this.O00000oo != null && ffq.this.O00000oo.equalsIgnoreCase(stringExtra) && intent.getIntExtra("key_connect_status", 5) == 32 && ffq.this.O0000OOo != null) {
                    if (ffq.this.O00000o0) {
                        ffq.this.O000000o(-101, "BLE DISCONNECT");
                    } else {
                        ffq.this.O000000o(-105, " BLE disconnect");
                    }
                }
            } else if (TextUtils.equals(action, "com.xiaomi.smarthome.bluetooth.character_changed")) {
                String stringExtra2 = intent.getStringExtra("key_device_address");
                if (ffq.this.O00000oo != null && ffq.this.O00000oo.equalsIgnoreCase(stringExtra2)) {
                    UUID uuid = (UUID) intent.getSerializableExtra("key_service_uuid");
                    UUID uuid2 = (UUID) intent.getSerializableExtra("key_character_uuid");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                    if (uuid != null && uuid2 != null) {
                        ffq ffq = ffq.this;
                        if (!glb.f17954O000000o.equals(uuid)) {
                            return;
                        }
                        if (glb.O0000o0O.equals(uuid2)) {
                            if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                                byte b = byteArrayExtra[0];
                                if (b == 1) {
                                    ffo ffo = new ffo(byteArrayExtra);
                                    if (ffq.O0000Oo == null || ffq.O0000Oo.f16239O000000o != ffo.O00000Oo) {
                                        fte.O00000Oo(String.format("Ble-OTA:MeshDfuManager processCommandEvent (%s) error, can't find callback", ffo.toString()));
                                        return;
                                    }
                                    ffq.O0000Oo0.removeMessages(12289);
                                    if (ffq.O0000Oo.O00000Oo == null) {
                                        return;
                                    }
                                    if (ffo.O00000o0 == 0) {
                                        ffq.O0000Oo.O00000Oo.O000000o(ffo.O00000o);
                                        return;
                                    }
                                    ffq.O0000Oo.O00000Oo.O000000o(ffq.O00000o(ffo.O00000o0), null);
                                    fte.O00000Oo(String.format("Ble-OTA:MeshDfuManager processCommandEvent (%s) error, status failed", ffo.toString()));
                                } else if (b == 2) {
                                    ffp ffp = new ffp(byteArrayExtra);
                                    if (ffq.O0000OoO == null) {
                                        fte.O00000Oo(String.format("Ble-OTA:MeshDfuManager processTransferEvent (%s) error, can't find callback", ffp.toString()));
                                    } else if (ffp.O00000Oo == 0) {
                                        ffq.O0000OoO.O000000o();
                                    } else {
                                        ffq.O0000OoO.O000000o(ffq.O00000o(ffp.O00000Oo), null);
                                        fte.O00000Oo(String.format("Ble-OTA:MeshDfuManager processTransferEvent (%s) error, status failed", ffp.toString()));
                                    }
                                }
                            }
                        } else if (glb.O0000o0o.equals(uuid2)) {
                            ChannelManager.O000000o O00000oO = fev.O00000Oo().O00000oO(ffq.O00000oo);
                            if (O00000oO != null) {
                                O00000oO.O000000o(byteArrayExtra);
                            }
                        } else if (glb.O0000oOO.equals(uuid2)) {
                            ffl O000000o2 = ffl.O000000o(byteArrayExtra);
                            if (O000000o2.f16222O000000o == 1) {
                                LogType logType = LogType.BLUETOOTH;
                                gsy.O00000o0(logType, "Ble-OTA:MeshDfuManager", "receive mcu version notify, result code=" + O000000o2.O00000o0 + ",value=" + O000000o2.O00000Oo);
                                if (O000000o2.O00000o0 == 0 && (o0000OOo = ffq.f16225O000000o.get(ffq.O00000oo)) != null && o0000OOo.O0000Oo0) {
                                    String str2 = O000000o2.O00000Oo;
                                    String str3 = o0000OOo.O00000o0;
                                    if (flo.O000000o(str2, str3) > 0) {
                                        Pair<Boolean, String> O00000o = fec.O00000o0().O00000o(ffq.O00000oo);
                                        if (((Boolean) O00000o.first).booleanValue()) {
                                            str = (String) O00000o.second;
                                        } else {
                                            str = ffr.O00000oo(ffq.O00000oo);
                                        }
                                        fgo.O000000o(new fcp(str, str2, null), (feo<Void, fes>) null);
                                        gnk.O00000o("Ble-OTA:MeshDfuManager：read mcu version success, and upgrade mcu version ,success,old version=" + str3 + ",new version =" + str2);
                                        ffq.O0000Oo0.removeMessages(12293);
                                        ffq.O0000Oo0.removeMessages(12292);
                                        o0000OOo.O0000Oo0 = false;
                                        o0000OOo.O00000o0 = str2;
                                        ffq.O00000o = false;
                                        ffq.O0000Oo0();
                                        return;
                                    }
                                    gnk.O00000o("Ble-OTA:MeshDfuManager：read mcu version success, but still is old version= ".concat(String.valueOf(str2)));
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private HandlerThread O0000oO0 = new HandlerThread("MeshDfuManager-Thread");

    interface O00000o0 {
        void O000000o(int i, String str);

        void O000000o(byte[] bArr);
    }

    public interface O0000O0o {
        void O000000o();

        void O000000o(int i, String str);
    }

    static int O00000o(int i) {
        switch (i) {
            case 1:
                return -501;
            case 2:
                return -502;
            case 3:
                return -503;
            case 4:
                return -504;
            case 5:
                return -505;
            case 6:
                return -506;
            case 7:
                return -507;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return -508;
            default:
                return -599;
        }
    }

    public static int O00000oO(int i) {
        if (i != -3) {
            return i != -2 ? -499 : -412;
        }
        return -413;
    }

    private ffq() {
        this.O0000oO0.start();
        this.O0000Oo0 = new O000000o(this.O0000oO0.getLooper());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.smarthome.bluetooth.character_changed");
        intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
        gnl.O000000o(this.O0000oO, intentFilter);
    }

    public static ffq O000000o() {
        if (O0000o == null) {
            synchronized (ffq.class) {
                if (O0000o == null) {
                    O0000o = new ffq();
                }
            }
        }
        return O0000o;
    }

    public final boolean O00000Oo() {
        return this.O00000o0 || this.O00000o;
    }

    public class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16240O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        boolean O00000oO = false;
        boolean O00000oo = false;
        int O0000O0o = 0;
        int O0000OOo = -1;
        public boolean O0000Oo = false;
        public boolean O0000Oo0 = false;

        public O0000OOo() {
        }
    }

    public static void O000000o(IBleMeshUpgradeResponse iBleMeshUpgradeResponse, int i, String str) {
        if (iBleMeshUpgradeResponse != null) {
            try {
                iBleMeshUpgradeResponse.onResponse(i, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean O000000o(String str) {
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    public final void O00000o0() {
        final O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        if (o0000OOo == null || !o0000OOo.O00000oO) {
            glw.O000000o().notify(this.O00000oo, glb.f17954O000000o, glb.O0000o0O, new BleNotifyResponse() {
                /* class _m_j.ffq.AnonymousClass5 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i == 0) {
                        O0000OOo o0000OOo = o0000OOo;
                        if (o0000OOo != null) {
                            o0000OOo.O00000oO = true;
                        }
                        ffq.this.O00000o();
                        return;
                    }
                    ffq.this.O000000o(-107, "open command notify failed");
                }
            });
        } else {
            O00000o();
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        final O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        if (o0000OOo == null || !o0000OOo.O00000oo) {
            glw.O000000o().notify(this.O00000oo, glb.f17954O000000o, glb.O0000o0o, new BleNotifyResponse() {
                /* class _m_j.ffq.AnonymousClass6 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i != 0) {
                        ffq.this.O000000o(-108, "open data notify failed");
                    } else if (!o0000OOo.O0000Oo || ffq.O000000o("1.4.0", ffq.this.O0000o0) <= 0) {
                        ffq.this.O00000oO();
                    } else {
                        gnk.O000000o("mesh device skip protocol version,current version is %s", ffq.this.O0000o0);
                        ffq ffq = ffq.this;
                        ffq.O0000o00 = -1;
                        o0000OOo.O0000O0o = -1;
                        ffq.O00000oo();
                    }
                }
            });
        } else if (!o0000OOo.O0000Oo || O000000o("1.4.0", o0000OOo.O00000o) <= 0) {
            O00000oO();
        } else {
            O00000oo();
        }
    }

    public static int O000000o(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        while (i < min) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                int parseInt2 = Integer.parseInt(split2[i]);
                if (parseInt != parseInt2) {
                    return parseInt - parseInt2;
                }
                i++;
            } catch (Exception e) {
                gnk.O00000Oo(gnk.O00000Oo(e));
                return 0;
            }
        }
        return split.length - split2.length;
    }

    public final void O00000oO() {
        final O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        if (o0000OOo == null || o0000OOo.O0000O0o == 0) {
            O000000o(1, (byte[]) null, new O00000o0() {
                /* class _m_j.ffq.AnonymousClass7 */

                public final void O000000o(byte[] bArr) {
                    if (bArr == null || bArr.length < 2) {
                        ffq.this.O000000o(-401, "get fragment size failed");
                        return;
                    }
                    short s = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort();
                    gnk.O000000o("get Protocol version %d", Integer.valueOf(s));
                    ffq ffq = ffq.this;
                    ffq.O0000o00 = s;
                    o0000OOo.O0000O0o = s;
                    ffq.O000000o(s);
                }

                public final void O000000o(int i, String str) {
                    gnk.O000000o("get protocol version fail, error code=%d,msg=%s", Integer.valueOf(i), str);
                    ffq.this.O000000o(i, str);
                }
            });
        } else {
            O000000o(o0000OOo.O0000O0o);
        }
    }

    public final void O000000o(int i) {
        if (i <= 4) {
            O00000oo();
        } else {
            O000000o(3, "should update app , current app not suit protocol version ".concat(String.valueOf(i)));
        }
    }

    public final void O00000oo() {
        final O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        if (o0000OOo == null || o0000OOo.O0000OOo <= 0) {
            O000000o(2, (byte[]) null, new O00000o0() {
                /* class _m_j.ffq.AnonymousClass8 */

                public final void O000000o(byte[] bArr) {
                    if (bArr == null || bArr.length < 2) {
                        ffq.this.O000000o(-403, "get fragment size failed");
                        return;
                    }
                    short s = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort();
                    if (s > 0) {
                        o0000OOo.O0000OOo = s;
                        ffq.this.O00000Oo(s);
                        return;
                    }
                    ffq.this.O000000o(-403, "fragment size is 0");
                }

                public final void O000000o(int i, String str) {
                    gnk.O000000o("getFragmentSize fail, code = %d,msg = %s", Integer.valueOf(i), str);
                    ffq.this.O000000o(i, str);
                }
            });
        } else {
            O00000Oo(o0000OOo.O0000OOo);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(int i) {
        O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        if (o0000OOo == null || !o0000OOo.O0000Oo0) {
            if (this.O0000o00 >= 2) {
                O0000O0o(i);
            } else {
                O00000o0(i);
            }
        } else if (this.O0000o00 >= 3) {
            O00000oo(i);
        } else {
            O000000o(3, "should update app , current app cannot read mcu fragment index , device protocol version is:" + this.O0000o00);
        }
    }

    private void O00000oo(final int i) {
        O000000o(5, (byte[]) null, new O00000o0() {
            /* class _m_j.ffq.AnonymousClass9 */

            public final void O000000o(byte[] bArr) {
                if (bArr == null || bArr.length < 2) {
                    ffq.this.O000000o(-601, "get mcu last fragment index failed");
                    return;
                }
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                short s = order.getShort();
                int i = order.getInt();
                ByteBuffer order2 = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
                order2.putInt(i);
                gnk.O00000o("remote hex = " + got.O00000o0(order2.array()));
                if (s == 0) {
                    gnk.O00000o("getMCULastFragmentIndex =0");
                } else {
                    boolean O000000o2 = ffq.this.O000000o(i, s, i);
                    gnk.O00000o("getMCULastFragmentIndex,check result=".concat(String.valueOf(O000000o2)));
                    if (O000000o2) {
                        ffq.this.O000000o(i, s);
                        return;
                    }
                }
                ffq.this.O00000o0(i);
            }

            public final void O000000o(int i, String str) {
                ffq.this.O000000o(i, str);
            }
        });
    }

    private void O0000O0o(final int i) {
        O000000o(3, (byte[]) null, new O00000o0() {
            /* class _m_j.ffq.AnonymousClass10 */

            public final void O000000o(byte[] bArr) {
                if (bArr == null || bArr.length < 2) {
                    ffq.this.O000000o(-402, "get last fragment index failed");
                    return;
                }
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                short s = order.getShort();
                int i = order.getInt();
                ByteBuffer order2 = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
                order2.putInt(i);
                gnk.O00000o("remote hex = " + got.O00000o0(order2.array()));
                if (s == 0) {
                    gnk.O00000o("getLastFragmentIndex =0");
                } else {
                    boolean O000000o2 = ffq.this.O000000o(i, s, i);
                    gnk.O00000o("getLastFragmentIndex,check result=".concat(String.valueOf(O000000o2)));
                    if (O000000o2) {
                        ffq.this.O000000o(i, s);
                        return;
                    }
                }
                ffq.this.O00000o0(i);
            }

            public final void O000000o(int i, String str) {
                ffq.this.O000000o(i, str);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A[SYNTHETIC, Splitter:B:28:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e A[SYNTHETIC, Splitter:B:34:0x007e] */
    public final boolean O000000o(int i, int i2, int i3) {
        String O0000Oo2 = O0000Oo();
        if (!O000000o(O0000Oo2)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            File file = new File(O0000Oo2);
            long length = file.length();
            long j = (long) (i * i2);
            Integer valueOf = Integer.valueOf(i2);
            boolean z = true;
            gnk.O000000o("check last fragment Index,fragmentSize =%d, lastIndex =%d,fileSize = %d,crc32=%d", Integer.valueOf(i), valueOf, Long.valueOf(length), Integer.valueOf(i3));
            if (j <= length) {
                length = j;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                int O000000o2 = O000000o(fileInputStream2, length);
                gnk.O00000o("check local CRC32=".concat(String.valueOf(O000000o2)));
                if (i3 != O000000o2) {
                    z = false;
                }
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return z;
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            return false;
        }
    }

    private static int O000000o(InputStream inputStream, long j) {
        byte[] bArr = new byte[2048];
        long j2 = j;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            i++;
            try {
                int read = inputStream.read(bArr);
                if (read == 0) {
                    break;
                }
                long j3 = (long) read;
                if (j3 < j2) {
                    j2 -= j3;
                    z = false;
                } else {
                    read = (int) j2;
                }
                i2 = glf.O000000o(bArr, read, i2);
                gnk.O00000o("length =".concat(String.valueOf(read)));
                ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
                order.putInt(i2);
                if (z) {
                    gnk.O00000o("index =" + i + " ,crc32 hex =" + got.O00000o0(order.array()));
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return i2;
    }

    public final void O00000o0(int i) {
        gnk.O00000o0("Ble-OTA:MeshDfuManager sendData fragmentSize = ".concat(String.valueOf(i)));
        String O0000Oo2 = O0000Oo();
        if (!new File(O0000Oo2).exists()) {
            O000000o(-104, "file don't exist");
            return;
        }
        this.O0000Ooo = new O00000Oo(O0000Oo2, i);
        O0000O0o();
    }

    private String O0000Oo() {
        O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        String str = this.O0000O0o;
        return (o0000OOo == null || !o0000OOo.O0000Oo0 || TextUtils.isEmpty(o0000OOo.f16240O000000o)) ? str : o0000OOo.f16240O000000o;
    }

    public final void O000000o(int i, int i2) {
        String O0000Oo2 = O0000Oo();
        gnk.O000000o("send data fragment size = %d,last fragment index =%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!new File(O0000Oo2).exists()) {
            O000000o(-104, "file don't exist");
            return;
        }
        this.O0000Ooo = new O00000Oo(O0000Oo2, i);
        this.O0000Ooo.O000000o(i2);
        O0000O0o();
    }

    public final void O0000O0o() {
        O00000Oo o00000Oo = this.O0000Ooo;
        if (o00000Oo != null) {
            if (o00000Oo.O00000o0) {
                O0000OoO();
                return;
            }
            byte[] O000000o2 = this.O0000Ooo.O000000o();
            if (O000000o2 == null) {
                fte.O00000Oo("Ble-OTA:MeshDfuManager sendFragmentData buffer is null");
                O000000o(-1, "read file error");
                return;
            }
            this.O0000Oo0.removeMessages(12290);
            this.O0000Oo0.sendEmptyMessage(12290);
            StringBuilder sb = new StringBuilder("Ble-OTA:MeshDfuManager sendFragmentData fragment index = ");
            sb.append(this.O0000Ooo.O00000o - 1);
            gnk.O00000o0(sb.toString());
            O000000o(O000000o2, new O0000O0o() {
                /* class _m_j.ffq.AnonymousClass11 */

                public final void O000000o() {
                    ffq.this.O0000Oo0.sendEmptyMessage(12291);
                }

                public final void O000000o(int i, String str) {
                    ffq.this.O000000o(i, str);
                }
            });
        }
    }

    private void O0000OoO() {
        int i;
        final boolean z;
        gnk.O00000o0("Ble-OTA:MeshDfuManager switchFirmware");
        O0000OOo o0000OOo = this.f16225O000000o.get(this.O00000oo);
        if (o0000OOo == null || !o0000OOo.O0000Oo0) {
            z = false;
            i = 4;
        } else {
            z = true;
            i = 6;
        }
        if (z) {
            LogType logType = LogType.BLUETOOTH;
            gsy.O00000o0(logType, "Ble-OTA:MeshDfuManager", "mcu installing timeout=" + this.O00000Oo);
            O000000o(this.O0000OOo, 4, (String) null);
        }
        O000000o(i, got.O000000o(1), new O00000o0() {
            /* class _m_j.ffq.AnonymousClass2 */

            public final void O000000o(byte[] bArr) {
                if (ffq.this.O0000OOo != null) {
                    try {
                        ffq.this.O0000OOo.onProgress(100);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    ffq.this.O0000Oo0.removeMessages(12293);
                    ffq.this.O0000Oo0.removeMessages(12292);
                    ffq.this.O0000Oo0.sendEmptyMessageDelayed(12293, (long) (ffq.this.O00000Oo * 1000));
                    ffq.this.O0000Oo0.sendEmptyMessageDelayed(12292, 5000);
                    ffq.this.O0000OOo();
                    return;
                }
                ffq.this.O0000Oo0();
            }

            public final void O000000o(int i, String str) {
                if (-7 != i) {
                    ffq ffq = ffq.this;
                    ffq.O000000o(i, str + ":switch firmware fail");
                } else if (z) {
                    ffq.this.O0000Oo0.removeMessages(12293);
                    ffq.this.O0000Oo0.removeMessages(12292);
                    ffq.this.O0000Oo0.sendEmptyMessageDelayed(12293, (long) (ffq.this.O00000Oo * 1000));
                    ffq.this.O0000Oo0.sendEmptyMessageDelayed(12292, 5000);
                    ffq.this.O0000OOo();
                } else {
                    ffq.this.O0000Oo0();
                }
            }
        });
    }

    public final void O0000OOo() {
        gnk.O00000o("Ble-OTA:MeshDfuManager：start poll mcu version");
        glw.O000000o().write(this.O00000oo, glb.f17954O000000o, glb.O0000oOO, new byte[]{1}, new BleWriteResponse() {
            /* class _m_j.ffq.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                gsy.O00000o0(LogType.BLUETOOTH, "Ble-OTA:MeshDfuManager", "pollMcuVersion[write] onResponse code=".concat(String.valueOf(i)));
            }
        });
    }

    private void O000000o(int i, byte[] bArr, final O00000o0 o00000o0) {
        try {
            ffn ffn = new ffn(i, bArr);
            this.O0000Oo = new O00000o(i, o00000o0);
            this.O0000Oo0.sendEmptyMessageDelayed(12289, 20000);
            glw.O000000o().write(this.O00000oo, glb.f17954O000000o, glb.O0000o0O, ffn.O000000o(), new BleWriteResponse() {
                /* class _m_j.ffq.AnonymousClass4 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    if (i != 0) {
                        ffq ffq = ffq.this;
                        ffq.O0000Oo = null;
                        ffq.O0000Oo0.removeMessages(12289);
                        o00000o0.O000000o(i, "send command failed");
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            o00000o0.O000000o(-11, "params exceed max size");
        }
    }

    private void O000000o(byte[] bArr, O0000O0o o0000O0o) {
        IBleChannelWriter iBleChannelWriter = this.O0000o0O;
        if (iBleChannelWriter == null) {
            o0000O0o.O000000o(-1, "channel write is null");
            return;
        }
        try {
            this.O0000OoO = o0000O0o;
            iBleChannelWriter.write(bArr, 0, new MeshDfuManager$13(this, o0000O0o));
        } catch (RemoteException e) {
            e.printStackTrace();
            o0000O0o.O000000o(-1, "channel write exception");
        }
    }

    public final void O000000o(int i, String str) {
        fte.O00000Oo(String.format("Ble-OTA:MeshDfuManager onUpgradeFailed errorCode = %d, errorMsg = %s", Integer.valueOf(i), str));
        O000000o(this.O0000OOo, i, str);
        O0000Ooo();
    }

    private void O0000Ooo() {
        if (this.O0000o0O != null) {
            fev.O00000Oo().O000000o(this.O00000oo, this.O0000o0o);
            this.O0000o0O = null;
        }
        O00000Oo o00000Oo = this.O0000Ooo;
        if (o00000Oo != null) {
            o00000Oo.O00000Oo();
            this.O0000Ooo = null;
        }
        if (!TextUtils.isEmpty(this.O00000oo)) {
            this.f16225O000000o.remove(this.O00000oo);
        }
        this.O0000Oo0.removeMessages(12289);
        this.O0000Oo0.removeMessages(12290);
        this.O0000Oo = null;
        this.O0000OoO = null;
        this.O0000OOo = null;
        this.O00000o0 = false;
        this.O00000oO = false;
        this.O00000oo = null;
        this.O0000O0o = null;
    }

    class O000000o extends Handler {
        public O000000o(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 12289:
                    if (!(ffq.this.O0000Oo == null || ffq.this.O0000Oo.O00000Oo == null)) {
                        ffq.this.O0000Oo.O00000Oo.O000000o(-7, "send command timeout");
                    }
                    ffq.this.O0000Oo = null;
                    return;
                case 12290:
                    if (ffq.this.O0000OOo != null) {
                        try {
                            IBleMeshUpgradeResponse iBleMeshUpgradeResponse = ffq.this.O0000OOo;
                            O00000Oo o00000Oo = ffq.this.O0000Ooo;
                            long j = (o00000Oo.O00000Oo * 100) / o00000Oo.f16238O000000o;
                            if (j > 100) {
                                j = 100;
                            }
                            iBleMeshUpgradeResponse.onProgress((int) j);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        ffq.this.O0000Oo0.sendEmptyMessageDelayed(12290, 400);
                        return;
                    }
                    return;
                case 12291:
                    ffq.this.O0000O0o();
                    return;
                case 12292:
                    ffq.this.O0000Oo0.removeMessages(12292);
                    ffq.this.O0000Oo0.sendEmptyMessageDelayed(12292, 5000);
                    ffq.this.O0000OOo();
                    return;
                case 12293:
                    ffq.this.O0000Oo0.removeMessages(12292);
                    ffq.this.O000000o(-602, "switch mcu firmware, but activate timeout");
                    return;
                default:
                    return;
            }
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        long f16238O000000o;
        long O00000Oo = 0;
        short O00000o = 1;
        boolean O00000o0 = false;
        private int O00000oo;
        private byte[] O0000O0o;
        private int O0000OOo = 0;
        private byte[] O0000Oo;
        private int O0000Oo0 = 0;
        private FileInputStream O0000OoO;

        public O00000Oo(String str, int i) {
            this.O00000oo = i;
            this.O0000O0o = new byte[(i * 10)];
            this.O0000Oo = new byte[(i + 2)];
            File file = new File(str);
            this.f16238O000000o = file.length();
            try {
                this.O0000OoO = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public final boolean O000000o(int i) {
            long j = (long) (this.O00000oo * i);
            long j2 = this.f16238O000000o;
            if (j > j2) {
                j = j2;
            }
            try {
                if (this.O0000OoO.skip(j) != j) {
                    return false;
                }
                this.O00000o = (short) (((short) i) + 1);
                this.O00000Oo = j;
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        public final byte[] O000000o() {
            byte[] bArr;
            if (this.O00000o0) {
                gnk.O00000o0("Ble-OTA:MeshDfuManager getFragmentBuffer has send complete");
                return null;
            } else if (this.O0000OoO == null) {
                fte.O00000Oo("Ble-OTA:MeshDfuManager getFragmentBuffer fis is null");
                return null;
            } else if (this.O0000Oo0 < this.O0000OOo || O00000o0()) {
                int i = this.O0000OOo;
                if (i == 0 || i == -1) {
                    gnk.O00000o0("Ble-OTA:MeshDfuManager getFragmentBuffer fileBufferCount is " + this.O0000OOo);
                    return null;
                }
                int i2 = this.O0000Oo0;
                int i3 = i - i2;
                int i4 = this.O00000oo;
                if (i3 >= i4) {
                    System.arraycopy(this.O0000O0o, i2, this.O0000Oo, 2, i4);
                    bArr = this.O0000Oo;
                    long j = this.O00000Oo;
                    int i5 = this.O00000oo;
                    this.O00000Oo = j + ((long) i5);
                    this.O0000Oo0 += i5;
                } else {
                    byte[] bArr2 = new byte[((i - i2) + 2)];
                    System.arraycopy(this.O0000O0o, i2, bArr2, 2, i - i2);
                    long j2 = this.O00000Oo;
                    int i6 = this.O0000OOo;
                    this.O00000Oo = j2 + ((long) (i6 - this.O0000Oo0));
                    this.O0000Oo0 = i6;
                    bArr = bArr2;
                }
                byte[] O000000o2 = got.O000000o(this.O00000o);
                bArr[0] = O000000o2[0];
                bArr[1] = O000000o2[1];
                this.O00000o = (short) (this.O00000o + 1);
                if (this.O00000Oo >= this.f16238O000000o) {
                    this.O00000o0 = true;
                }
                return bArr;
            } else {
                fte.O00000Oo("Ble-OTA:MeshDfuManager loadFromFile failed");
                return null;
            }
        }

        private boolean O00000o0() {
            boolean z;
            try {
                this.O0000OOo = this.O0000OoO.read(this.O0000O0o);
                z = true;
            } catch (IOException e) {
                e.printStackTrace();
                z = false;
            }
            this.O0000Oo0 = 0;
            return z;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            FileInputStream fileInputStream = this.O0000OoO;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.O0000OoO = null;
            }
            this.O0000O0o = null;
            this.O0000Oo = null;
        }
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f16239O000000o;
        O00000o0 O00000Oo;

        public O00000o(int i, O00000o0 o00000o0) {
            this.f16239O000000o = i;
            this.O00000Oo = o00000o0;
        }
    }

    public final void O0000Oo0() {
        fte.O00000Oo("Ble-OTA:MeshDfuManager onUpgradeSuccess ");
        O000000o(this.O0000OOo, 0, (String) null);
        if (!this.O00000oO) {
            fte.O00000Oo("Ble-OTA:MeshDfuManager start release ");
            O0000Ooo();
        }
    }
}
