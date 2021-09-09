package _m_j;

public final class bvf {
    public static boolean O000000o(String str) {
        return str == null || str.length() <= 0;
    }

    public static int O00000Oo(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }
}
