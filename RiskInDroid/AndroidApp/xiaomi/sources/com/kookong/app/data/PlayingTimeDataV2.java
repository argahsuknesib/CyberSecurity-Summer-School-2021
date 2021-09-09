package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayingTimeDataV2 implements SerializableEx {
    private static final long serialVersionUID = 1;
    public int now = 0;
    public String resId;
    public String thumb;
    public List<EPGDataV2> tvs = new ArrayList();
    public short typeId;

    public static class EPGDataV2 implements SerializableEx {
        private static final long serialVersionUID = 1;
        public int channelId;
        public String countryCode;
        public Date endTime;
        public String epgName;
        public int epi;
        public Date startTime;
    }
}
