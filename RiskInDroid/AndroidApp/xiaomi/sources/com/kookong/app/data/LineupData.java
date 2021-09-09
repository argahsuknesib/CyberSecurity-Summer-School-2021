package com.kookong.app.data;

import java.util.List;

public class LineupData implements SerializableEx {
    private static final long serialVersionUID = 1643266612132998771L;
    public int areaId;
    public int lid;
    public List<Chnnum> list;
    public String mson;
    public int stbrid;
    public int tvrid;
    public int tvsId;
    public short type;

    public static class Chnnum implements SerializableEx {
        private static final long serialVersionUID = 2899980296377174067L;
        public int cid;
        public String ctrid;
        public short fee;
        public short hd;
        public short hidden;
        public String llogo;
        public String logo;
        public String name;
        public int num;
        public short type;
    }
}
