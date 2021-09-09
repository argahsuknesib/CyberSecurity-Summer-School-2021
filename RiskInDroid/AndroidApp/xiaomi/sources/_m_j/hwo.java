package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.ArrayList;
import java.util.List;

public final class hwo extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public LinearLayout f891O000000o;
    public CustomPullDownRefreshListView O00000Oo;
    public List<dcu> O00000o = new ArrayList();
    public WifiManager O00000o0;
    public BaseAdapter O00000oO = new BaseAdapter() {
        /* class _m_j.hwo.AnonymousClass9 */

        public final long getItemId(int i) {
            return 0;
        }

        public final int getCount() {
            return hwo.this.O00000o.size();
        }

        /* access modifiers changed from: private */
        /* renamed from: O000000o */
        public dcu getItem(int i) {
            return hwo.this.O00000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(hwo.this.O000O0oo).inflate((int) R.layout.miconnect_list_item_choose_wifi, viewGroup, false);
                o000000o = new O000000o();
                o000000o.f902O000000o = (TextView) view.findViewById(R.id.wifi_name);
                o000000o.O00000Oo = (ImageView) view.findViewById(R.id.wifi_signal);
                view.setTag(o000000o);
            } else {
                o000000o = (O000000o) view.getTag();
            }
            final dcu O000000o2 = getItem(i);
            ScanResult scanResult = O000000o2.f14487O000000o;
            o000000o.f902O000000o.setText(scanResult.SSID);
            o000000o.O00000Oo.setImageResource(iag.O000000o(iag.O00000Oo(scanResult.level)));
            view.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hwo.AnonymousClass9.AnonymousClass1 */

                public final void onClick(View view) {
                    dcv.f14488O000000o.O00000o0();
                    hwo.this.O000000o(O000000o2);
                }
            });
            return view;
        }

        /* renamed from: _m_j.hwo$9$O000000o */
        class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public TextView f902O000000o;
            public ImageView O00000Oo;

            O000000o() {
            }
        }
    };
    private Handler O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;
    private BroadcastReceiver O0000Oo = new BroadcastReceiver() {
        /* class _m_j.hwo.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                hwo.this.x_().sendEmptyMessage(100);
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    Message obtainMessage = hwo.this.x_().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.obj = (NetworkInfo) parcelableExtra;
                    hwo.this.x_().sendMessage(obtainMessage);
                }
            } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                hwo.this.x_().sendEmptyMessage(102);
            }
        }
    };
    private boolean O0000Oo0 = false;

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Context context) {
    }

    public final void O000000o(Message message) {
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_CHOOSE_WIFI;
    }

    public final Handler x_() {
        if (this.O00000oo == null) {
            this.O00000oo = new Handler(Looper.getMainLooper()) {
                /* class _m_j.hwo.AnonymousClass2 */

                public final void handleMessage(Message message) {
                    dct.O00000oO("CHOOSE WIFI, handleMessage: " + message.what);
                    int i = message.what;
                    if (i == 99) {
                        hwo.this.x_().removeMessages(99);
                        if (hwo.this.O00000Oo != null && hwo.this.O00000Oo.O00000o) {
                            dct.O00000oO("CHOOSE WIFI, handleMessage: postRefresh");
                            hwo.this.O00000Oo.O00000Oo();
                        }
                    } else if (i == 100) {
                        hwo.this.O00000Oo();
                    }
                }
            };
        }
        return this.O00000oo;
    }

    public final View O00000Oo(Context context) {
        this.O000O0oo = context;
        this.O000OO00 = false;
        this.O000OO0o = false;
        this.O000O0oO = LayoutInflater.from(context.getApplicationContext()).inflate((int) R.layout.miconnect_step_choose_wifi, (ViewGroup) null);
        this.O000O0oo.registerReceiver(this.O0000Oo, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        this.f891O000000o = (LinearLayout) this.O000O0oO.findViewById(R.id.ll_root);
        this.O0000O0o = (TextView) this.O000O0oO.findViewById(R.id.common_tile_tv);
        this.O0000OOo = (TextView) this.O000O0oO.findViewById(R.id.tv_24g_tips);
        this.O00000Oo = (CustomPullDownRefreshListView) this.O000O0oO.findViewById(R.id.listview);
        this.O0000O0o.setText((int) R.string.miconnect_choose_wifi);
        this.O00000Oo.setAdapter((ListAdapter) this.O00000oO);
        this.O00000Oo.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class _m_j.hwo.AnonymousClass3 */

            public final void startRefresh() {
                hwo.this.x_().removeMessages(99);
                hwo.this.x_().sendEmptyMessageDelayed(99, DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS);
                dct.O00000oO("CHOOSE WIFI, startScan");
                hwo.this.O00000o0.startScan();
            }
        });
        this.O000OOOo = (String) htr.O000000o().O000000o("device_model");
        dcv.O00000Oo.O00000o();
        if (this.O000OOOo != null && DeviceFactory.O00000Oo(this.O000OOOo)) {
            this.O0000Oo0 = true;
        }
        if (this.O0000Oo0) {
            this.O0000OOo.setVisibility(8);
        } else {
            this.O0000OOo.setVisibility(0);
        }
        this.O00000o0 = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f891O000000o.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_INPUT_CONFIG);
        return this.O000O0oO;
    }

    public final void O0000O0o() {
        SmartConfigRouterFactory.getStatBindManager().endBindStep(this.O000OOOo, BindStep.STEP_INPUT_CONFIG);
        this.O000O0oo.unregisterReceiver(this.O0000Oo);
        x_().removeMessages(100);
        x_().removeMessages(101);
        x_().removeMessages(99);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.LinearLayout, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(final dcu dcu) {
        dcv.O00000Oo.O00000oO();
        this.O000O0oO.setVisibility(8);
        String O00000o02 = dcp.O000000o().O00000o0(dcu.f14487O000000o.SSID);
        View inflate = LayoutInflater.from(this.O000O0oo).inflate((int) R.layout.dialog_choose_wifi_input, (ViewGroup) this.f891O000000o, false);
        inflate.findViewById(R.id.input_again_root_view).setVisibility(8);
        inflate.findViewById(R.id.wifi_name).setVisibility(0);
        ((TextView) inflate.findViewById(R.id.wifi_name)).setText(dcu.f14487O000000o.SSID);
        ((TextView) inflate.findViewById(R.id.input_again_wifi_name)).setText(dcu.f14487O000000o.SSID);
        final EditText editText = (EditText) inflate.findViewById(R.id.password_input_et);
        ((CheckBox) inflate.findViewById(R.id.change_password_state)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class _m_j.hwo.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                editText.setInputType(z ? 144 : 129);
                EditText editText = editText;
                editText.setSelection(editText.getText().toString().length());
            }
        });
        final Button button = (Button) inflate.findViewById(R.id.right_button);
        button.setEnabled(false);
        final MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this.O000O0oo).O000000o(inflate).O00000o();
        O00000o2.setCanceledOnTouchOutside(false);
        ((Button) inflate.findViewById(R.id.left_button)).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hwo.AnonymousClass5 */

            public final void onClick(View view) {
                if (O00000o2.isShowing()) {
                    O00000o2.dismiss();
                }
                hwo.this.O000O0oO.setVisibility(0);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hwo.AnonymousClass6 */

            public final void onClick(View view) {
                if (O00000o2.isShowing()) {
                    O00000o2.dismiss();
                }
                hwo.this.O000O0oO.setVisibility(0);
                htr.O000000o().O00000Oo("selected_ap", dcu.f14487O000000o);
                htr.O000000o().O00000Oo("selected_ap_ssid", dcu.f14487O000000o.SSID);
                htr.O000000o().O00000Oo("selected_ap_passwd", editText.getText().toString());
                hwo.this.O000O0o();
            }
        });
        if (!TextUtils.isEmpty(O00000o02)) {
            editText.setText(O00000o02);
            button.setEnabled(true);
            button.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg));
        }
        editText.addTextChangedListener(new TextWatcher() {
            /* class _m_j.hwo.AnonymousClass7 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (hwo.this.O000O0oo != null) {
                    if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                        button.setEnabled(false);
                        button.setTextColor(hwo.this.O000O0oo.getResources().getColor(R.color.mj_color_black_30_transparent));
                        return;
                    }
                    button.setEnabled(true);
                    button.setTextColor(hwo.this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg));
                }
            }
        });
        O00000o2.show();
    }

    public final void O00000Oo() {
        gor.O000000o(new AsyncTask<Void, Void, List<dcu>>() {
            /* class _m_j.hwo.AnonymousClass8 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                List list = (List) obj;
                super.onPostExecute(list);
                if (list != null) {
                    ViewGroup.LayoutParams layoutParams = hwo.this.f891O000000o.getLayoutParams();
                    layoutParams.height = -1;
                    hwo.this.f891O000000o.setLayoutParams(layoutParams);
                    hwo.this.O00000Oo.O00000Oo();
                    hwo.this.O00000o.clear();
                    hwo.this.O00000o.addAll(list);
                    hwo.this.O00000oO.notifyDataSetChanged();
                    return;
                }
                hwo.this.O000O0o();
            }

            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x0111 A[SYNTHETIC] */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                String str;
                boolean z;
                boolean z2;
                Context context = hwo.this.O000O0oo;
                List<ScanResult> scanResults = hwo.this.O00000o0.getScanResults();
                WifiInfo connectionInfo = hwo.this.O00000o0.getConnectionInfo();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < scanResults.size(); i++) {
                    ScanResult scanResult = scanResults.get(i);
                    if (!TextUtils.isEmpty(scanResult.SSID) && !DeviceFactory.O0000OOo(scanResult)) {
                        if (connectionInfo == null || !iag.O000000o(connectionInfo.getSSID(), scanResult.SSID) || !iag.O00000o0(scanResult) || scanResult.frequency <= 5000) {
                            str = "";
                        } else {
                            String[] split = scanResult.BSSID.split("\\:");
                            str = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", split[0], split[1], split[2], split[3], split[4], Integer.valueOf(Integer.valueOf(split[5], 16).intValue() - 1));
                        }
                        if (!iag.O000000o(connectionInfo.getSSID(), scanResult.SSID) && !scanResult.BSSID.equalsIgnoreCase(str)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            boolean O00000Oo = DeviceFactory.O00000Oo(hwo.this.O000OOOo);
                            boolean O00000Oo2 = ddd.O00000Oo(context);
                            if ((O00000Oo || !O00000Oo2) && hwo.this.O000000o(scanResult)) {
                                String O000000o2 = ddd.O000000o(context);
                                String O00000o0 = dcp.O000000o().O00000o0(O000000o2);
                                dct.O00000oO("PopUpChooseWifiStep ssid = " + O000000o2 + " pwd = " + O00000o0);
                                if (!TextUtils.isEmpty(O00000o0)) {
                                    htr.O000000o().O00000Oo("selected_ap", scanResult);
                                    htr.O000000o().O00000Oo("selected_ap_ssid", O000000o2);
                                    htr.O000000o().O00000Oo("selected_ap_passwd", O00000o0);
                                    z2 = false;
                                    if (!z2) {
                                        return null;
                                    }
                                }
                            }
                            z2 = true;
                            if (!z2) {
                            }
                        }
                        dcu dcu = new dcu();
                        dcu.f14487O000000o = scanResult;
                        dcu.O00000Oo = scanResult.frequency > 5000;
                        if (hwo.this.O000000o(scanResult)) {
                            dcu.O00000o0 = true;
                            arrayList.add(dcu);
                        } else {
                            dcu.O00000o0 = false;
                            arrayList2.add(dcu);
                        }
                    }
                }
                return arrayList;
            }
        }, new Void[0]);
    }

    public final boolean O000000o(ScanResult scanResult) {
        if (TextUtils.isEmpty(scanResult.SSID) || scanResult.BSSID == null || DeviceFactory.O0000OOo(scanResult) || ((scanResult.frequency > 5000 && !this.O0000Oo0) || scanResult.capabilities.contains("WEP") || scanResult.capabilities.contains("EAP") || scanResult.capabilities.contains("WAPI-KEY") || scanResult.capabilities.contains("WAPI-PSK") || scanResult.capabilities.contains("WAPI-CERT") || iag.O00000Oo(scanResult) == 0 || scanResult.level == 0)) {
            return false;
        }
        return true;
    }
}
