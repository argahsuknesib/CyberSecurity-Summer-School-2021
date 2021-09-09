package com.xiaomi.smarthome.newui.amappoi;

import _m_j.gfr;
import _m_j.gsy;
import _m_j.hbv;
import _m_j.hte;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.location.AMapLocation;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmapPoiActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private PublishSubject<String> f10185O000000o;
    private CompositeDisposable O00000Oo;
    public AMapLocation aMapLocation;
    public ListView lv_data;
    public View mClearContent;
    public View mEditBg;
    public EditText mEditText;
    public O000000o poiAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_amap_poi_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.aMapLocation = (AMapLocation) intent.getParcelableExtra("map_location");
        }
        if (this.aMapLocation == null) {
            finish();
            return;
        }
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AmapPoiActivity.this.finish();
            }
        });
        this.lv_data = (ListView) findViewById(R.id.lv_data);
        this.poiAdapter = new O000000o();
        this.lv_data.setOnItemClickListener(this);
        this.lv_data.setAdapter((ListAdapter) this.poiAdapter);
        this.mClearContent = findViewById(R.id.img_search_content_clear);
        this.mEditBg = findViewById(R.id.search_places);
        this.mEditText = (EditText) findViewById(R.id.search_et);
        this.mEditText.requestFocus();
        this.mEditText.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass2 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (i3 > 0 && AmapPoiActivity.this.mClearContent.getVisibility() == 8) {
                    AmapPoiActivity.this.mClearContent.setVisibility(0);
                } else if (i3 <= 0 && AmapPoiActivity.this.mClearContent.getVisibility() == 0) {
                    AmapPoiActivity.this.mClearContent.setVisibility(8);
                }
            }
        });
        this.mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass3 */

            public final void onFocusChange(View view, boolean z) {
                if (AmapPoiActivity.this.mEditBg == null) {
                    return;
                }
                if (z) {
                    AmapPoiActivity.this.mEditBg.setBackgroundResource(R.drawable.bg_10_bgcolor_white_stroke_green);
                } else {
                    AmapPoiActivity.this.mEditBg.setBackgroundResource(R.drawable.bg_10_bgcolorf5f5f5);
                }
            }
        });
        this.mClearContent.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass4 */

            public final void onClick(View view) {
                if (AmapPoiActivity.this.mEditText != null) {
                    AmapPoiActivity.this.mEditText.setText("");
                }
            }
        });
        this.f10185O000000o = PublishSubject.create();
        this.f10185O000000o.debounce(400, TimeUnit.MILLISECONDS).filter(new Predicate<String>() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass7 */

            public final /* synthetic */ boolean test(Object obj) throws Exception {
                return ((String) obj).length() >= 0;
            }
        }).switchMap(new Function<String, ObservableSource<List<LocationBean>>>() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass6 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return AmapPoiActivity.this.getSearchObservable((String) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<List<LocationBean>>() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass5 */

            public final void onComplete() {
            }

            public final void onError(Throwable th) {
            }

            public final /* synthetic */ void onNext(Object obj) {
                List<LocationBean> list = (List) obj;
                O000000o o000000o = AmapPoiActivity.this.poiAdapter;
                o000000o.f10195O000000o = list;
                if (list.size() > 0) {
                    AmapPoiActivity.this.lv_data.setVisibility(0);
                } else {
                    if (gfr.O0000OOo) {
                        hte.O00000Oo(AmapPoiActivity.this, R.string.mj_common_no);
                    }
                    AmapPoiActivity.this.lv_data.setVisibility(8);
                }
                AmapPoiActivity.this.poiAdapter.notifyDataSetChanged();
            }
        });
        this.O00000Oo = new CompositeDisposable();
        CompositeDisposable compositeDisposable = this.O00000Oo;
        compositeDisposable.add(compositeDisposable);
        this.mEditText.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass8 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AmapPoiActivity.this.startSearch(charSequence.toString());
            }
        });
        this.mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.$$Lambda$AmapPoiActivity$FXaiYhU4nFCXc_kA9DGTTKmfBZ0 */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return AmapPoiActivity.this.O000000o(textView, i, keyEvent);
            }
        });
        String stringExtra = getIntent().getStringExtra("map_location_name");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mEditText.setText(stringExtra);
            this.mEditText.setSelection(stringExtra.length());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O000000o(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        Editable text = this.mEditText.getText();
        if (text == null || TextUtils.isEmpty(text.toString())) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                return true;
            }
            inputMethodManager.hideSoftInputFromWindow(this.mEditText.getWindowToken(), 2);
            return true;
        }
        startSearch(text.toString().trim());
        return true;
    }

    public void startSearch(String str) {
        PublishSubject<String> publishSubject = this.f10185O000000o;
        if (publishSubject != null) {
            publishSubject.onNext(str);
        }
    }

    public Observable<List<LocationBean>> getSearchObservable(final String str) {
        return Observable.create(new ObservableOnSubscribe<List<LocationBean>>() {
            /* class com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity.AnonymousClass9 */

            public final void subscribe(ObservableEmitter<List<LocationBean>> observableEmitter) throws Exception {
                gsy.O00000Oo("Geo", "开始请求，关键词为：" + str);
                ArrayList<LocationBean> arrayList = new ArrayList<>();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                    hbv O000000o2 = hbv.O000000o(AmapPoiActivity.this);
                    String str = str;
                    String cityCode = AmapPoiActivity.this.aMapLocation.getCityCode();
                    AmapPoiActivity.this.aMapLocation.getLatitude();
                    AmapPoiActivity.this.aMapLocation.getLongitude();
                    arrayList = O000000o2.O000000o(str, cityCode, AmapPoiActivity.this.aMapLocation);
                    if (!AmapPoiActivity.this.isValid()) {
                        observableEmitter.onComplete();
                        return;
                    }
                }
                gsy.O00000Oo("Geo", "结束请求，关键词为：" + str);
                if (arrayList != null) {
                    observableEmitter.onNext(arrayList);
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getId() == R.id.lv_data) {
            Intent intent = new Intent();
            intent.putExtra("map_location", (LocationBean) this.poiAdapter.getItem(i));
            setResult(-1, intent);
            finish();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000Oo.clear();
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        List<LocationBean> f10195O000000o = new ArrayList();

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o() {
        }

        public final int getCount() {
            return this.f10195O000000o.size();
        }

        public final Object getItem(int i) {
            return this.f10195O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C0087O000000o o000000o;
            if (view == null) {
                o000000o = new C0087O000000o(this, (byte) 0);
                view2 = AmapPoiActivity.this.getLayoutInflater().inflate((int) R.layout.app_list_item_poi, viewGroup, false);
                o000000o.f10196O000000o = (TextView) view2.findViewById(R.id.address);
                o000000o.O00000Oo = (TextView) view2.findViewById(R.id.desc);
                view2.setTag(o000000o);
            } else {
                view2 = view;
                o000000o = (C0087O000000o) view.getTag();
            }
            LocationBean locationBean = (LocationBean) getItem(i);
            if (TextUtils.isEmpty(locationBean.O00000o0)) {
                o000000o.f10196O000000o.setVisibility(8);
            } else {
                o000000o.f10196O000000o.setVisibility(0);
                o000000o.f10196O000000o.setText(locationBean.O00000o0);
            }
            o000000o.O00000Oo.setText(locationBean.O00000o);
            return view2;
        }

        /* renamed from: com.xiaomi.smarthome.newui.amappoi.AmapPoiActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0087O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public TextView f10196O000000o;
            public TextView O00000Oo;

            private C0087O000000o() {
            }

            /* synthetic */ C0087O000000o(O000000o o000000o, byte b) {
                this();
            }
        }
    }
}
