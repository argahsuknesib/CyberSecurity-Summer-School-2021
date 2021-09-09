package _m_j;

import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class gbb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Charset f17486O000000o = Charset.forName("UTF-8");

    public interface O000000o {
        Object O000000o() throws XmlPullParserException, IOException;
    }

    public interface O00000Oo {
    }

    public static final void O000000o(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, f17486O000000o.name());
        newSerializer.startDocument(null, Boolean.TRUE);
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        O000000o(map, (String) null, newSerializer);
        newSerializer.endDocument();
    }

    private static void O000000o(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        O000000o(map, xmlSerializer, (O00000Oo) null);
        xmlSerializer.endTag(null, "map");
    }

    private static void O000000o(Map map, XmlSerializer xmlSerializer, O00000Oo o00000Oo) throws XmlPullParserException, IOException {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                O000000o(entry.getValue(), (String) entry.getKey(), xmlSerializer, (O00000Oo) null);
            }
        }
    }

    private static void O000000o(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            O000000o(list.get(i), (String) null, xmlSerializer, (O00000Oo) null);
        }
        xmlSerializer.endTag(null, "list");
    }

    private static void O000000o(Set set, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (set == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "set");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Object O000000o2 : set) {
            O000000o(O000000o2, (String) null, xmlSerializer, (O00000Oo) null);
        }
        xmlSerializer.endTag(null, "set");
    }

    private static void O000000o(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r8));
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = (b >> 4) & 15;
            sb.append((char) (i >= 10 ? (i + 97) - 10 : i + 48));
            byte b2 = b & 15;
            sb.append((char) (b2 >= 10 ? (b2 + 97) - 10 : b2 + 48));
        }
        xmlSerializer.text(sb.toString());
        xmlSerializer.endTag(null, "byte-array");
    }

    private static void O000000o(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r7));
        for (int num : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Integer.toString(num));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
    }

    private static void O000000o(long[] jArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (jArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "long-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r7));
        for (long l : jArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Long.toString(l));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "long-array");
    }

    private static void O000000o(double[] dArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (dArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "double-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r7));
        for (double d : dArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Double.toString(d));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "double-array");
    }

    private static void O000000o(String[] strArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (strArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "string-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r7));
        for (String attribute : strArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", attribute);
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "string-array");
    }

    private static void O000000o(boolean[] zArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (zArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "boolean-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r7));
        for (boolean bool : zArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Boolean.toString(bool));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "boolean-array");
    }

    private static final void O000000o(Object obj, String str, XmlSerializer xmlSerializer, O00000Oo o00000Oo) throws XmlPullParserException, IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag(null, "null");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, "null");
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
        } else {
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = "boolean";
            } else if (obj instanceof byte[]) {
                O000000o((byte[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof int[]) {
                O000000o((int[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof long[]) {
                O000000o((long[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof double[]) {
                O000000o((double[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof String[]) {
                O000000o((String[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof boolean[]) {
                O000000o((boolean[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Map) {
                O000000o((Map) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof List) {
                O000000o((List) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Set) {
                O000000o((Set) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag(null, "string");
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, "string");
                return;
            } else if (o00000Oo == null) {
                throw new RuntimeException("writeValueXml: unable to write value ".concat(String.valueOf(obj)));
            } else {
                return;
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.attribute(null, "value", obj.toString());
            xmlSerializer.endTag(null, str2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, boolean):java.lang.Object
     arg types: [org.xmlpull.v1.XmlPullParser, java.lang.String[], ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String[], _m_j.gbb$O000000o):java.util.HashMap<java.lang.String, ?>
      _m_j.gbb.O000000o(java.lang.Object, java.lang.String, org.xmlpull.v1.XmlSerializer, _m_j.gbb$O00000Oo):void
      _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, boolean):java.lang.Object */
    public static final HashMap<String, ?> O000000o(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, f17486O000000o.name());
        String[] strArr = new String[1];
        int eventType = newPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + newPullParser.getName());
            } else if (eventType != 4) {
                eventType = newPullParser.next();
                if (eventType == 1) {
                    throw new XmlPullParserException("Unexpected end of document");
                }
            } else {
                throw new XmlPullParserException("Unexpected text: " + newPullParser.getText());
            }
        }
        return (HashMap) O000000o(newPullParser, strArr, (O000000o) null, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, boolean):java.lang.Object
     arg types: [org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, int]
     candidates:
      _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String[], _m_j.gbb$O000000o):java.util.HashMap<java.lang.String, ?>
      _m_j.gbb.O000000o(java.lang.Object, java.lang.String, org.xmlpull.v1.XmlSerializer, _m_j.gbb$O00000Oo):void
      _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, boolean):java.lang.Object */
    private static HashMap<String, ?> O000000o(XmlPullParser xmlPullParser, String str, String[] strArr, O000000o o000000o) throws XmlPullParserException, IOException {
        HashMap<String, ?> hashMap = new HashMap<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashMap.put(strArr[0], O000000o(xmlPullParser, strArr, o000000o, false));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, boolean):java.lang.Object
     arg types: [org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, int]
     candidates:
      _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String[], _m_j.gbb$O000000o):java.util.HashMap<java.lang.String, ?>
      _m_j.gbb.O000000o(java.lang.Object, java.lang.String, org.xmlpull.v1.XmlSerializer, _m_j.gbb$O00000Oo):void
      _m_j.gbb.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String[], _m_j.gbb$O000000o, boolean):java.lang.Object */
    private static o0O0OOO0<String, ?> O00000Oo(XmlPullParser xmlPullParser, String str, String[] strArr, O000000o o000000o) throws XmlPullParserException, IOException {
        o0O0OOO0<String, ?> o0o0ooo0 = new o0O0OOO0<>();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                o0o0ooo0.put(strArr[0], O000000o(xmlPullParser, strArr, o000000o, true));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return o0o0ooo0;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final ArrayList O000000o(XmlPullParser xmlPullParser, String str, String[] strArr, O000000o o000000o, boolean z) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(O000000o(xmlPullParser, strArr, o000000o, z));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final HashSet O00000Oo(XmlPullParser xmlPullParser, String str, String[] strArr, O000000o o000000o, boolean z) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(O000000o(xmlPullParser, strArr, o000000o, z));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashSet;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static byte[] O000000o(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            byte[] bArr = new byte[parseInt];
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 4) {
                    if (parseInt > 0) {
                        String text = xmlPullParser.getText();
                        if (text == null || text.length() != parseInt * 2) {
                            throw new XmlPullParserException("Invalid value found in byte-array: ".concat(String.valueOf(text)));
                        }
                        for (int i = 0; i < parseInt; i++) {
                            int i2 = i * 2;
                            char charAt = text.charAt(i2);
                            char charAt2 = text.charAt(i2 + 1);
                            bArr[i] = (byte) (((charAt2 > 'a' ? (charAt2 - 'a') + 10 : charAt2 - '0') & 15) | (((charAt > 'a' ? (charAt - 'a') + 10 : charAt - '0') & 15) << 4));
                        }
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return bArr;
                    }
                    throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException unused2) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    private static int[] O00000Oo(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            int[] iArr = new int[parseInt];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            iArr[i] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in int-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in int-array");
        }
    }

    private static long[] O00000o0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            long[] jArr = new long[parseInt];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            jArr[i] = Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return jArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in long-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in long-array");
        }
    }

    private static double[] O00000o(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            double[] dArr = new double[parseInt];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            dArr[i] = Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return dArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in double-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in double-array");
        }
    }

    private static String[] O00000oO(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            String[] strArr = new String[parseInt];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            strArr[i] = xmlPullParser.getAttributeValue(null, "value");
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return strArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in string-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static boolean[] O00000oo(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            boolean[] zArr = new boolean[parseInt];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            zArr[i] = Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return zArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in string-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static final Object O000000o(XmlPullParser xmlPullParser, String[] strArr, O000000o o000000o, boolean z) throws XmlPullParserException, IOException {
        int next;
        Object obj;
        Object obj2 = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    } else if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    } else if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else {
                obj2 = O0000O0o(xmlPullParser, name);
                if (obj2 == null) {
                    if (name.equals("byte-array")) {
                        byte[] O000000o2 = O000000o(xmlPullParser, "byte-array");
                        strArr[0] = attributeValue;
                        return O000000o2;
                    } else if (name.equals("int-array")) {
                        int[] O00000Oo2 = O00000Oo(xmlPullParser, "int-array");
                        strArr[0] = attributeValue;
                        return O00000Oo2;
                    } else if (name.equals("long-array")) {
                        long[] O00000o0 = O00000o0(xmlPullParser, "long-array");
                        strArr[0] = attributeValue;
                        return O00000o0;
                    } else if (name.equals("double-array")) {
                        double[] O00000o = O00000o(xmlPullParser, "double-array");
                        strArr[0] = attributeValue;
                        return O00000o;
                    } else if (name.equals("string-array")) {
                        String[] O00000oO = O00000oO(xmlPullParser, "string-array");
                        strArr[0] = attributeValue;
                        return O00000oO;
                    } else if (name.equals("boolean-array")) {
                        boolean[] O00000oo = O00000oo(xmlPullParser, "boolean-array");
                        strArr[0] = attributeValue;
                        return O00000oo;
                    } else if (name.equals("map")) {
                        xmlPullParser.next();
                        if (z) {
                            obj = O00000Oo(xmlPullParser, "map", strArr, o000000o);
                        } else {
                            obj = O000000o(xmlPullParser, "map", strArr, o000000o);
                        }
                        strArr[0] = attributeValue;
                        return obj;
                    } else if (name.equals("list")) {
                        xmlPullParser.next();
                        ArrayList O000000o3 = O000000o(xmlPullParser, "list", strArr, o000000o, z);
                        strArr[0] = attributeValue;
                        return O000000o3;
                    } else if (name.equals("set")) {
                        xmlPullParser.next();
                        HashSet O00000Oo3 = O00000Oo(xmlPullParser, "set", strArr, o000000o, z);
                        strArr[0] = attributeValue;
                        return O00000Oo3;
                    } else if (o000000o != null) {
                        Object O000000o4 = o000000o.O000000o();
                        strArr[0] = attributeValue;
                        return O000000o4;
                    } else {
                        throw new XmlPullParserException("Unknown tag: ".concat(String.valueOf(name)));
                    }
                }
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + ">");
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj2;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            } else if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }

    private static final Object O0000O0o(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            if (str.equals("int")) {
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            }
            if (str.equals("long")) {
                return Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("float")) {
                return new Float(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("double")) {
                return new Double(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("boolean")) {
                return Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            return null;
        } catch (NullPointerException unused) {
            throw new XmlPullParserException("Need value attribute in <" + str + ">");
        } catch (NumberFormatException unused2) {
            throw new XmlPullParserException("Not a number in value attribute in <" + str + ">");
        }
    }
}
