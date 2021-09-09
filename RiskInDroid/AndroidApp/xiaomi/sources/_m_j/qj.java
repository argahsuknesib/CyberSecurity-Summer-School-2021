package _m_j;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.List;

public final class qj {
    private static byte O000000o(TelephonyManager telephonyManager) {
        try {
            return (byte) telephonyManager.getNetworkType();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static CellInfo O000000o(List<CellInfo> list) {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        if (list != null) {
            for (CellInfo next : list) {
                if (((next instanceof CellInfoLte) || (next instanceof CellInfoCdma) || (next instanceof CellInfoGsm)) && next.isRegistered()) {
                    return next;
                }
                if (Build.VERSION.SDK_INT >= 18 && (next instanceof CellInfoWcdma) && next.isRegistered()) {
                    return next;
                }
            }
        }
        return null;
    }

    public static boolean O000000o(Context context) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) : Settings.System.getInt(contentResolver, "airplane_mode_on", 0)) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String O00000Oo(TelephonyManager telephonyManager) {
        String str;
        try {
            str = telephonyManager.getNetworkOperator();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6  */
    public static void O000000o(Context context, tz tzVar, CellLocation cellLocation, SignalStrength signalStrength, List<CellInfo> list) {
        T uhVar;
        ua uaVar;
        byte b;
        List<NeighboringCellInfo> list2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        byte O000000o2 = O000000o(telephonyManager);
        String O00000Oo = O00000Oo(telephonyManager);
        tzVar.f2521O000000o = O000000o2;
        tzVar.O00000Oo = O00000Oo;
        tzVar.O00000o0.clear();
        tzVar.O00000o.clear();
        if (cellLocation != null) {
            boolean z = cellLocation instanceof GsmCellLocation;
            if (z) {
                try {
                    list2 = telephonyManager.getNeighboringCellInfo();
                } catch (Throwable unused) {
                }
                if (!z) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    T ueVar = new ue();
                    ueVar.O00000o0 = gsmCellLocation.getLac();
                    ueVar.O00000o = gsmCellLocation.getCid();
                    if (Build.VERSION.SDK_INT >= 9) {
                        ueVar.O0000Oo0 = gsmCellLocation.getPsc();
                    }
                    if (signalStrength != null) {
                        int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                        ueVar.O00000oO = gsmSignalStrength == 99 ? Integer.MAX_VALUE : (gsmSignalStrength * 2) - 113;
                    }
                    ua uaVar2 = new ua();
                    uaVar2.f2523O000000o = 1;
                    uaVar2.O00000oo = ueVar;
                    uaVar2.O00000Oo = 1;
                    uaVar2.O00000o0 = 0;
                    tzVar.O00000o0.add(uaVar2);
                    if (list2 != null) {
                        for (NeighboringCellInfo neighboringCellInfo : list2) {
                            T ueVar2 = new ue();
                            ueVar2.O00000o0 = neighboringCellInfo.getLac();
                            ueVar2.O00000o = neighboringCellInfo.getCid();
                            ueVar2.O00000oO = neighboringCellInfo.getRssi();
                            ueVar2.O0000Oo0 = neighboringCellInfo.getPsc();
                            ua uaVar3 = new ua();
                            uaVar3.f2523O000000o = 1;
                            uaVar3.O00000oo = ueVar2;
                            uaVar3.O00000Oo = 0;
                            uaVar3.O00000o0 = 0;
                            tzVar.O00000o0.add(uaVar3);
                        }
                    }
                } else if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    T tyVar = new ty();
                    tyVar.O00000o = cdmaCellLocation.getBaseStationLatitude();
                    tyVar.O00000oO = cdmaCellLocation.getBaseStationLongitude();
                    tyVar.f2520O000000o = cdmaCellLocation.getSystemId();
                    tyVar.O00000Oo = cdmaCellLocation.getNetworkId();
                    tyVar.O00000o0 = cdmaCellLocation.getBaseStationId();
                    if (signalStrength != null) {
                        tyVar.O00000oo = signalStrength.getCdmaDbm();
                    }
                    ua uaVar4 = new ua();
                    uaVar4.f2523O000000o = 2;
                    uaVar4.O00000oo = tyVar;
                    uaVar4.O00000Oo = 1;
                    uaVar4.O00000o0 = 0;
                    tzVar.O00000o0.add(uaVar4);
                }
            }
            list2 = null;
            if (!z) {
            }
        }
        if (list != null && Build.VERSION.SDK_INT >= 17) {
            for (CellInfo next : list) {
                if (next instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) next;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    T tyVar2 = new ty();
                    tyVar2.O00000o = cellIdentity.getLatitude();
                    tyVar2.O00000oO = cellIdentity.getLongitude();
                    tyVar2.f2520O000000o = cellIdentity.getSystemId();
                    tyVar2.O00000Oo = cellIdentity.getNetworkId();
                    tyVar2.O00000o0 = cellIdentity.getBasestationId();
                    tyVar2.O00000oo = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    tyVar2.O0000O0o = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    uaVar = new ua();
                    uaVar.f2523O000000o = 2;
                    uaVar.O00000oo = tyVar2;
                } else {
                    if (next instanceof CellInfoGsm) {
                        CellInfoGsm cellInfoGsm = (CellInfoGsm) next;
                        CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                        uhVar = new ue();
                        uhVar.f2528O000000o = cellIdentity2.getMcc();
                        uhVar.O00000Oo = cellIdentity2.getMnc();
                        uhVar.O00000o0 = cellIdentity2.getLac();
                        uhVar.O00000o = cellIdentity2.getCid();
                        uhVar.O00000oO = cellInfoGsm.getCellSignalStrength().getDbm();
                        uhVar.O0000OOo = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                        if (Build.VERSION.SDK_INT >= 24) {
                            uhVar.O00000oo = cellIdentity2.getArfcn();
                            uhVar.O0000O0o = cellIdentity2.getBsic();
                        }
                        uaVar = new ua();
                        uaVar.f2523O000000o = 1;
                    } else {
                        if (next instanceof CellInfoLte) {
                            CellInfoLte cellInfoLte = (CellInfoLte) next;
                            CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                            uhVar = new uf();
                            uhVar.f2529O000000o = cellIdentity3.getMcc();
                            uhVar.O00000Oo = cellIdentity3.getMnc();
                            uhVar.O00000o0 = cellIdentity3.getTac();
                            uhVar.O00000o = cellIdentity3.getCi();
                            uhVar.O00000oO = cellIdentity3.getPci();
                            uhVar.O00000oo = cellInfoLte.getCellSignalStrength().getDbm();
                            uhVar.O0000OOo = cellInfoLte.getCellSignalStrength().getAsuLevel();
                            if (Build.VERSION.SDK_INT >= 24) {
                                uhVar.O0000O0o = cellIdentity3.getEarfcn();
                            }
                            uaVar = new ua();
                            b = 3;
                        } else if (Build.VERSION.SDK_INT >= 18 && (next instanceof CellInfoWcdma)) {
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) next;
                            CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                            uhVar = new uh();
                            uhVar.f2531O000000o = cellIdentity4.getMcc();
                            uhVar.O00000Oo = cellIdentity4.getMnc();
                            uhVar.O00000o0 = cellIdentity4.getLac();
                            uhVar.O00000o = cellIdentity4.getCid();
                            uhVar.O00000oO = cellIdentity4.getPsc();
                            uhVar.O00000oo = cellInfoWcdma.getCellSignalStrength().getDbm();
                            uhVar.O0000OOo = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                            if (Build.VERSION.SDK_INT >= 24) {
                                uhVar.O0000O0o = cellIdentity4.getUarfcn();
                            }
                            uaVar = new ua();
                            b = 4;
                        }
                        uaVar.f2523O000000o = b;
                    }
                    uaVar.O00000oo = uhVar;
                }
                uaVar.O00000Oo = next.isRegistered() ? (byte) 1 : 0;
                uaVar.O00000o0 = 1;
                tzVar.O00000o0.add(uaVar);
            }
        }
    }
}
