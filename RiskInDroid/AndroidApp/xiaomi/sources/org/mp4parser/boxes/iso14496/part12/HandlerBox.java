package org.mp4parser.boxes.iso14496.part12;

import _m_j.jhc;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HandlerBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    public static final Map<String, String> readableTypes;

    /* renamed from: a  reason: collision with root package name */
    private long f15445a;
    private long b;
    private long c;
    private String handlerType;
    private String name = null;
    private long shouldBeZeroButAppleWritesHereSomeValue;
    private boolean zeroTerm = true;

    private static void ajc$preClinit() {
        jho jho = new jho("HandlerBox.java", HandlerBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getHandlerType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 78);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setHandlerType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "java.lang.String", "handlerType", "", "void"), 82);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getName", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 86);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setName", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "java.lang.String", "name", "", "void"), 95);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getHumanReadableTrackType", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 99);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.iso14496.part12.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    static {
        ajc$preClinit();
        HashMap hashMap = new HashMap();
        hashMap.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mdir", "Apple Meta Data iTunes Reader");
        hashMap.put("mp7b", "MPEG-7 binary XML");
        hashMap.put("mp7t", "MPEG-7 XML");
        hashMap.put("vide", "Video Track");
        hashMap.put("soun", "Sound Track");
        hashMap.put("hint", "Hint Track");
        hashMap.put("appl", "Apple specific");
        hashMap.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        readableTypes = Collections.unmodifiableMap(hashMap);
    }

    public HandlerBox() {
        super("hdlr");
    }

    public String getHandlerType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.handlerType;
    }

    public void setHandlerType(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.handlerType = str;
    }

    public String getName() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.name;
    }

    public void setName(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.name = str;
    }

    public String getHumanReadableTrackType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return readableTypes.get(this.handlerType) != null ? readableTypes.get(this.handlerType) : "Unknown Handler Type";
    }

    public long getContentSize() {
        int O00000Oo;
        if (this.zeroTerm) {
            O00000Oo = jli.O00000Oo(this.name) + 25;
        } else {
            O00000Oo = jli.O00000Oo(this.name) + 24;
        }
        return (long) O00000Oo;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.shouldBeZeroButAppleWritesHereSomeValue = jky.O000000o(byteBuffer);
        this.handlerType = jky.O0000OoO(byteBuffer);
        this.f15445a = jky.O000000o(byteBuffer);
        this.b = jky.O000000o(byteBuffer);
        this.c = jky.O000000o(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.name = jky.O000000o(byteBuffer, byteBuffer.remaining());
            if (this.name.endsWith("\u0000")) {
                String str = this.name;
                this.name = str.substring(0, str.length() - 1);
                this.zeroTerm = true;
                return;
            }
            this.zeroTerm = false;
            return;
        }
        this.zeroTerm = false;
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000Oo(byteBuffer, this.shouldBeZeroButAppleWritesHereSomeValue);
        byteBuffer.put(jhc.O000000o(this.handlerType));
        jla.O00000Oo(byteBuffer, this.f15445a);
        jla.O00000Oo(byteBuffer, this.b);
        jla.O00000Oo(byteBuffer, this.c);
        String str = this.name;
        if (str != null) {
            byteBuffer.put(jli.O000000o(str));
        }
        if (this.zeroTerm) {
            byteBuffer.put((byte) 0);
        }
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "HandlerBox[handlerType=" + getHandlerType() + ";name=" + getName() + "]";
    }
}
