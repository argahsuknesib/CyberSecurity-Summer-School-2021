package com.xiaomi.smarthome.uwb.tv.remote;

import java.util.List;

public class TVInfo {
    public List<TVItem> medias;
    public List<TVItem> uc;

    public static class Extra {
        public int ci;
        public String date;
        public double moviepercent;
        public double percent;
        public long seconds;
        public String status_text;
    }

    public static class TVItem {
        public Extra extra;
        public int id;
        public int mediatype;
        public String poster;
        public int source;
        public String title;
    }
}
