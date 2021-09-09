package org.mp4parser.boxes.apple;

import _m_j.jgy;
import _m_j.jgz;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import org.mp4parser.boxes.sampleentry.AbstractSampleEntry;

public class QuicktimeTextSampleEntry extends AbstractSampleEntry {
    int backgroundB;
    int backgroundG;
    int backgroundR;
    int dataReferenceIndex;
    long defaultTextBox;
    int displayFlags;
    short fontFace;
    String fontName = "";
    short fontNumber;
    int foregroundB = 65535;
    int foregroundG = 65535;
    int foregroundR = 65535;
    long reserved1;
    byte reserved2;
    short reserved3;
    int textJustification;

    public QuicktimeTextSampleEntry() {
        super("text");
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(jkv.O000000o(j));
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        this.displayFlags = allocate.getInt();
        this.textJustification = allocate.getInt();
        this.backgroundR = jky.O00000o0(allocate);
        this.backgroundG = jky.O00000o0(allocate);
        this.backgroundB = jky.O00000o0(allocate);
        this.defaultTextBox = jky.O00000oo(allocate);
        this.reserved1 = jky.O00000oo(allocate);
        this.fontNumber = allocate.getShort();
        this.fontFace = allocate.getShort();
        this.reserved2 = allocate.get();
        this.reserved3 = allocate.getShort();
        this.foregroundR = jky.O00000o0(allocate);
        this.foregroundG = jky.O00000o0(allocate);
        this.foregroundB = jky.O00000o0(allocate);
        if (allocate.remaining() > 0) {
            byte[] bArr = new byte[jky.O000000o(allocate.get())];
            allocate.get(bArr);
            this.fontName = new String(bArr);
            return;
        }
        this.fontName = null;
    }

    public void setBoxes(List<? extends jgy> list) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    public void addBox(jgy jgy) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        String str = this.fontName;
        ByteBuffer allocate = ByteBuffer.allocate((str != null ? str.length() : 0) + 52);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        allocate.putInt(this.displayFlags);
        allocate.putInt(this.textJustification);
        jla.O00000Oo(allocate, this.backgroundR);
        jla.O00000Oo(allocate, this.backgroundG);
        jla.O00000Oo(allocate, this.backgroundB);
        jla.O000000o(allocate, this.defaultTextBox);
        jla.O000000o(allocate, this.reserved1);
        allocate.putShort(this.fontNumber);
        allocate.putShort(this.fontFace);
        allocate.put(this.reserved2);
        allocate.putShort(this.reserved3);
        jla.O00000Oo(allocate, this.foregroundR);
        jla.O00000Oo(allocate, this.foregroundG);
        jla.O00000Oo(allocate, this.foregroundB);
        String str2 = this.fontName;
        if (str2 != null) {
            jla.O00000o(allocate, str2.length());
            allocate.put(this.fontName.getBytes());
        }
        writableByteChannel.write((ByteBuffer) allocate.rewind());
    }

    public long getSize() {
        long containerSize = getContainerSize() + 52;
        String str = this.fontName;
        long length = containerSize + ((long) (str != null ? str.length() : 0));
        return length + ((long) ((this.largeBox || 8 + length >= 4294967296L) ? 16 : 8));
    }

    public int getDisplayFlags() {
        return this.displayFlags;
    }

    public void setDisplayFlags(int i) {
        this.displayFlags = i;
    }

    public int getTextJustification() {
        return this.textJustification;
    }

    public void setTextJustification(int i) {
        this.textJustification = i;
    }

    public int getBackgroundR() {
        return this.backgroundR;
    }

    public void setBackgroundR(int i) {
        this.backgroundR = i;
    }

    public int getBackgroundG() {
        return this.backgroundG;
    }

    public void setBackgroundG(int i) {
        this.backgroundG = i;
    }

    public int getBackgroundB() {
        return this.backgroundB;
    }

    public void setBackgroundB(int i) {
        this.backgroundB = i;
    }

    public long getDefaultTextBox() {
        return this.defaultTextBox;
    }

    public void setDefaultTextBox(long j) {
        this.defaultTextBox = j;
    }

    public long getReserved1() {
        return this.reserved1;
    }

    public void setReserved1(long j) {
        this.reserved1 = j;
    }

    public short getFontNumber() {
        return this.fontNumber;
    }

    public void setFontNumber(short s) {
        this.fontNumber = s;
    }

    public short getFontFace() {
        return this.fontFace;
    }

    public void setFontFace(short s) {
        this.fontFace = s;
    }

    public byte getReserved2() {
        return this.reserved2;
    }

    public void setReserved2(byte b) {
        this.reserved2 = b;
    }

    public short getReserved3() {
        return this.reserved3;
    }

    public void setReserved3(short s) {
        this.reserved3 = s;
    }

    public int getForegroundR() {
        return this.foregroundR;
    }

    public void setForegroundR(int i) {
        this.foregroundR = i;
    }

    public int getForegroundG() {
        return this.foregroundG;
    }

    public void setForegroundG(int i) {
        this.foregroundG = i;
    }

    public int getForegroundB() {
        return this.foregroundB;
    }

    public void setForegroundB(int i) {
        this.foregroundB = i;
    }

    public String getFontName() {
        return this.fontName;
    }

    public void setFontName(String str) {
        this.fontName = str;
    }
}
