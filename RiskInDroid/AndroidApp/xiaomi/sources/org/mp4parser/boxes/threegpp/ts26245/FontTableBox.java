package org.mp4parser.boxes.threegpp.ts26245;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class FontTableBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    List<FontRecord> entries = new LinkedList();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("FontTableBox.java", FontTableBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getEntries", "org.mp4parser.boxes.threegpp.ts26245.FontTableBox", "", "", "", "java.util.List"), 52);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setEntries", "org.mp4parser.boxes.threegpp.ts26245.FontTableBox", "java.util.List", "entries", "", "void"), 56);
    }

    public FontTableBox() {
        super("ftab");
    }

    public long getContentSize() {
        int i = 2;
        for (FontRecord size : this.entries) {
            i += size.getSize();
        }
        return (long) i;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        int O00000o0 = jky.O00000o0(byteBuffer);
        for (int i = 0; i < O00000o0; i++) {
            FontRecord fontRecord = new FontRecord();
            fontRecord.parse(byteBuffer);
            this.entries.add(fontRecord);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        jla.O00000Oo(byteBuffer, this.entries.size());
        for (FontRecord content : this.entries) {
            content.getContent(byteBuffer);
        }
    }

    public List<FontRecord> getEntries() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.entries;
    }

    public void setEntries(List<FontRecord> list) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, list);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.entries = list;
    }

    public static class FontRecord {
        int fontId;
        String fontname;

        public FontRecord() {
        }

        public FontRecord(int i, String str) {
            this.fontId = i;
            this.fontname = str;
        }

        public void parse(ByteBuffer byteBuffer) {
            this.fontId = jky.O00000o0(byteBuffer);
            this.fontname = jky.O000000o(byteBuffer, jky.O000000o(byteBuffer.get()));
        }

        public void getContent(ByteBuffer byteBuffer) {
            jla.O00000Oo(byteBuffer, this.fontId);
            jla.O00000o(byteBuffer, this.fontname.length());
            byteBuffer.put(jli.O000000o(this.fontname));
        }

        public int getSize() {
            return jli.O00000Oo(this.fontname) + 3;
        }

        public String toString() {
            return "FontRecord{fontId=" + this.fontId + ", fontname='" + this.fontname + '\'' + '}';
        }
    }
}
