package com.xiaomi.smarthome.uwb.lib.utils;

import _m_j.fas;
import _m_j.grv;
import _m_j.gsy;
import _m_j.hzf;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.view.View;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.auth.ByteUtils;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.TagState;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class UwbDeviceUtil {
    public static boolean isBuiltinDeviceType(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static boolean isTagDeviceType(int i) {
        return i == 3;
    }

    public static void updateUwbDeviceBindStatus(UwbScanDevice uwbScanDevice, String str, String str2, int i) {
        uwbScanDevice.setAccountInfoPlain(str2);
        uwbScanDevice.setAccountInfo(getUwbHashFirst3B(str2));
        uwbScanDevice.setPid((long) i);
        DidInfo didInfo = uwbScanDevice.getDidInfo();
        if (didInfo == null) {
            didInfo = new DidInfo();
            uwbScanDevice.setDidInfo(didInfo);
        }
        didInfo.setPlainDid(str);
        didInfo.setDid(getUwbHashFirst3B(str));
    }

    public static void updateUwbDeviceLogin(UwbScanDevice uwbScanDevice, String str) {
        uwbScanDevice.setAccountInfo(getUwbHashFirst3B(str));
        uwbScanDevice.setAccountInfoPlain(str);
    }

    public static void updateUwbDeviceThirdTvLogin(UwbScanDevice uwbScanDevice, String str, String str2) {
        uwbScanDevice.setAccountInfo(getUwbHashFirst3B(str));
        uwbScanDevice.setAccountInfoPlain(str);
        TagState tagState = uwbScanDevice.getTagState();
        if (tagState == null) {
            tagState = new TagState();
            uwbScanDevice.setTagState(tagState);
        }
        DidInfo didInfo = uwbScanDevice.getDidInfo();
        if (didInfo == null) {
            didInfo = new DidInfo();
            uwbScanDevice.setDidInfo(didInfo);
        }
        didInfo.setDid(getUwbHashFirst3B(str2));
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("UwbDeviceUtil", "updateUwbDeviceThirdTvLogin for tagId=" + str2 + ",hashTagId=" + didInfo.getDid());
        }
        didInfo.setPlainDid(str2);
        tagState.setAssociationStatus(2);
    }

    public static boolean isThirdTagDevice(UwbScanDevice uwbScanDevice) {
        TagState tagState;
        if (isTagDeviceType(uwbScanDevice.getDeviceType()) && (tagState = uwbScanDevice.getTagState()) != null && tagState.getAssociationStatus() == 2 && isUsbInserted(uwbScanDevice) && !isMitvDeviceTagType(uwbScanDevice)) {
            return true;
        }
        return false;
    }

    public static String getUwbHashFirst3B(String str) {
        byte[] uwbHash3B = getUwbHash3B(str);
        if (uwbHash3B == null || uwbHash3B.length <= 0) {
            return null;
        }
        return ByteUtils.toHexString(uwbHash3B);
    }

    public static byte[] getUwbHash3B(String str) {
        byte[] bArr;
        try {
            bArr = ByteUtils.fromLong(Long.parseLong(str));
        } catch (Exception unused) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                UwbLogUtil.d("UwbDeviceUtil", "getUwbHash3B as string:id=" + str + ",bytes=" + Arrays.toString(bytes));
                bArr = bytes;
            } catch (Exception unused2) {
            }
        }
        byte[] hash = getHash(bArr);
        if (hash != null) {
            if (hash.length > 2) {
                byte[] bArr2 = new byte[3];
                System.arraycopy(hash, 0, bArr2, 0, 3);
                return bArr2;
            }
        }
        return null;
    }

    public static byte[] getHash(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUwbHashLast3AsString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String uwbHashFirst3B = getUwbHashFirst3B(str);
        return uwbHashFirst3B.substring(uwbHashFirst3B.length() - 3, uwbHashFirst3B.length());
    }

    public static byte[] getUwbHashLast3AsByte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0") && !TextUtils.equals(str, "null")) {
            try {
                byte[] bArr = new byte[3];
                System.arraycopy(MessageDigest.getInstance("SHA-256").digest(str.getBytes()), 0, bArr, 0, 3);
                return bArr;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return new byte[0];
    }

    public static boolean isUwbHashEnd(String str, String str2) {
        String uwbHashFirst3B;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (uwbHashFirst3B = getUwbHashFirst3B(str2)) == null || !uwbHashFirst3B.endsWith(str)) {
            return false;
        }
        return true;
    }

    public static boolean shouldOpenInMijiaPlus(UwbScanDevice uwbScanDevice) {
        if (getMijiaStatus() != 0 && uwbScanDevice != null && isMitvDeviceType(uwbScanDevice) && !isLogin(uwbScanDevice)) {
            return true;
        }
        return false;
    }

    public static String getDeviceAccountId(UwbScanDevice uwbScanDevice) {
        if (isBuiltinDeviceType(uwbScanDevice.getDeviceType())) {
            return uwbScanDevice.getAccountInfo();
        }
        if (!isMitvDeviceTagType(uwbScanDevice) || uwbScanDevice.getTagState() == null) {
            return uwbScanDevice.getAccountInfo();
        }
        return uwbScanDevice.getTagState().getTvAccountInfo();
    }

    public static boolean isUsbInserted(UwbScanDevice uwbScanDevice) {
        TagState tagState;
        if (uwbScanDevice == null || 3 != uwbScanDevice.getDeviceType() || (tagState = uwbScanDevice.getTagState()) == null || tagState.getUsb() == 0) {
            return false;
        }
        return true;
    }

    public static boolean isMitvDeviceType(UwbScanDevice uwbScanDevice) {
        return isBuiltinMitvDeviceType(uwbScanDevice) || isMitvDeviceTagType(uwbScanDevice);
    }

    public static boolean isBuiltinMitvDeviceType(UwbScanDevice uwbScanDevice) {
        if (2 == uwbScanDevice.getDeviceType() && uwbScanDevice.getDeviceState().getMilinkSupport() != 0) {
            return true;
        }
        return false;
    }

    public static boolean isMitvDeviceTagType(UwbScanDevice uwbScanDevice) {
        TagState tagState;
        if (3 == uwbScanDevice.getDeviceType() && (tagState = uwbScanDevice.getTagState()) != null && tagState.getMilinkSupport() == 1) {
            return true;
        }
        return false;
    }

    public static String getUwbDeviceKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        fas fas = fas.O000000o.f16038O000000o;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return fas.O0000O0o(str + ".uwbDeviceKey");
    }

    public static boolean isMitvDeviceShutdown(UwbScanDevice uwbScanDevice) {
        if (isMitvDeviceTagShutDown(uwbScanDevice)) {
            return true;
        }
        if (!isBuiltinMitvDeviceType(uwbScanDevice) || TextUtils.isEmpty(uwbScanDevice.getMacAddress()) || uwbScanDevice.getMacAddress().contains("0000")) {
            return false;
        }
        return true;
    }

    public static boolean isMitvDeviceTagShutDown(UwbScanDevice uwbScanDevice) {
        TagState tagState = uwbScanDevice.getTagState();
        return (tagState == null || tagState.getMilinkSupport() == 0 || tagState.getIdmSupport() == 0 || tagState.getShutDown() == 0) ? false : true;
    }

    public static String getMitvBleMac4B(String str) {
        int length = str.length();
        if (TextUtils.isEmpty(str) || length < 4) {
            return null;
        }
        String replace = str.replace(":", "");
        int length2 = replace.length();
        String substring = replace.substring(length2 - 4, length2);
        gsy.O000000o(3, "UwbDeviceUtil", "UwbLogUtilPlus getMitvBleMac4B: ".concat(String.valueOf(substring)));
        return substring;
    }

    public static boolean isMitvPublicMode(UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice == null) {
            return false;
        }
        return isMitvDeviceTagType(uwbScanDevice) ? 1 == uwbScanDevice.getTagState().getTvMode() : isBuiltinMitvDeviceType(uwbScanDevice) && 1 == uwbScanDevice.getDeviceState().getPlazaMode();
    }

    public static boolean isHidTagForMitv(UwbScanDevice uwbScanDevice) {
        TagState tagState;
        if (!isTagDeviceType(uwbScanDevice.getDeviceType()) || !isMitvDeviceTagType(uwbScanDevice) || (tagState = uwbScanDevice.getTagState()) == null) {
            return false;
        }
        tagState.getAssociationStatus();
        return false;
    }

    public static String getUwbDeviceID(UwbScanDevice uwbScanDevice) {
        String str = "";
        if (isTagDeviceType(uwbScanDevice.getDeviceType())) {
            if (uwbScanDevice.getDidInfo() == null) {
                str = uwbScanDevice.getBleAddress() + "_" + uwbScanDevice.getPid();
            } else {
                str = uwbScanDevice.getBleAddress() + "_" + uwbScanDevice.getDidInfo().getDid() + "_" + uwbScanDevice.getPid();
            }
        } else if (isBuiltinDeviceType(uwbScanDevice.getDeviceType()) && isLogin(uwbScanDevice)) {
            if (uwbScanDevice.getDidInfo() == null) {
                str = uwbScanDevice.getBleAddress() + "_" + uwbScanDevice.getPid();
            } else {
                str = uwbScanDevice.getDidInfo().getDid() + "_" + uwbScanDevice.getPid();
            }
        }
        String O000000o2 = grv.O000000o(str);
        UwbLogUtil.d("Mijia-UWB", "getUwbDeviceID:".concat(String.valueOf(O000000o2)));
        return O000000o2;
    }

    public static boolean isLogin(UwbScanDevice uwbScanDevice) {
        if (!isTagDeviceType(uwbScanDevice.getDeviceType()) || !isMitvDeviceTagType(uwbScanDevice)) {
            return uwbScanDevice != null && !TextUtils.isEmpty(uwbScanDevice.getAccountInfo()) && !uwbScanDevice.getAccountInfo().contains("000000");
        }
        return isMitvLogin(uwbScanDevice);
    }

    public static boolean checkIfValidTag(UwbScanDevice uwbScanDevice) {
        if (isBuiltinDeviceType(uwbScanDevice.getDeviceType())) {
            return true;
        }
        if (isHid(uwbScanDevice)) {
            return false;
        }
        if (uwbScanDevice.getDidInfo() != null && !TextUtils.isEmpty(uwbScanDevice.getDidInfo().getDid())) {
            return false;
        }
        if (TextUtils.isEmpty(uwbScanDevice.getAccountInfo()) || TextUtils.equals(uwbScanDevice.getAccountInfo(), "000000")) {
            return true;
        }
        return false;
    }

    public static boolean isIotBindedTag(UwbScanDevice uwbScanDevice) {
        TagState tagState;
        if (!isBuiltinDeviceType(uwbScanDevice.getDeviceType()) && (tagState = uwbScanDevice.getTagState()) != null && tagState.getAssociationStatus() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isHid(UwbScanDevice uwbScanDevice) {
        if (!isBuiltinDeviceType(uwbScanDevice.getDeviceType()) && uwbScanDevice.getTagState() != null && uwbScanDevice.getTagState().getAssociationStatus() == 2) {
            return true;
        }
        return false;
    }

    public static boolean isValidDeviceType(UwbScanDevice uwbScanDevice) {
        int deviceType = uwbScanDevice.getDeviceType();
        return deviceType == 0 || deviceType == 1 || deviceType == 2 || deviceType == 3;
    }

    public static int getMijiaStatus() {
        try {
            PackageInfo packageInfo = UwbSdk.getApplication().getPackageManager().getPackageInfo("com.xiaomi.smarthome", 0);
            if (packageInfo == null) {
                return 2;
            }
            if (packageInfo.getLongVersionCode() < 64500) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    public static int getTagBindStatus(UwbScanDevice uwbScanDevice) {
        boolean isLogin = isLogin(uwbScanDevice);
        if (!isLogin) {
            return 0;
        }
        DidInfo didInfo = uwbScanDevice.getDidInfo();
        boolean z = true;
        if (didInfo != null) {
            if (TextUtils.isEmpty(didInfo.getDid()) || didInfo.getDid().contains("000000")) {
                z = false;
            }
            if (z) {
                return 2;
            }
            return 0;
        } else if (isLogin) {
            return 1;
        } else {
            return 0;
        }
    }

    public static UwbConst.AppId getEstablishSecurityLineAppId(UwbScanDevice uwbScanDevice) {
        if (isMitvDeviceTagType(uwbScanDevice)) {
            return UwbConst.AppId.IDM;
        }
        if (isBuiltinMitvDeviceType(uwbScanDevice)) {
            return UwbConst.AppId.IDM;
        }
        if (getTagBindStatus(uwbScanDevice) == 1) {
            return UwbConst.AppId.ALL;
        }
        return UwbConst.AppId.TAG;
    }

    public static boolean isMijiaPlusNeedStopScan(UwbScanDevice uwbScanDevice) {
        if (isLogin(uwbScanDevice)) {
            return false;
        }
        if (isUsbInserted(uwbScanDevice) && !isMitvDeviceTagType(uwbScanDevice)) {
            return true;
        }
        if (isMitvDeviceShutdown(uwbScanDevice)) {
            return false;
        }
        if (isTagDeviceType(uwbScanDevice.getDeviceType()) && !isUsbInserted(uwbScanDevice)) {
            return true;
        }
        if (!isBuiltinDeviceType(uwbScanDevice.getDeviceType()) || isBuiltinMitvDeviceType(uwbScanDevice)) {
            return false;
        }
        return true;
    }

    public static boolean hasRealDid(UwbScanDevice uwbScanDevice) {
        if (!isTagDeviceType(uwbScanDevice.getDeviceType())) {
            return true;
        }
        if (isThirdTagDevice(uwbScanDevice)) {
            if (uwbScanDevice.getPid() != 5662) {
                return false;
            }
            return true;
        } else if (!isLogin(uwbScanDevice)) {
            return true;
        } else {
            return false;
        }
    }

    public static long convertMacAddressToLong(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 12) {
            return 0;
        }
        String replaceAll = str.replaceAll(":", "");
        if (replaceAll.length() > 16) {
            return 0;
        }
        return Long.parseLong(replaceAll, 16);
    }

    public static String convertLongToMacAddress(long j) {
        return ByteUtils.toHexString(ByteUtils.fromLongLittleEndian(j));
    }

    public static boolean isMitvAuthAll(UwbScanDevice uwbScanDevice) {
        if (isMitvDeviceTagType(uwbScanDevice)) {
            if (uwbScanDevice.getTagState() == null) {
                UwbLogUtil.w("UwbDeviceUtil", "UwbLogUtilPlus isMitvDeviceTagType is NOT AuthAll");
                return false;
            } else if (1 != uwbScanDevice.getTagState().getTvAuth()) {
                return true;
            } else {
                UwbLogUtil.w("UwbDeviceUtil", "UwbLogUtilPlus isMitvDeviceTagType is NOT AuthAll");
                return false;
            }
        } else if (!isBuiltinMitvDeviceType(uwbScanDevice)) {
            UwbLogUtil.w("UwbDeviceUtil", "UwbLogUtilPlus isMitvBuiltinType is NOT AuthAll");
            return false;
        } else if (1 != uwbScanDevice.getDeviceState().getAuth()) {
            return true;
        } else {
            UwbLogUtil.w("UwbDeviceUtil", "UwbLogUtilPlus isMitvBuiltinType is NOT AuthAll");
            return false;
        }
    }

    public static boolean isMitvLogin(UwbScanDevice uwbScanDevice) {
        return isMitvDeviceTagType(uwbScanDevice) ? uwbScanDevice.getTagState() != null && !TextUtils.isEmpty(uwbScanDevice.getTagState().getTvAccountInfo()) && !uwbScanDevice.getTagState().getTvAccountInfo().contains("000000") : isBuiltinMitvDeviceType(uwbScanDevice) && !TextUtils.isEmpty(uwbScanDevice.getAccountInfo()) && !uwbScanDevice.getAccountInfo().contains("000000");
    }

    public static boolean isMitvScreenOff(UwbScanDevice uwbScanDevice) {
        if (isMitvDeviceTagType(uwbScanDevice)) {
            if (uwbScanDevice.getTagState() == null) {
                return false;
            }
            if (1 == uwbScanDevice.getTagState().getTvScreenOff()) {
                return true;
            }
        }
        return isBuiltinMitvDeviceType(uwbScanDevice) && uwbScanDevice.getDeviceState() != null && 1 == uwbScanDevice.getDeviceState().getTvScreenOff();
    }

    public static void sendUwbShutdownBroadCast(Context context) {
        UwbLogUtil.d("UwbDeviceUtil", "UwbLogUtilPlus sendUwbShutdownBroadCast");
        context.sendBroadcast(new Intent("uwb_shutdown_broadcast"));
    }

    public static void performHapticConfirm(View view) {
        hzf.O000000o(view);
    }

    public static boolean isTagPower(UwbScanDevice uwbScanDevice) {
        TagState tagState;
        if ((!isMitvDeviceTagType(uwbScanDevice) || (tagState = uwbScanDevice.getTagState()) == null || 1 != tagState.getPower()) && !isBuiltinMitvDeviceType(uwbScanDevice)) {
            return false;
        }
        return true;
    }

    public static int getMitvPowerStatus(MitvInfo mitvInfo) {
        if (mitvInfo == null) {
            return -1;
        }
        if (TextUtils.equals(mitvInfo.getPowerShortPress(), "0")) {
            return 1;
        }
        if (!TextUtils.equals(mitvInfo.getPowerShortPress(), "1") && !TextUtils.equals(mitvInfo.getPowerShortPress(), "2")) {
            return 0;
        }
        return 2;
    }

    public static void saveUwbDeviceKey(String str, String str2) {
        fas fas = fas.O000000o.f16038O000000o;
        fas.O0000O0o(str2 + ".uwbDeviceKey", str);
    }

    public static void saveMitvBleMac(String str) {
        fas fas = fas.O000000o.f16038O000000o;
        int length = str.length();
        if (!TextUtils.isEmpty(str) && length >= 4) {
            String replace = str.replace(":", "");
            int length2 = replace.length();
            String str2 = replace.substring(length2 - 4, length2) + ".mitvBleMac";
            gsy.O00000Oo("SecurityCache", "UwbLogUtilPlus setMitvBleMac key: " + str2 + " blemac: " + str);
            fas.O0000O0o(str2, str);
        }
    }
}
