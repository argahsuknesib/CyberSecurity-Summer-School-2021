package com.kookong.app.data;

import com.kookong.app.data.CharInfoData;
import java.util.ArrayList;
import java.util.List;

public class DramaDetailData implements SerializableEx {
    private static final long serialVersionUID = 1;
    public List<String> acts = new ArrayList();
    public List<CharInfoData.CharInfo> chars = new ArrayList();
    public String desc;
    public String name = "";
    public String resId;
    public short typeId;
}
