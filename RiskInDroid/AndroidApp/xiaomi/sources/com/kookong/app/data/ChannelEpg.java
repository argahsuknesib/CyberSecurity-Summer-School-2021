package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class ChannelEpg implements SerializableEx {
    public String date;
    public List<PG> epgList = new ArrayList();
    public boolean isfav;

    public static class PG implements SerializableEx {
        public String edate;
        public String etime;
        public String flcate;
        public String name;
        public String resId;
        public String time;
        public short typeId;
    }
}
