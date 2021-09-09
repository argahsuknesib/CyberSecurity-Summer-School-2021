package _m_j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import java.util.concurrent.ExecutorService;

public class cnx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f14158O000000o = "cnx";
    private static volatile cnx O00000oO;
    public ImageLoaderConfiguration O00000Oo;
    private cny O00000o;
    public coo O00000o0 = new coq();

    public static cnx O000000o() {
        if (O00000oO == null) {
            synchronized (cnx.class) {
                if (O00000oO == null) {
                    O00000oO = new cnx();
                }
            }
        }
        return O00000oO;
    }

    protected cnx() {
    }

    public final synchronized void O000000o(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.O00000Oo == null) {
            cou.O000000o("Initialize ImageLoader with configuration", new Object[0]);
            this.O00000o = new cny(imageLoaderConfiguration);
            this.O00000Oo = imageLoaderConfiguration;
        } else {
            cou.O00000o0("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    public final boolean O00000Oo() {
        return this.O00000Oo != null;
    }

    public final void O000000o(String str, ImageView imageView) {
        O000000o(str, new col(imageView), null, null, null);
    }

    public final void O000000o(String str, ImageView imageView, cnw cnw) {
        O000000o(str, new col(imageView), cnw, null, null);
    }

    public final void O00000o0() {
        if (this.O00000Oo == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public final void O000000o(ImageView imageView) {
        this.O00000o.O00000Oo(new col(imageView));
    }

    public final void O00000o() {
        if (this.O00000Oo != null) {
            cou.O000000o("Destroy ImageLoader", new Object[0]);
        }
        cny cny = this.O00000o;
        if (!cny.f14159O000000o.O0000Oo0) {
            ((ExecutorService) cny.O00000Oo).shutdownNow();
        }
        if (!cny.f14159O000000o.O0000Oo) {
            ((ExecutorService) cny.O00000o0).shutdownNow();
        }
        cny.O00000oO.clear();
        cny.O00000oo.clear();
        this.O00000Oo.O0000o0O.O000000o();
        this.O00000o = null;
        this.O00000Oo = null;
    }

    public final void O000000o(String str, cok cok, cnw cnw, coo coo, cop cop) {
        O00000o0();
        if (coo == null) {
            coo = this.O00000o0;
        }
        coo coo2 = coo;
        if (cnw == null) {
            cnw = this.O00000Oo.O0000oO0;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            this.O00000o.O00000Oo(cok);
            coo2.onLoadingStarted(str, cok.O00000o());
            if (!(cnw.O00000oO == null && cnw.O00000Oo == 0)) {
                z = true;
            }
            if (z) {
                cok.O000000o(cnw.O00000Oo != 0 ? this.O00000Oo.f5352O000000o.getDrawable(cnw.O00000Oo) : cnw.O00000oO);
            } else {
                cok.O000000o((Drawable) null);
            }
            coo2.onLoadingComplete(str, cok.O00000o(), null);
            return;
        }
        cod O000000o2 = cos.O000000o(cok, this.O00000Oo.O000000o());
        String str2 = str + "_" + O000000o2.f14165O000000o + "x" + O000000o2.O00000Oo;
        this.O00000o.O00000oO.put(Integer.valueOf(cok.O00000oo()), str2);
        coo2.onLoadingStarted(str, cok.O00000o());
        Bitmap O000000o3 = this.O00000Oo.O0000o0.O000000o(str2);
        if (O000000o3 == null || O000000o3.isRecycled()) {
            if (!(cnw.O00000o == null && cnw.f14156O000000o == 0)) {
                z = true;
            }
            if (z) {
                cok.O000000o(cnw.f14156O000000o != 0 ? this.O00000Oo.f5352O000000o.getDrawable(cnw.f14156O000000o) : cnw.O00000o);
            } else if (cnw.O0000O0o) {
                cok.O000000o((Drawable) null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.O00000o, new cnz(str, cok, O000000o2, str2, cnw, coo2, null, this.O00000o.O000000o(str)), O000000o(cnw));
            if (cnw.O0000oO) {
                loadAndDisplayImageTask.run();
                return;
            }
            cny cny = this.O00000o;
            cny.O00000o.execute(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x013a: INVOKE  
                  (wrap: java.util.concurrent.Executor : 0x0133: IGET  (r12v2 java.util.concurrent.Executor) = (r11v3 'cny' _m_j.cny) _m_j.cny.O00000o java.util.concurrent.Executor)
                  (wrap: _m_j.cny$1 : 0x0137: CONSTRUCTOR  (r13v14 _m_j.cny$1) = 
                  (r11v3 'cny' _m_j.cny)
                  (r10v1 'loadAndDisplayImageTask' com.nostra13.universalimageloader.core.LoadAndDisplayImageTask)
                 call: _m_j.cny.1.<init>(_m_j.cny, com.nostra13.universalimageloader.core.LoadAndDisplayImageTask):void type: CONSTRUCTOR)
                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: _m_j.cnx.O000000o(java.lang.String, _m_j.cok, _m_j.cnw, _m_j.coo, _m_j.cop):void, dex: classes6.dex
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
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0137: CONSTRUCTOR  (r13v14 _m_j.cny$1) = 
                  (r11v3 'cny' _m_j.cny)
                  (r10v1 'loadAndDisplayImageTask' com.nostra13.universalimageloader.core.LoadAndDisplayImageTask)
                 call: _m_j.cny.1.<init>(_m_j.cny, com.nostra13.universalimageloader.core.LoadAndDisplayImageTask):void type: CONSTRUCTOR in method: _m_j.cnx.O000000o(java.lang.String, _m_j.cok, _m_j.cnw, _m_j.coo, _m_j.cop):void, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 46 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.cny, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 52 more
                */
            /*
                this = this;
                r9.O00000o0()
                if (r13 != 0) goto L_0x0007
                _m_j.coo r13 = r9.O00000o0
            L_0x0007:
                r6 = r13
                if (r12 != 0) goto L_0x000e
                com.nostra13.universalimageloader.core.ImageLoaderConfiguration r12 = r9.O00000Oo
                _m_j.cnw r12 = r12.O0000oO0
            L_0x000e:
                boolean r13 = android.text.TextUtils.isEmpty(r10)
                r14 = 0
                r0 = 0
                r1 = 1
                if (r13 == 0) goto L_0x004e
                _m_j.cny r13 = r9.O00000o
                r13.O00000Oo(r11)
                android.view.View r13 = r11.O00000o()
                r6.onLoadingStarted(r10, r13)
                android.graphics.drawable.Drawable r13 = r12.O00000oO
                if (r13 != 0) goto L_0x002b
                int r13 = r12.O00000Oo
                if (r13 == 0) goto L_0x002c
            L_0x002b:
                r0 = 1
            L_0x002c:
                if (r0 == 0) goto L_0x0043
                com.nostra13.universalimageloader.core.ImageLoaderConfiguration r13 = r9.O00000Oo
                android.content.res.Resources r13 = r13.f5352O000000o
                int r0 = r12.O00000Oo
                if (r0 == 0) goto L_0x003d
                int r12 = r12.O00000Oo
                android.graphics.drawable.Drawable r12 = r13.getDrawable(r12)
                goto L_0x003f
            L_0x003d:
                android.graphics.drawable.Drawable r12 = r12.O00000oO
            L_0x003f:
                r11.O000000o(r12)
                goto L_0x0046
            L_0x0043:
                r11.O000000o(r14)
            L_0x0046:
                android.view.View r11 = r11.O00000o()
                r6.onLoadingComplete(r10, r11, r14)
                return
            L_0x004e:
                com.nostra13.universalimageloader.core.ImageLoaderConfiguration r13 = r9.O00000Oo
                _m_j.cod r13 = r13.O000000o()
                _m_j.cod r3 = _m_j.cos.O000000o(r11, r13)
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>(r10)
                java.lang.String r2 = "_"
                r13.append(r2)
                int r2 = r3.f14165O000000o
                r13.append(r2)
                java.lang.String r2 = "x"
                r13.append(r2)
                int r2 = r3.O00000Oo
                r13.append(r2)
                java.lang.String r4 = r13.toString()
                _m_j.cny r13 = r9.O00000o
                java.util.Map<java.lang.Integer, java.lang.String> r13 = r13.O00000oO
                int r2 = r11.O00000oo()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r13.put(r2, r4)
                android.view.View r13 = r11.O00000o()
                r6.onLoadingStarted(r10, r13)
                com.nostra13.universalimageloader.core.ImageLoaderConfiguration r13 = r9.O00000Oo
                _m_j.cns r13 = r13.O0000o0
                android.graphics.Bitmap r13 = r13.O000000o(r4)
                if (r13 == 0) goto L_0x00e7
                boolean r2 = r13.isRecycled()
                if (r2 != 0) goto L_0x00e7
                java.lang.Object[] r14 = new java.lang.Object[r1]
                r14[r0] = r4
                java.lang.String r0 = "Load image from memory cache [%s]"
                _m_j.cou.O000000o(r0, r14)
                boolean r14 = r12.O000000o()
                if (r14 == 0) goto L_0x00d8
                _m_j.cnz r14 = new _m_j.cnz
                r7 = 0
                _m_j.cny r0 = r9.O00000o
                java.util.concurrent.locks.ReentrantLock r8 = r0.O000000o(r10)
                r0 = r14
                r1 = r10
                r2 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                _m_j.coa r10 = new _m_j.coa
                _m_j.cny r11 = r9.O00000o
                android.os.Handler r0 = O000000o(r12)
                r10.<init>(r11, r13, r14, r0)
                boolean r11 = r12.O0000oO
                if (r11 == 0) goto L_0x00cd
                r10.run()
                return
            L_0x00cd:
                _m_j.cny r11 = r9.O00000o
                r11.O000000o()
                java.util.concurrent.Executor r11 = r11.O00000o0
                r11.execute(r10)
                return
            L_0x00d8:
                _m_j.coi r12 = r12.O0000o
                com.nostra13.universalimageloader.core.assist.LoadedFrom r14 = com.nostra13.universalimageloader.core.assist.LoadedFrom.MEMORY_CACHE
                r12.O000000o(r13, r11)
                android.view.View r11 = r11.O00000o()
                r6.onLoadingComplete(r10, r11, r13)
                return
            L_0x00e7:
                android.graphics.drawable.Drawable r13 = r12.O00000o
                if (r13 != 0) goto L_0x00ef
                int r13 = r12.f14156O000000o
                if (r13 == 0) goto L_0x00f0
            L_0x00ef:
                r0 = 1
            L_0x00f0:
                if (r0 == 0) goto L_0x0107
                com.nostra13.universalimageloader.core.ImageLoaderConfiguration r13 = r9.O00000Oo
                android.content.res.Resources r13 = r13.f5352O000000o
                int r14 = r12.f14156O000000o
                if (r14 == 0) goto L_0x0101
                int r14 = r12.f14156O000000o
                android.graphics.drawable.Drawable r13 = r13.getDrawable(r14)
                goto L_0x0103
            L_0x0101:
                android.graphics.drawable.Drawable r13 = r12.O00000o
            L_0x0103:
                r11.O000000o(r13)
                goto L_0x010e
            L_0x0107:
                boolean r13 = r12.O0000O0o
                if (r13 == 0) goto L_0x010e
                r11.O000000o(r14)
            L_0x010e:
                _m_j.cnz r13 = new _m_j.cnz
                r7 = 0
                _m_j.cny r14 = r9.O00000o
                java.util.concurrent.locks.ReentrantLock r8 = r14.O000000o(r10)
                r0 = r13
                r1 = r10
                r2 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                com.nostra13.universalimageloader.core.LoadAndDisplayImageTask r10 = new com.nostra13.universalimageloader.core.LoadAndDisplayImageTask
                _m_j.cny r11 = r9.O00000o
                android.os.Handler r14 = O000000o(r12)
                r10.<init>(r11, r13, r14)
                boolean r11 = r12.O0000oO
                if (r11 == 0) goto L_0x0131
                r10.run()
                return
            L_0x0131:
                _m_j.cny r11 = r9.O00000o
                java.util.concurrent.Executor r12 = r11.O00000o
                _m_j.cny$1 r13 = new _m_j.cny$1
                r13.<init>(r10)
                r12.execute(r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.cnx.O000000o(java.lang.String, _m_j.cok, _m_j.cnw, _m_j.coo, _m_j.cop):void");
        }

        public final void O000000o(String str, ImageView imageView, cnw cnw, coo coo) {
            O000000o(str, new col(imageView), cnw, coo, null);
        }

        private static Handler O000000o(cnw cnw) {
            Handler handler = cnw.O0000oO0;
            if (cnw.O0000oO) {
                return null;
            }
            return (handler == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : handler;
        }
    }
