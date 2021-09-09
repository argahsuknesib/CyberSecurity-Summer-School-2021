package com.hzy.tvmao.model.legacy.api.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public final class EPGProgramData implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<EPGData> epgList = new ArrayList<>();

    public static class EPGData implements Serializable {
        private static final long serialVersionUID = 1;
        public int cid;
        public String cllogo;
        public String clogo;
        public String cname;
        public int cnum;
        public String ct;
        public String d;
        public Date endTime;
        public short isFree;
        public short isHd;
        public String n;
        public String pulse;
        public String rid;
        public Date startTime;
        public String t;
        public String thumb;
        public short tid;
    }

    public final ArrayList<EPGData> getEPGList() {
        return this.epgList;
    }

    public final void setEpgList(ArrayList<EPGData> arrayList) {
        this.epgList = arrayList;
    }
}
