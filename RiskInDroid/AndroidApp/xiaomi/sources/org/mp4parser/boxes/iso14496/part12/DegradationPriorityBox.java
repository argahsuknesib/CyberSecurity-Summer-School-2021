package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;

public class DegradationPriorityBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    int[] priorities = new int[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("DegradationPriorityBox.java", DegradationPriorityBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getPriorities", "org.mp4parser.boxes.iso14496.part12.DegradationPriorityBox", "", "", "", "[I"), 38);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setPriorities", "org.mp4parser.boxes.iso14496.part12.DegradationPriorityBox", "[I", "priorities", "", "void"), 42);
    }

    public DegradationPriorityBox() {
        super("stdp");
    }

    public long getContentSize() {
        return (long) ((this.priorities.length * 2) + 4);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (int O00000Oo : this.priorities) {
            jla.O00000Oo(byteBuffer, O00000Oo);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.priorities = new int[(byteBuffer.remaining() / 2)];
        int i = 0;
        while (true) {
            int[] iArr = this.priorities;
            if (i < iArr.length) {
                iArr[i] = jky.O00000o0(byteBuffer);
                i++;
            } else {
                return;
            }
        }
    }

    public int[] getPriorities() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.priorities;
    }

    public void setPriorities(int[] iArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, iArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.priorities = iArr;
    }
}
