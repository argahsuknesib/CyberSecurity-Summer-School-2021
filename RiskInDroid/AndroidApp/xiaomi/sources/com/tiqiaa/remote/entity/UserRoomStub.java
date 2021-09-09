package com.tiqiaa.remote.entity;

import _m_j.bdk;
import com.tiqiaa.common.IJsonable;
import java.util.List;

public class UserRoomStub implements IJsonable {
    @bdk(O000000o = "rooms")
    List<Room> rooms;
    @bdk(O000000o = "user_id")
    long user_id;

    public long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(long j) {
        this.user_id = j;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> list) {
        this.rooms = list;
    }
}
