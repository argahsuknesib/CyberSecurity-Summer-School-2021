package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class BrandHuaWeiList implements SerializableEx {
    private static final long serialVersionUID = -9203932753583051221L;
    public List<Brand> brandList = new ArrayList();
    public int hotCount = 0;

    public static class Brand implements SerializableEx, Comparable {
        private static final long serialVersionUID = -8143386744144886047L;
        public int brandId;
        public String engName;
        public String initial;
        public String name;
        public String pinyin;
        public String simName;
        public String traName;

        public int compareTo(Object obj) {
            return this.initial.compareTo(((Brand) obj).initial);
        }
    }
}
