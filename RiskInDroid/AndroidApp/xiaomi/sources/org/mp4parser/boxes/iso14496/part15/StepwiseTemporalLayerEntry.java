package org.mp4parser.boxes.iso14496.part15;

import java.nio.ByteBuffer;
import org.mp4parser.boxes.samplegrouping.GroupEntry;

public class StepwiseTemporalLayerEntry extends GroupEntry {
    public String getType() {
        return "stsa";
    }

    public int hashCode() {
        return 37;
    }

    public void parse(ByteBuffer byteBuffer) {
    }

    public ByteBuffer get() {
        return ByteBuffer.allocate(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }
}
