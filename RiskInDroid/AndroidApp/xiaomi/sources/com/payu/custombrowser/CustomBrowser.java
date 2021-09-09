package com.payu.custombrowser;

import android.app.Activity;
import android.content.Intent;
import com.payu.custombrowser.bean.CustomBrowserConfig;
import com.payu.custombrowser.bean.CustomBrowserData;

public class CustomBrowser {
    public void addCustomBrowser(Activity activity, CustomBrowserConfig customBrowserConfig, PayUCustomBrowserCallback payUCustomBrowserCallback) {
        CustomBrowserData.SINGLETON.setPayuCustomBrowserCallback(payUCustomBrowserCallback);
        if (customBrowserConfig.getPayuPostData() != null && customBrowserConfig.getEnableSurePay() > 0 && (customBrowserConfig.getPostURL().contentEquals("https://secure.payu.in/_payment") || customBrowserConfig.getPostURL().contentEquals("https://mobiletest.payu.in/_payment") || customBrowserConfig.getPostURL().contentEquals("https://mobiletest.payu.in/_seamless_payment") || customBrowserConfig.getPostURL().contentEquals("https://secure.payu.in/_seamless_payment"))) {
            if (customBrowserConfig.getPayuPostData().trim().endsWith("&")) {
                customBrowserConfig.setPayuPostData(customBrowserConfig.getPayuPostData().substring(0, customBrowserConfig.getPayuPostData().length() - 1));
            }
            customBrowserConfig.setPayuPostData(customBrowserConfig.getPayuPostData() + "&snooze=" + customBrowserConfig.getEnableSurePay());
        }
        Intent intent = new Intent(activity, CBActivity.class);
        intent.putExtra("cb_config", customBrowserConfig);
        activity.startActivity(intent);
    }
}
