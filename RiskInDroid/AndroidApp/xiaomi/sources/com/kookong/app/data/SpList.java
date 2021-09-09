package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class SpList implements SerializableEx {
    private static final long serialVersionUID = 7173200763662743549L;
    public List<Sp> spList = new ArrayList();

    public static class Sp implements SerializableEx {
        private static final long serialVersionUID = -724649716496213680L;
        public int spId;
        public String spName;
        public short type;
    }
}
