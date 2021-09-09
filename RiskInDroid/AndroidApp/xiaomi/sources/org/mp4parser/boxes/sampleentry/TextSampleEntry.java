package org.mp4parser.boxes.sampleentry;

import _m_j.jgz;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

public class TextSampleEntry extends AbstractSampleEntry {
    private int[] backgroundColorRgba = new int[4];
    private BoxRecord boxRecord = new BoxRecord();
    private long displayFlags;
    private int horizontalJustification;
    private StyleRecord styleRecord = new StyleRecord();
    private int verticalJustification;

    public String toString() {
        return "TextSampleEntry";
    }

    public TextSampleEntry() {
        super("tx3g");
    }

    public TextSampleEntry(String str) {
        super(str);
    }

    public void setType(String str) {
        this.type = str;
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(38);
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        this.displayFlags = jky.O000000o(allocate);
        this.horizontalJustification = jky.O000000o(allocate.get());
        this.verticalJustification = jky.O000000o(allocate.get());
        this.backgroundColorRgba = new int[4];
        this.backgroundColorRgba[0] = jky.O000000o(allocate.get());
        this.backgroundColorRgba[1] = jky.O000000o(allocate.get());
        this.backgroundColorRgba[2] = jky.O000000o(allocate.get());
        this.backgroundColorRgba[3] = jky.O000000o(allocate.get());
        this.boxRecord = new BoxRecord();
        this.boxRecord.parse(allocate);
        this.styleRecord = new StyleRecord();
        this.styleRecord.parse(allocate);
        initContainer(readableByteChannel, j - 38, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(38);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        jla.O00000Oo(allocate, this.displayFlags);
        jla.O00000o(allocate, this.horizontalJustification);
        jla.O00000o(allocate, this.verticalJustification);
        jla.O00000o(allocate, this.backgroundColorRgba[0]);
        jla.O00000o(allocate, this.backgroundColorRgba[1]);
        jla.O00000o(allocate, this.backgroundColorRgba[2]);
        jla.O00000o(allocate, this.backgroundColorRgba[3]);
        this.boxRecord.getContent(allocate);
        this.styleRecord.getContent(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public BoxRecord getBoxRecord() {
        return this.boxRecord;
    }

    public void setBoxRecord(BoxRecord boxRecord2) {
        this.boxRecord = boxRecord2;
    }

    public StyleRecord getStyleRecord() {
        return this.styleRecord;
    }

    public void setStyleRecord(StyleRecord styleRecord2) {
        this.styleRecord = styleRecord2;
    }

    public boolean isScrollIn() {
        return (this.displayFlags & 32) == 32;
    }

    public void setScrollIn(boolean z) {
        if (z) {
            this.displayFlags |= 32;
        } else {
            this.displayFlags &= -33;
        }
    }

    public boolean isScrollOut() {
        return (this.displayFlags & 64) == 64;
    }

    public void setScrollOut(boolean z) {
        if (z) {
            this.displayFlags |= 64;
        } else {
            this.displayFlags &= -65;
        }
    }

    public boolean isScrollDirection() {
        return (this.displayFlags & 384) == 384;
    }

    public void setScrollDirection(boolean z) {
        if (z) {
            this.displayFlags |= 384;
        } else {
            this.displayFlags &= -385;
        }
    }

    public boolean isContinuousKaraoke() {
        return (this.displayFlags & 2048) == 2048;
    }

    public void setContinuousKaraoke(boolean z) {
        if (z) {
            this.displayFlags |= 2048;
        } else {
            this.displayFlags &= -2049;
        }
    }

    public boolean isWriteTextVertically() {
        return (this.displayFlags & 131072) == 131072;
    }

    public void setWriteTextVertically(boolean z) {
        if (z) {
            this.displayFlags |= 131072;
        } else {
            this.displayFlags &= -131073;
        }
    }

    public boolean isFillTextRegion() {
        return (this.displayFlags & 262144) == 262144;
    }

    public void setFillTextRegion(boolean z) {
        if (z) {
            this.displayFlags |= 262144;
        } else {
            this.displayFlags &= -262145;
        }
    }

    public int getHorizontalJustification() {
        return this.horizontalJustification;
    }

    public void setHorizontalJustification(int i) {
        this.horizontalJustification = i;
    }

    public int getVerticalJustification() {
        return this.verticalJustification;
    }

    public void setVerticalJustification(int i) {
        this.verticalJustification = i;
    }

    public int[] getBackgroundColorRgba() {
        return this.backgroundColorRgba;
    }

    public void setBackgroundColorRgba(int[] iArr) {
        this.backgroundColorRgba = iArr;
    }

    public long getSize() {
        long containerSize = getContainerSize() + 38;
        return containerSize + ((long) ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8));
    }

    public static class BoxRecord {
        int bottom;
        int left;
        int right;
        int top;

        public int getSize() {
            return 8;
        }

        public BoxRecord() {
        }

        public BoxRecord(int i, int i2, int i3, int i4) {
            this.top = i;
            this.left = i2;
            this.bottom = i3;
            this.right = i4;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.top = jky.O00000o0(byteBuffer);
            this.left = jky.O00000o0(byteBuffer);
            this.bottom = jky.O00000o0(byteBuffer);
            this.right = jky.O00000o0(byteBuffer);
        }

        public void getContent(ByteBuffer byteBuffer) {
            jla.O00000Oo(byteBuffer, this.top);
            jla.O00000Oo(byteBuffer, this.left);
            jla.O00000Oo(byteBuffer, this.bottom);
            jla.O00000Oo(byteBuffer, this.right);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BoxRecord boxRecord = (BoxRecord) obj;
            return this.bottom == boxRecord.bottom && this.left == boxRecord.left && this.right == boxRecord.right && this.top == boxRecord.top;
        }

        public int hashCode() {
            return (((((this.top * 31) + this.left) * 31) + this.bottom) * 31) + this.right;
        }
    }

    public static class StyleRecord {
        int endChar;
        int faceStyleFlags;
        int fontId;
        int fontSize;
        int startChar;
        int[] textColor = {255, 255, 255, 255};

        public int getSize() {
            return 12;
        }

        public StyleRecord() {
        }

        public StyleRecord(int i, int i2, int i3, int i4, int i5, int[] iArr) {
            this.startChar = i;
            this.endChar = i2;
            this.fontId = i3;
            this.faceStyleFlags = i4;
            this.fontSize = i5;
            this.textColor = iArr;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.startChar = jky.O00000o0(byteBuffer);
            this.endChar = jky.O00000o0(byteBuffer);
            this.fontId = jky.O00000o0(byteBuffer);
            this.faceStyleFlags = jky.O000000o(byteBuffer.get());
            this.fontSize = jky.O000000o(byteBuffer.get());
            this.textColor = new int[4];
            this.textColor[0] = jky.O000000o(byteBuffer.get());
            this.textColor[1] = jky.O000000o(byteBuffer.get());
            this.textColor[2] = jky.O000000o(byteBuffer.get());
            this.textColor[3] = jky.O000000o(byteBuffer.get());
        }

        public void getContent(ByteBuffer byteBuffer) {
            jla.O00000Oo(byteBuffer, this.startChar);
            jla.O00000Oo(byteBuffer, this.endChar);
            jla.O00000Oo(byteBuffer, this.fontId);
            jla.O00000o(byteBuffer, this.faceStyleFlags);
            jla.O00000o(byteBuffer, this.fontSize);
            jla.O00000o(byteBuffer, this.textColor[0]);
            jla.O00000o(byteBuffer, this.textColor[1]);
            jla.O00000o(byteBuffer, this.textColor[2]);
            jla.O00000o(byteBuffer, this.textColor[3]);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            StyleRecord styleRecord = (StyleRecord) obj;
            return this.endChar == styleRecord.endChar && this.faceStyleFlags == styleRecord.faceStyleFlags && this.fontId == styleRecord.fontId && this.fontSize == styleRecord.fontSize && this.startChar == styleRecord.startChar && Arrays.equals(this.textColor, styleRecord.textColor);
        }

        public int hashCode() {
            int i = ((((((((this.startChar * 31) + this.endChar) * 31) + this.fontId) * 31) + this.faceStyleFlags) * 31) + this.fontSize) * 31;
            int[] iArr = this.textColor;
            return i + (iArr != null ? Arrays.hashCode(iArr) : 0);
        }
    }
}
