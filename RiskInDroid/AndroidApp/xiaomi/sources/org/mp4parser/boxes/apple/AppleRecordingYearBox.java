package org.mp4parser.boxes.apple;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jku;
import _m_j.jky;
import _m_j.jli;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AppleRecordingYearBox extends AppleDataBox {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssZ");

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("AppleRecordingYearBox.java", AppleRecordingYearBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getDate", "org.mp4parser.boxes.apple.AppleRecordingYearBox", "", "", "", "java.util.Date"), 38);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setDate", "org.mp4parser.boxes.apple.AppleRecordingYearBox", "java.util.Date", "date", "", "void"), 42);
    }

    public AppleRecordingYearBox() {
        super("©day", 1);
        this.df.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    protected static String iso8601toRfc822Date(String str) {
        return str.replaceAll("Z$", "+0000").replaceAll("([0-9][0-9]):([0-9][0-9])$", "$1$2");
    }

    protected static String rfc822toIso8601Date(String str) {
        return str.replaceAll("\\+0000$", "Z");
    }

    public Date getDate() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.date;
    }

    public void setDate(Date date2) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, date2);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.date = date2;
    }

    /* access modifiers changed from: protected */
    public byte[] writeData() {
        return jli.O000000o(rfc822toIso8601Date(this.df.format(this.date)));
    }

    /* access modifiers changed from: protected */
    public void parseData(ByteBuffer byteBuffer) {
        try {
            this.date = this.df.parse(iso8601toRfc822Date(jky.O000000o(byteBuffer, byteBuffer.remaining())));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public int getDataLength() {
        return jli.O000000o(rfc822toIso8601Date(this.df.format(this.date))).length;
    }
}
