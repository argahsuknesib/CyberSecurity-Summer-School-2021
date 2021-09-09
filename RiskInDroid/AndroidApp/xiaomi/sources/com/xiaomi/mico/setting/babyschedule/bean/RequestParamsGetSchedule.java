package com.xiaomi.mico.setting.babyschedule.bean;

import com.xiaomi.mico.common.util.GsonUtil;
import java.util.ArrayList;
import java.util.List;

public class RequestParamsGetSchedule {
    private List<Long> age = new ArrayList();
    private List<Long> content = new ArrayList();

    public RequestParamsGetSchedule(long j, long j2) {
        this.age.add(Long.valueOf(j));
        this.content.add(Long.valueOf(j2));
    }

    public String toRequestParams() {
        return GsonUtil.getGsonInstance().toJson(this);
    }
}
