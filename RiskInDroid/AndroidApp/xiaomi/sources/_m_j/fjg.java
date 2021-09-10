package _m_j;

import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.device.Device;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class fjg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f16465O000000o = "_miio._udp.local.";
    public static String O00000Oo = "_rc._tcp.local.";
    private static volatile fjg O0000OOo;
    private static Object O0000Oo0 = new Object();
    public gpq O00000o = new gpq("DiscoverManager");
    public isq O00000o0;
    public Handler O00000oO;
    public List<WeakReference<fja>> O00000oo = new ArrayList();
    public ConcurrentMap<String, Device> O0000O0o = new ConcurrentHashMap();

    private fjg() {
    }

    public static fjg O000000o() {
        if (O0000OOo == null) {
            synchronized (fjg.class) {
                if (O0000OOo == null) {
                    O0000OOo = new fjg();
                }
            }
        }
        return O0000OOo;
    }

    public final synchronized void O000000o(fja fja) {
        if (fja != null) {
            this.O00000oo.add(new WeakReference(fja));
        }
    }

    public final void O00000Oo() {
        fjn.O000000o().O00000Oo();
        this.O0000O0o.clear();
    }

    public final void O000000o(final Device device) {
        if (device != null && !TextUtils.isEmpty(device.getDid()) && device.getModel().contains("robot")) {
            MiioLocalAPI.O000000o(device.getLocalIP(), 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE  
                  (wrap: java.lang.String : 0x001d: INVOKE  (r1v1 java.lang.String) = (r4v0 'device' com.xiaomi.smarthome.device.Device) type: VIRTUAL call: com.xiaomi.smarthome.device.Device.getLocalIP():java.lang.String)
                  (wrap: _m_j.fjh$2 : 0x0028: CONSTRUCTOR  (r4v1 _m_j.fjh$2) = 
                  (wrap: _m_j.fjh : 0x0019: INVOKE  (r0v4 _m_j.fjh) =  type: STATIC call: _m_j.fjh.O000000o():_m_j.fjh)
                  (wrap: _m_j.fjg$3 : 0x0023: CONSTRUCTOR  (r2v0 _m_j.fjg$3) = (r3v0 'this' _m_j.fjg A[THIS]), (r4v0 'device' com.xiaomi.smarthome.device.Device A[SKIP_ARG]) call: _m_j.fjg.3.<init>(_m_j.fjg, com.xiaomi.smarthome.device.Device):void type: CONSTRUCTOR)
                 call: _m_j.fjh.2.<init>(_m_j.fjh, _m_j.fjo):void type: CONSTRUCTOR)
                  (9 int)
                 type: STATIC call: com.xiaomi.miio.MiioLocalAPI.O000000o(java.lang.String, _m_j.dxe, int):com.xiaomi.miio.MiioLocalAPI$O000000o in method: _m_j.fjg.O000000o(com.xiaomi.smarthome.device.Device):void, dex: classes7.dex
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
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: CONSTRUCTOR  (r4v1 _m_j.fjh$2) = 
                  (wrap: _m_j.fjh : 0x0019: INVOKE  (r0v4 _m_j.fjh) =  type: STATIC call: _m_j.fjh.O000000o():_m_j.fjh)
                  (wrap: _m_j.fjg$3 : 0x0023: CONSTRUCTOR  (r2v0 _m_j.fjg$3) = (r3v0 'this' _m_j.fjg A[THIS]), (r4v0 'device' com.xiaomi.smarthome.device.Device A[SKIP_ARG]) call: _m_j.fjg.3.<init>(_m_j.fjg, com.xiaomi.smarthome.device.Device):void type: CONSTRUCTOR)
                 call: _m_j.fjh.2.<init>(_m_j.fjh, _m_j.fjo):void type: CONSTRUCTOR in method: _m_j.fjg.O000000o(com.xiaomi.smarthome.device.Device):void, dex: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 38 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.fjh, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 44 more
                */
            /*
                this = this;
                if (r4 == 0) goto L_0x0030
                java.lang.String r0 = r4.getDid()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0030
                java.lang.String r0 = r4.getModel()
                java.lang.String r1 = "robot"
                boolean r0 = r0.contains(r1)
                if (r0 != 0) goto L_0x0019
                goto L_0x0030
            L_0x0019:
                _m_j.fjh r0 = _m_j.fjh.O000000o()
                java.lang.String r1 = r4.getLocalIP()
                _m_j.fjg$3 r2 = new _m_j.fjg$3
                r2.<init>(r4)
                _m_j.fjh$2 r4 = new _m_j.fjh$2
                r4.<init>(r2)
                r0 = 9
                com.xiaomi.miio.MiioLocalAPI.O000000o(r1, r4, r0)
            L_0x0030:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.fjg.O000000o(com.xiaomi.smarthome.device.Device):void");
        }

        public final void O000000o(ServiceInfo serviceInfo) {
            String O00000Oo2 = fjb.O00000Oo(serviceInfo.O00000o0());
            if (this.O0000O0o.containsKey(O00000Oo2)) {
                Device device = this.O0000O0o.get(O00000Oo2);
                this.O0000O0o.remove(O00000Oo2);
                for (WeakReference next : this.O00000oo) {
                    if (next.get() != null) {
                        ((fja) next.get()).O00000Oo(device);
                    }
                }
            }
        }

        class O000000o implements iss {
            private O000000o() {
            }

            /* synthetic */ O000000o(fjg fjg, byte b) {
                this();
            }

            public final void O000000o(ServiceEvent serviceEvent) {
                fjg.this.O000000o(fjb.O000000o(serviceEvent.O00000o().O00000o0(), serviceEvent._source.getHostAddress()));
            }

            public final void O00000Oo(ServiceEvent serviceEvent) {
                fjg.this.O000000o(serviceEvent.O00000o());
            }

            public final void O00000o0(ServiceEvent serviceEvent) {
                fjg.this.O000000o(fjb.O000000o(serviceEvent.O00000o().O00000o0(), serviceEvent.O00000o().O00000oo().getHostAddress()));
            }
        }

        class O00000Oo implements iss {
            private O00000Oo() {
            }

            /* synthetic */ O00000Oo(fjg fjg, byte b) {
                this();
            }

            public final void O000000o(final ServiceEvent serviceEvent) {
                goq.O000000o(new Runnable() {
                    /* class _m_j.fjg.O00000Oo.AnonymousClass1 */

                    public final void run() {
                        ServiceInfo O000000o2 = fjg.this.O00000o0.O000000o(fjg.O00000Oo, serviceEvent.O00000o().O00000o0());
                        if (O000000o2 != null) {
                            MiTVDevice O00000Oo2 = fjg.O00000Oo(O000000o2);
                            fjn.O000000o().O000000o(O00000Oo2);
                            fjg.this.O000000o(O00000Oo2);
                        }
                    }
                });
            }

            public final void O00000Oo(ServiceEvent serviceEvent) {
                ServiceInfo O00000o;
                if (serviceEvent != null && (O00000o = serviceEvent.O00000o()) != null) {
                    fjn.O000000o().O00000Oo(fjg.O00000Oo(O00000o));
                    fjg.this.O000000o(O00000o);
                }
            }

            public final void O00000o0(ServiceEvent serviceEvent) {
                ServiceInfo O00000o;
                if (serviceEvent != null && (O00000o = serviceEvent.O00000o()) != null) {
                    MiTVDevice O00000Oo = fjg.O00000Oo(O00000o);
                    fjn.O000000o().O000000o(O00000Oo);
                    fjg.this.O000000o(O00000Oo);
                }
            }
        }

        public static MiTVDevice O00000Oo(ServiceInfo serviceInfo) {
            MiTVDevice miTVDevice = new MiTVDevice();
            miTVDevice.setMac(serviceInfo.O000000o("mac"));
            miTVDevice.setBssid(serviceInfo.O000000o("mac"));
            String O00000Oo2 = gog.O00000Oo(CommonApplication.getAppContext());
            if (!TextUtils.isEmpty(O00000Oo2)) {
                miTVDevice.setBssid(O00000Oo2.toUpperCase());
            }
            String O00000o02 = gog.O00000o0(CommonApplication.getAppContext());
            if (!TextUtils.isEmpty(O00000o02)) {
                miTVDevice.setSsid(O00000o02);
            }
            miTVDevice.setName(serviceInfo.O00000o0());
            String O000000o2 = serviceInfo.O000000o("rid");
            if (!TextUtils.isEmpty(miTVDevice.getMac()) && !TextUtils.isEmpty(O000000o2)) {
                miTVDevice.setDid("mitv." + fjb.O000000o(miTVDevice.getMac()) + ":" + serviceInfo.O000000o("rid"));
            }
            InetAddress O00000oo2 = serviceInfo.O00000oo();
            if (O00000oo2 != null) {
                miTVDevice.setLocalIP(O00000oo2.getHostAddress());
            }
            miTVDevice.toggleOnline(true);
            miTVDevice.setResetFlag(1);
            miTVDevice.setLocation(Device.Location.LOCAL);
            miTVDevice.setPid(2);
            miTVDevice.O000000o();
            int i = 0;
            miTVDevice.toggleCanAuth(false);
            miTVDevice.setShared(true);
            miTVDevice.toggleCanUseNotBind(true);
            miTVDevice.toggleOnline(true);
            try {
                i = Integer.valueOf(serviceInfo.O000000o("platform_id")).intValue();
            } catch (Exception unused) {
            }
            if (i < 600) {
                miTVDevice.setModel("xiaomi.tvbox.v1");
            } else {
                miTVDevice.setModel("xiaomi.tv.v1");
            }
            if (i > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("platform", i);
                } catch (JSONException unused2) {
                }
                miTVDevice.setExtraInfo(jSONObject.toString());
            }
            return miTVDevice;
        }
    }
