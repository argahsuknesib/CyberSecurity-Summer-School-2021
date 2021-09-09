package _m_j;

import java.util.Date;

public final class jkw {
    public static Date O000000o(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    public static long O000000o(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
