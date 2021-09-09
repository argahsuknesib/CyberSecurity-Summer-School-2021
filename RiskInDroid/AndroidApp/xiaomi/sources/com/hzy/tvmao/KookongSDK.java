package com.hzy.tvmao;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import com.hzy.tvmao.b.a.a;
import com.hzy.tvmao.b.ag;
import com.hzy.tvmao.b.f;
import com.hzy.tvmao.b.n;
import com.hzy.tvmao.b.q;
import com.hzy.tvmao.b.w;
import com.hzy.tvmao.interf.IRequestResult;
import com.hzy.tvmao.ir.encode.CodeHelper;
import com.hzy.tvmao.ir.encode.IrDevice;
import com.hzy.tvmao.model.db.bean.ChannelInfo;
import com.hzy.tvmao.model.legacy.api.EncryptDataUtil2;
import com.hzy.tvmao.model.legacy.api.StreamHelper;
import com.hzy.tvmao.model.legacy.api.StreamHelper2;
import com.hzy.tvmao.model.legacy.api.data.EPGProgramData;
import com.hzy.tvmao.model.legacy.api.data.UIProgramData;
import com.hzy.tvmao.offline.SDKSwitcher;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.StringUtil;
import com.kookong.app.data.BrandList;
import com.kookong.app.data.ChannelEpg;
import com.kookong.app.data.CountryList;
import com.kookong.app.data.IrData;
import com.kookong.app.data.IrDataList;
import com.kookong.app.data.LineupList;
import com.kookong.app.data.PlayingTimeDataV2;
import com.kookong.app.data.ProgramData;
import com.kookong.app.data.ProgramDetailData;
import com.kookong.app.data.ProgramGuideList;
import com.kookong.app.data.RcTestRemoteKeyList;
import com.kookong.app.data.RemoteList;
import com.kookong.app.data.SearchDataList;
import com.kookong.app.data.SpList;
import com.kookong.app.data.StbList;
import com.kookong.config.SDKConfig;
import com.kookong.sdk.bean.ManualMatchLineupData;
import java.security.MessageDigest;
import java.util.List;

public class KookongSDK {
    public static String APPKEY = null;
    public static String DEVICEID = null;
    private static String TAG = "KookongSDK";
    public static boolean isInitcustomer = false;
    private static Config sConfig = new Config();
    private static Context sContext;
    private static SDKSwitcher sdkSwitcher = new SDKSwitcher();
    private static boolean useHttps = true;

    public static boolean statAddRemotePannel(String str, String str2, String str3, String str4, double d, double d2) {
        return false;
    }

    public static boolean statSwitchRemotePannel(String str, String str2, String str3, String str4, double d, double d2) {
        return false;
    }

    public static boolean statTunein(String str, String str2, String str3, double d, double d2) {
        return false;
    }

    public static void statistical(String str, String str2, String str3) {
    }

    public static class Config {
        private boolean repeatCodeFormat = false;

        public boolean isRepeatCodeFormat() {
            return this.repeatCodeFormat;
        }

        public void setRepeatCodeFormat(boolean z) {
            this.repeatCodeFormat = z;
        }
    }

    public static boolean init(Context context, String str) {
        return init(context, str, "");
    }

    public static boolean init(Context context, String str, String str2) {
        return init(context, str, str2, 1);
    }

    public static boolean init(Context context, String str, String str2, int i) {
        APPKEY = str;
        sContext = context;
        DEVICEID = str2;
        SDKConfig.init(i);
        boolean init = StreamHelper.init(sContext, str);
        boolean init2 = StreamHelper2.init(context, str);
        boolean init3 = EncryptDataUtil2.init(context, str);
        boolean init4 = IrDevice.init(context, str);
        LogUtil.d("StreamHelper2 init：".concat(String.valueOf(init2)));
        LogUtil.d("EncryptDataUtil2 init：".concat(String.valueOf(init3)));
        LogUtil.d("IrDevice init：".concat(String.valueOf(init4)));
        if (!(init2 && init3 && init4)) {
            LogUtil.e("offline init failed.");
        }
        LogUtil.d("StreamHelper init：".concat(String.valueOf(init)));
        boolean init5 = CodeHelper.init(sContext, str);
        LogUtil.d("CodeHelper init：".concat(String.valueOf(init5)));
        u.a();
        v.a();
        login();
        printParams(str, sContext);
        return init5;
    }

    public static SDKSwitcher getSdkSwitcher() {
        return sdkSwitcher;
    }

    public static void setMode(SDKSwitcher.Mode mode) {
        sdkSwitcher.setMode(mode);
    }

    public static void setUseHttps(boolean z) {
        useHttps = z;
    }

    public static boolean getUseHttps() {
        return useHttps;
    }

    public static void setConfig(Config config) {
        sConfig = config;
    }

    public static Config getConfig() {
        return sConfig;
    }

