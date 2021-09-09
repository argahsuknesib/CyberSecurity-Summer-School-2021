package com.xiaomi.smarthome.framework.page.rndebug;

import _m_j.fko;
import _m_j.fso;
import _m_j.fta;
import _m_j.fvo;
import _m_j.fvt;
import _m_j.fvu;
import _m_j.fvv;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hsj;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.SendMessageHandle;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.rndebug.RnDebugSearchListAdapter;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class DevSettingRnDebugListActivity extends BaseActivity {
    @BindView(5105)
    EditText etSearchModel;
    public MLAlertDialog ipInfoInputDialog = null;
    @BindView(5366)
    ImageView ivHeadRight;
    @BindView(5234)
    ImageView ivPluginDebug;
    @BindView(5259)
    View layoutOtherSetting;
    @BindView(5260)
    View layoutRnSettingIp;
    public List<JSONObject> listDatas = new ArrayList();
    public boolean mIsDebugEnable = false;
    public int mSelectPosition = -1;
    public fvv rnDebugListAdapter;
    public RnDebugSearchListAdapter rnDebugSearchListAdapter;
    public List<DeviceStat> rnDebugSearchTotalModels = new ArrayList();
    public JSONObject selectDebugJson;
    @BindView(5684)
    SlideRecyclerView srvRnDebugPluginModelList;
    @BindView(5685)
    SlideRecyclerView srvSearchModelList;
    @BindView(5361)
    TextView tvHeadTitle;
    @BindView(5835)
    TextView tvIpDetail;
    @BindView(5844)
    TextView tvPluginDebug;
    @BindView(5357)
    View viewHeadLeft;
    @BindView(5249)
    View viewWindow;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, DevSettingRnDebugListActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_dev_setting_rn_debug_list);
        ButterKnife.bind(this);
        this.viewHeadLeft.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DevSettingRnDebugListActivity.this.clickBack();
            }
        });
        this.tvHeadTitle.setText(getString(R.string.string_rn_debug_dev_setting));
        this.ivHeadRight.setVisibility(0);
        this.ivHeadRight.setImageResource(R.drawable.mj_webp_titlebar_add_nor);
        fvo.O000000o();
        this.mIsDebugEnable = fvo.O00000oO();
        this.tvIpDetail.setText(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("debug_http_host", ""));
        this.ivHeadRight.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass12 */

            public final void onClick(View view) {
                if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o("请开启开发模式");
                    return;
                }
                DevelopSettingRNActivity.startActivityForResult(DevSettingRnDebugListActivity.this, (int) C.MSG_CUSTOM_BASE);
            }
        });
        this.ivPluginDebug.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass17 */

            public final void onClick(View view) {
                DevSettingRnDebugListActivity devSettingRnDebugListActivity = DevSettingRnDebugListActivity.this;
                devSettingRnDebugListActivity.mIsDebugEnable = !devSettingRnDebugListActivity.mIsDebugEnable;
                fvo.O000000o();
                fvo.O00000o0(DevSettingRnDebugListActivity.this.mIsDebugEnable);
                DevSettingRnDebugListActivity.this.updateView();
            }
        });
        this.layoutRnSettingIp.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass18 */

            public final void onClick(View view) {
                if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o("请开启开发模式");
                    return;
                }
                DevSettingRnDebugListActivity.this.showInputIpInfoDialog();
            }
        });
        this.layoutOtherSetting.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass19 */

            public final void onClick(View view) {
                if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o("请开启开发模式");
                    return;
                }
                RnDebugOtherSettingActivity.startActivity(DevSettingRnDebugListActivity.this);
            }
        });
        this.etSearchModel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass20 */

            public final void onClick(View view) {
                if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o("请开启开发模式");
                    return;
                }
                DevSettingRnDebugListActivity.this.srvRnDebugPluginModelList.setVisibility(4);
                DevSettingRnDebugListActivity.this.srvSearchModelList.setVisibility(0);
                DevSettingRnDebugListActivity.this.etSearchModel.setFocusable(true);
                DevSettingRnDebugListActivity.this.etSearchModel.requestFocus();
                DevSettingRnDebugListActivity.this.etSearchModel.setFocusableInTouchMode(true);
                DevSettingRnDebugListActivity.this.etSearchModel.requestFocusFromTouch();
                InputMethodManager inputMethodManager = (InputMethodManager) DevSettingRnDebugListActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(DevSettingRnDebugListActivity.this.etSearchModel, 0);
                }
            }
        });
        this.etSearchModel.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass21 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                String trim = editable.toString().trim();
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(trim)) {
                    for (DeviceStat next : DevSettingRnDebugListActivity.this.rnDebugSearchTotalModels) {
                        if (!TextUtils.isEmpty(next.model) && next.model.startsWith(trim)) {
                            arrayList.add(next);
                        }
                    }
                }
                RnDebugSearchListAdapter.O000000o(arrayList, DevSettingRnDebugListActivity.this.rnDebugSearchListAdapter.f7928O000000o);
                DevSettingRnDebugListActivity.this.rnDebugSearchListAdapter.notifyDataSetChanged();
            }
        });
        this.srvRnDebugPluginModelList.setLayoutManager(new LinearLayoutManager(this, 1, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this);
        Drawable O000000o2 = ContextCompat.O000000o(this, (int) R.drawable.std_lite_grid_divider);
        if (O000000o2 != null) {
            dividerItemDecoration.f2930O000000o = O000000o2;
            this.srvRnDebugPluginModelList.addItemDecoration(dividerItemDecoration);
            this.rnDebugListAdapter = new fvv(this, this.listDatas);
            this.srvRnDebugPluginModelList.setAdapter(this.rnDebugListAdapter);
            this.rnDebugListAdapter.O00000o0 = new fvv.O000000o() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass22 */

                public final void O000000o(int i) {
                    if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                        fta fta = fta.O000000o.f17086O000000o;
                        fta.O000000o("请开启开发模式");
                        return;
                    }
                    DevSettingRnDebugListActivity devSettingRnDebugListActivity = DevSettingRnDebugListActivity.this;
                    devSettingRnDebugListActivity.mSelectPosition = i;
                    DevelopSettingRNActivity.startActivityForResult(devSettingRnDebugListActivity, 10001, devSettingRnDebugListActivity.listDatas.get(i).toString());
                }

                public final void O00000Oo(int i) {
                    if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                        fta fta = fta.O000000o.f17086O000000o;
                        fta.O000000o("请开启开发模式");
                        return;
                    }
                    DevSettingRnDebugListActivity.this.listDatas.remove(i);
                    DevSettingRnDebugListActivity.this.srvRnDebugPluginModelList.O000000o();
                }

                public final void O000000o(int i, boolean z) {
                    if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                        fta fta = fta.O000000o.f17086O000000o;
                        fta.O000000o("请开启开发模式");
                        return;
                    }
                    DevSettingRnDebugListActivity.this.updateDebugListIfCheckStarPkg(i, z);
                }

                public final void O000000o() {
                    if (!DevSettingRnDebugListActivity.this.mIsDebugEnable) {
                        fta fta = fta.O000000o.f17086O000000o;
                        fta.O000000o("请开启开发模式");
                    } else if (DevSettingRnDebugListActivity.this.getSelectCount() == 1) {
                        Observable.create(new Observable.OnSubscribe<String>() {
                            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass22.AnonymousClass3 */

                            public final /* synthetic */ void call(Object obj) {
                                Subscriber subscriber = (Subscriber) obj;
                                fvu.O000000o(DevSettingRnDebugListActivity.this, DevSettingRnDebugListActivity.this.listDatas);
                                if (DevSettingRnDebugListActivity.this.selectDebugJson != null) {
                                    fvo.O000000o();
                                    fvo.O000000o(DevSettingRnDebugListActivity.this.selectDebugJson.optString(fvt.f17284O000000o));
                                }
                                subscriber.onNext("");
                            }
                        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass22.AnonymousClass1 */

                            public final /* synthetic */ void call(Object obj) {
                                DevSettingRnDebugListActivity.this.getAction("t.t.t", DevSettingRnDebugListActivity.this.getContext(), new Bundle(), true);
                            }
                        }, new Action1<Throwable>() {
                            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass22.AnonymousClass2 */

                            public final /* synthetic */ void call(Object obj) {
                                gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", ((Throwable) obj).toString());
                            }
                        });
                    } else {
                        gqg.O00000Oo("请选择列表中的一项进行调试");
                    }
                }
            };
            this.srvSearchModelList.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.srvSearchModelList.addItemDecoration(dividerItemDecoration);
            this.rnDebugSearchListAdapter = new RnDebugSearchListAdapter(this);
            this.srvSearchModelList.setAdapter(this.rnDebugSearchListAdapter);
            this.rnDebugSearchListAdapter.O00000Oo = new RnDebugSearchListAdapter.O000000o() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass23 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
                 arg types: [java.lang.String, int]
                 candidates:
                  org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
                  org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
                public final void O000000o(DeviceStat deviceStat) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(fvt.f17284O000000o, "*");
                        jSONObject.put(fvt.O00000Oo, deviceStat.model);
                        jSONObject.put(fvt.O00000o0, false);
                        jSONObject.put(fvt.O00000o, "");
                        jSONObject.put(fvt.O00000oO, false);
                    } catch (JSONException e) {
                        gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e.toString());
                    }
                    DevSettingRnDebugListActivity.this.listDatas.add(jSONObject);
                    DevSettingRnDebugListActivity.this.rnDebugListAdapter.O000000o(DevSettingRnDebugListActivity.this.listDatas);
                    DevSettingRnDebugListActivity.this.srvDebugPluginModelListNotifyDataSetChanged();
                    DevSettingRnDebugListActivity.this.clickBack();
                }
            };
            Observable.create(new Observable.OnSubscribe<String>() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass4 */

                public final /* synthetic */ void call(Object obj) {
                    DevSettingRnDebugListActivity devSettingRnDebugListActivity = DevSettingRnDebugListActivity.this;
                    devSettingRnDebugListActivity.listDatas = fvu.O000000o(devSettingRnDebugListActivity);
                    ((Subscriber) obj).onNext("");
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass2 */

                public final /* synthetic */ void call(Object obj) {
                    DevSettingRnDebugListActivity.this.rnDebugListAdapter.O000000o(DevSettingRnDebugListActivity.this.listDatas);
                    DevSettingRnDebugListActivity.this.updateView();
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass3 */

                public final /* synthetic */ void call(Object obj) {
                    gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", ((Throwable) obj).toString());
                }
            });
            Observable.create(new Observable.OnSubscribe<String>() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass7 */

                public final /* synthetic */ void call(Object obj) {
                    Subscriber subscriber = (Subscriber) obj;
                    List<DeviceStat> deviceList = XmPluginHostApi.instance().getDeviceList();
                    HashMap hashMap = new HashMap();
                    for (DeviceStat next : deviceList) {
                        if (!hashMap.containsKey(next.model)) {
                            DevSettingRnDebugListActivity.this.rnDebugSearchTotalModels.add(next);
                            hashMap.put(next.model, next.did);
                        }
                    }
                    hashMap.clear();
                    subscriber.onNext("");
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass5 */

                public final /* synthetic */ void call(Object obj) {
                    LogType logType = LogType.PLUGIN;
                    gsy.O00000o0(logType, "DevSettingRnDebugList", "total mode size is " + DevSettingRnDebugListActivity.this.rnDebugSearchTotalModels.size());
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass6 */

                public final /* synthetic */ void call(Object obj) {
                    gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", ((Throwable) obj).toString());
                }
            });
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void updateView() {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "DevSettingRnDebugList", "DevSettingRnDebugListActivity  IsDebugEnable: " + this.mIsDebugEnable);
        if (this.mIsDebugEnable) {
            this.viewWindow.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
            this.ivPluginDebug.setBackgroundResource(R.drawable.btn_power_on);
            this.tvPluginDebug.setText(getString(R.string.string_rn_debug_dev_pattern_on));
        } else {
            this.viewWindow.setBackgroundColor(getResources().getColor(R.color.mj_color_white_60_transparent));
            this.ivPluginDebug.setBackgroundResource(R.drawable.btn_power_off);
            this.tvPluginDebug.setText(getString(R.string.string_rn_debug_dev_pattern_off));
        }
        this.rnDebugListAdapter.f17285O000000o = this.mIsDebugEnable;
        srvDebugPluginModelListNotifyDataSetChanged();
    }

    public void checkHasStarPackageToReplaceAllPluginTest() {
        String str;
        Iterator<JSONObject> it = this.listDatas.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            JSONObject next = it.next();
            if ("*".equals(next.optString(fvt.f17284O000000o)) && next.optBoolean(fvt.O00000o0)) {
                str = next.optString(fvt.O00000Oo);
                break;
            }
        }
        fko.O000000o(CommonApplication.getAppContext(), str);
    }

    public int getSelectCount() {
        int size = this.listDatas.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            try {
                if (this.listDatas.get(i2).getBoolean(fvt.O00000o0)) {
                    this.selectDebugJson = this.listDatas.get(i2);
                    i++;
                }
            } catch (JSONException e) {
                gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e.toString());
            }
        }
        return i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
     arg types: [java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, int):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder */
    public void showInputIpInfoDialog() {
        String trim = this.tvIpDetail.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            trim = trim.split(":")[0];
        }
        if (this.ipInfoInputDialog == null) {
            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(this).O000000o("IP地址").O00000Oo("输入电脑的IP地址，您的手机可以不通过USB连接电脑，就能调试RN扩展程序！").O000000o("请输入您电脑的ip地址", true).O000000o(false).O00000Oo("取消", new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    DevSettingRnDebugListActivity.this.ipInfoInputDialog.dismiss();
                }
            }).O000000o("确定", new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String trim = DevSettingRnDebugListActivity.this.ipInfoInputDialog.getInputView().getText().toString().trim();
                    DevSettingRnDebugListActivity.this.ipInfoInputDialog.dismiss();
                    if (!TextUtils.isEmpty(trim)) {
                        trim = trim + ":8081";
                    }
                    DevSettingRnDebugListActivity.this.tvIpDetail.setText(trim);
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(DevSettingRnDebugListActivity.this.getApplicationContext()).edit();
                    edit.putString("debug_http_host", trim);
                    edit.apply();
                }
            });
            if (!TextUtils.isEmpty(trim)) {
                O000000o2.O000000o().setText(trim);
            }
            this.ipInfoInputDialog = O000000o2.O00000oo();
            return;
        }
        if (!TextUtils.isEmpty(trim)) {
            this.ipInfoInputDialog.getInputView().setText(trim);
        }
        this.ipInfoInputDialog.show();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public void updateDebugListIfCheckStarPkg(int i, boolean z) {
        int size = this.listDatas.size();
        JSONObject jSONObject = this.listDatas.get(i);
        try {
            jSONObject.put(fvt.O00000o0, z);
        } catch (JSONException e) {
            gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e.toString());
        }
        if (z) {
            boolean equals = "*".equals(jSONObject.optString(fvt.f17284O000000o));
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != i) {
                    JSONObject jSONObject2 = this.listDatas.get(i2);
                    if (equals) {
                        try {
                            jSONObject2.put(fvt.O00000o0, false);
                        } catch (JSONException e2) {
                            gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e2.toString());
                        }
                    } else if ("*".equals(jSONObject2.optString(fvt.f17284O000000o))) {
                        try {
                            jSONObject2.put(fvt.O00000o0, false);
                        } catch (JSONException e3) {
                            gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e3.toString());
                        }
                    }
                }
            }
        }
        this.rnDebugListAdapter.O000000o(this.listDatas);
        srvDebugPluginModelListNotifyDataSetChanged();
    }

    public void srvDebugPluginModelListNotifyDataSetChanged() {
        this.srvRnDebugPluginModelList.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass14 */

            public final void run() {
                DevSettingRnDebugListActivity.this.rnDebugListAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle bundleExtra;
        super.onActivityResult(i, i2, intent);
        if (intent != null && (bundleExtra = intent.getBundleExtra("data")) != null) {
            String string = bundleExtra.getString("jsonData");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e.toString());
                }
                if (jSONObject != null) {
                    if (10001 == i) {
                        JSONObject jSONObject2 = this.listDatas.get(this.mSelectPosition);
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        try {
                            jSONObject2.put(fvt.f17284O000000o, jSONObject.optString(fvt.f17284O000000o));
                            jSONObject2.put(fvt.O00000Oo, jSONObject.optString(fvt.O00000Oo));
                            jSONObject2.put(fvt.O00000o0, jSONObject.optBoolean(fvt.O00000o0));
                            jSONObject2.put(fvt.O00000o, jSONObject.optString(fvt.O00000o));
                            jSONObject2.put(fvt.O00000oO, jSONObject.optBoolean(fvt.O00000oO));
                        } catch (JSONException e2) {
                            gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", e2.toString());
                        }
                    } else if (10000 == i) {
                        this.listDatas.add(0, jSONObject);
                    }
                    this.rnDebugListAdapter.O000000o(this.listDatas);
                    srvDebugPluginModelListNotifyDataSetChanged();
                }
            }
        }
    }

    public Intent getAction(String str, Context context, Bundle bundle, boolean z) {
        Bundle bundle2 = bundle;
        if (CoreApi.O000000o().O00000o(str)) {
            if (z) {
                Intent intent = new Intent();
                if (bundle2 != null) {
                    intent.putExtras(bundle);
                }
                Context context2 = context;
                String str2 = str;
                PluginApi.getInstance().sendMessage(context2, str2, 1, intent, hsj.O000000o(), null, false, new SendMessageCallback() {
                    /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass15 */

                    public final void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask) {
                    }

                    public final void onDownloadCancel() {
                    }

                    public final void onDownloadFailure(PluginError pluginError) {
                    }

                    public final void onDownloadProgress(String str, float f) {
                    }

                    public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    }

                    public final void onDownloadSuccess(String str) {
                    }

                    public final void onInstallSuccess(String str) {
                    }

                    public final void onSendCancel() {
                    }

                    public final void onSendFailure(fso fso) {
                    }

                    public final void onSendSuccess(Bundle bundle) {
                    }
                }, new SendMessageHandle());
            } else {
                Intent intent2 = new Intent();
                if (bundle2 != null) {
                    intent2.putExtras(bundle);
                }
                AnonymousClass16 r10 = new O000000o() {
                    /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass16 */

                    public final void onDownloadCancel() {
                    }

                    public final void onDownloadFailure(PluginError pluginError) {
                    }

                    public final void onDownloadProgress(String str, float f) {
                    }

                    public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    }

                    public final void onDownloadSuccess(String str) {
                    }

                    public final void onSendCancel() {
                    }

                    public final void onSendFailure(fso fso) {
                    }

                    public final void onSendSuccess(Bundle bundle) {
                    }
                };
                r10.f7900O000000o = PluginApi.getInstance().sendMessage(context, str, 1, intent2, hsj.O000000o(), null, false, r10);
            }
        }
        gsy.O000000o(6, "Device_Renderer", str + ", 0 - " + System.currentTimeMillis());
        return null;
    }

    class O000000o extends SendMessageCallback {

        /* renamed from: O000000o  reason: collision with root package name */
        public SendMessageHandle f7900O000000o;

        O000000o() {
        }
    }

    public void clickBack() {
        if (this.srvRnDebugPluginModelList.getVisibility() != 0) {
            this.srvRnDebugPluginModelList.setVisibility(0);
            this.srvSearchModelList.setVisibility(4);
            this.etSearchModel.setText("");
            this.etSearchModel.setFocusable(false);
            this.etSearchModel.setFocusableInTouchMode(false);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.etSearchModel.getWindowToken(), 0);
                return;
            }
            return;
        }
        Observable.create(new Observable.OnSubscribe<String>() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass10 */

            public final /* synthetic */ void call(Object obj) {
                DevSettingRnDebugListActivity devSettingRnDebugListActivity = DevSettingRnDebugListActivity.this;
                fvu.O000000o(devSettingRnDebugListActivity, devSettingRnDebugListActivity.listDatas);
                DevSettingRnDebugListActivity.this.checkHasStarPackageToReplaceAllPluginTest();
                ((Subscriber) obj).onNext("");
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass8 */

            public final /* synthetic */ void call(Object obj) {
                DevSettingRnDebugListActivity.this.finish();
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevSettingRnDebugListActivity.AnonymousClass9 */

            public final /* synthetic */ void call(Object obj) {
                gsy.O00000o0(LogType.PLUGIN, "DevSettingRnDebugList", ((Throwable) obj).toString());
            }
        });
    }

    public void onBackPressed() {
        clickBack();
    }
}
