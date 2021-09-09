package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TvWallFavList implements SerializableEx {
    private static final long serialVersionUID = 7707347364159564801L;
    public TvWallFavChannelList channelDatas = null;
    public TvWallFavProgramList programDatas = null;

    public static class TvWallFavChannel implements SerializableEx {
        private static final long serialVersionUID = 2161262665459094383L;
        public Date bdate;
        public int cid;
        public String cname;
        public String ctry = "";
        public Date edate;
        public int epi;
        public short ishd;
        public String pic;
        public String pname;
        public String resId;
        public short typeId;
    }

    public static class TvWallFavChannelList implements SerializableEx {
        private static final long serialVersionUID = 3136307971027005307L;
        public short isEnd;
        public List<TvWallFavChannel> list = new ArrayList();
        public Date nowTime;
        public int start;
    }

    public static class TvWallFavProgramList implements SerializableEx {
        private static final long serialVersionUID = 4532045205998832040L;
        public short isEnd;
        public List<TvWallFavProgram> list = new ArrayList();
        public Date nowTime;
        public int start;
    }

    public static class TvWallFavProgram implements SerializableEx {
        private static final long serialVersionUID = -1118430140252340365L;
        public List<ChannelPlaying> list = new ArrayList();
        public String pic;
        public String pname;
        public String resId;
        public short typeId;

        public static class ChannelPlaying implements SerializableEx, Comparable<ChannelPlaying> {
            private static final long serialVersionUID = -3960892619818595714L;
            public Date bdate;
            public int cid;
            public String cname;
            public String ctry = "";
            public Date edate;
            public int epi;

            public int compareTo(ChannelPlaying channelPlaying) {
                return this.bdate.compareTo(channelPlaying.bdate);
            }
        }
    }
}
