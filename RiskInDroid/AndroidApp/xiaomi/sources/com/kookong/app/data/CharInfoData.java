package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class CharInfoData implements SerializableEx {
    private static final long serialVersionUID = 1;
    List<CharInfo> list = new ArrayList();

    public static class CharInfo implements SerializableEx {
        private static final long serialVersionUID = 1;
        public String an;
        public int cid;

        /* renamed from: cn  reason: collision with root package name */
        public String f4503cn;
        public String sid;
        public String t;
    }
}
