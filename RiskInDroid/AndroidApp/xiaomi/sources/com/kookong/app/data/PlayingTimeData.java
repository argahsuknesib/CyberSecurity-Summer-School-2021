package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayingTimeData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public int now = 0;
    public List<EPGData> tvs = new ArrayList();

    public static class EPGData implements SerializableEx {
        private static final long serialVersionUID = 1;
        public int cid;
        public String ct;
        public String d;
        public Date endTime;
        public String n;
        public String rid;
        public Date startTime;
        public String t;
        public String thumb;
        public short tid;
    }
}
