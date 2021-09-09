package com.payu.custombrowser;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.payu.custombrowser.bean.CustomBrowserConfig;
import com.payu.custombrowser.bean.CustomBrowserData;
import com.payu.custombrowser.util.CBConstant;
import com.payu.custombrowser.util.CBUtil;
import com.payu.magicretry.MagicRetryFragment;
import com.xiaomi.smarthome.R;
import org.json.JSONException;

public class CBActivity extends FragmentActivity implements MagicRetryFragment.ActivityCallback {
    public static int STATE;
    private AlertDialog backButtonAlertDialog;
    CBUtil cbUtil;
    CustomBrowserConfig customBrowserConfig;
    private Bank payUCustomBrowser;
    private androidx.appcompat.app.AlertDialog snoozeDialog;

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
        STATE = 1;
    }

    public void onPause() {
        super.onPause();
        STATE = 2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(null);
        setContentView((int) R.layout.cb_payments);
        this.payUCustomBrowser = new Bank();
        this.cbUtil = new CBUtil();
        this.cbUtil.resetPayuID();
        Bundle bundle2 = new Bundle();
        this.customBrowserConfig = (CustomBrowserConfig) getIntent().getParcelableExtra("cb_config");
        bundle2.putParcelable("cb_config", this.customBrowserConfig);
        this.payUCustomBrowser.setArguments(bundle2);
        getSupportFragmentManager().O000000o().O000000o((int) R.id.main_frame, this.payUCustomBrowser).O00000Oo();
    }

    public void onBackPressed() {
        CustomBrowserConfig customBrowserConfig2 = this.customBrowserConfig;
        if (customBrowserConfig2 == null || customBrowserConfig2.getDisableBackButtonDialog() == 1) {
            finish();
            return;
        }
        this.payUCustomBrowser.addEventAnalytics("user_input", "payu_back_button".toLowerCase());
        this.payUCustomBrowser.showBackButtonDialog();
    }

    public void showMagicRetry() {
        this.payUCustomBrowser.showMagicRetry();
    }

    public void hideMagicRetry() {
        this.payUCustomBrowser.hideMagicRetry();
    }

    public void onDestroy() {
        AlertDialog alertDialog = this.backButtonAlertDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.backButtonAlertDialog.dismiss();
            this.backButtonAlertDialog.cancel();
        }
        androidx.appcompat.app.AlertDialog alertDialog2 = this.snoozeDialog;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            this.snoozeDialog.dismiss();
            this.snoozeDialog.cancel();
        }
        STATE = 3;
        Bank bank = this.payUCustomBrowser;
        if (!(bank == null || bank.getSnoozeLoaderView() == null)) {
            this.payUCustomBrowser.getSnoozeLoaderView().cancelAnimation();
        }
        if (CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback() != null) {
            CustomBrowserData.SINGLETON.getPayuCustomBrowserCallback().onPaymentTerminate();
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        notificationManager.cancel(CBConstant.SNOOZE_NOTIFICATION_ID);
        notificationManager.cancel(63);
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        Bank bank;
        super.onNewIntent(intent);
        if (intent != null && intent.getStringExtra("sender").contentEquals("snoozeService") && (bank = this.payUCustomBrowser) != null) {
            bank.killSnoozeService();
            this.payUCustomBrowser.dismissSnoozeWindow();
            Bank bank2 = this.payUCustomBrowser;
            bank2.snoozeNotificationIntent = null;
            bank2.isSnoozeNotificationLaunched = false;
            if (intent.getExtras().getBoolean("verificationMsgReceived")) {
                try {
                    if (this.cbUtil.getValueOfJSONKey(intent.getExtras().getString("payu_response"), getString(R.string.cb_snooze_verify_api_status)).equalsIgnoreCase("1")) {
                        this.payUCustomBrowser.addEventAnalytics("transaction_verified_notification_click", "-1");
                    } else {
                        this.payUCustomBrowser.addEventAnalytics("transaction_not_verified_notification_click", "-1");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.payUCustomBrowser.showTransactionStatusDialog(intent.getExtras().getString("payu_response"), true);
                return;
            }
            this.payUCustomBrowser.addEventAnalytics("internet_restored_notification_click", "-1");
            this.payUCustomBrowser.resumeTransaction(intent);
        }
    }
}
