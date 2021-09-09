package _m_j;

import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public final class clu {

    /* renamed from: O000000o  reason: collision with root package name */
    static SimpleDateFormat f14113O000000o;
    static SimpleDateFormat O00000Oo = new SimpleDateFormat("dd.MM.yyyy");
    static SimpleDateFormat O00000o0 = new SimpleDateFormat("yyyy.MM.dd");
    public long O00000o;
    public String O00000oO;
    public int O00000oo;
    public List<clv> O0000O0o = new ArrayList();
    public boolean[] O0000OOo = new boolean[24];

    public final void O000000o(boolean z) {
        if (!z) {
            for (int i = 0; i < 24; i++) {
                this.O0000OOo[i] = false;
            }
            return;
        }
        for (clv clv : this.O0000O0o) {
            int i2 = clv.f14114O000000o;
            if (i2 >= 0 && i2 <= 23) {
                this.O0000OOo[i2] = z;
            }
        }
    }

    public final clv O000000o(int i) {
        for (int i2 = 0; i2 < this.O0000O0o.size(); i2++) {
            if (this.O0000O0o.get(i2).f14114O000000o == i) {
                return this.O0000O0o.get(i2);
            }
        }
        return null;
    }

    public final List<TimeItem> O000000o() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.O0000O0o.size(); i++) {
            int i2 = this.O0000O0o.get(i).f14114O000000o;
            if ((i2 < 0 || i2 > 23) ? false : this.O0000OOo[i2]) {
                arrayList.addAll(this.O0000O0o.get(i).O00000o0);
            }
        }
        return arrayList;
    }

    public static SimpleDateFormat O00000Oo() {
        String language = XmPluginHostApi.instance().getSettingLocale() != null ? XmPluginHostApi.instance().getSettingLocale().getLanguage() : null;
        if (XmPluginHostApi.instance().getApiLevel() < 51 || (!"de".equalsIgnoreCase(language) && !"es".equalsIgnoreCase(language) && !"fr".equalsIgnoreCase(language) && !"it".equalsIgnoreCase(language) && !"pl".equalsIgnoreCase(language) && !"ru".equalsIgnoreCase(language))) {
            return O00000o0;
        }
        return O00000Oo;
    }

    public static List<clu> O000000o(List<TimeItem> list, String str) {
        f14113O000000o = O00000Oo();
        Calendar instance = Calendar.getInstance(mi.O000000o());
        f14113O000000o.setTimeZone(mi.O000000o());
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int size = list.size();
            clu clu = null;
            clv clv = null;
            for (int i = 0; i < size; i++) {
                TimeItem timeItem = list.get(i);
                instance.setTimeInMillis(timeItem.f5243O000000o);
                int i2 = instance.get(5);
                int i3 = instance.get(11);
                if (!(clu == null || clu.O00000oo == i2)) {
                    clu = null;
                    clv = null;
                }
                if (!(clv == null || clv.f14114O000000o == i3)) {
                    clv = null;
                }
                if (clu == null) {
                    clu = new clu();
                    clu.O00000oO = f14113O000000o.format(Long.valueOf(timeItem.f5243O000000o));
                    clu.O00000o = timeItem.f5243O000000o;
                    clu.O00000oo = i2;
                    arrayList.add(clu);
                }
                if (clv == null) {
                    clv = new clv();
                    clv.f14114O000000o = i3;
                    clu.O0000O0o.add(clv);
                }
                clv.O00000o0.add(timeItem);
            }
            if (!DeviceConstant.supportNewPlayBack(str)) {
                Collections.reverse(arrayList);
            }
        }
        return arrayList;
    }
}
