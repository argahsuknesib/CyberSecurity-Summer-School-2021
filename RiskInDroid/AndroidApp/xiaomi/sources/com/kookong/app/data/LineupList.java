package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class LineupList implements SerializableEx {
    private static final long serialVersionUID = 6560772408929650683L;
    public List<Lineup> lineupList = new ArrayList();

    public static class Lineup implements SerializableEx {
        private static final long serialVersionUID = -6087367823268333086L;
        public int lid;
        public String lname;
    }
}
