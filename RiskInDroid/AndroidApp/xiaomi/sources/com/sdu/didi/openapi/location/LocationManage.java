package com.sdu.didi.openapi.location;

import android.content.Context;
import android.os.Looper;
import com.sdu.didi.openapi.DIOpenSDK;
import com.sdu.didi.openapi.location.LocationHelper;

public class LocationManage {
    private SdkHub sdkHub;

    /* renamed from: com.sdu.didi.openapi.location.LocationManage$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sdu$didi$openapi$DIOpenSDK$MapLocationType = new int[DIOpenSDK.MapLocationType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$sdu$didi$openapi$DIOpenSDK$MapLocationType[DIOpenSDK.MapLocationType.GAODE.ordinal()] = 1;
            $SwitchMap$com$sdu$didi$openapi$DIOpenSDK$MapLocationType[DIOpenSDK.MapLocationType.BAIDU.ordinal()] = 2;
            try {
                $SwitchMap$com$sdu$didi$openapi$DIOpenSDK$MapLocationType[DIOpenSDK.MapLocationType.SOSO.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void findRealType() {
        if (findSdk("com.amap.api.location.AMapLocationClient")) {
            DIOpenSDK.setMapSdkType(DIOpenSDK.MapLocationType.GAODE);
        }
        if (findSdk("com.baidu.location.LocationClient")) {
            DIOpenSDK.setMapSdkType(DIOpenSDK.MapLocationType.BAIDU);
        }
        if (findSdk("com.tencent.map.geolocation.TencentLocationManager")) {
            DIOpenSDK.setMapSdkType(DIOpenSDK.MapLocationType.SOSO);
        }
    }

    private boolean findSdk(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        if (DIOpenSDK.getMapSdkType() == DIOpenSDK.MapLocationType.SYSTEM) {
            findRealType();
        }
        int i = AnonymousClass1.$SwitchMap$com$sdu$didi$openapi$DIOpenSDK$MapLocationType[DIOpenSDK.getMapSdkType().ordinal()];
        this.sdkHub = i != 1 ? i != 2 ? i != 3 ? new SystemSDK(context) : new SosoSdk(context) : new BaiduSdk(context) : new GaodeSdk(context);
    }

    /* access modifiers changed from: protected */
    public void registListener(Looper looper, LocationHelper.LocationListener locationListener) {
        this.sdkHub.registListener(looper, locationListener);
    }

    /* access modifiers changed from: protected */
    public void unRegistListener() {
        SdkHub sdkHub2 = this.sdkHub;
        if (sdkHub2 != null) {
            sdkHub2.unRegistListener();
        }
    }
}
