package _m_j;

import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshRegisterConnector$12;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.BleMeshRegisterConnector$5;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleWriteResponse;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fhc extends fhd {
    public static final byte[] O0000Oo = {71, 0, 0, 0};
    public static final byte[] O0000Oo0 = {66, 0, 0, 0};
    public static final byte[] O0000OoO = {73, 0, 0, 0};
    private static final byte[] O000O00o = {67, 0, 0, 0};
    private static final byte[] O000O0OO = {68, 0, 0, 0};
    private static final byte[] O000O0Oo = {69, 0, 0, 0};
    private static final byte[] O000O0o = {-31, 0, 0, 0};
    private static final byte[] O000O0o0 = {72, 0, 0, 0};
    private static final byte[] O00oOoOo = {70, 0, 0, 0};
    private static final byte[] O00oOooO = {64, 0, 0, 0};
    private static final byte[] O00oOooo = {65, 0, 0, 0};
    public byte[] O0000Ooo;
    public int O0000o = 0;
    public String O0000o0;
    public String O0000o00;
    public String O0000o0O;
    public String O0000o0o;
    public int O0000oO;
    public String O0000oO0;
    public byte[] O0000oOO;
    public byte[] O0000oOo;
    public int O0000oo = -7;
    public Map<Integer, List<Integer>> O0000oo0 = new LinkedHashMap();
    private byte[] O000O0oO;
    private byte[] O000O0oo;
    private byte[] O000OO;
    private byte[] O000OO00;
    private byte[] O000OO0o;

    public final byte[] O0000Oo0() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean O0000OoO() {
        return true;
    }

    protected fhc(fgp fgp) {
        super(fgp);
    }

    public final void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (!uuid.equals(glb.f17954O000000o) || !uuid2.equals(glb.O0000OOo)) {
            if (uuid.equals(glb.f17954O000000o) && uuid2.equals(glb.O0000o0)) {
                super.O000000o(uuid, uuid2, bArr);
            }
        } else if (this.O00000Oo) {
            O000000o(-2);
        } else {
            fte.O00000Oo("BleMeshRegisterConnector Process Step 10 ..., value = " + got.O00000o0(bArr));
            fec.O00000o().O000000o(14, "data", got.O00000o0(bArr));
            this.O0000OOo.removeMessages(4101);
            if (got.O00000Oo(bArr, O00oOooo)) {
                fec.O00000o().O000000o(14, 0);
                String lowerCase = got.O00000o0(O00000Oo(got.O000000o(this.O0000oO0))).toLowerCase();
                fec.O00000o().O000000o(36);
                String str = this.O0000o0o;
                String O00000o0 = got.O00000o0(this.O000OO);
                String substring = lowerCase.substring(0, 32);
                AnonymousClass5 r2 = new feo<Boolean, fes>() {
                    /* class _m_j.fhc.AnonymousClass5 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        if (((Boolean) obj).booleanValue()) {
                            fec.O00000o().O00000Oo(36);
                            fhc.this.O000000o(0);
                            return;
                        }
                        fec.O00000o().O000000o(36, 11);
                        fhc.this.O000000o(-45);
                    }

                    public final void O000000o(fes fes) {
                        if (fes != null) {
                            fec.O00000o().O000000o(36, "msg", fes.toString());
                        }
                        fec.O00000o().O000000o(36, 11);
                        fhc.this.O000000o(-45);
                    }
                };
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", 0);
                    jSONObject.put("did", str);
                    jSONObject.put("device_key", O00000o0);
                    jSONObject.put("auth", substring);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
                gnk.O00000o0(String.format("sendBleMeshProvisionResult: [%s]", jSONObject));
                BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
                o000000o.f6799O000000o = "POST";
                o000000o.O00000Oo = "/v2/blemesh/provision_done";
                o000000o.O00000o0 = arrayList;
                fec.O00000o0().O000000o(o000000o.O000000o(), new fer(new feq<Boolean>() {
                    /* class _m_j.fgo.AnonymousClass16 */

                    public final /* synthetic */ Object O000000o(JSONObject jSONObject) {
                        boolean z = true;
                        gnk.O00000o0(String.format("sendBleMeshProvisionResult Http Response: [%S]", jSONObject));
                        if (jSONObject.optInt("code", -1) != 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }, r2) {
                    /* class _m_j.fgo.AnonymousClass17 */

                    /* renamed from: O000000o */
                    final /* synthetic */ feq f16281O000000o;
                    final /* synthetic */ feo O00000Oo;

                    {
                        this.f16281O000000o = r1;
                        this.O00000Oo = r2;
                    }

                    public final void O000000o(String str) {
                        fet.O000000o().O000000o(str, this.f16281O000000o, this.O00000Oo);
                    }

                    public final void O000000o(int i, String str) {
                        fte.O00000Oo("sendBleMeshProvisionResult failed = ".concat(String.valueOf(str)));
                        feo feo = this.O00000Oo;
                        if (feo != null) {
                            feo.O000000o(new fes(i, str));
                        }
                    }
                });
            } else if (got.O00000Oo(bArr, O000O0OO)) {
                fec.O00000o().O000000o(14, 13);
                O000000o(-41);
            } else if (got.O00000Oo(bArr, O00oOoOo)) {
                fec.O00000o().O000000o(14, 13);
                O000000o(-42);
            } else if (got.O00000Oo(bArr, O000O0Oo)) {
                fec.O00000o().O000000o(14, 13);
                O000000o(-43);
            } else if (got.O00000Oo(bArr, O000O0o)) {
                fec.O00000o().O000000o(14, 13);
                O000000o(-17);
            }
        }
    }

    private int O0000o0o() {
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> value : this.O0000oo0.entrySet()) {
            i += ((List) value.getValue()).size();
        }
        return i;
    }

    public final void O0000o0O() {
        ByteBuffer order = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        this.O000OO = bArr;
        order.put((byte) 1);
        order.put((byte) 16);
        order.put(this.O000OO);
        order.put((byte) 2);
        order.put((byte) 25);
        order.put(this.O0000oOO);
        order.putShort(0);
        order.put((byte) 0);
        order.putInt(this.O0000o);
        order.putShort((short) this.O0000oO);
        order.put((byte) 3);
        order.put((byte) 20);
        order.putShort(0);
        order.putShort(0);
        order.put(this.O0000oOo);
        order.put((byte) 4);
        int O0000o0o2 = O0000o0o();
        order.put((byte) (O0000o0o2 * 8));
        if (O0000o0o2 != 0) {
            for (Map.Entry next : this.O0000oo0.entrySet()) {
                Integer num = (Integer) next.getKey();
                for (Integer num2 : (List) next.getValue()) {
                    order.putShort(num.shortValue());
                    Integer valueOf = Integer.valueOf(num2.intValue() >> 16);
                    Integer valueOf2 = Integer.valueOf(num2.intValue() & 65535);
                    order.putShort(valueOf.shortValue());
                    order.putShort(valueOf2.shortValue());
                    order.putShort(0);
                }
            }
        }
        byte[] bArr2 = new byte[order.position()];
        System.arraycopy(order.array(), 0, bArr2, 0, bArr2.length);
        byte[] O000000o2 = got.O000000o(this.O0000oO0);
        byte[] bArr3 = new byte[8];
        System.arraycopy(O000000o2, 0, bArr3, 0, 8);
        byte[] O000000o3 = fir.O000000o(O000000o2, bArr3, bArr2);
        fec.O00000o().O000000o(35);
        if (!O000000o(O000000o3, 9, new BleMeshRegisterConnector$12(this))) {
            fec.O00000o().O000000o(35, 2);
            O000000o(-28);
        }
    }

    public final void O000000o(Message message) {
        if (message.what == 4101) {
            fte.O00000Oo("BleMeshRegisterConnector notify timeout");
            fec.O00000o().O000000o();
            O000000o(this.O0000oo);
        }
    }

    public static byte[] O00000Oo(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(byte[] bArr, int i) {
        if (this.O00000Oo) {
            O000000o(-2);
        } else if (i == 1) {
            fte.O00000Oo("BleMeshRegisterConnector Process recvDeviceCert ...");
            this.O000OO0o = Arrays.copyOf(bArr, bArr.length);
            fec.O00000o().O000000o(24, "data", got.O00000o0(bArr));
            fec.O00000o().O000000o(24, 0);
            this.O0000OOo.removeMessages(4101);
            fec.O00000o().O000000o(17);
            this.O0000OOo.sendEmptyMessageDelayed(4101, 15000);
        } else if (i == 3) {
            fte.O00000Oo("BleMeshRegisterConnector Process recvDevicePub ...");
            fec.O00000o().O000000o(17, "data", got.O00000o0(bArr));
            fec.O00000o().O000000o(17, 0);
            this.O000O0oo = Arrays.copyOfRange(bArr, 0, 12);
            this.O000OO00 = Arrays.copyOfRange(bArr, 12, 20);
            this.O000O0oO = Arrays.copyOfRange(bArr, 20, 84);
            this.O0000OOo.removeMessages(4101);
            int O0000O0o = ffr.O0000O0o(O00000o0());
            String O00000Oo = grs.O00000Oo(this.O000OO0o);
            String O00000Oo2 = grs.O00000Oo(this.O000O0oO);
            fec.O00000o().O000000o(25);
            String O00000Oo3 = got.O00000Oo(this.O000OO00);
            String O00000o0 = got.O00000o0(this.O000O0oo);
            AnonymousClass8 r9 = new feo<String, fes>() {
                /* class _m_j.fhc.AnonymousClass8 */

                public final /* synthetic */ void O000000o(Object obj) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) obj);
                        fhc.this.O0000o0O = jSONObject.optString("sign");
                        fhc.this.O0000o0 = jSONObject.optString("pub");
                        fhc.this.O0000o00 = jSONObject.optString("server_cert");
                        jSONObject.optString("code");
                        fhc.this.O0000o0o = jSONObject.optString("did");
                        if (!TextUtils.isEmpty(fhc.this.O0000o0O) && !TextUtils.isEmpty(fhc.this.O0000o0) && !TextUtils.isEmpty(fhc.this.O0000o00)) {
                            if (!TextUtils.isEmpty(fhc.this.O0000o0o)) {
                                fec.O00000o().O00000Oo(25);
                                fhc fhc = fhc.this;
                                fec.O00000o().O000000o(26);
                                if (!fhc.O000000o(grs.O000000o(fhc.O0000o00, 24), 7, new BleMeshRegisterConnector$5(fhc))) {
                                    fec.O00000o().O000000o(26, 2);
                                    fhc.O000000o(-28);
                                    return;
                                }
                                return;
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("sign", fhc.this.O0000o0O);
                        hashMap.put("pub", fhc.this.O0000o0);
                        hashMap.put("server_cert", fhc.this.O0000o00);
                        hashMap.put("did", fhc.this.O0000o0o);
                        fec.O00000o().O000000o(hashMap);
                        fhc.this.O0000oo = -39;
                        fhc.this.O000000o(fhc.O0000Oo);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public final void O000000o(fes fes) {
                    fhc.this.O0000oo = -39;
                    if (fes != null) {
                        fec.O00000o().O000000o(26, "msg", fes.toString());
                    }
                    fec.O00000o().O000000o(26, 11);
                    fhc.this.O000000o(fhc.O0000Oo);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pdid", O0000O0o);
                jSONObject.put("dev_mesh_pub", O00000Oo2);
                jSONObject.put("manu_cert_id", O00000Oo3);
                jSONObject.put("dev_cert", O00000Oo);
                jSONObject.put("dev_info", O00000o0);
                jSONObject.put("code", "123456");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
            gnk.O00000o0(String.format("authBleMesh: [%s]", jSONObject));
            BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
            o000000o.f6799O000000o = "POST";
            o000000o.O00000Oo = "/v2/blemesh/auth";
            o000000o.O00000o0 = arrayList;
            fec.O00000o0().O000000o(o000000o.O000000o(), new fer(new feq<String>() {
                /* class _m_j.fgo.AnonymousClass7 */

                public final /* synthetic */ Object O000000o(JSONObject jSONObject) {
                    gnk.O00000o0(String.format("authBleMesh Http Response: [%S]", jSONObject));
                    return jSONObject.toString();
                }
            }, r9) {
                /* class _m_j.fgo.AnonymousClass8 */

                /* renamed from: O000000o */
                final /* synthetic */ feq f16297O000000o;
                final /* synthetic */ feo O00000Oo;

                {
                    this.f16297O000000o = r1;
                    this.O00000Oo = r2;
                }

                public final void O000000o(String str) {
                    fet.O000000o().O000000o(str, this.f16297O000000o, this.O00000Oo);
                }

                public final void O000000o(int i, String str) {
                    feo feo = this.O00000Oo;
                    if (feo != null) {
                        feo.O000000o(new fes(i, str));
                    }
                }
            });
        } else if (i == 4) {
            fte.O00000Oo("BleMeshRegisterConnector Process recvDeviceSign ...");
            this.O0000OOo.removeMessages(4101);
            fec.O00000o().O000000o(29, "data", got.O00000o0(bArr));
            fec.O00000o().O00000Oo(29);
            int O0000O0o2 = ffr.O0000O0o(O00000o0());
            String O00000Oo4 = grs.O00000Oo(bArr);
            fec.O00000o().O000000o(30);
            long j = (long) O0000O0o2;
            String O00000o02 = O00000o0();
            String str = this.O0000o0o;
            AnonymousClass9 r5 = new feo<String, fes>() {
                /* class _m_j.fhc.AnonymousClass9 */

                public final /* synthetic */ void O000000o(Object obj) {
                    String str = (String) obj;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        fhc.this.O0000oO0 = jSONObject.optString("static_oob");
                        String optString = jSONObject.optString("gatt_ltmk");
                        fhc.this.O0000oO = jSONObject.optInt("address");
                        JSONObject optJSONObject = jSONObject.optJSONObject("appkey");
                        if (optJSONObject != null) {
                            optJSONObject.optString("key");
                            optJSONObject.optString("appkey_id");
                        }
                        if (TextUtils.isEmpty(optString)) {
                            fec.O00000o().O000000o(30, "msg", "gatt LTMK is empty");
                            fec.O00000o().O000000o(30, 11);
                            fhc.this.O0000oo = -40;
                            fhc.this.O000000o(fhc.O0000OoO);
                            return;
                        }
                        ffr.O0000o0(fhc.this.O00000o0(), str);
                        fec.O00000o().O00000Oo(30);
                        fhc.this.O0000Ooo = grs.O000000o(optString, 24);
                        fhc.this.O0000o0();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public final void O000000o(fes fes) {
                    fhc.this.O0000oo = -40;
                    if (fes != null) {
                        fec.O00000o().O000000o(30, "msg", fes.toString());
                    }
                    fec.O00000o().O000000o(30, 11);
                    fhc.this.O000000o(fhc.O0000OoO);
                }
            };
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("pdid", j);
                jSONObject2.put("mac", O00000o02);
                jSONObject2.put("sign", O00000Oo4);
                jSONObject2.put("did", str);
                jSONObject2.put("token", "");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new BleKeyValuePair("data", jSONObject2.toString()));
            gnk.O00000o0(String.format("bindBleMesh: [%s]", jSONObject2));
            BleNetRequest.O000000o o000000o2 = new BleNetRequest.O000000o();
            o000000o2.f6799O000000o = "POST";
            o000000o2.O00000Oo = "/v2/blemesh/bind";
            o000000o2.O00000o0 = arrayList2;
            fec.O00000o0().O000000o(o000000o2.O000000o(), new fer(new feq<String>() {
                /* class _m_j.fgo.AnonymousClass9 */

                public final /* synthetic */ Object O000000o(JSONObject jSONObject) {
                    gnk.O00000o0(String.format("bindBleMesh Http Response: [%S]", jSONObject));
                    return jSONObject.toString();
                }
            }, r5) {
                /* class _m_j.fgo.AnonymousClass10 */

                /* renamed from: O000000o */
                final /* synthetic */ feq f16277O000000o;
                final /* synthetic */ feo O00000Oo;

                {
                    this.f16277O000000o = r1;
                    this.O00000Oo = r2;
                }

                public final void O000000o(String str) {
                    fet.O000000o().O000000o(str, this.f16277O000000o, this.O00000Oo);
                }

                public final void O000000o(int i, String str) {
                    feo feo = this.O00000Oo;
                    if (feo != null) {
                        feo.O000000o(new fes(i, str));
                    }
                }
            });
        }
    }

    public final void O0000Oo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshRegisterConnector Process Step 1 ...");
        ffr.O00000o(O00000o0(), "".getBytes());
        O00000Oo(new BleNotifyResponse() {
            /* class _m_j.fhc.AnonymousClass1 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshRegisterConnector Step 1 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhc.this.O0000Ooo();
                } else {
                    fhc.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000Ooo() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshRegisterConnector Process Step 1 plus ...");
        O000000o(new BleNotifyResponse() {
            /* class _m_j.fhc.AnonymousClass6 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshRegisterConnector Step 1 plus onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhc.this.O0000o00();
                } else {
                    fhc.this.O000000o(-27);
                }
            }
        });
    }

    public final void O0000o00() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fte.O00000Oo("BleMeshRegisterConnector Process Step 2 ...");
        fec.O00000o().O000000o(4);
        fec.O00000o().O000000o(4, "char", glb.O0000OOo.toString());
        fec.O00000o().O000000o(4, "data", got.O00000o0(O00oOooO));
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, O00oOooO, new BleWriteResponse() {
            /* class _m_j.fhc.AnonymousClass7 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshRegisterConnector Step 2 onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fhc.this.O0000OOo.removeMessages(4101);
                    fec.O00000o().O000000o(24);
                    fhc.this.O0000OOo.sendEmptyMessageDelayed(4101, 15000);
                    return;
                }
                fhc.this.O000000o(-28);
            }
        });
    }

    public final void O0000o0() {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fec.O00000o().O000000o(13);
        fec.O00000o().O000000o(13, "char", glb.O0000OOo.toString());
        fec.O00000o().O000000o(13, "data", got.O00000o0(O000O00o));
        fte.O00000Oo("BleMeshRegisterConnector, sendRegVerifySuccessToDevice");
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, O000O00o, new BleWriteResponse() {
            /* class _m_j.fhc.AnonymousClass10 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshRegisterConnector sendRegVerifySuccessToDevice onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fec.O00000o().O00000Oo(13);
                    fhc fhc = fhc.this;
                    fec.O00000o().O000000o(31);
                    AnonymousClass2 r5 = new feo<String, fes>() {
                        /* class _m_j.fhc.AnonymousClass2 */

                        public final /* synthetic */ void O000000o(Object obj) {
                            try {
                                JSONObject jSONObject = new JSONObject((String) obj);
                                try {
                                    String optString = jSONObject.optString("iv_index");
                                    fhc.this.O0000o = Integer.parseInt(optString, 16);
                                } catch (NumberFormatException e) {
                                    e.printStackTrace();
                                }
                                JSONObject optJSONObject = jSONObject.optJSONObject("primary_netkey");
                                if (optJSONObject != null) {
                                    fhc.this.O0000oOO = got.O000000o(optJSONObject.optString("key"));
                                }
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("ctl_appkey");
                                if (optJSONObject2 != null) {
                                    fhc.this.O0000oOo = got.O000000o(optJSONObject2.optString("key"));
                                }
                                if (fhc.this.O0000oOO == null || fhc.this.O0000oOo == null) {
                                    fec.O00000o().O000000o(31, "netKey", got.O00000o0(fhc.this.O0000oOO));
                                    fec.O00000o().O000000o(31, "appKey", got.O00000o0(fhc.this.O0000oOo));
                                    fec.O00000o().O000000o(31, 11);
                                    fhc.this.O0000oo = -44;
                                    fhc.this.O000000o(fhc.O0000Oo0);
                                    return;
                                }
                                fec.O00000o().O00000Oo(31);
                                fhc fhc = fhc.this;
                                int O0000O0o = ffr.O0000O0o(fhc.O00000o0());
                                fec.O00000o().O000000o(34);
                                AnonymousClass3 r1 = new feo<String, fes>() {
                                    /* class _m_j.fhc.AnonymousClass3 */

                                    public final /* synthetic */ void O000000o(Object obj) {
                                        String str = (String) obj;
                                        try {
                                            JSONArray optJSONArray = new JSONObject(str).optJSONArray("elements");
                                            if (optJSONArray != null) {
                                                for (int i = 0; i < optJSONArray.length(); i++) {
                                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                                    if (optJSONObject != null) {
                                                        int optInt = optJSONObject.optInt("num");
                                                        ArrayList arrayList = new ArrayList();
                                                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("model_id");
                                                        if (optJSONArray2 != null) {
                                                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                                                try {
                                                                    arrayList.add(Integer.valueOf(Integer.parseInt(optJSONArray2.optString(i2), 16)));
                                                                } catch (NumberFormatException e) {
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        fhc.this.O0000oo0.put(Integer.valueOf(optInt), arrayList);
                                                    }
                                                }
                                            }
                                            if (fhc.this.O0000oo0 != null) {
                                                fec.O00000o().O00000Oo(34);
                                                fhc.this.O0000o0O();
                                                return;
                                            }
                                            fec.O00000o().O000000o(34, "msg", str);
                                            fec.O00000o().O000000o(34, 11);
                                            fhc.this.O0000oo = -44;
                                            fhc.this.O000000o(fhc.O0000Oo0);
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }

                                    public final void O000000o(fes fes) {
                                        fhc.this.O0000oo = -44;
                                        if (fes != null) {
                                            fec.O00000o().O000000o(34, "msg", fes.toString());
                                        }
                                        fec.O00000o().O000000o(34, 11);
                                        fhc.this.O000000o(fhc.O0000Oo0);
                                    }
                                };
                                ArrayList arrayList = new ArrayList();
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("pdid", O0000O0o);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                arrayList.add(new BleKeyValuePair("data", jSONObject2.toString()));
                                BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
                                o000000o.f6799O000000o = "POST";
                                o000000o.O00000Oo = "/v2/blemesh/query_model";
                                o000000o.O00000o0 = arrayList;
                                fec.O00000o0().O000000o(o000000o.O000000o(), new fer(new feq<String>() {
                                    /* class _m_j.fgo.AnonymousClass14 */

                                    public final /* synthetic */ Object O000000o(JSONObject jSONObject) {
                                        gnk.O00000o0(String.format("queryBleMeshModelInfo Http Response: [%S]", jSONObject));
                                        return jSONObject.toString();
                                    }
                                }, r1) {
                                    /* class _m_j.fgo.AnonymousClass15 */

                                    /* renamed from: O000000o */
                                    final /* synthetic */ feq f16280O000000o;
                                    final /* synthetic */ feo O00000Oo;

                                    {
                                        this.f16280O000000o = r1;
                                        this.O00000Oo = r2;
                                    }

                                    public final void O000000o(String str) {
                                        fet.O000000o().O000000o(str, this.f16280O000000o, this.O00000Oo);
                                    }

                                    public final void O000000o(int i, String str) {
                                        feo feo = this.O00000Oo;
                                        if (feo != null) {
                                            feo.O000000o(new fes(i, str));
                                        }
                                    }
                                });
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }

                        public final void O000000o(fes fes) {
                            fhc.this.O0000oo = -44;
                            if (fes != null) {
                                fec.O00000o().O000000o(31, "msg", fes.toString());
                            }
                            fec.O00000o().O000000o(31, 11);
                            fhc.this.O000000o(fhc.O0000Oo0);
                        }
                    };
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BleKeyValuePair("data", new JSONObject().toString()));
                    BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
                    o000000o.f6799O000000o = "POST";
                    o000000o.O00000Oo = "/v2/blemesh/ctl_info";
                    o000000o.O00000o0 = arrayList;
                    fec.O00000o0().O000000o(o000000o.O000000o(), new fer(new feq<String>() {
                        /* class _m_j.fgo.AnonymousClass11 */

                        public final /* synthetic */ Object O000000o(JSONObject jSONObject) {
                            gnk.O00000o0(String.format("queryBleMeshCtlInfo Http Response: [%S]", jSONObject));
                            return jSONObject.toString();
                        }
                    }, r5) {
                        /* class _m_j.fgo.AnonymousClass13 */

                        /* renamed from: O000000o */
                        final /* synthetic */ feq f16279O000000o;
                        final /* synthetic */ feo O00000Oo;

                        {
                            this.f16279O000000o = r1;
                            this.O00000Oo = r2;
                        }

                        public final void O000000o(String str) {
                            fet.O000000o().O000000o(str, this.f16279O000000o, this.O00000Oo);
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
                fec.O00000o().O000000o(13, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(13, 2);
                fhc.this.O000000o(-28);
            }
        });
    }

    public final void O000000o(byte[] bArr) {
        if (this.O00000Oo) {
            O000000o(-2);
            return;
        }
        fec.O00000o().O000000o(13);
        fec.O00000o().O000000o(13, "data", got.O00000o0(bArr));
        fte.O00000Oo("BleMeshRegisterConnector, sendErrorCodeToDevice errorCode = " + got.O00000o0(bArr));
        glw.O000000o().writeNoRsp(O00000o0(), glb.f17954O000000o, glb.O0000OOo, bArr, new BleWriteResponse() {
            /* class _m_j.fhc.AnonymousClass4 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                fte.O00000Oo("BleMeshRegisterConnector sendErrorCodeToDevice onResponse: " + gmc.O000000o(i));
                if (i == 0) {
                    fec.O00000o().O00000Oo(13);
                    fhc.this.O0000OOo.removeMessages(4101);
                    fec.O00000o().O000000o(14);
                    fhc.this.O0000OOo.sendEmptyMessageDelayed(4101, 15000);
                    return;
                }
                fec.O00000o().O000000o(13, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(13, 2);
                fhc.this.O000000o(-28);
            }
        });
    }
}
