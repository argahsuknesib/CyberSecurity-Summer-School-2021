package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayingProgramData implements SerializableEx {
    public Date nowTime;
    public List<PairPlayingProgram> pgs = new ArrayList();

    public static class PairPlayingProgram implements SerializableEx {
        public int cid;
        public String ctry = "";
        public int epi = 0;
        public short ishd;
        public String sn = "";
    }
}
