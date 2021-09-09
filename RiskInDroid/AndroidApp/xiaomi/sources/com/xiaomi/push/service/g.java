package com.xiaomi.push.service;

import _m_j.eqo;
import _m_j.eqw;
import _m_j.eqx;
import _m_j.erb;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class g implements eqw {
    public static eqo a(XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        String str;
        String[] strArr;
        String[] strArr2;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = erb.O00000Oo(xmlPullParser.getAttributeValue(i));
            }
            strArr2 = strArr3;
            str = null;
            arrayList = null;
            strArr = strArr4;
        } else {
            strArr2 = null;
            strArr = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new eqo(name, namespace, strArr2, strArr, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                eqo a2 = a(xmlPullParser);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
    }

    public eqo b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }

    public void a() {
        eqx O000000o2 = eqx.O000000o();
        O000000o2.f15735O000000o.put(eqx.O00000Oo("all", "xm:chat"), this);
    }
}
