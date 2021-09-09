package com.tiqiaa.remote;

import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.remote.entity.Room;
import java.util.List;

public interface IRemoteManager {
    boolean addRemote(Remote remote);

    boolean addRemoteToRoom(Remote remote, Room room);

    boolean addRemoteToRoom(String str, Room room);

    boolean addRoom(Room room);

    boolean changeRemoteName(Remote remote, String str);

    boolean deleteRemote(Remote remote);

    boolean deleteRemote(String str);

    boolean deleteRemoteFromRoom(Remote remote, Room room);

    boolean deleteRemoteFromRoom(String str, Room room);

    boolean deleteRoom(Room room);

    List<Room> getAllRooms();

    Remote getRemoteByID(String str);

    List<Remote> getRemoteFromRoom(Room room);
}
