package _m_j;

import _m_j.eqp;
import _m_j.equ;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.go;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.g;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class eqy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static XmlPullParser f15736O000000o;

    private static String O00000o(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    public static eqt O00000o0(XmlPullParser xmlPullParser) {
        eqt eqt = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                eqt = new eqt(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return eqt;
    }

    private static equ O00000oO(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = "-1";
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str3 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(xmlPullParser.getNamespace())) {
                        str4 = name;
                    } else {
                        arrayList.add(O00000oo(xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new equ(Integer.parseInt(str3), str == null ? "cancel" : str, str2, str4, str5, arrayList);
    }

    private static eqo O00000oo(XmlPullParser xmlPullParser) {
        Object O000000o2 = eqx.O000000o().O000000o("all", "xm:chat");
        if (O000000o2 == null || !(O000000o2 instanceof g)) {
            return null;
        }
        return ((g) O000000o2).b(xmlPullParser);
    }

    private static String O0000O0o(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:131:0x019b */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:122:0x019b */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:128:0x019b */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:120:0x00ef */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:119:0x00ef */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: _m_j.eqr} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: _m_j.eqr} */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    /* JADX WARNING: Multi-variable type inference failed */
    public static eqr O000000o(XmlPullParser xmlPullParser) {
        String str;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int i = 2;
        boolean z = false;
        ? r13 = 0;
        if ("1".equals(xmlPullParser2.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser2.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser2.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser2.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser2.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser2.getAttributeValue("", "type");
            az.b a2 = az.a().a(attributeValue, attributeValue4);
            if (a2 == null) {
                a2 = az.a().a(attributeValue, attributeValue3);
            }
            az.b bVar = a2;
            if (bVar != null) {
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == i) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new gg("error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                eqq eqq = new eqq();
                                eqq.O0000oOO = attributeValue;
                                eqq.O0000o00 = true;
                                eqq.O0000oO = attributeValue3;
                                eqq.O0000oO0 = attributeValue4;
                                eqq.O0000o = attributeValue2;
                                eqq.f15730O000000o = attributeValue5;
                                eqo eqo = new eqo("s");
                                eqo.O00000Oo(text);
                                eqq.O000000o(eqo);
                                return eqq;
                            }
                            byte[] a3 = bi.a(bi.a(bVar.h, attributeValue2), text);
                            if (f15736O000000o == null) {
                                try {
                                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                                    f15736O000000o = newPullParser;
                                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                                } catch (XmlPullParserException e) {
                                    e.printStackTrace();
                                }
                            }
                            f15736O000000o.setInput(new InputStreamReader(new ByteArrayInputStream(a3)));
                            f15736O000000o.next();
                            r13 = O000000o(f15736O000000o);
                        } else {
                            throw new gg("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                    i = 2;
                    r13 = r13;
                }
                if (r13 != 0) {
                    return r13;
                }
                throw new gg("error while receiving a encrypted message with wrong format");
            }
            throw new gg("the channel id is wrong while receiving a encrypted message");
        }
        eqq eqq2 = new eqq();
        String attributeValue6 = xmlPullParser2.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        eqq2.O0000o = attributeValue6;
        eqq2.O0000oO0 = xmlPullParser2.getAttributeValue("", "to");
        eqq2.O0000oO = xmlPullParser2.getAttributeValue("", "from");
        eqq2.O0000oOO = xmlPullParser2.getAttributeValue("", "chid");
        eqq2.O0000OOo = xmlPullParser2.getAttributeValue("", "appid");
        try {
            str = xmlPullParser2.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser2.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                eqq2.O0000Oo0 = attributeValue7;
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser2.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                eqq2.O0000Oo = attributeValue8;
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser2.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                eqq2.O0000OoO = attributeValue9;
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser2.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                eqq2.O0000Ooo = attributeValue10;
            }
        } catch (Exception unused5) {
        }
        eqq2.O0000O0o = !TextUtils.isEmpty(str) && str.equalsIgnoreCase("true");
        eqq2.f15730O000000o = xmlPullParser2.getAttributeValue("", "type");
        String O0000O0o = O0000O0o(xmlPullParser);
        if (O0000O0o == null || "".equals(O0000O0o.trim())) {
            eqr.O00000oo();
        } else {
            eqq2.O00000o0 = O0000O0o;
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                TextUtils.isEmpty(xmlPullParser.getNamespace());
                if (name.equals("subject")) {
                    O0000O0o(xmlPullParser);
                    eqq2.O00000o = O00000o(xmlPullParser);
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser2.getAttributeValue("", "encode");
                    String O00000o = O00000o(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        eqq2.O00000oO = O00000o;
                        eqq2.O00000oo = attributeValue11;
                    } else {
                        eqq2.O00000oO = O00000o;
                    }
                } else if (name.equals("thread")) {
                    if (r13 == 0) {
                        r13 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    eqq2.O0000oo0 = O00000oO(xmlPullParser);
                } else {
                    eqq2.O000000o(O00000oo(xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        eqq2.O00000Oo = r13;
        return eqq2;
    }

    public static go O00000Oo(XmlPullParser xmlPullParser) {
        go.b bVar = go.b.f6387a;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = go.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type ".concat(String.valueOf(attributeValue)));
            }
        }
        go goVar = new go(bVar);
        goVar.O0000oO0 = xmlPullParser.getAttributeValue("", "to");
        goVar.O0000oO = xmlPullParser.getAttributeValue("", "from");
        goVar.O0000oOO = xmlPullParser.getAttributeValue("", "chid");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        goVar.O0000o = attributeValue2;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    goVar.f6385O000000o = xmlPullParser.nextText();
                } else if (name.equals("priority")) {
                    try {
                        goVar.O000000o(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        goVar.O000000o(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        goVar.O00000Oo = go.a.valueOf(nextText);
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode ".concat(String.valueOf(nextText)));
                    }
                } else if (name.equals("error")) {
                    goVar.O0000oo0 = O00000oO(xmlPullParser);
                } else {
                    goVar.O000000o(O00000oo(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return goVar;
    }

    public static eqp O000000o(XmlPullParser xmlPullParser, eqb eqb) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        eqp.O000000o O000000o2 = eqp.O000000o.O000000o(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        eqp eqp = null;
        equ equ = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    equ = O00000oO(xmlPullParser);
                } else {
                    eqp = new eqp();
                    eqp.O000000o(O00000oo(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (eqp == null) {
            if (eqp.O000000o.f15729O000000o == O000000o2 || eqp.O000000o.O00000Oo == O000000o2) {
                eqz eqz = new eqz();
                eqz.O0000o = attributeValue;
                eqz.O0000oO0 = attributeValue3;
                eqz.O0000oO = attributeValue2;
                eqz.O000000o(eqp.O000000o.O00000o);
                eqz.O0000oOO = attributeValue4;
                eqz.O0000oo0 = new equ(equ.O000000o.O00000oO);
                eqb.O000000o(eqz);
                duv.O00000o("iq usage error. send packet in packet parser.");
                return null;
            }
            eqp = new era();
        }
        eqp.O0000o = attributeValue;
        eqp.O0000oO0 = attributeValue2;
        eqp.O0000oOO = attributeValue4;
        eqp.O0000oO = attributeValue3;
        eqp.O000000o(O000000o2);
        eqp.O0000oo0 = equ;
        eqp.O000000o(hashMap);
        return eqp;
    }
}
