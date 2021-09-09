package com.kookong.app.data;

import com.kookong.app.data.RecentWatchUserData;
import java.util.ArrayList;
import java.util.List;

public class TVShowNumberData implements SerializableEx {
    private static final long serialVersionUID = -4890275802133066340L;
    public int commentNum;
    public List<RecentWatchUserData.UserInfo> rwuList = new ArrayList();
    public int watchNum;
}
