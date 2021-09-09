package com.miui.tsmclient.analytics;

import android.content.Context;
import com.miui.tsmclient.analytics.database.TSMDataStatUtils;
import com.miui.tsmclient.analytics.entity.DataStatInfo;
import com.miui.tsmclient.analytics.upload.TSMDataStatAuthManager;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.util.NetworkUtil;
import com.miui.tsmclient.util.PrefUtils;

public class TSMDataStatManager {
    public void recordCountEvent(Context context, int i) {
        TSMDataStatUtils.getInstance().insertData(context, new DataStatInfo(i));
        uploadDataStatInfo(context);
    }

    public void recordStringEvent(Context context, int i, String str) {
        DataStatInfo dataStatInfo = new DataStatInfo(i);
        dataStatInfo.setDataValue(str);
        TSMDataStatUtils.getInstance().insertData(context, dataStatInfo);
        uploadDataStatInfo(context);
    }

    private void uploadDataStatInfo(Context context) {
        if (isConformUploadCondition(context)) {
            BaseResponse uploadDataStatInfo = new TSMDataStatAuthManager().uploadDataStatInfo(context, DataStatInfo.toServerData(TSMDataStatUtils.getInstance().getAllData(context)));
            if (uploadDataStatInfo != null && uploadDataStatInfo.mResultCode == 0 && TSMDataStatUtils.getInstance().deleteAllData(context) > 0) {
                PrefUtils.putLong(context, "pref_key_last_upload_data_stat_time", System.currentTimeMillis());
            }
        }
    }

    private boolean isConformUploadCondition(Context context) {
        if (NetworkUtil.isWifiConnected(context)) {
            return true;
        }
        if (System.currentTimeMillis() > PrefUtils.getLong(context, "pref_key_last_upload_data_stat_time", 0) + 86400000) {
            return true;
        }
        return false;
    }
}
