package com.xiaomi.smarthome.smartconfig.initdevice;

import _m_j.fsm;
import _m_j.fso;
import _m_j.gfy;
import _m_j.ggb;
import _m_j.ggx;
import _m_j.gof;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.huf;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceNameActivity;
import java.util.ArrayList;
import java.util.List;

public class InitDeviceNameActivity extends InitNameBaseActivity implements ggx.O000000o {
    private String O00000oO;
    private String O00000oo;
    public final ggx mApi = new ggx();
    @BindView(6425)
    SimpleDraweeView mDeviceImg;
    @BindView(6432)
    EditText mDeviceNameEt;
    @BindView(6433)
    TextView mDeviceNameTips;
    @BindView(6449)
    View mDivider;
    public boolean mEditDeviceName;
    @BindView(6586)
    Button mGoNextBtn;
    @BindView(6707)
    View mInputClearBtn;
    public List<String> mRecommendNames;
    @BindView(7167)
    CommonFlowGroup mRecommendTagFlow;

    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.O00000o == null) {
            LogType logType = LogType.KUAILIAN;
            gsy.O00000o0(logType, "InitDeviceNameActivity", "device = null did = " + getIntent().getStringExtra("device_id"));
            finish();
            return;
        }
        setContentView((int) R.layout.activity_init_device_name);
        ButterKnife.bind(this);
        DeviceFactory.O00000Oo(this.O00000o.model, this.mDeviceImg);
        this.mInputClearBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceNameActivity$tyNMTZdzrgX9wx2BgZeN7CB3GaM */

            public final void onClick(View view) {
                InitDeviceNameActivity.this.O00000o0(view);
            }
        });
        this.mGoNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceNameActivity$fLrpMfGmyLsXvDUbShghgjxdLAM */

            public final void onClick(View view) {
                InitDeviceNameActivity.this.O00000Oo(view);
            }
        });
        this.O00000oO = getIntent().getStringExtra("device_room");
        this.mDeviceNameTips.setText("");
        this.O00000oo = getIntent().getStringExtra("device_name");
        if (!TextUtils.isEmpty(this.O00000oo)) {
            this.mDeviceNameEt.setText(this.O00000oo);
            this.mDeviceNameEt.setSelection(this.O00000oo.length());
            if (!this.O00000oo.equals(this.O00000o.name)) {
                this.mEditDeviceName = true;
            }
        } else if (this.O00000o.name != null) {
            this.mDeviceNameEt.setText(this.O00000o.name);
            this.mDeviceNameEt.setSelection(this.O00000o.name.length());
        }
        this.mDeviceNameEt.setCursorVisible(false);
        this.mInputClearBtn.setVisibility(8);
        this.mDeviceNameEt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceNameActivity$EVzDE1UPPH3FqTaZdgu6gAfNFOc */

            public final void onClick(View view) {
                InitDeviceNameActivity.this.O000000o(view);
            }
        });
        this.mDeviceNameEt.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceNameActivity.AnonymousClass1 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String obj = InitDeviceNameActivity.this.mDeviceNameEt.getText().toString();
                if (obj.length() > 0) {
                    boolean O00000o0 = gqb.O00000o0(obj);
                    InitDeviceNameActivity.this.mInputClearBtn.setVisibility(0);
                    InitDeviceNameActivity.this.mDeviceNameEt.setCursorVisible(true);
                    if (O00000o0) {
                        InitDeviceNameActivity.this.mGoNextBtn.setEnabled(false);
                        InitDeviceNameActivity.this.mDeviceNameTips.setText(InitDeviceNameActivity.this.getString(R.string.tag_save_data_description));
                        InitDeviceNameActivity.this.mDeviceNameTips.setTextColor(Color.parseColor("#FFF46666"));
                    } else if (!ggb.O0000oO(obj)) {
                        InitDeviceNameActivity.this.mGoNextBtn.setEnabled(false);
                        InitDeviceNameActivity.this.mDeviceNameTips.setText(InitDeviceNameActivity.this.getString(R.string.room_name_too_long));
                        InitDeviceNameActivity.this.mDeviceNameTips.setTextColor(Color.parseColor("#FFF46666"));
                    } else {
                        InitDeviceNameActivity initDeviceNameActivity = InitDeviceNameActivity.this;
                        initDeviceNameActivity.mEditDeviceName = true;
                        initDeviceNameActivity.mGoNextBtn.setEnabled(true);
                        InitDeviceNameActivity.this.mDeviceNameTips.setText("");
                    }
                } else {
                    InitDeviceNameActivity.this.mGoNextBtn.setEnabled(false);
                    InitDeviceNameActivity.this.mInputClearBtn.setVisibility(8);
                    InitDeviceNameActivity.this.mDeviceNameTips.setText("");
                }
                if (InitDeviceNameActivity.this.mRecommendTagFlow.getVisibility() == 0 && InitDeviceNameActivity.this.mRecommendNames != null) {
                    InitDeviceNameActivity.this.mRecommendTagFlow.setSelectIndex(-1);
                    for (int i4 = 0; i4 < InitDeviceNameActivity.this.mRecommendNames.size(); i4++) {
                        if (obj.equals(InitDeviceNameActivity.this.mRecommendNames.get(i4))) {
                            InitDeviceNameActivity.this.mRecommendTagFlow.setSelectIndex(i4);
                            return;
                        }
                    }
                }
            }
        });
        this.mRecommendTagFlow.O000000o(Boolean.FALSE);
        this.mRecommendTagFlow.setOnTagClickListener(new CommonFlowGroup.O000000o() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceNameActivity.AnonymousClass2 */

            public final void O000000o() {
            }

            public final void O000000o(int i) {
                if (InitDeviceNameActivity.this.mRecommendNames != null && InitDeviceNameActivity.this.mRecommendNames.size() > i) {
                    hxi.O00000o.O0000OoO(InitDeviceNameActivity.this.mRecommendNames.get(i));
                    InitDeviceNameActivity.this.mDeviceNameEt.setText(ggx.O000000o(InitDeviceNameActivity.this.O00000o, InitDeviceNameActivity.this.mRecommendNames.get(i)));
                }
            }
        });
        this.mApi.O000000o(this.O00000o.model, this);
        ggb.O00000Oo().O000000o((ggb.O00000o) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        this.mDeviceNameEt.setText("");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        this.mDeviceNameEt.setCursorVisible(true);
        if (!TextUtils.isEmpty(this.mDeviceNameEt.getText().toString())) {
            this.mInputClearBtn.setVisibility(0);
        }
    }

    public void onRecommendName(String str, List<String> list) {
        this.mRecommendNames = list;
        if (!this.mEditDeviceName && !TextUtils.isEmpty(str)) {
            String O000000o2 = ggx.O000000o(this.O00000o, str);
            this.mDeviceNameEt.setText(O000000o2);
            this.mDeviceNameEt.setSelection(O000000o2.length());
            this.mDeviceNameTips.setText((int) R.string.init_device_choose_name_tip);
            this.mEditDeviceName = true;
        }
        if (list.size() > 0) {
            this.mRecommendTagFlow.setVisibility(0);
            this.mRecommendTagFlow.setData(list);
            this.mDivider.setVisibility(0);
            this.mRecommendTagFlow.setSelectIndex(-1);
            for (int i = 0; i < list.size(); i++) {
                if (this.mDeviceNameEt.getText().toString().equals(list.get(i))) {
                    this.mRecommendTagFlow.setSelectIndex(i);
                    return;
                }
            }
        }
    }

    public void goNext() {
        LogType logType = LogType.HOME_ROOM;
        gsy.O00000Oo(logType, "InitDeviceNameActivity", "goNext  did:" + this.O00000o.did);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.O00000o.did);
        gfy.O000000o(arrayList, new fsm() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceNameActivity.AnonymousClass4 */

            public final void onSuccess(Object obj) {
                InitDeviceNameActivity.this.O000000o();
            }

            public final void onFailure(fso fso) {
                if (InitDeviceNameActivity.this.isValid()) {
                    gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceNameActivity", "error".concat(String.valueOf(fso)));
                    gqg.O00000Oo((int) R.string.set_failed);
                    if (InitDeviceNameActivity.this.O00000o0 != null && InitDeviceNameActivity.this.O00000o0.isShowing()) {
                        InitDeviceNameActivity.this.O00000o0.dismiss();
                    }
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        hxp hxp = hxi.O00000o0;
        String str = this.O00000o.model;
        hxp.f957O000000o.O000000o("adddevice_rename_show", "model", str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        if (!gof.O00000o0()) {
            gqg.O00000Oo((int) R.string.popup_select_loc_no_network);
        } else {
            if (this.O00000o0 == null || !this.O00000o0.isShowing()) {
                O00000Oo();
                this.O00000o0.show();
            }
            this.mApi.O000000o(this, this.O00000o, this.O00000oO, new Callback<String>() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitDeviceNameActivity.AnonymousClass3 */

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    InitDeviceNameActivity.this.goNext();
                }

                public final void onFailure(int i, String str) {
                    gsy.O00000o0(LogType.KUAILIAN, "InitDeviceNameActivity", str);
                    if (InitDeviceNameActivity.this.O00000o0 != null && InitDeviceNameActivity.this.O00000o0.isShowing()) {
                        InitDeviceNameActivity.this.O00000o0.dismiss();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (InitDeviceNameActivity.this.mEditDeviceName) {
                        String obj2 = InitDeviceNameActivity.this.mDeviceNameEt.getText().toString();
                        gsy.O00000Oo(LogType.HOME_ROOM, "InitDeviceNameActivity", "doSaveDeviceName:".concat(String.valueOf(obj2)));
                        if (!TextUtils.isEmpty(obj2)) {
                            InitDeviceNameActivity initDeviceNameActivity = InitDeviceNameActivity.this;
                            initDeviceNameActivity.O000000o(initDeviceNameActivity.O00000o, obj2, new huf() {
                                /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitDeviceNameActivity$3$zoMAJBRWUNcIY9qd0K_XxANJnmU */

                                public final void accept(String str) {
                                    InitDeviceNameActivity.AnonymousClass3.this.O000000o(str);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    InitDeviceNameActivity.this.goNext();
                }
            });
        }
        hxk hxk = hxi.O00000o;
        String str = this.mEditDeviceName ? "2" : "1";
        hxk.f952O000000o.O000000o("adddevice_rename_next", "type", str, "device-name", this.mDeviceNameEt.getText().toString(), "model", this.O00000o.model);
    }
}
