package _m_j;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.Tip;
import com.xiaomi.smarthome.newui.amappoi.LocationBean;
import java.util.ArrayList;
import java.util.List;

public class hbu implements Inputtips.InputtipsListener {
    private static volatile hbu O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<LocationBean> f18758O000000o = new ArrayList();
    private AutoCompleteTextView O00000o;
    private Context O00000o0;

    private hbu(Context context) {
        this.O00000o0 = context;
    }

    public static hbu O000000o(Context context) {
        if (O00000Oo == null) {
            synchronized (hbu.class) {
                if (O00000Oo == null) {
                    O00000Oo = new hbu(context);
                }
            }
        }
        return O00000Oo;
    }

    public void onGetInputtips(List<Tip> list, int i) {
        if (i == 1000) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                this.f18758O000000o.clear();
                for (Tip next : list) {
                    arrayList.add(next.getName());
                    this.f18758O000000o.add(new LocationBean(next.getPoint().getLongitude(), next.getPoint().getLatitude(), next.getAddress(), next.getDistrict()));
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.O00000o0, 17367043, arrayList);
            this.O00000o.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
