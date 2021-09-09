package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import java.nio.ByteBuffer;

public class AppleTrackNumberBox extends AppleDataBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;

    /* renamed from: a  reason: collision with root package name */
    int f15444a;
    int b;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleTrackNumberBox.java", AppleTrackNumberBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getA", "org.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 16);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setA", "org.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "a", "", "void"), 20);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getB", "org.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 24);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setB", "org.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "b", "", "void"), 28);
    }

    /* access modifiers changed from: protected */
    public int getDataLength() {
        return 8;
    }

    public AppleTrackNumberBox() {
        super("trkn", 0);
    }

    public int getA() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.f15444a;
    }

    public int getB() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.b;
    }

    /* access modifiers changed from: protected */
    public byte[] writeData() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(this.f15444a);
        allocate.putInt(this.b);
        return allocate.array();
    }

    /* access modifiers changed from: protected */
    public void parseData(ByteBuffer byteBuffer) {
        this.f15444a = byteBuffer.getInt();
        this.b = byteBuffer.getInt();
    }

    public void setA(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.f15444a = i;
    }

    public void setB(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.b = i;
    }
}
