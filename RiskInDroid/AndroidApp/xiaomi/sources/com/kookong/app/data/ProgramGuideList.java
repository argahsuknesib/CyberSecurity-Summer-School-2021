package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramGuideList implements SerializableEx {
    private static final long serialVersionUID = -1313833530073934139L;
    public List<PairProgramGuide> pgs = new ArrayList();

    public static class PairProgramGuide implements SerializableEx {
        private static final long serialVersionUID = 5776972153550917325L;
        public String cate;
        public int cid;
        public Date edate;
        public int epi = 0;
        public short ishd;
        public String resId = "";
        public Date sdate;
        public String sn = "";
        public String thumb = "";
        public short typeId;
    }
}
