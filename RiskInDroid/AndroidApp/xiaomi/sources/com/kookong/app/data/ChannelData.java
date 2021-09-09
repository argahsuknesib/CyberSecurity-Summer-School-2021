package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class ChannelData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public List<Channel> chn = new ArrayList();

    public static class Channel implements SerializableEx {
        private static final long serialVersionUID = 1;
        public String ctyId;
        public short fee;
        public int id;
        public String logo;
        public String name;
        public short type;
    }
}
