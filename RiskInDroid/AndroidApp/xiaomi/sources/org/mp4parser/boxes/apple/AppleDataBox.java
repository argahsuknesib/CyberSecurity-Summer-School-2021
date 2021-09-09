package org.mp4parser.boxes.apple;

import _m_j.ayt;
import _m_j.jhf;
import _m_j.jho;
import _m_j.jkn;
import _m_j.jku;
import _m_j.jky;
import _m_j.jla;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;

public abstract class AppleDataBox extends jkn {
    private static final jhf.O000000o ajc$tjp_0 = null;
    private static final jhf.O000000o ajc$tjp_1 = null;
    private static final jhf.O000000o ajc$tjp_2 = null;
    private static final jhf.O000000o ajc$tjp_3 = null;
    private static final jhf.O000000o ajc$tjp_4 = null;
    private static final jhf.O000000o ajc$tjp_5 = null;
    private static HashMap<String, String> language;
    int dataCountry;
    int dataLanguage;
    int dataType;

    private static void ajc$preClinit() {
        jho jho = new jho("AppleDataBox.java", AppleDataBox.class);
        ajc$tjp_0 = jho.O000000o("method-execution", jho.O000000o("1", "getLanguageString", "org.mp4parser.boxes.apple.AppleDataBox", "", "", "", "java.lang.String"), 137);
        ajc$tjp_1 = jho.O000000o("method-execution", jho.O000000o("1", "getDataType", "org.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 155);
        ajc$tjp_2 = jho.O000000o("method-execution", jho.O000000o("1", "getDataCountry", "org.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 159);
        ajc$tjp_3 = jho.O000000o("method-execution", jho.O000000o("1", "setDataCountry", "org.mp4parser.boxes.apple.AppleDataBox", "int", "dataCountry", "", "void"), 163);
        ajc$tjp_4 = jho.O000000o("method-execution", jho.O000000o("1", "getDataLanguage", "org.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 167);
        ajc$tjp_5 = jho.O000000o("method-execution", jho.O000000o("1", "setDataLanguage", "org.mp4parser.boxes.apple.AppleDataBox", "int", "dataLanguage", "", "void"), 171);
    }

    /* access modifiers changed from: protected */
    public abstract int getDataLength();

    /* access modifiers changed from: protected */
    public abstract void parseData(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public abstract byte[] writeData();

    static {
        ajc$preClinit();
        HashMap<String, String> hashMap = new HashMap<>();
        language = hashMap;
        hashMap.put("0", "English");
        language.put("1", "French");
        language.put("2", "German");
        language.put("3", "Italian");
        language.put("4", "Dutch");
        language.put("5", "Swedish");
        language.put("6", "Spanish");
        language.put("7", "Danish");
        language.put("8", "Portuguese");
        language.put("9", "Norwegian");
        language.put("10", "Hebrew");
        language.put("11", "Japanese");
        language.put("12", "Arabic");
        language.put("13", "Finnish");
        language.put("14", "Greek");
        language.put("15", "Icelandic");
        language.put("16", "Maltese");
        language.put("17", "Turkish");
        language.put("18", "Croatian");
        language.put("19", "Traditional_Chinese");
        language.put("20", "Urdu");
        language.put("21", "Hindi");
        language.put("22", "Thai");
        language.put(ayt.f12712O000000o, "Korean");
        language.put("24", "Lithuanian");
        language.put("25", "Polish");
        language.put("26", "Hungarian");
        language.put("27", "Estonian");
        language.put("28", "Lettish");
        language.put("29", "Sami");
        language.put("30", "Faroese");
        language.put("31", "Farsi");
        language.put("32", "Russian");
        language.put("33", "Simplified_Chinese");
        language.put("34", "Flemish");
        language.put("35", "Irish");
        language.put("36", "Albanian");
        language.put("37", "Romanian");
        language.put("38", "Czech");
        language.put("39", "Slovak");
        language.put("40", "Slovenian");
        language.put("41", "Yiddish");
        language.put("42", "Serbian");
        language.put("43", "Macedonian");
        language.put("44", "Bulgarian");
        language.put("45", "Ukrainian");
        language.put("46", "Belarusian");
        language.put("47", "Uzbek");
        language.put("48", "Kazakh");
        language.put("49", "Azerbaijani");
        language.put("50", "AzerbaijanAr");
        language.put("51", "Armenian");
        language.put("52", "Georgian");
        language.put("53", "Moldavian");
        language.put("54", "Kirghiz");
        language.put("55", "Tajiki");
        language.put("56", "Turkmen");
        language.put("57", "Mongolian");
        language.put("58", "MongolianCyr");
        language.put("59", "Pashto");
        language.put("60", "Kurdish");
        language.put("61", "Kashmiri");
        language.put("62", "Sindhi");
        language.put("63", "Tibetan");
        language.put("64", "Nepali");
        language.put("65", "Sanskrit");
        language.put("66", "Marathi");
        language.put("67", "Bengali");
        language.put("68", "Assamese");
        language.put("69", "Gujarati");
        language.put("70", "Punjabi");
        language.put("71", "Oriya");
        language.put("72", "Malayalam");
        language.put("73", "Kannada");
        language.put("74", "Tamil");
        language.put("75", "Telugu");
        language.put("76", "Sinhala");
        language.put("77", "Burmese");
        language.put("78", "Khmer");
        language.put("79", "Lao");
        language.put("80", "Vietnamese");
        language.put("81", "Indonesian");
        language.put("82", "Tagalog");
        language.put("83", "MalayRoman");
        language.put("84", "MalayArabic");
        language.put("85", "Amharic");
        language.put("87", "Galla");
        language.put("87", "Oromo");
        language.put("88", "Somali");
        language.put("89", "Swahili");
        language.put("90", "Kinyarwanda");
        language.put("91", "Rundi");
        language.put("92", "Nyanja");
        language.put("93", "Malagasy");
        language.put("94", "Esperanto");
        language.put("128", "Welsh");
        language.put("129", "Basque");
        language.put("130", "Catalan");
        language.put("131", "Latin");
        language.put("132", "Quechua");
        language.put("133", "Guarani");
        language.put("134", "Aymara");
        language.put("135", "Tatar");
        language.put("136", "Uighur");
        language.put("137", "Dzongkha");
        language.put("138", "JavaneseRom");
        language.put("32767", "Unspecified");
    }

    protected AppleDataBox(String str, int i) {
        super(str);
        this.dataType = i;
    }

    public String getLanguageString() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_0, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        HashMap<String, String> hashMap = language;
        StringBuilder sb = new StringBuilder();
        sb.append(this.dataLanguage);
        String str = hashMap.get(sb.toString());
        if (str != null) {
            return str;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[2]);
        jla.O00000Oo(wrap, this.dataLanguage);
        wrap.reset();
        return new Locale(jky.O0000Oo(wrap)).getDisplayLanguage();
    }

    public long getContentSize() {
        return (long) (getDataLength() + 16);
    }

    public int getDataType() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_1, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataType;
    }

    public int getDataCountry() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_2, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataCountry;
    }

    public int getDataLanguage() {
        jhf O000000o2 = jho.O000000o(ajc$tjp_4, this, this);
        jku.O000000o();
        jku.O000000o(O000000o2);
        return this.dataLanguage;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer parseDataLength4ccTypeCountryLanguageAndReturnRest(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        this.dataType = byteBuffer.getInt();
        this.dataCountry = byteBuffer.getShort();
        int i2 = this.dataCountry;
        if (i2 < 0) {
            this.dataCountry = i2 + 65536;
        }
        this.dataLanguage = byteBuffer.getShort();
        int i3 = this.dataLanguage;
        if (i3 < 0) {
            this.dataLanguage = i3 + 65536;
        }
        int i4 = i - 16;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.duplicate().slice().limit(i4);
        byteBuffer.position(i4 + byteBuffer.position());
        return byteBuffer2;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseData(parseDataLength4ccTypeCountryLanguageAndReturnRest(byteBuffer));
    }

    public void getContent(ByteBuffer byteBuffer) {
        writeDataLength4ccTypeCountryLanguage(byteBuffer);
        byteBuffer.put(writeData());
    }

    /* access modifiers changed from: protected */
    public void writeDataLength4ccTypeCountryLanguage(ByteBuffer byteBuffer) {
        byteBuffer.putInt(getDataLength() + 16);
        byteBuffer.put("data".getBytes());
        byteBuffer.putInt(this.dataType);
        jla.O00000Oo(byteBuffer, this.dataCountry);
        jla.O00000Oo(byteBuffer, this.dataLanguage);
    }

    public void setDataCountry(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_3, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.dataCountry = i;
    }

    public void setDataLanguage(int i) {
        jhf O000000o2 = jho.O000000o(ajc$tjp_5, this, this, Integer.valueOf(i));
        jku.O000000o();
        jku.O000000o(O000000o2);
        this.dataLanguage = i;
    }
}
