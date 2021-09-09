package _m_j;

import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.core.entity.device.BtDevice;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegisterConnector$12;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegisterConnector$5;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegisterConnector$7;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegisterConnector$8;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleSecurityChipRegisterConnector$9;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import javax.crypto.SecretKey;
import org.json.JSONObject;

public final class fhj extends fhd {
    public static final byte[] O0000Oo = {16, 1, 0, 0};
    public static final byte[] O0000Oo0 = {16, 0, 0, 0};
    public static final byte[] O0000OoO = {16, Byte.MIN_VALUE, 0, 0};
    private static final byte[] O0000oo = {18, 0, 0, 0};
    private static final byte[] O0000oo0 = {17, 0, 0, 0};
    private static final byte[] O000O00o = {-31, 0, 0, 0};
    private static final byte[] O00oOooO = {19, 0, 0, 0};
    private static final byte[] O00oOooo = {20, 0, 0, 0};
    X509Certificate O0000Ooo;
    public byte[] O0000o;
    byte[] O0000o0;
    public byte[] O0000o00;
    public SecretKey O0000o0O;
    public byte[] O0000o0o;
    public String O0000oO;
    public String O0000oO0;
    public String O0000oOO;
    public byte[] O0000oOo;
    private KeyPair O000O0OO;
    private PublicKey O000O0Oo;
    private byte[] O000O0o;
    private byte[] O000O0o0;
    private byte[] O000O0oO;
    private X509Certificate O000O0oo;
    private byte[] O000OO;
    private byte[] O000OO00;
    private byte[] O000OO0o;
    private byte[] O000OOOo;
    private String O000OOo;
    private int O000OOo0 = -7;
    private String O000OOoO;
    private BleComboWifiConfig O000OOoo;
    private byte[] O00oOoOo;

