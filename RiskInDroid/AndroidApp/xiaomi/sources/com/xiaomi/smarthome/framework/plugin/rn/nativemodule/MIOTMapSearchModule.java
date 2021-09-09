package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MIOTMapSearchModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "MHMapSearch";
    }

    public MIOTMapSearchModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void reGeocodeSearch(ReadableMap readableMap, final Callback callback) {
        double d = readableMap.getDouble("latitude");
        double d2 = readableMap.getDouble("longitude");
        GeocodeSearch geocodeSearch = new GeocodeSearch(getReactApplicationContext());
        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTMapSearchModule.AnonymousClass1 */

            public final void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
                if (regeocodeResult == null || i != 1000) {
                    callback.invoke(Boolean.FALSE, null);
                    return;
                }
                RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                if (regeocodeAddress != null) {
                    writableNativeMap.putString("title", regeocodeAddress.getProvince());
                    writableNativeMap.putString("subTitle", regeocodeAddress.getFormatAddress());
                }
                callback.invoke(Boolean.TRUE, writableNativeMap);
            }

            public final void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
                callback.invoke(Boolean.FALSE, "onGeocodeSearched");
            }
        });
        geocodeSearch.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(d, d2), 0.0f, "autonavi"));
    }

    @ReactMethod
    public void poiAroundSearch(ReadableMap readableMap, String str, Callback callback) {
        double d = readableMap.getDouble("latitude");
        double d2 = readableMap.getDouble("longitude");
        PoiSearch poiSearch = new PoiSearch(getReactApplicationContext(), new PoiSearch.Query(str, ""));
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(d, d2), 0));
        poiSearch.setOnPoiSearchListener(new O000000o(callback));
        poiSearch.searchPOIAsyn();
    }

    @ReactMethod
    public void poiKeywordsSearch(String str, String str2, boolean z, Callback callback) {
        PoiSearch.Query query = new PoiSearch.Query(str2, "", str);
        query.setCityLimit(z);
        PoiSearch poiSearch = new PoiSearch(getReactApplicationContext(), query);
        poiSearch.setOnPoiSearchListener(new O000000o(callback));
        poiSearch.searchPOIAsyn();
    }

    @ReactMethod
    public void poiIDSearch(String str, Callback callback) {
        PoiSearch poiSearch = new PoiSearch(getReactApplicationContext(), null);
        poiSearch.searchPOIIdAsyn(str);
        poiSearch.setOnPoiSearchListener(new O000000o(callback));
    }

    @ReactMethod
    public void walkingRouteSearch(ReadableMap readableMap, ReadableMap readableMap2, int i, final Callback callback) {
        double d = readableMap.getDouble("latitude");
        double d2 = readableMap.getDouble("longitude");
        double d3 = readableMap2.getDouble("latitude");
        double d4 = readableMap2.getDouble("longitude");
        RouteSearch routeSearch = new RouteSearch(getReactApplicationContext());
        routeSearch.calculateWalkRouteAsyn(new RouteSearch.WalkRouteQuery(new RouteSearch.FromAndTo(new LatLonPoint(d, d2), new LatLonPoint(d3, d4)), i));
        routeSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTMapSearchModule.AnonymousClass2 */

            public final void onBusRouteSearched(BusRouteResult busRouteResult, int i) {
                callback.invoke(Boolean.FALSE, "onBusRouteSearched");
            }

            public final void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {
                callback.invoke(Boolean.FALSE, "onDriveRouteSearched");
            }

            public final void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {
                WritableNativeMap writableNativeMap;
                WritableNativeMap writableNativeMap2;
                WritableNativeMap writableNativeMap3;
                int i2 = 0;
                if (walkRouteResult == null || i != 1000) {
                    callback.invoke(Boolean.FALSE, null);
                    return;
                }
                WritableNativeMap writableNativeMap4 = new WritableNativeMap();
                List<WalkPath> paths = walkRouteResult.getPaths();
                if (paths == null) {
                    callback.invoke(Boolean.FALSE, null);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                for (WalkPath next : paths) {
                    if (next != null) {
                        WritableNativeMap writableNativeMap5 = new WritableNativeMap();
                        writableNativeMap5.putDouble("distance", (double) next.getDistance());
                        writableNativeMap5.putDouble("duration", (double) next.getDuration());
                        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
                        for (WalkStep next2 : next.getSteps()) {
                            if (next2 != null) {
                                WritableNativeMap writableNativeMap6 = new WritableNativeMap();
                                writableNativeMap6.putString("action", next2.getAction());
                                writableNativeMap6.putString("assistantAction", next2.getAssistantAction());
                                writableNativeMap6.putString("instruction", next2.getInstruction());
                                writableNativeMap6.putString("orientation", next2.getOrientation());
                                writableNativeMap6.putString("road", next2.getRoad());
                                writableNativeMap6.putDouble("distance", (double) next2.getDistance());
                                writableNativeMap6.putDouble("duration", (double) next2.getDuration());
                                sb.setLength(i2);
                                for (LatLonPoint next3 : next2.getPolyline()) {
                                    if (next3 != null) {
                                        writableNativeMap3 = writableNativeMap4;
                                        sb.append(next3.getLongitude());
                                        sb.append(",");
                                        sb.append(next3.getLatitude());
                                        sb.append(";");
                                    } else {
                                        writableNativeMap3 = writableNativeMap4;
                                    }
                                    writableNativeMap4 = writableNativeMap3;
                                }
                                writableNativeMap2 = writableNativeMap4;
                                writableNativeMap6.putString("polyline", sb.toString());
                                writableNativeArray2.pushMap(writableNativeMap6);
                            } else {
                                writableNativeMap2 = writableNativeMap4;
                            }
                            writableNativeMap4 = writableNativeMap2;
                            i2 = 0;
                        }
                        writableNativeMap = writableNativeMap4;
                        writableNativeMap5.putArray("steps", writableNativeArray2);
                        writableNativeArray.pushMap(writableNativeMap5);
                    } else {
                        writableNativeMap = writableNativeMap4;
                    }
                    writableNativeMap4 = writableNativeMap;
                    i2 = 0;
                }
                WritableNativeMap writableNativeMap7 = writableNativeMap4;
                writableNativeMap7.putArray("paths", writableNativeArray);
                RouteSearch.FromAndTo fromAndTo = walkRouteResult.getWalkQuery().getFromAndTo();
                writableNativeMap7.putMap("origin", MIOTMapSearchModule.mapLatLon(fromAndTo.getFrom()));
                writableNativeMap7.putMap("destination", MIOTMapSearchModule.mapLatLon(fromAndTo.getTo()));
                paths.size();
                callback.invoke(Boolean.TRUE, writableNativeMap7);
            }

            public final void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {
                callback.invoke(Boolean.FALSE, "onRideRouteSearched");
            }
        });
    }

    public static WritableMap mapLatLon(LatLonPoint latLonPoint) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (latLonPoint != null) {
            writableNativeMap.putDouble("latitude", latLonPoint.getLatitude());
            writableNativeMap.putDouble("longitude", latLonPoint.getLongitude());
        }
        return writableNativeMap;
    }

    static class O000000o implements PoiSearch.OnPoiSearchListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private Callback f8323O000000o;

        public O000000o(Callback callback) {
            this.f8323O000000o = callback;
        }

        public final void onPoiSearched(PoiResult poiResult, int i) {
            if (poiResult == null || i != 1000) {
                this.f8323O000000o.invoke(Boolean.FALSE, null);
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            int pageCount = poiResult.getPageCount();
            PoiSearch.SearchBound bound = poiResult.getBound();
            PoiSearch.Query query = poiResult.getQuery();
            ArrayList<PoiItem> pois = poiResult.getPois();
            List<SuggestionCity> searchSuggestionCitys = poiResult.getSearchSuggestionCitys();
            List<String> searchSuggestionKeywords = poiResult.getSearchSuggestionKeywords();
            writableNativeMap.putInt("pageCount", pageCount);
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            if (bound != null) {
                writableNativeMap2.putString("shape", bound.getShape());
                writableNativeMap2.putInt("range", bound.getRange());
                writableNativeMap2.putMap("center", MIOTMapSearchModule.mapLatLon(bound.getCenter()));
                writableNativeMap2.putMap("lowerLeft", MIOTMapSearchModule.mapLatLon(bound.getLowerLeft()));
                writableNativeMap2.putMap("upperRight", MIOTMapSearchModule.mapLatLon(bound.getUpperRight()));
                List<LatLonPoint> polyGonList = bound.getPolyGonList();
                if (polyGonList != null) {
                    for (LatLonPoint mapLatLon : polyGonList) {
                        writableNativeArray.pushMap(MIOTMapSearchModule.mapLatLon(mapLatLon));
                    }
                }
            }
            writableNativeMap2.putArray("polyGonList", writableNativeArray);
            writableNativeMap.putMap("bound", writableNativeMap2);
            WritableNativeMap writableNativeMap3 = new WritableNativeMap();
            writableNativeMap3.putString("building", query.getBuilding());
            writableNativeMap3.putInt("pageNum", query.getPageNum());
            writableNativeMap3.putInt("pageSize", query.getPageSize());
            writableNativeMap3.putString("category", query.getCategory());
            writableNativeMap3.putString("city", query.getCity());
            writableNativeMap3.putString("queryString", query.getQueryString());
            writableNativeMap3.putBoolean("cityLimit", query.getCityLimit());
            writableNativeMap.putMap("query", writableNativeMap3);
            WritableNativeArray writableNativeArray2 = new WritableNativeArray();
            Iterator<PoiItem> it = pois.iterator();
            while (it.hasNext()) {
                writableNativeArray2.pushMap(O000000o(it.next()));
            }
            writableNativeMap.putArray("pois", writableNativeArray2);
            WritableNativeArray writableNativeArray3 = new WritableNativeArray();
            for (SuggestionCity next : searchSuggestionCitys) {
                WritableNativeMap writableNativeMap4 = new WritableNativeMap();
                writableNativeMap4.putString("adCode", next.getAdCode());
                writableNativeMap4.putString("cityCode", next.getCityCode());
                writableNativeMap4.putString("cityName", next.getCityName());
                writableNativeMap4.putInt("suggestionNum", next.getSuggestionNum());
                writableNativeArray3.pushMap(writableNativeMap4);
            }
            writableNativeMap.putArray("searchSuggestionCitys", writableNativeArray3);
            WritableNativeArray writableNativeArray4 = new WritableNativeArray();
            for (String pushString : searchSuggestionKeywords) {
                writableNativeArray4.pushString(pushString);
            }
            writableNativeMap.putArray("searchSuggestionKeywords", writableNativeArray4);
            this.f8323O000000o.invoke(Boolean.TRUE, writableNativeMap);
        }

        public final void onPoiItemSearched(PoiItem poiItem, int i) {
            if (poiItem == null || i != 1000) {
                this.f8323O000000o.invoke(Boolean.FALSE, null);
                return;
            }
            this.f8323O000000o.invoke(Boolean.TRUE, O000000o(poiItem));
        }

        private static WritableNativeMap O000000o(PoiItem poiItem) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            poiItem.getProvinceName();
            writableNativeMap.putString("adCode", poiItem.getAdCode());
            writableNativeMap.putString("adName", poiItem.getAdName());
            writableNativeMap.putString("provinceName", poiItem.getProvinceName());
            writableNativeMap.putString("businessArea", poiItem.getBusinessArea());
            writableNativeMap.putString("cityCode", poiItem.getCityCode());
            writableNativeMap.putString("cityName", poiItem.getCityName());
            writableNativeMap.putString("direction", poiItem.getDirection());
            writableNativeMap.putString("email", poiItem.getEmail());
            writableNativeMap.putString("parkingType", poiItem.getParkingType());
            writableNativeMap.putString("poiId", poiItem.getPoiId());
            writableNativeMap.putString("postcode", poiItem.getPostcode());
            writableNativeMap.putString("provinceCode", poiItem.getProvinceCode());
            writableNativeMap.putString("provinceName", poiItem.getProvinceName());
            writableNativeMap.putString("shopID", poiItem.getShopID());
            writableNativeMap.putString("snippet", poiItem.getSnippet());
            writableNativeMap.putString("tel", poiItem.getTel());
            writableNativeMap.putString("title", poiItem.getTitle());
            writableNativeMap.putString("typeCode", poiItem.getTypeCode());
            writableNativeMap.putString("typeDes", poiItem.getTypeDes());
            writableNativeMap.putString("website", poiItem.getWebsite());
            writableNativeMap.putInt("distance", poiItem.getDistance());
            writableNativeMap.putMap("enter", MIOTMapSearchModule.mapLatLon(poiItem.getEnter()));
            writableNativeMap.putMap("latLonPoint", MIOTMapSearchModule.mapLatLon(poiItem.getLatLonPoint()));
            List<Photo> photos = poiItem.getPhotos();
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            for (Photo next : photos) {
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putString("title", next.getTitle());
                writableNativeMap2.putString("url", next.getUrl());
                writableNativeArray.pushMap(writableNativeMap2);
            }
            writableNativeMap.putArray("photos", writableNativeArray);
            WritableNativeArray writableNativeArray2 = new WritableNativeArray();
            for (SubPoiItem next2 : poiItem.getSubPois()) {
                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                writableNativeMap3.putString("title", next2.getTitle());
                writableNativeMap3.putString("poiId", next2.getPoiId());
                writableNativeMap3.putString("snippet", next2.getSnippet());
                writableNativeMap3.putString("subName", next2.getSubName());
                writableNativeMap3.putString("subTypeDes", next2.getSubTypeDes());
                writableNativeMap3.putInt("url", next2.getDistance());
                writableNativeMap3.putMap("latLonPoint", MIOTMapSearchModule.mapLatLon(next2.getLatLonPoint()));
                writableNativeArray2.pushMap(writableNativeMap3);
            }
            writableNativeMap.putArray("subPois", writableNativeArray2);
            WritableNativeMap writableNativeMap4 = new WritableNativeMap();
            IndoorData indoorData = poiItem.getIndoorData();
            writableNativeMap4.putInt("floor", indoorData.getFloor());
            writableNativeMap4.putString("floorName", indoorData.getFloorName());
            writableNativeMap4.putString("poiId", indoorData.getPoiId());
            writableNativeMap.putMap("indoorData", writableNativeMap4);
            WritableNativeMap writableNativeMap5 = new WritableNativeMap();
            PoiItemExtension poiExtension = poiItem.getPoiExtension();
            writableNativeMap5.putString("mRating", poiExtension.getmRating());
            writableNativeMap5.putString("opentime", poiExtension.getOpentime());
            writableNativeMap.putMap("poiExtension", writableNativeMap5);
            return writableNativeMap;
        }
    }
}
