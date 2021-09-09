package com.tiqiaa.remote.entity;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bdk;
import _m_j.bdl;
import _m_j.box;
import _m_j.boy;
import _m_j.bpa;
import com.imi.fastjson.parser.Feature;
import com.tiqiaa.common.IJsonable;
import java.util.ArrayList;
import java.util.List;

@bpa(O000000o = "tb_room")
@bdl(O00000Oo = {"remote_ids", "remote_ids_json"})
public class Room implements IJsonable, Cloneable {
    @bdk(O000000o = "name")
    String name;
    @boy
    @box
    @bdk(O000000o = "no")

    /* renamed from: no  reason: collision with root package name */
    int f5889no;
    @bdk(O000000o = "remote_ids")
    List<String> remote_ids;
    @bdk(O000000o = "remote_ids_json")
    String remote_ids_json;
    @bdk(O000000o = "remotes")
    List<Remote> remotes;

    public int getNo() {
        return this.f5889no;
    }

    public void setNo(int i) {
        this.f5889no = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<String> getRemote_ids() {
        String str;
        if (this.remote_ids == null && (str = this.remote_ids_json) != null) {
            try {
                this.remote_ids = (List) bdf.O000000o(str, new bdi<List<String>>() {
                    /* class com.tiqiaa.remote.entity.Room.AnonymousClass1 */
                }, new Feature[0]);
            } catch (Exception unused) {
            }
        }
        return this.remote_ids;
    }

    public void setRemote_ids(List<String> list) {
        this.remote_ids = list;
    }

    public List<Remote> getRemotes() {
        return this.remotes;
    }

    public void setRemotes(List<Remote> list) {
        this.remotes = list;
    }

    public String getRemote_ids_json() {
        return this.remote_ids_json;
    }

    public void setRemote_ids_json(String str) {
        this.remote_ids_json = str;
    }

    public Room clone() {
        Room room = new Room();
        room.setName(this.name);
        room.setNo(this.f5889no);
        if (this.remotes != null) {
            ArrayList arrayList = new ArrayList();
            for (Remote add : this.remotes) {
                arrayList.add(add);
            }
            room.setRemotes(this.remotes);
        }
        return room;
    }
}
