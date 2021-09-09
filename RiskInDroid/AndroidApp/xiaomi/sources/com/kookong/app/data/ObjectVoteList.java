package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectVoteList implements SerializableEx {
    private static final long serialVersionUID = 1;
    public List<SimpleVote> list = new ArrayList();

    public static class Item implements SerializableEx {
        public String option;
        public float percent;
    }

    public static class SimpleVote implements SerializableEx {
        public int commentNum;
        public String creator;
        public Date ctime;
        public int id;
        public Item[] items;
        public String title;
        public int totalVoteNum;
    }
}
