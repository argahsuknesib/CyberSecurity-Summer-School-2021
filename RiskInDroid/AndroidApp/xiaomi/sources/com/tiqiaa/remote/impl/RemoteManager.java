package com.tiqiaa.remote.impl;

import _m_j.bdf;
import com.tiqiaa.database.DataBaseManager;
import com.tiqiaa.remote.IRemoteManager;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.remote.entity.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoteManager implements IRemoteManager {
    public List<Room> getAllRooms() {
        return DataBaseManager.getInstance().getAllRooms();
    }

    public List<Remote> getRemoteFromRoom(Room room) {
        return DataBaseManager.getInstance().getAllRemotesInRoom(room);
    }

    public Remote getRemoteByID(String str) {
        return DataBaseManager.getInstance().getRemoteById(str);
    }

    public boolean addRemoteToRoom(Remote remote, Room room) {
        if (remote == null || room == null) {
            return false;
        }
        if (room.getRemote_ids() == null) {
            room.setRemote_ids(new ArrayList());
        }
        if (!room.getRemote_ids().contains(remote.getId())) {
            room.getRemote_ids().add(remote.getId());
            if (room.getRemotes() == null) {
                room.setRemotes(new ArrayList());
            }
            room.getRemotes().add(remote);
            room.setRemote_ids_json(bdf.O000000o(room.getRemote_ids()));
        }
        DataBaseManager.getInstance().saveOrUpdateRoom(room);
        DataBaseManager.getInstance().saveRemote(remote);
        return true;
    }

    public boolean addRemoteToRoom(String str, Room room) {
        Remote remoteByID;
        if (str == null || room == null || (remoteByID = getRemoteByID(str)) == null) {
            return false;
        }
        return addRemoteToRoom(remoteByID, room);
    }

    public boolean deleteRemoteFromRoom(Remote remote, Room room) {
        if (remote == null || room == null || room.getRemote_ids() == null) {
            return false;
        }
        if (!room.getRemote_ids().contains(remote.getId())) {
            return true;
        }
        room.getRemote_ids().remove(remote.getId());
        room.setRemote_ids_json(bdf.O000000o(room.getRemote_ids()));
        room.getRemotes().remove(remote);
        return DataBaseManager.getInstance().saveOrUpdateRoom(room);
    }

    public boolean deleteRemoteFromRoom(String str, Room room) {
        if (str == null || room == null || room.getRemote_ids() == null) {
            return false;
        }
        if (!room.getRemote_ids().contains(str)) {
            return true;
        }
        room.getRemote_ids().remove(str);
        room.setRemote_ids_json(bdf.O000000o(room.getRemote_ids()));
        Iterator<Remote> it = room.getRemotes().iterator();
        while (true) {
            if (it.hasNext()) {
                Remote next = it.next();
                if (next.getId().equals(str)) {
                    room.getRemotes().remove(next);
                    break;
                }
            } else {
                break;
            }
        }
        return DataBaseManager.getInstance().saveOrUpdateRoom(room);
    }

    public boolean deleteRemote(Remote remote) {
        return DataBaseManager.getInstance().deleteRemote(remote);
    }

    public boolean deleteRemote(String str) {
        return DataBaseManager.getInstance().deleteRemoteById(str);
    }

    public boolean addRemote(Remote remote) {
        if (remote == null) {
            return false;
        }
        return DataBaseManager.getInstance().saveRemote(remote);
    }

    public boolean changeRemoteName(Remote remote, String str) {
        if (remote == null || str == null || str.equals(remote.getName())) {
            return false;
        }
        remote.setName(str);
        return DataBaseManager.getInstance().saveOrUpdateRemote(remote);
    }

    public boolean addRoom(Room room) {
        if (room == null) {
            return false;
        }
        return DataBaseManager.getInstance().saveRoom(room);
    }

    public boolean deleteRoom(Room room) {
        if (room == null) {
            return false;
        }
        return DataBaseManager.getInstance().deleteRoom(room);
    }
}
