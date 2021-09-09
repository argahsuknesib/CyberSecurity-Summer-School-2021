package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY implements Function {
    public static final /* synthetic */ $$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY INSTANCE = new $$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY();

    private /* synthetic */ $$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY() {
    }

    public final Object apply(Object obj) {
        return CollectSpliterators.map(((Collection) ((Map.Entry) obj).getValue()).spliterator(), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: RETURN  
              (wrap: java.util.Spliterator : 0x0002: INVOKE  (r1v2 java.util.Spliterator) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: STATIC call: com.google.common.collect.AbstractMapBasedMultimap.lambda$entrySpliterator$1(java.util.Map$Entry):java.util.Spliterator)
             in method: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY.apply(java.lang.Object):java.lang.Object, dex: classes3.dex
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
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE  (r1v2 java.util.Spliterator) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: STATIC call: com.google.common.collect.AbstractMapBasedMultimap.lambda$entrySpliterator$1(java.util.Map$Entry):java.util.Spliterator in method: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY.apply(java.lang.Object):java.lang.Object, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:313)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 31 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: ONE_ARG  
              (wrap: java.util.Spliterator : 0x0013: INVOKE  (r2v4 java.util.Spliterator) = 
              (wrap: java.util.Spliterator : 0x000a: INVOKE  (r2v3 java.util.Spliterator) = 
              (wrap: java.util.Collection : 0x0008: CHECK_CAST  (r2v2 java.util.Collection) = (java.util.Collection) (wrap: java.lang.Object : 0x0004: INVOKE  (r2v1 java.lang.Object) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object))
             type: INTERFACE call: java.util.Collection.spliterator():java.util.Spliterator)
              (wrap: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ : 0x0010: CONSTRUCTOR  (r1v0 com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ) = 
              (wrap: java.lang.Object : 0x0000: INVOKE  (r0v0 java.lang.Object) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object)
             call: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ.<init>(java.lang.Object):void type: CONSTRUCTOR)
             type: STATIC call: com.google.common.collect.CollectSpliterators.map(java.util.Spliterator, java.util.function.Function):java.util.Spliterator)
             in method: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY.apply(java.lang.Object):java.lang.Object, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:865)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:686)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 35 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE  (r2v4 java.util.Spliterator) = 
              (wrap: java.util.Spliterator : 0x000a: INVOKE  (r2v3 java.util.Spliterator) = 
              (wrap: java.util.Collection : 0x0008: CHECK_CAST  (r2v2 java.util.Collection) = (java.util.Collection) (wrap: java.lang.Object : 0x0004: INVOKE  (r2v1 java.lang.Object) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object))
             type: INTERFACE call: java.util.Collection.spliterator():java.util.Spliterator)
              (wrap: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ : 0x0010: CONSTRUCTOR  (r1v0 com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ) = 
              (wrap: java.lang.Object : 0x0000: INVOKE  (r0v0 java.lang.Object) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object)
             call: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ.<init>(java.lang.Object):void type: CONSTRUCTOR)
             type: STATIC call: com.google.common.collect.CollectSpliterators.map(java.util.Spliterator, java.util.function.Function):java.util.Spliterator in method: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY.apply(java.lang.Object):java.lang.Object, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:97)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:481)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 39 more
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r1v0 com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ) = 
              (wrap: java.lang.Object : 0x0000: INVOKE  (r0v0 java.lang.Object) = 
              (wrap: java.util.Map$Entry : 0x0000: CHECK_CAST  (r1v1 java.util.Map$Entry) = (java.util.Map$Entry) (r1v0 'obj' java.lang.Object))
             type: INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object)
             call: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ.<init>(java.lang.Object):void type: CONSTRUCTOR in method: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY.apply(java.lang.Object):java.lang.Object, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 44 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.common.collect.-$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 50 more
            */
        /*
            this = this;
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.util.Spliterator r1 = com.google.common.collect.CollectSpliterators.map(((java.util.Collection) r1.getValue()).spliterator(), new com.google.common.collect.$$Lambda$AbstractMapBasedMultimap$LZeF0aE0_zVLsxZdv41rGXc8McQ(r1.getKey()))
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.$$Lambda$AbstractMapBasedMultimap$GMPqKIl8YmjBXAn2_BtVZGwD6YY.apply(java.lang.Object):java.lang.Object");
    }
}
