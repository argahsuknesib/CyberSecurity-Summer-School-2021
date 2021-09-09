package com.kookong.app.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLoginData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public int city;
    public Date ctime;
    public String email;
    public List<ExternalInfo> extList = new ArrayList();
    public int id;
    public String name;
    public char sex;
    public short thumb;
    public String thumbSrc;

    public static class ExternalInfo implements SerializableEx {
        private static final long serialVersionUID = 1;
        public Date expire;
        public String openid;
        public String secret;
        public short source;
        public String token;
    }
}
