package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class AreaList implements SerializableEx {
    private static final long serialVersionUID = -7514636551214699017L;
    public List<Area> areaList = new ArrayList();

    public static class Area implements SerializableEx {
        private static final long serialVersionUID = -3760233660749147900L;
        public int areaId;
        public String areaName;
        public List<Integer> remoteIds = new ArrayList();
    }
}
