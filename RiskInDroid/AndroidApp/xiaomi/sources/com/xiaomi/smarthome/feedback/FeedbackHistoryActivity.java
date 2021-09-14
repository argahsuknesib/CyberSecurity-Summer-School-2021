package com.xiaomi.smarthome.feedback;

import _m_j.fsi;
import _m_j.fsj;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gwg;
import _m_j.hzf;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.feedback.view.BatchBar;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import java.util.HashSet;
import java.util.List;

public class FeedbackHistoryActivity extends BaseActivity implements BatchBar.O000000o {
    public List<fsi.O000000o> feebackHistoryDatas;
    public BatchBar mBatchBar;
    public View mEmptyView;
    public O000000o mHistoryAdapter;
    public CustomPullDownRefreshListView mHistoryListView;
    public ProgressBar mProgressBar;
    public View space;

    public View getContentViewOfBatchActionBar() {
        return null;
    }

    public View getContentViewOfBatchSelectBar() {
        return null;
    }

    public void onStartBatchMode() {
    }

    public void onUpdateBatchBarViewState(int i) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.feedback_history_layout);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.feedback_history);
        }
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass6 */

                public final void onClick(View view) {
                    FeedbackHistoryActivity.this.finish();
                }
            });
        }
        this.mHistoryAdapter = new O000000o();
        this.mHistoryListView = (CustomPullDownRefreshListView) findViewById(R.id.pull_down_lv_feedback_history);
        this.mHistoryListView.O00000Oo();
        this.mProgressBar = (ProgressBar) findViewById(R.id.pb_loading);
        this.mBatchBar = new BatchBar(getContext());
        this.mEmptyView = findViewById(R.id.tv_empty_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.batch_select_bar);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.batch_action_bar);
        if (viewGroup != null && gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), viewGroup);
        }
        BatchBar batchBar = this.mBatchBar;
        batchBar.f7420O000000o = new fsj(batchBar.O00000Oo, viewGroup, viewGroup2);
        this.mBatchBar.O0000Oo = this;
        this.mHistoryListView.setAdapter((ListAdapter) this.mHistoryAdapter);
        this.mHistoryListView.setOnScrollListener(new O00000Oo(new Runnable() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass1 */

            public final void run() {
                if (!FeedbackManager.INSTANCE.isLoadingHistory() && !FeedbackManager.INSTANCE.isAllLoaded()) {
                    FeedbackHistoryActivity.this.mProgressBar.setVisibility(0);
                    FeedbackHistoryActivity.this.loadMoreHistoryData();
                }
            }
        }));
        this.mHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass2 */

            /* JADX WARN: Type inference failed for: r2v1, types: [android.widget.Adapter] */
            /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
                	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
                	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
                	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
                	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
                	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
                	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
                	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
                */
            public final void onItemClick(android.widget.AdapterView<?> r2, android.view.View r3, int r4, long r5) {
                /*
                    r1 = this;
                    java.lang.Object r3 = r3.getTag()
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity$O00000o0 r3 = (com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.O00000o0) r3
                    if (r3 != 0) goto L_0x0009
                    return
                L_0x0009:
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    java.util.List<_m_j.fsi$O000000o> r5 = r5.feebackHistoryDatas
                    if (r5 == 0) goto L_0x0067
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    java.util.List<_m_j.fsi$O000000o> r5 = r5.feebackHistoryDatas
                    int r5 = r5.size()
                    if (r5 > 0) goto L_0x001a
                    goto L_0x0067
                L_0x001a:
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    com.xiaomi.smarthome.feedback.view.BatchBar r5 = r5.mBatchBar
                    boolean r5 = r5.O0000OoO
                    if (r5 == 0) goto L_0x0037
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r2 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    com.xiaomi.smarthome.feedback.view.BatchBar r2 = r2.mBatchBar
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r3 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView r3 = r3.mHistoryListView
                    int r3 = r3.getHeaderViewsCount()
                    int r4 = r4 - r3
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                    r2.O000000o(r3)
                    return
                L_0x0037:
                    android.content.Intent r5 = new android.content.Intent
                    r5.<init>()
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r6 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    android.content.Context r6 = r6.getContext()
                    java.lang.Class<com.xiaomi.smarthome.feedback.FeedbackDetailActivity> r0 = com.xiaomi.smarthome.feedback.FeedbackDetailActivity.class
                    r5.setClass(r6, r0)
                    android.widget.Adapter r2 = r2.getAdapter()
                    java.lang.Object r2 = r2.getItem(r4)
                    _m_j.fsi$O000000o r2 = (_m_j.fsi.O000000o) r2
                    java.lang.String r4 = r2.f17054O000000o
                    java.lang.String r6 = "extra_id"
                    r5.putExtra(r6, r4)
                    android.view.View r3 = r3.O00000o0
                    r4 = 8
                    r3.setVisibility(r4)
                    r3 = 0
                    r2.O00000o0 = r3
                    com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r2 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                    r2.startActivity(r5)
                L_0x0067:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass2.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
        this.mHistoryListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass3 */

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FeedbackHistoryActivity.this.mHistoryListView.O00000o || FeedbackHistoryActivity.this.feebackHistoryDatas == null || FeedbackHistoryActivity.this.feebackHistoryDatas.size() <= 0) {
                    return false;
                }
                if (!FeedbackHistoryActivity.this.mBatchBar.O0000OoO) {
                    BatchBar batchBar = FeedbackHistoryActivity.this.mBatchBar;
                    batchBar.O0000Ooo = FeedbackHistoryActivity.this.mHistoryAdapter;
                    batchBar.O0000o00.clear();
                    batchBar.O0000OoO = true;
                    if (batchBar.O00000oO == null) {
                        if (batchBar.O0000Oo != null) {
                            batchBar.O00000oO = batchBar.O0000Oo.getContentViewOfBatchSelectBar();
                        }
                        if (batchBar.O00000oO == null) {
                            batchBar.O00000o0 = true;
                            batchBar.O00000oO = LayoutInflater.from(batchBar.O00000Oo).inflate((int) R.layout.batch_select_bar, (ViewGroup) null);
                            batchBar.O00000oO.findViewById(R.id.btn_cancel).setOnClickListener(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006a: INVOKE  
                                  (wrap: android.view.View : 0x0061: INVOKE  (r9v32 android.view.View) = 
                                  (wrap: android.view.View : 0x005c: IGET  (r9v31 android.view.View) = (r5v18 'batchBar' com.xiaomi.smarthome.feedback.view.BatchBar) com.xiaomi.smarthome.feedback.view.BatchBar.O00000oO android.view.View)
                                  (wrap: ? : ?: SGET   com.xiaomi.smarthome.R.id.btn_cancel int)
                                 type: VIRTUAL call: android.view.View.findViewById(int):android.view.View)
                                  (wrap: com.xiaomi.smarthome.feedback.view.BatchBar$1 : 0x0067: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.feedback.view.BatchBar$1) = (r5v18 'batchBar' com.xiaomi.smarthome.feedback.view.BatchBar) call: com.xiaomi.smarthome.feedback.view.BatchBar.1.<init>(com.xiaomi.smarthome.feedback.view.BatchBar):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.3.onItemLongClick(android.widget.AdapterView<?>, android.view.View, int, long):boolean, dex: classes5.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.feedback.view.BatchBar$1) = (r5v18 'batchBar' com.xiaomi.smarthome.feedback.view.BatchBar) call: com.xiaomi.smarthome.feedback.view.BatchBar.1.<init>(com.xiaomi.smarthome.feedback.view.BatchBar):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.3.onItemLongClick(android.widget.AdapterView<?>, android.view.View, int, long):boolean, dex: classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 82 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.feedback.view.BatchBar, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 88 more
                                */
                            /*
                                this = this;
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView r5 = r5.mHistoryListView
                                boolean r5 = r5.O00000o
                                r6 = 0
                                if (r5 == 0) goto L_0x000a
                                return r6
                            L_0x000a:
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                java.util.List<_m_j.fsi$O000000o> r5 = r5.feebackHistoryDatas
                                if (r5 == 0) goto L_0x014f
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                java.util.List<_m_j.fsi$O000000o> r5 = r5.feebackHistoryDatas
                                int r5 = r5.size()
                                if (r5 > 0) goto L_0x001c
                                goto L_0x014f
                            L_0x001c:
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.feedback.view.BatchBar r5 = r5.mBatchBar
                                boolean r5 = r5.O0000OoO
                                r8 = 1
                                if (r5 != 0) goto L_0x0132
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.feedback.view.BatchBar r5 = r5.mBatchBar
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r9 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity$O000000o r9 = r9.mHistoryAdapter
                                r5.O0000Ooo = r9
                                java.util.HashSet<java.lang.Integer> r9 = r5.O0000o00
                                r9.clear()
                                r5.O0000OoO = r8
                                android.view.View r9 = r5.O00000oO
                                r0 = 0
                                if (r9 != 0) goto L_0x0091
                                com.xiaomi.smarthome.feedback.view.BatchBar$O000000o r9 = r5.O0000Oo
                                if (r9 == 0) goto L_0x0047
                                com.xiaomi.smarthome.feedback.view.BatchBar$O000000o r9 = r5.O0000Oo
                                android.view.View r9 = r9.getContentViewOfBatchSelectBar()
                                r5.O00000oO = r9
                            L_0x0047:
                                android.view.View r9 = r5.O00000oO
                                if (r9 != 0) goto L_0x0091
                                r5.O00000o0 = r8
                                android.content.Context r9 = r5.O00000Oo
                                android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)
                                r1 = 2132345193(0x7f190169, float:2.033792E38)
                                android.view.View r9 = r9.inflate(r1, r0)
                                r5.O00000oO = r9
                                android.view.View r9 = r5.O00000oO
                                r1 = 2132148760(0x7f160218, float:1.9939507E38)
                                android.view.View r9 = r9.findViewById(r1)
                                com.xiaomi.smarthome.feedback.view.BatchBar$1 r1 = new com.xiaomi.smarthome.feedback.view.BatchBar$1
                                r1.<init>()
                                r9.setOnClickListener(r1)
                                android.view.View r9 = r5.O00000oO
                                r1 = 2132148832(0x7f160260, float:1.9939653E38)
                                android.view.View r9 = r9.findViewById(r1)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                r5.O0000O0o = r9
                                android.widget.ImageView r9 = r5.O0000O0o
                                com.xiaomi.smarthome.feedback.view.BatchBar$2 r1 = new com.xiaomi.smarthome.feedback.view.BatchBar$2
                                r1.<init>()
                                r9.setOnClickListener(r1)
                                android.view.View r9 = r5.O00000oO
                                r1 = 2132153353(0x7f161409, float:1.9948823E38)
                                android.view.View r9 = r9.findViewById(r1)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                r5.O0000OOo = r9
                            L_0x0091:
                                android.view.View r9 = r5.O00000oo
                                if (r9 != 0) goto L_0x00cb
                                com.xiaomi.smarthome.feedback.view.BatchBar$O000000o r9 = r5.O0000Oo
                                if (r9 == 0) goto L_0x00a1
                                com.xiaomi.smarthome.feedback.view.BatchBar$O000000o r9 = r5.O0000Oo
                                android.view.View r9 = r9.getContentViewOfBatchActionBar()
                                r5.O00000oo = r9
                            L_0x00a1:
                                android.view.View r9 = r5.O00000oo
                                if (r9 != 0) goto L_0x00cb
                                r5.O00000o = r8
                                android.content.Context r9 = r5.O00000Oo
                                android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)
                                r1 = 2132345192(0x7f190168, float:2.0337919E38)
                                android.view.View r9 = r9.inflate(r1, r0)
                                r5.O00000oo = r9
                                android.view.View r9 = r5.O00000oo
                                r0 = 2132148813(0x7f16024d, float:1.9939615E38)
                                android.view.View r9 = r9.findViewById(r0)
                                r5.O0000Oo0 = r9
                                android.view.View r9 = r5.O0000Oo0
                                com.xiaomi.smarthome.feedback.view.BatchBar$3 r0 = new com.xiaomi.smarthome.feedback.view.BatchBar$3
                                r0.<init>()
                                r9.setOnClickListener(r0)
                            L_0x00cb:
                                _m_j.fsj r9 = r5.f7420O000000o
                                r9.O000000o()
                                _m_j.fsj r9 = r5.f7420O000000o
                                android.view.View r0 = r5.O00000oO
                                android.view.View r1 = r5.O00000oo
                                android.view.ViewGroup r2 = r9.f17055O000000o
                                r3 = 8
                                if (r2 == 0) goto L_0x00ea
                                if (r0 == 0) goto L_0x00ea
                                android.view.ViewGroup r2 = r9.f17055O000000o
                                r2.addView(r0)
                                r9.O00000o0 = r0
                                android.view.View r0 = r9.O00000o0
                                r0.setVisibility(r3)
                            L_0x00ea:
                                android.view.ViewGroup r0 = r9.O00000Oo
                                if (r0 == 0) goto L_0x00fc
                                if (r1 == 0) goto L_0x00fc
                                r9.O00000o = r1
                                android.view.View r0 = r9.O00000o
                                r0.setVisibility(r3)
                                android.view.ViewGroup r9 = r9.O00000Oo
                                r9.addView(r1)
                            L_0x00fc:
                                _m_j.fsj r9 = r5.f7420O000000o
                                _m_j.fsj$O00000Oo r0 = r5.O0000o0O
                                r9.O00000oO = r0
                                _m_j.fsj r9 = r5.f7420O000000o
                                _m_j.fsj$O000000o r0 = r5.O0000o0o
                                r9.O00000oo = r0
                                _m_j.fsj r5 = r5.f7420O000000o
                                android.view.View r9 = r5.O00000o0
                                if (r9 == 0) goto L_0x011c
                                r5.O0000Oo0 = r8
                                android.view.View r9 = r5.O00000o0
                                android.view.animation.Animation r0 = r5.O0000O0o
                                r9.startAnimation(r0)
                                android.view.View r9 = r5.O00000o0
                                r9.setVisibility(r6)
                            L_0x011c:
                                android.view.View r9 = r5.O00000o
                                if (r9 == 0) goto L_0x0132
                                android.view.View r9 = r5.O00000o0
                                if (r9 != 0) goto L_0x0126
                                r5.O0000Oo0 = r6
                            L_0x0126:
                                android.view.View r9 = r5.O00000o
                                android.view.animation.Animation r0 = r5.O0000OOo
                                r9.startAnimation(r0)
                                android.view.View r5 = r5.O00000o
                                r5.setVisibility(r6)
                            L_0x0132:
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.feedback.view.BatchBar r5 = r5.mBatchBar
                                boolean r5 = r5.O0000OoO
                                if (r5 == 0) goto L_0x014e
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r5 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.feedback.view.BatchBar r5 = r5.mBatchBar
                                com.xiaomi.smarthome.feedback.FeedbackHistoryActivity r6 = com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.this
                                com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView r6 = r6.mHistoryListView
                                int r6 = r6.getHeaderViewsCount()
                                int r7 = r7 - r6
                                java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
                                r5.O000000o(r6)
                            L_0x014e:
                                return r8
                            L_0x014f:
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass3.onItemLongClick(android.widget.AdapterView, android.view.View, int, long):boolean");
                        }
                    });
                    this.space = LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mHistoryListView, false);
                    loadHistoryData();
                }

                public void loadHistoryData() {
                    FeedbackManager.INSTANCE.loadFeedbackHistory(getContext(), new fsm<List<fsi.O000000o>, fso>() {
                        /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass4 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            final List list = (List) obj;
                            FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    FeedbackHistoryActivity.this.feebackHistoryDatas = list;
                                    FeedbackHistoryActivity.this.mHistoryAdapter.notifyDataSetChanged();
                                    if (list.size() == 0) {
                                        FeedbackHistoryActivity.this.mEmptyView.setVisibility(0);
                                    } else {
                                        FeedbackHistoryActivity.this.mEmptyView.setVisibility(8);
                                        FeedbackHistoryActivity.this.mHistoryListView.addHeaderView(FeedbackHistoryActivity.this.space);
                                    }
                                    FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                                }
                            });
                        }

                        public final void onFailure(fso fso) {
                            FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                        }
                    });
                }

                public void loadMoreHistoryData() {
                    FeedbackManager.INSTANCE.loadMoreFeedbackHistory(getContext(), new fsm<List<fsi.O000000o>, fso>() {
                        /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass5 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            final List list = (List) obj;
                            FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    FeedbackHistoryActivity.this.feebackHistoryDatas = list;
                                    FeedbackHistoryActivity.this.mProgressBar.setVisibility(8);
                                    FeedbackHistoryActivity.this.mHistoryAdapter.notifyDataSetChanged();
                                    FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                                }
                            });
                        }

                        public final void onFailure(fso fso) {
                            FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass5.AnonymousClass2 */

                                public final void run() {
                                    FeedbackHistoryActivity.this.mProgressBar.setVisibility(8);
                                    FeedbackHistoryActivity.this.mHistoryListView.O00000Oo();
                                }
                            });
                        }
                    });
                    this.mProgressBar.setVisibility(0);
                }

                public void onExitBatchMode(int i, BaseAdapter baseAdapter) {
                    if (i == 1) {
                        BatchBar batchBar = this.mBatchBar;
                        HashSet<Integer> hashSet = new HashSet<>();
                        hashSet.addAll(batchBar.O0000o00);
                        if (!hashSet.isEmpty()) {
                            String[] strArr = new String[hashSet.size()];
                            int i2 = 0;
                            for (Integer intValue : hashSet) {
                                strArr[i2] = this.feebackHistoryDatas.get(intValue.intValue()).f17054O000000o;
                                i2++;
                            }
                            FeedbackApi.INSTANCE.deleteFeedback(getContext(), strArr, new fsm<Boolean, fso>() {
                                /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass7 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    FeedbackHistoryActivity.this.mHandler.post(new Runnable() {
                                        /* class com.xiaomi.smarthome.feedback.FeedbackHistoryActivity.AnonymousClass7.AnonymousClass1 */

                                        public final void run() {
                                            FeedbackHistoryActivity.this.loadHistoryData();
                                        }
                                    });
                                }
                            });
                        }
                    }
                }

                public void onBackPressed() {
                    BatchBar batchBar = this.mBatchBar;
                    if (batchBar == null || !batchBar.O0000OoO) {
                        super.onBackPressed();
                    } else {
                        this.mBatchBar.O000000o(0);
                    }
                }

                class O00000o0 {

                    /* renamed from: O000000o  reason: collision with root package name */
                    TextView f7414O000000o;
                    TextView O00000Oo;
                    View O00000o;
                    View O00000o0;
                    CheckBox O00000oO;

                    O00000o0() {
                    }
                }

                class O000000o extends BaseAdapter {
                    public final long getItemId(int i) {
                        return 0;
                    }

                    O000000o() {
                    }

                    public final int getCount() {
                        if (FeedbackHistoryActivity.this.feebackHistoryDatas == null) {
                            return 0;
                        }
                        return FeedbackHistoryActivity.this.feebackHistoryDatas.size();
                    }

                    public final Object getItem(int i) {
                        return FeedbackHistoryActivity.this.feebackHistoryDatas.get(i);
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
                     arg types: [?, android.view.ViewGroup, int]
                     candidates:
                      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
                      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
                    public final View getView(int i, View view, ViewGroup viewGroup) {
                        O00000o0 o00000o0;
                        fsi.O000000o o000000o;
                        String str;
                        if (view == null) {
                            view = LayoutInflater.from(FeedbackHistoryActivity.this.getContext()).inflate((int) R.layout.feedback_history_item, viewGroup, false);
                            o00000o0 = new O00000o0();
                            o00000o0.O00000o0 = view.findViewById(R.id.red_point);
                            o00000o0.O00000o = view.findViewById(R.id.right_hint);
                            o00000o0.f7414O000000o = (TextView) view.findViewById(R.id.feedback_title);
                            o00000o0.O00000Oo = (TextView) view.findViewById(R.id.feedback_desc);
                            o00000o0.O00000oO = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
                            view.setTag(o00000o0);
                        } else {
                            o00000o0 = (O00000o0) view.getTag();
                        }
                        if (!(FeedbackHistoryActivity.this.feebackHistoryDatas == null || (o000000o = FeedbackHistoryActivity.this.feebackHistoryDatas.get(i)) == null)) {
                            if (i == getCount() - 1) {
                                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
                            } else {
                                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
                            }
                            if (o000000o.O00000oo != null && !o000000o.O00000oo.isEmpty()) {
                                o00000o0.f7414O000000o.setText(o000000o.O00000oo);
                            }
                            if (FeedbackHistoryActivity.this.mBatchBar.O0000OoO) {
                                o00000o0.O00000o0.setVisibility(8);
                                o00000o0.O00000o.setVisibility(8);
                                o00000o0.O00000oO.setVisibility(0);
                                if (FeedbackHistoryActivity.this.mBatchBar.O0000o00.contains(Integer.valueOf(i))) {
                                    o00000o0.O00000oO.setChecked(true);
                                } else {
                                    o00000o0.O00000oO.setChecked(false);
                                }
                            } else {
                                o00000o0.O00000oO.setVisibility(8);
                                if (o000000o.O00000o0) {
                                    o00000o0.O00000o0.setVisibility(0);
                                    o00000o0.O00000o.setVisibility(8);
                                } else {
                                    o00000o0.O00000o0.setVisibility(8);
                                    o00000o0.O00000o.setVisibility(0);
                                }
                            }
                            String feedbackDeviceName = FeedbackManager.INSTANCE.getFeedbackDeviceName(FeedbackHistoryActivity.this.getContext(), o000000o.O00000o);
                            if (feedbackDeviceName != null) {
                                str = String.format("%s | %s", feedbackDeviceName, o000000o.O00000Oo);
                            } else {
                                str = o000000o.O00000Oo;
                            }
                            if (str != null) {
                                o00000o0.O00000Oo.setText(str);
                            }
                        }
                        return view;
                    }
                }

                public class O00000Oo implements AbsListView.OnScrollListener {
                    private Runnable O00000Oo;
                    private boolean O00000o = false;
                    private boolean O00000o0 = false;
                    private boolean O00000oO = false;

                    public O00000Oo(Runnable runnable) {
                        this.O00000Oo = runnable;
                    }

                    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        boolean z = true;
                        this.O00000o0 = i3 == i + i2;
                        if (i3 != i2) {
                            z = false;
                        }
                        this.O00000o = z;
                    }

                    public final void onScrollStateChanged(AbsListView absListView, int i) {
                        if (i == 0 && this.O00000o0 && this.O00000Oo != null) {
                            if (this.O00000oO || !this.O00000o) {
                                this.O00000Oo.run();
                            }
                        }
                    }
                }
            }
