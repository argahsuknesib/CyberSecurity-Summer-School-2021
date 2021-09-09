package _m_j;

import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.xiaomi.smarthome.newui.amappoi.LocationBean;
import java.util.ArrayList;
import java.util.Iterator;

public class hbv implements PoiSearch.OnPoiSearchListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hbv f18759O000000o;
    private PoiSearch O00000Oo;
    private AMapLocation O00000o;
    private Context O00000o0;

    public void onPoiItemSearched(PoiItem poiItem, int i) {
    }

    private hbv(Context context) {
        this.O00000o0 = context;
    }

    public static hbv O000000o(Context context) {
        if (f18759O000000o == null) {
            synchronized (hbv.class) {
                if (f18759O000000o == null) {
                    f18759O000000o = new hbv(context);
                }
            }
        }
        return f18759O000000o;
    }

    public final ArrayList<LocationBean> O000000o(String str, String str2, AMapLocation aMapLocation) {
        this.O00000o = aMapLocation;
        PoiSearch.Query query = new PoiSearch.Query(str, "", str2);
        this.O00000Oo = new PoiSearch(this.O00000o0, query);
        this.O00000Oo.setQuery(query);
        this.O00000Oo.setOnPoiSearchListener(this);
        try {
            PoiResult searchPOI = this.O00000Oo.searchPOI();
            if (searchPOI == null || searchPOI.getQuery() == null) {
                return null;
            }
            ArrayList<LocationBean> arrayList = new ArrayList<>();
            Iterator<PoiItem> it = searchPOI.getPois().iterator();
            while (it.hasNext()) {
                PoiItem next = it.next();
                LatLonPoint latLonPoint = next.getLatLonPoint();
                arrayList.add(new LocationBean(latLonPoint.getLongitude(), latLonPoint.getLatitude(), next.getTitle(), next.getSnippet(), next.getProvinceName(), next.getCityName(), next.getAdName()));
            }
            return arrayList;
        } catch (AMapException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void onPoiSearched(PoiResult poiResult, int i) {
        if (i == 1000 && poiResult != null && poiResult.getQuery() != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<PoiItem> it = poiResult.getPois().iterator();
            while (it.hasNext()) {
                PoiItem next = it.next();
                LatLonPoint latLonPoint = next.getLatLonPoint();
                arrayList.add(new LocationBean(latLonPoint.getLongitude(), latLonPoint.getLatitude(), next.getTitle(), next.getSnippet()));
            }
        }
    }
}
