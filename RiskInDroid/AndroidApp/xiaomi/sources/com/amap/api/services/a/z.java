package com.amap.api.services.a;

import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DrivePlanStep;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TimeInfo;
import com.amap.api.services.route.TimeInfosElement;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.traffic.TrafficStatusEvaluation;
import com.amap.api.services.traffic.TrafficStatusInfo;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f3424a = {"010", "021", "022", "023", "1852", "1853"};

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    public static ArrayList<NearbyInfo> a(JSONObject jSONObject, boolean z) throws JSONException {
        double d;
        JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<NearbyInfo> arrayList = new ArrayList<>();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String a2 = a(optJSONObject, "userid");
            String a3 = a(optJSONObject, "location");
            double d2 = 0.0d;
            if (a3 != null) {
                String[] split = a3.split(",");
                if (split.length == 2) {
                    double l = l(split[0]);
                    d2 = l(split[1]);
                    d = l;
                    String a4 = a(optJSONObject, "distance");
                    long m = m(a(optJSONObject, "updatetime"));
                    int j = j(a4);
                    LatLonPoint latLonPoint = new LatLonPoint(d2, d);
                    NearbyInfo nearbyInfo = new NearbyInfo();
                    nearbyInfo.setUserID(a2);
                    nearbyInfo.setTimeStamp(m);
                    nearbyInfo.setPoint(latLonPoint);
                    if (!z) {
                        nearbyInfo.setDrivingDistance(j);
                    } else {
                        nearbyInfo.setDistance(j);
                    }
                    arrayList.add(nearbyInfo);
                }
            }
            d = 0.0d;
            String a42 = a(optJSONObject, "distance");
            long m2 = m(a(optJSONObject, "updatetime"));
            int j2 = j(a42);
            LatLonPoint latLonPoint2 = new LatLonPoint(d2, d);
            NearbyInfo nearbyInfo2 = new NearbyInfo();
            nearbyInfo2.setUserID(a2);
            nearbyInfo2.setTimeStamp(m2);
            nearbyInfo2.setPoint(latLonPoint2);
            if (!z) {
            }
            arrayList.add(nearbyInfo2);
        }
        return arrayList;
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (!jSONObject.has("cities") || (optJSONArray = jSONObject.optJSONArray("cities")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), j(a(optJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("pois")) == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(d(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static PoiItem d(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!i(a2)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    s.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    s.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(b(jSONObject, "entr_location"));
        poiItem.setExit(b(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, "website"));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        poiItem.setBusinessArea(a(jSONObject, "business_area"));
        poiItem.setEmail(a(jSONObject, "email"));
        if (h(a(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(x(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(d(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(e(jSONObject, "biz_ext"));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        a(poiItem, jSONObject);
        return poiItem;
    }

    private static SubPoiItem x(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!i(a2)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    s.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    s.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    public static ArrayList<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("busstops")) == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(f(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static BusStationItem f(JSONObject jSONObject) throws JSONException {
        BusStationItem g = g(jSONObject);
        if (g == null) {
            return g;
        }
        g.setAdCode(a(jSONObject, "adcode"));
        g.setCityCode(a(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            g.setBusLineItems(arrayList);
            return g;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(h(optJSONObject));
            }
        }
        g.setBusLineItems(arrayList);
        return g;
    }

    public static BusStationItem g(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    public static BusLineItem h(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(c(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static ArrayList<BusLineItem> i(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(j(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusLineItem j(JSONObject jSONObject) throws JSONException {
        BusLineItem h = h(jSONObject);
        if (h == null) {
            return h;
        }
        h.setFirstBusTime(s.c(a(jSONObject, "start_time")));
        h.setLastBusTime(s.c(a(jSONObject, "end_time")));
        h.setBusCompany(a(jSONObject, "company"));
        h.setDistance(k(a(jSONObject, "distance")));
        h.setBasicPrice(k(a(jSONObject, "basic_price")));
        h.setTotalPrice(k(a(jSONObject, "total_price")));
        h.setBounds(c(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            h.setBusStations(arrayList);
            return h;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(g(optJSONObject));
            }
        }
        h.setBusStations(arrayList);
        return h;
    }

    public static DistrictItem k(JSONObject jSONObject) throws JSONException {
        String optString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, "level"));
        districtItem.setCenter(b(jSONObject, "center"));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(k(optJSONObject));
                }
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    public static ArrayList<GeocodeAddress> l(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("geocodes")) == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(a(optJSONObject, "province"));
                    geocodeAddress.setCity(a(optJSONObject, "city"));
                    geocodeAddress.setDistrict(a(optJSONObject, "district"));
                    geocodeAddress.setTownship(a(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(b(optJSONObject, "location"));
                    geocodeAddress.setLevel(a(optJSONObject, "level"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> m(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, "district"));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, "address"));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                String a2 = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a2)) {
                    String[] split = a2.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, "direction"));
                crossroad.setDistance(k(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(b(optJSONObject, "location"));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(b(optJSONObject, "location"));
                regeocodeRoad.setDirection(a(optJSONObject, "direction"));
                regeocodeRoad.setDistance(k(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(a(jSONObject, "country"));
        regeocodeAddress.setProvince(a(jSONObject, "province"));
        regeocodeAddress.setCity(a(jSONObject, "city"));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, "district"));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, "number"));
        streetNumber.setLatLonPoint(b(optJSONObject, "location"));
        streetNumber.setDirection(a(optJSONObject, "direction"));
        streetNumber.setDistance(k(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(n(jSONObject));
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        a(regeocodeAddress);
    }

    private static void a(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && t(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static boolean t(String str) {
        if (str != null && str.length() > 0) {
            for (String trim : f3424a) {
                if (str.trim().equals(trim.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<BusinessArea> n(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    businessArea.setCenterPoint(b(optJSONObject, "location"));
                    businessArea.setName(a(optJSONObject, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        return arrayList;
    }

    public static BusRouteResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(b(optJSONObject, "origin"));
            busRouteResult.setTargetPos(b(optJSONObject, "destination"));
            busRouteResult.setTaxiCost(k(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("transits") || (optJSONArray = optJSONObject.optJSONArray("transits")) == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(a(optJSONArray));
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        BusStep o;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(k(a(optJSONObject, "cost")));
                busPath.setDuration(m(a(optJSONObject, "duration")));
                busPath.setNightBus(n(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(k(a(optJSONObject, "walking_distance")));
                busPath.setDistance(k(a(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (!(optJSONObject2 == null || (o = o(optJSONObject2)) == null)) {
                            arrayList2.add(o);
                            if (o.getWalk() != null) {
                                f2 += o.getWalk().getDistance();
                            }
                            if (o.getBusLines() != null && o.getBusLines().size() > 0) {
                                f += o.getBusLines().get(0).getDistance();
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    public static BusStep o(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(p(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(q(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(r(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStep.setExit(r(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(y(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(E(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    public static RouteBusWalkItem p(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(b(jSONObject, "origin"));
        routeBusWalkItem.setDestination(b(jSONObject, "destination"));
        routeBusWalkItem.setDistance(k(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(m(a(jSONObject, "duration")));
        if (!jSONObject.has("steps") || (optJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(s(optJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        return routeBusWalkItem;
    }

    public static List<RouteBusLineItem> q(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(t(optJSONObject));
            }
        }
        return arrayList;
    }

    public static Doorway r(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(b(jSONObject, "location"));
        return doorway;
    }

    public static WalkStep s(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(k(a(jSONObject, "distance")));
        walkStep.setDuration(k(a(jSONObject, "duration")));
        walkStep.setPolyline(c(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        return walkStep;
    }

    public static RouteBusLineItem t(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(v(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(v(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(k(a(jSONObject, "distance")));
        routeBusLineItem.setDuration(k(a(jSONObject, "duration")));
        routeBusLineItem.setPolyline(c(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(s.c(a(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(s.c(a(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(j(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(u(jSONObject));
        return routeBusLineItem;
    }

    public static List<BusStationItem> u(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(v(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusStationItem v(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        return busStationItem;
    }

    private static RouteRailwayItem y(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(a(jSONObject, "id"));
        routeRailwayItem.setName(a(jSONObject, "name"));
        routeRailwayItem.setTime(a(jSONObject, "time"));
        routeRailwayItem.setTrip(a(jSONObject, "trip"));
        routeRailwayItem.setDistance(k(a(jSONObject, "distance")));
        routeRailwayItem.setType(a(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(z(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(z(jSONObject.optJSONObject("arrival_stop")));
        routeRailwayItem.setViastops(A(jSONObject));
        routeRailwayItem.setAlters(B(jSONObject));
        routeRailwayItem.setSpaces(C(jSONObject));
        return routeRailwayItem;
    }

    private static RailwayStationItem z(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(b(jSONObject, "location"));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(n(a(jSONObject, "start")));
        railwayStationItem.setisEnd(n(a(jSONObject, "end")));
        railwayStationItem.setWait(k(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static List<RailwayStationItem> A(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(z(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Railway> B(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(a(optJSONObject, "id"));
                railway.setName(a(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> C(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(D(optJSONObject));
            }
        }
        return arrayList;
    }

    private static RailwaySpace D(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(a(jSONObject, "code"), k(a(jSONObject, "cost")));
    }

    private static TaxiItem E(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(b(jSONObject, "origin"));
        taxiItem.setDestination(b(jSONObject, "destination"));
        taxiItem.setDistance(k(a(jSONObject, "distance")));
        taxiItem.setDuration(k(a(jSONObject, "duration")));
        taxiItem.setSname(a(jSONObject, "sname"));
        taxiItem.setTname(a(jSONObject, "tname"));
        return taxiItem;
    }

    public static DriveRouteResult b(String str) throws AMapException {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(b(optJSONObject, "origin"));
            driveRouteResult.setTargetPos(b(optJSONObject, "destination"));
            driveRouteResult.setTaxiCost(k(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                DrivePath drivePath = new DrivePath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    drivePath.setDistance(k(a(optJSONObject2, "distance")));
                    drivePath.setDuration(m(a(optJSONObject2, "duration")));
                    drivePath.setStrategy(a(optJSONObject2, "strategy"));
                    drivePath.setTolls(k(a(optJSONObject2, "tolls")));
                    drivePath.setTollDistance(k(a(optJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(j(a(optJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(j(a(optJSONObject2, "restriction")));
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray2.length()) {
                            DriveStep driveStep = new DriveStep();
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                jSONArray2 = optJSONArray;
                                driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                driveStep.setRoad(a(optJSONObject3, "road"));
                                driveStep.setDistance(k(a(optJSONObject3, "distance")));
                                driveStep.setTolls(k(a(optJSONObject3, "tolls")));
                                driveStep.setTollDistance(k(a(optJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                driveStep.setDuration(k(a(optJSONObject3, "duration")));
                                driveStep.setPolyline(c(optJSONObject3, "polyline"));
                                driveStep.setAction(a(optJSONObject3, "action"));
                                driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                a(driveStep, optJSONObject3);
                                b(driveStep, optJSONObject3);
                                arrayList2.add(driveStep);
                            } else {
                                jSONArray2 = optJSONArray;
                            }
                            i2++;
                            optJSONArray = jSONArray2;
                        }
                        jSONArray = optJSONArray;
                        drivePath.setSteps(arrayList2);
                        arrayList.add(drivePath);
                        i++;
                        optJSONArray = jSONArray;
                    }
                }
                jSONArray = optJSONArray;
                i++;
                optJSONArray = jSONArray;
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            s.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(j(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, "status"));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                driveStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                driveStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(a(optJSONObject, "name"));
                        district.setDistrictAdcode(a(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                s.a(e, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static WalkRouteResult c(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(b(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(k(a(optJSONObject2, "distance")));
                    walkPath.setDuration(m(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(k(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(k(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(c(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherLive d(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherLive;
                    }
                    localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherLive.setProvince(a(optJSONObject, "province"));
                    localWeatherLive.setCity(a(optJSONObject, "city"));
                    localWeatherLive.setWeather(a(optJSONObject, "weather"));
                    localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
                    localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
                    localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
                    localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
                    localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
                }
            }
            return localWeatherLive;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherForecast e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setCity(a(optJSONObject, "city"));
                    localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(a(optJSONObject, "province"));
                    localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null) {
                        if (optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                                    localDayWeatherForecast.setWeek(a(optJSONObject2, "week"));
                                    localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                                    localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                                    localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                                    localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                                    localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                                    localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                                    localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                                    localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                                    arrayList.add(localDayWeatherForecast);
                                }
                            }
                            localWeatherForecast.setWeatherForecast(arrayList);
                            return localWeatherForecast;
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                }
            }
            return localWeatherForecast;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.optString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    public static LatLonPoint b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return g(jSONObject.optString(str));
        }
        return null;
    }

    public static ArrayList<LatLonPoint> c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return f(jSONObject.optString(str));
        }
        return null;
    }

    public static ArrayList<LatLonPoint> f(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        String[] split = str.split(";");
        for (String g : split) {
            arrayList.add(g(g));
        }
        return arrayList;
    }

    public static LatLonPoint g(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static boolean h(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    public static boolean i(String str) {
        return str == null || str.equals("");
    }

    public static int j(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            s.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static float k(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            s.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    public static double l(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            s.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    public static long m(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            s.a(e, "JSONHelper", "str2long");
            return 0;
        }
    }

    public static boolean n(String str) {
        if (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) {
            return false;
        }
        return true;
    }

    private static IndoorData d(JSONObject jSONObject, String str) throws JSONException {
        int i;
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null || !optJSONObject.has("cpid") || !optJSONObject.has("floor")) {
            i = 0;
            str2 = str3;
        } else {
            str3 = a(optJSONObject, "cpid");
            i = j(a(optJSONObject, "floor"));
            str2 = a(optJSONObject, "truefloor");
        }
        return new IndoorData(str3, i, str2);
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(b(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(k(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    public static void a(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> F = F(jSONObject.optJSONObject("deep_info"));
        if (F.size() == 0) {
            F = F(jSONObject);
        }
        poiItem.setPhotos(F);
    }

    private static List<Photo> F(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            Photo photo = new Photo();
            photo.setTitle(a(optJSONObject, "title"));
            photo.setUrl(a(optJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    private static PoiItemExtension e(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        JSONObject optJSONObject;
        String str3 = "";
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = str3;
        } else {
            str3 = a(optJSONObject, "open_time");
            str2 = a(optJSONObject, "rating");
        }
        return new PoiItemExtension(str3, str2);
    }

    public static ArrayList<RoutePOIItem> w(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(G(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(G(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static RoutePOIItem G(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(b(jSONObject, "location"));
        routePOIItem.setDistance(k(a(jSONObject, "distance")));
        routePOIItem.setDuration(k(a(jSONObject, "duration")));
        return routePOIItem;
    }

    public static RideRouteResult o(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(b(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(b(optJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RidePath H = H(optJSONArray.optJSONObject(i));
                    if (H != null) {
                        arrayList.add(H);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath H2 = H(optJSONObject2.optJSONObject("path"));
                if (H2 != null) {
                    arrayList.add(H2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RidePath H(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(k(a(jSONObject, "distance")));
            ridePath.setDuration(m(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(k(a(optJSONObject, "distance")));
                        rideStep.setDuration(k(a(optJSONObject, "duration")));
                        rideStep.setPolyline(c(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TrafficStatusResult p(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("trafficinfo")) {
                return null;
            }
            TrafficStatusResult trafficStatusResult = new TrafficStatusResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("trafficinfo");
            trafficStatusResult.setDescription(a(optJSONObject, "description"));
            if (optJSONObject.has("evaluation")) {
                TrafficStatusEvaluation trafficStatusEvaluation = new TrafficStatusEvaluation();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("evaluation");
                trafficStatusEvaluation.setExpedite(a(optJSONObject2, "expedite"));
                trafficStatusEvaluation.setCongested(a(optJSONObject2, "congested"));
                trafficStatusEvaluation.setBlocked(a(optJSONObject2, "blocked"));
                trafficStatusEvaluation.setUnknown(a(optJSONObject2, "unknown"));
                trafficStatusEvaluation.setStatus(a(optJSONObject2, "status"));
                trafficStatusEvaluation.setDescription(a(optJSONObject2, "description"));
                trafficStatusResult.setEvaluation(trafficStatusEvaluation);
            }
            if (!optJSONObject.has("roads")) {
                return trafficStatusResult;
            }
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("roads");
            if (opt == null) {
                trafficStatusResult.setRoads(arrayList);
                return trafficStatusResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TrafficStatusInfo I = I(optJSONArray.optJSONObject(i));
                    if (I != null) {
                        arrayList.add(I);
                    }
                }
            }
            trafficStatusResult.setRoads(arrayList);
            return trafficStatusResult;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static TrafficStatusInfo I(JSONObject jSONObject) throws AMapException {
        TrafficStatusInfo trafficStatusInfo = new TrafficStatusInfo();
        try {
            trafficStatusInfo.setName(a(jSONObject, "name"));
            trafficStatusInfo.setStatus(a(jSONObject, "status"));
            trafficStatusInfo.setAngle(j(a(jSONObject, "angle")));
            trafficStatusInfo.setSpeed(k(a(jSONObject, "speed")));
            trafficStatusInfo.setDirection(a(jSONObject, "direction"));
            trafficStatusInfo.setLcodes(a(jSONObject, "lcodes"));
            trafficStatusInfo.setCoordinates(c(jSONObject, "polyline"));
            return trafficStatusInfo;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseRoadInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static DistanceResult q(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                distanceItem.setOriginId(j(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(j(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(k(a(jSONObject2, "distance")));
                distanceItem.setDuration(k(a(jSONObject2, "duration")));
                String a2 = a(jSONObject2, "info");
                if (!TextUtils.isEmpty(a2)) {
                    distanceItem.setErrorInfo(a2);
                    distanceItem.setErrorCode(j(a(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TruckRouteRestult r(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
            truckRouteRestult.setStartPos(b(optJSONObject, "origin"));
            truckRouteRestult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return truckRouteRestult;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                TruckPath truckPath = new TruckPath();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                truckPath.setDistance(k(a(jSONObject2, "distance")));
                truckPath.setDuration(m(a(jSONObject2, "duration")));
                truckPath.setStrategy(a(jSONObject2, "strategy"));
                truckPath.setTolls(k(a(jSONObject2, "tolls")));
                truckPath.setTollDistance(k(a(jSONObject2, "toll_distance")));
                truckPath.setTotalTrafficlights(j(a(jSONObject2, "traffic_lights")));
                truckPath.setRestriction(j(a(jSONObject2, "restriction")));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        TruckStep truckStep = new TruckStep();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            truckStep.setInstruction(a(optJSONObject2, "instruction"));
                            truckStep.setOrientation(a(optJSONObject2, "orientation"));
                            truckStep.setRoad(a(optJSONObject2, "road"));
                            truckStep.setDistance(k(a(optJSONObject2, "distance")));
                            truckStep.setTolls(k(a(optJSONObject2, "tolls")));
                            truckStep.setTollDistance(k(a(optJSONObject2, "toll_distance")));
                            truckStep.setTollRoad(a(optJSONObject2, "toll_road"));
                            truckStep.setDuration(k(a(optJSONObject2, "duration")));
                            truckStep.setPolyline(c(optJSONObject2, "polyline"));
                            truckStep.setAction(a(optJSONObject2, "action"));
                            truckStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
                            a(truckStep, optJSONObject2);
                            b(truckStep, optJSONObject2);
                            arrayList2.add(truckStep);
                        }
                    }
                    truckPath.setSteps(arrayList2);
                    arrayList.add(truckPath);
                }
            }
            truckRouteRestult.setPaths(arrayList);
            return truckRouteRestult;
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                truckStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(j(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, "status"));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                truckStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            s.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a4 A[Catch:{ JSONException -> 0x021d, Throwable -> 0x021b }] */
    public static DriveRoutePlanResult s(String str) throws AMapException {
        String str2;
        String str3;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray jSONArray;
        String str4;
        JSONArray jSONArray2;
        String str5;
        int i;
        JSONArray optJSONArray3;
        JSONArray jSONArray3;
        String str6;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        String str7 = "starttime";
        String str8 = "协议解析错误 - ProtocolException";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                jSONObject.optInt("errcode");
                jSONObject.optString("errmsg");
                jSONObject.optString("errdetail");
            }
            if (!jSONObject.has("data")) {
                return null;
            }
            DriveRoutePlanResult driveRoutePlanResult = new DriveRoutePlanResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null || !optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRoutePlanResult;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                DrivePlanPath drivePlanPath = new DrivePlanPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    drivePlanPath.setDistance(k(a(optJSONObject2, "distance")));
                    drivePlanPath.setTrafficLights(j(a(optJSONObject2, "traffic_lights")));
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray4 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (i3 < optJSONArray4.length()) {
                            DrivePlanStep drivePlanStep = new DrivePlanStep();
                            JSONArray jSONArray6 = optJSONArray;
                            JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i3);
                            if (optJSONObject3 != null) {
                                jSONArray5 = optJSONArray4;
                                drivePlanStep.setAdCode(a(optJSONObject3, "adcode"));
                                drivePlanStep.setRoad(a(optJSONObject3, "road"));
                                drivePlanStep.setDistance(k(a(optJSONObject3, "distance")));
                                str3 = str8;
                                try {
                                    drivePlanStep.setToll(j(a(optJSONObject3, "toll")) == 1);
                                    drivePlanStep.setPolyline(c(optJSONObject3, "polyline"));
                                    arrayList2.add(drivePlanStep);
                                } catch (JSONException e) {
                                    e = e;
                                    str2 = str3;
                                    s.a(e, "JSONHelper", "parseDriveRoute");
                                    throw new AMapException(str2);
                                } catch (Throwable th) {
                                    th = th;
                                    s.a(th, "JSONHelper", "parseDriveRouteThrowable");
                                    throw new AMapException(str3);
                                }
                            } else {
                                str3 = str8;
                                jSONArray5 = optJSONArray4;
                            }
                            i3++;
                            optJSONArray = jSONArray6;
                            optJSONArray4 = jSONArray5;
                            str8 = str3;
                        }
                        jSONArray4 = optJSONArray;
                        str6 = str8;
                        drivePlanPath.setSteps(arrayList2);
                        arrayList.add(drivePlanPath);
                        i2++;
                        optJSONArray = jSONArray4;
                        str8 = str6;
                    }
                }
                jSONArray4 = optJSONArray;
                str6 = str8;
                i2++;
                optJSONArray = jSONArray4;
                str8 = str6;
            }
            String str9 = str8;
            driveRoutePlanResult.setPaths(arrayList);
            if (!optJSONObject.has("time_infos") || (optJSONArray2 = optJSONObject.optJSONArray("time_infos")) == null) {
                return driveRoutePlanResult;
            }
            ArrayList arrayList3 = new ArrayList();
            int i4 = 0;
            while (i4 < optJSONArray2.length()) {
                TimeInfo timeInfo = new TimeInfo();
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                if (optJSONObject4 != null) {
                    if (!optJSONObject4.has(str7)) {
                        return driveRoutePlanResult;
                    }
                    timeInfo.setStartTime(m(a(optJSONObject4, str7)));
                    JSONArray optJSONArray5 = optJSONObject4.optJSONArray("elements");
                    if (optJSONArray5 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int i5 = 0;
                        while (i5 < optJSONArray5.length()) {
                            TimeInfosElement timeInfosElement = new TimeInfosElement();
                            JSONObject optJSONObject5 = optJSONArray5.optJSONObject(i5);
                            if (optJSONObject5 != null) {
                                timeInfosElement.setPathindex(j(a(optJSONObject5, "pathindex")));
                                timeInfosElement.setDuration(k(a(optJSONObject5, "duration")));
                                timeInfosElement.setTolls(k(a(optJSONObject5, "tolls")));
                                int j = j(a(optJSONObject5, "restriction"));
                                if (j != 2) {
                                    if (j != -1) {
                                        i = 1;
                                        timeInfosElement.setRestriction(i);
                                        optJSONArray3 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray3 != null) {
                                            ArrayList arrayList5 = new ArrayList();
                                            str5 = str7;
                                            int i6 = 0;
                                            while (i6 < optJSONArray3.length()) {
                                                TMC tmc = new TMC();
                                                JSONArray jSONArray7 = optJSONArray2;
                                                JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i6);
                                                if (optJSONObject6 != null) {
                                                    jSONArray3 = optJSONArray3;
                                                    tmc.setStatus(a(optJSONObject6, "status"));
                                                    tmc.setDistance(j(a(optJSONObject6, "distance")));
                                                    tmc.setPolyline(c(optJSONObject6, "polyline"));
                                                    arrayList5.add(tmc);
                                                } else {
                                                    jSONArray3 = optJSONArray3;
                                                }
                                                i6++;
                                                optJSONArray2 = jSONArray7;
                                                optJSONArray3 = jSONArray3;
                                            }
                                            jSONArray2 = optJSONArray2;
                                            timeInfosElement.setTMCs(arrayList5);
                                            arrayList4.add(timeInfosElement);
                                            i5++;
                                            str7 = str5;
                                            optJSONArray2 = jSONArray2;
                                        }
                                    }
                                }
                                i = 0;
                                timeInfosElement.setRestriction(i);
                                optJSONArray3 = optJSONObject5.optJSONArray("tmcs");
                                if (optJSONArray3 != null) {
                                }
                            }
                            str5 = str7;
                            jSONArray2 = optJSONArray2;
                            i5++;
                            str7 = str5;
                            optJSONArray2 = jSONArray2;
                        }
                        str4 = str7;
                        jSONArray = optJSONArray2;
                        timeInfo.setElements(arrayList4);
                        arrayList3.add(timeInfo);
                        i4++;
                        str7 = str4;
                        optJSONArray2 = jSONArray;
                    }
                }
                str4 = str7;
                jSONArray = optJSONArray2;
                i4++;
                str7 = str4;
                optJSONArray2 = jSONArray;
            }
            driveRoutePlanResult.setTimeInfos(arrayList3);
            return driveRoutePlanResult;
        } catch (JSONException e2) {
            e = e2;
            str2 = str8;
            s.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException(str2);
        } catch (Throwable th2) {
            th = th2;
            str3 = str8;
            s.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException(str3);
        }
    }
}
