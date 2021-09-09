package org.mp4parser.boxes.threegpp.ts26244;

import _m_j.jhf;
import _m_j.jho;
import _m_j.jkp;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.nio.ByteBuffer;

public class LocationInformationBox extends jkp {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_10 = null;
    private static final jhf.O000000o ajc$tjp_11 = null;
    private static final jhf.O000000o ajc$tjp_12 = null;
    private static final jhf.O000000o ajc$tjp_13 = null;
    private static final jhf.O000000o ajc$tjp_14 = null;
    private static final jhf.O000000o ajc$tjp_15 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static final jhf.O000000o ajc$tjp_6 = null;
    private static final jhf.O000000o ajc$tjp_7 = null;
    private static final jhf.O000000o ajc$tjp_8 = null;
    private static final jhf.O000000o ajc$tjp_9 = null;
    private String additionalNotes = "";
    private double altitude;
    private String astronomicalBody = "";
    private String language;
    private double latitude;
    private double longitude;
    private String name = "";
    private int role;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        jho jho = new jho("LocationInformationBox.java", LocationInformationBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguage", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "java.lang.String"), 30);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "setLanguage", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "java.lang.String", "language", "", "void"), 34);
        ajc$tjp_10 = jho.O000000o("method-execution", jho.O000000o("1", "getAltitude", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "double"), 70);
        ajc$tjp_11 = jho.O000000o("method-execution", jho.O000000o("1", "setAltitude", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "double", "altitude", "", "void"), 74);
        ajc$tjp_12 = jho.O000000o("method-execution", jho.O000000o("1", "getAstronomicalBody", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "java.lang.String"), 78);
        ajc$tjp_13 = jho.O000000o("method-execution", jho.O000000o("1", "setAstronomicalBody", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "java.lang.String", "astronomicalBody", "", "void"), 82);
        ajc$tjp_14 = jho.O000000o("method-execution", jho.O000000o("1", "getAdditionalNotes", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "java.lang.String"), 86);
        ajc$tjp_15 = jho.O000000o("method-execution", jho.O000000o("1", "setAdditionalNotes", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "java.lang.String", "additionalNotes", "", "void"), 90);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getName", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "java.lang.String"), 38);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setName", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "java.lang.String", "name", "", "void"), 42);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getRole", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "int"), 46);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setRole", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "int", "role", "", "void"), 50);
        ajc$tjp_6 = jho.O000000o("method-execution", jho.O000000o("1", "getLongitude", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "double"), 54);
        ajc$tjp_7 = jho.O000000o("method-execution", jho.O000000o("1", "setLongitude", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "double", "longitude", "", "void"), 58);
        ajc$tjp_8 = jho.O000000o("method-execution", jho.O000000o("1", "getLatitude", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "", "", "", "double"), 62);
        ajc$tjp_9 = jho.O000000o("method-execution", jho.O000000o("1", "setLatitude", "org.mp4parser.boxes.threegpp.ts26244.LocationInformationBox", "double", "latitude", "", "void"), 66);
    }

    public LocationInformationBox() {
        super("loci");
    }

    public String getLanguage() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.language;
    }

    public void setLanguage(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.language = str;
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

    public int getRole() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.role;
    }

    public double getLongitude() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_6, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.longitude;
    }

    public double getLatitude() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_8, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.latitude;
    }

    public double getAltitude() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_10, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.altitude;
    }

    public String getAstronomicalBody() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_12, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.astronomicalBody;
    }

    public void setAstronomicalBody(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_13, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.astronomicalBody = str;
    }

    public String getAdditionalNotes() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_14, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.additionalNotes;
    }

    public void setAdditionalNotes(String str) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_15, this, this, str);
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.additionalNotes = str;
    }

    public long getContentSize() {
        return (long) (jli.O000000o(this.name).length + 22 + jli.O000000o(this.astronomicalBody).length + jli.O000000o(this.additionalNotes).length);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = jky.O0000Oo(byteBuffer);
        this.name = jky.O00000oO(byteBuffer);
        this.role = jky.O000000o(byteBuffer.get());
        this.longitude = jky.O0000O0o(byteBuffer);
        this.latitude = jky.O0000O0o(byteBuffer);
        this.altitude = jky.O0000O0o(byteBuffer);
        this.astronomicalBody = jky.O00000oO(byteBuffer);
        this.additionalNotes = jky.O00000oO(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        jla.O000000o(byteBuffer, this.language);
        byteBuffer.put(jli.O000000o(this.name));
        byteBuffer.put((byte) 0);
        jla.O00000o(byteBuffer, this.role);
        jla.O000000o(byteBuffer, this.longitude);
        jla.O000000o(byteBuffer, this.latitude);
        jla.O000000o(byteBuffer, this.altitude);
        byteBuffer.put(jli.O000000o(this.astronomicalBody));
        byteBuffer.put((byte) 0);
        byteBuffer.put(jli.O000000o(this.additionalNotes));
        byteBuffer.put((byte) 0);
    }

    public void setRole(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.role = i;
    }

    public void setLongitude(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_7, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.longitude = d;
    }

    public void setLatitude(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_9, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.latitude = d;
    }

    public void setAltitude(double d) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_11, this, this, Double.valueOf(d));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.altitude = d;
    }
}
