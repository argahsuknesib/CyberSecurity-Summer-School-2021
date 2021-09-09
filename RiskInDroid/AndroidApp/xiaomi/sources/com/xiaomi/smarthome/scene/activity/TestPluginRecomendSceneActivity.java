package com.xiaomi.smarthome.scene.activity;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.hps;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity;
import java.util.List;

public class TestPluginRecomendSceneActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_test_recommend_scene);
        final List<Device> O0000Ooo = fno.O000000o().O0000Ooo("lumi.lock.mcn01");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.O000000o<O000000o>() {
            /* class com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.AnonymousClass1 */

            public final long getItemId(int i) {
                return (long) i;
            }

            public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                O000000o o000000o = (O000000o) o000OOo0;
                if (!TextUtils.isEmpty(((Device) O0000Ooo.get(i)).name)) {
                    o000000o.f11115O000000o.setText(((Device) O0000Ooo.get(i)).name);
                } else {
                    o000000o.f11115O000000o.setText("");
                }
                o000000o.itemView.setOnClickListener(new View.OnClickListener(O0000Ooo, i) {
                    /* class com.xiaomi.smarthome.scene.activity.$$Lambda$TestPluginRecomendSceneActivity$1$iHTcmC4vB1hpj7iNjWhof_MhTRs */
                    private final /* synthetic */ List f$1;
                    private final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        TestPluginRecomendSceneActivity.AnonymousClass1.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(final List list, final int i, View view) {
                hps.O000000o().O000000o(((Device) list.get(i)).did, new fsm<PluginRecommendSceneInfo, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.AnonymousClass1.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        TestPluginRecomendSceneActivity.this.mHandler.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: INVOKE  
                              (wrap: android.os.Handler : 0x0006: IGET  (r0v2 android.os.Handler) = 
                              (wrap: com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity : 0x0004: IGET  (r0v1 com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity) = 
                              (wrap: com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1 : 0x0002: IGET  (r0v0 com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS]) com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.O00000o0 com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1)
                             com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.O00000Oo com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity)
                             com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.mHandler android.os.Handler)
                              (wrap: com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM : 0x000e: CONSTRUCTOR  (r3v0 com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM) = 
                              (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS])
                              (wrap: com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo : 0x0000: CHECK_CAST  (r5v1 com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo) = (com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo) (r5v0 'obj' java.lang.Object))
                              (wrap: java.util.List : 0x0008: IGET  (r1v0 java.util.List) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS]) com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.O000000o java.util.List)
                              (wrap: int : 0x000a: IGET  (r2v0 int) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS]) com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.O00000Oo int)
                             call: com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM.<init>(com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1, com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo, java.util.List, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.onSuccess(java.lang.Object):void, dex: classes5.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: CONSTRUCTOR  (r3v0 com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM) = 
                              (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS])
                              (wrap: com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo : 0x0000: CHECK_CAST  (r5v1 com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo) = (com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo) (r5v0 'obj' java.lang.Object))
                              (wrap: java.util.List : 0x0008: IGET  (r1v0 java.util.List) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS]) com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.O000000o java.util.List)
                              (wrap: int : 0x000a: IGET  (r2v0 int) = (r4v0 'this' com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1 A[THIS]) com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.O00000Oo int)
                             call: com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM.<init>(com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1$1, com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo, java.util.List, int):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.1.1.onSuccess(java.lang.Object):void, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 95 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 101 more
                            */
                        /*
                            this = this;
                            com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo r5 = (com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo) r5
                            com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity$1 r0 = com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.AnonymousClass1.this
                            com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity r0 = com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.this
                            android.os.Handler r0 = r0.mHandler
                            java.util.List r1 = r3
                            int r2 = r4
                            com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM r3 = new com.xiaomi.smarthome.scene.activity.-$$Lambda$TestPluginRecomendSceneActivity$1$1$lhsnf73xin_7KmbWQ8SbGzaPziM
                            r3.<init>(r4, r5, r1, r2)
                            r0.post(r3)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.scene.activity.TestPluginRecomendSceneActivity.AnonymousClass1.AnonymousClass1.onSuccess(java.lang.Object):void");
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o(PluginRecommendSceneInfo pluginRecommendSceneInfo, List list, int i) {
                        if (pluginRecommendSceneInfo != null && pluginRecommendSceneInfo.mSceneItems != null && pluginRecommendSceneInfo.mSceneItems.size() > 0) {
                            Intent intent = new Intent(TestPluginRecomendSceneActivity.this, PluginRecommendSceneActivity.class);
                            intent.putExtra("did", ((Device) list.get(i)).did);
                            intent.putExtra("sr_id", new Integer(pluginRecommendSceneInfo.mSceneItems.get(0).sr_id));
                            TestPluginRecomendSceneActivity.this.startActivity(intent);
                        }
                    }
                });
            }

            public final int getItemCount() {
                List list = O0000Ooo;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new O000000o(LayoutInflater.from(TestPluginRecomendSceneActivity.this).inflate((int) R.layout.item_plugin_rec_action, (ViewGroup) null));
            }
        });
    }

    public static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11115O000000o;

        public O000000o(View view) {
            super(view);
            this.f11115O000000o = (TextView) view.findViewById(R.id.device_name);
        }
    }
}
