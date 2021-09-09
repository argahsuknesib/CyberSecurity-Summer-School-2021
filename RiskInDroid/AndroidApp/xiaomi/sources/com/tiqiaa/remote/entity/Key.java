package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.bdl;
import _m_j.box;
import _m_j.boy;
import _m_j.bpa;
import com.tiqiaa.common.IJsonable;
import com.tiqiaa.icontrol.util.RemoteUtils;
import java.util.ArrayList;
import java.util.List;

@bpa(O000000o = "tb_key")
@bdl(O000000o = {"name", "type", "protocol", "infrareds"}, O00000Oo = {"id", "remote_id"})
public class Key implements IJsonable, Cloneable {
    @boy
    @box
    @bdk(O000000o = "id")
    long id;
    @bdk(O000000o = "infrareds")
    private List<Infrared> infrareds;
    @bdk(O000000o = "name")
    private String name;
    @bdk(O000000o = "positions")
    private List<KeyPosition> positions;
    @bdk(O000000o = "protocol")
    private int protocol;
    @bdk(O000000o = "remarks")
    String remarks;
    @bdk(O000000o = "remote_id")
    private String remoteId;
    @bdk(O000000o = "type")
    private int type;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getRemote_id() {
        return this.remoteId;
    }

    public void setRemote_id(String str) {
        this.remoteId = str;
    }

    public List<Infrared> getInfrareds() {
        return this.infrareds;
    }

    public void setInfrareds(List<Infrared> list) {
        this.infrareds = list;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public List<KeyPosition> getPositions() {
        return this.positions;
    }

    public void setPositions(List<KeyPosition> list) {
        this.positions = list;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public String getLocalName() {
        String str = this.name;
        if (str == null || str.equals("")) {
            return RemoteUtils.getLocalKeyName(this.type);
        }
        return this.name;
    }

    public Key clone() {
        Key key = new Key();
        List<Infrared> list = this.infrareds;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Infrared clone : this.infrareds) {
                arrayList.add(clone.clone());
            }
            key.setInfrareds(arrayList);
        }
        List<KeyPosition> list2 = this.positions;
        if (list2 != null && list2.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (KeyPosition clone2 : this.positions) {
                arrayList2.add(clone2.clone());
            }
            key.setPositions(arrayList2);
        }
        key.setId(this.id);
        key.setName(this.name);
        key.setProtocol(this.protocol);
        key.setType(this.type);
        key.setRemote_id(this.remoteId);
        key.setRemarks(this.remarks);
        return key;
    }
}
