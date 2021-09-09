package org.mp4parser.boxes.apple;

import _m_j.jgy;
import _m_j.jha;
import _m_j.jhf;
import _m_j.jhm;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.List;
import org.mp4parser.boxes.sampleentry.SampleEntry;

public class TimeCodeBox extends jkn implements jha, SampleEntry {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_14 = null;
    private static final jhf.O000000o ajc$tjp_15 = null;
    private static final jhf.O000000o ajc$tjp_16 = null;
    private static final jhf.O000000o ajc$tjp_17 = null;
    private static final jhf.O000000o ajc$tjp_18 = null;
    private static final jhf.O000000o ajc$tjp_19 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_20 = null;
    private static final jhf.O000000o ajc$tjp_21 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    int dataReferenceIndex;
    long flags;
    int frameDuration;
    int numberOfFrames;
    int reserved1;
    int reserved2;
    byte[] rest = new byte[0];
    int timeScale;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("TimeCodeBox.java", TimeCodeBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getDataReferenceIndex", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 87);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setDataReferenceIndex", "org.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 91);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved1", "org.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved1", "", "void"), 136);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved2", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 140);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "setReserved2", "org.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved2", "", "void"), 144);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "getFlags", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "long"), 148);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "setFlags", "org.mp4parser.boxes.apple.TimeCodeBox", "long", "flags", "", "void"), 152);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "getRest", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), 156);
        ajc$tjp_16 = jho.O000000o("method-execution", jho.O000000o("1", "setRest", "org.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), 160);
        ajc$tjp_17 = jho.O000000o("method-execution", jho.O000000o("1", "getBoxes", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.util.List"), 165);
        ajc$tjp_18 = jho.O000000o("method-execution", jho.O000000o("1", "setBoxes", "org.mp4parser.boxes.apple.TimeCodeBox", "java.util.List", "boxes", "", "void"), 169);
        ajc$tjp_19 = jho.O000000o("method-execution", jho.O000000o("1", "getBoxes", "org.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class", "clazz", "", "java.util.List"), 173);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "toString", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 97);
        ajc$tjp_20 = jho.O000000o("method-execution", jho.O000000o("1", "getBoxes", "org.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class:boolean", "clazz:recursive", "", "java.util.List"), 177);
        ajc$tjp_21 = jho.O000000o("method-execution", jho.O000000o("1", "writeContainer", "org.mp4parser.boxes.apple.TimeCodeBox", "java.nio.channels.WritableByteChannel", "bb", "java.io.IOException", "void"), 181);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "getTimeScale", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 108);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "setTimeScale", "org.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 112);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "getFrameDuration", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 116);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "setFrameDuration", "org.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 120);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "getNumberOfFrames", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 124);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "setNumberOfFrames", "org.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), (int) NotificationCompat.FLAG_HIGH_PRIORITY);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "getReserved1", "org.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 132);
    }

    public TimeCodeBox() {
        super("tmcd");
    }

    public long getContentSize() {
        return (long) (this.rest.length + 28);
    }

    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[6]);
        jla.O00000Oo(byteBuffer, this.dataReferenceIndex);
        byteBuffer.putInt(this.reserved1);
        jla.O00000Oo(byteBuffer, this.flags);
        byteBuffer.putInt(this.timeScale);
        byteBuffer.putInt(this.frameDuration);
        jla.O00000o(byteBuffer, this.numberOfFrames);
        jla.O000000o(byteBuffer, this.reserved2);
        byteBuffer.put(this.rest);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.dataReferenceIndex = jky.O00000o0(byteBuffer);
        this.reserved1 = byteBuffer.getInt();
        this.flags = jky.O000000o(byteBuffer);
        this.timeScale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numberOfFrames = jky.O000000o(byteBuffer.get());
        this.reserved2 = jky.O00000Oo(byteBuffer);
        this.rest = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.rest);
    }

    public int getDataReferenceIndex() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataReferenceIndex;
    }

    public String toString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return "TimeCodeBox{timeScale=" + this.timeScale + ", frameDuration=" + this.frameDuration + ", numberOfFrames=" + this.numberOfFrames + ", reserved1=" + this.reserved1 + ", reserved2=" + this.reserved2 + ", flags=" + this.flags + '}';
    }

    public int getTimeScale() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.timeScale;
    }

    public int getFrameDuration() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.frameDuration;
    }

    public int getNumberOfFrames() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.numberOfFrames;
    }

    public int getReserved1() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved1;
    }

    public int getReserved2() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.reserved2;
    }

    public long getFlags() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.flags;
    }

    public void setFlags(long j) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this, jhm.O000000o(j));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.flags = j;
    }

    public byte[] getRest() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.rest;
    }

    public void setRest(byte[] bArr) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_16, this, this, bArr);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.rest = bArr;
    }

    public List<jgy> getBoxes() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_17, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return Collections.emptyList();
    }

    public void setBoxes(List<? extends jgy> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_18, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        throw new RuntimeException("Time Code Box doesn't accept any children");
    }

    public <T extends jgy> List<T> getBoxes(Class<T> cls) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_19, this, this, cls);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return Collections.emptyList();
    }

    public void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        jhf O000000o2 = jho.O000000o(ajc$tjp_21, this, this, writableByteChannel);
        jku.O000000o();
        jku.O000000o(O000000o2);
    }

    public void setDataReferenceIndex(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.dataReferenceIndex = i;
    }

    public void setTimeScale(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.timeScale = i;
    }

    public void setFrameDuration(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.frameDuration = i;
    }

    public void setNumberOfFrames(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.numberOfFrames = i;
    }

    public void setReserved1(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved1 = i;
    }

    public void setReserved2(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.reserved2 = i;
    }

    public <T extends jgy> List<T> getBoxes(Class<T> cls, boolean z) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_20, this, this, cls, Boolean.valueOf(z));
        jku.O000000o();
        jku.O000000o(O000000o2);
        return Collections.emptyList();
    }
}
