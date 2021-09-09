package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(tags = {20})
public class ProfileLevelIndicationDescriptor extends BaseDescriptor {
    int profileLevelIndicationIndex;

    public int getContentSize() {
        return 1;
    }

    public ProfileLevelIndicationDescriptor() {
        this.tag = 20;
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(getSize());
        jla.O00000o(allocate, 20);
        writeSize(allocate, getContentSize());
        jla.O00000o(allocate, this.profileLevelIndicationIndex);
        return allocate;
    }

    public String toString() {
        return "ProfileLevelIndicationDescriptor" + "{profileLevelIndicationIndex=" + Integer.toHexString(this.profileLevelIndicationIndex) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.profileLevelIndicationIndex == ((ProfileLevelIndicationDescriptor) obj).profileLevelIndicationIndex;
    }

    public int hashCode() {
        return this.profileLevelIndicationIndex;
    }

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.profileLevelIndicationIndex = jky.O000000o(byteBuffer.get());
    }
}
