package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jky;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class InitialObjectDescriptor extends ObjectDescriptorBase {
    int audioProfileLevelIndication;
    List<ESDescriptor> esDescriptors = new ArrayList();
    List<ExtensionDescriptor> extensionDescriptors = new ArrayList();
    int graphicsProfileLevelIndication;
    int includeInlineProfileLevelFlag;
    int oDProfileLevelIndication;
    private int objectDescriptorId;
    int sceneProfileLevelIndication;
    List<BaseDescriptor> unknownDescriptors = new ArrayList();
    int urlFlag;
    int urlLength;
    String urlString;
    int visualProfileLevelIndication;

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i;
        int O00000o0 = jky.O00000o0(byteBuffer);
        this.objectDescriptorId = (65472 & O00000o0) >> 6;
        this.urlFlag = (O00000o0 & 63) >> 5;
        this.includeInlineProfileLevelFlag = (O00000o0 & 31) >> 4;
        int size = getSize() - 2;
        if (this.urlFlag == 1) {
            this.urlLength = jky.O000000o(byteBuffer.get());
            this.urlString = jky.O000000o(byteBuffer, this.urlLength);
            i = size - (this.urlLength + 1);
        } else {
            this.oDProfileLevelIndication = jky.O000000o(byteBuffer.get());
            this.sceneProfileLevelIndication = jky.O000000o(byteBuffer.get());
            this.audioProfileLevelIndication = jky.O000000o(byteBuffer.get());
            this.visualProfileLevelIndication = jky.O000000o(byteBuffer.get());
            this.graphicsProfileLevelIndication = jky.O000000o(byteBuffer.get());
            i = size - 5;
            if (i > 2) {
                BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
                i -= createFrom.getSize();
                if (createFrom instanceof ESDescriptor) {
                    this.esDescriptors.add((ESDescriptor) createFrom);
                } else {
                    this.unknownDescriptors.add(createFrom);
                }
            }
        }
        if (i > 2) {
            BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
            if (createFrom2 instanceof ExtensionDescriptor) {
                this.extensionDescriptors.add((ExtensionDescriptor) createFrom2);
            } else {
                this.unknownDescriptors.add(createFrom2);
            }
        }
    }

    public String toString() {
        return "InitialObjectDescriptor" + "{objectDescriptorId=" + this.objectDescriptorId + ", urlFlag=" + this.urlFlag + ", includeInlineProfileLevelFlag=" + this.includeInlineProfileLevelFlag + ", urlLength=" + this.urlLength + ", urlString='" + this.urlString + '\'' + ", oDProfileLevelIndication=" + this.oDProfileLevelIndication + ", sceneProfileLevelIndication=" + this.sceneProfileLevelIndication + ", audioProfileLevelIndication=" + this.audioProfileLevelIndication + ", visualProfileLevelIndication=" + this.visualProfileLevelIndication + ", graphicsProfileLevelIndication=" + this.graphicsProfileLevelIndication + ", esDescriptors=" + this.esDescriptors + ", extensionDescriptors=" + this.extensionDescriptors + ", unknownDescriptors=" + this.unknownDescriptors + '}';
    }
}
