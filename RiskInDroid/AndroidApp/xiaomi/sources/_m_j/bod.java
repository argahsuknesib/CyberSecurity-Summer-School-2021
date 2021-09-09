package _m_j;

import _m_j.boe;
import _m_j.bof;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

public final class bod implements boe.O000000o, bof.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public bof f13155O000000o;
    private boe O00000Oo;
    private String O00000o = Environment.getExternalStorageDirectory().getPath();
    private Context O00000o0;
    private O000000o O00000oO;

    public interface O000000o {
        void O000000o();
    }

    static {
        System.loadLibrary("sinvoice");
    }

    public bod(Context context, O000000o o000000o) {
        this.O00000o0 = context;
        this.O00000oO = o000000o;
        this.f13155O000000o = new bof(context, this);
        this.O00000Oo = new boe(context, this);
    }

    public final boolean O000000o() {
        return 1 == this.f13155O000000o.O00000o0;
    }

    public final void O00000o0() {
        bof bof = this.f13155O000000o;
        bof.f13160O000000o.O00000o.destroy();
        boa boa = bof.O00000Oo;
        if (boa.O00000oO != null) {
            boa.O00000oO.stop();
            boa.O00000oO.release();
        }
        this.O00000Oo.O00000o0.O00000oO.destroy();
    }

    public final void O00000o() {
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public final void O000000o(String str) {
        if (this.O00000oO != null) {
            TextUtils.isEmpty(str);
        }
    }

    public final void O00000Oo() {
        this.f13155O000000o.O00000o();
        bnx bnx = this.f13155O000000o.f13160O000000o;
        bnx.O00000oo = 1;
        bnx.O00000o.setEffect(1);
        boe boe = this.O00000Oo;
        if (1 == boe.O00000oo) {
            boe.O00000oo = 2;
            bob bob = boe.O00000Oo;
            if (1 == bob.f13153O000000o) {
                bob.f13153O000000o = 2;
            }
            bog bog = boe.O00000o0;
            if (1 == bog.f13164O000000o) {
                bog.f13164O000000o = 2;
            }
            boe.f13156O000000o.O00000Oo();
            if (boe.O00000o != null) {
                try {
                    boe.O00000o.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    boe.O00000o = null;
                    throw th;
                }
                boe.O00000o = null;
            }
            if (boe.O00000oO != null) {
                try {
                    boe.O00000oO.join();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (Throwable th2) {
                    boe.O00000oO = null;
                    throw th2;
                }
                boe.O00000oO = null;
            }
        }
        this.O00000Oo.O00000o0.O00000oO.setEffect(1);
        boe boe2 = this.O00000Oo;
        if (2 == boe2.O00000oo) {
            boe2.O00000oo = 1;
            boe2.f13156O000000o.O000000o();
            boe2.O00000oO = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0077: IPUT  
                  (wrap: _m_j.boe$2 : 0x0074: CONSTRUCTOR  (r1v2 _m_j.boe$2) = (r0v8 'boe2' _m_j.boe) call: _m_j.boe.2.<init>(_m_j.boe):void type: CONSTRUCTOR)
                  (r0v8 'boe2' _m_j.boe)
                 _m_j.boe.O00000oO java.lang.Thread in method: _m_j.bod.O00000Oo():void, dex: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0074: CONSTRUCTOR  (r1v2 _m_j.boe$2) = (r0v8 'boe2' _m_j.boe) call: _m_j.boe.2.<init>(_m_j.boe):void type: CONSTRUCTOR in method: _m_j.bod.O00000Oo():void, dex: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 38 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.boe, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 42 more
                */
            /*
                this = this;
                _m_j.bof r0 = r5.f13155O000000o
                r0.O00000o()
                _m_j.bof r0 = r5.f13155O000000o
                _m_j.bnx r0 = r0.f13160O000000o
                r1 = 1
                r0.O00000oo = r1
                com.libra.sinvoice.VoiceEncoder r0 = r0.O00000o
                r0.setEffect(r1)
                _m_j.boe r0 = r5.O00000Oo
                int r2 = r0.O00000oo
                r3 = 2
                if (r1 != r2) goto L_0x005c
                r0.O00000oo = r3
                _m_j.bob r2 = r0.O00000Oo
                int r4 = r2.f13153O000000o
                if (r1 != r4) goto L_0x0022
                r2.f13153O000000o = r3
            L_0x0022:
                _m_j.bog r2 = r0.O00000o0
                int r4 = r2.f13164O000000o
                if (r1 != r4) goto L_0x002a
                r2.f13164O000000o = r3
            L_0x002a:
                _m_j.bnw r2 = r0.f13156O000000o
                r2.O00000Oo()
                java.lang.Thread r2 = r0.O00000o
                r4 = 0
                if (r2 == 0) goto L_0x0046
                java.lang.Thread r2 = r0.O00000o     // Catch:{ InterruptedException -> 0x003e }
                r2.join()     // Catch:{ InterruptedException -> 0x003e }
            L_0x0039:
                r0.O00000o = r4
                goto L_0x0046
            L_0x003c:
                r1 = move-exception
                goto L_0x0043
            L_0x003e:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ all -> 0x003c }
                goto L_0x0039
            L_0x0043:
                r0.O00000o = r4
                throw r1
            L_0x0046:
                java.lang.Thread r2 = r0.O00000oO
                if (r2 == 0) goto L_0x005c
                java.lang.Thread r2 = r0.O00000oO     // Catch:{ InterruptedException -> 0x0054 }
                r2.join()     // Catch:{ InterruptedException -> 0x0054 }
            L_0x004f:
                r0.O00000oO = r4
                goto L_0x005c
            L_0x0052:
                r1 = move-exception
                goto L_0x0059
            L_0x0054:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ all -> 0x0052 }
                goto L_0x004f
            L_0x0059:
                r0.O00000oO = r4
                throw r1
            L_0x005c:
                _m_j.boe r0 = r5.O00000Oo
                _m_j.bog r0 = r0.O00000o0
                com.libra.sinvoice.VoiceDecoder r0 = r0.O00000oO
                r0.setEffect(r1)
                _m_j.boe r0 = r5.O00000Oo
                int r2 = r0.O00000oo
                if (r3 != r2) goto L_0x0093
                r0.O00000oo = r1
                _m_j.bnw r1 = r0.f13156O000000o
                r1.O000000o()
                _m_j.boe$2 r1 = new _m_j.boe$2
                r1.<init>()
                r0.O00000oO = r1
                java.lang.Thread r1 = r0.O00000oO
                if (r1 == 0) goto L_0x0082
                java.lang.Thread r1 = r0.O00000oO
                r1.start()
            L_0x0082:
                _m_j.boe$3 r1 = new _m_j.boe$3
                r2 = 0
                r1.<init>(r2)
                r0.O00000o = r1
                java.lang.Thread r1 = r0.O00000o
                if (r1 == 0) goto L_0x0093
                java.lang.Thread r0 = r0.O00000o
                r0.start()
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: _m_j.bod.O00000Oo():void");
        }
    }
