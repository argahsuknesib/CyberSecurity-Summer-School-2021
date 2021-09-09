package com.xiaomi.accountsdk.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import com.xiaomi.accountsdk.futureservice.ClientFuture;
import com.xiaomi.accountsdk.futureservice.ServerServiceConnector;
import com.xiaomi.accountsdk.futureservice.SimpleClientFuture;
import com.xiaomi.accountsdk.service.DeviceInfoResult;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.IPassportCommonService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PassportCommonServiceClient {
    private PassportCommonServiceClient() {
    }

    private static boolean isDeviceInfoSupported(Context context) {
        return checkServiceFeatureSupportedByVersion(context, "feature_get_device_info_version", 1);
    }

    public static DeviceInfoResult getDeviceInfoRpc(Context context, final String str, final int i, int i2) {
        if (!isDeviceInfoSupported(context)) {
            return new DeviceInfoResult.Builder(null).errorCode(DeviceInfoResult.ErrorCode.ERROR_NOT_SUPPORTED).errorMessage("GetDeviceInfo feature is not yet supported by this version of XiaomiAccount, please update a newer version.").build();
        }
        SimpleClientFuture simpleClientFuture = new SimpleClientFuture();
        new ConnectorBase<DeviceInfoResult>(context, simpleClientFuture) {
            /* class com.xiaomi.accountsdk.service.PassportCommonServiceClient.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final DeviceInfoResult callServiceWork() throws RemoteException {
                return ((IPassportCommonService) getIService()).getDeviceInfo(str, i);
            }
        }.bind();
        try {
            return (DeviceInfoResult) simpleClientFuture.get((long) i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            AccountLog.e("PassportCommonServiceClient", "getDeviceInfoRpc", e);
            return new DeviceInfoResult.Builder(null).errorCode(DeviceInfoResult.ErrorCode.ERROR_EXECUTION_EXCEPTION).errorMessage(e.getMessage()).build();
        }
    }

    private static boolean checkServiceFeatureSupportedByVersion(Context context, String str, int i) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.account.action.COMMON_SERVICE");
        intent.setPackage("com.xiaomi.account");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (!(queryIntentServices == null || queryIntentServices.isEmpty() || (resolveInfo = queryIntentServices.get(0)) == null || resolveInfo.serviceInfo == null)) {
            try {
                ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name), NotificationCompat.FLAG_HIGH_PRIORITY);
                if (!(serviceInfo == null || serviceInfo.metaData == null)) {
                    Object obj = serviceInfo.metaData.get(str);
                    if (!(obj instanceof Integer) || ((Integer) obj).intValue() < i) {
                        return false;
                    }
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                AccountLog.w("PassportCommonServiceClient", "component not found", e);
            }
        }
        return false;
    }

    static abstract class ConnectorBase<T> extends ServerServiceConnector<IPassportCommonService, T, T> {
        protected ConnectorBase(Context context, ClientFuture<T, T> clientFuture) {
            super(context, "com.xiaomi.account.action.COMMON_SERVICE", "com.xiaomi.account", clientFuture);
        }

        /* access modifiers changed from: protected */
        public final IPassportCommonService binderToServiceType(IBinder iBinder) {
            return IPassportCommonService.Stub.asInterface(iBinder);
        }
    }
}
