package com.payu.custombrowser.util;

import android.os.AsyncTask;
import com.payu.custombrowser.bean.CustomBrowserAsyncTaskData;
import com.payu.custombrowser.cbinterface.CustomBrowserAsyncTaskInterface;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CustomBrowserAsyncTask extends AsyncTask<CustomBrowserAsyncTaskData, String, String> {
    private CustomBrowserAsyncTaskInterface mCustomBrowserAsyncTaskInterface;

    private CustomBrowserAsyncTask() {
    }

    public CustomBrowserAsyncTask(CustomBrowserAsyncTaskInterface customBrowserAsyncTaskInterface) {
        this.mCustomBrowserAsyncTaskInterface = customBrowserAsyncTaskInterface;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    public String doInBackground(CustomBrowserAsyncTaskData... customBrowserAsyncTaskDataArr) {
        CustomBrowserAsyncTaskData customBrowserAsyncTaskData = customBrowserAsyncTaskDataArr[0];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(customBrowserAsyncTaskData.getUrl()).openConnection();
            httpURLConnection.setRequestMethod(customBrowserAsyncTaskData.getHttpMethod());
            httpURLConnection.setRequestProperty("Content-Type", customBrowserAsyncTaskData.getContentType());
            StringBuilder sb = new StringBuilder();
            sb.append(customBrowserAsyncTaskData.getPostData() != null ? customBrowserAsyncTaskData.getPostData().length() : 0);
            httpURLConnection.setRequestProperty("Content-Length", sb.toString());
            httpURLConnection.getOutputStream().write(customBrowserAsyncTaskData.getPostData().getBytes());
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage().toString();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        super.onPostExecute((Object) str);
        this.mCustomBrowserAsyncTaskInterface.onCustomBrowserAsyncTaskResponse(str);
    }
}
