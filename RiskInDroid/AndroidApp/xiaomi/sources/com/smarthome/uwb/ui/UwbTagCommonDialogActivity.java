package com.smarthome.uwb.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;

public class UwbTagCommonDialogActivity extends UwbBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f5681O000000o;
    private MLAlertDialog O00000Oo;
    private UwbScanDevice O00000o;
    private int O00000o0;
    private DialogInterface.OnCancelListener O00000oO = new DialogInterface.OnCancelListener() {
        /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass1 */

        public final void onCancel(DialogInterface dialogInterface) {
            UwbTagCommonDialogActivity.this.finish();
        }
    };

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.f5681O000000o = intent.getStringExtra("intent_key_dialog_msg_tips");
        this.O00000o0 = intent.getIntExtra("intent_key_dialog_type", 1);
        this.O00000o = (UwbScanDevice) intent.getParcelableExtra("uwb_scan_device");
        int i = this.O00000o0;
        if (i == 1) {
            this.O00000Oo = new MLAlertDialog.Builder(this).O00000Oo(this.f5681O000000o).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O000000o((int) R.string.setting, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        } else if (i == 2) {
            this.O00000Oo = new MLAlertDialog.Builder(this).O000000o((int) R.string.mj_uwb_associate_tv).O00000Oo(this.f5681O000000o).O000000o(LayoutInflater.from(getApplicationContext()).inflate((int) R.layout.uwb_associate_tv_dialog, (ViewGroup) null, false)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        } else if (i == 3) {
            this.O00000Oo = new MLAlertDialog.Builder(this).O00000Oo(this.f5681O000000o).O000000o((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000o0().O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        } else if (i == 4) {
            this.O00000Oo = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.uwb_tag_need_reset_stranger_msg).O000000o((int) R.string.mj_i_know, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000o0().O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        } else if (i == 5) {
            this.O00000Oo = new MLAlertDialog.Builder(this).O000000o((int) R.string.mj_uwb_tag_3rd_idle).O000000o((int) R.string.mj_i_know, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        } else if (i == 6) {
            this.O00000Oo = new MLAlertDialog.Builder(this).O000000o((int) R.string.mj_uwb_tag_iot_2_mitv).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        } else if (i == 7) {
            MLAlertDialog.Builder O00000Oo2 = new MLAlertDialog.Builder(this).O000000o((int) R.string.mj_uwb_tag_iot_bind_invalid_title).O00000Oo((int) R.string.mj_uwb_tag_iot_bind_invalid_msg);
            O00000Oo2.f9096O000000o.O00000oO = 3;
            this.O00000Oo = O00000Oo2.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.UwbTagCommonDialogActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UwbTagCommonDialogActivity.this.finish();
                }
            }).O00000Oo().O000000o(this.O00000oO).O00000o();
            this.O00000Oo.show();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        MLAlertDialog mLAlertDialog = this.O00000Oo;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000Oo.dismiss();
        }
    }

    public static void startShowWifiNotEnabledDialog() {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_msg_tips", UwbSdk.getApplication().getResources().getString(R.string.uwb_wifi_not_enabled));
        intent.putExtra("intent_key_dialog_type", 1);
        intent.addFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void startShowNot24GDialog() {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_msg_tips", UwbSdk.getApplication().getResources().getString(R.string.uwb_wifi_not_valid_5g));
        intent.putExtra("intent_key_dialog_type", 1);
        intent.addFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void startShowNotSupportDevice() {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_msg_tips", UwbSdk.getApplication().getResources().getString(R.string.uwb_not_supported_device));
        intent.putExtra("intent_key_dialog_type", 3);
        intent.addFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void showResetTagThirdTv() {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_type", 2);
        intent.addFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void showResetTagMitvInsertThirdTvTag(UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_type", 4);
        intent.addFlags(268435456);
        intent.putExtra("uwb_scan_device", uwbScanDevice);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void show3rdTVTagIdle(UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_type", 5);
        intent.addFlags(268435456);
        intent.putExtra("uwb_scan_device", uwbScanDevice);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void showIotTagInsertInMiTV(UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_type", 6);
        intent.addFlags(268435456);
        intent.putExtra("uwb_scan_device", uwbScanDevice);
        UwbSdk.getApplication().startActivity(intent);
    }

    public static void showIotTagBindInvalid(UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTagCommonDialogActivity.class);
        intent.putExtra("intent_key_dialog_type", 7);
        intent.addFlags(268435456);
        intent.putExtra("uwb_scan_device", uwbScanDevice);
        UwbSdk.getApplication().startActivity(intent);
    }
}
