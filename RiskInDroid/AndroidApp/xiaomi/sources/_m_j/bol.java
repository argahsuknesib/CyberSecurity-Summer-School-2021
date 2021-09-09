package _m_j;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.lidroid.xutils.task.Priority;
import com.lidroid.xutils.task.PriorityAsyncTask;
import com.lidroid.xutils.task.PriorityExecutor;
import java.io.File;
import java.util.HashMap;

public final class bol {
    private static final PriorityExecutor O0000Oo = new PriorityExecutor(2);
    private static final PriorityExecutor O0000Oo0 = new PriorityExecutor(5);
    private static final HashMap<String, bol> O0000o0O = new HashMap<>(1);

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13170O000000o;
    public int O00000Oo = 4194304;
    public boolean O00000o = true;
    public int O00000o0 = 52428800;
    public boolean O00000oO = true;
    bom O00000oo;
    public bop O0000O0o;
    public boj O0000OOo;
    private long O0000OoO = 2592000000L;
    private int O0000Ooo = 15000;
    private Context O0000o0;
    private int O0000o00 = 15000;

    private bol(Context context, String str) {
        if (context != null) {
            this.O0000o0 = context;
            this.f13170O000000o = str;
            new O000000o(this, (byte) 0).O00000o0(0);
            new O000000o(this, (byte) 0).O00000o0(1);
            return;
        }
        throw new IllegalArgumentException("context may not be null");
    }

