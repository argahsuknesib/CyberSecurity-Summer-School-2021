package com.tiqiaa.ircode;

import com.tiqiaa.remote.entity.AirRemoteState;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.Remote;
import java.util.List;

public interface IInfraredFetcher {
    void clearAirRemoteStatus(String str);

    List<Infrared> fetchAirInfrareds(Remote remote, Key key, AirRemoteState airRemoteState);

    List<Infrared> fetchAirTestInfrareds(Remote remote, Key key);

    List<Infrared> fetchInfrareds(Remote remote, Key key);

    List<Infrared> fetchNoAirInfrareds(Remote remote, Key key);

    AirRemoteState getAirRemoteStatus(Remote remote);
}
