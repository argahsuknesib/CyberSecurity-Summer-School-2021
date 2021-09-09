package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class BrandList implements SerializableEx {
    private static final long serialVersionUID = -6358065578704438419L;
    public List<Brand> brandList = new ArrayList();
    public int hotCount = 0;

    public static class Brand implements SerializableEx, Comparable {
        private static final long serialVersionUID = 6579767242005830344L;
        public int brandId;
        public String cname;
        public String ename;
        public String initial;
        public String pinyin;

        public int compareTo(Object obj) {
            return this.initial.compareTo(((Brand) obj).initial);
        }
    }
}
