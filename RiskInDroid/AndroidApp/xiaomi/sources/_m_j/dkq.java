package _m_j;

import com.tencent.wxop.stat.StatReportStrategy;

final /* synthetic */ class dkq {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ int[] f14749O000000o = new int[StatReportStrategy.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    static {
        f14749O000000o[StatReportStrategy.INSTANT.ordinal()] = 1;
        f14749O000000o[StatReportStrategy.PERIOD.ordinal()] = 2;
        f14749O000000o[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        f14749O000000o[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        f14749O000000o[StatReportStrategy.BATCH.ordinal()] = 5;
        f14749O000000o[StatReportStrategy.ONLY_WIFI.ordinal()] = 6;
        try {
            f14749O000000o[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError unused) {
        }
    }
}
