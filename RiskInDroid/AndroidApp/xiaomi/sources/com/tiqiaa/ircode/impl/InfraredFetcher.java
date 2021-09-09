package com.tiqiaa.ircode.impl;

import android.content.Context;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.tiqiaa.icontrol.util.LogUtil;
import com.tiqiaa.icontrol.util.RemoteUtils;
import com.tiqiaa.icontrol.util.TQJSON;
import com.tiqiaa.ircode.AirRemoteStateMananger;
import com.tiqiaa.ircode.IInfraredFetcher;
import com.tiqiaa.local.LocalIrDb;
import com.tiqiaa.remote.entity.AirMode;
import com.tiqiaa.remote.entity.AirPower;
import com.tiqiaa.remote.entity.AirRemoteState;
import com.tiqiaa.remote.entity.AirTemp;
import com.tiqiaa.remote.entity.AirTime;
import com.tiqiaa.remote.entity.AirWindAmount;
import com.tiqiaa.remote.entity.AirWindDirection;
import com.tiqiaa.remote.entity.AirWindHoz;
import com.tiqiaa.remote.entity.AirWindVer;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.Remote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class InfraredFetcher implements IInfraredFetcher {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$ircode$impl$InfraredFetcher$AB;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirPower;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirTemp;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindDirection;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindHoz;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindVer;
    private static Map<String, AB> mRemoteABToggles;
    static Map<String, AirRemoteState> testAirKeyCache = new HashMap();
    private final String TAG = "InfraredFetcher";
    private Context mContext;
    private Map<Long, Integer> mDiyAirKeyInfraredIndexCache;

    enum AB {
        A,
        B
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$ircode$impl$InfraredFetcher$AB() {
        int[] iArr = $SWITCH_TABLE$com$tiqiaa$ircode$impl$InfraredFetcher$AB;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AB.values().length];
        iArr2[AB.A.ordinal()] = 1;
        iArr2[AB.B.ordinal()] = 2;
        $SWITCH_TABLE$com$tiqiaa$ircode$impl$InfraredFetcher$AB = iArr2;
        return iArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|6|7|8|9|10|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirPower() {
        int[] iArr = $SWITCH_TABLE$com$tiqiaa$remote$entity$AirPower;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AirPower.values().length];
        iArr2[AirPower.POWER_OFF.ordinal()] = 1;
        iArr2[AirPower.POWER_ON.ordinal()] = 2;
        try {
            iArr2[AirPower.WORK.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        $SWITCH_TABLE$com$tiqiaa$remote$entity$AirPower = iArr2;
        return iArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(34:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|(2:34|35)|36|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(35:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0069 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0087 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0091 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirTemp() {
        int[] iArr = $SWITCH_TABLE$com$tiqiaa$remote$entity$AirTemp;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AirTemp.values().length];
        iArr2[AirTemp.T16.ordinal()] = 1;
        iArr2[AirTemp.T17.ordinal()] = 2;
        iArr2[AirTemp.T18.ordinal()] = 3;
        iArr2[AirTemp.T19.ordinal()] = 4;
        iArr2[AirTemp.T20.ordinal()] = 5;
        iArr2[AirTemp.T21.ordinal()] = 6;
        iArr2[AirTemp.T22.ordinal()] = 7;
        iArr2[AirTemp.T23.ordinal()] = 8;
        iArr2[AirTemp.T24.ordinal()] = 9;
        iArr2[AirTemp.T25.ordinal()] = 10;
        iArr2[AirTemp.T26.ordinal()] = 11;
        iArr2[AirTemp.T27.ordinal()] = 12;
        iArr2[AirTemp.T28.ordinal()] = 13;
        iArr2[AirTemp.T29.ordinal()] = 14;
        iArr2[AirTemp.T30.ordinal()] = 15;
        try {
            iArr2[AirTemp.T31.ordinal()] = 16;
        } catch (NoSuchFieldError unused) {
        }
        $SWITCH_TABLE$com$tiqiaa$remote$entity$AirTemp = iArr2;
        return iArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|8|9|10|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindDirection() {
        int[] iArr = $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindDirection;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AirWindDirection.values().length];
        iArr2[AirWindDirection.AUTO.ordinal()] = 1;
        iArr2[AirWindDirection.DOWN.ordinal()] = 4;
        iArr2[AirWindDirection.MIDDLE.ordinal()] = 3;
        iArr2[AirWindDirection.UP.ordinal()] = 2;
        $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindDirection = iArr2;
        return iArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindHoz() {
        int[] iArr = $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindHoz;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AirWindHoz.values().length];
        iArr2[AirWindHoz.HOZ_OFF.ordinal()] = 1;
        iArr2[AirWindHoz.HOZ_ON.ordinal()] = 2;
        $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindHoz = iArr2;
        return iArr2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    static /* synthetic */ int[] $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindVer() {
        int[] iArr = $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindVer;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AirWindVer.values().length];
        iArr2[AirWindVer.VER_OFF.ordinal()] = 1;
        iArr2[AirWindVer.VER_ON.ordinal()] = 2;
        $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindVer = iArr2;
        return iArr2;
    }

    public InfraredFetcher(Context context) {
        if (mRemoteABToggles == null) {
            mRemoteABToggles = new HashMap();
        }
        this.mDiyAirKeyInfraredIndexCache = new HashMap();
        this.mContext = context;
    }

    public List<Infrared> fetchNoAirInfrareds(Remote remote, Key key) {
        if (remote == null || key == null || key.getInfrareds() == null || key.getInfrareds().size() == 0 || remote.getKeys() == null || remote.getKeys().size() == 0) {
            return null;
        }
        if (RemoteUtils.isMultiAirRemote(remote)) {
            throw new RuntimeException("the remote is a multi-IR air-condition remote,please call method 'fetchAirInfrareds(Remote,Key,AirRemoteState)' instead to get ir codes..");
        } else if (key == null || key.getInfrareds() == null) {
            LogUtil.e("InfraredFetcher", "fetchInfrareds................key==null");
            return null;
        } else {
            LogUtil.d("InfraredFetcher", "fetchInfrareds..............普通按键...........key.getInfrareds().");
            AB ab = mRemoteABToggles.get(key.getRemote_id());
            if (ab == null) {
                ab = AB.A;
                mRemoteABToggles.put(key.getRemote_id(), AB.A);
            }
            if (key.getInfrareds().size() != 1 && key.getType() != -90 && key.getType() != 815 && key.getType() != 816) {
                return filterAbInfrareds(key, ab);
            }
            LogUtil.d("InfraredFetcher", "fetchInfrareds............信号数量为 1 或者 是记忆键");
            return key.getInfrareds();
        }
    }

    public List<Infrared> fetchAirInfrareds(Remote remote, Key key, AirRemoteState airRemoteState) {
        if (remote == null || key == null || airRemoteState == null) {
            LogUtil.e("InfraredFetcher", "fetchAirInfrareds.........参数空....remote==null||key==null||air_state==null");
            return null;
        }
        LogUtil.e("InfraredFetcher", "fetchAirInfrareds........................................key.getProtocol=" + key.getProtocol() + ",remoteId=" + remote.getId());
        if (key.getProtocol() > 0) {
            AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
            LogUtil.d("InfraredFetcher", "fetchAirInfrareds..............................协议空调按键..........air_state = ".concat(String.valueOf(airRemoteState)));
            return fetchProtocolAirInfrareds(key, airRemoteState);
        }
        LogUtil.w("InfraredFetcher", "fetchAirInfrareds........................DIY的组合空调按键................air_state = ".concat(String.valueOf(airRemoteState)));
        AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
        return fetchDiyAirInfrareds(remote, key, airRemoteState);
    }

    private List<Infrared> fetchProtocolAirInfrareds(Key key, AirRemoteState airRemoteState) {
        LogUtil.d("InfraredFetcher", "fetchAirInfrareds fetchProtocolAirInfrareds........................................协议空调码获取");
        if (airRemoteState == null) {
            return null;
        }
        if (airRemoteState.getPower() != AirPower.POWER_OFF || key.getType() == 800) {
            LogUtil.d("InfraredFetcher", "fetchAirInfrareds fetchProtocolAirInfrareds............计算信号");
            return loadAirCodes(airRemoteState);
        }
        LogUtil.e("InfraredFetcher", "fetchAirInfrareds fetchProtocolAirInfrareds.............关键状态点击其他按键 不作响应");
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:227:0x050f, code lost:
        return null;
     */
    private List<Infrared> fetchDiyAirInfrareds(Remote remote, Key key, AirRemoteState airRemoteState) {
        while (true) {
            LogUtil.d("InfraredFetcher", "fetchDiyAirInfrareds....##############....DIY空调码获取....air_state = " + TQJSON.toJSONString(airRemoteState));
            ArrayList arrayList = null;
            if (remote == null || remote.getKeys() == null || key == null || key.getInfrareds() == null || key.getInfrareds().size() == 0 || airRemoteState == null) {
                LogUtil.e("InfraredFetcher", "fetchDiyAirInfrareds........DIY空调码获取..！！！！.数据不完整");
            } else if (airRemoteState.getPower() == AirPower.POWER_OFF && key.getType() != 800) {
                return null;
            } else {
                if (key.getType() != 800) {
                    airRemoteState.setLast_key(key.getType());
                }
                LogUtil.v("InfraredFetcher", "fetchDiyAirInfrareds........DIY空调码获取.....air_state.mode = " + airRemoteState.getMode());
                int type = key.getType();
                int i = 1;
                if (type == 800) {
                    if ($SWITCH_TABLE$com$tiqiaa$remote$entity$AirPower()[airRemoteState.getPower().ordinal()] == 2) {
                        i = 0;
                    }
                    for (Infrared next : key.getInfrareds()) {
                        if (next.getFunc() == i) {
                            arrayList = new ArrayList();
                            arrayList.add(next);
                        }
                    }
                    if (arrayList != null) {
                        if (airRemoteState.getPower() != AirPower.POWER_ON || airRemoteState.getLast_key() <= 0) {
                            return arrayList;
                        }
                        LogUtil.w("InfraredFetcher", "fetchDiyAirInfrareds............已找到开机信号，尝试寻找最后状态信号");
                        for (Key next2 : remote.getKeys()) {
                            if (next2 != null && next2.getType() == airRemoteState.getLast_key()) {
                                LogUtil.i("InfraredFetcher", "fetchDiyAirInfrareds............找到最后的信号.....air_state.getLast_key() = " + airRemoteState.getLast_key());
                                if (next2.getInfrareds() == null) {
                                    continue;
                                } else if (airRemoteState.getMode() == AirMode.COOL || airRemoteState.getMode() == AirMode.HOT) {
                                    for (Infrared next3 : next2.getInfrareds()) {
                                        if (next3 != null && next3.getFunc() == airRemoteState.getMode().value() && next3.getMark() == airRemoteState.getTemp().value()) {
                                            LogUtil.i("InfraredFetcher", "######################.......找到最后的温度信号....ir.getFunc() = " + AirMode.getMode(next3.getFunc()) + "....ir.getMark() = " + next3.getMark());
                                            arrayList.add(next3);
                                            return arrayList;
                                        }
                                    }
                                    continue;
                                } else {
                                    for (Infrared next4 : next2.getInfrareds()) {
                                        if (next4 != null && next4.getFunc() == airRemoteState.getMode().value()) {
                                            LogUtil.i("InfraredFetcher", "######################.......找到最后的模式信号........");
                                            arrayList.add(next4);
                                            return arrayList;
                                        }
                                    }
                                    continue;
                                }
                            }
                        }
                        return arrayList;
                    } else if (!validateDiyAirKey(key)) {
                        return filterInfraredsByIndex(key);
                    } else {
                        LogUtil.w("InfraredFetcher", "fetchDiyAirInfrareds.........递归寻找下一开关信号......key.protocol = " + key.getProtocol() + ",key.getInfrared.size = " + key.getInfrareds().size());
                        AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                    }
                } else if (type != 870) {
                    if (type == 811) {
                        int value = airRemoteState.getTemp().value();
                        for (Infrared next5 : key.getInfrareds()) {
                            if (next5.getFunc() == airRemoteState.getMode().value() && next5.getMark() == value) {
                                LogUtil.i("InfraredFetcher", "fetchDiyAirInfrareds..........temp_up........找到匹配温度信号.");
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(next5);
                                return arrayList2;
                            }
                        }
                        AirTemp airMaxTemp = AirRemoteStateMananger.getInstance(this.mContext).getAirMaxTemp(key, airRemoteState);
                        LogUtil.d("InfraredFetcher", "fetchDiyAirInfrareds..................寻找最大温度信号...maxTemp = ".concat(String.valueOf(airMaxTemp)));
                        if (airRemoteState.getTemp().value() >= airMaxTemp.value()) {
                            Infrared infrared = null;
                            for (Infrared next6 : key.getInfrareds()) {
                                if (next6 != null && next6.getFunc() == airRemoteState.getMode().value() && next6.getMark() > 0) {
                                    try {
                                        if (next6.getMark() >= airMaxTemp.value()) {
                                            LogUtil.i("InfraredFetcher", "fetchDiyAirInfrareds..................找到最大温度信号...");
                                            infrared = next6;
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            airRemoteState.setTemp(airMaxTemp);
                            if (infrared != null) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(infrared);
                                return arrayList3;
                            } else if (!validateDiyAirKey(key)) {
                                return filterInfraredsByIndex(key);
                            } else {
                                return null;
                            }
                        } else {
                            AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                        }
                    } else if (type != 812) {
                        switch (type) {
                            case 832:
                                if (airRemoteState.getMode() == AirMode.COOL || airRemoteState.getMode() == AirMode.HOT) {
                                    LogUtil.w("InfraredFetcher", "fetchDiyAirInfrareds...............................目标模式是制冷或取暖，则寻找最佳温度信号发出去");
                                    Infrared fetchMinDiffTempInfrared = fetchMinDiffTempInfrared(airRemoteState, remote);
                                    break;
                                } else {
                                    for (Infrared next7 : key.getInfrareds()) {
                                        if (next7 != null && next7.getFunc() == airRemoteState.getMode().value()) {
                                            ArrayList arrayList4 = new ArrayList();
                                            arrayList4.add(next7);
                                            return arrayList4;
                                        }
                                    }
                                    LogUtil.e("InfraredFetcher", "fetchDiyAirInfrareds............................找不到合适的模式信号");
                                    if (!validateDiyAirKey(key)) {
                                        return filterInfraredsByIndex(key);
                                    }
                                    AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                                    continue;
                                }
                            case 833:
                                int value2 = airRemoteState.getWind_amount().value();
                                for (Infrared next8 : key.getInfrareds()) {
                                    if (next8.getFunc() == value2) {
                                        ArrayList arrayList5 = new ArrayList();
                                        arrayList5.add(next8);
                                        return arrayList5;
                                    }
                                }
                                if (!validateDiyAirKey(key)) {
                                    return filterInfraredsByIndex(key);
                                }
                                AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                                continue;
                            case 834:
                                if (airRemoteState.getWind_hoz() == null) {
                                    return null;
                                }
                                if ($SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindHoz()[airRemoteState.getWind_hoz().ordinal()] != 2) {
                                    AirWindHoz.HOZ_ON.value();
                                    airRemoteState.setWind_hoz(AirWindHoz.HOZ_ON);
                                } else {
                                    AirWindHoz.HOZ_OFF.value();
                                    airRemoteState.setWind_hoz(AirWindHoz.HOZ_OFF);
                                }
                                if (!validateDiyAirKey(key)) {
                                    return filterInfraredsByIndex(key);
                                }
                                AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                                continue;
                            case 835:
                                if (airRemoteState.getWind_ver() == null) {
                                    return null;
                                }
                                if ($SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindVer()[airRemoteState.getWind_ver().ordinal()] != 2) {
                                    AirWindVer.VER_ON.value();
                                    airRemoteState.setWind_ver(AirWindVer.VER_ON);
                                } else {
                                    AirWindVer.VER_OFF.value();
                                    airRemoteState.setWind_ver(AirWindVer.VER_OFF);
                                }
                                if (!validateDiyAirKey(key)) {
                                    return filterInfraredsByIndex(key);
                                }
                                AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                                continue;
                            default:
                                return key.getInfrareds();
                        }
                    } else {
                        int value3 = airRemoteState.getTemp().value();
                        for (Infrared next9 : key.getInfrareds()) {
                            if (next9.getFunc() == airRemoteState.getMode().value() && next9.getMark() == value3) {
                                LogUtil.i("InfraredFetcher", "fetchDiyAirInfrareds..........temp_down........找到匹配温度信号.");
                                ArrayList arrayList6 = new ArrayList();
                                arrayList6.add(next9);
                                return arrayList6;
                            }
                        }
                        AirTemp airMinTemp = AirRemoteStateMananger.getInstance(this.mContext).getAirMinTemp(key, airRemoteState);
                        LogUtil.d("InfraredFetcher", "fetchDiyAirInfrareds..................寻找最小温度信号...minTemp = ".concat(String.valueOf(airMinTemp)));
                        if (airRemoteState.getTemp().value() <= airMinTemp.value()) {
                            Infrared infrared2 = null;
                            for (Infrared next10 : key.getInfrareds()) {
                                if (next10 != null && next10.getFunc() == airRemoteState.getMode().value() && next10.getMark() > 0) {
                                    try {
                                        if (next10.getMark() <= airMinTemp.value()) {
                                            LogUtil.i("InfraredFetcher", "fetchDiyAirInfrareds..................找到最小温度信号...");
                                            infrared2 = next10;
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                            airRemoteState.setTemp(airMinTemp);
                            if (infrared2 != null) {
                                ArrayList arrayList7 = new ArrayList();
                                arrayList7.add(infrared2);
                                return arrayList7;
                            } else if (validateDiyAirKey(key)) {
                                return null;
                            } else {
                                AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                                return filterInfraredsByIndex(key);
                            }
                        }
                    }
                } else if (airRemoteState.getWind_direction() == null) {
                    return null;
                } else {
                    airRemoteState.getWind_direction().value();
                    int i2 = $SWITCH_TABLE$com$tiqiaa$remote$entity$AirWindDirection()[airRemoteState.getWind_direction().ordinal()];
                    if (i2 == 1) {
                        AirWindDirection.DOWN.value();
                        airRemoteState.setWind_direction(AirWindDirection.DOWN);
                    } else if (i2 == 3) {
                        AirWindDirection.UP.value();
                        airRemoteState.setWind_direction(AirWindDirection.UP);
                    } else if (i2 != 4) {
                        AirWindDirection.AUTO.value();
                        airRemoteState.setWind_direction(AirWindDirection.AUTO);
                    } else {
                        AirWindDirection.MIDDLE.value();
                        airRemoteState.setWind_direction(AirWindDirection.MIDDLE);
                    }
                    if (!validateDiyAirKey(key)) {
                        return filterInfraredsByIndex(key);
                    }
                    AirRemoteStateMananger.getInstance(this.mContext).fitAirState(airRemoteState, key);
                }
            }
        }
        LogUtil.w("InfraredFetcher", "fetchDiyAirInfrareds...............................目标模式是制冷或取暖，则寻找最佳温度信号发出去");
        Infrared fetchMinDiffTempInfrared2 = fetchMinDiffTempInfrared(airRemoteState, remote);
        if (fetchMinDiffTempInfrared2 != null) {
            ArrayList arrayList8 = new ArrayList();
            arrayList8.add(fetchMinDiffTempInfrared2);
            return arrayList8;
        }
        LogUtil.e("InfraredFetcher", "fetchDiyAirInfrareds............................找不到合适的温度信号");
        return null;
    }

    public List<Infrared> fetchAirInfrareds(Remote remote, AirRemoteState airRemoteState, AirPower airPower, AirMode airMode, AirWindAmount airWindAmount, AirTemp airTemp) {
        Key key;
        LogUtil.d("InfraredFetcher", "fetchAirInfrareds...........power = " + airPower + ",mode = " + airMode + ", wind_amount = " + airWindAmount + ", temp = " + airTemp);
        if (airRemoteState == null) {
            return null;
        }
        boolean isProtocolAirRemote = RemoteUtils.isProtocolAirRemote(remote);
        airRemoteState.setPower(airPower);
        airRemoteState.setMode(airMode);
        airRemoteState.setWind_amount(airWindAmount);
        if (airTemp != null) {
            airRemoteState.setTemp(airTemp);
        } else {
            airRemoteState.setTemp(AirTemp.T26);
        }
        int i = airPower == AirPower.POWER_ON ? (!isProtocolAirRemote || !(airMode == AirMode.COOL || airMode == AirMode.HOT)) ? 832 : 811 : 800;
        airRemoteState.setCurrent_key(i);
        Iterator<Key> it = remote.getKeys().iterator();
        while (true) {
            if (it.hasNext()) {
                key = it.next();
                if (key != null && key.getType() == i) {
                    airRemoteState.setProtocol(key.getProtocol());
                    break;
                }
            } else {
                key = null;
                break;
            }
        }
        LogUtil.w("InfraredFetcher", "fetchAirInfrareds..........获取指定遥控器的调整到指定状态的信号....state = ".concat(String.valueOf(airRemoteState)));
        LogUtil.e("InfraredFetcher", "fetchAirInfrareds..........获取指定遥控器的调整到指定状态的信号....clickKey = " + TQJSON.toJSONString(key));
        if (isProtocolAirRemote) {
            return loadAirCodes(airRemoteState);
        }
        return fetchDiyAirInfrareds(remote, key, airRemoteState);
    }

    public List<Infrared> fetchAirTimeInfrareds(Key key, int i, AirRemoteState airRemoteState) {
        if (key == null || i <= 0 || airRemoteState == null) {
            return null;
        }
        airRemoteState.setProtocol(key.getProtocol());
        airRemoteState.setCurrent_key(876);
        airRemoteState.setTime(AirTime.TIME_ON);
        airRemoteState.setTime_limit(i);
        LogUtil.w("InfraredFetcher", "获取定时信号 ...air_state.Time_limit = " + airRemoteState.getTime_limit() + "....air_state -> " + TQJSON.toJSONString(airRemoteState));
        return loadAirCodes(airRemoteState);
    }

    private List<Infrared> filterInfraredsByIndex(Key key) {
        Integer num;
        LogUtil.d("InfraredFetcher", "filterInfraredsByIndex.........通过记录的索引获取信号");
        Integer num2 = this.mDiyAirKeyInfraredIndexCache.get(Long.valueOf(key.getId()));
        if (num2 == null) {
            LogUtil.w("InfraredFetcher", "filterInfraredsByIndex.........通过记录的索引获取信号.....初始化此按键的索引");
            this.mDiyAirKeyInfraredIndexCache.put(Long.valueOf(key.getId()), 0);
            num = 0;
        } else {
            LogUtil.i("InfraredFetcher", "filterInfraredsByIndex.........通过记录的索引获取信号.....index++");
            num = Integer.valueOf(num2.intValue() + 1);
        }
        LogUtil.d("InfraredFetcher", "filterInfraredsByIndex.........通过记录的索引获取信号.....index = ".concat(String.valueOf(num)));
        ArrayList arrayList = new ArrayList();
        if (num.intValue() >= key.getInfrareds().size()) {
            LogUtil.w("InfraredFetcher", "filterInfraredsByIndex....通过记录的索引获取信号.....到底后归零....index = " + num + ",key.infrareds.size=" + key.getInfrareds().size());
            num = 0;
        }
        arrayList.add(key.getInfrareds().get(num.intValue()));
        this.mDiyAirKeyInfraredIndexCache.put(Long.valueOf(key.getId()), num);
        return arrayList;
    }

    private List<Infrared> filterAbInfrareds(Key key, AB ab) {
        LogUtil.d("InfraredFetcher", "filterAbInfrareds.........寻找下一状态的信号....当前是 AB状态为 -> ".concat(String.valueOf(ab)));
        ArrayList arrayList = new ArrayList();
        for (Infrared next : key.getInfrareds()) {
            if (next != null) {
                int i = $SWITCH_TABLE$com$tiqiaa$ircode$impl$InfraredFetcher$AB()[ab.ordinal()];
                if (i != 1) {
                    if (i == 2 && 1 == next.getMark()) {
                        arrayList.add(next);
                        LogUtil.v("InfraredFetcher", "filterAbInfrareds.............当前是 AB状态为 -> B......找到A信号，加入结果集....ir = " + TQJSON.toJSONString(next));
                    }
                } else if (2 == next.getMark()) {
                    arrayList.add(next);
                    LogUtil.d("InfraredFetcher", "filterAbInfrareds.............当前是 AB状态为 -> A......找到B信号，加入结果集....ir = " + TQJSON.toJSONString(next));
                }
            }
        }
        if (arrayList.size() <= 0) {
            return key.getInfrareds();
        }
        StringBuilder sb = new StringBuilder("filterAbInfrareds.............寻找AB信号成功，切换AB标志....当前为  ");
        sb.append(ab);
        sb.append(",切换 为");
        sb.append(ab == AB.A ? AB.B : AB.A);
        LogUtil.w("InfraredFetcher", sb.toString());
        mRemoteABToggles.put(key.getRemote_id(), ab == AB.A ? AB.B : AB.A);
        return arrayList;
    }

    private boolean validateDiyAirKey(Key key) {
        if (key == null || key.getInfrareds() == null) {
            return false;
        }
        for (Infrared next : key.getInfrareds()) {
            if (!(next == null || next.getData() == null)) {
                int type = key.getType();
                if (type != 800) {
                    if (type == 811 || type == 812) {
                        if ((next.getFunc() == 3 || next.getFunc() == 4) && next.getMark() >= 16 && next.getMark() <= 31) {
                            return true;
                        }
                    } else if (type != 832) {
                        if (type == 833 && (next.getFunc() == 0 || next.getFunc() == 1 || next.getFunc() == 2 || next.getFunc() == 3 || next.getFunc() == 4)) {
                            return true;
                        }
                    } else if (next.getFunc() == 0 || next.getFunc() == 1 || next.getFunc() == 2 || next.getFunc() == 3 || next.getFunc() == 4) {
                        return true;
                    }
                } else if (next.getFunc() == 0 || next.getFunc() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private AirTemp getPlusTemp(AirRemoteState airRemoteState) {
        if (airRemoteState == null) {
            return AirTemp.T31;
        }
        return getPlusTemp(airRemoteState.getTemp());
    }

    private AirTemp getPlusTemp(AirTemp airTemp) {
        if (airTemp == null) {
            return AirTemp.T31;
        }
        switch ($SWITCH_TABLE$com$tiqiaa$remote$entity$AirTemp()[airTemp.ordinal()]) {
            case 1:
                return AirTemp.T17;
            case 2:
                return AirTemp.T18;
            case 3:
                return AirTemp.T19;
            case 4:
                return AirTemp.T20;
            case 5:
                return AirTemp.T21;
            case 6:
                return AirTemp.T22;
            case 7:
                return AirTemp.T23;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return AirTemp.T24;
            case 9:
                return AirTemp.T25;
            case 10:
                return AirTemp.T26;
            case 11:
                return AirTemp.T27;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return AirTemp.T28;
            case 13:
                return AirTemp.T29;
            case 14:
                return AirTemp.T30;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return AirTemp.T31;
            default:
                return AirTemp.T31;
        }
    }

    private AirTemp getReduceTemp(AirRemoteState airRemoteState) {
        if (airRemoteState == null) {
            return AirTemp.T17;
        }
        return getReduceTemp(airRemoteState.getTemp());
    }

    private AirTemp getReduceTemp(AirTemp airTemp) {
        if (airTemp == null) {
            return AirTemp.T17;
        }
        switch ($SWITCH_TABLE$com$tiqiaa$remote$entity$AirTemp()[airTemp.ordinal()]) {
            case 2:
                return AirTemp.T16;
            case 3:
                return AirTemp.T17;
            case 4:
                return AirTemp.T18;
            case 5:
                return AirTemp.T19;
            case 6:
                return AirTemp.T20;
            case 7:
                return AirTemp.T21;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return AirTemp.T22;
            case 9:
                return AirTemp.T23;
            case 10:
                return AirTemp.T24;
            case 11:
                return AirTemp.T25;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return AirTemp.T26;
            case 13:
                return AirTemp.T27;
            case 14:
                return AirTemp.T28;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return AirTemp.T29;
            case 16:
                return AirTemp.T30;
            default:
                return AirTemp.T16;
        }
    }

    public List<Infrared> loadAirCodes(AirRemoteState airRemoteState) {
        if (airRemoteState == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[19];
        bArr[0] = (byte) airRemoteState.getPower().value();
        bArr[1] = (byte) airRemoteState.getMode().value();
        bArr[2] = (byte) airRemoteState.getTemp().value();
        bArr[3] = (byte) airRemoteState.getWind_amount().value();
        if (airRemoteState.getWind_direction() != null) {
            bArr[4] = (byte) airRemoteState.getWind_direction().value();
            bArr[5] = 0;
            bArr[6] = 0;
        } else {
            bArr[4] = 0;
            bArr[5] = (byte) airRemoteState.getWind_hoz().value();
            bArr[6] = (byte) airRemoteState.getWind_ver().value();
        }
        bArr[7] = (byte) airRemoteState.getSuper_mode().value();
        bArr[8] = (byte) airRemoteState.getSleep().value();
        bArr[9] = (byte) airRemoteState.getHot().value();
        bArr[10] = (byte) airRemoteState.getTime().value();
        bArr[11] = (byte) airRemoteState.getTemp_display().value();
        bArr[12] = (byte) airRemoteState.getPower_saving().value();
        bArr[13] = (byte) airRemoteState.getAnion().value();
        bArr[14] = (byte) airRemoteState.getComfort().value();
        bArr[15] = (byte) airRemoteState.getFlash_air().value();
        bArr[16] = (byte) airRemoteState.getLight().value();
        bArr[17] = (byte) airRemoteState.getWet().value();
        bArr[18] = (byte) airRemoteState.getMute().value();
        arrayList.add(LocalIrDb.getIrDb(this.mContext).getAirCode(airRemoteState.getProtocol(), airRemoteState.getCurrent_key(), airRemoteState.getCaculate_number(), airRemoteState.getTime_limit(), bArr));
        if (airRemoteState.getCurrent_key() == 800 && airRemoteState.getPower() == AirPower.POWER_ON && airRemoteState.getLast_key() > 0) {
            airRemoteState.setCurrent_key(airRemoteState.getLast_key());
            LogUtil.v("InfraredFetcher", "loadAirCode.....############..生成上次关机前的信号.....last_key = " + airRemoteState.getLast_key() + ",current_key = " + airRemoteState.getCurrent_key() + ",caculate_number = " + airRemoteState.getCaculate_number() + ",cime_limit = " + airRemoteState.getTime_limit());
            airRemoteState.setCaculate_number(airRemoteState.getCaculate_number() + 1);
            arrayList.add(LocalIrDb.getIrDb(this.mContext).getAirCode(airRemoteState.getProtocol(), airRemoteState.getCurrent_key(), airRemoteState.getCaculate_number(), airRemoteState.getTime_limit(), bArr));
        }
        LogUtil.d("InfraredFetcher", "loadAirCode.....############.....获取到的信号有 ——> " + TQJSON.toJSONString(arrayList));
        return arrayList;
    }

    private int diffTemp(AirRemoteState airRemoteState, Key key) {
        if (airRemoteState == null || airRemoteState.getTemp() == null || airRemoteState.getMode() == null || key == null || key.getInfrareds() == null || key.getInfrareds().size() == 0) {
            return -1;
        }
        int i = -1;
        for (Infrared next : key.getInfrareds()) {
            if (next != null && next.getFunc() == airRemoteState.getMode().value() && next.getMark() > 0) {
                try {
                    int abs = Math.abs(next.getMark() - airRemoteState.getTemp().value());
                    if (i == -1 || i > abs) {
                        i = abs;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }

    private Infrared fetchMinDiffTempInfrared(AirRemoteState airRemoteState, Remote remote) {
        LogUtil.d("InfraredFetcher", "fetchMinDiffTempInfrared.....state = " + TQJSON.toJSONString(airRemoteState));
        Infrared infrared = null;
        if (airRemoteState == null || airRemoteState.getTemp() == null || airRemoteState.getMode() == null || remote == null || remote.getKeys() == null || remote.getKeys().size() == 0) {
            return null;
        }
        int i = -1;
        for (Key next : remote.getKeys()) {
            if (!(next == null || next.getInfrareds() == null)) {
                for (Infrared next2 : next.getInfrareds()) {
                    if (next2 != null && next2.getFunc() == airRemoteState.getMode().value() && next2.getMark() > 0) {
                        try {
                            int abs = Math.abs(next2.getMark() - airRemoteState.getTemp().value());
                            LogUtil.v("InfraredFetcher", "fetchMinDiffTempInfrared..........ir.getMark() = " + next2.getMark() + ", state.getTemp() = " + airRemoteState.getTemp() + ",diff = " + abs);
                            if (i != -1) {
                                if (i < abs) {
                                    LogUtil.w("InfraredFetcher", "fetchMinDiffTempInfrared..........不符合替换最佳信号条件....");
                                }
                            }
                            try {
                                LogUtil.d("InfraredFetcher", "fetchMinDiffTempInfrared..........符合替换最佳信号条件....");
                                infrared = next2;
                                i = abs;
                            } catch (Exception e) {
                                i = abs;
                                Infrared infrared2 = next2;
                                e = e;
                                infrared = infrared2;
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        if (infrared != null) {
            LogUtil.d("InfraredFetcher", "fetchMinDiffTempInfrared.....找到的最佳信号  minDiffInfrared = " + TQJSON.toJSONString(infrared));
            try {
                airRemoteState.setTemp(AirTemp.getAirTemp(infrared.getMark()));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return infrared;
    }

    public List<Infrared> fetchInfrareds(Remote remote, Key key) {
        return getOriginalInfrareds(remote, key);
    }

    public AirRemoteState getAirRemoteStatus(Remote remote) {
        if (remote != null && RemoteUtils.isMultiAirRemote(remote)) {
            return AirRemoteStateMananger.getInstance(this.mContext).getAirRemoteState(remote.getId());
        }
        LogUtil.e("InfraredFetcher", "fetchAirInfrareds getAirRemoteStatus------return null!");
        return null;
    }

    public void clearAirRemoteStatus(String str) {
        AirRemoteStateMananger.getInstance(this.mContext).clearAirRemoteState(str);
    }

    private List<Infrared> getOriginalInfrareds(Remote remote, Key key) {
        if (!RemoteUtils.isMultiAirRemote(remote)) {
            return fetchNoAirInfrareds(remote, key);
        }
        AirRemoteState airRemoteStatus = getAirRemoteStatus(remote);
        List<Infrared> fetchAirInfrareds = fetchAirInfrareds(remote, key, airRemoteStatus);
        AirRemoteStateMananger.getInstance(this.mContext).saveAirRemoteState(airRemoteStatus);
        return fetchAirInfrareds;
    }

    public List<Infrared> fetchAirTestInfrareds(Remote remote, Key key) {
        AirRemoteState airRemoteState;
        if (testAirKeyCache.get(remote.getId()) != null) {
            airRemoteState = testAirKeyCache.get(remote.getId());
        } else {
            airRemoteState = new AirRemoteState(remote.getId());
            testAirKeyCache.put(remote.getId(), airRemoteState);
        }
        if (key.getType() != 800) {
            airRemoteState.setPower(AirPower.POWER_ON);
        }
        return fetchAirInfrareds(remote, key, airRemoteState);
    }
}
