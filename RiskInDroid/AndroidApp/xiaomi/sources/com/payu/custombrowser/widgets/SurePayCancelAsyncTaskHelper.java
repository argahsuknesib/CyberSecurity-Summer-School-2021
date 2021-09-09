package com.payu.custombrowser.widgets;

import com.payu.custombrowser.bean.CustomBrowserAsyncTaskData;
import com.payu.custombrowser.cbinterface.CustomBrowserAsyncTaskInterface;
import com.payu.custombrowser.util.CustomBrowserAsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SurePayCancelAsyncTaskHelper implements CustomBrowserAsyncTaskInterface {
    private String mPostData;

    public void onCustomBrowserAsyncTaskResponse(String str) {
    }

    private SurePayCancelAsyncTaskHelper() {
    }

    public SurePayCancelAsyncTaskHelper(String str) {
        this.mPostData = str;
    }

    public void execute() {
        try {
            if (this.mPostData != null && this.mPostData.length() > 0) {
                CustomBrowserAsyncTaskData customBrowserAsyncTaskData = new CustomBrowserAsyncTaskData();
                customBrowserAsyncTaskData.setHttpMethod("POST");
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(new JSONObject(this.mPostData));
                customBrowserAsyncTaskData.setPostData("command=EventAnalytics&data=" + jSONArray.toString());
                customBrowserAsyncTaskData.setUrl("https://info.payu.in/merchant/MobileAnalytics");
                new CustomBrowserAsyncTask(this).execute(customBrowserAsyncTaskData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
