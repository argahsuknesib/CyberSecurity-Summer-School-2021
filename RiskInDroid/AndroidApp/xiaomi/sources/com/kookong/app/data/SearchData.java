package com.kookong.app.data;

import com.kookong.app.data.PlayingTimeData;
import java.util.ArrayList;
import java.util.List;

public class SearchData implements SerializableEx {
    public List<PlayingTimeData.EPGData> epgs = new ArrayList();
    public int now = 0;
}
