package com.xiaomi.smarthome.framework.page.rndebug;

import _m_j.fta;
import _m_j.fvo;
import _m_j.fvt;
import _m_j.gsy;
import _m_j.hsi;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONException;
import org.json.JSONObject;

public class DevelopSettingRNActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private CheckBox f7902O000000o;
    public CheckBox cbRemoteDebug;
    public CheckBox cbTimestamp;
    public EditText etModelName;
    public EditText etPackageName;
    public EditText etSelfSceneId;
    public JSONObject mPageJsonData;
    public boolean mSceneIdChecked = false;

    public static void startActivityForResult(BaseActivity baseActivity, int i) {
        baseActivity.startActivityForResult(new Intent(baseActivity, DevelopSettingRNActivity.class), i);
    }

    public static void startActivityForResult(BaseActivity baseActivity, int i, String str) {
        Intent intent = new Intent(baseActivity, DevelopSettingRNActivity.class);
        intent.putExtra("json_data", str);
        baseActivity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.develop_rn_activity);
        String stringExtra = getIntent().getStringExtra("json_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                this.mPageJsonData = new JSONObject(stringExtra);
            } catch (JSONException unused) {
                this.mPageJsonData = null;
            }
        }
        findViewById(R.id.module_a_5_return_finish_btn).setEnabled(true);
        this.cbRemoteDebug = (CheckBox) findViewById(R.id.remote_debug);
        this.cbTimestamp = (CheckBox) findViewById(R.id.rn_timestamp);
        this.etPackageName = (EditText) findViewById(R.id.package_name);
        this.etModelName = (EditText) findViewById(R.id.model_name);
        this.etSelfSceneId = (EditText) findViewById(R.id.et_self_scene_id);
        this.f7902O000000o = (CheckBox) findViewById(R.id.cb_debug_plugin_scene_check);
        CheckBox checkBox = this.cbRemoteDebug;
        fvo.O000000o();
        checkBox.setChecked(fvo.O00000o());
        this.cbTimestamp.setChecked(hsi.O00000Oo());
        findViewById(R.id.module_a_5_return_more_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevelopSettingRNActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DevelopSettingRNActivity.this.onBackPressed();
            }
        });
        findViewById(R.id.module_a_5_return_finish_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevelopSettingRNActivity.AnonymousClass2 */

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
            public final void onClick(View view) {
                if (TextUtils.isEmpty(DevelopSettingRNActivity.this.etPackageName.getText().toString().trim())) {
                    fta fta = fta.O000000o.f17086O000000o;
                    fta.O000000o("请输入插件包名");
                } else if (TextUtils.isEmpty(DevelopSettingRNActivity.this.etModelName.getText().toString().trim())) {
                    fta fta2 = fta.O000000o.f17086O000000o;
                    fta.O000000o("请输入设备model");
                } else {
                    String trim = DevelopSettingRNActivity.this.etPackageName.getText().toString().trim();
                    fvo.O000000o();
                    fvo.O000000o(DevelopSettingRNActivity.this.cbRemoteDebug.isChecked(), trim, DevelopSettingRNActivity.this.etModelName.getText().toString(), DevelopSettingRNActivity.this.cbTimestamp.isChecked());
                    PluginRuntimeManager.getInstance().exitALLProcess();
                    if (DevelopSettingRNActivity.this.mPageJsonData == null) {
                        DevelopSettingRNActivity.this.mPageJsonData = new JSONObject();
                    }
                    try {
                        DevelopSettingRNActivity.this.mPageJsonData.put(fvt.f17284O000000o, trim);
                        DevelopSettingRNActivity.this.mPageJsonData.put(fvt.O00000Oo, DevelopSettingRNActivity.this.etModelName.getText().toString().trim());
                        DevelopSettingRNActivity.this.mPageJsonData.put(fvt.O00000o0, true);
                        DevelopSettingRNActivity.this.mPageJsonData.put(fvt.O00000o, DevelopSettingRNActivity.this.etSelfSceneId.getText().toString().trim());
                        DevelopSettingRNActivity.this.mPageJsonData.put(fvt.O00000oO, DevelopSettingRNActivity.this.mSceneIdChecked);
                    } catch (JSONException e) {
                        gsy.O00000o0(LogType.PLUGIN, "DevelopSettingRNAct", e.toString());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("jsonData", DevelopSettingRNActivity.this.mPageJsonData.toString());
                    Intent intent = DevelopSettingRNActivity.this.getIntent();
                    intent.putExtra("data", bundle);
                    DevelopSettingRNActivity.this.setResult(1000, intent);
                    DevelopSettingRNActivity.this.onBackPressed();
                    fta fta3 = fta.O000000o.f17086O000000o;
                    fta.O000000o("saved successfully");
                }
            }
        });
        this.f7902O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.rndebug.DevelopSettingRNActivity.AnonymousClass3 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DevelopSettingRNActivity.this.mSceneIdChecked = z;
            }
        });
        JSONObject jSONObject = this.mPageJsonData;
        if (jSONObject != null) {
            this.etPackageName.setText(jSONObject.optString(fvt.f17284O000000o, ""));
            this.etModelName.setText(this.mPageJsonData.optString(fvt.O00000Oo, ""));
            this.etSelfSceneId.setText(this.mPageJsonData.optString(fvt.O00000o, ""));
            this.mSceneIdChecked = this.mPageJsonData.optBoolean(fvt.O00000oO, false);
            this.f7902O000000o.setChecked(this.mSceneIdChecked);
        }
    }
}
