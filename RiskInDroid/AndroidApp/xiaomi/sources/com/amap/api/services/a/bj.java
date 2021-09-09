package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

public class bj implements IRouteSearch {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RouteSearch.OnRouteSearchListener f3319a;
    /* access modifiers changed from: private */
    public RouteSearch.OnTruckRouteSearchListener b;
    /* access modifiers changed from: private */
    public RouteSearch.OnRoutePlanSearchListener c;
    private Context d;
    /* access modifiers changed from: private */
    public Handler e = ac.a();

    public bj(Context context) {
        this.d = context.getApplicationContext();
    }

    public void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f3319a = onRouteSearchListener;
    }

    public void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    public void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.c = onRoutePlanSearchListener;
    }

    public WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            aa.a(this.d);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(walkRouteQuery.getFromAndTo())) {
                RouteSearch.WalkRouteQuery clone = walkRouteQuery.clone();
                WalkRouteResult walkRouteResult = (WalkRouteResult) new au(this.d, clone).c();
                if (walkRouteResult != null) {
                    walkRouteResult.setWalkQuery(clone);
                }
                return walkRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "RouteSearch", "calculateWalkRoute");
            throw e2;
        }
    }

    public void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bj.AnonymousClass1 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    try {
                        walkRouteResult = bj.this.calculateWalkRoute(walkRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bj.this.f3319a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        bj.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bj.this.f3319a;
                    bundle.putParcelable("result", walkRouteResult);
                    obtainMessage.setData(bundle);
                    bj.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    public BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            aa.a(this.d);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(busRouteQuery.getFromAndTo())) {
                RouteSearch.BusRouteQuery clone = busRouteQuery.clone();
                BusRouteResult busRouteResult = (BusRouteResult) new l(this.d, clone).c();
                if (busRouteResult != null) {
                    busRouteResult.setBusQuery(clone);
                }
                return busRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "RouteSearch", "calculateBusRoute");
            throw e2;
        }
    }

    public void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bj.AnonymousClass2 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    try {
                        busRouteResult = bj.this.calculateBusRoute(busRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bj.this.f3319a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        bj.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bj.this.f3319a;
                    bundle.putParcelable("result", busRouteResult);
                    obtainMessage.setData(bundle);
                    bj.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    public DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            aa.a(this.d);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(driveRouteQuery.getFromAndTo())) {
                RouteSearch.DriveRouteQuery clone = driveRouteQuery.clone();
                DriveRouteResult driveRouteResult = (DriveRouteResult) new w(this.d, clone).c();
                if (driveRouteResult != null) {
                    driveRouteResult.setDriveQuery(clone);
                }
                return driveRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "RouteSearch", "calculateDriveRoute");
            throw e2;
        }
    }

    public void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bj.AnonymousClass3 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    try {
                        driveRouteResult = bj.this.calculateDriveRoute(driveRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bj.this.f3319a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        bj.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bj.this.f3319a;
                    bundle.putParcelable("result", driveRouteResult);
                    obtainMessage.setData(bundle);
                    bj.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    private boolean a(RouteSearch.FromAndTo fromAndTo) {
        if (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return false;
        }
        return true;
    }

    public void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bj.AnonymousClass4 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    try {
                        rideRouteResult = bj.this.calculateRideRoute(rideRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bj.this.f3319a;
                        bundle.putParcelable("result", rideRouteResult);
                        obtainMessage.setData(bundle);
                        bj.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bj.this.f3319a;
                    bundle.putParcelable("result", rideRouteResult);
                    obtainMessage.setData(bundle);
                    bj.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    public RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            aa.a(this.d);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(rideRouteQuery.getFromAndTo())) {
                RouteSearch.RideRouteQuery clone = rideRouteQuery.clone();
                RideRouteResult rideRouteResult = (RideRouteResult) new an(this.d, clone).c();
                if (rideRouteResult != null) {
                    rideRouteResult.setRideQuery(clone);
                }
                return rideRouteResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "RouteSearch", "calculaterideRoute");
            throw e2;
        }
    }

    public TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            aa.a(this.d);
            if (truckRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(truckRouteQuery.getFromAndTo())) {
                RouteSearch.TruckRouteQuery clone = truckRouteQuery.clone();
                TruckRouteRestult truckRouteRestult = (TruckRouteRestult) new at(this.d, clone).c();
                if (truckRouteRestult != null) {
                    truckRouteRestult.setTruckQuery(clone);
                }
                return truckRouteRestult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "RouteSearch", "calculateDriveRoute");
            throw e2;
        }
    }

    public void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bj.AnonymousClass5 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 104;
                    obtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestult = null;
                    try {
                        truckRouteRestult = bj.this.calculateTruckRoute(truckRouteQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bj.this.b;
                        bundle.putParcelable("result", truckRouteRestult);
                        obtainMessage.setData(bundle);
                        bj.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bj.this.b;
                    bundle.putParcelable("result", truckRouteRestult);
                    obtainMessage.setData(bundle);
                    bj.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            aa.a(this.d);
            if (drivePlanQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (a(drivePlanQuery.getFromAndTo())) {
                DriveRoutePlanResult driveRoutePlanResult = (DriveRoutePlanResult) new v(this.d, drivePlanQuery.clone()).c();
                if (driveRoutePlanResult != null) {
                    driveRoutePlanResult.setDrivePlanQuery(drivePlanQuery);
                }
                return driveRoutePlanResult;
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (AMapException e2) {
            s.a(e2, "RouteSearch", "calculateDrivePlan");
            throw e2;
        }
    }

    public void calculateDrivePlanAsyn(final RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            as.a().a(new Runnable() {
                /* class com.amap.api.services.a.bj.AnonymousClass6 */

                public void run() {
                    Message obtainMessage = ac.a().obtainMessage();
                    obtainMessage.what = 105;
                    obtainMessage.arg1 = 18;
                    Bundle bundle = new Bundle();
                    DriveRoutePlanResult driveRoutePlanResult = null;
                    try {
                        driveRoutePlanResult = bj.this.calculateDrivePlan(drivePlanQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e) {
                        bundle.putInt("errorCode", e.getErrorCode());
                    } catch (Throwable th) {
                        obtainMessage.obj = bj.this.c;
                        bundle.putParcelable("result", driveRoutePlanResult);
                        obtainMessage.setData(bundle);
                        bj.this.e.sendMessage(obtainMessage);
                        throw th;
                    }
                    obtainMessage.obj = bj.this.c;
                    bundle.putParcelable("result", driveRoutePlanResult);
                    obtainMessage.setData(bundle);
                    bj.this.e.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            s.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }
}
