package com.xiaomi.smarthome.device.choosedevice;

import _m_j.fsm;
import _m_j.fso;
import _m_j.gpc;
import _m_j.gsy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.widget.XmLoadingDialog;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.api.FDDeviceApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CannotFindDeviceActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, List> f7203O000000o = new HashMap();
    private String O00000Oo;
    private XmLoadingDialog O00000o0;
    public boolean isRootUser = false;
    @BindView(5071)
    Button mBtnSure;
    @BindView(5428)
    ImageView mImgGuide;
    @BindView(5479)
    View mLayoutBottomGuide;
    @BindView(5480)
    View mLayoutCompanyGroup;
    @BindView(5481)
    LinearLayout mLayoutCompanyParent;
    @BindView(5487)
    View mLayoutModelGroup;
    @BindView(5488)
    LinearLayout mLayoutModelParent;
    @BindView(6218)
    TextView mTxtTopTitle;

    public static void invokeActivity(String str, Context context) {
        Intent intent = new Intent(context, CannotFindDeviceActivity.class);
        intent.putExtra("EXTRA_USER_ID", str);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cannot_find_device);
        ButterKnife.bind(this);
        findViewById(R.id.module_a_3_right_iv_setting_btn).setVisibility(4);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CannotFindDeviceActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.cannot_find_device_title);
        String string = getString(R.string.sure_account_in_developer_whitelist);
        this.O00000Oo = getIntent().getStringExtra("EXTRA_USER_ID");
        this.mTxtTopTitle.setText(O000000o(string, this.O00000Oo));
        this.mBtnSure.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass2 */

            public final void onClick(View view) {
                CannotFindDeviceActivity.this.onBackPressed();
            }
        });
        this.mImgGuide.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass3 */

            public final void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(MediaStore.Images.Media.insertImage(CannotFindDeviceActivity.this.getContentResolver(), BitmapFactory.decodeResource(CannotFindDeviceActivity.this.getResources(), R.drawable.how_become_white_developer), (String) null, (String) null)), "image/*");
                CannotFindDeviceActivity.this.startActivity(intent);
            }
        });
        gsy.O00000Oo("CannotFindDeviceActivity", "start requestWhiteDeveloper");
        showLoadingDialog();
        FDDeviceApi.getInstance().getWhiteDeveloperCompanyInfo(this, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                CannotFindDeviceActivity.this.hideLoadingDialog();
                if (jSONObject == null) {
                    gsy.O00000Oo("CannotFindDeviceActivity", " get developer whitelist ,but result is null");
                    return;
                }
                gsy.O00000Oo("CannotFindDeviceActivity", "requestWhiteDeveloper onSuccess json:" + jSONObject.toString());
                try {
                    Gson create = new GsonBuilder().create();
                    String optString = jSONObject.optString("manufacturer");
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(optString)) {
                        Map map = (Map) create.fromJson(optString, Map.class);
                        for (Object next : map.keySet()) {
                            String str = (String) next;
                            arrayList.add(str);
                            CannotFindDeviceActivity.this.f7203O000000o.put(str, (List) map.get(next));
                            if ("rootlist".equals(str)) {
                                CannotFindDeviceActivity.this.isRootUser = true;
                                CannotFindDeviceActivity.this.checkRootUser();
                                return;
                            }
                        }
                    }
                    CannotFindDeviceActivity.this.handleCompanies(arrayList);
                    JSONArray jSONArray = jSONObject.getJSONArray("model");
                    int length = jSONArray != null ? jSONArray.length() : 0;
                    String[] strArr = new String[length];
                    for (int i = 0; i < length; i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    CannotFindDeviceActivity.this.handleModels(strArr);
                } catch (JSONException e) {
                    e.printStackTrace();
                    gsy.O00000Oo("CannotFindDeviceActivity", "requestWhiteDeveloper onSuccess json exception:" + e.getMessage());
                }
            }

            public final void onFailure(fso fso) {
                gsy.O000000o(6, "CannotFindDeviceActivity", "get developer white fail " + fso.f17063O000000o + ",msg:" + fso.O00000Oo);
                CannotFindDeviceActivity.this.hideLoadingDialog();
            }
        });
    }

    public void checkRootUser() {
        int i = this.isRootUser ? 8 : 0;
        this.mLayoutCompanyGroup.setVisibility(i);
        this.mLayoutModelGroup.setVisibility(i);
        this.mLayoutBottomGuide.setVisibility(i);
        this.mTxtTopTitle.setText(O000000o(getString(this.isRootUser ? R.string.user_is_root_developer : R.string.sure_account_in_developer_whitelist), this.O00000Oo));
    }

    private static CharSequence O000000o(String str, String str2) {
        String[] split = str.split("%s");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(split[0]);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9900")), length, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) split[1]);
        return spannableStringBuilder;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public TextView buildItemView(String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, gpc.O000000o((Activity) this, 50.0f));
        TextView textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setTextSize(15.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(16);
        return textView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public View buildCompanyItemView(String str) {
        int O000000o2 = gpc.O000000o((Activity) this, 50.0f);
        View inflate = LayoutInflater.from(this).inflate((int) R.layout.item_company_group, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, O000000o2));
        ((TextView) inflate.findViewById(R.id.txt_company_title)).setText(str);
        return inflate;
    }

    public void handleCompanies(final List list) {
        if (!this.mIsDestroyed) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass5 */

                public final void run() {
                    CannotFindDeviceActivity.this.mLayoutCompanyParent.removeAllViews();
                    if (list.size() == 0) {
                        CannotFindDeviceActivity cannotFindDeviceActivity = CannotFindDeviceActivity.this;
                        CannotFindDeviceActivity.this.mLayoutCompanyParent.addView(cannotFindDeviceActivity.buildItemView(cannotFindDeviceActivity.getString(R.string.none)));
                        return;
                    }
                    for (final String str : list) {
                        View buildCompanyItemView = CannotFindDeviceActivity.this.buildCompanyItemView(str);
                        buildCompanyItemView.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass5.AnonymousClass1 */

                            public final void onClick(View view) {
                                CannotFindDeviceChildActivity.invokeActivity(str, (ArrayList) CannotFindDeviceActivity.this.f7203O000000o.get(str), CannotFindDeviceActivity.this);
                            }
                        });
                        CannotFindDeviceActivity.this.mLayoutCompanyParent.addView(buildCompanyItemView);
                    }
                }
            });
        }
    }

    public void handleModels(final String[] strArr) {
        if (!this.mIsDestroyed && strArr != null) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.device.choosedevice.CannotFindDeviceActivity.AnonymousClass6 */

                public final void run() {
                    String str;
                    CannotFindDeviceActivity.this.mLayoutModelParent.removeAllViews();
                    String[] strArr = strArr;
                    if (strArr.length == 0) {
                        CannotFindDeviceActivity cannotFindDeviceActivity = CannotFindDeviceActivity.this;
                        CannotFindDeviceActivity.this.mLayoutModelParent.addView(cannotFindDeviceActivity.buildItemView(cannotFindDeviceActivity.getString(R.string.none)));
                        return;
                    }
                    for (String str2 : strArr) {
                        PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(str2);
                        if (pluginInfo == null) {
                            str = "null";
                        } else {
                            str = pluginInfo.O0000Oo0();
                        }
                        CannotFindDeviceActivity.this.mLayoutModelParent.addView(CannotFindDeviceActivity.this.buildItemView("(" + str + ")" + str2));
                    }
                }
            });
        }
    }

    public void showLoadingDialog() {
        XmLoadingDialog xmLoadingDialog = this.O00000o0;
        if (xmLoadingDialog != null && xmLoadingDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
        this.O00000o0 = XmLoadingDialog.show(this, getString(R.string.plugin_loading));
        this.O00000o0.show();
    }

    public void hideLoadingDialog() {
        XmLoadingDialog xmLoadingDialog = this.O00000o0;
        if (xmLoadingDialog != null && xmLoadingDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
    }
}
