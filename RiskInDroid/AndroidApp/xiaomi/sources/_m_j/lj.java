package _m_j;

public final class lj {
    public static String O000000o(String str, Class[] clsArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("(");
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.toString());
        if (clsArr.length > 0) {
            stringBuffer2.append(" ");
        }
        int i = 0;
        while (i < clsArr.length) {
            Class cls = clsArr[i];
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(cls == null ? "null" : cls.getName());
            stringBuffer3.append(i < clsArr.length + -1 ? ", " : " ");
            stringBuffer2.append(stringBuffer3.toString());
            i++;
        }
        stringBuffer2.append(")");
        return stringBuffer2.toString();
    }
}
