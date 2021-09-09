package com.hzy.tvmao.model.legacy.api;

import android.text.TextUtils;
import android.util.Log;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.model.legacy.api.data.ManualMatchData;
import com.kookong.app.data.BrandList;
import com.kookong.app.data.ChannelEpg;
import com.kookong.app.data.CountryList;
import com.kookong.app.data.IrData;
import com.kookong.app.data.IrDataList;
import com.kookong.app.data.LineupList;
import com.kookong.app.data.PlayingTimeData;
import com.kookong.app.data.PlayingTimeDataV2;
import com.kookong.app.data.ProgramData;
import com.kookong.app.data.ProgramDetailData;
import com.kookong.app.data.ProgramGuideList;
import com.kookong.app.data.RcTestRemoteKeyList;
import com.kookong.app.data.RcTestRemoteKeyListV3;
import com.kookong.app.data.RemoteList;
import com.kookong.app.data.SearchDataList;
import com.kookong.app.data.SpList;
import com.kookong.app.data.StbList;
import com.kookong.app.data.api.LineupData;
import java.util.HashMap;
import java.util.Locale;

public class i {
    public static n<ManualMatchData> a(int i, int i2, String str) {
        n<ManualMatchData> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("areaid", String.valueOf(i));
        hashMap.put("spid", String.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("mr", str);
        }
        try {
            nVar = o.a(a.be, hashMap, ManualMatchData.class);
        } catch (Exception e) {
            Log.e("manuallineup", "failed to get manualLineup ", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<ProgramGuideList> a(int i, int i2, String str, String str2) {
        n<ProgramGuideList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("cid", String.valueOf(i));
        hashMap.put("ctryId", "");
        hashMap.put("isHd", i2 + "'");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("stime", str + "'");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("etime", str2 + "'");
        }
        try {
            nVar = o.a(a.bb, hashMap, ProgramGuideList.class);
        } catch (Exception e) {
            Log.e("getChannelGuide", "failed to get drama counter data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<IrDataList> a(int i, int i2) {
        n<IrDataList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("brandid", String.valueOf(i));
        hashMap.put("devicetypeid", String.valueOf(i2));
        try {
            nVar = o.a(e.i, hashMap, IrDataList.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<IrDataList> a(String str, int i, String str2, boolean z, boolean z2) {
        n<IrDataList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("rids", str);
        hashMap.put("alg", String.valueOf(KookongSDK.getConfig().isRepeatCodeFormat() ? 3 : z ? 1 : 0));
        if (i != -1) {
            hashMap.put("deviceType", String.valueOf(i));
        }
        hashMap.put("mcode", str2);
        hashMap.put("ackey", String.valueOf(z2));
        try {
            nVar = o.a(e.f, hashMap, IrDataList.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<IrData> a(int i, int i2, boolean z) {
        n<IrData> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("rid", String.valueOf(i));
        hashMap.put("fid", String.valueOf(i2));
        if (z) {
            hashMap.put("alg", "1");
        }
        try {
            nVar = o.a(e.g, hashMap, IrData.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<RemoteList> b(int i, int i2, String str) {
        n<RemoteList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("functionid", String.valueOf(i));
        if (str != null) {
            hashMap.put("remoteids", str);
        }
        if (i2 != -1) {
            hashMap.put("remoteid", String.valueOf(i2));
        }
        try {
            nVar = o.a(e.h, hashMap, new j());
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<RcTestRemoteKeyListV3> a(String str, String str2, String str3, boolean z) {
        n<RcTestRemoteKeyListV3> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("encrypt", "0");
        hashMap.put("devicetypeid", str);
        hashMap.put("switch", str2);
        hashMap.put("mr", str3);
        if (z) {
            hashMap.put("alg", "1");
        }
        try {
            nVar = o.a(a.bd, hashMap, RcTestRemoteKeyListV3.class);
        } catch (Exception e) {
            Log.e("CommentListData", "failed to get comment list data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<RemoteList> a(int i, int i2, int i3, int i4, String str) {
        n<RemoteList> nVar;
        HashMap hashMap = new HashMap();
        if (i != 0) {
            hashMap.put("did", String.valueOf(i));
        }
        if (i2 != 0) {
            hashMap.put("bid", String.valueOf(i2));
        }
        if (i3 != 0) {
            hashMap.put("spId", String.valueOf(i3));
        }
        if (i4 != 0) {
            hashMap.put("areaId", String.valueOf(i4));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("countryCode", str);
        }
        try {
            nVar = o.a(e.d, hashMap, RemoteList.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<RemoteList> a(int i, int i2, int i3, int i4) {
        n<RemoteList> nVar;
        Log.d("listRemoteIdBySameKey", String.format(Locale.CHINA, "did=%d,rid=%d,fid=%d,brandId=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        HashMap hashMap = new HashMap();
        hashMap.put("did", String.valueOf(i));
        hashMap.put("rid", String.valueOf(i2));
        hashMap.put("fid", String.valueOf(i3));
        hashMap.put("brandid", String.valueOf(i4));
        try {
            nVar = o.a(e.e, hashMap, RemoteList.class);
        } catch (Exception e) {
            Log.e("listRemoteIdBySameKey", "failed to getRemoteIdListByFunctionKey", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<StbList> a(String str, int i) {
        n<StbList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("areaId", String.valueOf(i));
        try {
            nVar = o.a(e.p, hashMap, new k());
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<StbList> a(int i) {
        n<StbList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("spId", String.valueOf(i));
        try {
            nVar = o.a(e.p, hashMap, new l());
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<LineupList> b(int i, int i2) {
        n<LineupList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("areaId", String.valueOf(i));
        hashMap.put("spId", String.valueOf(i2));
        hashMap.put("exact", "1");
        try {
            nVar = o.a(e.n, hashMap, new m());
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<SpList> b(int i) {
        n<SpList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("areaId", String.valueOf(i));
        try {
            nVar = o.a(e.l, hashMap, SpList.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<Integer> a(String str, String str2, String str3) {
        n<Integer> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("p", str);
        hashMap.put("c", str2);
        hashMap.put("a", str3);
        try {
            nVar = o.a(e.k, hashMap, Integer.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<BrandList> a(String str, String str2) {
        n<BrandList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("deviceType", str);
        hashMap.put("countryCode", str2);
        try {
            nVar = o.a(e.b, hashMap, BrandList.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<PlayingTimeData> a(short s, String str, int i, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("resourceId", str);
        hashMap.put("typeId", String.valueOf((int) s));
        if (!z) {
            hashMap.put("chid", String.valueOf(i));
            hashMap.put("ctry", str2);
        }
        n<PlayingTimeData> nVar = null;
        try {
            nVar = o.a(a.P, hashMap, PlayingTimeData.class);
            if (nVar.e != null && ((PlayingTimeData) nVar.e).now > 0) {
                u.a(((PlayingTimeData) nVar.e).now);
            }
        } catch (Exception e) {
            Log.e("PlayingTimeDataV2", "failed to get drama playintime data,", e);
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<PlayingTimeDataV2> a(short s, String str) {
        n<PlayingTimeDataV2> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("resourceId", str);
        hashMap.put("typeId", String.valueOf((int) s));
        try {
            nVar = o.a(a.Q, hashMap, PlayingTimeDataV2.class);
        } catch (Exception e) {
            Log.e("PlayingTimeDataV2", "failed to get drama playintime data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<LineupData> c(int i, int i2) {
        n<LineupData> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("lid", String.valueOf(i2));
        hashMap.put("rid", String.valueOf(i));
        try {
            nVar = o.a(a.aN, hashMap, LineupData.class, false, true);
        } catch (Exception e) {
            Log.e("LineupData", "failed to get Lineup data list,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<ProgramDetailData> a(String str, short s) {
        HashMap hashMap = new HashMap();
        hashMap.put("resourceId", str);
        hashMap.put("typeId", String.valueOf((int) s));
        n<ProgramDetailData> nVar = null;
        try {
            nVar = o.a(a.aQ, hashMap, ProgramDetailData.class);
            if (nVar.a() && nVar.e != null) {
                ((ProgramDetailData) nVar.e).desc = p.a((CharSequence) ((ProgramDetailData) nVar.e).desc);
            }
        } catch (Exception e) {
            Log.e("getProgramDetail", "failed to get ProgramData data,", e);
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<ProgramData> b(String str, String str2, String str3) {
        int time;
        HashMap hashMap = new HashMap();
        hashMap.put("time", str2);
        hashMap.put("lid", str);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("cid", str3);
        }
        n<ProgramData> nVar = null;
        try {
            nVar = o.a(a.aO, hashMap, ProgramData.class, false, true);
            if (!(nVar.e == null || ((ProgramData) nVar.e).nowTime == null || (time = (int) (((ProgramData) nVar.e).nowTime.getTime() / 1000)) <= 0)) {
                u.a(time);
            }
        } catch (Exception e) {
            Log.e("ProgramData", "failed to get ProgramData data,", e);
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<ChannelEpg> a(int i, String str, int i2) {
        n<ChannelEpg> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("chid", String.valueOf(i));
        hashMap.put("ctry", str);
        if (i2 != 0) {
            hashMap.put("day", String.valueOf(i2));
        }
        try {
            nVar = o.a(a.G, hashMap, ChannelEpg.class, false, true);
        } catch (Exception e) {
            Log.e("ChannelEpg", "failed to get program list,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<SearchDataList> b(String str, String str2) {
        n<SearchDataList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("term", str);
        hashMap.put("cinfo", str2);
        try {
            nVar = o.a(a.az, hashMap, SearchDataList.class);
        } catch (Exception e) {
            e.printStackTrace();
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<RcTestRemoteKeyList> d(int i, int i2) {
        n<RcTestRemoteKeyList> nVar;
        HashMap hashMap = new HashMap();
        hashMap.put("brandid", String.valueOf(i));
        hashMap.put("devicetypeid", String.valueOf(i2));
        try {
            nVar = o.a(e.i, hashMap, RcTestRemoteKeyList.class);
        } catch (Exception e) {
            Log.e("getIRDataById", "failed to get home object data,", e);
            nVar = null;
        }
        return nVar == null ? n.b() : nVar;
    }

    public static n<CountryList> a() {
        n<CountryList> nVar = null;
        try {
            nVar = o.a(a.bc, null, CountryList.class);
        } catch (Exception e) {
            Log.e("initcustomer", "failed", e);
        }
        return nVar == null ? n.b() : nVar;
    }
}
