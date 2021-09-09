package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.services.a.bk;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

public class ShareSearch {

    /* renamed from: a  reason: collision with root package name */
    private IShareSearch f3535a;

    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i);

        void onDrivingRouteShareUrlSearched(String str, int i);

        void onLocationShareUrlSearched(String str, int i);

        void onNaviShareUrlSearched(String str, int i);

        void onPoiShareUrlSearched(String str, int i);

        void onWalkRouteShareUrlSearched(String str, int i);
    }

    public ShareSearch(Context context) {
        if (this.f3535a == null) {
            try {
                this.f3535a = new bk(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchPoiShareUrl(poiItem);
        return null;
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchNaviShareUrl(shareNaviQuery);
        return null;
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchLocationShareUrl(latLonSharePoint);
        return null;
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
        return null;
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
        return null;
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f3535a;
        if (iShareSearch == null) {
            return null;
        }
        iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
        return null;
    }

    public static class ShareNaviQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f3539a;
        private int b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f3539a = shareFromAndTo;
            this.b = i;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f3539a;
        }

        public int getNaviMode() {
            return this.b;
        }
    }

    public static class ShareWalkRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f3540a;
        private int b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f3540a = shareFromAndTo;
            this.b = i;
        }

        public int getWalkMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f3540a;
        }
    }

    public static class ShareDrivingRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f3537a;
        private int b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f3537a = shareFromAndTo;
            this.b = i;
        }

        public int getDrivingMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f3537a;
        }
    }

    public static class ShareBusRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f3536a;
        private int b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f3536a = shareFromAndTo;
            this.b = i;
        }

        public int getBusMode() {
            return this.b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f3536a;
        }
    }

    public static class ShareFromAndTo {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f3538a;
        private LatLonPoint b;
        private String c = "起点";
        private String d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3538a = latLonPoint;
            this.b = latLonPoint2;
        }

        public void setFromName(String str) {
            this.c = str;
        }

        public void setToName(String str) {
            this.d = str;
        }

        public LatLonPoint getFrom() {
            return this.f3538a;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public String getFromName() {
            return this.c;
        }

        public String getToName() {
            return this.d;
        }
    }
}
