package com.xiaomi.mico.infrared.bean;

import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import java.util.ArrayList;
import java.util.List;

public class SkillEntity {
    public String id;
    public List<Result> results;
    public int scope;
    public Trigger trigger;
    public String type;

    public SkillEntity() {
    }

    public SkillEntity(String str, List<String> list, String str2, long j, String str3, String str4) {
        this.id = str;
        this.type = "private";
        this.scope = 2;
        this.trigger = new Trigger(list);
        this.results = new ArrayList();
        this.results.add(new Result(str2, j, str3, str4));
    }

    public SkillEntity(List<String> list, String str, long j, String str2, String str3) {
        this.type = "private";
        this.scope = 2;
        this.trigger = new Trigger(list);
        this.results = new ArrayList();
        this.results.add(new Result(str, j, str2, str3));
    }

    class Trigger {
        public List<Item> items = new ArrayList();
        public String op = "or";

        public Trigger(List<String> list) {
            for (String item : list) {
                this.items.add(new Item(item));
            }
        }
    }

    class Item {
        public String type = "text";
        public String value;

        public Item(String str) {
            this.value = str;
        }
    }

    class Result {
        public String type;
        public String value;

        public Result(String str, String str2) {
            this.type = str;
            this.value = str2;
        }

        public Result(String str, long j, String str2, String str3) {
            this.type = "localexec";
            this.value = Remote.sGson.toJson(new LocalExec(str, j, str2, str3));
        }
    }

    class LocalExec {
        public String exectype = "infraredCode";
        public String execvalue;
        public Extra extra;

        public LocalExec(String str, long j, String str2, String str3) {
            this.execvalue = str;
            this.extra = new Extra(j, str2, str3);
        }
    }

    public static class Extra {
        public String deviceName;
        public long keyId;
        public String keyName;

        public Extra(long j, String str, String str2) {
            this.keyId = j;
            this.keyName = str;
            this.deviceName = str2;
        }
    }

    public Extra getExtra() {
        if (ContainerUtil.isEmpty(this.results)) {
            return null;
        }
        for (Result next : this.results) {
            if (next.type.equals("localexec")) {
                LocalExec localExec = (LocalExec) GsonUtil.getGsonInstance().fromJson(next.value, LocalExec.class);
                if (localExec != null && localExec.exectype.equals("infraredCode")) {
                    return localExec.extra;
                }
            }
        }
        return null;
    }

    public String getIrLocalExecValue() {
        if (ContainerUtil.isEmpty(this.results)) {
            return "";
        }
        for (Result next : this.results) {
            if (next.type.equals("localexec")) {
                LocalExec localExec = (LocalExec) GsonUtil.getGsonInstance().fromJson(next.value, LocalExec.class);
                if (localExec != null && localExec.exectype.equals("infraredCode")) {
                    return localExec.execvalue;
                }
            }
        }
        return "";
    }

    public List<String> getTriggerList() {
        ArrayList arrayList = new ArrayList();
        Trigger trigger2 = this.trigger;
        if (trigger2 != null && !ContainerUtil.isEmpty(trigger2.items)) {
            for (Item next : this.trigger.items) {
                if (next.type.equals("text")) {
                    arrayList.add(next.value);
                }
            }
        }
        return arrayList;
    }
}