    protected fhj(fgp fgp, BleConnectOptions bleConnectOptions) {
        super(fgp);
        if (bleConnectOptions != null) {
            this.O0000oO0 = bleConnectOptions.O00000oO;
            this.O000OOoo = bleConnectOptions.O00000oo;
        }
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o0)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleSecurityChipRegisterConnector receiveDeviceResult ..., value = " + got.O00000o0(bArr));
            fec.O00000o().O00000Oo(14);
            if (got.O00000Oo(bArr, O0000oo0)) {
                this.O0000OOo.removeMessages(4098);
                this.O00000oO.putByteArray("ltmk", this.O0000o00);
                O000000o(0);
            } else if (got.O00000Oo(bArr, O0000oo)) {
                this.O0000OOo.removeMessages(4098);
                fec.O00000o().O000000o(14, "msg", "reg failed");
                O0000o0o();
                O000000o(this.O000OOo0);
            } else if (got.O00000Oo(bArr, O000O00o)) {
                this.O0000OOo.removeMessages(4098);
                fec.O00000o().O000000o(14, "msg", "error:registered");
                O000000o(-17);
            }
        }
    }

    private short O0000o() {
        return ByteBuffer.wrap(Arrays.copyOfRange(this.O000O0o0, 10, 12)).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    private static String O0000oO0() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }

    public final String O0000o0O() {
        X509Certificate x509Certificate = this.O0000Ooo;
        return x509Certificate != null ? x509Certificate.getSerialNumber().toString() : "";
    }

    public final void O0000o0o() {
        if (O0000o() == 517 && !TextUtils.isEmpty(this.O0000oOO)) {
            fgo.O000000o(O0000o0O(), ffr.O0000O0o(O00000o0()), new feo<Boolean, fes>() {
                /* class _m_j.fhj.AnonymousClass4 */

                public final void O000000o(fes fes) {
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                }
            });
            ffr.O000000o(O00000o0(), "");
            ffr.O00000o(O00000o0(), 0);
        }
    }

    private byte[] O00000o0(byte[] bArr) {
        int i = this.O000OOoo != null ? 16 : 12;
        try {
            return Arrays.copyOfRange(grx.O000000o(bArr), 0, i);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return Arrays.copyOfRange(bArr, 0, i);
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return Arrays.copyOfRange(bArr, 0, i);
        }
    }

    public static void O000000o(String str, Object... objArr) {
        String concat = "BleSecurityChipRegisterConnector".concat(String.valueOf(str));
        if (objArr.length > 0) {
            gsy.O00000o0(LogType.BLUETOOTH, "core-bluetooth", String.format(concat, objArr));
        } else {
            gsy.O00000o0(LogType.BLUETOOTH, "core-bluetooth", concat);
        }
    }

    private void O0000oO() {
        String str;
        String str2;
        this.O000OO0o = O00000o0(this.O0000o00);
        String O0000Oo2 = ffr.O0000Oo(O00000o0());
        String O00000Oo = grs.O00000Oo(this.O000O0o);
        String O00000Oo2 = grs.O00000Oo(this.O000O0oO);
        final String O000000o2 = O000000o(fec.O00000o0().O00000Oo(O0000Oo2), O0000Oo2);
        fte.O00000Oo(String.format("bindLtmkToServerV205 name = %s, did = %s, mac = %s, model = %s", O000000o2, O0000o0O(), fte.O000000o(O00000o0()), O0000Oo2));
        if (!got.O00000o(this.O000OO00)) {
            str = got.O00000o0(this.O000OO00);
        } else {
            str = "";
        }
        if (!got.O00000o(this.O0000o0)) {
            str2 = got.O00000o0(this.O0000o0);
        } else {
            str2 = "";
        }
        final int O0000oOO2 = ffr.O0000oOO(O00000o0());
        fec.O00000o().O000000o(12);
        this.O0000oOO = null;
        this.O0000oOo = null;
        fgo.O00000Oo(O00000o0(), O0000Oo2, got.O00000o0(this.O000OO0o), got.O00000o0(this.O0000o00), O000000o2, O00000Oo, O00000Oo2, str, str2, O0000oOO2, this.O000OOo, this.O000OOoO, this.O0000oO, new feo<JSONObject, fes>() {
            /* class _m_j.fhj.AnonymousClass5 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fhj.O000000o(boolean, int):void
             arg types: [int, int]
             candidates:
              _m_j.fhj.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.fhj.O000000o(java.lang.String, java.lang.Object[]):void
              _m_j.fhj.O000000o(byte[], byte[]):byte[]
              _m_j.fhj.O000000o(byte[], int):void
              _m_j.fhd.O000000o(byte[], int):void
              _m_j.fgm.O000000o(int, boolean):void
              _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
              _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
              _m_j.fhj.O000000o(boolean, int):void */
            public final /* synthetic */ void O000000o(Object obj) {
                byte[] bArr;
                JSONObject jSONObject = (JSONObject) obj;
                boolean optBoolean = jSONObject.optBoolean("success");
                String optString = jSONObject.optString("cloud_cert");
                String optString2 = jSONObject.optString("cloud_sign");
                int optInt = jSONObject.optInt("utc");
                fte.O00000Oo(">>> bindLtmkToServerV205 onSuccess ".concat(String.valueOf(jSONObject)));
                if (optBoolean) {
                    fec.O00000o().O00000Oo(12);
                    ffr.O000000o(fhj.this.O00000o0(), O000000o2);
                    ffr.O00000o(fhj.this.O00000o0(), 2);
                    fhj fhj = fhj.this;
                    fhj.O0000oOO = optString;
                    byte[] bArr2 = new byte[76];
                    if (fhj.O0000Ooo != null) {
                        String bigInteger = fhj.O0000Ooo.getSerialNumber().toString();
                        ByteBuffer order = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
                        order.putLong(Long.parseLong(bigInteger));
                        bArr = order.array();
                    } else {
                        bArr = new byte[8];
                    }
                    byte[] O000000o2 = grs.O000000o(optString2, 24);
                    fhj.O000000o("utc =%d", Integer.valueOf(optInt));
                    System.arraycopy(bArr, 0, bArr2, 0, 8);
                    System.arraycopy(O000000o2, 0, bArr2, 8, 64);
                    ByteBuffer order2 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                    order2.putInt(optInt);
                    byte[] array = order2.array();
                    System.arraycopy(array, 0, bArr2, 72, 4);
                    byte[] O000000o3 = fir.O000000o(fhj.O0000o0, new byte[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}, bArr2);
                    fhj.O000000o("buildEncryptData===>\nutc=%s", got.O00000o0(array));
                    fhj.O000000o("buildEncryptData===> \nsign=%s,\n deviceID=%s", got.O00000o0(O000000o2), got.O00000o0(bArr));
                    fhj.O000000o("buildEncryptData===> \ncloudKey=%s\n, plain=%s", got.O00000o0(fhj.O0000o0), got.O00000o0(bArr2));
                    fhj.O000000o("buildEncryptData===> data length=%d,\ndata=%s", Integer.valueOf(O000000o3.length), got.O00000o0(O000000o3));
                    fhj.O0000oOo = O000000o3;
                    fhj.this.O000000o(true, 0);
                    if (O0000oOO2 != 0) {
                        fgo.O000000o(fhj.this.O0000o0O(), ffr.O0000oOo(fhj.this.O00000o0()));
                        return;
                    }
                    return;
                }
                fec.O00000o().O000000o(12, 11);
                fhj.this.O000000o(false, -26);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fhj.O000000o(boolean, int):void
             arg types: [int, int]
             candidates:
              _m_j.fhj.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.fhj.O000000o(java.lang.String, java.lang.Object[]):void
              _m_j.fhj.O000000o(byte[], byte[]):byte[]
              _m_j.fhj.O000000o(byte[], int):void
              _m_j.fhd.O000000o(byte[], int):void
              _m_j.fgm.O000000o(int, boolean):void
              _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
              _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
              _m_j.fhj.O000000o(boolean, int):void */
            public final void O000000o(fes fes) {
                fte.O00000Oo(">>> bindLtmkToServerV205 onFailure: ".concat(String.valueOf(fes)));
                if (fes != null) {
                    fec.O00000o().O000000o(12, "msg", fes.toString());
                    fec.O00000o().O000000o(12, 11);
                }
                if (fes.f16189O000000o == -1) {
                    String str = fes.O00000Oo;
                    if (TextUtils.isEmpty(str) || str.contains("Unable to resolve")) {
                        fhj.this.O000000o(false, -26);
                        return;
                    }
                    fhj.this.O00000oO.putString("key_device_did", fhj.this.O0000o0O());
                    fhj.this.O000000o(false, -14);
                    return;
                }
                fhj.this.O000000o(false, -26);
            }
        });
    }

    private void O0000oOO() {
        String str;
        String str2;
        this.O000OO0o = O00000o0(this.O0000o00);
        String O0000Oo2 = ffr.O0000Oo(O00000o0());
        String O00000Oo = grs.O00000Oo(this.O000O0o);
        String O00000Oo2 = grs.O00000Oo(this.O000O0oO);
        final String O000000o2 = O000000o(fec.O00000o0().O00000Oo(O0000Oo2), O0000Oo2);
        fte.O00000Oo(String.format("bindLtmkToServer name = %s, did = %s, mac = %s, model = %s", O000000o2, O0000o0O(), fte.O000000o(O00000o0()), O0000Oo2));
        if (!got.O00000o(this.O000OO00)) {
            str = got.O00000o0(this.O000OO00);
        } else {
            str = "";
        }
        if (!got.O00000o(this.O0000o0)) {
            str2 = got.O00000o0(this.O0000o0);
        } else {
            str2 = "";
        }
        final int O0000oOO2 = ffr.O0000oOO(O00000o0());
        fec.O00000o().O000000o(12);
        fgo.O000000o(O00000o0(), O0000Oo2, got.O00000o0(this.O000OO0o), got.O00000o0(this.O0000o00), O000000o2, O00000Oo, O00000Oo2, str, str2, O0000oOO2, this.O000OOo, this.O000OOoO, this.O0000oO, new feo<Boolean, fes>() {
            /* class _m_j.fhj.AnonymousClass6 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fhj.O000000o(boolean, int):void
             arg types: [int, int]
             candidates:
              _m_j.fhj.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.fhj.O000000o(java.lang.String, java.lang.Object[]):void
              _m_j.fhj.O000000o(byte[], byte[]):byte[]
              _m_j.fhj.O000000o(byte[], int):void
              _m_j.fhd.O000000o(byte[], int):void
              _m_j.fgm.O000000o(int, boolean):void
              _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
              _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
              _m_j.fhj.O000000o(boolean, int):void */
            public final /* synthetic */ void O000000o(Object obj) {
                Boolean bool = (Boolean) obj;
                fte.O00000Oo(">>> securityChipBindLtmkToServer onSuccess ".concat(String.valueOf(bool)));
                if (bool.booleanValue()) {
                    fec.O00000o().O00000Oo(12);
                    ffr.O000000o(fhj.this.O00000o0(), O000000o2);
                    ffr.O00000o(fhj.this.O00000o0(), 2);
                    fhj.this.O000000o(true, 0);
                    if (O0000oOO2 != 0) {
                        fgo.O000000o(fhj.this.O0000o0O(), ffr.O0000oOo(fhj.this.O00000o0()));
                        return;
                    }
                    return;
                }
                fec.O00000o().O000000o(12, 11);
                fhj.this.O000000o(false, -26);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fhj.O000000o(boolean, int):void
             arg types: [int, int]
             candidates:
              _m_j.fhj.O000000o(java.lang.String, java.lang.String):java.lang.String
              _m_j.fhj.O000000o(java.lang.String, java.lang.Object[]):void
              _m_j.fhj.O000000o(byte[], byte[]):byte[]
              _m_j.fhj.O000000o(byte[], int):void
              _m_j.fhd.O000000o(byte[], int):void
              _m_j.fgm.O000000o(int, boolean):void
              _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
              _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
              _m_j.fhj.O000000o(boolean, int):void */
            public final void O000000o(fes fes) {
                fte.O00000Oo(">>> securityChipBindLtmkToServer onFailure: ".concat(String.valueOf(fes)));
                if (fes != null) {
                    fec.O00000o().O000000o(12, "msg", fes.toString());
                    fec.O00000o().O000000o(12, 11);
                }
                if (fes.f16189O000000o == -1) {
                    String str = fes.O00000Oo;
                    if (TextUtils.isEmpty(str) || str.contains("Unable to resolve")) {
                        fhj.this.O000000o(false, -26);
                        return;
                    }
                    fhj.this.O00000oO.putString("key_device_did", fhj.this.O0000o0O());
                    fhj.this.O000000o(false, -14);
                    return;
                }
                fhj.this.O000000o(false, -26);
            }
        });
    }

    private static String O000000o(String str, String str2) {
        int i;
        String str3;
        ArrayList<BtDevice> O00000oo = fea.O00000oo();
        ArrayList arrayList = new ArrayList();
        Iterator<BtDevice> it = O00000oo.iterator();
        while (it.hasNext()) {
            BtDevice next = it.next();
            if (TextUtils.equals(str2, next.getModel())) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            boolean z = false;
            i = 1;
            while (!z) {
                if (i == 1) {
                    str3 = str;
                } else {
                    str3 = str + i;
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (TextUtils.equals(str3, ((BtDevice) it2.next()).getName())) {
                            i++;
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
        } else {
            i = 1;
        }
        if (i == 1) {
            return str;
        }
        return str + i;
    }

    private static byte[] O00000o(byte[] bArr) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, "smartcfg-setup-salt".getBytes());
            return O000000o2.O000000o("smartcfg-setup-info".getBytes(), 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] O00000oO(byte[] bArr) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, "smartcfg-masterkey-salt".getBytes());
            return O000000o2.O000000o("smartcfg-masterkey-info".getBytes(), 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("smartcfg-setup-info".getBytes(), 32);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] O00000Oo(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("smartcfg-setup-info".getBytes(), 64);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O000000o(Message message) {
        int i = message.what;
        if (i == 4098) {
            fte.O00000Oo("BleSecurityChipRegisterConnector notify timeout");
            O000000o(this.O000OOo0);
            fec.O00000o().O000000o();
        } else if (i == 4099) {
            fte.O00000Oo("BleSecurityChipRegisterConnector paircode timeout");
            fec.O00000o().O000000o(44, 8);
            O000000o(-35);
        }
    }

    public final byte[] O0000Oo0() {
        return this.O000OO0o;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        boolean z = true;
        if (i == 1) {
            fte.O00000Oo("BleSecurityChipRegisterConnector recvDeviceCert ...");
            this.O000O0o = Arrays.copyOf(bArr, bArr.length);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            fec.O00000o().O00000Oo(24);
            try {
                this.O0000Ooo = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            } catch (CertificateException e) {
                e.printStackTrace();
            }
            fec.O00000o().O000000o(43);
            this.O0000OOo.removeMessages(4098);
            this.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
        } else if (i == 2) {
            fte.O00000Oo("BleSecurityChipRegisterConnector recvDeviceManuCert ...");
            fec.O00000o().O00000Oo(43);
            this.O000O0oO = Arrays.copyOf(bArr, bArr.length);
            try {
                this.O000O0oo = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            } catch (CertificateException e2) {
                e2.printStackTrace();
            }
            fec.O00000o().O000000o(29);
            this.O0000OOo.removeMessages(4098);
            this.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
        } else if (i == 3) {
            fte.O00000Oo("BleSecurityChipRegisterConnector recvDevicePubKey ...");
            this.O000O0o0 = Arrays.copyOfRange(bArr, 0, 12);
            this.O00oOoOo = Arrays.copyOfRange(bArr, 12, 76);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 11, 76);
            copyOfRange[0] = 4;
            try {
                this.O000O0Oo = fio.O000000o(copyOfRange, ((ECPublicKey) this.O000O0OO.getPublic()).getParams());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            short O0000o2 = O0000o();
            if (!(O0000o2 == 257 || O0000o2 == 512)) {
                switch (O0000o2) {
                    case 514:
                    case 515:
                    case 516:
                    case 517:
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            if (z) {
                fec.O00000o().O00000Oo(17);
                if (516 <= O0000o()) {
                    fec.O00000o().O000000o(41);
                    AnonymousClass10 r13 = new feo<String, fes>() {
                        /* class _m_j.fhj.AnonymousClass10 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            if (TextUtils.isEmpty(str)) {
                                fec.O00000o().O000000o(41, 11);
                                fte.O00000Oo("BleSecurityChipRegisterConnector get bind key is empty");
                                fhj.this.O000000o(-46);
                                return;
                            }
                            fec.O00000o().O00000Oo(41);
                            fhj fhj = fhj.this;
                            fhj.O0000oO = str;
                            byte[] bytes = str.getBytes();
                            fec.O00000o().O000000o(42);
                            if (!fhj.O000000o(bytes, 14, new BleSecurityChipRegisterConnector$9(fhj))) {
                                fec.O00000o().O000000o(42, 2);
                                fhj.O000000o(-28);
                            }
                        }

                        public final void O000000o(fes fes) {
                            if (fes != null) {
                                fec.O00000o().O000000o(41, "msg", fes.toString());
                            }
                            fec.O00000o().O000000o(41, 11);
                            fte.O00000Oo("BleSecurityChipRegisterConnector get bind key failed: " + fes.toString());
                            fhj.this.O000000o(-46);
                        }
                    };
                    JSONObject jSONObject = new JSONObject();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
                    BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
                    o000000o.f6799O000000o = "POST";
                    o000000o.O00000Oo = "/user/get_bindkey";
                    o000000o.O00000o0 = arrayList;
                    fec.O00000o0().O000000o(o000000o.O000000o(), new fer(new feq<String>() {
                        /* class _m_j.fgo.AnonymousClass27 */

                        public final /* synthetic */ Object O000000o(JSONObject jSONObject) {
                            gnk.O00000o0(String.format("Http Response: [%S]", jSONObject));
                            return jSONObject.optString("bindkey");
                        }
                    }, r13) {
                        /* class _m_j.fgo.AnonymousClass28 */

                        /* renamed from: O000000o */
                        final /* synthetic */ feq f16289O000000o;
                        final /* synthetic */ feo O00000Oo;

                        {
                            this.f16289O000000o = r1;
                            this.O00000Oo = r2;
                        }

                        public final void O000000o(String str) {
                            fet.O000000o().O000000o(str, this.f16289O000000o, this.O00000Oo);
                        }

                        public final void O000000o(int i, String str) {
                            feo feo = this.O00000Oo;
                            if (feo != null) {
                                feo.O000000o(new fes(i, str));
                            }
                        }
                    });
                    return;
                }
                this.O0000OOo.removeMessages(4098);
                fec.O00000o().O000000o(24);
                this.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
                return;
            }
            fec.O00000o().O000000o(17, 104);
            O000000o(-37);
        } else if (i == 4) {
            fec.O00000o().O00000Oo(29);
            fec.O00000o().O000000o(45);
            if (O00000Oo(bArr)) {
                fec.O00000o().O00000Oo(45);
                if (got.O00000o(this.O0000o0o)) {
                    O000000o(true);
                } else {
                    fec.O00000o().O000000o(21);
                }
            } else {
                fec.O00000o().O000000o(45, 10);
                O000000o(false);
            }
        } else if (i == 12) {
            fte.O00000Oo("BleSecurityChipRegisterConnector recvDevConfirmation ...");
            this.O0000o = bArr;
            fec.O00000o().O00000Oo(44);
            fec.O00000o().O00000Oo(21);
            fec.O00000o().O000000o(18);
            if (!O000000o(this.O000OOOo, 10, new BleSecurityChipRegisterConnector$7(this))) {
                fec.O00000o().O000000o(18, 2);
                O000000o(-28);
            }
        } else if (i == 13) {
            fte.O00000Oo("BleSecurityChipRegisterConnector recvDevRandom ...");
            this.O0000OOo.removeMessages(4098);
            this.O0000OOo.removeMessages(4099);
            fec.O00000o().O00000Oo(19);
            fec.O00000o().O000000o(20);
            if (!O000000o(this.O000OO, 11, new BleSecurityChipRegisterConnector$8(this, bArr))) {
                fec.O00000o().O000000o(20, 2);
                O000000o(-28);
            }
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector Process Step 1 ...");
        ffr.O00000o(O00000o0(), "".getBytes());
        O00000Oo(new BleNotifyResponse() {
            /* class _m_j.fhj.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleSecurityChipRegisterConnector Step 1 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhj.this.O0000Ooo();
                } else {
                    fhj.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector Process Step 1 plus ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fhj.AnonymousClass7 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleSecurityChipRegisterConnector Step 1 plus onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhj.this.O0000o00();
                } else {
                    fhj.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector Process Step 2 ...");
        fec.O00000o().O000000o(40);
        O000000o(O00000o0(), new BleResponse<String>() {
            /* class _m_j.fhj.AnonymousClass8 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                String str = (String) obj;
                if (i != 0 || TextUtils.isEmpty(str)) {
                    fec.O00000o().O000000o(40, "error_code", String.valueOf(i));
                    fec.O00000o().O000000o(40, 2);
                    fhj.this.O000000o(-36);
                    return;
                }
                fte.O00000Oo("BleSecurityChipRegisterConnector version: ".concat(String.valueOf(str)));
                String[] split = str.split("[._]");
                int i2 = 0;
                try {
                    if (split.length == 1) {
                        i2 = Integer.valueOf(split[0]).intValue();
                    } else {
                        i2 = (Integer.valueOf(split[0]).intValue() * 1000) + Integer.valueOf(split[1]).intValue();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fec.O00000o().O000000o(40, "version", str);
                fec.O00000o().O00000Oo(40);
                ffr.O0000o0o(fhj.this.O00000o0(), str);
                if (i2 < 2001) {
                    fhj.this.O000000o(fhj.O0000Oo0);
                } else if (TextUtils.isEmpty(fhj.this.O0000oO0)) {
                    fhj.this.O000000o(fhj.O0000Oo);
                } else {
                    fhj.this.O000000o(fhj.O0000OoO);
                }
            }
        });
    }

    public final void O000000o(final byte[] bArr) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector sendRegStart ...");
        fec.O00000o().O000000o(4);
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr, new BleWriteResponse() {
            /* class _m_j.fhj.AnonymousClass9 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleSecurityChipRegisterConnector sendRegStart onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fec.O00000o().O00000Oo(4);
                    fhj.this.O0000o0();
                    return;
                }
                fec.O00000o().O000000o(4, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(4, "data", got.O00000o0(bArr));
                fec.O00000o().O000000o(4, 2);
                fhj.this.O000000o(-28);
            }
        });
    }

    public final void O0000o0() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector Process Step 3 ...");
        this.O000O0OO = fir.O000000o();
        fec.O00000o().O000000o(16);
        if (!O000000o(fir.O000000o(this.O000O0OO.getPublic()), 3, new BleSecurityChipRegisterConnector$5(this))) {
            fec.O00000o().O000000o(16, 2);
            O000000o(-28);
        }
    }

    private boolean O00000Oo(byte[] bArr) {
        byte[] bArr2;
        fte.O00000Oo("BleSecurityChipRegisterConnector recvDeviceSignature ...");
        this.O0000OOo.removeMessages(4098);
        if (this.O0000Ooo == null || this.O000O0oo == null || this.O000O0Oo == null) {
            fec.O00000o().O000000o(45, "msg", "devCert/ManuCert/DevPublicKey is empty");
            return false;
        } else if (!fiq.O000000o(fiq.O000000o(), this.O000O0oo)) {
            fec.O00000o().O000000o(45, "msg", "Manu cert is invalid");
            fte.O00000Oo("BleSecurityChipRegisterConnector MijiaManufactureCERT is invalid");
            return false;
        } else if (!fiq.O000000o(this.O000O0oo, this.O0000Ooo)) {
            fec.O00000o().O000000o(45, "msg", "Device Cert is invalid");
            fte.O00000Oo("BleSecurityChipRegisterConnector MijiaDeviceCert is invalid");
            return false;
        } else {
            this.O0000o0O = fir.O000000o(this.O000O0Oo, this.O000O0OO.getPrivate());
            if (this.O0000o0O == null) {
                fec.O00000o().O000000o(45, "msg", "eShare is empty");
                return false;
            }
            short O0000o2 = O0000o();
            try {
                fte.O00000Oo("BleSecurityChipRegisterConnector protocol version = ".concat(String.valueOf((int) O0000o2)));
                if (257 != O0000o2) {
                    if (512 != O0000o2) {
                        byte[] O000000o2 = fir.O000000o(bArr);
                        if (TextUtils.isEmpty(this.O0000oO)) {
                            bArr2 = this.O0000o0O.getEncoded();
                        } else {
                            byte[] O00000Oo = fhc.O00000Oo(this.O0000o0O.getEncoded());
                            byte[] bytes = this.O0000oO.getBytes();
                            byte[] bArr3 = new byte[(O00000Oo.length + bytes.length)];
                            System.arraycopy(O00000Oo, 0, bArr3, 0, O00000Oo.length);
                            System.arraycopy(bytes, 0, bArr3, O00000Oo.length, bytes.length);
                            bArr2 = bArr3;
                        }
                        if (fir.O000000o(bArr2, O000000o2, this.O0000Ooo.getPublicKey())) {
                            this.O0000o0o = new byte[16];
                            fte.O00000Oo("BleSecurityChipRegisterConnector qrcode oob: " + this.O0000oO0);
                            if (TextUtils.isEmpty(this.O0000oO0)) {
                                String O0000oO02 = O0000oO0();
                                O000000o(O0000oO02);
                                this.O0000OOo.sendEmptyMessageDelayed(4099, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                                System.arraycopy(O0000oO02.getBytes(), 0, this.O0000o0o, 0, O0000oO02.getBytes().length);
                            } else {
                                fec.O00000o().O000000o(21);
                                this.O0000OOo.removeMessages(4098);
                                this.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
                                byte[] O000000o3 = got.O000000o(this.O0000oO0);
                                System.arraycopy(O000000o3, 0, this.O0000o0o, 0, Math.min(O000000o3.length, 16));
                            }
                            byte[] bArr4 = new byte[16];
                            new SecureRandom().nextBytes(bArr4);
                            this.O000OO = bArr4;
                            byte[] bArr5 = new byte[32];
                            System.arraycopy(this.O000OO, 0, bArr5, 0, 16);
                            System.arraycopy(this.O0000o0o, 0, bArr5, 16, 16);
                            this.O000OOOo = fir.O000000o(this.O0000o0O.getEncoded(), bArr5);
                            this.O000OOo = grs.O00000Oo(bArr);
                            this.O000OOoO = grs.O00000Oo(fhc.O00000Oo(this.O0000o0O.getEncoded()));
                            if (514 == O0000o2) {
                                this.O0000o00 = O000000o(this.O0000o0O.getEncoded(), this.O0000o0o);
                            } else {
                                byte[] O00000Oo2 = O00000Oo(this.O0000o0O.getEncoded(), this.O0000o0o);
                                this.O0000o00 = new byte[32];
                                this.O000OO00 = new byte[16];
                                this.O0000o0 = new byte[16];
                                System.arraycopy(O00000Oo2, 0, this.O0000o00, 0, 32);
                                System.arraycopy(O00000Oo2, 32, this.O000OO00, 0, 16);
                                System.arraycopy(O00000Oo2, 48, this.O0000o0, 0, 16);
                            }
                            String O0000oO2 = ffr.O0000oO(O00000o0());
                            int O0000oOO2 = ffr.O0000oOO(O00000o0());
                            if (!TextUtils.isEmpty(O0000oO2) && O0000oOO2 != 0) {
                                fte.O00000Oo("BleSecurityChipRegisterConnector encryptLtmk");
                                this.O0000o00 = got.O000000o(fll.O000000o(O0000oO2, got.O00000o0(this.O0000o00), O0000oOO2));
                            }
                            return true;
                        }
                        return false;
                    }
                }
                byte[] O00000Oo3 = fir.O00000Oo(Arrays.copyOfRange(O00000o(this.O0000o0O.getEncoded()), 0, 16), new byte[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}, bArr);
                if (O00000Oo3 != null) {
                    byte[] O000000o4 = fir.O000000o(O00000o0());
                    ByteBuffer allocate = ByteBuffer.allocate(82);
                    allocate.put(this.O000O0o0);
                    allocate.put(O000000o4);
                    allocate.put(this.O00oOoOo);
                    if (fir.O000000o(allocate.array(), fir.O000000o(O00000Oo3), this.O0000Ooo.getPublicKey())) {
                        this.O000OOo = grs.O00000Oo(O00000Oo3);
                        this.O000OOoO = grs.O00000Oo(fhc.O00000Oo(allocate.array()));
                        this.O0000o00 = O00000oO(this.O0000o0O.getEncoded());
                        return true;
                    }
                    fec.O00000o().O000000o(45, "msg", "device sign is invalid");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fhj.O000000o(boolean, int):void
     arg types: [int, int]
     candidates:
      _m_j.fhj.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.fhj.O000000o(java.lang.String, java.lang.Object[]):void
      _m_j.fhj.O000000o(byte[], byte[]):byte[]
      _m_j.fhj.O000000o(byte[], int):void
      _m_j.fhd.O000000o(byte[], int):void
      _m_j.fgm.O000000o(int, boolean):void
      _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
      _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
      _m_j.fhj.O000000o(boolean, int):void */
    public final void O000000o(boolean z) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector processDeviceAuthComplete ..., isRegisterSuccess = ".concat(String.valueOf(z)));
        if (z) {
            if (O0000o() == 517) {
                O0000oO();
            } else {
                O0000oOO();
            }
        } else if (got.O00000o(this.O0000o0o)) {
            O000000o(false, -20);
        } else {
            fec.O00000o().O000000o(44, "msg", "retry input PIN-CODE");
            O000000o(false, -34);
        }
    }

    public final void O000000o(final boolean z, final int i) {
        byte[] bArr;
        byte[] bArr2;
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleSecurityChipRegisterConnector Process Step 9 ..., isRegisterSuccess = ".concat(String.valueOf(z)));
        final short O0000o2 = O0000o();
        if (257 == O0000o2) {
            if (z) {
                bArr2 = O0000oo0;
            } else {
                bArr2 = O0000oo;
            }
            byte[] bArr3 = bArr2;
            fec.O00000o().O000000o(13);
            fec.O00000o().O000000o(13, "data", got.O00000o0(bArr3));
            glw.O000000o().write(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr3, new BleWriteResponse() {
                /* class _m_j.fhj.AnonymousClass2 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    fte.O00000Oo("BleSecurityChipRegisterConnector Step 9 onResponse: " + gmc.O000000o(i));
                    if (!z) {
                        fec.O00000o().O000000o(13, "error_code", String.valueOf(i));
                        fec.O00000o().O000000o(13, "msg", "register result=False");
                        fec.O00000o().O000000o(13, 2);
                        fhj.this.O000000o(i);
                    } else if (i == 0) {
                        fec.O00000o().O00000Oo(13);
                        fhj.this.O00000oO.putByteArray("ltmk", fhj.this.O0000o00);
                        fhj.this.O000000o(0);
                    } else {
                        fec.O00000o().O000000o(13, "error_code", String.valueOf(i));
                        fec.O00000o().O000000o(13, 2);
                        fhj.this.O000000o(-28);
                    }
                }
            });
            return;
        }
        if (z) {
            bArr = O00oOooO;
        } else {
            byte[] bArr4 = O00oOooo;
            this.O000OOo0 = i;
            bArr = bArr4;
        }
        fec.O00000o().O000000o(13);
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr, new BleWriteResponse() {
            /* class _m_j.fhj.AnonymousClass3 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleSecurityChipRegisterConnector Step 9 onResponse: " + gmc.O000000o(i));
                if (z) {
                    fhj fhj = fhj.this;
                    if (517 == O0000o2 && !fhj.O000000o(fhj.O0000oOo, 0, new BleSecurityChipRegisterConnector$12(fhj))) {
                        fhj.O000000o("writeEncryptData fail", new Object[0]);
                        fhj.O0000o0o();
                        fhj.O000000o(-28);
                    }
                }
            }
        });
        fec.O00000o().O00000Oo(13);
        fec.O00000o().O000000o(14);
        this.O0000OOo.removeMessages(4098);
        this.O0000OOo.sendEmptyMessageDelayed(4098, 15000);
    }
}
