package com.xiaomi.smarthome.nfctag.ui;

import _m_j.dcp;
import _m_j.ddn;
import _m_j.gor;
import _m_j.gqg;
import _m_j.hig;
import _m_j.hih;
import _m_j.iag;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.nfctag.ui.NFCWifiListActivity;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class NFCWifiListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    LinearLayoutManager f10458O000000o;
    private BroadcastReceiver O00000Oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.nfctag.ui.NFCWifiListActivity.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            String action = intent.getAction();
            hih.O000000o("smarthome-nfc", action);
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                NFCWifiListActivity.this.mHandler.sendEmptyMessage(100);
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                Message obtainMessage = NFCWifiListActivity.this.mHandler.obtainMessage();
                obtainMessage.what = 101;
                obtainMessage.obj = (NetworkInfo) parcelableExtra;
                NFCWifiListActivity.this.mHandler.sendMessage(obtainMessage);
            }
        }
    };
    private ConnectivityManager O00000o0;
    public O000000o mAdapter;
    public List<O00000o0> mData = new ArrayList();
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.nfctag.ui.NFCWifiListActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 100) {
                NFCWifiListActivity.this.scanWifi();
            }
        }
    };
    @BindView(5662)
    PtrFrameLayout mPullRefreshLL;
    @BindView(5685)
    RecyclerView mRecyclerList;
    public WifiManager mWifiManager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_nfc_wifi);
        ButterKnife.bind(this);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.nfc_trigger_wifi_action);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWifiListActivity$EKAtwqUucc_mmwkzv4zV18ELGuY */

            public final void onClick(View view) {
                NFCWifiListActivity.this.O000000o(view);
            }
        });
        this.mAdapter = new O000000o(this, (byte) 0);
        this.f10458O000000o = new LinearLayoutManager(this);
        this.mRecyclerList.setLayoutManager(this.f10458O000000o);
        this.mRecyclerList.setAdapter(this.mAdapter);
        this.mWifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        this.O00000o0 = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        registerReceiver(this.O00000Oo, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        this.mPullRefreshLL.setPtrHandler(new PtrHandler() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCWifiListActivity.AnonymousClass3 */

            public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                if (Build.VERSION.SDK_INT < 14) {
                    if (!(view instanceof AbsListView)) {
                        return view instanceof RecyclerView ? NFCWifiListActivity.this.f10458O000000o != null && NFCWifiListActivity.this.f10458O000000o.findFirstCompletelyVisibleItemPosition() - 1 < 0 : view.getScrollY() > 0;
                    }
                    AbsListView absListView = (AbsListView) view;
                    return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                } else if (view instanceof RecyclerView) {
                    return NFCWifiListActivity.this.f10458O000000o != null && NFCWifiListActivity.this.f10458O000000o.findFirstCompletelyVisibleItemPosition() - 1 < 0 && NFCWifiListActivity.this.f10458O000000o.findFirstVisibleItemPosition() - 1 < 0;
                } else {
                    return view.canScrollVertically(-1);
                }
            }

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                NFCWifiListActivity.this.mWifiManager.startScan();
            }
        });
        scanWifi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(100);
        this.mHandler.removeMessages(101);
        unregisterReceiver(this.O00000Oo);
    }

    public void scanWifi() {
        gor.O000000o(new AsyncTask<Void, Void, List<O00000o0>>() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCWifiListActivity.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final void onPreExecute() {
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                List list = (List) obj;
                super.onPostExecute(list);
                hih.O000000o("smarthome-nfc", "size " + list.size());
                NFCWifiListActivity.this.mData.clear();
                NFCWifiListActivity.this.mData.addAll(list);
                NFCWifiListActivity.this.mAdapter.notifyDataSetChanged();
                NFCWifiListActivity.this.mPullRefreshLL.refreshComplete();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                List<ScanResult> scanResults = NFCWifiListActivity.this.mWifiManager.getScanResults();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (scanResults != null) {
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < scanResults.size(); i++) {
                        if (NFCWifiListActivity.this.isSupport(scanResults.get(i))) {
                            String str = scanResults.get(i).SSID + "_" + scanResults.get(i).capabilities;
                            if (!TextUtils.isEmpty(dcp.O000000o().O00000o0(scanResults.get(i).SSID))) {
                                O00000o0 o00000o0 = new O00000o0(scanResults.get(i), WifiManager.calculateSignalLevel(scanResults.get(i).level, 5), true);
                                if (hashMap.containsKey(str)) {
                                    hashMap.remove(str);
                                }
                                hashMap.put(str, o00000o0);
                            }
                            if (!hashMap.containsKey(str)) {
                                hashMap.put(str, new O00000o0(scanResults.get(i), WifiManager.calculateSignalLevel(scanResults.get(i).level, 5), false));
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        for (Map.Entry value : hashMap.entrySet()) {
                            O00000o0 o00000o02 = (O00000o0) value.getValue();
                            if (o00000o02.O00000o) {
                                arrayList.add(o00000o02);
                            } else {
                                arrayList2.add(o00000o02);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0 && arrayList2.size() > 0) {
                    NFCWifiListActivity nFCWifiListActivity = NFCWifiListActivity.this;
                    arrayList.add(0, new O00000o0(nFCWifiListActivity.getString(R.string.nfc_action_wifilist_sub_title1)));
                    NFCWifiListActivity nFCWifiListActivity2 = NFCWifiListActivity.this;
                    arrayList.add(new O00000o0(nFCWifiListActivity2.getString(R.string.nfc_action_wifilist_sub_title2)));
                }
                arrayList.addAll(arrayList2);
                return arrayList;
            }
        }, new Void[0]);
    }

    public void showInputPasswordDialog(final ScanResult scanResult) {
        String O00000o02 = dcp.O000000o().O00000o0(scanResult.SSID);
        ddn ddn = new ddn();
        ddn.setCancelable(false);
        ddn.O00000Oo = scanResult.SSID;
        if (!TextUtils.isEmpty(O00000o02)) {
            ddn.O00000o0 = O00000o02;
        }
        ddn.f14503O000000o = new ddn.O000000o() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCWifiListActivity.AnonymousClass5 */

            public final void O000000o() {
            }

            public final void O000000o(String str) {
                NFCWifiListActivity.this.toNextPage(scanResult.SSID, str);
            }
        };
        ddn.show(getSupportFragmentManager(), "");
    }

    public void toNextPage(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ssid", str);
            jSONObject.put("pass_word", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONObject.keys().hasNext()) {
            Intent intent = new Intent(this, NFCWriteActivity.class);
            hig.f18961O000000o = 5;
            hig.O00000o0 = jSONObject.toString();
            startActivity(intent);
            finish();
            return;
        }
        gqg.O000000o("null params");
    }

    public boolean isSupport(ScanResult scanResult) {
        if (TextUtils.isEmpty(scanResult.SSID) || scanResult.BSSID == null || scanResult.capabilities.contains("WEP") || scanResult.capabilities.contains("EAP") || scanResult.capabilities.contains("WAPI-KEY") || scanResult.capabilities.contains("WAPI-PSK") || scanResult.capabilities.contains("WAPI-CERT") || iag.O00000Oo(scanResult) == 0) {
            return false;
        }
        return true;
    }

    class O000000o extends RecyclerView.O000000o<O00000Oo> {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(NFCWifiListActivity nFCWifiListActivity, byte b) {
            this();
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            O00000o0 o00000o0 = NFCWifiListActivity.this.mData.get(i);
            if (o00000o0 != null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    if (!TextUtils.isEmpty(o00000o0.O00000Oo)) {
                        o00000Oo.f10465O000000o.setText(o00000o0.O00000Oo);
                    } else {
                        o00000Oo.f10465O000000o.setText("");
                    }
                } else if (itemViewType == 1) {
                    if (!TextUtils.isEmpty(o00000o0.f10466O000000o.SSID)) {
                        o00000Oo.f10465O000000o.setText(o00000o0.f10466O000000o.SSID);
                    } else {
                        o00000Oo.f10465O000000o.setText("");
                    }
                    int i2 = o00000o0.O00000o0;
                    if (i2 == 0) {
                        o00000Oo.O00000Oo.setImageResource(R.drawable.nfc_wifi_level0);
                    } else if (i2 == 1) {
                        o00000Oo.O00000Oo.setImageResource(R.drawable.nfc_wifi_level1);
                    } else if (i2 == 2) {
                        o00000Oo.O00000Oo.setImageResource(R.drawable.nfc_wifi_level2);
                    } else if (i2 == 3) {
                        o00000Oo.O00000Oo.setImageResource(R.drawable.nfc_wifi_level3);
                    } else if (i2 != 4) {
                        o00000Oo.O00000Oo.setImageResource(R.drawable.nfc_wifi_level0);
                    } else {
                        o00000Oo.O00000Oo.setImageResource(R.drawable.nfc_wifi_level4);
                    }
                    o00000Oo.itemView.setOnClickListener(new View.OnClickListener(o00000o0) {
                        /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWifiListActivity$O000000o$1L8UifM2xJMagCXI3TTMATb9to */
                        private final /* synthetic */ NFCWifiListActivity.O00000o0 f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            NFCWifiListActivity.O000000o.this.O000000o(this.f$1, view);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(O00000o0 o00000o0, View view) {
            NFCWifiListActivity.this.showInputPasswordDialog(o00000o0.f10466O000000o);
        }

        public final int getItemCount() {
            if (NFCWifiListActivity.this.mData == null) {
                return 0;
            }
            return NFCWifiListActivity.this.mData.size();
        }

        public final int getItemViewType(int i) {
            return !TextUtils.isEmpty(NFCWifiListActivity.this.mData.get(i).O00000Oo) ? 0 : 1;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                NFCWifiListActivity nFCWifiListActivity = NFCWifiListActivity.this;
                return new O00000Oo(nFCWifiListActivity.getLayoutInflater().inflate((int) R.layout.item_nfc_wifi_group, viewGroup, false));
            }
            NFCWifiListActivity nFCWifiListActivity2 = NFCWifiListActivity.this;
            return new O00000Oo(nFCWifiListActivity2.getLayoutInflater().inflate((int) R.layout.item_nfc_wifi_child, viewGroup, false));
        }
    }

    public class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10465O000000o;
        public ImageView O00000Oo;

        public O00000Oo(View view) {
            super(view);
            this.f10465O000000o = (TextView) view.findViewById(R.id.txt_title);
            this.O00000Oo = (ImageView) view.findViewById(R.id.img_level);
        }
    }

    public class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ScanResult f10466O000000o;
        String O00000Oo;
        boolean O00000o;
        int O00000o0;

        public O00000o0(ScanResult scanResult, int i, boolean z) {
            this.O00000o0 = i;
            this.f10466O000000o = scanResult;
            this.O00000o = z;
        }

        public O00000o0(String str) {
            this.O00000Oo = str;
        }
    }
}
