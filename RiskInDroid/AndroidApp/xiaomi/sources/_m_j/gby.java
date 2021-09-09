package _m_j;

public final class gby {
    public static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            sb.append((int) (bArr[i] & 255));
            i++;
            if (i < bArr.length) {
                sb.append(",");
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
