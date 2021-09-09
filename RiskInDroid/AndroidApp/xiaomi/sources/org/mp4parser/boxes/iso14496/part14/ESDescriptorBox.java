package org.mp4parser.boxes.iso14496.part14;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import java.nio.ByteBuffer;
import org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor;

public class ESDescriptorBox extends AbstractDescriptorBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("ESDescriptorBox.java", ESDescriptorBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEsDescriptor", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "", "", "", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor"), 35);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEsDescriptor", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "org.mp4parser.boxes.iso14496.part1.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 39);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "equals", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 44);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "hashCode", "org.mp4parser.boxes.iso14496.part14.ESDescriptorBox", "", "", "", "int"), 55);
    }

    public ESDescriptorBox() {
        super("esds");
    }

    public ESDescriptor getEsDescriptor() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return (ESDescriptor) super.getDescriptor();
    }

    public void setEsDescriptor(ESDescriptor eSDescriptor) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, eSDescriptor);
        jku.O000000o();
        jku.O000000o(O000000o2);
        super.setDescriptor(eSDescriptor);
    }

    public boolean equals(Object obj) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this, obj);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) obj;
        return this.data == null ? eSDescriptorBox.data == null : this.data.equals(eSDescriptorBox.data);
    }

    public int hashCode() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        if (this.data != null) {
            return this.data.hashCode();
        }
        return 0;
    }

    public long getContentSize() {
        int remaining;
        ESDescriptor esDescriptor = getEsDescriptor();
        if (esDescriptor != null) {
            remaining = esDescriptor.getSize();
        } else {
            remaining = this.data.remaining();
        }
        return (long) (remaining + 4);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        ESDescriptor esDescriptor = getEsDescriptor();
        if (esDescriptor != null) {
            byteBuffer.put((ByteBuffer) esDescriptor.serialize().rewind());
        } else {
            byteBuffer.put(this.data.duplicate());
        }
    }
}
