package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {
    private final int allocationLength;
    private final Allocator allocator;
    private AllocationNode firstAllocationNode = new AllocationNode(0, this.allocationLength);
    private AllocationNode readAllocationNode;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesWritten;
    private AllocationNode writeAllocationNode;

    public SampleDataQueue(Allocator allocator2) {
        this.allocator = allocator2;
        this.allocationLength = allocator2.getIndividualAllocationLength();
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    public void reset() {
        clearAllocationNodes(this.firstAllocationNode);
        this.firstAllocationNode = new AllocationNode(0, this.allocationLength);
        AllocationNode allocationNode = this.firstAllocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0;
        this.allocator.trim();
    }

    public void discardUpstreamSampleBytes(long j) {
        this.totalBytesWritten = j;
        long j2 = this.totalBytesWritten;
        if (j2 == 0 || j2 == this.firstAllocationNode.startPosition) {
            clearAllocationNodes(this.firstAllocationNode);
            this.firstAllocationNode = new AllocationNode(this.totalBytesWritten, this.allocationLength);
            AllocationNode allocationNode = this.firstAllocationNode;
            this.readAllocationNode = allocationNode;
            this.writeAllocationNode = allocationNode;
            return;
        }
        AllocationNode allocationNode2 = this.firstAllocationNode;
        while (this.totalBytesWritten > allocationNode2.endPosition) {
            allocationNode2 = allocationNode2.next;
        }
        AllocationNode allocationNode3 = allocationNode2.next;
        clearAllocationNodes(allocationNode3);
        allocationNode2.next = new AllocationNode(allocationNode2.endPosition, this.allocationLength);
        this.writeAllocationNode = this.totalBytesWritten == allocationNode2.endPosition ? allocationNode2.next : allocationNode2;
        if (this.readAllocationNode == allocationNode3) {
            this.readAllocationNode = allocationNode2.next;
        }
    }

    public void rewind() {
        this.readAllocationNode = this.firstAllocationNode;
    }

    public void readToBuffer(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        if (decoderInputBuffer.isEncrypted()) {
            readEncryptionData(decoderInputBuffer, sampleExtrasHolder);
        }
        if (decoderInputBuffer.hasSupplementalData()) {
            this.scratch.reset(4);
            readData(sampleExtrasHolder.offset, this.scratch.data, 4);
            int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
            sampleExtrasHolder.offset += 4;
            sampleExtrasHolder.size -= 4;
            decoderInputBuffer.ensureSpaceForWrite(readUnsignedIntToInt);
            readData(sampleExtrasHolder.offset, decoderInputBuffer.data, readUnsignedIntToInt);
            sampleExtrasHolder.offset += (long) readUnsignedIntToInt;
            sampleExtrasHolder.size -= readUnsignedIntToInt;
            decoderInputBuffer.resetSupplementalData(sampleExtrasHolder.size);
            readData(sampleExtrasHolder.offset, decoderInputBuffer.supplementalData, sampleExtrasHolder.size);
            return;
        }
        decoderInputBuffer.ensureSpaceForWrite(sampleExtrasHolder.size);
        readData(sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
    }

    public void discardDownstreamTo(long j) {
        if (j != -1) {
            while (j >= this.firstAllocationNode.endPosition) {
                this.allocator.release(this.firstAllocationNode.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if (this.readAllocationNode.startPosition < this.firstAllocationNode.startPosition) {
                this.readAllocationNode = this.firstAllocationNode;
            }
        }
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public int sampleData(DataReader dataReader, int i, boolean z) throws IOException {
        int read = dataReader.read(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend(i));
        if (read != -1) {
            postAppend(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int preAppend = preAppend(i);
            parsableByteArray.readBytes(this.writeAllocationNode.allocation.data, this.writeAllocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i -= preAppend;
            postAppend(preAppend);
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        int i;
        SampleQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        long j = sampleExtrasHolder2.offset;
        this.scratch.reset(1);
        readData(j, this.scratch.data, 1);
        long j2 = j + 1;
        byte b = this.scratch.data[0];
        boolean z = (b & 128) != 0;
        byte b2 = b & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
        } else {
            Arrays.fill(cryptoInfo.iv, (byte) 0);
        }
        readData(j2, cryptoInfo.iv, b2);
        long j3 = j2 + ((long) b2);
        if (z) {
            this.scratch.reset(2);
            readData(j3, this.scratch.data, 2);
            j3 += 2;
            i = this.scratch.readUnsignedShort();
        } else {
            i = 1;
        }
        int[] iArr = cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i) {
            iArr3 = new int[i];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i2 = i * 6;
            this.scratch.reset(i2);
            readData(j3, this.scratch.data, i2);
            j3 += (long) i2;
            this.scratch.setPosition(0);
            for (int i3 = 0; i3 < i; i3++) {
                iArr2[i3] = this.scratch.readUnsignedShort();
                iArr4[i3] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.size - ((int) (j3 - sampleExtrasHolder2.offset));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.castNonNull(sampleExtrasHolder2.cryptoData);
        cryptoInfo.set(i, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        int i4 = (int) (j3 - sampleExtrasHolder2.offset);
        sampleExtrasHolder2.offset += (long) i4;
        sampleExtrasHolder2.size -= i4;
    }

    private void readData(long j, ByteBuffer byteBuffer, int i) {
        advanceReadTo(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.readAllocationNode.endPosition - j));
            byteBuffer.put(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j), min);
            i -= min;
            j += (long) min;
            if (j == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void readData(long j, byte[] bArr, int i) {
        advanceReadTo(j);
        long j2 = j;
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.readAllocationNode.endPosition - j2));
            System.arraycopy(this.readAllocationNode.allocation.data, this.readAllocationNode.translateOffset(j2), bArr, i - i2, min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == this.readAllocationNode.endPosition) {
                this.readAllocationNode = this.readAllocationNode.next;
            }
        }
    }

    private void advanceReadTo(long j) {
        while (j >= this.readAllocationNode.endPosition) {
            this.readAllocationNode = this.readAllocationNode.next;
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            Allocation[] allocationArr = new Allocation[((this.writeAllocationNode.wasInitialized ? 1 : 0) + (((int) (this.writeAllocationNode.startPosition - allocationNode.startPosition)) / this.allocationLength))];
            for (int i = 0; i < allocationArr.length; i++) {
                allocationArr[i] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private int preAppend(int i) {
        if (!this.writeAllocationNode.wasInitialized) {
            this.writeAllocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void postAppend(int i) {
        this.totalBytesWritten += (long) i;
        if (this.totalBytesWritten == this.writeAllocationNode.endPosition) {
            this.writeAllocationNode = this.writeAllocationNode.next;
        }
    }

    static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j, int i) {
            this.startPosition = j;
            this.endPosition = j + ((long) i);
        }

        public final void initialize(Allocation allocation2, AllocationNode allocationNode) {
            this.allocation = allocation2;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public final int translateOffset(long j) {
            return ((int) (j - this.startPosition)) + this.allocation.offset;
        }

        public final AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }
    }
}
