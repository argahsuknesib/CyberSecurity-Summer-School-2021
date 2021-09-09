package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import java.io.IOException;

final class FlacBinarySearchSeeker extends BinarySearchSeeker {
    /* JADX WARNING: Illegal instructions before constructor call */
    public FlacBinarySearchSeeker(FlacStreamMetadata flacStreamMetadata, int i, long j, long j2) {
        super(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002b: CONSTRUCTOR  
              (wrap: com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE : 0x0007: CONSTRUCTOR  (r1v0 com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE) = (r0v0 com.google.android.exoplayer2.extractor.FlacStreamMetadata) call: com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata):void type: CONSTRUCTOR)
              (wrap: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker : 0x000f: CONSTRUCTOR  (r2v0 com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker) = 
              (r0v0 com.google.android.exoplayer2.extractor.FlacStreamMetadata)
              (r18v0 'i' int)
              (null com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$1)
             call: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.FlacTimestampSeeker.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata, int, com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$1):void type: CONSTRUCTOR)
              (wrap: long : 0x0012: INVOKE  (r3v1 long) = (r17v0 'flacStreamMetadata' com.google.android.exoplayer2.extractor.FlacStreamMetadata) type: VIRTUAL call: com.google.android.exoplayer2.extractor.FlacStreamMetadata.getDurationUs():long)
              (0 long)
              (wrap: long : 0x0016: IGET  (r7v0 long) = (r0v0 com.google.android.exoplayer2.extractor.FlacStreamMetadata) com.google.android.exoplayer2.extractor.FlacStreamMetadata.totalSamples long)
              (r19v0 'j' long)
              (r21v0 'j2' long)
              (wrap: long : 0x0018: INVOKE  (r13v0 long) = (r17v0 'flacStreamMetadata' com.google.android.exoplayer2.extractor.FlacStreamMetadata) type: VIRTUAL call: com.google.android.exoplayer2.extractor.FlacStreamMetadata.getApproxBytesPerFrame():long)
              (wrap: int : 0x001f: INVOKE  (r15v0 int) = 
              (6 int)
              (wrap: int : 0x001c: IGET  (r0v1 int) = (r0v0 com.google.android.exoplayer2.extractor.FlacStreamMetadata) com.google.android.exoplayer2.extractor.FlacStreamMetadata.minFrameSize int)
             type: STATIC call: java.lang.Math.max(int, int):int)
             call: com.google.android.exoplayer2.extractor.BinarySearchSeeker.<init>(com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekTimestampConverter, com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker, long, long, long, long, long, long, int):void type: SUPER in method: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata, int, long, long):void, dex: classes2.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: CONSTRUCTOR  (r1v0 com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE) = (r0v0 com.google.android.exoplayer2.extractor.FlacStreamMetadata) call: com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata, int, long, long):void, dex: classes2.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:642)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 31 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 37 more
            */
        /* JADX WARNING: Illegal instructions before constructor call */
        /*
            this = this;
            r0 = r17
            r17.getClass()
            com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE r1 = new com.google.android.exoplayer2.extractor.flac.-$$Lambda$RZnT0uiLg1lxLrLWgcUlQQYkZkE
            r1.<init>(r0)
            com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker r2 = new com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker
            r3 = 0
            r4 = r18
            r2.<init>(r0, r4)
            long r3 = r17.getDurationUs()
            long r7 = r0.totalSamples
            long r13 = r17.getApproxBytesPerFrame()
            int r0 = r0.minFrameSize
            r5 = 6
            int r15 = java.lang.Math.max(r5, r0)
            r5 = 0
            r0 = r16
            r9 = r19
            r11 = r21
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata, int, long, long):void");
    }

    static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final FlacStreamMetadata flacStreamMetadata;
        private final int frameStartMarker;
        private final FlacFrameReader.SampleNumberHolder sampleNumberHolder;

        public /* synthetic */ void onSeekFinished() {
            BinarySearchSeeker.TimestampSeeker.CC.$default$onSeekFinished(this);
        }

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata2, int i) {
            this.flacStreamMetadata = flacStreamMetadata2;
            this.frameStartMarker = i;
            this.sampleNumberHolder = new FlacFrameReader.SampleNumberHolder();
        }

        public final BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            long findNextFrame = findNextFrame(extractorInput);
            long peekPosition = extractorInput.getPeekPosition();
            extractorInput.advancePeekPosition(Math.max(6, this.flacStreamMetadata.minFrameSize));
            long findNextFrame2 = findNextFrame(extractorInput);
            long peekPosition2 = extractorInput.getPeekPosition();
            if (findNextFrame <= j && findNextFrame2 > j) {
                return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(peekPosition);
            }
            if (findNextFrame2 <= j) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(findNextFrame2, peekPosition2);
            }
            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(findNextFrame, position);
        }

        private long findNextFrame(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.getPeekPosition() < extractorInput.getLength() - 6 && !FlacFrameReader.checkFrameHeaderFromPeek(extractorInput, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                extractorInput.advancePeekPosition(1);
            }
            if (extractorInput.getPeekPosition() < extractorInput.getLength() - 6) {
                return this.sampleNumberHolder.sampleNumber;
            }
            extractorInput.advancePeekPosition((int) (extractorInput.getLength() - extractorInput.getPeekPosition()));
            return this.flacStreamMetadata.totalSamples;
        }
    }
}
