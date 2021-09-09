package _m_j;

import java.lang.reflect.Modifier;

final class jhr extends jhn implements jhk {
    Class O00000o;

    jhr(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.O00000o = cls2;
    }

    /* access modifiers changed from: protected */
    public final String O000000o(jhu jhu) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.O00000oO == -1) {
            this.O00000oO = Integer.parseInt(O000000o(0), 16);
        }
        int i = this.O00000oO;
        String str = "";
        if (jhu.O00000o) {
            String modifier = Modifier.toString(i);
            if (modifier.length() != 0) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(modifier);
                stringBuffer2.append(" ");
                str = stringBuffer2.toString();
            }
        }
        stringBuffer.append(str);
        if (jhu.O00000Oo) {
            if (this.O00000o == null) {
                this.O00000o = O00000Oo(6);
            }
            stringBuffer.append(jhu.O000000o(this.O00000o));
        }
        if (jhu.O00000Oo) {
            stringBuffer.append(" ");
        }
        Class O00000o0 = O00000o0();
        if (this.O0000O0o == null) {
            this.O0000O0o = O00000o0().getName();
        }
        stringBuffer.append(jhu.O000000o(O00000o0, this.O0000O0o, jhu.O00000oO));
        stringBuffer.append(".");
        if (this.O00000oo == null) {
            this.O00000oo = O000000o(1);
        }
        stringBuffer.append(this.O00000oo);
        Class[] O000000o2 = O000000o();
        if (O000000o2 != null) {
            if (jhu.O00000Oo) {
                stringBuffer.append("(");
                jhu.O000000o(stringBuffer, O000000o2);
                stringBuffer.append(")");
            } else if (O000000o2.length == 0) {
                stringBuffer.append("()");
            } else {
                stringBuffer.append("(..)");
            }
        }
        Class[] O00000Oo = O00000Oo();
        if (!(!jhu.O00000o0 || O00000Oo == null || O00000Oo.length == 0)) {
            stringBuffer.append(" throws ");
            jhu.O000000o(stringBuffer, O00000Oo);
        }
        return stringBuffer.toString();
    }
}