    public static void login() {
        Log.d("KookongSDK", "isInitcustomer " + isInitcustomer);
        if (!isInitcustomer) {
            isInitcustomer = true;
        }
    }

    public static void setDebugMode(boolean z) {
        LogUtil.setDebugMode(z);
    }

    public static Context getContext() {
        return sContext;
    }

    public static <T> void parseControlResponseBean(a aVar, IRequestResult<T> iRequestResult) {
        if (!aVar.d() || aVar.c() == null) {
            iRequestResult.onFail(Integer.valueOf(aVar.a()), aVar.b());
        } else {
            iRequestResult.onSuccess(aVar.b(), aVar.c());
        }
    }

    public static void getCountryList(IRequestResult<CountryList> iRequestResult) {
        sdkSwitcher.getSDK().getCountryList(iRequestResult);
    }

    public static void getAreaId(String str, String str2, String str3, IRequestResult<Integer> iRequestResult) {
        sdkSwitcher.getSDK().getAreaId(str, str2, str3, iRequestResult);
    }

    public static void getOperaters(int i, IRequestResult<SpList> iRequestResult) {
        sdkSwitcher.getSDK().getOperater(i, iRequestResult);
    }

    public static void searchSTB(String str, int i, IRequestResult<StbList> iRequestResult) {
        new q().a(str, i, new c(iRequestResult));
    }

    public static void getIPTV(int i, IRequestResult<StbList> iRequestResult) {
        sdkSwitcher.getSDK().getIptvBrandList(i, iRequestResult);
    }

    public static void getAllRemoteIds(int i, int i2, int i3, int i4, IRequestResult<RemoteList> iRequestResult) {
        sdkSwitcher.getSDK().getAllRemoteIdsInChina(i, i2, i3, i4, iRequestResult);
    }

    public static void getAllRemoteIds(int i, int i2, String str, IRequestResult<RemoteList> iRequestResult) {
        sdkSwitcher.getSDK().getAllRemoteIdsInternational(i, i2, str, iRequestResult);
    }

    public static void getRemoteIdListByFunctionKey(int i, int i2, int i3, int i4, IRequestResult<RemoteList> iRequestResult) {
        new f().a(i, i2, i3, i4, new m(iRequestResult));
    }

    public static void getIrDataByFunctionKey(int i, int i2, boolean z, IRequestResult<IrData> iRequestResult) {
        new f().a(i, i2, z, new n(iRequestResult));
    }

    public static void getIRDataById(String str, int i, IRequestResult<IrDataList> iRequestResult) {
        getIRDataById(str, i, false, iRequestResult);
    }

    public static void getIRDataById(String str, IRequestResult<IrDataList> iRequestResult) {
        getIRDataById(str, -1, false, iRequestResult);
    }

