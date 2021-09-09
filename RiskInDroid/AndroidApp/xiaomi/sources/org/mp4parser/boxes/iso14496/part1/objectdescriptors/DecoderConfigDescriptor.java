package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jkx;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Descriptor(tags = {4})
public class DecoderConfigDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(DecoderConfigDescriptor.class.getName());
    AudioSpecificConfig audioSpecificInfo;
    long avgBitRate;
    int bufferSizeDB;
    byte[] configDescriptorDeadBytes;
    DecoderSpecificInfo decoderSpecificInfo;
    long maxBitRate;
    int objectTypeIndication;
    List<ProfileLevelIndicationDescriptor> profileLevelIndicationDescriptors = new ArrayList();
    int streamType;
    int upStream;

    public DecoderConfigDescriptor() {
        this.tag = 4;
    }

    /* access modifiers changed from: package-private */
    public int getContentSize() {
        AudioSpecificConfig audioSpecificConfig = this.audioSpecificInfo;
        int i = 0;
        int size = (audioSpecificConfig == null ? 0 : audioSpecificConfig.getSize()) + 13;
        DecoderSpecificInfo decoderSpecificInfo2 = this.decoderSpecificInfo;
        if (decoderSpecificInfo2 != null) {
            i = decoderSpecificInfo2.getSize();
        }
        int i2 = size + i;
        for (ProfileLevelIndicationDescriptor size2 : this.profileLevelIndicationDescriptors) {
            i2 += size2.getSize();
        }
        return i2;
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(getSize());
        jla.O00000o(allocate, this.tag);
        writeSize(allocate, getContentSize());
        jla.O00000o(allocate, this.objectTypeIndication);
        jla.O00000o(allocate, (this.streamType << 2) | (this.upStream << 1) | 1);
        jla.O000000o(allocate, this.bufferSizeDB);
        jla.O00000Oo(allocate, this.maxBitRate);
        jla.O00000Oo(allocate, this.avgBitRate);
        DecoderSpecificInfo decoderSpecificInfo2 = this.decoderSpecificInfo;
        if (decoderSpecificInfo2 != null) {
            allocate.put(decoderSpecificInfo2.serialize());
        }
        AudioSpecificConfig audioSpecificConfig = this.audioSpecificInfo;
        if (audioSpecificConfig != null) {
            allocate.put(audioSpecificConfig.serialize());
        }
        for (ProfileLevelIndicationDescriptor serialize : this.profileLevelIndicationDescriptors) {
            allocate.put(serialize.serialize());
        }
        return (ByteBuffer) allocate.rewind();
    }

    public DecoderSpecificInfo getDecoderSpecificInfo() {
        return this.decoderSpecificInfo;
    }

    public void setDecoderSpecificInfo(DecoderSpecificInfo decoderSpecificInfo2) {
        this.decoderSpecificInfo = decoderSpecificInfo2;
    }

    public AudioSpecificConfig getAudioSpecificInfo() {
        return this.audioSpecificInfo;
    }

    public void setAudioSpecificInfo(AudioSpecificConfig audioSpecificConfig) {
        this.audioSpecificInfo = audioSpecificConfig;
    }

    public List<ProfileLevelIndicationDescriptor> getProfileLevelIndicationDescriptors() {
        return this.profileLevelIndicationDescriptors;
    }

    public int getObjectTypeIndication() {
        return this.objectTypeIndication;
    }

    public void setObjectTypeIndication(int i) {
        this.objectTypeIndication = i;
    }

    public int getStreamType() {
        return this.streamType;
    }

    public void setStreamType(int i) {
        this.streamType = i;
    }

    public int getUpStream() {
        return this.upStream;
    }

    public void setUpStream(int i) {
        this.upStream = i;
    }

    public int getBufferSizeDB() {
        return this.bufferSizeDB;
    }

    public void setBufferSizeDB(int i) {
        this.bufferSizeDB = i;
    }

    public long getMaxBitRate() {
        return this.maxBitRate;
    }

    public void setMaxBitRate(long j) {
        this.maxBitRate = j;
    }

    public long getAvgBitRate() {
        return this.avgBitRate;
    }

    public void setAvgBitRate(long j) {
        this.avgBitRate = j;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.objectTypeIndication);
        sb.append(", streamType=");
        sb.append(this.streamType);
        sb.append(", upStream=");
        sb.append(this.upStream);
        sb.append(", bufferSizeDB=");
        sb.append(this.bufferSizeDB);
        sb.append(", maxBitRate=");
        sb.append(this.maxBitRate);
        sb.append(", avgBitRate=");
        sb.append(this.avgBitRate);
        sb.append(", decoderSpecificInfo=");
        sb.append(this.decoderSpecificInfo);
        sb.append(", audioSpecificInfo=");
        sb.append(this.audioSpecificInfo);
        sb.append(", configDescriptorDeadBytes=");
        byte[] bArr = this.configDescriptorDeadBytes;
        if (bArr == null) {
            bArr = new byte[0];
        }
        sb.append(jkx.O000000o(bArr));
        sb.append(", profileLevelIndicationDescriptors=");
        List<ProfileLevelIndicationDescriptor> list = this.profileLevelIndicationDescriptors;
        if (list == null) {
            str = "null";
        } else {
            str = Arrays.asList(list).toString();
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int size;
        this.objectTypeIndication = jky.O000000o(byteBuffer.get());
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.streamType = O000000o2 >>> 2;
        this.upStream = (O000000o2 >> 1) & 1;
        this.bufferSizeDB = jky.O00000Oo(byteBuffer);
        this.maxBitRate = jky.O000000o(byteBuffer);
        this.avgBitRate = jky.O000000o(byteBuffer);
        while (byteBuffer.remaining() > 2) {
            int position = byteBuffer.position();
            BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(this.objectTypeIndication, byteBuffer);
            int position2 = byteBuffer.position() - position;
            Logger logger = log;
            StringBuilder sb = new StringBuilder();
            sb.append(createFrom);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(position2);
            sb.append(", size: ");
            sb.append(createFrom != null ? Integer.valueOf(createFrom.getSize()) : null);
            logger.finer(sb.toString());
            if (createFrom != null && position2 < (size = createFrom.getSize())) {
                this.configDescriptorDeadBytes = new byte[(size - position2)];
                byteBuffer.get(this.configDescriptorDeadBytes);
            }
            if (createFrom instanceof DecoderSpecificInfo) {
                this.decoderSpecificInfo = (DecoderSpecificInfo) createFrom;
            } else if (createFrom instanceof AudioSpecificConfig) {
                this.audioSpecificInfo = (AudioSpecificConfig) createFrom;
            } else if (createFrom instanceof ProfileLevelIndicationDescriptor) {
                this.profileLevelIndicationDescriptors.add((ProfileLevelIndicationDescriptor) createFrom);
            }
        }
    }
}
