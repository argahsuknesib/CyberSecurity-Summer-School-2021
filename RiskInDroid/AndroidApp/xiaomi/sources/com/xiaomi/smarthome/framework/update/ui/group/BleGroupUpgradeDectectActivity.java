package com.xiaomi.smarthome.framework.update.ui.group;

import _m_j.fat;
import _m_j.ffr;
import _m_j.fno;
import _m_j.fpo;
import _m_j.gof;
import _m_j.gsy;
import _m_j.gtf;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfoV2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class BleGroupUpgradeDectectActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    View.OnClickListener f8768O000000o = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass3 */

        public final void onClick(View view) {
            BleGroupUpgradeDectectActivity.this.checkIfNeedUpdate();
        }
    };
    View.OnClickListener O00000Oo = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass4 */

        public final void onClick(View view) {
            BleGroupUpgradeDectectActivity.this.onBackPressed();
        }
    };
    private boolean O00000o;
    private TextView O00000o0;
    public Button mBtnBottom;
    public Device mDevice;
    public String mGroupDid;
    public ImageView mImgStatusIcon;
    public List<Device> mMemberDeviceList = new ArrayList();
    public TextView mTxtUpdateDesc;
    public TextView mTxtUpdateSubtitle;
    public TextView mTxtUpdateTitle;

    enum OTAStatus {
        CHECKING,
        CHECKING_FAIL,
        READY_UPGRADE,
        FORBID_UPGRADE,
        NO_UPGRADE,
        UPGRADING,
        INSTALLING,
        OTA_SUCCESS,
        UPGRADE_FAIL
    }

    /* renamed from: com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f8776O000000o = new int[OTAStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f8776O000000o[OTAStatus.CHECKING.ordinal()] = 1;
            f8776O000000o[OTAStatus.READY_UPGRADE.ordinal()] = 2;
            f8776O000000o[OTAStatus.UPGRADING.ordinal()] = 3;
            f8776O000000o[OTAStatus.INSTALLING.ordinal()] = 4;
            f8776O000000o[OTAStatus.NO_UPGRADE.ordinal()] = 5;
            f8776O000000o[OTAStatus.OTA_SUCCESS.ordinal()] = 6;
            f8776O000000o[OTAStatus.UPGRADE_FAIL.ordinal()] = 7;
            f8776O000000o[OTAStatus.CHECKING_FAIL.ordinal()] = 8;
            f8776O000000o[OTAStatus.FORBID_UPGRADE.ordinal()] = 9;
        }
    }

    public int getStatusIcon(OTAStatus oTAStatus) {
        switch (AnonymousClass6.f8776O000000o[oTAStatus.ordinal()]) {
            case 1:
                return R.drawable.icon_ota_checking;
            case 2:
                return R.drawable.icon_ota_ready_upgrade;
            case 3:
                return R.drawable.icon_ota_upgrading;
            case 4:
                return R.drawable.icon_ota_installing;
            case 5:
            case 6:
                return R.drawable.icon_ota_success;
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return R.drawable.icon_ota_fail;
            default:
                return 0;
        }
    }

    public View.OnClickListener getBtnClickListener(OTAStatus oTAStatus) {
        int i = AnonymousClass6.f8776O000000o[oTAStatus.ordinal()];
        if (!(i == 5 || i == 6)) {
            if (i == 8) {
                return this.f8768O000000o;
            }
            if (i != 9) {
                return null;
            }
        }
        return this.O00000Oo;
    }

    public String getBtnText(OTAStatus oTAStatus) {
        int i = AnonymousClass6.f8776O000000o[oTAStatus.ordinal()];
        if (i == 2) {
            return getString(R.string.upgrade_new_version_upgrade);
        }
        switch (i) {
            case 5:
            case 6:
            case 9:
                return getString(R.string.confirm);
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return getString(R.string.mj_retry);
            default:
                return null;
        }
    }

    public static void invokeActivity(Context context, int i, String str) {
        Intent intent = new Intent(context, BleGroupUpgradeDectectActivity.class);
        intent.putExtra("arg_auth_type", i);
        intent.putExtra("did", str);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        List<Device> list;
        Device device;
        super.onCreate(bundle);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        setContentView((int) R.layout.ble_ota_upgrade_activity);
        this.O00000o0 = (TextView) findViewById(R.id.txt_debug);
        this.mImgStatusIcon = (ImageView) findViewById(R.id.img_status_icon);
        this.mTxtUpdateTitle = (TextView) findViewById(R.id.txt_update_title);
        this.mTxtUpdateSubtitle = (TextView) findViewById(R.id.txt_update_subtitle);
        this.mTxtUpdateDesc = (TextView) findViewById(R.id.txt_update_desc);
        this.mBtnBottom = (Button) findViewById(R.id.btn_bottom);
        Intent intent = getIntent();
        this.mGroupDid = intent.getStringExtra("did");
        int intExtra = intent.getIntExtra("arg_auth_type", -1);
        this.mDevice = fno.O000000o().O000000o(this.mGroupDid);
        this.mMemberDeviceList = fno.O000000o().O0000O0o(this.mGroupDid);
        List<Device> list2 = this.mMemberDeviceList;
        if (!(list2 == null || list2.size() != 0 || (device = this.mDevice) == null)) {
            try {
                Iterator<String> keys = new JSONObject(device.extra).optJSONObject("member_list").optJSONObject("member_ship").keys();
                while (keys.hasNext()) {
                    Device O000000o2 = fno.O000000o().O000000o(keys.next());
                    if (O000000o2 != null) {
                        this.mMemberDeviceList.add(O000000o2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mDevice == null || (list = this.mMemberDeviceList) == null || list.size() == 0 || intExtra < 0) {
            finish();
        } else {
            findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    BleGroupUpgradeDectectActivity.this.onBackPressed();
                }
            });
            TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
            Device device2 = this.mDevice;
            if (device2 != null) {
                textView.setText(device2.name);
            }
        }
        checkIfNeedUpdate();
    }

    public void switchStatus(final OTAStatus oTAStatus, final Object... objArr) {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass2 */

            public final void run() {
                View.OnClickListener btnClickListener = BleGroupUpgradeDectectActivity.this.getBtnClickListener(oTAStatus);
                if (btnClickListener == null) {
                    BleGroupUpgradeDectectActivity.this.mBtnBottom.setVisibility(4);
                    BleGroupUpgradeDectectActivity.this.mBtnBottom.setOnClickListener(null);
                } else {
                    BleGroupUpgradeDectectActivity.this.mBtnBottom.setVisibility(0);
                    BleGroupUpgradeDectectActivity.this.mBtnBottom.setOnClickListener(btnClickListener);
                }
                String btnText = BleGroupUpgradeDectectActivity.this.getBtnText(oTAStatus);
                if (!TextUtils.isEmpty(btnText)) {
                    BleGroupUpgradeDectectActivity.this.mBtnBottom.setText(btnText);
                }
                BleGroupUpgradeDectectActivity.this.mImgStatusIcon.setImageResource(BleGroupUpgradeDectectActivity.this.getStatusIcon(oTAStatus));
                BleGroupUpgradeDectectActivity.this.mTxtUpdateTitle.setText("");
                BleGroupUpgradeDectectActivity.this.mTxtUpdateSubtitle.setText("");
                BleGroupUpgradeDectectActivity.this.mTxtUpdateDesc.setText("");
                int i = AnonymousClass6.f8776O000000o[oTAStatus.ordinal()];
                if (i == 1) {
                    BleGroupUpgradeDectectActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_is_checking);
                    String O00oOooo = ffr.O00oOooo(BleGroupUpgradeDectectActivity.this.mDevice.mac);
                    if (!TextUtils.isEmpty(O00oOooo)) {
                        TextView textView = BleGroupUpgradeDectectActivity.this.mTxtUpdateSubtitle;
                        textView.setText(BleGroupUpgradeDectectActivity.this.getString(R.string.app_curr_version) + O00oOooo);
                    }
                } else if (i == 2) {
                    Object[] objArr = objArr;
                    if (objArr != null && objArr.length >= 3) {
                        String str = (String) objArr[2];
                        TextView textView2 = BleGroupUpgradeDectectActivity.this.mTxtUpdateTitle;
                        textView2.setText(BleGroupUpgradeDectectActivity.this.getString(R.string.list_item_latest_version) + ":" + ((String) objArr[1]));
                        TextView textView3 = BleGroupUpgradeDectectActivity.this.mTxtUpdateSubtitle;
                        textView3.setText(BleGroupUpgradeDectectActivity.this.getString(R.string.app_curr_version) + ((String) objArr[0]));
                        if (!TextUtils.isEmpty(str)) {
                            BleGroupUpgradeDectectActivity.this.mTxtUpdateDesc.setText(str);
                        }
                    }
                } else if (i == 5) {
                    BleGroupUpgradeDectectActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_version_latest);
                    String O00oOooo2 = ffr.O00oOooo(BleGroupUpgradeDectectActivity.this.mDevice.mac);
                    Object[] objArr2 = objArr;
                    if (objArr2 != null && objArr2.length > 0) {
                        O00oOooo2 = (String) objArr2[0];
                    }
                    if (!TextUtils.isEmpty(O00oOooo2)) {
                        TextView textView4 = BleGroupUpgradeDectectActivity.this.mTxtUpdateSubtitle;
                        textView4.setText(BleGroupUpgradeDectectActivity.this.getString(R.string.app_curr_version) + O00oOooo2);
                    }
                } else if (i == 8) {
                    BleGroupUpgradeDectectActivity.this.mTxtUpdateTitle.setText((int) R.string.ble_ota_check_fail);
                    Object[] objArr3 = objArr;
                    if (objArr3 == null || objArr3.length <= 0) {
                        BleGroupUpgradeDectectActivity.this.mTxtUpdateSubtitle.setText((int) R.string.ble_ota_check_fail_tip);
                        return;
                    }
                    BleGroupUpgradeDectectActivity.this.mTxtUpdateSubtitle.setText((String) objArr3[0]);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    public void checkIfNeedUpdate() {
        DeviceCategory fromPid;
        switchStatus(OTAStatus.CHECKING, new Object[0]);
        if (!gof.O000000o()) {
            onCheckFail(101010);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Device next : this.mMemberDeviceList) {
            if (next != null && ((fromPid = DeviceCategory.fromPid(next.pid)) == DeviceCategory.BleMesh || fromPid == DeviceCategory.Bluetooth)) {
                arrayList.add(next.did);
            }
        }
        gtf.O000000o();
        gtf.O000000o(this.mMemberDeviceList.get(0).model, arrayList, new Callback<List<BleMeshFirmwareUpdateInfoV2>>() {
            /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List<BleMeshFirmwareUpdateInfoV2> list = (List) obj;
                if (list == null || list.size() <= 0) {
                    fat fat = fat.O000000o.f16039O000000o;
                    String O000000o2 = fat.O000000o(BleGroupUpgradeDectectActivity.this.mMemberDeviceList.get(0).mac);
                    if (TextUtils.isEmpty(O000000o2)) {
                        XmPluginHostApi.instance().getBleMeshFirmwareUpdateInfo(BleGroupUpgradeDectectActivity.this.mMemberDeviceList.get(0).model, BleGroupUpgradeDectectActivity.this.mMemberDeviceList.get(0).did, new Callback<BleMeshFirmwareUpdateInfo>() {
                            /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass5.AnonymousClass2 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                BleGroupUpgradeDectectActivity.this.switchStatus(OTAStatus.NO_UPGRADE, ((BleMeshFirmwareUpdateInfo) obj).getLatestVersion());
                            }

                            public final void onFailure(int i, String str) {
                                BleGroupUpgradeDectectActivity.this.switchStatus(OTAStatus.NO_UPGRADE, BleGroupUpgradeDectectActivity.this.mMemberDeviceList.get(0).version);
                            }
                        });
                        return;
                    }
                    BleGroupUpgradeDectectActivity bleGroupUpgradeDectectActivity = BleGroupUpgradeDectectActivity.this;
                    OTAStatus oTAStatus = OTAStatus.NO_UPGRADE;
                    bleGroupUpgradeDectectActivity.switchStatus(oTAStatus, BleGroupUpgradeDectectActivity.this.mMemberDeviceList.get(0).version + "." + O000000o2);
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                for (BleMeshFirmwareUpdateInfoV2 bleMeshFirmwareUpdateInfoV2 : list) {
                    if (bleMeshFirmwareUpdateInfoV2 != null && (fpo.O000000o(bleMeshFirmwareUpdateInfoV2.version, bleMeshFirmwareUpdateInfoV2.currentVersion) > 0 || fpo.O000000o(bleMeshFirmwareUpdateInfoV2.mcuVersion, bleMeshFirmwareUpdateInfoV2.currentMcuVersion) > 0)) {
                        arrayList.add(bleMeshFirmwareUpdateInfoV2);
                    }
                }
                if (arrayList.size() > 0) {
                    BleGroupUpgradeDectectActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.update.ui.group.BleGroupUpgradeDectectActivity.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            BleGroupMemberUpdateActivity.open(BleGroupUpgradeDectectActivity.this, arrayList, null, BleGroupUpgradeDectectActivity.this.mGroupDid);
                            BleGroupUpgradeDectectActivity.this.finish();
                        }
                    }, 1000);
                    return;
                }
                BleGroupUpgradeDectectActivity bleGroupUpgradeDectectActivity2 = BleGroupUpgradeDectectActivity.this;
                OTAStatus oTAStatus2 = OTAStatus.NO_UPGRADE;
                bleGroupUpgradeDectectActivity2.switchStatus(oTAStatus2, ((BleMeshFirmwareUpdateInfoV2) list.get(0)).currentVersion + "." + ((BleMeshFirmwareUpdateInfoV2) list.get(0)).currentMcuVersion);
            }

            public final void onFailure(int i, String str) {
                BleGroupUpgradeDectectActivity.this.onCheckFail(101010);
            }
        });
    }

    public void onCheckFail(int i) {
        gsy.O00000o0(LogType.BLUETOOTH, "Ble-OTA", "onCheckFail code".concat(String.valueOf(i)));
        if (i == 101010) {
            switchStatus(OTAStatus.CHECKING_FAIL, getString(R.string.ble_ota_network_not_connected));
        }
    }

    public void onBackPressed() {
        this.O00000o = true;
        finish();
    }
}
