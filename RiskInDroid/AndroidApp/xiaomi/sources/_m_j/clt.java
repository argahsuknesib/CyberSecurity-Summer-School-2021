package _m_j;

import com.mijia.model.sdcard.TimeItem;
import java.util.Comparator;

public final class clt implements Comparator<TimeItem> {
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        TimeItem timeItem = (TimeItem) obj;
        TimeItem timeItem2 = (TimeItem) obj2;
        if (timeItem.f5243O000000o == timeItem2.f5243O000000o) {
            return 0;
        }
        return timeItem.f5243O000000o > timeItem2.f5243O000000o ? 1 : -1;
    }
}
