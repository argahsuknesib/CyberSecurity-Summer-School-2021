package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class SpGlobalList implements SerializableEx {
    public List<SpGlobal> spGlobalList = new ArrayList();

    public static class SpGlobal implements SerializableEx {
        public int spGlobalId;
        public String spGlobalName;
    }
}
