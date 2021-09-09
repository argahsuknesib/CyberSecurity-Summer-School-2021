package _m_j;

import _m_j.fap;
import _m_j.ffk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.library.bluetooth.BleConnectOptions;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattProfile;
import com.xiaomi.smarthome.library.bluetooth.connect.BleGattService;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleNotifyResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class fgm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected fgp f16262O000000o;
    protected boolean O00000Oo;
    O000000o O00000o;
    protected BleConnectResponse O00000o0;
    public Bundle O00000oO;
    public boolean O00000oo = false;
    public ffk O0000O0o = null;
    public final Handler O0000OOo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.fgm.AnonymousClass7 */

        public final void handleMessage(Message message) {
            fgm.this.O000000o(message);
        }
    };
    private final BleConnectResponse O0000Oo0 = new BleConnectResponse() {
        /* class _m_j.fgm.AnonymousClass1 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fgm.O000000o(int, boolean):void
         arg types: [int, int]
         candidates:
          _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
          _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
          _m_j.fgm.O000000o(int, boolean):void */
        public final /* synthetic */ void onResponse(int i, Object obj) {
            Bundle bundle = (Bundle) obj;
            fgm.this.f16262O000000o.O000000o(i, bundle);
            if (i == 0) {
                fec.O00000o().O000000o(3, 0);
                if (bundle != null) {
                    fgm.this.O00000oO.putAll(bundle);
                }
                fgm.this.O00000Oo(bundle);
                fgm fgm = fgm.this;
                fgm.O00000oo = false;
                if (fgm.O00000o == null) {
                    fgm.O00000o = new O000000o(fgm, (byte) 0);
                    IntentFilter intentFilter = new IntentFilter("com.xiaomi.smarthome.bluetooth.character_changed");
                    intentFilter.addAction("com.xiaomi.smarthome.bluetooth.connect_status_changed");
                    intentFilter.addAction("com.miot.action.a4.result");
                    gnl.O000000o(fgm.O00000o, intentFilter);
                }
                if (fgm.O000000o(bundle)) {
                    fec.O00000o().O000000o(3, "support_spec_v2", "true");
                    fte.O00000Oo("check support character SPEC true ");
                    fgm.this.O0000O0o();
                } else if (fgm.O00000o0(bundle)) {
                    fgm.this.O00000oo();
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", " current ble device support mcu version");
                } else {
                    fec.O00000o().O000000o(3, "support_spec_v2", "false");
                    fgm fgm2 = fgm.this;
                    fgm2.O00000oo = true;
                    fgm2.O0000Oo();
                }
            } else {
                fec.O00000o().O000000o(3, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(3, 7);
                fgm.this.O000000o(i, true);
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract void O000000o(Message message);

    /* access modifiers changed from: protected */
    public abstract void O000000o(UUID uuid, UUID uuid2, byte[] bArr);

    /* access modifiers changed from: protected */
    public void O00000Oo() {
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void O0000OOo() {
    }

    /* access modifiers changed from: protected */
    public abstract void O0000Oo();

    /* access modifiers changed from: protected */
    public byte[] O0000Oo0() {
        return null;
    }

    protected fgm(fgp fgp) {
        this.f16262O000000o = fgp;
        if (fgp != null) {
            this.O00000oO = new Bundle();
            return;
        }
        throw new NullPointerException("launcher should not be null");
    }

    public final void O000000o(BleConnectOptions bleConnectOptions, BleConnectResponse bleConnectResponse) {
        this.O00000o0 = bleConnectResponse;
        fea.O000000o(O00000o0(), bleConnectOptions, this.O0000Oo0);
    }

    public final void O000000o() {
        glw.O000000o().disconnect(this.f16262O000000o.O000000o());
    }

    public static boolean O000000o(Bundle bundle) {
        BleGattService O000000o2;
        BleGattProfile bleGattProfile = (BleGattProfile) bundle.getParcelable("key_gatt_profile");
        if (bleGattProfile != null && (O000000o2 = bleGattProfile.O000000o(glb.f17954O000000o)) != null && O000000o2.O000000o(glb.O0000oO0) && O000000o2.O000000o(glb.O0000oO)) {
            return true;
        }
        return false;
    }

    public final String O00000o0() {
        return this.f16262O000000o.O000000o();
    }

    /* access modifiers changed from: protected */
    public final int O00000o() {
        return this.f16262O000000o.O00000Oo();
    }

    /* access modifiers changed from: protected */
    public final byte[] O00000oO() {
        return this.f16262O000000o.O00000o0();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(final BleNotifyResponse bleNotifyResponse) {
        fec.O00000o().O000000o(23);
        fec.O00000o().O000000o(23, "char", glb.O0000OOo.toString());
        glw.O000000o().notify(O00000o0(), glb.f17954O000000o, glb.O0000OOo, new BleNotifyResponse() {
            /* class _m_j.fgm.AnonymousClass2 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    fec.O00000o().O00000Oo(23);
                } else {
                    fec.O00000o().O000000o(23, "error_code", String.valueOf(i));
                    fec.O00000o().O00000Oo(23);
                }
                bleNotifyResponse.onResponse(i, null);
            }
        });
    }

    public final void O000000o(final String str, final BleResponse<String> bleResponse) {
        glw.O000000o().read(str, glb.f17954O000000o, glb.O00000oO, new BleReadResponse() {
            /* class _m_j.fgm.AnonymousClass3 */

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
                        String str = new String(bArr2);
                        fap.O000000o.f16027O000000o.O000000o(str).O00000Oo(str);
                        bleResponse.onResponse(0, str);
                        return;
                    }
                }
                bleResponse.onResponse(-1, "");
            }
        });
    }

    public final void O00000oo() {
        this.O0000O0o = new ffk(O00000o0());
        ffk ffk = this.O0000O0o;
        ffk.O0000OOo = new ffk.O000000o() {
            /* class _m_j.fgm.AnonymousClass4 */

            public final void O000000o() {
                fgm.this.O0000Oo();
            }
        };
        glw.O000000o().notify(ffk.f16217O000000o, glb.f17954O000000o, glb.O0000oOO, new BleNotifyResponse() {
            /* class _m_j.ffk.AnonymousClass4 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", " open mcu notify success");
                    ffk.this.O000000o(0);
                    return;
                }
                gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", " open mcu notify fail");
                ffk.this.O000000o();
            }
        });
    }

    public final void O0000O0o() {
        fec.O00000o().O000000o(23);
        fec.O00000o().O000000o(23, "char", glb.O0000oO.toString());
        glw.O000000o().notify(O00000o0(), glb.f17954O000000o, glb.O0000oO, new BleNotifyResponse() {
            /* class _m_j.fgm.AnonymousClass5 */

            public final /* synthetic */ void onResponse(int i, Object obj) {
                if (i == 0) {
                    fec.O00000o().O000000o(23, 0);
                    fte.O00000Oo("open spec READ notify success ");
                    fec.O00000o().O000000o(23);
                    fec.O00000o().O000000o(23, "char", glb.O0000oO0.toString());
                    glw.O000000o().notify(fgm.this.O00000o0(), glb.f17954O000000o, glb.O0000oO0, new BleNotifyResponse() {
                        /* class _m_j.fgm.AnonymousClass5.AnonymousClass1 */

                        public final /* synthetic */ void onResponse(int i, Object obj) {
                            if (i == 0) {
                                fec.O00000o().O000000o(23, 0);
                                fte.O00000Oo("open spec WRITE notify success");
                                String O00000o0 = fgm.this.O00000o0();
                                Intent intent = new Intent("com.xiaomi.smarthome.support.ble.spec.protocol");
                                intent.putExtra("mac", O00000o0);
                                glc.O0000O0o.sendBroadcast(intent);
                            } else {
                                fec.O00000o().O000000o(23, "error_code", String.valueOf(i));
                                fte.O00000Oo("open spec WRITE notify <<Fail>> code=".concat(String.valueOf(i)));
                                fec.O00000o().O000000o(23, 3);
                            }
                            if (fgm.O00000o0(fgm.this.O00000oO)) {
                                fgm.this.O00000oo();
                                return;
                            }
                            fgm.this.O00000oo = true;
                            fgm.this.O0000Oo();
                        }
                    });
                    return;
                }
                fec.O00000o().O000000o(23, "error_code", String.valueOf(i));
                fec.O00000o().O000000o(23, 3);
                fte.O00000Oo("open spec READ notify <<Fail>>,onResponse code=".concat(String.valueOf(i)));
                if (fgm.O00000o0(fgm.this.O00000oO)) {
                    fgm.this.O00000oo();
                    return;
                }
                fgm fgm = fgm.this;
                fgm.O00000oo = true;
                fgm.O0000Oo();
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fgm.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.fgm.O000000o(com.xiaomi.smarthome.library.bluetooth.BleConnectOptions, com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse):void
      _m_j.fgm.O000000o(java.lang.String, com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse<java.lang.String>):void
      _m_j.fgm.O000000o(int, boolean):void */
    public final void O000000o(int i) {
        fte.O00000Oo(String.format("%s.dispatchResult code = %s", getClass().getSimpleName(), gmc.O000000o(i)));
        O000000o(i, false);
    }

    public final void O000000o(final int i, final boolean z) {
        this.O0000OOo.post(new Runnable() {
            /* class _m_j.fgm.AnonymousClass6 */

            public final void run() {
                fgm.this.O00000Oo(i, z);
            }
        });
    }

    public static boolean O00000o0(Bundle bundle) {
        BleGattProfile bleGattProfile;
        BleGattService O000000o2;
        if (bundle == null || (bleGattProfile = (BleGattProfile) bundle.getParcelable("key_gatt_profile")) == null || (O000000o2 = bleGattProfile.O000000o(glb.f17954O000000o)) == null || !O000000o2.O000000o(glb.O0000oOO)) {
            return false;
        }
        return true;
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(fgm fgm, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.xiaomi.smarthome.bluetooth.character_changed".equalsIgnoreCase(action)) {
                    if (fgm.this.O00000o0().equalsIgnoreCase(intent.getStringExtra("key_device_address"))) {
                        UUID uuid = (UUID) intent.getSerializableExtra("key_service_uuid");
                        UUID uuid2 = (UUID) intent.getSerializableExtra("key_character_uuid");
                        byte[] byteArrayExtra = intent.getByteArrayExtra("key_character_value");
                        if (uuid != null && uuid2 != null) {
                            if (!glb.f17954O000000o.equals(uuid) || !glb.O0000oOO.equals(uuid2)) {
                                fgm.this.O000000o(uuid, uuid2, byteArrayExtra);
                            } else if (fgm.this.O0000O0o != null) {
                                fgm.this.O0000O0o.O000000o(byteArrayExtra);
                            }
                        }
                    }
                } else if ("com.xiaomi.smarthome.bluetooth.connect_status_changed".equalsIgnoreCase(action)) {
                    if (fgm.this.O00000o0().equalsIgnoreCase(intent.getStringExtra("key_device_address")) && intent.getIntExtra("key_connect_status", 5) == 32) {
                        fgm.this.O000000o(-32);
                    }
                } else if ("com.miot.action.a4.result".equals(action)) {
                    fec.O00000o().O00000Oo(37);
                    fgm.this.O0000OOo();
                }
            }
        }
    }

    public static void O000000o(final String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            fte.O00000Oo("checkFirmwareNewVersion did or ble firmware version is null,return");
        } else {
            fec.O00000oo().submit(new Runnable() {
                /* class _m_j.fgm.AnonymousClass8 */

                public final void run() {
                    String str = str2;
                    String str2 = str;
                    AnonymousClass1 r2 = new feo<String, fes>() {
                        /* class _m_j.fgm.AnonymousClass8.AnonymousClass1 */

                        public final void O000000o(fes fes) {
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            String str = (String) obj;
                            if (TextUtils.isEmpty(str)) {
                                fte.O00000Oo("checkFirmwareNewVersion remote version is null,return");
                                return;
                            }
                            fte.O00000Oo("checkFirmwareNewVersion current version=" + str3 + ",latest version=" + str);
                            if (flo.O00000Oo(str, str3) > 0) {
                                Intent intent = new Intent("com.xiaomi.iot.firmware.new_version");
                                intent.putExtra("current_version", str3);
                                intent.putExtra("latest_version", str);
                                intent.putExtra("did", str2);
                                BleMeshFirmwareUpdateInfo O000O00o = ffr.O000O00o(str);
                                if (!(O000O00o == null || O000O00o.mcuUpdateInfo == null || TextUtils.isEmpty(O000O00o.mcuUpdateInfo.version))) {
                                    intent.putExtra("mcu_version", O000O00o.mcuUpdateInfo.version);
                                }
                                glc.O0000O0o.sendBroadcast(intent);
                            }
                        }
                    };
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("did", str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BleKeyValuePair("data", jSONObject.toString()));
                    BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
                    o000000o.f6799O000000o = "POST";
                    o000000o.O00000Oo = "/v2/device/latest_ver";
                    o000000o.O00000o0 = arrayList;
                    fec.O00000o0().O000000o(o000000o.O000000o(), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: INVOKE  
                          (wrap: _m_j.fej : 0x0043: INVOKE  (r1v1 _m_j.fej) =  type: STATIC call: _m_j.fec.O00000o0():_m_j.fej)
                          (wrap: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest : 0x003a: INVOKE  (r0v2 com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest) = (r3v2 'o000000o' com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o) type: VIRTUAL call: com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest.O000000o.O000000o():com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest)
                          (wrap: _m_j.fgo$26 : 0x0049: CONSTRUCTOR  (r4v4 _m_j.fgo$26) = 
                          (wrap: _m_j.fgo$25 : 0x0040: CONSTRUCTOR  (r3v3 _m_j.fgo$25) = (r1v0 'str2' java.lang.String) call: _m_j.fgo.25.<init>(java.lang.String):void type: CONSTRUCTOR)
                          (r2v0 'r2' _m_j.fgm$8$1)
                         call: _m_j.fgo.26.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR)
                         type: INTERFACE call: _m_j.fej.O000000o(com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest, _m_j.fer):void in method: _m_j.fgm.8.run():void, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r4v4 _m_j.fgo$26) = 
                          (wrap: _m_j.fgo$25 : 0x0040: CONSTRUCTOR  (r3v3 _m_j.fgo$25) = (r1v0 'str2' java.lang.String) call: _m_j.fgo.25.<init>(java.lang.String):void type: CONSTRUCTOR)
                          (r2v0 'r2' _m_j.fgm$8$1)
                         call: _m_j.fgo.26.<init>(_m_j.feq, _m_j.feo):void type: CONSTRUCTOR in method: _m_j.fgm.8.run():void, dex: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 68 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.fgo, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 74 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = r3
                        java.lang.String r1 = r2
                        _m_j.fgm$8$1 r2 = new _m_j.fgm$8$1
                        r2.<init>()
                        org.json.JSONObject r3 = new org.json.JSONObject
                        r3.<init>()
                        java.lang.String r4 = "did"
                        r3.put(r4, r0)     // Catch:{ JSONException -> 0x0014 }
                        goto L_0x0018
                    L_0x0014:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x0018:
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair r4 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair
                        java.lang.String r3 = r3.toString()
                        java.lang.String r5 = "data"
                        r4.<init>(r5, r3)
                        r0.add(r4)
                        com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o r3 = new com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest$O000000o
                        r3.<init>()
                        java.lang.String r4 = "POST"
                        r3.f6799O000000o = r4
                        java.lang.String r4 = "/v2/device/latest_ver"
                        r3.O00000Oo = r4
                        r3.O00000o0 = r0
                        com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest r0 = r3.O000000o()
                        _m_j.fgo$25 r3 = new _m_j.fgo$25
                        r3.<init>(r1)
                        _m_j.fej r1 = _m_j.fec.O00000o0()
                        _m_j.fgo$26 r4 = new _m_j.fgo$26
                        r4.<init>(r3, r2)
                        r1.O000000o(r0, r4)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: _m_j.fgm.AnonymousClass8.run():void");
                }
            });
        }
    }

    public final void O00000Oo(int i, boolean z) {
        if (this.O00000Oo) {
            i = -2;
        }
        boolean z2 = i == 0;
        O000000o o000000o = this.O00000o;
        if (o000000o != null) {
            gnl.O000000o(o000000o);
            this.O00000o = null;
        }
        O00000Oo();
        if (this.O00000o0 != null) {
            if (z2) {
                this.O00000oO.putByteArray("key_token", O0000Oo0());
            }
            this.O00000oO.putBoolean("key_is_connect_failed", z);
            this.O00000o0.onResponse(i, this.O00000oO);
        }
        ffk ffk = this.O0000O0o;
        if (ffk != null && (!TextUtils.isEmpty(ffk.O00000o0) || !TextUtils.isEmpty(ffk.O00000Oo))) {
            new Timer().schedule(new TimerTask() {
                /* class _m_j.ffk.AnonymousClass2 */

                public final void run() {
                    String str;
                    Pair<Boolean, String> O00000o = fec.O00000o0().O00000o(ffk.this.f16217O000000o);
                    if (((Boolean) O00000o.first).booleanValue()) {
                        str = (String) O00000o.second;
                    } else {
                        str = ffr.O00000oo(ffk.this.f16217O000000o);
                    }
                    String str2 = str;
                    if (TextUtils.isEmpty(str2)) {
                        gsy.O00000Oo("MCU-bluetooth", " report mcu version,but did is empty ,so mac is null =" + TextUtils.isEmpty(ffk.this.f16217O000000o));
                        return;
                    }
                    gsy.O00000o0(LogType.BLUETOOTH, "MCU-bluetooth", String.format("start report mcu version=%s, dev sn=%s,hardware=%s,latitude=%s,longitude=%s", ffk.this.O00000Oo, ffk.this.O00000o0, ffk.this.O00000o, ffk.this.O00000oO, ffk.this.O00000oo));
                    fgo.O000000o(new fcp(str2, ffk.this.O00000Oo, ffk.this.O00000o0, ffk.this.O00000o, ffk.this.O00000oO, ffk.this.O00000oo), (feo<Void, fes>) null);
                }
            }, 1200);
        }
        this.O0000OOo.removeCallbacksAndMessages(null);
        this.O00000o0 = null;
    }
}
