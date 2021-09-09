package org.mp4parser.boxes.iso23009.part1;

import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class EventMessageBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    long eventDuration;
    long id;
    byte[] messageData;
    long presentationTimeDelta;
    String schemeIdUri;
    long timescale;
    String value;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("EventMessageBox.java", EventMessageBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getSchemeIdUri", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 59);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setSchemeIdUri", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "java.lang.String", "schemeIdUri", "", "void"), 63);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getId", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "long"), 99);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setId", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "long", "id", "", "void"), 103);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getMessageData", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "[B"), 107);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setMessageData", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "[B", "messageData", "", "void"), 111);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getValue", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 67);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setValue", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "java.lang.String", "value", "", "void"), 71);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getTimescale", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "long"), 75);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setTimescale", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "long", "timescale", "", "void"), 79);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getPresentationTimeDelta", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "long"), 83);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setPresentationTimeDelta", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "long", "presentationTimeDelta", "", "void"), 87);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getEventDuration", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "", "", "", "long"), 91);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setEventDuration", "org.mp4parser.boxes.iso23009.part1.EventMessageBox", "long", "eventDuration", "", "void"), 95);
    }

    public EventMessageBox() {
        super("emsg");
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeIdUri = jky.O00000oO(byteBuffer);
        this.value = jky.O00000oO(byteBuffer);
        this.timescale = jky.O000000o(byteBuffer);
        this.presentationTimeDelta = jky.O000000o(byteBuffer);
        this.eventDuration = jky.O000000o(byteBuffer);
        this.id = jky.O000000o(byteBuffer);
        this.messageData = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.messageData);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O00000o0(byteBuffer, this.schemeIdUri);
        jla.O00000o0(byteBuffer, this.value);
        jla.O00000Oo(byteBuffer, this.timescale);
        jla.O00000Oo(byteBuffer, this.presentationTimeDelta);
        jla.O00000Oo(byteBuffer, this.eventDuration);
        jla.O00000Oo(byteBuffer, this.id);
        byteBuffer.put(this.messageData);
    }

    public long getContentSize() {
        return (long) (jli.O00000Oo(this.schemeIdUri) + 22 + jli.O00000Oo(this.value) + this.messageData.length);
    }

    public String getSchemeIdUri() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.schemeIdUri;
    }

    public void setSchemeIdUri(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.schemeIdUri = str;
    }

    public String getValue() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.value;
    }

    public void setValue(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.value = str;
    }

    public long getTimescale() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.timescale;
    }

    public void setTimescale(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.timescale = j;
    }

    public long getPresentationTimeDelta() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.presentationTimeDelta;
    }

    public void setPresentationTimeDelta(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.presentationTimeDelta = j;
    }

    public long getEventDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.eventDuration;
    }

    public void setEventDuration(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.eventDuration = j;
    }

    public long getId() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.id;
    }

    public void setId(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.id = j;
    }

    public byte[] getMessageData() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.messageData;
    }

    public void setMessageData(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.messageData = bArr;
    }
}
