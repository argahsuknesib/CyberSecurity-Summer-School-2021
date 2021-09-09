package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramData implements SerializableEx {
    public Date nowTime;
    public List<PairProgram> pgs = new ArrayList();

    public static class PairProgram implements SerializableEx, Cloneable {
        public String cate;
        public Date cdate;
        public Date cedate;
        public int cid;
        public int cnum;
        public String ctry = "";
        public int ctype;
        public int epi = 0;
        public String flcate;
        public int ilike;
        public short ishd;
        public Date ndate;
        public Date nedate;
        public String nn = "";
        public String resId = "";
        public String sn = "";
        public String thumb = "";
        public short typeId;
        public int weight;
        public int wnum;

        public PairProgram shallowCopy() throws CloneNotSupportedException {
            return (PairProgram) super.clone();
        }
    }
}
