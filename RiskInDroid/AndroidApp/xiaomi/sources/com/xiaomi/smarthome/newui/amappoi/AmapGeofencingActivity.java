package com.xiaomi.smarthome.newui.amappoi;

import _m_j.gpc;
import _m_j.hbt;
import _m_j.hbu;
import _m_j.hpv;
import _m_j.hte;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class AmapGeofencingActivity extends BaseActivity implements AdapterView.OnItemClickListener, AMap.OnCameraChangeListener, LocationSource {

    /* renamed from: O000000o  reason: collision with root package name */
    protected MapView f10176O000000o = null;
    protected AMapLocation O00000Oo;
    protected TextView O00000o;
    protected int O00000o0;
    protected View O00000oO;
    protected AMapLocationClient O00000oo;
    private int O0000O0o = 500;
    private int O0000OOo = 2000;
    private ImageView O0000Oo;
    private AMapLocationListener O0000Oo0 = new AMapLocationListener() {
        /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass1 */

        public final void onLocationChanged(AMapLocation aMapLocation) {
            AmapGeofencingActivity.this.mMyLocation = new hpv(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            AmapGeofencingActivity amapGeofencingActivity = AmapGeofencingActivity.this;
            amapGeofencingActivity.O00000Oo = aMapLocation;
            amapGeofencingActivity.dismissLoadingDialog();
            if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
                AmapGeofencingActivity.this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()), AmapGeofencingActivity.this.mCurrentZoom));
                AmapGeofencingActivity.this.calculateRatio();
            }
        }
    };
    private XQProgressDialog O0000OoO;
    private View O0000Ooo;
    private String O0000o = null;
    private int O0000o0 = R.drawable.geofencing_circle;
    private ImageView O0000o00;
    private TextView O0000o0O;
    private String O0000o0o = null;
    private long O0000oO;
    private String O0000oO0 = null;
    private View O0000oOO;
    private TextView O0000oOo;
    private Locale O0000oo;
    private AMapLocationClientOption O0000oo0;
    private PublishSubject<hpv> O0000ooO;
    public GeocodeSearch geocodeSearch;
    public float mCurrentZoom = 15.0f;
    public AMap mMap;
    public hpv mMyLocation;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000oo = CoreApi.O000000o().O00oOooo();
        if (this.O0000oo == null) {
            this.O0000oo = Locale.getDefault();
        }
        getIntent().getDoubleExtra("extra_data_latitude", 0.0d);
        getIntent().getDoubleExtra("extra_data_longitude", 0.0d);
        this.O00000o0 = (int) getIntent().getFloatExtra("extra_data_radius", -1.0f);
        this.O0000oO0 = getIntent().getStringExtra("extra_data_radius_degree");
        this.O0000o0o = getIntent().getStringExtra("extra_data_sub_title");
        this.O0000o = getIntent().getStringExtra("extra_data_act_name");
        this.O0000oO = getIntent().getLongExtra("extra_data_poid", 0);
        this.O0000O0o = getIntent().getIntExtra("extra_data_min_radius", 500);
        this.O0000OOo = getIntent().getIntExtra("extra_data_max_radius", 2000);
        try {
            MapsInitializer.initialize(this);
            setView(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void setView(Bundle bundle) {
        setContentView((int) R.layout.activity_amap_geo_fencing_layout);
        O000000o(bundle);
        O000000o();
        activate(null);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Bundle bundle) {
        O00000Oo(bundle);
        this.O0000Oo = (ImageView) findViewById(R.id.module_a_3_return_btn);
        ImageView imageView = this.O0000Oo;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    AmapGeofencingActivity.this.setResult(0, null);
                    AmapGeofencingActivity.this.finish();
                }
            });
        }
        this.O0000oOo = (TextView) findViewById(R.id.module_a_3_return_title);
        TextView textView = this.O0000oOo;
        if (textView != null) {
            textView.setText((int) R.string.select_loc);
        }
        TextView textView2 = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        if (textView2 != null) {
            textView2.setText((int) R.string.confirm);
            this.O00000oO = textView2;
        }
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.amappoi.$$Lambda$AmapGeofencingActivity$1eJNQlcN73vyMYkP5b72M3jv8Vo */

                public final void onClick(View view) {
                    AmapGeofencingActivity.this.O000000o(view);
                }
            });
        }
        this.O0000Ooo = findViewById(R.id.radius_parent);
        this.O0000o00 = (ImageView) findViewById(R.id.geo_fencing_circle);
        this.O0000o0O = (TextView) findViewById(R.id.radius);
        View findViewById = findViewById(R.id.my_location_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    AmapGeofencingActivity.this.activate(null);
                }
            });
        }
        this.O0000oOO = findViewById(R.id.search_places);
        this.O00000o = (TextView) findViewById(R.id.search_places_tv);
        this.O0000oOO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (AmapGeofencingActivity.this.O00000Oo == null) {
                    hte.O000000o(AmapGeofencingActivity.this, (int) R.string.mj_geo_area_location_failed);
                    return;
                }
                Intent intent = new Intent(AmapGeofencingActivity.this, AmapPoiActivity.class);
                intent.putExtra("map_location", AmapGeofencingActivity.this.O00000Oo);
                if (!TextUtils.isEmpty(AmapGeofencingActivity.this.O00000o.getText())) {
                    intent.putExtra("map_location_name", AmapGeofencingActivity.this.O00000o.getText());
                }
                AmapGeofencingActivity.this.startActivityForResult(intent, 1);
            }
        });
        this.geocodeSearch = new GeocodeSearch(this);
    }

    private void O00000Oo(Bundle bundle) {
        this.f10176O000000o = findViewById(R.id.mapView);
        this.f10176O000000o.onCreate(bundle);
        this.mMap = this.f10176O000000o.getMap();
        UiSettings uiSettings = this.mMap.getUiSettings();
        if (uiSettings != null) {
            uiSettings.setZoomControlsEnabled(true);
            uiSettings.setMyLocationButtonEnabled(false);
        }
        this.mMap.setOnCameraChangeListener(this);
        this.mMap.setMyLocationEnabled(true);
        this.mMap.setLocationSource(this);
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            return;
        }
        if ("zh".equalsIgnoreCase(O00oOooo.getLanguage())) {
            this.mMap.setMapLanguage("zh_cn");
        } else {
            this.mMap.setMapLanguage("en");
        }
    }

    public void calculateRatio() {
        if (this.O0000Ooo != null) {
            this.mCurrentZoom = this.mMap.getCameraPosition().zoom;
            this.O00000o0 = (int) ((this.mMap.getScalePerPixel() * ((float) gpc.O000000o(200.0f))) / 2.0f);
            int i = this.O00000o0;
            if (i > this.O0000OOo) {
                if (this.O0000o0 == R.drawable.geofencing_circle) {
                    this.O0000o0 = R.drawable.geofencing_circle_red;
                    this.O0000o00.setImageResource(this.O0000o0);
                }
                View view = this.O00000oO;
                if (view != null) {
                    view.setEnabled(false);
                }
            } else if (i < this.O0000O0o) {
                if (this.O0000o0 == R.drawable.geofencing_circle) {
                    this.O0000o0 = R.drawable.geofencing_circle_red;
                    this.O0000o00.setImageResource(this.O0000o0);
                }
                View view2 = this.O00000oO;
                if (view2 != null) {
                    view2.setEnabled(false);
                }
            } else {
                if (this.O0000o0 == R.drawable.geofencing_circle_red) {
                    this.O0000o0 = R.drawable.geofencing_circle;
                    this.O0000o00.setImageResource(this.O0000o0);
                }
                View view3 = this.O00000oO;
                if (view3 != null) {
                    view3.setEnabled(true);
                }
            }
            TextView textView = this.O0000o0O;
            Resources resources = getResources();
            int i2 = this.O00000o0;
            textView.setText(resources.getQuantityString(R.plurals.distance_in_meter, i2, Integer.valueOf(i2)));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            LocationBean locationBean = (LocationBean) intent.getParcelableExtra("map_location");
            this.O00000Oo.setLongitude(locationBean.f10197O000000o);
            this.O00000Oo.setLatitude(locationBean.O00000Oo);
            this.O00000Oo.setProvince(locationBean.O00000oO);
            this.O00000Oo.setCity(locationBean.O00000oo);
            this.O00000Oo.setDistrict(locationBean.O0000O0o);
            if (locationBean != null) {
                O000000o(locationBean);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(LocationBean locationBean) {
        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locationBean.O00000Oo, locationBean.f10197O000000o), this.mCurrentZoom));
        this.O00000o.setText(locationBean.O00000o);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getId() != R.id.lv_data) {
            List<LocationBean> list = hbu.O000000o(this).f18758O000000o;
            this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(list.get(i).O00000Oo, list.get(i).f10197O000000o), 15.0f));
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        this.O0000OoO = new XQProgressDialog(this);
        this.O0000OoO.setCancelable(false);
        this.O0000OoO.setMessage(getResources().getString(R.string.mj_loading));
        this.O0000OoO.show();
        this.O0000OoO.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass5 */

            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
    }

    public void dismissLoadingDialog() {
        XQProgressDialog xQProgressDialog = this.O0000OoO;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        calculateRatio();
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        hpv hpv = new hpv(cameraPosition.target.latitude, cameraPosition.target.longitude);
        this.O00000Oo.setLatitude(cameraPosition.target.latitude);
        this.O00000Oo.setLongitude(cameraPosition.target.longitude);
        if (this.O0000ooO == null) {
            this.O0000ooO = PublishSubject.create();
            this.O0000ooO.debounce(800, TimeUnit.MILLISECONDS).switchMap(new Function<hpv, ObservableSource<RegeocodeAddress>>() {
                /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass7 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    return AmapGeofencingActivity.this.getSearchObservable((hpv) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<RegeocodeAddress>() {
                /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass6 */

                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final /* synthetic */ void onNext(Object obj) {
                    AmapGeofencingActivity.this.updateSearchTv((RegeocodeAddress) obj);
                }
            });
        }
        this.O0000ooO.onNext(hpv);
    }

    public Observable<RegeocodeAddress> getSearchObservable(final hpv hpv) {
        return Observable.create(new ObservableOnSubscribe<RegeocodeAddress>() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity.AnonymousClass8 */

            public final void subscribe(ObservableEmitter<RegeocodeAddress> observableEmitter) throws Exception {
                new ArrayList();
                try {
                    RegeocodeAddress fromLocation = AmapGeofencingActivity.this.geocodeSearch.getFromLocation(new RegeocodeQuery(new LatLonPoint(hpv.O00000Oo, hpv.f511O000000o), 200.0f, "autonavi"));
                    if (!AmapGeofencingActivity.this.isValid()) {
                        observableEmitter.onComplete();
                        return;
                    }
                    observableEmitter.onNext(fromLocation);
                    observableEmitter.onComplete();
                } catch (AMapException unused) {
                    observableEmitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    /* access modifiers changed from: protected */
    public void updateSearchTv(RegeocodeAddress regeocodeAddress) {
        if (isValid()) {
            this.O00000Oo.setProvince(regeocodeAddress.getProvince());
            this.O00000Oo.setCity(regeocodeAddress.getCity());
            this.O00000Oo.setDistrict(regeocodeAddress.getDistrict());
            this.O00000o.setText(regeocodeAddress.getFormatAddress());
        }
    }

    public void onResume() {
        super.onResume();
        this.f10176O000000o.onResume();
    }

    public void onPause() {
        super.onPause();
        this.f10176O000000o.onPause();
        this.O00000oo.stopLocation();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f10176O000000o.onSaveInstanceState(bundle);
    }

    public void onDestroy() {
        this.f10176O000000o.onDestroy();
        AMapLocationClient aMapLocationClient = this.O00000oo;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.O00000oo.onDestroy();
        }
        super.onDestroy();
    }

    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        if (this.O00000oo == null) {
            this.O00000oo = new AMapLocationClient(this);
            this.O0000oo0 = new AMapLocationClientOption();
            this.O0000oo0.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            this.O0000oo0.setNeedAddress(true);
            this.O0000oo0.setOnceLocation(true);
        }
        if (hbt.O000000o(this.O0000oo, Locale.CHINA)) {
            this.O0000oo0.setGeoLanguage(AMapLocationClientOption.GeoLanguage.ZH);
        } else {
            this.O0000oo0.setGeoLanguage(AMapLocationClientOption.GeoLanguage.EN);
        }
        this.O00000oo.setLocationListener(this.O0000Oo0);
        this.O00000oo.setLocationOption(this.O0000oo0);
        this.O00000oo.startLocation();
    }

    public void deactivate() {
        AMapLocationClient aMapLocationClient = this.O00000oo;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.O00000oo.onDestroy();
        }
        this.O00000oo = null;
    }

    public void onBackPressed() {
        setResult(0, null);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        Intent intent = new Intent();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("longitude", this.O00000Oo.getLongitude());
            jSONObject.put("latitude", this.O00000Oo.getLatitude());
            jSONObject.put("radius", this.O00000o0);
            if (!TextUtils.isEmpty(this.O0000o)) {
                jSONObject.put("act_name", this.O0000o);
            }
            if (!TextUtils.isEmpty(this.O0000oO0)) {
                jSONObject.put("radius_degree", this.O0000oO0);
            }
            intent.putExtra("value", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CharSequence charSequence = "";
        if (!TextUtils.isEmpty(this.O0000o0o)) {
            String str = this.O0000o0o;
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(this.O00000o.getText()) ? charSequence : this.O00000o.getText();
            intent.putExtra("key_name", String.format(str, objArr));
        }
        if (!TextUtils.isEmpty(this.O00000o.getText())) {
            charSequence = this.O00000o.getText();
        }
        intent.putExtra("poi_name", charSequence);
        long j = this.O0000oO;
        if (j > 0) {
            intent.putExtra("extra_data_poid", j);
        }
        setResult(-1, intent);
        finish();
    }
}