    public static synchronized bol O000000o(Context context, String str) {
        File cacheDir;
        File externalCacheDir;
        synchronized (bol.class) {
            String str2 = null;
            if (TextUtils.isEmpty(null)) {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalCacheDir = context.getExternalCacheDir()) != null) {
                    str2 = externalCacheDir.getPath();
                }
                if (str2 == null && (cacheDir = context.getCacheDir()) != null && cacheDir.exists()) {
                    str2 = cacheDir.getPath();
                }
                str = String.valueOf(str2) + File.separator + "xBitmapCache";
            }
            if (O0000o0O.containsKey(str)) {
                bol bol = O0000o0O.get(str);
                return bol;
            }
            bol bol2 = new bol(context, str);
            O0000o0O.put(str, bol2);
            return bol2;
        }
    }

    class O000000o extends PriorityAsyncTask<Object, Void, Object[]> {
        public final /* synthetic */ void O000000o(Object obj) {
            Object[] objArr = (Object[]) obj;
            if (bol.this.O0000OOo != null && objArr != null && objArr.length != 0) {
                try {
                    switch (((Integer) objArr[0]).intValue()) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            return;
                        case 7:
                            if (objArr.length == 2) {
                                String.valueOf(objArr[1]);
                                return;
                            }
                            return;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            if (objArr.length == 2) {
                                String.valueOf(objArr[1]);
                                return;
                            }
                            return;
                        case 9:
                            if (objArr.length == 2) {
                                String.valueOf(objArr[1]);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    brm.O000000o(th.getMessage(), th);
                }
            }
        }

        private O000000o() {
            this.O00000oo = Priority.UI_TOP;
        }

        /* synthetic */ O000000o(bol bol, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:34|(2:36|37)|38|39) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0081 */
        /* renamed from: O00000oO */
        public Object[] O000000o(Object... objArr) {
            if (!(objArr == null || objArr.length == 0)) {
                bol bol = bol.this;
                if (bol.O00000oo == null) {
                    bol.O00000oo = new bom(bol);
                }
                bom bom = bol.O00000oo;
                if (bom == null) {
                    return objArr;
                }
                try {
                    switch (((Integer) objArr[0]).intValue()) {
                        case 0:
                            if (bom.O00000Oo.O00000o) {
                                if (bom.f13172O000000o != null) {
                                    bom.O00000Oo();
                                }
                                bom.f13172O000000o = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008a: IPUT  
                                      (wrap: _m_j.bom$1 : 0x0087: CONSTRUCTOR  (r1v9 _m_j.bom$1) = 
                                      (r0v2 'bom' _m_j.bom)
                                      (wrap: int : 0x0085: IGET  (r2v2 int) = (wrap: _m_j.bol : 0x0083: IGET  (r2v1 _m_j.bol) = (r0v2 'bom' _m_j.bom) _m_j.bom.O00000Oo _m_j.bol) _m_j.bol.O00000Oo int)
                                     call: _m_j.bom.1.<init>(_m_j.bom, int):void type: CONSTRUCTOR)
                                      (r0v2 'bom' _m_j.bom)
                                     _m_j.bom.O000000o _m_j.bor in method: _m_j.bol.O000000o.O00000oO(java.lang.Object[]):java.lang.Object[], dex: classes6.dex
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
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:286)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0087: CONSTRUCTOR  (r1v9 _m_j.bom$1) = 
                                      (r0v2 'bom' _m_j.bom)
                                      (wrap: int : 0x0085: IGET  (r2v2 int) = (wrap: _m_j.bol : 0x0083: IGET  (r2v1 _m_j.bol) = (r0v2 'bom' _m_j.bom) _m_j.bom.O00000Oo _m_j.bol) _m_j.bol.O00000Oo int)
                                     call: _m_j.bom.1.<init>(_m_j.bom, int):void type: CONSTRUCTOR in method: _m_j.bol.O000000o.O00000oO(java.lang.Object[]):java.lang.Object[], dex: classes6.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 71 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.bom, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 75 more
                                    */
                                /* JADX WARNING: Can't wrap try/catch for region: R(4:34|(2:36|37)|38|39) */
                                /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0081 */
                                /*
                                    this = this;
                                    if (r5 == 0) goto L_0x0095
                                    int r0 = r5.length
                                    if (r0 != 0) goto L_0x0007
                                    goto L_0x0095
                                L_0x0007:
                                    _m_j.bol r0 = _m_j.bol.this
                                    _m_j.bom r1 = r0.O00000oo
                                    if (r1 != 0) goto L_0x0014
                                    _m_j.bom r1 = new _m_j.bom
                                    r1.<init>(r0)
                                    r0.O00000oo = r1
                                L_0x0014:
                                    _m_j.bom r0 = r0.O00000oo
                                    if (r0 != 0) goto L_0x0019
                                    return r5
                                L_0x0019:
                                    r1 = 0
                                    r1 = r5[r1]     // Catch:{ Throwable -> 0x008d }
                                    java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Throwable -> 0x008d }
                                    int r1 = r1.intValue()     // Catch:{ Throwable -> 0x008d }
                                    r2 = 1
                                    r3 = 2
                                    switch(r1) {
                                        case 0: goto L_0x0074;
                                        case 1: goto L_0x0070;
                                        case 2: goto L_0x006c;
                                        case 3: goto L_0x0065;
                                        case 4: goto L_0x005e;
                                        case 5: goto L_0x005a;
                                        case 6: goto L_0x0056;
                                        case 7: goto L_0x0045;
                                        case 8: goto L_0x0037;
                                        case 9: goto L_0x0029;
                                        default: goto L_0x0027;
                                    }     // Catch:{ Throwable -> 0x008d }
                                L_0x0027:
                                    goto L_0x0095
                                L_0x0029:
                                    int r1 = r5.length     // Catch:{ Throwable -> 0x008d }
                                    if (r1 == r3) goto L_0x002d
                                    return r5
                                L_0x002d:
                                    r1 = r5[r2]     // Catch:{ Throwable -> 0x008d }
                                    java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x008d }
                                    r0.O00000Oo(r1)     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x0037:
                                    int r1 = r5.length     // Catch:{ Throwable -> 0x008d }
                                    if (r1 == r3) goto L_0x003b
                                    return r5
                                L_0x003b:
                                    r1 = r5[r2]     // Catch:{ Throwable -> 0x008d }
                                    java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x008d }
                                    r0.O000000o(r1)     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x0045:
                                    int r1 = r5.length     // Catch:{ Throwable -> 0x008d }
                                    if (r1 == r3) goto L_0x0049
                                    return r5
                                L_0x0049:
                                    r1 = r5[r2]     // Catch:{ Throwable -> 0x008d }
                                    java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x008d }
                                    r0.O000000o(r1)     // Catch:{ Throwable -> 0x008d }
                                    r0.O00000Oo(r1)     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x0056:
                                    r0.O00000o0()     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x005a:
                                    r0.O00000Oo()     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x005e:
                                    r0.O00000Oo()     // Catch:{ Throwable -> 0x008d }
                                    r0.O00000o0()     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x0065:
                                    r0.O00000Oo()     // Catch:{ Throwable -> 0x008d }
                                    r0.O00000oO()     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x006c:
                                    r0.O00000o()     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x0070:
                                    r0.O000000o()     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x0074:
                                    _m_j.bol r1 = r0.O00000Oo     // Catch:{ Throwable -> 0x008d }
                                    boolean r1 = r1.O00000o     // Catch:{ Throwable -> 0x008d }
                                    if (r1 == 0) goto L_0x0095
                                    _m_j.bor<_m_j.bom$O000000o, android.graphics.Bitmap> r1 = r0.f13172O000000o     // Catch:{ Throwable -> 0x008d }
                                    if (r1 == 0) goto L_0x0081
                                    r0.O00000Oo()     // Catch:{ Throwable -> 0x0081 }
                                L_0x0081:
                                    _m_j.bom$1 r1 = new _m_j.bom$1     // Catch:{ Throwable -> 0x008d }
                                    _m_j.bol r2 = r0.O00000Oo     // Catch:{ Throwable -> 0x008d }
                                    int r2 = r2.O00000Oo     // Catch:{ Throwable -> 0x008d }
                                    r1.<init>(r2)     // Catch:{ Throwable -> 0x008d }
                                    r0.f13172O000000o = r1     // Catch:{ Throwable -> 0x008d }
                                    goto L_0x0095
                                L_0x008d:
                                    r0 = move-exception
                                    java.lang.String r1 = r0.getMessage()
                                    _m_j.brm.O000000o(r1, r0)
                                L_0x0095:
                                    return r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: _m_j.bol.O000000o.O000000o(java.lang.Object[]):java.lang.Object[]");
                            }
                        }
                    }
