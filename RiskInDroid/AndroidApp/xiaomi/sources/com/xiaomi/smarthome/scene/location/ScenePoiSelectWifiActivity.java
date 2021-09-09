package com.xiaomi.smarthome.scene.location;

import _m_j.fnn;
import _m_j.gqg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.scene.location.model.WifiGroupData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

public class ScenePoiSelectWifiActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f11142O000000o = false;
    private List<WifiConfiguration> O00000Oo = new ArrayList();
    private WifiGroupData O00000o;
    private View O00000o0;
    private O000000o O00000oO;
    private String O00000oo;
    private BroadcastReceiver O0000O0o = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                action.equals("android.net.wifi.SCAN_RESULTS");
            } else if (ScenePoiSelectWifiActivity.this.mWifiManager.getWifiState() == 3) {
                ScenePoiSelectWifiActivity.this.mListView.O000000o();
            }
        }
    };
    private Map<String, String> O0000OOo = new HashMap();
    public XQProgressDialog mDialog;
    public List<String> mDisplayListData = new ArrayList();
    public List<String> mListData = new ArrayList();
    public PullDownDragListView mListView;
    public ArrayList<String> mSelectedData = new ArrayList<>();
    public WifiManager mWifiManager;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.wifi_group_choose_list);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        Intent intent = getIntent();
        if (intent != null) {
            this.O00000o = (WifiGroupData) intent.getParcelableExtra("data");
            this.O00000oo = intent.getStringExtra("mode");
        }
        if (!this.mWifiManager.isWifiEnabled()) {
            registerReceiver(this.O0000O0o, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
            new MLAlertDialog.Builder(this).O00000Oo((int) R.string.close_wifi_message).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ScenePoiSelectWifiActivity scenePoiSelectWifiActivity = ScenePoiSelectWifiActivity.this;
                    scenePoiSelectWifiActivity.mDialog = new XQProgressDialog(scenePoiSelectWifiActivity);
                    ScenePoiSelectWifiActivity.this.mDialog.setMessage(ScenePoiSelectWifiActivity.this.getString(R.string.wifi_setting_wifi_opening));
                    ScenePoiSelectWifiActivity.this.mDialog.setCancelable(false);
                    ScenePoiSelectWifiActivity.this.mDialog.show();
                    ScenePoiSelectWifiActivity.this.mWifiManager.setWifiEnabled(true);
                    ScenePoiSelectWifiActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            ScenePoiSelectWifiActivity.this.mDialog.dismiss();
                            new MLAlertDialog.Builder(ScenePoiSelectWifiActivity.this).O00000Oo((int) R.string.close_wifi_failed).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ScenePoiSelectWifiActivity.this.finish();
                                }
                            }).O000000o(false).O00000oo();
                        }
                    }, 20000);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ScenePoiSelectWifiActivity.this.finish();
                }
            }).O000000o(false).O00000oo();
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (textView != null) {
            textView.setText((int) R.string.scene_enter_or_leave_wifi);
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ScenePoiSelectWifiActivity.this.setResult(0);
                ScenePoiSelectWifiActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        textView2.setText((int) R.string.next_button);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass3 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < ScenePoiSelectWifiActivity.this.mSelectedData.size(); i++) {
                    int indexOf = ScenePoiSelectWifiActivity.this.mListData.indexOf(ScenePoiSelectWifiActivity.this.mSelectedData.get(i));
                    if (indexOf >= 0) {
                        jSONArray.put(ScenePoiSelectWifiActivity.this.mListData.get(indexOf));
                    }
                }
                intent.putExtra("value", jSONArray.toString());
                if (jSONArray.length() > 0) {
                    intent.putExtra("name", jSONArray.optString(0));
                }
                intent.putExtra("wifi_size", jSONArray.length());
                ScenePoiSelectWifiActivity.this.setResult(-1, intent);
                ScenePoiSelectWifiActivity.this.finish();
            }
        });
        this.O00000o0 = findViewById(R.id.common_white_empty_view);
        this.mListView = (PullDownDragListView) findViewById(R.id.wifi_list);
        this.O00000oO = new O000000o();
        this.mListView.addHeaderView(LayoutInflater.from(this).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.mListView, false));
        this.mListView.setAdapter((ListAdapter) this.O00000oO);
        this.mListView.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.AnonymousClass4 */

            public final void startRefresh() {
            }
        });
        O000000o();
    }

    private void O000000o() {
        if (this.mWifiManager.isWifiEnabled()) {
            List<WifiConfiguration> configuredNetworks = this.mWifiManager.getConfiguredNetworks();
            HashSet hashSet = new HashSet();
            if (configuredNetworks != null) {
                for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                    hashSet.add(convertToQuotedString(wifiConfiguration.SSID));
                }
            }
            List<String> arrayList = new ArrayList<>();
            HashMap hashMap = new HashMap();
            WifiGroupData wifiGroupData = this.O00000o;
            if (!(wifiGroupData == null || (arrayList = wifiGroupData.O00000Oo) == null || arrayList.size() <= 0)) {
                for (String str : arrayList) {
                    hashMap.put(str, str);
                }
            }
            String str2 = null;
            WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                str2 = convertToQuotedString(connectionInfo.getSSID());
                hashSet.remove(str2);
            }
            if (arrayList != null && arrayList.size() > 0) {
                for (String remove : arrayList) {
                    hashSet.remove(remove);
                }
            }
            Map<String, String> O00000Oo2 = O00000Oo();
            if (O00000Oo2 != null && O00000Oo2.size() > 0) {
                for (String remove2 : O00000Oo2.keySet()) {
                    hashSet.remove(remove2);
                }
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        String remove3 = O00000Oo2.remove(str3);
                        if (!TextUtils.isEmpty(remove3)) {
                            hashMap.put(str3, remove3);
                        }
                    }
                }
                if (!O00000Oo2.isEmpty()) {
                    this.mDisplayListData.addAll(0, O00000Oo2.values());
                    this.mListData.addAll(0, O00000Oo2.keySet());
                }
            }
            this.mDisplayListData.addAll(hashSet);
            this.mListData.addAll(hashSet);
            if (arrayList != null && !TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                this.mDisplayListData.add(0, str2);
                this.mListData.add(0, str2);
            }
            if (!(this.O00000o == null || arrayList == null || arrayList.size() <= 0)) {
                ArrayList arrayList2 = new ArrayList();
                for (String str4 : arrayList) {
                    arrayList2.add(hashMap.get(str4));
                }
                this.mDisplayListData.addAll(0, arrayList2);
                this.mListData.addAll(0, arrayList);
                this.mSelectedData.addAll(arrayList);
            }
            if (this.mDisplayListData.size() == 0) {
                this.O00000o0.setVisibility(0);
                this.mListView.setVisibility(8);
                return;
            }
            this.O00000o0.setVisibility(8);
            this.mListView.setVisibility(0);
            this.O00000oO.notifyDataSetChanged();
        }
    }

    private static Map<String, String> O00000Oo() {
        DeviceTagInterface<Device> O00000Oo2 = fnn.O000000o().O00000Oo();
        HashMap hashMap = null;
        if (O00000Oo2 == null) {
            return null;
        }
        Map<String, Set<String>> O000000o2 = O00000Oo2.O000000o(2);
        if (!(O000000o2 == null || O000000o2.size() == 0)) {
            hashMap = new HashMap();
            for (String next : O000000o2.keySet()) {
                String O00000Oo3 = O00000Oo2.O00000Oo(next);
                String O00000oo2 = O00000Oo2.O00000oo(next);
                if (!TextUtils.isEmpty(O00000Oo3)) {
                    hashMap.put(O00000Oo3, O00000oo2);
                }
            }
        }
        return hashMap;
    }

    public static String convertToQuotedString(String str) {
        if (str == null) {
            return "";
        }
        return (str.length() >= 2 && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') ? str.substring(1, str.length() - 1) : str;
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.O0000O0o);
        } catch (Exception unused) {
        }
    }

    class O000000o extends BaseAdapter {
        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        O000000o() {
        }

        public final int getCount() {
            return ScenePoiSelectWifiActivity.this.mDisplayListData.size();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            String str = ScenePoiSelectWifiActivity.this.mDisplayListData.get(i);
            String str2 = ScenePoiSelectWifiActivity.this.mListData.get(i);
            ScenePoiSelectWifiActivity scenePoiSelectWifiActivity = ScenePoiSelectWifiActivity.this;
            int i2 = 0;
            while (true) {
                if (i2 >= scenePoiSelectWifiActivity.mSelectedData.size()) {
                    z = false;
                    break;
                } else if (scenePoiSelectWifiActivity.mSelectedData.get(i2).equals(str2)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (view == null) {
                view = ScenePoiSelectWifiActivity.this.getLayoutInflater().inflate((int) R.layout.wifi_choose_list_item, (ViewGroup) null);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.location.ScenePoiSelectWifiActivity.O000000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        boolean booleanValue = ((Boolean) view.getTag()).booleanValue();
                        if (booleanValue || ScenePoiSelectWifiActivity.this.mSelectedData.size() < 6) {
                            TextView textView = (TextView) view.findViewById(R.id.wifi_text);
                            ImageView imageView = (ImageView) view.findViewById(R.id.select_flag_image);
                            ((CheckBox) view.findViewById(R.id.ratio_btn)).setChecked(!booleanValue);
                            String charSequence = textView.getText().toString();
                            int indexOf = ScenePoiSelectWifiActivity.this.mDisplayListData.indexOf(textView.getText().toString());
                            if (indexOf > 0) {
                                charSequence = ScenePoiSelectWifiActivity.this.mListData.get(indexOf);
                            }
                            if (booleanValue) {
                                view.setTag(Boolean.FALSE);
                                imageView.setImageResource(R.drawable.wifi_check_normal);
                                ScenePoiSelectWifiActivity.this.mSelectedData.remove(charSequence);
                                return;
                            }
                            view.setTag(Boolean.TRUE);
                            imageView.setImageResource(R.drawable.wifi_check_press);
                            ScenePoiSelectWifiActivity.this.mSelectedData.add(charSequence);
                            return;
                        }
                        gqg.O00000Oo((int) R.string.choose_wifi_count_over);
                    }
                });
            }
            TextView textView = (TextView) view.findViewById(R.id.wifi_text);
            if (textView != null) {
                textView.setText(str);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.select_flag_image);
            if (imageView != null) {
                if (z) {
                    imageView.setImageResource(R.drawable.wifi_check_press);
                } else {
                    imageView.setImageResource(R.drawable.wifi_check_normal);
                }
            }
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.ratio_btn);
            checkBox.setChecked(z);
            view.setTag(Boolean.valueOf(z));
            checkBox.setClickable(false);
            return view;
        }
    }
}
