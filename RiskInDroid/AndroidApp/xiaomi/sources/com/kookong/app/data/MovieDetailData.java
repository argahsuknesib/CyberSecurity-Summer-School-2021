package com.kookong.app.data;

import com.kookong.app.data.CharInfoData;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public List<String> acts = new ArrayList();
    public List<CharInfoData.CharInfo> chars = new ArrayList();
    public String country;
    public String desc;
    public List<String> dirs = new ArrayList();
    public String language;
    public String name = "";
    public String resId;
    public List<String> sws = new ArrayList();
    public short typeId;
    public short year;
}
