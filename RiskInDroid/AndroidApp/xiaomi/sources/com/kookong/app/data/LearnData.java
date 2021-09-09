package com.kookong.app.data;

import com.kookong.app.data.LineupData;
import java.util.List;

public class LearnData implements SerializableEx {
    private static final long serialVersionUID = -9111016058976337169L;
    public int areaId;
    public int lid;
    public List<LineupData.Chnnum> list;
    public int spId;
    public String spName;
    public short type;
}
