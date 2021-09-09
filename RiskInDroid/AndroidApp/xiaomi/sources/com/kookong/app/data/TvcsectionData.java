package com.kookong.app.data;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TvcsectionData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public List<String> cfgRoleNames;
    public Map<Integer, String> resultCfgMap;
    public Map<String, List<SimpleRole>> roleMapList = null;
    public int seasonId;
    public String secDesc;
    public Date secPlayDate;
    public String secTitle;
    public int sectionId;
    public int ssnum;
    public int stnum;
    public Map<String, List<SimpleRole>> topResults = null;
    public String tvcId;
    public short vflag = 0;

    public static class SimpleRole implements SerializableEx, Comparator<SimpleRole> {
        private static final long serialVersionUID = 1;
        public boolean isShowOrder = false;
        public String name;
        public int orderId;
        public String resaultTag = "";
        public int result = 0;
        public int roleId;
        public String thumb;

        public int compare(SimpleRole simpleRole, SimpleRole simpleRole2) {
            int i = simpleRole.result;
            int i2 = simpleRole2.result;
            if (i > 0 && i2 > 0) {
                return i - i2;
            }
            if (i == 0) {
                return 1;
            }
            return (i2 != 0 && i - i2 <= 0) ? 1 : -1;
        }
    }
}
