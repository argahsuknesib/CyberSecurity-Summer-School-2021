package org.mp4parser.boxes.sampleentry;

import _m_j.jgy;
import _m_j.jgz;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public final class AudioSampleEntry extends AbstractSampleEntry {
    private long bytesPerFrame;
    private long bytesPerPacket;
    private long bytesPerSample;
    private int channelCount;
    private int compressionId;
    private int packetSize;
    private int reserved1;
    private long reserved2;
    private long sampleRate;
    private int sampleSize;
    private long samplesPerPacket;
    private int soundVersion;
    private byte[] soundVersion2Data;

    public AudioSampleEntry(String str) {
        super(str);
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public final void setChannelCount(int i) {
        this.channelCount = i;
    }

    public final int getSampleSize() {
        return this.sampleSize;
    }

    public final void setSampleSize(int i) {
        this.sampleSize = i;
    }

    public final long getSampleRate() {
        return this.sampleRate;
    }

    public final void setSampleRate(long j) {
        this.sampleRate = j;
    }

    public final int getSoundVersion() {
        return this.soundVersion;
    }

    public final void setSoundVersion(int i) {
        this.soundVersion = i;
    }

    public final int getCompressionId() {
        return this.compressionId;
    }

    public final void setCompressionId(int i) {
        this.compressionId = i;
    }

    public final int getPacketSize() {
        return this.packetSize;
    }

    public final void setPacketSize(int i) {
        this.packetSize = i;
    }

    public final long getSamplesPerPacket() {
        return this.samplesPerPacket;
    }

    public final void setSamplesPerPacket(long j) {
        this.samplesPerPacket = j;
    }

    public final long getBytesPerPacket() {
        return this.bytesPerPacket;
    }

    public final void setBytesPerPacket(long j) {
        this.bytesPerPacket = j;
    }

    public final long getBytesPerFrame() {
        return this.bytesPerFrame;
    }

    public final void setBytesPerFrame(long j) {
        this.bytesPerFrame = j;
    }

    public final long getBytesPerSample() {
        return this.bytesPerSample;
    }

    public final void setBytesPerSample(long j) {
        this.bytesPerSample = j;
    }

    public final byte[] getSoundVersion2Data() {
        return this.soundVersion2Data;
    }

    public final void setSoundVersion2Data(byte[] bArr) {
        this.soundVersion2Data = bArr;
    }

    public final int getReserved1() {
        return this.reserved1;
    }

    public final void setReserved1(int i) {
        this.reserved1 = i;
    }

    public final long getReserved2() {
        return this.reserved2;
    }

    public final void setReserved2(long j) {
        this.reserved2 = j;
    }

    public final void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(28);
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        this.soundVersion = jky.O00000o0(allocate);
        this.reserved1 = jky.O00000o0(allocate);
        this.reserved2 = jky.O000000o(allocate);
        this.channelCount = jky.O00000o0(allocate);
        this.sampleSize = jky.O00000o0(allocate);
        this.compressionId = jky.O00000o0(allocate);
        this.packetSize = jky.O00000o0(allocate);
        this.sampleRate = jky.O000000o(allocate);
        int i = 16;
        if (!this.type.equals("mlpa")) {
            this.sampleRate >>>= 16;
        }
        if (this.soundVersion == 1) {
            ByteBuffer allocate2 = ByteBuffer.allocate(16);
            readableByteChannel.read(allocate2);
            allocate2.rewind();
            this.samplesPerPacket = jky.O000000o(allocate2);
            this.bytesPerPacket = jky.O000000o(allocate2);
            this.bytesPerFrame = jky.O000000o(allocate2);
            this.bytesPerSample = jky.O000000o(allocate2);
        }
        int i2 = 36;
        if (this.soundVersion == 2) {
            ByteBuffer allocate3 = ByteBuffer.allocate(36);
            readableByteChannel.read(allocate3);
            allocate3.rewind();
            this.samplesPerPacket = jky.O000000o(allocate3);
            this.bytesPerPacket = jky.O000000o(allocate3);
            this.bytesPerFrame = jky.O000000o(allocate3);
            this.bytesPerSample = jky.O000000o(allocate3);
            this.soundVersion2Data = new byte[20];
            allocate3.get(this.soundVersion2Data);
        }
        if ("owma".equals(this.type)) {
            System.err.println("owma");
            long j2 = j - 28;
            if (this.soundVersion != 1) {
                i = 0;
            }
            long j3 = j2 - ((long) i);
            if (this.soundVersion != 2) {
                i2 = 0;
            }
            final long j4 = j3 - ((long) i2);
            final ByteBuffer allocate4 = ByteBuffer.allocate(jkv.O000000o(j4));
            readableByteChannel.read(allocate4);
            addBox(new jgy() {
                /* class org.mp4parser.boxes.sampleentry.AudioSampleEntry.AnonymousClass1 */

                public String getType() {
                    return "----";
                }

                public long getSize() {
                    return j4;
                }

                public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                    allocate4.rewind();
                    writableByteChannel.write(allocate4);
                }
            });
            return;
        }
        long j5 = j - 28;
        if (this.soundVersion != 1) {
            i = 0;
        }
        long j6 = j5 - ((long) i);
        if (this.soundVersion != 2) {
            i2 = 0;
        }
        initContainer(readableByteChannel, j6 - ((long) i2), jgz);
    }

    public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        int i = 0;
        int i2 = (this.soundVersion == 1 ? 16 : 0) + 28;
        if (this.soundVersion == 2) {
            i = 36;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + i);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        jla.O00000Oo(allocate, this.soundVersion);
        jla.O00000Oo(allocate, this.reserved1);
        jla.O00000Oo(allocate, this.reserved2);
        jla.O00000Oo(allocate, this.channelCount);
        jla.O00000Oo(allocate, this.sampleSize);
        jla.O00000Oo(allocate, this.compressionId);
        jla.O00000Oo(allocate, this.packetSize);
        if (this.type.equals("mlpa")) {
            jla.O00000Oo(allocate, getSampleRate());
        } else {
            jla.O00000Oo(allocate, getSampleRate() << 16);
        }
        if (this.soundVersion == 1) {
            jla.O00000Oo(allocate, this.samplesPerPacket);
            jla.O00000Oo(allocate, this.bytesPerPacket);
            jla.O00000Oo(allocate, this.bytesPerFrame);
            jla.O00000Oo(allocate, this.bytesPerSample);
        }
        if (this.soundVersion == 2) {
            jla.O00000Oo(allocate, this.samplesPerPacket);
            jla.O00000Oo(allocate, this.bytesPerPacket);
            jla.O00000Oo(allocate, this.bytesPerFrame);
            jla.O00000Oo(allocate, this.bytesPerSample);
            allocate.put(this.soundVersion2Data);
        }
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public final long getSize() {
        int i = 16;
        int i2 = 0;
        int i3 = (this.soundVersion == 1 ? 16 : 0) + 28;
        if (this.soundVersion == 2) {
            i2 = 36;
        }
        long containerSize = ((long) (i3 + i2)) + getContainerSize();
        if (!this.largeBox && 8 + containerSize < 4294967296L) {
            i = 8;
        }
        return containerSize + ((long) i);
    }

    public final String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.bytesPerSample + ", bytesPerFrame=" + this.bytesPerFrame + ", bytesPerPacket=" + this.bytesPerPacket + ", samplesPerPacket=" + this.samplesPerPacket + ", packetSize=" + this.packetSize + ", compressionId=" + this.compressionId + ", soundVersion=" + this.soundVersion + ", sampleRate=" + this.sampleRate + ", sampleSize=" + this.sampleSize + ", channelCount=" + this.channelCount + ", boxes=" + getBoxes() + '}';
    }
}
