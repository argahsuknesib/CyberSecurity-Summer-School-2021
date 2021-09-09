package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class RegionList implements SerializableEx {
    public List<Region> regionList = new ArrayList();

    public static class Region implements SerializableEx {
        public String regionCode;
        public String regionName;
        public List<SubRegion> subRegionList = new ArrayList();
    }

    public static class SubRegion implements SerializableEx {
        public String subRegionCode;
        public String subRegionName;
    }
}
