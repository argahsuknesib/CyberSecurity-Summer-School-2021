package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectVoteData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public boolean canViewResult;
    public Date ctime;
    public Date exp;
    public int id;
    public boolean isVoted;
    public List<VoteItem> items = new ArrayList();
    public short maxNum;
    public boolean multOption;
    public short status;
    public String title;
    public int totalVoteNum;
    public SimpleUser user;

    public static class VoteItem implements SerializableEx {
        private static final long serialVersionUID = 1;
        public int id;
        public String op;
        public int vn;
    }
}
