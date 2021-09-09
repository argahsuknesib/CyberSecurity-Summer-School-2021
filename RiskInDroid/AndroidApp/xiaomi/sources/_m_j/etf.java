package _m_j;

import android.util.Size;

public final class etf {
    public static Size O000000o(Size[] sizeArr, int i, int i2) {
        Size size = sizeArr[0];
        boolean z = size.getWidth() >= i && size.getHeight() >= i2;
        Size size2 = size;
        for (int i3 = 1; i3 < sizeArr.length; i3++) {
            Size size3 = sizeArr[i3];
            boolean z2 = size3.getWidth() >= i && size3.getHeight() >= i2;
            if (!z && z2) {
                size2 = size3;
                z = true;
            } else if ((!z2) ^ z) {
                if ((((long) size2.getWidth()) * ((long) size2.getHeight()) < ((long) size3.getWidth()) * ((long) size3.getHeight())) ^ z) {
                    size2 = size3;
                }
            }
        }
        return size2;
    }
}
