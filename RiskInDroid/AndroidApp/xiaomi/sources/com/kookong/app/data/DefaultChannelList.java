package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class DefaultChannelList implements SerializableEx {
    private static final long serialVersionUID = 6817780118420169169L;
    public List<DefaultChannel> list = new ArrayList();

    public static class DefaultChannel implements SerializableEx, Comparable {
        private static final long serialVersionUID = -2556000116916727680L;
        public int cid;
        public String ctrid = "";
        public short fee;
        public String fl;
        public String logo;
        public String name;
        public short type;

        public int compareTo(Object obj) {
            return this.fl.compareTo(((DefaultChannel) obj).fl);
        }
    }
}
