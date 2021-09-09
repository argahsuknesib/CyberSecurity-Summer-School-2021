package com.amap.api.services.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ac extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static ac f3272a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public BusLineResult f3273a;
        public BusLineSearch.OnBusLineSearchListener b;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public BusStationResult f3274a;
        public BusStationSearch.OnBusStationSearchListener b;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public CloudItemDetail f3275a;
        public CloudSearch.OnCloudSearchListener b;
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public CloudResult f3276a;
        public CloudSearch.OnCloudSearchListener b;
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public GeocodeResult f3277a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f3278a;
        public NearbySearchResult b;
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public PoiItem f3279a;
        public PoiSearch.OnPoiSearchListener b;
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public PoiResult f3280a;
        public PoiSearch.OnPoiSearchListener b;
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RegeocodeResult f3281a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RoutePOISearchResult f3282a;
        public RoutePOISearch.OnRoutePOISearchListener b;
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public LocalWeatherForecastResult f3283a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public LocalWeatherLiveResult f3284a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            if (f3272a == null) {
                if (Looper.myLooper() != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        f3272a = new ac();
                    }
                }
                f3272a = new ac(Looper.getMainLooper());
            }
            acVar = f3272a;
        }
        return acVar;
    }

    ac() {
    }

    ac(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            switch (message.arg1) {
                case 1:
                    k(message);
                    return;
                case 2:
                    h(message);
                    return;
                case 3:
                    j(message);
                    return;
                case 4:
                    i(message);
                    return;
                case 5:
                    g(message);
                    return;
                case 6:
                    f(message);
                    return;
                case 7:
                    e(message);
                    return;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                    d(message);
                    return;
                case 9:
                    c(message);
                    return;
                case 10:
                    b(message);
                    return;
                case 11:
                    a(message);
                    return;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    n(message);
                    return;
                case 13:
                    o(message);
                    return;
                case 14:
                    p(message);
                    return;
                case GmsLogger.MAX_PII_TAG_LENGTH /*15*/:
                    q(message);
                    return;
                case 16:
                    r(message);
                    return;
                case 17:
                    l(message);
                    return;
                case 18:
                    m(message);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            s.a(th, "MessageHandler", "handleMessage");
        }
    }

    private void a(Message message) {
        int i2 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener != null) {
            switch (message.what) {
                case 1100:
                    onShareSearchListener.onPoiShareUrlSearched(string, i2);
                    return;
                case 1101:
                    onShareSearchListener.onLocationShareUrlSearched(string, i2);
                    return;
                case 1102:
                    onShareSearchListener.onNaviShareUrlSearched(string, i2);
                    return;
                case 1103:
                    onShareSearchListener.onBusRouteShareUrlSearched(string, i2);
                    return;
                case 1104:
                    onShareSearchListener.onDrivingRouteShareUrlSearched(string, i2);
                    return;
                case 1105:
                    onShareSearchListener.onWalkRouteShareUrlSearched(string, i2);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list != null && list.size() != 0) {
            for (NearbySearch.NearbyListener onNearbyInfoUploaded : list) {
                onNearbyInfoUploaded.onNearbyInfoUploaded(message.what);
            }
        }
    }

    private void c(Message message) {
        List<NearbySearch.NearbyListener> list;
        f fVar = (f) message.obj;
        if (fVar != null && (list = fVar.f3278a) != null && list.size() != 0) {
            NearbySearchResult nearbySearchResult = null;
            if (message.what == 1000) {
                nearbySearchResult = fVar.b;
            }
            for (NearbySearch.NearbyListener onNearbyInfoSearched : list) {
                onNearbyInfoSearched.onNearbyInfoSearched(nearbySearchResult, message.what);
            }
        }
    }

    private void d(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list != null && list.size() != 0) {
            for (NearbySearch.NearbyListener onUserInfoCleared : list) {
                onUserInfoCleared.onUserInfoCleared(message.what);
            }
        }
    }

    private void e(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        b bVar = (b) message.obj;
        if (bVar != null && (onBusStationSearchListener = bVar.b) != null) {
            BusStationResult busStationResult = null;
            if (message.what == 1000) {
                busStationResult = bVar.f3274a;
            }
            onBusStationSearchListener.onBusStationSearched(busStationResult, message.what);
        }
    }

    private void f(Message message) {
        g gVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        if (message.what == 600) {
            h hVar = (h) message.obj;
            if (hVar != null && (onPoiSearchListener = hVar.b) != null && (data = message.getData()) != null) {
                onPoiSearchListener.onPoiSearched(hVar.f3280a, data.getInt("errorCode"));
            }
        } else if (message.what == 602 && (gVar = (g) message.obj) != null) {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = gVar.b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(gVar.f3279a, data2.getInt("errorCode"));
            }
        }
    }

    private void g(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener != null) {
            ArrayList arrayList = null;
            if (message.what == 1000) {
                arrayList = message.getData().getParcelableArrayList("result");
            }
            inputtipsListener.onGetInputtips(arrayList, message.what);
        }
    }

    private void h(Message message) {
        e eVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        if (message.what == 201) {
            i iVar = (i) message.obj;
            if (iVar != null && (onGeocodeSearchListener2 = iVar.b) != null) {
                onGeocodeSearchListener2.onRegeocodeSearched(iVar.f3281a, message.arg2);
            }
        } else if (message.what == 200 && (eVar = (e) message.obj) != null && (onGeocodeSearchListener = eVar.b) != null) {
            onGeocodeSearchListener.onGeocodeSearched(eVar.f3277a, message.arg2);
        }
    }

    private void i(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener != null) {
            onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
        }
    }

    private void j(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        a aVar = (a) message.obj;
        if (aVar != null && (onBusLineSearchListener = aVar.b) != null) {
            BusLineResult busLineResult = null;
            if (message.what == 1000) {
                busLineResult = aVar.f3273a;
            }
            onBusLineSearchListener.onBusLineSearched(busLineResult, message.what);
        }
    }

    private void k(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener != null) {
            if (message.what == 100) {
                Bundle data2 = message.getData();
                if (data2 != null) {
                    onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                }
            } else if (message.what == 101) {
                Bundle data3 = message.getData();
                if (data3 != null) {
                    onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                }
            } else if (message.what == 102) {
                Bundle data4 = message.getData();
                if (data4 != null) {
                    onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                }
            } else if (message.what == 103) {
                Bundle data5 = message.getData();
                if (data5 != null) {
                    onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
                }
            } else if (message.what == 104 && (data = message.getData()) != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
            }
        }
    }

    private void l(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener != null && message.what == 104 && (data = message.getData()) != null) {
            onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data.getInt("errorCode"));
        }
    }

    private void m(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener != null && message.what == 105 && (data = message.getData()) != null) {
            int i2 = data.getInt("errorCode");
            DriveRoutePlanResult driveRoutePlanResult = (DriveRoutePlanResult) message.getData().getParcelable("result");
            if (onRoutePlanSearchListener != null) {
                onRoutePlanSearchListener.onDriveRoutePlanSearched(driveRoutePlanResult, i2);
            }
        }
    }

    private void n(Message message) {
        c cVar;
        if (message.what == 700) {
            d dVar = (d) message.obj;
            if (dVar != null) {
                dVar.b.onCloudSearched(dVar.f3276a, message.arg2);
            }
        } else if (message.what == 701 && (cVar = (c) message.obj) != null) {
            cVar.b.onCloudItemDetailSearched(cVar.f3275a, message.arg2);
        }
    }

    private void o(Message message) {
        k kVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        if (message.what == 1301) {
            l lVar = (l) message.obj;
            if (lVar != null && (onWeatherSearchListener2 = lVar.b) != null && (data2 = message.getData()) != null) {
                onWeatherSearchListener2.onWeatherLiveSearched(lVar.f3284a, data2.getInt("errorCode"));
            }
        } else if (message.what == 1302 && (kVar = (k) message.obj) != null && (onWeatherSearchListener = kVar.b) != null && (data = message.getData()) != null) {
            onWeatherSearchListener.onWeatherForecastSearched(kVar.f3283a, data.getInt("errorCode"));
        }
    }

    private void p(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        j jVar = (j) message.obj;
        if (jVar != null && (onRoutePOISearchListener = jVar.b) != null && (data = message.getData()) != null) {
            onRoutePOISearchListener.onRoutePoiSearched(jVar.f3282a, data.getInt("errorCode"));
        }
    }

    private void q(Message message) {
        TrafficSearch.OnTrafficSearchListener onTrafficSearchListener = (TrafficSearch.OnTrafficSearchListener) message.obj;
        if (onTrafficSearchListener != null) {
            if (message.what == 300) {
                Bundle data = message.getData();
                if (data != null) {
                    onTrafficSearchListener.onRoadTrafficSearched((TrafficStatusResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
                }
            } else if (message.what == 301) {
                Bundle data2 = message.getData();
                if (data2 != null) {
                    onTrafficSearchListener.onRoadTrafficSearched((TrafficStatusResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                }
            } else if (message.what == 302) {
                message.getData();
            }
        }
    }

    private void r(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener != null && message.what == 400 && (data = message.getData()) != null) {
            onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
        }
    }
}
