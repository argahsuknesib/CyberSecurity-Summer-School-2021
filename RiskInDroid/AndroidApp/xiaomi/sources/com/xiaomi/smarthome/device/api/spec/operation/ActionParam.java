package com.xiaomi.smarthome.device.api.spec.operation;

import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import java.util.ArrayList;
import java.util.List;

public class ActionParam extends SpecParam {
    private int aiid;

    /* renamed from: in  reason: collision with root package name */
    private List<Object> f7048in = new ArrayList();
    private List<Object> out = new ArrayList();

    @Deprecated
    public ActionParam() {
        super(null, 0);
    }

    @Deprecated
    public ActionParam(String str, int i, int i2, List<Object> list) {
        super(str, i);
        this.aiid = i2;
        this.f7048in = list;
    }

    public ActionParam(String str, int i, int i2, int i3, List<Object> list) {
        super(str, i, i2);
        this.aiid = i3;
        this.f7048in = list;
    }

    public ActionParam(String str, SpecAction specAction, List<Object> list) {
        super(str, Spec.getIid(specAction, 2), Spec.getIid(specAction, 1));
        this.aiid = Spec.getIid(specAction, 0);
        this.f7048in = list;
    }

    public int getAiid() {
        return this.aiid;
    }

    public void setAiid(int i) {
        this.aiid = i;
    }

    public List<Object> getIn() {
        return this.f7048in;
    }

    public void setIn(List<Object> list) {
        this.f7048in = list;
    }

    public List<Object> getOut() {
        return this.out;
    }

    public void setOut(List<Object> list) {
        this.out = list;
    }
}
