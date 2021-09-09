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

                    public final /* synthetic */ Object O000000o(JSONObject jSONObject) throws JSONException {
                        boolean z = true;
                        gnk.O00000o0(String.format("sendBleMeshProvisionResult Http Response: [%S]", jSONObject));
                        if (jSONObject.optInt("code", -1) != 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }, r2) {
                    /* class _m_j.fgo.AnonymousClass17 */

                    /* renamed from: O000000o  reason: collision with root package name */
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
            fec.O00000o0().O000000o(o000000o.O000000o(), 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0189: INVOKE  
                  (wrap: _m_j.fej : 0x0180: INVOKE  (r0v10 _m_j.fej) =  type: STATIC call: _m_j.fec.O00000o0():_m_j.fej)
                  (wrap: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest : 0x0177: INVOKE  (r12v11 com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest) = (r13v16 'o000000o' com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o) type: VIRTUAL call: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest.O000000o.O000000o():com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest)
                  (wrap: _m_j.fgo$8 : 0x0186: CONSTRUCTOR  (r1v2 _m_j.fgo$8) = 
                  (wrap: _m_j.fgo$7 : 0x017d: CONSTRUCTOR  (r13v17 _m_j.fgo$7) =  call: _m_j.fgo.7.<init>():void type: CONSTRUCTOR)
                  (r9v0 'r9' _m_j.fhc$8)
                 call: _m_j.fgo.8.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR)
                 type: INTERFACE call: _m_j.fej.O000000o(com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest, _m_j.fer):void in method: _m_j.fhc.O000000o(byte[], int):void, dex: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0186: CONSTRUCTOR  (r1v2 _m_j.fgo$8) = 
                  (wrap: _m_j.fgo$7 : 0x017d: CONSTRUCTOR  (r13v17 _m_j.fgo$7) =  call: _m_j.fgo.7.<init>():void type: CONSTRUCTOR)
                  (r9v0 'r9' _m_j.fhc$8)
                 call: _m_j.fgo.8.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR in method: _m_j.fhc.O000000o(byte[], int):void, dex: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 40 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.fgo, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 46 more
                */
            /*
                this = this;
                boolean r0 = r11.O00000Oo
                if (r0 == 0) goto L_0x0009
                r12 = -2
                r11.O000000o(r12)
                return
            L_0x0009:
                r0 = 17
                r1 = 1
                r2 = 4101(0x1005, float:5.747E-42)
                r3 = 0
                java.lang.String r4 = "data"
                if (r13 == r1) goto L_0x018d
                r5 = 3
                java.lang.String r6 = "POST"
                java.lang.String r7 = "pdid"
                if (r13 == r5) goto L_0x00c2
                r0 = 4
                if (r13 == r0) goto L_0x001f
                goto L_0x00c1
            L_0x001f:
                java.lang.String r13 = "BleMeshRegisterConnector Process recvDeviceSign ..."
                _m_j.fte.O00000Oo(r13)
                android.os.Handler r13 = r11.O0000OOo
                r13.removeMessages(r2)
                _m_j.hmh r13 = _m_j.fec.O00000o()
                java.lang.String r0 = _m_j.got.O00000o0(r12)
                r2 = 29
                r13.O000000o(r2, r4, r0)
                _m_j.hmh r13 = _m_j.fec.O00000o()
                r13.O00000Oo(r2)
                java.lang.String r13 = r11.O00000o0()
                int r13 = _m_j.ffr.O0000O0o(r13)
                java.lang.String r12 = _m_j.grs.O00000Oo(r12)
                _m_j.hmh r0 = _m_j.fec.O00000o()
                r2 = 30
                r0.O000000o(r2)
                long r8 = (long) r13
                java.lang.String r13 = r11.O00000o0()
                java.lang.String r0 = r11.O0000o0o
                java.lang.String r2 = ""
                _m_j.fhc$9 r5 = new _m_j.fhc$9
                r5.<init>()
                org.json.JSONObject r10 = new org.json.JSONObject
                r10.<init>()
                r10.put(r7, r8)     // Catch:{ JSONException -> 0x007d }
                java.lang.String r7 = "mac"
                r10.put(r7, r13)     // Catch:{ JSONException -> 0x007d }
                java.lang.String r13 = "sign"
                r10.put(r13, r12)     // Catch:{ JSONException -> 0x007d }
                java.lang.String r12 = "did"
                r10.put(r12, r0)     // Catch:{ JSONException -> 0x007d }
                java.lang.String r12 = "token"
                r10.put(r12, r2)     // Catch:{ JSONException -> 0x007d }
                goto L_0x0081
            L_0x007d:
                r12 = move-exception
                r12.printStackTrace()
            L_0x0081:
                java.util.ArrayList r12 = new java.util.ArrayList
                r12.<init>()
                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair r13 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair
                java.lang.String r0 = r10.toString()
                r13.<init>(r4, r0)
                r12.add(r13)
                java.lang.Object[] r13 = new java.lang.Object[r1]
                r13[r3] = r10
                java.lang.String r0 = "bindBleMesh: [%s]"
                java.lang.String r13 = java.lang.String.format(r0, r13)
                _m_j.gnk.O00000o0(r13)
                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o r13 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o
                r13.<init>()
                r13.f6799O000000o = r6
                java.lang.String r0 = "/v2/blemesh/bind"
                r13.O00000Oo = r0
                r13.O00000o0 = r12
                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest r12 = r13.O000000o()
                _m_j.fgo$9 r13 = new _m_j.fgo$9
                r13.<init>()
                _m_j.fej r0 = _m_j.fec.O00000o0()
                _m_j.fgo$10 r1 = new _m_j.fgo$10
                r1.<init>(r13, r5)
                r0.O000000o(r12, r1)
            L_0x00c1:
                return
            L_0x00c2:
                java.lang.String r13 = "BleMeshRegisterConnector Process recvDevicePub ..."
                _m_j.fte.O00000Oo(r13)
                _m_j.hmh r13 = _m_j.fec.O00000o()
                java.lang.String r5 = _m_j.got.O00000o0(r12)
                r13.O000000o(r0, r4, r5)
                _m_j.hmh r13 = _m_j.fec.O00000o()
                r13.O000000o(r0, r3)
                r13 = 12
                byte[] r0 = java.util.Arrays.copyOfRange(r12, r3, r13)
                r11.O000O0oo = r0
                r0 = 20
                byte[] r13 = java.util.Arrays.copyOfRange(r12, r13, r0)
                r11.O000OO00 = r13
                r13 = 84
                byte[] r12 = java.util.Arrays.copyOfRange(r12, r0, r13)
                r11.O000O0oO = r12
                android.os.Handler r12 = r11.O0000OOo
                r12.removeMessages(r2)
                java.lang.String r12 = r11.O00000o0()
                int r12 = _m_j.ffr.O0000O0o(r12)
                byte[] r13 = r11.O000OO0o
                java.lang.String r13 = _m_j.grs.O00000Oo(r13)
                byte[] r0 = r11.O000O0oO
                java.lang.String r0 = _m_j.grs.O00000Oo(r0)
                java.lang.String r2 = "123456"
                _m_j.hmh r5 = _m_j.fec.O00000o()
                r8 = 25
                r5.O000000o(r8)
                byte[] r5 = r11.O000OO00
                java.lang.String r5 = _m_j.got.O00000Oo(r5)
                byte[] r8 = r11.O000O0oo
                java.lang.String r8 = _m_j.got.O00000o0(r8)
                _m_j.fhc$8 r9 = new _m_j.fhc$8
                r9.<init>()
                org.json.JSONObject r10 = new org.json.JSONObject
                r10.<init>()
                r10.put(r7, r12)     // Catch:{ JSONException -> 0x0148 }
                java.lang.String r12 = "dev_mesh_pub"
                r10.put(r12, r0)     // Catch:{ JSONException -> 0x0148 }
                java.lang.String r12 = "manu_cert_id"
                r10.put(r12, r5)     // Catch:{ JSONException -> 0x0148 }
                java.lang.String r12 = "dev_cert"
                r10.put(r12, r13)     // Catch:{ JSONException -> 0x0148 }
                java.lang.String r12 = "dev_info"
                r10.put(r12, r8)     // Catch:{ JSONException -> 0x0148 }
                java.lang.String r12 = "code"
                r10.put(r12, r2)     // Catch:{ JSONException -> 0x0148 }
                goto L_0x014c
            L_0x0148:
                r12 = move-exception
                r12.printStackTrace()
            L_0x014c:
                java.util.ArrayList r12 = new java.util.ArrayList
                r12.<init>()
                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair r13 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair
                java.lang.String r0 = r10.toString()
                r13.<init>(r4, r0)
                r12.add(r13)
                java.lang.Object[] r13 = new java.lang.Object[r1]
                r13[r3] = r10
                java.lang.String r0 = "authBleMesh: [%s]"
                java.lang.String r13 = java.lang.String.format(r0, r13)
                _m_j.gnk.O00000o0(r13)
                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o r13 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o
                r13.<init>()
                r13.f6799O000000o = r6
                java.lang.String r0 = "/v2/blemesh/auth"
                r13.O00000Oo = r0
                r13.O00000o0 = r12
                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest r12 = r13.O000000o()
                _m_j.fgo$7 r13 = new _m_j.fgo$7
                r13.<init>()
                _m_j.fej r0 = _m_j.fec.O00000o0()
                _m_j.fgo$8 r1 = new _m_j.fgo$8
                r1.<init>(r13, r9)
                r0.O000000o(r12, r1)
                return
            L_0x018d:
                java.lang.String r13 = "BleMeshRegisterConnector Process recvDeviceCert ..."
                _m_j.fte.O00000Oo(r13)
                int r13 = r12.length
                byte[] r13 = java.util.Arrays.copyOf(r12, r13)
                r11.O000OO0o = r13
                _m_j.hmh r13 = _m_j.fec.O00000o()
                java.lang.String r12 = _m_j.got.O00000o0(r12)
                r1 = 24
                r13.O000000o(r1, r4, r12)
                _m_j.hmh r12 = _m_j.fec.O00000o()
                r12.O000000o(r1, r3)
                android.os.Handler r12 = r11.O0000OOo
                r12.removeMessages(r2)
                _m_j.hmh r12 = _m_j.fec.O00000o()
                r12.O000000o(r0)
                android.os.Handler r12 = r11.O0000OOo
                r0 = 15000(0x3a98, double:7.411E-320)
                r12.sendEmptyMessageDelayed(r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.fhc.O000000o(byte[], int):void");
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
                                    fec.O00000o0().O000000o(o000000o.O000000o(), 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b6: INVOKE  
                                          (wrap: _m_j.fej : 0x00ad: INVOKE  (r2v11 _m_j.fej) =  type: STATIC call: _m_j.fec.O00000o0():_m_j.fej)
                                          (wrap: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest : 0x00a4: INVOKE  (r5v20 com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest) = (r0v7 'o000000o' com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o) type: VIRTUAL call: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest.O000000o.O000000o():com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest)
                                          (wrap: _m_j.fgo$15 : 0x00b3: CONSTRUCTOR  (r3v2 _m_j.fgo$15) = 
                                          (wrap: _m_j.fgo$14 : 0x00aa: CONSTRUCTOR  (r0v8 _m_j.fgo$14) =  call: _m_j.fgo.14.<init>():void type: CONSTRUCTOR)
                                          (r1v5 'r1' _m_j.fhc$3)
                                         call: _m_j.fgo.15.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR)
                                         type: INTERFACE call: _m_j.fej.O000000o(com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest, _m_j.fer):void in method: _m_j.fhc.2.O000000o(java.lang.Object):void, dex: classes7.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b3: CONSTRUCTOR  (r3v2 _m_j.fgo$15) = 
                                          (wrap: _m_j.fgo$14 : 0x00aa: CONSTRUCTOR  (r0v8 _m_j.fgo$14) =  call: _m_j.fgo.14.<init>():void type: CONSTRUCTOR)
                                          (r1v5 'r1' _m_j.fhc$3)
                                         call: _m_j.fgo.15.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR in method: _m_j.fhc.2.O000000o(java.lang.Object):void, dex: classes7.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 109 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.fgo, state: PROCESS_STARTED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 115 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r5 = (java.lang.String) r5
                                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f3 }
                                        r0.<init>(r5)     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r5 = "iv_index"
                                        java.lang.String r5 = r0.optString(r5)     // Catch:{ NumberFormatException -> 0x0018 }
                                        _m_j.fhc r1 = _m_j.fhc.this     // Catch:{ NumberFormatException -> 0x0018 }
                                        r2 = 16
                                        int r5 = java.lang.Integer.parseInt(r5, r2)     // Catch:{ NumberFormatException -> 0x0018 }
                                        r1.O0000o = r5     // Catch:{ NumberFormatException -> 0x0018 }
                                        goto L_0x001c
                                    L_0x0018:
                                        r5 = move-exception
                                        r5.printStackTrace()     // Catch:{ JSONException -> 0x00f3 }
                                    L_0x001c:
                                        java.lang.String r5 = "primary_netkey"
                                        org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r1 = "key"
                                        if (r5 == 0) goto L_0x0032
                                        _m_j.fhc r2 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r5 = r5.optString(r1)     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r5 = _m_j.got.O000000o(r5)     // Catch:{ JSONException -> 0x00f3 }
                                        r2.O0000oOO = r5     // Catch:{ JSONException -> 0x00f3 }
                                    L_0x0032:
                                        java.lang.String r5 = "ctl_appkey"
                                        org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ JSONException -> 0x00f3 }
                                        if (r5 == 0) goto L_0x0046
                                        _m_j.fhc r0 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r5 = r5.optString(r1)     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r5 = _m_j.got.O000000o(r5)     // Catch:{ JSONException -> 0x00f3 }
                                        r0.O0000oOo = r5     // Catch:{ JSONException -> 0x00f3 }
                                    L_0x0046:
                                        _m_j.fhc r5 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r5 = r5.O0000oOO     // Catch:{ JSONException -> 0x00f3 }
                                        r0 = 31
                                        if (r5 == 0) goto L_0x00ba
                                        _m_j.fhc r5 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r5 = r5.O0000oOo     // Catch:{ JSONException -> 0x00f3 }
                                        if (r5 == 0) goto L_0x00ba
                                        _m_j.hmh r5 = _m_j.fec.O00000o()     // Catch:{ JSONException -> 0x00f3 }
                                        r5.O00000Oo(r0)     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fhc r5 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r0 = r5.O00000o0()     // Catch:{ JSONException -> 0x00f3 }
                                        int r0 = _m_j.ffr.O0000O0o(r0)     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.hmh r1 = _m_j.fec.O00000o()     // Catch:{ JSONException -> 0x00f3 }
                                        r2 = 34
                                        r1.O000000o(r2)     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fhc$3 r1 = new _m_j.fhc$3     // Catch:{ JSONException -> 0x00f3 }
                                        r1.<init>()     // Catch:{ JSONException -> 0x00f3 }
                                        java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ JSONException -> 0x00f3 }
                                        r5.<init>()     // Catch:{ JSONException -> 0x00f3 }
                                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f3 }
                                        r2.<init>()     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r3 = "pdid"
                                        r2.put(r3, r0)     // Catch:{ JSONException -> 0x0083 }
                                        goto L_0x0087
                                    L_0x0083:
                                        r0 = move-exception
                                        r0.printStackTrace()     // Catch:{ JSONException -> 0x00f3 }
                                    L_0x0087:
                                        com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair r0 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r3 = "data"
                                        java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x00f3 }
                                        r0.<init>(r3, r2)     // Catch:{ JSONException -> 0x00f3 }
                                        r5.add(r0)     // Catch:{ JSONException -> 0x00f3 }
                                        com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o r0 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o     // Catch:{ JSONException -> 0x00f3 }
                                        r0.<init>()     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r2 = "POST"
                                        r0.f6799O000000o = r2     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r2 = "/v2/blemesh/query_model"
                                        r0.O00000Oo = r2     // Catch:{ JSONException -> 0x00f3 }
                                        r0.O00000o0 = r5     // Catch:{ JSONException -> 0x00f3 }
                                        com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest r5 = r0.O000000o()     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fgo$14 r0 = new _m_j.fgo$14     // Catch:{ JSONException -> 0x00f3 }
                                        r0.<init>()     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fej r2 = _m_j.fec.O00000o0()     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fgo$15 r3 = new _m_j.fgo$15     // Catch:{ JSONException -> 0x00f3 }
                                        r3.<init>(r0, r1)     // Catch:{ JSONException -> 0x00f3 }
                                        r2.O000000o(r5, r3)     // Catch:{ JSONException -> 0x00f3 }
                                        return
                                    L_0x00ba:
                                        _m_j.hmh r5 = _m_j.fec.O00000o()     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r1 = "netKey"
                                        _m_j.fhc r2 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r2 = r2.O0000oOO     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r2 = _m_j.got.O00000o0(r2)     // Catch:{ JSONException -> 0x00f3 }
                                        r5.O000000o(r0, r1, r2)     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.hmh r5 = _m_j.fec.O00000o()     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r1 = "appKey"
                                        _m_j.fhc r2 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r2 = r2.O0000oOo     // Catch:{ JSONException -> 0x00f3 }
                                        java.lang.String r2 = _m_j.got.O00000o0(r2)     // Catch:{ JSONException -> 0x00f3 }
                                        r5.O000000o(r0, r1, r2)     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.hmh r5 = _m_j.fec.O00000o()     // Catch:{ JSONException -> 0x00f3 }
                                        r1 = 11
                                        r5.O000000o(r0, r1)     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fhc r5 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        r0 = -44
                                        r5.O0000oo = r0     // Catch:{ JSONException -> 0x00f3 }
                                        _m_j.fhc r5 = _m_j.fhc.this     // Catch:{ JSONException -> 0x00f3 }
                                        byte[] r0 = _m_j.fhc.O0000Oo0     // Catch:{ JSONException -> 0x00f3 }
                                        r5.O000000o(r0)     // Catch:{ JSONException -> 0x00f3 }
                                        return
                                    L_0x00f3:
                                        r5 = move-exception
                                        r5.printStackTrace()
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: _m_j.fhc.AnonymousClass2.O000000o(java.lang.Object):void");
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
                            fec.O00000o0().O000000o(o000000o.O000000o(), 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: INVOKE  
                                  (wrap: _m_j.fej : 0x0060: INVOKE  (r1v4 _m_j.fej) =  type: STATIC call: _m_j.fec.O00000o0():_m_j.fej)
                                  (wrap: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest : 0x0057: INVOKE  (r4v7 com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest) = (r0v7 'o000000o' com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o) type: VIRTUAL call: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest.O000000o.O000000o():com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest)
                                  (wrap: _m_j.fgo$13 : 0x0066: CONSTRUCTOR  (r2v1 _m_j.fgo$13) = 
                                  (wrap: _m_j.fgo$11 : 0x005d: CONSTRUCTOR  (r0v8 _m_j.fgo$11) =  call: _m_j.fgo.11.<init>():void type: CONSTRUCTOR)
                                  (r5v6 'r5' _m_j.fhc$2)
                                 call: _m_j.fgo.13.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR)
                                 type: INTERFACE call: _m_j.fej.O000000o(com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest, _m_j.fer):void in method: _m_j.fhc.10.onResponse(int, java.lang.Object):void, dex: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: CONSTRUCTOR  (r2v1 _m_j.fgo$13) = 
                                  (wrap: _m_j.fgo$11 : 0x005d: CONSTRUCTOR  (r0v8 _m_j.fgo$11) =  call: _m_j.fgo.11.<init>():void type: CONSTRUCTOR)
                                  (r5v6 'r5' _m_j.fhc$2)
                                 call: _m_j.fgo.13.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR in method: _m_j.fhc.10.onResponse(int, java.lang.Object):void, dex: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 74 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.fgo, state: PROCESS_STARTED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 80 more
                                */
                            /*
                                this = this;
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                java.lang.String r0 = "BleMeshRegisterConnector sendRegVerifySuccessToDevice onResponse: "
                                r5.<init>(r0)
                                java.lang.String r0 = _m_j.gmc.O000000o(r4)
                                r5.append(r0)
                                java.lang.String r5 = r5.toString()
                                _m_j.fte.O00000Oo(r5)
                                r5 = 13
                                if (r4 != 0) goto L_0x006d
                                _m_j.hmh r4 = _m_j.fec.O00000o()
                                r4.O00000Oo(r5)
                                _m_j.fhc r4 = _m_j.fhc.this
                                _m_j.hmh r5 = _m_j.fec.O00000o()
                                r0 = 31
                                r5.O000000o(r0)
                                _m_j.fhc$2 r5 = new _m_j.fhc$2
                                r5.<init>()
                                java.util.ArrayList r4 = new java.util.ArrayList
                                r4.<init>()
                                org.json.JSONObject r0 = new org.json.JSONObject
                                r0.<init>()
                                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair r1 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair
                                java.lang.String r0 = r0.toString()
                                java.lang.String r2 = "data"
                                r1.<init>(r2, r0)
                                r4.add(r1)
                                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o r0 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o
                                r0.<init>()
                                java.lang.String r1 = "POST"
                                r0.f6799O000000o = r1
                                java.lang.String r1 = "/v2/blemesh/ctl_info"
                                r0.O00000Oo = r1
                                r0.O00000o0 = r4
                                com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest r4 = r0.O000000o()
                                _m_j.fgo$11 r0 = new _m_j.fgo$11
                                r0.<init>()
                                _m_j.fej r1 = _m_j.fec.O00000o0()
                                _m_j.fgo$13 r2 = new _m_j.fgo$13
                                r2.<init>(r0, r5)
                                r1.O000000o(r4, r2)
                                return
                            L_0x006d:
                                _m_j.hmh r0 = _m_j.fec.O00000o()
                                java.lang.String r4 = java.lang.String.valueOf(r4)
                                java.lang.String r1 = "error_code"
                                r0.O000000o(r5, r1, r4)
                                _m_j.hmh r4 = _m_j.fec.O00000o()
                                r0 = 2
                                r4.O000000o(r5, r0)
                                _m_j.fhc r4 = _m_j.fhc.this
                                r5 = -28
                                r4.O000000o(r5)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: _m_j.fhc.AnonymousClass10.onResponse(int, java.lang.Object):void");
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