    public static void getIRDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult) {
        sdkSwitcher.getSDK().getRemoteDataById(str, i, z, iRequestResult);
    }

    public static void getIRDataById(String str, boolean z, IRequestResult<IrDataList> iRequestResult) {
        getIRDataById(str, -1, z, iRequestResult);
    }

    public static void getNoStateIRDataById(String str, int i, IRequestResult<IrDataList> iRequestResult) {
        getNoStateIRDataById(str, i, false, iRequestResult);
    }

    public static void getNoStateIRDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult) {
        httpGetIRDataBydId(str, i, "0", z, true, iRequestResult);
    }

    public static void getNoStateIRDataById(String str, IRequestResult<IrDataList> iRequestResult) {
        getNoStateIRDataById(str, -1, false, iRequestResult);
    }

    public static void getNoStateIRDataById(String str, boolean z, IRequestResult<IrDataList> iRequestResult) {
        httpGetIRDataBydId(str, -1, "0", z, true, iRequestResult);
    }

    public static void getTestNoStateIRDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult) {
        httpGetIRDataBydId(str, i, "1", z, true, iRequestResult);
    }

    public static void testIRDataById(String str, int i, IRequestResult<IrDataList> iRequestResult) {
        httpGetIRDataBydId(str, i, "1", false, iRequestResult);
    }

    public static void testIRDataById(String str, int i, boolean z, IRequestResult<IrDataList> iRequestResult) {
        httpGetIRDataBydId(str, i, "1", z, iRequestResult);
    }

    private static void httpGetIRDataBydId(String str, int i, String str2, boolean z, IRequestResult<IrDataList> iRequestResult) {
        httpGetIRDataBydId(str, i, str2, z, false, iRequestResult);
    }

    private static void httpGetIRDataBydId(String str, int i, String str2, boolean z, boolean z2, IRequestResult<IrDataList> iRequestResult) {
        new f().a(str, i, str2, z, z2, new o(iRequestResult));
    }

    public static void getACIRDataByBrandId(int i, IRequestResult<IrDataList> iRequestResult) {
        new f().a(i, new p(iRequestResult));
    }

    public static void getFilterIRData(int i, int i2, String str, IRequestResult<RemoteList> iRequestResult) {
        new f().a(i, i2, str, new q(iRequestResult));
    }

    public static void getBrandListFromNet(int i, IRequestResult<BrandList> iRequestResult) {
        getBrandListFromNet(i, "", iRequestResult);
    }

    public static void getBrandListFromNet(int i, String str, IRequestResult<BrandList> iRequestResult) {
        sdkSwitcher.getSDK().getBrandList(i, str, iRequestResult);
    }

    public static ChannelInfo getChannelInfo(int i, String str, int i2) {
        return n.c().a(i, str, i2);
    }

    public static boolean loadLineupByDeviceId(int i) {
        return n.c().a(i);
    }

    public static List<ChannelInfo> getLineupByDeviceId(int i) {
        return n.c().b(i);
    }

    public static void getLineUpsList(int i, int i2, IRequestResult<LineupList> iRequestResult) {
        n.c().a(i, i2, new r(iRequestResult));
    }

    public static void getLineupDataAndSave(int i, int i2, int i3, IRequestResult<String> iRequestResult) {
        n.c().a(i, i2, i3, new s(iRequestResult));
    }

    public static void getProgramGuide(int i, int i2, String str, String str2, IRequestResult<ProgramGuideList> iRequestResult) {
        w.c().a(i, i2, str, str2, new t(iRequestResult));
    }

    public static void searchProgram(String str, int i, IRequestResult<EPGProgramData> iRequestResult) {
        searchProgram(str, i, 0, null, true, iRequestResult);
    }

    public static void searchProgramByChannel(String str, int i, int i2, String str2, IRequestResult<EPGProgramData> iRequestResult) {
        searchProgram(str, i, i2, str2, false, iRequestResult);
    }

    private static void searchProgram(String str, int i, int i2, String str2, boolean z, IRequestResult<EPGProgramData> iRequestResult) {
        w.c().a(str, (short) i, i2, str2, z, new d(iRequestResult));
    }

    public static void accurateSearchProgram(String str, short s, IRequestResult<PlayingTimeDataV2> iRequestResult) {
        w.c().a(str, s, new e(iRequestResult));
    }

    public static void getProgramGuide(int i, String str, int i2, IRequestResult<ChannelEpg> iRequestResult) {
        w.c().a(i, str, i2, new f(iRequestResult));
    }

    public static void getProgramsByCatID(int i, String str, String str2, IRequestResult<ProgramData> iRequestResult) {
        w.c().a(i, str, str2, new g(iRequestResult));
    }

    public static void getProgramDetail(String str, short s, IRequestResult<ProgramDetailData> iRequestResult) {
        w.c().b(str, s, new h(iRequestResult));
    }

    public static void searchPlayingProgram(int i, String str, IRequestResult<SearchDataList> iRequestResult) {
        w.c().a(i, str, new i(iRequestResult));
    }

    public static void getTVWallData(int i, String str, IRequestResult<UIProgramData> iRequestResult) {
        ag.c().a(i, str, new j(iRequestResult));
    }

    public static void getRcTestKeys(int i, int i2, IRequestResult<RcTestRemoteKeyList> iRequestResult) {
        new f().a(i, i2, new k(iRequestResult));
    }

    public static ChannelInfo getChannelInfo(int i, int i2) {
        return n.c().a(i, "", i2);
    }

    public static void manualMatchLineup(int i, int i2, String str, IRequestResult<ManualMatchLineupData> iRequestResult) {
        new q().a(i, i2, str, new l(iRequestResult));
    }

    public static void sendIR(int i, String str) {
        com.hzy.tvmao.ir.a.a().a(i, str);
    }

    public static byte[] decode(byte[] bArr) {
        return StreamHelper.dec(bArr);
    }

    public static String decodeChannelNum(String str) {
        return new String(decode(StringUtil.base64Decode(str)));
    }

    public static KKSingleMatchManager getSingleMatchManager() {
        return sdkSwitcher.getSDK().getSingleMatchManager();
    }

    private static void printParams(String str, Context context) {
        String str2;
        Signature[] signatureArr;
        if (TextUtils.isEmpty(str)) {
            str2 = "invalid_key";
        } else {
            str2 = str.substring(0, 4) + "***" + str.substring(str.length() - 4, str.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(":");
        sb.append(context == null ? "context is null!" : context.getPackageName());
        Log.d("sdk_params", sb.toString());
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null) {
                for (Signature byteArray : signatureArr) {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(byteArray.toByteArray());
                    byte[] digest = instance.digest();
                    char[] charArray = "0123456789ABCDEF".toCharArray();
                    char[] cArr = new char[(digest.length * 2)];
                    for (int i = 0; i < digest.length; i++) {
                        byte b = digest[i] & 255;
                        int i2 = i * 2;
                        cArr[i2] = charArray[b >>> 4];
                        cArr[i2 + 1] = charArray[b & 15];
                    }
                    Log.d("sdk_params", new String(cArr).substring(8, 16));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
