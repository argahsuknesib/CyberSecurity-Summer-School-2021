package _m_j;

import java.util.Comparator;

public final class O00Oo0 implements Comparator<String> {
    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        return str2.length() != str.length() ? str.length() - str2.length() : str2.compareTo(str);
    }
}
