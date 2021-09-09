package com.xiaomi.smarthome.operation.js_sdk.titlebar;

import _m_j.gpc;
import _m_j.gsy;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TitleBarMenu extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O000000o f10526O000000o;
    public final List<O000000o> O00000Oo;
    public boolean O00000o;
    public final List<O000000o> O00000o0;

    public TitleBarMenu(Context context) {
        this(context, null);
    }

    public TitleBarMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBarMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10526O000000o = new O000000o("inner:more_menu_id", "") {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final void O000000o(View view, O000000o o000000o) {
                View inflate = LayoutInflater.from(TitleBarMenu.this.getContext()).inflate((int) R.layout.title_drop_down_menu_layout, (ViewGroup) null);
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);
                PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
                popupWindow.setClippingEnabled(false);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0));
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                recyclerView.setAdapter(new O000000o(new ArrayList(TitleBarMenu.this.O00000o0), popupWindow));
                recyclerView.setLayoutManager(new LinearLayoutManager(TitleBarMenu.this.getContext()));
                popupWindow.showAsDropDown(view, -gpc.O000000o(TitleBarMenu.this.getContext(), 120.0f), -gpc.O000000o(TitleBarMenu.this.getContext(), 37.0f));
            }

            /* renamed from: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o */
            class O000000o extends RecyclerView.O000000o<C0088O000000o> {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ ArrayList f10528O000000o;
                final /* synthetic */ PopupWindow O00000Oo;

                O000000o(ArrayList arrayList, PopupWindow popupWindow) {
                    this.f10528O000000o = arrayList;
                    this.O00000Oo = popupWindow;
                }

                public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                    ((C0088O000000o) o000OOo0).O000000o((O000000o) this.f10528O000000o.get(i), i);
                }

                public final int getItemCount() {
                    return this.f10528O000000o.size();
                }

                /* renamed from: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o  reason: collision with other inner class name */
                class C0088O000000o extends RecyclerView.O000OOo0 {
                    C0088O000000o(View view) {
                        super(view);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
                    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec  */
                    public final void O000000o(O000000o o000000o, int i) {
                        boolean z;
                        this.itemView.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                              (wrap: android.view.View : 0x0000: IGET  (r0v0 android.view.View) = (r9v0 'this' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.itemView android.view.View)
                              (wrap: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU : 0x0008: CONSTRUCTOR  (r2v0 com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU) = 
                              (r9v0 'this' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o A[THIS])
                              (r10v0 'o000000o' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o)
                              (wrap: android.widget.PopupWindow : 0x0004: IGET  (r1v1 android.widget.PopupWindow) = 
                              (wrap: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o : 0x0002: IGET  (r1v0 com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o) = (r9v0 'this' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.O000000o com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o)
                             com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O00000Oo android.widget.PopupWindow)
                             call: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU.<init>(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o, com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, android.widget.PopupWindow):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.O000000o(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, int):void, dex: classes5.dex
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
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r2v0 com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU) = 
                              (r9v0 'this' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o A[THIS])
                              (r10v0 'o000000o' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o)
                              (wrap: android.widget.PopupWindow : 0x0004: IGET  (r1v1 android.widget.PopupWindow) = 
                              (wrap: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o : 0x0002: IGET  (r1v0 com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o) = (r9v0 'this' com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.O000000o com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o)
                             com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O00000Oo android.widget.PopupWindow)
                             call: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU.<init>(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o$O000000o, com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, android.widget.PopupWindow):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.O000000o(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, int):void, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 93 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 99 more
                            */
                        /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
                        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ec  */
                        /*
                            this = this;
                            android.view.View r0 = r9.itemView
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r1 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            android.widget.PopupWindow r1 = r1.O00000Oo
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU r2 = new com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$TitleBarMenu$1$O000000o$O000000o$hDlo-POK8e116jxNdgS_iZCCfHU
                            r2.<init>(r9, r10, r1)
                            r0.setOnClickListener(r2)
                            android.view.View r0 = r9.itemView
                            r1 = 2132151426(0x7f160c82, float:1.9944914E38)
                            android.view.View r0 = r0.findViewById(r1)
                            android.widget.TextView r0 = (android.widget.TextView) r0
                            android.view.View r1 = r9.itemView
                            r2 = 2132151417(0x7f160c79, float:1.9944896E38)
                            android.view.View r1 = r1.findViewById(r2)
                            android.widget.ImageButton r1 = (android.widget.ImageButton) r1
                            android.view.View r2 = r9.itemView
                            r3 = 2132148595(0x7f160173, float:1.9939172E38)
                            android.view.View r2 = r2.findViewById(r3)
                            android.widget.TextView r2 = (android.widget.TextView) r2
                            android.view.View r3 = r9.itemView
                            r4 = 2132148594(0x7f160172, float:1.993917E38)
                            android.view.View r3 = r3.findViewById(r4)
                            android.widget.TextView r3 = (android.widget.TextView) r3
                            android.graphics.Bitmap r4 = r10.O00000o
                            r5 = 8
                            r6 = -1
                            r7 = 1
                            r8 = 0
                            if (r4 == 0) goto L_0x004a
                            android.graphics.Bitmap r4 = r10.O00000o
                            r1.setImageBitmap(r4)
                        L_0x0048:
                            r1 = 1
                            goto L_0x0058
                        L_0x004a:
                            int r4 = r10.O00000oO
                            if (r4 == r6) goto L_0x0054
                            int r4 = r10.O00000oO
                            r1.setImageResource(r4)
                            goto L_0x0048
                        L_0x0054:
                            r1.setVisibility(r5)
                            r1 = 0
                        L_0x0058:
                            if (r1 == 0) goto L_0x0060
                            int r4 = r10.O00000oo
                            if (r4 == r6) goto L_0x0060
                            r4 = 0
                            goto L_0x0062
                        L_0x0060:
                            r4 = 8
                        L_0x0062:
                            r2.setVisibility(r4)
                            if (r1 != 0) goto L_0x006c
                            int r1 = r10.O00000oo
                            if (r1 == r6) goto L_0x006c
                            r5 = 0
                        L_0x006c:
                            r3.setVisibility(r5)
                            java.lang.String r10 = r10.O00000o0
                            r0.setText(r10)
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            int r10 = r10.getItemCount()
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r0 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r0 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r0 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
                            r1 = 1115160576(0x42780000, float:62.0)
                            if (r11 != 0) goto L_0x00ba
                            if (r10 != r7) goto L_0x00ba
                            android.view.View r10 = r9.itemView
                            r11 = 2132085301(0x7f150a35, float:1.9810797E38)
                            r10.setBackgroundResource(r11)
                            if (r0 == 0) goto L_0x00b9
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r10 = r10.getContext()
                            int r10 = _m_j.gpc.O00000o0(r10, r1)
                            r0.height = r10
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r10 = r10.getContext()
                            r11 = 1086324736(0x40c00000, float:6.0)
                            int r10 = _m_j.gpc.O00000o0(r10, r11)
                            android.view.View r11 = r9.itemView
                            r11.setPadding(r8, r10, r8, r10)
                        L_0x00b9:
                            return
                        L_0x00ba:
                            r2 = 1094713344(0x41400000, float:12.0)
                            if (r11 != 0) goto L_0x00ec
                            android.view.View r10 = r9.itemView
                            r11 = 2132085303(0x7f150a37, float:1.98108E38)
                            r10.setBackgroundResource(r11)
                            if (r0 == 0) goto L_0x013e
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r10 = r10.getContext()
                            int r10 = _m_j.gpc.O00000o0(r10, r2)
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r11 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r11 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r11 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r11 = r11.getContext()
                            int r11 = _m_j.gpc.O00000o0(r11, r1)
                            r0.height = r11
                            android.view.View r11 = r9.itemView
                            r11.setPadding(r8, r10, r8, r8)
                            return
                        L_0x00ec:
                            int r10 = r10 - r7
                            if (r11 != r10) goto L_0x011d
                            android.view.View r10 = r9.itemView
                            r11 = 2132085302(0x7f150a36, float:1.9810799E38)
                            r10.setBackgroundResource(r11)
                            if (r0 == 0) goto L_0x013e
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r10 = r10.getContext()
                            int r10 = _m_j.gpc.O00000o0(r10, r1)
                            r0.height = r10
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r10 = r10.getContext()
                            int r10 = _m_j.gpc.O00000o0(r10, r2)
                            android.view.View r11 = r9.itemView
                            r11.setPadding(r8, r8, r8, r10)
                            return
                        L_0x011d:
                            android.view.View r10 = r9.itemView
                            r11 = 2132085304(0x7f150a38, float:1.9810803E38)
                            r10.setBackgroundResource(r11)
                            if (r0 == 0) goto L_0x013e
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1$O000000o r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$1 r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.this
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu r10 = com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.this
                            android.content.Context r10 = r10.getContext()
                            r11 = 1112014848(0x42480000, float:50.0)
                            int r10 = _m_j.gpc.O00000o0(r10, r11)
                            r0.height = r10
                            android.view.View r10 = r9.itemView
                            r10.setPadding(r8, r8, r8, r8)
                        L_0x013e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.C0088O000000o.O000000o(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, int):void");
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o(O000000o o000000o, PopupWindow popupWindow, View view) {
                        o000000o.O000000o(view, o000000o);
                        View view2 = this.itemView;
                        popupWindow.getClass();
                        view2.postDelayed(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                              (r3v1 'view2' android.view.View)
                              (wrap: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ : 0x000a: CONSTRUCTOR  (r5v1 com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ) = (r4v0 'popupWindow' android.widget.PopupWindow) call: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ.<init>(android.widget.PopupWindow):void type: CONSTRUCTOR)
                              (200 long)
                             type: VIRTUAL call: android.view.View.postDelayed(java.lang.Runnable, long):boolean in method: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.O000000o(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, android.widget.PopupWindow, android.view.View):void, dex: classes5.dex
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
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r5v1 com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ) = (r4v0 'popupWindow' android.widget.PopupWindow) call: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ.<init>(android.widget.PopupWindow):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.1.O000000o.O000000o.O000000o(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, android.widget.PopupWindow, android.view.View):void, dex: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 93 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 99 more
                            */
                        /*
                            this = this;
                            r3.O000000o(r5, r3)
                            android.view.View r3 = r2.itemView
                            r4.getClass()
                            com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ r5 = new com.xiaomi.smarthome.operation.js_sdk.titlebar.-$$Lambda$K3zhJ9HhkSO4qTQ9p9JhLHWMaEQ
                            r5.<init>(r4)
                            r0 = 200(0xc8, double:9.9E-322)
                            r3.postDelayed(r5, r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass1.O000000o.C0088O000000o.O000000o(com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu$O000000o, android.widget.PopupWindow, android.view.View):void");
                    }
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
                 arg types: [?, android.view.ViewGroup, int]
                 candidates:
                  ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
                  ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
                public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                    return new C0088O000000o((ViewGroup) LayoutInflater.from(TitleBarMenu.this.getContext()).inflate((int) R.layout.title_icon_text_menu_layout, viewGroup, false));
                }
            }
        };
        this.O00000Oo = new ArrayList();
        this.O00000o0 = new ArrayList();
        setOrientation(0);
        this.f10526O000000o.O00000oO = R.drawable.std_tittlebar_main_device_more;
    }

    public void setOmit(boolean z) {
        boolean z2 = this.O00000o;
        if (z2 != z) {
            if (z2) {
                setOptionsMenu(Collections.emptyList());
                O000000o();
            }
            this.O00000o = z;
        }
    }

    public static class O000000o {
        public String O00000Oo;
        public Bitmap O00000o;
        public String O00000o0;
        public int O00000oO = -1;
        public int O00000oo = -1;

        /* access modifiers changed from: protected */
        public void O000000o(View view, O000000o o000000o) {
        }

        public O000000o(String str, String str2) {
            this.O00000Oo = str;
            this.O00000o0 = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                O000000o o000000o = (O000000o) obj;
                String str = this.O00000Oo;
                if (str == null ? o000000o.O00000Oo != null : !str.equals(o000000o.O00000Oo)) {
                    return false;
                }
                String str2 = this.O00000o0;
                if (str2 != null) {
                    return str2.equals(o000000o.O00000o0);
                }
                if (o000000o.O00000o0 == null) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.O00000Oo;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.O00000o0;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Menu{id='" + this.O00000Oo + '\'' + ", title='" + this.O00000o0 + '\'' + ", iconResId=" + this.O00000oO + ", badge=" + this.O00000oo + '}';
        }
    }

    public void setOptionsMenu(List<O000000o> list) {
        ArrayList<O000000o> arrayList = new ArrayList<>();
        for (O000000o next : list) {
            if (next.O00000o == null && next.O00000oO == -1) {
                gsy.O00000Oo("TitleBarMenu", "setOptionsMenu: menu.iconBitmap is null. " + next.toString());
            } else {
                arrayList.add(next);
            }
        }
        this.O00000Oo.clear();
        removeAllViews();
        for (O000000o O000000o2 : arrayList) {
            O000000o(O000000o2);
        }
        if (!this.O00000o0.isEmpty()) {
            O000000o(this.f10526O000000o);
        }
    }

    public final void O000000o(O000000o o000000o) {
        if (o000000o.O00000o == null && o000000o.O00000oO == -1) {
            gsy.O00000Oo("TitleBarMenu", "appendOptionMenu: menu.iconBitmap is null. " + o000000o.toString());
        } else if (!O000000o(this.O00000Oo, o000000o)) {
            this.O00000Oo.add(o000000o);
            if (!this.O00000o) {
                addView(O00000o0(o000000o));
            }
        }
    }

    public static boolean O000000o(List<O000000o> list, O000000o o000000o) {
        for (O000000o o000000o2 : list) {
            if (TextUtils.equals(o000000o2.O00000Oo, o000000o.O00000Oo)) {
                return true;
            }
        }
        return false;
    }

    public List<O000000o> getOptionMenus() {
        return this.O00000Oo;
    }

    public List<O000000o> getDropDownMenus() {
        return this.O00000o0;
    }

    public final void O00000Oo(O000000o o000000o) {
        boolean z;
        Iterator<O000000o> it = this.O00000Oo.iterator();
        while (true) {
            if (it.hasNext()) {
                if (TextUtils.equals(o000000o.O00000Oo, it.next().O00000Oo)) {
                    it.remove();
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            removeAllViews();
            setOptionsMenu(this.O00000Oo);
        }
    }

    public void setDropDownMenu(List<O000000o> list) {
        ArrayList arrayList = new ArrayList();
        for (O000000o next : list) {
            if (next.O00000o == null && TextUtils.isEmpty(next.O00000o0) && next.O00000oO == -1) {
                gsy.O000000o(3, "TitleBarMenu", "setDropDownMenu: both menu.iconBitmap && menu.title are null");
            } else {
                arrayList.add(next);
            }
        }
        this.O00000o0.clear();
        this.O00000o0.addAll(arrayList);
        if (!this.O00000o0.isEmpty()) {
            O000000o(this.f10526O000000o);
        } else {
            O00000Oo(this.f10526O000000o);
        }
    }

    public final void O000000o() {
        this.O00000o0.clear();
        O00000Oo(this.f10526O000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View O00000o0(final O000000o o000000o) {
        int i = 0;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate((int) R.layout.title_icon_menu_layout, (ViewGroup) this, false);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.operation.js_sdk.titlebar.TitleBarMenu.AnonymousClass2 */

            public final void onClick(View view) {
                O000000o o000000o = o000000o;
                o000000o.O000000o(view, o000000o);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            viewGroup.setBackgroundResource(R.drawable.item_ripple_10_radius);
        }
        ImageButton imageButton = (ImageButton) viewGroup.findViewById(R.id.menu_icon);
        TextView textView = (TextView) viewGroup.findViewById(R.id.badge);
        imageButton.setBackground(null);
        if (o000000o.O00000o != null) {
            imageButton.setImageBitmap(o000000o.O00000o);
        } else if (o000000o.O00000oO != -1) {
            imageButton.setImageResource(o000000o.O00000oO);
        }
        if (o000000o.O00000oo == -1) {
            i = 8;
        }
        textView.setVisibility(i);
        return viewGroup;
    }
}
