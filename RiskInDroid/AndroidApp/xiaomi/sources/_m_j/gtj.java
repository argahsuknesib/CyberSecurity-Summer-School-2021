package _m_j;

import _m_j.gti;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gtj {
    private static gtj O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f18250O000000o = false;
    public boolean O00000Oo = false;
    public boolean O00000o = true;
    AtomicBoolean O00000o0 = new AtomicBoolean(false);
    public boolean O00000oO = false;
    public boolean O00000oo = false;
    public boolean O0000O0o = false;
    public List<O000000o> O0000OOo = new ArrayList();
    O00000Oo O0000Oo;
    public Handler O0000Oo0 = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gtj.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                gtj.this.O00000Oo = false;
                CameraRouterFactory.getCameraManagerApi().swapCameraDeviceOpManager();
                gti.O000000o();
                Iterator<O000000o> it = gtj.this.O0000OOo.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } else if (i == 2) {
                gtj.this.f18250O000000o = false;
                if (((Class) message.obj).equals(gti.class)) {
                    gtj.this.O00000oO = false;
                }
                if (!gtj.this.O00000oO) {
                    if (gtj.this.O00000oo) {
                        gti.O000000o();
                    }
                    for (O000000o O000000o2 : gtj.this.O0000OOo) {
                        O000000o2.O000000o();
                    }
                    ft.O000000o(gkv.f17949O000000o).O000000o(new Intent("get_camera_success"));
                }
            } else if (i == 4) {
                gtj gtj = gtj.this;
                if (gtj.O00000o0.getAndSet(false)) {
                    List<Device> homeDeviceList = CameraRouterFactory.getCameraManagerApi().getHomeDeviceList();
                    gti O000000o3 = gti.O000000o();
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < homeDeviceList.size(); i2++) {
                        Device device = homeDeviceList.get(i2);
                        if (device != null && !device.model.contains("mxiang.camera.mwc10") && !device.model.contains("mxiang.camera.mwc11")) {
                            hashMap.put(homeDeviceList.get(i2).did, Integer.valueOf(i2));
                        }
                    }
                    int i3 = 0;
                    while (i3 < O000000o3.O00000o0.size()) {
                        gti.O000000o o000000o = O000000o3.O00000o0.get(i3);
                        if (o000000o == null || !hashMap.containsKey(o000000o.f18248O000000o)) {
                            O000000o3.O00000oO.add(O000000o3.O00000o0.remove(i3));
                            i3--;
                        } else {
                            hashMap.remove(O000000o3.O00000o0.get(i3).f18248O000000o);
                        }
                        i3++;
                    }
                    if (hashMap.size() != 0) {
                        for (String str : hashMap.keySet()) {
                            gti.O000000o o000000o2 = null;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= O000000o3.O00000oO.size()) {
                                    break;
                                } else if (O000000o3.O00000oO.get(i4).f18248O000000o.equals(str)) {
                                    o000000o2 = O000000o3.O00000oO.remove(i4);
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (o000000o2 == null) {
                                o000000o2 = new gti.O000000o();
                                o000000o2.f18248O000000o = str;
                            }
                            Device O00000o0 = fno.O000000o().O00000o0(o000000o2.f18248O000000o);
                            if (O00000o0 != null) {
                                Map<String, Long> supportCameraModelsCameraDeviceOpManager = CameraRouterFactory.getCameraManagerApi().getSupportCameraModelsCameraDeviceOpManager();
                                if (supportCameraModelsCameraDeviceOpManager == null || !supportCameraModelsCameraDeviceOpManager.containsKey(O00000o0.model)) {
                                    O000000o3.O00000o0.add(o000000o2);
                                } else {
                                    O000000o3.O00000o0.add(0, o000000o2);
                                }
                            }
                        }
                    }
                    gsy.O000000o(6, "AllCameraGroup", O000000o3.O00000o.size() + ", " + O000000o3.O00000o0.size());
                    for (O000000o O000000o4 : gtj.O0000OOo) {
                        O000000o4.O000000o();
                    }
                    gtj.f18250O000000o = false;
                    gtj.O0000Oo.sendEmptyMessage(3);
                    return;
                }
                gtj.f18250O000000o = false;
                gkv.f17949O000000o.sendBroadcast(new Intent("refresh_list"));
                gti.O000000o().O000000o(new fsm<Void, fso>() {
                    /* class _m_j.gtj.AnonymousClass2 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    }
                });
            }
        }
    };
    private HandlerThread O0000Ooo = new gpq("camera_list_info");

    public interface O000000o {
        void O000000o();
    }

    public static gtj O000000o() {
        if (O0000OoO == null) {
            O0000OoO = new gtj();
        }
        return O0000OoO;
    }

    class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                gti O000000o2 = gti.O000000o();
                String string = O000000o2.f18243O000000o.getString(gti.O00000Oo(), "");
                if (!TextUtils.isEmpty(string)) {
                    O000000o2.O00000oo.sendMessage(O000000o2.O00000oo.obtainMessage(3, O000000o2.O000000o(string)));
                }
                gtj.this.O0000Oo0.sendMessage(gtj.this.O0000Oo0.obtainMessage(1));
                gsy.O000000o(6, "device_rpc", "Refresh Cache complete");
                fuj.O000000o().O000000o(gkv.f17949O000000o, new String[]{"20"}, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007d: INVOKE  
                      (wrap: _m_j.fuj : 0x006c: INVOKE  (r1v1 _m_j.fuj) =  type: STATIC call: _m_j.fuj.O000000o():_m_j.fuj)
                      (wrap: android.content.Context : 0x0070: SGET  (r2v4 android.content.Context) =  _m_j.gkv.O000000o android.content.Context)
                      (wrap: java.lang.String[] : 0x0074: FILLED_NEW_ARRAY  (r3v4 java.lang.String[]) = ("20") elemType: java.lang.String)
                      (wrap: _m_j.gti$4 : 0x007a: CONSTRUCTOR  (r4v2 _m_j.gti$4) = 
                      (wrap: _m_j.gti : 0x0063: INVOKE  (r7v6 _m_j.gti) =  type: STATIC call: _m_j.gti.O000000o():_m_j.gti)
                      (wrap: _m_j.gtj$O00000Oo$1 : 0x0069: CONSTRUCTOR  (r0v1 _m_j.gtj$O00000Oo$1) = (r6v0 'this' _m_j.gtj$O00000Oo A[THIS]) call: _m_j.gtj.O00000Oo.1.<init>(_m_j.gtj$O00000Oo):void type: CONSTRUCTOR)
                     call: _m_j.gti.4.<init>(_m_j.gti, _m_j.fsm):void type: CONSTRUCTOR)
                     type: VIRTUAL call: _m_j.fuj.O000000o(android.content.Context, java.lang.String[], _m_j.fsm):_m_j.fsn in method: _m_j.gtj.O00000Oo.handleMessage(android.os.Message):void, dex: classes7.dex
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007a: CONSTRUCTOR  (r4v2 _m_j.gti$4) = 
                      (wrap: _m_j.gti : 0x0063: INVOKE  (r7v6 _m_j.gti) =  type: STATIC call: _m_j.gti.O000000o():_m_j.gti)
                      (wrap: _m_j.gtj$O00000Oo$1 : 0x0069: CONSTRUCTOR  (r0v1 _m_j.gtj$O00000Oo$1) = (r6v0 'this' _m_j.gtj$O00000Oo A[THIS]) call: _m_j.gtj.O00000Oo.1.<init>(_m_j.gtj$O00000Oo):void type: CONSTRUCTOR)
                     call: _m_j.gti.4.<init>(_m_j.gti, _m_j.fsm):void type: CONSTRUCTOR in method: _m_j.gtj.O00000Oo.handleMessage(android.os.Message):void, dex: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 52 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.gti, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 58 more
                    */
                /*
                    this = this;
                    int r7 = r7.what
                    r0 = 6
                    java.lang.String r1 = "device_rpc"
                    r2 = 3
                    if (r7 == 0) goto L_0x0029
                    if (r7 == r2) goto L_0x000b
                    goto L_0x0028
                L_0x000b:
                    java.lang.String r7 = "Start Refresh PROP"
                    _m_j.gsy.O000000o(r0, r1, r7)
                    com.xiaomi.smarthome.camera.api.ICameraManagerApi r7 = com.xiaomi.smarthome.camera.api.CameraRouterFactory.getCameraManagerApi()
                    _m_j.gtj$O00000Oo$2 r0 = new _m_j.gtj$O00000Oo$2
                    r0.<init>()
                    r7.loadAllCameraCloudStorageInfoFromServer(r0)
                    com.xiaomi.smarthome.camera.api.ICameraManagerApi r7 = com.xiaomi.smarthome.camera.api.CameraRouterFactory.getCameraManagerApi()
                    _m_j.gtj$O00000Oo$3 r0 = new _m_j.gtj$O00000Oo$3
                    r0.<init>()
                    r7.updateDevicePropsCameraDeviceOpManager(r0)
                L_0x0028:
                    return
                L_0x0029:
                    _m_j.gti r7 = _m_j.gti.O000000o()
                    android.content.SharedPreferences r3 = r7.f18243O000000o
                    java.lang.String r4 = _m_j.gti.O00000Oo()
                    java.lang.String r5 = ""
                    java.lang.String r3 = r3.getString(r4, r5)
                    boolean r4 = android.text.TextUtils.isEmpty(r3)
                    if (r4 != 0) goto L_0x004e
                    java.util.List r3 = r7.O000000o(r3)
                    android.os.Handler r4 = r7.O00000oo
                    android.os.Handler r7 = r7.O00000oo
                    android.os.Message r7 = r7.obtainMessage(r2, r3)
                    r4.sendMessage(r7)
                L_0x004e:
                    _m_j.gtj r7 = _m_j.gtj.this
                    android.os.Handler r7 = r7.O0000Oo0
                    _m_j.gtj r2 = _m_j.gtj.this
                    android.os.Handler r2 = r2.O0000Oo0
                    r3 = 1
                    android.os.Message r2 = r2.obtainMessage(r3)
                    r7.sendMessage(r2)
                    java.lang.String r7 = "Refresh Cache complete"
                    _m_j.gsy.O000000o(r0, r1, r7)
                    _m_j.gti r7 = _m_j.gti.O000000o()
                    _m_j.gtj$O00000Oo$1 r0 = new _m_j.gtj$O00000Oo$1
                    r0.<init>()
                    _m_j.fuj r1 = _m_j.fuj.O000000o()
                    android.content.Context r2 = _m_j.gkv.f17949O000000o
                    java.lang.String r3 = "20"
                    java.lang.String[] r3 = new java.lang.String[]{r3}
                    _m_j.gti$4 r4 = new _m_j.gti$4
                    r4.<init>(r0)
                    r1.O000000o(r2, r3, r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: _m_j.gtj.O00000Oo.handleMessage(android.os.Message):void");
            }
        }

        gtj() {
            this.O0000Ooo.start();
            this.O0000Oo = new O00000Oo(this.O0000Ooo.getLooper());
        }

        public final void O00000Oo() {
            if (!this.f18250O000000o) {
                this.f18250O000000o = true;
                this.O00000oO = true;
                this.O0000O0o = false;
                this.O00000oo = false;
                this.O00000Oo = false;
                this.O0000Oo.sendEmptyMessage(0);
            }
        }

        public final void O00000o0() {
            this.O00000o0.set(true);
            if (!this.f18250O000000o) {
                this.f18250O000000o = true;
                this.O0000Oo0.sendEmptyMessage(4);
            }
        }
    }
