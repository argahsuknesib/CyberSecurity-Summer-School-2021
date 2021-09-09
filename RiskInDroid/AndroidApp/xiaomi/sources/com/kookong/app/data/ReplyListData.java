package com.kookong.app.data;

import java.util.List;

public class ReplyListData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public int lastPosition = 0;
    public List<ReplyItemData> list;
    public int total;
}
