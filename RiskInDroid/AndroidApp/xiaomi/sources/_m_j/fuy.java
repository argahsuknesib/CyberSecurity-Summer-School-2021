package _m_j;

import _m_j.fuw;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.location.LocationRetrieveFromServerUtil;
import com.xiaomi.smarthome.framework.log.HookHelper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class fuy {
    private static volatile fuy O0000Oo;
    private static final Object O0000OoO = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f17234O000000o = CommonApplication.getAppContext();
    boolean O00000Oo = false;
    String O00000o = "";
    public Location O00000o0 = null;
    List<O000000o> O00000oO = new ArrayList();
    Handler O00000oo = new Handler(Looper.getMainLooper());
    public LocationListener O0000O0o = new LocationListener() {
        /* class _m_j.fuy.AnonymousClass1 */

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            fuy.this.O0000OOo.sendEmptyMessage(3);
        }

        public final void onProviderEnabled(String str) {
            fuy.this.O0000OOo.sendEmptyMessage(4);
        }

        public final void onProviderDisabled(String str) {
            fuy.this.O0000OOo.sendEmptyMessage(5);
        }

        public final void onLocationChanged(Location location) {
            fuy.this.O0000OOo.obtainMessage(6, location).sendToTarget();
        }
    };
    public O00000Oo O0000OOo;
    private gpq O0000Oo0 = new gpq("LocationThread");

    public static class O000000o {
        public String O00000Oo;

        public void O000000o(String str) {
        }

        public void O000000o(String str, Location location) {
        }
    }

    class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            String str = "passive";
            String str2 = "network";
            switch (message.what) {
                case 1:
                    if (message.obj instanceof O000000o) {
                        O000000o o000000o = (O000000o) message.obj;
                        if (!fuy.this.O00000oO.contains(o000000o)) {
                            fuy.this.O00000oO.add(o000000o);
                        }
                    }
                    fuy fuy = fuy.this;
                    if (!fuy.O00000Oo) {
                        fuy.O00000Oo = true;
                        LocationManager locationManager = (LocationManager) fuy.f17234O000000o.getSystemService("location");
                        try {
                            if (!locationManager.isProviderEnabled(str2)) {
                                if (locationManager.isProviderEnabled("gps")) {
                                    str2 = "gps";
                                } else {
                                    if (!locationManager.isProviderEnabled(str)) {
                                        str = "";
                                    }
                                    str2 = str;
                                }
                            }
                            fuy.O00000o = str2;
                            try {
                                locationManager.requestSingleUpdate(str2, fuy.O0000O0o, (Looper) null);
                            } catch (Exception unused) {
                            }
                            fuy.O0000OOo.sendEmptyMessageDelayed(2, 20000);
                            return;
                        } catch (Exception unused2) {
                            fuy.O00000Oo = false;
                            fuy.O00000oo.post(new Runnable() {
                                /* class _m_j.fuy.AnonymousClass2 */

                                public final void run() {
                                    fuy.this.O000000o("");
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 2:
                    fuy.this.O000000o((Location) null);
                    return;
                case 3:
                case 4:
                case 5:
                    if (fuy.this.O0000OOo.hasMessages(2)) {
                        fuy.this.O000000o((Location) null);
                        return;
                    }
                    return;
                case 6:
                    if (!fuy.this.O0000OOo.hasMessages(2)) {
                        return;
                    }
                    if (message.obj instanceof Location) {
                        final Location location = (Location) message.obj;
                        fuy.this.O00000oo.post(new Runnable() {
                            /* class _m_j.fuy.O00000Oo.AnonymousClass1 */

                            public final void run() {
                                fuy.this.O00000o0 = location;
                                fuy fuy = fuy.this;
                                for (int i = 0; i < fuy.O00000oO.size(); i++) {
                                    fuy.O00000oO.get(i);
                                }
                            }
                        });
                        Message obtainMessage = fuy.this.O0000OOo.obtainMessage();
                        obtainMessage.obj = location;
                        obtainMessage.what = 7;
                        fuy.this.O0000OOo.sendMessage(obtainMessage);
                        return;
                    }
                    fuy.this.O000000o((Location) null);
                    return;
                case 7:
                    if (message.obj instanceof Location) {
                        final Location location2 = (Location) message.obj;
                        try {
                            List<Address> fromLocation = new Geocoder(fuy.this.f17234O000000o).getFromLocation(location2.getLatitude(), location2.getLongitude(), 1);
                            if (fromLocation == null || fromLocation.size() <= 0) {
                                fuy.this.O000000o(location2);
                                return;
                            }
                            fuy.O000000o(location2, fromLocation.get(0));
                            fuy.this.O00000Oo = false;
                            fuy.this.O0000OOo.removeMessages(2);
                            ((LocationManager) fuy.this.f17234O000000o.getSystemService("location")).removeUpdates(fuy.this.O0000O0o);
                            fuy.this.O00000oo.post(new Runnable() {
                                /* class _m_j.fuy.O00000Oo.AnonymousClass2 */

                                public final void run() {
                                    fuy.this.O00000o0 = location2;
                                    fuy.this.O000000o(fuy.this.O00000o, location2);
                                }
                            });
                            return;
                        } catch (Exception unused3) {
                            fuy.this.O000000o(location2);
                            return;
                        }
                    } else {
                        fuy.this.O000000o((Location) null);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public static fuy O000000o() {
        if (O0000Oo == null) {
            synchronized (O0000OoO) {
                if (O0000Oo == null) {
                    O0000Oo = new fuy();
                }
            }
        }
        return O0000Oo;
    }

    private fuy() {
        this.O0000Oo0.start();
        this.O0000OOo = new O00000Oo(this.O0000Oo0.getLooper());
    }

    public final void O000000o(String str, Location location) {
        while (this.O00000oO.size() > 0) {
            try {
                this.O00000oO.get(0).O000000o(str, location);
            } catch (Exception unused) {
            }
            this.O00000oO.remove(0);
        }
    }

    public final void O000000o(String str) {
        while (this.O00000oO.size() > 0) {
            try {
                this.O00000oO.get(0).O000000o(str);
            } catch (Exception unused) {
            }
            this.O00000oO.remove(0);
        }
    }

    public final boolean O00000Oo() {
        try {
            return ((LocationManager) this.f17234O000000o.getSystemService("location")).isProviderEnabled("network");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean O00000o0() {
        try {
            return ((LocationManager) this.f17234O000000o.getSystemService("location")).isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public final void O000000o(O000000o o000000o) {
        if (!HookHelper.interceptLocationRequestOnBackground()) {
            O00000Oo(o000000o);
        }
    }

    private void O00000Oo(O000000o o000000o) {
        if (O00000o() && O00000oO()) {
            if (o000000o != null) {
                StringWriter stringWriter = new StringWriter();
                new Exception().printStackTrace(new PrintWriter(stringWriter));
                o000000o.O00000Oo = stringWriter.toString();
            }
            this.O0000OOo.obtainMessage(1, o000000o).sendToTarget();
        } else if (o000000o != null) {
            o000000o.O000000o("");
        }
    }

    public static void O000000o(Location location, Address address) {
        if (location == null) {
            return;
        }
        if (address != null || !TextUtils.isEmpty(null)) {
            Bundle bundle = new Bundle();
            if (address != null) {
                bundle.putParcelable("address", address);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("address_str", null);
            }
            location.setExtras(bundle);
        }
    }

    public final void O000000o(Location location) {
        if (HookHelper.interceptLocationRequestOnBackground()) {
            this.O00000Oo = false;
            this.O0000OOo.removeMessages(2);
            ((LocationManager) this.f17234O000000o.getSystemService("location")).removeUpdates(this.O0000O0o);
            this.O00000oo.post(new Runnable() {
                /* class _m_j.fuy.AnonymousClass3 */

                public final void run() {
                    fuy fuy = fuy.this;
                    fuy.O000000o(fuy.O00000o);
                }
            });
            return;
        }
        ExternalLoadManager.instance.loadExternal("amap2d", new fkv(location) {
            /* class _m_j.$$Lambda$fuy$sh5WMIqTEIb7BtAgHDD4aCBPro */
            private final /* synthetic */ Location f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return fuy.this.O000000o(this.f$1, (ExternalLoadManager.O000000o) obj);
            }
        });
    }

    public final void O00000Oo(final Location location) {
        this.O00000o0 = location;
        this.O00000Oo = false;
        this.O0000OOo.removeMessages(2);
        ((LocationManager) this.f17234O000000o.getSystemService("location")).removeUpdates(this.O0000O0o);
        this.O00000oo.post(new Runnable() {
            /* class _m_j.fuy.AnonymousClass6 */

            public final void run() {
                fuy fuy = fuy.this;
                fuy.O000000o(fuy.O00000o, location);
            }
        });
    }

    public final void O000000o(double d, double d2, O000000o o000000o) {
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        final Geocoder geocoder = new Geocoder(CommonApplication.getAppContext(), O00oOooo);
        final double d3 = d;
        final double d4 = d2;
        final O000000o o000000o2 = o000000o;
        this.O0000OOo.post(new Runnable() {
            /* class _m_j.fuy.AnonymousClass7 */

            public final void run() {
                try {
                    List<Address> fromLocation = geocoder.getFromLocation(d3, d4, 1);
                    if (fromLocation == null || fromLocation.size() <= 0) {
                        fuy.this.O00000Oo(d3, d4, o000000o2);
                        return;
                    }
                    Address address = fromLocation.get(0);
                    Location location = new Location("");
                    location.setLatitude(d3);
                    location.setLongitude(d4);
                    Bundle bundle = new Bundle();
                    if (address != null) {
                        bundle.putParcelable("address", address);
                    }
                    location.setExtras(bundle);
                    o000000o2.O000000o("", location);
                } catch (Exception unused) {
                    fuy.this.O00000Oo(d3, d4, o000000o2);
                }
            }
        });
    }

    public final void O00000Oo(double d, double d2, O000000o o000000o) {
        GeocodeSearch geocodeSearch = new GeocodeSearch(CommonApplication.getAppContext());
        final O000000o o000000o2 = o000000o;
        final double d3 = d2;
        final double d4 = d;
        geocodeSearch.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            /* class _m_j.fuy.AnonymousClass8 */

            public final void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
            }

            public final void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
                if (regeocodeResult == null) {
                    o000000o2.O000000o("");
                    return;
                }
                Location location = new Location("");
                RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
                if (regeocodeAddress == null) {
                    o000000o2.O000000o("");
                    return;
                }
                location.setLongitude(d3);
                location.setLatitude(d4);
                Address address = new Address(Locale.getDefault());
                address.setLatitude(d4);
                address.setLongitude(d3);
                if (!TextUtils.isEmpty(regeocodeAddress.getProvince()) && !"null".equalsIgnoreCase(regeocodeAddress.getProvince())) {
                    address.setAdminArea(regeocodeAddress.getProvince());
                }
                if (!TextUtils.isEmpty(regeocodeAddress.getCity()) && !"null".equalsIgnoreCase(regeocodeAddress.getCity())) {
                    address.setLocality(regeocodeAddress.getCity());
                }
                if (!TextUtils.isEmpty(regeocodeAddress.getDistrict()) && !"null".equalsIgnoreCase(regeocodeAddress.getDistrict())) {
                    address.setSubLocality(regeocodeAddress.getDistrict());
                }
                List<RegeocodeRoad> roads = regeocodeAddress.getRoads();
                if (roads != null && roads.size() > 0) {
                    RegeocodeRoad regeocodeRoad = roads.get(0);
                    if (!TextUtils.isEmpty(regeocodeRoad.getName()) && !"null".equalsIgnoreCase(regeocodeRoad.getName())) {
                        address.setThoroughfare(regeocodeRoad.getName());
                    }
                }
                LocationRetrieveFromServerUtil.O000000o(location, address, "");
                fuy.this.O00000Oo(location);
                o000000o2.O000000o("", location);
            }
        });
        geocodeSearch.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(d, d2), 1000.0f, "autonavi"));
    }

    public static boolean O00000o() {
        try {
            if (Build.VERSION.SDK_INT < 19) {
                return !TextUtils.isEmpty(Settings.Secure.getString(CommonApplication.getAppContext().getContentResolver(), "location_providers_allowed"));
            }
            try {
                return Settings.Secure.getInt(CommonApplication.getAppContext().getContentResolver(), "location_mode") != 0;
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean O00000oO() {
        if (!gqd.O000000o(CommonApplication.getAppContext(), "android.permission.ACCESS_FINE_LOCATION") && !gqd.O000000o(CommonApplication.getAppContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(final Location location, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            fuw.O000000o().O000000o(new fuw.O000000o() {
                /* class _m_j.fuy.AnonymousClass4 */

                public final void O000000o(AMapLocation aMapLocation) {
                    Location location = location;
                    if (location == null) {
                        location = new Location(fuy.this.O00000o);
                    }
                    location.setLongitude(aMapLocation.getLongitude());
                    location.setLatitude(aMapLocation.getLatitude());
                    Address address = new Address(Locale.getDefault());
                    address.setLatitude(aMapLocation.getLatitude());
                    address.setLongitude(aMapLocation.getLongitude());
                    if (!TextUtils.isEmpty(aMapLocation.getProvince()) && !"null".equalsIgnoreCase(aMapLocation.getProvince())) {
                        address.setAdminArea(aMapLocation.getProvince());
                    }
                    if (!TextUtils.isEmpty(aMapLocation.getCity()) && !"null".equalsIgnoreCase(aMapLocation.getCity())) {
                        address.setLocality(aMapLocation.getCity());
                    }
                    if (!TextUtils.isEmpty(aMapLocation.getDistrict()) && !"null".equalsIgnoreCase(aMapLocation.getDistrict())) {
                        address.setSubLocality(aMapLocation.getDistrict());
                    }
                    if (!TextUtils.isEmpty(aMapLocation.getRoad()) && !"null".equalsIgnoreCase(aMapLocation.getRoad())) {
                        address.setThoroughfare(aMapLocation.getRoad());
                    }
                    LocationRetrieveFromServerUtil.O000000o(location, address, aMapLocation.getAddress());
                    fuy.this.O00000Oo(location);
                }

                public final void O000000o() {
                    fuy fuy = fuy.this;
                    fuy.O00000Oo = false;
                    fuy.O0000OOo.removeMessages(2);
                    ((LocationManager) fuy.this.f17234O000000o.getSystemService("location")).removeUpdates(fuy.this.O0000O0o);
                    fuy.this.O00000oo.post(new Runnable() {
                        /* class _m_j.fuy.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            fuy.this.O000000o(fuy.this.O00000o);
                        }
                    });
                }
            }, "high");
        } else {
            this.O00000Oo = false;
            this.O0000OOo.removeMessages(2);
            ((LocationManager) this.f17234O000000o.getSystemService("location")).removeUpdates(this.O0000O0o);
            this.O00000oo.post(new Runnable() {
                /* class _m_j.fuy.AnonymousClass5 */

                public final void run() {
                    fuy fuy = fuy.this;
                    fuy.O000000o(fuy.O00000o);
                }
            });
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
