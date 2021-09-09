package com.xiaomi.smarthome.camera.activity.nas;

import _m_j.cit;
import _m_j.ft;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mijia.camera.nas.NASServer;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.CameraPullDownRefreshListView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NASDiscoveryActivity extends CameraBaseActivity {
    private BroadcastReceiver finishReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            NASDiscoveryActivity.this.finish();
        }
    };
    private ImageView ivEmptyIcon;
    private SimpleAdapter mAdapter;
    public List<NASServer> mData = new ArrayList();
    private View mEmptyView;
    public Handler mHandler = new Handler();
    private CameraPullDownRefreshListView mListView;
    public XQProgressDialog mXQProgressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_device_smb_discovery_list);
        initView();
        loadNASServerList();
        ft.O000000o(this).O000000o(this.finishReceiver, new IntentFilter("go_smbinfo_clear_top_activity"));
    }

    public void onDestroy() {
        super.onDestroy();
        XQProgressDialog xQProgressDialog = this.mXQProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mXQProgressDialog.dismiss();
        }
        try {
            ft.O000000o(this).O000000o(this.finishReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.camera.view.CameraPullDownRefreshListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.smb_storage);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.AnonymousClass2 */

            public void onClick(View view) {
                NASDiscoveryActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mListView = (CameraPullDownRefreshListView) findViewById(R.id.list);
        this.mAdapter = new SimpleAdapter();
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mEmptyView = findViewById(R.id.white_empty_view);
        this.ivEmptyIcon = (ImageView) findViewById(R.id.empty_icon);
        this.ivEmptyIcon.setImageResource(this.isV4 ? R.drawable.camera_v4_file_loading_fail : R.drawable.camera_alarm_common_no_bg);
        this.mEmptyView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.AnonymousClass3 */

            public void onClick(View view) {
                NASDiscoveryActivity.this.loadNASServerList();
            }
        });
        initProgressDialog();
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.camera_smb_discovery_list_header, (ViewGroup) this.mListView, false);
        View inflate2 = LayoutInflater.from(this).inflate((int) R.layout.camera_smb_discovery_list_footer, (ViewGroup) this.mListView, false);
        inflate2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.AnonymousClass4 */

            public void onClick(View view) {
            }
        });
        this.mListView.addHeaderView(inflate);
        this.mListView.addFooterView(inflate2);
        this.mListView.setPullDownHeaderVisibility(8);
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void loadNASServerList() {
        this.mXQProgressDialog.show();
        cit O0000oO0 = this.mCameraDevice.O0000oO0();
        O0000oO0.O00000o0.callMethod("nas_scan", new JSONArray(), new Callback<List<NASServer>>(new Callback<List<NASServer>>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.AnonymousClass5 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<NASServer>) ((List) obj));
            }

            public void onSuccess(List<NASServer> list) {
                NASDiscoveryActivity.this.mXQProgressDialog.dismiss();
                if (list != null) {
                    NASDiscoveryActivity.this.mData = list;
                }
                NASDiscoveryActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.AnonymousClass5.AnonymousClass1 */

                    public void run() {
                        if (NASDiscoveryActivity.this.mData.size() == 0) {
                            NASDiscoveryActivity.this.showEmptyView();
                        } else {
                            NASDiscoveryActivity.this.showContentView();
                        }
                    }
                });
            }

            public void onFailure(int i, String str) {
                NASDiscoveryActivity.this.mXQProgressDialog.dismiss();
            }
        }) {
            /* class _m_j.cit.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f13918O000000o;

            {
                this.f13918O000000o = r2;
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                Callback callback = this.f13918O000000o;
                if (callback != null) {
                    callback.onSuccess(list);
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = this.f13918O000000o;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, new Parser<List<NASServer>>() {
            /* class _m_j.cit.AnonymousClass2 */

            public final /* synthetic */ Object parse(String str) throws JSONException {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("result")) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(NASServer.O000000o(optJSONArray.optJSONObject(i)));
                }
                return arrayList;
            }
        });
    }

    public void showEmptyView() {
        this.mEmptyView.setVisibility(0);
        this.mListView.setVisibility(8);
    }

    public void showContentView() {
        this.mEmptyView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.mAdapter.notifyDataSetChanged();
    }

    class SimpleAdapter extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        private SimpleAdapter() {
        }

        public int getCount() {
            return NASDiscoveryActivity.this.mData.size();
        }

        public Object getItem(int i) {
            if (i < 0 || i >= NASDiscoveryActivity.this.mData.size()) {
                return null;
            }
            return NASDiscoveryActivity.this.mData.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(NASDiscoveryActivity.this).inflate((int) R.layout.camera_smb_discovery_list_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) view.findViewById(R.id.device_icon);
                viewHolder.name = (TextView) view.findViewById(R.id.smb_name);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final NASServer nASServer = NASDiscoveryActivity.this.mData.get(i);
            viewHolder.name.setText(nASServer.f5188O000000o);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity.SimpleAdapter.AnonymousClass1 */

                public void onClick(View view) {
                    Intent intent = new Intent(NASDiscoveryActivity.this, NASAddActivity.class);
                    intent.putExtra("data", nASServer);
                    NASDiscoveryActivity.this.startActivity(intent);
                }
            });
            return view;
        }
    }

    class ViewHolder {
        public ImageView icon;
        public TextView name;

        private ViewHolder() {
        }
    }
}
