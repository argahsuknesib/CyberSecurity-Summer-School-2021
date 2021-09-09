package com.xiaomi.smarthome.smartconfig.initdevice;

import _m_j.fno;
import _m_j.ggb;
import _m_j.ggx;
import _m_j.gof;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.huf;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.initdevice.InitCurtainGroupActivity;
import java.util.List;

public class InitCurtainGroupActivity extends InitNameBaseActivity implements ggx.O000000o {
    private String O00000oO;
    public TextView leftNewName;
    public final ggx mApi = new ggx();
    public Device mDeviceLeft;
    public EditText mDeviceNameEt;
    public Device mDeviceRight;
    public boolean mEditDeviceName;
    public List<String> mRecommendNames;
    public CommonFlowGroup mRecommendTagFlow;
    public TextView rightNewName;

    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_init_curtaingroup);
        Intent intent = getIntent();
        intent.putExtra("extra_backable", false);
        intent.getStringExtra("device_id");
        String stringExtra = intent.getStringExtra("device_id_left");
        String stringExtra2 = intent.getStringExtra("device_id_right");
        this.O00000oO = intent.getStringExtra("device_room");
        this.mDeviceLeft = fno.O000000o().O000000o(stringExtra);
        this.mDeviceRight = fno.O000000o().O000000o(stringExtra2);
        if (this.O00000o == null || this.mDeviceLeft == null || this.mDeviceRight == null) {
            LogType logType = LogType.KUAILIAN;
            gsy.O00000o0(logType, "InitCurtainGroupActivity", this.O00000o + " " + this.mDeviceLeft + " " + this.mDeviceRight);
            finish();
            return;
        }
        final TextView textView = (TextView) findViewById(R.id.go_next);
        this.leftNewName = (TextView) findViewById(R.id.leftNewName);
        this.rightNewName = (TextView) findViewById(R.id.rightNewName);
        this.mDeviceNameEt = (EditText) findViewById(R.id.device_name);
        final View findViewById = findViewById(R.id.input_clear);
        this.mRecommendTagFlow = (CommonFlowGroup) findViewById(R.id.recommend_name_tag);
        ((TextView) findViewById(R.id.leftCurName)).setText(this.mDeviceLeft.getName());
        ((TextView) findViewById(R.id.rightCurName)).setText(this.mDeviceRight.getName());
        DeviceFactory.O00000Oo(this.O00000o.model, (SimpleDraweeView) findViewById(R.id.device_img));
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitCurtainGroupActivity$x9DYtE6q1ivYLR4NVD7zKMGU */

            public final void onClick(View view) {
                InitCurtainGroupActivity.this.O000000o(view);
            }
        });
        String stringExtra3 = getIntent().getStringExtra("device_name");
        if (!TextUtils.isEmpty(stringExtra3)) {
            setName(stringExtra3, true);
            this.mDeviceNameEt.setSelection(stringExtra3.length());
            if (!stringExtra3.equals(this.O00000o.name)) {
                this.mEditDeviceName = true;
            }
        } else if (this.O00000o.name != null) {
            setName(this.O00000o.name, true);
            this.mDeviceNameEt.setSelection(this.O00000o.name.length());
        }
        this.mDeviceNameEt.setCursorVisible(false);
        findViewById.setVisibility(8);
        this.mDeviceNameEt.setOnClickListener(new View.OnClickListener(findViewById) {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitCurtainGroupActivity$HbddN62dIRICmt0anpomtbvtYI */
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                InitCurtainGroupActivity.this.O000000o(this.f$1, view);
            }
        });
        this.mDeviceNameEt.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitCurtainGroupActivity.AnonymousClass1 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String obj = InitCurtainGroupActivity.this.mDeviceNameEt.getText().toString();
                if (obj.length() > 0) {
                    boolean O00000o02 = gqb.O00000o0(obj);
                    findViewById.setVisibility(0);
                    InitCurtainGroupActivity.this.mDeviceNameEt.setCursorVisible(true);
                    if (O00000o02) {
                        textView.setEnabled(false);
                        gqg.O00000Oo(InitCurtainGroupActivity.this.getString(R.string.tag_save_data_description));
                    } else if (!ggb.O0000oO(obj)) {
                        textView.setEnabled(false);
                        gqg.O00000Oo(InitCurtainGroupActivity.this.getString(R.string.room_name_too_long));
                    } else {
                        InitCurtainGroupActivity.this.mEditDeviceName = true;
                        textView.setEnabled(true);
                    }
                } else {
                    textView.setEnabled(false);
                    findViewById.setVisibility(8);
                }
                if (InitCurtainGroupActivity.this.mRecommendTagFlow.getVisibility() == 0 && InitCurtainGroupActivity.this.mRecommendNames != null) {
                    InitCurtainGroupActivity.this.mRecommendTagFlow.setSelectIndex(-1);
                    for (int i4 = 0; i4 < InitCurtainGroupActivity.this.mRecommendNames.size(); i4++) {
                        if (obj.equals(InitCurtainGroupActivity.this.mRecommendNames.get(i4))) {
                            InitCurtainGroupActivity.this.mRecommendTagFlow.setSelectIndex(i4);
                            return;
                        }
                    }
                }
            }

            public final void afterTextChanged(Editable editable) {
                InitCurtainGroupActivity.this.setName(editable.toString(), false);
            }
        });
        this.mRecommendTagFlow.O000000o(Boolean.FALSE);
        this.mRecommendTagFlow.setOnTagClickListener(new CommonFlowGroup.O000000o() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitCurtainGroupActivity.AnonymousClass2 */

            public final void O000000o() {
            }

            public final void O000000o(int i) {
                if (InitCurtainGroupActivity.this.mRecommendNames != null && InitCurtainGroupActivity.this.mRecommendNames.size() > i) {
                    hxi.O00000o.O0000OoO(InitCurtainGroupActivity.this.mRecommendNames.get(i));
                    InitCurtainGroupActivity initCurtainGroupActivity = InitCurtainGroupActivity.this;
                    initCurtainGroupActivity.setName(ggx.O000000o(initCurtainGroupActivity.O00000o, InitCurtainGroupActivity.this.mRecommendNames.get(i)), true);
                }
            }
        });
        new ggx().O000000o(this.O00000o.model, this);
        ggb.O00000Oo().O000000o((ggb.O00000o) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view, View view2) {
        this.mDeviceNameEt.setCursorVisible(true);
        if (!TextUtils.isEmpty(this.mDeviceNameEt.getText().toString())) {
            view.setVisibility(0);
        }
    }

    public void setName(String str, boolean z) {
        if (z) {
            this.mDeviceNameEt.setText(str);
        }
        this.leftNewName.setText(getString(R.string.mj_initcurtain_leftcontrol, new Object[]{str}));
        this.rightNewName.setText(getString(R.string.mj_initcurtain_rightcontrol, new Object[]{str}));
    }

    public void onRecommendName(String str, List<String> list) {
        this.mRecommendNames = list;
        if (!this.mEditDeviceName && !TextUtils.isEmpty(str)) {
            String O000000o2 = ggx.O000000o(this.O00000o, str);
            setName(O000000o2, true);
            this.mDeviceNameEt.setSelection(O000000o2.length());
            this.mEditDeviceName = true;
        }
        if (list.size() > 0) {
            this.mRecommendTagFlow.setVisibility(0);
            this.mRecommendTagFlow.setData(list);
            this.mRecommendTagFlow.setSelectIndex(-1);
            for (int i = 0; i < list.size(); i++) {
                if (this.mDeviceNameEt.getText().toString().equals(list.get(i))) {
                    this.mRecommendTagFlow.setSelectIndex(i);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (!gof.O00000o0()) {
            gqg.O00000Oo((int) R.string.popup_select_loc_no_network);
            return;
        }
        if (this.O00000o0 == null || !this.O00000o0.isShowing()) {
            this.O00000o0 = new XQProgressHorizontalDialog(this);
            this.O00000o0.setCancelable(true);
            this.O00000o0.setMessage(getResources().getString(R.string.loading_share_info));
            this.O00000o0.show();
        }
        this.mApi.O000000o(this, this.O00000o, this.O00000oO, new Callback<String>() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitCurtainGroupActivity.AnonymousClass3 */

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(String str) {
                InitCurtainGroupActivity initCurtainGroupActivity = InitCurtainGroupActivity.this;
                initCurtainGroupActivity.O000000o(initCurtainGroupActivity.mDeviceLeft, InitCurtainGroupActivity.this.leftNewName.getText().toString(), new huf() {
                    /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitCurtainGroupActivity$3$s6L3VQkuNSTZerJ3bvxyiV5PAAg */

                    public final void accept(String str) {
                        InitCurtainGroupActivity.AnonymousClass3.this.O00000Oo(str);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O00000Oo(String str) {
                InitCurtainGroupActivity initCurtainGroupActivity = InitCurtainGroupActivity.this;
                initCurtainGroupActivity.O000000o(initCurtainGroupActivity.mDeviceRight, InitCurtainGroupActivity.this.rightNewName.getText().toString(), new huf() {
                    /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitCurtainGroupActivity$3$w9sbwQNz6jBulcufTS5lQEdiqGk */

                    public final void accept(String str) {
                        InitCurtainGroupActivity.AnonymousClass3.this.O00000o0(str);
                    }
                });
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O00000o0(String str) {
                InitCurtainGroupActivity.this.O000000o();
            }

            public final void onFailure(int i, String str) {
                gsy.O00000o0(LogType.KUAILIAN, "InitCurtainGroupActivity", str);
                if (InitCurtainGroupActivity.this.O00000o0 != null && InitCurtainGroupActivity.this.O00000o0.isShowing()) {
                    InitCurtainGroupActivity.this.O00000o0.dismiss();
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                String obj2 = InitCurtainGroupActivity.this.mDeviceNameEt.getText().toString();
                gsy.O00000Oo(LogType.HOME_ROOM, "InitCurtainGroupActivity", "doSaveDeviceName:".concat(String.valueOf(obj2)));
                if (!TextUtils.isEmpty(obj2)) {
                    InitCurtainGroupActivity initCurtainGroupActivity = InitCurtainGroupActivity.this;
                    initCurtainGroupActivity.O000000o(initCurtainGroupActivity.O00000o, obj2, new huf() {
                        /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitCurtainGroupActivity$3$ds502vrgUCldFbvcF2mq2dsI */

                        public final void accept(String str) {
                            InitCurtainGroupActivity.AnonymousClass3.this.O000000o(str);
                        }
                    });
                }
            }
        });
    }
}
