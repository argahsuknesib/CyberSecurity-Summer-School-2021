package com.xiaomi.smarthome.framework.page;

import _m_j.fno;
import _m_j.fum;
import _m_j.fup;
import _m_j.grv;
import _m_j.gsy;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.library.log.LogType;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralOneTimePasswordHistoryActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f7761O000000o;
    @BindView(5357)
    ImageView mBackBt;
    public String mCurrentToken;
    public Device mDevice;
    @BindView(5087)
    View mEmptyView;
    @BindView(5162)
    ImageView mGeneratePwdBtn;
    public int mInterval;
    @BindView(5549)
    ListView mListView;
    public int mPasswordNum;
    @BindView(5528)
    DevicePtrFrameLayout mPullRefresh;
    public String mServiceToken;
    @BindView(5700)
    View mSubTitle;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008f  */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("did");
        this.mInterval = getIntent().getIntExtra("interval", 0);
        this.mPasswordNum = getIntent().getIntExtra("digits", 0);
        this.mDevice = fno.O000000o().O000000o(stringExtra);
        if (this.mDevice == null) {
            gsy.O00000o0(LogType.GENERAL, "", "GeneralOneTimePasswordActivity failed, device don't exist, ".concat(String.valueOf(stringExtra)));
        } else {
            int i = this.mInterval;
            if (i <= 0 || i > 60) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "", "GeneralOneTimePasswordActivity failed, mInterval is invalid, " + this.mInterval);
            } else {
                int i2 = this.mPasswordNum;
                if (i2 < 6 || i2 > 8) {
                    LogType logType2 = LogType.GENERAL;
                    gsy.O00000o0(logType2, "", "GeneralOneTimePasswordActivity failed, mPasswordNum is invalid, " + this.mPasswordNum);
                } else {
                    z = true;
                    if (z) {
                        finish();
                        return;
                    }
                    setContentView((int) R.layout.activity_general_one_time_password_history);
                    ButterKnife.bind(this);
                    this.mBackBt.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass1 */

                        public final void onClick(View view) {
                            GeneralOneTimePasswordHistoryActivity.this.finish();
                        }
                    });
                    this.f7761O000000o = new O000000o(this, (byte) 0);
                    this.mListView.setAdapter((ListAdapter) this.f7761O000000o);
                    this.mPullRefresh = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
                    this.mPullRefresh.disableWhenHorizontalMove(true);
                    this.mPullRefresh.setPullToRefresh(false);
                    this.mPullRefresh.setPtrIndicator(new PtrIndicator());
                    this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass2 */

                        public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                            GeneralOneTimePasswordHistoryActivity.this.startRefresh();
                        }
                    });
                    this.mGeneratePwdBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass3 */

                        public final void onClick(View view) {
                            Intent intent = new Intent(GeneralOneTimePasswordHistoryActivity.this, GeneralOneTimePasswordActivity.class);
                            intent.putExtra("did", GeneralOneTimePasswordHistoryActivity.this.mDevice.did);
                            intent.putExtra("interval", GeneralOneTimePasswordHistoryActivity.this.mInterval);
                            intent.putExtra("digits", GeneralOneTimePasswordHistoryActivity.this.mPasswordNum);
                            GeneralOneTimePasswordHistoryActivity.this.startActivity(intent);
                        }
                    });
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    public void startRefresh() {
        XmPluginHostApi.instance().getUTCFromServer("", new Callback<Long>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                final Long l = (Long) obj;
                XmPluginHostApi.instance().getUserDeviceData(GeneralOneTimePasswordHistoryActivity.this.mDevice.model, GeneralOneTimePasswordHistoryActivity.this.mDevice.did, "prop", "device_lock_token", 0, l.longValue(), new Callback<JSONArray>() {
                    /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass4.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONArray jSONArray = (JSONArray) obj;
                        gsy.O000000o(4, "OneTimePwdHistActivity", " get result =".concat(String.valueOf(jSONArray)));
                        GeneralOneTimePasswordHistoryActivity.this.mCurrentToken = XmBluetoothManager.getInstance().getTokenMd5(GeneralOneTimePasswordHistoryActivity.this.mDevice.mac);
                        if (TextUtils.isEmpty(GeneralOneTimePasswordHistoryActivity.this.mCurrentToken)) {
                            GeneralOneTimePasswordHistoryActivity.this.mCurrentToken = grv.O000000o(GeneralOneTimePasswordHistoryActivity.this.mDevice.token);
                        }
                        if (TextUtils.isEmpty(GeneralOneTimePasswordHistoryActivity.this.mCurrentToken) || GeneralOneTimePasswordHistoryActivity.this.mCurrentToken.length() <= 4) {
                            GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
                            return;
                        }
                        GeneralOneTimePasswordHistoryActivity.this.mCurrentToken = GeneralOneTimePasswordHistoryActivity.this.mCurrentToken.substring(2, GeneralOneTimePasswordHistoryActivity.this.mCurrentToken.length() - 2);
                        if (jSONArray == null || jSONArray.length() == 0) {
                            GeneralOneTimePasswordHistoryActivity.this.uploadToken(l.longValue(), GeneralOneTimePasswordHistoryActivity.this.mCurrentToken);
                            GeneralOneTimePasswordHistoryActivity.this.refreshData(l.longValue());
                            return;
                        }
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(0);
                            GeneralOneTimePasswordHistoryActivity.this.mServiceToken = jSONObject.optString("value", "");
                            if (GeneralOneTimePasswordHistoryActivity.this.mServiceToken.equalsIgnoreCase(GeneralOneTimePasswordHistoryActivity.this.mCurrentToken)) {
                                GeneralOneTimePasswordHistoryActivity.this.refreshData(l.longValue());
                                return;
                            }
                            GeneralOneTimePasswordHistoryActivity.this.deleteHistoryList(l.longValue());
                            GeneralOneTimePasswordHistoryActivity.this.uploadToken(l.longValue(), GeneralOneTimePasswordHistoryActivity.this.mCurrentToken);
                            GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
                        } catch (JSONException e) {
                            GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
                            e.printStackTrace();
                        }
                    }

                    public final void onFailure(int i, String str) {
                        gsy.O000000o(4, "OneTimePwdHistActivity", "get device_lock_token failed, error = " + i + ", msg = " + str);
                        GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
                    }
                });
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(4, "OneTimePwdHistActivity", "refresh failed, error = " + i + ", msg = " + str);
                GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
            }
        });
    }

    public void refreshData(final long j) {
        XmPluginHostApi.instance().getUserDeviceData(this.mDevice.model, this.mDevice.did, "prop", "device_lock", 0, j, new Callback<JSONArray>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                gsy.O000000o(4, "OneTimePwdHistActivity", " get result =".concat(String.valueOf(jSONArray)));
                if (jSONArray != null) {
                    fup.f17194O000000o = fup.O000000o(GeneralOneTimePasswordHistoryActivity.this.mDevice, jSONArray, j);
                    GeneralOneTimePasswordHistoryActivity.this.displayList(fup.f17194O000000o);
                }
                GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(4, "OneTimePwdHistActivity", "getUserDeviceData failed, error = " + i + ", msg = " + str);
                GeneralOneTimePasswordHistoryActivity.this.mPullRefresh.refreshComplete();
            }
        });
    }

    public void uploadToken(long j, String str) {
        XmPluginHostApi.instance().setUserDeviceData(this.mDevice.model, this.mDevice.did, "prop", "device_lock_token", j, str, new Callback<JSONArray>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass6 */

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "OneTimePwdHistActivity", "uploadToken onFailure, error = " + i + ", msg = " + str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gsy.O000000o(6, "OneTimePwdHistActivity", " uploadToken successfully.");
            }
        });
    }

    public void deleteHistoryList(long j) {
        long j2 = j;
        XmPluginHostApi.instance().setUserDeviceData(this.mDevice.model, this.mDevice.did, "prop", "device_lock", j2, new JSONArray(), new Callback<JSONArray>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity.AnonymousClass7 */

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "OneTimePwdHistActivity", "deleteHistoryList onFailure, error = " + i + ", msg = " + str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gsy.O000000o(6, "OneTimePwdHistActivity", " deleteHistoryList successfully.");
            }
        });
    }

    public void displayList(TreeMap<Long, fum> treeMap) {
        ArrayList arrayList = new ArrayList(treeMap.values());
        if (arrayList.size() == 0) {
            this.mEmptyView.setVisibility(0);
            this.mSubTitle.setVisibility(8);
            this.mListView.setVisibility(8);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.mSubTitle.setVisibility(0);
        this.mListView.setVisibility(0);
        O000000o o000000o = this.f7761O000000o;
        o000000o.f7770O000000o.clear();
        o000000o.f7770O000000o.addAll(arrayList);
        o000000o.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        this.mPullRefresh.autoRefresh();
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<fum> f7770O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
            this.f7770O000000o = new ArrayList();
        }

        /* synthetic */ O000000o(GeneralOneTimePasswordHistoryActivity generalOneTimePasswordHistoryActivity, byte b) {
            this();
        }

        public final Object getItem(int i) {
            return this.f7770O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(GeneralOneTimePasswordHistoryActivity.this.getContext()).inflate((int) R.layout.onetimepwd_item_layout, viewGroup, false);
            }
            fum fum = this.f7770O000000o.get(i);
            ((TextView) view.findViewById(R.id.title)).setText(fum.O000000o(fum.O00000Oo) + "~" + fum.O000000o(fum.O00000o0));
            return view;
        }

        public final int getCount() {
            return this.f7770O000000o.size();
        }
    }
}
