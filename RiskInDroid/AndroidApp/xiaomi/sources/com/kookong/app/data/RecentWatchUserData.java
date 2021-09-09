package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class RecentWatchUserData implements SerializableEx {
    private static final long serialVersionUID = -3458304325037421309L;
    public List<UserInfo> userInfoList = new ArrayList();
    public int watchNum;

    public static class UserInfo implements SerializableEx {
        private static final long serialVersionUID = 4090450731298134895L;
        public int userId;
        public String userThumb;
    }
}
