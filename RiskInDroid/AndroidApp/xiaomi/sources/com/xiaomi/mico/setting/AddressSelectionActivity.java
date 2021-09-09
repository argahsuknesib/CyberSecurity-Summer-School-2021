package com.xiaomi.mico.setting;

import _m_j.bni;
import _m_j.bnn;
import _m_j.bno;
import _m_j.oOOO00o0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.PermissionHelper;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.address.POIInfoWrapper;
import com.xiaomi.mico.setting.address.POIProvider;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class AddressSelectionActivity extends MicoBaseActivity {
    EditText address;
    Button city;
    ListView listview;
    public AddressAdapter mAdapter;
    public String mGpsCity;
    public LocationListener mLocationListener;
    private PermissionHelper mPermissionHelper;
    public POIProvider mProvider = POIProvider.BAIDU;
    ViewGroup searchContainer;
    TitleBar titleBar;

    public boolean needFitsSystemWindows() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_address_selection);
        this.city = (Button) findViewById(R.id.city);
        this.city.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$AddressSelectionActivity$BXoaUrEzic9U3pQtZ9JZLALHdxU */

            public final void onClick(View view) {
                AddressSelectionActivity.this.lambda$onCreate$0$AddressSelectionActivity(view);
            }
        });
        this.address = (EditText) findViewById(R.id.address);
        this.searchContainer = (ViewGroup) findViewById(R.id.search_container);
        this.listview = (ListView) findViewById(R.id.listview);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                AddressSelectionActivity.this.setResult(0);
                AddressSelectionActivity.this.finish();
            }
        });
        if (!TextUtils.isEmpty(getIntent().getStringExtra("custome_title"))) {
            this.titleBar.setTitle(getIntent().getStringExtra("custome_title"));
        }
        this.mAdapter = new AddressAdapter();
        this.listview.setAdapter((ListAdapter) this.mAdapter);
        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass2 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                intent.putExtra("SELECTED_ADDRESS", ((POIInfoWrapper) adapterView.getItemAtPosition(i)).getOrigin());
                AddressSelectionActivity.this.setResult(-1, intent);
                AddressSelectionActivity.this.finish();
            }
        });
        this.mPermissionHelper = new PermissionHelper(this).withPermission("android.permission.ACCESS_FINE_LOCATION", R.string.permission_fine_location, R.string.permission_fine_location, true).listener(new PermissionHelper.Listener() {
            /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass3 */

            public void onGoToSetting() {
            }

            public void onPermissionDenied(String str) {
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int
             arg types: [android.app.Activity, java.lang.String]
             candidates:
              _m_j.oOOO00o0.O000000o(android.app.Activity, _m_j.d):void
              _m_j.oOOO00o0.O000000o(android.app.Activity, java.lang.String):boolean
              androidx.core.content.ContextCompat.O000000o(android.content.Context, int):android.graphics.drawable.Drawable
              androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.Class):T
              androidx.core.content.ContextCompat.O000000o(android.content.Context, java.lang.String):int */
            @SuppressLint({"MissingPermission"})
            public void onAllPermissionGranted() {
                if (oOOO00o0.O000000o((Context) AddressSelectionActivity.this.getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    AddressSelectionActivity.this.city.setText((int) R.string.city_select_unknown);
                } else {
                    AddressSelectionActivity.this.getCurrentCity();
                }
            }
        });
        if (getIntent().getStringExtra("pod_provider") != null) {
            this.mProvider = POIProvider.valueOf(getIntent().getStringExtra("pod_provider"));
        }
        if (getIntent().getSerializableExtra("SELECTED_ADDRESS") != null) {
            POIInfoWrapper wrapper = this.mProvider.getWrapper(getIntent().getSerializableExtra("SELECTED_ADDRESS"));
            this.city.setText(wrapper.getCity());
            this.address.setText(wrapper.getDisplayAddress());
            EditText editText = this.address;
            editText.setSelection(editText.getText().length());
            if (TextUtils.isEmpty(wrapper.getCity()) && TextUtils.isEmpty(wrapper.getDisplayAddress())) {
                this.mPermissionHelper.check();
            }
        } else {
            this.mPermissionHelper.check();
        }
        EditText editText2 = this.address;
        bni.O000000o(editText2, "view == null");
        Observable.create(new bno(editText2)).filter(new Func1() {
            /* class com.xiaomi.mico.setting.$$Lambda$AddressSelectionActivity$5nCtcFXaQeP6vK6b2H2lrG_WxkQ */

            public final Object call(Object obj) {
                return AddressSelectionActivity.this.lambda$onCreate$1$AddressSelectionActivity((bnn) obj);
            }
        }).debounce(300, TimeUnit.MILLISECONDS).flatMap(new Func1<bnn, Observable<List<POIInfoWrapper>>>() {
            /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass5 */

            public Observable<List<POIInfoWrapper>> call(bnn bnn) {
                return AddressSelectionActivity.this.mProvider.search(AddressSelectionActivity.this.getContext(), AddressSelectionActivity.this.city.getText().toString(), AddressSelectionActivity.this.address.getText().toString());
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<POIInfoWrapper>>() {
            /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((List<POIInfoWrapper>) ((List) obj));
            }

            public void call(List<POIInfoWrapper> list) {
                if (list != null) {
                    AddressSelectionActivity.this.mAdapter.refreshData(list);
                }
            }
        }, $$Lambda$AddressSelectionActivity$GmbKVxqHVnDMZbj9Voa8VH0DLvs.INSTANCE);
        this.mGpsCity = getString(R.string.city_select_unknown);
    }

    public /* synthetic */ void lambda$onCreate$0$AddressSelectionActivity(View view) {
        onViewClicked();
    }

    public /* synthetic */ Boolean lambda$onCreate$1$AddressSelectionActivity(bnn bnn) {
        return Boolean.valueOf(!TextUtils.isEmpty(this.address.getText().toString()));
    }

    public void getCurrentCity() {
        final LocationManager locationManager = (LocationManager) getSystemService("location");
        this.mLocationListener = new LocationListener() {
            /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass6 */

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @SuppressLint({"MissingPermission"})
            public void onLocationChanged(final Location location) {
                locationManager.removeUpdates(AddressSelectionActivity.this.mLocationListener);
                Observable.unsafeCreate(new Observable.OnSubscribe<Address>() {
                    /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass6.AnonymousClass3 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super Address>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super Address> subscriber) {
                        try {
                            subscriber.onNext(new Geocoder(AddressSelectionActivity.this.getContext(), Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 10).get(0));
                            subscriber.onCompleted();
                        } catch (IOException e) {
                            subscriber.onError(e);
                        }
                    }
                }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Address>() {
                    /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass6.AnonymousClass1 */

                    public void call(Address address) {
                        AddressSelectionActivity.this.mGpsCity = address.getAdminArea();
                        AddressSelectionActivity.this.city.setText(address.getAdminArea());
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.setting.AddressSelectionActivity.AnonymousClass6.AnonymousClass2 */

                    public void call(Throwable th) {
                    }
                });
            }

            public void onProviderDisabled(String str) {
                AddressSelectionActivity.this.city.setText((int) R.string.city_select_unknown);
            }
        };
        locationManager.requestLocationUpdates("network", 0, 0.0f, this.mLocationListener);
    }

    public void onViewClicked() {
        Intent intent = new Intent(this, CitySelectActivity.class);
        intent.putExtra("current_city", this.mGpsCity);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            this.city.setText(intent.getStringExtra("selected_city"));
            this.address.setText("");
            this.mAdapter.refreshData(null);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mPermissionHelper.onRequestPermissionsResult(i, strArr, iArr);
    }

    class AddressAdapter extends BaseAdapter implements Filterable {
        private List<POIInfoWrapper> data;

        public Filter getFilter() {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        AddressAdapter() {
        }

        public int getCount() {
            List<POIInfoWrapper> list = this.data;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void refreshData(List<POIInfoWrapper> list) {
            this.data = list;
            notifyDataSetChanged();
        }

        public Object getItem(int i) {
            return this.data.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(AddressSelectionActivity.this.getContext()).inflate((int) R.layout.activity_address_selection_item, (ViewGroup) null);
                view.setTag(new AddressItemViewHolder(view));
            }
            POIInfoWrapper pOIInfoWrapper = (POIInfoWrapper) getItem(i);
            AddressItemViewHolder addressItemViewHolder = (AddressItemViewHolder) view.getTag();
            addressItemViewHolder.title.setText(pOIInfoWrapper.getName());
            addressItemViewHolder.description.setText(pOIInfoWrapper.getDesc());
            return view;
        }
    }

    class AddressItemViewHolder {
        TextView description;
        TextView title;

        AddressItemViewHolder(View view) {
            this.title = (TextView) view.findViewById(R.id.title);
            this.description = (TextView) view.findViewById(R.id.description);
        }
    }
}
