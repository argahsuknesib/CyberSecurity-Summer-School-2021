package com.amap.api.services.traffic;

import android.content.Context;
import com.amap.api.services.a.bl;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ITrafficSearch;

public class TrafficSearch {
    public static int ROAD_LEVEL_CITY_QUICK_WAY = 2;
    public static int ROAD_LEVEL_HIGH_WAY = 1;
    public static int ROAD_LEVEL_HIGH_WAY_BYROAD = 3;
    public static int ROAD_LEVEL_MAIN_WAY = 4;
    public static int ROAD_LEVEL_NONAME_WAY = 6;
    public static int ROAD_LEVEL_NORMAL_WAY = 5;

    /* renamed from: a  reason: collision with root package name */
    private ITrafficSearch f3541a;

    public interface OnTrafficSearchListener {
        void onRoadTrafficSearched(TrafficStatusResult trafficStatusResult, int i);
    }

    public TrafficSearch(Context context) {
        if (this.f3541a == null) {
            try {
                this.f3541a = new bl(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTrafficSearchListener(OnTrafficSearchListener onTrafficSearchListener) {
        ITrafficSearch iTrafficSearch = this.f3541a;
        if (iTrafficSearch != null) {
            iTrafficSearch.setTrafficSearchListener(onTrafficSearchListener);
        }
    }

    public TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException {
        ITrafficSearch iTrafficSearch = this.f3541a;
        if (iTrafficSearch != null) {
            return iTrafficSearch.loadTrafficByRoad(roadTrafficQuery);
        }
        return null;
    }

    public void loadTrafficByRoadAsyn(RoadTrafficQuery roadTrafficQuery) {
        ITrafficSearch iTrafficSearch = this.f3541a;
        if (iTrafficSearch != null) {
            iTrafficSearch.loadTrafficByRoadAsyn(roadTrafficQuery);
        }
    }

    public TrafficStatusResult loadTrafficByCircle(CircleTrafficQuery circleTrafficQuery) throws AMapException {
        ITrafficSearch iTrafficSearch = this.f3541a;
        if (iTrafficSearch != null) {
            return iTrafficSearch.loadTrafficByCircle(circleTrafficQuery);
        }
        return null;
    }

    public void loadTrafficByCircleAsyn(CircleTrafficQuery circleTrafficQuery) {
        ITrafficSearch iTrafficSearch = this.f3541a;
        if (iTrafficSearch != null) {
            iTrafficSearch.loadTrafficByCircleAsyn(circleTrafficQuery);
        }
    }
}
