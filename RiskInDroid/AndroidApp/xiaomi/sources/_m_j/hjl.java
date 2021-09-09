package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.log.HookHelper;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class hjl {
    private static volatile hjl O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public long f18991O000000o = 0;
    public O00000o0 O00000Oo;
    public final AMapLocationClient O00000o = new AMapLocationClient(ServiceApplication.getApplication());
    public O00000Oo O00000o0;

    private hjl() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setGpsFirst(false);
        this.O00000o.setLocationOption(aMapLocationClientOption);
    }

    public static hjl O000000o() {
        if (O00000oO == null) {
            synchronized (hjl.class) {
                if (O00000oO == null) {
                    O00000oO = new hjl();
                }
            }
        }
        return O00000oO;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    public final Single<O00000o0> O000000o(String str) {
        String str2 = "GCJ02";
        if (!fuy.O00000oO()) {
            return Single.just(O000000o.O00000Oo);
        }
        if (HookHelper.interceptLocationRequestOnBackground()) {
            return Single.just(O000000o.f18997O000000o);
        }
        try {
            final O00000Oo o00000Oo = new O00000Oo();
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.equals(jSONObject.optString("csysType").toUpperCase(), str2)) {
                str2 = "WGS84";
            }
            o00000Oo.f18998O000000o = str2;
            o00000Oo.O00000Oo = Math.min(jSONObject.optLong("cacheTimeout", 30), 30L);
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f18991O000000o;
            if (currentTimeMillis - j < 500) {
                return Single.just(O000000o.O00000oo);
            }
            if (this.O00000Oo != null && j != 0 && o00000Oo == this.O00000o0 && (System.currentTimeMillis() / 1000) - this.f18991O000000o < o00000Oo.O00000Oo / 1000) {
                gsy.O00000Oo("LocationHelper", "getLocationRx: use cache location");
                return Single.just(this.O00000Oo);
            }
            this.O00000Oo = null;
            this.O00000o0 = null;
            final long currentTimeMillis2 = System.currentTimeMillis();
            return Single.create(new SingleOnSubscribe<O00000o0>() {
                /* class _m_j.hjl.AnonymousClass4 */

                public final void subscribe(final SingleEmitter<O00000o0> singleEmitter) throws Exception {
                    gsy.O00000Oo("LocationHelper", "getLocationRx: start");
                    hjl.this.O00000o.setLocationListener(new AMapLocationListener() {
                        /* class _m_j.hjl.AnonymousClass4.AnonymousClass1 */

                        public final void onLocationChanged(AMapLocation aMapLocation) {
                            O00000o0 o00000o0;
                            gsy.O00000Oo("LocationHelper", "onLocationChanged: ".concat(String.valueOf(aMapLocation)));
                            if (!singleEmitter.isDisposed()) {
                                SingleEmitter singleEmitter = singleEmitter;
                                if (aMapLocation == null) {
                                    o00000o0 = O000000o.O00000o;
                                } else if (TextUtils.isEmpty(aMapLocation.getErrorInfo()) || TextUtils.equals("success", aMapLocation.getErrorInfo())) {
                                    o00000o0 = new O00000o0();
                                    o00000o0.O0000OOo = aMapLocation.getCoordType() == null ? "" : aMapLocation.getCoordType().toUpperCase();
                                    o00000o0.O0000Oo = aMapLocation.getLatitude();
                                    o00000o0.O0000Oo0 = aMapLocation.getLongitude();
                                    o00000o0.O0000OoO = aMapLocation.getAccuracy();
                                    o00000o0.O0000Ooo = aMapLocation.getSpeed();
                                    o00000o0.O0000o0 = aMapLocation.getProvince();
                                    o00000o0.O0000o0O = aMapLocation.getCity();
                                    o00000o0.O0000o0o = aMapLocation.getCityCode();
                                    o00000o0.O0000o = aMapLocation.getAdCode();
                                    o00000o0.O0000o00 = aMapLocation.getCountry();
                                    o00000o0.O0000oO0 = aMapLocation.getDistrict();
                                    o00000o0.O0000oO = aMapLocation.getStreet();
                                    o00000o0.O0000oOO = aMapLocation.getStreetNum();
                                } else {
                                    o00000o0 = new O000000o(aMapLocation.getErrorInfo());
                                }
                                singleEmitter.onSuccess(o00000o0);
                            }
                        }
                    });
                    hjl.this.O00000o.startLocation();
                }
            }).map(new Function<O00000o0, O00000o0>() {
                /* class _m_j.hjl.AnonymousClass3 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    O00000o0 o00000o0 = (O00000o0) obj;
                    if (!TextUtils.equals(o00000Oo.f18998O000000o, o00000o0.O0000OOo)) {
                        if (TextUtils.equals(o00000o0.O0000OOo, "GCJ02")) {
                            hpv O00000Oo2 = hjk.O00000Oo(o00000o0.O0000Oo, o00000o0.O0000Oo0);
                            o00000o0.O0000Oo = O00000Oo2.O00000Oo;
                            o00000o0.O0000Oo0 = O00000Oo2.f511O000000o;
                            o00000o0.O0000OOo = "WGS84";
                        } else if (TextUtils.equals(o00000o0.O0000OOo, "WGS84")) {
                            hpv O000000o2 = hjk.O000000o(o00000o0.O0000Oo, o00000o0.O0000Oo0);
                            o00000o0.O0000Oo = O000000o2.O00000Oo;
                            o00000o0.O0000Oo0 = O000000o2.f511O000000o;
                            o00000o0.O0000OOo = "GCJ02";
                        }
                    }
                    return o00000o0;
                }
            }).timeout(60, TimeUnit.SECONDS, new SingleSource<O00000o0>() {
                /* class _m_j.hjl.AnonymousClass2 */

                public final void subscribe(SingleObserver<? super O00000o0> singleObserver) {
                    singleObserver.onSuccess(O000000o.O00000o0);
                }
            }).doOnSuccess(new Consumer<O00000o0>() {
                /* class _m_j.hjl.AnonymousClass1 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    O00000o0 o00000o0 = (O00000o0) obj;
                    gsy.O000000o(3, "LocationHelper", "getLocationRx: take: " + ((System.currentTimeMillis() - currentTimeMillis2) / 1000) + " sec");
                    gsy.O00000Oo("LocationHelper", "getLocationRx: " + o00000Oo + " ; " + o00000o0);
                    if (!(o00000o0 instanceof O000000o)) {
                        hjl.this.f18991O000000o = System.currentTimeMillis();
                        hjl hjl = hjl.this;
                        hjl.O00000Oo = o00000o0;
                        hjl.O00000o0 = o00000Oo;
                    }
                }
            });
        } catch (Exception e) {
            return Single.just(new O000000o(e.getLocalizedMessage()));
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18998O000000o = "GCJ02";
        long O00000Oo = 8;

        O00000Oo() {
        }

        public final String toString() {
            return "RequestOption{csysType='" + this.f18998O000000o + '\'' + ", cacheTimeout=" + this.O00000Oo + '}';
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                O00000Oo o00000Oo = (O00000Oo) obj;
                if (this.O00000Oo != o00000Oo.O00000Oo) {
                    return false;
                }
                String str = this.f18998O000000o;
                if (str != null) {
                    return str.equals(o00000Oo.f18998O000000o);
                }
                if (o00000Oo.f18998O000000o == null) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f18998O000000o;
            int hashCode = str != null ? str.hashCode() : 0;
            long j = this.O00000Oo;
            return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
        }
    }

    public static class O00000o0 {
        String O0000OOo;
        double O0000Oo;
        double O0000Oo0;
        float O0000OoO;
        float O0000Ooo;
        String O0000o;
        String O0000o0;
        String O0000o00;
        String O0000o0O;
        String O0000o0o;
        String O0000oO;
        String O0000oO0;
        String O0000oOO;

        O00000o0() {
        }

        public JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", "ok");
                jSONObject.put("csysType", this.O0000OOo);
                jSONObject.put("latitude", this.O0000Oo);
                jSONObject.put("longitude", this.O0000Oo0);
                jSONObject.put("accuracy", (double) this.O0000OoO);
                jSONObject.put("speed", (double) this.O0000Ooo);
                jSONObject.put("province", this.O0000o0);
                jSONObject.put("city", this.O0000o0O);
                jSONObject.put("cityCode", this.O0000o0o);
                jSONObject.put("adCode", this.O0000o);
                jSONObject.put("country", this.O0000o00);
                jSONObject.put("district", this.O0000oO0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(this.O0000oO, this.O0000oOO);
                jSONObject.put("streetNumber", jSONObject2);
            } catch (Exception e) {
                gsy.O00000Oo("LocationHelper", "toJson: " + Log.getStackTraceString(e));
            }
            return jSONObject;
        }

        public String toString() {
            return O000000o().toString();
        }
    }

    static class O000000o extends O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final O00000o0 f18997O000000o = new O000000o("location is disabled.");
        static final O00000o0 O00000Oo = new O000000o("location permission is not granted.");
        static final O00000o0 O00000o = new O000000o("error unknow.");
        static final O00000o0 O00000o0 = new O000000o("get location timeout.");
        static final O00000o0 O00000oO = new O000000o("param error.");
        static final O00000o0 O00000oo = new O000000o("too many location request.");
        final String O0000O0o;

        O000000o(String str) {
            this.O0000O0o = str;
        }

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", "error");
                jSONObject.put("msg", this.O0000O0o);
            } catch (JSONException e) {
                gsy.O00000Oo("LocationHelper", "toJson: " + Log.getStackTraceString(e));
            }
            return jSONObject;
        }

        public final String toString() {
            return O000000o().toString();
        }
    }
}
