package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chr;
import _m_j.chx;
import _m_j.cin;
import _m_j.civ;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gkv;
import _m_j.gqg;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.mijia.camera.nas.NASInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity;
import com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemViewMultiLine;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.List;

public class FileManagerSettingActivity extends CameraBaseActivity {
    private final int SD_CARD_STATUS = 1001;
    chx mCameraProperties;
    private String mRecordStatus = "";
    SettingsItemViewMultiLine mSDCardItem;
    public int mSdcardStatus;
    public int mSdcardStatusFromNet;
    SettingsItemView mSmbBackupItem;
    public XQProgressDialog mXQProgressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_file_setting_activity);
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        initView();
        refreshUI();
    }

    private void initView() {
        this.mSDCardItem = (SettingsItemViewMultiLine) findViewById(R.id.settings_sdcard);
        this.mSDCardItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass1 */

            public void onClick(View view) {
                chr.O000000o("plg.gn9.c4r.h4u");
                if (FileManagerSettingActivity.this.mSdcardStatus == 4) {
                    FileManagerSettingActivity.this.activity();
                    gqg.O000000o(FileManagerSettingActivity.this.getString(R.string.camera_storage_sdcard_out_tips));
                } else if (FileManagerSettingActivity.this.mSdcardStatus == 2) {
                    FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                    fileManagerSettingActivity.startActivity(new Intent(fileManagerSettingActivity.activity(), NoMemoryCardActivity.class));
                } else if (FileManagerSettingActivity.this.mSdcardStatus == 5) {
                    FileManagerSettingActivity.this.activity();
                    gqg.O000000o(FileManagerSettingActivity.this.getString(R.string.camera_storage_sdcard_formating_tips));
                } else {
                    FileManagerSettingActivity fileManagerSettingActivity2 = FileManagerSettingActivity.this;
                    fileManagerSettingActivity2.startActivityForResult(new Intent(fileManagerSettingActivity2.activity(), SDCardStatusActivityNew.class), 1001);
                }
            }
        });
        this.mSmbBackupItem = (SettingsItemView) findViewById(R.id.settings_smb_backup);
        if (this.mCameraDevice.O0000oOO()) {
            this.mSmbBackupItem.setVisibility(8);
            findViewById(R.id.backup_title).setVisibility(8);
        }
        this.mSmbBackupItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass2 */

            public void onClick(View view) {
                chr.O000000o(chr.O000OOo);
                int i = FileManagerSettingActivity.this.mSdcardStatusFromNet;
                if (i == 1 || i == 5) {
                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(FileManagerSettingActivity.this.activity());
                    builder.O000000o((int) R.string.nas_no_sdcard_hint);
                    builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass2.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.O00000o().show();
                } else if (FileManagerSettingActivity.this.mCameraDevice != null) {
                    FileManagerSettingActivity.this.startNAS();
                } else {
                    FileManagerSettingActivity.this.activity();
                    gqg.O000000o((int) R.string.retrieve_data_fail);
                }
            }
        });
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass3 */

            public void onClick(View view) {
                FileManagerSettingActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.more_store_setting);
        updateSdcardStatus();
    }

    public void refreshUI() {
        int i = this.mSdcardStatusFromNet;
        Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "recording-mode");
        int intValue = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 0;
        getResources();
        int O00000Oo = cin.O00000Oo(i, "stop".equalsIgnoreCase(this.mCameraProperties.O00000o0()));
        if (this.mCameraSpecDevice != null) {
            O00000Oo = cin.O00000o0(i, intValue == 2);
        }
        String showDescString = showDescString(O00000Oo);
        civ.O00000o("SdCard", "sdcarad original status" + i + " ;display status:" + showDescString + " mSdcardStatus:" + this.mSdcardStatus);
        this.mSDCardItem.setInfo(showDescString);
        this.mSdcardStatus = O00000Oo;
        this.mSmbBackupItem.setEnabled(false);
        this.mSDCardItem.setEnabled(true);
        if (O00000Oo == 1) {
            this.mSmbBackupItem.setEnabled(true);
        } else if (O00000Oo == 6 && i != 1 && i != 5 && i != 3) {
            this.mSmbBackupItem.setEnabled(true);
        }
    }

    private String showDescString(int i) {
        String string = getString(R.string.camera_storage_normal_status);
        switch (i) {
            case 1:
                return getString(R.string.camera_storage_normal_status);
            case 2:
                return getString(R.string.sd_card_status1);
            case 3:
                return getString(R.string.camera_storage_unnormal_status);
            case 4:
                return getString(R.string.camera_storage_sdcard_out);
            case 5:
                return getString(R.string.sd_card_status4);
            case 6:
                return getString(R.string.camera_storage_pause);
            default:
                return string;
        }
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(activity());
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001 && i2 == -1) {
            refreshUI();
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass4 */

                public void run() {
                    FileManagerSettingActivity.this.updateSdcardStatus();
                }
            }, 300);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void updateSdcardStatus() {
        if (this.mCameraSpecDevice != null) {
            Object propertyValueFromCache = getPropertyValueFromCache("memory-card-management", "status");
            this.mSdcardStatusFromNet = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 0;
            this.mCameraProperties.O00000Oo("sdcard_status", Integer.valueOf(this.mSdcardStatusFromNet));
        } else {
            this.mSdcardStatusFromNet = this.mCameraProperties.O000000o("sdcard_status");
        }
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("memory-card-management");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "status");
            if (!(O000000o2 == null || O000000o3 == null)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o3));
                faw.O00000o().getDeviceSpecProp(gkv.f17949O000000o, arrayList, new fsm<List<PropertyParam>, fso>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass5 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<PropertyParam>) ((List) obj));
                    }

                    public void onSuccess(List<PropertyParam> list) {
                        if (!FileManagerSettingActivity.this.isFinishing()) {
                            Object propertyValueFromCache = FileManagerSettingActivity.this.getPropertyValueFromCache("memory-card-management", "status");
                            FileManagerSettingActivity.this.mSdcardStatusFromNet = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 0;
                            FileManagerSettingActivity.this.mCameraProperties.O00000Oo("sdcard_status", Integer.valueOf(FileManagerSettingActivity.this.mSdcardStatusFromNet));
                            FileManagerSettingActivity.this.refreshUI();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!FileManagerSettingActivity.this.isFinishing()) {
                            FileManagerSettingActivity.this.refreshUI();
                        }
                    }
                });
            }
        } else {
            this.mCameraProperties.O000000o(new String[]{"motion_record", "sdcard_status"}, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass6 */

                public void onSuccess(Void voidR) {
                    if (!FileManagerSettingActivity.this.isFinishing()) {
                        FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                        fileManagerSettingActivity.mSdcardStatusFromNet = fileManagerSettingActivity.mCameraProperties.O000000o("sdcard_status");
                        FileManagerSettingActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FileManagerSettingActivity.this.isFinishing()) {
                        FileManagerSettingActivity.this.refreshUI();
                    }
                }
            });
        }
        refreshUI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void startNAS() {
        if (this.mXQProgressDialog == null) {
            initProgressDialog();
        }
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.FileManagerSettingActivity.AnonymousClass7 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
             arg types: [java.lang.String, java.lang.String, int]
             candidates:
              _m_j.chr.O000000o(int, int, long):void
              _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
            public void onSuccess(NASInfo nASInfo) {
                if (!FileManagerSettingActivity.this.isFinishing()) {
                    FileManagerSettingActivity.this.mXQProgressDialog.dismiss();
                    if (nASInfo == null || nASInfo.O00000o == 0) {
                        chr.O000000o("plg.gn9.t3o.e0c", "type", (Object) 2);
                        FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                        fileManagerSettingActivity.startActivity(new Intent(fileManagerSettingActivity.activity(), NASDiscoveryActivity.class));
                        return;
                    }
                    chr.O000000o("plg.gn9.t3o.e0c", "type", (Object) 1);
                    FileManagerSettingActivity fileManagerSettingActivity2 = FileManagerSettingActivity.this;
                    fileManagerSettingActivity2.startActivity(new Intent(fileManagerSettingActivity2.activity(), NASInfoActivity.class));
                }
            }

            public void onFailure(int i, String str) {
                if (!FileManagerSettingActivity.this.isFinishing()) {
                    FileManagerSettingActivity.this.mXQProgressDialog.dismiss();
                    FileManagerSettingActivity.this.activity();
                    gqg.O000000o((int) R.string.retrieve_data_fail);
                }
            }
        });
    }
}
