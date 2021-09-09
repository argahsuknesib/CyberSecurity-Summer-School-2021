package com.xiaomi.smarthome.light.group;

import _m_j.faw;
import _m_j.fax;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import _m_j.gtf;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import org.json.JSONObject;

public class LightGroupTestActivity extends BaseActivity {
    public static final String TAG = "LightGroupTestActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f9383O000000o;
    TextView O00000Oo;
    TextView O00000o;
    ImageView O00000o0;
    View O00000oO;
    TextView O00000oo;
    public String did;
    public Device mGroupDevice;
    public boolean mSpecPropOnValue = true;

    public static void open(Activity activity, String str, int i) {
        Intent intent = new Intent();
        intent.setClass(activity, LightGroupTestActivity.class);
        intent.putExtra("did", str);
        activity.startActivityForResult(intent, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        if (_m_j.gtf.O00000Oo(r4.mGroupDevice) == false) goto L_0x003c;
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_light_group_test);
        this.did = getIntent().getStringExtra("did");
        if (TextUtils.isEmpty(this.did)) {
            finishPage(0);
        }
        this.mGroupDevice = fno.O000000o().O000000o(this.did);
        if (this.mGroupDevice != null) {
            gtf.O000000o();
        }
        finishPage(0);
        this.f9383O000000o = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o0 = (ImageView) findViewById(R.id.module_a_3_right_img_btn);
        this.O00000o = (TextView) findViewById(R.id.tv_modify);
        this.O00000oO = findViewById(R.id.shortcut);
        this.O00000oo = (TextView) findViewById(R.id.tv_next);
        this.O00000o0.setVisibility(8);
        this.O00000Oo.setText((int) R.string.light_group_creat_confirm);
        this.f9383O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupTestActivity$2rHOuRfOCRy6l6osADioj4ZM4rQ */

            public final void onClick(View view) {
                LightGroupTestActivity.this.O00000Oo(view);
            }
        });
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.$$Lambda$LightGroupTestActivity$Oexup0HR4nTUYRaul3Bxp3gk4_Q */

            public final void onClick(View view) {
                LightGroupTestActivity.this.O000000o(view);
            }
        });
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.LightGroupTestActivity.AnonymousClass1 */

            public final void onClick(View view) {
                fbt fbt = new fbt(LightGroupTestActivity.this, "initDeviceRoomActivity");
                fbt.O000000o("device_id", LightGroupTestActivity.this.did);
                fbs.O000000o(fbt);
                LightGroupTestActivity.this.finishPage(-1);
                hxk hxk = hxi.O00000o;
                String str = LightGroupTestActivity.this.mGroupDevice.model;
                hxk.f952O000000o.O000000o("addlightgroup_try_click", "model", str);
            }
        });
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.LightGroupTestActivity.AnonymousClass2 */

            public final void onClick(View view) {
                try {
                    LightGroupTestActivity.this.O00000oO.setEnabled(false);
                    if (LightGroupTestActivity.this.mSpecPropOnValue) {
                        hxk hxk = hxi.O00000o;
                        String str = LightGroupTestActivity.this.mGroupDevice.model;
                        hxk.f952O000000o.O000000o("addlightgroup_try_on", "model", str);
                    } else {
                        hxk hxk2 = hxi.O00000o;
                        String str2 = LightGroupTestActivity.this.mGroupDevice.model;
                        hxk2.f952O000000o.O000000o("addlightgroup_try_off", "model", str2);
                    }
                    faw.O000000o().setDeviceProp(LightGroupTestActivity.this.did, (SpecProperty) ((Spec.SpecItem) fax.O000000o(faw.O000000o().getSpecInstance(LightGroupTestActivity.this.mGroupDevice)).get("p:light:on").get(0)), Boolean.valueOf(LightGroupTestActivity.this.mSpecPropOnValue), new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.light.group.LightGroupTestActivity.AnonymousClass2.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            gsy.O00000Oo(LightGroupTestActivity.TAG, "setDeviceProp onSuccess: ".concat(String.valueOf((JSONObject) obj)));
                            LightGroupTestActivity.this.mSpecPropOnValue = !LightGroupTestActivity.this.mSpecPropOnValue;
                            LightGroupTestActivity.this.O00000oO.setBackgroundResource(LightGroupTestActivity.this.mSpecPropOnValue ? R.drawable.icon_shortcut_off : R.drawable.icon_shortcut_on);
                            LightGroupTestActivity.this.O00000oO.setEnabled(true);
                        }

                        public final void onFailure(fso fso) {
                            gsy.O00000Oo(LightGroupTestActivity.TAG, "setDeviceProp onFailure: ".concat(String.valueOf(fso)));
                            LightGroupTestActivity.this.O00000oO.setEnabled(true);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    LightGroupTestActivity.this.O00000oO.setEnabled(true);
                }
            }
        });
        hxp hxp = hxi.O00000o0;
        String str = this.mGroupDevice.model;
        hxp.f957O000000o.O000000o("addlightgroup_try_show", "model", str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
        hxk hxk = hxi.O00000o;
        String str = this.mGroupDevice.model;
        hxk.f952O000000o.O000000o("addlightgroup_try_reset", "model", str);
    }

    public void finishPage(int i) {
        setResult(i);
        finish();
    }

    public void onBackPressed() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.light_group_reselect_title).O00000Oo((int) R.string.light_group_reselect_msg).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.LightGroupTestActivity.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LightGroupTestActivity.this.finishPage(0);
                hxk hxk = hxi.O00000o;
                String str = LightGroupTestActivity.this.mGroupDevice.model;
                hxk.f952O000000o.O000000o("addlightgroup_reset_click", "model", str);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.light.group.LightGroupTestActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                hxk hxk = hxi.O00000o;
                String str = LightGroupTestActivity.this.mGroupDevice.model;
                hxk.f952O000000o.O000000o("addlightgroup_cancel_click", "model", str);
            }
        }).O00000oo();
    }
}
