package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class RcTestRemoteKeyList implements SerializableEx {
    private static final long serialVersionUID = 5980246524182480984L;
    protected String allRemoteIds = "";
    protected int defaultRemoteId = 0;
    protected List<RcTestRemoteKey> remoteKeyList = new ArrayList();

    public int getDefaultRemoteId() {
        return this.defaultRemoteId;
    }

    public void setDefaultRemoteId(int i) {
        this.defaultRemoteId = i;
    }

    public List<RcTestRemoteKey> getRemoteKeyList() {
        return this.remoteKeyList;
    }

    public void setRemoteKeyList(List<RcTestRemoteKey> list) {
        this.remoteKeyList = list;
    }

    public String getAllRemoteIds() {
        return this.allRemoteIds;
    }

    public void setAllRemoteIds(String str) {
        this.allRemoteIds = str;
    }
}
