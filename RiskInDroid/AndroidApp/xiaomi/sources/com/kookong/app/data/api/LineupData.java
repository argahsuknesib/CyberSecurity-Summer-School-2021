package com.kookong.app.data.api;

import com.kookong.app.data.SerializableEx;
import java.util.List;

public class LineupData implements SerializableEx {
    private static final long serialVersionUID = -6186826505005788396L;
    public int areaId;
    public int fre;
    public int lid;
    public List<Chnnum> list;
    public String mson;
    public int stbrid;
    public int tvrid;
    public int tvsId;
    public short type;

    public static class Chnnum implements SerializableEx {
        private static final long serialVersionUID = 6335634594583494015L;
        public int cid;
        public String ctrid;
        public short fee;
        public short hd;
        public short hidden;
        public String llogo;
        public String logo;
        public String name;
        public int num;
        public String pulse;
        public short type;
    }
}
