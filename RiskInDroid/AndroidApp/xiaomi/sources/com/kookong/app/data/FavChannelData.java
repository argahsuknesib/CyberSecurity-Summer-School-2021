package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class FavChannelData implements SerializableEx {
    public List<FavChannel> list = new ArrayList();
    public int total;

    public static class FavChannel implements SerializableEx {
        public int cid;
        public String ctry = "";
        public short ishd;
        public String logo;
        public String name;
    }
}
