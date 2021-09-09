package com.xiaomi.smarthome.framework.update.ui;

import _m_j.ezb;
import _m_j.ezc;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.flk;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gey;
import _m_j.gfa;
import _m_j.gfb;
import _m_j.ggb;
import _m_j.gpv;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gqr;
import _m_j.gsf;
import _m_j.gsy;
import _m_j.gye;
import _m_j.hte;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONObject;

@RouterService
public class ShowFirmwareUpdateActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    private boolean fromGuide;
    private View llNodata;
    private RecyclerView.O000000o mAdapter;
    private String mAutoUpdateDialogTips;
    public boolean mAutoUpgradeSwitch;
    public View mHeaderView;
    private RelativeLayout mRlPushLayout;
    public SwitchButton mSBAuto;
    public SwitchButton mSBPush;
    public boolean mUserSetSwitch = true;
    private RecyclerView recycler;
    private TextView tvAutoContent;
    private View tvContent;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.mj_activity_title_list);
        this.recycler = (RecyclerView) findViewById(R.id.recycler);
        final ArrayList arrayList = new ArrayList();
        this.llNodata = findViewById(R.id.llNodata);
        this.tvContent = findViewById(R.id.tv_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.$$Lambda$ShowFirmwareUpdateActivity$WryVTDzaoypCk8eeZfYcIpXaWsc */

            public final void onClick(View view) {
                ShowFirmwareUpdateActivity.this.lambda$onCreate$0$ShowFirmwareUpdateActivity(view);
            }
        });
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("device_list");
        this.fromGuide = getIntent().getBooleanExtra("from_guide", false);
        if (parcelableArrayListExtra != null) {
            arrayList.addAll(parcelableArrayListExtra);
        }
        this.recycler.setLayoutManager(new LinearLayoutManager(this));
        this.mHeaderView = LayoutInflater.from(this).inflate((int) R.layout.include_fireware_auto_update_list_header, (ViewGroup) null);
        this.mRlPushLayout = (RelativeLayout) this.mHeaderView.findViewById(R.id.rl_push_layout);
        this.tvAutoContent = (TextView) this.mHeaderView.findViewById(R.id.tv_auto_content);
        this.mSBAuto = (SwitchButton) this.mHeaderView.findViewById(R.id.sb_autoupdate);
        this.mSBAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.$$Lambda$YjSnowzzS_Tuao8ipBaDo3wmKEE */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ShowFirmwareUpdateActivity.this.onCheckedChanged(compoundButton, z);
            }
        });
        this.mSBPush = (SwitchButton) this.mHeaderView.findViewById(R.id.sb_push);
        this.mSBPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.update.ui.$$Lambda$YjSnowzzS_Tuao8ipBaDo3wmKEE */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ShowFirmwareUpdateActivity.this.onCheckedChanged(compoundButton, z);
            }
        });
        this.mAdapter = new ezb<KeyValuePair>(this, arrayList) {
            /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass1 */

            public final int O00000o0(int i) {
                return R.layout.mj_item_choose_device;
            }

            @SuppressLint({"SetTextI18n"})
            public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
                String str;
                KeyValuePair keyValuePair = (KeyValuePair) obj;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ezc.O000000o((int) R.id.device_icon);
                TextView textView = (TextView) ezc.O000000o((int) R.id.device_item);
                TextView textView2 = (TextView) ezc.O000000o((int) R.id.device_item_info);
                SwitchButton switchButton = (SwitchButton) ezc.O000000o((int) R.id.sb_autoupdate);
                String str2 = keyValuePair.f6728O000000o;
                Device O000000o2 = fno.O000000o().O000000o(str2);
                if (O000000o2 != null) {
                    textView.setText(O000000o2.getName());
                    String O0000o0O = ggb.O00000Oo().O0000o0O(O000000o2.did);
                    Home O0000o0 = ggb.O00000Oo().O0000o0(O000000o2.did);
                    if (O0000o0 != null) {
                        ggb.O00000Oo();
                        str = ggb.O000000o(O0000o0);
                    } else {
                        str = "";
                    }
                    textView2.setText(gqb.O000000o(str, 14, "…") + "-" + gqb.O000000o(O0000o0O, 10, "…"));
                    DeviceFactory.O00000Oo(O000000o2.model, simpleDraweeView);
                    switchButton.setOnPerformCheckedChangeListener(null);
                    switchButton.setChecked(Boolean.parseBoolean(keyValuePair.O00000Oo));
                    switchButton.setEnabled(ShowFirmwareUpdateActivity.this.mSBAuto.isChecked());
                    switchButton.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(arrayList, i, str2, switchButton) {
                        /* class com.xiaomi.smarthome.framework.update.ui.$$Lambda$ShowFirmwareUpdateActivity$1$kf43qrWTW04FXXwRvSsjQeuZ8 */
                        private final /* synthetic */ ArrayList f$1;
                        private final /* synthetic */ int f$2;
                        private final /* synthetic */ String f$3;
                        private final /* synthetic */ SwitchButton f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            ShowFirmwareUpdateActivity.AnonymousClass1.this.O000000o(this.f$1, this.f$2, this.f$3, this.f$4, compoundButton, z);
                        }
                    });
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(ArrayList arrayList, int i, String str, SwitchButton switchButton, CompoundButton compoundButton, boolean z) {
                arrayList.set(i, new KeyValuePair(str, String.valueOf(z)));
                gfb.O000000o();
                final ArrayList arrayList2 = arrayList;
                final int i2 = i;
                final String str2 = str;
                final boolean z2 = z;
                final SwitchButton switchButton2 = switchButton;
                gfb.O000000o(ShowFirmwareUpdateActivity.this.getContext(), str, z, (fsm<JSONObject, fso>) new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "onCheckedChanged onSuccess:".concat(String.valueOf((JSONObject) obj)));
                    }

                    public final void onFailure(fso fso) {
                        gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "onCheckedChanged onFailure:".concat(String.valueOf(fso)));
                        arrayList2.set(i2, new KeyValuePair(str2, String.valueOf(!z2)));
                        switchButton2.setChecked(!z2);
                        hte.O000000o(ShowFirmwareUpdateActivity.this.getContext(), (int) R.string.toast_failed_retry);
                    }
                });
            }

            public final int getItemCount() {
                if (ShowFirmwareUpdateActivity.this.mSBAuto.isChecked()) {
                    return super.getItemCount();
                }
                return 0;
            }
        };
        gqr gqr = new gqr(this.mAdapter);
        gqr.O000000o(this.mHeaderView);
        this.recycler.setAdapter(gqr);
        if (parcelableArrayListExtra == null) {
            gfb.O000000o();
            gfb.O00000Oo(this, new fsm<ArrayList<KeyValuePair>, fso>() {
                /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((ArrayList) obj).iterator();
                    while (it.hasNext()) {
                        KeyValuePair keyValuePair = (KeyValuePair) it.next();
                        if (fno.O000000o().O000000o(keyValuePair.f6728O000000o) != null) {
                            arrayList.add(keyValuePair);
                        }
                    }
                    arrayList.addAll(arrayList);
                    ShowFirmwareUpdateActivity.this.requestFinish(arrayList);
                }

                public final void onFailure(fso fso) {
                    ShowFirmwareUpdateActivity.this.requestFinish(null);
                }
            });
        } else {
            requestFinish(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null) {
                arrayList2.add(new KeyValuePair(device.did, device.model));
            }
        }
        gfa.getInstance().checkAllFirmwareUpdate(arrayList2, new gye.O000000o() {
            /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass3 */

            public final void O000000o(boolean z, boolean z2, boolean z3) {
                O00000Oo(z, z2, z3);
            }

            public final void O000000o(boolean z, boolean z2, boolean z3, List<gey> list) {
                O00000Oo(z, z2, z3);
            }

            public final void O000000o() {
                ShowFirmwareUpdateActivity.this.mHeaderView.setVisibility(8);
            }

            private void O00000Oo(boolean z, boolean z2, boolean z3) {
                ShowFirmwareUpdateActivity.this.mSBAuto.setChecked(z);
                ShowFirmwareUpdateActivity.this.mSBPush.setChecked(z3);
                ShowFirmwareUpdateActivity showFirmwareUpdateActivity = ShowFirmwareUpdateActivity.this;
                showFirmwareUpdateActivity.mUserSetSwitch = z2;
                showFirmwareUpdateActivity.mAutoUpgradeSwitch = z;
                if (showFirmwareUpdateActivity.needShowIPCTips()) {
                    ShowFirmwareUpdateActivity.this.showAutoUpdateDialog();
                }
                if (!z2) {
                    ShowFirmwareUpdateActivity showFirmwareUpdateActivity2 = ShowFirmwareUpdateActivity.this;
                    showFirmwareUpdateActivity2.onCheckedChanged(showFirmwareUpdateActivity2.mSBAuto, true);
                }
            }
        });
        new AppConfigHelper(this).O000000o("fireware_auto_update_config", "1", "en", null, new AppConfigHelper.O00000Oo() {
            /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass4 */

            public final boolean O000000o(String str) throws Exception {
                return ShowFirmwareUpdateActivity.this.parseAutoUpdateTips(str);
            }

            public final boolean O00000Oo(String str) throws Exception {
                return ShowFirmwareUpdateActivity.this.parseAutoUpdateTips(str);
            }
        }, new AppConfigHelper.O000000o() {
            /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass5 */

            public final void onFailure(gsf gsf, Exception exc, Response response) {
            }

            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                ShowFirmwareUpdateActivity.this.parseAutoUpdateTips(str);
            }
        }, $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE);
    }

    public /* synthetic */ void lambda$onCreate$0$ShowFirmwareUpdateActivity(View view) {
        onBackPressed();
    }

    public boolean parseAutoUpdateTips(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.tvAutoContent.setText(flk.O000000o(jSONObject.optJSONObject("auto_update_hint")));
            this.mAutoUpdateDialogTips = flk.O000000o(jSONObject.optJSONObject("auto_update_dialog"));
            if (!needShowIPCTips()) {
                return true;
            }
            showAutoUpdateDialog();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("auto_switch", this.mSBAuto.isChecked());
        setResult(-1, intent);
        super.finish();
    }

    public void onBackPressed() {
        if (this.fromGuide) {
            fbs.O000000o(new fbt(this, "UpdateActivity"));
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void requestFinish(ArrayList<KeyValuePair> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.llNodata.setVisibility(0);
        } else {
            this.llNodata.setVisibility(8);
        }
        if (this.mSBAuto.isChecked()) {
            this.mRlPushLayout.setVisibility(0);
        } else {
            this.mRlPushLayout.setVisibility(8);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.sb_autoupdate) {
            if (z) {
                this.mRlPushLayout.setVisibility(0);
                if (this.mUserSetSwitch && this.mAdapter.getItemCount() > 0) {
                    if (!gpv.O000000o(CoreApi.O000000o().O0000o0() + "fireware_autoupdate_hint_ipc", false)) {
                        showAutoUpdateDialog();
                    }
                }
            } else {
                this.mRlPushLayout.setVisibility(8);
            }
            this.mAdapter.notifyDataSetChanged();
            gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "onCheckedChanged ".concat(String.valueOf(z)));
            gfb.O000000o();
            gfb.O000000o(this, z, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "setAutoUpdate onSuccess:".concat(String.valueOf((JSONObject) obj)));
                }

                public final void onFailure(fso fso) {
                    gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "setAutoUpdate onFailure:".concat(String.valueOf(fso)));
                    gqg.O00000Oo((int) R.string.toast_failed_retry);
                }
            });
        } else if (compoundButton.getId() == R.id.sb_push) {
            gfb.O000000o();
            gfb.O00000Oo(this, z, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.update.ui.ShowFirmwareUpdateActivity.AnonymousClass7 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "setAutoUpdatePushSwitch onSuccess:".concat(String.valueOf((JSONObject) obj)));
                }

                public final void onFailure(fso fso) {
                    gsy.O00000o0(LogType.DEVICE_CONTROL, "ShowFirmwareUpdateActivity", "setAutoUpdatePushSwitch onFailure:".concat(String.valueOf(fso)));
                    gqg.O00000Oo((int) R.string.toast_failed_retry);
                }
            });
        }
    }

    public boolean needShowIPCTips() {
        if (!this.mUserSetSwitch) {
            return true;
        }
        if (this.mAutoUpgradeSwitch) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoreApi.O000000o().O0000o0());
            sb.append("fireware_autoupdate_hint_ipc");
            return !gpv.O000000o(sb.toString(), false) && this.mAdapter.getItemCount() > 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void showAutoUpdateDialog() {
        if (this.mAutoUpdateDialogTips != null) {
            new MLAlertDialog.Builder(this).O000000o(this.mAutoUpdateDialogTips).O00000o0().O000000o((int) R.string.knows_already, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.update.ui.$$Lambda$ShowFirmwareUpdateActivity$WX7AtuF_hqlNUls2PVCH0yHGUhg */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ShowFirmwareUpdateActivity.this.lambda$showAutoUpdateDialog$1$ShowFirmwareUpdateActivity(dialogInterface, i);
                }
            }).O00000oo();
            gpv.O00000Oo(CoreApi.O000000o().O0000o0() + "fireware_autoupdate_hint_ipc", true);
            gpv.O00000Oo(CoreApi.O000000o().O0000o0() + "home_page_fireware_autoupdate_hint_ipc", true);
        }
    }

    public /* synthetic */ void lambda$showAutoUpdateDialog$1$ShowFirmwareUpdateActivity(DialogInterface dialogInterface, int i) {
        this.mSBAuto.setChecked(true);
    }
}
