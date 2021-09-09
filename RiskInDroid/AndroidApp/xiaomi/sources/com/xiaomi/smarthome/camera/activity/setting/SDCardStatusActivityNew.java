package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.cin;
import _m_j.civ;
import _m_j.cll;
import _m_j.clq;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gkv;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import _m_j.me;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mijia.model.sdcard.SDCardInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.camera.view.widget.XmLoadingDialog;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SDCardStatusActivityNew extends CameraBaseActivity {
    public int CHECK_DURATION = 8000;
    public int SD_FORMAT_CHECK = 2001;
    private boolean isResume = false;
    public boolean isStopRecord;
    public cll mCameraProperties;
    MLAlertDialog mFormatErrorDialog;
    public SettingsItemView mFormatSdcard;
    public TextView mLeftSpace;
    public TextView mLeftSpaceNum;
    public View mLoadingView;
    private SettingsItemView mPushOutSdcard;
    public String mRecordStatus;
    private SettingsItemView mRecordingMode;
    private TextView mSdcardStatus;
    private ImageView mSdcardStatusBg;
    private TextView mSdcardStatusHint;
    public int mStatus = -1;
    private SettingsItemView mStorageSwitch;
    private TextView mTitleView;
    public TextView mTotalSpace;
    private View mbackView;
    MLAlertDialog.Builder mlAlertDialog;
    AlertDialog progressDialog;
    public int selectedModeIndex;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_sdcard_status_new);
        initView();
        initData();
    }

    private void initData() {
        this.mCameraProperties = this.mCameraDevice.O000000o();
        refreshUI();
        this.mCameraProperties.O000000o(new String[]{"sdcard_status", "motion_record"}, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass1 */

            public void onSuccess(Void voidR) {
                if (!SDCardStatusActivityNew.this.isFinishing()) {
                    SDCardStatusActivityNew.this.refreshUI();
                }
            }

            public void onFailure(int i, String str) {
                if (!SDCardStatusActivityNew.this.isFinishing()) {
                    SDCardStatusActivityNew.this.refreshUI();
                }
            }
        });
    }

    public void refreshUI() {
        StringBuilder sb = new StringBuilder("sdcarad status display status:");
        getResources();
        sb.append(cin.O000000o(this.mStatus, this.isStopRecord));
        civ.O00000o("SdCard", sb.toString());
        if (this.mCameraSpecDevice != null) {
            Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "recording-mode");
            int intValue = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 2;
            if (intValue == 2) {
                this.isStopRecord = true;
                int i = this.mStatus;
                if (3 == i) {
                    updateSdcardStatus(i);
                } else {
                    updateSdcardStatus(6);
                }
            } else {
                this.isStopRecord = false;
                updateSdcardStatus(this.mStatus);
            }
            if (intValue == 0) {
                this.mRecordingMode.setVisibility(0);
                this.mRecordingMode.setInfo(getString(R.string.setting_record_model_always));
                this.mStorageSwitch.setChecked(true);
            } else if (intValue != 2) {
                this.mRecordingMode.setVisibility(0);
                this.mRecordingMode.setInfo(getString(R.string.setting_record_model_move));
                this.mStorageSwitch.setChecked(true);
            } else {
                this.mRecordingMode.setVisibility(8);
                this.mStorageSwitch.setChecked(false);
            }
        } else {
            String O00000o0 = this.mCameraProperties.O00000o0();
            if ("stop".equalsIgnoreCase(O00000o0)) {
                this.isStopRecord = true;
            } else {
                this.isStopRecord = false;
            }
            getResources();
            updateSdcardStatus(cin.O000000o(this.mStatus, this.isStopRecord));
            char c = 65535;
            int hashCode = O00000o0.hashCode();
            if (hashCode != 109935) {
                if (hashCode == 3540994 && O00000o0.equals("stop")) {
                    c = 0;
                }
            } else if (O00000o0.equals("off")) {
                c = 1;
            }
            if (c == 0) {
                this.mRecordingMode.setVisibility(8);
                this.mStorageSwitch.setChecked(false);
            } else if (c != 1) {
                this.mRecordingMode.setVisibility(0);
                this.mRecordingMode.setInfo(getString(R.string.setting_record_model_move));
                this.mStorageSwitch.setChecked(true);
            } else {
                this.mRecordingMode.setVisibility(0);
                this.mRecordingMode.setInfo(getString(R.string.setting_record_model_always));
                this.mStorageSwitch.setChecked(true);
            }
        }
    }

    private void initView() {
        this.mSdcardStatus = (TextView) findViewById(R.id.tvSdcardStatus);
        this.mSdcardStatusBg = (ImageView) findViewById(R.id.ivSdcardStatusBg);
        this.mLeftSpace = (TextView) findViewById(R.id.tvLeftSpace);
        this.mLeftSpaceNum = (TextView) findViewById(R.id.tvLeftSpaceNum);
        this.mTotalSpace = (TextView) findViewById(R.id.tvTotalSpace);
        this.mLoadingView = findViewById(R.id.loading_layout);
        this.mStorageSwitch = (SettingsItemView) findViewById(R.id.settings_storage_switch);
        this.mRecordingMode = (SettingsItemView) findViewById(R.id.settings_record_mode);
        this.mFormatSdcard = (SettingsItemView) findViewById(R.id.settings_storage_format);
        this.mFormatSdcard.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$SDCardStatusActivityNew$tqku4keuy717BiNt3YUxdyNhIw */

            public final void onClick(View view) {
                SDCardStatusActivityNew.this.lambda$initView$0$SDCardStatusActivityNew(view);
            }
        });
        this.mPushOutSdcard = (SettingsItemView) findViewById(R.id.settings_storage_out);
        this.mPushOutSdcard.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$SDCardStatusActivityNew$VHDAgGTqwNvIeoL0CCBgAVBTZgc */

            public final void onClick(View view) {
                SDCardStatusActivityNew.this.lambda$initView$1$SDCardStatusActivityNew(view);
            }
        });
        this.mbackView = findViewById(R.id.title_bar_return);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleView.setText((int) R.string.more_store_setting);
        this.mbackView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$SDCardStatusActivityNew$WLJGYqmwaWnJS6lcA43owkJ0X7k */

            public final void onClick(View view) {
                SDCardStatusActivityNew.this.lambda$initView$2$SDCardStatusActivityNew(view);
            }
        });
        this.mSdcardStatusHint = (TextView) findViewById(R.id.tvSdcardStatusHint);
        this.mSdcardStatusHint.setVisibility(8);
        findViewById(R.id.storage_status_container).setVisibility(8);
        this.mStorageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SDCardStatusActivityNew sDCardStatusActivityNew = SDCardStatusActivityNew.this;
                    sDCardStatusActivityNew.isStopRecord = false;
                    if (sDCardStatusActivityNew.mCameraSpecDevice != null) {
                        faw.O000000o().setDeviceProp(SDCardStatusActivityNew.this.mCameraDevice.getDid(), SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o(SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("camera-control"), "recording-mode"), 0, new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass2.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (!SDCardStatusActivityNew.this.isFinishing()) {
                                    izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.settings_set_success, 0).show();
                                    SDCardStatusActivityNew.this.mCameraProperties.O00000Oo("motion_record", "off");
                                    SDCardStatusActivityNew.this.refreshUI();
                                }
                            }

                            public void onFailure(fso fso) {
                                if (!SDCardStatusActivityNew.this.isFinishing()) {
                                    izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.set_failed, 0).show();
                                }
                            }
                        });
                    } else if (!"off".equalsIgnoreCase(SDCardStatusActivityNew.this.mCameraProperties.O00000o0())) {
                        SDCardStatusActivityNew.this.mCameraProperties.O000000o("motion_record", "off", new Callback<Void>() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass2.AnonymousClass2 */

                            public void onSuccess(Void voidR) {
                                if (!SDCardStatusActivityNew.this.isFinishing()) {
                                    izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.settings_set_success, 0).show();
                                    SDCardStatusActivityNew.this.refreshUI();
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!SDCardStatusActivityNew.this.isFinishing()) {
                                    izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.set_failed, 0).show();
                                }
                            }
                        });
                    }
                } else if (SDCardStatusActivityNew.this.mCameraSpecDevice != null) {
                    faw.O000000o().setDeviceProp(SDCardStatusActivityNew.this.mCameraDevice.getDid(), SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o(SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("camera-control"), "recording-mode"), 2, new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass2.AnonymousClass3 */

                        public void onSuccess(JSONObject jSONObject) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.settings_set_success, 0).show();
                                SDCardStatusActivityNew.this.mCameraProperties.O00000Oo("motion_record", "stop");
                                SDCardStatusActivityNew.this.refreshUI();
                            }
                        }

                        public void onFailure(fso fso) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.set_failed, 0).show();
                            }
                        }
                    });
                } else if (!"stop".equalsIgnoreCase(SDCardStatusActivityNew.this.mCameraProperties.O00000o0())) {
                    SDCardStatusActivityNew.this.mCameraProperties.O000000o("motion_record", "stop", new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass2.AnonymousClass4 */

                        public void onSuccess(Void voidR) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.settings_set_success, 0).show();
                                SDCardStatusActivityNew.this.refreshUI();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.set_failed, 0).show();
                            }
                        }
                    });
                }
            }
        });
        this.mRecordingMode.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass3 */

            public void onClick(View view) {
                SDCardStatusActivityNew.this.changeRecordMode();
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$SDCardStatusActivityNew(View view) {
        doFormat();
    }

    public /* synthetic */ void lambda$initView$1$SDCardStatusActivityNew(View view) {
        doPushOut();
    }

    public /* synthetic */ void lambda$initView$2$SDCardStatusActivityNew(View view) {
        finish();
    }

    public void changeRecordMode() {
        RecordModeAdapter recordModeAdapter = new RecordModeAdapter();
        this.mRecordStatus = this.mCameraProperties.O00000o0();
        String str = this.mRecordStatus;
        if (str != null) {
            if ("on".equalsIgnoreCase(str)) {
                recordModeAdapter.setSelected(0);
                this.selectedModeIndex = 0;
            } else {
                recordModeAdapter.setSelected(1);
                this.selectedModeIndex = 1;
            }
            new MLAlertDialog.Builder(this).O000000o(getString(R.string.setting_record_model)).O000000o(recordModeAdapter, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i != SDCardStatusActivityNew.this.selectedModeIndex) {
                        if (SDCardStatusActivityNew.this.mCameraSpecDevice != null) {
                            int i2 = 0;
                            if (SDCardStatusActivityNew.this.selectedModeIndex == 1) {
                                i2 = 1;
                            }
                            if (i2 == 0) {
                                SDCardStatusActivityNew.this.mRecordStatus = "off";
                            } else {
                                SDCardStatusActivityNew.this.mRecordStatus = "on";
                            }
                            faw.O000000o().setDeviceProp(SDCardStatusActivityNew.this.mCameraDevice.getDid(), SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o(SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("camera-control"), "recording-mode"), Integer.valueOf(i2), new fsm<JSONObject, fso>() {
                                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass4.AnonymousClass1 */

                                public void onSuccess(JSONObject jSONObject) {
                                    if (!SDCardStatusActivityNew.this.isFinishing()) {
                                        izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.settings_set_success, 0).show();
                                        SDCardStatusActivityNew.this.mCameraProperties.O00000Oo("motion_record", SDCardStatusActivityNew.this.mRecordStatus);
                                        SDCardStatusActivityNew.this.refreshUI();
                                    }
                                }

                                public void onFailure(fso fso) {
                                    if (!SDCardStatusActivityNew.this.isFinishing()) {
                                        izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.set_failed, 0).show();
                                    }
                                }
                            });
                            return;
                        }
                        if (i == 0) {
                            SDCardStatusActivityNew.this.mRecordStatus = "on";
                        } else {
                            SDCardStatusActivityNew.this.mRecordStatus = "off";
                        }
                        if (!SDCardStatusActivityNew.this.mRecordStatus.equals(SDCardStatusActivityNew.this.mCameraProperties.O00000o0())) {
                            SDCardStatusActivityNew.this.mCameraProperties.O000000o("motion_record", SDCardStatusActivityNew.this.mRecordStatus, new Callback<Void>() {
                                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass4.AnonymousClass2 */

                                public void onSuccess(Void voidR) {
                                    if (!SDCardStatusActivityNew.this.isFinishing()) {
                                        izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.settings_set_success, 0).show();
                                        SDCardStatusActivityNew.this.refreshUI();
                                    }
                                }

                                public void onFailure(int i, String str) {
                                    if (!SDCardStatusActivityNew.this.isFinishing()) {
                                        izb.O000000o(SDCardStatusActivityNew.this.activity(), (int) R.string.set_failed, 0).show();
                                    }
                                }
                            });
                        }
                    }
                }
            }).O00000o().show();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.isResume) {
            loadData(false);
        } else {
            loadData(true);
        }
        this.isResume = true;
    }

    public void handleMessage(Message message) {
        if (message.what == this.SD_FORMAT_CHECK) {
            checkFormat();
        }
    }

    public void loadData(boolean z) {
        if (z) {
            this.mLoadingView.setVisibility(0);
        }
        AnonymousClass5 r0 = new Callback<SDCardInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass5 */

            public void onSuccess(SDCardInfo sDCardInfo) {
                if (!SDCardStatusActivityNew.this.isFinishing()) {
                    if (SDCardStatusActivityNew.this.progressDialog != null && SDCardStatusActivityNew.this.progressDialog.isShowing()) {
                        SDCardStatusActivityNew.this.progressDialog.dismiss();
                    }
                    SDCardStatusActivityNew.this.mLoadingView.setVisibility(8);
                    SDCardStatusActivityNew.this.findViewById(R.id.storage_status_container).setVisibility(0);
                    civ.O00000o("SdCard", "sdcarad status success status:" + sDCardInfo.O00000oO);
                    SDCardStatusActivityNew.this.parseInfo(sDCardInfo);
                }
            }

            public void onFailure(int i, String str) {
                if (!SDCardStatusActivityNew.this.isFinishing()) {
                    civ.O00000o("SdCard", "sdcarad status fail " + i + " : " + str);
                    SDCardStatusActivityNew.this.initAlertDlg();
                    SDCardStatusActivityNew.this.mLoadingView.setVisibility(8);
                    SDCardStatusActivityNew.this.getString(R.string.sdcard_error);
                    SDCardStatusActivityNew.this.parseInfo(null);
                    if (i == -2003) {
                        String string = SDCardStatusActivityNew.this.getString(R.string.sdcard_no);
                        SDCardStatusActivityNew.this.activity();
                        gqg.O000000o(string);
                        SDCardStatusActivityNew sDCardStatusActivityNew = SDCardStatusActivityNew.this;
                        sDCardStatusActivityNew.mStatus = 1;
                        sDCardStatusActivityNew.refreshUI();
                    } else if (i == -2000) {
                        SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                        SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                        String string2 = SDCardStatusActivityNew.this.getString(R.string.sdcard_formating);
                        SDCardStatusActivityNew.this.activity();
                        gqg.O000000o(string2);
                        SDCardStatusActivityNew sDCardStatusActivityNew2 = SDCardStatusActivityNew.this;
                        sDCardStatusActivityNew2.mStatus = 4;
                        sDCardStatusActivityNew2.refreshUI();
                    } else if (i == -2002) {
                        SDCardStatusActivityNew sDCardStatusActivityNew3 = SDCardStatusActivityNew.this;
                        sDCardStatusActivityNew3.mStatus = 3;
                        sDCardStatusActivityNew3.refreshUI();
                    } else if (i == -2005) {
                        SDCardStatusActivityNew.this.mlAlertDialog.O000000o((int) R.string.sdcard_tip);
                        SDCardStatusActivityNew.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_error_out);
                        SDCardStatusActivityNew.this.mlAlertDialog.O00000Oo((int) R.string.know_button, (DialogInterface.OnClickListener) null);
                        SDCardStatusActivityNew.this.mlAlertDialog.O00000oo();
                        SDCardStatusActivityNew sDCardStatusActivityNew4 = SDCardStatusActivityNew.this;
                        sDCardStatusActivityNew4.mStatus = 5;
                        sDCardStatusActivityNew4.refreshUI();
                    } else {
                        SDCardStatusActivityNew sDCardStatusActivityNew5 = SDCardStatusActivityNew.this;
                        sDCardStatusActivityNew5.mStatus = 3;
                        sDCardStatusActivityNew5.refreshUI();
                        SDCardStatusActivityNew.this.mlAlertDialog.O000000o((int) R.string.sdcard_tip);
                        SDCardStatusActivityNew.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_error_tip);
                        SDCardStatusActivityNew.this.mlAlertDialog.O000000o((int) R.string.common_retry, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass5.AnonymousClass1 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                SDCardStatusActivityNew.this.loadData(true);
                            }
                        });
                        SDCardStatusActivityNew.this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                        SDCardStatusActivityNew.this.mlAlertDialog.O00000oo();
                    }
                }
            }
        };
        if (!this.mCameraDevice.O00000o()) {
            this.mCameraDevice.O0000Oo0().O000000o(r0, z);
        } else if (this.mCameraSpecDevice != null) {
            loadSpecData();
        } else {
            this.mCameraDevice.O0000OOo().O000000o(r0, z);
        }
    }

    private void loadSpecData() {
        SpecService O000000o2 = this.mCameraSpecDevice.O000000o("memory-card-management");
        SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "status");
        SpecProperty O000000o4 = this.mCameraSpecDevice.O000000o(O000000o2, "storage-total-space");
        SpecProperty O000000o5 = this.mCameraSpecDevice.O000000o(O000000o2, "storage-free-space");
        SpecProperty O000000o6 = this.mCameraSpecDevice.O000000o(O000000o2, "storage-used-space");
        SpecProperty O000000o7 = this.mCameraSpecDevice.O000000o(this.mCameraSpecDevice.O000000o("camera-control"), "recording-mode");
        if (O000000o2 != null && O000000o3 != null && O000000o4 != null && O000000o5 != null && O000000o6 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o3));
            arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o4));
            arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o5));
            arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o6));
            arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o7));
            faw.O00000o().getDeviceSpecProp(gkv.f17949O000000o, arrayList, new fsm<List<PropertyParam>, fso>() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass6 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    if (!SDCardStatusActivityNew.this.isFinishing()) {
                        SDCardStatusActivityNew.this.disProgressDlg();
                        SDCardStatusActivityNew.this.mLoadingView.setVisibility(8);
                        SDCardStatusActivityNew.this.findViewById(R.id.storage_status_container).setVisibility(0);
                        SDCardStatusActivityNew.this.mLeftSpace.setText("");
                        SDCardStatusActivityNew.this.mTotalSpace.setText("");
                        SDCardStatusActivityNew.this.mLeftSpaceNum.setText("");
                        if (list != null) {
                            int i = 0;
                            int i2 = 0;
                            for (PropertyParam next : list) {
                                SpecProperty O000000o2 = SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o(next.getSiid(), next.getPiid());
                                gsy.O00000Oo("SDCardStatusActivityNew", "getTypeName:" + O000000o2.getDefinition().getTypeName() + " property:" + next.toString());
                                if (O000000o2.getDefinition().getTypeName().equalsIgnoreCase("status")) {
                                    int intValue = ((Integer) next.getValue()).intValue();
                                    if (intValue >= 0) {
                                        SDCardStatusActivityNew sDCardStatusActivityNew = SDCardStatusActivityNew.this;
                                        sDCardStatusActivityNew.mStatus = intValue;
                                        if (sDCardStatusActivityNew.mStatus == 4) {
                                            SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                                            SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                                        }
                                        SDCardStatusActivityNew sDCardStatusActivityNew2 = SDCardStatusActivityNew.this;
                                        sDCardStatusActivityNew2.updateSdcardStatus(sDCardStatusActivityNew2.mStatus);
                                    }
                                } else if (O000000o2.getDefinition().getTypeName().equalsIgnoreCase("storage-total-space")) {
                                    i = ((Integer) next.getValue()).intValue();
                                } else if (O000000o2.getDefinition().getTypeName().equalsIgnoreCase("storage-free-space")) {
                                    i2 = ((Integer) next.getValue()).intValue();
                                } else if (O000000o2.getDefinition().getTypeName().equalsIgnoreCase("storage-used-space")) {
                                    ((Integer) next.getValue()).intValue();
                                } else if (O000000o2.getDefinition().getTypeName().equalsIgnoreCase("recording-mode")) {
                                    int intValue2 = ((Integer) next.getValue()).intValue();
                                    if (intValue2 == 0) {
                                        SDCardStatusActivityNew.this.mCameraProperties.O00000Oo("motion_record", "off");
                                    } else if (intValue2 == 1) {
                                        SDCardStatusActivityNew.this.mCameraProperties.O00000Oo("motion_record", "on");
                                    } else if (intValue2 == 2) {
                                        SDCardStatusActivityNew.this.mCameraProperties.O00000Oo("motion_record", "stop");
                                    }
                                }
                            }
                            if (i <= 0 || i2 <= 0) {
                                SDCardStatusActivityNew.this.mLeftSpace.setText("");
                                SDCardStatusActivityNew.this.mTotalSpace.setText("");
                                SDCardStatusActivityNew.this.mLeftSpaceNum.setText("");
                            } else {
                                SDCardStatusActivityNew.this.mLeftSpace.setText(SDCardStatusActivityNew.this.activity().getString(R.string.camera_storage_left_space));
                                SDCardStatusActivityNew.this.mLeftSpaceNum.setText(me.O000000o(((long) i2) * 1024));
                                SDCardStatusActivityNew.this.mTotalSpace.setText(SDCardStatusActivityNew.this.activity().getString(R.string.camera_storage_total_space, new Object[]{me.O000000o(((long) i) * 1024)}));
                            }
                        }
                        SDCardStatusActivityNew.this.refreshUI();
                    }
                }

                public void onFailure(fso fso) {
                    if (!SDCardStatusActivityNew.this.isFinishing()) {
                        SDCardStatusActivityNew.this.mLeftSpace.setText("");
                        SDCardStatusActivityNew.this.mTotalSpace.setText("");
                        SDCardStatusActivityNew.this.mLeftSpaceNum.setText("");
                        if (fso != null) {
                            gsy.O000000o(6, "SDCardStatusActivityNew", "checkFormat getDevicePropFromServer fail:" + fso.f17063O000000o + " " + fso.O00000Oo);
                            return;
                        }
                        gsy.O000000o(6, "SDCardStatusActivityNew", "checkFormat getDevicePropFromServer fail");
                    }
                }
            });
        }
    }

    public void parseInfo(SDCardInfo sDCardInfo) {
        if (sDCardInfo == null) {
            this.mLeftSpace.setText("");
            this.mTotalSpace.setText("");
            this.mLeftSpaceNum.setText("");
            return;
        }
        if (!(sDCardInfo.O00000oO == -1 || sDCardInfo.O00000oO == this.mStatus || this.mCameraSpecDevice != null)) {
            this.mStatus = sDCardInfo.O00000oO;
            getResources();
            updateSdcardStatus(cin.O000000o(this.mStatus, this.isStopRecord));
            this.mCameraDevice.O000000o().O000000o("sdcard_status", Integer.valueOf(this.mStatus));
        }
        if (sDCardInfo.O00000Oo <= 0 || sDCardInfo.f5242O000000o <= 0) {
            this.mLeftSpace.setText("");
            this.mTotalSpace.setText("");
            this.mLeftSpaceNum.setText("");
            return;
        }
        this.mLeftSpace.setText(activity().getString(R.string.camera_storage_left_space));
        this.mLeftSpaceNum.setText(me.O000000o(sDCardInfo.O00000Oo));
        this.mTotalSpace.setText(activity().getString(R.string.camera_storage_total_space, new Object[]{me.O000000o(sDCardInfo.f5242O000000o)}));
    }

    public void updateSdcardStatus(int i) {
        if (this.mCameraSpecDevice != null) {
            findViewById(R.id.storage_status_container).setVisibility(0);
            this.mSdcardStatusHint.setVisibility(4);
            if (i == 0) {
                this.mSdcardStatus.setText(getString(R.string.camera_storage_normal));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_normal);
            } else if (i == 1 || i == 2 || i == 3) {
                this.mSdcardStatus.setText(getString(R.string.camera_storage_unnormal));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_unnormal);
                this.mSdcardStatusHint.setVisibility(0);
            } else if (i == 4) {
                this.mSdcardStatus.setText(getString(R.string.sd_card_status4));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_stopped);
            } else if (i == 5 || i == 6 || i == 7) {
                this.mSdcardStatus.setText(getString(R.string.camera_storage_pause));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_stopped);
            }
        } else {
            findViewById(R.id.storage_status_container).setVisibility(0);
            this.mSdcardStatusHint.setVisibility(4);
            if (i == 1) {
                this.mSdcardStatus.setText(getString(R.string.camera_storage_normal));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_normal);
            } else if (i == 2) {
                this.mSdcardStatus.setText(getString(R.string.camera_storage_unnormal));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_unnormal);
                this.mSdcardStatusHint.setVisibility(0);
            } else if (i == 3) {
                this.mSdcardStatus.setText(getString(R.string.camera_storage_pause));
                this.mSdcardStatusBg.setImageResource(R.drawable.camera_sdcard_status_stopped);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cls.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew$7, int]
     candidates:
      _m_j.cls.O000000o(java.util.List<com.mijia.model.sdcard.TimeItem>, com.xiaomi.smarthome.device.api.Callback<org.json.JSONObject>):void
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.cls.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew$7, int]
     candidates:
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    private void checkFormat() {
        this.mHandler.removeMessages(this.SD_FORMAT_CHECK);
        AnonymousClass7 r0 = new Callback<SDCardInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass7 */

            public void onSuccess(SDCardInfo sDCardInfo) {
                if (!SDCardStatusActivityNew.this.isFinishing()) {
                    SDCardStatusActivityNew.this.disProgressDlg();
                    SDCardStatusActivityNew.this.parseInfo(sDCardInfo);
                    SDCardStatusActivityNew.this.activity();
                    gqg.O000000o((int) R.string.sdcard_format_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!SDCardStatusActivityNew.this.isFinishing()) {
                    if (i == -2000) {
                        SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                        return;
                    }
                    SDCardStatusActivityNew.this.disProgressDlg();
                    civ.O00000o("SdCard", "check format error ".concat(String.valueOf(i)));
                    SDCardStatusActivityNew.this.mFormatSdcard.setEnabled(true);
                    SDCardStatusActivityNew.this.mFormatSdcard.setTitleColor(Color.parseColor("#e94f4f"));
                    SDCardStatusActivityNew.this.showFormatErrorDialog();
                }
            }
        };
        if (!this.mCameraDevice.O00000o()) {
            this.mCameraDevice.O0000OOo().O000000o((Callback<SDCardInfo>) r0, true);
        } else if (this.mCameraSpecDevice != null) {
            loadSpecData();
        } else {
            this.mCameraDevice.O0000Oo0().O000000o((Callback<SDCardInfo>) r0, true);
        }
    }

    private void doFormat() {
        initAlertDlg();
        this.mlAlertDialog.O000000o((int) R.string.sdcard_format);
        this.mlAlertDialog.O00000Oo((int) R.string.sdcard_format_tip);
        this.mlAlertDialog.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass8 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                SDCardStatusActivityNew sDCardStatusActivityNew = SDCardStatusActivityNew.this;
                sDCardStatusActivityNew.initProgressDlg(sDCardStatusActivityNew.getString(R.string.sdcard_formating));
                if (!SDCardStatusActivityNew.this.mCameraDevice.O00000o()) {
                    SDCardStatusActivityNew.this.mCameraDevice.O0000OOo().O00000o0(new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass8.AnonymousClass3 */

                        public void onSuccess(Object obj) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                                SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                if (i == -2000) {
                                    SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                                    SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                                    SDCardStatusActivityNew.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_formating);
                                    return;
                                }
                                if (i == -2003) {
                                    SDCardStatusActivityNew.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_no);
                                } else {
                                    civ.O00000o("SdCard", "format error " + i + " info ");
                                    SDCardStatusActivityNew.this.mFormatSdcard.setEnabled(true);
                                    SDCardStatusActivityNew.this.mFormatSdcard.setTitleColor(Color.parseColor("#e94f4f"));
                                    SDCardStatusActivityNew.this.showFormatErrorDialog();
                                }
                                SDCardStatusActivityNew.this.disProgressDlg();
                            }
                        }
                    });
                } else if (SDCardStatusActivityNew.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("memory-card-management");
                    SpecAction O000000o3 = SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("memory-card-management", "format");
                    if (O000000o2 == null || O000000o3 == null) {
                        SDCardStatusActivityNew.this.disProgressDlg();
                        return;
                    }
                    faw.O00000o().setDeviceSpecAction(gkv.f17949O000000o, new ActionParam(SDCardStatusActivityNew.this.mCameraDevice.getDid(), O000000o3, null), new fsm<ActionParam, fso>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass8.AnonymousClass1 */

                        public void onSuccess(ActionParam actionParam) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                                SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                                SDCardStatusActivityNew.this.mCameraDevice.O0000Oo0().O0000Oo0();
                                SDCardStatusActivityNew.this.mCameraDevice.O0000Oo();
                                clq.O000000o();
                            }
                        }

                        public void onFailure(fso fso) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                if (fso != null) {
                                    gsy.O00000Oo("SDCardStatusActivityNew", "memory-card-management format fail:" + fso.f17063O000000o + fso.O00000Oo);
                                } else {
                                    gsy.O00000Oo("SDCardStatusActivityNew", "memory-card-management format fail");
                                }
                                SDCardStatusActivityNew.this.disProgressDlg();
                            }
                        }
                    });
                } else {
                    SDCardStatusActivityNew.this.mCameraDevice.O0000Oo0().O00000o0(new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass8.AnonymousClass2 */

                        public void onSuccess(Object obj) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                                SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                                SDCardStatusActivityNew.this.mCameraDevice.O0000Oo0().O0000Oo0();
                                SDCardStatusActivityNew.this.mCameraDevice.O0000Oo();
                                clq.O000000o();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                if (i == -2000) {
                                    SDCardStatusActivityNew.this.mHandler.removeMessages(SDCardStatusActivityNew.this.SD_FORMAT_CHECK);
                                    SDCardStatusActivityNew.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivityNew.this.SD_FORMAT_CHECK, (long) SDCardStatusActivityNew.this.CHECK_DURATION);
                                    SDCardStatusActivityNew.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_formating);
                                    return;
                                }
                                if (i == -2003) {
                                    SDCardStatusActivityNew.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_no);
                                } else {
                                    civ.O00000o("SdCard", "format error " + i + " info ");
                                    SDCardStatusActivityNew.this.mFormatSdcard.setEnabled(true);
                                    SDCardStatusActivityNew.this.mFormatSdcard.setTitleColor(Color.parseColor("#e94f4f"));
                                    SDCardStatusActivityNew.this.showFormatErrorDialog();
                                }
                                SDCardStatusActivityNew.this.disProgressDlg();
                            }
                        }
                    });
                }
            }
        });
        this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        this.mlAlertDialog.O00000oo();
    }

    public void showFormatErrorDialog() {
        if (this.mFormatErrorDialog == null) {
            this.mFormatErrorDialog = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.camer_sdcard_format_error).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass9 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    SDCardStatusActivityNew.this.mFormatErrorDialog.dismiss();
                }
            }).O00000o();
        }
        if (!this.mFormatErrorDialog.isShowing()) {
            this.mFormatErrorDialog.show();
        }
    }

    public void finish() {
        setResult(-1);
        super.finish();
    }

    private void doPushOut() {
        if (this.mStatus == 5) {
            activity();
            gqg.O000000o((int) R.string.sdcard_out_already);
            return;
        }
        initAlertDlg();
        this.mlAlertDialog.O000000o((int) R.string.sdcard_out);
        this.mlAlertDialog.O00000Oo((int) R.string.sdcard_out_tips);
        this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        this.mlAlertDialog.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass10 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                SDCardStatusActivityNew sDCardStatusActivityNew = SDCardStatusActivityNew.this;
                sDCardStatusActivityNew.initProgressDlg(sDCardStatusActivityNew.getString(R.string.sdcard_out));
                SDCardStatusActivityNew.this.progressDialog.show();
                if (!SDCardStatusActivityNew.this.mCameraDevice.O00000o()) {
                    SDCardStatusActivityNew.this.mCameraDevice.O0000OOo().O00000o(new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass10.AnonymousClass3 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                          _m_j.cll.O000000o(java.lang.String, boolean):boolean
                          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void */
                        public void onSuccess(Object obj) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.disProgressDlg();
                                SDCardStatusActivityNew.this.activity();
                                gqg.O000000o((int) R.string.sdcard_out_success);
                                SDCardStatusActivityNew.this.mCameraDevice.O000000o().O000000o("sdcard_status", (Object) 5);
                                SDCardStatusActivityNew.this.mFormatSdcard.setEnabled(false);
                                SDCardStatusActivityNew.this.mFormatSdcard.setTitleColor(-7829368);
                                SDCardStatusActivityNew.this.finish();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.activity();
                                gqg.O000000o((int) R.string.sdcard_out_fail);
                                SDCardStatusActivityNew.this.disProgressDlg();
                            }
                        }
                    });
                } else if (SDCardStatusActivityNew.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("memory-card-management");
                    SpecAction O000000o3 = SDCardStatusActivityNew.this.mCameraSpecDevice.O000000o("memory-card-management", "pop-up");
                    if (O000000o2 == null || O000000o3 == null) {
                        SDCardStatusActivityNew.this.disProgressDlg();
                        return;
                    }
                    faw.O00000o().setDeviceSpecAction(gkv.f17949O000000o, new ActionParam(SDCardStatusActivityNew.this.mCameraDevice.getDid(), O000000o3, null), new fsm<ActionParam, fso>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass10.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                          _m_j.cll.O000000o(java.lang.String, boolean):boolean
                          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void */
                        public void onSuccess(ActionParam actionParam) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.disProgressDlg();
                                SDCardStatusActivityNew.this.activity();
                                gqg.O000000o((int) R.string.sdcard_out_success);
                                SDCardStatusActivityNew.this.mCameraDevice.O000000o().O000000o("sdcard_status", (Object) 5);
                                SDCardStatusActivityNew.this.mFormatSdcard.setEnabled(false);
                                SDCardStatusActivityNew.this.mFormatSdcard.setTitleColor(-7829368);
                                SDCardStatusActivityNew.this.finish();
                            }
                        }

                        public void onFailure(fso fso) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.activity();
                                gqg.O000000o((int) R.string.sdcard_out_fail);
                                SDCardStatusActivityNew.this.disProgressDlg();
                            }
                        }
                    });
                } else {
                    SDCardStatusActivityNew.this.mCameraDevice.O0000Oo0().O00000o(new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivityNew.AnonymousClass10.AnonymousClass2 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                          _m_j.cll.O000000o(java.lang.String, boolean):boolean
                          _m_j.cll.O000000o(java.lang.String, java.lang.Object):void */
                        public void onSuccess(Object obj) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.disProgressDlg();
                                SDCardStatusActivityNew.this.activity();
                                gqg.O000000o((int) R.string.sdcard_out_success);
                                SDCardStatusActivityNew.this.mCameraDevice.O000000o().O000000o("sdcard_status", (Object) 5);
                                SDCardStatusActivityNew.this.mFormatSdcard.setEnabled(false);
                                SDCardStatusActivityNew.this.mFormatSdcard.setTitleColor(-7829368);
                                SDCardStatusActivityNew.this.finish();
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivityNew.this.isFinishing()) {
                                SDCardStatusActivityNew.this.activity();
                                gqg.O000000o((int) R.string.sdcard_out_fail);
                                SDCardStatusActivityNew.this.disProgressDlg();
                            }
                        }
                    });
                }
            }
        });
        this.mlAlertDialog.O00000oo();
    }

    public void initProgressDlg(String str) {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        this.progressDialog = XmLoadingDialog.show(activity(), str);
    }

    public void initAlertDlg() {
        if (this.mlAlertDialog == null) {
            this.mlAlertDialog = new MLAlertDialog.Builder(this);
        }
    }

    public void disProgressDlg() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    class RecordModeAdapter extends BaseAdapter {
        List<RecordModeEntity> datas;
        int selectedIndex;

        public long getItemId(int i) {
            return (long) i;
        }

        public RecordModeAdapter() {
            this.datas = null;
            this.selectedIndex = 0;
            this.datas = new ArrayList();
            this.datas.add(new RecordModeEntity(SDCardStatusActivityNew.this.getString(R.string.setting_record_model_move), SDCardStatusActivityNew.this.getString(R.string.setting_record_model_move_title)));
            this.datas.add(new RecordModeEntity(SDCardStatusActivityNew.this.getString(R.string.setting_record_model_always), SDCardStatusActivityNew.this.getString(R.string.setting_record_model_always_title)));
        }

        public void setSelected(int i) {
            if (i < this.datas.size()) {
                this.selectedIndex = i;
                notifyDataSetChanged();
            }
        }

        public int getCount() {
            return this.datas.size();
        }

        public RecordModeEntity getItem(int i) {
            return this.datas.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            RecordModeViewHolder recordModeViewHolder;
            int i2 = 0;
            if (view == null) {
                view = LayoutInflater.from(SDCardStatusActivityNew.this.getContext()).inflate((int) R.layout.camera_file_setting_record_mode_item, viewGroup, false);
                recordModeViewHolder = new RecordModeViewHolder();
                recordModeViewHolder.mRecordModeSelectedIcon = (ImageView) view.findViewById(R.id.ivSelectIcon);
                recordModeViewHolder.mRecordModeTitle = (TextView) view.findViewById(R.id.tvRecordModeTitle);
                recordModeViewHolder.mRecordModeDesc = (TextView) view.findViewById(R.id.tvRecordModeDesc);
                view.setTag(recordModeViewHolder);
            } else {
                recordModeViewHolder = (RecordModeViewHolder) view.getTag();
            }
            recordModeViewHolder.mRecordModeTitle.setText(getItem(i).title);
            recordModeViewHolder.mRecordModeDesc.setText(getItem(i).desc);
            ImageView imageView = recordModeViewHolder.mRecordModeSelectedIcon;
            if (this.selectedIndex != i) {
                i2 = 4;
            }
            imageView.setVisibility(i2);
            recordModeViewHolder.mRecordModeTitle.setTextColor(this.selectedIndex == i ? Color.parseColor("#FF32BAC0") : SDCardStatusActivityNew.this.getResources().getColor(R.color.mj_color_black));
            return view;
        }

        class RecordModeEntity {
            String desc;
            String title;

            public RecordModeEntity(String str, String str2) {
                this.title = str;
                this.desc = str2;
            }
        }

        class RecordModeViewHolder {
            TextView mRecordModeDesc;
            ImageView mRecordModeSelectedIcon;
            TextView mRecordModeTitle;

            RecordModeViewHolder() {
            }
        }
    }
}
