package com.xiaomi.smarthome.uwb.lib.mitv.parse;

import _m_j.bxd;
import _m_j.bxl;
import _m_j.bxm;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvNotif;
import com.xiaomi.smarthome.uwb.lib.mitv.data.VideoInfo;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

public class TVUwbDataBuilder {
    private static final String TAG = "com.xiaomi.smarthome.uwb.lib.mitv.parse.TVUwbDataBuilder";

    public static String buildRequestData(String str, String str2, Map<String, String> map) {
        bxm bxm = new bxm();
        StringBuilder sb = new StringBuilder();
        sb.append(new Random().nextInt(C.MSG_CUSTOM_BASE));
        String sb2 = sb.toString();
        bxm.O00000Oo = sb2;
        bxm.O00000o0 = "1";
        if (str2 == null) {
            bxm.f13380O000000o = "1234";
        } else {
            bxm.f13380O000000o = str2;
        }
        String O000000o2 = bxd.O000000o(bxm, str, map);
        UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-15-mijia-card-request:" + sb2 + "timeMills: " + System.currentTimeMillis());
        UwbLogUtil.w(TAG, "UwbLogUtilPlus buildRequestData: ".concat(String.valueOf(O000000o2)));
        return O000000o2;
    }

    public static String byteArrToString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("byteArr[");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(byte2Hex(bArr[i]) + " ");
        }
        return sb.toString().trim() + "]";
    }

    public static String byte2Hex(byte b) {
        int i = (b & Byte.MAX_VALUE) + (b < 0 ? (byte) 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }

    public static byte[] buildRequestDataByteArray(String str, String str2) {
        String buildRequestData = buildRequestData(str, null, null);
        try {
            byteArrToString(buildRequestData.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(buildRequestData)) {
            return new byte[0];
        }
        try {
            return buildRequestData.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static MitvNotif parseMitvNotif(bxl bxl) {
        if ("notifyTagOtaUpgradeInfo".equalsIgnoreCase(bxl.O000000o())) {
            MitvNotif mitvNotif = new MitvNotif();
            mitvNotif.setmNotif("notifyTagOtaUpgradeInfo");
            mitvNotif.setmParam("tagLatestVer", bxl.O000000o("tagLatestVer"));
            String str = TAG;
            UwbLogUtil.w(str, "UwbLogUtilPlus parseMitvNotif NotifyTagOtaUpgradeInfo: " + bxl.O000000o("tagLatestVer"));
            return mitvNotif;
        }
        if ("reqTvInfo".equalsIgnoreCase(bxl.O000000o())) {
            if (!TextUtils.isEmpty(bxl.O000000o("tagLatestVer"))) {
                MitvNotif mitvNotif2 = new MitvNotif();
                mitvNotif2.setmNotif("notifyTagOtaUpgradeInfo");
                mitvNotif2.setmParam("tagLatestVer", bxl.O000000o("tagLatestVer"));
                String str2 = TAG;
                UwbLogUtil.w(str2, "UwbLogUtilPlus parseMitvNotif ReqTvInfo: " + bxl.O000000o("tagLatestVer"));
                return mitvNotif2;
            }
        } else if ("notifyScreenState".equalsIgnoreCase(bxl.O000000o())) {
            MitvNotif mitvNotif3 = new MitvNotif();
            mitvNotif3.setmNotif("notifyScreenState");
            mitvNotif3.setmParam("screenOn", bxl.O000000o("screenOn"));
            String str3 = TAG;
            UwbLogUtil.w(str3, "UwbLogUtilPlus parseMitvNotif NotifyScreenState: " + bxl.O000000o("screenOn"));
            return mitvNotif3;
        }
        return null;
    }

    public static MitvInfo parseMitvInfo(bxl bxl) {
        if ("reqTvInfo".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo = new MitvInfo();
            String str = TAG;
            UwbLogUtil.w(str, "UwbLogUtilPlus ReqTvInfo: " + bxl.O000000o("tvName"));
            mitvInfo.setUwbVersion(bxl.O000000o("uwbVersion"));
            mitvInfo.setTvName(bxl.O000000o("tvName"));
            mitvInfo.setBleMac(bxl.O000000o("bleMac"));
            mitvInfo.setEhMac(bxl.O000000o("ehMac"));
            mitvInfo.setWifiMac(bxl.O000000o("wifiMac"));
            mitvInfo.setMiplayFlag(bxl.O000000o("miplayFlag"));
            mitvInfo.setMiAccountId(bxl.O000000o("miAccountId"));
            mitvInfo.setPartnerId(bxl.O000000o("partnerId"));
            mitvInfo.setScreenOn(bxl.O000000o("screenOn"));
            mitvInfo.setSupportXiaoai(bxl.O000000o("supportXiaoai"));
            mitvInfo.setPowerShortPress(bxl.O000000o("powerShortPress"));
            return mitvInfo;
        } else if ("reqPlayerInfo".equalsIgnoreCase(bxl.O000000o()) || "notifyPlayerInfo".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo2 = new MitvInfo();
            mitvInfo2.setIsPlaying(bxl.O000000o("isPlaying"));
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setMediaId(bxl.O000000o("mediaId"));
            videoInfo.setMediaName(bxl.O000000o("mediaName"));
            videoInfo.setCi(bxl.O000000o("ci"));
            videoInfo.setDuration(bxl.O000000o("duration"));
            videoInfo.setPosition(bxl.O000000o("position"));
            videoInfo.setSource(bxl.O000000o("source"));
            mitvInfo2.setmCurVideo(videoInfo);
            return mitvInfo2;
        } else if ("notifyTvNameChanged".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo3 = new MitvInfo();
            mitvInfo3.setTvName(bxl.O000000o("tvName"));
            return mitvInfo3;
        } else if ("notifyVideoPosition".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo4 = new MitvInfo();
            VideoInfo videoInfo2 = new VideoInfo();
            videoInfo2.setMediaId(bxl.O000000o("mediaId"));
            videoInfo2.setPosition(bxl.O000000o("position"));
            mitvInfo4.setmCurVideo(videoInfo2);
            return mitvInfo4;
        } else if ("notifyPlazaMode".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo5 = new MitvInfo();
            mitvInfo5.setPlazaMode(bxl.O000000o("plazaMode"));
            return mitvInfo5;
        } else if ("notifyAccountChanged".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo6 = new MitvInfo();
            mitvInfo6.setMiAccountId(bxl.O000000o("miAccountId"));
            return mitvInfo6;
        } else if ("notifyScreenState".equalsIgnoreCase(bxl.O000000o())) {
            MitvInfo mitvInfo7 = new MitvInfo();
            mitvInfo7.setScreenOn(bxl.O000000o("screenOn"));
            return mitvInfo7;
        } else if (!"notifyPowerShortPressChanged".equalsIgnoreCase(bxl.O000000o())) {
            return null;
        } else {
            MitvInfo mitvInfo8 = new MitvInfo();
            mitvInfo8.setPowerShortPress(bxl.O000000o("powerShortPress"));
            return mitvInfo8;
        }
    }
}
