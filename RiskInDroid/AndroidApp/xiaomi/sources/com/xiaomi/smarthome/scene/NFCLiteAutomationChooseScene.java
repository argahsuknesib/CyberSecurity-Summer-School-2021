package com.xiaomi.smarthome.scene;

import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.hig;
import _m_j.hns;
import _m_j.hob;
import _m_j.hod;
import _m_j.hpa;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hte;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity;
import com.xiaomi.smarthome.scene.activity.LiteAutomationChooseScene;
import com.xiaomi.smarthome.scene.activity.SmarthomeCreateAutoSceneActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import org.json.JSONException;
import org.json.JSONObject;

public class NFCLiteAutomationChooseScene extends LiteAutomationChooseScene {

    /* renamed from: O000000o  reason: collision with root package name */
    hns f10587O000000o;
    XQProgressDialog O00000Oo;
    public SceneApi.O000OOOo mScene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.$$Lambda$NFCLiteAutomationChooseScene$5x_bkbH38AjgzvrIJyYzXGyAE0 */

            public final void onClick(View view) {
                NFCLiteAutomationChooseScene.this.O000000o(view);
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.nfc_exectute_one_scene);
        ((ImageView) findViewById(R.id.main_icon)).setImageResource(R.drawable.nfc_lite_scene_empty);
        TextView textView = (TextView) findViewById(R.id.no_scene_hint);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(getResources().getColor(R.color.mj_color_gray_lighter));
        textView.setText((int) R.string.empty_scene_list);
        View findViewById = findViewById(R.id.create_new_scene);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.NFCLiteAutomationChooseScene.AnonymousClass1 */

            public final void onClick(View view) {
                hxi.O00000o.f952O000000o.O000000o("NFC_mihome_create", new Object[0]);
                hpq.O000000o().O000000o((SceneApi.O000OOOo) null);
                Intent intent = new Intent(NFCLiteAutomationChooseScene.this, SmarthomeCreateAutoSceneActivity.class);
                intent.putExtra("from", 2);
                NFCLiteAutomationChooseScene.this.startActivityForResult(intent, 1001);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        hpq.O000000o().O00000o0();
        hpq.O000000o().O000000o((SceneApi.O000OOOo) null);
        hpr.O00000o0().O000000o(this.O00000oo);
    }

    public final void chooseOne(int i) {
        if (this.O00000oO == null || i >= this.O00000oO.size()) {
            hte.O000000o(this, (int) R.string.save_fail);
            finish();
            return;
        }
        this.f10587O000000o = new hns(this.O00000oO);
        hpa hpa = new hpa();
        this.mScene = new SceneApi.O000OOOo();
        this.mScene.O0000O0o.clear();
        this.mScene.O0000O0o.add(hpa.O000000o(0, null));
        hpq.O000000o().O000000o(this.mScene);
        hpq.O000000o().O0000Oo0 = 3;
        hns hns = this.f10587O000000o;
        SceneApi.Action O000000o2 = hns.O000000o(hns.f19096O000000o[i], this.f10587O000000o.O00000Oo[i], null, null);
        this.mScene.O00000oo.clear();
        this.mScene.O00000oo.add(O000000o2);
        this.mScene.O00000Oo = getString(R.string.nfc_trigger_name_sufix) + " " + O000000o2.O00000Oo;
        this.O00000Oo = XQProgressDialog.O000000o(this, null, getResources().getString(R.string.smarthome_scene_saving_scene));
        this.O00000Oo.show();
        hob.O000000o().O000000o(this, this.mScene, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.scene.NFCLiteAutomationChooseScene.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                hod.O0000OoO().O00000o();
                if (NFCLiteAutomationChooseScene.this.isValid()) {
                    NFCLiteAutomationChooseScene.this.O00000Oo.dismiss();
                    String str = NFCLiteAutomationChooseScene.this.mScene.O00000Oo;
                    hpq.O000000o().O00000o0();
                    hpq.O000000o().O000000o((SceneApi.O000OOOo) null);
                    String optString = jSONObject.optString("us_id");
                    Intent intent = new Intent(NFCLiteAutomationChooseScene.this, NFCWriteActivity.class);
                    hig.f18961O000000o = 6;
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("us_id", optString);
                        jSONObject2.put("owner_uid", CoreApi.O000000o().O0000o0());
                        jSONObject2.put("region", ftn.O000000o(NFCLiteAutomationChooseScene.this).f7546O000000o);
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject2.put("scene_name", str);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2.keys().hasNext()) {
                        hig.O00000o0 = jSONObject2.toString();
                        NFCLiteAutomationChooseScene.this.startActivity(intent);
                        NFCLiteAutomationChooseScene.this.finish();
                        return;
                    }
                    hte.O000000o(NFCLiteAutomationChooseScene.this, (int) R.string.save_fail);
                }
            }

            public final void onFailure(fso fso) {
                hte.O000000o(NFCLiteAutomationChooseScene.this, (int) R.string.save_fail);
                if (NFCLiteAutomationChooseScene.this.isValid()) {
                    NFCLiteAutomationChooseScene.this.O00000Oo.dismiss();
                    NFCLiteAutomationChooseScene.this.finish();
                }
            }
        });
    }

    public final void cancelChoose() {
        this.mScene.O00000oo.clear();
    }
}
