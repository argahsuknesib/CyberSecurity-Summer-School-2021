package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectHeadData implements SerializableEx {
    public List<EPGData> epgs = new ArrayList();
    public int ilike;
    public float iscore;
    public boolean liked;
    public String name;
    public String pic;
    public String resId;
    public short typeId;

    public static class EPGData implements SerializableEx {
        private static final long serialVersionUID = 1;
        public int cid;
        public String ct;
        public Date endTime;
        public Date startTime;
    }
}
