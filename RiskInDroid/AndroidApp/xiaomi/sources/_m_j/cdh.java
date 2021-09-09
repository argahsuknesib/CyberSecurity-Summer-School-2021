package _m_j;

public class cdh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile cdh f13661O000000o;

    private cdh() {
    }

    public static cdh O000000o() {
        if (f13661O000000o == null) {
            synchronized (cdh.class) {
                if (f13661O000000o == null) {
                    f13661O000000o = new cdh();
                }
            }
        }
        return f13661O000000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long */
    public static long O00000Oo() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        try {
            long O000000o2 = cde.O000000o(ccx.O000000o(), "server_delay", 0L);
            try {
                if (Math.abs(currentTimeMillis - O000000o2) >= 1000) {
                    j = O000000o2;
                }
            } catch (Exception e) {
                long j2 = O000000o2;
                e = e;
                j = j2;
                e.printStackTrace();
                return currentTimeMillis + j;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return currentTimeMillis + j;
        }
        return currentTimeMillis + j;
    }
}
