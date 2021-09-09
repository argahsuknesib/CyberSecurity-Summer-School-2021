package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class FavObjectData implements SerializableEx {
    public List<FavObject> list = new ArrayList();
    public int total;

    public static class FavObject implements SerializableEx {
        public String cast;
        public int cnum;
        public String name;
        public int num;
        public String pic;
        public String resId;
        public short typeId;
    }
}
