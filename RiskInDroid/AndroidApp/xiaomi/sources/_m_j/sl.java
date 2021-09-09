package _m_j;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.OnNmeaMessageListener;
import android.os.Looper;
import java.util.List;

public interface sl {
    GpsStatus O000000o(GpsStatus gpsStatus);

    List<String> O000000o();

    void O000000o(LocationListener locationListener);

    void O000000o(String str, long j, float f, LocationListener locationListener, Looper looper);

    boolean O000000o(GnssStatus.Callback callback);

    @Deprecated
    boolean O000000o(GpsStatus.Listener listener);

    @Deprecated
    boolean O000000o(GpsStatus.NmeaListener nmeaListener);

    boolean O000000o(OnNmeaMessageListener onNmeaMessageListener);

    boolean O000000o(String str);

    void O00000Oo(GnssStatus.Callback callback);

    @Deprecated
    void O00000Oo(GpsStatus.Listener listener);

    @Deprecated
    void O00000Oo(GpsStatus.NmeaListener nmeaListener);

    void O00000Oo(OnNmeaMessageListener onNmeaMessageListener);
}
