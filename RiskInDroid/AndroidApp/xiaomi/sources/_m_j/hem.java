package _m_j;

public final class hem {
    public static float O000000o(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (i > 100) {
            i = 100;
        }
        return (((float) i) * 0.0045f) + 0.5f;
    }

    public static float O000000o(int i, int i2, int i3) {
        if (i < i2) {
            i = i2;
        }
        if (i > i3) {
            i = i3;
        }
        return (((float) (i3 - i)) * (0.4f / ((float) (i3 - i2)))) + 0.4f;
    }
}
