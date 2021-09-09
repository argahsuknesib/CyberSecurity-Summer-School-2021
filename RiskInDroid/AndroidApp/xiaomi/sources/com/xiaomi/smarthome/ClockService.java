package com.xiaomi.smarthome;

import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gsy;
import _m_j.hjg;
import _m_j.hrk;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.smarthome.ClockService;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.binder.ICallback;
import com.xiaomi.smarthome.binder.IClockService;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClockService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    private IBinder f4007O000000o = new ClockServiceBinder();

    public void onCreate() {
        super.onCreate();
        gsy.O00000o0(LogType.SCENE, "ClockService", "onCreate");
    }

    public IBinder onBind(Intent intent) {
        return this.f4007O000000o;
    }

    class ClockServiceBinder extends IClockService.Stub {
        private ClockServiceBinder() {
        }

        public void notifySleepChange(ICallback iCallback) {
            gsy.O00000o0(LogType.SCENE, "ClockService", "notifySleepChange");
            hjg.O000000o(ClockService.this, "ClockService".hashCode(), ClockService.this.getString(R.string.app_name), ClockService.this.getString(R.string.mj_scene_sleeptimesyncing), PendingIntent.getActivity(ClockService.this.getApplicationContext(), 1, new Intent(ClockService.this.getApplicationContext(), SleepModeActivity.class), 1073741824));
            new AllReadyCallback(new Runnable() {
                /* class com.xiaomi.smarthome.$$Lambda$ClockService$ClockServiceBinder$YAT6iqgsBhSJ9I9G7wLqbcrioO0 */

                public final void run() {
                    ClockService.ClockServiceBinder.this.updateTime();
                }
            });
        }

        /* access modifiers changed from: private */
        public void updateTime() {
            final SharedPreferences O000000o2 = hrk.O000000o();
            final Set<String> stringSet = O000000o2.getStringSet("auto_clock", new HashSet());
            gsy.O00000o0(LogType.SCENE, "ClockService", "updateTime homeSet:".concat(String.valueOf(stringSet)));
            if (stringSet.size() > 0) {
                hrk.O000000o(ggb.O00000Oo().O0000OOo(), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.ClockService.ClockServiceBinder.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gsy.O00000o0(LogType.SCENE, "ClockService", "setDeviceSleep getDeviceSleep onSuccess");
                        CommonApplication.getGlobalWorkerHandler().post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: INVOKE  
                              (wrap: android.os.Handler : 0x0011: INVOKE  (r8v2 android.os.Handler) =  type: STATIC call: com.xiaomi.smarthome.application.CommonApplication.getGlobalWorkerHandler():android.os.Handler)
                              (wrap: com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw : 0x001d: CONSTRUCTOR  (r0v1 com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw) = 
                              (r1v1 'this' com.xiaomi.smarthome.ClockService$ClockServiceBinder$1 A[THIS])
                              (wrap: org.json.JSONObject : 0x0001: CHECK_CAST  (r2v1 org.json.JSONObject) = (org.json.JSONObject) (r8v0 'obj' java.lang.Object))
                              (wrap: java.util.HashMap : 0x000e: CONSTRUCTOR  (r3v0 java.util.HashMap) =  call: java.util.HashMap.<init>():void type: CONSTRUCTOR)
                              (wrap: java.util.Set : 0x0015: IGET  (r4v0 java.util.Set) = (r7v0 'this' com.xiaomi.smarthome.ClockService$ClockServiceBinder$1 A[THIS]) com.xiaomi.smarthome.ClockService.ClockServiceBinder.1.O000000o java.util.Set)
                              (wrap: android.content.SharedPreferences : 0x0017: IGET  (r5v0 android.content.SharedPreferences) = (r7v0 'this' com.xiaomi.smarthome.ClockService$ClockServiceBinder$1 A[THIS]) com.xiaomi.smarthome.ClockService.ClockServiceBinder.1.O00000Oo android.content.SharedPreferences)
                             call: com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw.<init>(com.xiaomi.smarthome.ClockService$ClockServiceBinder$1, org.json.JSONObject, java.util.HashMap, java.util.Set, android.content.SharedPreferences):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.ClockService.ClockServiceBinder.1.onSuccess(java.lang.Object):void, dex: classes2.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: CONSTRUCTOR  (r0v1 com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw) = 
                              (r1v1 'this' com.xiaomi.smarthome.ClockService$ClockServiceBinder$1 A[THIS])
                              (wrap: org.json.JSONObject : 0x0001: CHECK_CAST  (r2v1 org.json.JSONObject) = (org.json.JSONObject) (r8v0 'obj' java.lang.Object))
                              (wrap: java.util.HashMap : 0x000e: CONSTRUCTOR  (r3v0 java.util.HashMap) =  call: java.util.HashMap.<init>():void type: CONSTRUCTOR)
                              (wrap: java.util.Set : 0x0015: IGET  (r4v0 java.util.Set) = (r7v0 'this' com.xiaomi.smarthome.ClockService$ClockServiceBinder$1 A[THIS]) com.xiaomi.smarthome.ClockService.ClockServiceBinder.1.O000000o java.util.Set)
                              (wrap: android.content.SharedPreferences : 0x0017: IGET  (r5v0 android.content.SharedPreferences) = (r7v0 'this' com.xiaomi.smarthome.ClockService$ClockServiceBinder$1 A[THIS]) com.xiaomi.smarthome.ClockService.ClockServiceBinder.1.O00000Oo android.content.SharedPreferences)
                             call: com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw.<init>(com.xiaomi.smarthome.ClockService$ClockServiceBinder$1, org.json.JSONObject, java.util.HashMap, java.util.Set, android.content.SharedPreferences):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.ClockService.ClockServiceBinder.1.onSuccess(java.lang.Object):void, dex: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 86 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 92 more
                            */
                        /*
                            this = this;
                            r2 = r8
                            org.json.JSONObject r2 = (org.json.JSONObject) r2
                            com.xiaomi.smarthome.library.log.LogType r8 = com.xiaomi.smarthome.library.log.LogType.SCENE
                            java.lang.String r0 = "ClockService"
                            java.lang.String r1 = "setDeviceSleep getDeviceSleep onSuccess"
                            _m_j.gsy.O00000o0(r8, r0, r1)
                            java.util.HashMap r3 = new java.util.HashMap
                            r3.<init>()
                            android.os.Handler r8 = com.xiaomi.smarthome.application.CommonApplication.getGlobalWorkerHandler()
                            java.util.Set r4 = r1
                            android.content.SharedPreferences r5 = r0
                            com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw r6 = new com.xiaomi.smarthome.-$$Lambda$ClockService$ClockServiceBinder$1$16mDJPOp4qK5E3EBqhpGP--Tbdw
                            r0 = r6
                            r1 = r7
                            r0.<init>(r1, r2, r3, r4, r5)
                            r8.post(r6)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.ClockService.ClockServiceBinder.AnonymousClass1.onSuccess(java.lang.Object):void");
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o(JSONObject jSONObject, HashMap hashMap, Set set, SharedPreferences sharedPreferences) {
                        List<String> dids;
                        HashMap hashMap2 = hashMap;
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("devices");
                            if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                    String optString = optJSONObject.optString("did");
                                    ggb.O00000Oo o00000Oo = ggb.O00000Oo().O0000OoO;
                                    HashMap hashMap3 = new HashMap();
                                    for (Map.Entry next : o00000Oo.f17692O000000o.entrySet()) {
                                        List list = (List) next.getValue();
                                        Home O00000o = o00000Oo.O00000o((String) next.getKey());
                                        if (!(list == null || O00000o == null)) {
                                            List<String> dids2 = O00000o.getDids();
                                            if (dids2 != null) {
                                                for (String put : dids2) {
                                                    hashMap3.put(put, O00000o);
                                                }
                                            }
                                            for (int i2 = 0; i2 < list.size(); i2++) {
                                                Room room = (Room) list.get(i2);
                                                if (!(room == null || (dids = room.getDids()) == null)) {
                                                    for (String put2 : dids) {
                                                        hashMap3.put(put2, O00000o);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    Home home = (Home) hashMap3.get(optString);
                                    if (optJSONObject.optBoolean("switch") && home != null) {
                                        ArrayList arrayList = (ArrayList) hashMap2.get(home.getId());
                                        if (arrayList == null) {
                                            String id = home.getId();
                                            arrayList = new ArrayList();
                                            hashMap2.put(id, arrayList);
                                        }
                                        arrayList.add(optString);
                                    }
                                }
                            }
                            Cursor query = ClockService.this.getContentResolver().query(Uri.parse("content://com.android.deskclock.additionProvider/bedtime"), new String[]{"bedtime_state", "sleep_hour", "sleep_minute", "wake_hour", "wake_minute", "repeat_type"}, null, null, null);
                            query.moveToFirst();
                            int i3 = query.getInt(0);
                            String str = hrk.O000000o(query.getInt(1)) + ":" + hrk.O000000o(query.getInt(2));
                            String str2 = hrk.O000000o(query.getInt(3)) + ":" + hrk.O000000o(query.getInt(4));
                            query.close();
                            if (i3 != 0) {
                                AtomicInteger atomicInteger = new AtomicInteger(0);
                                Iterator it = set.iterator();
                                while (it.hasNext()) {
                                    String str3 = (String) it.next();
                                    final SharedPreferences sharedPreferences2 = sharedPreferences;
                                    final String str4 = str3;
                                    final String str5 = str;
                                    final String str6 = str2;
                                    AnonymousClass1 r0 = r1;
                                    final AtomicInteger atomicInteger2 = atomicInteger;
                                    AtomicInteger atomicInteger3 = atomicInteger;
                                    ArrayList arrayList2 = (ArrayList) hashMap2.get(str3);
                                    final Set set2 = set;
                                    AnonymousClass1 r1 = new fsm<JSONObject, fso>() {
                                        /* class com.xiaomi.smarthome.ClockService.ClockServiceBinder.AnonymousClass1.AnonymousClass1 */

                                        public final void onFailure(fso fso) {
                                            LogType logType = LogType.SCENE;
                                            gsy.O00000o0(logType, "ClockService", "setDeviceSleep onFailure hoemId:" + str4 + " error:" + fso);
                                            O000000o();
                                        }

                                        private void O000000o() {
                                            if (atomicInteger2.incrementAndGet() == set2.size()) {
                                                ClockService.this.closeNotify();
                                            }
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            sharedPreferences2.edit().putString("auto_clock_time" + str4, str5 + "-" + str6).apply();
                                            LogType logType = LogType.SCENE;
                                            StringBuilder sb = new StringBuilder("setDeviceSleep onSuccess hoemId:");
                                            sb.append(str4);
                                            gsy.O00000o0(logType, "ClockService", sb.toString());
                                            O000000o();
                                        }
                                    };
                                    hrk.O000000o(str3, str, str2, arrayList2, r0);
                                    atomicInteger = atomicInteger3;
                                    hashMap2 = hashMap;
                                }
                                return;
                            }
                            gsy.O00000o0(LogType.SCENE, "ClockService", "getContentResolver off bedtime_state:".concat(String.valueOf(i3)));
                            ClockService.this.closeNotify();
                        } catch (Throwable th) {
                            gsy.O00000o0(LogType.SCENE, "ClockService", "getContentResolver Throwable:" + Log.getStackTraceString(th));
                            ClockService.this.closeNotify();
                        }
                    }

                    public final void onFailure(fso fso) {
                        gsy.O00000o0(LogType.SCENE, "ClockService", "getDeviceSleep onFailure error:".concat(String.valueOf(fso)));
                    }
                });
                return;
            }
            gsy.O00000o0(LogType.SCENE, "ClockService", "getDeviceSleep nohomeSet");
            ClockService.this.closeNotify();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        stopForeground(true);
    }

    public void closeNotify() {
        CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.$$Lambda$ClockService$SfkvbCLQSq8beUVJG4dwTPyGF0 */

            public final void run() {
                ClockService.this.O000000o();
            }
        }, 3000);
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O00000o0(LogType.SCENE, "ClockService", "onDestroy");
    }
}
