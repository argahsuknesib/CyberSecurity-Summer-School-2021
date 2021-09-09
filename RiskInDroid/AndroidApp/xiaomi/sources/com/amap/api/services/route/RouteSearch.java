package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.a.bj;
import com.amap.api.services.a.s;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import java.util.ArrayList;
import java.util.List;

public class RouteSearch {

    /* renamed from: a  reason: collision with root package name */
    private IRouteSearch f3510a;

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i);
    }

    public RouteSearch(Context context) {
        if (this.f3510a == null) {
            try {
                this.f3510a = new bj(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f3510a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() {
            /* class com.amap.api.services.route.RouteSearch.FromAndTo.AnonymousClass1 */

            /* renamed from: a */
            public final FromAndTo createFromParcel(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            /* renamed from: a */
            public final FromAndTo[] newArray(int i) {
                return new FromAndTo[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f3514a;
        private LatLonPoint b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;

        public int describeContents() {
            return 0;
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3514a = latLonPoint;
            this.b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f3514a;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public String getStartPoiID() {
            return this.c;
        }

        public void setStartPoiID(String str) {
            this.c = str;
        }

        public String getDestinationPoiID() {
            return this.d;
        }

        public void setDestinationPoiID(String str) {
            this.d = str;
        }

        public String getOriginType() {
            return this.e;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public String getDestinationType() {
            return this.f;
        }

        public void setDestinationType(String str) {
            this.f = str;
        }

        public String getPlateProvince() {
            return this.g;
        }

        public void setPlateProvince(String str) {
            this.g = str;
        }

        public String getPlateNumber() {
            return this.h;
        }

        public void setPlateNumber(String str) {
            this.h = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3514a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }

        public FromAndTo(Parcel parcel) {
            this.f3514a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
        }

        public FromAndTo() {
        }

        public int hashCode() {
            String str = this.d;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f3514a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode5 + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FromAndTo fromAndTo = (FromAndTo) obj;
            String str = this.d;
            if (str == null) {
                if (fromAndTo.d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f3514a;
            if (latLonPoint == null) {
                if (fromAndTo.f3514a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f3514a)) {
                return false;
            }
            String str2 = this.c;
            if (str2 == null) {
                if (fromAndTo.c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.b;
            if (latLonPoint2 == null) {
                if (fromAndTo.b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.b)) {
                return false;
            }
            String str3 = this.e;
            if (str3 == null) {
                if (fromAndTo.e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.e)) {
                return false;
            }
            String str4 = this.f;
            if (str4 == null) {
                if (fromAndTo.f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f)) {
                return false;
            }
            return true;
        }

        public FromAndTo clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f3514a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f);
            return fromAndTo;
        }
    }

    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.BusRouteQuery.AnonymousClass1 */

            /* renamed from: a */
            public final BusRouteQuery createFromParcel(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            /* renamed from: a */
            public final BusRouteQuery[] newArray(int i) {
                return new BusRouteQuery[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f3511a;
        private int b;
        private String c;
        private String d;
        private int e;

        public int describeContents() {
            return 0;
        }

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.f3511a = fromAndTo;
            this.b = i;
            this.c = str;
            this.e = i2;
        }

        public FromAndTo getFromAndTo() {
            return this.f3511a;
        }

        public int getMode() {
            return this.b;
        }

        public String getCity() {
            return this.c;
        }

        public int getNightFlag() {
            return this.e;
        }

        public String getCityd() {
            return this.d;
        }

        public void setCityd(String str) {
            this.d = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3511a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.e);
            parcel.writeString(this.d);
        }

        public BusRouteQuery(Parcel parcel) {
            this.f3511a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.e = parcel.readInt();
            this.d = parcel.readString();
        }

        public BusRouteQuery() {
        }

        public int hashCode() {
            String str = this.c;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f3511a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.b) * 31) + this.e) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            String str = this.c;
            if (str == null) {
                if (busRouteQuery.c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.c)) {
                return false;
            }
            String str2 = this.d;
            if (str2 == null) {
                if (busRouteQuery.d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.d)) {
                return false;
            }
            FromAndTo fromAndTo = this.f3511a;
            if (fromAndTo == null) {
                if (busRouteQuery.f3511a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.f3511a)) {
                return false;
            }
            return this.b == busRouteQuery.b && this.e == busRouteQuery.e;
        }

        public BusRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f3511a, this.b, this.c, this.e);
            busRouteQuery.setCityd(this.d);
            return busRouteQuery;
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.WalkRouteQuery.AnonymousClass1 */

            /* renamed from: a */
            public final WalkRouteQuery createFromParcel(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            /* renamed from: a */
            public final WalkRouteQuery[] newArray(int i) {
                return new WalkRouteQuery[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public FromAndTo f3517a;
        /* access modifiers changed from: private */
        public int b;

        public int describeContents() {
            return 0;
        }

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.f3517a = fromAndTo;
            this.b = i;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f3517a = fromAndTo;
        }

        public FromAndTo getFromAndTo() {
            return this.f3517a;
        }

        public int getMode() {
            return this.b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3517a, i);
            parcel.writeInt(this.b);
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f3517a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
        }

        public WalkRouteQuery() {
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f3517a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.f3517a;
            if (fromAndTo == null) {
                if (walkRouteQuery.f3517a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.f3517a)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public WalkRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                s.a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            return new WalkRouteQuery(this.f3517a);
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.DriveRouteQuery.AnonymousClass1 */

            /* renamed from: a */
            public final DriveRouteQuery createFromParcel(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            /* renamed from: a */
            public final DriveRouteQuery[] newArray(int i) {
                return new DriveRouteQuery[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f3513a;
        private int b;
        private List<LatLonPoint> c;
        private List<List<LatLonPoint>> d;
        private String e;
        private boolean f = true;
        private int g = 0;

        public int describeContents() {
            return 0;
        }

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f3513a = fromAndTo;
            this.b = i;
            this.c = list;
            this.d = list2;
            this.e = str;
        }

        public FromAndTo getFromAndTo() {
            return this.f3513a;
        }

        public int getMode() {
            return this.b;
        }

        public int getCarType() {
            return this.g;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.c;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.d;
        }

        public String getAvoidRoad() {
            return this.e;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.c.size(); i++) {
                LatLonPoint latLonPoint = this.c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasPassPoint() {
            return !s.a(getPassedPointStr());
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.d.size(); i++) {
                List list2 = this.d.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    LatLonPoint latLonPoint = (LatLonPoint) list2.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidpolygons() {
            return !s.a(getAvoidpolygonsStr());
        }

        public boolean hasAvoidRoad() {
            return !s.a(getAvoidRoad());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3513a, i);
            parcel.writeInt(this.b);
            parcel.writeTypedList(this.c);
            List<List<LatLonPoint>> list = this.d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> writeTypedList : this.d) {
                    parcel.writeTypedList(writeTypedList);
                }
            }
            parcel.writeString(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g);
        }

        public DriveRouteQuery(Parcel parcel) {
            boolean z = true;
            this.f3513a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.d = null;
            } else {
                this.d = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.e = parcel.readString();
            this.f = parcel.readInt() != 1 ? false : z;
            this.g = parcel.readInt();
        }

        public DriveRouteQuery() {
        }

        public int hashCode() {
            String str = this.e;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f3513a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.b) * 31;
            List<LatLonPoint> list2 = this.c;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return ((hashCode3 + i) * 31) + this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            String str = this.e;
            if (str == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.e)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.d;
            if (list == null) {
                if (driveRouteQuery.d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.d)) {
                return false;
            }
            FromAndTo fromAndTo = this.f3513a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f3513a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f3513a)) {
                return false;
            }
            if (this.b != driveRouteQuery.b) {
                return false;
            }
            List<LatLonPoint> list2 = this.c;
            if (list2 != null) {
                return list2.equals(driveRouteQuery.c) && this.f == driveRouteQuery.isUseFerry() && this.g == driveRouteQuery.g;
            }
            if (driveRouteQuery.c != null) {
                return false;
            }
        }

        public DriveRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f3513a, this.b, this.c, this.d, this.e);
            driveRouteQuery.setUseFerry(this.f);
            driveRouteQuery.setCarType(this.g);
            return driveRouteQuery;
        }

        public boolean isUseFerry() {
            return this.f;
        }

        public void setUseFerry(boolean z) {
            this.f = z;
        }

        public void setCarType(int i) {
            this.g = i;
        }
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.RideRouteQuery.AnonymousClass1 */

            /* renamed from: a */
            public final RideRouteQuery createFromParcel(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            /* renamed from: a */
            public final RideRouteQuery[] newArray(int i) {
                return new RideRouteQuery[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f3515a;
        private int b;

        public int describeContents() {
            return 0;
        }

        public RideRouteQuery(FromAndTo fromAndTo, int i) {
            this.f3515a = fromAndTo;
            this.b = i;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f3515a = fromAndTo;
        }

        public FromAndTo getFromAndTo() {
            return this.f3515a;
        }

        public int getMode() {
            return this.b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3515a, i);
            parcel.writeInt(this.b);
        }

        public RideRouteQuery(Parcel parcel) {
            this.f3515a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
        }

        public RideRouteQuery() {
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f3515a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.f3515a;
            if (fromAndTo == null) {
                if (walkRouteQuery.f3517a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.f3517a)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public RideRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                s.a(e, "RouteSearch", "RideRouteQueryclone");
            }
            return new RideRouteQuery(this.f3515a);
        }
    }

    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() {
            /* class com.amap.api.services.route.RouteSearch.TruckRouteQuery.AnonymousClass1 */

            /* renamed from: a */
            public final TruckRouteQuery createFromParcel(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            /* renamed from: a */
            public final TruckRouteQuery[] newArray(int i) {
                return new TruckRouteQuery[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f3516a;
        private int b = 2;
        private int c;
        private List<LatLonPoint> d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;

        public int describeContents() {
            return 0;
        }

        public TruckRouteQuery(FromAndTo fromAndTo, int i2, List<LatLonPoint> list, int i3) {
            this.f3516a = fromAndTo;
            this.c = i2;
            this.d = list;
            this.b = i3;
        }

        protected TruckRouteQuery(Parcel parcel) {
            this.f3516a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.e = parcel.readFloat();
            this.f = parcel.readFloat();
            this.g = parcel.readFloat();
            this.h = parcel.readFloat();
            this.i = parcel.readFloat();
        }

        public void setMode(int i2) {
            this.c = i2;
        }

        public void setTruckSize(int i2) {
            this.b = i2;
        }

        public void setTruckHeight(float f2) {
            this.e = f2;
        }

        public void setTruckWidth(float f2) {
            this.f = f2;
        }

        public void setTruckLoad(float f2) {
            this.g = f2;
        }

        public void setTruckWeight(float f2) {
            this.h = f2;
        }

        public void setTruckAxis(float f2) {
            this.i = f2;
        }

        public FromAndTo getFromAndTo() {
            return this.f3516a;
        }

        public int getMode() {
            return this.c;
        }

        public boolean hasPassPoint() {
            return !s.a(getPassedPointStr());
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                LatLonPoint latLonPoint = this.d.get(i2);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i2 < this.d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int getTruckSize() {
            return this.b;
        }

        public float getTruckHeight() {
            return this.e;
        }

        public float getTruckWidth() {
            return this.f;
        }

        public float getTruckLoad() {
            return this.g;
        }

        public float getTruckWeight() {
            return this.h;
        }

        public float getTruckAxis() {
            return this.i;
        }

        public TruckRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "RouteSearch", "TruckRouteQueryclone");
            }
            return new TruckRouteQuery(this.f3516a, this.c, this.d, this.b);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f3516a, i2);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeTypedList(this.d);
            parcel.writeFloat(this.e);
            parcel.writeFloat(this.f);
            parcel.writeFloat(this.g);
            parcel.writeFloat(this.h);
            parcel.writeFloat(this.i);
        }
    }

    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() {
            /* class com.amap.api.services.route.RouteSearch.DrivePlanQuery.AnonymousClass1 */

            /* renamed from: a */
            public final DrivePlanQuery createFromParcel(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            /* renamed from: a */
            public final DrivePlanQuery[] newArray(int i) {
                return new DrivePlanQuery[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private FromAndTo f3512a;
        private String b;
        private int c = 1;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private int g = 48;

        public int describeContents() {
            return 0;
        }

        public DrivePlanQuery(FromAndTo fromAndTo, int i, int i2, int i3) {
            this.f3512a = fromAndTo;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }

        public FromAndTo getFromAndTo() {
            return this.f3512a;
        }

        public String getDestParentPoiID() {
            return this.b;
        }

        public int getMode() {
            return this.c;
        }

        public int getCarType() {
            return this.d;
        }

        public int getFirstTime() {
            return this.e;
        }

        public int getInterval() {
            return this.f;
        }

        public int getCount() {
            return this.g;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3512a, i);
            parcel.writeString(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public DrivePlanQuery() {
        }

        protected DrivePlanQuery(Parcel parcel) {
            this.f3512a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readString();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f3512a;
            int i = 0;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return ((((((((((hashCode + i) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
            FromAndTo fromAndTo = this.f3512a;
            if (fromAndTo == null) {
                if (drivePlanQuery.f3512a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.f3512a)) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (drivePlanQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.b)) {
                return false;
            }
            return this.c == drivePlanQuery.c && this.d == drivePlanQuery.d && this.e == drivePlanQuery.e && this.f == drivePlanQuery.f && this.g == drivePlanQuery.g;
        }

        public DrivePlanQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                s.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f3512a, this.e, this.f, this.g);
            drivePlanQuery.setDestParentPoiID(this.b);
            drivePlanQuery.setMode(this.c);
            drivePlanQuery.setCarType(this.d);
            return drivePlanQuery;
        }

        public void setDestParentPoiID(String str) {
            this.b = str;
        }

        public void setMode(int i) {
            this.c = i;
        }

        public void setCarType(int i) {
            this.d = i;
        }
    }
}
