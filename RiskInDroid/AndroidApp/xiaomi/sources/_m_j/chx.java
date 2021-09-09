package _m_j;

import java.util.ArrayList;
import java.util.List;

public final class chx extends cll {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String[] f13863O000000o = {"light", "motion_record", "flip", "watermark", "sdcard_status", "power", "wdr", "night_mode", "mini_level", "full_color", "max_client"};
    public static final String[] O00000Oo = {"light", "motion_record", "flip", "watermark", "sdcard_status", "power", "night_mode", "rect", "max_client"};

    public chx(chs chs) {
        super(chs);
    }

    public final List<String> O000000o() {
        ArrayList arrayList = new ArrayList();
        for (String valueOf : f13863O000000o) {
            arrayList.add("prop.".concat(String.valueOf(valueOf)));
        }
        return arrayList;
    }

    public final List<String> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        for (String valueOf : O00000Oo) {
            arrayList.add("prop.".concat(String.valueOf(valueOf)));
        }
        return arrayList;
    }
}
