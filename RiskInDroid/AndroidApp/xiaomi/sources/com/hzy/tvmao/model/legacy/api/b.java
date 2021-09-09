package com.hzy.tvmao.model.legacy.api;

import com.hzy.tvmao.b.n;
import com.hzy.tvmao.model.db.bean.ChannelInfo;
import com.hzy.tvmao.model.legacy.api.data.EPGProgramData;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.app.data.PlayingTimeData;
import java.util.Collection;
import java.util.HashMap;

public class b {
    public static void a(Collection<PlayingTimeData.EPGData> collection, EPGProgramData ePGProgramData) {
        new HashMap();
        HashMap<ChannelInfo.a, ChannelInfo> d = n.c().d();
        ChannelInfo.a aVar = new ChannelInfo.a();
        LogUtil.d("Epgs size===" + collection.size());
        for (PlayingTimeData.EPGData next : collection) {
            if (next.cid > 0) {
                aVar.f4428a = next.cid;
                aVar.b = next.ct;
                for (int i = 0; i < 2; i++) {
                    aVar.c = i;
                    ChannelInfo channelInfo = d.get(aVar);
                    if (channelInfo != null) {
                        EPGProgramData.EPGData ePGData = new EPGProgramData.EPGData();
                        ePGData.cid = next.cid;
                        ePGData.ct = next.ct;
                        ePGData.cname = channelInfo.name;
                        ePGData.clogo = channelInfo.logo;
                        ePGData.cllogo = channelInfo.llogo;
                        ePGData.isHd = channelInfo.isHd;
                        ePGData.isFree = channelInfo.fee;
                        ePGData.pulse = channelInfo.pulse;
                        ePGData.cnum = channelInfo.num;
                        ePGData.tid = next.tid;
                        ePGData.rid = next.rid;
                        ePGData.n = next.n;
                        ePGData.d = next.d;
                        ePGData.t = next.t;
                        ePGData.startTime = next.startTime;
                        ePGData.endTime = next.endTime;
                        ePGData.thumb = next.thumb;
                        ePGProgramData.getEPGList().add(ePGData);
                    }
                }
            } else {
                EPGProgramData.EPGData ePGData2 = new EPGProgramData.EPGData();
                ePGData2.tid = next.tid;
                ePGData2.rid = next.rid;
                ePGData2.n = next.n;
                ePGData2.thumb = next.thumb;
                ePGProgramData.getEPGList().add(ePGData2);
            }
        }
    }
}
