package com.xiaomi.smarthome.infrared.activity;

import _m_j.gjd;
import _m_j.gje;
import _m_j.gsy;
import _m_j.izb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.IRKeyValue;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class IRStudyTipActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private Bundle f9030O000000o;
    private String O00000Oo;
    private DeviceStat O00000o;
    private String O00000o0;
    public String mLeanID;
    public Runnable mReadRunnable = new Runnable() {
        /* class com.xiaomi.smarthome.infrared.activity.IRStudyTipActivity.AnonymousClass1 */

        public final void run() {
            if (!IRStudyTipActivity.this.isFinishing()) {
                IRStudyTipActivity.this.readKeyValue();
            }
        }
    };
    public int mRetryReadCount = 0;
    public String mStudyKey;

    public static void showStudyTipActivity(Activity activity, IRKeyValue iRKeyValue, Bundle bundle, int i) {
        Intent intent = new Intent(activity, IRStudyTipActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_study_controller_key_value", iRKeyValue);
        intent.putExtra("request_bundle_key", bundle);
        activity.startActivityForResult(intent, i);
    }

    public static void showStudyTipActivity(Activity activity, String str, Bundle bundle, int i) {
        Intent intent = new Intent(activity, IRStudyTipActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_study_controller_key", str);
        intent.putExtra("request_bundle_key", bundle);
        activity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f9030O000000o = intent.getBundleExtra("request_bundle_key");
        String string = this.f9030O000000o.getString("key_device_image");
        this.mStudyKey = intent.getStringExtra("intent_study_controller_key");
        IRKeyValue iRKeyValue = (IRKeyValue) intent.getParcelableExtra("intent_study_controller_key_value");
        this.O00000o = (DeviceStat) intent.getParcelableExtra("extra_device");
        if (iRKeyValue != null) {
            this.mStudyKey = iRKeyValue.O00000o;
            this.O00000o0 = gjd.O000000o(iRKeyValue);
            this.O00000Oo = iRKeyValue.O00000Oo;
        }
        setContentView((int) R.layout.activity_ir_study_tip);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        View findViewById2 = findViewById(R.id.module_a_3_return_more_more_btn);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.ivDevice);
        findViewById2.setVisibility(8);
        if (TextUtils.isEmpty(string)) {
            string = this.O00000o.deviceIconReal;
        }
        simpleDraweeView.setImageURI(string);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O00000o.name);
        gsy.O00000Oo("IRStudyTipActivity", "initView: device mDeviceStat.did :" + this.O00000o.did);
        findViewById.setOnClickListener(this);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (!TextUtils.isEmpty(this.mStudyKey)) {
            sendRequest("miIO.ir_learn_stop", "key", this.mLeanID, new Callback<String>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRStudyTipActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O00000Oo("IRStudyTipActivity", "stopStudyKey" + IRStudyTipActivity.this.mStudyKey + " " + IRStudyTipActivity.this.mLeanID + " success " + ((String) obj));
                }

                public final void onFailure(int i, String str) {
                    gsy.O00000Oo("IRStudyTipActivity", "stopStudyKey key " + IRStudyTipActivity.this.mStudyKey + " " + IRStudyTipActivity.this.mLeanID + " failed " + i);
                }
            });
        }
        this.mHandler.removeCallbacks(this.mReadRunnable);
    }

    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(this.mStudyKey)) {
            if (gje.f17841O000000o == null) {
                gje.f17841O000000o = new HashSet();
            }
            this.mLeanID = gje.O000000o("0123456789", gje.f17841O000000o);
            sendRequest("miIO.ir_learn", "key", this.mLeanID, new Callback<String>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRStudyTipActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    gsy.O00000Oo("IRStudyTipActivity", "startStudyKey key " + IRStudyTipActivity.this.mStudyKey + " " + IRStudyTipActivity.this.mLeanID + " success " + ((String) obj));
                    IRStudyTipActivity.this.mHandler.removeCallbacks(IRStudyTipActivity.this.mReadRunnable);
                    IRStudyTipActivity.this.mHandler.postDelayed(IRStudyTipActivity.this.mReadRunnable, 1000);
                }

                public final void onFailure(int i, String str) {
                    gsy.O00000Oo("IRStudyTipActivity", "startStudyKey key " + IRStudyTipActivity.this.mStudyKey + " " + IRStudyTipActivity.this.mLeanID + " failed " + i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(IRStudyTipActivity.this.getString(R.string.ir_toast_key_read_other_error));
                    sb.append("(");
                    sb.append(i);
                    sb.append(")");
                    IRStudyTipActivity.this.showToast(sb.toString());
                }
            });
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            onBackPressed();
        }
    }

    public void readKeyValue() {
        sendRequest("miIO.ir_read", "key", this.mLeanID, new Callback<String>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRStudyTipActivity.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                gsy.O00000Oo("IRStudyTipActivity", "read mStudyKey " + IRStudyTipActivity.this.mStudyKey + " " + IRStudyTipActivity.this.mLeanID + " success" + str);
                String O000000o2 = gje.O000000o(IRStudyTipActivity.this.mLeanID, str);
                if (!O000000o2.isEmpty()) {
                    IRStudyTipActivity.this.onGotCode(O000000o2);
                    return;
                }
                IRStudyTipActivity iRStudyTipActivity = IRStudyTipActivity.this;
                iRStudyTipActivity.mRetryReadCount = 0;
                iRStudyTipActivity.mHandler.removeCallbacks(IRStudyTipActivity.this.mReadRunnable);
                IRStudyTipActivity.this.mHandler.postDelayed(IRStudyTipActivity.this.mReadRunnable, 1000);
            }

            public final void onFailure(int i, String str) {
                gsy.O00000Oo("IRStudyTipActivity", "read mStudyKey " + IRStudyTipActivity.this.mStudyKey + " failed " + i + " errorInfo " + str);
                int i2 = R.string.ir_toast_key_read_other_error;
                if (i == -9950 || i == -3) {
                    IRStudyTipActivity iRStudyTipActivity = IRStudyTipActivity.this;
                    int i3 = iRStudyTipActivity.mRetryReadCount;
                    iRStudyTipActivity.mRetryReadCount = i3 + 1;
                    if (i3 < 10) {
                        IRStudyTipActivity.this.mHandler.removeCallbacks(IRStudyTipActivity.this.mReadRunnable);
                        IRStudyTipActivity.this.mHandler.postDelayed(IRStudyTipActivity.this.mReadRunnable, 1000);
                        i2 = -1;
                    }
                } else if (i == -5003) {
                    i2 = R.string.ir_toast_key_read_timeout;
                }
                if (i2 != -1) {
                    IRStudyTipActivity.this.showToast(IRStudyTipActivity.this.getString(i2) + "(" + i + ")");
                }
            }
        });
    }

    public void onGotCode(String str) {
        gsy.O00000Oo("IRStudyTipActivity", "got code " + str + " mStudyKey  " + this.mStudyKey + "  mDisplayKey  :" + this.O00000o0);
        IRKeyValue iRKeyValue = new IRKeyValue();
        iRKeyValue.O00000oo = str;
        iRKeyValue.O00000o = this.mStudyKey;
        iRKeyValue.O00000Oo = this.O00000Oo;
        iRKeyValue.O0000OOo = TextUtils.isEmpty(this.O00000o0) ? this.mStudyKey : this.O00000o0;
        iRKeyValue.O0000O0o = 38000;
        Intent intent = new Intent();
        intent.putExtra("com.imi.action_study_key_value", iRKeyValue);
        intent.putExtra("request_bundle_key", this.f9030O000000o);
        setResult(-1, intent);
        finish();
    }

    public void sendRequest(String str, String str2, String str3, Callback<String> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!str2.isEmpty()) {
                jSONObject.put(str2, str3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XmPluginHostApi.instance().callMethod(this.O00000o.did, str, jSONObject, callback, new Parser<String>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRStudyTipActivity.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public void showToast(String str) {
        izb.O000000o(this, str, 0).show();
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        }
    }
}
