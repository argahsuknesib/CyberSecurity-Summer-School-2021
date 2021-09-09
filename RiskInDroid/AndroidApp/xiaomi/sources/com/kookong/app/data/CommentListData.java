package com.kookong.app.data;

import java.util.Date;
import java.util.List;

public class CommentListData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public int commentTotal;
    public int lastPosition = 0;
    public List<CommentItemData> list;
    public int reviewTotal;

    public static class CommentItemData implements SerializableEx {
        private static final long serialVersionUID = 1;
        public int cid;
        public Date date;
        public String desc;
        public List<ReplyItemData> latestReplies;
        public String orgName;
        public int orgResId;
        public short orgTypeId;
        public int rnum;
        public int uid;
        public String uname;
        public short upic;
        public int upnum;
        public float uscore;
        public String uthumb;
    }
}
